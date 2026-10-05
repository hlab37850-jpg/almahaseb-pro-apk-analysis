package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.unit.Velocity;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.E8;
import defpackage.FW;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.InterfaceC4038uO;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
public final class DraggableKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.DraggableKt", f = "Draggable.kt", l = {472, 481, 600, 650}, m = "awaitDownAndSlop")
    public static final class AnonymousClass1 extends AbstractC0819Pf {
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DraggableKt.awaitDownAndSlop(null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$1", f = "Draggable.kt", l = {}, m = "invokeSuspend")
    public static final class C13201 extends XS implements InterfaceC0552Gp {
        int label;

        public C13201(InterfaceC0793Of interfaceC0793Of) {
            super(3, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return m312invoked4ec7I((InterfaceC2052dg) obj, ((Offset) obj2).m2808unboximpl(), (InterfaceC0793Of) obj3);
        }

        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m312invoked4ec7I(InterfaceC2052dg interfaceC2052dg, long j, InterfaceC0793Of interfaceC0793Of) {
            return new C13201(interfaceC0793Of).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$2", f = "Draggable.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0552Gp {
        int label;

        public AnonymousClass2(InterfaceC0793Of interfaceC0793Of) {
            super(3, interfaceC0793Of);
        }

        public final Object invoke(InterfaceC2052dg interfaceC2052dg, float f, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass2(interfaceC0793Of).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            return FW.a;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((InterfaceC2052dg) obj, ((Number) obj2).floatValue(), (InterfaceC0793Of) obj3);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(PointerInputChange pointerInputChange) {
            AbstractC4492zt.h(pointerInputChange, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ boolean $startDragImmediately;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(boolean z) {
            super(0);
            this.$startDragImmediately = z;
        }

        @Override // defpackage.InterfaceC3588op
        public final Boolean invoke() {
            return Boolean.valueOf(this.$startDragImmediately);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$5, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$5", f = "Draggable.kt", l = {194}, m = "invokeSuspend")
    public static final class AnonymousClass5 extends XS implements InterfaceC0552Gp {
        final /* synthetic */ InterfaceC0552Gp $onDragStopped;
        final /* synthetic */ Orientation $orientation;
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(InterfaceC0552Gp interfaceC0552Gp, Orientation orientation, InterfaceC0793Of interfaceC0793Of) {
            super(3, interfaceC0793Of);
            this.$onDragStopped = interfaceC0552Gp;
            this.$orientation = orientation;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return m313invokeLuvzFrg((InterfaceC2052dg) obj, ((Velocity) obj2).m5394unboximpl(), (InterfaceC0793Of) obj3);
        }

        /* JADX INFO: renamed from: invoke-LuvzFrg, reason: not valid java name */
        public final Object m313invokeLuvzFrg(InterfaceC2052dg interfaceC2052dg, long j, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(this.$onDragStopped, this.$orientation, interfaceC0793Of);
            anonymousClass5.L$0 = interfaceC2052dg;
            anonymousClass5.J$0 = j;
            return anonymousClass5.invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                InterfaceC2052dg interfaceC2052dg = (InterfaceC2052dg) this.L$0;
                long j = this.J$0;
                InterfaceC0552Gp interfaceC0552Gp = this.$onDragStopped;
                Float fB = E8.b(DraggableKt.m310toFloatsFctU(j, this.$orientation));
                this.label = 1;
                if (interfaceC0552Gp.invoke(interfaceC2052dg, fB, this) == objD) {
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

    public static final DraggableState DraggableState(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "onDelta");
        return new DefaultDraggableState(interfaceC3750qp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:43:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:46:0x01da A[LOOP:0: B:42:0x01bd->B:46:0x01da, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:95:0x01ec A[EDGE_INSN: B:95:0x01ec->B:48:0x01ec BREAK  A[LOOP:0: B:42:0x01bd->B:46:0x01da], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x0225 -> B:67:0x0234). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x028e -> B:78:0x0293). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x02df -> B:67:0x0234). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object awaitDownAndSlop(androidx.compose.ui.input.pointer.AwaitPointerEventScope r20, defpackage.InterfaceC3750qp r21, defpackage.InterfaceC3588op r22, androidx.compose.ui.input.pointer.util.VelocityTracker r23, androidx.compose.foundation.gestures.Orientation r24, defpackage.InterfaceC0793Of r25) {
        /*
            Method dump skipped, instruction units count: 743
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableKt.awaitDownAndSlop(androidx.compose.ui.input.pointer.AwaitPointerEventScope, qp, op, androidx.compose.ui.input.pointer.util.VelocityTracker, androidx.compose.foundation.gestures.Orientation, Of):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: awaitDrag-Su4bsnU, reason: not valid java name */
    public static final Object m307awaitDragSu4bsnU(AwaitPointerEventScope awaitPointerEventScope, PointerInputChange pointerInputChange, long j, VelocityTracker velocityTracker, InterfaceC4038uO interfaceC4038uO, boolean z, Orientation orientation, InterfaceC0793Of interfaceC0793Of) {
        interfaceC4038uO.mo0trySendJP2dKIU(new DragEvent.DragStarted(Offset.m2802minusMKHz9U(pointerInputChange.m4054getPositionF1C5BW0(), OffsetKt.Offset(Offset.m2798getXimpl(j) * Math.signum(Offset.m2798getXimpl(pointerInputChange.m4054getPositionF1C5BW0())), Offset.m2799getYimpl(j) * Math.signum(Offset.m2799getYimpl(pointerInputChange.m4054getPositionF1C5BW0())))), null));
        interfaceC4038uO.mo0trySendJP2dKIU(new DragEvent.DragDelta(z ? Offset.m2805timestuRUvjQ(j, -1.0f) : j, null));
        return m308onDragOrUpAxegvzg(awaitPointerEventScope, orientation, pointerInputChange.m4053getIdJ3iCeTQ(), new DraggableKt$awaitDrag$2(velocityTracker, interfaceC4038uO, z), interfaceC0793Of);
    }

    public static final Modifier draggable(Modifier modifier, DraggableState draggableState, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0552Gp interfaceC0552Gp2, boolean z3) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(draggableState, "state");
        AbstractC4492zt.h(orientation, "orientation");
        AbstractC4492zt.h(interfaceC0552Gp, "onDragStarted");
        AbstractC4492zt.h(interfaceC0552Gp2, "onDragStopped");
        return modifier.then(new DraggableElement(draggableState, AnonymousClass3.INSTANCE, orientation, z, mutableInteractionSource, new AnonymousClass4(z2), interfaceC0552Gp, new AnonymousClass5(interfaceC0552Gp2, orientation, null), z3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b9 A[LOOP:0: B:28:0x00a1->B:32:0x00b9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:73:0x00c3 A[EDGE_INSN: B:73:0x00c3->B:34:0x00c3 BREAK  A[LOOP:0: B:28:0x00a1->B:32:0x00b9], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x008f -> B:27:0x0096). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: onDragOrUp-Axegvzg, reason: not valid java name */
    public static final java.lang.Object m308onDragOrUpAxegvzg(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, androidx.compose.foundation.gestures.Orientation r18, long r19, defpackage.InterfaceC3750qp r21, defpackage.InterfaceC0793Of r22) {
        /*
            Method dump skipped, instruction units count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableKt.m308onDragOrUpAxegvzg(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.gestures.Orientation, long, qp, Of):java.lang.Object");
    }

    @Composable
    public static final DraggableState rememberDraggableState(InterfaceC3750qp interfaceC3750qp, Composer composer, int i) {
        AbstractC4492zt.h(interfaceC3750qp, "onDelta");
        composer.startReplaceableGroup(-183245213);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-183245213, i, -1, "androidx.compose.foundation.gestures.rememberDraggableState (Draggable.kt:139)");
        }
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composer, i & 14);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = DraggableState(new DraggableKt$rememberDraggableState$1$1(stateRememberUpdatedState));
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        DraggableState draggableState = (DraggableState) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return draggableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toFloat-3MmeM6k, reason: not valid java name */
    public static final float m309toFloat3MmeM6k(long j, Orientation orientation) {
        return orientation == Orientation.Vertical ? Offset.m2799getYimpl(j) : Offset.m2798getXimpl(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toFloat-sF-c-tU, reason: not valid java name */
    public static final float m310toFloatsFctU(long j, Orientation orientation) {
        return orientation == Orientation.Vertical ? Velocity.m5386getYimpl(j) : Velocity.m5385getXimpl(j);
    }
}
