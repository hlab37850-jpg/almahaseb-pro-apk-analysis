package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.AutoboxingStateValueProperty;
import defpackage.AbstractC0962Uj;

/* JADX INFO: loaded from: classes.dex */
@Stable
public interface DoubleState extends State<Double> {

    public static final class DefaultImpls {
        @AutoboxingStateValueProperty(preferredPropertyName = "doubleValue")
        @Deprecated
        public static Double getValue(DoubleState doubleState) {
            return Double.valueOf(AbstractC0962Uj.a(doubleState).doubleValue());
        }
    }

    double getDoubleValue();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.State
    @AutoboxingStateValueProperty(preferredPropertyName = "doubleValue")
    Double getValue();

    @Override // androidx.compose.runtime.State
    /* bridge */ /* synthetic */ Double getValue();
}
