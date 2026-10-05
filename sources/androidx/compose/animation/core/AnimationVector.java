package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public abstract class AnimationVector {
    public static final int $stable = 0;

    public /* synthetic */ AnimationVector(AbstractC0419Di abstractC0419Di) {
        this();
    }

    public abstract float get$animation_core_release(int i);

    public abstract int getSize$animation_core_release();

    public abstract AnimationVector newVector$animation_core_release();

    public abstract void reset$animation_core_release();

    public abstract void set$animation_core_release(int i, float f);

    private AnimationVector() {
    }
}
