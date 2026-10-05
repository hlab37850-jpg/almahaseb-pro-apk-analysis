package com.itextpdf.text.pdf.parser;

/* JADX INFO: loaded from: classes3.dex */
public interface RenderListener {
    void beginTextBlock();

    void endTextBlock();

    void renderImage(ImageRenderInfo imageRenderInfo);

    void renderText(TextRenderInfo textRenderInfo);
}
