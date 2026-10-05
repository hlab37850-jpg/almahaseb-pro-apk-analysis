package com.itextpdf.tool.xml;

import com.itextpdf.text.Element;
import com.itextpdf.tool.xml.pipeline.WritableElement;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class ElementList extends ArrayList<Element> implements ElementHandler {
    private static final long serialVersionUID = -3943194552607332537L;

    @Override // com.itextpdf.tool.xml.ElementHandler
    public void add(Writable writable) {
        if (writable instanceof WritableElement) {
            addAll(((WritableElement) writable).elements());
        }
    }
}
