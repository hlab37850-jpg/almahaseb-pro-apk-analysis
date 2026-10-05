package com.itextpdf.tool.xml.html.table;

import com.itextpdf.text.Element;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.html.AbstractTagProcessor;
import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.tool.xml.html.pdfelement.HtmlCell;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class TableRow extends AbstractTagProcessor {
    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor
    public List<Element> end(WorkerContext workerContext, Tag tag, List<Element> list) {
        ArrayList arrayList = new ArrayList(1);
        TableRowElement tableRowElement = tag.getParent().getName().equalsIgnoreCase(HTML.Tag.THEAD) ? new TableRowElement(list, TableRowElement.Place.HEADER) : (!tag.getParent().getName().equalsIgnoreCase(HTML.Tag.TBODY) && tag.getParent().getName().equalsIgnoreCase(HTML.Tag.TFOOT)) ? new TableRowElement(list, TableRowElement.Place.FOOTER) : new TableRowElement(list, TableRowElement.Place.BODY);
        int runDirection = getRunDirection(tag);
        if (runDirection != 1) {
            for (HtmlCell htmlCell : tableRowElement.getContent()) {
                if (htmlCell.getRunDirection() == 1) {
                    htmlCell.setRunDirection(runDirection);
                }
            }
        }
        arrayList.add(tableRowElement);
        return arrayList;
    }

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor, com.itextpdf.tool.xml.html.TagProcessor
    public boolean isStackOwner() {
        return true;
    }
}
