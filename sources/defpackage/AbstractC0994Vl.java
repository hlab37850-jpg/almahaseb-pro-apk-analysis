package defpackage;

import java.io.Closeable;

/* JADX INFO: renamed from: Vl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0994Vl extends AbstractC1040Xf implements Closeable {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: Vl$a */
    public static final class a extends I {

        /* JADX INFO: renamed from: Vl$a$a, reason: collision with other inner class name */
        public static final class C0024a extends AbstractC2233fv implements InterfaceC3750qp {
            public static final C0024a a = new C0024a();

            public C0024a() {
                super(1);
            }

            @Override // defpackage.InterfaceC3750qp
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final AbstractC0994Vl invoke(InterfaceC0988Vf.b bVar) {
                if (bVar instanceof AbstractC0994Vl) {
                    return (AbstractC0994Vl) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public a() {
            super(AbstractC1040Xf.Key, C0024a.a);
        }
    }
}
