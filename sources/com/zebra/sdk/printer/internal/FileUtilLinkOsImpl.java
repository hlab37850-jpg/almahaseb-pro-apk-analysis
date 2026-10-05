package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.MultichannelConnection;
import com.zebra.sdk.comm.TcpConnection;
import com.zebra.sdk.comm.internal.FTP;
import com.zebra.sdk.comm.internal.PrinterCommandImpl;
import com.zebra.sdk.device.FileUtilLinkOs;
import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.printer.SGD;
import com.zebra.sdk.printer.StorageInfo;
import com.zebra.sdk.printer.ZebraPrinterLinkOs;
import com.zebra.sdk.printer.operations.internal.FileStorer;
import com.zebra.sdk.printer.operations.internal.ObjectGrabberOperation;
import com.zebra.sdk.printer.operations.internal.StorageInfoGrabber;
import com.zebra.sdk.util.fileConversion.internal.DZ_UnwrapperStream;
import com.zebra.sdk.util.fileConversion.internal.HzoToDzConverterStream;
import com.zebra.sdk.util.fileConversion.internal.MPF_UnwrapperStream;
import com.zebra.sdk.util.internal.FileReader;
import com.zebra.sdk.util.internal.FileUtilities;
import com.zebra.sdk.util.internal.FileWrapper;
import com.zebra.sdk.util.internal.PrinterFileDescriptor;
import com.zebra.sdk.util.internal.PrinterFileMetadata;
import com.zebra.sdk.util.internal.StringUtilities;
import com.zebra.sdk.util.internal.XmlUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.IOUtils;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes3.dex */
public class FileUtilLinkOsImpl implements FileUtilLinkOs {
    private static final Set<String> validExtensionsToGetObjectFromPrinter = new HashSet(Arrays.asList("FNT", "ZPL", "GRF", "DAT", "BAS", "STO", "PNG", "LBL", "TTF", "PCX", "BMP", "IMG", "TTE", "WML", "CSV", "HTM", "BAE", "TXT"));
    private ZebraPrinterLinkOs zebraPrinterLinkOs;

    public FileUtilLinkOsImpl(ZebraPrinterLinkOs zebraPrinterLinkOs) {
        this.zebraPrinterLinkOs = zebraPrinterLinkOs;
    }

    private void copyInputStreamToOutputStream(InputStream inputStream, OutputStream outputStream) throws ZebraIllegalArgumentException, IOException {
        int i = inputStream.read();
        if (i == -1) {
            throw new ZebraIllegalArgumentException("Invalid extension or file not found");
        }
        while (i != -1) {
            outputStream.write(i);
            i = inputStream.read();
        }
    }

    private void getFileOverFtp(OutputStream outputStream, String str, String str2) throws ConnectionException {
        FTP ftp;
        Connection connection = this.zebraPrinterLinkOs.getConnection();
        if (!(connection instanceof TcpConnection)) {
            if (connection instanceof MultichannelConnection) {
                MultichannelConnection multichannelConnection = (MultichannelConnection) connection;
                if (multichannelConnection.getPrintingChannel() instanceof TcpConnection) {
                    ftp = new FTP(((TcpConnection) multichannelConnection.getPrintingChannel()).getAddress(), null, str2);
                }
            }
            throw new ConnectionException("Must be a TCP connected printer to tranfer files");
        }
        ftp = new FTP(((TcpConnection) connection).getAddress(), null, str2);
        ftp.getFile(outputStream, str);
    }

    private Node getObjectData(String str, ByteArrayInputStream byteArrayInputStream) {
        return XmlUtil.getDataAtNamedNode(byteArrayInputStream, "OBJECT-DATA", str);
    }

    private String parseHzo(String str, ByteArrayInputStream byteArrayInputStream) throws ZebraIllegalArgumentException {
        try {
            return XmlUtil.getTextContent(getObjectData(str, byteArrayInputStream), "");
        } catch (Exception e) {
            throw new ZebraIllegalArgumentException(e.getLocalizedMessage());
        }
    }

