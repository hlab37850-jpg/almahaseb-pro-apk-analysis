package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.ListItem;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class OrderedUnorderedListItem extends AbstractTagProcessor {
    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor, com.itextpdf.tool.xml.html.TagProcessor
    public List<Element> content(WorkerContext workerContext, Tag tag, String str) {
        return textContent(workerContext, tag, str);
    }

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor
    public List<Element> end(WorkerContext workerContext, Tag tag, List<Element> list) {
        ArrayList arrayList = new ArrayList(1);
        ListItem listItem = new ListItem();
        float f = -1.0f;
        for (Element element : list) {
            listItem.add(element);
            Iterator<Chunk> it = element.getChunks().iterator();
            while (it.hasNext()) {
                float calculatedLeading = it.next().getFont().getCalculatedLeading(1.3333334f);
                if (f < calculatedLeading) {
                    f = calculatedLeading;
                }
            }
        }
        if (listItem.getLeading() < f) {
            listItem.setLeading(f);
        }
        if (listItem.trim()) {
            arrayList.add(listItem);
        }
        return arrayList;
    }

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor, com.itextpdf.tool.xml.html.TagProcessor
    public boolean isStackOwner() {
        return true;
    }
}
