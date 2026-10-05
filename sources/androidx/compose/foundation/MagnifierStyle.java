package androidx.compose.foundation;

import android.os.Build;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0564Hb;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalFoundationApi
public final class MagnifierStyle {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final MagnifierStyle Default;
    private static final MagnifierStyle TextDefault;
    private final boolean clippingEnabled;
    private final float cornerRadius;
    private final float elevation;
    private final boolean fishEyeEnabled;
    private final long size;
    private final boolean useTextDefault;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        @ExperimentalFoundationApi
        public static /* synthetic */ void getDefault$annotations() {
        }

        @ExperimentalFoundationApi
        public static /* synthetic */ void getTextDefault$annotations() {
        }

        public static /* synthetic */ boolean isStyleSupported$foundation_release$default(Companion companion, MagnifierStyle magnifierStyle, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = Build.VERSION.SDK_INT;
            }
            return companion.isStyleSupported$foundation_release(magnifierStyle, i);
        }

        public final MagnifierStyle getDefault() {
            return MagnifierStyle.Default;
        }

        public final MagnifierStyle getTextDefault() {
            return MagnifierStyle.TextDefault;
        }

        public final boolean isStyleSupported$foundation_release(MagnifierStyle magnifierStyle, int i) {
            AbstractC4492zt.h(magnifierStyle, "style");
            if (MagnifierKt.isPlatformMagnifierSupported(i) && !magnifierStyle.getFishEyeEnabled$foundation_release()) {
                return magnifierStyle.getUseTextDefault$foundation_release() || AbstractC4492zt.d(magnifierStyle, getDefault()) || i >= 29;
            }
            return false;
        }

        private Companion() {
        }
    }

    static {
        MagnifierStyle magnifierStyle = new MagnifierStyle(0L, 0.0f, 0.0f, false, false, 31, (AbstractC0419Di) null);
        Default = magnifierStyle;
        TextDefault = new MagnifierStyle(true, magnifierStyle.size, magnifierStyle.cornerRadius, magnifierStyle.elevation, magnifierStyle.clippingEnabled, magnifierStyle.fishEyeEnabled, (AbstractC0419Di) null);
    }

    @ExperimentalFoundationApi
    public /* synthetic */ MagnifierStyle(long j, float f, float f2, boolean z, boolean z2, AbstractC0419Di abstractC0419Di) {
        this(j, f, f2, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MagnifierStyle)) {
            return false;
        }
        MagnifierStyle magnifierStyle = (MagnifierStyle) obj;
        return this.useTextDefault == magnifierStyle.useTextDefault && DpSize.m5255equalsimpl0(this.size, magnifierStyle.size) && Dp.m5165equalsimpl0(this.cornerRadius, magnifierStyle.cornerRadius) && Dp.m5165equalsimpl0(this.elevation, magnifierStyle.elevation) && this.clippingEnabled == magnifierStyle.clippingEnabled && this.fishEyeEnabled == magnifierStyle.fishEyeEnabled;
    }

    public final boolean getClippingEnabled$foundation_release() {
        return this.clippingEnabled;
    }

    /* JADX INFO: renamed from: getCornerRadius-D9Ej5fM$foundation_release, reason: not valid java name */
    public final float m229getCornerRadiusD9Ej5fM$foundation_release() {
        return this.cornerRadius;
    }

    /* JADX INFO: renamed from: getElevation-D9Ej5fM$foundation_release, reason: not valid java name */
    public final float m230getElevationD9Ej5fM$foundation_release() {
        return this.elevation;
    }

    public final boolean getFishEyeEnabled$foundation_release() {
        return this.fishEyeEnabled;
    }

    /* JADX INFO: renamed from: getSize-MYxV2XQ$foundation_release, reason: not valid java name */
    public final long m231getSizeMYxV2XQ$foundation_release() {
        return this.size;
    }

    public final boolean getUseTextDefault$foundation_release() {
        return this.useTextDefault;
    }

    public int hashCode() {
        return (((((((((AbstractC0564Hb.a(this.useTextDefault) * 31) + DpSize.m5260hashCodeimpl(this.size)) * 31) + Dp.m5166hashCodeimpl(this.cornerRadius)) * 31) + Dp.m5166hashCodeimpl(this.elevation)) * 31) + AbstractC0564Hb.a(this.clippingEnabled)) * 31) + AbstractC0564Hb.a(this.fishEyeEnabled);
    }

    public final boolean isSupported() {
        return Companion.isStyleSupported$foundation_release$default(Companion, this, 0, 2, null);
    }

    public String toString() {
        if (this.useTextDefault) {
            return "MagnifierStyle.TextDefault";
        }
        return "MagnifierStyle(size=" + ((Object) DpSize.m5265toStringimpl(this.size)) + ", cornerRadius=" + ((Object) Dp.m5171toStringimpl(this.cornerRadius)) + ", elevation=" + ((Object) Dp.m5171toStringimpl(this.elevation)) + ", clippingEnabled=" + this.clippingEnabled + ", fishEyeEnabled=" + this.fishEyeEnabled + ')';
    }

    public /* synthetic */ MagnifierStyle(boolean z, long j, float f, float f2, boolean z2, boolean z3, AbstractC0419Di abstractC0419Di) {
        this(z, j, f, f2, z2, z3);
    }

    private MagnifierStyle(boolean z, long j, float f, float f2, boolean z2, boolean z3) {
        this.useTextDefault = z;
        this.size = j;
        this.cornerRadius = f;
        this.elevation = f2;
        this.clippingEnabled = z2;
        this.fishEyeEnabled = z3;
    }

    public /* synthetic */ MagnifierStyle(long j, float f, float f2, boolean z, boolean z2, int i, AbstractC0419Di abstractC0419Di) {
        this((i & 1) != 0 ? DpSize.Companion.m5267getUnspecifiedMYxV2XQ() : j, (i & 2) != 0 ? Dp.Companion.m5180getUnspecifiedD9Ej5fM() : f, (i & 4) != 0 ? Dp.Companion.m5180getUnspecifiedD9Ej5fM() : f2, (i & 8) != 0 ? true : z, (i & 16) != 0 ? false : z2, (AbstractC0419Di) null);
    }

    private MagnifierStyle(long j, float f, float f2, boolean z, boolean z2) {
        this(false, j, f, f2, z, z2, (AbstractC0419Di) null);
    }
}
