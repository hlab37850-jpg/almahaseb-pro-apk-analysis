package androidx.compose.material3;

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
public final class TimePickerKt$TimeSelector$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ InterfaceC2052dg $scope;
    final /* synthetic */ int $selection;
    final /* synthetic */ TimePickerState $state;

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$TimeSelector$2$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.material3.TimePickerKt$TimeSelector$2$1", f = "TimePicker.kt", l = {1100}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ TimePickerState $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(TimePickerState timePickerState, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$state = timePickerState;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass1(this.$state, interfaceC0793Of);
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
                TimePickerState timePickerState = this.$state;
                this.label = 1;
                if (timePickerState.animateToCurrent$material3_release(this) == objD) {
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
    public TimePickerKt$TimeSelector$2(int i, TimePickerState timePickerState, InterfaceC2052dg interfaceC2052dg) {
        super(0);
        this.$selection = i;
        this.$state = timePickerState;
        this.$scope = interfaceC2052dg;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m1958invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1958invoke() {
        if (Selection.m1746equalsimpl0(this.$selection, this.$state.m1974getSelectionJiIwxys$material3_release())) {
            return;
        }
        this.$state.m1977setSelectioniHAOin8$material3_release(this.$selection);
        O8.d(this.$scope, null, null, new AnonymousClass1(this.$state, null), 3, null);
    }
}
