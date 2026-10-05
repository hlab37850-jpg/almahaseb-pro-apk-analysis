package com.itextpdf.text.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.Rectangle;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PdfBody extends Rectangle implements Element {
    public PdfBody(Rectangle rectangle) {
        super(rectangle);
    }

    @Override // com.itextpdf.text.Rectangle, com.itextpdf.text.Element
    public List<Chunk> getChunks() {
        return null;
    }

    @Override // com.itextpdf.text.Rectangle, com.itextpdf.text.Element
    public boolean isContent() {
        return false;
    }

    @Override // com.itextpdf.text.Rectangle, com.itextpdf.text.Element
    public boolean isNestable() {
        return false;
    }

    @Override // com.itextpdf.text.Rectangle, com.itextpdf.text.Element
    public boolean process(ElementListener elementListener) {
        return false;
    }

    @Override // com.itextpdf.text.Rectangle, com.itextpdf.text.Element
    public int type() {
        return 38;
    }
}
