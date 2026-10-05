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
public final class LinearGradient extends ShaderBrush {
    private final List<Color> colors;
    private final long end;
    private final long start;
    private final List<Float> stops;
    private final int tileMode;

    public /* synthetic */ LinearGradient(List list, List list2, long j, long j2, int i, AbstractC0419Di abstractC0419Di) {
        this(list, list2, j, j2, i);
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public Shader mo3007createShaderuvyYCjk(long j) {
        return ShaderKt.m3318LinearGradientShaderVjE6UOU(OffsetKt.Offset(Offset.m2798getXimpl(this.start) == Float.POSITIVE_INFINITY ? Size.m2867getWidthimpl(j) : Offset.m2798getXimpl(this.start), Offset.m2799getYimpl(this.start) == Float.POSITIVE_INFINITY ? Size.m2864getHeightimpl(j) : Offset.m2799getYimpl(this.start)), OffsetKt.Offset(Offset.m2798getXimpl(this.end) == Float.POSITIVE_INFINITY ? Size.m2867getWidthimpl(j) : Offset.m2798getXimpl(this.end), Offset.m2799getYimpl(this.end) == Float.POSITIVE_INFINITY ? Size.m2864getHeightimpl(j) : Offset.m2799getYimpl(this.end)), this.colors, this.stops, this.tileMode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinearGradient)) {
            return false;
        }
        LinearGradient linearGradient = (LinearGradient) obj;
        return AbstractC4492zt.d(this.colors, linearGradient.colors) && AbstractC4492zt.d(this.stops, linearGradient.stops) && Offset.m2795equalsimpl0(this.start, linearGradient.start) && Offset.m2795equalsimpl0(this.end, linearGradient.end) && TileMode.m3372equalsimpl0(this.tileMode, linearGradient.tileMode);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0038  */
    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public long mo2986getIntrinsicSizeNHjbRc() {
        float fAbs;
        float fM2798getXimpl = Offset.m2798getXimpl(this.start);
        float fAbs2 = Float.NaN;
        if (Float.isInfinite(fM2798getXimpl) || Float.isNaN(fM2798getXimpl)) {
            fAbs = Float.NaN;
        } else {
            float fM2798getXimpl2 = Offset.m2798getXimpl(this.end);
            if (Float.isInfinite(fM2798getXimpl2) || Float.isNaN(fM2798getXimpl2)) {
                fAbs = Float.NaN;
            } else {
                fAbs = Math.abs(Offset.m2798getXimpl(this.start) - Offset.m2798getXimpl(this.end));
            }
        }
        float fM2799getYimpl = Offset.m2799getYimpl(this.start);
        if (!Float.isInfinite(fM2799getYimpl) && !Float.isNaN(fM2799getYimpl)) {
            float fM2799getYimpl2 = Offset.m2799getYimpl(this.end);
            if (!Float.isInfinite(fM2799getYimpl2) && !Float.isNaN(fM2799getYimpl2)) {
                fAbs2 = Math.abs(Offset.m2799getYimpl(this.start) - Offset.m2799getYimpl(this.end));
            }
        }
        return SizeKt.Size(fAbs, fAbs2);
    }

    public int hashCode() {
        int iHashCode = this.colors.hashCode() * 31;
        List<Float> list = this.stops;
        return ((((((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + Offset.m2800hashCodeimpl(this.start)) * 31) + Offset.m2800hashCodeimpl(this.end)) * 31) + TileMode.m3373hashCodeimpl(this.tileMode);
    }

    public String toString() {
        String str;
        String str2 = "";
        if (OffsetKt.m2815isFinitek4lQ0M(this.start)) {
            str = "start=" + ((Object) Offset.m2806toStringimpl(this.start)) + ", ";
        } else {
            str = "";
        }
        if (OffsetKt.m2815isFinitek4lQ0M(this.end)) {
            str2 = "end=" + ((Object) Offset.m2806toStringimpl(this.end)) + ", ";
        }
        return "LinearGradient(colors=" + this.colors + ", stops=" + this.stops + ", " + str + str2 + "tileMode=" + ((Object) TileMode.m3374toStringimpl(this.tileMode)) + ')';
    }

    public /* synthetic */ LinearGradient(List list, List list2, long j, long j2, int i, int i2, AbstractC0419Di abstractC0419Di) {
        this(list, (i2 & 2) != 0 ? null : list2, j, j2, (i2 & 16) != 0 ? TileMode.Companion.m3376getClamp3opZhB0() : i, null);
    }

    private LinearGradient(List<Color> list, List<Float> list2, long j, long j2, int i) {
        AbstractC4492zt.h(list, "colors");
        this.colors = list;
        this.stops = list2;
        this.start = j;
        this.end = j2;
        this.tileMode = i;
    }
}
