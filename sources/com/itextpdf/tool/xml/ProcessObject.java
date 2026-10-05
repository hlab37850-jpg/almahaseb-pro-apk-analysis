package com.itextpdf.tool.xml;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
public class ProcessObject {
    private final Queue<Writable> queue = new LinkedList();

    public void add(Writable writable) {
        this.queue.add(writable);
    }

    public void addAll(List<Writable> list) {
        this.queue.addAll(list);
    }

    public boolean containsWritable() {
        return !this.queue.isEmpty();
    }

    public Writable poll() {
        return this.queue.poll();
    }
}
