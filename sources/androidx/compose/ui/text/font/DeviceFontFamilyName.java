package androidx.compose.ui.text.font;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class DeviceFontFamilyName {
    private final String name;

    private /* synthetic */ DeviceFontFamilyName(String str) {
        this.name = str;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DeviceFontFamilyName m4767boximpl(String str) {
        return new DeviceFontFamilyName(str);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static String m4768constructorimpl(String str) {
        AbstractC4492zt.h(str, "name");
        if (str.length() > 0) {
            return str;
        }
        throw new IllegalArgumentException("name may not be empty");
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4769equalsimpl(String str, Object obj) {
        return (obj instanceof DeviceFontFamilyName) && AbstractC4492zt.d(str, ((DeviceFontFamilyName) obj).m4773unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4770equalsimpl0(String str, String str2) {
        return AbstractC4492zt.d(str, str2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4771hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4772toStringimpl(String str) {
        return "DeviceFontFamilyName(name=" + str + ')';
    }

    public boolean equals(Object obj) {
        return m4769equalsimpl(this.name, obj);
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return m4771hashCodeimpl(this.name);
    }

    public String toString() {
        return m4772toStringimpl(this.name);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ String m4773unboximpl() {
        return this.name;
    }
}
