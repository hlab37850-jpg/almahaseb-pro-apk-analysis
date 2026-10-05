package com.itextpdf.text;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class Chapter extends Section {
    private static final long serialVersionUID = 1791000695779357361L;

    public Chapter(int i) {
        super(null, 1);
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.numbers = arrayList;
        arrayList.add(Integer.valueOf(i));
        this.triggerNewPage = true;
    }

    @Override // com.itextpdf.text.Section, com.itextpdf.text.Element
    public boolean isNestable() {
        return false;
    }

    @Override // com.itextpdf.text.Section, com.itextpdf.text.Element
    public int type() {
        return 16;
    }

    public Chapter(Paragraph paragraph, int i) {
        super(paragraph, 1);
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.numbers = arrayList;
        arrayList.add(Integer.valueOf(i));
        this.triggerNewPage = true;
    }

    public Chapter(String str, int i) {
        this(new Paragraph(str), i);
    }
}
