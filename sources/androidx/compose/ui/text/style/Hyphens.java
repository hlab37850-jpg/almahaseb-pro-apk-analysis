package androidx.compose.ui.text.style;

import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
public final class Hyphens {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int None = m4979constructorimpl(1);
    private static final int Auto = m4979constructorimpl(2);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: renamed from: getAuto-vmbZdU8, reason: not valid java name */
        public final int m4985getAutovmbZdU8() {
            return Hyphens.Auto;
        }

        /* JADX INFO: renamed from: getNone-vmbZdU8, reason: not valid java name */
        public final int m4986getNonevmbZdU8() {
            return Hyphens.None;
        }

        private Companion() {
        }
    }

    private /* synthetic */ Hyphens(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Hyphens m4978boximpl(int i) {
        return new Hyphens(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m4979constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4980equalsimpl(int i, Object obj) {
        return (obj instanceof Hyphens) && i == ((Hyphens) obj).m4984unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4981equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4982hashCodeimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4983toStringimpl(int i) {
        if (m4981equalsimpl0(i, None)) {
            return "Hyphens.None";
        }
        return m4981equalsimpl0(i, Auto) ? "Hyphens.Auto" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m4980equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4982hashCodeimpl(this.value);
    }

    public String toString() {
        return m4983toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m4984unboximpl() {
        return this.value;
    }
}
