package defpackage;

/* JADX INFO: renamed from: al, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC1255al implements InterfaceC1784bJ {
    INSTANCE,
    NEVER;

    @Override // defpackage.InterfaceC1865cJ
    public int c(int i) {
        return i & 2;
    }

    @Override // defpackage.InterfaceC0624Jj
    public boolean isDisposed() {
        return this == INSTANCE;
    }

    @Override // defpackage.InterfaceC4283xQ
    public boolean isEmpty() {
        return true;
    }

    @Override // defpackage.InterfaceC4283xQ
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // defpackage.InterfaceC4283xQ
    public Object poll() {
        return null;
    }

    @Override // defpackage.InterfaceC4283xQ
    public void clear() {
    }

    @Override // defpackage.InterfaceC0624Jj
    public void dispose() {
    }
}
