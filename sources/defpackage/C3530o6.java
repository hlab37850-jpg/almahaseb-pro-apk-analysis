package defpackage;

/* JADX INFO: renamed from: o6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3530o6 extends AbstractC0354Av {
    public final String a;
    public final String b;

    public C3530o6(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null libraryName");
        }
        this.a = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.b = str2;
    }

    @Override // defpackage.AbstractC0354Av
    public String b() {
        return this.a;
    }

    @Override // defpackage.AbstractC0354Av
    public String c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC0354Av)) {
            return false;
        }
        AbstractC0354Av abstractC0354Av = (AbstractC0354Av) obj;
        return this.a.equals(abstractC0354Av.b()) && this.b.equals(abstractC0354Av.c());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.a + ", version=" + this.b + "}";
    }
}
