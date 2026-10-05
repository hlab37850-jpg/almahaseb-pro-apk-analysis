package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import defpackage.YB;
import defpackage.ZB;

/* JADX INFO: loaded from: classes.dex */
public interface DrawModifier extends Modifier.Element {

    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(DrawModifier drawModifier, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "predicate");
            return ZB.a(drawModifier, interfaceC3750qp);
        }

        @Deprecated
        public static boolean any(DrawModifier drawModifier, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "predicate");
            return ZB.b(drawModifier, interfaceC3750qp);
        }

        @Deprecated
        public static <R> R foldIn(DrawModifier drawModifier, R r, InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
            return (R) ZB.c(drawModifier, r, interfaceC0526Fp);
        }

        @Deprecated
        public static <R> R foldOut(DrawModifier drawModifier, R r, InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
            return (R) ZB.d(drawModifier, r, interfaceC0526Fp);
        }

        @Deprecated
        public static Modifier then(DrawModifier drawModifier, Modifier modifier) {
            AbstractC4492zt.h(modifier, "other");
            return YB.a(drawModifier, modifier);
        }
    }

    void draw(ContentDrawScope contentDrawScope);
}
