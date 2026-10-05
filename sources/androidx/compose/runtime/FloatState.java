package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.AutoboxingStateValueProperty;
import defpackage.AbstractC0887Rm;

/* JADX INFO: loaded from: classes.dex */
@Stable
public interface FloatState extends State<Float> {

    public static final class DefaultImpls {
        @AutoboxingStateValueProperty(preferredPropertyName = "floatValue")
        @Deprecated
        public static Float getValue(FloatState floatState) {
            return Float.valueOf(AbstractC0887Rm.a(floatState).floatValue());
        }
    }

    float getFloatValue();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.State
    @AutoboxingStateValueProperty(preferredPropertyName = "floatValue")
    Float getValue();

    @Override // androidx.compose.runtime.State
    /* bridge */ /* synthetic */ Float getValue();
}
