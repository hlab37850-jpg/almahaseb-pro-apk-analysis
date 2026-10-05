package androidx.compose.ui.node;

import defpackage.AbstractC4492zt;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class CenteredArray {
    private final int[] data;

    private /* synthetic */ CenteredArray(int[] iArr) {
        this.data = iArr;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ CenteredArray m4249boximpl(int[] iArr) {
        return new CenteredArray(iArr);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int[] m4250constructorimpl(int[] iArr) {
        AbstractC4492zt.h(iArr, "data");
        return iArr;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4251equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof CenteredArray) && AbstractC4492zt.d(iArr, ((CenteredArray) obj).m4258unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4252equalsimpl0(int[] iArr, int[] iArr2) {
        return AbstractC4492zt.d(iArr, iArr2);
    }

    /* JADX INFO: renamed from: get-impl, reason: not valid java name */
    public static final int m4253getimpl(int[] iArr, int i) {
        return iArr[i + m4254getMidimpl(iArr)];
    }

    /* JADX INFO: renamed from: getMid-impl, reason: not valid java name */
    private static final int m4254getMidimpl(int[] iArr) {
        return iArr.length / 2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4255hashCodeimpl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final void m4256setimpl(int[] iArr, int i, int i2) {
        iArr[i + m4254getMidimpl(iArr)] = i2;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4257toStringimpl(int[] iArr) {
        return "CenteredArray(data=" + Arrays.toString(iArr) + ')';
    }

    public boolean equals(Object obj) {
        return m4251equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m4255hashCodeimpl(this.data);
    }

    public String toString() {
        return m4257toStringimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int[] m4258unboximpl() {
        return this.data;
    }
}
