package defpackage;

/* JADX INFO: renamed from: Vr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C1000Vr {
    public int a;
    public String b;

    public C1000Vr(int i, String str) {
        this.a = i;
        if (str == null || str.trim().length() == 0) {
            this.b = C0974Ur.k(i);
            return;
        }
        this.b = str + " (response: " + C0974Ur.k(i) + ")";
    }

    public String a() {
        return this.b;
    }

    public boolean b() {
        return !c();
    }

    public boolean c() {
        return this.a == 0;
    }

    public String toString() {
        return "IabResult: " + a();
    }
}
