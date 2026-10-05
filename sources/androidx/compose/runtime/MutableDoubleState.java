package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.AutoboxingStateValueProperty;
import defpackage.AbstractC3945tC;

/* JADX INFO: loaded from: classes.dex */
@Stable
public interface MutableDoubleState extends DoubleState, MutableState<Double> {

    public static final class DefaultImpls {
        @AutoboxingStateValueProperty(preferredPropertyName = "doubleValue")
        @Deprecated
        public static Double getValue(MutableDoubleState mutableDoubleState) {
            return Double.valueOf(AbstractC3945tC.a(mutableDoubleState).doubleValue());
        }

        @AutoboxingStateValueProperty(preferredPropertyName = "doubleValue")
        @Deprecated
        public static void setValue(MutableDoubleState mutableDoubleState, double d) {
            AbstractC3945tC.c(mutableDoubleState, d);
        }
    }

    @Override // androidx.compose.runtime.DoubleState
    double getDoubleValue();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.DoubleState, androidx.compose.runtime.State
    @AutoboxingStateValueProperty(preferredPropertyName = "doubleValue")
    Double getValue();

    @Override // androidx.compose.runtime.DoubleState, androidx.compose.runtime.State
    /* bridge */ /* synthetic */ Double getValue();

    void setDoubleValue(double d);

    @AutoboxingStateValueProperty(preferredPropertyName = "doubleValue")
    void setValue(double d);

    @Override // androidx.compose.runtime.MutableState
    /* bridge */ /* synthetic */ void setValue(Double d);
}
