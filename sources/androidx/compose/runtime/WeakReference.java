package androidx.compose.runtime;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class WeakReference<T> extends java.lang.ref.WeakReference<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeakReference(T t) {
        super(t);
        AbstractC4492zt.h(t, "reference");
    }
}
