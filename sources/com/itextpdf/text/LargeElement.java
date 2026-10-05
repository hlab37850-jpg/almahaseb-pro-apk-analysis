package com.itextpdf.text;

/* JADX INFO: loaded from: classes3.dex */
public interface LargeElement extends Element {
    void flushContent();

    boolean isComplete();

    void setComplete(boolean z);
}
