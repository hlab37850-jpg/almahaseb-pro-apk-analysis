package androidx.compose.material;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class TabPosition {
    public static final int $stable = 0;
    private final float left;
    private final float width;

    public /* synthetic */ TabPosition(float f, float f2, AbstractC0419Di abstractC0419Di) {
        this(f, f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabPosition)) {
            return false;
        }
        TabPosition tabPosition = (TabPosition) obj;
        return Dp.m5165equalsimpl0(this.left, tabPosition.left) && Dp.m5165equalsimpl0(this.width, tabPosition.width);
    }

    /* JADX INFO: renamed from: getLeft-D9Ej5fM, reason: not valid java name */
    public final float m1249getLeftD9Ej5fM() {
        return this.left;
    }

    /* JADX INFO: renamed from: getRight-D9Ej5fM, reason: not valid java name */
    public final float m1250getRightD9Ej5fM() {
        return Dp.m5160constructorimpl(this.left + this.width);
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public final float m1251getWidthD9Ej5fM() {
        return this.width;
    }

    public int hashCode() {
        return (Dp.m5166hashCodeimpl(this.left) * 31) + Dp.m5166hashCodeimpl(this.width);
    }

    public String toString() {
        return "TabPosition(left=" + ((Object) Dp.m5171toStringimpl(this.left)) + ", right=" + ((Object) Dp.m5171toStringimpl(m1250getRightD9Ej5fM())) + ", width=" + ((Object) Dp.m5171toStringimpl(this.width)) + ')';
    }

    private TabPosition(float f, float f2) {
        this.left = f;
        this.width = f2;
    }
}
