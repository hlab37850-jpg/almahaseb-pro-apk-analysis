package defpackage;

/* JADX INFO: renamed from: Li, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0719Li implements QL {
    public int a;
    public int b;
    public final int c;
    public final float d;

    public C0719Li() {
        this(2500, 1, 1.0f);
    }

    @Override // defpackage.QL
    public int a() {
        return this.a;
    }

    @Override // defpackage.QL
    public int b() {
        return this.b;
    }

    @Override // defpackage.QL
    public void c(C2119eY c2119eY) throws C2119eY {
        this.b++;
        int i = this.a;
        this.a = (int) (i + (i * this.d));
        if (!d()) {
            throw c2119eY;
        }
    }

    public boolean d() {
        return this.b <= this.c;
    }

    public C0719Li(int i, int i2, float f) {
        this.a = i;
        this.c = i2;
        this.d = f;
    }
}
