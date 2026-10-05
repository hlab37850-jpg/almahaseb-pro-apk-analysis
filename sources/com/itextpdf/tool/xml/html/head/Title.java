package com.itextpdf.tool.xml.html.head;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.WritableDirectElement;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.html.AbstractTagProcessor;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class Title extends AbstractTagProcessor {
    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor, com.itextpdf.tool.xml.html.TagProcessor
    public List<Element> content(WorkerContext workerContext, Tag tag, final String str) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new WritableDirectElement() { // from class: com.itextpdf.tool.xml.html.head.Title.1
            @Override // com.itextpdf.text.api.WriterOperation
            public void write(PdfWriter pdfWriter, Document document) {
                document.addTitle(str);
            }
        });
        return arrayList;
    }
}
