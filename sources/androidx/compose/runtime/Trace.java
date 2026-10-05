package androidx.compose.runtime;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class Trace {
    public static final Trace INSTANCE = new Trace();

    private Trace() {
    }

    public final Object beginSection(String str) {
        AbstractC4492zt.h(str, "name");
        android.os.Trace.beginSection(str);
        return null;
    }

    public final void endSection(Object obj) {
        android.os.Trace.endSection();
    }
}
