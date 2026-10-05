package androidx.compose.runtime;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class UnboxedFloatState implements FloatState {
    private final State<Float> baseState;

    public UnboxedFloatState(State<Float> state) {
        AbstractC4492zt.h(state, "baseState");
        this.baseState = state;
    }

    @Override // androidx.compose.runtime.FloatState
    public float getFloatValue() {
        return this.baseState.getValue().floatValue();
    }

    public String toString() {
        return "UnboxedFloatState(baseState=" + this.baseState + ")@" + hashCode();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.FloatState, androidx.compose.runtime.State
    public Float getValue() {
        return this.baseState.getValue();
    }
}
