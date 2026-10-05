package androidx.core.util;

import defpackage.InterfaceC0793Of;

/* JADX INFO: loaded from: classes2.dex */
public final class RunnableKt {
    public static final Runnable asRunnable(InterfaceC0793Of interfaceC0793Of) {
        return new ContinuationRunnable(interfaceC0793Of);
    }
}
