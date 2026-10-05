package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public abstract class Brush {
    public static final Companion Companion = new Companion(null);
    private final long intrinsicSize;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: renamed from: horizontalGradient-8A-3gB4$default, reason: not valid java name */
        public static /* synthetic */ Brush m2987horizontalGradient8A3gB4$default(Companion companion, List list, float f, float f2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                f = 0.0f;
            }
            if ((i2 & 4) != 0) {
                f2 = Float.POSITIVE_INFINITY;
            }
            if ((i2 & 8) != 0) {
                i = TileMode.Companion.m3376getClamp3opZhB0();
            }
            return companion.m2997horizontalGradient8A3gB4((List<Color>) list, f, f2, i);
        }

        /* JADX INFO: renamed from: linearGradient-mHitzGk$default, reason: not valid java name */
        public static /* synthetic */ Brush m2990linearGradientmHitzGk$default(Companion companion, C2020dG[] c2020dGArr, long j, long j2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                j = Offset.Companion.m2814getZeroF1C5BW0();
            }
            long j3 = j;
            if ((i2 & 4) != 0) {
                j2 = Offset.Companion.m2812getInfiniteF1C5BW0();
            }
            long j4 = j2;
            if ((i2 & 8) != 0) {
                i = TileMode.Companion.m3376getClamp3opZhB0();
            }
            return companion.m3000linearGradientmHitzGk(c2020dGArr, j3, j4, i);
        }

        /* JADX INFO: renamed from: radialGradient-P_Vx-Ks$default, reason: not valid java name */
        public static /* synthetic */ Brush m2992radialGradientP_VxKs$default(Companion companion, C2020dG[] c2020dGArr, long j, float f, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                j = Offset.Companion.m2813getUnspecifiedF1C5BW0();
            }
            long j2 = j;
            float f2 = (i2 & 4) != 0 ? Float.POSITIVE_INFINITY : f;
            if ((i2 & 8) != 0) {
                i = TileMode.Companion.m3376getClamp3opZhB0();
            }
            return companion.m3002radialGradientP_VxKs(c2020dGArr, j2, f2, i);
        }

        /* JADX INFO: renamed from: sweepGradient-Uv8p0NA$default, reason: not valid java name */
        public static /* synthetic */ Brush m2994sweepGradientUv8p0NA$default(Companion companion, C2020dG[] c2020dGArr, long j, int i, Object obj) {
            if ((i & 2) != 0) {
                j = Offset.Companion.m2813getUnspecifiedF1C5BW0();
            }
            return companion.m3004sweepGradientUv8p0NA(c2020dGArr, j);
        }

        /* JADX INFO: renamed from: verticalGradient-8A-3gB4$default, reason: not valid java name */
        public static /* synthetic */ Brush m2995verticalGradient8A3gB4$default(Companion companion, List list, float f, float f2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                f = 0.0f;
            }
            if ((i2 & 4) != 0) {
                f2 = Float.POSITIVE_INFINITY;
            }
            if ((i2 & 8) != 0) {
                i = TileMode.Companion.m3376getClamp3opZhB0();
            }
            return companion.m3005verticalGradient8A3gB4((List<Color>) list, f, f2, i);
        }

        @Stable
        /* JADX INFO: renamed from: horizontalGradient-8A-3gB4, reason: not valid java name */
        public final Brush m2997horizontalGradient8A3gB4(List<Color> list, float f, float f2, int i) {
            AbstractC4492zt.h(list, "colors");
            return m2999linearGradientmHitzGk(list, OffsetKt.Offset(f, 0.0f), OffsetKt.Offset(f2, 0.0f), i);
        }

        @Stable
        /* JADX INFO: renamed from: linearGradient-mHitzGk, reason: not valid java name */
        public final Brush m3000linearGradientmHitzGk(C2020dG[] c2020dGArr, long j, long j2, int i) {
            AbstractC4492zt.h(c2020dGArr, "colorStops");
            ArrayList arrayList = new ArrayList(c2020dGArr.length);
            for (C2020dG c2020dG : c2020dGArr) {
                arrayList.add(Color.m3022boximpl(((Color) c2020dG.e()).m3042unboximpl()));
            }
            ArrayList arrayList2 = new ArrayList(c2020dGArr.length);
            for (C2020dG c2020dG2 : c2020dGArr) {
                arrayList2.add(Float.valueOf(((Number) c2020dG2.c()).floatValue()));
            }
            return new LinearGradient(arrayList, arrayList2, j, j2, i, null);
        }

        @Stable
        /* JADX INFO: renamed from: radialGradient-P_Vx-Ks, reason: not valid java name */
        public final Brush m3002radialGradientP_VxKs(C2020dG[] c2020dGArr, long j, float f, int i) {
            AbstractC4492zt.h(c2020dGArr, "colorStops");
            ArrayList arrayList = new ArrayList(c2020dGArr.length);
            for (C2020dG c2020dG : c2020dGArr) {
                arrayList.add(Color.m3022boximpl(((Color) c2020dG.e()).m3042unboximpl()));
            }
            ArrayList arrayList2 = new ArrayList(c2020dGArr.length);
            for (C2020dG c2020dG2 : c2020dGArr) {
                arrayList2.add(Float.valueOf(((Number) c2020dG2.c()).floatValue()));
            }
            return new RadialGradient(arrayList, arrayList2, j, f, i, null);
        }

        @Stable
        /* JADX INFO: renamed from: sweepGradient-Uv8p0NA, reason: not valid java name */
        public final Brush m3004sweepGradientUv8p0NA(C2020dG[] c2020dGArr, long j) {
            AbstractC4492zt.h(c2020dGArr, "colorStops");
            ArrayList arrayList = new ArrayList(c2020dGArr.length);
            for (C2020dG c2020dG : c2020dGArr) {
                arrayList.add(Color.m3022boximpl(((Color) c2020dG.e()).m3042unboximpl()));
            }
            ArrayList arrayList2 = new ArrayList(c2020dGArr.length);
            for (C2020dG c2020dG2 : c2020dGArr) {
                arrayList2.add(Float.valueOf(((Number) c2020dG2.c()).floatValue()));
            }
            return new SweepGradient(j, arrayList, arrayList2, null);
        }

        @Stable
        /* JADX INFO: renamed from: verticalGradient-8A-3gB4, reason: not valid java name */
        public final Brush m3005verticalGradient8A3gB4(List<Color> list, float f, float f2, int i) {
            AbstractC4492zt.h(list, "colors");
            return m2999linearGradientmHitzGk(list, OffsetKt.Offset(0.0f, f), OffsetKt.Offset(0.0f, f2), i);
        }

        private Companion() {
        }

        @Stable
        /* JADX INFO: renamed from: horizontalGradient-8A-3gB4, reason: not valid java name */
        public final Brush m2998horizontalGradient8A3gB4(C2020dG[] c2020dGArr, float f, float f2, int i) {
            AbstractC4492zt.h(c2020dGArr, "colorStops");
            return m3000linearGradientmHitzGk((C2020dG[]) Arrays.copyOf(c2020dGArr, c2020dGArr.length), OffsetKt.Offset(f, 0.0f), OffsetKt.Offset(f2, 0.0f), i);
        }

        @Stable
        /* JADX INFO: renamed from: verticalGradient-8A-3gB4, reason: not valid java name */
        public final Brush m3006verticalGradient8A3gB4(C2020dG[] c2020dGArr, float f, float f2, int i) {
            AbstractC4492zt.h(c2020dGArr, "colorStops");
            return m3000linearGradientmHitzGk((C2020dG[]) Arrays.copyOf(c2020dGArr, c2020dGArr.length), OffsetKt.Offset(0.0f, f), OffsetKt.Offset(0.0f, f2), i);
        }

        /* JADX INFO: renamed from: horizontalGradient-8A-3gB4$default, reason: not valid java name */
        public static /* synthetic */ Brush m2988horizontalGradient8A3gB4$default(Companion companion, C2020dG[] c2020dGArr, float f, float f2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                f = 0.0f;
            }
            if ((i2 & 4) != 0) {
                f2 = Float.POSITIVE_INFINITY;
            }
            if ((i2 & 8) != 0) {
                i = TileMode.Companion.m3376getClamp3opZhB0();
            }
            return companion.m2998horizontalGradient8A3gB4(c2020dGArr, f, f2, i);
        }

        /* JADX INFO: renamed from: sweepGradient-Uv8p0NA$default, reason: not valid java name */
        public static /* synthetic */ Brush m2993sweepGradientUv8p0NA$default(Companion companion, List list, long j, int i, Object obj) {
            if ((i & 2) != 0) {
                j = Offset.Companion.m2813getUnspecifiedF1C5BW0();
            }
            return companion.m3003sweepGradientUv8p0NA((List<Color>) list, j);
        }

        /* JADX INFO: renamed from: verticalGradient-8A-3gB4$default, reason: not valid java name */
        public static /* synthetic */ Brush m2996verticalGradient8A3gB4$default(Companion companion, C2020dG[] c2020dGArr, float f, float f2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                f = 0.0f;
            }
            if ((i2 & 4) != 0) {
                f2 = Float.POSITIVE_INFINITY;
            }
            if ((i2 & 8) != 0) {
                i = TileMode.Companion.m3376getClamp3opZhB0();
            }
            return companion.m3006verticalGradient8A3gB4(c2020dGArr, f, f2, i);
        }

        /* JADX INFO: renamed from: radialGradient-P_Vx-Ks$default, reason: not valid java name */
        public static /* synthetic */ Brush m2991radialGradientP_VxKs$default(Companion companion, List list, long j, float f, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                j = Offset.Companion.m2813getUnspecifiedF1C5BW0();
            }
            long j2 = j;
            float f2 = (i2 & 4) != 0 ? Float.POSITIVE_INFINITY : f;
            if ((i2 & 8) != 0) {
                i = TileMode.Companion.m3376getClamp3opZhB0();
            }
            return companion.m3001radialGradientP_VxKs((List<Color>) list, j2, f2, i);
        }

        @Stable
        /* JADX INFO: renamed from: linearGradient-mHitzGk, reason: not valid java name */
        public final Brush m2999linearGradientmHitzGk(List<Color> list, long j, long j2, int i) {
            AbstractC4492zt.h(list, "colors");
            return new LinearGradient(list, null, j, j2, i, null);
        }

        @Stable
        /* JADX INFO: renamed from: radialGradient-P_Vx-Ks, reason: not valid java name */
        public final Brush m3001radialGradientP_VxKs(List<Color> list, long j, float f, int i) {
            AbstractC4492zt.h(list, "colors");
            return new RadialGradient(list, null, j, f, i, null);
        }

        @Stable
        /* JADX INFO: renamed from: sweepGradient-Uv8p0NA, reason: not valid java name */
        public final Brush m3003sweepGradientUv8p0NA(List<Color> list, long j) {
            AbstractC4492zt.h(list, "colors");
            return new SweepGradient(j, list, null, null);
        }

        /* JADX INFO: renamed from: linearGradient-mHitzGk$default, reason: not valid java name */
        public static /* synthetic */ Brush m2989linearGradientmHitzGk$default(Companion companion, List list, long j, long j2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                j = Offset.Companion.m2814getZeroF1C5BW0();
            }
            long j3 = j;
            if ((i2 & 4) != 0) {
                j2 = Offset.Companion.m2812getInfiniteF1C5BW0();
            }
            long j4 = j2;
            if ((i2 & 8) != 0) {
                i = TileMode.Companion.m3376getClamp3opZhB0();
            }
            return companion.m2999linearGradientmHitzGk((List<Color>) list, j3, j4, i);
        }
    }

    public /* synthetic */ Brush(AbstractC0419Di abstractC0419Di) {
        this();
    }

    /* JADX INFO: renamed from: applyTo-Pq9zytI, reason: not valid java name */
    public abstract void mo2985applyToPq9zytI(long j, Paint paint, float f);

    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public long mo2986getIntrinsicSizeNHjbRc() {
        return this.intrinsicSize;
    }

    private Brush() {
        this.intrinsicSize = Size.Companion.m2875getUnspecifiedNHjbRc();
    }
}
