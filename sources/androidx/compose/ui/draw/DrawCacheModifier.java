package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import defpackage.YB;
import defpackage.ZB;

/* JADX INFO: loaded from: classes.dex */
public interface DrawCacheModifier extends DrawModifier {

    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(DrawCacheModifier drawCacheModifier, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "predicate");
            return ZB.a(drawCacheModifier, interfaceC3750qp);
        }

        @Deprecated
        public static boolean any(DrawCacheModifier drawCacheModifier, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "predicate");
            return ZB.b(drawCacheModifier, interfaceC3750qp);
        }

        @Deprecated
        public static <R> R foldIn(DrawCacheModifier drawCacheModifier, R r, InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
            return (R) ZB.c(drawCacheModifier, r, interfaceC0526Fp);
        }

        @Deprecated
        public static <R> R foldOut(DrawCacheModifier drawCacheModifier, R r, InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
            return (R) ZB.d(drawCacheModifier, r, interfaceC0526Fp);
        }

        @Deprecated
        public static Modifier then(DrawCacheModifier drawCacheModifier, Modifier modifier) {
            AbstractC4492zt.h(modifier, "other");
            return YB.a(drawCacheModifier, modifier);
        }
    }

    void onBuildCache(BuildDrawCacheParams buildDrawCacheParams);
}
