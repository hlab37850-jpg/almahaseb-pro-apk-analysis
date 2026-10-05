package androidx.compose.material3;

import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.FabPrimaryLargeTokens;
import androidx.compose.material3.tokens.FabPrimarySmallTokens;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class FloatingActionButtonKt {
    private static final ExitTransition ExtendedFabCollapseAnimation;
    private static final EnterTransition ExtendedFabExpandAnimation;
    private static final float ExtendedFabStartIconPadding = Dp.m5160constructorimpl(16);
    private static final float ExtendedFabEndIconPadding = Dp.m5160constructorimpl(12);
    private static final float ExtendedFabTextPadding = Dp.m5160constructorimpl(20);
    private static final float ExtendedFabMinimumWidth = Dp.m5160constructorimpl(80);

    static {
        MotionTokens motionTokens = MotionTokens.INSTANCE;
        ExitTransition exitTransitionFadeOut$default = EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(100, 0, motionTokens.getEasingLinearCubicBezier(), 2, null), 0.0f, 2, null);
        TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(500, 0, motionTokens.getEasingEmphasizedCubicBezier(), 2, null);
        Alignment.Companion companion = Alignment.Companion;
        ExtendedFabCollapseAnimation = exitTransitionFadeOut$default.plus(EnterExitTransitionKt.shrinkHorizontally$default(tweenSpecTween$default, companion.getStart(), false, null, 12, null));
        ExtendedFabExpandAnimation = EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween(200, 100, motionTokens.getEasingLinearCubicBezier()), 0.0f, 2, null).plus(EnterExitTransitionKt.expandHorizontally$default(AnimationSpecKt.tween$default(500, 0, motionTokens.getEasingEmphasizedCubicBezier(), 2, null), companion.getStart(), false, null, 12, null));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x011e  */
    /* JADX WARN: Code duplicated, block: B:102:0x0126  */
    /* JADX WARN: Code duplicated, block: B:104:0x012c  */
    /* JADX WARN: Code duplicated, block: B:105:0x012f  */
    /* JADX WARN: Code duplicated, block: B:109:0x013d  */
    /* JADX WARN: Code duplicated, block: B:113:0x015c  */
    /* JADX WARN: Code duplicated, block: B:115:0x016c  */
    /* JADX WARN: Code duplicated, block: B:131:0x01a0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:132:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:133:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:135:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:136:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:139:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:140:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:143:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:146:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:149:0x01db  */
    /* JADX WARN: Code duplicated, block: B:150:0x0202  */
    /* JADX WARN: Code duplicated, block: B:152:0x0205  */
    /* JADX WARN: Code duplicated, block: B:154:0x0217  */
    /* JADX WARN: Code duplicated, block: B:157:0x022f  */
    /* JADX WARN: Code duplicated, block: B:160:0x023b  */
    /* JADX WARN: Code duplicated, block: B:163:0x0293  */
    /* JADX WARN: Code duplicated, block: B:168:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0089  */
    /* JADX WARN: Code duplicated, block: B:48:0x008e  */
    /* JADX WARN: Code duplicated, block: B:50:0x0092  */
    /* JADX WARN: Code duplicated, block: B:52:0x009a  */
    /* JADX WARN: Code duplicated, block: B:53:0x009d  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:59:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:65:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:78:0x00df  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:90:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:92:0x0107  */
    /* JADX WARN: Code duplicated, block: B:93:0x010a  */
    /* JADX WARN: Code duplicated, block: B:96:0x0111  */
    /* JADX WARN: Code duplicated, block: B:99:0x0117  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: ExtendedFloatingActionButton-ElI5-7k, reason: not valid java name */
    public static final void m1587ExtendedFloatingActionButtonElI57k(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Composer composer, int i, int i2) {
        int i3;
        int i4;
        int i5;
        long containerColor;
        long jM1449contentColorForek8zF_U;
        FloatingActionButtonElevation floatingActionButtonElevation2;
        int i6;
        int i7;
        Modifier modifier2;
        boolean z2;
        Shape extendedFabShape;
        FloatingActionButtonElevation floatingActionButtonElevationM1584elevationxZ9QkE;
        MutableInteractionSource mutableInteractionSource2;
        boolean z3;
        FloatingActionButtonElevation floatingActionButtonElevation3;
        Shape shape2;
        long j3;
        long j4;
        Object objRememberedValue;
        Modifier modifier3;
        Shape shape3;
        long j5;
        FloatingActionButtonElevation floatingActionButtonElevation4;
        boolean z4;
        long j6;
        MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        int i9;
        AbstractC4492zt.h(interfaceC0526Fp, "text");
        AbstractC4492zt.h(interfaceC0526Fp2, "icon");
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1387401842);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp2) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC3588op) ? 256 : 128;
        }
        int i10 = i2 & 8;
        if (i10 == 0) {
            if ((i & 7168) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                if ((i & 458752) != 0) {
                    i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
                }
                if ((i & 3670016) == 0) {
                    containerColor = j;
                    if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(containerColor)) {
                        i9 = 524288;
                    } else {
                        i9 = 1048576;
                    }
                    i3 |= i9;
                } else {
                    containerColor = j;
                }
                if ((i & 29360128) == 0) {
                    jM1449contentColorForek8zF_U = j2;
                    if ((i2 & 128) == 0 || !composerStartRestartGroup.changed(jM1449contentColorForek8zF_U)) {
                        i8 = 4194304;
                    } else {
                        i8 = 8388608;
                    }
                    i3 |= i8;
                } else {
                    jM1449contentColorForek8zF_U = j2;
                }
                if ((i & 234881024) == 0) {
                    if ((i2 & 256) == 0) {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                        int i11 = composerStartRestartGroup.changed(floatingActionButtonElevation2) ? 67108864 : 33554432;
                        i3 |= i11;
                    } else {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                    }
                    i3 |= i11;
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                i6 = i2 & 512;
                if (i6 != 0) {
                    i3 |= 805306368;
                } else if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i7 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i7 = 268435456;
                    }
                    i3 |= i7;
                }
                if ((i3 & 1533916891) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 32) != 0) {
                            extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            extendedFabShape = shape;
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i3 &= -234881025;
                        } else {
                            floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        z3 = z2;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM1584elevationxZ9QkE;
                        shape2 = extendedFabShape;
                        j3 = jM1449contentColorForek8zF_U;
                        j4 = containerColor;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            i3 &= -29360129;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                        }
                        modifier2 = modifier;
                        shape2 = shape;
                        mutableInteractionSource2 = mutableInteractionSource;
                        j3 = jM1449contentColorForek8zF_U;
                        j4 = containerColor;
                        floatingActionButtonElevation3 = floatingActionButtonElevation2;
                        z3 = z;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1387401842, i3, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:337)");
                    }
                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1172118032, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$5(z3, interfaceC0526Fp2, i3, interfaceC0526Fp));
                    int i12 = i3 >> 6;
                    int i13 = i3 >> 9;
                    boolean z5 = z3;
                    m1589FloatingActionButtonXz6DiA(interfaceC3588op, modifier2, shape2, j4, j3, floatingActionButtonElevation3, mutableInteractionSource2, composableLambda, composerStartRestartGroup, (i12 & 112) | (i12 & 14) | 12582912 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (i13 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    shape3 = shape2;
                    j5 = j4;
                    floatingActionButtonElevation4 = floatingActionButtonElevation3;
                    z4 = z5;
                    j6 = j3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier;
                    z4 = z;
                    shape3 = shape;
                    FloatingActionButtonElevation floatingActionButtonElevation5 = floatingActionButtonElevation2;
                    mutableInteractionSource3 = mutableInteractionSource;
                    floatingActionButtonElevation4 = floatingActionButtonElevation5;
                    j6 = jM1449contentColorForek8zF_U;
                    j5 = containerColor;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$ExtendedFloatingActionButton$6(interfaceC0526Fp, interfaceC0526Fp2, interfaceC3588op, modifier3, z4, shape3, j5, j6, floatingActionButtonElevation4, mutableInteractionSource3, i, i2));
            }
            i3 |= 24576;
            if ((i & 458752) != 0) {
                i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
            }
            if ((i & 3670016) == 0) {
                containerColor = j;
                if ((i2 & 64) == 0) {
                    i9 = 524288;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            } else {
                containerColor = j;
            }
            if ((i & 29360128) == 0) {
                jM1449contentColorForek8zF_U = j2;
                if ((i2 & 128) == 0) {
                    i8 = 4194304;
                } else {
                    i8 = 4194304;
                }
                i3 |= i8;
            } else {
                jM1449contentColorForek8zF_U = j2;
            }
            if ((i & 234881024) == 0) {
                if ((i2 & 256) == 0) {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                    if (composerStartRestartGroup.changed(floatingActionButtonElevation2)) {
                    }
                    i3 |= i11;
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                i3 |= i11;
            } else {
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            i6 = i2 & 512;
            if (i6 != 0) {
                i3 |= 805306368;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i7 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i7 = 268435456;
                }
                i3 |= i7;
            }
            if ((i3 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 32) != 0) {
                        extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        extendedFabShape = shape;
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -234881025;
                    } else {
                        floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    z3 = z2;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM1584elevationxZ9QkE;
                    shape2 = extendedFabShape;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = containerColor;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 32) != 0) {
                        extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        extendedFabShape = shape;
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -234881025;
                    } else {
                        floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    z3 = z2;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM1584elevationxZ9QkE;
                    shape2 = extendedFabShape;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = containerColor;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1387401842, i3, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:337)");
                }
                ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1172118032, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$5(z3, interfaceC0526Fp2, i3, interfaceC0526Fp));
                int i14 = i3 >> 6;
                int i15 = i3 >> 9;
                boolean z6 = z3;
                m1589FloatingActionButtonXz6DiA(interfaceC3588op, modifier2, shape2, j4, j3, floatingActionButtonElevation3, mutableInteractionSource2, composableLambda2, composerStartRestartGroup, (i14 & 112) | (i14 & 14) | 12582912 | (i15 & 896) | (i15 & 7168) | (57344 & i15) | (458752 & i15) | (i15 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                shape3 = shape2;
                j5 = j4;
                floatingActionButtonElevation4 = floatingActionButtonElevation3;
                z4 = z6;
                j6 = j3;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 32) != 0) {
                        extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        extendedFabShape = shape;
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -234881025;
                    } else {
                        floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    z3 = z2;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM1584elevationxZ9QkE;
                    shape2 = extendedFabShape;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = containerColor;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 32) != 0) {
                        extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        extendedFabShape = shape;
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -234881025;
                    } else {
                        floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    z3 = z2;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM1584elevationxZ9QkE;
                    shape2 = extendedFabShape;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = containerColor;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1387401842, i3, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:337)");
                }
                ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1172118032, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$5(z3, interfaceC0526Fp2, i3, interfaceC0526Fp));
                int i16 = i3 >> 6;
                int i17 = i3 >> 9;
                boolean z7 = z3;
                m1589FloatingActionButtonXz6DiA(interfaceC3588op, modifier2, shape2, j4, j3, floatingActionButtonElevation3, mutableInteractionSource2, composableLambda3, composerStartRestartGroup, (i16 & 112) | (i16 & 14) | 12582912 | (i17 & 896) | (i17 & 7168) | (57344 & i17) | (458752 & i17) | (i17 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                shape3 = shape2;
                j5 = j4;
                floatingActionButtonElevation4 = floatingActionButtonElevation3;
                z4 = z7;
                j6 = j3;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$ExtendedFloatingActionButton$6(interfaceC0526Fp, interfaceC0526Fp2, interfaceC3588op, modifier3, z4, shape3, j5, j6, floatingActionButtonElevation4, mutableInteractionSource3, i, i2));
        }
        i3 |= 3072;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((i & 458752) != 0) {
                i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
            }
            if ((i & 3670016) == 0) {
                containerColor = j;
                if ((i2 & 64) == 0) {
                    i9 = 524288;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            } else {
                containerColor = j;
            }
            if ((i & 29360128) == 0) {
                jM1449contentColorForek8zF_U = j2;
                if ((i2 & 128) == 0) {
                    i8 = 4194304;
                } else {
                    i8 = 4194304;
                }
                i3 |= i8;
            } else {
                jM1449contentColorForek8zF_U = j2;
            }
            if ((i & 234881024) == 0) {
                if ((i2 & 256) == 0) {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                    if (composerStartRestartGroup.changed(floatingActionButtonElevation2)) {
                    }
                    i3 |= i11;
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                i3 |= i11;
            } else {
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            i6 = i2 & 512;
            if (i6 != 0) {
                i3 |= 805306368;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i7 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i7 = 268435456;
                }
                i3 |= i7;
            }
            if ((i3 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 32) != 0) {
                        extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        extendedFabShape = shape;
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -234881025;
                    } else {
                        floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    z3 = z2;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM1584elevationxZ9QkE;
                    shape2 = extendedFabShape;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = containerColor;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 32) != 0) {
                        extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        extendedFabShape = shape;
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -234881025;
                    } else {
                        floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    z3 = z2;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM1584elevationxZ9QkE;
                    shape2 = extendedFabShape;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = containerColor;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1387401842, i3, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:337)");
                }
                ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1172118032, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$5(z3, interfaceC0526Fp2, i3, interfaceC0526Fp));
                int i18 = i3 >> 6;
                int i19 = i3 >> 9;
                boolean z8 = z3;
                m1589FloatingActionButtonXz6DiA(interfaceC3588op, modifier2, shape2, j4, j3, floatingActionButtonElevation3, mutableInteractionSource2, composableLambda4, composerStartRestartGroup, (i18 & 112) | (i18 & 14) | 12582912 | (i19 & 896) | (i19 & 7168) | (57344 & i19) | (458752 & i19) | (i19 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                shape3 = shape2;
                j5 = j4;
                floatingActionButtonElevation4 = floatingActionButtonElevation3;
                z4 = z8;
                j6 = j3;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 32) != 0) {
                        extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        extendedFabShape = shape;
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -234881025;
                    } else {
                        floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    z3 = z2;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM1584elevationxZ9QkE;
                    shape2 = extendedFabShape;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = containerColor;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 32) != 0) {
                        extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        extendedFabShape = shape;
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -234881025;
                    } else {
                        floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    z3 = z2;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM1584elevationxZ9QkE;
                    shape2 = extendedFabShape;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = containerColor;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1387401842, i3, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:337)");
                }
                ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1172118032, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$5(z3, interfaceC0526Fp2, i3, interfaceC0526Fp));
                int i110 = i3 >> 6;
                int i111 = i3 >> 9;
                boolean z9 = z3;
                m1589FloatingActionButtonXz6DiA(interfaceC3588op, modifier2, shape2, j4, j3, floatingActionButtonElevation3, mutableInteractionSource2, composableLambda5, composerStartRestartGroup, (i110 & 112) | (i110 & 14) | 12582912 | (i111 & 896) | (i111 & 7168) | (57344 & i111) | (458752 & i111) | (i111 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                shape3 = shape2;
                j5 = j4;
                floatingActionButtonElevation4 = floatingActionButtonElevation3;
                z4 = z9;
                j6 = j3;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$ExtendedFloatingActionButton$6(interfaceC0526Fp, interfaceC0526Fp2, interfaceC3588op, modifier3, z4, shape3, j5, j6, floatingActionButtonElevation4, mutableInteractionSource3, i, i2));
        }
        i3 |= 24576;
        if ((i & 458752) != 0) {
            i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
        }
        if ((i & 3670016) == 0) {
            containerColor = j;
            if ((i2 & 64) == 0) {
                i9 = 524288;
            } else {
                i9 = 524288;
            }
            i3 |= i9;
        } else {
            containerColor = j;
        }
        if ((i & 29360128) == 0) {
            jM1449contentColorForek8zF_U = j2;
            if ((i2 & 128) == 0) {
                i8 = 4194304;
            } else {
                i8 = 4194304;
            }
            i3 |= i8;
        } else {
            jM1449contentColorForek8zF_U = j2;
        }
        if ((i & 234881024) == 0) {
            if ((i2 & 256) == 0) {
                floatingActionButtonElevation2 = floatingActionButtonElevation;
                if (composerStartRestartGroup.changed(floatingActionButtonElevation2)) {
                }
                i3 |= i11;
            } else {
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            i3 |= i11;
        } else {
            floatingActionButtonElevation2 = floatingActionButtonElevation;
        }
        i6 = i2 & 512;
        if (i6 != 0) {
            i3 |= 805306368;
        } else if ((i & 1879048192) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i7 = PropertyOptions.DELETE_EXISTING;
            } else {
                i7 = 268435456;
            }
            i3 |= i7;
        }
        if ((i3 & 1533916891) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if ((i2 & 32) != 0) {
                    extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                    i3 &= -458753;
                } else {
                    extendedFabShape = shape;
                }
                if ((i2 & 64) != 0) {
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -29360129;
                }
                if ((i2 & 256) != 0) {
                    floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 &= -234881025;
                } else {
                    floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation2;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                z3 = z2;
                floatingActionButtonElevation3 = floatingActionButtonElevationM1584elevationxZ9QkE;
                shape2 = extendedFabShape;
                j3 = jM1449contentColorForek8zF_U;
                j4 = containerColor;
            } else {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if ((i2 & 32) != 0) {
                    extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                    i3 &= -458753;
                } else {
                    extendedFabShape = shape;
                }
                if ((i2 & 64) != 0) {
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -29360129;
                }
                if ((i2 & 256) != 0) {
                    floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 &= -234881025;
                } else {
                    floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation2;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                z3 = z2;
                floatingActionButtonElevation3 = floatingActionButtonElevationM1584elevationxZ9QkE;
                shape2 = extendedFabShape;
                j3 = jM1449contentColorForek8zF_U;
                j4 = containerColor;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1387401842, i3, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:337)");
            }
            ComposableLambda composableLambda6 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1172118032, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$5(z3, interfaceC0526Fp2, i3, interfaceC0526Fp));
            int i112 = i3 >> 6;
            int i113 = i3 >> 9;
            boolean z10 = z3;
            m1589FloatingActionButtonXz6DiA(interfaceC3588op, modifier2, shape2, j4, j3, floatingActionButtonElevation3, mutableInteractionSource2, composableLambda6, composerStartRestartGroup, (i112 & 112) | (i112 & 14) | 12582912 | (i113 & 896) | (i113 & 7168) | (57344 & i113) | (458752 & i113) | (i113 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            shape3 = shape2;
            j5 = j4;
            floatingActionButtonElevation4 = floatingActionButtonElevation3;
            z4 = z10;
            j6 = j3;
            mutableInteractionSource3 = mutableInteractionSource2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if ((i2 & 32) != 0) {
                    extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                    i3 &= -458753;
                } else {
                    extendedFabShape = shape;
                }
                if ((i2 & 64) != 0) {
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -29360129;
                }
                if ((i2 & 256) != 0) {
                    floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 &= -234881025;
                } else {
                    floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation2;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                z3 = z2;
                floatingActionButtonElevation3 = floatingActionButtonElevationM1584elevationxZ9QkE;
                shape2 = extendedFabShape;
                j3 = jM1449contentColorForek8zF_U;
                j4 = containerColor;
            } else {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if ((i2 & 32) != 0) {
                    extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                    i3 &= -458753;
                } else {
                    extendedFabShape = shape;
                }
                if ((i2 & 64) != 0) {
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -29360129;
                }
                if ((i2 & 256) != 0) {
                    floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 &= -234881025;
                } else {
                    floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation2;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                z3 = z2;
                floatingActionButtonElevation3 = floatingActionButtonElevationM1584elevationxZ9QkE;
                shape2 = extendedFabShape;
                j3 = jM1449contentColorForek8zF_U;
                j4 = containerColor;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1387401842, i3, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:337)");
            }
            ComposableLambda composableLambda7 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1172118032, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$5(z3, interfaceC0526Fp2, i3, interfaceC0526Fp));
            int i114 = i3 >> 6;
            int i115 = i3 >> 9;
            boolean z11 = z3;
            m1589FloatingActionButtonXz6DiA(interfaceC3588op, modifier2, shape2, j4, j3, floatingActionButtonElevation3, mutableInteractionSource2, composableLambda7, composerStartRestartGroup, (i114 & 112) | (i114 & 14) | 12582912 | (i115 & 896) | (i115 & 7168) | (57344 & i115) | (458752 & i115) | (i115 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            shape3 = shape2;
            j5 = j4;
            floatingActionButtonElevation4 = floatingActionButtonElevation3;
            z4 = z11;
            j6 = j3;
            mutableInteractionSource3 = mutableInteractionSource2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$ExtendedFloatingActionButton$6(interfaceC0526Fp, interfaceC0526Fp2, interfaceC3588op, modifier3, z4, shape3, j5, j6, floatingActionButtonElevation4, mutableInteractionSource3, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:113:0x0150 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:114:0x0152  */
    /* JADX WARN: Code duplicated, block: B:115:0x0155  */
    /* JADX WARN: Code duplicated, block: B:118:0x015c  */
    /* JADX WARN: Code duplicated, block: B:119:0x0167  */
    /* JADX WARN: Code duplicated, block: B:122:0x016d  */
    /* JADX WARN: Code duplicated, block: B:125:0x017a  */
    /* JADX WARN: Code duplicated, block: B:126:0x018b  */
    /* JADX WARN: Code duplicated, block: B:129:0x0193  */
    /* JADX WARN: Code duplicated, block: B:130:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:132:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:134:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:136:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:139:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:142:0x0231  */
    /* JADX WARN: Code duplicated, block: B:147:0x0247  */
    /* JADX WARN: Code duplicated, block: B:149:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:30:0x005d  */
    /* JADX WARN: Code duplicated, block: B:31:0x0060  */
    /* JADX WARN: Code duplicated, block: B:34:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x008a  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:52:0x0096  */
    /* JADX WARN: Code duplicated, block: B:53:0x0099  */
    /* JADX WARN: Code duplicated, block: B:56:0x009f  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:66:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:82:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:93:0x0114  */
    /* JADX WARN: Code duplicated, block: B:95:0x0121  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: ExtendedFloatingActionButton-X-z6DiA, reason: not valid java name */
    public static final void m1588ExtendedFloatingActionButtonXz6DiA(InterfaceC3588op interfaceC3588op, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        int i3;
        Shape shape2;
        long containerColor;
        long j3;
        FloatingActionButtonElevation floatingActionButtonElevationM1584elevationxZ9QkE;
        int i4;
        MutableInteractionSource mutableInteractionSource2;
        int i5;
        int i6;
        Modifier modifier2;
        Shape extendedFabShape;
        int i7;
        long jM1449contentColorForek8zF_U;
        Modifier modifier3;
        Object objRememberedValue;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier4;
        FloatingActionButtonElevation floatingActionButtonElevation2;
        Shape shape3;
        long j4;
        long j5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-326283107);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC3588op) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                if ((i2 & 4) == 0) {
                    shape2 = shape;
                    int i10 = composerStartRestartGroup.changed(shape2) ? 256 : 128;
                    i3 |= i10;
                } else {
                    shape2 = shape;
                }
                i3 |= i10;
            } else {
                shape2 = shape;
            }
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    containerColor = j;
                    int i11 = composerStartRestartGroup.changed(containerColor) ? 2048 : 1024;
                    i3 |= i11;
                } else {
                    containerColor = j;
                }
                i3 |= i11;
            } else {
                containerColor = j;
            }
            if ((i & 57344) == 0) {
                if ((i2 & 16) == 0) {
                    j3 = j2;
                    int i12 = composerStartRestartGroup.changed(j3) ? 16384 : 8192;
                    i3 |= i12;
                } else {
                    j3 = j2;
                }
                i3 |= i12;
            } else {
                j3 = j2;
            }
            if ((i & 458752) == 0) {
                floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation;
                if ((i2 & 32) == 0 || !composerStartRestartGroup.changed(floatingActionButtonElevationM1584elevationxZ9QkE)) {
                    i8 = 65536;
                } else {
                    i8 = 131072;
                }
                i3 |= i8;
            } else {
                floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation;
            }
            i4 = i2 & 64;
            if (i4 != 0) {
                i3 |= 1572864;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i5 = 1048576;
                    } else {
                        i5 = 524288;
                    }
                    i3 |= i5;
                }
            }
            if ((i2 & 128) != 0) {
                i3 |= 12582912;
            } else if ((29360128 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i6 = 8388608;
                } else {
                    i6 = 4194304;
                }
                i3 |= i6;
            }
            if ((23967451 & i3) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                    } else {
                        extendedFabShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    } else {
                        i7 = i3;
                        jM1449contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 32) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        modifier3 = modifier2;
                    }
                    FloatingActionButtonElevation floatingActionButtonElevation3 = floatingActionButtonElevationM1584elevationxZ9QkE;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-326283107, i3, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:270)");
                    }
                    m1589FloatingActionButtonXz6DiA(interfaceC3588op, modifier3, extendedFabShape, containerColor, jM1449contentColorForek8zF_U, floatingActionButtonElevation3, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 398457247, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$2(interfaceC0552Gp, i3)), composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    floatingActionButtonElevation2 = floatingActionButtonElevation3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    shape3 = extendedFabShape;
                    j4 = jM1449contentColorForek8zF_U;
                    j5 = containerColor;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                    modifier3 = modifier;
                    extendedFabShape = shape2;
                    containerColor = containerColor;
                    jM1449contentColorForek8zF_U = j3;
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                FloatingActionButtonElevation floatingActionButtonElevation4 = floatingActionButtonElevationM1584elevationxZ9QkE;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-326283107, i3, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:270)");
                }
                m1589FloatingActionButtonXz6DiA(interfaceC3588op, modifier3, extendedFabShape, containerColor, jM1449contentColorForek8zF_U, floatingActionButtonElevation4, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 398457247, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$2(interfaceC0552Gp, i3)), composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                floatingActionButtonElevation2 = floatingActionButtonElevation4;
                mutableInteractionSource2 = mutableInteractionSource3;
                shape3 = extendedFabShape;
                j4 = jM1449contentColorForek8zF_U;
                j5 = containerColor;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier4 = modifier;
                shape3 = shape2;
                j5 = containerColor;
                j4 = j3;
                floatingActionButtonElevation2 = floatingActionButtonElevationM1584elevationxZ9QkE;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$ExtendedFloatingActionButton$3(interfaceC3588op, modifier4, shape3, j5, j4, floatingActionButtonElevation2, mutableInteractionSource2, interfaceC0552Gp, i, i2));
        }
        i3 |= 48;
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i10;
            } else {
                shape2 = shape;
            }
            i3 |= i10;
        } else {
            shape2 = shape;
        }
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                containerColor = j;
                if (composerStartRestartGroup.changed(containerColor)) {
                }
                i3 |= i11;
            } else {
                containerColor = j;
            }
            i3 |= i11;
        } else {
            containerColor = j;
        }
        if ((i & 57344) == 0) {
            if ((i2 & 16) == 0) {
                j3 = j2;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i3 |= i12;
            } else {
                j3 = j2;
            }
            i3 |= i12;
        } else {
            j3 = j2;
        }
        if ((i & 458752) == 0) {
            floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation;
            if ((i2 & 32) == 0) {
                i8 = 65536;
            } else {
                i8 = 65536;
            }
            i3 |= i8;
        } else {
            floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation;
        }
        i4 = i2 & 64;
        if (i4 != 0) {
            i3 |= 1572864;
            mutableInteractionSource2 = mutableInteractionSource;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i5 = 1048576;
                } else {
                    i5 = 524288;
                }
                i3 |= i5;
            }
        }
        if ((i2 & 128) != 0) {
            i3 |= 12582912;
        } else if ((29360128 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                i6 = 8388608;
            } else {
                i6 = 4194304;
            }
            i3 |= i6;
        }
        if ((23967451 & i3) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                } else {
                    extendedFabShape = shape2;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    i7 = i3 & (-57345);
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                } else {
                    i7 = i3;
                    jM1449contentColorForek8zF_U = j3;
                }
                if ((i2 & 32) != 0) {
                    floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i7 & (-458753);
                } else {
                    i3 = i7;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier2;
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    modifier3 = modifier2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
            } else {
                if (i9 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                } else {
                    extendedFabShape = shape2;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    i7 = i3 & (-57345);
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                } else {
                    i7 = i3;
                    jM1449contentColorForek8zF_U = j3;
                }
                if ((i2 & 32) != 0) {
                    floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i7 & (-458753);
                } else {
                    i3 = i7;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier2;
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    modifier3 = modifier2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
            }
            FloatingActionButtonElevation floatingActionButtonElevation5 = floatingActionButtonElevationM1584elevationxZ9QkE;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-326283107, i3, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:270)");
            }
            m1589FloatingActionButtonXz6DiA(interfaceC3588op, modifier3, extendedFabShape, containerColor, jM1449contentColorForek8zF_U, floatingActionButtonElevation5, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 398457247, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$2(interfaceC0552Gp, i3)), composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            floatingActionButtonElevation2 = floatingActionButtonElevation5;
            mutableInteractionSource2 = mutableInteractionSource3;
            shape3 = extendedFabShape;
            j4 = jM1449contentColorForek8zF_U;
            j5 = containerColor;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                } else {
                    extendedFabShape = shape2;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    i7 = i3 & (-57345);
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                } else {
                    i7 = i3;
                    jM1449contentColorForek8zF_U = j3;
                }
                if ((i2 & 32) != 0) {
                    floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i7 & (-458753);
                } else {
                    i3 = i7;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier2;
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    modifier3 = modifier2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
            } else {
                if (i9 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                } else {
                    extendedFabShape = shape2;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    i7 = i3 & (-57345);
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                } else {
                    i7 = i3;
                    jM1449contentColorForek8zF_U = j3;
                }
                if ((i2 & 32) != 0) {
                    floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i7 & (-458753);
                } else {
                    i3 = i7;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier2;
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    modifier3 = modifier2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
            }
            FloatingActionButtonElevation floatingActionButtonElevation6 = floatingActionButtonElevationM1584elevationxZ9QkE;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-326283107, i3, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:270)");
            }
            m1589FloatingActionButtonXz6DiA(interfaceC3588op, modifier3, extendedFabShape, containerColor, jM1449contentColorForek8zF_U, floatingActionButtonElevation6, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 398457247, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$2(interfaceC0552Gp, i3)), composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            floatingActionButtonElevation2 = floatingActionButtonElevation6;
            mutableInteractionSource2 = mutableInteractionSource3;
            shape3 = extendedFabShape;
            j4 = jM1449contentColorForek8zF_U;
            j5 = containerColor;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$ExtendedFloatingActionButton$3(interfaceC3588op, modifier4, shape3, j5, j4, floatingActionButtonElevation2, mutableInteractionSource2, interfaceC0552Gp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:111:0x014d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:112:0x014f  */
    /* JADX WARN: Code duplicated, block: B:113:0x0152  */
    /* JADX WARN: Code duplicated, block: B:116:0x0159  */
    /* JADX WARN: Code duplicated, block: B:119:0x0166  */
    /* JADX WARN: Code duplicated, block: B:122:0x0173  */
    /* JADX WARN: Code duplicated, block: B:123:0x017e  */
    /* JADX WARN: Code duplicated, block: B:126:0x0183  */
    /* JADX WARN: Code duplicated, block: B:128:0x019c  */
    /* JADX WARN: Code duplicated, block: B:130:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:135:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:138:0x024a  */
    /* JADX WARN: Code duplicated, block: B:143:0x0260  */
    /* JADX WARN: Code duplicated, block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:30:0x005d  */
    /* JADX WARN: Code duplicated, block: B:31:0x0060  */
    /* JADX WARN: Code duplicated, block: B:34:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x008a  */
    /* JADX WARN: Code duplicated, block: B:53:0x0099  */
    /* JADX WARN: Code duplicated, block: B:55:0x009d  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:66:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:89:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:93:0x0114  */
    /* JADX WARN: Code duplicated, block: B:95:0x0121  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: FloatingActionButton-X-z6DiA, reason: not valid java name */
    public static final void m1589FloatingActionButtonXz6DiA(InterfaceC3588op interfaceC3588op, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        int i3;
        Shape shape2;
        long containerColor;
        long j3;
        FloatingActionButtonElevation floatingActionButtonElevationM1584elevationxZ9QkE;
        int i4;
        MutableInteractionSource mutableInteractionSource2;
        int i5;
        int i6;
        Modifier modifier2;
        long jM1449contentColorForek8zF_U;
        int i7;
        Shape shape3;
        long j4;
        Modifier modifier3;
        FloatingActionButtonElevation floatingActionButtonElevation2;
        Object objRememberedValue;
        Composer composer2;
        Shape shape4;
        long j5;
        FloatingActionButtonElevation floatingActionButtonElevation3;
        long j6;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-731723913);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC3588op) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                if ((i2 & 4) == 0) {
                    shape2 = shape;
                    int i10 = composerStartRestartGroup.changed(shape2) ? 256 : 128;
                    i3 |= i10;
                } else {
                    shape2 = shape;
                }
                i3 |= i10;
            } else {
                shape2 = shape;
            }
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    containerColor = j;
                    int i11 = composerStartRestartGroup.changed(containerColor) ? 2048 : 1024;
                    i3 |= i11;
                } else {
                    containerColor = j;
                }
                i3 |= i11;
            } else {
                containerColor = j;
            }
            if ((i & 57344) == 0) {
                j3 = j2;
                if ((i2 & 16) == 0 || !composerStartRestartGroup.changed(j3)) {
                    i8 = 8192;
                } else {
                    i8 = 16384;
                }
                i3 |= i8;
            } else {
                j3 = j2;
            }
            if ((i & 458752) == 0) {
                if ((i2 & 32) == 0) {
                    floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation;
                    int i12 = composerStartRestartGroup.changed(floatingActionButtonElevationM1584elevationxZ9QkE) ? 131072 : 65536;
                    i3 |= i12;
                } else {
                    floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation;
                }
                i3 |= i12;
            } else {
                floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation;
            }
            i4 = i2 & 64;
            if (i4 != 0) {
                i3 |= 1572864;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i5 = 1048576;
                    } else {
                        i5 = 524288;
                    }
                    i3 |= i5;
                }
            }
            if ((i2 & 128) != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i6 = 8388608;
                    } else {
                        i6 = 4194304;
                    }
                }
                if ((23967451 & i3) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i9 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            shape2 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                            i3 &= -57345;
                        } else {
                            jM1449contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 32) != 0) {
                            floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i3 &= -458753;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        i7 = i3;
                        shape3 = shape2;
                        j4 = containerColor;
                        modifier3 = modifier2;
                        floatingActionButtonElevation2 = floatingActionButtonElevationM1584elevationxZ9QkE;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        shape3 = shape2;
                        j4 = containerColor;
                        floatingActionButtonElevation2 = floatingActionButtonElevationM1584elevationxZ9QkE;
                        jM1449contentColorForek8zF_U = j3;
                        modifier3 = modifier;
                        i7 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-731723913, i7, -1, "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:95)");
                    }
                    int i13 = ((i7 >> 12) & 112) | ((i7 >> 18) & 14);
                    FloatingActionButtonElevation floatingActionButtonElevation4 = floatingActionButtonElevation2;
                    int i14 = i7 << 3;
                    long j7 = jM1449contentColorForek8zF_U;
                    MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                    composer2 = composerStartRestartGroup;
                    Modifier modifier5 = modifier3;
                    SurfaceKt.m1853Surfaceo_FOJdg(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, FloatingActionButtonKt$FloatingActionButton$2.INSTANCE, 1, null), false, shape3, j4, j7, floatingActionButtonElevation2.tonalElevation$material3_release(mutableInteractionSource2, composerStartRestartGroup, i13).getValue().m5174unboximpl(), floatingActionButtonElevation2.shadowElevation$material3_release(mutableInteractionSource2, composerStartRestartGroup, i13).getValue().m5174unboximpl(), null, mutableInteractionSource4, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1249316354, true, new FloatingActionButtonKt$FloatingActionButton$3(jM1449contentColorForek8zF_U, interfaceC0526Fp, i7)), composer2, (i7 & 14) | (i14 & 7168) | (57344 & i14) | (i14 & 458752) | (1879048192 & (i7 << 9)), 6, MetaDo.META_SETROP2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape4 = shape3;
                    j5 = j4;
                    floatingActionButtonElevation3 = floatingActionButtonElevation4;
                    j6 = j7;
                    mutableInteractionSource3 = mutableInteractionSource4;
                    modifier4 = modifier5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier4 = modifier;
                    composer2 = composerStartRestartGroup;
                    shape4 = shape2;
                    j5 = containerColor;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM1584elevationxZ9QkE;
                    j6 = j3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$FloatingActionButton$4(interfaceC3588op, modifier4, shape4, j5, j6, floatingActionButtonElevation3, mutableInteractionSource3, interfaceC0526Fp, i, i2));
            }
            i6 = 12582912;
            i3 |= i6;
            if ((23967451 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        shape2 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    } else {
                        jM1449contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 32) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -458753;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    i7 = i3;
                    shape3 = shape2;
                    j4 = containerColor;
                    modifier3 = modifier2;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM1584elevationxZ9QkE;
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        shape2 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    } else {
                        jM1449contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 32) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -458753;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    i7 = i3;
                    shape3 = shape2;
                    j4 = containerColor;
                    modifier3 = modifier2;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM1584elevationxZ9QkE;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-731723913, i7, -1, "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:95)");
                }
                int i15 = ((i7 >> 12) & 112) | ((i7 >> 18) & 14);
                FloatingActionButtonElevation floatingActionButtonElevation5 = floatingActionButtonElevation2;
                int i16 = i7 << 3;
                long j8 = jM1449contentColorForek8zF_U;
                MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource2;
                composer2 = composerStartRestartGroup;
                Modifier modifier6 = modifier3;
                SurfaceKt.m1853Surfaceo_FOJdg(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, FloatingActionButtonKt$FloatingActionButton$2.INSTANCE, 1, null), false, shape3, j4, j8, floatingActionButtonElevation2.tonalElevation$material3_release(mutableInteractionSource2, composerStartRestartGroup, i15).getValue().m5174unboximpl(), floatingActionButtonElevation2.shadowElevation$material3_release(mutableInteractionSource2, composerStartRestartGroup, i15).getValue().m5174unboximpl(), null, mutableInteractionSource5, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1249316354, true, new FloatingActionButtonKt$FloatingActionButton$3(jM1449contentColorForek8zF_U, interfaceC0526Fp, i7)), composer2, (i7 & 14) | (i16 & 7168) | (57344 & i16) | (i16 & 458752) | (1879048192 & (i7 << 9)), 6, MetaDo.META_SETROP2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape4 = shape3;
                j5 = j4;
                floatingActionButtonElevation3 = floatingActionButtonElevation5;
                j6 = j8;
                mutableInteractionSource3 = mutableInteractionSource5;
                modifier4 = modifier6;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        shape2 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    } else {
                        jM1449contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 32) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -458753;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    i7 = i3;
                    shape3 = shape2;
                    j4 = containerColor;
                    modifier3 = modifier2;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM1584elevationxZ9QkE;
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        shape2 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    } else {
                        jM1449contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 32) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -458753;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    i7 = i3;
                    shape3 = shape2;
                    j4 = containerColor;
                    modifier3 = modifier2;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM1584elevationxZ9QkE;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-731723913, i7, -1, "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:95)");
                }
                int i17 = ((i7 >> 12) & 112) | ((i7 >> 18) & 14);
                FloatingActionButtonElevation floatingActionButtonElevation6 = floatingActionButtonElevation2;
                int i18 = i7 << 3;
                long j9 = jM1449contentColorForek8zF_U;
                MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource2;
                composer2 = composerStartRestartGroup;
                Modifier modifier7 = modifier3;
                SurfaceKt.m1853Surfaceo_FOJdg(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, FloatingActionButtonKt$FloatingActionButton$2.INSTANCE, 1, null), false, shape3, j4, j9, floatingActionButtonElevation2.tonalElevation$material3_release(mutableInteractionSource2, composerStartRestartGroup, i17).getValue().m5174unboximpl(), floatingActionButtonElevation2.shadowElevation$material3_release(mutableInteractionSource2, composerStartRestartGroup, i17).getValue().m5174unboximpl(), null, mutableInteractionSource6, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1249316354, true, new FloatingActionButtonKt$FloatingActionButton$3(jM1449contentColorForek8zF_U, interfaceC0526Fp, i7)), composer2, (i7 & 14) | (i18 & 7168) | (57344 & i18) | (i18 & 458752) | (1879048192 & (i7 << 9)), 6, MetaDo.META_SETROP2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape4 = shape3;
                j5 = j4;
                floatingActionButtonElevation3 = floatingActionButtonElevation6;
                j6 = j9;
                mutableInteractionSource3 = mutableInteractionSource6;
                modifier4 = modifier7;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$FloatingActionButton$4(interfaceC3588op, modifier4, shape4, j5, j6, floatingActionButtonElevation3, mutableInteractionSource3, interfaceC0526Fp, i, i2));
        }
        i3 |= 48;
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i10;
            } else {
                shape2 = shape;
            }
            i3 |= i10;
        } else {
            shape2 = shape;
        }
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                containerColor = j;
                if (composerStartRestartGroup.changed(containerColor)) {
                }
                i3 |= i11;
            } else {
                containerColor = j;
            }
            i3 |= i11;
        } else {
            containerColor = j;
        }
        if ((i & 57344) == 0) {
            j3 = j2;
            if ((i2 & 16) == 0) {
                i8 = 8192;
            } else {
                i8 = 8192;
            }
            i3 |= i8;
        } else {
            j3 = j2;
        }
        if ((i & 458752) == 0) {
            if ((i2 & 32) == 0) {
                floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation;
                if (composerStartRestartGroup.changed(floatingActionButtonElevationM1584elevationxZ9QkE)) {
                }
                i3 |= i12;
            } else {
                floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation;
            }
            i3 |= i12;
        } else {
            floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation;
        }
        i4 = i2 & 64;
        if (i4 != 0) {
            i3 |= 1572864;
            mutableInteractionSource2 = mutableInteractionSource;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i5 = 1048576;
                } else {
                    i5 = 524288;
                }
                i3 |= i5;
            }
        }
        if ((i2 & 128) != 0) {
            if ((29360128 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i6 = 8388608;
                } else {
                    i6 = 4194304;
                }
            }
            if ((23967451 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        shape2 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    } else {
                        jM1449contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 32) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -458753;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    i7 = i3;
                    shape3 = shape2;
                    j4 = containerColor;
                    modifier3 = modifier2;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM1584elevationxZ9QkE;
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        shape2 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    } else {
                        jM1449contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 32) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -458753;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    i7 = i3;
                    shape3 = shape2;
                    j4 = containerColor;
                    modifier3 = modifier2;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM1584elevationxZ9QkE;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-731723913, i7, -1, "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:95)");
                }
                int i19 = ((i7 >> 12) & 112) | ((i7 >> 18) & 14);
                FloatingActionButtonElevation floatingActionButtonElevation7 = floatingActionButtonElevation2;
                int i110 = i7 << 3;
                long j10 = jM1449contentColorForek8zF_U;
                MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource2;
                composer2 = composerStartRestartGroup;
                Modifier modifier8 = modifier3;
                SurfaceKt.m1853Surfaceo_FOJdg(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, FloatingActionButtonKt$FloatingActionButton$2.INSTANCE, 1, null), false, shape3, j4, j10, floatingActionButtonElevation2.tonalElevation$material3_release(mutableInteractionSource2, composerStartRestartGroup, i19).getValue().m5174unboximpl(), floatingActionButtonElevation2.shadowElevation$material3_release(mutableInteractionSource2, composerStartRestartGroup, i19).getValue().m5174unboximpl(), null, mutableInteractionSource7, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1249316354, true, new FloatingActionButtonKt$FloatingActionButton$3(jM1449contentColorForek8zF_U, interfaceC0526Fp, i7)), composer2, (i7 & 14) | (i110 & 7168) | (57344 & i110) | (i110 & 458752) | (1879048192 & (i7 << 9)), 6, MetaDo.META_SETROP2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape4 = shape3;
                j5 = j4;
                floatingActionButtonElevation3 = floatingActionButtonElevation7;
                j6 = j10;
                mutableInteractionSource3 = mutableInteractionSource7;
                modifier4 = modifier8;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        shape2 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    } else {
                        jM1449contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 32) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -458753;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    i7 = i3;
                    shape3 = shape2;
                    j4 = containerColor;
                    modifier3 = modifier2;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM1584elevationxZ9QkE;
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        shape2 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    } else {
                        jM1449contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 32) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -458753;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    i7 = i3;
                    shape3 = shape2;
                    j4 = containerColor;
                    modifier3 = modifier2;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM1584elevationxZ9QkE;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-731723913, i7, -1, "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:95)");
                }
                int i111 = ((i7 >> 12) & 112) | ((i7 >> 18) & 14);
                FloatingActionButtonElevation floatingActionButtonElevation8 = floatingActionButtonElevation2;
                int i112 = i7 << 3;
                long j11 = jM1449contentColorForek8zF_U;
                MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource2;
                composer2 = composerStartRestartGroup;
                Modifier modifier9 = modifier3;
                SurfaceKt.m1853Surfaceo_FOJdg(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, FloatingActionButtonKt$FloatingActionButton$2.INSTANCE, 1, null), false, shape3, j4, j11, floatingActionButtonElevation2.tonalElevation$material3_release(mutableInteractionSource2, composerStartRestartGroup, i111).getValue().m5174unboximpl(), floatingActionButtonElevation2.shadowElevation$material3_release(mutableInteractionSource2, composerStartRestartGroup, i111).getValue().m5174unboximpl(), null, mutableInteractionSource8, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1249316354, true, new FloatingActionButtonKt$FloatingActionButton$3(jM1449contentColorForek8zF_U, interfaceC0526Fp, i7)), composer2, (i7 & 14) | (i112 & 7168) | (57344 & i112) | (i112 & 458752) | (1879048192 & (i7 << 9)), 6, MetaDo.META_SETROP2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape4 = shape3;
                j5 = j4;
                floatingActionButtonElevation3 = floatingActionButtonElevation8;
                j6 = j11;
                mutableInteractionSource3 = mutableInteractionSource8;
                modifier4 = modifier9;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$FloatingActionButton$4(interfaceC3588op, modifier4, shape4, j5, j6, floatingActionButtonElevation3, mutableInteractionSource3, interfaceC0526Fp, i, i2));
        }
        i6 = 12582912;
        i3 |= i6;
        if ((23967451 & i3) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    shape2 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    i3 &= -57345;
                } else {
                    jM1449contentColorForek8zF_U = j3;
                }
                if ((i2 & 32) != 0) {
                    floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 &= -458753;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                i7 = i3;
                shape3 = shape2;
                j4 = containerColor;
                modifier3 = modifier2;
                floatingActionButtonElevation2 = floatingActionButtonElevationM1584elevationxZ9QkE;
            } else {
                if (i9 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    shape2 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    i3 &= -57345;
                } else {
                    jM1449contentColorForek8zF_U = j3;
                }
                if ((i2 & 32) != 0) {
                    floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 &= -458753;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                i7 = i3;
                shape3 = shape2;
                j4 = containerColor;
                modifier3 = modifier2;
                floatingActionButtonElevation2 = floatingActionButtonElevationM1584elevationxZ9QkE;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-731723913, i7, -1, "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:95)");
            }
            int i113 = ((i7 >> 12) & 112) | ((i7 >> 18) & 14);
            FloatingActionButtonElevation floatingActionButtonElevation9 = floatingActionButtonElevation2;
            int i114 = i7 << 3;
            long j12 = jM1449contentColorForek8zF_U;
            MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource2;
            composer2 = composerStartRestartGroup;
            Modifier modifier10 = modifier3;
            SurfaceKt.m1853Surfaceo_FOJdg(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, FloatingActionButtonKt$FloatingActionButton$2.INSTANCE, 1, null), false, shape3, j4, j12, floatingActionButtonElevation2.tonalElevation$material3_release(mutableInteractionSource2, composerStartRestartGroup, i113).getValue().m5174unboximpl(), floatingActionButtonElevation2.shadowElevation$material3_release(mutableInteractionSource2, composerStartRestartGroup, i113).getValue().m5174unboximpl(), null, mutableInteractionSource9, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1249316354, true, new FloatingActionButtonKt$FloatingActionButton$3(jM1449contentColorForek8zF_U, interfaceC0526Fp, i7)), composer2, (i7 & 14) | (i114 & 7168) | (57344 & i114) | (i114 & 458752) | (1879048192 & (i7 << 9)), 6, MetaDo.META_SETROP2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape4 = shape3;
            j5 = j4;
            floatingActionButtonElevation3 = floatingActionButtonElevation9;
            j6 = j12;
            mutableInteractionSource3 = mutableInteractionSource9;
            modifier4 = modifier10;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    shape2 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    i3 &= -57345;
                } else {
                    jM1449contentColorForek8zF_U = j3;
                }
                if ((i2 & 32) != 0) {
                    floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 &= -458753;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                i7 = i3;
                shape3 = shape2;
                j4 = containerColor;
                modifier3 = modifier2;
                floatingActionButtonElevation2 = floatingActionButtonElevationM1584elevationxZ9QkE;
            } else {
                if (i9 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    shape2 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    i3 &= -57345;
                } else {
                    jM1449contentColorForek8zF_U = j3;
                }
                if ((i2 & 32) != 0) {
                    floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 &= -458753;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                i7 = i3;
                shape3 = shape2;
                j4 = containerColor;
                modifier3 = modifier2;
                floatingActionButtonElevation2 = floatingActionButtonElevationM1584elevationxZ9QkE;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-731723913, i7, -1, "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:95)");
            }
            int i115 = ((i7 >> 12) & 112) | ((i7 >> 18) & 14);
            FloatingActionButtonElevation floatingActionButtonElevation10 = floatingActionButtonElevation2;
            int i116 = i7 << 3;
            long j13 = jM1449contentColorForek8zF_U;
            MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource2;
            composer2 = composerStartRestartGroup;
            Modifier modifier11 = modifier3;
            SurfaceKt.m1853Surfaceo_FOJdg(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, FloatingActionButtonKt$FloatingActionButton$2.INSTANCE, 1, null), false, shape3, j4, j13, floatingActionButtonElevation2.tonalElevation$material3_release(mutableInteractionSource2, composerStartRestartGroup, i115).getValue().m5174unboximpl(), floatingActionButtonElevation2.shadowElevation$material3_release(mutableInteractionSource2, composerStartRestartGroup, i115).getValue().m5174unboximpl(), null, mutableInteractionSource10, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1249316354, true, new FloatingActionButtonKt$FloatingActionButton$3(jM1449contentColorForek8zF_U, interfaceC0526Fp, i7)), composer2, (i7 & 14) | (i116 & 7168) | (57344 & i116) | (i116 & 458752) | (1879048192 & (i7 << 9)), 6, MetaDo.META_SETROP2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape4 = shape3;
            j5 = j4;
            floatingActionButtonElevation3 = floatingActionButtonElevation10;
            j6 = j13;
            mutableInteractionSource3 = mutableInteractionSource10;
            modifier4 = modifier11;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$FloatingActionButton$4(interfaceC3588op, modifier4, shape4, j5, j6, floatingActionButtonElevation3, mutableInteractionSource3, interfaceC0526Fp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:113:0x0150 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:114:0x0152  */
    /* JADX WARN: Code duplicated, block: B:115:0x0155  */
    /* JADX WARN: Code duplicated, block: B:118:0x015c  */
    /* JADX WARN: Code duplicated, block: B:119:0x0167  */
    /* JADX WARN: Code duplicated, block: B:122:0x016d  */
    /* JADX WARN: Code duplicated, block: B:125:0x017a  */
    /* JADX WARN: Code duplicated, block: B:126:0x018b  */
    /* JADX WARN: Code duplicated, block: B:129:0x0193  */
    /* JADX WARN: Code duplicated, block: B:130:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:132:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:134:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:136:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:139:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:142:0x0233  */
    /* JADX WARN: Code duplicated, block: B:147:0x0249  */
    /* JADX WARN: Code duplicated, block: B:149:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:30:0x005d  */
    /* JADX WARN: Code duplicated, block: B:31:0x0060  */
    /* JADX WARN: Code duplicated, block: B:34:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0095  */
    /* JADX WARN: Code duplicated, block: B:53:0x0098  */
    /* JADX WARN: Code duplicated, block: B:56:0x009e  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:86:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:94:0x0114  */
    /* JADX WARN: Code duplicated, block: B:96:0x0121  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: LargeFloatingActionButton-X-z6DiA, reason: not valid java name */
    public static final void m1590LargeFloatingActionButtonXz6DiA(InterfaceC3588op interfaceC3588op, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        int i3;
        Shape shape2;
        long containerColor;
        long j3;
        FloatingActionButtonElevation floatingActionButtonElevationM1584elevationxZ9QkE;
        int i4;
        int i5;
        int i6;
        Modifier modifier2;
        Shape largeShape;
        int i7;
        long jM1449contentColorForek8zF_U;
        MutableInteractionSource mutableInteractionSource2;
        Modifier modifier3;
        Object objRememberedValue;
        Modifier modifier4;
        Shape shape3;
        long j4;
        FloatingActionButtonElevation floatingActionButtonElevation2;
        long j5;
        MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-1650866856);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC3588op) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                if ((i2 & 4) == 0) {
                    shape2 = shape;
                    int i9 = composerStartRestartGroup.changed(shape2) ? 256 : 128;
                    i3 |= i9;
                } else {
                    shape2 = shape;
                }
                i3 |= i9;
            } else {
                shape2 = shape;
            }
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    containerColor = j;
                    int i10 = composerStartRestartGroup.changed(containerColor) ? 2048 : 1024;
                    i3 |= i10;
                } else {
                    containerColor = j;
                }
                i3 |= i10;
            } else {
                containerColor = j;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    j3 = j2;
                    int i11 = composerStartRestartGroup.changed(j3) ? 16384 : 8192;
                    i3 |= i11;
                } else {
                    j3 = j2;
                }
                i3 |= i11;
            } else {
                j3 = j2;
            }
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation;
                    int i12 = composerStartRestartGroup.changed(floatingActionButtonElevationM1584elevationxZ9QkE) ? 131072 : 65536;
                    i3 |= i12;
                } else {
                    floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation;
                }
                i3 |= i12;
            } else {
                floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation;
            }
            i4 = i2 & 64;
            if (i4 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i5 = 1048576;
                } else {
                    i5 = 524288;
                }
                i3 |= i5;
            }
            if ((i2 & 128) != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i6 = 8388608;
                    } else {
                        i6 = 4194304;
                    }
                }
                if ((23967451 & i3) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            largeShape = FloatingActionButtonDefaults.INSTANCE.getLargeShape(composerStartRestartGroup, 6);
                        } else {
                            largeShape = shape2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            i7 = i3 & (-57345);
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        } else {
                            i7 = i3;
                            jM1449contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 32) != 0) {
                            floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i3 = i7 & (-458753);
                        } else {
                            i3 = i7;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            modifier3 = modifier2;
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        modifier3 = modifier;
                        mutableInteractionSource2 = mutableInteractionSource;
                        largeShape = shape2;
                        containerColor = containerColor;
                        jM1449contentColorForek8zF_U = j3;
                    }
                    FloatingActionButtonElevation floatingActionButtonElevation3 = floatingActionButtonElevationM1584elevationxZ9QkE;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1650866856, i3, -1, "androidx.compose.material3.LargeFloatingActionButton (FloatingActionButton.kt:215)");
                    }
                    FabPrimaryLargeTokens fabPrimaryLargeTokens = FabPrimaryLargeTokens.INSTANCE;
                    m1589FloatingActionButtonXz6DiA(interfaceC3588op, SizeKt.m536sizeInqDBjuR0$default(modifier3, fabPrimaryLargeTokens.m2222getContainerWidthD9Ej5fM(), fabPrimaryLargeTokens.m2221getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), largeShape, containerColor, jM1449contentColorForek8zF_U, floatingActionButtonElevation3, mutableInteractionSource2, interfaceC0526Fp, composerStartRestartGroup, i3 & 33554318, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape3 = largeShape;
                    j4 = jM1449contentColorForek8zF_U;
                    floatingActionButtonElevation2 = floatingActionButtonElevation3;
                    j5 = containerColor;
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier4 = modifier;
                    shape3 = shape2;
                    j5 = containerColor;
                    j4 = j3;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM1584elevationxZ9QkE;
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$LargeFloatingActionButton$2(interfaceC3588op, modifier4, shape3, j5, j4, floatingActionButtonElevation2, mutableInteractionSource3, interfaceC0526Fp, i, i2));
            }
            i6 = 12582912;
            i3 |= i6;
            if ((23967451 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        largeShape = FloatingActionButtonDefaults.INSTANCE.getLargeShape(composerStartRestartGroup, 6);
                    } else {
                        largeShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    } else {
                        i7 = i3;
                        jM1449contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 32) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                    }
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        largeShape = FloatingActionButtonDefaults.INSTANCE.getLargeShape(composerStartRestartGroup, 6);
                    } else {
                        largeShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    } else {
                        i7 = i3;
                        jM1449contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 32) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                    }
                }
                FloatingActionButtonElevation floatingActionButtonElevation4 = floatingActionButtonElevationM1584elevationxZ9QkE;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1650866856, i3, -1, "androidx.compose.material3.LargeFloatingActionButton (FloatingActionButton.kt:215)");
                }
                FabPrimaryLargeTokens fabPrimaryLargeTokens2 = FabPrimaryLargeTokens.INSTANCE;
                m1589FloatingActionButtonXz6DiA(interfaceC3588op, SizeKt.m536sizeInqDBjuR0$default(modifier3, fabPrimaryLargeTokens2.m2222getContainerWidthD9Ej5fM(), fabPrimaryLargeTokens2.m2221getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), largeShape, containerColor, jM1449contentColorForek8zF_U, floatingActionButtonElevation4, mutableInteractionSource2, interfaceC0526Fp, composerStartRestartGroup, i3 & 33554318, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape3 = largeShape;
                j4 = jM1449contentColorForek8zF_U;
                floatingActionButtonElevation2 = floatingActionButtonElevation4;
                j5 = containerColor;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        largeShape = FloatingActionButtonDefaults.INSTANCE.getLargeShape(composerStartRestartGroup, 6);
                    } else {
                        largeShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    } else {
                        i7 = i3;
                        jM1449contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 32) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                    }
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        largeShape = FloatingActionButtonDefaults.INSTANCE.getLargeShape(composerStartRestartGroup, 6);
                    } else {
                        largeShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    } else {
                        i7 = i3;
                        jM1449contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 32) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                    }
                }
                FloatingActionButtonElevation floatingActionButtonElevation5 = floatingActionButtonElevationM1584elevationxZ9QkE;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1650866856, i3, -1, "androidx.compose.material3.LargeFloatingActionButton (FloatingActionButton.kt:215)");
                }
                FabPrimaryLargeTokens fabPrimaryLargeTokens3 = FabPrimaryLargeTokens.INSTANCE;
                m1589FloatingActionButtonXz6DiA(interfaceC3588op, SizeKt.m536sizeInqDBjuR0$default(modifier3, fabPrimaryLargeTokens3.m2222getContainerWidthD9Ej5fM(), fabPrimaryLargeTokens3.m2221getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), largeShape, containerColor, jM1449contentColorForek8zF_U, floatingActionButtonElevation5, mutableInteractionSource2, interfaceC0526Fp, composerStartRestartGroup, i3 & 33554318, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape3 = largeShape;
                j4 = jM1449contentColorForek8zF_U;
                floatingActionButtonElevation2 = floatingActionButtonElevation5;
                j5 = containerColor;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$LargeFloatingActionButton$2(interfaceC3588op, modifier4, shape3, j5, j4, floatingActionButtonElevation2, mutableInteractionSource3, interfaceC0526Fp, i, i2));
        }
        i3 |= 48;
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i9;
            } else {
                shape2 = shape;
            }
            i3 |= i9;
        } else {
            shape2 = shape;
        }
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                containerColor = j;
                if (composerStartRestartGroup.changed(containerColor)) {
                }
                i3 |= i10;
            } else {
                containerColor = j;
            }
            i3 |= i10;
        } else {
            containerColor = j;
        }
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                j3 = j2;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i3 |= i11;
            } else {
                j3 = j2;
            }
            i3 |= i11;
        } else {
            j3 = j2;
        }
        if ((458752 & i) == 0) {
            if ((i2 & 32) == 0) {
                floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation;
                if (composerStartRestartGroup.changed(floatingActionButtonElevationM1584elevationxZ9QkE)) {
                }
                i3 |= i12;
            } else {
                floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation;
            }
            i3 |= i12;
        } else {
            floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation;
        }
        i4 = i2 & 64;
        if (i4 != 0) {
            i3 |= 1572864;
        } else if ((i & 3670016) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i5 = 1048576;
            } else {
                i5 = 524288;
            }
            i3 |= i5;
        }
        if ((i2 & 128) != 0) {
            if ((29360128 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i6 = 8388608;
                } else {
                    i6 = 4194304;
                }
            }
            if ((23967451 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        largeShape = FloatingActionButtonDefaults.INSTANCE.getLargeShape(composerStartRestartGroup, 6);
                    } else {
                        largeShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    } else {
                        i7 = i3;
                        jM1449contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 32) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                    }
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        largeShape = FloatingActionButtonDefaults.INSTANCE.getLargeShape(composerStartRestartGroup, 6);
                    } else {
                        largeShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    } else {
                        i7 = i3;
                        jM1449contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 32) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                    }
                }
                FloatingActionButtonElevation floatingActionButtonElevation6 = floatingActionButtonElevationM1584elevationxZ9QkE;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1650866856, i3, -1, "androidx.compose.material3.LargeFloatingActionButton (FloatingActionButton.kt:215)");
                }
                FabPrimaryLargeTokens fabPrimaryLargeTokens4 = FabPrimaryLargeTokens.INSTANCE;
                m1589FloatingActionButtonXz6DiA(interfaceC3588op, SizeKt.m536sizeInqDBjuR0$default(modifier3, fabPrimaryLargeTokens4.m2222getContainerWidthD9Ej5fM(), fabPrimaryLargeTokens4.m2221getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), largeShape, containerColor, jM1449contentColorForek8zF_U, floatingActionButtonElevation6, mutableInteractionSource2, interfaceC0526Fp, composerStartRestartGroup, i3 & 33554318, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape3 = largeShape;
                j4 = jM1449contentColorForek8zF_U;
                floatingActionButtonElevation2 = floatingActionButtonElevation6;
                j5 = containerColor;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        largeShape = FloatingActionButtonDefaults.INSTANCE.getLargeShape(composerStartRestartGroup, 6);
                    } else {
                        largeShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    } else {
                        i7 = i3;
                        jM1449contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 32) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                    }
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        largeShape = FloatingActionButtonDefaults.INSTANCE.getLargeShape(composerStartRestartGroup, 6);
                    } else {
                        largeShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    } else {
                        i7 = i3;
                        jM1449contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 32) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                    }
                }
                FloatingActionButtonElevation floatingActionButtonElevation7 = floatingActionButtonElevationM1584elevationxZ9QkE;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1650866856, i3, -1, "androidx.compose.material3.LargeFloatingActionButton (FloatingActionButton.kt:215)");
                }
                FabPrimaryLargeTokens fabPrimaryLargeTokens5 = FabPrimaryLargeTokens.INSTANCE;
                m1589FloatingActionButtonXz6DiA(interfaceC3588op, SizeKt.m536sizeInqDBjuR0$default(modifier3, fabPrimaryLargeTokens5.m2222getContainerWidthD9Ej5fM(), fabPrimaryLargeTokens5.m2221getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), largeShape, containerColor, jM1449contentColorForek8zF_U, floatingActionButtonElevation7, mutableInteractionSource2, interfaceC0526Fp, composerStartRestartGroup, i3 & 33554318, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape3 = largeShape;
                j4 = jM1449contentColorForek8zF_U;
                floatingActionButtonElevation2 = floatingActionButtonElevation7;
                j5 = containerColor;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$LargeFloatingActionButton$2(interfaceC3588op, modifier4, shape3, j5, j4, floatingActionButtonElevation2, mutableInteractionSource3, interfaceC0526Fp, i, i2));
        }
        i6 = 12582912;
        i3 |= i6;
        if ((23967451 & i3) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    largeShape = FloatingActionButtonDefaults.INSTANCE.getLargeShape(composerStartRestartGroup, 6);
                } else {
                    largeShape = shape2;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    i7 = i3 & (-57345);
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                } else {
                    i7 = i3;
                    jM1449contentColorForek8zF_U = j3;
                }
                if ((i2 & 32) != 0) {
                    floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i7 & (-458753);
                } else {
                    i3 = i7;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier2;
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                }
            } else {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    largeShape = FloatingActionButtonDefaults.INSTANCE.getLargeShape(composerStartRestartGroup, 6);
                } else {
                    largeShape = shape2;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    i7 = i3 & (-57345);
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                } else {
                    i7 = i3;
                    jM1449contentColorForek8zF_U = j3;
                }
                if ((i2 & 32) != 0) {
                    floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i7 & (-458753);
                } else {
                    i3 = i7;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier2;
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                }
            }
            FloatingActionButtonElevation floatingActionButtonElevation8 = floatingActionButtonElevationM1584elevationxZ9QkE;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1650866856, i3, -1, "androidx.compose.material3.LargeFloatingActionButton (FloatingActionButton.kt:215)");
            }
            FabPrimaryLargeTokens fabPrimaryLargeTokens6 = FabPrimaryLargeTokens.INSTANCE;
            m1589FloatingActionButtonXz6DiA(interfaceC3588op, SizeKt.m536sizeInqDBjuR0$default(modifier3, fabPrimaryLargeTokens6.m2222getContainerWidthD9Ej5fM(), fabPrimaryLargeTokens6.m2221getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), largeShape, containerColor, jM1449contentColorForek8zF_U, floatingActionButtonElevation8, mutableInteractionSource2, interfaceC0526Fp, composerStartRestartGroup, i3 & 33554318, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            shape3 = largeShape;
            j4 = jM1449contentColorForek8zF_U;
            floatingActionButtonElevation2 = floatingActionButtonElevation8;
            j5 = containerColor;
            mutableInteractionSource3 = mutableInteractionSource2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    largeShape = FloatingActionButtonDefaults.INSTANCE.getLargeShape(composerStartRestartGroup, 6);
                } else {
                    largeShape = shape2;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    i7 = i3 & (-57345);
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                } else {
                    i7 = i3;
                    jM1449contentColorForek8zF_U = j3;
                }
                if ((i2 & 32) != 0) {
                    floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i7 & (-458753);
                } else {
                    i3 = i7;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier2;
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                }
            } else {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    largeShape = FloatingActionButtonDefaults.INSTANCE.getLargeShape(composerStartRestartGroup, 6);
                } else {
                    largeShape = shape2;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    i7 = i3 & (-57345);
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                } else {
                    i7 = i3;
                    jM1449contentColorForek8zF_U = j3;
                }
                if ((i2 & 32) != 0) {
                    floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i7 & (-458753);
                } else {
                    i3 = i7;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier2;
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                }
            }
            FloatingActionButtonElevation floatingActionButtonElevation9 = floatingActionButtonElevationM1584elevationxZ9QkE;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1650866856, i3, -1, "androidx.compose.material3.LargeFloatingActionButton (FloatingActionButton.kt:215)");
            }
            FabPrimaryLargeTokens fabPrimaryLargeTokens7 = FabPrimaryLargeTokens.INSTANCE;
            m1589FloatingActionButtonXz6DiA(interfaceC3588op, SizeKt.m536sizeInqDBjuR0$default(modifier3, fabPrimaryLargeTokens7.m2222getContainerWidthD9Ej5fM(), fabPrimaryLargeTokens7.m2221getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), largeShape, containerColor, jM1449contentColorForek8zF_U, floatingActionButtonElevation9, mutableInteractionSource2, interfaceC0526Fp, composerStartRestartGroup, i3 & 33554318, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            shape3 = largeShape;
            j4 = jM1449contentColorForek8zF_U;
            floatingActionButtonElevation2 = floatingActionButtonElevation9;
            j5 = containerColor;
            mutableInteractionSource3 = mutableInteractionSource2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$LargeFloatingActionButton$2(interfaceC3588op, modifier4, shape3, j5, j4, floatingActionButtonElevation2, mutableInteractionSource3, interfaceC0526Fp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:113:0x0150 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:114:0x0152  */
    /* JADX WARN: Code duplicated, block: B:115:0x0155  */
    /* JADX WARN: Code duplicated, block: B:118:0x015c  */
    /* JADX WARN: Code duplicated, block: B:119:0x0167  */
    /* JADX WARN: Code duplicated, block: B:122:0x016d  */
    /* JADX WARN: Code duplicated, block: B:125:0x017a  */
    /* JADX WARN: Code duplicated, block: B:126:0x018b  */
    /* JADX WARN: Code duplicated, block: B:129:0x0193  */
    /* JADX WARN: Code duplicated, block: B:130:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:132:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:134:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:136:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:139:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:142:0x0233  */
    /* JADX WARN: Code duplicated, block: B:147:0x0249  */
    /* JADX WARN: Code duplicated, block: B:149:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:30:0x005d  */
    /* JADX WARN: Code duplicated, block: B:31:0x0060  */
    /* JADX WARN: Code duplicated, block: B:34:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0095  */
    /* JADX WARN: Code duplicated, block: B:53:0x0098  */
    /* JADX WARN: Code duplicated, block: B:56:0x009e  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:86:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:94:0x0114  */
    /* JADX WARN: Code duplicated, block: B:96:0x0121  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: SmallFloatingActionButton-X-z6DiA, reason: not valid java name */
    public static final void m1591SmallFloatingActionButtonXz6DiA(InterfaceC3588op interfaceC3588op, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        int i3;
        Shape shape2;
        long containerColor;
        long j3;
        FloatingActionButtonElevation floatingActionButtonElevationM1584elevationxZ9QkE;
        int i4;
        int i5;
        int i6;
        Modifier modifier2;
        Shape smallShape;
        int i7;
        long jM1449contentColorForek8zF_U;
        MutableInteractionSource mutableInteractionSource2;
        Modifier modifier3;
        Object objRememberedValue;
        Modifier modifier4;
        Shape shape3;
        long j4;
        FloatingActionButtonElevation floatingActionButtonElevation2;
        long j5;
        MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(1444748300);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC3588op) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                if ((i2 & 4) == 0) {
                    shape2 = shape;
                    int i9 = composerStartRestartGroup.changed(shape2) ? 256 : 128;
                    i3 |= i9;
                } else {
                    shape2 = shape;
                }
                i3 |= i9;
            } else {
                shape2 = shape;
            }
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    containerColor = j;
                    int i10 = composerStartRestartGroup.changed(containerColor) ? 2048 : 1024;
                    i3 |= i10;
                } else {
                    containerColor = j;
                }
                i3 |= i10;
            } else {
                containerColor = j;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    j3 = j2;
                    int i11 = composerStartRestartGroup.changed(j3) ? 16384 : 8192;
                    i3 |= i11;
                } else {
                    j3 = j2;
                }
                i3 |= i11;
            } else {
                j3 = j2;
            }
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation;
                    int i12 = composerStartRestartGroup.changed(floatingActionButtonElevationM1584elevationxZ9QkE) ? 131072 : 65536;
                    i3 |= i12;
                } else {
                    floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation;
                }
                i3 |= i12;
            } else {
                floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation;
            }
            i4 = i2 & 64;
            if (i4 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i5 = 1048576;
                } else {
                    i5 = 524288;
                }
                i3 |= i5;
            }
            if ((i2 & 128) != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i6 = 8388608;
                    } else {
                        i6 = 4194304;
                    }
                }
                if ((23967451 & i3) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            smallShape = FloatingActionButtonDefaults.INSTANCE.getSmallShape(composerStartRestartGroup, 6);
                        } else {
                            smallShape = shape2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            i7 = i3 & (-57345);
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        } else {
                            i7 = i3;
                            jM1449contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 32) != 0) {
                            floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i3 = i7 & (-458753);
                        } else {
                            i3 = i7;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            modifier3 = modifier2;
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        modifier3 = modifier;
                        mutableInteractionSource2 = mutableInteractionSource;
                        smallShape = shape2;
                        containerColor = containerColor;
                        jM1449contentColorForek8zF_U = j3;
                    }
                    FloatingActionButtonElevation floatingActionButtonElevation3 = floatingActionButtonElevationM1584elevationxZ9QkE;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1444748300, i3, -1, "androidx.compose.material3.SmallFloatingActionButton (FloatingActionButton.kt:163)");
                    }
                    FabPrimarySmallTokens fabPrimarySmallTokens = FabPrimarySmallTokens.INSTANCE;
                    m1589FloatingActionButtonXz6DiA(interfaceC3588op, SizeKt.m536sizeInqDBjuR0$default(modifier3, fabPrimarySmallTokens.m2233getContainerWidthD9Ej5fM(), fabPrimarySmallTokens.m2232getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), smallShape, containerColor, jM1449contentColorForek8zF_U, floatingActionButtonElevation3, mutableInteractionSource2, interfaceC0526Fp, composerStartRestartGroup, i3 & 33554318, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape3 = smallShape;
                    j4 = jM1449contentColorForek8zF_U;
                    floatingActionButtonElevation2 = floatingActionButtonElevation3;
                    j5 = containerColor;
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier4 = modifier;
                    shape3 = shape2;
                    j5 = containerColor;
                    j4 = j3;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM1584elevationxZ9QkE;
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$SmallFloatingActionButton$2(interfaceC3588op, modifier4, shape3, j5, j4, floatingActionButtonElevation2, mutableInteractionSource3, interfaceC0526Fp, i, i2));
            }
            i6 = 12582912;
            i3 |= i6;
            if ((23967451 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        smallShape = FloatingActionButtonDefaults.INSTANCE.getSmallShape(composerStartRestartGroup, 6);
                    } else {
                        smallShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    } else {
                        i7 = i3;
                        jM1449contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 32) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                    }
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        smallShape = FloatingActionButtonDefaults.INSTANCE.getSmallShape(composerStartRestartGroup, 6);
                    } else {
                        smallShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    } else {
                        i7 = i3;
                        jM1449contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 32) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                    }
                }
                FloatingActionButtonElevation floatingActionButtonElevation4 = floatingActionButtonElevationM1584elevationxZ9QkE;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1444748300, i3, -1, "androidx.compose.material3.SmallFloatingActionButton (FloatingActionButton.kt:163)");
                }
                FabPrimarySmallTokens fabPrimarySmallTokens2 = FabPrimarySmallTokens.INSTANCE;
                m1589FloatingActionButtonXz6DiA(interfaceC3588op, SizeKt.m536sizeInqDBjuR0$default(modifier3, fabPrimarySmallTokens2.m2233getContainerWidthD9Ej5fM(), fabPrimarySmallTokens2.m2232getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), smallShape, containerColor, jM1449contentColorForek8zF_U, floatingActionButtonElevation4, mutableInteractionSource2, interfaceC0526Fp, composerStartRestartGroup, i3 & 33554318, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape3 = smallShape;
                j4 = jM1449contentColorForek8zF_U;
                floatingActionButtonElevation2 = floatingActionButtonElevation4;
                j5 = containerColor;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        smallShape = FloatingActionButtonDefaults.INSTANCE.getSmallShape(composerStartRestartGroup, 6);
                    } else {
                        smallShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    } else {
                        i7 = i3;
                        jM1449contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 32) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                    }
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        smallShape = FloatingActionButtonDefaults.INSTANCE.getSmallShape(composerStartRestartGroup, 6);
                    } else {
                        smallShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    } else {
                        i7 = i3;
                        jM1449contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 32) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                    }
                }
                FloatingActionButtonElevation floatingActionButtonElevation5 = floatingActionButtonElevationM1584elevationxZ9QkE;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1444748300, i3, -1, "androidx.compose.material3.SmallFloatingActionButton (FloatingActionButton.kt:163)");
                }
                FabPrimarySmallTokens fabPrimarySmallTokens3 = FabPrimarySmallTokens.INSTANCE;
                m1589FloatingActionButtonXz6DiA(interfaceC3588op, SizeKt.m536sizeInqDBjuR0$default(modifier3, fabPrimarySmallTokens3.m2233getContainerWidthD9Ej5fM(), fabPrimarySmallTokens3.m2232getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), smallShape, containerColor, jM1449contentColorForek8zF_U, floatingActionButtonElevation5, mutableInteractionSource2, interfaceC0526Fp, composerStartRestartGroup, i3 & 33554318, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape3 = smallShape;
                j4 = jM1449contentColorForek8zF_U;
                floatingActionButtonElevation2 = floatingActionButtonElevation5;
                j5 = containerColor;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$SmallFloatingActionButton$2(interfaceC3588op, modifier4, shape3, j5, j4, floatingActionButtonElevation2, mutableInteractionSource3, interfaceC0526Fp, i, i2));
        }
        i3 |= 48;
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i9;
            } else {
                shape2 = shape;
            }
            i3 |= i9;
        } else {
            shape2 = shape;
        }
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                containerColor = j;
                if (composerStartRestartGroup.changed(containerColor)) {
                }
                i3 |= i10;
            } else {
                containerColor = j;
            }
            i3 |= i10;
        } else {
            containerColor = j;
        }
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                j3 = j2;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i3 |= i11;
            } else {
                j3 = j2;
            }
            i3 |= i11;
        } else {
            j3 = j2;
        }
        if ((458752 & i) == 0) {
            if ((i2 & 32) == 0) {
                floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation;
                if (composerStartRestartGroup.changed(floatingActionButtonElevationM1584elevationxZ9QkE)) {
                }
                i3 |= i12;
            } else {
                floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation;
            }
            i3 |= i12;
        } else {
            floatingActionButtonElevationM1584elevationxZ9QkE = floatingActionButtonElevation;
        }
        i4 = i2 & 64;
        if (i4 != 0) {
            i3 |= 1572864;
        } else if ((i & 3670016) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i5 = 1048576;
            } else {
                i5 = 524288;
            }
            i3 |= i5;
        }
        if ((i2 & 128) != 0) {
            if ((29360128 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i6 = 8388608;
                } else {
                    i6 = 4194304;
                }
            }
            if ((23967451 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        smallShape = FloatingActionButtonDefaults.INSTANCE.getSmallShape(composerStartRestartGroup, 6);
                    } else {
                        smallShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    } else {
                        i7 = i3;
                        jM1449contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 32) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                    }
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        smallShape = FloatingActionButtonDefaults.INSTANCE.getSmallShape(composerStartRestartGroup, 6);
                    } else {
                        smallShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    } else {
                        i7 = i3;
                        jM1449contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 32) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                    }
                }
                FloatingActionButtonElevation floatingActionButtonElevation6 = floatingActionButtonElevationM1584elevationxZ9QkE;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1444748300, i3, -1, "androidx.compose.material3.SmallFloatingActionButton (FloatingActionButton.kt:163)");
                }
                FabPrimarySmallTokens fabPrimarySmallTokens4 = FabPrimarySmallTokens.INSTANCE;
                m1589FloatingActionButtonXz6DiA(interfaceC3588op, SizeKt.m536sizeInqDBjuR0$default(modifier3, fabPrimarySmallTokens4.m2233getContainerWidthD9Ej5fM(), fabPrimarySmallTokens4.m2232getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), smallShape, containerColor, jM1449contentColorForek8zF_U, floatingActionButtonElevation6, mutableInteractionSource2, interfaceC0526Fp, composerStartRestartGroup, i3 & 33554318, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape3 = smallShape;
                j4 = jM1449contentColorForek8zF_U;
                floatingActionButtonElevation2 = floatingActionButtonElevation6;
                j5 = containerColor;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        smallShape = FloatingActionButtonDefaults.INSTANCE.getSmallShape(composerStartRestartGroup, 6);
                    } else {
                        smallShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    } else {
                        i7 = i3;
                        jM1449contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 32) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                    }
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        smallShape = FloatingActionButtonDefaults.INSTANCE.getSmallShape(composerStartRestartGroup, 6);
                    } else {
                        smallShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    } else {
                        i7 = i3;
                        jM1449contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 32) != 0) {
                        floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier2;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                    }
                }
                FloatingActionButtonElevation floatingActionButtonElevation7 = floatingActionButtonElevationM1584elevationxZ9QkE;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1444748300, i3, -1, "androidx.compose.material3.SmallFloatingActionButton (FloatingActionButton.kt:163)");
                }
                FabPrimarySmallTokens fabPrimarySmallTokens5 = FabPrimarySmallTokens.INSTANCE;
                m1589FloatingActionButtonXz6DiA(interfaceC3588op, SizeKt.m536sizeInqDBjuR0$default(modifier3, fabPrimarySmallTokens5.m2233getContainerWidthD9Ej5fM(), fabPrimarySmallTokens5.m2232getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), smallShape, containerColor, jM1449contentColorForek8zF_U, floatingActionButtonElevation7, mutableInteractionSource2, interfaceC0526Fp, composerStartRestartGroup, i3 & 33554318, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape3 = smallShape;
                j4 = jM1449contentColorForek8zF_U;
                floatingActionButtonElevation2 = floatingActionButtonElevation7;
                j5 = containerColor;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$SmallFloatingActionButton$2(interfaceC3588op, modifier4, shape3, j5, j4, floatingActionButtonElevation2, mutableInteractionSource3, interfaceC0526Fp, i, i2));
        }
        i6 = 12582912;
        i3 |= i6;
        if ((23967451 & i3) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    smallShape = FloatingActionButtonDefaults.INSTANCE.getSmallShape(composerStartRestartGroup, 6);
                } else {
                    smallShape = shape2;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    i7 = i3 & (-57345);
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                } else {
                    i7 = i3;
                    jM1449contentColorForek8zF_U = j3;
                }
                if ((i2 & 32) != 0) {
                    floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i7 & (-458753);
                } else {
                    i3 = i7;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier2;
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                }
            } else {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    smallShape = FloatingActionButtonDefaults.INSTANCE.getSmallShape(composerStartRestartGroup, 6);
                } else {
                    smallShape = shape2;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    i7 = i3 & (-57345);
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                } else {
                    i7 = i3;
                    jM1449contentColorForek8zF_U = j3;
                }
                if ((i2 & 32) != 0) {
                    floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i7 & (-458753);
                } else {
                    i3 = i7;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier2;
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                }
            }
            FloatingActionButtonElevation floatingActionButtonElevation8 = floatingActionButtonElevationM1584elevationxZ9QkE;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1444748300, i3, -1, "androidx.compose.material3.SmallFloatingActionButton (FloatingActionButton.kt:163)");
            }
            FabPrimarySmallTokens fabPrimarySmallTokens6 = FabPrimarySmallTokens.INSTANCE;
            m1589FloatingActionButtonXz6DiA(interfaceC3588op, SizeKt.m536sizeInqDBjuR0$default(modifier3, fabPrimarySmallTokens6.m2233getContainerWidthD9Ej5fM(), fabPrimarySmallTokens6.m2232getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), smallShape, containerColor, jM1449contentColorForek8zF_U, floatingActionButtonElevation8, mutableInteractionSource2, interfaceC0526Fp, composerStartRestartGroup, i3 & 33554318, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            shape3 = smallShape;
            j4 = jM1449contentColorForek8zF_U;
            floatingActionButtonElevation2 = floatingActionButtonElevation8;
            j5 = containerColor;
            mutableInteractionSource3 = mutableInteractionSource2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    smallShape = FloatingActionButtonDefaults.INSTANCE.getSmallShape(composerStartRestartGroup, 6);
                } else {
                    smallShape = shape2;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    i7 = i3 & (-57345);
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                } else {
                    i7 = i3;
                    jM1449contentColorForek8zF_U = j3;
                }
                if ((i2 & 32) != 0) {
                    floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i7 & (-458753);
                } else {
                    i3 = i7;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier2;
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                }
            } else {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    smallShape = FloatingActionButtonDefaults.INSTANCE.getSmallShape(composerStartRestartGroup, 6);
                } else {
                    smallShape = shape2;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    i7 = i3 & (-57345);
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                } else {
                    i7 = i3;
                    jM1449contentColorForek8zF_U = j3;
                }
                if ((i2 & 32) != 0) {
                    floatingActionButtonElevationM1584elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1584elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i7 & (-458753);
                } else {
                    i3 = i7;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier2;
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                }
            }
            FloatingActionButtonElevation floatingActionButtonElevation9 = floatingActionButtonElevationM1584elevationxZ9QkE;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1444748300, i3, -1, "androidx.compose.material3.SmallFloatingActionButton (FloatingActionButton.kt:163)");
            }
            FabPrimarySmallTokens fabPrimarySmallTokens7 = FabPrimarySmallTokens.INSTANCE;
            m1589FloatingActionButtonXz6DiA(interfaceC3588op, SizeKt.m536sizeInqDBjuR0$default(modifier3, fabPrimarySmallTokens7.m2233getContainerWidthD9Ej5fM(), fabPrimarySmallTokens7.m2232getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), smallShape, containerColor, jM1449contentColorForek8zF_U, floatingActionButtonElevation9, mutableInteractionSource2, interfaceC0526Fp, composerStartRestartGroup, i3 & 33554318, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            shape3 = smallShape;
            j4 = jM1449contentColorForek8zF_U;
            floatingActionButtonElevation2 = floatingActionButtonElevation9;
            j5 = containerColor;
            mutableInteractionSource3 = mutableInteractionSource2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$SmallFloatingActionButton$2(interfaceC3588op, modifier4, shape3, j5, j4, floatingActionButtonElevation2, mutableInteractionSource3, interfaceC0526Fp, i, i2));
    }
}
