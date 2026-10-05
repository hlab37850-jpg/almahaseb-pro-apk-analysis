package androidx.compose.ui.semantics;

import androidx.compose.runtime.Immutable;
import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class Role {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Button = m4544constructorimpl(0);
    private static final int Checkbox = m4544constructorimpl(1);
    private static final int Switch = m4544constructorimpl(2);
    private static final int RadioButton = m4544constructorimpl(3);
    private static final int Tab = m4544constructorimpl(4);
    private static final int Image = m4544constructorimpl(5);
    private static final int DropdownList = m4544constructorimpl(6);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: renamed from: getButton-o7Vup1c, reason: not valid java name */
        public final int m4550getButtono7Vup1c() {
            return Role.Button;
        }

        /* JADX INFO: renamed from: getCheckbox-o7Vup1c, reason: not valid java name */
        public final int m4551getCheckboxo7Vup1c() {
            return Role.Checkbox;
        }

        /* JADX INFO: renamed from: getDropdownList-o7Vup1c, reason: not valid java name */
        public final int m4552getDropdownListo7Vup1c() {
            return Role.DropdownList;
        }

        /* JADX INFO: renamed from: getImage-o7Vup1c, reason: not valid java name */
        public final int m4553getImageo7Vup1c() {
            return Role.Image;
        }

        /* JADX INFO: renamed from: getRadioButton-o7Vup1c, reason: not valid java name */
        public final int m4554getRadioButtono7Vup1c() {
            return Role.RadioButton;
        }

        /* JADX INFO: renamed from: getSwitch-o7Vup1c, reason: not valid java name */
        public final int m4555getSwitcho7Vup1c() {
            return Role.Switch;
        }

        /* JADX INFO: renamed from: getTab-o7Vup1c, reason: not valid java name */
        public final int m4556getTabo7Vup1c() {
            return Role.Tab;
        }

        private Companion() {
        }
    }

    private /* synthetic */ Role(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Role m4543boximpl(int i) {
        return new Role(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m4544constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4545equalsimpl(int i, Object obj) {
        return (obj instanceof Role) && i == ((Role) obj).m4549unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4546equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4547hashCodeimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4548toStringimpl(int i) {
        if (m4546equalsimpl0(i, Button)) {
            return "Button";
        }
        if (m4546equalsimpl0(i, Checkbox)) {
            return "Checkbox";
        }
        if (m4546equalsimpl0(i, Switch)) {
            return "Switch";
        }
        if (m4546equalsimpl0(i, RadioButton)) {
            return "RadioButton";
        }
        if (m4546equalsimpl0(i, Tab)) {
            return "Tab";
        }
        if (m4546equalsimpl0(i, Image)) {
            return "Image";
        }
        return m4546equalsimpl0(i, DropdownList) ? "DropdownList" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m4545equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4547hashCodeimpl(this.value);
    }

    public String toString() {
        return m4548toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m4549unboximpl() {
        return this.value;
    }
}
