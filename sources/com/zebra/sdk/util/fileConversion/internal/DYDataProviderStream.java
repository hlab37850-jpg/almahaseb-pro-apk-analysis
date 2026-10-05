package com.zebra.sdk.util.fileConversion.internal;

import com.zebra.sdk.util.internal.ZPLUtilities;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class DYDataProviderStream extends InputStream {
    InputStream sourceStream;
    String[] headerParts = {"", "", "", "", ""};
    int[] preReaderDataHeader = new int[5];
    int preReaderDataHeaderIndex = 0;
    private DataFormatSpecifier dataFormatSpecifier = DataFormatSpecifier.OTHER;

    public DYDataProviderStream(InputStream inputStream) throws IOException {
        int i = 0;
        this.sourceStream = inputStream;
        int i2 = 0;
        int i3 = 0;
        while (i2 != 5 && i3 != -1) {
            i3 = this.sourceStream.read();
            if (i3 == 44 || i3 == 31) {
                i2++;
            } else {
                StringBuilder sb = new StringBuilder();
                String[] strArr = this.headerParts;
                sb.append(strArr[i2]);
                sb.append((char) i3);
                strArr[i2] = sb.toString();
            }
        }
        if (i2 != 5) {
            throw new IOException("Invalid ~DY Header");
        }
        String[] strArr2 = this.headerParts;
        strArr2[0] = strArr2[0].replace(ZPLUtilities.ZPL_INTERNAL_COMMAND_PREFIX + "DY", "");
        String[] strArr3 = this.headerParts;
        strArr3[0] = strArr3[0].replace("~DY", "").trim();
        checkAndAdjustFileNameAndExtensionCode();
        adjustDataFormatSpecifier();
        while (true) {
            int[] iArr = this.preReaderDataHeader;
            if (i >= iArr.length) {
                break;
            }
            iArr[i] = inputStream.read();
            i++;
        }
        setDataFormatSpecifier();
        if (isDataMimed()) {
            ignorePrereadData();
        }
    }

    private void adjustDataFormatSpecifier() {
        if (Arrays.asList("B", "E", "T", "NRD", "PAC").contains(this.headerParts[2].toUpperCase())) {
            this.headerParts[1] = "B";
        }
    }

    private void checkAndAdjustFileNameAndExtensionCode() {
        HashMap map = new HashMap();
        map.put("BMP", "B");
        map.put("TTE", "E");
        String upperCase = "G";
        map.put("GRF", "G");
        map.put("PNG", "P");
        map.put("TTF", "T");
        map.put("PCX", "X");
        map.put("NRD", "NRD");
        map.put("PAC", "PAC");
        List listAsList = Arrays.asList("B", "E", "G", "P", "T", "X", "NRD", "PAC");
        String[] strArrSplit = this.headerParts[0].split("\\.");
        if (listAsList.contains(this.headerParts[2].toUpperCase())) {
            upperCase = this.headerParts[2].toUpperCase();
        } else if (2 == strArrSplit.length && strArrSplit[1].length() > 0 && map.containsKey(strArrSplit[1].toUpperCase())) {
            upperCase = (String) map.get(strArrSplit[1].toUpperCase());
        }
        this.headerParts[2] = upperCase;
        for (Map.Entry entry : map.entrySet()) {
            if (((String) entry.getValue()).equals(upperCase)) {
                this.headerParts[0] = strArrSplit[0] + "." + ((String) entry.getKey());
            }
        }
    }

    private void ignorePrereadData() {
        this.preReaderDataHeaderIndex = this.preReaderDataHeader.length;
    }

    private boolean isDataMimed() {
        DataFormatSpecifier dataFormatSpecifier = this.dataFormatSpecifier;
        return dataFormatSpecifier == DataFormatSpecifier.MIME_COMPRESSED || dataFormatSpecifier == DataFormatSpecifier.MIME_UNCOMPRESSED;
    }

    private boolean isMimeCompressed() {
        int[] iArr = this.preReaderDataHeader;
        return new String(iArr, 0, iArr.length).equalsIgnoreCase(":Z64:");
    }

    private boolean isMimeUncompressed() {
        int[] iArr = this.preReaderDataHeader;
        return new String(iArr, 0, iArr.length).equalsIgnoreCase(":B64:");
    }

    private void setDataFormatSpecifier() {
        DataFormatSpecifier dataFormatSpecifier;
        if (getFormatDownloadedInDataField().equalsIgnoreCase("B")) {
            dataFormatSpecifier = DataFormatSpecifier.RAW_BINARY;
        } else if (isMimeUncompressed()) {
            dataFormatSpecifier = DataFormatSpecifier.MIME_UNCOMPRESSED;
        } else {
            dataFormatSpecifier = isMimeCompressed() ? DataFormatSpecifier.MIME_COMPRESSED : DataFormatSpecifier.ASCII_HEX;
        }
        this.dataFormatSpecifier = dataFormatSpecifier;
    }

    public int getBytesPerRow() throws IOException {
        int i = -1;
        if (this.headerParts[4].isEmpty()) {
            return -1;
        }
        try {
            i = Integer.parseInt(this.headerParts[4]);
        } catch (NumberFormatException unused) {
        }
        if (i >= 0) {
            return i;
        }
        throw new IOException("Invalid ~DY Header");
    }

    public DataFormatSpecifier getDataFormatSpecifier() {
        return this.dataFormatSpecifier;
    }

    public String getFileExtensionCode() {
        return this.headerParts[2];
    }

    public String getFilenameOnPrinter() {
        return this.headerParts[0];
    }

    public String getFormatDownloadedInDataField() {
        return this.headerParts[1];
    }

    public InputStream getSourceStream() {
        return this.sourceStream;
    }

    public int getTotalBytesInData() throws IOException {
        int i = -1;
        try {
            if (!this.headerParts[3].isEmpty()) {
                i = Integer.parseInt(this.headerParts[3]);
            }
        } catch (NumberFormatException unused) {
        }
        if (i >= 0) {
            return i;
        }
        throw new IOException("Invalid ~DY Header");
    }

    @Override // java.io.InputStream
    public int read() {
        int i = this.preReaderDataHeaderIndex;
        int[] iArr = this.preReaderDataHeader;
        if (i >= iArr.length) {
            return this.sourceStream.read();
        }
        this.preReaderDataHeaderIndex = i + 1;
        return iArr[i];
    }
}
