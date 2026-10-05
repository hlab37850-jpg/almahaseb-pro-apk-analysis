package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class NonSanitizedTag extends AbstractTagProcessor {
    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor, com.itextpdf.tool.xml.html.TagProcessor
    public List<Element> content(WorkerContext workerContext, Tag tag, String str) {
        ArrayList arrayList = new ArrayList(1);
        if (str != null && str.length() > 0) {
            try {
                arrayList.add(getCssAppliers().apply(new Chunk(str), tag, getHtmlPipelineContext(workerContext)));
            } catch (NoCustomContextException e) {
                throw new RuntimeWorkerException(e);
            }
        }
        return arrayList;
    }

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor
    public List<Element> end(WorkerContext workerContext, Tag tag, List<Element> list) {
        return currentContentToParagraph(list, false, true, tag, workerContext);
    }
}
