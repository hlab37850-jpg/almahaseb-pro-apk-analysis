package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.XS;
import org.apache.poi.hpsf.Constants;

/* JADX INFO: loaded from: classes.dex */
final class CombinedClickablePointerInputNode extends AbstractClickablePointerInputNode {
    private InterfaceC3588op onDoubleClick;
    private InterfaceC3588op onLongClick;

    /* JADX INFO: renamed from: androidx.compose.foundation.CombinedClickablePointerInputNode$pointerInput$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        public AnonymousClass2() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m218invokek4lQ0M(((Offset) obj).m2808unboximpl());
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
        public final void m218invokek4lQ0M(long j) {
            InterfaceC3588op interfaceC3588op = CombinedClickablePointerInputNode.this.onDoubleClick;
            if (interfaceC3588op != null) {
                interfaceC3588op.invoke();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.CombinedClickablePointerInputNode$pointerInput$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3750qp {
        public AnonymousClass3() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m219invokek4lQ0M(((Offset) obj).m2808unboximpl());
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
        public final void m219invokek4lQ0M(long j) {
            InterfaceC3588op interfaceC3588op = CombinedClickablePointerInputNode.this.onLongClick;
            if (interfaceC3588op != null) {
                interfaceC3588op.invoke();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.CombinedClickablePointerInputNode$pointerInput$4, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.CombinedClickablePointerInputNode$pointerInput$4", f = "Clickable.kt", l = {Constants.CP_GBK}, m = "invokeSuspend")
    public static final class AnonymousClass4 extends XS implements InterfaceC0552Gp {
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass4(InterfaceC0793Of interfaceC0793Of) {
            super(3, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return m220invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).m2808unboximpl(), (InterfaceC0793Of) obj3);
        }

        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m220invoked4ec7I(PressGestureScope pressGestureScope, long j, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass4 anonymousClass4 = CombinedClickablePointerInputNode.this.new AnonymousClass4(interfaceC0793Of);
            anonymousClass4.L$0 = pressGestureScope;
            anonymousClass4.J$0 = j;
            return anonymousClass4.invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                long j = this.J$0;
                if (CombinedClickablePointerInputNode.this.getEnabled()) {
                    CombinedClickablePointerInputNode combinedClickablePointerInputNode = CombinedClickablePointerInputNode.this;
                    this.label = 1;
                    if (combinedClickablePointerInputNode.m155handlePressInteractiond4ec7I(pressGestureScope, j, this) == objD) {
                        return objD;
                    }
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

    /* JADX INFO: renamed from: androidx.compose.foundation.CombinedClickablePointerInputNode$pointerInput$5, reason: invalid class name */
    public static final class AnonymousClass5 extends AbstractC2233fv implements InterfaceC3750qp {
        public AnonymousClass5() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m221invokek4lQ0M(((Offset) obj).m2808unboximpl());
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
        public final void m221invokek4lQ0M(long j) {
            if (CombinedClickablePointerInputNode.this.getEnabled()) {
                CombinedClickablePointerInputNode.this.getOnClick().invoke();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombinedClickablePointerInputNode(boolean z, MutableInteractionSource mutableInteractionSource, InterfaceC3588op interfaceC3588op, AbstractClickableNode.InteractionData interactionData, InterfaceC3588op interfaceC3588op2, InterfaceC3588op interfaceC3588op3) {
        super(z, mutableInteractionSource, interfaceC3588op, interactionData, null);
        AbstractC4492zt.h(mutableInteractionSource, "interactionSource");
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interactionData, "interactionData");
        this.onLongClick = interfaceC3588op2;
        this.onDoubleClick = interfaceC3588op3;
    }

    @Override // androidx.compose.foundation.AbstractClickablePointerInputNode
    public Object pointerInput(PointerInputScope pointerInputScope, InterfaceC0793Of interfaceC0793Of) {
        AbstractClickableNode.InteractionData interactionData = getInteractionData();
        long jM5326getCenterozmzZPI = IntSizeKt.m5326getCenterozmzZPI(pointerInputScope.mo4077getSizeYbymL2g());
        interactionData.m154setCentreOffsetk4lQ0M(OffsetKt.Offset(IntOffset.m5278getXimpl(jM5326getCenterozmzZPI), IntOffset.m5279getYimpl(jM5326getCenterozmzZPI)));
        Object objDetectTapGestures = TapGestureDetectorKt.detectTapGestures(pointerInputScope, (!getEnabled() || this.onDoubleClick == null) ? null : new AnonymousClass2(), (!getEnabled() || this.onLongClick == null) ? null : new AnonymousClass3(), new AnonymousClass4(null), new AnonymousClass5(), interfaceC0793Of);
        return objDetectTapGestures == AbstractC0378Bt.d() ? objDetectTapGestures : FW.a;
    }

    public final void update(boolean z, MutableInteractionSource mutableInteractionSource, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, InterfaceC3588op interfaceC3588op3) {
        boolean z2;
        AbstractC4492zt.h(mutableInteractionSource, "interactionSource");
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        setOnClick(interfaceC3588op);
        setInteractionSource(mutableInteractionSource);
        if (getEnabled() != z) {
            setEnabled(z);
            z2 = true;
        } else {
            z2 = false;
        }
        if ((this.onLongClick == null) != (interfaceC3588op2 == null)) {
            z2 = true;
        }
        this.onLongClick = interfaceC3588op2;
        boolean z3 = (this.onDoubleClick == null) == (interfaceC3588op3 == null) ? z2 : true;
        this.onDoubleClick = interfaceC3588op3;
        if (z3) {
            resetPointerInputHandler();
        }
    }
}
