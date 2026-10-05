package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.device.FileUtil;
import com.zebra.sdk.device.ProgressMonitor;
import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.device.internal.NullProgressMonitor;
import com.zebra.sdk.printer.SGD;
import com.zebra.sdk.util.internal.FileUtilities;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FileUtilA implements FileUtil {
    private static final String EPOCH_FILE_DIR_KEYWORD = "DIR";
    private static final String LEGACY_FILE_DIR_KEYWORD = "Directory";
    protected Connection printerConnection;

    public FileUtilA(Connection connection) {
        this.printerConnection = connection;
    }

    public PrinterFilePropertiesList extractFilePropertiesFromDirResult(String str) throws ZebraIllegalArgumentException {
        if (str == null) {
            throw new ZebraIllegalArgumentException("No files found.");
        }
        PrinterFilePropertiesList printerFilePropertiesList = new PrinterFilePropertiesList();
        if (str.contains(EPOCH_FILE_DIR_KEYWORD)) {
            Matcher matcher = Pattern.compile("\\*\\s+([^\\s]+\\:)([^\\s]+)\\.([^\\s]+)\\s+(\\d+)", 8).matcher(str);
            while (matcher.find()) {
                printerFilePropertiesList.add(new PrinterFilePropertiesZpl(matcher.group(1), matcher.group(2), matcher.group(3), Long.parseLong(matcher.group(4))));
            }
        } else {
            if (!str.contains(LEGACY_FILE_DIR_KEYWORD)) {
                throw new ZebraIllegalArgumentException("No files found.");
            }
            Matcher matcher2 = Pattern.compile("\\s+([^\\s]+)\\s+\\.([^\\s]+)\\s+(\\d+)", 8).matcher(str);
            while (matcher2.find()) {
                printerFilePropertiesList.add(new PrinterFilePropertiesZpl("", matcher2.group(1), matcher2.group(2), Long.parseLong(matcher2.group(3))));
            }
        }
        return printerFilePropertiesList;
    }

    public ZebraFileConnection getFileConnection(String str) {
        return new ZebraFileConnectionImpl(str);
    }

    @Override // com.zebra.sdk.device.FileUtil
    public abstract String[] retrieveFileNames();

    @Override // com.zebra.sdk.device.FileUtil
    public abstract String[] retrieveFileNames(String[] strArr);

    public PrinterFilePropertiesList retrieveFilePropertiesFromPrinter() {
        return extractFilePropertiesFromDirResult(SGD.DO("file.dir", "", this.printerConnection));
    }

    @Override // com.zebra.sdk.device.FileUtil
    public void sendFileContents(String str) {
        sendFileContents(str, new NullProgressMonitor());
    }

    @Override // com.zebra.sdk.device.FileUtil
    public void sendFileContents(String str, ProgressMonitor progressMonitor) {
        ZebraFileConnection fileConnection = getFileConnection(str);
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                inputStreamOpenInputStream = ((ZebraFileConnectionImpl) fileConnection).openInputStream();
                FileUtilities.sendFileContentsInChunks(this.printerConnection, progressMonitor, inputStreamOpenInputStream, fileConnection.fileSize());
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused) {
                    }
                }
            } catch (Throwable th) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            throw new ConnectionException(e.getMessage());
        }
    }
}
