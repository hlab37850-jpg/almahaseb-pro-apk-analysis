package com.itextpdf.text;

/* JADX INFO: loaded from: classes3.dex */
public class ZapfDingbatsList extends List {
    protected int zn;

    public ZapfDingbatsList(int i) {
        super(true);
        this.zn = i;
        this.symbol.setFont(FontFactory.getFont("ZapfDingbats", this.symbol.getFont().getSize(), 0));
        this.postSymbol = " ";
    }

    @Override // com.itextpdf.text.List, com.itextpdf.text.TextElementArray
    public boolean add(Element element) {
        if (!(element instanceof ListItem)) {
            if (!(element instanceof List)) {
                return false;
            }
            List list = (List) element;
            list.setIndentationLeft(list.getIndentationLeft() + this.symbolIndent);
            this.first--;
            return this.list.add(list);
        }
        ListItem listItem = (ListItem) element;
        Chunk chunk = new Chunk(this.preSymbol, this.symbol.getFont());
        chunk.setAttributes(this.symbol.getAttributes());
        chunk.append(String.valueOf((char) this.zn));
        chunk.append(this.postSymbol);
        listItem.setListSymbol(chunk);
        listItem.setIndentationLeft(this.symbolIndent, this.autoindent);
        listItem.setIndentationRight(0.0f);
        this.list.add(listItem);
        return false;
    }

    @Override // com.itextpdf.text.List
    public List cloneShallow() {
        ZapfDingbatsList zapfDingbatsList = new ZapfDingbatsList(this.zn);
        populateProperties(zapfDingbatsList);
        return zapfDingbatsList;
    }

    public int getCharNumber() {
        return this.zn;
    }

    public void setCharNumber(int i) {
        this.zn = i;
    }

    public void setDingbatColor(BaseColor baseColor) {
        this.symbol.setFont(FontFactory.getFont("ZapfDingbats", this.symbol.getFont().getSize(), 0, baseColor));
    }

    public ZapfDingbatsList(int i, int i2) {
        super(true, i2);
        this.zn = i;
        this.symbol.setFont(FontFactory.getFont("ZapfDingbats", this.symbol.getFont().getSize(), 0));
        this.postSymbol = " ";
    }

    public ZapfDingbatsList(int i, int i2, BaseColor baseColor) {
        super(true, i2);
        this.zn = i;
        this.symbol.setFont(FontFactory.getFont("ZapfDingbats", this.symbol.getFont().getSize(), 0, baseColor));
        this.postSymbol = " ";
    }
}
