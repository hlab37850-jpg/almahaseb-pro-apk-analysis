package com.itextpdf.tool.xml.html.pdfelement;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.api.Indentable;

/* JADX INFO: loaded from: classes3.dex */
public class NoNewLineParagraph extends Phrase implements Indentable {
    private static final long serialVersionUID = -8392940968188620772L;
    protected int alignment;
    private float extraParagraphSpace;
    private float firstLineIndent;
    protected float indentationLeft;
    protected float indentationRight;
    protected boolean keeptogether;
    protected float spacingAfter;
    protected float spacingBefore;

    public NoNewLineParagraph() {
        this.alignment = -1;
        this.firstLineIndent = 0.0f;
        this.extraParagraphSpace = 0.0f;
        this.keeptogether = false;
    }

    public int getAlignment() {
        return this.alignment;
    }

    public float getExtraParagraphSpace() {
        return this.extraParagraphSpace;
    }

    public float getFirstLineIndent() {
        return this.firstLineIndent;
    }

    @Override // com.itextpdf.text.api.Indentable
    public float getIndentationLeft() {
        return this.indentationLeft;
    }

    @Override // com.itextpdf.text.api.Indentable
    public float getIndentationRight() {
        return this.indentationRight;
    }

    public boolean getKeepTogether() {
        return this.keeptogether;
    }

    public float getSpacingAfter() {
        return this.spacingAfter;
    }

    public float getSpacingBefore() {
        return this.spacingBefore;
    }

    public void setAlignment(int i) {
        this.alignment = i;
    }

    public void setExtraParagraphSpace(float f) {
        this.extraParagraphSpace = f;
    }

    public void setFirstLineIndent(float f) {
        this.firstLineIndent = f;
    }

    @Override // com.itextpdf.text.api.Indentable
    public void setIndentationLeft(float f) {
        this.indentationLeft = f;
    }

    @Override // com.itextpdf.text.api.Indentable
    public void setIndentationRight(float f) {
        this.indentationRight = f;
    }

    public void setKeepTogether(boolean z) {
        this.keeptogether = z;
    }

    public void setSpacingAfter(float f) {
        this.spacingAfter = f;
    }

    public void setSpacingBefore(float f) {
        this.spacingBefore = f;
    }

    @Deprecated
    public float spacingAfter() {
        return this.spacingAfter;
    }

    @Deprecated
    public float spacingBefore() {
        return getSpacingBefore();
    }

    @Override // com.itextpdf.text.Phrase, java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Element element) {
        if (element instanceof List) {
            List list = (List) element;
            list.setIndentationLeft(list.getIndentationLeft() + this.indentationLeft);
            list.setIndentationRight(this.indentationRight);
            return super.add((Element) list);
        }
        if (!(element instanceof Image)) {
            return super.add(element);
        }
        super.addSpecial(element);
        return true;
    }

    public NoNewLineParagraph(float f) {
        super(f);
        this.alignment = -1;
        this.firstLineIndent = 0.0f;
        this.extraParagraphSpace = 0.0f;
        this.keeptogether = false;
    }

    public NoNewLineParagraph(Chunk chunk) {
        super(chunk);
        this.alignment = -1;
        this.firstLineIndent = 0.0f;
        this.extraParagraphSpace = 0.0f;
        this.keeptogether = false;
    }

    public NoNewLineParagraph(float f, Chunk chunk) {
        super(f, chunk);
        this.alignment = -1;
        this.firstLineIndent = 0.0f;
        this.extraParagraphSpace = 0.0f;
        this.keeptogether = false;
    }

    public NoNewLineParagraph(String str) {
        super(str);
        this.alignment = -1;
        this.firstLineIndent = 0.0f;
        this.extraParagraphSpace = 0.0f;
        this.keeptogether = false;
    }

    public NoNewLineParagraph(String str, Font font) {
        super(str, font);
        this.alignment = -1;
        this.firstLineIndent = 0.0f;
        this.extraParagraphSpace = 0.0f;
        this.keeptogether = false;
    }

    public NoNewLineParagraph(float f, String str) {
        super(f, str);
        this.alignment = -1;
        this.firstLineIndent = 0.0f;
        this.extraParagraphSpace = 0.0f;
        this.keeptogether = false;
    }

    public NoNewLineParagraph(float f, String str, Font font) {
        super(f, str, font);
        this.alignment = -1;
        this.firstLineIndent = 0.0f;
        this.extraParagraphSpace = 0.0f;
        this.keeptogether = false;
    }

    public NoNewLineParagraph(Phrase phrase) {
        super(phrase);
        this.alignment = -1;
        this.firstLineIndent = 0.0f;
        this.extraParagraphSpace = 0.0f;
        this.keeptogether = false;
        if (phrase instanceof NoNewLineParagraph) {
            NoNewLineParagraph noNewLineParagraph = (NoNewLineParagraph) phrase;
            this.alignment = noNewLineParagraph.getAlignment();
            this.indentationLeft = noNewLineParagraph.getIndentationLeft();
            this.indentationRight = noNewLineParagraph.getIndentationRight();
            this.firstLineIndent = noNewLineParagraph.getFirstLineIndent();
            this.spacingAfter = noNewLineParagraph.getSpacingAfter();
            this.spacingBefore = noNewLineParagraph.getSpacingBefore();
            this.extraParagraphSpace = noNewLineParagraph.getExtraParagraphSpace();
        }
        if (phrase instanceof Paragraph) {
            Paragraph paragraph = (Paragraph) phrase;
            setAlignment(paragraph.getAlignment());
            setIndentationLeft(paragraph.getIndentationLeft());
            setIndentationRight(paragraph.getIndentationRight());
            setFirstLineIndent(paragraph.getFirstLineIndent());
            setSpacingAfter(paragraph.getSpacingAfter());
            setSpacingBefore(paragraph.getSpacingBefore());
            setExtraParagraphSpace(paragraph.getExtraParagraphSpace());
        }
    }
}
