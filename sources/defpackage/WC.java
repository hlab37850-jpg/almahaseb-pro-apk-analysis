package defpackage;

/* JADX INFO: loaded from: classes2.dex */
public final class WC extends XC {
    public final int c;
    public final int d;
    public final int e;

    public WC(String str, int i, int i2, int i3, int i4) {
        super(str, i);
        this.c = i2;
        this.d = i3;
        this.e = i4;
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
        return i == 3 && iArr[0] == this.c && iArr[1] == this.d && iArr[2] == this.e;
    }
}
