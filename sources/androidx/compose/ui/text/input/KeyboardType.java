package androidx.compose.ui.text.input;

import androidx.compose.runtime.Stable;
import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
public final class KeyboardType {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Text = m4893constructorimpl(1);
    private static final int Ascii = m4893constructorimpl(2);
    private static final int Number = m4893constructorimpl(3);
    private static final int Phone = m4893constructorimpl(4);
    private static final int Uri = m4893constructorimpl(5);
    private static final int Email = m4893constructorimpl(6);
    private static final int Password = m4893constructorimpl(7);
    private static final int NumberPassword = m4893constructorimpl(8);
    private static final int Decimal = m4893constructorimpl(9);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        @Stable
        /* JADX INFO: renamed from: getAscii-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m4899getAsciiPjHm6EE$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getDecimal-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m4900getDecimalPjHm6EE$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getEmail-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m4901getEmailPjHm6EE$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getNumber-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m4902getNumberPjHm6EE$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getNumberPassword-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m4903getNumberPasswordPjHm6EE$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getPassword-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m4904getPasswordPjHm6EE$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getPhone-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m4905getPhonePjHm6EE$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getText-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m4906getTextPjHm6EE$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getUri-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m4907getUriPjHm6EE$annotations() {
        }

        /* JADX INFO: renamed from: getAscii-PjHm6EE, reason: not valid java name */
        public final int m4908getAsciiPjHm6EE() {
            return KeyboardType.Ascii;
        }

        /* JADX INFO: renamed from: getDecimal-PjHm6EE, reason: not valid java name */
        public final int m4909getDecimalPjHm6EE() {
            return KeyboardType.Decimal;
        }

        /* JADX INFO: renamed from: getEmail-PjHm6EE, reason: not valid java name */
        public final int m4910getEmailPjHm6EE() {
            return KeyboardType.Email;
        }

        /* JADX INFO: renamed from: getNumber-PjHm6EE, reason: not valid java name */
        public final int m4911getNumberPjHm6EE() {
            return KeyboardType.Number;
        }

        /* JADX INFO: renamed from: getNumberPassword-PjHm6EE, reason: not valid java name */
        public final int m4912getNumberPasswordPjHm6EE() {
            return KeyboardType.NumberPassword;
        }

        /* JADX INFO: renamed from: getPassword-PjHm6EE, reason: not valid java name */
        public final int m4913getPasswordPjHm6EE() {
            return KeyboardType.Password;
        }

        /* JADX INFO: renamed from: getPhone-PjHm6EE, reason: not valid java name */
        public final int m4914getPhonePjHm6EE() {
            return KeyboardType.Phone;
        }

        /* JADX INFO: renamed from: getText-PjHm6EE, reason: not valid java name */
        public final int m4915getTextPjHm6EE() {
            return KeyboardType.Text;
        }

        /* JADX INFO: renamed from: getUri-PjHm6EE, reason: not valid java name */
        public final int m4916getUriPjHm6EE() {
            return KeyboardType.Uri;
        }

        private Companion() {
        }
    }

    private /* synthetic */ KeyboardType(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ KeyboardType m4892boximpl(int i) {
        return new KeyboardType(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m4893constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4894equalsimpl(int i, Object obj) {
        return (obj instanceof KeyboardType) && i == ((KeyboardType) obj).m4898unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4895equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4896hashCodeimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4897toStringimpl(int i) {
        if (m4895equalsimpl0(i, Text)) {
            return "Text";
        }
        if (m4895equalsimpl0(i, Ascii)) {
            return "Ascii";
        }
        if (m4895equalsimpl0(i, Number)) {
            return "Number";
        }
        if (m4895equalsimpl0(i, Phone)) {
            return "Phone";
        }
        if (m4895equalsimpl0(i, Uri)) {
            return "Uri";
        }
        if (m4895equalsimpl0(i, Email)) {
            return "Email";
        }
        if (m4895equalsimpl0(i, Password)) {
            return "Password";
        }
        if (m4895equalsimpl0(i, NumberPassword)) {
            return "NumberPassword";
        }
        return m4895equalsimpl0(i, Decimal) ? "Decimal" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m4894equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4896hashCodeimpl(this.value);
    }

    public String toString() {
        return m4897toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m4898unboximpl() {
        return this.value;
    }
}
