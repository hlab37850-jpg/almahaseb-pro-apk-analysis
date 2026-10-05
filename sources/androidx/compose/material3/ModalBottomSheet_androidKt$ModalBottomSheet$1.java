package androidx.compose.material3;

import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.O8;
import defpackage.XS;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes.dex */
public final class ModalBottomSheet_androidKt$ModalBottomSheet$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ InterfaceC3588op $onDismissRequest;
    final /* synthetic */ InterfaceC2052dg $scope;
    final /* synthetic */ SheetState $sheetState;

    /* JADX INFO: renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1$1", f = "ModalBottomSheet.android.kt", l = {ShapeTypes.ACTION_BUTTON_SOUND}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ SheetState $sheetState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SheetState sheetState, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$sheetState = sheetState;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass1(this.$sheetState, interfaceC0793Of);
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
                SheetState sheetState = this.$sheetState;
                this.label = 1;
                if (sheetState.partialExpand(this) == objD) {
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

    /* JADX INFO: renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1$2", f = "ModalBottomSheet.android.kt", l = {ShapeTypes.GEAR_6}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ SheetState $sheetState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(SheetState sheetState, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$sheetState = sheetState;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass2(this.$sheetState, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass2) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                SheetState sheetState = this.$sheetState;
                this.label = 1;
                if (sheetState.hide(this) == objD) {
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

    /* JADX INFO: renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3588op $onDismissRequest;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(InterfaceC3588op interfaceC3588op) {
            super(1);
            this.$onDismissRequest = interfaceC3588op;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return FW.a;
        }

        public final void invoke(Throwable th) {
            this.$onDismissRequest.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModalBottomSheet_androidKt$ModalBottomSheet$1(SheetState sheetState, InterfaceC2052dg interfaceC2052dg, InterfaceC3588op interfaceC3588op) {
        super(0);
        this.$sheetState = sheetState;
        this.$scope = interfaceC2052dg;
        this.$onDismissRequest = interfaceC3588op;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m1650invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1650invoke() {
        if (this.$sheetState.getCurrentValue() == SheetValue.Expanded && this.$sheetState.getHasPartiallyExpandedState()) {
            O8.d(this.$scope, null, null, new AnonymousClass1(this.$sheetState, null), 3, null);
        } else {
            O8.d(this.$scope, null, null, new AnonymousClass2(this.$sheetState, null), 3, null).C(new AnonymousClass3(this.$onDismissRequest));
        }
    }
}
