package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class UF implements InterfaceC0412Db {
    public final Class a;
    public final String b;

    public UF(Class cls, String str) {
        AbstractC4492zt.h(cls, "jClass");
        AbstractC4492zt.h(str, "moduleName");
        this.a = cls;
        this.b = str;
    }

    @Override // defpackage.InterfaceC0412Db
    public Class b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof UF) && AbstractC4492zt.d(b(), ((UF) obj).b());
    }

    public int hashCode() {
        return b().hashCode();
    }

    public String toString() {
        return b().toString() + " (Kotlin reflection is not available)";
    }
}
