package androidx.compose.ui.layout;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3750qp;
import defpackage.YB;
import defpackage.ZB;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalComposeUiApi
public interface RelocationModifier extends Modifier.Element {

    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(RelocationModifier relocationModifier, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "predicate");
            return ZB.a(relocationModifier, interfaceC3750qp);
        }

        @Deprecated
        public static boolean any(RelocationModifier relocationModifier, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "predicate");
            return ZB.b(relocationModifier, interfaceC3750qp);
        }

        @Deprecated
        public static <R> R foldIn(RelocationModifier relocationModifier, R r, InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
            return (R) ZB.c(relocationModifier, r, interfaceC0526Fp);
        }

        @Deprecated
        public static <R> R foldOut(RelocationModifier relocationModifier, R r, InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
            return (R) ZB.d(relocationModifier, r, interfaceC0526Fp);
        }

        @Deprecated
        public static Modifier then(RelocationModifier relocationModifier, Modifier modifier) {
            AbstractC4492zt.h(modifier, "other");
            return YB.a(relocationModifier, modifier);
        }
    }

    Rect computeDestination(Rect rect, LayoutCoordinates layoutCoordinates);

    Object performRelocation(Rect rect, Rect rect2, InterfaceC0793Of interfaceC0793Of);
}
