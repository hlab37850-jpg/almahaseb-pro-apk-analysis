package androidx.compose.ui.layout;

import defpackage.AbstractC0419Di;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public interface BeyondBoundsLayout {

    public interface BeyondBoundsScope {
        boolean getHasMoreContent();
    }

    public static final class LayoutDirection {
        private final int value;
        public static final Companion Companion = new Companion(null);
        private static final int Before = m4137constructorimpl(1);
        private static final int After = m4137constructorimpl(2);
        private static final int Left = m4137constructorimpl(3);
        private static final int Right = m4137constructorimpl(4);
        private static final int Above = m4137constructorimpl(5);
        private static final int Below = m4137constructorimpl(6);

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
                this();
            }

            /* JADX INFO: renamed from: getAbove-hoxUOeE, reason: not valid java name */
            public final int m4143getAbovehoxUOeE() {
                return LayoutDirection.Above;
            }

            /* JADX INFO: renamed from: getAfter-hoxUOeE, reason: not valid java name */
            public final int m4144getAfterhoxUOeE() {
                return LayoutDirection.After;
            }

            /* JADX INFO: renamed from: getBefore-hoxUOeE, reason: not valid java name */
            public final int m4145getBeforehoxUOeE() {
                return LayoutDirection.Before;
            }

            /* JADX INFO: renamed from: getBelow-hoxUOeE, reason: not valid java name */
            public final int m4146getBelowhoxUOeE() {
                return LayoutDirection.Below;
            }

            /* JADX INFO: renamed from: getLeft-hoxUOeE, reason: not valid java name */
            public final int m4147getLefthoxUOeE() {
                return LayoutDirection.Left;
            }

            /* JADX INFO: renamed from: getRight-hoxUOeE, reason: not valid java name */
            public final int m4148getRighthoxUOeE() {
                return LayoutDirection.Right;
            }

            private Companion() {
            }
        }

        private /* synthetic */ LayoutDirection(int i) {
            this.value = i;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ LayoutDirection m4136boximpl(int i) {
            return new LayoutDirection(i);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m4137constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m4138equalsimpl(int i, Object obj) {
            return (obj instanceof LayoutDirection) && i == ((LayoutDirection) obj).m4142unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m4139equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m4140hashCodeimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m4141toStringimpl(int i) {
            if (m4139equalsimpl0(i, Before)) {
                return "Before";
            }
            if (m4139equalsimpl0(i, After)) {
                return "After";
            }
            if (m4139equalsimpl0(i, Left)) {
                return "Left";
            }
            if (m4139equalsimpl0(i, Right)) {
                return "Right";
            }
            if (m4139equalsimpl0(i, Above)) {
                return "Above";
            }
            return m4139equalsimpl0(i, Below) ? "Below" : "invalid LayoutDirection";
        }

        public boolean equals(Object obj) {
            return m4138equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m4140hashCodeimpl(this.value);
        }

        public String toString() {
            return m4141toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m4142unboximpl() {
            return this.value;
        }
    }

    /* JADX INFO: renamed from: layout-o7g1Pn8 */
    <T> T mo637layouto7g1Pn8(int i, InterfaceC3750qp interfaceC3750qp);
}
