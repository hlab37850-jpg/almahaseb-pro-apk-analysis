package androidx.compose.material3;

import androidx.compose.foundation.lazy.LazyListState;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.LL;
import defpackage.O8;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
public final class DatePickerKt$DatePickerContent$1$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ InterfaceC2052dg $coroutineScope;
    final /* synthetic */ LazyListState $monthsListState;

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$DatePickerContent$1$2$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.material3.DatePickerKt$DatePickerContent$1$2$1", f = "DatePicker.kt", l = {1162}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ LazyListState $monthsListState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LazyListState lazyListState, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$monthsListState = lazyListState;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass1(this.$monthsListState, interfaceC0793Of);
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
                LazyListState lazyListState = this.$monthsListState;
                int firstVisibleItemIndex = lazyListState.getFirstVisibleItemIndex() - 1;
                this.label = 1;
                if (LazyListState.animateScrollToItem$default(lazyListState, firstVisibleItemIndex, 0, this, 2, null) == objD) {
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
    public DatePickerKt$DatePickerContent$1$2(InterfaceC2052dg interfaceC2052dg, LazyListState lazyListState) {
        super(0);
        this.$coroutineScope = interfaceC2052dg;
        this.$monthsListState = lazyListState;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m1505invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1505invoke() {
        O8.d(this.$coroutineScope, null, null, new AnonymousClass1(this.$monthsListState, null), 3, null);
    }
}
