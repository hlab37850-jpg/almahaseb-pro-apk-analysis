package androidx.compose.material.ripple;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;

/* JADX INFO: loaded from: classes.dex */
public interface RippleTheme {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* JADX INFO: renamed from: defaultRippleAlpha-DxMtmZc, reason: not valid java name */
        public final RippleAlpha m1319defaultRippleAlphaDxMtmZc(long j, boolean z) {
            if (z) {
                return ((double) ColorKt.m3084luminance8_81llA(j)) > 0.5d ? RippleThemeKt.LightThemeHighContrastRippleAlpha : RippleThemeKt.LightThemeLowContrastRippleAlpha;
            }
            return RippleThemeKt.DarkThemeRippleAlpha;
        }

        /* JADX INFO: renamed from: defaultRippleColor-5vOe2sY, reason: not valid java name */
        public final long m1320defaultRippleColor5vOe2sY(long j, boolean z) {
            return (z || ((double) ColorKt.m3084luminance8_81llA(j)) >= 0.5d) ? j : Color.Companion.m3069getWhite0d7_KjU();
        }
    }

    @Composable
    /* JADX INFO: renamed from: defaultColor-WaAFU9c */
    long mo1144defaultColorWaAFU9c(Composer composer, int i);

    @Composable
    RippleAlpha rippleAlpha(Composer composer, int i);
}
