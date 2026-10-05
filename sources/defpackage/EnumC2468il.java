package defpackage;

/* JADX INFO: renamed from: il, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC2468il implements InterfaceC2023dJ {
    INSTANCE;

    public static void a(Throwable th, NS ns) {
        ns.a(INSTANCE);
        ns.onError(th);
    }

    @Override // defpackage.InterfaceC4283xQ
    public boolean isEmpty() {
        return true;
    }

    @Override // defpackage.PS
    public void l(long j) {
        RS.h(j);
    }

    @Override // defpackage.InterfaceC4283xQ
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // defpackage.InterfaceC4283xQ
    public Object poll() {
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }

    @Override // defpackage.PS
    public void cancel() {
    }

    @Override // defpackage.InterfaceC4283xQ
    public void clear() {
    }
}
