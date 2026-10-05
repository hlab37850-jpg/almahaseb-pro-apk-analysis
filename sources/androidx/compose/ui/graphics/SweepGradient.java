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
public final class SweepGradient extends ShaderBrush {
    private final long center;
    private final List<Color> colors;
    private final List<Float> stops;

    public /* synthetic */ SweepGradient(long j, List list, List list2, AbstractC0419Di abstractC0419Di) {
        this(j, list, list2);
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public Shader mo3007createShaderuvyYCjk(long j) {
        long jOffset;
        if (OffsetKt.m2819isUnspecifiedk4lQ0M(this.center)) {
            jOffset = SizeKt.m2877getCenteruvyYCjk(j);
        } else {
            jOffset = OffsetKt.Offset(Offset.m2798getXimpl(this.center) == Float.POSITIVE_INFINITY ? Size.m2867getWidthimpl(j) : Offset.m2798getXimpl(this.center), Offset.m2799getYimpl(this.center) == Float.POSITIVE_INFINITY ? Size.m2864getHeightimpl(j) : Offset.m2799getYimpl(this.center));
        }
        return ShaderKt.m3322SweepGradientShader9KIMszo(jOffset, this.colors, this.stops);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SweepGradient)) {
            return false;
        }
        SweepGradient sweepGradient = (SweepGradient) obj;
        return Offset.m2795equalsimpl0(this.center, sweepGradient.center) && AbstractC4492zt.d(this.colors, sweepGradient.colors) && AbstractC4492zt.d(this.stops, sweepGradient.stops);
    }

    public int hashCode() {
        int iM2800hashCodeimpl = ((Offset.m2800hashCodeimpl(this.center) * 31) + this.colors.hashCode()) * 31;
        List<Float> list = this.stops;
        return iM2800hashCodeimpl + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        String str;
        if (OffsetKt.m2817isSpecifiedk4lQ0M(this.center)) {
            str = "center=" + ((Object) Offset.m2806toStringimpl(this.center)) + ", ";
        } else {
            str = "";
        }
        return "SweepGradient(" + str + "colors=" + this.colors + ", stops=" + this.stops + ')';
    }

    public /* synthetic */ SweepGradient(long j, List list, List list2, int i, AbstractC0419Di abstractC0419Di) {
        this(j, list, (i & 4) != 0 ? null : list2, null);
    }

    private SweepGradient(long j, List<Color> list, List<Float> list2) {
        AbstractC4492zt.h(list, "colors");
        this.center = j;
        this.colors = list;
        this.stops = list2;
    }
}
