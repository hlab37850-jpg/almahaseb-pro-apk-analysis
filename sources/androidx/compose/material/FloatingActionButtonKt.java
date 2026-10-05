package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class FloatingActionButtonKt {
    private static final float FabSize = Dp.m5160constructorimpl(56);
    private static final float ExtendedFabSize = Dp.m5160constructorimpl(48);
    private static final float ExtendedFabIconPadding = Dp.m5160constructorimpl(12);
    private static final float ExtendedFabTextPadding = Dp.m5160constructorimpl(20);

    /* JADX WARN: Code duplicated, block: B:100:0x011f  */
    /* JADX WARN: Code duplicated, block: B:104:0x0136  */
    /* JADX WARN: Code duplicated, block: B:106:0x0147  */
    /* JADX WARN: Code duplicated, block: B:122:0x017d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:123:0x017f  */
    /* JADX WARN: Code duplicated, block: B:124:0x0182  */
    /* JADX WARN: Code duplicated, block: B:126:0x0185  */
    /* JADX WARN: Code duplicated, block: B:127:0x0187  */
    /* JADX WARN: Code duplicated, block: B:129:0x018a  */
    /* JADX WARN: Code duplicated, block: B:131:0x019c  */
    /* JADX WARN: Code duplicated, block: B:133:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:136:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:137:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:140:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:141:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:144:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:145:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:148:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:152:0x0231  */
    /* JADX WARN: Code duplicated, block: B:155:0x029c  */
    /* JADX WARN: Code duplicated, block: B:160:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:38:0x006d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:43:0x007c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0086  */
    /* JADX WARN: Code duplicated, block: B:49:0x008b  */
    /* JADX WARN: Code duplicated, block: B:51:0x008f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0097  */
    /* JADX WARN: Code duplicated, block: B:54:0x009a  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:66:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:91:0x0101  */
    /* JADX WARN: Code duplicated, block: B:93:0x0109  */
    /* JADX WARN: Code duplicated, block: B:94:0x010c  */
    /* JADX WARN: Code duplicated, block: B:97:0x0113  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: ExtendedFloatingActionButton-wqdebIU, reason: not valid java name */
    public static final void m1136ExtendedFloatingActionButtonwqdebIU(InterfaceC0526Fp interfaceC0526Fp, InterfaceC3588op interfaceC3588op, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp2, MutableInteractionSource mutableInteractionSource, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        InterfaceC0526Fp interfaceC0526Fp3;
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        long j3;
        int i8;
        FloatingActionButtonElevation floatingActionButtonElevationM1135elevationxZ9QkE;
        Modifier modifier3;
        InterfaceC0526Fp interfaceC0526Fp4;
        MutableInteractionSource mutableInteractionSource3;
        Shape shapeCopy;
        long jM1053getSecondary0d7_KjU;
        long jM1069contentColorForek8zF_U;
        InterfaceC0526Fp interfaceC0526Fp5;
        MutableInteractionSource mutableInteractionSource4;
        Shape shape2;
        long j4;
        FloatingActionButtonElevation floatingActionButtonElevation2;
        long j5;
        Modifier modifier4;
        int i9;
        Object objRememberedValue;
        Modifier modifier5;
        InterfaceC0526Fp interfaceC0526Fp6;
        MutableInteractionSource mutableInteractionSource5;
        Shape shape3;
        long j6;
        long j7;
        FloatingActionButtonElevation floatingActionButtonElevation3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i10;
        int i11;
        AbstractC4492zt.h(interfaceC0526Fp, "text");
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1555720195);
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
            i3 |= composerStartRestartGroup.changedInstance(interfaceC3588op) ? 32 : 16;
        }
        int i12 = i2 & 4;
        if (i12 == 0) {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 57344) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    if ((i & 458752) != 0) {
                        i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
                    }
                    if ((i & 3670016) == 0) {
                        j3 = j;
                        if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(j3)) {
                            i11 = 524288;
                        } else {
                            i11 = 1048576;
                        }
                        i3 |= i11;
                    } else {
                        j3 = j;
                    }
                    if ((i & 29360128) == 0) {
                        int i13 = i3;
                        if ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j2)) {
                            i10 = 4194304;
                        } else {
                            i10 = 8388608;
                        }
                        i8 = i13 | i10;
                    } else {
                        i8 = i3;
                    }
                    if ((i & 234881024) == 0) {
                        if ((i2 & 256) == 0) {
                            floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation;
                            int i14 = composerStartRestartGroup.changed(floatingActionButtonElevationM1135elevationxZ9QkE) ? 67108864 : 33554432;
                            i8 |= i14;
                        } else {
                            floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation;
                        }
                        i8 |= i14;
                    } else {
                        floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation;
                    }
                    if ((i8 & 191739611) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp3;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 32) != 0) {
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i8 &= -458753;
                            } else {
                                shapeCopy = shape;
                            }
                            if ((i2 & 64) != 0) {
                                jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                                i8 &= -3670017;
                            } else {
                                jM1053getSecondary0d7_KjU = j3;
                            }
                            if ((i2 & 128) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                                i8 &= -29360129;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if ((i2 & 256) != 0) {
                                floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                                i8 &= -234881025;
                            }
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape2 = shapeCopy;
                            j4 = jM1053getSecondary0d7_KjU;
                            floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                            j5 = jM1069contentColorForek8zF_U;
                            int i15 = i8;
                            modifier4 = modifier3;
                            i9 = i15;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i8 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i8 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i8 &= -29360129;
                            }
                            if ((i2 & 256) != 0) {
                                i8 &= -234881025;
                            }
                            shape2 = shape;
                            j5 = j2;
                            floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            j4 = j3;
                            i9 = i8;
                            modifier4 = modifier2;
                            interfaceC0526Fp5 = interfaceC0526Fp3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1555720195, i9, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:146)");
                        }
                        float f = ExtendedFabSize;
                        Modifier modifierM536sizeInqDBjuR0$default = SizeKt.m536sizeInqDBjuR0$default(modifier4, f, f, 0.0f, 0.0f, 12, null);
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$2(interfaceC0526Fp5, i9, interfaceC0526Fp));
                        int i16 = ((i9 >> 3) & 14) | 12582912;
                        int i17 = i9 >> 6;
                        InterfaceC0526Fp interfaceC0526Fp7 = interfaceC0526Fp5;
                        m1137FloatingActionButtonbogVsAg(interfaceC3588op, modifierM536sizeInqDBjuR0$default, mutableInteractionSource4, shape2, j4, j5, floatingActionButtonElevation2, composableLambda, composerStartRestartGroup, (i17 & 896) | i16 | (i17 & 7168) | (57344 & i17) | (458752 & i17) | (i17 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        interfaceC0526Fp6 = interfaceC0526Fp7;
                        mutableInteractionSource5 = mutableInteractionSource4;
                        shape3 = shape2;
                        j6 = j4;
                        j7 = j5;
                        floatingActionButtonElevation3 = floatingActionButtonElevation2;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        shape3 = shape;
                        modifier5 = modifier2;
                        interfaceC0526Fp6 = interfaceC0526Fp3;
                        mutableInteractionSource5 = mutableInteractionSource2;
                        j6 = j3;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM1135elevationxZ9QkE;
                        j7 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$ExtendedFloatingActionButton$3(interfaceC0526Fp, interfaceC3588op, modifier5, interfaceC0526Fp6, mutableInteractionSource5, shape3, j6, j7, floatingActionButtonElevation3, i, i2));
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 458752) != 0) {
                    i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
                }
                if ((i & 3670016) == 0) {
                    j3 = j;
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                } else {
                    j3 = j;
                }
                if ((i & 29360128) == 0) {
                    int i18 = i3;
                    if ((i2 & 128) == 0) {
                        i10 = 4194304;
                    } else {
                        i10 = 4194304;
                    }
                    i8 = i18 | i10;
                } else {
                    i8 = i3;
                }
                if ((i & 234881024) == 0) {
                    if ((i2 & 256) == 0) {
                        floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation;
                        if (composerStartRestartGroup.changed(floatingActionButtonElevationM1135elevationxZ9QkE)) {
                        }
                        i8 |= i14;
                    } else {
                        floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation;
                    }
                    i8 |= i14;
                } else {
                    floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation;
                }
                if ((i8 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i8 &= -458753;
                        } else {
                            shapeCopy = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                            i8 &= -3670017;
                        } else {
                            jM1053getSecondary0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                            i8 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i8 &= -234881025;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape2 = shapeCopy;
                        j4 = jM1053getSecondary0d7_KjU;
                        floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                        j5 = jM1069contentColorForek8zF_U;
                        int i19 = i8;
                        modifier4 = modifier3;
                        i9 = i19;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i8 &= -458753;
                        } else {
                            shapeCopy = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                            i8 &= -3670017;
                        } else {
                            jM1053getSecondary0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                            i8 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i8 &= -234881025;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape2 = shapeCopy;
                        j4 = jM1053getSecondary0d7_KjU;
                        floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                        j5 = jM1069contentColorForek8zF_U;
                        int i110 = i8;
                        modifier4 = modifier3;
                        i9 = i110;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1555720195, i9, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:146)");
                    }
                    float f2 = ExtendedFabSize;
                    Modifier modifierM536sizeInqDBjuR0$default2 = SizeKt.m536sizeInqDBjuR0$default(modifier4, f2, f2, 0.0f, 0.0f, 12, null);
                    ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$2(interfaceC0526Fp5, i9, interfaceC0526Fp));
                    int i111 = ((i9 >> 3) & 14) | 12582912;
                    int i112 = i9 >> 6;
                    InterfaceC0526Fp interfaceC0526Fp8 = interfaceC0526Fp5;
                    m1137FloatingActionButtonbogVsAg(interfaceC3588op, modifierM536sizeInqDBjuR0$default2, mutableInteractionSource4, shape2, j4, j5, floatingActionButtonElevation2, composableLambda2, composerStartRestartGroup, (i112 & 896) | i111 | (i112 & 7168) | (57344 & i112) | (458752 & i112) | (i112 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    interfaceC0526Fp6 = interfaceC0526Fp8;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    shape3 = shape2;
                    j6 = j4;
                    j7 = j5;
                    floatingActionButtonElevation3 = floatingActionButtonElevation2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i8 &= -458753;
                        } else {
                            shapeCopy = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                            i8 &= -3670017;
                        } else {
                            jM1053getSecondary0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                            i8 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i8 &= -234881025;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape2 = shapeCopy;
                        j4 = jM1053getSecondary0d7_KjU;
                        floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                        j5 = jM1069contentColorForek8zF_U;
                        int i113 = i8;
                        modifier4 = modifier3;
                        i9 = i113;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i8 &= -458753;
                        } else {
                            shapeCopy = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                            i8 &= -3670017;
                        } else {
                            jM1053getSecondary0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                            i8 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i8 &= -234881025;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape2 = shapeCopy;
                        j4 = jM1053getSecondary0d7_KjU;
                        floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                        j5 = jM1069contentColorForek8zF_U;
                        int i114 = i8;
                        modifier4 = modifier3;
                        i9 = i114;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1555720195, i9, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:146)");
                    }
                    float f3 = ExtendedFabSize;
                    Modifier modifierM536sizeInqDBjuR0$default3 = SizeKt.m536sizeInqDBjuR0$default(modifier4, f3, f3, 0.0f, 0.0f, 12, null);
                    ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$2(interfaceC0526Fp5, i9, interfaceC0526Fp));
                    int i115 = ((i9 >> 3) & 14) | 12582912;
                    int i116 = i9 >> 6;
                    InterfaceC0526Fp interfaceC0526Fp9 = interfaceC0526Fp5;
                    m1137FloatingActionButtonbogVsAg(interfaceC3588op, modifierM536sizeInqDBjuR0$default3, mutableInteractionSource4, shape2, j4, j5, floatingActionButtonElevation2, composableLambda3, composerStartRestartGroup, (i116 & 896) | i115 | (i116 & 7168) | (57344 & i116) | (458752 & i116) | (i116 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    interfaceC0526Fp6 = interfaceC0526Fp9;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    shape3 = shape2;
                    j6 = j4;
                    j7 = j5;
                    floatingActionButtonElevation3 = floatingActionButtonElevation2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$ExtendedFloatingActionButton$3(interfaceC0526Fp, interfaceC3588op, modifier5, interfaceC0526Fp6, mutableInteractionSource5, shape3, j6, j7, floatingActionButtonElevation3, i, i2));
            }
            i3 |= 3072;
            interfaceC0526Fp3 = interfaceC0526Fp2;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 57344) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((i & 458752) != 0) {
                    i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
                }
                if ((i & 3670016) == 0) {
                    j3 = j;
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                } else {
                    j3 = j;
                }
                if ((i & 29360128) == 0) {
                    int i117 = i3;
                    if ((i2 & 128) == 0) {
                        i10 = 4194304;
                    } else {
                        i10 = 4194304;
                    }
                    i8 = i117 | i10;
                } else {
                    i8 = i3;
                }
                if ((i & 234881024) == 0) {
                    if ((i2 & 256) == 0) {
                        floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation;
                        if (composerStartRestartGroup.changed(floatingActionButtonElevationM1135elevationxZ9QkE)) {
                        }
                        i8 |= i14;
                    } else {
                        floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation;
                    }
                    i8 |= i14;
                } else {
                    floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation;
                }
                if ((i8 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i8 &= -458753;
                        } else {
                            shapeCopy = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                            i8 &= -3670017;
                        } else {
                            jM1053getSecondary0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                            i8 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i8 &= -234881025;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape2 = shapeCopy;
                        j4 = jM1053getSecondary0d7_KjU;
                        floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                        j5 = jM1069contentColorForek8zF_U;
                        int i118 = i8;
                        modifier4 = modifier3;
                        i9 = i118;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i8 &= -458753;
                        } else {
                            shapeCopy = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                            i8 &= -3670017;
                        } else {
                            jM1053getSecondary0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                            i8 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i8 &= -234881025;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape2 = shapeCopy;
                        j4 = jM1053getSecondary0d7_KjU;
                        floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                        j5 = jM1069contentColorForek8zF_U;
                        int i119 = i8;
                        modifier4 = modifier3;
                        i9 = i119;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1555720195, i9, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:146)");
                    }
                    float f4 = ExtendedFabSize;
                    Modifier modifierM536sizeInqDBjuR0$default4 = SizeKt.m536sizeInqDBjuR0$default(modifier4, f4, f4, 0.0f, 0.0f, 12, null);
                    ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$2(interfaceC0526Fp5, i9, interfaceC0526Fp));
                    int i1110 = ((i9 >> 3) & 14) | 12582912;
                    int i1111 = i9 >> 6;
                    InterfaceC0526Fp interfaceC0526Fp10 = interfaceC0526Fp5;
                    m1137FloatingActionButtonbogVsAg(interfaceC3588op, modifierM536sizeInqDBjuR0$default4, mutableInteractionSource4, shape2, j4, j5, floatingActionButtonElevation2, composableLambda4, composerStartRestartGroup, (i1111 & 896) | i1110 | (i1111 & 7168) | (57344 & i1111) | (458752 & i1111) | (i1111 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    interfaceC0526Fp6 = interfaceC0526Fp10;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    shape3 = shape2;
                    j6 = j4;
                    j7 = j5;
                    floatingActionButtonElevation3 = floatingActionButtonElevation2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i8 &= -458753;
                        } else {
                            shapeCopy = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                            i8 &= -3670017;
                        } else {
                            jM1053getSecondary0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                            i8 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i8 &= -234881025;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape2 = shapeCopy;
                        j4 = jM1053getSecondary0d7_KjU;
                        floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                        j5 = jM1069contentColorForek8zF_U;
                        int i1112 = i8;
                        modifier4 = modifier3;
                        i9 = i1112;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i8 &= -458753;
                        } else {
                            shapeCopy = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                            i8 &= -3670017;
                        } else {
                            jM1053getSecondary0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                            i8 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i8 &= -234881025;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape2 = shapeCopy;
                        j4 = jM1053getSecondary0d7_KjU;
                        floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                        j5 = jM1069contentColorForek8zF_U;
                        int i1113 = i8;
                        modifier4 = modifier3;
                        i9 = i1113;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1555720195, i9, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:146)");
                    }
                    float f5 = ExtendedFabSize;
                    Modifier modifierM536sizeInqDBjuR0$default5 = SizeKt.m536sizeInqDBjuR0$default(modifier4, f5, f5, 0.0f, 0.0f, 12, null);
                    ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$2(interfaceC0526Fp5, i9, interfaceC0526Fp));
                    int i1114 = ((i9 >> 3) & 14) | 12582912;
                    int i1115 = i9 >> 6;
                    InterfaceC0526Fp interfaceC0526Fp11 = interfaceC0526Fp5;
                    m1137FloatingActionButtonbogVsAg(interfaceC3588op, modifierM536sizeInqDBjuR0$default5, mutableInteractionSource4, shape2, j4, j5, floatingActionButtonElevation2, composableLambda5, composerStartRestartGroup, (i1115 & 896) | i1114 | (i1115 & 7168) | (57344 & i1115) | (458752 & i1115) | (i1115 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    interfaceC0526Fp6 = interfaceC0526Fp11;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    shape3 = shape2;
                    j6 = j4;
                    j7 = j5;
                    floatingActionButtonElevation3 = floatingActionButtonElevation2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$ExtendedFloatingActionButton$3(interfaceC0526Fp, interfaceC3588op, modifier5, interfaceC0526Fp6, mutableInteractionSource5, shape3, j6, j7, floatingActionButtonElevation3, i, i2));
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 458752) != 0) {
                i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
            }
            if ((i & 3670016) == 0) {
                j3 = j;
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            } else {
                j3 = j;
            }
            if ((i & 29360128) == 0) {
                int i1116 = i3;
                if ((i2 & 128) == 0) {
                    i10 = 4194304;
                } else {
                    i10 = 4194304;
                }
                i8 = i1116 | i10;
            } else {
                i8 = i3;
            }
            if ((i & 234881024) == 0) {
                if ((i2 & 256) == 0) {
                    floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation;
                    if (composerStartRestartGroup.changed(floatingActionButtonElevationM1135elevationxZ9QkE)) {
                    }
                    i8 |= i14;
                } else {
                    floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation;
                }
                i8 |= i14;
            } else {
                floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation;
            }
            if ((i8 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i8 &= -458753;
                    } else {
                        shapeCopy = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                        i8 &= -3670017;
                    } else {
                        jM1053getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                        i8 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i8 &= -234881025;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape2 = shapeCopy;
                    j4 = jM1053getSecondary0d7_KjU;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                    j5 = jM1069contentColorForek8zF_U;
                    int i1117 = i8;
                    modifier4 = modifier3;
                    i9 = i1117;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i8 &= -458753;
                    } else {
                        shapeCopy = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                        i8 &= -3670017;
                    } else {
                        jM1053getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                        i8 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i8 &= -234881025;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape2 = shapeCopy;
                    j4 = jM1053getSecondary0d7_KjU;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                    j5 = jM1069contentColorForek8zF_U;
                    int i1118 = i8;
                    modifier4 = modifier3;
                    i9 = i1118;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1555720195, i9, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:146)");
                }
                float f6 = ExtendedFabSize;
                Modifier modifierM536sizeInqDBjuR0$default6 = SizeKt.m536sizeInqDBjuR0$default(modifier4, f6, f6, 0.0f, 0.0f, 12, null);
                ComposableLambda composableLambda6 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$2(interfaceC0526Fp5, i9, interfaceC0526Fp));
                int i1119 = ((i9 >> 3) & 14) | 12582912;
                int i11110 = i9 >> 6;
                InterfaceC0526Fp interfaceC0526Fp12 = interfaceC0526Fp5;
                m1137FloatingActionButtonbogVsAg(interfaceC3588op, modifierM536sizeInqDBjuR0$default6, mutableInteractionSource4, shape2, j4, j5, floatingActionButtonElevation2, composableLambda6, composerStartRestartGroup, (i11110 & 896) | i1119 | (i11110 & 7168) | (57344 & i11110) | (458752 & i11110) | (i11110 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                interfaceC0526Fp6 = interfaceC0526Fp12;
                mutableInteractionSource5 = mutableInteractionSource4;
                shape3 = shape2;
                j6 = j4;
                j7 = j5;
                floatingActionButtonElevation3 = floatingActionButtonElevation2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i8 &= -458753;
                    } else {
                        shapeCopy = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                        i8 &= -3670017;
                    } else {
                        jM1053getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                        i8 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i8 &= -234881025;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape2 = shapeCopy;
                    j4 = jM1053getSecondary0d7_KjU;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                    j5 = jM1069contentColorForek8zF_U;
                    int i11111 = i8;
                    modifier4 = modifier3;
                    i9 = i11111;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i8 &= -458753;
                    } else {
                        shapeCopy = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                        i8 &= -3670017;
                    } else {
                        jM1053getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                        i8 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i8 &= -234881025;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape2 = shapeCopy;
                    j4 = jM1053getSecondary0d7_KjU;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                    j5 = jM1069contentColorForek8zF_U;
                    int i11112 = i8;
                    modifier4 = modifier3;
                    i9 = i11112;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1555720195, i9, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:146)");
                }
                float f7 = ExtendedFabSize;
                Modifier modifierM536sizeInqDBjuR0$default7 = SizeKt.m536sizeInqDBjuR0$default(modifier4, f7, f7, 0.0f, 0.0f, 12, null);
                ComposableLambda composableLambda7 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$2(interfaceC0526Fp5, i9, interfaceC0526Fp));
                int i11113 = ((i9 >> 3) & 14) | 12582912;
                int i11114 = i9 >> 6;
                InterfaceC0526Fp interfaceC0526Fp13 = interfaceC0526Fp5;
                m1137FloatingActionButtonbogVsAg(interfaceC3588op, modifierM536sizeInqDBjuR0$default7, mutableInteractionSource4, shape2, j4, j5, floatingActionButtonElevation2, composableLambda7, composerStartRestartGroup, (i11114 & 896) | i11113 | (i11114 & 7168) | (57344 & i11114) | (458752 & i11114) | (i11114 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                interfaceC0526Fp6 = interfaceC0526Fp13;
                mutableInteractionSource5 = mutableInteractionSource4;
                shape3 = shape2;
                j6 = j4;
                j7 = j5;
                floatingActionButtonElevation3 = floatingActionButtonElevation2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$ExtendedFloatingActionButton$3(interfaceC0526Fp, interfaceC3588op, modifier5, interfaceC0526Fp6, mutableInteractionSource5, shape3, j6, j7, floatingActionButtonElevation3, i, i2));
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                interfaceC0526Fp3 = interfaceC0526Fp2;
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 57344) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((i & 458752) != 0) {
                    i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
                }
                if ((i & 3670016) == 0) {
                    j3 = j;
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                } else {
                    j3 = j;
                }
                if ((i & 29360128) == 0) {
                    int i11115 = i3;
                    if ((i2 & 128) == 0) {
                        i10 = 4194304;
                    } else {
                        i10 = 4194304;
                    }
                    i8 = i11115 | i10;
                } else {
                    i8 = i3;
                }
                if ((i & 234881024) == 0) {
                    if ((i2 & 256) == 0) {
                        floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation;
                        if (composerStartRestartGroup.changed(floatingActionButtonElevationM1135elevationxZ9QkE)) {
                        }
                        i8 |= i14;
                    } else {
                        floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation;
                    }
                    i8 |= i14;
                } else {
                    floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation;
                }
                if ((i8 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i8 &= -458753;
                        } else {
                            shapeCopy = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                            i8 &= -3670017;
                        } else {
                            jM1053getSecondary0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                            i8 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i8 &= -234881025;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape2 = shapeCopy;
                        j4 = jM1053getSecondary0d7_KjU;
                        floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                        j5 = jM1069contentColorForek8zF_U;
                        int i11116 = i8;
                        modifier4 = modifier3;
                        i9 = i11116;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i8 &= -458753;
                        } else {
                            shapeCopy = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                            i8 &= -3670017;
                        } else {
                            jM1053getSecondary0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                            i8 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i8 &= -234881025;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape2 = shapeCopy;
                        j4 = jM1053getSecondary0d7_KjU;
                        floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                        j5 = jM1069contentColorForek8zF_U;
                        int i11117 = i8;
                        modifier4 = modifier3;
                        i9 = i11117;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1555720195, i9, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:146)");
                    }
                    float f8 = ExtendedFabSize;
                    Modifier modifierM536sizeInqDBjuR0$default8 = SizeKt.m536sizeInqDBjuR0$default(modifier4, f8, f8, 0.0f, 0.0f, 12, null);
                    ComposableLambda composableLambda8 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$2(interfaceC0526Fp5, i9, interfaceC0526Fp));
                    int i11118 = ((i9 >> 3) & 14) | 12582912;
                    int i11119 = i9 >> 6;
                    InterfaceC0526Fp interfaceC0526Fp14 = interfaceC0526Fp5;
                    m1137FloatingActionButtonbogVsAg(interfaceC3588op, modifierM536sizeInqDBjuR0$default8, mutableInteractionSource4, shape2, j4, j5, floatingActionButtonElevation2, composableLambda8, composerStartRestartGroup, (i11119 & 896) | i11118 | (i11119 & 7168) | (57344 & i11119) | (458752 & i11119) | (i11119 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    interfaceC0526Fp6 = interfaceC0526Fp14;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    shape3 = shape2;
                    j6 = j4;
                    j7 = j5;
                    floatingActionButtonElevation3 = floatingActionButtonElevation2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i8 &= -458753;
                        } else {
                            shapeCopy = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                            i8 &= -3670017;
                        } else {
                            jM1053getSecondary0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                            i8 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i8 &= -234881025;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape2 = shapeCopy;
                        j4 = jM1053getSecondary0d7_KjU;
                        floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                        j5 = jM1069contentColorForek8zF_U;
                        int i111110 = i8;
                        modifier4 = modifier3;
                        i9 = i111110;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i8 &= -458753;
                        } else {
                            shapeCopy = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                            i8 &= -3670017;
                        } else {
                            jM1053getSecondary0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                            i8 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i8 &= -234881025;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape2 = shapeCopy;
                        j4 = jM1053getSecondary0d7_KjU;
                        floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                        j5 = jM1069contentColorForek8zF_U;
                        int i111111 = i8;
                        modifier4 = modifier3;
                        i9 = i111111;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1555720195, i9, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:146)");
                    }
                    float f9 = ExtendedFabSize;
                    Modifier modifierM536sizeInqDBjuR0$default9 = SizeKt.m536sizeInqDBjuR0$default(modifier4, f9, f9, 0.0f, 0.0f, 12, null);
                    ComposableLambda composableLambda9 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$2(interfaceC0526Fp5, i9, interfaceC0526Fp));
                    int i111112 = ((i9 >> 3) & 14) | 12582912;
                    int i111113 = i9 >> 6;
                    InterfaceC0526Fp interfaceC0526Fp15 = interfaceC0526Fp5;
                    m1137FloatingActionButtonbogVsAg(interfaceC3588op, modifierM536sizeInqDBjuR0$default9, mutableInteractionSource4, shape2, j4, j5, floatingActionButtonElevation2, composableLambda9, composerStartRestartGroup, (i111113 & 896) | i111112 | (i111113 & 7168) | (57344 & i111113) | (458752 & i111113) | (i111113 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    interfaceC0526Fp6 = interfaceC0526Fp15;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    shape3 = shape2;
                    j6 = j4;
                    j7 = j5;
                    floatingActionButtonElevation3 = floatingActionButtonElevation2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$ExtendedFloatingActionButton$3(interfaceC0526Fp, interfaceC3588op, modifier5, interfaceC0526Fp6, mutableInteractionSource5, shape3, j6, j7, floatingActionButtonElevation3, i, i2));
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 458752) != 0) {
                i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
            }
            if ((i & 3670016) == 0) {
                j3 = j;
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            } else {
                j3 = j;
            }
            if ((i & 29360128) == 0) {
                int i111114 = i3;
                if ((i2 & 128) == 0) {
                    i10 = 4194304;
                } else {
                    i10 = 4194304;
                }
                i8 = i111114 | i10;
            } else {
                i8 = i3;
            }
            if ((i & 234881024) == 0) {
                if ((i2 & 256) == 0) {
                    floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation;
                    if (composerStartRestartGroup.changed(floatingActionButtonElevationM1135elevationxZ9QkE)) {
                    }
                    i8 |= i14;
                } else {
                    floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation;
                }
                i8 |= i14;
            } else {
                floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation;
            }
            if ((i8 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i8 &= -458753;
                    } else {
                        shapeCopy = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                        i8 &= -3670017;
                    } else {
                        jM1053getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                        i8 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i8 &= -234881025;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape2 = shapeCopy;
                    j4 = jM1053getSecondary0d7_KjU;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                    j5 = jM1069contentColorForek8zF_U;
                    int i111115 = i8;
                    modifier4 = modifier3;
                    i9 = i111115;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i8 &= -458753;
                    } else {
                        shapeCopy = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                        i8 &= -3670017;
                    } else {
                        jM1053getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                        i8 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i8 &= -234881025;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape2 = shapeCopy;
                    j4 = jM1053getSecondary0d7_KjU;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                    j5 = jM1069contentColorForek8zF_U;
                    int i111116 = i8;
                    modifier4 = modifier3;
                    i9 = i111116;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1555720195, i9, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:146)");
                }
                float f10 = ExtendedFabSize;
                Modifier modifierM536sizeInqDBjuR0$default10 = SizeKt.m536sizeInqDBjuR0$default(modifier4, f10, f10, 0.0f, 0.0f, 12, null);
                ComposableLambda composableLambda10 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$2(interfaceC0526Fp5, i9, interfaceC0526Fp));
                int i111117 = ((i9 >> 3) & 14) | 12582912;
                int i111118 = i9 >> 6;
                InterfaceC0526Fp interfaceC0526Fp16 = interfaceC0526Fp5;
                m1137FloatingActionButtonbogVsAg(interfaceC3588op, modifierM536sizeInqDBjuR0$default10, mutableInteractionSource4, shape2, j4, j5, floatingActionButtonElevation2, composableLambda10, composerStartRestartGroup, (i111118 & 896) | i111117 | (i111118 & 7168) | (57344 & i111118) | (458752 & i111118) | (i111118 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                interfaceC0526Fp6 = interfaceC0526Fp16;
                mutableInteractionSource5 = mutableInteractionSource4;
                shape3 = shape2;
                j6 = j4;
                j7 = j5;
                floatingActionButtonElevation3 = floatingActionButtonElevation2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i8 &= -458753;
                    } else {
                        shapeCopy = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                        i8 &= -3670017;
                    } else {
                        jM1053getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                        i8 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i8 &= -234881025;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape2 = shapeCopy;
                    j4 = jM1053getSecondary0d7_KjU;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                    j5 = jM1069contentColorForek8zF_U;
                    int i111119 = i8;
                    modifier4 = modifier3;
                    i9 = i111119;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i8 &= -458753;
                    } else {
                        shapeCopy = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                        i8 &= -3670017;
                    } else {
                        jM1053getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                        i8 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i8 &= -234881025;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape2 = shapeCopy;
                    j4 = jM1053getSecondary0d7_KjU;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                    j5 = jM1069contentColorForek8zF_U;
                    int i1111110 = i8;
                    modifier4 = modifier3;
                    i9 = i1111110;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1555720195, i9, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:146)");
                }
                float f11 = ExtendedFabSize;
                Modifier modifierM536sizeInqDBjuR0$default11 = SizeKt.m536sizeInqDBjuR0$default(modifier4, f11, f11, 0.0f, 0.0f, 12, null);
                ComposableLambda composableLambda11 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$2(interfaceC0526Fp5, i9, interfaceC0526Fp));
                int i1111111 = ((i9 >> 3) & 14) | 12582912;
                int i1111112 = i9 >> 6;
                InterfaceC0526Fp interfaceC0526Fp17 = interfaceC0526Fp5;
                m1137FloatingActionButtonbogVsAg(interfaceC3588op, modifierM536sizeInqDBjuR0$default11, mutableInteractionSource4, shape2, j4, j5, floatingActionButtonElevation2, composableLambda11, composerStartRestartGroup, (i1111112 & 896) | i1111111 | (i1111112 & 7168) | (57344 & i1111112) | (458752 & i1111112) | (i1111112 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                interfaceC0526Fp6 = interfaceC0526Fp17;
                mutableInteractionSource5 = mutableInteractionSource4;
                shape3 = shape2;
                j6 = j4;
                j7 = j5;
                floatingActionButtonElevation3 = floatingActionButtonElevation2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$ExtendedFloatingActionButton$3(interfaceC0526Fp, interfaceC3588op, modifier5, interfaceC0526Fp6, mutableInteractionSource5, shape3, j6, j7, floatingActionButtonElevation3, i, i2));
        }
        i3 |= 3072;
        interfaceC0526Fp3 = interfaceC0526Fp2;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 57344) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((i & 458752) != 0) {
                i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
            }
            if ((i & 3670016) == 0) {
                j3 = j;
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            } else {
                j3 = j;
            }
            if ((i & 29360128) == 0) {
                int i1111113 = i3;
                if ((i2 & 128) == 0) {
                    i10 = 4194304;
                } else {
                    i10 = 4194304;
                }
                i8 = i1111113 | i10;
            } else {
                i8 = i3;
            }
            if ((i & 234881024) == 0) {
                if ((i2 & 256) == 0) {
                    floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation;
                    if (composerStartRestartGroup.changed(floatingActionButtonElevationM1135elevationxZ9QkE)) {
                    }
                    i8 |= i14;
                } else {
                    floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation;
                }
                i8 |= i14;
            } else {
                floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation;
            }
            if ((i8 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i8 &= -458753;
                    } else {
                        shapeCopy = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                        i8 &= -3670017;
                    } else {
                        jM1053getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                        i8 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i8 &= -234881025;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape2 = shapeCopy;
                    j4 = jM1053getSecondary0d7_KjU;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                    j5 = jM1069contentColorForek8zF_U;
                    int i1111114 = i8;
                    modifier4 = modifier3;
                    i9 = i1111114;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i8 &= -458753;
                    } else {
                        shapeCopy = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                        i8 &= -3670017;
                    } else {
                        jM1053getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                        i8 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i8 &= -234881025;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape2 = shapeCopy;
                    j4 = jM1053getSecondary0d7_KjU;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                    j5 = jM1069contentColorForek8zF_U;
                    int i1111115 = i8;
                    modifier4 = modifier3;
                    i9 = i1111115;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1555720195, i9, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:146)");
                }
                float f12 = ExtendedFabSize;
                Modifier modifierM536sizeInqDBjuR0$default12 = SizeKt.m536sizeInqDBjuR0$default(modifier4, f12, f12, 0.0f, 0.0f, 12, null);
                ComposableLambda composableLambda12 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$2(interfaceC0526Fp5, i9, interfaceC0526Fp));
                int i1111116 = ((i9 >> 3) & 14) | 12582912;
                int i1111117 = i9 >> 6;
                InterfaceC0526Fp interfaceC0526Fp18 = interfaceC0526Fp5;
                m1137FloatingActionButtonbogVsAg(interfaceC3588op, modifierM536sizeInqDBjuR0$default12, mutableInteractionSource4, shape2, j4, j5, floatingActionButtonElevation2, composableLambda12, composerStartRestartGroup, (i1111117 & 896) | i1111116 | (i1111117 & 7168) | (57344 & i1111117) | (458752 & i1111117) | (i1111117 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                interfaceC0526Fp6 = interfaceC0526Fp18;
                mutableInteractionSource5 = mutableInteractionSource4;
                shape3 = shape2;
                j6 = j4;
                j7 = j5;
                floatingActionButtonElevation3 = floatingActionButtonElevation2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i8 &= -458753;
                    } else {
                        shapeCopy = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                        i8 &= -3670017;
                    } else {
                        jM1053getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                        i8 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i8 &= -234881025;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape2 = shapeCopy;
                    j4 = jM1053getSecondary0d7_KjU;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                    j5 = jM1069contentColorForek8zF_U;
                    int i1111118 = i8;
                    modifier4 = modifier3;
                    i9 = i1111118;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i8 &= -458753;
                    } else {
                        shapeCopy = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                        i8 &= -3670017;
                    } else {
                        jM1053getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                        i8 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i8 &= -234881025;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape2 = shapeCopy;
                    j4 = jM1053getSecondary0d7_KjU;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                    j5 = jM1069contentColorForek8zF_U;
                    int i1111119 = i8;
                    modifier4 = modifier3;
                    i9 = i1111119;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1555720195, i9, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:146)");
                }
                float f13 = ExtendedFabSize;
                Modifier modifierM536sizeInqDBjuR0$default13 = SizeKt.m536sizeInqDBjuR0$default(modifier4, f13, f13, 0.0f, 0.0f, 12, null);
                ComposableLambda composableLambda13 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$2(interfaceC0526Fp5, i9, interfaceC0526Fp));
                int i11111110 = ((i9 >> 3) & 14) | 12582912;
                int i11111111 = i9 >> 6;
                InterfaceC0526Fp interfaceC0526Fp19 = interfaceC0526Fp5;
                m1137FloatingActionButtonbogVsAg(interfaceC3588op, modifierM536sizeInqDBjuR0$default13, mutableInteractionSource4, shape2, j4, j5, floatingActionButtonElevation2, composableLambda13, composerStartRestartGroup, (i11111111 & 896) | i11111110 | (i11111111 & 7168) | (57344 & i11111111) | (458752 & i11111111) | (i11111111 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                interfaceC0526Fp6 = interfaceC0526Fp19;
                mutableInteractionSource5 = mutableInteractionSource4;
                shape3 = shape2;
                j6 = j4;
                j7 = j5;
                floatingActionButtonElevation3 = floatingActionButtonElevation2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$ExtendedFloatingActionButton$3(interfaceC0526Fp, interfaceC3588op, modifier5, interfaceC0526Fp6, mutableInteractionSource5, shape3, j6, j7, floatingActionButtonElevation3, i, i2));
        }
        i3 |= 24576;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i & 458752) != 0) {
            i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
        }
        if ((i & 3670016) == 0) {
            j3 = j;
            if ((i2 & 64) == 0) {
                i11 = 524288;
            } else {
                i11 = 524288;
            }
            i3 |= i11;
        } else {
            j3 = j;
        }
        if ((i & 29360128) == 0) {
            int i11111112 = i3;
            if ((i2 & 128) == 0) {
                i10 = 4194304;
            } else {
                i10 = 4194304;
            }
            i8 = i11111112 | i10;
        } else {
            i8 = i3;
        }
        if ((i & 234881024) == 0) {
            if ((i2 & 256) == 0) {
                floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation;
                if (composerStartRestartGroup.changed(floatingActionButtonElevationM1135elevationxZ9QkE)) {
                }
                i8 |= i14;
            } else {
                floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation;
            }
            i8 |= i14;
        } else {
            floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation;
        }
        if ((i8 & 191739611) == 38347922) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp3;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                if ((i2 & 32) != 0) {
                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    i8 &= -458753;
                } else {
                    shapeCopy = shape;
                }
                if ((i2 & 64) != 0) {
                    jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                    i8 &= -3670017;
                } else {
                    jM1053getSecondary0d7_KjU = j3;
                }
                if ((i2 & 128) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                    i8 &= -29360129;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if ((i2 & 256) != 0) {
                    floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i8 &= -234881025;
                }
                interfaceC0526Fp5 = interfaceC0526Fp4;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape2 = shapeCopy;
                j4 = jM1053getSecondary0d7_KjU;
                floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                j5 = jM1069contentColorForek8zF_U;
                int i11111113 = i8;
                modifier4 = modifier3;
                i9 = i11111113;
            } else {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp3;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                if ((i2 & 32) != 0) {
                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    i8 &= -458753;
                } else {
                    shapeCopy = shape;
                }
                if ((i2 & 64) != 0) {
                    jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                    i8 &= -3670017;
                } else {
                    jM1053getSecondary0d7_KjU = j3;
                }
                if ((i2 & 128) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                    i8 &= -29360129;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if ((i2 & 256) != 0) {
                    floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i8 &= -234881025;
                }
                interfaceC0526Fp5 = interfaceC0526Fp4;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape2 = shapeCopy;
                j4 = jM1053getSecondary0d7_KjU;
                floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                j5 = jM1069contentColorForek8zF_U;
                int i11111114 = i8;
                modifier4 = modifier3;
                i9 = i11111114;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1555720195, i9, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:146)");
            }
            float f14 = ExtendedFabSize;
            Modifier modifierM536sizeInqDBjuR0$default14 = SizeKt.m536sizeInqDBjuR0$default(modifier4, f14, f14, 0.0f, 0.0f, 12, null);
            ComposableLambda composableLambda14 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$2(interfaceC0526Fp5, i9, interfaceC0526Fp));
            int i11111115 = ((i9 >> 3) & 14) | 12582912;
            int i11111116 = i9 >> 6;
            InterfaceC0526Fp interfaceC0526Fp110 = interfaceC0526Fp5;
            m1137FloatingActionButtonbogVsAg(interfaceC3588op, modifierM536sizeInqDBjuR0$default14, mutableInteractionSource4, shape2, j4, j5, floatingActionButtonElevation2, composableLambda14, composerStartRestartGroup, (i11111116 & 896) | i11111115 | (i11111116 & 7168) | (57344 & i11111116) | (458752 & i11111116) | (i11111116 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            interfaceC0526Fp6 = interfaceC0526Fp110;
            mutableInteractionSource5 = mutableInteractionSource4;
            shape3 = shape2;
            j6 = j4;
            j7 = j5;
            floatingActionButtonElevation3 = floatingActionButtonElevation2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp3;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                if ((i2 & 32) != 0) {
                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    i8 &= -458753;
                } else {
                    shapeCopy = shape;
                }
                if ((i2 & 64) != 0) {
                    jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                    i8 &= -3670017;
                } else {
                    jM1053getSecondary0d7_KjU = j3;
                }
                if ((i2 & 128) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                    i8 &= -29360129;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if ((i2 & 256) != 0) {
                    floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i8 &= -234881025;
                }
                interfaceC0526Fp5 = interfaceC0526Fp4;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape2 = shapeCopy;
                j4 = jM1053getSecondary0d7_KjU;
                floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                j5 = jM1069contentColorForek8zF_U;
                int i11111117 = i8;
                modifier4 = modifier3;
                i9 = i11111117;
            } else {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp3;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                if ((i2 & 32) != 0) {
                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    i8 &= -458753;
                } else {
                    shapeCopy = shape;
                }
                if ((i2 & 64) != 0) {
                    jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                    i8 &= -3670017;
                } else {
                    jM1053getSecondary0d7_KjU = j3;
                }
                if ((i2 & 128) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                    i8 &= -29360129;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if ((i2 & 256) != 0) {
                    floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i8 &= -234881025;
                }
                interfaceC0526Fp5 = interfaceC0526Fp4;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape2 = shapeCopy;
                j4 = jM1053getSecondary0d7_KjU;
                floatingActionButtonElevation2 = floatingActionButtonElevationM1135elevationxZ9QkE;
                j5 = jM1069contentColorForek8zF_U;
                int i11111118 = i8;
                modifier4 = modifier3;
                i9 = i11111118;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1555720195, i9, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:146)");
            }
            float f15 = ExtendedFabSize;
            Modifier modifierM536sizeInqDBjuR0$default15 = SizeKt.m536sizeInqDBjuR0$default(modifier4, f15, f15, 0.0f, 0.0f, 12, null);
            ComposableLambda composableLambda15 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$2(interfaceC0526Fp5, i9, interfaceC0526Fp));
            int i11111119 = ((i9 >> 3) & 14) | 12582912;
            int i111111110 = i9 >> 6;
            InterfaceC0526Fp interfaceC0526Fp111 = interfaceC0526Fp5;
            m1137FloatingActionButtonbogVsAg(interfaceC3588op, modifierM536sizeInqDBjuR0$default15, mutableInteractionSource4, shape2, j4, j5, floatingActionButtonElevation2, composableLambda15, composerStartRestartGroup, (i111111110 & 896) | i11111119 | (i111111110 & 7168) | (57344 & i111111110) | (458752 & i111111110) | (i111111110 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            interfaceC0526Fp6 = interfaceC0526Fp111;
            mutableInteractionSource5 = mutableInteractionSource4;
            shape3 = shape2;
            j6 = j4;
            j7 = j5;
            floatingActionButtonElevation3 = floatingActionButtonElevation2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$ExtendedFloatingActionButton$3(interfaceC0526Fp, interfaceC3588op, modifier5, interfaceC0526Fp6, mutableInteractionSource5, shape3, j6, j7, floatingActionButtonElevation3, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:113:0x0149 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:114:0x014b  */
    /* JADX WARN: Code duplicated, block: B:116:0x0150  */
    /* JADX WARN: Code duplicated, block: B:118:0x0162  */
    /* JADX WARN: Code duplicated, block: B:122:0x0174  */
    /* JADX WARN: Code duplicated, block: B:125:0x018f  */
    /* JADX WARN: Code duplicated, block: B:126:0x019f  */
    /* JADX WARN: Code duplicated, block: B:129:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:132:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:133:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:136:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:139:0x026a  */
    /* JADX WARN: Code duplicated, block: B:144:0x0280  */
    /* JADX WARN: Code duplicated, block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:33:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x008a  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0099 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:56:0x009f  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:80:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:86:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:87:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:94:0x010e  */
    /* JADX WARN: Code duplicated, block: B:96:0x011e  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: FloatingActionButton-bogVsAg, reason: not valid java name */
    public static final void m1137FloatingActionButtonbogVsAg(InterfaceC3588op interfaceC3588op, Modifier modifier, MutableInteractionSource mutableInteractionSource, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        MutableInteractionSource mutableInteractionSource2;
        int i5;
        Shape shapeCopy;
        long jM1069contentColorForek8zF_U;
        FloatingActionButtonElevation floatingActionButtonElevation2;
        int i6;
        int i7;
        long jM1053getSecondary0d7_KjU;
        long j3;
        Modifier modifier3;
        MutableInteractionSource mutableInteractionSource3;
        Shape shape2;
        long j4;
        FloatingActionButtonElevation floatingActionButtonElevationM1135elevationxZ9QkE;
        Object objRememberedValue;
        Composer composer2;
        Modifier modifier4;
        Shape shape3;
        long j5;
        MutableInteractionSource mutableInteractionSource4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(1028985328);
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
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        shapeCopy = shape;
                        int i10 = composerStartRestartGroup.changed(shapeCopy) ? 2048 : 1024;
                        i3 |= i10;
                    } else {
                        shapeCopy = shape;
                    }
                    i3 |= i10;
                } else {
                    shapeCopy = shape;
                }
                if ((i & 57344) != 0) {
                    i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changed(j)) ? 8192 : 16384;
                }
                if ((i & 458752) == 0) {
                    jM1069contentColorForek8zF_U = j2;
                    if ((i2 & 32) == 0 || !composerStartRestartGroup.changed(jM1069contentColorForek8zF_U)) {
                        i8 = 65536;
                    } else {
                        i8 = 131072;
                    }
                    i3 |= i8;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if ((3670016 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                        int i11 = composerStartRestartGroup.changed(floatingActionButtonElevation2) ? 1048576 : 524288;
                        i3 |= i11;
                    } else {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                    }
                    i3 |= i11;
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
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
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            }
                            if ((i2 & 16) != 0) {
                                i7 = i3 & (-57345);
                                jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                            } else {
                                i7 = i3;
                                jM1053getSecondary0d7_KjU = j;
                            }
                            if ((i2 & 32) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                                i7 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                j3 = jM1053getSecondary0d7_KjU;
                                i3 = i7 & (-3670017);
                                modifier3 = modifier2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                shape2 = shapeCopy;
                                j4 = jM1069contentColorForek8zF_U;
                                floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            } else {
                                j3 = jM1053getSecondary0d7_KjU;
                                i3 = i7;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1028985328, i3, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:81)");
                            }
                            long j6 = j4;
                            FloatingActionButtonElevation floatingActionButtonElevation3 = floatingActionButtonElevationM1135elevationxZ9QkE;
                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                            Modifier modifier5 = modifier3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, FloatingActionButtonKt$FloatingActionButton$2.INSTANCE, 1, null), false, shape2, j3, j4, null, floatingActionButtonElevationM1135elevationxZ9QkE.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m5174unboximpl(), mutableInteractionSource5, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new FloatingActionButtonKt$FloatingActionButton$3(j4, interfaceC0526Fp, i3)), composer2, (i3 & 14) | 805306368 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier5;
                            shape3 = shape2;
                            j5 = j3;
                            mutableInteractionSource4 = mutableInteractionSource5;
                            jM1069contentColorForek8zF_U = j6;
                            floatingActionButtonElevation2 = floatingActionButtonElevation3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                            j3 = j;
                        }
                        modifier3 = modifier2;
                        shape2 = shapeCopy;
                        j4 = jM1069contentColorForek8zF_U;
                        floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1028985328, i3, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:81)");
                        }
                        long j7 = j4;
                        FloatingActionButtonElevation floatingActionButtonElevation4 = floatingActionButtonElevationM1135elevationxZ9QkE;
                        MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource3;
                        Modifier modifier6 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, FloatingActionButtonKt$FloatingActionButton$2.INSTANCE, 1, null), false, shape2, j3, j4, null, floatingActionButtonElevationM1135elevationxZ9QkE.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m5174unboximpl(), mutableInteractionSource6, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new FloatingActionButtonKt$FloatingActionButton$3(j4, interfaceC0526Fp, i3)), composer2, (i3 & 14) | 805306368 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier6;
                        shape3 = shape2;
                        j5 = j3;
                        mutableInteractionSource4 = mutableInteractionSource6;
                        jM1069contentColorForek8zF_U = j7;
                        floatingActionButtonElevation2 = floatingActionButtonElevation4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier4 = modifier2;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        shape3 = shapeCopy;
                        composer2 = composerStartRestartGroup;
                        j5 = j;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$FloatingActionButton$4(interfaceC3588op, modifier4, mutableInteractionSource4, shape3, j5, jM1069contentColorForek8zF_U, floatingActionButtonElevation2, interfaceC0526Fp, i, i2));
                }
                i6 = 12582912;
                i3 |= i6;
                if ((23967451 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = Modifier.Companion;
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
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        }
                        if ((i2 & 16) != 0) {
                            i7 = i3 & (-57345);
                            jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                        } else {
                            i7 = i3;
                            jM1053getSecondary0d7_KjU = j;
                        }
                        if ((i2 & 32) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                            i7 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            j3 = jM1053getSecondary0d7_KjU;
                            i3 = i7 & (-3670017);
                            modifier3 = modifier2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = shapeCopy;
                            j4 = jM1069contentColorForek8zF_U;
                            floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        } else {
                            j3 = jM1053getSecondary0d7_KjU;
                            i3 = i7;
                            modifier3 = modifier2;
                            shape2 = shapeCopy;
                            j4 = jM1069contentColorForek8zF_U;
                            floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.Companion;
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
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        }
                        if ((i2 & 16) != 0) {
                            i7 = i3 & (-57345);
                            jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                        } else {
                            i7 = i3;
                            jM1053getSecondary0d7_KjU = j;
                        }
                        if ((i2 & 32) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                            i7 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            j3 = jM1053getSecondary0d7_KjU;
                            i3 = i7 & (-3670017);
                            modifier3 = modifier2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = shapeCopy;
                            j4 = jM1069contentColorForek8zF_U;
                            floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        } else {
                            j3 = jM1053getSecondary0d7_KjU;
                            i3 = i7;
                            modifier3 = modifier2;
                            shape2 = shapeCopy;
                            j4 = jM1069contentColorForek8zF_U;
                            floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1028985328, i3, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:81)");
                    }
                    long j8 = j4;
                    FloatingActionButtonElevation floatingActionButtonElevation5 = floatingActionButtonElevationM1135elevationxZ9QkE;
                    MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource3;
                    Modifier modifier7 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, FloatingActionButtonKt$FloatingActionButton$2.INSTANCE, 1, null), false, shape2, j3, j4, null, floatingActionButtonElevationM1135elevationxZ9QkE.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m5174unboximpl(), mutableInteractionSource7, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new FloatingActionButtonKt$FloatingActionButton$3(j4, interfaceC0526Fp, i3)), composer2, (i3 & 14) | 805306368 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier7;
                    shape3 = shape2;
                    j5 = j3;
                    mutableInteractionSource4 = mutableInteractionSource7;
                    jM1069contentColorForek8zF_U = j8;
                    floatingActionButtonElevation2 = floatingActionButtonElevation5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = Modifier.Companion;
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
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        }
                        if ((i2 & 16) != 0) {
                            i7 = i3 & (-57345);
                            jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                        } else {
                            i7 = i3;
                            jM1053getSecondary0d7_KjU = j;
                        }
                        if ((i2 & 32) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                            i7 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            j3 = jM1053getSecondary0d7_KjU;
                            i3 = i7 & (-3670017);
                            modifier3 = modifier2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = shapeCopy;
                            j4 = jM1069contentColorForek8zF_U;
                            floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        } else {
                            j3 = jM1053getSecondary0d7_KjU;
                            i3 = i7;
                            modifier3 = modifier2;
                            shape2 = shapeCopy;
                            j4 = jM1069contentColorForek8zF_U;
                            floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.Companion;
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
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        }
                        if ((i2 & 16) != 0) {
                            i7 = i3 & (-57345);
                            jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                        } else {
                            i7 = i3;
                            jM1053getSecondary0d7_KjU = j;
                        }
                        if ((i2 & 32) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                            i7 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            j3 = jM1053getSecondary0d7_KjU;
                            i3 = i7 & (-3670017);
                            modifier3 = modifier2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = shapeCopy;
                            j4 = jM1069contentColorForek8zF_U;
                            floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        } else {
                            j3 = jM1053getSecondary0d7_KjU;
                            i3 = i7;
                            modifier3 = modifier2;
                            shape2 = shapeCopy;
                            j4 = jM1069contentColorForek8zF_U;
                            floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1028985328, i3, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:81)");
                    }
                    long j9 = j4;
                    FloatingActionButtonElevation floatingActionButtonElevation6 = floatingActionButtonElevationM1135elevationxZ9QkE;
                    MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource3;
                    Modifier modifier8 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, FloatingActionButtonKt$FloatingActionButton$2.INSTANCE, 1, null), false, shape2, j3, j4, null, floatingActionButtonElevationM1135elevationxZ9QkE.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m5174unboximpl(), mutableInteractionSource8, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new FloatingActionButtonKt$FloatingActionButton$3(j4, interfaceC0526Fp, i3)), composer2, (i3 & 14) | 805306368 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier8;
                    shape3 = shape2;
                    j5 = j3;
                    mutableInteractionSource4 = mutableInteractionSource8;
                    jM1069contentColorForek8zF_U = j9;
                    floatingActionButtonElevation2 = floatingActionButtonElevation6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$FloatingActionButton$4(interfaceC3588op, modifier4, mutableInteractionSource4, shape3, j5, jM1069contentColorForek8zF_U, floatingActionButtonElevation2, interfaceC0526Fp, i, i2));
            }
            i3 |= 384;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    shapeCopy = shape;
                    if (composerStartRestartGroup.changed(shapeCopy)) {
                    }
                    i3 |= i10;
                } else {
                    shapeCopy = shape;
                }
                i3 |= i10;
            } else {
                shapeCopy = shape;
            }
            if ((i & 57344) != 0) {
                i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changed(j)) ? 8192 : 16384;
            }
            if ((i & 458752) == 0) {
                jM1069contentColorForek8zF_U = j2;
                if ((i2 & 32) == 0) {
                    i8 = 65536;
                } else {
                    i8 = 65536;
                }
                i3 |= i8;
            } else {
                jM1069contentColorForek8zF_U = j2;
            }
            if ((3670016 & i) == 0) {
                if ((i2 & 64) == 0) {
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
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        }
                        if ((i2 & 16) != 0) {
                            i7 = i3 & (-57345);
                            jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                        } else {
                            i7 = i3;
                            jM1053getSecondary0d7_KjU = j;
                        }
                        if ((i2 & 32) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                            i7 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            j3 = jM1053getSecondary0d7_KjU;
                            i3 = i7 & (-3670017);
                            modifier3 = modifier2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = shapeCopy;
                            j4 = jM1069contentColorForek8zF_U;
                            floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        } else {
                            j3 = jM1053getSecondary0d7_KjU;
                            i3 = i7;
                            modifier3 = modifier2;
                            shape2 = shapeCopy;
                            j4 = jM1069contentColorForek8zF_U;
                            floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.Companion;
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
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        }
                        if ((i2 & 16) != 0) {
                            i7 = i3 & (-57345);
                            jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                        } else {
                            i7 = i3;
                            jM1053getSecondary0d7_KjU = j;
                        }
                        if ((i2 & 32) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                            i7 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            j3 = jM1053getSecondary0d7_KjU;
                            i3 = i7 & (-3670017);
                            modifier3 = modifier2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = shapeCopy;
                            j4 = jM1069contentColorForek8zF_U;
                            floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        } else {
                            j3 = jM1053getSecondary0d7_KjU;
                            i3 = i7;
                            modifier3 = modifier2;
                            shape2 = shapeCopy;
                            j4 = jM1069contentColorForek8zF_U;
                            floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1028985328, i3, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:81)");
                    }
                    long j10 = j4;
                    FloatingActionButtonElevation floatingActionButtonElevation7 = floatingActionButtonElevationM1135elevationxZ9QkE;
                    MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource3;
                    Modifier modifier9 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, FloatingActionButtonKt$FloatingActionButton$2.INSTANCE, 1, null), false, shape2, j3, j4, null, floatingActionButtonElevationM1135elevationxZ9QkE.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m5174unboximpl(), mutableInteractionSource9, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new FloatingActionButtonKt$FloatingActionButton$3(j4, interfaceC0526Fp, i3)), composer2, (i3 & 14) | 805306368 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier9;
                    shape3 = shape2;
                    j5 = j3;
                    mutableInteractionSource4 = mutableInteractionSource9;
                    jM1069contentColorForek8zF_U = j10;
                    floatingActionButtonElevation2 = floatingActionButtonElevation7;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = Modifier.Companion;
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
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        }
                        if ((i2 & 16) != 0) {
                            i7 = i3 & (-57345);
                            jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                        } else {
                            i7 = i3;
                            jM1053getSecondary0d7_KjU = j;
                        }
                        if ((i2 & 32) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                            i7 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            j3 = jM1053getSecondary0d7_KjU;
                            i3 = i7 & (-3670017);
                            modifier3 = modifier2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = shapeCopy;
                            j4 = jM1069contentColorForek8zF_U;
                            floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        } else {
                            j3 = jM1053getSecondary0d7_KjU;
                            i3 = i7;
                            modifier3 = modifier2;
                            shape2 = shapeCopy;
                            j4 = jM1069contentColorForek8zF_U;
                            floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.Companion;
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
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        }
                        if ((i2 & 16) != 0) {
                            i7 = i3 & (-57345);
                            jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                        } else {
                            i7 = i3;
                            jM1053getSecondary0d7_KjU = j;
                        }
                        if ((i2 & 32) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                            i7 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            j3 = jM1053getSecondary0d7_KjU;
                            i3 = i7 & (-3670017);
                            modifier3 = modifier2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = shapeCopy;
                            j4 = jM1069contentColorForek8zF_U;
                            floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        } else {
                            j3 = jM1053getSecondary0d7_KjU;
                            i3 = i7;
                            modifier3 = modifier2;
                            shape2 = shapeCopy;
                            j4 = jM1069contentColorForek8zF_U;
                            floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1028985328, i3, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:81)");
                    }
                    long j11 = j4;
                    FloatingActionButtonElevation floatingActionButtonElevation8 = floatingActionButtonElevationM1135elevationxZ9QkE;
                    MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource3;
                    Modifier modifier10 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, FloatingActionButtonKt$FloatingActionButton$2.INSTANCE, 1, null), false, shape2, j3, j4, null, floatingActionButtonElevationM1135elevationxZ9QkE.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m5174unboximpl(), mutableInteractionSource10, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new FloatingActionButtonKt$FloatingActionButton$3(j4, interfaceC0526Fp, i3)), composer2, (i3 & 14) | 805306368 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier10;
                    shape3 = shape2;
                    j5 = j3;
                    mutableInteractionSource4 = mutableInteractionSource10;
                    jM1069contentColorForek8zF_U = j11;
                    floatingActionButtonElevation2 = floatingActionButtonElevation8;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$FloatingActionButton$4(interfaceC3588op, modifier4, mutableInteractionSource4, shape3, j5, jM1069contentColorForek8zF_U, floatingActionButtonElevation2, interfaceC0526Fp, i, i2));
            }
            i6 = 12582912;
            i3 |= i6;
            if ((23967451 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
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
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                    } else {
                        i7 = i3;
                        jM1053getSecondary0d7_KjU = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                        i7 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        j3 = jM1053getSecondary0d7_KjU;
                        i3 = i7 & (-3670017);
                        modifier3 = modifier2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = shapeCopy;
                        j4 = jM1069contentColorForek8zF_U;
                        floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    } else {
                        j3 = jM1053getSecondary0d7_KjU;
                        i3 = i7;
                        modifier3 = modifier2;
                        shape2 = shapeCopy;
                        j4 = jM1069contentColorForek8zF_U;
                        floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
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
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                    } else {
                        i7 = i3;
                        jM1053getSecondary0d7_KjU = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                        i7 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        j3 = jM1053getSecondary0d7_KjU;
                        i3 = i7 & (-3670017);
                        modifier3 = modifier2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = shapeCopy;
                        j4 = jM1069contentColorForek8zF_U;
                        floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    } else {
                        j3 = jM1053getSecondary0d7_KjU;
                        i3 = i7;
                        modifier3 = modifier2;
                        shape2 = shapeCopy;
                        j4 = jM1069contentColorForek8zF_U;
                        floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1028985328, i3, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:81)");
                }
                long j12 = j4;
                FloatingActionButtonElevation floatingActionButtonElevation9 = floatingActionButtonElevationM1135elevationxZ9QkE;
                MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource3;
                Modifier modifier11 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, FloatingActionButtonKt$FloatingActionButton$2.INSTANCE, 1, null), false, shape2, j3, j4, null, floatingActionButtonElevationM1135elevationxZ9QkE.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m5174unboximpl(), mutableInteractionSource11, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new FloatingActionButtonKt$FloatingActionButton$3(j4, interfaceC0526Fp, i3)), composer2, (i3 & 14) | 805306368 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier11;
                shape3 = shape2;
                j5 = j3;
                mutableInteractionSource4 = mutableInteractionSource11;
                jM1069contentColorForek8zF_U = j12;
                floatingActionButtonElevation2 = floatingActionButtonElevation9;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
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
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                    } else {
                        i7 = i3;
                        jM1053getSecondary0d7_KjU = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                        i7 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        j3 = jM1053getSecondary0d7_KjU;
                        i3 = i7 & (-3670017);
                        modifier3 = modifier2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = shapeCopy;
                        j4 = jM1069contentColorForek8zF_U;
                        floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    } else {
                        j3 = jM1053getSecondary0d7_KjU;
                        i3 = i7;
                        modifier3 = modifier2;
                        shape2 = shapeCopy;
                        j4 = jM1069contentColorForek8zF_U;
                        floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
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
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                    } else {
                        i7 = i3;
                        jM1053getSecondary0d7_KjU = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                        i7 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        j3 = jM1053getSecondary0d7_KjU;
                        i3 = i7 & (-3670017);
                        modifier3 = modifier2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = shapeCopy;
                        j4 = jM1069contentColorForek8zF_U;
                        floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    } else {
                        j3 = jM1053getSecondary0d7_KjU;
                        i3 = i7;
                        modifier3 = modifier2;
                        shape2 = shapeCopy;
                        j4 = jM1069contentColorForek8zF_U;
                        floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1028985328, i3, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:81)");
                }
                long j13 = j4;
                FloatingActionButtonElevation floatingActionButtonElevation10 = floatingActionButtonElevationM1135elevationxZ9QkE;
                MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource3;
                Modifier modifier12 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, FloatingActionButtonKt$FloatingActionButton$2.INSTANCE, 1, null), false, shape2, j3, j4, null, floatingActionButtonElevationM1135elevationxZ9QkE.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m5174unboximpl(), mutableInteractionSource12, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new FloatingActionButtonKt$FloatingActionButton$3(j4, interfaceC0526Fp, i3)), composer2, (i3 & 14) | 805306368 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier12;
                shape3 = shape2;
                j5 = j3;
                mutableInteractionSource4 = mutableInteractionSource12;
                jM1069contentColorForek8zF_U = j13;
                floatingActionButtonElevation2 = floatingActionButtonElevation10;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$FloatingActionButton$4(interfaceC3588op, modifier4, mutableInteractionSource4, shape3, j5, jM1069contentColorForek8zF_U, floatingActionButtonElevation2, interfaceC0526Fp, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    shapeCopy = shape;
                    if (composerStartRestartGroup.changed(shapeCopy)) {
                    }
                    i3 |= i10;
                } else {
                    shapeCopy = shape;
                }
                i3 |= i10;
            } else {
                shapeCopy = shape;
            }
            if ((i & 57344) != 0) {
                i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changed(j)) ? 8192 : 16384;
            }
            if ((i & 458752) == 0) {
                jM1069contentColorForek8zF_U = j2;
                if ((i2 & 32) == 0) {
                    i8 = 65536;
                } else {
                    i8 = 65536;
                }
                i3 |= i8;
            } else {
                jM1069contentColorForek8zF_U = j2;
            }
            if ((3670016 & i) == 0) {
                if ((i2 & 64) == 0) {
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
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        }
                        if ((i2 & 16) != 0) {
                            i7 = i3 & (-57345);
                            jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                        } else {
                            i7 = i3;
                            jM1053getSecondary0d7_KjU = j;
                        }
                        if ((i2 & 32) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                            i7 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            j3 = jM1053getSecondary0d7_KjU;
                            i3 = i7 & (-3670017);
                            modifier3 = modifier2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = shapeCopy;
                            j4 = jM1069contentColorForek8zF_U;
                            floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        } else {
                            j3 = jM1053getSecondary0d7_KjU;
                            i3 = i7;
                            modifier3 = modifier2;
                            shape2 = shapeCopy;
                            j4 = jM1069contentColorForek8zF_U;
                            floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.Companion;
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
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        }
                        if ((i2 & 16) != 0) {
                            i7 = i3 & (-57345);
                            jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                        } else {
                            i7 = i3;
                            jM1053getSecondary0d7_KjU = j;
                        }
                        if ((i2 & 32) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                            i7 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            j3 = jM1053getSecondary0d7_KjU;
                            i3 = i7 & (-3670017);
                            modifier3 = modifier2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = shapeCopy;
                            j4 = jM1069contentColorForek8zF_U;
                            floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        } else {
                            j3 = jM1053getSecondary0d7_KjU;
                            i3 = i7;
                            modifier3 = modifier2;
                            shape2 = shapeCopy;
                            j4 = jM1069contentColorForek8zF_U;
                            floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1028985328, i3, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:81)");
                    }
                    long j14 = j4;
                    FloatingActionButtonElevation floatingActionButtonElevation11 = floatingActionButtonElevationM1135elevationxZ9QkE;
                    MutableInteractionSource mutableInteractionSource13 = mutableInteractionSource3;
                    Modifier modifier13 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, FloatingActionButtonKt$FloatingActionButton$2.INSTANCE, 1, null), false, shape2, j3, j4, null, floatingActionButtonElevationM1135elevationxZ9QkE.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m5174unboximpl(), mutableInteractionSource13, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new FloatingActionButtonKt$FloatingActionButton$3(j4, interfaceC0526Fp, i3)), composer2, (i3 & 14) | 805306368 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier13;
                    shape3 = shape2;
                    j5 = j3;
                    mutableInteractionSource4 = mutableInteractionSource13;
                    jM1069contentColorForek8zF_U = j14;
                    floatingActionButtonElevation2 = floatingActionButtonElevation11;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = Modifier.Companion;
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
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        }
                        if ((i2 & 16) != 0) {
                            i7 = i3 & (-57345);
                            jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                        } else {
                            i7 = i3;
                            jM1053getSecondary0d7_KjU = j;
                        }
                        if ((i2 & 32) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                            i7 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            j3 = jM1053getSecondary0d7_KjU;
                            i3 = i7 & (-3670017);
                            modifier3 = modifier2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = shapeCopy;
                            j4 = jM1069contentColorForek8zF_U;
                            floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        } else {
                            j3 = jM1053getSecondary0d7_KjU;
                            i3 = i7;
                            modifier3 = modifier2;
                            shape2 = shapeCopy;
                            j4 = jM1069contentColorForek8zF_U;
                            floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.Companion;
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
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        }
                        if ((i2 & 16) != 0) {
                            i7 = i3 & (-57345);
                            jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                        } else {
                            i7 = i3;
                            jM1053getSecondary0d7_KjU = j;
                        }
                        if ((i2 & 32) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                            i7 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            j3 = jM1053getSecondary0d7_KjU;
                            i3 = i7 & (-3670017);
                            modifier3 = modifier2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = shapeCopy;
                            j4 = jM1069contentColorForek8zF_U;
                            floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        } else {
                            j3 = jM1053getSecondary0d7_KjU;
                            i3 = i7;
                            modifier3 = modifier2;
                            shape2 = shapeCopy;
                            j4 = jM1069contentColorForek8zF_U;
                            floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1028985328, i3, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:81)");
                    }
                    long j15 = j4;
                    FloatingActionButtonElevation floatingActionButtonElevation12 = floatingActionButtonElevationM1135elevationxZ9QkE;
                    MutableInteractionSource mutableInteractionSource14 = mutableInteractionSource3;
                    Modifier modifier14 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, FloatingActionButtonKt$FloatingActionButton$2.INSTANCE, 1, null), false, shape2, j3, j4, null, floatingActionButtonElevationM1135elevationxZ9QkE.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m5174unboximpl(), mutableInteractionSource14, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new FloatingActionButtonKt$FloatingActionButton$3(j4, interfaceC0526Fp, i3)), composer2, (i3 & 14) | 805306368 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier14;
                    shape3 = shape2;
                    j5 = j3;
                    mutableInteractionSource4 = mutableInteractionSource14;
                    jM1069contentColorForek8zF_U = j15;
                    floatingActionButtonElevation2 = floatingActionButtonElevation12;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$FloatingActionButton$4(interfaceC3588op, modifier4, mutableInteractionSource4, shape3, j5, jM1069contentColorForek8zF_U, floatingActionButtonElevation2, interfaceC0526Fp, i, i2));
            }
            i6 = 12582912;
            i3 |= i6;
            if ((23967451 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
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
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                    } else {
                        i7 = i3;
                        jM1053getSecondary0d7_KjU = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                        i7 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        j3 = jM1053getSecondary0d7_KjU;
                        i3 = i7 & (-3670017);
                        modifier3 = modifier2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = shapeCopy;
                        j4 = jM1069contentColorForek8zF_U;
                        floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    } else {
                        j3 = jM1053getSecondary0d7_KjU;
                        i3 = i7;
                        modifier3 = modifier2;
                        shape2 = shapeCopy;
                        j4 = jM1069contentColorForek8zF_U;
                        floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
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
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                    } else {
                        i7 = i3;
                        jM1053getSecondary0d7_KjU = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                        i7 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        j3 = jM1053getSecondary0d7_KjU;
                        i3 = i7 & (-3670017);
                        modifier3 = modifier2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = shapeCopy;
                        j4 = jM1069contentColorForek8zF_U;
                        floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    } else {
                        j3 = jM1053getSecondary0d7_KjU;
                        i3 = i7;
                        modifier3 = modifier2;
                        shape2 = shapeCopy;
                        j4 = jM1069contentColorForek8zF_U;
                        floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1028985328, i3, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:81)");
                }
                long j16 = j4;
                FloatingActionButtonElevation floatingActionButtonElevation13 = floatingActionButtonElevationM1135elevationxZ9QkE;
                MutableInteractionSource mutableInteractionSource15 = mutableInteractionSource3;
                Modifier modifier15 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, FloatingActionButtonKt$FloatingActionButton$2.INSTANCE, 1, null), false, shape2, j3, j4, null, floatingActionButtonElevationM1135elevationxZ9QkE.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m5174unboximpl(), mutableInteractionSource15, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new FloatingActionButtonKt$FloatingActionButton$3(j4, interfaceC0526Fp, i3)), composer2, (i3 & 14) | 805306368 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier15;
                shape3 = shape2;
                j5 = j3;
                mutableInteractionSource4 = mutableInteractionSource15;
                jM1069contentColorForek8zF_U = j16;
                floatingActionButtonElevation2 = floatingActionButtonElevation13;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
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
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                    } else {
                        i7 = i3;
                        jM1053getSecondary0d7_KjU = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                        i7 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        j3 = jM1053getSecondary0d7_KjU;
                        i3 = i7 & (-3670017);
                        modifier3 = modifier2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = shapeCopy;
                        j4 = jM1069contentColorForek8zF_U;
                        floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    } else {
                        j3 = jM1053getSecondary0d7_KjU;
                        i3 = i7;
                        modifier3 = modifier2;
                        shape2 = shapeCopy;
                        j4 = jM1069contentColorForek8zF_U;
                        floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
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
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                    } else {
                        i7 = i3;
                        jM1053getSecondary0d7_KjU = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                        i7 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        j3 = jM1053getSecondary0d7_KjU;
                        i3 = i7 & (-3670017);
                        modifier3 = modifier2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = shapeCopy;
                        j4 = jM1069contentColorForek8zF_U;
                        floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    } else {
                        j3 = jM1053getSecondary0d7_KjU;
                        i3 = i7;
                        modifier3 = modifier2;
                        shape2 = shapeCopy;
                        j4 = jM1069contentColorForek8zF_U;
                        floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1028985328, i3, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:81)");
                }
                long j17 = j4;
                FloatingActionButtonElevation floatingActionButtonElevation14 = floatingActionButtonElevationM1135elevationxZ9QkE;
                MutableInteractionSource mutableInteractionSource16 = mutableInteractionSource3;
                Modifier modifier16 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, FloatingActionButtonKt$FloatingActionButton$2.INSTANCE, 1, null), false, shape2, j3, j4, null, floatingActionButtonElevationM1135elevationxZ9QkE.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m5174unboximpl(), mutableInteractionSource16, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new FloatingActionButtonKt$FloatingActionButton$3(j4, interfaceC0526Fp, i3)), composer2, (i3 & 14) | 805306368 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier16;
                shape3 = shape2;
                j5 = j3;
                mutableInteractionSource4 = mutableInteractionSource16;
                jM1069contentColorForek8zF_U = j17;
                floatingActionButtonElevation2 = floatingActionButtonElevation14;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$FloatingActionButton$4(interfaceC3588op, modifier4, mutableInteractionSource4, shape3, j5, jM1069contentColorForek8zF_U, floatingActionButtonElevation2, interfaceC0526Fp, i, i2));
        }
        i3 |= 384;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                shapeCopy = shape;
                if (composerStartRestartGroup.changed(shapeCopy)) {
                }
                i3 |= i10;
            } else {
                shapeCopy = shape;
            }
            i3 |= i10;
        } else {
            shapeCopy = shape;
        }
        if ((i & 57344) != 0) {
            i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changed(j)) ? 8192 : 16384;
        }
        if ((i & 458752) == 0) {
            jM1069contentColorForek8zF_U = j2;
            if ((i2 & 32) == 0) {
                i8 = 65536;
            } else {
                i8 = 65536;
            }
            i3 |= i8;
        } else {
            jM1069contentColorForek8zF_U = j2;
        }
        if ((3670016 & i) == 0) {
            if ((i2 & 64) == 0) {
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
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                    } else {
                        i7 = i3;
                        jM1053getSecondary0d7_KjU = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                        i7 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        j3 = jM1053getSecondary0d7_KjU;
                        i3 = i7 & (-3670017);
                        modifier3 = modifier2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = shapeCopy;
                        j4 = jM1069contentColorForek8zF_U;
                        floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    } else {
                        j3 = jM1053getSecondary0d7_KjU;
                        i3 = i7;
                        modifier3 = modifier2;
                        shape2 = shapeCopy;
                        j4 = jM1069contentColorForek8zF_U;
                        floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
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
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                    } else {
                        i7 = i3;
                        jM1053getSecondary0d7_KjU = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                        i7 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        j3 = jM1053getSecondary0d7_KjU;
                        i3 = i7 & (-3670017);
                        modifier3 = modifier2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = shapeCopy;
                        j4 = jM1069contentColorForek8zF_U;
                        floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    } else {
                        j3 = jM1053getSecondary0d7_KjU;
                        i3 = i7;
                        modifier3 = modifier2;
                        shape2 = shapeCopy;
                        j4 = jM1069contentColorForek8zF_U;
                        floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1028985328, i3, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:81)");
                }
                long j18 = j4;
                FloatingActionButtonElevation floatingActionButtonElevation15 = floatingActionButtonElevationM1135elevationxZ9QkE;
                MutableInteractionSource mutableInteractionSource17 = mutableInteractionSource3;
                Modifier modifier17 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, FloatingActionButtonKt$FloatingActionButton$2.INSTANCE, 1, null), false, shape2, j3, j4, null, floatingActionButtonElevationM1135elevationxZ9QkE.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m5174unboximpl(), mutableInteractionSource17, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new FloatingActionButtonKt$FloatingActionButton$3(j4, interfaceC0526Fp, i3)), composer2, (i3 & 14) | 805306368 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier17;
                shape3 = shape2;
                j5 = j3;
                mutableInteractionSource4 = mutableInteractionSource17;
                jM1069contentColorForek8zF_U = j18;
                floatingActionButtonElevation2 = floatingActionButtonElevation15;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
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
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                    } else {
                        i7 = i3;
                        jM1053getSecondary0d7_KjU = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                        i7 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        j3 = jM1053getSecondary0d7_KjU;
                        i3 = i7 & (-3670017);
                        modifier3 = modifier2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = shapeCopy;
                        j4 = jM1069contentColorForek8zF_U;
                        floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    } else {
                        j3 = jM1053getSecondary0d7_KjU;
                        i3 = i7;
                        modifier3 = modifier2;
                        shape2 = shapeCopy;
                        j4 = jM1069contentColorForek8zF_U;
                        floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
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
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    }
                    if ((i2 & 16) != 0) {
                        i7 = i3 & (-57345);
                        jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                    } else {
                        i7 = i3;
                        jM1053getSecondary0d7_KjU = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                        i7 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        j3 = jM1053getSecondary0d7_KjU;
                        i3 = i7 & (-3670017);
                        modifier3 = modifier2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = shapeCopy;
                        j4 = jM1069contentColorForek8zF_U;
                        floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    } else {
                        j3 = jM1053getSecondary0d7_KjU;
                        i3 = i7;
                        modifier3 = modifier2;
                        shape2 = shapeCopy;
                        j4 = jM1069contentColorForek8zF_U;
                        floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1028985328, i3, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:81)");
                }
                long j19 = j4;
                FloatingActionButtonElevation floatingActionButtonElevation16 = floatingActionButtonElevationM1135elevationxZ9QkE;
                MutableInteractionSource mutableInteractionSource18 = mutableInteractionSource3;
                Modifier modifier18 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, FloatingActionButtonKt$FloatingActionButton$2.INSTANCE, 1, null), false, shape2, j3, j4, null, floatingActionButtonElevationM1135elevationxZ9QkE.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m5174unboximpl(), mutableInteractionSource18, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new FloatingActionButtonKt$FloatingActionButton$3(j4, interfaceC0526Fp, i3)), composer2, (i3 & 14) | 805306368 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier18;
                shape3 = shape2;
                j5 = j3;
                mutableInteractionSource4 = mutableInteractionSource18;
                jM1069contentColorForek8zF_U = j19;
                floatingActionButtonElevation2 = floatingActionButtonElevation16;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$FloatingActionButton$4(interfaceC3588op, modifier4, mutableInteractionSource4, shape3, j5, jM1069contentColorForek8zF_U, floatingActionButtonElevation2, interfaceC0526Fp, i, i2));
        }
        i6 = 12582912;
        i3 |= i6;
        if ((23967451 & i3) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier2 = Modifier.Companion;
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
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                }
                if ((i2 & 16) != 0) {
                    i7 = i3 & (-57345);
                    jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                } else {
                    i7 = i3;
                    jM1053getSecondary0d7_KjU = j;
                }
                if ((i2 & 32) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                    i7 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    j3 = jM1053getSecondary0d7_KjU;
                    i3 = i7 & (-3670017);
                    modifier3 = modifier2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape2 = shapeCopy;
                    j4 = jM1069contentColorForek8zF_U;
                    floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                } else {
                    j3 = jM1053getSecondary0d7_KjU;
                    i3 = i7;
                    modifier3 = modifier2;
                    shape2 = shapeCopy;
                    j4 = jM1069contentColorForek8zF_U;
                    floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
            } else {
                if (i9 != 0) {
                    modifier2 = Modifier.Companion;
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
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                }
                if ((i2 & 16) != 0) {
                    i7 = i3 & (-57345);
                    jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                } else {
                    i7 = i3;
                    jM1053getSecondary0d7_KjU = j;
                }
                if ((i2 & 32) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                    i7 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    j3 = jM1053getSecondary0d7_KjU;
                    i3 = i7 & (-3670017);
                    modifier3 = modifier2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape2 = shapeCopy;
                    j4 = jM1069contentColorForek8zF_U;
                    floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                } else {
                    j3 = jM1053getSecondary0d7_KjU;
                    i3 = i7;
                    modifier3 = modifier2;
                    shape2 = shapeCopy;
                    j4 = jM1069contentColorForek8zF_U;
                    floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1028985328, i3, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:81)");
            }
            long j110 = j4;
            FloatingActionButtonElevation floatingActionButtonElevation17 = floatingActionButtonElevationM1135elevationxZ9QkE;
            MutableInteractionSource mutableInteractionSource19 = mutableInteractionSource3;
            Modifier modifier19 = modifier3;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, FloatingActionButtonKt$FloatingActionButton$2.INSTANCE, 1, null), false, shape2, j3, j4, null, floatingActionButtonElevationM1135elevationxZ9QkE.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m5174unboximpl(), mutableInteractionSource19, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new FloatingActionButtonKt$FloatingActionButton$3(j4, interfaceC0526Fp, i3)), composer2, (i3 & 14) | 805306368 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier19;
            shape3 = shape2;
            j5 = j3;
            mutableInteractionSource4 = mutableInteractionSource19;
            jM1069contentColorForek8zF_U = j110;
            floatingActionButtonElevation2 = floatingActionButtonElevation17;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier2 = Modifier.Companion;
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
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                }
                if ((i2 & 16) != 0) {
                    i7 = i3 & (-57345);
                    jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                } else {
                    i7 = i3;
                    jM1053getSecondary0d7_KjU = j;
                }
                if ((i2 & 32) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                    i7 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    j3 = jM1053getSecondary0d7_KjU;
                    i3 = i7 & (-3670017);
                    modifier3 = modifier2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape2 = shapeCopy;
                    j4 = jM1069contentColorForek8zF_U;
                    floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                } else {
                    j3 = jM1053getSecondary0d7_KjU;
                    i3 = i7;
                    modifier3 = modifier2;
                    shape2 = shapeCopy;
                    j4 = jM1069contentColorForek8zF_U;
                    floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
            } else {
                if (i9 != 0) {
                    modifier2 = Modifier.Companion;
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
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                }
                if ((i2 & 16) != 0) {
                    i7 = i3 & (-57345);
                    jM1053getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1053getSecondary0d7_KjU();
                } else {
                    i7 = i3;
                    jM1053getSecondary0d7_KjU = j;
                }
                if ((i2 & 32) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1053getSecondary0d7_KjU, composerStartRestartGroup, (i7 >> 12) & 14);
                    i7 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    j3 = jM1053getSecondary0d7_KjU;
                    i3 = i7 & (-3670017);
                    modifier3 = modifier2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape2 = shapeCopy;
                    j4 = jM1069contentColorForek8zF_U;
                    floatingActionButtonElevationM1135elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1135elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                } else {
                    j3 = jM1053getSecondary0d7_KjU;
                    i3 = i7;
                    modifier3 = modifier2;
                    shape2 = shapeCopy;
                    j4 = jM1069contentColorForek8zF_U;
                    floatingActionButtonElevationM1135elevationxZ9QkE = floatingActionButtonElevation2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1028985328, i3, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:81)");
            }
            long j111 = j4;
            FloatingActionButtonElevation floatingActionButtonElevation18 = floatingActionButtonElevationM1135elevationxZ9QkE;
            MutableInteractionSource mutableInteractionSource110 = mutableInteractionSource3;
            Modifier modifier110 = modifier3;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, SemanticsModifierKt.semantics$default(modifier3, false, FloatingActionButtonKt$FloatingActionButton$2.INSTANCE, 1, null), false, shape2, j3, j4, null, floatingActionButtonElevationM1135elevationxZ9QkE.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m5174unboximpl(), mutableInteractionSource110, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new FloatingActionButtonKt$FloatingActionButton$3(j4, interfaceC0526Fp, i3)), composer2, (i3 & 14) | 805306368 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier110;
            shape3 = shape2;
            j5 = j3;
            mutableInteractionSource4 = mutableInteractionSource110;
            jM1069contentColorForek8zF_U = j111;
            floatingActionButtonElevation2 = floatingActionButtonElevation18;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new FloatingActionButtonKt$FloatingActionButton$4(interfaceC3588op, modifier4, mutableInteractionSource4, shape3, j5, jM1069contentColorForek8zF_U, floatingActionButtonElevation2, interfaceC0526Fp, i, i2));
    }
}
