package com.itextpdf.text.pdf.codec.wmf;

/* JADX INFO: loaded from: classes3.dex */
public class MetaObject {
    public static final int META_BRUSH = 2;
    public static final int META_FONT = 3;
    public static final int META_NOT_SUPPORTED = 0;
    public static final int META_PEN = 1;
    public int type;

    public MetaObject() {
        this.type = 0;
    }

    public int getType() {
        return this.type;
    }

    public MetaObject(int i) {
        this.type = i;
    }
}
