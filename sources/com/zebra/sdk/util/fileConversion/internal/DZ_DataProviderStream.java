package com.zebra.sdk.util.fileConversion.internal;

import com.zebra.sdk.util.internal.ZPLUtilities;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class DZ_DataProviderStream extends InputStream {
    InputStream sourceStream;
    String[] headerParts = {"", ""};
    int[] preReaderDataHeader = new int[5];
    int preReaderDataHeaderIndex = 0;
    private DataFormatSpecifier dataFormatSpecifier = DataFormatSpecifier.OTHER;

    public DZ_DataProviderStream(InputStream inputStream) throws IOException {
        int i = 0;
        this.sourceStream = inputStream;
        int i2 = 0;
        int i3 = 0;
        while (i2 != 2 && i3 != -1) {
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
        if (i2 != 2) {
            throw new IOException("Invalid ~DZ Header");
        }
        String[] strArr2 = this.headerParts;
        strArr2[0] = strArr2[0].replace(ZPLUtilities.ZPL_INTERNAL_COMMAND_PREFIX, "~").replace("~DZ", "").trim();
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
        if (isMimeUncompressed()) {
            dataFormatSpecifier = DataFormatSpecifier.MIME_UNCOMPRESSED;
        } else {
            dataFormatSpecifier = isMimeCompressed() ? DataFormatSpecifier.MIME_COMPRESSED : DataFormatSpecifier.RAW_BINARY;
        }
        this.dataFormatSpecifier = dataFormatSpecifier;
    }

    public DataFormatSpecifier getDataFormatSpecifier() {
        return this.dataFormatSpecifier;
    }

    public String getFilenameOnPrinter() {
        return this.headerParts[0];
    }

    public InputStream getSourceStream() {
        return this.sourceStream;
    }

    public int getTotalBytesInData() throws IOException {
        int i = -1;
        try {
            if (!this.headerParts[1].isEmpty()) {
                i = Integer.parseInt(this.headerParts[1]);
            }
        } catch (NumberFormatException unused) {
        }
        if (i >= 0) {
            return i;
        }
        throw new IOException("Invalid ~DZ Header");
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
