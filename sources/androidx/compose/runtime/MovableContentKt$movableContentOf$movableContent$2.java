package androidx.compose.runtime;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;
import defpackage.FW;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0578Hp;

/* JADX INFO: loaded from: classes.dex */
public final class MovableContentKt$movableContentOf$movableContent$2 extends AbstractC2233fv implements InterfaceC0552Gp {
    final /* synthetic */ InterfaceC0578Hp $content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovableContentKt$movableContentOf$movableContent$2(InterfaceC0578Hp interfaceC0578Hp) {
        super(3);
        this.$content = interfaceC0578Hp;
    }

    @Override // defpackage.InterfaceC0552Gp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((C2020dG) obj, (Composer) obj2, ((Number) obj3).intValue());
        return FW.a;
    }

    @Composable
    public final void invoke(C2020dG c2020dG, Composer composer, int i) {
        int i2;
        AbstractC4492zt.h(c2020dG, "it");
        if ((i & 14) == 0) {
            i2 = (composer.changed(c2020dG) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 91) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1849814513, i, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:87)");
        }
        this.$content.invoke(c2020dG.c(), c2020dG.e(), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
