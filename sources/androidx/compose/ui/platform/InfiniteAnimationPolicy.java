package androidx.compose.ui.platform;

import com.itextpdf.text.Annotation;
import defpackage.AbstractC0555Gs;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public interface InfiniteAnimationPolicy extends InterfaceC0988Vf.b {
    public static final Key Key = Key.$$INSTANCE;

    public static final class DefaultImpls {
        public static <R> R fold(InfiniteAnimationPolicy infiniteAnimationPolicy, R r, InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
            return (R) InterfaceC0988Vf.b.a.a(infiniteAnimationPolicy, r, interfaceC0526Fp);
        }

        public static <E extends InterfaceC0988Vf.b> E get(InfiniteAnimationPolicy infiniteAnimationPolicy, InterfaceC0988Vf.c cVar) {
            AbstractC4492zt.h(cVar, "key");
            return (E) InterfaceC0988Vf.b.a.b(infiniteAnimationPolicy, cVar);
        }

        @Deprecated
        public static InterfaceC0988Vf.c getKey(InfiniteAnimationPolicy infiniteAnimationPolicy) {
            return AbstractC0555Gs.a(infiniteAnimationPolicy);
        }

        public static InterfaceC0988Vf minusKey(InfiniteAnimationPolicy infiniteAnimationPolicy, InterfaceC0988Vf.c cVar) {
            AbstractC4492zt.h(cVar, "key");
            return InterfaceC0988Vf.b.a.c(infiniteAnimationPolicy, cVar);
        }

        public static InterfaceC0988Vf plus(InfiniteAnimationPolicy infiniteAnimationPolicy, InterfaceC0988Vf interfaceC0988Vf) {
            AbstractC4492zt.h(interfaceC0988Vf, "context");
            return InterfaceC0988Vf.b.a.d(infiniteAnimationPolicy, interfaceC0988Vf);
        }
    }

    public static final class Key implements InterfaceC0988Vf.c {
        static final /* synthetic */ Key $$INSTANCE = new Key();

        private Key() {
        }
    }

    @Override // defpackage.InterfaceC0988Vf
    /* synthetic */ Object fold(Object obj, InterfaceC0526Fp interfaceC0526Fp);

    @Override // defpackage.InterfaceC0988Vf.b, defpackage.InterfaceC0988Vf
    /* synthetic */ InterfaceC0988Vf.b get(InterfaceC0988Vf.c cVar);

    @Override // defpackage.InterfaceC0988Vf.b
    InterfaceC0988Vf.c getKey();

    @Override // defpackage.InterfaceC0988Vf
    /* synthetic */ InterfaceC0988Vf minusKey(InterfaceC0988Vf.c cVar);

    <R> Object onInfiniteOperation(InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of);

    @Override // defpackage.InterfaceC0988Vf
    /* synthetic */ InterfaceC0988Vf plus(InterfaceC0988Vf interfaceC0988Vf);
}
