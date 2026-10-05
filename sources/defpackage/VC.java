package defpackage;

/* JADX INFO: loaded from: classes2.dex */
public final class VC extends XC {
    public final int c;
    public final int d;

    public VC(String str, int i, int i2, int i3) {
        super(str, i);
        this.c = i2;
        this.d = i3;
    }

    @Override // defpackage.XC
    public boolean a(int i) {
        return false;
    }

    @Override // defpackage.XC
    public boolean b(int i, int i2) {
        return i == this.c && i2 == this.d;
    }

    @Override // defpackage.XC
    public boolean c(int[] iArr, int i) {
        return i == 2 && iArr[0] == this.c && iArr[1] == this.d;
    }
}
