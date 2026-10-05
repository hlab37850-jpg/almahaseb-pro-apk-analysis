package com.itextpdf.tool.xml.pipeline.html;

import com.itextpdf.text.Element;
import com.itextpdf.tool.xml.Tag;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class StackKeeper {
    private final List<Element> stack = new ArrayList();
    private final Tag tag;

    public StackKeeper(Tag tag) {
        this.tag = tag;
    }

    public void add(Element element) {
        this.stack.add(element);
    }

    public List<Element> getElements() {
        return this.stack;
    }

    public Tag getTag() {
        return this.tag;
    }

    public void add(Collection<? extends Element> collection) {
        Iterator<? extends Element> it = collection.iterator();
        while (it.hasNext()) {
            this.stack.add(it.next());
        }
    }
}
