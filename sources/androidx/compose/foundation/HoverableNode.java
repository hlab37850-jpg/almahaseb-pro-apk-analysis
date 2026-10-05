package androidx.compose.foundation;

import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.node.PointerInputModifierNode;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import defpackage.O8;
import defpackage.RG;

/* JADX INFO: loaded from: classes.dex */
final class HoverableNode extends Modifier.Node implements PointerInputModifierNode {
    private HoverInteraction.Enter hoverInteraction;
    private MutableInteractionSource interactionSource;

    /* JADX INFO: renamed from: androidx.compose.foundation.HoverableNode$emitEnter$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.HoverableNode", f = "Hoverable.kt", l = {108}, m = "emitEnter")
    public static final class AnonymousClass1 extends AbstractC0819Pf {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HoverableNode.this.emitEnter(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.HoverableNode$emitExit$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.HoverableNode", f = "Hoverable.kt", l = {116}, m = "emitExit")
    public static final class C13061 extends AbstractC0819Pf {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C13061(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HoverableNode.this.emitExit(this);
        }
    }

    public HoverableNode(MutableInteractionSource mutableInteractionSource) {
        AbstractC4492zt.h(mutableInteractionSource, "interactionSource");
        this.interactionSource = mutableInteractionSource;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object emitEnter(InterfaceC0793Of interfaceC0793Of) throws Throwable {
        AnonymousClass1 anonymousClass1;
        HoverableNode hoverableNode;
        HoverInteraction.Enter enter;
        if (interfaceC0793Of instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) interfaceC0793Of;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
        }
        Object obj = anonymousClass1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            LL.b(obj);
            if (this.hoverInteraction == null) {
                HoverInteraction.Enter enter2 = new HoverInteraction.Enter();
                MutableInteractionSource mutableInteractionSource = this.interactionSource;
                anonymousClass1.L$0 = this;
                anonymousClass1.L$1 = enter2;
                anonymousClass1.label = 1;
                if (mutableInteractionSource.emit(enter2, anonymousClass1) == objD) {
                    return objD;
                }
                hoverableNode = this;
                enter = enter2;
            }
            return FW.a;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        enter = (HoverInteraction.Enter) anonymousClass1.L$1;
        hoverableNode = (HoverableNode) anonymousClass1.L$0;
        LL.b(obj);
        hoverableNode.hoverInteraction = enter;
        return FW.a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object emitExit(InterfaceC0793Of interfaceC0793Of) throws Throwable {
        C13061 c13061;
        HoverableNode hoverableNode;
        if (interfaceC0793Of instanceof C13061) {
            c13061 = (C13061) interfaceC0793Of;
            int i = c13061.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c13061.label = i - Integer.MIN_VALUE;
            } else {
                c13061 = new C13061(interfaceC0793Of);
            }
        } else {
            c13061 = new C13061(interfaceC0793Of);
        }
        Object obj = c13061.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = c13061.label;
        if (i2 == 0) {
            LL.b(obj);
            HoverInteraction.Enter enter = this.hoverInteraction;
            if (enter != null) {
                HoverInteraction.Exit exit = new HoverInteraction.Exit(enter);
                MutableInteractionSource mutableInteractionSource = this.interactionSource;
                c13061.L$0 = this;
                c13061.label = 1;
                if (mutableInteractionSource.emit(exit, c13061) == objD) {
                    return objD;
                }
                hoverableNode = this;
            }
            return FW.a;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        hoverableNode = (HoverableNode) c13061.L$0;
        LL.b(obj);
        hoverableNode.hoverInteraction = null;
        return FW.a;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return RG.a(this);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        tryEmitExit();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public /* synthetic */ void onDensityChange() {
        RG.b(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        tryEmitExit();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo150onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        AbstractC4492zt.h(pointerEvent, "pointerEvent");
        AbstractC4492zt.h(pointerEventPass, "pass");
        if (pointerEventPass == PointerEventPass.Main) {
            int iM3996getType7fucELk = pointerEvent.m3996getType7fucELk();
            PointerEventType.Companion companion = PointerEventType.Companion;
            if (PointerEventType.m4003equalsimpl0(iM3996getType7fucELk, companion.m4007getEnter7fucELk())) {
                O8.d(getCoroutineScope(), null, null, new HoverableNode$onPointerEvent$1(this, null), 3, null);
            } else if (PointerEventType.m4003equalsimpl0(iM3996getType7fucELk, companion.m4008getExit7fucELk())) {
                O8.d(getCoroutineScope(), null, null, new HoverableNode$onPointerEvent$2(this, null), 3, null);
            }
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public /* synthetic */ void onViewConfigurationChange() {
        RG.c(this);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public /* synthetic */ boolean sharePointerInputWithSiblings() {
        return RG.d(this);
    }

    public final void tryEmitExit() {
        HoverInteraction.Enter enter = this.hoverInteraction;
        if (enter != null) {
            this.interactionSource.tryEmit(new HoverInteraction.Exit(enter));
            this.hoverInteraction = null;
        }
    }

    public final void updateInteractionSource(MutableInteractionSource mutableInteractionSource) {
        AbstractC4492zt.h(mutableInteractionSource, "interactionSource");
        if (AbstractC4492zt.d(this.interactionSource, mutableInteractionSource)) {
            return;
        }
        tryEmitExit();
        this.interactionSource = mutableInteractionSource;
    }
}