    private void retrieveFileViaFileTypeSgdCommand(OutputStream outputStream, String str) {
        PrinterCommandImpl printerCommandImpl = new PrinterCommandImpl("! U1 do \"file.type\" \"" + str + "\"" + StringUtilities.CRLF);
        Connection connection = this.zebraPrinterLinkOs.getConnection();
        printerCommandImpl.sendAndWaitForResponse(outputStream, connection, connection.getMaxTimeoutForRead(), connection.getTimeToWaitForMoreData(), null);
    }

    private boolean validExtension(String str) {
        return validExtensionsToGetObjectFromPrinter.contains(str.substring(str.lastIndexOf(46) + 1));
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public void deleteFile(String str) {
        SGD.SET("file.delete", str, this.zebraPrinterLinkOs.getConnection());
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public void getObjectFromPrinter(OutputStream outputStream, String str) throws Throwable {
        InputStream inputStream;
        HzoToDzConverterStream hzoToDzConverterStream;
        InputStream inputStreamExecute = new ObjectGrabberOperation(str, this.zebraPrinterLinkOs.getConnection(), this.zebraPrinterLinkOs.getPrinterControlLanguage(), this.zebraPrinterLinkOs.getLinkOsInformation()).execute();
        InputStream dZ_UnwrapperStream = null;
        try {
            if (inputStreamExecute instanceof MultipartFormReceiverStream) {
                dZ_UnwrapperStream = new MPF_UnwrapperStream(inputStreamExecute);
                hzoToDzConverterStream = null;
            } else {
                if (!FileWrapper.isHzoExtension(str.substring(str.lastIndexOf(46) + 1))) {
                    if (!validExtension(str)) {
                        throw new ZebraIllegalArgumentException("Invalid extension, cannot retrieve file type");
                    }
                    retrieveFileViaFileTypeSgdCommand(outputStream, str);
                    IOUtils.closeQuietly(inputStreamExecute);
                    IOUtils.closeQuietly((InputStream) null);
                    IOUtils.closeQuietly((InputStream) null);
                    return;
                }
                hzoToDzConverterStream = new HzoToDzConverterStream(inputStreamExecute);
                try {
                    dZ_UnwrapperStream = new DZ_UnwrapperStream(hzoToDzConverterStream);
                } catch (IOException e) {
                    e = e;
                    InputStream inputStream2 = dZ_UnwrapperStream;
                    dZ_UnwrapperStream = hzoToDzConverterStream;
                    inputStream = inputStream2;
                    try {
                        if (!e.getLocalizedMessage().equals("File not found")) {
                            throw new ConnectionException(e.getLocalizedMessage());
                        }
                        throw new ZebraIllegalArgumentException(e.getLocalizedMessage());
                    } catch (Throwable th) {
                        th = th;
                        IOUtils.closeQuietly(inputStreamExecute);
                        IOUtils.closeQuietly(dZ_UnwrapperStream);
                        IOUtils.closeQuietly(inputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    InputStream inputStream3 = dZ_UnwrapperStream;
                    dZ_UnwrapperStream = hzoToDzConverterStream;
                    inputStream = inputStream3;
                    IOUtils.closeQuietly(inputStreamExecute);
                    IOUtils.closeQuietly(dZ_UnwrapperStream);
                    IOUtils.closeQuietly(inputStream);
                    throw th;
                }
            }
            copyInputStreamToOutputStream(dZ_UnwrapperStream, outputStream);
            IOUtils.closeQuietly(inputStreamExecute);
            IOUtils.closeQuietly(hzoToDzConverterStream);
            IOUtils.closeQuietly(dZ_UnwrapperStream);
        } catch (IOException e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public void getObjectFromPrinterViaFtp(OutputStream outputStream, String str, String str2) throws ZebraIllegalArgumentException, ConnectionException {
        if (!validExtension(str)) {
            throw new ZebraIllegalArgumentException("Invalid extension, cannot retrieve file type");
        }
        getFileOverFtp(outputStream, str, str2);
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public byte[] getPrinterDownloadableObjectFromPrinter(String str) throws Throwable {
        if (!validExtension(str)) {
            throw new ZebraIllegalArgumentException("Invalid extension, cannot retrieve file type");
        }
        InputStream inputStreamExecute = new ObjectGrabberOperation(str, this.zebraPrinterLinkOs.getConnection(), this.zebraPrinterLinkOs.getPrinterControlLanguage(), this.zebraPrinterLinkOs.getLinkOsInformation()).execute();
        InputStream inputStream = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (!(inputStreamExecute instanceof MultipartFormReceiverStream)) {
                    if (!FileWrapper.isHzoExtension(str.substring(str.lastIndexOf(46) + 1))) {
                        byte[] bArrWrapFileWithCisdfHeader = FileWrapper.wrapFileWithCisdfHeader(retrieveFileViaFileTypeSgdCommand(str), str);
                        IOUtils.closeQuietly(inputStreamExecute);
                        IOUtils.closeQuietly((InputStream) null);
                        return bArrWrapFileWithCisdfHeader;
                    }
                    copyInputStreamToOutputStream(inputStreamExecute, byteArrayOutputStream);
                    byte[] bytes = parseHzo(str, new ByteArrayInputStream(byteArrayOutputStream.toByteArray())).getBytes();
                    IOUtils.closeQuietly(inputStreamExecute);
                    IOUtils.closeQuietly((InputStream) null);
                    return bytes;
                }
                InputStream mPF_UnwrapperStream = new MPF_UnwrapperStream(inputStreamExecute);
                try {
                    copyInputStreamToOutputStream(mPF_UnwrapperStream, byteArrayOutputStream);
                    byte[] bytes2 = FileWrapper.wrapFile(byteArrayOutputStream.toByteArray(), str, false, false).getBytes();
                    IOUtils.closeQuietly(inputStreamExecute);
                    IOUtils.closeQuietly(mPF_UnwrapperStream);
                    return bytes2;
                } catch (IOException e) {
                    e = e;
                    throw new ConnectionException(e.getLocalizedMessage());
                } catch (Throwable th) {
                    th = th;
                    inputStream = mPF_UnwrapperStream;
                    IOUtils.closeQuietly(inputStreamExecute);
                    IOUtils.closeQuietly(inputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public List<StorageInfo> getStorageInfo() {
        return new StorageInfoGrabber(this.zebraPrinterLinkOs.getConnection(), this.zebraPrinterLinkOs.getPrinterControlLanguage(), this.zebraPrinterLinkOs.getLinkOsInformation()).execute();
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public void storeFileOnPrinter(String str) throws ZebraIllegalArgumentException, ConnectionException {
        storeFileOnPrinter(str, FileUtilities.GetFileNameOnPrinter(str));
    }

    private byte[] retrieveFileViaFileTypeSgdCommand(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        retrieveFileViaFileTypeSgdCommand(byteArrayOutputStream, str);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public byte[] getObjectFromPrinter(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        getObjectFromPrinter(byteArrayOutputStream, str);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public byte[] getObjectFromPrinterViaFtp(String str, String str2) throws ZebraIllegalArgumentException, ConnectionException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        getObjectFromPrinterViaFtp(byteArrayOutputStream, str, str2);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public void storeFileOnPrinter(String str, String str2) throws ZebraIllegalArgumentException, ConnectionException {
        storeFileOnPrinter(FileReader.toByteArray(str), str2);
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public void storeFileOnPrinter(byte[] bArr, String str) throws ZebraIllegalArgumentException, ConnectionException {
        if (bArr == null) {
            throw new ZebraIllegalArgumentException("file not found.");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            PrinterFileMetadata printerFileMetadata = new PrinterFileMetadata(byteArrayInputStream);
            byteArrayInputStream.reset();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PrinterFileDescriptor(byteArrayInputStream, str, printerFileMetadata));
            new FileStorer(arrayList, this.zebraPrinterLinkOs.getConnection(), this.zebraPrinterLinkOs.getPrinterControlLanguage(), this.zebraPrinterLinkOs.getLinkOsInformation()).execute();
        } catch (IOException e) {
            throw new ZebraIllegalArgumentException(e.getLocalizedMessage());
        }
    }
}
