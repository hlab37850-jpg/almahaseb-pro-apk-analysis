package androidx.compose.runtime;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class UnboxedDoubleState implements DoubleState {
    private final State<Double> baseState;

    public UnboxedDoubleState(State<Double> state) {
        AbstractC4492zt.h(state, "baseState");
        this.baseState = state;
    }

    @Override // androidx.compose.runtime.DoubleState
    public double getDoubleValue() {
        return this.baseState.getValue().doubleValue();
    }

    public String toString() {
        return "UnboxedDoubleState(baseState=" + this.baseState + ")@" + hashCode();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.DoubleState, androidx.compose.runtime.State
    public Double getValue() {
        return this.baseState.getValue();
    }
}
