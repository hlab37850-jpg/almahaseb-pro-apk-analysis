package com.itextpdf.text.pdf.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class MultiFilteredRenderListener implements RenderListener {
    private final List<RenderListener> delegates = new ArrayList();
    private final List<RenderFilter[]> filters = new ArrayList();

    public <E extends RenderListener> E attachRenderListener(E e, RenderFilter... renderFilterArr) {
        this.delegates.add(e);
        this.filters.add(renderFilterArr);
        return e;
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void beginTextBlock() {
        Iterator<RenderListener> it = this.delegates.iterator();
        while (it.hasNext()) {
            it.next().beginTextBlock();
        }
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void endTextBlock() {
        Iterator<RenderListener> it = this.delegates.iterator();
        while (it.hasNext()) {
            it.next().endTextBlock();
        }
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void renderImage(ImageRenderInfo imageRenderInfo) {
        for (int i = 0; i < this.delegates.size(); i++) {
            RenderFilter[] renderFilterArr = this.filters.get(i);
            int length = renderFilterArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    this.delegates.get(i).renderImage(imageRenderInfo);
                    break;
                } else if (!renderFilterArr[i2].allowImage(imageRenderInfo)) {
                    break;
                } else {
                    i2++;
                }
            }
        }
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void renderText(TextRenderInfo textRenderInfo) {
        for (int i = 0; i < this.delegates.size(); i++) {
            RenderFilter[] renderFilterArr = this.filters.get(i);
            int length = renderFilterArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    this.delegates.get(i).renderText(textRenderInfo);
                    break;
                } else if (!renderFilterArr[i2].allowText(textRenderInfo)) {
                    break;
                } else {
                    i2++;
                }
            }
        }
    }
}
