package com.itextpdf.tool.xml;

import com.itextpdf.tool.xml.CustomContext;

/* JADX INFO: loaded from: classes3.dex */
public interface Pipeline<T extends CustomContext> {
    Pipeline<?> close(WorkerContext workerContext, Tag tag, ProcessObject processObject);

    Pipeline<?> content(WorkerContext workerContext, Tag tag, String str, ProcessObject processObject);

    Pipeline<?> getNext();

    Pipeline<?> init(WorkerContext workerContext);

    Pipeline<?> open(WorkerContext workerContext, Tag tag, ProcessObject processObject);
}
