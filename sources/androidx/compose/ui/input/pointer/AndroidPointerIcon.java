package androidx.compose.ui.input.pointer;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidPointerIcon implements PointerIcon {
    private final android.view.PointerIcon pointerIcon;

    public AndroidPointerIcon(android.view.PointerIcon pointerIcon) {
        AbstractC4492zt.h(pointerIcon, "pointerIcon");
        this.pointerIcon = pointerIcon;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC4492zt.d(AndroidPointerIcon.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC4492zt.f(obj, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.AndroidPointerIcon");
        return AbstractC4492zt.d(this.pointerIcon, ((AndroidPointerIcon) obj).pointerIcon);
    }

    public final android.view.PointerIcon getPointerIcon() {
        return this.pointerIcon;
    }

    public int hashCode() {
        return this.pointerIcon.hashCode();
    }

    public String toString() {
        return "AndroidPointerIcon(pointerIcon=" + this.pointerIcon + ')';
    }
}
