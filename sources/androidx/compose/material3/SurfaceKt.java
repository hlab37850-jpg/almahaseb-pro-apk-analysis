package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SurfaceKt {
    private static final ProvidableCompositionLocal<Dp> LocalAbsoluteTonalElevation = CompositionLocalKt.compositionLocalOf$default(null, SurfaceKt$LocalAbsoluteTonalElevation$1.INSTANCE, 1, null);

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Surface-T9BRK9s, reason: not valid java name */
    public static final void m1850SurfaceT9BRK9s(Modifier modifier, Shape shape, long j, long j2, float f, float f2, BorderStroke borderStroke, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        composer.startReplaceableGroup(-513881741);
        Modifier modifier2 = (i2 & 1) != 0 ? Modifier.Companion : modifier;
        Shape rectangleShape = (i2 & 2) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        long jM1413getSurface0d7_KjU = (i2 & 4) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1413getSurface0d7_KjU() : j;
        long jM1449contentColorForek8zF_U = (i2 & 8) != 0 ? ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composer, (i >> 6) & 14) : j2;
        float fM5160constructorimpl = (i2 & 16) != 0 ? Dp.m5160constructorimpl(0) : f;
        float fM5160constructorimpl2 = (i2 & 32) != 0 ? Dp.m5160constructorimpl(0) : f2;
        BorderStroke borderStroke2 = (i2 & 64) != 0 ? null : borderStroke;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-513881741, i, -1, "androidx.compose.material3.Surface (Surface.kt:99)");
        }
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        float fM5160constructorimpl3 = Dp.m5160constructorimpl(((Dp) composer.consume(providableCompositionLocal)).m5174unboximpl() + fM5160constructorimpl);
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(jM1449contentColorForek8zF_U)), providableCompositionLocal.provides(Dp.m5158boximpl(fM5160constructorimpl3))}, ComposableLambdaKt.composableLambda(composer, -70914509, true, new SurfaceKt$Surface$1(modifier2, rectangleShape, jM1413getSurface0d7_KjU, fM5160constructorimpl3, i, borderStroke2, fM5160constructorimpl2, interfaceC0526Fp)), composer, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Surface-d85dljk, reason: not valid java name */
    public static final void m1851Surfaced85dljk(boolean z, InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z2, Shape shape, long j, long j2, float f, float f2, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2, int i3) {
        MutableInteractionSource mutableInteractionSource2;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        composer.startReplaceableGroup(540296512);
        Modifier modifier2 = (i3 & 4) != 0 ? Modifier.Companion : modifier;
        boolean z3 = (i3 & 8) != 0 ? true : z2;
        Shape rectangleShape = (i3 & 16) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        long jM1413getSurface0d7_KjU = (i3 & 32) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1413getSurface0d7_KjU() : j;
        long jM1449contentColorForek8zF_U = (i3 & 64) != 0 ? ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composer, (i >> 15) & 14) : j2;
        float fM5160constructorimpl = (i3 & 128) != 0 ? Dp.m5160constructorimpl(0) : f;
        float fM5160constructorimpl2 = (i3 & 256) != 0 ? Dp.m5160constructorimpl(0) : f2;
        BorderStroke borderStroke2 = (i3 & 512) != 0 ? null : borderStroke;
        if ((i3 & 1024) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(540296512, i, i2, "androidx.compose.material3.Surface (Surface.kt:309)");
        }
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        float fM5160constructorimpl3 = Dp.m5160constructorimpl(((Dp) composer.consume(providableCompositionLocal)).m5174unboximpl() + fM5160constructorimpl);
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(jM1449contentColorForek8zF_U)), providableCompositionLocal.provides(Dp.m5158boximpl(fM5160constructorimpl3))}, ComposableLambdaKt.composableLambda(composer, -1164547968, true, new SurfaceKt$Surface$5(modifier2, rectangleShape, jM1413getSurface0d7_KjU, fM5160constructorimpl3, i, borderStroke2, fM5160constructorimpl2, z, mutableInteractionSource2, z3, interfaceC3588op, interfaceC0526Fp, i2)), composer, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Surface-o_FOJdg, reason: not valid java name */
    public static final void m1853Surfaceo_FOJdg(InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z, Shape shape, long j, long j2, float f, float f2, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2, int i3) {
        MutableInteractionSource mutableInteractionSource2;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        composer.startReplaceableGroup(-789752804);
        Modifier modifier2 = (i3 & 2) != 0 ? Modifier.Companion : modifier;
        boolean z2 = (i3 & 4) != 0 ? true : z;
        Shape rectangleShape = (i3 & 8) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        long jM1413getSurface0d7_KjU = (i3 & 16) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1413getSurface0d7_KjU() : j;
        long jM1449contentColorForek8zF_U = (i3 & 32) != 0 ? ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composer, (i >> 12) & 14) : j2;
        float fM5160constructorimpl = (i3 & 64) != 0 ? Dp.m5160constructorimpl(0) : f;
        float fM5160constructorimpl2 = (i3 & 128) != 0 ? Dp.m5160constructorimpl(0) : f2;
        BorderStroke borderStroke2 = (i3 & 256) != 0 ? null : borderStroke;
        if ((i3 & 512) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-789752804, i, i2, "androidx.compose.material3.Surface (Surface.kt:201)");
        }
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        float fM5160constructorimpl3 = Dp.m5160constructorimpl(((Dp) composer.consume(providableCompositionLocal)).m5174unboximpl() + fM5160constructorimpl);
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(jM1449contentColorForek8zF_U)), providableCompositionLocal.provides(Dp.m5158boximpl(fM5160constructorimpl3))}, ComposableLambdaKt.composableLambda(composer, 1279702876, true, new SurfaceKt$Surface$3(modifier2, rectangleShape, jM1413getSurface0d7_KjU, fM5160constructorimpl3, i, borderStroke2, fM5160constructorimpl2, mutableInteractionSource2, z2, interfaceC3588op, interfaceC0526Fp, i2)), composer, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    public static final ProvidableCompositionLocal<Dp> getLocalAbsoluteTonalElevation() {
        return LocalAbsoluteTonalElevation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: surface-8ww4TTg, reason: not valid java name */
    public static final Modifier m1856surface8ww4TTg(Modifier modifier, Shape shape, long j, BorderStroke borderStroke, float f) {
        return ClipKt.clip(BackgroundKt.m166backgroundbw27NRU(ShadowKt.m2707shadows4CzXII$default(modifier, f, shape, false, 0L, 0L, 24, null).then(borderStroke != null ? BorderKt.border(Modifier.Companion, borderStroke, shape) : Modifier.Companion), j, shape), shape);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    /* JADX INFO: renamed from: surfaceColorAtElevation-CLU3JFs, reason: not valid java name */
    public static final long m1857surfaceColorAtElevationCLU3JFs(long j, float f, Composer composer, int i) {
        composer.startReplaceableGroup(-2079918090);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2079918090, i, -1, "androidx.compose.material3.surfaceColorAtElevation (Surface.kt:475)");
        }
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        if (Color.m3033equalsimpl0(j, materialTheme.getColorScheme(composer, 6).m1413getSurface0d7_KjU())) {
            j = ColorSchemeKt.m1454surfaceColorAtElevation3ABfNKs(materialTheme.getColorScheme(composer, 6), f);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return j;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Surface-d85dljk, reason: not valid java name */
    public static final void m1852Surfaced85dljk(boolean z, InterfaceC3750qp interfaceC3750qp, Modifier modifier, boolean z2, Shape shape, long j, long j2, float f, float f2, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2, int i3) {
        MutableInteractionSource mutableInteractionSource2;
        AbstractC4492zt.h(interfaceC3750qp, "onCheckedChange");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        composer.startReplaceableGroup(-1877401889);
        Modifier modifier2 = (i3 & 4) != 0 ? Modifier.Companion : modifier;
        boolean z3 = (i3 & 8) != 0 ? true : z2;
        Shape rectangleShape = (i3 & 16) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        long jM1413getSurface0d7_KjU = (i3 & 32) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1413getSurface0d7_KjU() : j;
        long jM1449contentColorForek8zF_U = (i3 & 64) != 0 ? ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composer, (i >> 15) & 14) : j2;
        float fM5160constructorimpl = (i3 & 128) != 0 ? Dp.m5160constructorimpl(0) : f;
        float fM5160constructorimpl2 = (i3 & 256) != 0 ? Dp.m5160constructorimpl(0) : f2;
        BorderStroke borderStroke2 = (i3 & 512) != 0 ? null : borderStroke;
        if ((i3 & 1024) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1877401889, i, i2, "androidx.compose.material3.Surface (Surface.kt:419)");
        }
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        float fM5160constructorimpl3 = Dp.m5160constructorimpl(((Dp) composer.consume(providableCompositionLocal)).m5174unboximpl() + fM5160constructorimpl);
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(jM1449contentColorForek8zF_U)), providableCompositionLocal.provides(Dp.m5158boximpl(fM5160constructorimpl3))}, ComposableLambdaKt.composableLambda(composer, 712720927, true, new SurfaceKt$Surface$7(modifier2, rectangleShape, jM1413getSurface0d7_KjU, fM5160constructorimpl3, i, borderStroke2, fM5160constructorimpl2, z, mutableInteractionSource2, z3, interfaceC3750qp, interfaceC0526Fp, i2)), composer, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }
}
