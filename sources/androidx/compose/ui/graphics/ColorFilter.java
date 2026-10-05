package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class ColorFilter {
    public static final Companion Companion = new Companion(null);
    private final android.graphics.ColorFilter nativeColorFilter;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: renamed from: tint-xETnrds$default, reason: not valid java name */
        public static /* synthetic */ ColorFilter m3073tintxETnrds$default(Companion companion, long j, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = BlendMode.Companion.m2980getSrcIn0nO6VwU();
            }
            return companion.m3076tintxETnrds(j, i);
        }

        @Stable
        /* JADX INFO: renamed from: colorMatrix-jHG-Opc, reason: not valid java name */
        public final ColorFilter m3074colorMatrixjHGOpc(float[] fArr) {
            AbstractC4492zt.h(fArr, "colorMatrix");
            return AndroidColorFilter_androidKt.m2904actualColorMatrixColorFilterjHGOpc(fArr);
        }

        @Stable
        /* JADX INFO: renamed from: lighting--OWjLjI, reason: not valid java name */
        public final ColorFilter m3075lightingOWjLjI(long j, long j2) {
            return AndroidColorFilter_androidKt.m2905actualLightingColorFilterOWjLjI(j, j2);
        }

        @Stable
        /* JADX INFO: renamed from: tint-xETnrds, reason: not valid java name */
        public final ColorFilter m3076tintxETnrds(long j, int i) {
            return AndroidColorFilter_androidKt.m2906actualTintColorFilterxETnrds(j, i);
        }

        private Companion() {
        }
    }

    public ColorFilter(android.graphics.ColorFilter colorFilter) {
        AbstractC4492zt.h(colorFilter, "nativeColorFilter");
        this.nativeColorFilter = colorFilter;
    }

    public final android.graphics.ColorFilter getNativeColorFilter$ui_graphics_release() {
        return this.nativeColorFilter;
    }
}
