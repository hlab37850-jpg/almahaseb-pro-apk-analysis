package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class BlendMode {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Clear = m2949constructorimpl(0);
    private static final int Src = m2949constructorimpl(1);
    private static final int Dst = m2949constructorimpl(2);
    private static final int SrcOver = m2949constructorimpl(3);
    private static final int DstOver = m2949constructorimpl(4);
    private static final int SrcIn = m2949constructorimpl(5);
    private static final int DstIn = m2949constructorimpl(6);
    private static final int SrcOut = m2949constructorimpl(7);
    private static final int DstOut = m2949constructorimpl(8);
    private static final int SrcAtop = m2949constructorimpl(9);
    private static final int DstAtop = m2949constructorimpl(10);
    private static final int Xor = m2949constructorimpl(11);
    private static final int Plus = m2949constructorimpl(12);
    private static final int Modulate = m2949constructorimpl(13);
    private static final int Screen = m2949constructorimpl(14);
    private static final int Overlay = m2949constructorimpl(15);
    private static final int Darken = m2949constructorimpl(16);
    private static final int Lighten = m2949constructorimpl(17);
    private static final int ColorDodge = m2949constructorimpl(18);
    private static final int ColorBurn = m2949constructorimpl(19);
    private static final int Hardlight = m2949constructorimpl(20);
    private static final int Softlight = m2949constructorimpl(21);
    private static final int Difference = m2949constructorimpl(22);
    private static final int Exclusion = m2949constructorimpl(23);
    private static final int Multiply = m2949constructorimpl(24);
    private static final int Hue = m2949constructorimpl(25);
    private static final int Saturation = m2949constructorimpl(26);
    private static final int Color = m2949constructorimpl(27);
    private static final int Luminosity = m2949constructorimpl(28);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: renamed from: getClear-0nO6VwU, reason: not valid java name */
        public final int m2955getClear0nO6VwU() {
            return BlendMode.Clear;
        }

        /* JADX INFO: renamed from: getColor-0nO6VwU, reason: not valid java name */
        public final int m2956getColor0nO6VwU() {
            return BlendMode.Color;
        }

        /* JADX INFO: renamed from: getColorBurn-0nO6VwU, reason: not valid java name */
        public final int m2957getColorBurn0nO6VwU() {
            return BlendMode.ColorBurn;
        }

        /* JADX INFO: renamed from: getColorDodge-0nO6VwU, reason: not valid java name */
        public final int m2958getColorDodge0nO6VwU() {
            return BlendMode.ColorDodge;
        }

        /* JADX INFO: renamed from: getDarken-0nO6VwU, reason: not valid java name */
        public final int m2959getDarken0nO6VwU() {
            return BlendMode.Darken;
        }

        /* JADX INFO: renamed from: getDifference-0nO6VwU, reason: not valid java name */
        public final int m2960getDifference0nO6VwU() {
            return BlendMode.Difference;
        }

        /* JADX INFO: renamed from: getDst-0nO6VwU, reason: not valid java name */
        public final int m2961getDst0nO6VwU() {
            return BlendMode.Dst;
        }

        /* JADX INFO: renamed from: getDstAtop-0nO6VwU, reason: not valid java name */
        public final int m2962getDstAtop0nO6VwU() {
            return BlendMode.DstAtop;
        }

        /* JADX INFO: renamed from: getDstIn-0nO6VwU, reason: not valid java name */
        public final int m2963getDstIn0nO6VwU() {
            return BlendMode.DstIn;
        }

        /* JADX INFO: renamed from: getDstOut-0nO6VwU, reason: not valid java name */
        public final int m2964getDstOut0nO6VwU() {
            return BlendMode.DstOut;
        }

        /* JADX INFO: renamed from: getDstOver-0nO6VwU, reason: not valid java name */
        public final int m2965getDstOver0nO6VwU() {
            return BlendMode.DstOver;
        }

        /* JADX INFO: renamed from: getExclusion-0nO6VwU, reason: not valid java name */
        public final int m2966getExclusion0nO6VwU() {
            return BlendMode.Exclusion;
        }

        /* JADX INFO: renamed from: getHardlight-0nO6VwU, reason: not valid java name */
        public final int m2967getHardlight0nO6VwU() {
            return BlendMode.Hardlight;
        }

        /* JADX INFO: renamed from: getHue-0nO6VwU, reason: not valid java name */
        public final int m2968getHue0nO6VwU() {
            return BlendMode.Hue;
        }

        /* JADX INFO: renamed from: getLighten-0nO6VwU, reason: not valid java name */
        public final int m2969getLighten0nO6VwU() {
            return BlendMode.Lighten;
        }

        /* JADX INFO: renamed from: getLuminosity-0nO6VwU, reason: not valid java name */
        public final int m2970getLuminosity0nO6VwU() {
            return BlendMode.Luminosity;
        }

        /* JADX INFO: renamed from: getModulate-0nO6VwU, reason: not valid java name */
        public final int m2971getModulate0nO6VwU() {
            return BlendMode.Modulate;
        }

        /* JADX INFO: renamed from: getMultiply-0nO6VwU, reason: not valid java name */
        public final int m2972getMultiply0nO6VwU() {
            return BlendMode.Multiply;
        }

        /* JADX INFO: renamed from: getOverlay-0nO6VwU, reason: not valid java name */
        public final int m2973getOverlay0nO6VwU() {
            return BlendMode.Overlay;
        }

        /* JADX INFO: renamed from: getPlus-0nO6VwU, reason: not valid java name */
        public final int m2974getPlus0nO6VwU() {
            return BlendMode.Plus;
        }

        /* JADX INFO: renamed from: getSaturation-0nO6VwU, reason: not valid java name */
        public final int m2975getSaturation0nO6VwU() {
            return BlendMode.Saturation;
        }

        /* JADX INFO: renamed from: getScreen-0nO6VwU, reason: not valid java name */
        public final int m2976getScreen0nO6VwU() {
            return BlendMode.Screen;
        }

        /* JADX INFO: renamed from: getSoftlight-0nO6VwU, reason: not valid java name */
        public final int m2977getSoftlight0nO6VwU() {
            return BlendMode.Softlight;
        }

        /* JADX INFO: renamed from: getSrc-0nO6VwU, reason: not valid java name */
        public final int m2978getSrc0nO6VwU() {
            return BlendMode.Src;
        }

        /* JADX INFO: renamed from: getSrcAtop-0nO6VwU, reason: not valid java name */
        public final int m2979getSrcAtop0nO6VwU() {
            return BlendMode.SrcAtop;
        }

        /* JADX INFO: renamed from: getSrcIn-0nO6VwU, reason: not valid java name */
        public final int m2980getSrcIn0nO6VwU() {
            return BlendMode.SrcIn;
        }

        /* JADX INFO: renamed from: getSrcOut-0nO6VwU, reason: not valid java name */
        public final int m2981getSrcOut0nO6VwU() {
            return BlendMode.SrcOut;
        }

        /* JADX INFO: renamed from: getSrcOver-0nO6VwU, reason: not valid java name */
        public final int m2982getSrcOver0nO6VwU() {
            return BlendMode.SrcOver;
        }

        /* JADX INFO: renamed from: getXor-0nO6VwU, reason: not valid java name */
        public final int m2983getXor0nO6VwU() {
            return BlendMode.Xor;
        }

        private Companion() {
        }
    }

    private /* synthetic */ BlendMode(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ BlendMode m2948boximpl(int i) {
        return new BlendMode(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m2949constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2950equalsimpl(int i, Object obj) {
        return (obj instanceof BlendMode) && i == ((BlendMode) obj).m2954unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2951equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2952hashCodeimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2953toStringimpl(int i) {
        if (m2951equalsimpl0(i, Clear)) {
            return "Clear";
        }
        if (m2951equalsimpl0(i, Src)) {
            return "Src";
        }
        if (m2951equalsimpl0(i, Dst)) {
            return "Dst";
        }
        if (m2951equalsimpl0(i, SrcOver)) {
            return "SrcOver";
        }
        if (m2951equalsimpl0(i, DstOver)) {
            return "DstOver";
        }
        if (m2951equalsimpl0(i, SrcIn)) {
            return "SrcIn";
        }
        if (m2951equalsimpl0(i, DstIn)) {
            return "DstIn";
        }
        if (m2951equalsimpl0(i, SrcOut)) {
            return "SrcOut";
        }
        if (m2951equalsimpl0(i, DstOut)) {
            return "DstOut";
        }
        if (m2951equalsimpl0(i, SrcAtop)) {
            return "SrcAtop";
        }
        if (m2951equalsimpl0(i, DstAtop)) {
            return "DstAtop";
        }
        if (m2951equalsimpl0(i, Xor)) {
            return "Xor";
        }
        if (m2951equalsimpl0(i, Plus)) {
            return "Plus";
        }
        if (m2951equalsimpl0(i, Modulate)) {
            return "Modulate";
        }
        if (m2951equalsimpl0(i, Screen)) {
            return "Screen";
        }
        if (m2951equalsimpl0(i, Overlay)) {
            return "Overlay";
        }
        if (m2951equalsimpl0(i, Darken)) {
            return "Darken";
        }
        if (m2951equalsimpl0(i, Lighten)) {
            return "Lighten";
        }
        if (m2951equalsimpl0(i, ColorDodge)) {
            return "ColorDodge";
        }
        if (m2951equalsimpl0(i, ColorBurn)) {
            return "ColorBurn";
        }
        if (m2951equalsimpl0(i, Hardlight)) {
            return "HardLight";
        }
        if (m2951equalsimpl0(i, Softlight)) {
            return "Softlight";
        }
        if (m2951equalsimpl0(i, Difference)) {
            return "Difference";
        }
        if (m2951equalsimpl0(i, Exclusion)) {
            return "Exclusion";
        }
        if (m2951equalsimpl0(i, Multiply)) {
            return "Multiply";
        }
        if (m2951equalsimpl0(i, Hue)) {
            return "Hue";
        }
        if (m2951equalsimpl0(i, Saturation)) {
            return "Saturation";
        }
        if (m2951equalsimpl0(i, Color)) {
            return "Color";
        }
        return m2951equalsimpl0(i, Luminosity) ? "Luminosity" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m2950equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2952hashCodeimpl(this.value);
    }

    public String toString() {
        return m2953toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2954unboximpl() {
        return this.value;
    }
}
