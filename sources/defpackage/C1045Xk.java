package defpackage;

/* JADX INFO: renamed from: Xk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1045Xk implements InterfaceC0377Bs {
    public final boolean a;

    public C1045Xk(boolean z) {
        this.a = z;
    }

    @Override // defpackage.InterfaceC0377Bs
    public BD c() {
        return null;
    }

    @Override // defpackage.InterfaceC0377Bs
    public boolean isActive() {
        return this.a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(isActive() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
