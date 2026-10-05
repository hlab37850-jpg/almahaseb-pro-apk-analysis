package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.unit.Velocity;
import defpackage.AbstractC0378Bt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1", f = "Scrollable.kt", l = {464, 466, 468}, m = "invokeSuspend")
public final class ScrollingLogic$onDragStopped$performFling$1 extends XS implements InterfaceC0526Fp {
    /* synthetic */ long J$0;
    long J$1;
    int label;
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollingLogic$onDragStopped$performFling$1(ScrollingLogic scrollingLogic, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.this$0 = scrollingLogic;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        ScrollingLogic$onDragStopped$performFling$1 scrollingLogic$onDragStopped$performFling$1 = new ScrollingLogic$onDragStopped$performFling$1(this.this$0, interfaceC0793Of);
        scrollingLogic$onDragStopped$performFling$1.J$0 = ((Velocity) obj).m5394unboximpl();
        return scrollingLogic$onDragStopped$performFling$1;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return m357invokesFctU(((Velocity) obj).m5394unboximpl(), (InterfaceC0793Of) obj2);
    }

    /* JADX INFO: renamed from: invoke-sF-c-tU, reason: not valid java name */
    public final Object m357invokesFctU(long j, InterfaceC0793Of interfaceC0793Of) {
        return ((ScrollingLogic$onDragStopped$performFling$1) create(Velocity.m5376boximpl(j), interfaceC0793Of)).invokeSuspend(FW.a);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0093 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x0094  */
    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM3953dispatchPreFlingQWom1Mo;
        long j;
        Object objM345doFlingAnimationQWom1Mo;
        long j2;
        long j3;
        long jM5394unboximpl;
        Object objM3951dispatchPostFlingRZ2iAVY;
        long j4;
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                j = this.J$0;
                LL.b(obj);
                objM3953dispatchPreFlingQWom1Mo = obj;
            } else if (i == 2) {
                j2 = this.J$1;
                long j5 = this.J$0;
                LL.b(obj);
                objM345doFlingAnimationQWom1Mo = obj;
                j3 = j5;
                jM5394unboximpl = ((Velocity) objM345doFlingAnimationQWom1Mo).m5394unboximpl();
                NestedScrollDispatcher value = this.this$0.getNestedScrollDispatcher().getValue();
                long jM5388minusAH228Gc = Velocity.m5388minusAH228Gc(j2, jM5394unboximpl);
                this.J$0 = j3;
                this.J$1 = jM5394unboximpl;
                this.label = 3;
                objM3951dispatchPostFlingRZ2iAVY = value.m3951dispatchPostFlingRZ2iAVY(jM5388minusAH228Gc, jM5394unboximpl, this);
                if (objM3951dispatchPostFlingRZ2iAVY == objD) {
                    return objD;
                }
                j4 = j3;
            } else {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                long j6 = this.J$1;
                j4 = this.J$0;
                LL.b(obj);
                jM5394unboximpl = j6;
                objM3951dispatchPostFlingRZ2iAVY = obj;
            }
            return Velocity.m5376boximpl(Velocity.m5388minusAH228Gc(j4, Velocity.m5388minusAH228Gc(jM5394unboximpl, ((Velocity) objM3951dispatchPostFlingRZ2iAVY).m5394unboximpl())));
        }
        LL.b(obj);
        long j7 = this.J$0;
        NestedScrollDispatcher value2 = this.this$0.getNestedScrollDispatcher().getValue();
        this.J$0 = j7;
        this.label = 1;
        objM3953dispatchPreFlingQWom1Mo = value2.m3953dispatchPreFlingQWom1Mo(j7, this);
        if (objM3953dispatchPreFlingQWom1Mo == objD) {
            return objD;
        }
        j = j7;
        long jM5388minusAH228Gc2 = Velocity.m5388minusAH228Gc(j, ((Velocity) objM3953dispatchPreFlingQWom1Mo).m5394unboximpl());
        ScrollingLogic scrollingLogic = this.this$0;
        this.J$0 = j;
        this.J$1 = jM5388minusAH228Gc2;
        this.label = 2;
        objM345doFlingAnimationQWom1Mo = scrollingLogic.m345doFlingAnimationQWom1Mo(jM5388minusAH228Gc2, this);
        if (objM345doFlingAnimationQWom1Mo == objD) {
            return objD;
        }
        j2 = jM5388minusAH228Gc2;
        j3 = j;
        jM5394unboximpl = ((Velocity) objM345doFlingAnimationQWom1Mo).m5394unboximpl();
        NestedScrollDispatcher value3 = this.this$0.getNestedScrollDispatcher().getValue();
        long jM5388minusAH228Gc3 = Velocity.m5388minusAH228Gc(j2, jM5394unboximpl);
        this.J$0 = j3;
        this.J$1 = jM5394unboximpl;
        this.label = 3;
        objM3951dispatchPostFlingRZ2iAVY = value3.m3951dispatchPostFlingRZ2iAVY(jM5388minusAH228Gc3, jM5394unboximpl, this);
        if (objM3951dispatchPostFlingRZ2iAVY == objD) {
            return objD;
        }
        j4 = j3;
        return Velocity.m5376boximpl(Velocity.m5388minusAH228Gc(j4, Velocity.m5388minusAH228Gc(jM5394unboximpl, ((Velocity) objM3951dispatchPostFlingRZ2iAVY).m5394unboximpl())));
    }
}
