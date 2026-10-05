package androidx.compose.ui.text.style;

import androidx.compose.runtime.Stable;
import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
public final class TextOverflow {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Clip = m5104constructorimpl(1);
    private static final int Ellipsis = m5104constructorimpl(2);
    private static final int Visible = m5104constructorimpl(3);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        @Stable
        /* JADX INFO: renamed from: getClip-gIe3tQ8$annotations, reason: not valid java name */
        public static /* synthetic */ void m5110getClipgIe3tQ8$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getEllipsis-gIe3tQ8$annotations, reason: not valid java name */
        public static /* synthetic */ void m5111getEllipsisgIe3tQ8$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getVisible-gIe3tQ8$annotations, reason: not valid java name */
        public static /* synthetic */ void m5112getVisiblegIe3tQ8$annotations() {
        }

        /* JADX INFO: renamed from: getClip-gIe3tQ8, reason: not valid java name */
        public final int m5113getClipgIe3tQ8() {
            return TextOverflow.Clip;
        }

        /* JADX INFO: renamed from: getEllipsis-gIe3tQ8, reason: not valid java name */
        public final int m5114getEllipsisgIe3tQ8() {
            return TextOverflow.Ellipsis;
        }

        /* JADX INFO: renamed from: getVisible-gIe3tQ8, reason: not valid java name */
        public final int m5115getVisiblegIe3tQ8() {
            return TextOverflow.Visible;
        }

        private Companion() {
        }
    }

    private /* synthetic */ TextOverflow(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextOverflow m5103boximpl(int i) {
        return new TextOverflow(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m5104constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5105equalsimpl(int i, Object obj) {
        return (obj instanceof TextOverflow) && i == ((TextOverflow) obj).m5109unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5106equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5107hashCodeimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5108toStringimpl(int i) {
        if (m5106equalsimpl0(i, Clip)) {
            return "Clip";
        }
        if (m5106equalsimpl0(i, Ellipsis)) {
            return "Ellipsis";
        }
        return m5106equalsimpl0(i, Visible) ? "Visible" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m5105equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5107hashCodeimpl(this.value);
    }

    public String toString() {
        return m5108toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m5109unboximpl() {
        return this.value;
    }
}
