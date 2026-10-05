package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class WrapContentElement$Companion$size$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ Alignment $align;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WrapContentElement$Companion$size$1(Alignment alignment) {
        super(2);
        this.$align = alignment;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return IntOffset.m5269boximpl(m585invoke5SAbXVA(((IntSize) obj).m5324unboximpl(), (LayoutDirection) obj2));
    }

    /* JADX INFO: renamed from: invoke-5SAbXVA, reason: not valid java name */
    public final long m585invoke5SAbXVA(long j, LayoutDirection layoutDirection) {
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        return this.$align.mo2684alignKFBX0sM(IntSize.Companion.m5325getZeroYbymL2g(), j, layoutDirection);
    }
}
