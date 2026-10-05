package com.itextpdf.text;

import com.itextpdf.text.pdf.PdfName;

/* JADX INFO: loaded from: classes3.dex */
public class ListItem extends Paragraph {
    private static final long serialVersionUID = 1970670787169329006L;
    private ListBody listBody;
    private ListLabel listLabel;
    protected Chunk symbol;

    public ListItem() {
        this.listBody = null;
        this.listLabel = null;
        setRole(PdfName.LI);
    }

    public void adjustListSymbolFont() {
        Chunk chunk;
        java.util.List<Chunk> chunks = getChunks();
        if (chunks.isEmpty() || (chunk = this.symbol) == null) {
            return;
        }
        chunk.setFont(chunks.get(0).getFont());
    }

    @Override // com.itextpdf.text.Paragraph
    public Paragraph cloneShallow(boolean z) {
        ListItem listItem = new ListItem();
        populateProperties(listItem, z);
        return listItem;
    }

    public ListBody getListBody() {
        if (this.listBody == null) {
            this.listBody = new ListBody(this);
        }
        return this.listBody;
    }

    public ListLabel getListLabel() {
        if (this.listLabel == null) {
            this.listLabel = new ListLabel(this);
        }
        return this.listLabel;
    }

    public Chunk getListSymbol() {
        return this.symbol;
    }

    public void setIndentationLeft(float f, boolean z) {
        if (z) {
            setIndentationLeft(getListSymbol().getWidthPoint());
        } else {
            setIndentationLeft(f);
        }
    }

    public void setListSymbol(Chunk chunk) {
        if (this.symbol == null) {
            this.symbol = chunk;
            if (chunk.getFont().isStandardFont()) {
                this.symbol.setFont(this.font);
            }
        }
    }

    @Override // com.itextpdf.text.Paragraph, com.itextpdf.text.Phrase, com.itextpdf.text.Element
    public int type() {
        return 15;
    }

    public ListItem(float f) {
        super(f);
        this.listBody = null;
        this.listLabel = null;
        setRole(PdfName.LI);
    }

    public ListItem(Chunk chunk) {
        super(chunk);
        this.listBody = null;
        this.listLabel = null;
        setRole(PdfName.LI);
    }

    public ListItem(String str) {
        super(str);
        this.listBody = null;
        this.listLabel = null;
        setRole(PdfName.LI);
    }

    public ListItem(String str, Font font) {
        super(str, font);
        this.listBody = null;
        this.listLabel = null;
        setRole(PdfName.LI);
    }

    public ListItem(float f, Chunk chunk) {
        super(f, chunk);
        this.listBody = null;
        this.listLabel = null;
        setRole(PdfName.LI);
    }

    public ListItem(float f, String str) {
        super(f, str);
        this.listBody = null;
        this.listLabel = null;
        setRole(PdfName.LI);
    }

    public ListItem(float f, String str, Font font) {
        super(f, str, font);
        this.listBody = null;
        this.listLabel = null;
        setRole(PdfName.LI);
    }

    public ListItem(Phrase phrase) {
        super(phrase);
        this.listBody = null;
        this.listLabel = null;
        setRole(PdfName.LI);
    }
}
