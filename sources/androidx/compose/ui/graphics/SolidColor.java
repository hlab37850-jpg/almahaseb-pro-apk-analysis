package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class SolidColor extends Brush {
    private final long value;

    public /* synthetic */ SolidColor(long j, AbstractC0419Di abstractC0419Di) {
        this(j);
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: applyTo-Pq9zytI */
    public void mo2985applyToPq9zytI(long j, Paint paint, float f) {
        long jM3031copywmQWz5c$default;
        AbstractC4492zt.h(paint, "p");
        paint.setAlpha(1.0f);
        if (f == 1.0f) {
            jM3031copywmQWz5c$default = this.value;
        } else {
            long j2 = this.value;
            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(j2, Color.m3034getAlphaimpl(j2) * f, 0.0f, 0.0f, 0.0f, 14, null);
        }
        paint.mo2919setColor8_81llA(jM3031copywmQWz5c$default);
        if (paint.getShader() != null) {
            paint.setShader(null);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SolidColor) && Color.m3033equalsimpl0(this.value, ((SolidColor) obj).value);
    }

    /* JADX INFO: renamed from: getValue-0d7_KjU, reason: not valid java name */
    public final long m3338getValue0d7_KjU() {
        return this.value;
    }

    public int hashCode() {
        return Color.m3039hashCodeimpl(this.value);
    }

    public String toString() {
        return "SolidColor(value=" + ((Object) Color.m3040toStringimpl(this.value)) + ')';
    }

    private SolidColor(long j) {
        super(null);
        this.value = j;
    }
}
