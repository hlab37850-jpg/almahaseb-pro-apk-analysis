package androidx.compose.material.pullrefresh;

import androidx.compose.runtime.Immutable;

/* JADX INFO: loaded from: classes.dex */
@Immutable
final class ArrowValues {
    private final float endAngle;
    private final float rotation;
    private final float scale;
    private final float startAngle;

    public ArrowValues(float f, float f2, float f3, float f4) {
        this.rotation = f;
        this.startAngle = f2;
        this.endAngle = f3;
        this.scale = f4;
    }

    public final float getEndAngle() {
        return this.endAngle;
    }

    public final float getRotation() {
        return this.rotation;
    }

    public final float getScale() {
        return this.scale;
    }

    public final float getStartAngle() {
        return this.startAngle;
    }
}
