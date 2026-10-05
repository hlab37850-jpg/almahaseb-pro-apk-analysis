package androidx.compose.animation;

import androidx.compose.ui.layout.Placeable;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AnimatedContentTransitionScopeImpl$SizeModifier$measure$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ long $offset;
    final /* synthetic */ Placeable $placeable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimatedContentTransitionScopeImpl$SizeModifier$measure$1(Placeable placeable, long j) {
        super(1);
        this.$placeable = placeable;
        this.$offset = j;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return FW.a;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        AbstractC4492zt.h(placementScope, "$this$layout");
        Placeable.PlacementScope.m4203place70tqf50$default(placementScope, this.$placeable, this.$offset, 0.0f, 2, null);
    }
}
