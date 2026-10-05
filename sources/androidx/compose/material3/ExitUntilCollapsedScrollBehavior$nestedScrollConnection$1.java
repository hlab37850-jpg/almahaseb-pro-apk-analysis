package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2262gD;
import defpackage.InterfaceC0793Of;
import defpackage.LL;

/* JADX INFO: loaded from: classes.dex */
public final class ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ ExitUntilCollapsedScrollBehavior this$0;

    public ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1(ExitUntilCollapsedScrollBehavior exitUntilCollapsedScrollBehavior) {
        this.this$0 = exitUntilCollapsedScrollBehavior;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo340onPostFlingRZ2iAVY(long j, long j2, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1 exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1;
        ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1 exitUntilCollapsedScrollBehavior$nestedScrollConnection$1;
        long j3;
        if (interfaceC0793Of instanceof ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1) {
            exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1 = (ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1) interfaceC0793Of;
            int i = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1.label = i - Integer.MIN_VALUE;
            } else {
                exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1 = new ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1(this, interfaceC0793Of);
            }
        } else {
            exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1 = new ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1(this, interfaceC0793Of);
        }
        Object objA = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                j2 = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1.J$0;
                exitUntilCollapsedScrollBehavior$nestedScrollConnection$1 = (ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1) exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1.L$0;
                LL.b(objA);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j3 = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1.J$0;
                LL.b(objA);
            }
            return Velocity.m5376boximpl(Velocity.m5389plusAH228Gc(j3, ((Velocity) objA).m5394unboximpl()));
        }
        LL.b(objA);
        exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1.L$0 = this;
        exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1.J$0 = j2;
        exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1.label = 1;
        objA = AbstractC2262gD.a(this, j, j2, exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1);
        if (objA == objD) {
            return objD;
        }
        exitUntilCollapsedScrollBehavior$nestedScrollConnection$1 = this;
        long jM5394unboximpl = ((Velocity) objA).m5394unboximpl();
        TopAppBarState state = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1.this$0.getState();
        float fM5386getYimpl = Velocity.m5386getYimpl(j2);
        DecayAnimationSpec<Float> flingAnimationSpec = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1.this$0.getFlingAnimationSpec();
        AnimationSpec<Float> snapAnimationSpec = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1.this$0.getSnapAnimationSpec();
        exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1.L$0 = null;
        exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1.J$0 = jM5394unboximpl;
        exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1.label = 2;
        objA = AppBarKt.settleAppBar(state, fM5386getYimpl, flingAnimationSpec, snapAnimationSpec, exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1);
        if (objA == objD) {
            return objD;
        }
        j3 = jM5394unboximpl;
        return Velocity.m5376boximpl(Velocity.m5389plusAH228Gc(j3, ((Velocity) objA).m5394unboximpl()));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo341onPostScrollDzOQY0M(long j, long j2, int i) {
        if (!((Boolean) this.this$0.getCanScroll().invoke()).booleanValue()) {
            return Offset.Companion.m2814getZeroF1C5BW0();
        }
        TopAppBarState state = this.this$0.getState();
        state.setContentOffset(state.getContentOffset() + Offset.m2799getYimpl(j));
        if (Offset.m2799getYimpl(j2) < 0.0f || Offset.m2799getYimpl(j) < 0.0f) {
            float heightOffset = this.this$0.getState().getHeightOffset();
            this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Offset.m2799getYimpl(j));
            return OffsetKt.Offset(0.0f, this.this$0.getState().getHeightOffset() - heightOffset);
        }
        if (Offset.m2799getYimpl(j) == 0.0f && Offset.m2799getYimpl(j2) > 0.0f) {
            this.this$0.getState().setContentOffset(0.0f);
        }
        if (Offset.m2799getYimpl(j2) <= 0.0f) {
            return Offset.Companion.m2814getZeroF1C5BW0();
        }
        float heightOffset2 = this.this$0.getState().getHeightOffset();
        this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Offset.m2799getYimpl(j2));
        return OffsetKt.Offset(0.0f, this.this$0.getState().getHeightOffset() - heightOffset2);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public /* synthetic */ Object mo342onPreFlingQWom1Mo(long j, InterfaceC0793Of interfaceC0793Of) {
        return AbstractC2262gD.c(this, j, interfaceC0793Of);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo343onPreScrollOzD1aCk(long j, int i) {
        if (!((Boolean) this.this$0.getCanScroll().invoke()).booleanValue() || Offset.m2799getYimpl(j) > 0.0f) {
            return Offset.Companion.m2814getZeroF1C5BW0();
        }
        float heightOffset = this.this$0.getState().getHeightOffset();
        this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Offset.m2799getYimpl(j));
        return heightOffset == this.this$0.getState().getHeightOffset() ? Offset.Companion.m2814getZeroF1C5BW0() : Offset.m2792copydBAh8RU$default(j, 0.0f, 0.0f, 2, null);
    }
}
