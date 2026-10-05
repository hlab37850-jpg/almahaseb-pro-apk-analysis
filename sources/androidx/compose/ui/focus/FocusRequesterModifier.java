package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import defpackage.YB;
import defpackage.ZB;

/* JADX INFO: loaded from: classes.dex */
public interface FocusRequesterModifier extends Modifier.Element {

    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(FocusRequesterModifier focusRequesterModifier, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "predicate");
            return ZB.a(focusRequesterModifier, interfaceC3750qp);
        }

        @Deprecated
        public static boolean any(FocusRequesterModifier focusRequesterModifier, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "predicate");
            return ZB.b(focusRequesterModifier, interfaceC3750qp);
        }

        @Deprecated
        public static <R> R foldIn(FocusRequesterModifier focusRequesterModifier, R r, InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
            return (R) ZB.c(focusRequesterModifier, r, interfaceC0526Fp);
        }

        @Deprecated
        public static <R> R foldOut(FocusRequesterModifier focusRequesterModifier, R r, InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
            return (R) ZB.d(focusRequesterModifier, r, interfaceC0526Fp);
        }

        @Deprecated
        public static Modifier then(FocusRequesterModifier focusRequesterModifier, Modifier modifier) {
            AbstractC4492zt.h(modifier, "other");
            return YB.a(focusRequesterModifier, modifier);
        }
    }

    FocusRequester getFocusRequester();
}
