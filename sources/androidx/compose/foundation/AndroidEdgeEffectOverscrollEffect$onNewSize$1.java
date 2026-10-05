package androidx.compose.foundation;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidEdgeEffectOverscrollEffect$onNewSize$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ AndroidEdgeEffectOverscrollEffect this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidEdgeEffectOverscrollEffect$onNewSize$1(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect) {
        super(1);
        this.this$0 = androidEdgeEffectOverscrollEffect;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m163invokeozmzZPI(((IntSize) obj).m5324unboximpl());
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
    public final void m163invokeozmzZPI(long j) {
        boolean zM2863equalsimpl0 = Size.m2863equalsimpl0(IntSizeKt.m5330toSizeozmzZPI(j), this.this$0.containerSize);
        this.this$0.containerSize = IntSizeKt.m5330toSizeozmzZPI(j);
        if (!zM2863equalsimpl0) {
            this.this$0.topEffect.setSize(IntSize.m5320getWidthimpl(j), IntSize.m5319getHeightimpl(j));
            this.this$0.bottomEffect.setSize(IntSize.m5320getWidthimpl(j), IntSize.m5319getHeightimpl(j));
            this.this$0.leftEffect.setSize(IntSize.m5319getHeightimpl(j), IntSize.m5320getWidthimpl(j));
            this.this$0.rightEffect.setSize(IntSize.m5319getHeightimpl(j), IntSize.m5320getWidthimpl(j));
            this.this$0.topEffectNegation.setSize(IntSize.m5320getWidthimpl(j), IntSize.m5319getHeightimpl(j));
            this.this$0.bottomEffectNegation.setSize(IntSize.m5320getWidthimpl(j), IntSize.m5319getHeightimpl(j));
            this.this$0.leftEffectNegation.setSize(IntSize.m5319getHeightimpl(j), IntSize.m5320getWidthimpl(j));
            this.this$0.rightEffectNegation.setSize(IntSize.m5319getHeightimpl(j), IntSize.m5320getWidthimpl(j));
        }
        if (zM2863equalsimpl0) {
            return;
        }
        this.this$0.invalidateOverscroll();
        this.this$0.animateToRelease();
    }
}
