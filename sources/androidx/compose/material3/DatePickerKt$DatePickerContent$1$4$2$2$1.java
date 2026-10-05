package androidx.compose.material3;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.O8;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
public final class DatePickerKt$DatePickerContent$1$4$2$2$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ InterfaceC2052dg $coroutineScope;
    final /* synthetic */ LazyListState $monthsListState;
    final /* synthetic */ StateData $stateData;
    final /* synthetic */ MutableState<Boolean> $yearPickerVisible$delegate;

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2$2$1$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2$2$1$1", f = "DatePicker.kt", l = {1212}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ LazyListState $monthsListState;
        final /* synthetic */ StateData $stateData;
        final /* synthetic */ int $year;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StateData stateData, LazyListState lazyListState, int i, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$stateData = stateData;
            this.$monthsListState = lazyListState;
            this.$year = i;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass1(this.$stateData, this.$monthsListState, this.$year, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                StateData stateData = this.$stateData;
                LazyListState lazyListState = this.$monthsListState;
                int iB = (((this.$year - stateData.getYearRange().b()) * 12) + stateData.getDisplayedMonth().getMonth()) - 1;
                this.label = 1;
                if (LazyListState.scrollToItem$default(lazyListState, iB, 0, this, 2, null) == objD) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatePickerKt$DatePickerContent$1$4$2$2$1(InterfaceC2052dg interfaceC2052dg, MutableState<Boolean> mutableState, StateData stateData, LazyListState lazyListState) {
        super(1);
        this.$coroutineScope = interfaceC2052dg;
        this.$yearPickerVisible$delegate = mutableState;
        this.$stateData = stateData;
        this.$monthsListState = lazyListState;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return FW.a;
    }

    public final void invoke(int i) {
        MutableState<Boolean> mutableState = this.$yearPickerVisible$delegate;
        DatePickerKt.DatePickerContent$lambda$6(mutableState, !DatePickerKt.DatePickerContent$lambda$5(mutableState));
        O8.d(this.$coroutineScope, null, null, new AnonymousClass1(this.$stateData, this.$monthsListState, i, null), 3, null);
    }
}
