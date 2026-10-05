package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0789Ob;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SliderKt$RangeSliderImpl$onValueChangeState$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ InterfaceC3750qp $onValueChange;
    final /* synthetic */ InterfaceC0789Ob $value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SliderKt$RangeSliderImpl$onValueChangeState$1$1(InterfaceC0789Ob interfaceC0789Ob, InterfaceC3750qp interfaceC3750qp) {
        super(1);
        this.$value = interfaceC0789Ob;
        this.$onValueChange = interfaceC3750qp;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InterfaceC0789Ob) obj);
        return FW.a;
    }

    public final void invoke(InterfaceC0789Ob interfaceC0789Ob) {
        AbstractC4492zt.h(interfaceC0789Ob, "it");
        if (AbstractC4492zt.d(interfaceC0789Ob, this.$value)) {
            return;
        }
        this.$onValueChange.invoke(interfaceC0789Ob);
    }
}
