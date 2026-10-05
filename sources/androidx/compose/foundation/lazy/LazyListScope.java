package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
@LazyScopeMarker
public interface LazyListScope {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListScope$-CC, reason: invalid class name */
    public abstract /* synthetic */ class CC {
        public static /* synthetic */ void a(LazyListScope lazyListScope, Object obj, InterfaceC0552Gp interfaceC0552Gp) {
            AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
            lazyListScope.item(obj, null, interfaceC0552Gp);
        }

        public static void b(LazyListScope lazyListScope, Object obj, Object obj2, InterfaceC0552Gp interfaceC0552Gp) {
            AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
            throw new IllegalStateException("The method is not implemented");
        }

        public static void c(LazyListScope lazyListScope, int i, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, InterfaceC0578Hp interfaceC0578Hp) {
            AbstractC4492zt.h(interfaceC3750qp2, "contentType");
            AbstractC4492zt.h(interfaceC0578Hp, "itemContent");
            throw new IllegalStateException("The method is not implemented");
        }

        public static /* synthetic */ void d(LazyListScope lazyListScope, int i, InterfaceC3750qp interfaceC3750qp, InterfaceC0578Hp interfaceC0578Hp) {
            AbstractC4492zt.h(interfaceC0578Hp, "itemContent");
            lazyListScope.items(i, interfaceC3750qp, AnonymousClass2.INSTANCE, interfaceC0578Hp);
        }

        public static /* synthetic */ void i(LazyListScope lazyListScope, Object obj, InterfaceC0552Gp interfaceC0552Gp, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
            }
            if ((i & 1) != 0) {
                obj = null;
            }
            lazyListScope.item(obj, interfaceC0552Gp);
        }

        public static /* synthetic */ void j(LazyListScope lazyListScope, Object obj, Object obj2, InterfaceC0552Gp interfaceC0552Gp, int i, Object obj3) {
            if (obj3 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
            }
            if ((i & 1) != 0) {
                obj = null;
            }
            if ((i & 2) != 0) {
                obj2 = null;
            }
            lazyListScope.item(obj, obj2, interfaceC0552Gp);
        }

        public static /* synthetic */ void k(LazyListScope lazyListScope, int i, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, InterfaceC0578Hp interfaceC0578Hp, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
            }
            if ((i2 & 2) != 0) {
                interfaceC3750qp = null;
            }
            if ((i2 & 4) != 0) {
                interfaceC3750qp2 = AnonymousClass1.INSTANCE;
            }
            lazyListScope.items(i, interfaceC3750qp, interfaceC3750qp2, interfaceC0578Hp);
        }

        public static /* synthetic */ void l(LazyListScope lazyListScope, int i, InterfaceC3750qp interfaceC3750qp, InterfaceC0578Hp interfaceC0578Hp, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
            }
            if ((i2 & 2) != 0) {
                interfaceC3750qp = null;
            }
            lazyListScope.items(i, interfaceC3750qp, interfaceC0578Hp);
        }

        public static /* synthetic */ void m(LazyListScope lazyListScope, Object obj, Object obj2, InterfaceC0552Gp interfaceC0552Gp, int i, Object obj3) {
            if (obj3 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stickyHeader");
            }
            if ((i & 1) != 0) {
                obj = null;
            }
            if ((i & 2) != 0) {
                obj2 = null;
            }
            lazyListScope.stickyHeader(obj, obj2, interfaceC0552Gp);
        }
    }

    public static final class DefaultImpls {
        @Deprecated
        public static void item(LazyListScope lazyListScope, Object obj, Object obj2, InterfaceC0552Gp interfaceC0552Gp) {
            AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
            CC.b(lazyListScope, obj, obj2, interfaceC0552Gp);
        }

        @Deprecated
        public static void items(LazyListScope lazyListScope, int i, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, InterfaceC0578Hp interfaceC0578Hp) {
            AbstractC4492zt.h(interfaceC3750qp2, "contentType");
            AbstractC4492zt.h(interfaceC0578Hp, "itemContent");
            CC.c(lazyListScope, i, interfaceC3750qp, interfaceC3750qp2, interfaceC0578Hp);
        }

        @Deprecated
        public static /* synthetic */ void item(LazyListScope lazyListScope, Object obj, InterfaceC0552Gp interfaceC0552Gp) {
            AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
            CC.a(lazyListScope, obj, interfaceC0552Gp);
        }

        @Deprecated
        public static /* synthetic */ void items(LazyListScope lazyListScope, int i, InterfaceC3750qp interfaceC3750qp, InterfaceC0578Hp interfaceC0578Hp) {
            AbstractC4492zt.h(interfaceC0578Hp, "itemContent");
            CC.d(lazyListScope, i, interfaceC3750qp, interfaceC0578Hp);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListScope$items$1, reason: invalid class name */
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListScope$items$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        public final Object invoke(int i) {
            return null;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }
    }

    /* synthetic */ void item(Object obj, InterfaceC0552Gp interfaceC0552Gp);

    void item(Object obj, Object obj2, InterfaceC0552Gp interfaceC0552Gp);

    /* synthetic */ void items(int i, InterfaceC3750qp interfaceC3750qp, InterfaceC0578Hp interfaceC0578Hp);

    void items(int i, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, InterfaceC0578Hp interfaceC0578Hp);

    @ExperimentalFoundationApi
    void stickyHeader(Object obj, Object obj2, InterfaceC0552Gp interfaceC0552Gp);
}
