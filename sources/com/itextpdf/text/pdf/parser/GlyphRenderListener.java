package com.itextpdf.text.pdf.parser;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class GlyphRenderListener implements RenderListener {
    private final RenderListener delegate;

    public GlyphRenderListener(RenderListener renderListener) {
        this.delegate = renderListener;
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void beginTextBlock() {
        this.delegate.beginTextBlock();
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void endTextBlock() {
        this.delegate.endTextBlock();
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void renderImage(ImageRenderInfo imageRenderInfo) {
        this.delegate.renderImage(imageRenderInfo);
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void renderText(TextRenderInfo textRenderInfo) {
        Iterator<TextRenderInfo> it = textRenderInfo.getCharacterRenderInfos().iterator();
        while (it.hasNext()) {
            this.delegate.renderText(it.next());
        }
    }
}
