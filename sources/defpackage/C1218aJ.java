package defpackage;

/* JADX INFO: renamed from: aJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1218aJ {
    public final String a;

    /* JADX INFO: renamed from: aJ$a */
    public static class a {
        public String a;

        public /* synthetic */ a(AbstractC3861s90 abstractC3861s90) {
        }

        public C1218aJ a() {
            if (this.a != null) {
                return new C1218aJ(this, null);
            }
            throw new IllegalArgumentException("Product type must be set");
        }

        public a b(String str) {
            this.a = str;
            return this;
        }
    }

    public /* synthetic */ C1218aJ(a aVar, AbstractC3861s90 abstractC3861s90) {
        this.a = aVar.a;
    }

    public static a a() {
        return new a(null);
    }

    public final String b() {
        return this.a;
    }
}
