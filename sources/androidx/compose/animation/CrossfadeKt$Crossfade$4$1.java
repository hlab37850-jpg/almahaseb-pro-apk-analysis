package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class CrossfadeKt$Crossfade$4$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ Transition<T> $this_Crossfade;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CrossfadeKt$Crossfade$4$1(Transition<T> transition) {
        super(1);
        this.$this_Crossfade = transition;
    }

    @Override // defpackage.InterfaceC3750qp
    public final Boolean invoke(T t) {
        return Boolean.valueOf(!AbstractC4492zt.d(t, this.$this_Crossfade.getTargetState()));
    }
}
