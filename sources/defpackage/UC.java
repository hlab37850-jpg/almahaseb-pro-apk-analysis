package defpackage;

/* JADX INFO: loaded from: classes2.dex */
public final class UC extends XC {
    public static final UC d = new UC("", 0, 0);
    public final int c;

    public UC(String str, int i, int i2) {
        super(str, i);
        this.c = i2;
    }

    public static UC e() {
        return d;
    }

    @Override // defpackage.XC
    public boolean a(int i) {
        return i == this.c;
    }

    @Override // defpackage.XC
    public boolean b(int i, int i2) {
        return i == this.c && i2 == 0;
    }

    @Override // defpackage.XC
    public boolean c(int[] iArr, int i) {
        return i == 1 && iArr[0] == this.c;
    }
}
