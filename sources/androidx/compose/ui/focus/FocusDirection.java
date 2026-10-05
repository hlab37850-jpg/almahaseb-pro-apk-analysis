package androidx.compose.ui.focus;

import androidx.compose.ui.ExperimentalComposeUiApi;
import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
public final class FocusDirection {
    private static final int Enter;
    private static final int Exit;
    private static final int In;
    private static final int Out;
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Next = m2712constructorimpl(1);
    private static final int Previous = m2712constructorimpl(2);
    private static final int Left = m2712constructorimpl(3);
    private static final int Right = m2712constructorimpl(4);
    private static final int Up = m2712constructorimpl(5);
    private static final int Down = m2712constructorimpl(6);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        @ExperimentalComposeUiApi
        /* JADX INFO: renamed from: getEnter-dhqQ-8s$annotations, reason: not valid java name */
        public static /* synthetic */ void m2718getEnterdhqQ8s$annotations() {
        }

        @ExperimentalComposeUiApi
        /* JADX INFO: renamed from: getExit-dhqQ-8s$annotations, reason: not valid java name */
        public static /* synthetic */ void m2719getExitdhqQ8s$annotations() {
        }

        @ExperimentalComposeUiApi
        /* JADX INFO: renamed from: getIn-dhqQ-8s$annotations, reason: not valid java name */
        public static /* synthetic */ void m2720getIndhqQ8s$annotations() {
        }

        @ExperimentalComposeUiApi
        /* JADX INFO: renamed from: getOut-dhqQ-8s$annotations, reason: not valid java name */
        public static /* synthetic */ void m2721getOutdhqQ8s$annotations() {
        }

        /* JADX INFO: renamed from: getDown-dhqQ-8s, reason: not valid java name */
        public final int m2722getDowndhqQ8s() {
            return FocusDirection.Down;
        }

        @ExperimentalComposeUiApi
        /* JADX INFO: renamed from: getEnter-dhqQ-8s, reason: not valid java name */
        public final int m2723getEnterdhqQ8s() {
            return FocusDirection.Enter;
        }

        @ExperimentalComposeUiApi
        /* JADX INFO: renamed from: getExit-dhqQ-8s, reason: not valid java name */
        public final int m2724getExitdhqQ8s() {
            return FocusDirection.Exit;
        }

        @ExperimentalComposeUiApi
        /* JADX INFO: renamed from: getIn-dhqQ-8s, reason: not valid java name */
        public final int m2725getIndhqQ8s() {
            return FocusDirection.In;
        }

        /* JADX INFO: renamed from: getLeft-dhqQ-8s, reason: not valid java name */
        public final int m2726getLeftdhqQ8s() {
            return FocusDirection.Left;
        }

        /* JADX INFO: renamed from: getNext-dhqQ-8s, reason: not valid java name */
        public final int m2727getNextdhqQ8s() {
            return FocusDirection.Next;
        }

        @ExperimentalComposeUiApi
        /* JADX INFO: renamed from: getOut-dhqQ-8s, reason: not valid java name */
        public final int m2728getOutdhqQ8s() {
            return FocusDirection.Out;
        }

        /* JADX INFO: renamed from: getPrevious-dhqQ-8s, reason: not valid java name */
        public final int m2729getPreviousdhqQ8s() {
            return FocusDirection.Previous;
        }

        /* JADX INFO: renamed from: getRight-dhqQ-8s, reason: not valid java name */
        public final int m2730getRightdhqQ8s() {
            return FocusDirection.Right;
        }

        /* JADX INFO: renamed from: getUp-dhqQ-8s, reason: not valid java name */
        public final int m2731getUpdhqQ8s() {
            return FocusDirection.Up;
        }

        private Companion() {
        }
    }

    static {
        int iM2712constructorimpl = m2712constructorimpl(7);
        Enter = iM2712constructorimpl;
        int iM2712constructorimpl2 = m2712constructorimpl(8);
        Exit = iM2712constructorimpl2;
        In = iM2712constructorimpl;
        Out = iM2712constructorimpl2;
    }

    private /* synthetic */ FocusDirection(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FocusDirection m2711boximpl(int i) {
        return new FocusDirection(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m2712constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2713equalsimpl(int i, Object obj) {
        return (obj instanceof FocusDirection) && i == ((FocusDirection) obj).m2717unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2714equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2715hashCodeimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2716toStringimpl(int i) {
        if (m2714equalsimpl0(i, Next)) {
            return "Next";
        }
        if (m2714equalsimpl0(i, Previous)) {
            return "Previous";
        }
        if (m2714equalsimpl0(i, Left)) {
            return "Left";
        }
        if (m2714equalsimpl0(i, Right)) {
            return "Right";
        }
        if (m2714equalsimpl0(i, Up)) {
            return "Up";
        }
        if (m2714equalsimpl0(i, Down)) {
            return "Down";
        }
        if (m2714equalsimpl0(i, Enter)) {
            return "Enter";
        }
        return m2714equalsimpl0(i, Exit) ? "Exit" : "Invalid FocusDirection";
    }

    public boolean equals(Object obj) {
        return m2713equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2715hashCodeimpl(this.value);
    }

    public String toString() {
        return m2716toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2717unboximpl() {
        return this.value;
    }
}
