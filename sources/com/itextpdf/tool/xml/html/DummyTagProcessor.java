package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Element;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DummyTagProcessor implements TagProcessor {
    @Override // com.itextpdf.tool.xml.html.TagProcessor
    public List<Element> content(WorkerContext workerContext, Tag tag, String str) {
        return new ArrayList(0);
    }

    @Override // com.itextpdf.tool.xml.html.TagProcessor
    public List<Element> endElement(WorkerContext workerContext, Tag tag, List<Element> list) {
        return new ArrayList(0);
    }

    @Override // com.itextpdf.tool.xml.html.TagProcessor
    public boolean isStackOwner() {
        return false;
    }

    @Override // com.itextpdf.tool.xml.html.TagProcessor
    public List<Element> startElement(WorkerContext workerContext, Tag tag) {
        return new ArrayList(0);
    }
}
