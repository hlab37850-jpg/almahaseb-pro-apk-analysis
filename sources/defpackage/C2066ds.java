package defpackage;

/* JADX INFO: renamed from: ds, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2066ds implements InterfaceC3461nF {
    public static C2066ds a = new C2066ds();

    public static C2066ds d() {
        return a;
    }

    @Override // defpackage.InterfaceC3461nF
    public T8 a(String str, BF bf, T8 t8) throws EF {
        if (str == null) {
            return t8;
        }
        throw new EF("This Encryption version does not support Crypt filters");
    }

    @Override // defpackage.InterfaceC3461nF
    public boolean b() {
        return false;
    }

    @Override // defpackage.InterfaceC3461nF
    public String c(int i, int i2, String str) {
        return str;
    }
}
