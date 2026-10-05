package com.itextpdf.text;

import com.itextpdf.text.factories.RomanNumberFactory;

/* JADX INFO: loaded from: classes3.dex */
public class RomanList extends List {
    public RomanList() {
        super(true);
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
        chunk.append(RomanNumberFactory.getString(this.first + this.list.size(), this.lowercase));
        chunk.append(this.postSymbol);
        listItem.setListSymbol(chunk);
        listItem.setIndentationLeft(this.symbolIndent, this.autoindent);
        listItem.setIndentationRight(0.0f);
        this.list.add(listItem);
        return false;
    }

    @Override // com.itextpdf.text.List
    public List cloneShallow() {
        RomanList romanList = new RomanList();
        populateProperties(romanList);
        return romanList;
    }

    public RomanList(int i) {
        super(true, i);
    }

    public RomanList(boolean z, int i) {
        super(true, i);
        this.lowercase = z;
    }
}
