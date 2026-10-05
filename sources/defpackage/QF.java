package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class QF {
    public int a;
    public int b;
    public boolean c;
    public ZQ d;

    public QF(int i, int i2) {
        this.d = null;
        this.a = i;
        this.b = i2;
        this.c = false;
    }

    public boolean a() {
        return this.c;
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.a;
    }

    public int e() {
        return this.b;
    }

    public BF f() {
        ZQ zq = this.d;
        if (zq != null) {
            return (BF) zq.a();
        }
        return null;
    }

    public void g(BF bf) {
        this.d = new ZQ(bf);
    }

    public QF(int i, int i2, boolean z) {
        this.d = null;
        this.a = i;
        this.b = i2;
        this.c = z;
    }

    public QF(byte[] bArr) {
        this.d = null;
        if (bArr == null) {
            this.a = -1;
            this.b = -1;
        } else {
            this.a = Integer.parseInt(new String(bArr, 0, 10));
            this.b = Integer.parseInt(new String(bArr, 11, 5));
        }
        this.c = false;
    }
}
