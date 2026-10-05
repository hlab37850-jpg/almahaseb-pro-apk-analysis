package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class RadialGradient extends ShaderBrush {
    private final long center;
    private final List<Color> colors;
    private final float radius;
    private final List<Float> stops;
    private final int tileMode;

    public /* synthetic */ RadialGradient(List list, List list2, long j, float f, int i, AbstractC0419Di abstractC0419Di) {
        this(list, list2, j, f, i);
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public Shader mo3007createShaderuvyYCjk(long j) {
        float fM2867getWidthimpl;
        float fM2864getHeightimpl;
        if (OffsetKt.m2819isUnspecifiedk4lQ0M(this.center)) {
            long jM2877getCenteruvyYCjk = SizeKt.m2877getCenteruvyYCjk(j);
            fM2867getWidthimpl = Offset.m2798getXimpl(jM2877getCenteruvyYCjk);
            fM2864getHeightimpl = Offset.m2799getYimpl(jM2877getCenteruvyYCjk);
        } else {
            fM2867getWidthimpl = Offset.m2798getXimpl(this.center) == Float.POSITIVE_INFINITY ? Size.m2867getWidthimpl(j) : Offset.m2798getXimpl(this.center);
            fM2864getHeightimpl = Offset.m2799getYimpl(this.center) == Float.POSITIVE_INFINITY ? Size.m2864getHeightimpl(j) : Offset.m2799getYimpl(this.center);
        }
        List<Color> list = this.colors;
        List<Float> list2 = this.stops;
        long jOffset = OffsetKt.Offset(fM2867getWidthimpl, fM2864getHeightimpl);
        float f = this.radius;
        return ShaderKt.m3320RadialGradientShader8uybcMk(jOffset, f == Float.POSITIVE_INFINITY ? Size.m2866getMinDimensionimpl(j) / 2 : f, list, list2, this.tileMode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RadialGradient)) {
            return false;
        }
        RadialGradient radialGradient = (RadialGradient) obj;
        return AbstractC4492zt.d(this.colors, radialGradient.colors) && AbstractC4492zt.d(this.stops, radialGradient.stops) && Offset.m2795equalsimpl0(this.center, radialGradient.center) && this.radius == radialGradient.radius && TileMode.m3372equalsimpl0(this.tileMode, radialGradient.tileMode);
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public long mo2986getIntrinsicSizeNHjbRc() {
        float f = this.radius;
        if (Float.isInfinite(f) || Float.isNaN(f)) {
            return Size.Companion.m2875getUnspecifiedNHjbRc();
        }
        float f2 = this.radius;
        float f3 = 2;
        return SizeKt.Size(f2 * f3, f2 * f3);
    }

    public int hashCode() {
        int iHashCode = this.colors.hashCode() * 31;
        List<Float> list = this.stops;
        return ((((((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + Offset.m2800hashCodeimpl(this.center)) * 31) + Float.floatToIntBits(this.radius)) * 31) + TileMode.m3373hashCodeimpl(this.tileMode);
    }

    public String toString() {
        String str;
        String str2 = "";
        if (OffsetKt.m2817isSpecifiedk4lQ0M(this.center)) {
            str = "center=" + ((Object) Offset.m2806toStringimpl(this.center)) + ", ";
        } else {
            str = "";
        }
        float f = this.radius;
        if (!Float.isInfinite(f) && !Float.isNaN(f)) {
            str2 = "radius=" + this.radius + ", ";
        }
        return "RadialGradient(colors=" + this.colors + ", stops=" + this.stops + ", " + str + str2 + "tileMode=" + ((Object) TileMode.m3374toStringimpl(this.tileMode)) + ')';
    }

    public /* synthetic */ RadialGradient(List list, List list2, long j, float f, int i, int i2, AbstractC0419Di abstractC0419Di) {
        this(list, (i2 & 2) != 0 ? null : list2, j, f, (i2 & 16) != 0 ? TileMode.Companion.m3376getClamp3opZhB0() : i, null);
    }

    private RadialGradient(List<Color> list, List<Float> list2, long j, float f, int i) {
        AbstractC4492zt.h(list, "colors");
        this.colors = list;
        this.stops = list2;
        this.center = j;
        this.radius = f;
        this.tileMode = i;
    }
}
