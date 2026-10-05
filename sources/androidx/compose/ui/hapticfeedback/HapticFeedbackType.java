package androidx.compose.ui.hapticfeedback;

import defpackage.AbstractC0419Di;
import defpackage.AbstractC1886cc;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class HapticFeedbackType {
    public static final Companion Companion = new Companion(null);
    private final int value;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: renamed from: getLongPress-5zf0vsI, reason: not valid java name */
        public final int m3610getLongPress5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m3612getLongPress5zf0vsI();
        }

        /* JADX INFO: renamed from: getTextHandleMove-5zf0vsI, reason: not valid java name */
        public final int m3611getTextHandleMove5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m3613getTextHandleMove5zf0vsI();
        }

        public final List<HapticFeedbackType> values() {
            return AbstractC1886cc.p(HapticFeedbackType.m3603boximpl(m3610getLongPress5zf0vsI()), HapticFeedbackType.m3603boximpl(m3611getTextHandleMove5zf0vsI()));
        }

        private Companion() {
        }
    }

    private /* synthetic */ HapticFeedbackType(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ HapticFeedbackType m3603boximpl(int i) {
        return new HapticFeedbackType(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m3604constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3605equalsimpl(int i, Object obj) {
        return (obj instanceof HapticFeedbackType) && i == ((HapticFeedbackType) obj).m3609unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3606equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3607hashCodeimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3608toStringimpl(int i) {
        Companion companion = Companion;
        if (m3606equalsimpl0(i, companion.m3610getLongPress5zf0vsI())) {
            return "LongPress";
        }
        return m3606equalsimpl0(i, companion.m3611getTextHandleMove5zf0vsI()) ? "TextHandleMove" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m3605equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3607hashCodeimpl(this.value);
    }

    public String toString() {
        return m3608toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3609unboximpl() {
        return this.value;
    }
}
