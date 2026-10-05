package androidx.compose.material.pullrefresh;

import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.material.ExperimentalMaterialApi;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC1830bu;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.O8;
import defpackage.XS;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalMaterialApi
public final class PullRefreshState {
    public static final int $stable = 8;
    private final MutableFloatState _position$delegate;
    private final MutableState _refreshing$delegate;
    private final MutableFloatState _refreshingOffset$delegate;
    private final MutableFloatState _threshold$delegate;
    private final State adjustedDistancePulled$delegate;
    private final InterfaceC2052dg animationScope;
    private final MutableFloatState distancePulled$delegate;
    private final MutatorMutex mutatorMutex;
    private final State<InterfaceC3588op> onRefreshState;

    /* JADX INFO: renamed from: androidx.compose.material.pullrefresh.PullRefreshState$animateIndicatorTo$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.material.pullrefresh.PullRefreshState$animateIndicatorTo$1", f = "PullRefreshState.kt", l = {ShapeTypes.CHART_STAR}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ float $offset;
        int label;

        /* JADX INFO: renamed from: androidx.compose.material.pullrefresh.PullRefreshState$animateIndicatorTo$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC3252ki(c = "androidx.compose.material.pullrefresh.PullRefreshState$animateIndicatorTo$1$1", f = "PullRefreshState.kt", l = {ShapeTypes.CHART_PLUS}, m = "invokeSuspend")
        public static final class C00931 extends XS implements InterfaceC3750qp {
            final /* synthetic */ float $offset;
            int label;
            final /* synthetic */ PullRefreshState this$0;

            /* JADX INFO: renamed from: androidx.compose.material.pullrefresh.PullRefreshState$animateIndicatorTo$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C00941 extends AbstractC2233fv implements InterfaceC0526Fp {
                final /* synthetic */ PullRefreshState this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00941(PullRefreshState pullRefreshState) {
                    super(2);
                    this.this$0 = pullRefreshState;
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke */
                public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
                    invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue());
                    return FW.a;
                }

                public final void invoke(float f, float f2) {
                    this.this$0.set_position(f);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00931(PullRefreshState pullRefreshState, float f, InterfaceC0793Of interfaceC0793Of) {
                super(1, interfaceC0793Of);
                this.this$0 = pullRefreshState;
                this.$offset = f;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(InterfaceC0793Of interfaceC0793Of) {
                return new C00931(this.this$0, this.$offset, interfaceC0793Of);
            }

            @Override // defpackage.InterfaceC3750qp
            public final Object invoke(InterfaceC0793Of interfaceC0793Of) {
                return ((C00931) create(interfaceC0793Of)).invokeSuspend(FW.a);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objD = AbstractC0378Bt.d();
                int i = this.label;
                if (i == 0) {
                    LL.b(obj);
                    float f = this.this$0.get_position();
                    float f2 = this.$offset;
                    C00941 c00941 = new C00941(this.this$0);
                    this.label = 1;
                    if (SuspendAnimationKt.animate$default(f, f2, 0.0f, null, c00941, this, 12, null) == objD) {
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
        public AnonymousClass1(float f, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$offset = f;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return PullRefreshState.this.new AnonymousClass1(this.$offset, interfaceC0793Of);
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
                MutatorMutex mutatorMutex = PullRefreshState.this.mutatorMutex;
                C00931 c00931 = new C00931(PullRefreshState.this, this.$offset, null);
                this.label = 1;
                if (MutatorMutex.mutate$default(mutatorMutex, null, c00931, this, 1, null) == objD) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public PullRefreshState(InterfaceC2052dg interfaceC2052dg, State<? extends InterfaceC3588op> state, float f, float f2) {
        AbstractC4492zt.h(interfaceC2052dg, "animationScope");
        AbstractC4492zt.h(state, "onRefreshState");
        this.animationScope = interfaceC2052dg;
        this.onRefreshState = state;
        this.adjustedDistancePulled$delegate = SnapshotStateKt.derivedStateOf(new PullRefreshState$adjustedDistancePulled$2(this));
        this._refreshing$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this._position$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.distancePulled$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this._threshold$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(f2);
        this._refreshingOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
        this.mutatorMutex = new MutatorMutex();
    }

    private final InterfaceC1830bu animateIndicatorTo(float f) {
        return O8.d(this.animationScope, null, null, new AnonymousClass1(f, null), 3, null);
    }

    private final float calculateIndicatorPosition() {
        if (getAdjustedDistancePulled() <= getThreshold$material_release()) {
            return getAdjustedDistancePulled();
        }
        float fK = AbstractC3871sJ.k(Math.abs(getProgress()) - 1.0f, 0.0f, 2.0f);
        return getThreshold$material_release() + (getThreshold$material_release() * (fK - (((float) Math.pow(fK, 2)) / 4)));
    }

    private final float getAdjustedDistancePulled() {
        return ((Number) this.adjustedDistancePulled$delegate.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getDistancePulled() {
        return this.distancePulled$delegate.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float get_position() {
        return this._position$delegate.getFloatValue();
    }

    private final boolean get_refreshing() {
        return ((Boolean) this._refreshing$delegate.getValue()).booleanValue();
    }

    private final float get_refreshingOffset() {
        return this._refreshingOffset$delegate.getFloatValue();
    }

    private final float get_threshold() {
        return this._threshold$delegate.getFloatValue();
    }

    private final void setDistancePulled(float f) {
        this.distancePulled$delegate.setFloatValue(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void set_position(float f) {
        this._position$delegate.setFloatValue(f);
    }

    private final void set_refreshing(boolean z) {
        this._refreshing$delegate.setValue(Boolean.valueOf(z));
    }

    private final void set_refreshingOffset(float f) {
        this._refreshingOffset$delegate.setFloatValue(f);
    }

    private final void set_threshold(float f) {
        this._threshold$delegate.setFloatValue(f);
    }

    public final float getPosition$material_release() {
        return get_position();
    }

    public final float getProgress() {
        return getAdjustedDistancePulled() / getThreshold$material_release();
    }

    public final boolean getRefreshing$material_release() {
        return get_refreshing();
    }

    public final float getThreshold$material_release() {
        return get_threshold();
    }

    public final float onPull$material_release(float f) {
        if (get_refreshing()) {
            return 0.0f;
        }
        float fC = AbstractC3871sJ.c(getDistancePulled() + f, 0.0f);
        float distancePulled = fC - getDistancePulled();
        setDistancePulled(fC);
        set_position(calculateIndicatorPosition());
        return distancePulled;
    }

    public final float onRelease$material_release(float f) {
        if (getRefreshing$material_release()) {
            return 0.0f;
        }
        if (getAdjustedDistancePulled() > getThreshold$material_release()) {
            this.onRefreshState.getValue().invoke();
        }
        animateIndicatorTo(0.0f);
        if (getDistancePulled() == 0.0f || f < 0.0f) {
            f = 0.0f;
        }
        setDistancePulled(0.0f);
        return f;
    }

    public final void setRefreshing$material_release(boolean z) {
        if (get_refreshing() != z) {
            set_refreshing(z);
            setDistancePulled(0.0f);
            animateIndicatorTo(z ? get_refreshingOffset() : 0.0f);
        }
    }

    public final void setRefreshingOffset$material_release(float f) {
        if (get_refreshingOffset() == f) {
            return;
        }
        set_refreshingOffset(f);
        if (getRefreshing$material_release()) {
            animateIndicatorTo(f);
        }
    }

    public final void setThreshold$material_release(float f) {
        set_threshold(f);
    }
}
