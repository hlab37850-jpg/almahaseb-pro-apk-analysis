package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import defpackage.YB;
import defpackage.ZB;

/* JADX INFO: loaded from: classes.dex */
public interface ParentDataModifier extends Modifier.Element {

    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(ParentDataModifier parentDataModifier, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "predicate");
            return ZB.a(parentDataModifier, interfaceC3750qp);
        }

        @Deprecated
        public static boolean any(ParentDataModifier parentDataModifier, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "predicate");
            return ZB.b(parentDataModifier, interfaceC3750qp);
        }

        @Deprecated
        public static <R> R foldIn(ParentDataModifier parentDataModifier, R r, InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
            return (R) ZB.c(parentDataModifier, r, interfaceC0526Fp);
        }

        @Deprecated
        public static <R> R foldOut(ParentDataModifier parentDataModifier, R r, InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
            return (R) ZB.d(parentDataModifier, r, interfaceC0526Fp);
        }

        @Deprecated
        public static Modifier then(ParentDataModifier parentDataModifier, Modifier modifier) {
            AbstractC4492zt.h(modifier, "other");
            return YB.a(parentDataModifier, modifier);
        }
    }

    Object modifyParentData(Density density, Object obj);
}
