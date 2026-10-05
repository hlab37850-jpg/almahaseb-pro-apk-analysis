package com.itextpdf.tool.xml.pipeline;

import com.itextpdf.text.Element;
import com.itextpdf.tool.xml.Writable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class WritableElement implements Writable {
    private final ArrayList<Element> list;

    public WritableElement() {
        this.list = new ArrayList<>();
    }

    public void add(Element element) {
        this.list.add(element);
    }

    public void addAll(List<Element> list) {
        this.list.addAll(list);
    }

    public List<Element> elements() {
        return this.list;
    }

    public WritableElement(Element element) {
        this();
        this.list.add(element);
    }
}
