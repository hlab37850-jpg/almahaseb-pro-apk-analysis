package androidx.compose.foundation;

import defpackage.AbstractC1210aB;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3871sJ;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ScrollState$scrollableState$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ ScrollState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollState$scrollableState$1(ScrollState scrollState) {
        super(1);
        this.this$0 = scrollState;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).floatValue());
    }

    public final Float invoke(float f) {
        float value = this.this$0.getValue() + f + this.this$0.accumulator;
        float fK = AbstractC3871sJ.k(value, 0.0f, this.this$0.getMaxValue());
        boolean z = value == fK;
        float value2 = fK - this.this$0.getValue();
        int iC = AbstractC1210aB.c(value2);
        ScrollState scrollState = this.this$0;
        scrollState.setValue(scrollState.getValue() + iC);
        this.this$0.accumulator = value2 - iC;
        if (!z) {
            f = value2;
        }
        return Float.valueOf(f);
    }
}
