package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class Break extends AbstractTagProcessor {
    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor
    public List<Element> end(WorkerContext workerContext, Tag tag, List<Element> list) {
        ArrayList arrayList = new ArrayList(1);
        try {
            arrayList.add((Chunk) getCssAppliers().apply(new Chunk(Chunk.NEWLINE), tag, getHtmlPipelineContext(workerContext)));
            return arrayList;
        } catch (NoCustomContextException e) {
            throw new RuntimeWorkerException(LocaleMessages.getInstance().getMessage(LocaleMessages.NO_CUSTOM_CONTEXT), e);
        }
    }
}
