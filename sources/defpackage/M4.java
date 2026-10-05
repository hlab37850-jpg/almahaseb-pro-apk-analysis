package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class M4 {
    public final int a;
    public final Object[] b;
    public Object[] c;
    public int d;

    public M4(int i) {
        this.a = i;
        Object[] objArr = new Object[i + 1];
        this.b = objArr;
        this.c = objArr;
    }

    public boolean a(NS ns) {
        Object[] objArr = this.b;
        int i = this.a;
        while (true) {
            if (objArr == null) {
                return false;
            }
            for (int i2 = 0; i2 < i; i2++) {
                Object[] objArr2 = objArr[i2];
                if (objArr2 == null) {
                    break;
                }
                if (QD.a(objArr2, ns)) {
                    return true;
                }
            }
            objArr = objArr[i];
        }
    }

    public void b(Object obj) {
        int i = this.a;
        int i2 = this.d;
        if (i2 == i) {
            Object[] objArr = new Object[i + 1];
            this.c[i] = objArr;
            this.c = objArr;
            i2 = 0;
        }
        this.c[i2] = obj;
        this.d = i2 + 1;
    }

    public void c(Object obj) {
        this.b[0] = obj;
    }
}
