package androidx.compose.runtime;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;
import defpackage.FW;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0630Jp;

/* JADX INFO: loaded from: classes.dex */
public final class MovableContentKt$movableContentOf$movableContent$4 extends AbstractC2233fv implements InterfaceC0552Gp {
    final /* synthetic */ InterfaceC0630Jp $content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovableContentKt$movableContentOf$movableContent$4(InterfaceC0630Jp interfaceC0630Jp) {
        super(3);
        this.$content = interfaceC0630Jp;
    }

    @Override // defpackage.InterfaceC0552Gp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((C2020dG) obj, (Composer) obj2, ((Number) obj3).intValue());
        return FW.a;
    }

    @Composable
    public final void invoke(C2020dG c2020dG, Composer composer, int i) {
        AbstractC4492zt.h(c2020dG, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1876318581, i, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:143)");
        }
        this.$content.invoke(((C2020dG) c2020dG.c()).c(), ((C2020dG) c2020dG.c()).e(), ((C2020dG) c2020dG.e()).c(), ((C2020dG) c2020dG.e()).e(), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
