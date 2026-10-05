package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import defpackage.AbstractC3255kk;
import defpackage.AbstractC3790rJ;
import defpackage.AbstractC3871sJ;
import defpackage.C0893Rs;
import defpackage.InterfaceC0789Ob;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ProgressIndicatorKt {
    private static final float BaseRotationAngle = 286.0f;
    private static final int FirstLineHeadDelay = 0;
    private static final int FirstLineHeadDuration = 750;
    private static final int FirstLineTailDelay = 333;
    private static final int FirstLineTailDuration = 850;
    private static final int HeadAndTailAnimationDuration = 666;
    private static final int HeadAndTailDelayDuration = 666;
    private static final float JumpRotationAngle = 290.0f;
    private static final int LinearAnimationDuration = 1800;
    private static final float RotationAngleOffset = 216.0f;
    private static final int RotationDuration = 1332;
    private static final int RotationsPerCycle = 5;
    private static final int SecondLineHeadDelay = 1000;
    private static final int SecondLineHeadDuration = 567;
    private static final int SecondLineTailDelay = 1267;
    private static final int SecondLineTailDuration = 533;
    private static final float StartAngleOffset = -90.0f;
    private static final float LinearIndicatorHeight = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
    private static final float LinearIndicatorWidth = Dp.m5160constructorimpl(240);
    private static final float CircularIndicatorDiameter = Dp.m5160constructorimpl(40);
    private static final CubicBezierEasing FirstLineHeadEasing = new CubicBezierEasing(0.2f, 0.0f, 0.8f, 1.0f);
    private static final CubicBezierEasing FirstLineTailEasing = new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);
    private static final CubicBezierEasing SecondLineHeadEasing = new CubicBezierEasing(0.0f, 0.0f, 0.65f, 1.0f);
    private static final CubicBezierEasing SecondLineTailEasing = new CubicBezierEasing(0.1f, 0.0f, 0.45f, 1.0f);
    private static final CubicBezierEasing CircularEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);

    /* JADX WARN: Code duplicated, block: B:102:0x0187  */
    /* JADX WARN: Code duplicated, block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0043  */
    /* JADX WARN: Code duplicated, block: B:28:0x0047  */
    /* JADX WARN: Code duplicated, block: B:30:0x004f  */
    /* JADX WARN: Code duplicated, block: B:31:0x0052  */
    /* JADX WARN: Code duplicated, block: B:34:0x0058  */
    /* JADX WARN: Code duplicated, block: B:37:0x005e  */
    /* JADX WARN: Code duplicated, block: B:39:0x0063  */
    /* JADX WARN: Code duplicated, block: B:41:0x0067  */
    /* JADX WARN: Code duplicated, block: B:43:0x006f  */
    /* JADX WARN: Code duplicated, block: B:44:0x0072  */
    /* JADX WARN: Code duplicated, block: B:48:0x0079  */
    /* JADX WARN: Code duplicated, block: B:50:0x007e  */
    /* JADX WARN: Code duplicated, block: B:52:0x0084  */
    /* JADX WARN: Code duplicated, block: B:54:0x008c  */
    /* JADX WARN: Code duplicated, block: B:55:0x008f  */
    /* JADX WARN: Code duplicated, block: B:59:0x0097  */
    /* JADX WARN: Code duplicated, block: B:61:0x009b  */
    /* JADX WARN: Code duplicated, block: B:63:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:64:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:70:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:75:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:77:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:81:0x00d8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x00da  */
    /* JADX WARN: Code duplicated, block: B:85:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:87:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:92:0x0103  */
    /* JADX WARN: Code duplicated, block: B:95:0x0113  */
    /* JADX WARN: Code duplicated, block: B:98:0x017b  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: CircularProgressIndicator-DUhRLBM, reason: not valid java name */
    public static final void m1174CircularProgressIndicatorDUhRLBM(float f, Modifier modifier, long j, float f2, long j2, int i, Composer composer, int i2, int i3) {
        int i4;
        Modifier modifier2;
        long jM1051getPrimary0d7_KjU;
        int i5;
        float fM1173getStrokeWidthD9Ej5fM;
        int i6;
        int i7;
        long jM3067getTransparent0d7_KjU;
        int i8;
        int iM3356getButtKaPHkGw;
        long j3;
        long j4;
        int i9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1746618448);
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i10 = i3 & 2;
        if (i10 == 0) {
            if ((i2 & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 896) == 0) {
                if ((i3 & 4) == 0) {
                    jM1051getPrimary0d7_KjU = j;
                    int i11 = composerStartRestartGroup.changed(jM1051getPrimary0d7_KjU) ? 256 : 128;
                    i4 |= i11;
                } else {
                    jM1051getPrimary0d7_KjU = j;
                }
                i4 |= i11;
            } else {
                jM1051getPrimary0d7_KjU = j;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i2 & 7168) == 0) {
                    fM1173getStrokeWidthD9Ej5fM = f2;
                    if (composerStartRestartGroup.changed(fM1173getStrokeWidthD9Ej5fM)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 16;
                if (i7 != 0) {
                    if ((57344 & i2) == 0) {
                        jM3067getTransparent0d7_KjU = j2;
                        if (composerStartRestartGroup.changed(jM3067getTransparent0d7_KjU)) {
                            i8 = 16384;
                        } else {
                            i8 = 8192;
                        }
                        i4 |= i8;
                    }
                    if ((458752 & i2) == 0) {
                        if ((i3 & 32) == 0) {
                            iM3356getButtKaPHkGw = i;
                            int i12 = composerStartRestartGroup.changed(iM3356getButtKaPHkGw) ? 131072 : 65536;
                            i4 |= i12;
                        } else {
                            iM3356getButtKaPHkGw = i;
                        }
                        i4 |= i12;
                    } else {
                        iM3356getButtKaPHkGw = i;
                    }
                    if ((i4 & 374491) == 74898 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i10 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i3 & 4) != 0) {
                                jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                            }
                            if (i5 != 0) {
                                fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                            }
                            if (i7 != 0) {
                                jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                            }
                            if ((i3 & 32) != 0) {
                                iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1746618448, i2, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:285)");
                        }
                        float fK = AbstractC3871sJ.k(f, 0.0f, 1.0f);
                        CanvasKt.Canvas(SizeKt.m532size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier2, fK, null, 0, 6, null), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$1(fK, jM3067getTransparent0d7_KjU, new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM1173getStrokeWidthD9Ej5fM), 0.0f, iM3356getButtKaPHkGw, 0, null, 26, null), jM1051getPrimary0d7_KjU), composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                    }
                    j3 = jM1051getPrimary0d7_KjU;
                    j4 = jM3067getTransparent0d7_KjU;
                    i9 = iM3356getButtKaPHkGw;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$2(f, modifier2, j3, fM1173getStrokeWidthD9Ej5fM, j4, i9, i2, i3));
                }
                i4 |= 24576;
                jM3067getTransparent0d7_KjU = j2;
                if ((458752 & i2) == 0) {
                    if ((i3 & 32) == 0) {
                        iM3356getButtKaPHkGw = i;
                        if (composerStartRestartGroup.changed(iM3356getButtKaPHkGw)) {
                        }
                        i4 |= i12;
                    } else {
                        iM3356getButtKaPHkGw = i;
                    }
                    i4 |= i12;
                } else {
                    iM3356getButtKaPHkGw = i;
                }
                if ((i4 & 374491) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i3 & 4) != 0) {
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        }
                        if (i5 != 0) {
                            fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                        }
                        if (i7 != 0) {
                            jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                        }
                        if ((i3 & 32) != 0) {
                            iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                        }
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i3 & 4) != 0) {
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        }
                        if (i5 != 0) {
                            fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                        }
                        if (i7 != 0) {
                            jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                        }
                        if ((i3 & 32) != 0) {
                            iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1746618448, i2, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:285)");
                    }
                    float fK2 = AbstractC3871sJ.k(f, 0.0f, 1.0f);
                    CanvasKt.Canvas(SizeKt.m532size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier2, fK2, null, 0, 6, null), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$1(fK2, jM3067getTransparent0d7_KjU, new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM1173getStrokeWidthD9Ej5fM), 0.0f, iM3356getButtKaPHkGw, 0, null, 26, null), jM1051getPrimary0d7_KjU), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i3 & 4) != 0) {
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        }
                        if (i5 != 0) {
                            fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                        }
                        if (i7 != 0) {
                            jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                        }
                        if ((i3 & 32) != 0) {
                            iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                        }
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i3 & 4) != 0) {
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        }
                        if (i5 != 0) {
                            fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                        }
                        if (i7 != 0) {
                            jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                        }
                        if ((i3 & 32) != 0) {
                            iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1746618448, i2, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:285)");
                    }
                    float fK3 = AbstractC3871sJ.k(f, 0.0f, 1.0f);
                    CanvasKt.Canvas(SizeKt.m532size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier2, fK3, null, 0, 6, null), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$1(fK3, jM3067getTransparent0d7_KjU, new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM1173getStrokeWidthD9Ej5fM), 0.0f, iM3356getButtKaPHkGw, 0, null, 26, null), jM1051getPrimary0d7_KjU), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                j3 = jM1051getPrimary0d7_KjU;
                j4 = jM3067getTransparent0d7_KjU;
                i9 = iM3356getButtKaPHkGw;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$2(f, modifier2, j3, fM1173getStrokeWidthD9Ej5fM, j4, i9, i2, i3));
            }
            i4 |= 3072;
            fM1173getStrokeWidthD9Ej5fM = f2;
            i7 = i3 & 16;
            if (i7 != 0) {
                if ((57344 & i2) == 0) {
                    jM3067getTransparent0d7_KjU = j2;
                    if (composerStartRestartGroup.changed(jM3067getTransparent0d7_KjU)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i4 |= i8;
                }
                if ((458752 & i2) == 0) {
                    if ((i3 & 32) == 0) {
                        iM3356getButtKaPHkGw = i;
                        if (composerStartRestartGroup.changed(iM3356getButtKaPHkGw)) {
                        }
                        i4 |= i12;
                    } else {
                        iM3356getButtKaPHkGw = i;
                    }
                    i4 |= i12;
                } else {
                    iM3356getButtKaPHkGw = i;
                }
                if ((i4 & 374491) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i3 & 4) != 0) {
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        }
                        if (i5 != 0) {
                            fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                        }
                        if (i7 != 0) {
                            jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                        }
                        if ((i3 & 32) != 0) {
                            iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                        }
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i3 & 4) != 0) {
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        }
                        if (i5 != 0) {
                            fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                        }
                        if (i7 != 0) {
                            jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                        }
                        if ((i3 & 32) != 0) {
                            iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1746618448, i2, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:285)");
                    }
                    float fK4 = AbstractC3871sJ.k(f, 0.0f, 1.0f);
                    CanvasKt.Canvas(SizeKt.m532size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier2, fK4, null, 0, 6, null), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$1(fK4, jM3067getTransparent0d7_KjU, new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM1173getStrokeWidthD9Ej5fM), 0.0f, iM3356getButtKaPHkGw, 0, null, 26, null), jM1051getPrimary0d7_KjU), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i3 & 4) != 0) {
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        }
                        if (i5 != 0) {
                            fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                        }
                        if (i7 != 0) {
                            jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                        }
                        if ((i3 & 32) != 0) {
                            iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                        }
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i3 & 4) != 0) {
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        }
                        if (i5 != 0) {
                            fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                        }
                        if (i7 != 0) {
                            jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                        }
                        if ((i3 & 32) != 0) {
                            iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1746618448, i2, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:285)");
                    }
                    float fK5 = AbstractC3871sJ.k(f, 0.0f, 1.0f);
                    CanvasKt.Canvas(SizeKt.m532size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier2, fK5, null, 0, 6, null), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$1(fK5, jM3067getTransparent0d7_KjU, new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM1173getStrokeWidthD9Ej5fM), 0.0f, iM3356getButtKaPHkGw, 0, null, 26, null), jM1051getPrimary0d7_KjU), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                j3 = jM1051getPrimary0d7_KjU;
                j4 = jM3067getTransparent0d7_KjU;
                i9 = iM3356getButtKaPHkGw;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$2(f, modifier2, j3, fM1173getStrokeWidthD9Ej5fM, j4, i9, i2, i3));
            }
            i4 |= 24576;
            jM3067getTransparent0d7_KjU = j2;
            if ((458752 & i2) == 0) {
                if ((i3 & 32) == 0) {
                    iM3356getButtKaPHkGw = i;
                    if (composerStartRestartGroup.changed(iM3356getButtKaPHkGw)) {
                    }
                    i4 |= i12;
                } else {
                    iM3356getButtKaPHkGw = i;
                }
                i4 |= i12;
            } else {
                iM3356getButtKaPHkGw = i;
            }
            if ((i4 & 374491) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i3 & 4) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    }
                    if (i5 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                    }
                    if (i7 != 0) {
                        jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                    }
                    if ((i3 & 32) != 0) {
                        iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                    }
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i3 & 4) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    }
                    if (i5 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                    }
                    if (i7 != 0) {
                        jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                    }
                    if ((i3 & 32) != 0) {
                        iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1746618448, i2, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:285)");
                }
                float fK6 = AbstractC3871sJ.k(f, 0.0f, 1.0f);
                CanvasKt.Canvas(SizeKt.m532size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier2, fK6, null, 0, 6, null), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$1(fK6, jM3067getTransparent0d7_KjU, new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM1173getStrokeWidthD9Ej5fM), 0.0f, iM3356getButtKaPHkGw, 0, null, 26, null), jM1051getPrimary0d7_KjU), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i3 & 4) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    }
                    if (i5 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                    }
                    if (i7 != 0) {
                        jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                    }
                    if ((i3 & 32) != 0) {
                        iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                    }
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i3 & 4) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    }
                    if (i5 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                    }
                    if (i7 != 0) {
                        jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                    }
                    if ((i3 & 32) != 0) {
                        iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1746618448, i2, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:285)");
                }
                float fK7 = AbstractC3871sJ.k(f, 0.0f, 1.0f);
                CanvasKt.Canvas(SizeKt.m532size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier2, fK7, null, 0, 6, null), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$1(fK7, jM3067getTransparent0d7_KjU, new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM1173getStrokeWidthD9Ej5fM), 0.0f, iM3356getButtKaPHkGw, 0, null, 26, null), jM1051getPrimary0d7_KjU), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            j3 = jM1051getPrimary0d7_KjU;
            j4 = jM3067getTransparent0d7_KjU;
            i9 = iM3356getButtKaPHkGw;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$2(f, modifier2, j3, fM1173getStrokeWidthD9Ej5fM, j4, i9, i2, i3));
        }
        i4 |= 48;
        modifier2 = modifier;
        if ((i2 & 896) == 0) {
            if ((i3 & 4) == 0) {
                jM1051getPrimary0d7_KjU = j;
                if (composerStartRestartGroup.changed(jM1051getPrimary0d7_KjU)) {
                }
                i4 |= i11;
            } else {
                jM1051getPrimary0d7_KjU = j;
            }
            i4 |= i11;
        } else {
            jM1051getPrimary0d7_KjU = j;
        }
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i2 & 7168) == 0) {
                fM1173getStrokeWidthD9Ej5fM = f2;
                if (composerStartRestartGroup.changed(fM1173getStrokeWidthD9Ej5fM)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            i7 = i3 & 16;
            if (i7 != 0) {
                if ((57344 & i2) == 0) {
                    jM3067getTransparent0d7_KjU = j2;
                    if (composerStartRestartGroup.changed(jM3067getTransparent0d7_KjU)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i4 |= i8;
                }
                if ((458752 & i2) == 0) {
                    if ((i3 & 32) == 0) {
                        iM3356getButtKaPHkGw = i;
                        if (composerStartRestartGroup.changed(iM3356getButtKaPHkGw)) {
                        }
                        i4 |= i12;
                    } else {
                        iM3356getButtKaPHkGw = i;
                    }
                    i4 |= i12;
                } else {
                    iM3356getButtKaPHkGw = i;
                }
                if ((i4 & 374491) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i3 & 4) != 0) {
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        }
                        if (i5 != 0) {
                            fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                        }
                        if (i7 != 0) {
                            jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                        }
                        if ((i3 & 32) != 0) {
                            iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                        }
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i3 & 4) != 0) {
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        }
                        if (i5 != 0) {
                            fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                        }
                        if (i7 != 0) {
                            jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                        }
                        if ((i3 & 32) != 0) {
                            iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1746618448, i2, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:285)");
                    }
                    float fK8 = AbstractC3871sJ.k(f, 0.0f, 1.0f);
                    CanvasKt.Canvas(SizeKt.m532size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier2, fK8, null, 0, 6, null), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$1(fK8, jM3067getTransparent0d7_KjU, new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM1173getStrokeWidthD9Ej5fM), 0.0f, iM3356getButtKaPHkGw, 0, null, 26, null), jM1051getPrimary0d7_KjU), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i3 & 4) != 0) {
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        }
                        if (i5 != 0) {
                            fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                        }
                        if (i7 != 0) {
                            jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                        }
                        if ((i3 & 32) != 0) {
                            iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                        }
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i3 & 4) != 0) {
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        }
                        if (i5 != 0) {
                            fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                        }
                        if (i7 != 0) {
                            jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                        }
                        if ((i3 & 32) != 0) {
                            iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1746618448, i2, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:285)");
                    }
                    float fK9 = AbstractC3871sJ.k(f, 0.0f, 1.0f);
                    CanvasKt.Canvas(SizeKt.m532size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier2, fK9, null, 0, 6, null), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$1(fK9, jM3067getTransparent0d7_KjU, new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM1173getStrokeWidthD9Ej5fM), 0.0f, iM3356getButtKaPHkGw, 0, null, 26, null), jM1051getPrimary0d7_KjU), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                j3 = jM1051getPrimary0d7_KjU;
                j4 = jM3067getTransparent0d7_KjU;
                i9 = iM3356getButtKaPHkGw;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$2(f, modifier2, j3, fM1173getStrokeWidthD9Ej5fM, j4, i9, i2, i3));
            }
            i4 |= 24576;
            jM3067getTransparent0d7_KjU = j2;
            if ((458752 & i2) == 0) {
                if ((i3 & 32) == 0) {
                    iM3356getButtKaPHkGw = i;
                    if (composerStartRestartGroup.changed(iM3356getButtKaPHkGw)) {
                    }
                    i4 |= i12;
                } else {
                    iM3356getButtKaPHkGw = i;
                }
                i4 |= i12;
            } else {
                iM3356getButtKaPHkGw = i;
            }
            if ((i4 & 374491) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i3 & 4) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    }
                    if (i5 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                    }
                    if (i7 != 0) {
                        jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                    }
                    if ((i3 & 32) != 0) {
                        iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                    }
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i3 & 4) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    }
                    if (i5 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                    }
                    if (i7 != 0) {
                        jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                    }
                    if ((i3 & 32) != 0) {
                        iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1746618448, i2, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:285)");
                }
                float fK10 = AbstractC3871sJ.k(f, 0.0f, 1.0f);
                CanvasKt.Canvas(SizeKt.m532size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier2, fK10, null, 0, 6, null), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$1(fK10, jM3067getTransparent0d7_KjU, new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM1173getStrokeWidthD9Ej5fM), 0.0f, iM3356getButtKaPHkGw, 0, null, 26, null), jM1051getPrimary0d7_KjU), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i3 & 4) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    }
                    if (i5 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                    }
                    if (i7 != 0) {
                        jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                    }
                    if ((i3 & 32) != 0) {
                        iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                    }
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i3 & 4) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    }
                    if (i5 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                    }
                    if (i7 != 0) {
                        jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                    }
                    if ((i3 & 32) != 0) {
                        iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1746618448, i2, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:285)");
                }
                float fK11 = AbstractC3871sJ.k(f, 0.0f, 1.0f);
                CanvasKt.Canvas(SizeKt.m532size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier2, fK11, null, 0, 6, null), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$1(fK11, jM3067getTransparent0d7_KjU, new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM1173getStrokeWidthD9Ej5fM), 0.0f, iM3356getButtKaPHkGw, 0, null, 26, null), jM1051getPrimary0d7_KjU), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            j3 = jM1051getPrimary0d7_KjU;
            j4 = jM3067getTransparent0d7_KjU;
            i9 = iM3356getButtKaPHkGw;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$2(f, modifier2, j3, fM1173getStrokeWidthD9Ej5fM, j4, i9, i2, i3));
        }
        i4 |= 3072;
        fM1173getStrokeWidthD9Ej5fM = f2;
        i7 = i3 & 16;
        if (i7 != 0) {
            if ((57344 & i2) == 0) {
                jM3067getTransparent0d7_KjU = j2;
                if (composerStartRestartGroup.changed(jM3067getTransparent0d7_KjU)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i4 |= i8;
            }
            if ((458752 & i2) == 0) {
                if ((i3 & 32) == 0) {
                    iM3356getButtKaPHkGw = i;
                    if (composerStartRestartGroup.changed(iM3356getButtKaPHkGw)) {
                    }
                    i4 |= i12;
                } else {
                    iM3356getButtKaPHkGw = i;
                }
                i4 |= i12;
            } else {
                iM3356getButtKaPHkGw = i;
            }
            if ((i4 & 374491) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i3 & 4) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    }
                    if (i5 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                    }
                    if (i7 != 0) {
                        jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                    }
                    if ((i3 & 32) != 0) {
                        iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                    }
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i3 & 4) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    }
                    if (i5 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                    }
                    if (i7 != 0) {
                        jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                    }
                    if ((i3 & 32) != 0) {
                        iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1746618448, i2, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:285)");
                }
                float fK12 = AbstractC3871sJ.k(f, 0.0f, 1.0f);
                CanvasKt.Canvas(SizeKt.m532size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier2, fK12, null, 0, 6, null), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$1(fK12, jM3067getTransparent0d7_KjU, new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM1173getStrokeWidthD9Ej5fM), 0.0f, iM3356getButtKaPHkGw, 0, null, 26, null), jM1051getPrimary0d7_KjU), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i3 & 4) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    }
                    if (i5 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                    }
                    if (i7 != 0) {
                        jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                    }
                    if ((i3 & 32) != 0) {
                        iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                    }
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i3 & 4) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    }
                    if (i5 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                    }
                    if (i7 != 0) {
                        jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                    }
                    if ((i3 & 32) != 0) {
                        iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1746618448, i2, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:285)");
                }
                float fK13 = AbstractC3871sJ.k(f, 0.0f, 1.0f);
                CanvasKt.Canvas(SizeKt.m532size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier2, fK13, null, 0, 6, null), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$1(fK13, jM3067getTransparent0d7_KjU, new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM1173getStrokeWidthD9Ej5fM), 0.0f, iM3356getButtKaPHkGw, 0, null, 26, null), jM1051getPrimary0d7_KjU), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            j3 = jM1051getPrimary0d7_KjU;
            j4 = jM3067getTransparent0d7_KjU;
            i9 = iM3356getButtKaPHkGw;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$2(f, modifier2, j3, fM1173getStrokeWidthD9Ej5fM, j4, i9, i2, i3));
        }
        i4 |= 24576;
        jM3067getTransparent0d7_KjU = j2;
        if ((458752 & i2) == 0) {
            if ((i3 & 32) == 0) {
                iM3356getButtKaPHkGw = i;
                if (composerStartRestartGroup.changed(iM3356getButtKaPHkGw)) {
                }
                i4 |= i12;
            } else {
                iM3356getButtKaPHkGw = i;
            }
            i4 |= i12;
        } else {
            iM3356getButtKaPHkGw = i;
        }
        if ((i4 & 374491) == 74898) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i3 & 4) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                }
                if (i5 != 0) {
                    fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                }
                if (i7 != 0) {
                    jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                }
                if ((i3 & 32) != 0) {
                    iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                }
            } else {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i3 & 4) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                }
                if (i5 != 0) {
                    fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                }
                if (i7 != 0) {
                    jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                }
                if ((i3 & 32) != 0) {
                    iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1746618448, i2, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:285)");
            }
            float fK14 = AbstractC3871sJ.k(f, 0.0f, 1.0f);
            CanvasKt.Canvas(SizeKt.m532size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier2, fK14, null, 0, 6, null), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$1(fK14, jM3067getTransparent0d7_KjU, new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM1173getStrokeWidthD9Ej5fM), 0.0f, iM3356getButtKaPHkGw, 0, null, 26, null), jM1051getPrimary0d7_KjU), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i3 & 4) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                }
                if (i5 != 0) {
                    fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                }
                if (i7 != 0) {
                    jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                }
                if ((i3 & 32) != 0) {
                    iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                }
            } else {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i3 & 4) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                }
                if (i5 != 0) {
                    fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                }
                if (i7 != 0) {
                    jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                }
                if ((i3 & 32) != 0) {
                    iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1746618448, i2, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:285)");
            }
            float fK15 = AbstractC3871sJ.k(f, 0.0f, 1.0f);
            CanvasKt.Canvas(SizeKt.m532size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier2, fK15, null, 0, 6, null), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$1(fK15, jM3067getTransparent0d7_KjU, new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM1173getStrokeWidthD9Ej5fM), 0.0f, iM3356getButtKaPHkGw, 0, null, 26, null), jM1051getPrimary0d7_KjU), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        j3 = jM1051getPrimary0d7_KjU;
        j4 = jM3067getTransparent0d7_KjU;
        i9 = iM3356getButtKaPHkGw;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$2(f, modifier2, j3, fM1173getStrokeWidthD9Ej5fM, j4, i9, i2, i3));
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0064  */
    /* JADX WARN: Code duplicated, block: B:39:0x0069  */
    /* JADX WARN: Code duplicated, block: B:41:0x006d  */
    /* JADX WARN: Code duplicated, block: B:43:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x0078  */
    /* JADX WARN: Code duplicated, block: B:48:0x0081  */
    /* JADX WARN: Code duplicated, block: B:50:0x0085  */
    /* JADX WARN: Code duplicated, block: B:52:0x008d  */
    /* JADX WARN: Code duplicated, block: B:53:0x0090  */
    /* JADX WARN: Code duplicated, block: B:56:0x0096  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c3 A[PHI: r2 r6 r10 r12
      0x00c3: PHI (r2v7 androidx.compose.ui.Modifier) = (r2v2 androidx.compose.ui.Modifier), (r2v8 androidx.compose.ui.Modifier) binds: [B:81:0x00f2, B:68:0x00bf] A[DONT_GENERATE, DONT_INLINE]
      0x00c3: PHI (r6v6 long) = (r6v3 long), (r6v2 long) binds: [B:81:0x00f2, B:68:0x00bf] A[DONT_GENERATE, DONT_INLINE]
      0x00c3: PHI (r10v20 float) = (r10v3 float), (r10v2 float) binds: [B:81:0x00f2, B:68:0x00bf] A[DONT_GENERATE, DONT_INLINE]
      0x00c3: PHI (r12v13 long) = (r12v3 long), (r12v2 long) binds: [B:81:0x00f2, B:68:0x00bf] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:70:0x00c8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:85:0x0107  */
    /* JADX WARN: Code duplicated, block: B:88:0x025c  */
    /* JADX WARN: Code duplicated, block: B:93:0x026d  */
    /* JADX WARN: Code duplicated, block: B:95:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: CircularProgressIndicator-LxG7B9w, reason: not valid java name */
    public static final void m1175CircularProgressIndicatorLxG7B9w(Modifier modifier, long j, float f, long j2, int i, Composer composer, int i2, int i3) {
        Modifier modifier2;
        int i4;
        long jM1051getPrimary0d7_KjU;
        float fM1173getStrokeWidthD9Ej5fM;
        int i5;
        long jM3067getTransparent0d7_KjU;
        int i6;
        int i7;
        Modifier modifier3;
        int iM3358getSquareKaPHkGw;
        float f2;
        long j3;
        float f3;
        long j4;
        long j5;
        int i8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1119119072);
        int i9 = i3 & 1;
        if (i9 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 14) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        if ((i2 & 112) == 0) {
            if ((i3 & 2) == 0) {
                jM1051getPrimary0d7_KjU = j;
                int i10 = composerStartRestartGroup.changed(jM1051getPrimary0d7_KjU) ? 32 : 16;
                i4 |= i10;
            } else {
                jM1051getPrimary0d7_KjU = j;
            }
            i4 |= i10;
        } else {
            jM1051getPrimary0d7_KjU = j;
        }
        int i11 = i3 & 4;
        if (i11 == 0) {
            if ((i2 & 896) == 0) {
                fM1173getStrokeWidthD9Ej5fM = f;
                i4 |= composerStartRestartGroup.changed(fM1173getStrokeWidthD9Ej5fM) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i2 & 7168) == 0) {
                    jM3067getTransparent0d7_KjU = j2;
                    if (composerStartRestartGroup.changed(jM3067getTransparent0d7_KjU)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i4 |= i6;
                }
                if ((57344 & i2) == 0) {
                    if ((i3 & 16) == 0) {
                        i7 = i;
                        int i12 = composerStartRestartGroup.changed(i7) ? 16384 : 8192;
                        i4 |= i12;
                    } else {
                        i7 = i;
                    }
                    i4 |= i12;
                } else {
                    i7 = i;
                }
                if ((i4 & 46811) == 9362 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i9 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i3 & 2) != 0) {
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        }
                        if (i11 != 0) {
                            fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                        }
                        if (i5 != 0) {
                            jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                        }
                        if ((i3 & 16) != 0) {
                            iM3358getSquareKaPHkGw = StrokeCap.Companion.m3358getSquareKaPHkGw();
                            f2 = fM1173getStrokeWidthD9Ej5fM;
                            j3 = jM3067getTransparent0d7_KjU;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1119119072, i2, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:326)");
                        }
                        Stroke stroke = new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f2), 0.0f, iM3358getSquareKaPHkGw, 0, null, 26, null);
                        InfiniteTransition infiniteTransitionRememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition(null, composerStartRestartGroup, 0, 1);
                        TwoWayConverter<Integer, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(C0893Rs.a);
                        InfiniteRepeatableSpec infiniteRepeatableSpecM96infiniteRepeatable9IiC70o$default = AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null);
                        int i13 = InfiniteTransition.$stable;
                        int i14 = InfiniteRepeatableSpec.$stable;
                        State stateAnimateValue = InfiniteTransitionKt.animateValue(infiniteTransitionRememberInfiniteTransition, 0, 5, vectorConverter, infiniteRepeatableSpecM96infiniteRepeatable9IiC70o$default, null, composerStartRestartGroup, i13 | 4528 | (i14 << 12), 16);
                        State<Float> stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, BaseRotationAngle, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, composerStartRestartGroup, i13 | 432 | (i14 << 9), 8);
                        State<Float> stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, JumpRotationAngle, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$CircularProgressIndicator$endAngle$2.INSTANCE), null, 0L, 6, null), null, composerStartRestartGroup, i13 | 432 | (i14 << 9), 8);
                        State<Float> stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, JumpRotationAngle, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$CircularProgressIndicator$startAngle$2.INSTANCE), null, 0L, 6, null), null, composerStartRestartGroup, i13 | 432 | (i14 << 9), 8);
                        Modifier modifier4 = modifier3;
                        f3 = f2;
                        int i15 = iM3358getSquareKaPHkGw;
                        CanvasKt.Canvas(SizeKt.m532size3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier3), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$3(j3, stroke, f2, jM1051getPrimary0d7_KjU, stateAnimateValue, stateAnimateFloat2, stateAnimateFloat3, stateAnimateFloat), composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier4;
                        j4 = jM1051getPrimary0d7_KjU;
                        j5 = j3;
                        i8 = i15;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                    }
                    f2 = fM1173getStrokeWidthD9Ej5fM;
                    j3 = jM3067getTransparent0d7_KjU;
                    iM3358getSquareKaPHkGw = i7;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1119119072, i2, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:326)");
                    }
                    Stroke stroke2 = new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f2), 0.0f, iM3358getSquareKaPHkGw, 0, null, 26, null);
                    InfiniteTransition infiniteTransitionRememberInfiniteTransition2 = InfiniteTransitionKt.rememberInfiniteTransition(null, composerStartRestartGroup, 0, 1);
                    TwoWayConverter<Integer, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(C0893Rs.a);
                    InfiniteRepeatableSpec infiniteRepeatableSpecM96infiniteRepeatable9IiC70o$default2 = AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null);
                    int i16 = InfiniteTransition.$stable;
                    int i17 = InfiniteRepeatableSpec.$stable;
                    State stateAnimateValue2 = InfiniteTransitionKt.animateValue(infiniteTransitionRememberInfiniteTransition2, 0, 5, vectorConverter2, infiniteRepeatableSpecM96infiniteRepeatable9IiC70o$default2, null, composerStartRestartGroup, i16 | 4528 | (i17 << 12), 16);
                    State<Float> stateAnimateFloat4 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, BaseRotationAngle, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, composerStartRestartGroup, i16 | 432 | (i17 << 9), 8);
                    State<Float> stateAnimateFloat5 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, JumpRotationAngle, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$CircularProgressIndicator$endAngle$2.INSTANCE), null, 0L, 6, null), null, composerStartRestartGroup, i16 | 432 | (i17 << 9), 8);
                    State<Float> stateAnimateFloat6 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, JumpRotationAngle, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$CircularProgressIndicator$startAngle$2.INSTANCE), null, 0L, 6, null), null, composerStartRestartGroup, i16 | 432 | (i17 << 9), 8);
                    Modifier modifier5 = modifier3;
                    f3 = f2;
                    int i18 = iM3358getSquareKaPHkGw;
                    CanvasKt.Canvas(SizeKt.m532size3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier3), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$3(j3, stroke2, f2, jM1051getPrimary0d7_KjU, stateAnimateValue2, stateAnimateFloat5, stateAnimateFloat6, stateAnimateFloat4), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier5;
                    j4 = jM1051getPrimary0d7_KjU;
                    j5 = j3;
                    i8 = i18;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    j4 = jM1051getPrimary0d7_KjU;
                    f3 = fM1173getStrokeWidthD9Ej5fM;
                    j5 = jM3067getTransparent0d7_KjU;
                    i8 = i7;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$4(modifier2, j4, f3, j5, i8, i2, i3));
            }
            i4 |= 3072;
            jM3067getTransparent0d7_KjU = j2;
            if ((57344 & i2) == 0) {
                if ((i3 & 16) == 0) {
                    i7 = i;
                    if (composerStartRestartGroup.changed(i7)) {
                    }
                    i4 |= i12;
                } else {
                    i7 = i;
                }
                i4 |= i12;
            } else {
                i7 = i;
            }
            if ((i4 & 46811) == 9362) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i3 & 2) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    }
                    if (i11 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                    }
                    if (i5 != 0) {
                        jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                    }
                    if ((i3 & 16) != 0) {
                        iM3358getSquareKaPHkGw = StrokeCap.Companion.m3358getSquareKaPHkGw();
                        f2 = fM1173getStrokeWidthD9Ej5fM;
                        j3 = jM3067getTransparent0d7_KjU;
                    } else {
                        f2 = fM1173getStrokeWidthD9Ej5fM;
                        j3 = jM3067getTransparent0d7_KjU;
                        iM3358getSquareKaPHkGw = i7;
                    }
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i3 & 2) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    }
                    if (i11 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                    }
                    if (i5 != 0) {
                        jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                    }
                    if ((i3 & 16) != 0) {
                        iM3358getSquareKaPHkGw = StrokeCap.Companion.m3358getSquareKaPHkGw();
                        f2 = fM1173getStrokeWidthD9Ej5fM;
                        j3 = jM3067getTransparent0d7_KjU;
                    } else {
                        f2 = fM1173getStrokeWidthD9Ej5fM;
                        j3 = jM3067getTransparent0d7_KjU;
                        iM3358getSquareKaPHkGw = i7;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1119119072, i2, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:326)");
                }
                Stroke stroke3 = new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f2), 0.0f, iM3358getSquareKaPHkGw, 0, null, 26, null);
                InfiniteTransition infiniteTransitionRememberInfiniteTransition3 = InfiniteTransitionKt.rememberInfiniteTransition(null, composerStartRestartGroup, 0, 1);
                TwoWayConverter<Integer, AnimationVector1D> vectorConverter3 = VectorConvertersKt.getVectorConverter(C0893Rs.a);
                InfiniteRepeatableSpec infiniteRepeatableSpecM96infiniteRepeatable9IiC70o$default3 = AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null);
                int i19 = InfiniteTransition.$stable;
                int i110 = InfiniteRepeatableSpec.$stable;
                State stateAnimateValue3 = InfiniteTransitionKt.animateValue(infiniteTransitionRememberInfiniteTransition3, 0, 5, vectorConverter3, infiniteRepeatableSpecM96infiniteRepeatable9IiC70o$default3, null, composerStartRestartGroup, i19 | 4528 | (i110 << 12), 16);
                State<Float> stateAnimateFloat7 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition3, 0.0f, BaseRotationAngle, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, composerStartRestartGroup, i19 | 432 | (i110 << 9), 8);
                State<Float> stateAnimateFloat8 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition3, 0.0f, JumpRotationAngle, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$CircularProgressIndicator$endAngle$2.INSTANCE), null, 0L, 6, null), null, composerStartRestartGroup, i19 | 432 | (i110 << 9), 8);
                State<Float> stateAnimateFloat9 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition3, 0.0f, JumpRotationAngle, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$CircularProgressIndicator$startAngle$2.INSTANCE), null, 0L, 6, null), null, composerStartRestartGroup, i19 | 432 | (i110 << 9), 8);
                Modifier modifier6 = modifier3;
                f3 = f2;
                int i111 = iM3358getSquareKaPHkGw;
                CanvasKt.Canvas(SizeKt.m532size3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier3), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$3(j3, stroke3, f2, jM1051getPrimary0d7_KjU, stateAnimateValue3, stateAnimateFloat8, stateAnimateFloat9, stateAnimateFloat7), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier6;
                j4 = jM1051getPrimary0d7_KjU;
                j5 = j3;
                i8 = i111;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i3 & 2) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    }
                    if (i11 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                    }
                    if (i5 != 0) {
                        jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                    }
                    if ((i3 & 16) != 0) {
                        iM3358getSquareKaPHkGw = StrokeCap.Companion.m3358getSquareKaPHkGw();
                        f2 = fM1173getStrokeWidthD9Ej5fM;
                        j3 = jM3067getTransparent0d7_KjU;
                    } else {
                        f2 = fM1173getStrokeWidthD9Ej5fM;
                        j3 = jM3067getTransparent0d7_KjU;
                        iM3358getSquareKaPHkGw = i7;
                    }
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i3 & 2) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    }
                    if (i11 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                    }
                    if (i5 != 0) {
                        jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                    }
                    if ((i3 & 16) != 0) {
                        iM3358getSquareKaPHkGw = StrokeCap.Companion.m3358getSquareKaPHkGw();
                        f2 = fM1173getStrokeWidthD9Ej5fM;
                        j3 = jM3067getTransparent0d7_KjU;
                    } else {
                        f2 = fM1173getStrokeWidthD9Ej5fM;
                        j3 = jM3067getTransparent0d7_KjU;
                        iM3358getSquareKaPHkGw = i7;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1119119072, i2, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:326)");
                }
                Stroke stroke4 = new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f2), 0.0f, iM3358getSquareKaPHkGw, 0, null, 26, null);
                InfiniteTransition infiniteTransitionRememberInfiniteTransition4 = InfiniteTransitionKt.rememberInfiniteTransition(null, composerStartRestartGroup, 0, 1);
                TwoWayConverter<Integer, AnimationVector1D> vectorConverter4 = VectorConvertersKt.getVectorConverter(C0893Rs.a);
                InfiniteRepeatableSpec infiniteRepeatableSpecM96infiniteRepeatable9IiC70o$default4 = AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null);
                int i112 = InfiniteTransition.$stable;
                int i113 = InfiniteRepeatableSpec.$stable;
                State stateAnimateValue4 = InfiniteTransitionKt.animateValue(infiniteTransitionRememberInfiniteTransition4, 0, 5, vectorConverter4, infiniteRepeatableSpecM96infiniteRepeatable9IiC70o$default4, null, composerStartRestartGroup, i112 | 4528 | (i113 << 12), 16);
                State<Float> stateAnimateFloat10 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition4, 0.0f, BaseRotationAngle, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, composerStartRestartGroup, i112 | 432 | (i113 << 9), 8);
                State<Float> stateAnimateFloat11 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition4, 0.0f, JumpRotationAngle, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$CircularProgressIndicator$endAngle$2.INSTANCE), null, 0L, 6, null), null, composerStartRestartGroup, i112 | 432 | (i113 << 9), 8);
                State<Float> stateAnimateFloat12 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition4, 0.0f, JumpRotationAngle, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$CircularProgressIndicator$startAngle$2.INSTANCE), null, 0L, 6, null), null, composerStartRestartGroup, i112 | 432 | (i113 << 9), 8);
                Modifier modifier7 = modifier3;
                f3 = f2;
                int i114 = iM3358getSquareKaPHkGw;
                CanvasKt.Canvas(SizeKt.m532size3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier3), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$3(j3, stroke4, f2, jM1051getPrimary0d7_KjU, stateAnimateValue4, stateAnimateFloat11, stateAnimateFloat12, stateAnimateFloat10), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier7;
                j4 = jM1051getPrimary0d7_KjU;
                j5 = j3;
                i8 = i114;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$4(modifier2, j4, f3, j5, i8, i2, i3));
        }
        i4 |= 384;
        fM1173getStrokeWidthD9Ej5fM = f;
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i2 & 7168) == 0) {
                jM3067getTransparent0d7_KjU = j2;
                if (composerStartRestartGroup.changed(jM3067getTransparent0d7_KjU)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            if ((57344 & i2) == 0) {
                if ((i3 & 16) == 0) {
                    i7 = i;
                    if (composerStartRestartGroup.changed(i7)) {
                    }
                    i4 |= i12;
                } else {
                    i7 = i;
                }
                i4 |= i12;
            } else {
                i7 = i;
            }
            if ((i4 & 46811) == 9362) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i3 & 2) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    }
                    if (i11 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                    }
                    if (i5 != 0) {
                        jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                    }
                    if ((i3 & 16) != 0) {
                        iM3358getSquareKaPHkGw = StrokeCap.Companion.m3358getSquareKaPHkGw();
                        f2 = fM1173getStrokeWidthD9Ej5fM;
                        j3 = jM3067getTransparent0d7_KjU;
                    } else {
                        f2 = fM1173getStrokeWidthD9Ej5fM;
                        j3 = jM3067getTransparent0d7_KjU;
                        iM3358getSquareKaPHkGw = i7;
                    }
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i3 & 2) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    }
                    if (i11 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                    }
                    if (i5 != 0) {
                        jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                    }
                    if ((i3 & 16) != 0) {
                        iM3358getSquareKaPHkGw = StrokeCap.Companion.m3358getSquareKaPHkGw();
                        f2 = fM1173getStrokeWidthD9Ej5fM;
                        j3 = jM3067getTransparent0d7_KjU;
                    } else {
                        f2 = fM1173getStrokeWidthD9Ej5fM;
                        j3 = jM3067getTransparent0d7_KjU;
                        iM3358getSquareKaPHkGw = i7;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1119119072, i2, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:326)");
                }
                Stroke stroke5 = new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f2), 0.0f, iM3358getSquareKaPHkGw, 0, null, 26, null);
                InfiniteTransition infiniteTransitionRememberInfiniteTransition5 = InfiniteTransitionKt.rememberInfiniteTransition(null, composerStartRestartGroup, 0, 1);
                TwoWayConverter<Integer, AnimationVector1D> vectorConverter5 = VectorConvertersKt.getVectorConverter(C0893Rs.a);
                InfiniteRepeatableSpec infiniteRepeatableSpecM96infiniteRepeatable9IiC70o$default5 = AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null);
                int i115 = InfiniteTransition.$stable;
                int i116 = InfiniteRepeatableSpec.$stable;
                State stateAnimateValue5 = InfiniteTransitionKt.animateValue(infiniteTransitionRememberInfiniteTransition5, 0, 5, vectorConverter5, infiniteRepeatableSpecM96infiniteRepeatable9IiC70o$default5, null, composerStartRestartGroup, i115 | 4528 | (i116 << 12), 16);
                State<Float> stateAnimateFloat13 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition5, 0.0f, BaseRotationAngle, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, composerStartRestartGroup, i115 | 432 | (i116 << 9), 8);
                State<Float> stateAnimateFloat14 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition5, 0.0f, JumpRotationAngle, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$CircularProgressIndicator$endAngle$2.INSTANCE), null, 0L, 6, null), null, composerStartRestartGroup, i115 | 432 | (i116 << 9), 8);
                State<Float> stateAnimateFloat15 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition5, 0.0f, JumpRotationAngle, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$CircularProgressIndicator$startAngle$2.INSTANCE), null, 0L, 6, null), null, composerStartRestartGroup, i115 | 432 | (i116 << 9), 8);
                Modifier modifier8 = modifier3;
                f3 = f2;
                int i117 = iM3358getSquareKaPHkGw;
                CanvasKt.Canvas(SizeKt.m532size3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier3), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$3(j3, stroke5, f2, jM1051getPrimary0d7_KjU, stateAnimateValue5, stateAnimateFloat14, stateAnimateFloat15, stateAnimateFloat13), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier8;
                j4 = jM1051getPrimary0d7_KjU;
                j5 = j3;
                i8 = i117;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i3 & 2) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    }
                    if (i11 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                    }
                    if (i5 != 0) {
                        jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                    }
                    if ((i3 & 16) != 0) {
                        iM3358getSquareKaPHkGw = StrokeCap.Companion.m3358getSquareKaPHkGw();
                        f2 = fM1173getStrokeWidthD9Ej5fM;
                        j3 = jM3067getTransparent0d7_KjU;
                    } else {
                        f2 = fM1173getStrokeWidthD9Ej5fM;
                        j3 = jM3067getTransparent0d7_KjU;
                        iM3358getSquareKaPHkGw = i7;
                    }
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i3 & 2) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    }
                    if (i11 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                    }
                    if (i5 != 0) {
                        jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                    }
                    if ((i3 & 16) != 0) {
                        iM3358getSquareKaPHkGw = StrokeCap.Companion.m3358getSquareKaPHkGw();
                        f2 = fM1173getStrokeWidthD9Ej5fM;
                        j3 = jM3067getTransparent0d7_KjU;
                    } else {
                        f2 = fM1173getStrokeWidthD9Ej5fM;
                        j3 = jM3067getTransparent0d7_KjU;
                        iM3358getSquareKaPHkGw = i7;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1119119072, i2, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:326)");
                }
                Stroke stroke6 = new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f2), 0.0f, iM3358getSquareKaPHkGw, 0, null, 26, null);
                InfiniteTransition infiniteTransitionRememberInfiniteTransition6 = InfiniteTransitionKt.rememberInfiniteTransition(null, composerStartRestartGroup, 0, 1);
                TwoWayConverter<Integer, AnimationVector1D> vectorConverter6 = VectorConvertersKt.getVectorConverter(C0893Rs.a);
                InfiniteRepeatableSpec infiniteRepeatableSpecM96infiniteRepeatable9IiC70o$default6 = AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null);
                int i118 = InfiniteTransition.$stable;
                int i119 = InfiniteRepeatableSpec.$stable;
                State stateAnimateValue6 = InfiniteTransitionKt.animateValue(infiniteTransitionRememberInfiniteTransition6, 0, 5, vectorConverter6, infiniteRepeatableSpecM96infiniteRepeatable9IiC70o$default6, null, composerStartRestartGroup, i118 | 4528 | (i119 << 12), 16);
                State<Float> stateAnimateFloat16 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition6, 0.0f, BaseRotationAngle, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, composerStartRestartGroup, i118 | 432 | (i119 << 9), 8);
                State<Float> stateAnimateFloat17 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition6, 0.0f, JumpRotationAngle, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$CircularProgressIndicator$endAngle$2.INSTANCE), null, 0L, 6, null), null, composerStartRestartGroup, i118 | 432 | (i119 << 9), 8);
                State<Float> stateAnimateFloat18 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition6, 0.0f, JumpRotationAngle, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$CircularProgressIndicator$startAngle$2.INSTANCE), null, 0L, 6, null), null, composerStartRestartGroup, i118 | 432 | (i119 << 9), 8);
                Modifier modifier9 = modifier3;
                f3 = f2;
                int i1110 = iM3358getSquareKaPHkGw;
                CanvasKt.Canvas(SizeKt.m532size3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier3), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$3(j3, stroke6, f2, jM1051getPrimary0d7_KjU, stateAnimateValue6, stateAnimateFloat17, stateAnimateFloat18, stateAnimateFloat16), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier9;
                j4 = jM1051getPrimary0d7_KjU;
                j5 = j3;
                i8 = i1110;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$4(modifier2, j4, f3, j5, i8, i2, i3));
        }
        i4 |= 3072;
        jM3067getTransparent0d7_KjU = j2;
        if ((57344 & i2) == 0) {
            if ((i3 & 16) == 0) {
                i7 = i;
                if (composerStartRestartGroup.changed(i7)) {
                }
                i4 |= i12;
            } else {
                i7 = i;
            }
            i4 |= i12;
        } else {
            i7 = i;
        }
        if ((i4 & 46811) == 9362) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i3 & 2) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                }
                if (i11 != 0) {
                    fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                }
                if (i5 != 0) {
                    jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                }
                if ((i3 & 16) != 0) {
                    iM3358getSquareKaPHkGw = StrokeCap.Companion.m3358getSquareKaPHkGw();
                    f2 = fM1173getStrokeWidthD9Ej5fM;
                    j3 = jM3067getTransparent0d7_KjU;
                } else {
                    f2 = fM1173getStrokeWidthD9Ej5fM;
                    j3 = jM3067getTransparent0d7_KjU;
                    iM3358getSquareKaPHkGw = i7;
                }
            } else {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i3 & 2) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                }
                if (i11 != 0) {
                    fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                }
                if (i5 != 0) {
                    jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                }
                if ((i3 & 16) != 0) {
                    iM3358getSquareKaPHkGw = StrokeCap.Companion.m3358getSquareKaPHkGw();
                    f2 = fM1173getStrokeWidthD9Ej5fM;
                    j3 = jM3067getTransparent0d7_KjU;
                } else {
                    f2 = fM1173getStrokeWidthD9Ej5fM;
                    j3 = jM3067getTransparent0d7_KjU;
                    iM3358getSquareKaPHkGw = i7;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1119119072, i2, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:326)");
            }
            Stroke stroke7 = new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f2), 0.0f, iM3358getSquareKaPHkGw, 0, null, 26, null);
            InfiniteTransition infiniteTransitionRememberInfiniteTransition7 = InfiniteTransitionKt.rememberInfiniteTransition(null, composerStartRestartGroup, 0, 1);
            TwoWayConverter<Integer, AnimationVector1D> vectorConverter7 = VectorConvertersKt.getVectorConverter(C0893Rs.a);
            InfiniteRepeatableSpec infiniteRepeatableSpecM96infiniteRepeatable9IiC70o$default7 = AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null);
            int i1111 = InfiniteTransition.$stable;
            int i1112 = InfiniteRepeatableSpec.$stable;
            State stateAnimateValue7 = InfiniteTransitionKt.animateValue(infiniteTransitionRememberInfiniteTransition7, 0, 5, vectorConverter7, infiniteRepeatableSpecM96infiniteRepeatable9IiC70o$default7, null, composerStartRestartGroup, i1111 | 4528 | (i1112 << 12), 16);
            State<Float> stateAnimateFloat19 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition7, 0.0f, BaseRotationAngle, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, composerStartRestartGroup, i1111 | 432 | (i1112 << 9), 8);
            State<Float> stateAnimateFloat110 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition7, 0.0f, JumpRotationAngle, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$CircularProgressIndicator$endAngle$2.INSTANCE), null, 0L, 6, null), null, composerStartRestartGroup, i1111 | 432 | (i1112 << 9), 8);
            State<Float> stateAnimateFloat111 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition7, 0.0f, JumpRotationAngle, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$CircularProgressIndicator$startAngle$2.INSTANCE), null, 0L, 6, null), null, composerStartRestartGroup, i1111 | 432 | (i1112 << 9), 8);
            Modifier modifier10 = modifier3;
            f3 = f2;
            int i1113 = iM3358getSquareKaPHkGw;
            CanvasKt.Canvas(SizeKt.m532size3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier3), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$3(j3, stroke7, f2, jM1051getPrimary0d7_KjU, stateAnimateValue7, stateAnimateFloat110, stateAnimateFloat111, stateAnimateFloat19), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier10;
            j4 = jM1051getPrimary0d7_KjU;
            j5 = j3;
            i8 = i1113;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i3 & 2) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                }
                if (i11 != 0) {
                    fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                }
                if (i5 != 0) {
                    jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                }
                if ((i3 & 16) != 0) {
                    iM3358getSquareKaPHkGw = StrokeCap.Companion.m3358getSquareKaPHkGw();
                    f2 = fM1173getStrokeWidthD9Ej5fM;
                    j3 = jM3067getTransparent0d7_KjU;
                } else {
                    f2 = fM1173getStrokeWidthD9Ej5fM;
                    j3 = jM3067getTransparent0d7_KjU;
                    iM3358getSquareKaPHkGw = i7;
                }
            } else {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i3 & 2) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                }
                if (i11 != 0) {
                    fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                }
                if (i5 != 0) {
                    jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
                }
                if ((i3 & 16) != 0) {
                    iM3358getSquareKaPHkGw = StrokeCap.Companion.m3358getSquareKaPHkGw();
                    f2 = fM1173getStrokeWidthD9Ej5fM;
                    j3 = jM3067getTransparent0d7_KjU;
                } else {
                    f2 = fM1173getStrokeWidthD9Ej5fM;
                    j3 = jM3067getTransparent0d7_KjU;
                    iM3358getSquareKaPHkGw = i7;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1119119072, i2, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:326)");
            }
            Stroke stroke8 = new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f2), 0.0f, iM3358getSquareKaPHkGw, 0, null, 26, null);
            InfiniteTransition infiniteTransitionRememberInfiniteTransition8 = InfiniteTransitionKt.rememberInfiniteTransition(null, composerStartRestartGroup, 0, 1);
            TwoWayConverter<Integer, AnimationVector1D> vectorConverter8 = VectorConvertersKt.getVectorConverter(C0893Rs.a);
            InfiniteRepeatableSpec infiniteRepeatableSpecM96infiniteRepeatable9IiC70o$default8 = AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null);
            int i1114 = InfiniteTransition.$stable;
            int i1115 = InfiniteRepeatableSpec.$stable;
            State stateAnimateValue8 = InfiniteTransitionKt.animateValue(infiniteTransitionRememberInfiniteTransition8, 0, 5, vectorConverter8, infiniteRepeatableSpecM96infiniteRepeatable9IiC70o$default8, null, composerStartRestartGroup, i1114 | 4528 | (i1115 << 12), 16);
            State<Float> stateAnimateFloat112 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition8, 0.0f, BaseRotationAngle, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, composerStartRestartGroup, i1114 | 432 | (i1115 << 9), 8);
            State<Float> stateAnimateFloat113 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition8, 0.0f, JumpRotationAngle, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$CircularProgressIndicator$endAngle$2.INSTANCE), null, 0L, 6, null), null, composerStartRestartGroup, i1114 | 432 | (i1115 << 9), 8);
            State<Float> stateAnimateFloat114 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition8, 0.0f, JumpRotationAngle, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$CircularProgressIndicator$startAngle$2.INSTANCE), null, 0L, 6, null), null, composerStartRestartGroup, i1114 | 432 | (i1115 << 9), 8);
            Modifier modifier11 = modifier3;
            f3 = f2;
            int i1116 = iM3358getSquareKaPHkGw;
            CanvasKt.Canvas(SizeKt.m532size3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier3), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$3(j3, stroke8, f2, jM1051getPrimary0d7_KjU, stateAnimateValue8, stateAnimateFloat113, stateAnimateFloat114, stateAnimateFloat112), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier11;
            j4 = jM1051getPrimary0d7_KjU;
            j5 = j3;
            i8 = i1116;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$4(modifier2, j4, f3, j5, i8, i2, i3));
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    /* JADX WARN: Code duplicated, block: B:28:0x004c  */
    /* JADX WARN: Code duplicated, block: B:30:0x0054  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:34:0x005d  */
    /* JADX WARN: Code duplicated, block: B:37:0x0063  */
    /* JADX WARN: Code duplicated, block: B:39:0x0068  */
    /* JADX WARN: Code duplicated, block: B:41:0x006c  */
    /* JADX WARN: Code duplicated, block: B:43:0x0074  */
    /* JADX WARN: Code duplicated, block: B:44:0x0077  */
    /* JADX WARN: Code duplicated, block: B:48:0x0080  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:54:0x0097  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a8 A[PHI: r3 r4 r7
      0x00a8: PHI (r3v16 int) = (r3v12 int), (r3v17 int) binds: [B:68:0x00c3, B:60:0x00a7] A[DONT_GENERATE, DONT_INLINE]
      0x00a8: PHI (r4v5 androidx.compose.ui.Modifier) = (r4v2 androidx.compose.ui.Modifier), (r4v7 androidx.compose.ui.Modifier) binds: [B:68:0x00c3, B:60:0x00a7] A[DONT_GENERATE, DONT_INLINE]
      0x00a8: PHI (r7v15 long) = (r7v7 long), (r7v6 long) binds: [B:68:0x00c3, B:60:0x00a7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:62:0x00ac A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:75:0x0108  */
    /* JADX WARN: Code duplicated, block: B:79:0x0112  */
    /* JADX WARN: Code duplicated, block: B:81:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: CircularProgressIndicator-MBs18nI, reason: not valid java name */
    public static final /* synthetic */ void m1176CircularProgressIndicatorMBs18nI(float f, Modifier modifier, long j, float f2, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        long jM1051getPrimary0d7_KjU;
        int i4;
        float f3;
        int i5;
        Modifier modifier3;
        float fM1173getStrokeWidthD9Ej5fM;
        long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-409649739);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                if ((i2 & 4) == 0) {
                    jM1051getPrimary0d7_KjU = j;
                    int i7 = composerStartRestartGroup.changed(jM1051getPrimary0d7_KjU) ? 256 : 128;
                    i3 |= i7;
                } else {
                    jM1051getPrimary0d7_KjU = j;
                }
                i3 |= i7;
            } else {
                jM1051getPrimary0d7_KjU = j;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    f3 = f2;
                    if (composerStartRestartGroup.changed(f3)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i3 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i6 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                            i3 &= -897;
                        }
                        if (i4 != 0) {
                            fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                            j2 = jM1051getPrimary0d7_KjU;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-409649739, i3, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:405)");
                        }
                        m1174CircularProgressIndicatorDUhRLBM(f, modifier3, j2, fM1173getStrokeWidthD9Ej5fM, Color.Companion.m3067getTransparent0d7_KjU(), StrokeCap.Companion.m3356getButtKaPHkGw(), composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        modifier3 = modifier2;
                    }
                    j2 = jM1051getPrimary0d7_KjU;
                    fM1173getStrokeWidthD9Ej5fM = f3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-409649739, i3, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:405)");
                    }
                    m1174CircularProgressIndicatorDUhRLBM(f, modifier3, j2, fM1173getStrokeWidthD9Ej5fM, Color.Companion.m3067getTransparent0d7_KjU(), StrokeCap.Companion.m3356getButtKaPHkGw(), composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    j2 = jM1051getPrimary0d7_KjU;
                    fM1173getStrokeWidthD9Ej5fM = f3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$5(f, modifier3, j2, fM1173getStrokeWidthD9Ej5fM, i, i2));
            }
            i3 |= 3072;
            f3 = f2;
            if ((i3 & 5851) == 1170) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        i3 &= -897;
                    }
                    if (i4 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                        j2 = jM1051getPrimary0d7_KjU;
                    } else {
                        j2 = jM1051getPrimary0d7_KjU;
                        fM1173getStrokeWidthD9Ej5fM = f3;
                    }
                } else {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        i3 &= -897;
                    }
                    if (i4 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                        j2 = jM1051getPrimary0d7_KjU;
                    } else {
                        j2 = jM1051getPrimary0d7_KjU;
                        fM1173getStrokeWidthD9Ej5fM = f3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-409649739, i3, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:405)");
                }
                m1174CircularProgressIndicatorDUhRLBM(f, modifier3, j2, fM1173getStrokeWidthD9Ej5fM, Color.Companion.m3067getTransparent0d7_KjU(), StrokeCap.Companion.m3356getButtKaPHkGw(), composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        i3 &= -897;
                    }
                    if (i4 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                        j2 = jM1051getPrimary0d7_KjU;
                    } else {
                        j2 = jM1051getPrimary0d7_KjU;
                        fM1173getStrokeWidthD9Ej5fM = f3;
                    }
                } else {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        i3 &= -897;
                    }
                    if (i4 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                        j2 = jM1051getPrimary0d7_KjU;
                    } else {
                        j2 = jM1051getPrimary0d7_KjU;
                        fM1173getStrokeWidthD9Ej5fM = f3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-409649739, i3, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:405)");
                }
                m1174CircularProgressIndicatorDUhRLBM(f, modifier3, j2, fM1173getStrokeWidthD9Ej5fM, Color.Companion.m3067getTransparent0d7_KjU(), StrokeCap.Companion.m3356getButtKaPHkGw(), composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$5(f, modifier3, j2, fM1173getStrokeWidthD9Ej5fM, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                jM1051getPrimary0d7_KjU = j;
                if (composerStartRestartGroup.changed(jM1051getPrimary0d7_KjU)) {
                }
                i3 |= i7;
            } else {
                jM1051getPrimary0d7_KjU = j;
            }
            i3 |= i7;
        } else {
            jM1051getPrimary0d7_KjU = j;
        }
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                f3 = f2;
                if (composerStartRestartGroup.changed(f3)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i3 & 5851) == 1170) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        i3 &= -897;
                    }
                    if (i4 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                        j2 = jM1051getPrimary0d7_KjU;
                    } else {
                        j2 = jM1051getPrimary0d7_KjU;
                        fM1173getStrokeWidthD9Ej5fM = f3;
                    }
                } else {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        i3 &= -897;
                    }
                    if (i4 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                        j2 = jM1051getPrimary0d7_KjU;
                    } else {
                        j2 = jM1051getPrimary0d7_KjU;
                        fM1173getStrokeWidthD9Ej5fM = f3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-409649739, i3, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:405)");
                }
                m1174CircularProgressIndicatorDUhRLBM(f, modifier3, j2, fM1173getStrokeWidthD9Ej5fM, Color.Companion.m3067getTransparent0d7_KjU(), StrokeCap.Companion.m3356getButtKaPHkGw(), composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        i3 &= -897;
                    }
                    if (i4 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                        j2 = jM1051getPrimary0d7_KjU;
                    } else {
                        j2 = jM1051getPrimary0d7_KjU;
                        fM1173getStrokeWidthD9Ej5fM = f3;
                    }
                } else {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        i3 &= -897;
                    }
                    if (i4 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                        j2 = jM1051getPrimary0d7_KjU;
                    } else {
                        j2 = jM1051getPrimary0d7_KjU;
                        fM1173getStrokeWidthD9Ej5fM = f3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-409649739, i3, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:405)");
                }
                m1174CircularProgressIndicatorDUhRLBM(f, modifier3, j2, fM1173getStrokeWidthD9Ej5fM, Color.Companion.m3067getTransparent0d7_KjU(), StrokeCap.Companion.m3356getButtKaPHkGw(), composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$5(f, modifier3, j2, fM1173getStrokeWidthD9Ej5fM, i, i2));
        }
        i3 |= 3072;
        f3 = f2;
        if ((i3 & 5851) == 1170) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    i3 &= -897;
                }
                if (i4 != 0) {
                    fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                    j2 = jM1051getPrimary0d7_KjU;
                } else {
                    j2 = jM1051getPrimary0d7_KjU;
                    fM1173getStrokeWidthD9Ej5fM = f3;
                }
            } else {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    i3 &= -897;
                }
                if (i4 != 0) {
                    fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                    j2 = jM1051getPrimary0d7_KjU;
                } else {
                    j2 = jM1051getPrimary0d7_KjU;
                    fM1173getStrokeWidthD9Ej5fM = f3;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-409649739, i3, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:405)");
            }
            m1174CircularProgressIndicatorDUhRLBM(f, modifier3, j2, fM1173getStrokeWidthD9Ej5fM, Color.Companion.m3067getTransparent0d7_KjU(), StrokeCap.Companion.m3356getButtKaPHkGw(), composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    i3 &= -897;
                }
                if (i4 != 0) {
                    fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                    j2 = jM1051getPrimary0d7_KjU;
                } else {
                    j2 = jM1051getPrimary0d7_KjU;
                    fM1173getStrokeWidthD9Ej5fM = f3;
                }
            } else {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    i3 &= -897;
                }
                if (i4 != 0) {
                    fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                    j2 = jM1051getPrimary0d7_KjU;
                } else {
                    j2 = jM1051getPrimary0d7_KjU;
                    fM1173getStrokeWidthD9Ej5fM = f3;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-409649739, i3, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:405)");
            }
            m1174CircularProgressIndicatorDUhRLBM(f, modifier3, j2, fM1173getStrokeWidthD9Ej5fM, Color.Companion.m3067getTransparent0d7_KjU(), StrokeCap.Companion.m3356getButtKaPHkGw(), composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$5(f, modifier3, j2, fM1173getStrokeWidthD9Ej5fM, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0073  */
    /* JADX WARN: Code duplicated, block: B:43:0x007a  */
    /* JADX WARN: Code duplicated, block: B:50:0x008b A[PHI: r2 r4 r6
      0x008b: PHI (r2v5 androidx.compose.ui.Modifier) = (r2v2 androidx.compose.ui.Modifier), (r2v7 androidx.compose.ui.Modifier) binds: [B:58:0x00aa, B:49:0x008a] A[DONT_GENERATE, DONT_INLINE]
      0x008b: PHI (r4v13 int) = (r4v10 int), (r4v14 int) binds: [B:58:0x00aa, B:49:0x008a] A[DONT_GENERATE, DONT_INLINE]
      0x008b: PHI (r6v10 long) = (r6v3 long), (r6v2 long) binds: [B:58:0x00aa, B:49:0x008a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:52:0x0093 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x0095  */
    /* JADX WARN: Code duplicated, block: B:54:0x0098  */
    /* JADX WARN: Code duplicated, block: B:57:0x009d  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:62:0x00be  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:70:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:72:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: CircularProgressIndicator-aM-cp0Q, reason: not valid java name */
    public static final /* synthetic */ void m1177CircularProgressIndicatoraMcp0Q(Modifier modifier, long j, float f, Composer composer, int i, int i2) {
        Modifier modifier2;
        int i3;
        long jM1051getPrimary0d7_KjU;
        float f2;
        Modifier modifier3;
        float fM1173getStrokeWidthD9Ej5fM;
        int i4;
        long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-392089979);
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                jM1051getPrimary0d7_KjU = j;
                int i6 = composerStartRestartGroup.changed(jM1051getPrimary0d7_KjU) ? 32 : 16;
                i3 |= i6;
            } else {
                jM1051getPrimary0d7_KjU = j;
            }
            i3 |= i6;
        } else {
            jM1051getPrimary0d7_KjU = j;
        }
        int i7 = i2 & 4;
        if (i7 == 0) {
            if ((i & 896) == 0) {
                f2 = f;
                i3 |= composerStartRestartGroup.changed(f2) ? 256 : 128;
            }
            if ((i3 & 731) == 146 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i5 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        i3 &= -113;
                    }
                    if (i7 != 0) {
                        fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                    }
                    long j3 = jM1051getPrimary0d7_KjU;
                    i4 = i3;
                    j2 = j3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-392089979, i4, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:421)");
                    }
                    m1175CircularProgressIndicatorLxG7B9w(modifier3, j2, fM1173getStrokeWidthD9Ej5fM, Color.Companion.m3067getTransparent0d7_KjU(), StrokeCap.Companion.m3358getSquareKaPHkGw(), composerStartRestartGroup, (i4 & 14) | 3072 | (i4 & 112) | (i4 & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f2 = fM1173getStrokeWidthD9Ej5fM;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    modifier3 = modifier2;
                }
                fM1173getStrokeWidthD9Ej5fM = f2;
                long j4 = jM1051getPrimary0d7_KjU;
                i4 = i3;
                j2 = j4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-392089979, i4, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:421)");
                }
                m1175CircularProgressIndicatorLxG7B9w(modifier3, j2, fM1173getStrokeWidthD9Ej5fM, Color.Companion.m3067getTransparent0d7_KjU(), StrokeCap.Companion.m3358getSquareKaPHkGw(), composerStartRestartGroup, (i4 & 14) | 3072 | (i4 & 112) | (i4 & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f2 = fM1173getStrokeWidthD9Ej5fM;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                j2 = jM1051getPrimary0d7_KjU;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$6(modifier3, j2, f2, i, i2));
        }
        i3 |= 384;
        f2 = f;
        if ((i3 & 731) == 146) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    i3 &= -113;
                }
                if (i7 != 0) {
                    fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                } else {
                    fM1173getStrokeWidthD9Ej5fM = f2;
                }
            } else {
                if (i5 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    i3 &= -113;
                }
                if (i7 != 0) {
                    fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                } else {
                    fM1173getStrokeWidthD9Ej5fM = f2;
                }
            }
            long j5 = jM1051getPrimary0d7_KjU;
            i4 = i3;
            j2 = j5;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-392089979, i4, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:421)");
            }
            m1175CircularProgressIndicatorLxG7B9w(modifier3, j2, fM1173getStrokeWidthD9Ej5fM, Color.Companion.m3067getTransparent0d7_KjU(), StrokeCap.Companion.m3358getSquareKaPHkGw(), composerStartRestartGroup, (i4 & 14) | 3072 | (i4 & 112) | (i4 & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f2 = fM1173getStrokeWidthD9Ej5fM;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    i3 &= -113;
                }
                if (i7 != 0) {
                    fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                } else {
                    fM1173getStrokeWidthD9Ej5fM = f2;
                }
            } else {
                if (i5 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    i3 &= -113;
                }
                if (i7 != 0) {
                    fM1173getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1173getStrokeWidthD9Ej5fM();
                } else {
                    fM1173getStrokeWidthD9Ej5fM = f2;
                }
            }
            long j6 = jM1051getPrimary0d7_KjU;
            i4 = i3;
            j2 = j6;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-392089979, i4, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:421)");
            }
            m1175CircularProgressIndicatorLxG7B9w(modifier3, j2, fM1173getStrokeWidthD9Ej5fM, Color.Companion.m3067getTransparent0d7_KjU(), StrokeCap.Companion.m3358getSquareKaPHkGw(), composerStartRestartGroup, (i4 & 14) | 3072 | (i4 & 112) | (i4 & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f2 = fM1173getStrokeWidthD9Ej5fM;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$6(modifier3, j2, f2, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CircularProgressIndicator_LxG7B9w$lambda$10(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CircularProgressIndicator_LxG7B9w$lambda$11(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int CircularProgressIndicator_LxG7B9w$lambda$8(State<Integer> state) {
        return state.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CircularProgressIndicator_LxG7B9w$lambda$9(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: LinearProgressIndicator-2cYBFYY, reason: not valid java name */
    public static final void m1178LinearProgressIndicator2cYBFYY(Modifier modifier, long j, long j2, int i, Composer composer, int i2, int i3) {
        Modifier modifier2;
        int i4;
        long j3;
        long j4;
        int iM3356getButtKaPHkGw;
        int i5;
        Modifier modifier3;
        long j5;
        long j6;
        int i6;
        long j7;
        long j8;
        Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(1501635280);
        int i7 = i3 & 1;
        if (i7 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 14) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        if ((i2 & 112) == 0) {
            if ((i3 & 2) == 0) {
                j3 = j;
                int i8 = composerStartRestartGroup.changed(j3) ? 32 : 16;
                i4 |= i8;
            } else {
                j3 = j;
            }
            i4 |= i8;
        } else {
            j3 = j;
        }
        if ((i2 & 896) == 0) {
            if ((i3 & 4) == 0) {
                j4 = j2;
                int i9 = composerStartRestartGroup.changed(j4) ? 256 : 128;
                i4 |= i9;
            } else {
                j4 = j2;
            }
            i4 |= i9;
        } else {
            j4 = j2;
        }
        if ((i2 & 7168) == 0) {
            if ((i3 & 8) == 0) {
                iM3356getButtKaPHkGw = i;
                int i10 = composerStartRestartGroup.changed(iM3356getButtKaPHkGw) ? 2048 : 1024;
                i4 |= i10;
            } else {
                iM3356getButtKaPHkGw = i;
            }
            i4 |= i10;
        } else {
            iM3356getButtKaPHkGw = i;
        }
        if ((i4 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            i6 = iM3356getButtKaPHkGw;
            modifier4 = modifier2;
            j7 = j3;
            j8 = j4;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if (i7 != 0) {
                    modifier2 = Modifier.Companion;
                }
                long jM1051getPrimary0d7_KjU = (i3 & 2) != 0 ? MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU() : j3;
                long jM3031copywmQWz5c$default = (i3 & 4) != 0 ? Color.m3031copywmQWz5c$default(jM1051getPrimary0d7_KjU, 0.24f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
                if ((i3 & 8) != 0) {
                    iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                }
                i5 = iM3356getButtKaPHkGw;
                modifier3 = modifier2;
                j5 = jM1051getPrimary0d7_KjU;
                j6 = jM3031copywmQWz5c$default;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                i5 = iM3356getButtKaPHkGw;
                modifier3 = modifier2;
                j5 = j3;
                j6 = j4;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1501635280, i2, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:106)");
            }
            InfiniteTransition infiniteTransitionRememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition(null, composerStartRestartGroup, 0, 1);
            InfiniteRepeatableSpec infiniteRepeatableSpecM96infiniteRepeatable9IiC70o$default = AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$2.INSTANCE), null, 0L, 6, null);
            int i11 = InfiniteTransition.$stable;
            int i12 = InfiniteRepeatableSpec.$stable;
            State<Float> stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, infiniteRepeatableSpecM96infiniteRepeatable9IiC70o$default, null, composerStartRestartGroup, i11 | 432 | (i12 << 9), 8);
            State<Float> stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$2.INSTANCE), null, 0L, 6, null), null, composerStartRestartGroup, i11 | 432 | (i12 << 9), 8);
            State<Float> stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$2.INSTANCE), null, 0L, 6, null), null, composerStartRestartGroup, i11 | 432 | (i12 << 9), 8);
            State<Float> stateAnimateFloat4 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$2.INSTANCE), null, 0L, 6, null), null, composerStartRestartGroup, i11 | 432 | (i12 << 9), 8);
            Modifier modifierM534sizeVpY3zN4 = SizeKt.m534sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(modifier3), LinearIndicatorWidth, LinearIndicatorHeight);
            Object[] objArr = {Color.m3022boximpl(j6), StrokeCap.m3349boximpl(i5), stateAnimateFloat, stateAnimateFloat2, Color.m3022boximpl(j5), stateAnimateFloat3, stateAnimateFloat4};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            boolean zChanged = false;
            for (int i13 = 0; i13 < 7; i13++) {
                zChanged |= composerStartRestartGroup.changed(objArr[i13]);
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new ProgressIndicatorKt$LinearProgressIndicator$3$1(j6, i5, j5, stateAnimateFloat, stateAnimateFloat2, stateAnimateFloat3, stateAnimateFloat4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(modifierM534sizeVpY3zN4, (InterfaceC3750qp) objRememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            i6 = i5;
            j7 = j5;
            j8 = j6;
            modifier4 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new ProgressIndicatorKt$LinearProgressIndicator$4(modifier4, j7, j8, i6, i2, i3));
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: LinearProgressIndicator-RIQooxk, reason: not valid java name */
    public static final /* synthetic */ void m1179LinearProgressIndicatorRIQooxk(Modifier modifier, long j, long j2, Composer composer, int i, int i2) {
        Modifier modifier2;
        int i3;
        long jM1051getPrimary0d7_KjU;
        long jM3031copywmQWz5c$default;
        Modifier modifier3;
        long j3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-819397058);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 112) == 0) {
            jM1051getPrimary0d7_KjU = j;
            i3 |= ((i2 & 2) == 0 && composerStartRestartGroup.changed(jM1051getPrimary0d7_KjU)) ? 32 : 16;
        } else {
            jM1051getPrimary0d7_KjU = j;
        }
        if ((i & 896) == 0) {
            jM3031copywmQWz5c$default = j2;
            i3 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(jM3031copywmQWz5c$default)) ? 256 : 128;
        } else {
            jM3031copywmQWz5c$default = j2;
        }
        if ((i3 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            j3 = jM1051getPrimary0d7_KjU;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                modifier3 = i4 != 0 ? Modifier.Companion : modifier2;
                if ((i2 & 2) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM1051getPrimary0d7_KjU, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                    i3 &= -897;
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                modifier3 = modifier2;
            }
            int i5 = i3;
            j3 = jM1051getPrimary0d7_KjU;
            long j4 = jM3031copywmQWz5c$default;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-819397058, i5, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:205)");
            }
            m1178LinearProgressIndicator2cYBFYY(modifier3, j3, j4, StrokeCap.Companion.m3356getButtKaPHkGw(), composerStartRestartGroup, i5 & 1022, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            jM3031copywmQWz5c$default = j4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new ProgressIndicatorKt$LinearProgressIndicator$6(modifier3, j3, jM3031copywmQWz5c$default, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0049  */
    /* JADX WARN: Code duplicated, block: B:28:0x004d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0055  */
    /* JADX WARN: Code duplicated, block: B:31:0x0058  */
    /* JADX WARN: Code duplicated, block: B:34:0x005e  */
    /* JADX WARN: Code duplicated, block: B:37:0x0064  */
    /* JADX WARN: Code duplicated, block: B:42:0x0073  */
    /* JADX WARN: Code duplicated, block: B:44:0x0078  */
    /* JADX WARN: Code duplicated, block: B:47:0x0081  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:54:0x0095  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c3 A[PHI: r0 r12 r13
      0x00c3: PHI (r0v5 long) = (r0v2 long), (r0v1 long) binds: [B:77:0x00f1, B:66:0x00c0] A[DONT_GENERATE, DONT_INLINE]
      0x00c3: PHI (r12v6 androidx.compose.ui.Modifier) = (r12v3 androidx.compose.ui.Modifier), (r12v2 androidx.compose.ui.Modifier) binds: [B:77:0x00f1, B:66:0x00c0] A[DONT_GENERATE, DONT_INLINE]
      0x00c3: PHI (r13v10 long) = (r13v7 long), (r13v6 long) binds: [B:77:0x00f1, B:66:0x00c0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:68:0x00c5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:69:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:75:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:81:0x0102  */
    /* JADX WARN: Code duplicated, block: B:84:0x0156 A[LOOP:0: B:83:0x0154->B:84:0x0156, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:87:0x0166  */
    /* JADX WARN: Code duplicated, block: B:89:0x016e  */
    /* JADX WARN: Code duplicated, block: B:92:0x018d  */
    /* JADX WARN: Code duplicated, block: B:97:0x019b  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: LinearProgressIndicator-_5eSR-E, reason: not valid java name */
    public static final void m1180LinearProgressIndicator_5eSRE(float f, Modifier modifier, long j, long j2, int i, Composer composer, int i2, int i3) {
        int i4;
        Modifier modifier2;
        long jM1051getPrimary0d7_KjU;
        long jM3031copywmQWz5c$default;
        int i5;
        int iM3356getButtKaPHkGw;
        float fK;
        Object[] objArr;
        int i6;
        boolean zChanged;
        Object objRememberedValue;
        long j3;
        int i7;
        Modifier modifier3;
        long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(-531984864);
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i10 = i3 & 2;
        if (i10 == 0) {
            if ((i2 & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 896) == 0) {
                if ((i3 & 4) == 0) {
                    jM1051getPrimary0d7_KjU = j;
                    int i11 = composerStartRestartGroup.changed(jM1051getPrimary0d7_KjU) ? 256 : 128;
                    i4 |= i11;
                } else {
                    jM1051getPrimary0d7_KjU = j;
                }
                i4 |= i11;
            } else {
                jM1051getPrimary0d7_KjU = j;
            }
            if ((i2 & 7168) == 0) {
                jM3031copywmQWz5c$default = j2;
                if ((i3 & 8) == 0 || !composerStartRestartGroup.changed(jM3031copywmQWz5c$default)) {
                    i9 = 1024;
                } else {
                    i9 = 2048;
                }
                i4 |= i9;
            } else {
                jM3031copywmQWz5c$default = j2;
            }
            if ((i2 & 57344) == 0) {
                i5 = i;
                if ((i3 & 16) == 0 || !composerStartRestartGroup.changed(i5)) {
                    i8 = 8192;
                } else {
                    i8 = 16384;
                }
                i4 |= i8;
            } else {
                i5 = i;
            }
            if ((i4 & 46811) == 9362 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i3 & 4) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    }
                    if ((i3 & 8) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM1051getPrimary0d7_KjU, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    if ((i3 & 16) != 0) {
                        iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-531984864, i2, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:72)");
                    }
                    fK = AbstractC3871sJ.k(f, 0.0f, 1.0f);
                    Modifier modifierM534sizeVpY3zN4 = SizeKt.m534sizeVpY3zN4(ProgressSemanticsKt.progressSemantics$default(modifier2, fK, null, 0, 6, null), LinearIndicatorWidth, LinearIndicatorHeight);
                    objArr = new Object[]{Color.m3022boximpl(jM3031copywmQWz5c$default), StrokeCap.m3349boximpl(iM3356getButtKaPHkGw), Float.valueOf(fK), Color.m3022boximpl(jM1051getPrimary0d7_KjU)};
                    composerStartRestartGroup.startReplaceableGroup(-568225417);
                    i6 = 0;
                    zChanged = false;
                    for (int i12 = 4; i6 < i12; i12 = 4) {
                        zChanged |= composerStartRestartGroup.changed(objArr[i6]);
                        i6++;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new ProgressIndicatorKt$LinearProgressIndicator$1$1(jM3031copywmQWz5c$default, iM3356getButtKaPHkGw, fK, jM1051getPrimary0d7_KjU);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CanvasKt.Canvas(modifierM534sizeVpY3zN4, (InterfaceC3750qp) objRememberedValue, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = jM3031copywmQWz5c$default;
                    i7 = iM3356getButtKaPHkGw;
                    modifier3 = modifier2;
                    j4 = jM1051getPrimary0d7_KjU;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                }
                iM3356getButtKaPHkGw = i5;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-531984864, i2, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:72)");
                }
                fK = AbstractC3871sJ.k(f, 0.0f, 1.0f);
                Modifier modifierM534sizeVpY3zN5 = SizeKt.m534sizeVpY3zN4(ProgressSemanticsKt.progressSemantics$default(modifier2, fK, null, 0, 6, null), LinearIndicatorWidth, LinearIndicatorHeight);
                objArr = new Object[]{Color.m3022boximpl(jM3031copywmQWz5c$default), StrokeCap.m3349boximpl(iM3356getButtKaPHkGw), Float.valueOf(fK), Color.m3022boximpl(jM1051getPrimary0d7_KjU)};
                composerStartRestartGroup.startReplaceableGroup(-568225417);
                i6 = 0;
                zChanged = false;
                while (i6 < i12) {
                    zChanged |= composerStartRestartGroup.changed(objArr[i6]);
                    i6++;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new ProgressIndicatorKt$LinearProgressIndicator$1$1(jM3031copywmQWz5c$default, iM3356getButtKaPHkGw, fK, jM1051getPrimary0d7_KjU);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new ProgressIndicatorKt$LinearProgressIndicator$1$1(jM3031copywmQWz5c$default, iM3356getButtKaPHkGw, fK, jM1051getPrimary0d7_KjU);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierM534sizeVpY3zN5, (InterfaceC3750qp) objRememberedValue, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = jM3031copywmQWz5c$default;
                i7 = iM3356getButtKaPHkGw;
                modifier3 = modifier2;
                j4 = jM1051getPrimary0d7_KjU;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                j3 = jM3031copywmQWz5c$default;
                modifier3 = modifier2;
                j4 = jM1051getPrimary0d7_KjU;
                i7 = i5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ProgressIndicatorKt$LinearProgressIndicator$2(f, modifier3, j4, j3, i7, i2, i3));
        }
        i4 |= 48;
        modifier2 = modifier;
        if ((i2 & 896) == 0) {
            if ((i3 & 4) == 0) {
                jM1051getPrimary0d7_KjU = j;
                if (composerStartRestartGroup.changed(jM1051getPrimary0d7_KjU)) {
                }
                i4 |= i11;
            } else {
                jM1051getPrimary0d7_KjU = j;
            }
            i4 |= i11;
        } else {
            jM1051getPrimary0d7_KjU = j;
        }
        if ((i2 & 7168) == 0) {
            jM3031copywmQWz5c$default = j2;
            if ((i3 & 8) == 0) {
                i9 = 1024;
            } else {
                i9 = 1024;
            }
            i4 |= i9;
        } else {
            jM3031copywmQWz5c$default = j2;
        }
        if ((i2 & 57344) == 0) {
            i5 = i;
            if ((i3 & 16) == 0) {
                i8 = 8192;
            } else {
                i8 = 8192;
            }
            i4 |= i8;
        } else {
            i5 = i;
        }
        if ((i4 & 46811) == 9362) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i3 & 4) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                }
                if ((i3 & 8) != 0) {
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM1051getPrimary0d7_KjU, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                }
                if ((i3 & 16) != 0) {
                    iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                } else {
                    iM3356getButtKaPHkGw = i5;
                }
            } else {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i3 & 4) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                }
                if ((i3 & 8) != 0) {
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM1051getPrimary0d7_KjU, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                }
                if ((i3 & 16) != 0) {
                    iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                } else {
                    iM3356getButtKaPHkGw = i5;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-531984864, i2, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:72)");
            }
            fK = AbstractC3871sJ.k(f, 0.0f, 1.0f);
            Modifier modifierM534sizeVpY3zN6 = SizeKt.m534sizeVpY3zN4(ProgressSemanticsKt.progressSemantics$default(modifier2, fK, null, 0, 6, null), LinearIndicatorWidth, LinearIndicatorHeight);
            objArr = new Object[]{Color.m3022boximpl(jM3031copywmQWz5c$default), StrokeCap.m3349boximpl(iM3356getButtKaPHkGw), Float.valueOf(fK), Color.m3022boximpl(jM1051getPrimary0d7_KjU)};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            i6 = 0;
            zChanged = false;
            while (i6 < i12) {
                zChanged |= composerStartRestartGroup.changed(objArr[i6]);
                i6++;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue = new ProgressIndicatorKt$LinearProgressIndicator$1$1(jM3031copywmQWz5c$default, iM3356getButtKaPHkGw, fK, jM1051getPrimary0d7_KjU);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new ProgressIndicatorKt$LinearProgressIndicator$1$1(jM3031copywmQWz5c$default, iM3356getButtKaPHkGw, fK, jM1051getPrimary0d7_KjU);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(modifierM534sizeVpY3zN6, (InterfaceC3750qp) objRememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j3 = jM3031copywmQWz5c$default;
            i7 = iM3356getButtKaPHkGw;
            modifier3 = modifier2;
            j4 = jM1051getPrimary0d7_KjU;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i3 & 4) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                }
                if ((i3 & 8) != 0) {
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM1051getPrimary0d7_KjU, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                }
                if ((i3 & 16) != 0) {
                    iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                } else {
                    iM3356getButtKaPHkGw = i5;
                }
            } else {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i3 & 4) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                }
                if ((i3 & 8) != 0) {
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM1051getPrimary0d7_KjU, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                }
                if ((i3 & 16) != 0) {
                    iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
                } else {
                    iM3356getButtKaPHkGw = i5;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-531984864, i2, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:72)");
            }
            fK = AbstractC3871sJ.k(f, 0.0f, 1.0f);
            Modifier modifierM534sizeVpY3zN7 = SizeKt.m534sizeVpY3zN4(ProgressSemanticsKt.progressSemantics$default(modifier2, fK, null, 0, 6, null), LinearIndicatorWidth, LinearIndicatorHeight);
            objArr = new Object[]{Color.m3022boximpl(jM3031copywmQWz5c$default), StrokeCap.m3349boximpl(iM3356getButtKaPHkGw), Float.valueOf(fK), Color.m3022boximpl(jM1051getPrimary0d7_KjU)};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            i6 = 0;
            zChanged = false;
            while (i6 < i12) {
                zChanged |= composerStartRestartGroup.changed(objArr[i6]);
                i6++;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue = new ProgressIndicatorKt$LinearProgressIndicator$1$1(jM3031copywmQWz5c$default, iM3356getButtKaPHkGw, fK, jM1051getPrimary0d7_KjU);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new ProgressIndicatorKt$LinearProgressIndicator$1$1(jM3031copywmQWz5c$default, iM3356getButtKaPHkGw, fK, jM1051getPrimary0d7_KjU);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(modifierM534sizeVpY3zN7, (InterfaceC3750qp) objRememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j3 = jM3031copywmQWz5c$default;
            i7 = iM3356getButtKaPHkGw;
            modifier3 = modifier2;
            j4 = jM1051getPrimary0d7_KjU;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new ProgressIndicatorKt$LinearProgressIndicator$2(f, modifier3, j4, j3, i7, i2, i3));
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:33:0x005b  */
    /* JADX WARN: Code duplicated, block: B:36:0x0061  */
    /* JADX WARN: Code duplicated, block: B:41:0x0070  */
    /* JADX WARN: Code duplicated, block: B:43:0x0074  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:52:0x0091  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a9 A[PHI: r3 r4 r5
      0x00a9: PHI (r3v15 int) = (r3v11 int), (r3v17 int) binds: [B:71:0x00c7, B:61:0x00a7] A[DONT_GENERATE, DONT_INLINE]
      0x00a9: PHI (r4v5 androidx.compose.ui.Modifier) = (r4v2 androidx.compose.ui.Modifier), (r4v8 androidx.compose.ui.Modifier) binds: [B:71:0x00c7, B:61:0x00a7] A[DONT_GENERATE, DONT_INLINE]
      0x00a9: PHI (r5v11 long) = (r5v5 long), (r5v12 long) binds: [B:71:0x00c7, B:61:0x00a7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:63:0x00ac A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:78:0x0106  */
    /* JADX WARN: Code duplicated, block: B:83:0x0113  */
    /* JADX WARN: Code duplicated, block: B:85:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: LinearProgressIndicator-eaDK9VM, reason: not valid java name */
    public static final /* synthetic */ void m1181LinearProgressIndicatoreaDK9VM(float f, Modifier modifier, long j, long j2, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        long j3;
        long j4;
        Modifier modifier3;
        long jM1051getPrimary0d7_KjU;
        long jM3031copywmQWz5c$default;
        long j5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i4;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-850309746);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                j3 = j;
                if ((i2 & 4) == 0 || !composerStartRestartGroup.changed(j3)) {
                    i5 = 128;
                } else {
                    i5 = 256;
                }
                i3 |= i5;
            } else {
                j3 = j;
            }
            if ((i & 7168) == 0) {
                j4 = j2;
                if ((i2 & 8) == 0 || !composerStartRestartGroup.changed(j4)) {
                    i4 = 1024;
                } else {
                    i4 = 2048;
                }
                i3 |= i4;
            } else {
                j4 = j2;
            }
            if ((i3 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        i3 &= -897;
                    } else {
                        jM1051getPrimary0d7_KjU = j3;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM1051getPrimary0d7_KjU, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-850309746, i3, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:190)");
                    }
                    m1180LinearProgressIndicator_5eSRE(f, modifier3, jM1051getPrimary0d7_KjU, jM3031copywmQWz5c$default, StrokeCap.Companion.m3356getButtKaPHkGw(), composerStartRestartGroup, i3 & 8190, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = jM1051getPrimary0d7_KjU;
                    j5 = jM3031copywmQWz5c$default;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    modifier3 = modifier2;
                    jM1051getPrimary0d7_KjU = j3;
                }
                jM3031copywmQWz5c$default = j4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-850309746, i3, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:190)");
                }
                m1180LinearProgressIndicator_5eSRE(f, modifier3, jM1051getPrimary0d7_KjU, jM3031copywmQWz5c$default, StrokeCap.Companion.m3356getButtKaPHkGw(), composerStartRestartGroup, i3 & 8190, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = jM1051getPrimary0d7_KjU;
                j5 = jM3031copywmQWz5c$default;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                j5 = j4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ProgressIndicatorKt$LinearProgressIndicator$5(f, modifier3, j3, j5, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 896) == 0) {
            j3 = j;
            if ((i2 & 4) == 0) {
                i5 = 128;
            } else {
                i5 = 128;
            }
            i3 |= i5;
        } else {
            j3 = j;
        }
        if ((i & 7168) == 0) {
            j4 = j2;
            if ((i2 & 8) == 0) {
                i4 = 1024;
            } else {
                i4 = 1024;
            }
            i3 |= i4;
        } else {
            j4 = j2;
        }
        if ((i3 & 5851) == 1170) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    i3 &= -897;
                } else {
                    jM1051getPrimary0d7_KjU = j3;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM1051getPrimary0d7_KjU, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jM3031copywmQWz5c$default = j4;
                }
            } else {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    i3 &= -897;
                } else {
                    jM1051getPrimary0d7_KjU = j3;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM1051getPrimary0d7_KjU, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jM3031copywmQWz5c$default = j4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-850309746, i3, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:190)");
            }
            m1180LinearProgressIndicator_5eSRE(f, modifier3, jM1051getPrimary0d7_KjU, jM3031copywmQWz5c$default, StrokeCap.Companion.m3356getButtKaPHkGw(), composerStartRestartGroup, i3 & 8190, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j3 = jM1051getPrimary0d7_KjU;
            j5 = jM3031copywmQWz5c$default;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    i3 &= -897;
                } else {
                    jM1051getPrimary0d7_KjU = j3;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM1051getPrimary0d7_KjU, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jM3031copywmQWz5c$default = j4;
                }
            } else {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    i3 &= -897;
                } else {
                    jM1051getPrimary0d7_KjU = j3;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM1051getPrimary0d7_KjU, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jM3031copywmQWz5c$default = j4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-850309746, i3, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:190)");
            }
            m1180LinearProgressIndicator_5eSRE(f, modifier3, jM1051getPrimary0d7_KjU, jM3031copywmQWz5c$default, StrokeCap.Companion.m3356getButtKaPHkGw(), composerStartRestartGroup, i3 & 8190, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j3 = jM1051getPrimary0d7_KjU;
            j5 = jM3031copywmQWz5c$default;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new ProgressIndicatorKt$LinearProgressIndicator$5(f, modifier3, j3, j5, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LinearProgressIndicator_2cYBFYY$lambda$1(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LinearProgressIndicator_2cYBFYY$lambda$2(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LinearProgressIndicator_2cYBFYY$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LinearProgressIndicator_2cYBFYY$lambda$4(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: renamed from: drawCircularIndicator-42QJj7c, reason: not valid java name */
    private static final void m1187drawCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        float f3 = 2;
        float width = stroke.getWidth() / f3;
        float fM2867getWidthimpl = Size.m2867getWidthimpl(drawScope.mo3469getSizeNHjbRc()) - (f3 * width);
        AbstractC3255kk.v(drawScope, j, f, f2, false, OffsetKt.Offset(width, width), androidx.compose.ui.geometry.SizeKt.Size(fM2867getWidthimpl, fM2867getWidthimpl), 0.0f, stroke, null, 0, 832, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawCircularIndicatorBackground-bw27NRU, reason: not valid java name */
    public static final void m1188drawCircularIndicatorBackgroundbw27NRU(DrawScope drawScope, long j, Stroke stroke) {
        m1187drawCircularIndicator42QJj7c(drawScope, 0.0f, 360.0f, j, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawDeterminateCircularIndicator-42QJj7c, reason: not valid java name */
    public static final void m1189drawDeterminateCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        m1187drawCircularIndicator42QJj7c(drawScope, f, f2, j, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawIndeterminateCircularIndicator-hrjfTZI, reason: not valid java name */
    public static final void m1190drawIndeterminateCircularIndicatorhrjfTZI(DrawScope drawScope, float f, float f2, float f3, long j, Stroke stroke) {
        m1187drawCircularIndicator42QJj7c(drawScope, f + (StrokeCap.m3352equalsimpl0(stroke.m3556getCapKaPHkGw(), StrokeCap.Companion.m3356getButtKaPHkGw()) ? 0.0f : ((f2 / Dp.m5160constructorimpl(CircularIndicatorDiameter / 2)) * 57.29578f) / 2.0f), Math.max(f3, 0.1f), j, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawLinearIndicator-qYKTg0g, reason: not valid java name */
    public static final void m1191drawLinearIndicatorqYKTg0g(DrawScope drawScope, float f, float f2, long j, float f3, int i) {
        float fM2867getWidthimpl = Size.m2867getWidthimpl(drawScope.mo3469getSizeNHjbRc());
        float fM2864getHeightimpl = Size.m2864getHeightimpl(drawScope.mo3469getSizeNHjbRc());
        float f4 = 2;
        float f5 = fM2864getHeightimpl / f4;
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Ltr;
        float f6 = (z ? f : 1.0f - f2) * fM2867getWidthimpl;
        float f7 = (z ? f2 : 1.0f - f) * fM2867getWidthimpl;
        if (StrokeCap.m3352equalsimpl0(i, StrokeCap.Companion.m3356getButtKaPHkGw()) || fM2864getHeightimpl > fM2867getWidthimpl) {
            AbstractC3255kk.C(drawScope, j, OffsetKt.Offset(f6, f5), OffsetKt.Offset(f7, f5), f3, 0, null, 0.0f, null, 0, MetaDo.META_DELETEOBJECT, null);
            return;
        }
        float f8 = f3 / f4;
        InterfaceC0789Ob interfaceC0789ObB = AbstractC3790rJ.b(f8, fM2867getWidthimpl - f8);
        float fFloatValue = ((Number) AbstractC3871sJ.o(Float.valueOf(f6), interfaceC0789ObB)).floatValue();
        float fFloatValue2 = ((Number) AbstractC3871sJ.o(Float.valueOf(f7), interfaceC0789ObB)).floatValue();
        if (Math.abs(f2 - f) > 0.0f) {
            AbstractC3255kk.C(drawScope, j, OffsetKt.Offset(fFloatValue, f5), OffsetKt.Offset(fFloatValue2, f5), f3, i, null, 0.0f, null, 0, 480, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawLinearIndicatorBackground-AZGd3zU, reason: not valid java name */
    public static final void m1192drawLinearIndicatorBackgroundAZGd3zU(DrawScope drawScope, long j, float f, int i) {
        m1191drawLinearIndicatorqYKTg0g(drawScope, 0.0f, 1.0f, j, f, i);
    }
}
