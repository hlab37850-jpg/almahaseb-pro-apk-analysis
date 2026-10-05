package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;

/* JADX INFO: loaded from: classes.dex */
public final class VelocityKt {
    @Stable
    public static final long Velocity(float f, float f2) {
        return Velocity.m5379constructorimpl((((long) Float.floatToIntBits(f2)) & 4294967295L) | (Float.floatToIntBits(f) << 32));
    }
}
