package androidx.compose.ui.graphics;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import defpackage.AbstractC0865Qq;
import defpackage.AbstractC1819bj;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public interface GraphicsLayerScope extends Density {

    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
        public static long m3202getAmbientShadowColor0d7_KjU(GraphicsLayerScope graphicsLayerScope) {
            return AbstractC0865Qq.a(graphicsLayerScope);
        }

        public static /* synthetic */ void getClip$annotations() {
        }

        @Deprecated
        /* JADX INFO: renamed from: getCompositingStrategy--NrFUSI, reason: not valid java name */
        public static int m3203getCompositingStrategyNrFUSI(GraphicsLayerScope graphicsLayerScope) {
            return AbstractC0865Qq.b(graphicsLayerScope);
        }

        @Deprecated
        public static RenderEffect getRenderEffect(GraphicsLayerScope graphicsLayerScope) {
            return AbstractC0865Qq.c(graphicsLayerScope);
        }

        @Deprecated
        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public static long m3204getSizeNHjbRc(GraphicsLayerScope graphicsLayerScope) {
            return AbstractC0865Qq.d(graphicsLayerScope);
        }

        @Deprecated
        /* JADX INFO: renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
        public static long m3205getSpotShadowColor0d7_KjU(GraphicsLayerScope graphicsLayerScope) {
            return AbstractC0865Qq.e(graphicsLayerScope);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m3206roundToPxR2X_6o(GraphicsLayerScope graphicsLayerScope, long j) {
            return AbstractC1819bj.a(graphicsLayerScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m3207roundToPx0680j_4(GraphicsLayerScope graphicsLayerScope, float f) {
            return AbstractC1819bj.b(graphicsLayerScope, f);
        }

        @Deprecated
        /* JADX INFO: renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
        public static void m3208setAmbientShadowColor8_81llA(GraphicsLayerScope graphicsLayerScope, long j) {
            AbstractC0865Qq.f(graphicsLayerScope, j);
        }

        @Deprecated
        /* JADX INFO: renamed from: setCompositingStrategy-aDBOjCE, reason: not valid java name */
        public static void m3209setCompositingStrategyaDBOjCE(GraphicsLayerScope graphicsLayerScope, int i) {
            AbstractC0865Qq.g(graphicsLayerScope, i);
        }

        @Deprecated
        public static void setRenderEffect(GraphicsLayerScope graphicsLayerScope, RenderEffect renderEffect) {
            AbstractC0865Qq.h(graphicsLayerScope, renderEffect);
        }

        @Deprecated
        /* JADX INFO: renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
        public static void m3210setSpotShadowColor8_81llA(GraphicsLayerScope graphicsLayerScope, long j) {
            AbstractC0865Qq.i(graphicsLayerScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m3211toDpGaN1DYA(GraphicsLayerScope graphicsLayerScope, long j) {
            return AbstractC1819bj.c(graphicsLayerScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m3212toDpu2uoSUM(GraphicsLayerScope graphicsLayerScope, float f) {
            return AbstractC1819bj.d(graphicsLayerScope, f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m3214toDpSizekrfVVM(GraphicsLayerScope graphicsLayerScope, long j) {
            return AbstractC1819bj.f(graphicsLayerScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m3215toPxR2X_6o(GraphicsLayerScope graphicsLayerScope, long j) {
            return AbstractC1819bj.g(graphicsLayerScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m3216toPx0680j_4(GraphicsLayerScope graphicsLayerScope, float f) {
            return AbstractC1819bj.h(graphicsLayerScope, f);
        }

        @Stable
        @Deprecated
        public static Rect toRect(GraphicsLayerScope graphicsLayerScope, DpRect dpRect) {
            AbstractC4492zt.h(dpRect, "$receiver");
            return AbstractC1819bj.i(graphicsLayerScope, dpRect);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m3217toSizeXkaWNTQ(GraphicsLayerScope graphicsLayerScope, long j) {
            return AbstractC1819bj.j(graphicsLayerScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m3218toSp0xMU5do(GraphicsLayerScope graphicsLayerScope, float f) {
            return AbstractC1819bj.k(graphicsLayerScope, f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m3219toSpkPz2Gy4(GraphicsLayerScope graphicsLayerScope, float f) {
            return AbstractC1819bj.l(graphicsLayerScope, f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m3213toDpu2uoSUM(GraphicsLayerScope graphicsLayerScope, int i) {
            return AbstractC1819bj.e(graphicsLayerScope, i);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m3220toSpkPz2Gy4(GraphicsLayerScope graphicsLayerScope, int i) {
            return AbstractC1819bj.m(graphicsLayerScope, i);
        }
    }

    float getAlpha();

    /* JADX INFO: renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
    long mo3193getAmbientShadowColor0d7_KjU();

    float getCameraDistance();

    boolean getClip();

    /* JADX INFO: renamed from: getCompositingStrategy--NrFUSI, reason: not valid java name */
    int mo3194getCompositingStrategyNrFUSI();

    RenderEffect getRenderEffect();

    float getRotationX();

    float getRotationY();

    float getRotationZ();

    float getScaleX();

    float getScaleY();

    float getShadowElevation();

    Shape getShape();

    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    long mo3195getSizeNHjbRc();

    /* JADX INFO: renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
    long mo3196getSpotShadowColor0d7_KjU();

    /* JADX INFO: renamed from: getTransformOrigin-SzJe1aQ, reason: not valid java name */
    long mo3197getTransformOriginSzJe1aQ();

    float getTranslationX();

    float getTranslationY();

    void setAlpha(float f);

    /* JADX INFO: renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
    void mo3198setAmbientShadowColor8_81llA(long j);

    void setCameraDistance(float f);

    void setClip(boolean z);

    /* JADX INFO: renamed from: setCompositingStrategy-aDBOjCE, reason: not valid java name */
    void mo3199setCompositingStrategyaDBOjCE(int i);

    void setRenderEffect(RenderEffect renderEffect);

    void setRotationX(float f);

    void setRotationY(float f);

    void setRotationZ(float f);

    void setScaleX(float f);

    void setScaleY(float f);

    void setShadowElevation(float f);

    void setShape(Shape shape);

    /* JADX INFO: renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
    void mo3200setSpotShadowColor8_81llA(long j);

    /* JADX INFO: renamed from: setTransformOrigin-__ExYCQ, reason: not valid java name */
    void mo3201setTransformOrigin__ExYCQ(long j);

    void setTranslationX(float f);

    void setTranslationY(float f);
}
