package defpackage;

/* JADX INFO: loaded from: classes2.dex */
public final class YC extends XC {
    public final int[] c;
    public final int d;

    public YC(String str, int i, int[] iArr, int i2) {
        super(str, i);
        if (i2 < 3) {
            throw new IllegalArgumentException("Qlen must >= 3");
        }
        this.c = iArr;
        this.d = i2;
    }

    @Override // defpackage.XC
    public boolean a(int i) {
        return false;
    }

    @Override // defpackage.XC
    public boolean b(int i, int i2) {
        return false;
    }

    @Override // defpackage.XC
    public boolean c(int[] iArr, int i) {
        if (i != this.d) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != this.c[i2]) {
                return false;
            }
        }
        return true;
    }
}
