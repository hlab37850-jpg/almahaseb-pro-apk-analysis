package com.zebra.sdk.util.fileConversion.internal;

import com.zebra.sdk.util.internal.ZPLUtilities;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class DG_ToDyConverterStream extends InputStream {
    String fakeDyHeader;
    int readCounter = 0;
    private InputStream sourceStream;

    public DG_ToDyConverterStream(InputStream inputStream) throws IOException {
        this.fakeDyHeader = "";
        this.sourceStream = inputStream;
        if (inputStream == null) {
            throw new IOException("input stream is null");
        }
        String[] strArr = {"", "", ""};
        int i = 0;
        int i2 = 0;
        while (i != 3 && i2 != -1) {
            i2 = this.sourceStream.read();
            if (i2 == 44 || i2 == 31) {
                i++;
            } else {
                strArr[i] = strArr[i] + ((char) i2);
            }
        }
        if (i != 3) {
            throw new IOException("Invalid ~DG Header");
        }
        String strReplace = strArr[0].replace(ZPLUtilities.ZPL_INTERNAL_COMMAND_PREFIX + "DG", "~DY");
        strArr[0] = strReplace;
        strArr[0] = strReplace.replace("~DG", "~DY").trim();
        String str = strArr[0] + ",A,G," + strArr[1] + "," + strArr[2] + ",";
        this.fakeDyHeader = str;
        this.fakeDyHeader = ZPLUtilities.replaceAllWithInternalCharacters(str);
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.readCounter >= this.fakeDyHeader.length()) {
            return this.sourceStream.read();
        }
        String str = this.fakeDyHeader;
        int i = this.readCounter;
        this.readCounter = i + 1;
        return str.charAt(i);
    }
}
