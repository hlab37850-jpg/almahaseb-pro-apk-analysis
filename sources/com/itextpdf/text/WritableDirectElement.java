package com.itextpdf.text;

import com.itextpdf.text.api.WriterOperation;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class WritableDirectElement implements Element, WriterOperation {
    public static final int DIRECT_ELEMENT_TYPE_HEADER = 1;
    public static final int DIRECT_ELEMENT_TYPE_UNKNOWN = 0;
    protected int directElementType;

    public WritableDirectElement() {
        this.directElementType = 0;
    }

    @Override // com.itextpdf.text.Element
    public java.util.List<Chunk> getChunks() {
        return new ArrayList(0);
    }

    public int getDirectElementType() {
        return this.directElementType;
    }

    @Override // com.itextpdf.text.Element
    public boolean isContent() {
        return false;
    }

    @Override // com.itextpdf.text.Element
    public boolean isNestable() {
        throw new UnsupportedOperationException();
    }

    @Override // com.itextpdf.text.Element
    public boolean process(ElementListener elementListener) {
        throw new UnsupportedOperationException();
    }

    @Override // com.itextpdf.text.Element
    public int type() {
        return Element.WRITABLE_DIRECT;
    }

    public WritableDirectElement(int i) {
        this.directElementType = i;
    }
}
