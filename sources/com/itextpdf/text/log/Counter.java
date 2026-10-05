package com.itextpdf.text.log;

/* JADX INFO: loaded from: classes3.dex */
public interface Counter {
    Counter getCounter(Class<?> cls);

    void read(long j);

    void written(long j);
}
