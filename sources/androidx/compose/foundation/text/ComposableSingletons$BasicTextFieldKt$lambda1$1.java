package androidx.compose.foundation.text;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: renamed from: androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt$lambda-1$1, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
public final class ComposableSingletons$BasicTextFieldKt$lambda1$1 extends AbstractC2233fv implements InterfaceC0552Gp {
    public static final ComposableSingletons$BasicTextFieldKt$lambda1$1 INSTANCE = new ComposableSingletons$BasicTextFieldKt$lambda1$1();

    public ComposableSingletons$BasicTextFieldKt$lambda1$1() {
        super(3);
    }

    @Override // defpackage.InterfaceC0552Gp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((InterfaceC0526Fp) obj, (Composer) obj2, ((Number) obj3).intValue());
        return FW.a;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public final void invoke(InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        AbstractC4492zt.h(interfaceC0526Fp, "innerTextField");
        if ((i & 14) == 0) {
            i |= composer.changedInstance(interfaceC0526Fp) ? 4 : 2;
        }
        if ((i & 91) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(997835932, i, -1, "androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt.lambda-1.<anonymous> (BasicTextField.kt:139)");
        }
        interfaceC0526Fp.mo13invoke(composer, Integer.valueOf(i & 14));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
