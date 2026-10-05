package com.itextpdf.text.pdf.codec.wmf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Utilities;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class InputMeta {
    InputStream in;
    int length;

    public InputMeta(InputStream inputStream) {
        this.in = inputStream;
    }

    public int getLength() {
        return this.length;
    }

    public int readByte() {
        this.length++;
        return this.in.read() & 255;
    }

    public BaseColor readColor() {
        int i = readByte();
        int i2 = readByte();
        int i3 = readByte();
        readByte();
        return new BaseColor(i, i2, i3);
    }

    public int readInt() throws IOException {
        this.length += 4;
        int i = this.in.read();
        if (i < 0) {
            return 0;
        }
        return i + (this.in.read() << 8) + (this.in.read() << 16) + (this.in.read() << 24);
    }

    public int readShort() throws IOException {
        int word = readWord();
        return word > 32767 ? word - 65536 : word;
    }

    public int readWord() throws IOException {
        this.length += 2;
        int i = this.in.read();
        if (i < 0) {
            return 0;
        }
        return (i + (this.in.read() << 8)) & 65535;
    }

    public void skip(int i) {
        this.length += i;
        Utilities.skip(this.in, i);
    }
}
