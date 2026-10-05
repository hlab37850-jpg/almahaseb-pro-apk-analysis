package com.itextpdf.text;

import com.itextpdf.text.api.Indentable;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class MarkedSection extends MarkedObject implements Indentable {
    protected MarkedObject title;

    public MarkedSection(Section section) {
        this.title = null;
        Paragraph paragraph = section.title;
        if (paragraph != null) {
            this.title = new MarkedObject(paragraph);
            section.setTitle(null);
        }
        this.element = section;
    }

    public void add(int i, Element element) {
        ((Section) this.element).add(i, element);
    }

    public boolean addAll(Collection<? extends Element> collection) {
        return ((Section) this.element).addAll(collection);
    }

    public MarkedSection addSection(float f, int i) {
        MarkedSection markedSectionAddMarkedSection = ((Section) this.element).addMarkedSection();
        markedSectionAddMarkedSection.setIndentation(f);
        markedSectionAddMarkedSection.setNumberDepth(i);
        return markedSectionAddMarkedSection;
    }

    @Override // com.itextpdf.text.api.Indentable
    public float getIndentationLeft() {
        return ((Section) this.element).getIndentationLeft();
    }

    @Override // com.itextpdf.text.api.Indentable
    public float getIndentationRight() {
        return ((Section) this.element).getIndentationRight();
    }

    public MarkedObject getTitle() {
        Paragraph paragraph = (Paragraph) this.title.element;
        Element element = this.element;
        MarkedObject markedObject = new MarkedObject(Section.constructTitle(paragraph, ((Section) element).numbers, ((Section) element).numberDepth, ((Section) element).numberStyle));
        markedObject.markupAttributes = this.title.markupAttributes;
        return markedObject;
    }

    public void newPage() {
        ((Section) this.element).newPage();
    }

    @Override // com.itextpdf.text.MarkedObject, com.itextpdf.text.Element
    public boolean process(ElementListener elementListener) {
        try {
            Iterator<Element> it = ((Section) this.element).iterator();
            while (it.hasNext()) {
                elementListener.add(it.next());
            }
            return true;
        } catch (DocumentException unused) {
            return false;
        }
    }

    public void setBookmarkOpen(boolean z) {
        ((Section) this.element).setBookmarkOpen(z);
    }

    public void setBookmarkTitle(String str) {
        ((Section) this.element).setBookmarkTitle(str);
    }

    public void setIndentation(float f) {
        ((Section) this.element).setIndentation(f);
    }

    @Override // com.itextpdf.text.api.Indentable
    public void setIndentationLeft(float f) {
        ((Section) this.element).setIndentationLeft(f);
    }

    @Override // com.itextpdf.text.api.Indentable
    public void setIndentationRight(float f) {
        ((Section) this.element).setIndentationRight(f);
    }

    public void setNumberDepth(int i) {
        ((Section) this.element).setNumberDepth(i);
    }

    public void setTitle(MarkedObject markedObject) {
        if (markedObject.element instanceof Paragraph) {
            this.title = markedObject;
        }
    }

    public void setTriggerNewPage(boolean z) {
        ((Section) this.element).setTriggerNewPage(z);
    }

    public boolean add(Element element) {
        return ((Section) this.element).add(element);
    }

    public MarkedSection addSection(float f) {
        MarkedSection markedSectionAddMarkedSection = ((Section) this.element).addMarkedSection();
        markedSectionAddMarkedSection.setIndentation(f);
        return markedSectionAddMarkedSection;
    }

    public MarkedSection addSection(int i) {
        MarkedSection markedSectionAddMarkedSection = ((Section) this.element).addMarkedSection();
        markedSectionAddMarkedSection.setNumberDepth(i);
        return markedSectionAddMarkedSection;
    }

    public MarkedSection addSection() {
        return ((Section) this.element).addMarkedSection();
    }
}
