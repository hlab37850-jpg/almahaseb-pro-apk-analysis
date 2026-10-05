package com.itextpdf.text;

import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes3.dex */
public class ZapfDingbatsNumberList extends List {
    protected int type;

    public ZapfDingbatsNumberList(int i) {
        super(true);
        this.type = i;
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
        int i = this.type;
        if (i == 0) {
            chunk.append(String.valueOf((char) (this.first + this.list.size() + ShapeTypes.ACTION_BUTTON_SOUND)));
        } else if (i == 1) {
            chunk.append(String.valueOf((char) (this.first + this.list.size() + ShapeTypes.MATH_NOT_EQUAL)));
        } else if (i != 2) {
            chunk.append(String.valueOf((char) (this.first + this.list.size() + 201)));
        } else {
            chunk.append(String.valueOf((char) (this.first + this.list.size() + 191)));
        }
        chunk.append(this.postSymbol);
        listItem.setListSymbol(chunk);
        listItem.setIndentationLeft(this.symbolIndent, this.autoindent);
        listItem.setIndentationRight(0.0f);
        this.list.add(listItem);
        return false;
    }

    @Override // com.itextpdf.text.List
    public List cloneShallow() {
        ZapfDingbatsNumberList zapfDingbatsNumberList = new ZapfDingbatsNumberList(this.type);
        populateProperties(zapfDingbatsNumberList);
        return zapfDingbatsNumberList;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public ZapfDingbatsNumberList(int i, int i2) {
        super(true, i2);
        this.type = i;
        this.symbol.setFont(FontFactory.getFont("ZapfDingbats", this.symbol.getFont().getSize(), 0));
        this.postSymbol = " ";
    }
}
