package androidx.compose.material3;

import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
final class ListItemType implements Comparable<ListItemType> {
    private final int lines;
    public static final Companion Companion = new Companion(null);
    private static final int OneLine = m1633constructorimpl(1);
    private static final int TwoLine = m1633constructorimpl(2);
    private static final int ThreeLine = m1633constructorimpl(3);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: renamed from: getListItemType-7AlIA9s$material3_release, reason: not valid java name */
        public final int m1640getListItemType7AlIA9s$material3_release(boolean z, boolean z2) {
            if (z && z2) {
                return m1642getThreeLineAlXitO8();
            }
            return (z || z2) ? m1643getTwoLineAlXitO8() : m1641getOneLineAlXitO8();
        }

        /* JADX INFO: renamed from: getOneLine-AlXitO8, reason: not valid java name */
        public final int m1641getOneLineAlXitO8() {
            return ListItemType.OneLine;
        }

        /* JADX INFO: renamed from: getThreeLine-AlXitO8, reason: not valid java name */
        public final int m1642getThreeLineAlXitO8() {
            return ListItemType.ThreeLine;
        }

        /* JADX INFO: renamed from: getTwoLine-AlXitO8, reason: not valid java name */
        public final int m1643getTwoLineAlXitO8() {
            return ListItemType.TwoLine;
        }

        private Companion() {
        }
    }

    private /* synthetic */ ListItemType(int i) {
        this.lines = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ListItemType m1631boximpl(int i) {
        return new ListItemType(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m1633constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1634equalsimpl(int i, Object obj) {
        return (obj instanceof ListItemType) && i == ((ListItemType) obj).m1639unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1635equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1636hashCodeimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1637toStringimpl(int i) {
        return "ListItemType(lines=" + i + ')';
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ListItemType listItemType) {
        return m1638compareToyh95HIg(listItemType.m1639unboximpl());
    }

    /* JADX INFO: renamed from: compareTo-yh95HIg, reason: not valid java name */
    public int m1638compareToyh95HIg(int i) {
        return m1632compareToyh95HIg(this.lines, i);
    }

    public boolean equals(Object obj) {
        return m1634equalsimpl(this.lines, obj);
    }

    public int hashCode() {
        return m1636hashCodeimpl(this.lines);
    }

    public String toString() {
        return m1637toStringimpl(this.lines);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1639unboximpl() {
        return this.lines;
    }

    /* JADX INFO: renamed from: compareTo-yh95HIg, reason: not valid java name */
    public static int m1632compareToyh95HIg(int i, int i2) {
        return AbstractC4492zt.j(i, i2);
    }
}
