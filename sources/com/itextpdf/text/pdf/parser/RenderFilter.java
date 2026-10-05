package com.itextpdf.text.pdf.parser;

/* JADX INFO: loaded from: classes3.dex */
public abstract class RenderFilter {
    public boolean allowImage(ImageRenderInfo imageRenderInfo) {
        return true;
    }

    public boolean allowText(TextRenderInfo textRenderInfo) {
        return true;
    }
}
