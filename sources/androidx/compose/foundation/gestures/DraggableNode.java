package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.unit.Velocity;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC2287gb;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC1009Wa;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.RG;

/* JADX INFO: loaded from: classes.dex */
public final class DraggableNode extends DelegatingNode implements PointerInputModifierNode {
    private final InterfaceC3750qp _canDrag;
    private final InterfaceC3588op _startDragImmediately;
    private InterfaceC3750qp canDrag;
    private final InterfaceC1009Wa channel;
    private DragInteraction.Start dragInteraction;
    private boolean enabled;
    private MutableInteractionSource interactionSource;
    private InterfaceC0552Gp onDragStarted;
    private InterfaceC0552Gp onDragStopped;
    private Orientation orientation;
    private final SuspendingPointerInputModifierNode pointerInputNode;
    private boolean reverseDirection;
    private InterfaceC3588op startDragImmediately;
    private DraggableState state;
    private final VelocityTracker velocityTracker;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableNode$processDragCancel$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.DraggableNode", f = "Draggable.kt", l = {451, 454}, m = "processDragCancel")
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
            return DraggableNode.this.processDragCancel(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableNode$processDragStart$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.DraggableNode", f = "Draggable.kt", l = {433, 436, 438}, m = "processDragStart")
    public static final class C13211 extends AbstractC0819Pf {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C13211(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DraggableNode.this.processDragStart(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableNode$processDragStop$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.DraggableNode", f = "Draggable.kt", l = {443, 446}, m = "processDragStop")
    public static final class C13221 extends AbstractC0819Pf {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C13221(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DraggableNode.this.processDragStop(null, null, this);
        }
    }

    public DraggableNode(DraggableState draggableState, InterfaceC3750qp interfaceC3750qp, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, InterfaceC3588op interfaceC3588op, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0552Gp interfaceC0552Gp2, boolean z2) {
        AbstractC4492zt.h(draggableState, "state");
        AbstractC4492zt.h(interfaceC3750qp, "canDrag");
        AbstractC4492zt.h(orientation, "orientation");
        AbstractC4492zt.h(interfaceC3588op, "startDragImmediately");
        AbstractC4492zt.h(interfaceC0552Gp, "onDragStarted");
        AbstractC4492zt.h(interfaceC0552Gp2, "onDragStopped");
        this.state = draggableState;
        this.canDrag = interfaceC3750qp;
        this.orientation = orientation;
        this.enabled = z;
        this.interactionSource = mutableInteractionSource;
        this.startDragImmediately = interfaceC3588op;
        this.onDragStarted = interfaceC0552Gp;
        this.onDragStopped = interfaceC0552Gp2;
        this.reverseDirection = z2;
        this._canDrag = new DraggableNode$_canDrag$1(this);
        this._startDragImmediately = new DraggableNode$_startDragImmediately$1(this);
        this.velocityTracker = new VelocityTracker();
        this.pointerInputNode = (SuspendingPointerInputModifierNode) delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new DraggableNode$pointerInputNode$1(this, null)));
        this.channel = AbstractC2287gb.b(Integer.MAX_VALUE, null, null, 6, null);
    }

    private final void disposeInteractionSource() {
        DragInteraction.Start start = this.dragInteraction;
        if (start != null) {
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            if (mutableInteractionSource != null) {
                mutableInteractionSource.tryEmit(new DragInteraction.Cancel(start));
            }
            this.dragInteraction = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:28:0x007b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object processDragCancel(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        AnonymousClass1 anonymousClass1;
        DraggableNode draggableNode;
        InterfaceC0552Gp interfaceC0552Gp;
        Velocity velocityM5376boximpl;
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
        if (i2 != 0) {
            if (i2 == 1) {
                interfaceC2052dg = (InterfaceC2052dg) anonymousClass1.L$1;
                draggableNode = (DraggableNode) anonymousClass1.L$0;
                LL.b(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return FW.a;
        }
        LL.b(obj);
        DragInteraction.Start start = this.dragInteraction;
        if (start != null) {
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            if (mutableInteractionSource != null) {
                DragInteraction.Cancel cancel = new DragInteraction.Cancel(start);
                anonymousClass1.L$0 = this;
                anonymousClass1.L$1 = interfaceC2052dg;
                anonymousClass1.label = 1;
                if (mutableInteractionSource.emit(cancel, anonymousClass1) == objD) {
                    return objD;
                }
            }
            draggableNode = this;
        } else {
            draggableNode = this;
        }
        interfaceC0552Gp = draggableNode.onDragStopped;
        velocityM5376boximpl = Velocity.m5376boximpl(Velocity.Companion.m5396getZero9UxMQ8M());
        anonymousClass1.L$0 = null;
        anonymousClass1.L$1 = null;
        anonymousClass1.label = 2;
        if (interfaceC0552Gp.invoke(interfaceC2052dg, velocityM5376boximpl, anonymousClass1) == objD) {
            return objD;
        }
        return FW.a;
        draggableNode.dragInteraction = null;
        interfaceC0552Gp = draggableNode.onDragStopped;
        velocityM5376boximpl = Velocity.m5376boximpl(Velocity.Companion.m5396getZero9UxMQ8M());
        anonymousClass1.L$0 = null;
        anonymousClass1.L$1 = null;
        anonymousClass1.label = 2;
        if (interfaceC0552Gp.invoke(interfaceC2052dg, velocityM5376boximpl, anonymousClass1) == objD) {
            return objD;
        }
        return FW.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:35:0x00ba A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object processDragStart(InterfaceC2052dg interfaceC2052dg, DragEvent.DragStarted dragStarted, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        C13211 c13211;
        DraggableNode draggableNode;
        MutableInteractionSource mutableInteractionSource;
        DragInteraction.Start start;
        DraggableNode draggableNode2;
        InterfaceC2052dg interfaceC2052dg2;
        DragInteraction.Start start2;
        InterfaceC0552Gp interfaceC0552Gp;
        Offset offsetM2787boximpl;
        if (interfaceC0793Of instanceof C13211) {
            c13211 = (C13211) interfaceC0793Of;
            int i = c13211.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c13211.label = i - Integer.MIN_VALUE;
            } else {
                c13211 = new C13211(interfaceC0793Of);
            }
        } else {
            c13211 = new C13211(interfaceC0793Of);
        }
        Object obj = c13211.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = c13211.label;
        if (i2 != 0) {
            if (i2 == 1) {
                dragStarted = (DragEvent.DragStarted) c13211.L$2;
                interfaceC2052dg = (InterfaceC2052dg) c13211.L$1;
                draggableNode = (DraggableNode) c13211.L$0;
                LL.b(obj);
            } else if (i2 == 2) {
                start2 = (DragInteraction.Start) c13211.L$3;
                dragStarted = (DragEvent.DragStarted) c13211.L$2;
                interfaceC2052dg2 = (InterfaceC2052dg) c13211.L$1;
                draggableNode2 = (DraggableNode) c13211.L$0;
                LL.b(obj);
                start = start2;
                interfaceC2052dg = interfaceC2052dg2;
                draggableNode = draggableNode2;
                draggableNode.dragInteraction = start;
                interfaceC0552Gp = draggableNode.onDragStarted;
                offsetM2787boximpl = Offset.m2787boximpl(dragStarted.m265getStartPointF1C5BW0());
                c13211.L$0 = null;
                c13211.L$1 = null;
                c13211.L$2 = null;
                c13211.L$3 = null;
                c13211.label = 3;
                if (interfaceC0552Gp.invoke(interfaceC2052dg, offsetM2787boximpl, c13211) == objD) {
                    return objD;
                }
            } else {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return FW.a;
        }
        LL.b(obj);
        DragInteraction.Start start3 = this.dragInteraction;
        if (start3 != null && (mutableInteractionSource = this.interactionSource) != null) {
            DragInteraction.Cancel cancel = new DragInteraction.Cancel(start3);
            c13211.L$0 = this;
            c13211.L$1 = interfaceC2052dg;
            c13211.L$2 = dragStarted;
            c13211.label = 1;
            if (mutableInteractionSource.emit(cancel, c13211) == objD) {
                return objD;
            }
        }
        draggableNode = this;
        start = new DragInteraction.Start();
        MutableInteractionSource mutableInteractionSource2 = draggableNode.interactionSource;
        if (mutableInteractionSource2 != null) {
            c13211.L$0 = draggableNode;
            c13211.L$1 = interfaceC2052dg;
            c13211.L$2 = dragStarted;
            c13211.L$3 = start;
            c13211.label = 2;
            if (mutableInteractionSource2.emit(start, c13211) == objD) {
                return objD;
            }
            draggableNode2 = draggableNode;
            interfaceC2052dg2 = interfaceC2052dg;
            start2 = start;
            start = start2;
            interfaceC2052dg = interfaceC2052dg2;
            draggableNode = draggableNode2;
        }
        draggableNode.dragInteraction = start;
        interfaceC0552Gp = draggableNode.onDragStarted;
        offsetM2787boximpl = Offset.m2787boximpl(dragStarted.m265getStartPointF1C5BW0());
        c13211.L$0 = null;
        c13211.L$1 = null;
        c13211.L$2 = null;
        c13211.L$3 = null;
        c13211.label = 3;
        if (interfaceC0552Gp.invoke(interfaceC2052dg, offsetM2787boximpl, c13211) == objD) {
            return objD;
        }
        return FW.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:28:0x0082 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object processDragStop(InterfaceC2052dg interfaceC2052dg, DragEvent.DragStopped dragStopped, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        C13221 c13221;
        DraggableNode draggableNode;
        InterfaceC0552Gp interfaceC0552Gp;
        Velocity velocityM5376boximpl;
        if (interfaceC0793Of instanceof C13221) {
            c13221 = (C13221) interfaceC0793Of;
            int i = c13221.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c13221.label = i - Integer.MIN_VALUE;
            } else {
                c13221 = new C13221(interfaceC0793Of);
            }
        } else {
            c13221 = new C13221(interfaceC0793Of);
        }
        Object obj = c13221.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = c13221.label;
        if (i2 != 0) {
            if (i2 == 1) {
                dragStopped = (DragEvent.DragStopped) c13221.L$2;
                interfaceC2052dg = (InterfaceC2052dg) c13221.L$1;
                draggableNode = (DraggableNode) c13221.L$0;
                LL.b(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return FW.a;
        }
        LL.b(obj);
        DragInteraction.Start start = this.dragInteraction;
        if (start != null) {
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            if (mutableInteractionSource != null) {
                DragInteraction.Stop stop = new DragInteraction.Stop(start);
                c13221.L$0 = this;
                c13221.L$1 = interfaceC2052dg;
                c13221.L$2 = dragStopped;
                c13221.label = 1;
                if (mutableInteractionSource.emit(stop, c13221) == objD) {
                    return objD;
                }
            }
            draggableNode = this;
        } else {
            draggableNode = this;
        }
        interfaceC0552Gp = draggableNode.onDragStopped;
        velocityM5376boximpl = Velocity.m5376boximpl(dragStopped.m266getVelocity9UxMQ8M());
        c13221.L$0 = null;
        c13221.L$1 = null;
        c13221.L$2 = null;
        c13221.label = 2;
        if (interfaceC0552Gp.invoke(interfaceC2052dg, velocityM5376boximpl, c13221) == objD) {
            return objD;
        }
        return FW.a;
        draggableNode.dragInteraction = null;
        interfaceC0552Gp = draggableNode.onDragStopped;
        velocityM5376boximpl = Velocity.m5376boximpl(dragStopped.m266getVelocity9UxMQ8M());
        c13221.L$0 = null;
        c13221.L$1 = null;
        c13221.L$2 = null;
        c13221.label = 2;
        if (interfaceC0552Gp.invoke(interfaceC2052dg, velocityM5376boximpl, c13221) == objD) {
            return objD;
        }
        return FW.a;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return RG.a(this);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        this.pointerInputNode.onCancelPointerInput();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public /* synthetic */ void onDensityChange() {
        RG.b(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        disposeInteractionSource();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo150onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        AbstractC4492zt.h(pointerEvent, "pointerEvent");
        AbstractC4492zt.h(pointerEventPass, "pass");
        this.pointerInputNode.mo150onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public /* synthetic */ void onViewConfigurationChange() {
        RG.c(this);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public /* synthetic */ boolean sharePointerInputWithSiblings() {
        return RG.d(this);
    }

    public final void update(DraggableState draggableState, InterfaceC3750qp interfaceC3750qp, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, InterfaceC3588op interfaceC3588op, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0552Gp interfaceC0552Gp2, boolean z2) {
        boolean z3;
        AbstractC4492zt.h(draggableState, "state");
        AbstractC4492zt.h(interfaceC3750qp, "canDrag");
        AbstractC4492zt.h(orientation, "orientation");
        AbstractC4492zt.h(interfaceC3588op, "startDragImmediately");
        AbstractC4492zt.h(interfaceC0552Gp, "onDragStarted");
        AbstractC4492zt.h(interfaceC0552Gp2, "onDragStopped");
        boolean z4 = true;
        if (AbstractC4492zt.d(this.state, draggableState)) {
            z3 = false;
        } else {
            this.state = draggableState;
            z3 = true;
        }
        this.canDrag = interfaceC3750qp;
        if (this.orientation != orientation) {
            this.orientation = orientation;
            z3 = true;
        }
        if (this.enabled != z) {
            this.enabled = z;
            if (!z) {
                disposeInteractionSource();
            }
            z3 = true;
        }
        if (!AbstractC4492zt.d(this.interactionSource, mutableInteractionSource)) {
            disposeInteractionSource();
            this.interactionSource = mutableInteractionSource;
        }
        this.startDragImmediately = interfaceC3588op;
        this.onDragStarted = interfaceC0552Gp;
        this.onDragStopped = interfaceC0552Gp2;
        if (this.reverseDirection != z2) {
            this.reverseDirection = z2;
        } else {
            z4 = z3;
        }
        if (z4) {
            this.pointerInputNode.resetPointerInputHandler();
        }
    }
}
