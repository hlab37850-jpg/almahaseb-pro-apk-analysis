package androidx.work.impl.model;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
public final class WorkSpecKt {
    public static final WorkGenerationalId generationalId(WorkSpec workSpec) {
        AbstractC4492zt.h(workSpec, "<this>");
        return new WorkGenerationalId(workSpec.id, workSpec.getGeneration());
    }
}
