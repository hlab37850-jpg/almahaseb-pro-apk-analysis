package defpackage;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: Pj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class FutureC0823Pj implements Future {
    public final InterfaceC0624Jj a;

    public FutureC0823Pj(InterfaceC0624Jj interfaceC0624Jj) {
        this.a = interfaceC0624Jj;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        this.a.dispose();
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return null;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) {
        return null;
    }
}
