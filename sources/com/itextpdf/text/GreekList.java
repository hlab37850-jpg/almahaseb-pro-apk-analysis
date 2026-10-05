package com.itextpdf.text;

import com.itextpdf.text.factories.GreekAlphabetFactory;

/* JADX INFO: loaded from: classes3.dex */
public class GreekList extends List {
    public GreekList() {
        super(true);
        setGreekFont();
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
        chunk.append(GreekAlphabetFactory.getString(this.first + this.list.size(), this.lowercase));
        chunk.append(this.postSymbol);
        listItem.setListSymbol(chunk);
        listItem.setIndentationLeft(this.symbolIndent, this.autoindent);
        listItem.setIndentationRight(0.0f);
        this.list.add(listItem);
        return false;
    }

    @Override // com.itextpdf.text.List
    public List cloneShallow() {
        GreekList greekList = new GreekList();
        populateProperties(greekList);
        return greekList;
    }

    public void setGreekFont() {
        this.symbol.setFont(FontFactory.getFont("Symbol", this.symbol.getFont().getSize(), 0));
    }

    public GreekList(int i) {
        super(true, i);
        setGreekFont();
    }

    public GreekList(boolean z, int i) {
        super(true, i);
        this.lowercase = z;
        setGreekFont();
    }
}
