package androidx.compose.ui.text.style;

import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
public final class TextDirection {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Ltr = m5073constructorimpl(1);
    private static final int Rtl = m5073constructorimpl(2);
    private static final int Content = m5073constructorimpl(3);
    private static final int ContentOrLtr = m5073constructorimpl(4);
    private static final int ContentOrRtl = m5073constructorimpl(5);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: renamed from: getContent-s_7X-co, reason: not valid java name */
        public final int m5079getContents_7Xco() {
            return TextDirection.Content;
        }

        /* JADX INFO: renamed from: getContentOrLtr-s_7X-co, reason: not valid java name */
        public final int m5080getContentOrLtrs_7Xco() {
            return TextDirection.ContentOrLtr;
        }

        /* JADX INFO: renamed from: getContentOrRtl-s_7X-co, reason: not valid java name */
        public final int m5081getContentOrRtls_7Xco() {
            return TextDirection.ContentOrRtl;
        }

        /* JADX INFO: renamed from: getLtr-s_7X-co, reason: not valid java name */
        public final int m5082getLtrs_7Xco() {
            return TextDirection.Ltr;
        }

        /* JADX INFO: renamed from: getRtl-s_7X-co, reason: not valid java name */
        public final int m5083getRtls_7Xco() {
            return TextDirection.Rtl;
        }

        private Companion() {
        }
    }

    private /* synthetic */ TextDirection(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextDirection m5072boximpl(int i) {
        return new TextDirection(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m5073constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5074equalsimpl(int i, Object obj) {
        return (obj instanceof TextDirection) && i == ((TextDirection) obj).m5078unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5075equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5076hashCodeimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5077toStringimpl(int i) {
        if (m5075equalsimpl0(i, Ltr)) {
            return "Ltr";
        }
        if (m5075equalsimpl0(i, Rtl)) {
            return "Rtl";
        }
        if (m5075equalsimpl0(i, Content)) {
            return "Content";
        }
        if (m5075equalsimpl0(i, ContentOrLtr)) {
            return "ContentOrLtr";
        }
        return m5075equalsimpl0(i, ContentOrRtl) ? "ContentOrRtl" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m5074equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5076hashCodeimpl(this.value);
    }

    public String toString() {
        return m5077toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m5078unboximpl() {
        return this.value;
    }
}
