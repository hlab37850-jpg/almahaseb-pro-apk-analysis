package defpackage;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class Bc0 implements ThreadFactory {
    public static final ThreadFactory a = new Bc0();

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return AbstractC4472zd0.a(runnable);
    }
}
