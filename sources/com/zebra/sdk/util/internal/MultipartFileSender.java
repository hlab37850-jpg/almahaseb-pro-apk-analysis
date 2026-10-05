package com.zebra.sdk.util.internal;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.printer.PrinterObjectProperties;
import com.zebra.sdk.printer.internal.PrinterFilePropertiesZpl;
import com.zebra.sdk.settings.internal.JsonValidator;
import defpackage.C4412yu;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.InputStreamBody;

/* JADX INFO: loaded from: classes3.dex */
public class MultipartFileSender {
    private Connection connection;
    private List<PrinterFileDescriptor> fileDescriptors;

    public class PrinterOutputStream extends OutputStream {
        private Connection connection;

        public PrinterOutputStream(Connection connection) {
            this.connection = connection;
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            throw new IOException("Unsupported Operation");
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            write(bArr, 0, bArr.length);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                this.connection.write(bArr, i, i2);
            } catch (ConnectionException e) {
                throw new IOException(e.getLocalizedMessage());
            }
        }
    }

    public MultipartFileSender(Connection connection, List<PrinterFileDescriptor> list) {
        this.connection = connection;
        this.fileDescriptors = list;
    }

    private HttpEntity buildEntity() {
        MultipartEntityBuilder multipartEntityBuilderCreate = MultipartEntityBuilder.create();
        multipartEntityBuilderCreate.setMode(HttpMultipartMode.STRICT);
        for (PrinterFileDescriptor printerFileDescriptor : this.fileDescriptors) {
            multipartEntityBuilderCreate.addPart("files", new InputStreamBody(printerFileDescriptor.getSourceStream(), printerFileDescriptor.getName()));
        }
        return multipartEntityBuilderCreate.build();
    }

    public static List<PrinterObjectProperties> getPrinterObjectPropertiesFromJsonData(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        if (bArr != null && bArr.length > 0) {
            try {
                for (MpfPrinterResponse mpfPrinterResponse : (List) JacksonObjectMapperFactory.getInstance().readValue(bArr, new TypeReference() { // from class: com.zebra.sdk.util.internal.MultipartFileSender.1
                })) {
                    PrinterFilePath driveAndExtension = FileUtilities.parseDriveAndExtension(mpfPrinterResponse.getFilename());
                    arrayList.add(new PrinterFilePropertiesZpl(driveAndExtension.getDrive() + ":", driveAndExtension.getFileName(), driveAndExtension.getExtension().substring(1), mpfPrinterResponse.getSize(), mpfPrinterResponse.getCrc32()));
                }
            } catch (C4412yu | JsonMappingException | ZebraIllegalArgumentException | IOException unused) {
            }
        }
        return arrayList;
    }

    private List<PrinterObjectProperties> getPrinterResponse() {
        return getPrinterObjectPropertiesFromJsonData(this.connection.sendAndWaitForValidResponse(StringUtilities.CRLF.getBytes(), this.connection.getMaxTimeoutForRead(), this.connection.getTimeToWaitForMoreData(), new JsonValidator()));
    }

    public static PrinterObjectProperties send(Connection connection, PrinterFileDescriptor printerFileDescriptor) throws ConnectionException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(printerFileDescriptor);
        List<PrinterObjectProperties> listSend = send(connection, arrayList);
        if (listSend.size() >= 1) {
            return listSend.get(0);
        }
        throw new ConnectionException("No printer response to MPF storage request");
    }

    private void sendToPrinter(HttpEntity httpEntity) throws ConnectionException {
        try {
            PrinterOutputStream printerOutputStream = new PrinterOutputStream(this.connection);
            printerOutputStream.write("{}".getBytes());
            httpEntity.writeTo(printerOutputStream);
            printerOutputStream.flush();
        } catch (IOException e) {
            throw new ConnectionException(e.getLocalizedMessage());
        }
    }

    private List<PrinterObjectProperties> send() throws ConnectionException {
        List<PrinterFileDescriptor> list = this.fileDescriptors;
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("No files to send");
        }
        sendToPrinter(buildEntity());
        return getPrinterResponse();
    }

    public static List<PrinterObjectProperties> send(Connection connection, List<PrinterFileDescriptor> list) {
        return new MultipartFileSender(connection, list).send();
    }
}
