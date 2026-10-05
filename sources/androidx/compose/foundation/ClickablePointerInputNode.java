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

/* JADX INFO: loaded from: classes.dex */
final class ClickablePointerInputNode extends AbstractClickablePointerInputNode {

    /* JADX INFO: renamed from: androidx.compose.foundation.ClickablePointerInputNode$pointerInput$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.ClickablePointerInputNode$pointerInput$2", f = "Clickable.kt", l = {892}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0552Gp {
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(InterfaceC0793Of interfaceC0793Of) {
            super(3, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return m210invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).m2808unboximpl(), (InterfaceC0793Of) obj3);
        }

        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m210invoked4ec7I(PressGestureScope pressGestureScope, long j, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass2 anonymousClass2 = ClickablePointerInputNode.this.new AnonymousClass2(interfaceC0793Of);
            anonymousClass2.L$0 = pressGestureScope;
            anonymousClass2.J$0 = j;
            return anonymousClass2.invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                long j = this.J$0;
                if (ClickablePointerInputNode.this.getEnabled()) {
                    ClickablePointerInputNode clickablePointerInputNode = ClickablePointerInputNode.this;
                    this.label = 1;
                    if (clickablePointerInputNode.m155handlePressInteractiond4ec7I(pressGestureScope, j, this) == objD) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.ClickablePointerInputNode$pointerInput$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3750qp {
        public AnonymousClass3() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m211invokek4lQ0M(((Offset) obj).m2808unboximpl());
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
        public final void m211invokek4lQ0M(long j) {
            if (ClickablePointerInputNode.this.getEnabled()) {
                ClickablePointerInputNode.this.getOnClick().invoke();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickablePointerInputNode(boolean z, MutableInteractionSource mutableInteractionSource, InterfaceC3588op interfaceC3588op, AbstractClickableNode.InteractionData interactionData) {
        super(z, mutableInteractionSource, interfaceC3588op, interactionData, null);
        AbstractC4492zt.h(mutableInteractionSource, "interactionSource");
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interactionData, "interactionData");
    }

    @Override // androidx.compose.foundation.AbstractClickablePointerInputNode
    public Object pointerInput(PointerInputScope pointerInputScope, InterfaceC0793Of interfaceC0793Of) {
        AbstractClickableNode.InteractionData interactionData = getInteractionData();
        long jM5326getCenterozmzZPI = IntSizeKt.m5326getCenterozmzZPI(pointerInputScope.mo4077getSizeYbymL2g());
        interactionData.m154setCentreOffsetk4lQ0M(OffsetKt.Offset(IntOffset.m5278getXimpl(jM5326getCenterozmzZPI), IntOffset.m5279getYimpl(jM5326getCenterozmzZPI)));
        Object objDetectTapAndPress = TapGestureDetectorKt.detectTapAndPress(pointerInputScope, new AnonymousClass2(null), new AnonymousClass3(), interfaceC0793Of);
        return objDetectTapAndPress == AbstractC0378Bt.d() ? objDetectTapAndPress : FW.a;
    }

    public final void update(boolean z, MutableInteractionSource mutableInteractionSource, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(mutableInteractionSource, "interactionSource");
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        setEnabled(z);
        setOnClick(interfaceC3588op);
        setInteractionSource(mutableInteractionSource);
    }
}
