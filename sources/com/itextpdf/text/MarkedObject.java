package com.itextpdf.text;

import java.util.Properties;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class MarkedObject implements Element {
    protected Element element;
    protected Properties markupAttributes;

    public MarkedObject() {
        this.markupAttributes = new Properties();
        this.element = null;
    }

    @Override // com.itextpdf.text.Element
    public java.util.List<Chunk> getChunks() {
        return this.element.getChunks();
    }

    public Properties getMarkupAttributes() {
        return this.markupAttributes;
    }

    @Override // com.itextpdf.text.Element
    public boolean isContent() {
        return true;
    }

    @Override // com.itextpdf.text.Element
    public boolean isNestable() {
        return true;
    }

    @Override // com.itextpdf.text.Element
    public boolean process(ElementListener elementListener) {
        try {
            return elementListener.add(this.element);
        } catch (DocumentException unused) {
            return false;
        }
    }

    public void setMarkupAttribute(String str, String str2) {
        this.markupAttributes.setProperty(str, str2);
    }

    @Override // com.itextpdf.text.Element
    public int type() {
        return 50;
    }

    public MarkedObject(Element element) {
        this.markupAttributes = new Properties();
        this.element = element;
    }
}
