package androidx.compose.material3;

import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
public final class Selection {
    public static final Companion Companion = new Companion(null);
    private static final int Hour = m1744constructorimpl(0);
    private static final int Minute = m1744constructorimpl(1);
    private final int value;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: renamed from: getHour-JiIwxys, reason: not valid java name */
        public final int m1750getHourJiIwxys() {
            return Selection.Hour;
        }

        /* JADX INFO: renamed from: getMinute-JiIwxys, reason: not valid java name */
        public final int m1751getMinuteJiIwxys() {
            return Selection.Minute;
        }

        private Companion() {
        }
    }

    private /* synthetic */ Selection(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Selection m1743boximpl(int i) {
        return new Selection(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m1744constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1745equalsimpl(int i, Object obj) {
        return (obj instanceof Selection) && i == ((Selection) obj).m1749unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1746equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1747hashCodeimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1748toStringimpl(int i) {
        return "Selection(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m1745equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m1747hashCodeimpl(this.value);
    }

    public String toString() {
        return m1748toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1749unboximpl() {
        return this.value;
    }
}
