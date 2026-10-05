package androidx.compose.ui.text.style;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.SolidColor;
import defpackage.AD;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public interface TextForegroundStyle {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: renamed from: androidx.compose.ui.text.style.TextForegroundStyle$-CC, reason: invalid class name */
    public abstract /* synthetic */ class CC {
        public static TextForegroundStyle a(TextForegroundStyle textForegroundStyle, TextForegroundStyle textForegroundStyle2) {
            AbstractC4492zt.h(textForegroundStyle2, "other");
            boolean z = textForegroundStyle2 instanceof BrushStyle;
            if (z && (textForegroundStyle instanceof BrushStyle)) {
                return new BrushStyle(((BrushStyle) textForegroundStyle2).getValue(), TextDrawStyleKt.takeOrElse(textForegroundStyle2.getAlpha(), textForegroundStyle.new AnonymousClass1()));
            }
            if (!z || (textForegroundStyle instanceof BrushStyle)) {
                return (z || !(textForegroundStyle instanceof BrushStyle)) ? textForegroundStyle2.takeOrElse(textForegroundStyle.new AnonymousClass2()) : textForegroundStyle;
            }
            return textForegroundStyle2;
        }

        public static TextForegroundStyle b(TextForegroundStyle textForegroundStyle, InterfaceC3588op interfaceC3588op) {
            AbstractC4492zt.h(interfaceC3588op, "other");
            return !AbstractC4492zt.d(textForegroundStyle, Unspecified.INSTANCE) ? textForegroundStyle : (TextForegroundStyle) interfaceC3588op.invoke();
        }
    }

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final TextForegroundStyle from(Brush brush, float f) {
            if (brush == null) {
                return Unspecified.INSTANCE;
            }
            if (brush instanceof SolidColor) {
                return m5085from8_81llA(TextDrawStyleKt.m5084modulateDxMtmZc(((SolidColor) brush).m3338getValue0d7_KjU(), f));
            }
            if (brush instanceof ShaderBrush) {
                return new BrushStyle((ShaderBrush) brush, f);
            }
            throw new AD();
        }

        /* JADX INFO: renamed from: from-8_81llA, reason: not valid java name */
        public final TextForegroundStyle m5085from8_81llA(long j) {
            return j != Color.Companion.m3068getUnspecified0d7_KjU() ? new ColorStyle(j, null) : Unspecified.INSTANCE;
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class Unspecified implements TextForegroundStyle {
        public static final int $stable = 0;
        public static final Unspecified INSTANCE = new Unspecified();

        private Unspecified() {
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public float getAlpha() {
            return Float.NaN;
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public Brush getBrush() {
            return null;
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        /* JADX INFO: renamed from: getColor-0d7_KjU */
        public long mo4973getColor0d7_KjU() {
            return Color.Companion.m3068getUnspecified0d7_KjU();
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public /* synthetic */ TextForegroundStyle merge(TextForegroundStyle textForegroundStyle) {
            return CC.a(this, textForegroundStyle);
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public /* synthetic */ TextForegroundStyle takeOrElse(InterfaceC3588op interfaceC3588op) {
            return CC.b(this, interfaceC3588op);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.text.style.TextForegroundStyle$merge$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        public AnonymousClass1() {
            super(0);
        }

        @Override // defpackage.InterfaceC3588op
        public final Float invoke() {
            return Float.valueOf(TextForegroundStyle.this.getAlpha());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.text.style.TextForegroundStyle$merge$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3588op {
        public AnonymousClass2() {
            super(0);
        }

        @Override // defpackage.InterfaceC3588op
        public final TextForegroundStyle invoke() {
            return TextForegroundStyle.this;
        }
    }

    float getAlpha();

    Brush getBrush();

    /* JADX INFO: renamed from: getColor-0d7_KjU */
    long mo4973getColor0d7_KjU();

    TextForegroundStyle merge(TextForegroundStyle textForegroundStyle);

    TextForegroundStyle takeOrElse(InterfaceC3588op interfaceC3588op);
}
