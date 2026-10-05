package com.itextpdf.text;

import com.itextpdf.text.pdf.OutputStreamCounter;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Properties;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DocWriter implements DocListener {
    public static final byte EQUALS = 61;
    public static final byte FORWARD = 47;
    public static final byte GT = 62;
    public static final byte LT = 60;
    public static final byte NEWLINE = 10;
    public static final byte QUOTE = 34;
    public static final byte SPACE = 32;
    public static final byte TAB = 9;
    protected Document document;
    protected OutputStreamCounter os;
    protected Rectangle pageSize;
    protected boolean open = false;
    protected boolean pause = false;
    protected boolean closeStream = true;

    public DocWriter() {
    }

    public static final byte[] getISOBytes(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    @Override // com.itextpdf.text.ElementListener
    public boolean add(Element element) {
        return false;
    }

    public void addTabs(int i) throws IOException {
        this.os.write(10);
        for (int i2 = 0; i2 < i; i2++) {
            this.os.write(9);
        }
    }

    @Override // com.itextpdf.text.DocListener
    public void close() {
        this.open = false;
        try {
            this.os.flush();
            if (this.closeStream) {
                this.os.close();
            }
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public void flush() {
        try {
            this.os.flush();
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean isCloseStream() {
        return this.closeStream;
    }

    public boolean isPaused() {
        return this.pause;
    }

    @Override // com.itextpdf.text.DocListener
    public boolean newPage() {
        return this.open;
    }

    @Override // com.itextpdf.text.DocListener
    public void open() {
        this.open = true;
    }

    public void pause() {
        this.pause = true;
    }

    @Override // com.itextpdf.text.DocListener
    public void resetPageCount() {
    }

    public void resume() {
        this.pause = false;
    }

    public void setCloseStream(boolean z) {
        this.closeStream = z;
    }

    @Override // com.itextpdf.text.DocListener
    public boolean setMarginMirroring(boolean z) {
        return false;
    }

    @Override // com.itextpdf.text.DocListener
    public boolean setMarginMirroringTopBottom(boolean z) {
        return false;
    }

    @Override // com.itextpdf.text.DocListener
    public boolean setMargins(float f, float f2, float f3, float f4) {
        return false;
    }

    @Override // com.itextpdf.text.DocListener
    public void setPageCount(int i) {
    }

    @Override // com.itextpdf.text.DocListener
    public boolean setPageSize(Rectangle rectangle) {
        this.pageSize = rectangle;
        return true;
    }

    public void write(String str) throws IOException {
        this.os.write(getISOBytes(str));
    }

    public void writeEnd(String str) throws IOException {
        this.os.write(60);
        this.os.write(47);
        write(str);
        this.os.write(62);
    }

    public boolean writeMarkupAttributes(Properties properties) throws IOException {
        if (properties == null) {
            return false;
        }
        Iterator it = properties.keySet().iterator();
        while (it.hasNext()) {
            String strValueOf = String.valueOf(it.next());
            write(strValueOf, properties.getProperty(strValueOf));
        }
        properties.clear();
        return true;
    }

    public void writeStart(String str) throws IOException {
        this.os.write(60);
        write(str);
    }

    public void write(String str, String str2) throws IOException {
        this.os.write(32);
        write(str);
        this.os.write(61);
        this.os.write(34);
        write(str2);
        this.os.write(34);
    }

    public DocWriter(Document document, OutputStream outputStream) {
        this.document = document;
        this.os = new OutputStreamCounter(new BufferedOutputStream(outputStream));
    }

    public void writeEnd() throws IOException {
        this.os.write(32);
        this.os.write(47);
        this.os.write(62);
    }
}
