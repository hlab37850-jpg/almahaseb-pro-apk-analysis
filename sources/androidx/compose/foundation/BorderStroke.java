package androidx.compose.foundation;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class BorderStroke {
    public static final int $stable = 0;
    private final Brush brush;
    private final float width;

    public /* synthetic */ BorderStroke(float f, Brush brush, AbstractC0419Di abstractC0419Di) {
        this(f, brush);
    }

    /* JADX INFO: renamed from: copy-D5KLDUw$default, reason: not valid java name */
    public static /* synthetic */ BorderStroke m191copyD5KLDUw$default(BorderStroke borderStroke, float f, Brush brush, int i, Object obj) {
        if ((i & 1) != 0) {
            f = borderStroke.width;
        }
        if ((i & 2) != 0) {
            brush = borderStroke.brush;
        }
        return borderStroke.m192copyD5KLDUw(f, brush);
    }

    /* JADX INFO: renamed from: copy-D5KLDUw, reason: not valid java name */
    public final BorderStroke m192copyD5KLDUw(float f, Brush brush) {
        AbstractC4492zt.h(brush, "brush");
        return new BorderStroke(f, brush, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderStroke)) {
            return false;
        }
        BorderStroke borderStroke = (BorderStroke) obj;
        return Dp.m5165equalsimpl0(this.width, borderStroke.width) && AbstractC4492zt.d(this.brush, borderStroke.brush);
    }

    public final Brush getBrush() {
        return this.brush;
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public final float m193getWidthD9Ej5fM() {
        return this.width;
    }

    public int hashCode() {
        return (Dp.m5166hashCodeimpl(this.width) * 31) + this.brush.hashCode();
    }

    public String toString() {
        return "BorderStroke(width=" + ((Object) Dp.m5171toStringimpl(this.width)) + ", brush=" + this.brush + ')';
    }

    private BorderStroke(float f, Brush brush) {
        AbstractC4492zt.h(brush, "brush");
        this.width = f;
        this.brush = brush;
    }
}
