package com.itextpdf.tool.xml.html.pdfelement;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

/* JADX INFO: loaded from: classes3.dex */
public class TabbedChunk extends Chunk {
    private String alignment;
    private int tabCount;

    public TabbedChunk(String str) {
        super(str);
    }

    public String getAlignment() {
        return this.alignment;
    }

    public int getTabCount() {
        return this.tabCount;
    }

    public void setAlignment(String str) {
        this.alignment = str;
    }

    public void setTabCount(int i) {
        this.tabCount = i;
    }

    public TabbedChunk(VerticalPositionMark verticalPositionMark, float f, boolean z, String str) {
        super(verticalPositionMark, f, z);
        this.alignment = str;
    }

    public TabbedChunk(VerticalPositionMark verticalPositionMark, float f, boolean z) {
        super(verticalPositionMark, f, z);
    }
}
