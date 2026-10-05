package defpackage;

/* JADX INFO: loaded from: classes2.dex */
public final class V1 {
    public String a;

    public static final class a {
        public String a;

        public /* synthetic */ a(N30 n30) {
        }

        public V1 a() {
            String str = this.a;
            if (str == null) {
                throw new IllegalArgumentException("Purchase token must be set");
            }
            V1 v1 = new V1(null);
            v1.a = str;
            return v1;
        }

        public a b(String str) {
            this.a = str;
            return this;
        }
    }

    public /* synthetic */ V1(N30 n30) {
    }

    public static a b() {
        return new a(null);
    }

    public String a() {
        return this.a;
    }
}
