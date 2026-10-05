package com.itextpdf.tool.xml;

/* JADX INFO: loaded from: classes3.dex */
public interface WorkerContext {
    CustomContext get(String str);

    Tag getCurrentTag();

    void put(String str, CustomContext customContext);

    void setCurrentTag(Tag tag);
}
