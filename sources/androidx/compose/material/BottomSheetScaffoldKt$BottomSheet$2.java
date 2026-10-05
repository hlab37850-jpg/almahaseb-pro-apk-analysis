package androidx.compose.material;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
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

/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetScaffoldKt$BottomSheet$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ InterfaceC2052dg $scope;
    final /* synthetic */ BottomSheetState $state;

    /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ InterfaceC2052dg $scope;
        final /* synthetic */ BottomSheetState $state;

        /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC3252ki(c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1$1", f = "BottomSheetScaffold.kt", l = {MetaDo.META_SETMAPPERFLAGS}, m = "invokeSuspend")
        public static final class C00691 extends XS implements InterfaceC0526Fp {
            final /* synthetic */ BottomSheetState $state;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00691(BottomSheetState bottomSheetState, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$state = bottomSheetState;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                return new C00691(this.$state, interfaceC0793Of);
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                return ((C00691) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objD = AbstractC0378Bt.d();
                int i = this.label;
                if (i == 0) {
                    LL.b(obj);
                    BottomSheetState bottomSheetState = this.$state;
                    this.label = 1;
                    if (bottomSheetState.expand(this) == objD) {
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
        public AnonymousClass1(BottomSheetState bottomSheetState, InterfaceC2052dg interfaceC2052dg) {
            super(0);
            this.$state = bottomSheetState;
            this.$scope = interfaceC2052dg;
        }

        @Override // defpackage.InterfaceC3588op
        public final Boolean invoke() {
            if (((Boolean) this.$state.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(BottomSheetValue.Expanded)).booleanValue()) {
                O8.d(this.$scope, null, null, new C00691(this.$state, null), 3, null);
            }
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ InterfaceC2052dg $scope;
        final /* synthetic */ BottomSheetState $state;

        /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$2$1, reason: invalid class name */
        @InterfaceC3252ki(c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$2$1", f = "BottomSheetScaffold.kt", l = {568}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
            final /* synthetic */ BottomSheetState $state;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(BottomSheetState bottomSheetState, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$state = bottomSheetState;
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
                    BottomSheetState bottomSheetState = this.$state;
                    this.label = 1;
                    if (bottomSheetState.collapse(this) == objD) {
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
        public AnonymousClass2(BottomSheetState bottomSheetState, InterfaceC2052dg interfaceC2052dg) {
            super(0);
            this.$state = bottomSheetState;
            this.$scope = interfaceC2052dg;
        }

        @Override // defpackage.InterfaceC3588op
        public final Boolean invoke() {
            if (((Boolean) this.$state.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(BottomSheetValue.Collapsed)).booleanValue()) {
                O8.d(this.$scope, null, null, new AnonymousClass1(this.$state, null), 3, null);
            }
            return Boolean.TRUE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetScaffoldKt$BottomSheet$2(BottomSheetState bottomSheetState, InterfaceC2052dg interfaceC2052dg) {
        super(1);
        this.$state = bottomSheetState;
        this.$scope = interfaceC2052dg;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return FW.a;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        AbstractC4492zt.h(semanticsPropertyReceiver, "$this$semantics");
        if (this.$state.getAnchoredDraggableState$material_release().getAnchors$material_release().size() > 1) {
            if (this.$state.isCollapsed()) {
                SemanticsPropertiesKt.expand$default(semanticsPropertyReceiver, null, new AnonymousClass1(this.$state, this.$scope), 1, null);
            } else {
                SemanticsPropertiesKt.collapse$default(semanticsPropertyReceiver, null, new AnonymousClass2(this.$state, this.$scope), 1, null);
            }
        }
    }
}
