package defpackage;

/* JADX INFO: renamed from: vG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4111vG {
    public final boolean a;
    public final boolean b;

    /* JADX INFO: renamed from: vG$a */
    public static final class a {
        public boolean a;
        public boolean b;

        public a() {
        }

        public C4111vG a() {
            if (!this.a) {
                throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
            }
            return new C4111vG(true, this.b);
        }

        public a b() {
            this.a = true;
            return this;
        }
    }

    public C4111vG(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    public static a c() {
        return new a();
    }

    public boolean a() {
        return this.a;
    }

    public boolean b() {
        return this.b;
    }
}
