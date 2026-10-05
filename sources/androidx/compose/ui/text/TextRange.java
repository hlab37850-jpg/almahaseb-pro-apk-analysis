package androidx.compose.ui.text;

import androidx.compose.runtime.Immutable;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0723Lm;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class TextRange {
    public static final Companion Companion = new Companion(null);
    private static final long Zero = TextRangeKt.TextRange(0);
    private final long packedValue;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: renamed from: getZero-d9O1mEE, reason: not valid java name */
        public final long m4710getZerod9O1mEE() {
            return TextRange.Zero;
        }

        private Companion() {
        }
    }

    private /* synthetic */ TextRange(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextRange m4693boximpl(long j) {
        return new TextRange(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m4694constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: contains-5zc-tL8, reason: not valid java name */
    public static final boolean m4695contains5zctL8(long j, long j2) {
        return m4703getMinimpl(j) <= m4703getMinimpl(j2) && m4702getMaximpl(j2) <= m4702getMaximpl(j);
    }

    /* JADX INFO: renamed from: contains-impl, reason: not valid java name */
    public static final boolean m4696containsimpl(long j, int i) {
        return i < m4702getMaximpl(j) && m4703getMinimpl(j) <= i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4697equalsimpl(long j, Object obj) {
        return (obj instanceof TextRange) && j == ((TextRange) obj).m4709unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4698equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getCollapsed-impl, reason: not valid java name */
    public static final boolean m4699getCollapsedimpl(long j) {
        return m4705getStartimpl(j) == m4700getEndimpl(j);
    }

    /* JADX INFO: renamed from: getEnd-impl, reason: not valid java name */
    public static final int m4700getEndimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* JADX INFO: renamed from: getLength-impl, reason: not valid java name */
    public static final int m4701getLengthimpl(long j) {
        return m4702getMaximpl(j) - m4703getMinimpl(j);
    }

    /* JADX INFO: renamed from: getMax-impl, reason: not valid java name */
    public static final int m4702getMaximpl(long j) {
        return m4705getStartimpl(j) > m4700getEndimpl(j) ? m4705getStartimpl(j) : m4700getEndimpl(j);
    }

    /* JADX INFO: renamed from: getMin-impl, reason: not valid java name */
    public static final int m4703getMinimpl(long j) {
        return m4705getStartimpl(j) > m4700getEndimpl(j) ? m4700getEndimpl(j) : m4705getStartimpl(j);
    }

    /* JADX INFO: renamed from: getReversed-impl, reason: not valid java name */
    public static final boolean m4704getReversedimpl(long j) {
        return m4705getStartimpl(j) > m4700getEndimpl(j);
    }

    /* JADX INFO: renamed from: getStart-impl, reason: not valid java name */
    public static final int m4705getStartimpl(long j) {
        return (int) (j >> 32);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4706hashCodeimpl(long j) {
        return AbstractC0723Lm.a(j);
    }

    /* JADX INFO: renamed from: intersects-5zc-tL8, reason: not valid java name */
    public static final boolean m4707intersects5zctL8(long j, long j2) {
        return m4703getMinimpl(j) < m4702getMaximpl(j2) && m4703getMinimpl(j2) < m4702getMaximpl(j);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4708toStringimpl(long j) {
        return "TextRange(" + m4705getStartimpl(j) + ", " + m4700getEndimpl(j) + ')';
    }

    public boolean equals(Object obj) {
        return m4697equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m4706hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m4708toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m4709unboximpl() {
        return this.packedValue;
    }
}
