package androidx.compose.runtime;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
public final class MovableContentKt$movableContentOf$movableContent$1 extends AbstractC2233fv implements InterfaceC0552Gp {
    final /* synthetic */ InterfaceC0526Fp $content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovableContentKt$movableContentOf$movableContent$1(InterfaceC0526Fp interfaceC0526Fp) {
        super(3);
        this.$content = interfaceC0526Fp;
    }

    @Override // defpackage.InterfaceC0552Gp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((FW) obj, (Composer) obj2, ((Number) obj3).intValue());
        return FW.a;
    }

    @Composable
    public final void invoke(FW fw, Composer composer, int i) {
        AbstractC4492zt.h(fw, "it");
        if ((i & 81) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1079330685, i, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:37)");
        }
        this.$content.mo13invoke(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
