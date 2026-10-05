package com.itextpdf.tool.xml.pipeline.ctx;

import com.itextpdf.tool.xml.CustomContext;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;

/* JADX INFO: loaded from: classes3.dex */
public class WorkerContextImpl implements WorkerContext {
    private final MapContext mc = new MapContext();
    private Tag tag;

    @Override // com.itextpdf.tool.xml.WorkerContext
    public CustomContext get(String str) throws NoCustomContextException {
        Object obj = this.mc.get(str);
        if (obj != null) {
            return (CustomContext) obj;
        }
        throw new NoCustomContextException();
    }

    @Override // com.itextpdf.tool.xml.WorkerContext
    public Tag getCurrentTag() {
        return this.tag;
    }

    @Override // com.itextpdf.tool.xml.WorkerContext
    public void put(String str, CustomContext customContext) {
        this.mc.put(str, customContext);
    }

    @Override // com.itextpdf.tool.xml.WorkerContext
    public void setCurrentTag(Tag tag) {
        this.tag = tag;
    }
}
