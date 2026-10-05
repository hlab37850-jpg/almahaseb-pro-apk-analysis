package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
class EnumerateTTC extends TrueTypeFont {
    protected String[] names;

    public EnumerateTTC(String str) {
        this.fileName = str;
        this.rf = new RandomAccessFileOrArray(str);
        findNames();
    }

    public void findNames() {
        this.tables = new HashMap<>();
        try {
            if (!readStandardString(4).equals("ttcf")) {
                throw new DocumentException(MessageLocalization.getComposedMessage("1.is.not.a.valid.ttc.file", this.fileName));
            }
            this.rf.skipBytes(4);
            int i = this.rf.readInt();
            this.names = new String[i];
            int filePointer = (int) this.rf.getFilePointer();
            for (int i2 = 0; i2 < i; i2++) {
                this.tables.clear();
                this.rf.seek(filePointer);
                this.rf.skipBytes(i2 * 4);
                int i3 = this.rf.readInt();
                this.directoryOffset = i3;
                this.rf.seek(i3);
                if (this.rf.readInt() != 65536) {
                    throw new DocumentException(MessageLocalization.getComposedMessage("1.is.not.a.valid.ttf.file", this.fileName));
                }
                int unsignedShort = this.rf.readUnsignedShort();
                this.rf.skipBytes(6);
                for (int i4 = 0; i4 < unsignedShort; i4++) {
                    String standardString = readStandardString(4);
                    this.rf.skipBytes(4);
                    this.tables.put(standardString, new int[]{this.rf.readInt(), this.rf.readInt()});
                }
                this.names[i2] = getBaseFont();
            }
            RandomAccessFileOrArray randomAccessFileOrArray = this.rf;
            if (randomAccessFileOrArray != null) {
                randomAccessFileOrArray.close();
            }
        } catch (Throwable th) {
            RandomAccessFileOrArray randomAccessFileOrArray2 = this.rf;
            if (randomAccessFileOrArray2 != null) {
                randomAccessFileOrArray2.close();
            }
            throw th;
        }
    }

    public String[] getNames() {
        return this.names;
    }

    public EnumerateTTC(byte[] bArr) {
        this.fileName = "Byte array TTC";
        this.rf = new RandomAccessFileOrArray(bArr);
        findNames();
    }
}
