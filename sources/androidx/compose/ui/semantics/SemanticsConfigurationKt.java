package androidx.compose.ui.semantics;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class SemanticsConfigurationKt {

    /* JADX INFO: renamed from: androidx.compose.ui.semantics.SemanticsConfigurationKt$getOrNull$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // defpackage.InterfaceC3588op
        public final T invoke() {
            return null;
        }
    }

    public static final <T> T getOrNull(SemanticsConfiguration semanticsConfiguration, SemanticsPropertyKey<T> semanticsPropertyKey) {
        AbstractC4492zt.h(semanticsConfiguration, "<this>");
        AbstractC4492zt.h(semanticsPropertyKey, "key");
        return (T) semanticsConfiguration.getOrElseNullable(semanticsPropertyKey, AnonymousClass1.INSTANCE);
    }
}
