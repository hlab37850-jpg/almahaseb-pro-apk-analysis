package com.itextpdf.tool.xml.html;

/* JADX INFO: loaded from: classes3.dex */
public interface TagProcessorFactory {
    void addProcessor(TagProcessor tagProcessor, String... strArr);

    TagProcessor getProcessor(String str, String str2);

    void removeProcessor(String str);
}
