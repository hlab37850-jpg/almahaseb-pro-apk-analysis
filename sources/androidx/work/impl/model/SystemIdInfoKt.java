package androidx.work.impl.model;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
public final class SystemIdInfoKt {
    public static final SystemIdInfo systemIdInfo(WorkGenerationalId workGenerationalId, int i) {
        AbstractC4492zt.h(workGenerationalId, "generationalId");
        return new SystemIdInfo(workGenerationalId.getWorkSpecId(), workGenerationalId.getGeneration(), i);
    }
}
