package androidx.compose.ui.text.font;

import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
public final class FontSynthesis {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int None = m4808constructorimpl(0);
    private static final int All = m4808constructorimpl(1);
    private static final int Weight = m4808constructorimpl(2);
    private static final int Style = m4808constructorimpl(3);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: renamed from: getAll-GVVA2EU, reason: not valid java name */
        public final int m4816getAllGVVA2EU() {
            return FontSynthesis.All;
        }

        /* JADX INFO: renamed from: getNone-GVVA2EU, reason: not valid java name */
        public final int m4817getNoneGVVA2EU() {
            return FontSynthesis.None;
        }

        /* JADX INFO: renamed from: getStyle-GVVA2EU, reason: not valid java name */
        public final int m4818getStyleGVVA2EU() {
            return FontSynthesis.Style;
        }

        /* JADX INFO: renamed from: getWeight-GVVA2EU, reason: not valid java name */
        public final int m4819getWeightGVVA2EU() {
            return FontSynthesis.Weight;
        }

        private Companion() {
        }
    }

    private /* synthetic */ FontSynthesis(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FontSynthesis m4807boximpl(int i) {
        return new FontSynthesis(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m4808constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4809equalsimpl(int i, Object obj) {
        return (obj instanceof FontSynthesis) && i == ((FontSynthesis) obj).m4815unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4810equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4811hashCodeimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: isStyleOn-impl$ui_text_release, reason: not valid java name */
    public static final boolean m4812isStyleOnimpl$ui_text_release(int i) {
        return m4810equalsimpl0(i, All) || m4810equalsimpl0(i, Style);
    }

    /* JADX INFO: renamed from: isWeightOn-impl$ui_text_release, reason: not valid java name */
    public static final boolean m4813isWeightOnimpl$ui_text_release(int i) {
        return m4810equalsimpl0(i, All) || m4810equalsimpl0(i, Weight);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4814toStringimpl(int i) {
        if (m4810equalsimpl0(i, None)) {
            return "None";
        }
        if (m4810equalsimpl0(i, All)) {
            return "All";
        }
        if (m4810equalsimpl0(i, Weight)) {
            return "Weight";
        }
        return m4810equalsimpl0(i, Style) ? "Style" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m4809equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4811hashCodeimpl(this.value);
    }

    public String toString() {
        return m4814toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m4815unboximpl() {
        return this.value;
    }
}
