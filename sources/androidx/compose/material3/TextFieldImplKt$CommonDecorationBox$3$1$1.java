package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class TextFieldImplKt$CommonDecorationBox$3$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ float $labelProgress;
    final /* synthetic */ MutableState<Size> $labelSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldImplKt$CommonDecorationBox$3$1$1(float f, MutableState<Size> mutableState) {
        super(1);
        this.$labelProgress = f;
        this.$labelSize = mutableState;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m1922invokeuvyYCjk(((Size) obj).m2872unboximpl());
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke-uvyYCjk, reason: not valid java name */
    public final void m1922invokeuvyYCjk(long j) {
        float fM2867getWidthimpl = Size.m2867getWidthimpl(j) * this.$labelProgress;
        float fM2864getHeightimpl = Size.m2864getHeightimpl(j) * this.$labelProgress;
        if (Size.m2867getWidthimpl(this.$labelSize.getValue().m2872unboximpl()) == fM2867getWidthimpl && Size.m2864getHeightimpl(this.$labelSize.getValue().m2872unboximpl()) == fM2864getHeightimpl) {
            return;
        }
        this.$labelSize.setValue(Size.m2855boximpl(SizeKt.Size(fM2867getWidthimpl, fM2864getHeightimpl)));
    }
}
