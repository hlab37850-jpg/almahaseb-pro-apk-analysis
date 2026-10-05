package androidx.compose.ui.text.style;

import defpackage.AbstractC0419Di;
import defpackage.AbstractC1886cc;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class TextAlign {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Left = m5060constructorimpl(1);
    private static final int Right = m5060constructorimpl(2);
    private static final int Center = m5060constructorimpl(3);
    private static final int Justify = m5060constructorimpl(4);
    private static final int Start = m5060constructorimpl(5);
    private static final int End = m5060constructorimpl(6);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: renamed from: getCenter-e0LSkKk, reason: not valid java name */
        public final int m5066getCentere0LSkKk() {
            return TextAlign.Center;
        }

        /* JADX INFO: renamed from: getEnd-e0LSkKk, reason: not valid java name */
        public final int m5067getEnde0LSkKk() {
            return TextAlign.End;
        }

        /* JADX INFO: renamed from: getJustify-e0LSkKk, reason: not valid java name */
        public final int m5068getJustifye0LSkKk() {
            return TextAlign.Justify;
        }

        /* JADX INFO: renamed from: getLeft-e0LSkKk, reason: not valid java name */
        public final int m5069getLefte0LSkKk() {
            return TextAlign.Left;
        }

        /* JADX INFO: renamed from: getRight-e0LSkKk, reason: not valid java name */
        public final int m5070getRighte0LSkKk() {
            return TextAlign.Right;
        }

        /* JADX INFO: renamed from: getStart-e0LSkKk, reason: not valid java name */
        public final int m5071getStarte0LSkKk() {
            return TextAlign.Start;
        }

        public final List<TextAlign> values() {
            return AbstractC1886cc.p(TextAlign.m5059boximpl(m5069getLefte0LSkKk()), TextAlign.m5059boximpl(m5070getRighte0LSkKk()), TextAlign.m5059boximpl(m5066getCentere0LSkKk()), TextAlign.m5059boximpl(m5068getJustifye0LSkKk()), TextAlign.m5059boximpl(m5071getStarte0LSkKk()), TextAlign.m5059boximpl(m5067getEnde0LSkKk()));
        }

        private Companion() {
        }
    }

    private /* synthetic */ TextAlign(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextAlign m5059boximpl(int i) {
        return new TextAlign(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m5060constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5061equalsimpl(int i, Object obj) {
        return (obj instanceof TextAlign) && i == ((TextAlign) obj).m5065unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5062equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5063hashCodeimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5064toStringimpl(int i) {
        if (m5062equalsimpl0(i, Left)) {
            return "Left";
        }
        if (m5062equalsimpl0(i, Right)) {
            return "Right";
        }
        if (m5062equalsimpl0(i, Center)) {
            return "Center";
        }
        if (m5062equalsimpl0(i, Justify)) {
            return "Justify";
        }
        if (m5062equalsimpl0(i, Start)) {
            return "Start";
        }
        return m5062equalsimpl0(i, End) ? "End" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m5061equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5063hashCodeimpl(this.value);
    }

    public String toString() {
        return m5064toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m5065unboximpl() {
        return this.value;
    }
}
