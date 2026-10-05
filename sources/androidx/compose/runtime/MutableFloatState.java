package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.AutoboxingStateValueProperty;
import defpackage.AbstractC4026uC;

/* JADX INFO: loaded from: classes.dex */
@Stable
public interface MutableFloatState extends FloatState, MutableState<Float> {

    public static final class DefaultImpls {
        @AutoboxingStateValueProperty(preferredPropertyName = "floatValue")
        @Deprecated
        public static Float getValue(MutableFloatState mutableFloatState) {
            return Float.valueOf(AbstractC4026uC.a(mutableFloatState).floatValue());
        }

        @AutoboxingStateValueProperty(preferredPropertyName = "floatValue")
        @Deprecated
        public static void setValue(MutableFloatState mutableFloatState, float f) {
            AbstractC4026uC.c(mutableFloatState, f);
        }
    }

    @Override // androidx.compose.runtime.FloatState
    float getFloatValue();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.FloatState, androidx.compose.runtime.State
    @AutoboxingStateValueProperty(preferredPropertyName = "floatValue")
    Float getValue();

    @Override // androidx.compose.runtime.FloatState, androidx.compose.runtime.State
    /* bridge */ /* synthetic */ Float getValue();

    void setFloatValue(float f);

    @AutoboxingStateValueProperty(preferredPropertyName = "floatValue")
    void setValue(float f);

    @Override // androidx.compose.runtime.MutableState
    /* bridge */ /* synthetic */ void setValue(Float f);
}
