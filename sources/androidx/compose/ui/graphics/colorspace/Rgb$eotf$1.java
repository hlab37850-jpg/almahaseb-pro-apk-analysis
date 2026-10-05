package androidx.compose.ui.graphics.colorspace;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC3871sJ;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class Rgb$eotf$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ Rgb this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Rgb$eotf$1(Rgb rgb) {
        super(1);
        this.this$0 = rgb;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).doubleValue());
    }

    public final Double invoke(double d) {
        return Double.valueOf(this.this$0.getEotfOrig$ui_graphics_release().invoke(AbstractC3871sJ.j(d, this.this$0.min, this.this$0.max)));
    }
}
