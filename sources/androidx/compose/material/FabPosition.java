package androidx.compose.material;

import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
public final class FabPosition {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Center = m1123constructorimpl(0);
    private static final int End = m1123constructorimpl(1);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: renamed from: getCenter-5ygKITE, reason: not valid java name */
        public final int m1129getCenter5ygKITE() {
            return FabPosition.Center;
        }

        /* JADX INFO: renamed from: getEnd-5ygKITE, reason: not valid java name */
        public final int m1130getEnd5ygKITE() {
            return FabPosition.End;
        }

        private Companion() {
        }
    }

    private /* synthetic */ FabPosition(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FabPosition m1122boximpl(int i) {
        return new FabPosition(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1123constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1124equalsimpl(int i, Object obj) {
        return (obj instanceof FabPosition) && i == ((FabPosition) obj).m1128unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1125equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1126hashCodeimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1127toStringimpl(int i) {
        return m1125equalsimpl0(i, Center) ? "FabPosition.Center" : "FabPosition.End";
    }

    public boolean equals(Object obj) {
        return m1124equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1126hashCodeimpl(this.value);
    }

    public String toString() {
        return m1127toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1128unboximpl() {
        return this.value;
    }
}
