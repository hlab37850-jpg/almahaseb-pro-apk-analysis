package androidx.compose.runtime;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class SnapshotStateExtensionsKt {
    @Stable
    public static final DoubleState asDoubleState(State<Double> state) {
        AbstractC4492zt.h(state, "<this>");
        return state instanceof DoubleState ? (DoubleState) state : new UnboxedDoubleState(state);
    }

    @Stable
    public static final FloatState asFloatState(State<Float> state) {
        AbstractC4492zt.h(state, "<this>");
        return state instanceof FloatState ? (FloatState) state : new UnboxedFloatState(state);
    }

    @Stable
    public static final IntState asIntState(State<Integer> state) {
        AbstractC4492zt.h(state, "<this>");
        return state instanceof IntState ? (IntState) state : new UnboxedIntState(state);
    }

    @Stable
    public static final LongState asLongState(State<Long> state) {
        AbstractC4492zt.h(state, "<this>");
        return state instanceof LongState ? (LongState) state : new UnboxedLongState(state);
    }
}
