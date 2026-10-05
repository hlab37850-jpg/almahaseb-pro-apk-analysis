package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import defpackage.YB;
import defpackage.ZB;

/* JADX INFO: loaded from: classes.dex */
public interface OnRemeasuredModifier extends Modifier.Element {

    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(OnRemeasuredModifier onRemeasuredModifier, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "predicate");
            return ZB.a(onRemeasuredModifier, interfaceC3750qp);
        }

        @Deprecated
        public static boolean any(OnRemeasuredModifier onRemeasuredModifier, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "predicate");
            return ZB.b(onRemeasuredModifier, interfaceC3750qp);
        }

        @Deprecated
        public static <R> R foldIn(OnRemeasuredModifier onRemeasuredModifier, R r, InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
            return (R) ZB.c(onRemeasuredModifier, r, interfaceC0526Fp);
        }

        @Deprecated
        public static <R> R foldOut(OnRemeasuredModifier onRemeasuredModifier, R r, InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
            return (R) ZB.d(onRemeasuredModifier, r, interfaceC0526Fp);
        }

        @Deprecated
        public static Modifier then(OnRemeasuredModifier onRemeasuredModifier, Modifier modifier) {
            AbstractC4492zt.h(modifier, "other");
            return YB.a(onRemeasuredModifier, modifier);
        }
    }

    /* JADX INFO: renamed from: onRemeasured-ozmzZPI */
    void mo261onRemeasuredozmzZPI(long j);
}
