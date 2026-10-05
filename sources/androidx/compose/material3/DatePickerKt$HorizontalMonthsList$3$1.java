package androidx.compose.material3;

import androidx.compose.foundation.lazy.LazyListState;
import defpackage.AbstractC0378Bt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.material3.DatePickerKt$HorizontalMonthsList$3$1", f = "DatePicker.kt", l = {1325}, m = "invokeSuspend")
public final class DatePickerKt$HorizontalMonthsList$3$1 extends XS implements InterfaceC0526Fp {
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ StateData $stateData;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatePickerKt$HorizontalMonthsList$3$1(LazyListState lazyListState, StateData stateData, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.$lazyListState = lazyListState;
        this.$stateData = stateData;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        return new DatePickerKt$HorizontalMonthsList$3$1(this.$lazyListState, this.$stateData, interfaceC0793Of);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
        return ((DatePickerKt$HorizontalMonthsList$3$1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i == 0) {
            LL.b(obj);
            LazyListState lazyListState = this.$lazyListState;
            StateData stateData = this.$stateData;
            this.label = 1;
            if (DatePickerKt.updateDisplayedMonth(lazyListState, stateData, this) == objD) {
                return objD;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
        }
        return FW.a;
    }
}
