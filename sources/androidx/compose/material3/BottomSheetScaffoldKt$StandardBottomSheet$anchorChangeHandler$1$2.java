package androidx.compose.material3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.text.Jpeg;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
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
public final class BottomSheetScaffoldKt$StandardBottomSheet$anchorChangeHandler$1$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ InterfaceC2052dg $scope;
    final /* synthetic */ SheetState $state;

    /* JADX INFO: renamed from: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$anchorChangeHandler$1$2$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$anchorChangeHandler$1$2$1", f = "BottomSheetScaffold.kt", l = {Jpeg.M_APP2}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ SheetState $state;
        final /* synthetic */ SheetValue $target;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SheetState sheetState, SheetValue sheetValue, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$state = sheetState;
            this.$target = sheetValue;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass1(this.$state, this.$target, interfaceC0793Of);
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
                SwipeableV2State<SheetValue> swipeableState$material3_release = this.$state.getSwipeableState$material3_release();
                SheetValue sheetValue = this.$target;
                this.label = 1;
                if (swipeableState$material3_release.snapTo(sheetValue, this) == objD) {
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
    public BottomSheetScaffoldKt$StandardBottomSheet$anchorChangeHandler$1$2(InterfaceC2052dg interfaceC2052dg, SheetState sheetState) {
        super(1);
        this.$scope = interfaceC2052dg;
        this.$state = sheetState;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SheetValue) obj);
        return FW.a;
    }

    public final void invoke(SheetValue sheetValue) {
        AbstractC4492zt.h(sheetValue, TypedValues.AttributesType.S_TARGET);
        O8.d(this.$scope, null, null, new AnonymousClass1(this.$state, sheetValue, null), 3, null);
    }
}
