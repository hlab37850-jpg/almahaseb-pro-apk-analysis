package com.itextpdf.tool.xml.html.table;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.itextpdf.tool.xml.exceptions.NotImplementedException;
import com.itextpdf.tool.xml.html.pdfelement.HtmlCell;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class TableRowElement implements Element {
    private final List<HtmlCell> content;
    private final Place place;

    public enum Place {
        CAPTION_TOP(-2, -2),
        HEADER(-1, -1),
        BODY(0, 1),
        FOOTER(1, 0),
        CAPTION_BOTTOM(2, 2);

        private Integer normal;
        private Integer repeated;

        Place(Integer num, Integer num2) {
            this.normal = num;
            this.repeated = num2;
        }

        public Integer getNormal() {
            return this.normal;
        }

        public Integer getRepeated() {
            return this.repeated;
        }
    }

    public TableRowElement(List<Element> list, Place place) {
        this.content = new ArrayList(list.size());
        for (Element element : list) {
            if (element instanceof HtmlCell) {
                this.content.add((HtmlCell) element);
            }
        }
        this.place = place;
    }

    @Override // com.itextpdf.text.Element
    public List<Chunk> getChunks() {
        throw new NotImplementedException();
    }

    public List<HtmlCell> getContent() {
        return this.content;
    }

    public Place getPlace() {
        return this.place;
    }

    @Override // com.itextpdf.text.Element
    public boolean isContent() {
        throw new NotImplementedException();
    }

    @Override // com.itextpdf.text.Element
    public boolean isNestable() {
        throw new NotImplementedException();
    }

    @Override // com.itextpdf.text.Element
    public boolean process(ElementListener elementListener) {
        throw new NotImplementedException();
    }

    @Override // com.itextpdf.text.Element
    public int type() {
        throw new NotImplementedException();
    }
}
