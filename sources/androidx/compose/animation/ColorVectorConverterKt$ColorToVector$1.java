package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ColorVectorConverterKt$ColorToVector$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final ColorVectorConverterKt$ColorToVector$1 INSTANCE = new ColorVectorConverterKt$ColorToVector$1();

    /* JADX INFO: renamed from: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m44invoke8_81llA(((Color) obj).m3042unboximpl());
        }

        /* JADX INFO: renamed from: invoke-8_81llA, reason: not valid java name */
        public final AnimationVector4D m44invoke8_81llA(long j) {
            long jM3029convertvNxB06k = Color.m3029convertvNxB06k(j, ColorSpaces.INSTANCE.getOklab());
            return new AnimationVector4D(Color.m3026component4impl(jM3029convertvNxB06k), Color.m3023component1impl(jM3029convertvNxB06k), Color.m3024component2impl(jM3029convertvNxB06k), Color.m3025component3impl(jM3029convertvNxB06k));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ ColorSpace $colorSpace;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ColorSpace colorSpace) {
            super(1);
            this.$colorSpace = colorSpace;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Color.m3022boximpl(m45invokevNxB06k((AnimationVector4D) obj));
        }

        /* JADX INFO: renamed from: invoke-vNxB06k, reason: not valid java name */
        public final long m45invokevNxB06k(AnimationVector4D animationVector4D) {
            AbstractC4492zt.h(animationVector4D, "vector");
            return Color.m3029convertvNxB06k(ColorKt.Color(AbstractC3871sJ.k(animationVector4D.getV2(), 0.0f, 1.0f), AbstractC3871sJ.k(animationVector4D.getV3(), -0.5f, 0.5f), AbstractC3871sJ.k(animationVector4D.getV4(), -0.5f, 0.5f), AbstractC3871sJ.k(animationVector4D.getV1(), 0.0f, 1.0f), ColorSpaces.INSTANCE.getOklab()), this.$colorSpace);
        }
    }

    public ColorVectorConverterKt$ColorToVector$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final TwoWayConverter<Color, AnimationVector4D> invoke(ColorSpace colorSpace) {
        AbstractC4492zt.h(colorSpace, "colorSpace");
        return VectorConvertersKt.TwoWayConverter(AnonymousClass1.INSTANCE, new AnonymousClass2(colorSpace));
    }
}
