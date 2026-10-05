package defpackage;

/* JADX INFO: renamed from: sn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3909sn extends N {

    /* JADX INFO: renamed from: sn$a */
    public static final class a extends AbstractC4003u {
        public a(NS ns) {
            super(ns);
        }

        @Override // defpackage.NS
        public void b(Object obj) {
            this.g.lazySet(obj);
            e();
        }
    }

    public C3909sn(AbstractC3258kn abstractC3258kn) {
        super(abstractC3258kn);
    }

    @Override // defpackage.AbstractC3258kn
    public void n(NS ns) {
        this.b.m(new a(ns));
    }
}
