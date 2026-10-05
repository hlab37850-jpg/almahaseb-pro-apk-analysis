package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class TileMode {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Clamp = m3370constructorimpl(0);
    private static final int Repeated = m3370constructorimpl(1);
    private static final int Mirror = m3370constructorimpl(2);
    private static final int Decal = m3370constructorimpl(3);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: renamed from: getClamp-3opZhB0, reason: not valid java name */
        public final int m3376getClamp3opZhB0() {
            return TileMode.Clamp;
        }

        /* JADX INFO: renamed from: getDecal-3opZhB0, reason: not valid java name */
        public final int m3377getDecal3opZhB0() {
            return TileMode.Decal;
        }

        /* JADX INFO: renamed from: getMirror-3opZhB0, reason: not valid java name */
        public final int m3378getMirror3opZhB0() {
            return TileMode.Mirror;
        }

        /* JADX INFO: renamed from: getRepeated-3opZhB0, reason: not valid java name */
        public final int m3379getRepeated3opZhB0() {
            return TileMode.Repeated;
        }

        private Companion() {
        }
    }

    private /* synthetic */ TileMode(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TileMode m3369boximpl(int i) {
        return new TileMode(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m3370constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3371equalsimpl(int i, Object obj) {
        return (obj instanceof TileMode) && i == ((TileMode) obj).m3375unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3372equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3373hashCodeimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3374toStringimpl(int i) {
        if (m3372equalsimpl0(i, Clamp)) {
            return "Clamp";
        }
        if (m3372equalsimpl0(i, Repeated)) {
            return "Repeated";
        }
        if (m3372equalsimpl0(i, Mirror)) {
            return "Mirror";
        }
        return m3372equalsimpl0(i, Decal) ? "Decal" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m3371equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3373hashCodeimpl(this.value);
    }

    public String toString() {
        return m3374toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3375unboximpl() {
        return this.value;
    }
}
