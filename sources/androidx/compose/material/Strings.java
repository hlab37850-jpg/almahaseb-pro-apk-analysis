package androidx.compose.material;

import androidx.compose.runtime.Immutable;
import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class Strings {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int NavigationMenu = m1212constructorimpl(0);
    private static final int CloseDrawer = m1212constructorimpl(1);
    private static final int CloseSheet = m1212constructorimpl(2);
    private static final int DefaultErrorMessage = m1212constructorimpl(3);
    private static final int ExposedDropdownMenu = m1212constructorimpl(4);
    private static final int SliderRangeStart = m1212constructorimpl(5);
    private static final int SliderRangeEnd = m1212constructorimpl(6);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: renamed from: getCloseDrawer-UdPEhr4, reason: not valid java name */
        public final int m1218getCloseDrawerUdPEhr4() {
            return Strings.CloseDrawer;
        }

        /* JADX INFO: renamed from: getCloseSheet-UdPEhr4, reason: not valid java name */
        public final int m1219getCloseSheetUdPEhr4() {
            return Strings.CloseSheet;
        }

        /* JADX INFO: renamed from: getDefaultErrorMessage-UdPEhr4, reason: not valid java name */
        public final int m1220getDefaultErrorMessageUdPEhr4() {
            return Strings.DefaultErrorMessage;
        }

        /* JADX INFO: renamed from: getExposedDropdownMenu-UdPEhr4, reason: not valid java name */
        public final int m1221getExposedDropdownMenuUdPEhr4() {
            return Strings.ExposedDropdownMenu;
        }

        /* JADX INFO: renamed from: getNavigationMenu-UdPEhr4, reason: not valid java name */
        public final int m1222getNavigationMenuUdPEhr4() {
            return Strings.NavigationMenu;
        }

        /* JADX INFO: renamed from: getSliderRangeEnd-UdPEhr4, reason: not valid java name */
        public final int m1223getSliderRangeEndUdPEhr4() {
            return Strings.SliderRangeEnd;
        }

        /* JADX INFO: renamed from: getSliderRangeStart-UdPEhr4, reason: not valid java name */
        public final int m1224getSliderRangeStartUdPEhr4() {
            return Strings.SliderRangeStart;
        }

        private Companion() {
        }
    }

    private /* synthetic */ Strings(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Strings m1211boximpl(int i) {
        return new Strings(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m1212constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1213equalsimpl(int i, Object obj) {
        return (obj instanceof Strings) && i == ((Strings) obj).m1217unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1214equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1215hashCodeimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1216toStringimpl(int i) {
        return "Strings(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m1213equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1215hashCodeimpl(this.value);
    }

    public String toString() {
        return m1216toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1217unboximpl() {
        return this.value;
    }
}
