package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Element;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface TagProcessor {
    List<Element> content(WorkerContext workerContext, Tag tag, String str);

    List<Element> endElement(WorkerContext workerContext, Tag tag, List<Element> list);

    boolean isStackOwner();

    List<Element> startElement(WorkerContext workerContext, Tag tag);
}
