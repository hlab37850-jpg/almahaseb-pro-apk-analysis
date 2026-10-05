package androidx.compose.foundation.lazy.staggeredgrid;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
@LazyStaggeredGridScopeMarker
public interface LazyStaggeredGridScope {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope$-CC, reason: invalid class name */
    public abstract /* synthetic */ class CC {
        public static /* synthetic */ void a(LazyStaggeredGridScope lazyStaggeredGridScope, Object obj, Object obj2, StaggeredGridItemSpan staggeredGridItemSpan, InterfaceC0552Gp interfaceC0552Gp, int i, Object obj3) {
            if (obj3 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
            }
            if ((i & 1) != 0) {
                obj = null;
            }
            if ((i & 2) != 0) {
                obj2 = null;
            }
            if ((i & 4) != 0) {
                staggeredGridItemSpan = null;
            }
            lazyStaggeredGridScope.item(obj, obj2, staggeredGridItemSpan, interfaceC0552Gp);
        }

        public static /* synthetic */ void b(LazyStaggeredGridScope lazyStaggeredGridScope, int i, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, InterfaceC3750qp interfaceC3750qp3, InterfaceC0578Hp interfaceC0578Hp, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
            }
            InterfaceC3750qp interfaceC3750qp4 = (i2 & 2) != 0 ? null : interfaceC3750qp;
            if ((i2 & 4) != 0) {
                interfaceC3750qp2 = AnonymousClass1.INSTANCE;
            }
            lazyStaggeredGridScope.items(i, interfaceC3750qp4, interfaceC3750qp2, (i2 & 8) != 0 ? null : interfaceC3750qp3, interfaceC0578Hp);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope$items$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        public final Void invoke(int i) {
            return null;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }
    }

    void item(Object obj, Object obj2, StaggeredGridItemSpan staggeredGridItemSpan, InterfaceC0552Gp interfaceC0552Gp);

    void items(int i, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, InterfaceC3750qp interfaceC3750qp3, InterfaceC0578Hp interfaceC0578Hp);
}
