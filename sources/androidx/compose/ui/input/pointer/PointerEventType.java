package androidx.compose.ui.input.pointer;

import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
public final class PointerEventType {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Unknown = m4001constructorimpl(0);
    private static final int Press = m4001constructorimpl(1);
    private static final int Release = m4001constructorimpl(2);
    private static final int Move = m4001constructorimpl(3);
    private static final int Enter = m4001constructorimpl(4);
    private static final int Exit = m4001constructorimpl(5);
    private static final int Scroll = m4001constructorimpl(6);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: renamed from: getEnter-7fucELk, reason: not valid java name */
        public final int m4007getEnter7fucELk() {
            return PointerEventType.Enter;
        }

        /* JADX INFO: renamed from: getExit-7fucELk, reason: not valid java name */
        public final int m4008getExit7fucELk() {
            return PointerEventType.Exit;
        }

        /* JADX INFO: renamed from: getMove-7fucELk, reason: not valid java name */
        public final int m4009getMove7fucELk() {
            return PointerEventType.Move;
        }

        /* JADX INFO: renamed from: getPress-7fucELk, reason: not valid java name */
        public final int m4010getPress7fucELk() {
            return PointerEventType.Press;
        }

        /* JADX INFO: renamed from: getRelease-7fucELk, reason: not valid java name */
        public final int m4011getRelease7fucELk() {
            return PointerEventType.Release;
        }

        /* JADX INFO: renamed from: getScroll-7fucELk, reason: not valid java name */
        public final int m4012getScroll7fucELk() {
            return PointerEventType.Scroll;
        }

        /* JADX INFO: renamed from: getUnknown-7fucELk, reason: not valid java name */
        public final int m4013getUnknown7fucELk() {
            return PointerEventType.Unknown;
        }

        private Companion() {
        }
    }

    private /* synthetic */ PointerEventType(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PointerEventType m4000boximpl(int i) {
        return new PointerEventType(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m4001constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4002equalsimpl(int i, Object obj) {
        return (obj instanceof PointerEventType) && i == ((PointerEventType) obj).m4006unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4003equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4004hashCodeimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4005toStringimpl(int i) {
        if (m4003equalsimpl0(i, Press)) {
            return "Press";
        }
        if (m4003equalsimpl0(i, Release)) {
            return "Release";
        }
        if (m4003equalsimpl0(i, Move)) {
            return "Move";
        }
        if (m4003equalsimpl0(i, Enter)) {
            return "Enter";
        }
        if (m4003equalsimpl0(i, Exit)) {
            return "Exit";
        }
        return m4003equalsimpl0(i, Scroll) ? "Scroll" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m4002equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4004hashCodeimpl(this.value);
    }

    public String toString() {
        return m4005toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m4006unboximpl() {
        return this.value;
    }
}
