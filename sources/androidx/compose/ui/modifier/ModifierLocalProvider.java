package androidx.compose.ui.modifier;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import defpackage.YB;
import defpackage.ZB;

/* JADX INFO: loaded from: classes.dex */
@Stable
public interface ModifierLocalProvider<T> extends Modifier.Element {

    public static final class DefaultImpls {
        @Deprecated
        public static <T> boolean all(ModifierLocalProvider<T> modifierLocalProvider, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "predicate");
            return ZB.a(modifierLocalProvider, interfaceC3750qp);
        }

        @Deprecated
        public static <T> boolean any(ModifierLocalProvider<T> modifierLocalProvider, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "predicate");
            return ZB.b(modifierLocalProvider, interfaceC3750qp);
        }

        @Deprecated
        public static <T, R> R foldIn(ModifierLocalProvider<T> modifierLocalProvider, R r, InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
            return (R) ZB.c(modifierLocalProvider, r, interfaceC0526Fp);
        }

        @Deprecated
        public static <T, R> R foldOut(ModifierLocalProvider<T> modifierLocalProvider, R r, InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
            return (R) ZB.d(modifierLocalProvider, r, interfaceC0526Fp);
        }

        @Deprecated
        public static <T> Modifier then(ModifierLocalProvider<T> modifierLocalProvider, Modifier modifier) {
            AbstractC4492zt.h(modifier, "other");
            return YB.a(modifierLocalProvider, modifier);
        }
    }

    ProvidableModifierLocal<T> getKey();

    T getValue();
}
