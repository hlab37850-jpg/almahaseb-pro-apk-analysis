package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC3795rO;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import defpackage.YB;
import defpackage.ZB;

/* JADX INFO: loaded from: classes.dex */
public interface SemanticsModifier extends Modifier.Element {

    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(SemanticsModifier semanticsModifier, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "predicate");
            return ZB.a(semanticsModifier, interfaceC3750qp);
        }

        @Deprecated
        public static boolean any(SemanticsModifier semanticsModifier, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "predicate");
            return ZB.b(semanticsModifier, interfaceC3750qp);
        }

        @Deprecated
        public static <R> R foldIn(SemanticsModifier semanticsModifier, R r, InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
            return (R) ZB.c(semanticsModifier, r, interfaceC0526Fp);
        }

        @Deprecated
        public static <R> R foldOut(SemanticsModifier semanticsModifier, R r, InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
            return (R) ZB.d(semanticsModifier, r, interfaceC0526Fp);
        }

        @Deprecated
        public static int getId(SemanticsModifier semanticsModifier) {
            return AbstractC3795rO.a(semanticsModifier);
        }

        public static /* synthetic */ void getId$annotations() {
        }

        @Deprecated
        public static Modifier then(SemanticsModifier semanticsModifier, Modifier modifier) {
            AbstractC4492zt.h(modifier, "other");
            return YB.a(semanticsModifier, modifier);
        }
    }

    int getId();

    SemanticsConfiguration getSemanticsConfiguration();
}
