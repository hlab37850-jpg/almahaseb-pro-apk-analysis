package androidx.compose.ui.node;

import defpackage.AbstractC4492zt;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class Snake {
    private final int[] data;

    private /* synthetic */ Snake(int[] iArr) {
        this.data = iArr;
    }

    /* JADX INFO: renamed from: addDiagonalToStack-impl, reason: not valid java name */
    public static final void m4435addDiagonalToStackimpl(int[] iArr, IntStack intStack) {
        AbstractC4492zt.h(intStack, "diagonals");
        if (!m4443getHasAdditionOrRemovalimpl(iArr)) {
            intStack.pushDiagonal(m4445getStartXimpl(iArr), m4446getStartYimpl(iArr), m4441getEndXimpl(iArr) - m4445getStartXimpl(iArr));
            return;
        }
        if (m4444getReverseimpl(iArr)) {
            intStack.pushDiagonal(m4445getStartXimpl(iArr), m4446getStartYimpl(iArr), m4440getDiagonalSizeimpl(iArr));
        } else if (m4448isAdditionimpl(iArr)) {
            intStack.pushDiagonal(m4445getStartXimpl(iArr), m4446getStartYimpl(iArr) + 1, m4440getDiagonalSizeimpl(iArr));
        } else {
            intStack.pushDiagonal(m4445getStartXimpl(iArr) + 1, m4446getStartYimpl(iArr), m4440getDiagonalSizeimpl(iArr));
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Snake m4436boximpl(int[] iArr) {
        return new Snake(iArr);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int[] m4437constructorimpl(int[] iArr) {
        AbstractC4492zt.h(iArr, "data");
        return iArr;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4438equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof Snake) && AbstractC4492zt.d(iArr, ((Snake) obj).m4450unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4439equalsimpl0(int[] iArr, int[] iArr2) {
        return AbstractC4492zt.d(iArr, iArr2);
    }

    /* JADX INFO: renamed from: getDiagonalSize-impl, reason: not valid java name */
    public static final int m4440getDiagonalSizeimpl(int[] iArr) {
        return Math.min(m4441getEndXimpl(iArr) - m4445getStartXimpl(iArr), m4442getEndYimpl(iArr) - m4446getStartYimpl(iArr));
    }

    /* JADX INFO: renamed from: getEndX-impl, reason: not valid java name */
    public static final int m4441getEndXimpl(int[] iArr) {
        return iArr[2];
    }

    /* JADX INFO: renamed from: getEndY-impl, reason: not valid java name */
    public static final int m4442getEndYimpl(int[] iArr) {
        return iArr[3];
    }

    /* JADX INFO: renamed from: getHasAdditionOrRemoval-impl, reason: not valid java name */
    private static final boolean m4443getHasAdditionOrRemovalimpl(int[] iArr) {
        return m4442getEndYimpl(iArr) - m4446getStartYimpl(iArr) != m4441getEndXimpl(iArr) - m4445getStartXimpl(iArr);
    }

    /* JADX INFO: renamed from: getReverse-impl, reason: not valid java name */
    public static final boolean m4444getReverseimpl(int[] iArr) {
        return iArr[4] != 0;
    }

    /* JADX INFO: renamed from: getStartX-impl, reason: not valid java name */
    public static final int m4445getStartXimpl(int[] iArr) {
        return iArr[0];
    }

    /* JADX INFO: renamed from: getStartY-impl, reason: not valid java name */
    public static final int m4446getStartYimpl(int[] iArr) {
        return iArr[1];
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4447hashCodeimpl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    /* JADX INFO: renamed from: isAddition-impl, reason: not valid java name */
    private static final boolean m4448isAdditionimpl(int[] iArr) {
        return m4442getEndYimpl(iArr) - m4446getStartYimpl(iArr) > m4441getEndXimpl(iArr) - m4445getStartXimpl(iArr);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4449toStringimpl(int[] iArr) {
        return "Snake(" + m4445getStartXimpl(iArr) + ',' + m4446getStartYimpl(iArr) + ',' + m4441getEndXimpl(iArr) + ',' + m4442getEndYimpl(iArr) + ',' + m4444getReverseimpl(iArr) + ')';
    }

    public boolean equals(Object obj) {
        return m4438equalsimpl(this.data, obj);
    }

    public final int[] getData() {
        return this.data;
    }

    public int hashCode() {
        return m4447hashCodeimpl(this.data);
    }

    public String toString() {
        return m4449toStringimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int[] m4450unboximpl() {
        return this.data;
    }
}
