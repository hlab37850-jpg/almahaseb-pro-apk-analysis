package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SurfaceKt {
    /* JADX WARN: Code duplicated, block: B:101:0x013f  */
    /* JADX WARN: Code duplicated, block: B:103:0x0147  */
    /* JADX WARN: Code duplicated, block: B:105:0x014d  */
    /* JADX WARN: Code duplicated, block: B:106:0x0150  */
    /* JADX WARN: Code duplicated, block: B:109:0x0156  */
    /* JADX WARN: Code duplicated, block: B:111:0x015d  */
    /* JADX WARN: Code duplicated, block: B:113:0x0163  */
    /* JADX WARN: Code duplicated, block: B:116:0x016a  */
    /* JADX WARN: Code duplicated, block: B:118:0x016f  */
    /* JADX WARN: Code duplicated, block: B:121:0x0175  */
    /* JADX WARN: Code duplicated, block: B:123:0x017a  */
    /* JADX WARN: Code duplicated, block: B:125:0x0180  */
    /* JADX WARN: Code duplicated, block: B:127:0x0186  */
    /* JADX WARN: Code duplicated, block: B:128:0x0189  */
    /* JADX WARN: Code duplicated, block: B:132:0x0192  */
    /* JADX WARN: Code duplicated, block: B:133:0x0195  */
    /* JADX WARN: Code duplicated, block: B:135:0x0199  */
    /* JADX WARN: Code duplicated, block: B:137:0x019f  */
    /* JADX WARN: Code duplicated, block: B:138:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:142:0x01af  */
    /* JADX WARN: Code duplicated, block: B:148:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:150:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:163:0x021a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:164:0x021c  */
    /* JADX WARN: Code duplicated, block: B:165:0x021f  */
    /* JADX WARN: Code duplicated, block: B:167:0x0223  */
    /* JADX WARN: Code duplicated, block: B:170:0x022b  */
    /* JADX WARN: Code duplicated, block: B:171:0x023f  */
    /* JADX WARN: Code duplicated, block: B:174:0x0248  */
    /* JADX WARN: Code duplicated, block: B:175:0x0255  */
    /* JADX WARN: Code duplicated, block: B:177:0x0259  */
    /* JADX WARN: Code duplicated, block: B:178:0x025c  */
    /* JADX WARN: Code duplicated, block: B:181:0x0262  */
    /* JADX WARN: Code duplicated, block: B:182:0x0269  */
    /* JADX WARN: Code duplicated, block: B:184:0x026d  */
    /* JADX WARN: Code duplicated, block: B:186:0x027f  */
    /* JADX WARN: Code duplicated, block: B:189:0x028e  */
    /* JADX WARN: Code duplicated, block: B:192:0x0294  */
    /* JADX WARN: Code duplicated, block: B:193:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:195:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:196:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:198:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:199:0x02af  */
    /* JADX WARN: Code duplicated, block: B:201:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:203:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:206:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:209:0x0361  */
    /* JADX WARN: Code duplicated, block: B:214:0x0381  */
    /* JADX WARN: Code duplicated, block: B:216:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0082  */
    /* JADX WARN: Code duplicated, block: B:45:0x0098  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:55:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:58:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:63:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:64:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00db  */
    /* JADX WARN: Code duplicated, block: B:69:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:73:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:74:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:78:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:79:0x0102  */
    /* JADX WARN: Code duplicated, block: B:81:0x010a  */
    /* JADX WARN: Code duplicated, block: B:83:0x0110  */
    /* JADX WARN: Code duplicated, block: B:84:0x0113  */
    /* JADX WARN: Code duplicated, block: B:88:0x011d  */
    /* JADX WARN: Code duplicated, block: B:93:0x012e  */
    /* JADX WARN: Code duplicated, block: B:95:0x0132  */
    /* JADX WARN: Code duplicated, block: B:98:0x0138  */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Surface-9VG74zQ, reason: not valid java name */
    public static final void m1226Surface9VG74zQ(InterfaceC3588op interfaceC3588op, Modifier modifier, Shape shape, long j, long j2, BorderStroke borderStroke, float f, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2, int i3) {
        int i4;
        Shape rectangleShape;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        Modifier modifier2;
        int i19;
        long jM1055getSurface0d7_KjU;
        long jM1069contentColorForek8zF_U;
        BorderStroke borderStroke2;
        long j3;
        float fM5160constructorimpl;
        MutableInteractionSource mutableInteractionSource2;
        Indication indication2;
        boolean z2;
        String str2;
        Role role2;
        Modifier modifier3;
        int i20;
        Object objRememberedValue;
        Composer composer2;
        Modifier modifier4;
        Shape shape2;
        long j4;
        long j5;
        BorderStroke borderStroke3;
        float f2;
        MutableInteractionSource mutableInteractionSource3;
        Indication indication3;
        boolean z3;
        String str3;
        Role role3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i21;
        int i22;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(1585925488);
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = i | (composerStartRestartGroup.changedInstance(interfaceC3588op) ? 4 : 2);
        } else {
            i4 = i;
        }
        int i23 = i3 & 2;
        if (i23 != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i24 = i4;
        int i25 = i3 & 4;
        if (i25 == 0) {
            if ((i & 896) == 0) {
                rectangleShape = shape;
                i24 |= composerStartRestartGroup.changed(rectangleShape) ? 256 : 128;
            }
            if ((i & 7168) != 0) {
                i24 |= ((i3 & 8) == 0 || !composerStartRestartGroup.changed(j)) ? 1024 : 2048;
            }
            if ((i & 57344) != 0) {
                if ((i3 & 16) == 0 || !composerStartRestartGroup.changed(j2)) {
                    i22 = 8192;
                } else {
                    i22 = 16384;
                }
                i24 |= i22;
            }
            i5 = i3 & 32;
            if (i5 != 0) {
                i24 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i24 |= i6;
            }
            i7 = i3 & 64;
            if (i7 != 0) {
                i24 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i24 |= i8;
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                i24 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i24 |= i10;
            }
            if ((i & 234881024) != 0) {
                if ((i3 & 256) == 0 || !composerStartRestartGroup.changed(indication)) {
                    i21 = 33554432;
                } else {
                    i21 = 67108864;
                }
                i24 |= i21;
            }
            i11 = i3 & 512;
            if (i11 != 0) {
                if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i12 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i12 = 268435456;
                    }
                }
                i13 = 1024 & i3;
                if (i13 != 0) {
                    i14 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    i14 = i2 | (composerStartRestartGroup.changed(str) ? 4 : 2);
                } else {
                    i14 = i2;
                }
                i15 = 2048 & i3;
                if (i15 != 0) {
                    i14 |= 48;
                } else if ((i2 & 112) == 0) {
                    if (composerStartRestartGroup.changed(role)) {
                        i16 = 32;
                    } else {
                        i16 = 16;
                    }
                    i14 |= i16;
                }
                i17 = i14;
                if ((i3 & 4096) != 0) {
                    i17 |= 384;
                } else if ((i2 & 896) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i18 = 256;
                    } else {
                        i18 = 128;
                    }
                    i17 |= i18;
                }
                if ((1533916891 & i24) != 306783378 && (i17 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier4 = modifier;
                    j5 = j;
                    j4 = j2;
                    borderStroke3 = borderStroke;
                    indication3 = indication;
                    z3 = z;
                    str3 = str;
                    role3 = role;
                    shape2 = rectangleShape;
                    composer2 = composerStartRestartGroup;
                    f2 = f;
                    mutableInteractionSource3 = mutableInteractionSource;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i23 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i25 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i3 & 8) != 0) {
                            i24 &= -7169;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i19 = 16;
                        } else {
                            i19 = 16;
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i19 & i3) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i24 >> 9) & 14);
                            i24 &= -57345;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i5 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        j3 = jM1055getSurface0d7_KjU;
                        if (i7 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if (i9 != 0) {
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
                        if ((256 & i3) != 0) {
                            indication2 = (Indication) composerStartRestartGroup.consume(IndicationKt.getLocalIndication());
                            i24 &= -234881025;
                        } else {
                            indication2 = indication;
                        }
                        if (i11 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i13 != 0) {
                            str2 = null;
                        } else {
                            str2 = str;
                        }
                        if (i15 != 0) {
                            role2 = null;
                        } else {
                            role2 = role;
                        }
                        modifier3 = modifier2;
                        i20 = i24;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 8) != 0) {
                            i24 &= -7169;
                        }
                        if ((16 & i3) != 0) {
                            i24 &= -57345;
                        }
                        if ((256 & i3) != 0) {
                            i24 &= -234881025;
                        }
                        modifier3 = modifier;
                        j3 = j;
                        jM1069contentColorForek8zF_U = j2;
                        borderStroke2 = borderStroke;
                        fM5160constructorimpl = f;
                        mutableInteractionSource2 = mutableInteractionSource;
                        indication2 = indication;
                        z2 = z;
                        str2 = str;
                        role2 = role;
                        i20 = i24;
                        rectangleShape = rectangleShape;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1585925488, i20, i17, "androidx.compose.material.Surface (Surface.kt:569)");
                    }
                    float fM5160constructorimpl2 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + fM5160constructorimpl);
                    composer2 = composerStartRestartGroup;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(jM1069contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl2))}, ComposableLambdaKt.composableLambda(composer2, 149594672, true, new SurfaceKt$Surface$13(modifier3, rectangleShape, j3, fM5160constructorimpl2, i20, borderStroke2, fM5160constructorimpl, mutableInteractionSource2, indication2, z2, str2, role2, interfaceC3588op, interfaceC0526Fp, i17)), composer2, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape2 = rectangleShape;
                    j4 = jM1069contentColorForek8zF_U;
                    j5 = j3;
                    borderStroke3 = borderStroke2;
                    f2 = fM5160constructorimpl;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    indication3 = indication2;
                    z3 = z2;
                    str3 = str2;
                    role3 = role2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$14(interfaceC3588op, modifier4, shape2, j5, j4, borderStroke3, f2, mutableInteractionSource3, indication3, z3, str3, role3, interfaceC0526Fp, i, i2, i3));
            }
            i12 = 805306368;
            i24 |= i12;
            i13 = 1024 & i3;
            if (i13 != 0) {
                i14 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                i14 = i2 | (composerStartRestartGroup.changed(str) ? 4 : 2);
            } else {
                i14 = i2;
            }
            i15 = 2048 & i3;
            if (i15 != 0) {
                i14 |= 48;
            } else if ((i2 & 112) == 0) {
                if (composerStartRestartGroup.changed(role)) {
                    i16 = 32;
                } else {
                    i16 = 16;
                }
                i14 |= i16;
            }
            i17 = i14;
            if ((i3 & 4096) != 0) {
                i17 |= 384;
            } else if ((i2 & 896) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i18 = 256;
                } else {
                    i18 = 128;
                }
                i17 |= i18;
            }
            if ((1533916891 & i24) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i25 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i3 & 8) != 0) {
                        i24 &= -7169;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i19 = 16;
                    } else {
                        i19 = 16;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i19 & i3) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i24 >> 9) & 14);
                        i24 &= -57345;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i5 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    j3 = jM1055getSurface0d7_KjU;
                    if (i7 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i9 != 0) {
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
                    if ((256 & i3) != 0) {
                        indication2 = (Indication) composerStartRestartGroup.consume(IndicationKt.getLocalIndication());
                        i24 &= -234881025;
                    } else {
                        indication2 = indication;
                    }
                    if (i11 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i13 != 0) {
                        str2 = null;
                    } else {
                        str2 = str;
                    }
                    if (i15 != 0) {
                        role2 = null;
                    } else {
                        role2 = role;
                    }
                    modifier3 = modifier2;
                    i20 = i24;
                } else {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i25 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i3 & 8) != 0) {
                        i24 &= -7169;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i19 = 16;
                    } else {
                        i19 = 16;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i19 & i3) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i24 >> 9) & 14);
                        i24 &= -57345;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i5 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    j3 = jM1055getSurface0d7_KjU;
                    if (i7 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i9 != 0) {
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
                    if ((256 & i3) != 0) {
                        indication2 = (Indication) composerStartRestartGroup.consume(IndicationKt.getLocalIndication());
                        i24 &= -234881025;
                    } else {
                        indication2 = indication;
                    }
                    if (i11 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i13 != 0) {
                        str2 = null;
                    } else {
                        str2 = str;
                    }
                    if (i15 != 0) {
                        role2 = null;
                    } else {
                        role2 = role;
                    }
                    modifier3 = modifier2;
                    i20 = i24;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1585925488, i20, i17, "androidx.compose.material.Surface (Surface.kt:569)");
                }
                float fM5160constructorimpl3 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + fM5160constructorimpl);
                composer2 = composerStartRestartGroup;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(jM1069contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl3))}, ComposableLambdaKt.composableLambda(composer2, 149594672, true, new SurfaceKt$Surface$13(modifier3, rectangleShape, j3, fM5160constructorimpl3, i20, borderStroke2, fM5160constructorimpl, mutableInteractionSource2, indication2, z2, str2, role2, interfaceC3588op, interfaceC0526Fp, i17)), composer2, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape2 = rectangleShape;
                j4 = jM1069contentColorForek8zF_U;
                j5 = j3;
                borderStroke3 = borderStroke2;
                f2 = fM5160constructorimpl;
                mutableInteractionSource3 = mutableInteractionSource2;
                indication3 = indication2;
                z3 = z2;
                str3 = str2;
                role3 = role2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i25 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i3 & 8) != 0) {
                        i24 &= -7169;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i19 = 16;
                    } else {
                        i19 = 16;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i19 & i3) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i24 >> 9) & 14);
                        i24 &= -57345;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i5 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    j3 = jM1055getSurface0d7_KjU;
                    if (i7 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i9 != 0) {
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
                    if ((256 & i3) != 0) {
                        indication2 = (Indication) composerStartRestartGroup.consume(IndicationKt.getLocalIndication());
                        i24 &= -234881025;
                    } else {
                        indication2 = indication;
                    }
                    if (i11 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i13 != 0) {
                        str2 = null;
                    } else {
                        str2 = str;
                    }
                    if (i15 != 0) {
                        role2 = null;
                    } else {
                        role2 = role;
                    }
                    modifier3 = modifier2;
                    i20 = i24;
                } else {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i25 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i3 & 8) != 0) {
                        i24 &= -7169;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i19 = 16;
                    } else {
                        i19 = 16;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i19 & i3) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i24 >> 9) & 14);
                        i24 &= -57345;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i5 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    j3 = jM1055getSurface0d7_KjU;
                    if (i7 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i9 != 0) {
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
                    if ((256 & i3) != 0) {
                        indication2 = (Indication) composerStartRestartGroup.consume(IndicationKt.getLocalIndication());
                        i24 &= -234881025;
                    } else {
                        indication2 = indication;
                    }
                    if (i11 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i13 != 0) {
                        str2 = null;
                    } else {
                        str2 = str;
                    }
                    if (i15 != 0) {
                        role2 = null;
                    } else {
                        role2 = role;
                    }
                    modifier3 = modifier2;
                    i20 = i24;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1585925488, i20, i17, "androidx.compose.material.Surface (Surface.kt:569)");
                }
                float fM5160constructorimpl4 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + fM5160constructorimpl);
                composer2 = composerStartRestartGroup;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(jM1069contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl4))}, ComposableLambdaKt.composableLambda(composer2, 149594672, true, new SurfaceKt$Surface$13(modifier3, rectangleShape, j3, fM5160constructorimpl4, i20, borderStroke2, fM5160constructorimpl, mutableInteractionSource2, indication2, z2, str2, role2, interfaceC3588op, interfaceC0526Fp, i17)), composer2, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape2 = rectangleShape;
                j4 = jM1069contentColorForek8zF_U;
                j5 = j3;
                borderStroke3 = borderStroke2;
                f2 = fM5160constructorimpl;
                mutableInteractionSource3 = mutableInteractionSource2;
                indication3 = indication2;
                z3 = z2;
                str3 = str2;
                role3 = role2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$14(interfaceC3588op, modifier4, shape2, j5, j4, borderStroke3, f2, mutableInteractionSource3, indication3, z3, str3, role3, interfaceC0526Fp, i, i2, i3));
        }
        i24 |= 384;
        rectangleShape = shape;
        if ((i & 7168) != 0) {
            i24 |= ((i3 & 8) == 0 || !composerStartRestartGroup.changed(j)) ? 1024 : 2048;
        }
        if ((i & 57344) != 0) {
            if ((i3 & 16) == 0) {
                i22 = 8192;
            } else {
                i22 = 8192;
            }
            i24 |= i22;
        }
        i5 = i3 & 32;
        if (i5 != 0) {
            i24 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & 458752) == 0) {
            if (composerStartRestartGroup.changed(borderStroke)) {
                i6 = 131072;
            } else {
                i6 = 65536;
            }
            i24 |= i6;
        }
        i7 = i3 & 64;
        if (i7 != 0) {
            i24 |= 1572864;
        } else if ((i & 3670016) == 0) {
            if (composerStartRestartGroup.changed(f)) {
                i8 = 1048576;
            } else {
                i8 = 524288;
            }
            i24 |= i8;
        }
        i9 = i3 & 128;
        if (i9 != 0) {
            i24 |= 12582912;
        } else if ((i & 29360128) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i10 = 8388608;
            } else {
                i10 = 4194304;
            }
            i24 |= i10;
        }
        if ((i & 234881024) != 0) {
            if ((i3 & 256) == 0) {
                i21 = 33554432;
            } else {
                i21 = 33554432;
            }
            i24 |= i21;
        }
        i11 = i3 & 512;
        if (i11 != 0) {
            if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i12 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i12 = 268435456;
                }
            }
            i13 = 1024 & i3;
            if (i13 != 0) {
                i14 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                i14 = i2 | (composerStartRestartGroup.changed(str) ? 4 : 2);
            } else {
                i14 = i2;
            }
            i15 = 2048 & i3;
            if (i15 != 0) {
                i14 |= 48;
            } else if ((i2 & 112) == 0) {
                if (composerStartRestartGroup.changed(role)) {
                    i16 = 32;
                } else {
                    i16 = 16;
                }
                i14 |= i16;
            }
            i17 = i14;
            if ((i3 & 4096) != 0) {
                i17 |= 384;
            } else if ((i2 & 896) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i18 = 256;
                } else {
                    i18 = 128;
                }
                i17 |= i18;
            }
            if ((1533916891 & i24) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i25 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i3 & 8) != 0) {
                        i24 &= -7169;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i19 = 16;
                    } else {
                        i19 = 16;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i19 & i3) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i24 >> 9) & 14);
                        i24 &= -57345;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i5 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    j3 = jM1055getSurface0d7_KjU;
                    if (i7 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i9 != 0) {
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
                    if ((256 & i3) != 0) {
                        indication2 = (Indication) composerStartRestartGroup.consume(IndicationKt.getLocalIndication());
                        i24 &= -234881025;
                    } else {
                        indication2 = indication;
                    }
                    if (i11 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i13 != 0) {
                        str2 = null;
                    } else {
                        str2 = str;
                    }
                    if (i15 != 0) {
                        role2 = null;
                    } else {
                        role2 = role;
                    }
                    modifier3 = modifier2;
                    i20 = i24;
                } else {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i25 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i3 & 8) != 0) {
                        i24 &= -7169;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i19 = 16;
                    } else {
                        i19 = 16;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i19 & i3) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i24 >> 9) & 14);
                        i24 &= -57345;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i5 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    j3 = jM1055getSurface0d7_KjU;
                    if (i7 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i9 != 0) {
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
                    if ((256 & i3) != 0) {
                        indication2 = (Indication) composerStartRestartGroup.consume(IndicationKt.getLocalIndication());
                        i24 &= -234881025;
                    } else {
                        indication2 = indication;
                    }
                    if (i11 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i13 != 0) {
                        str2 = null;
                    } else {
                        str2 = str;
                    }
                    if (i15 != 0) {
                        role2 = null;
                    } else {
                        role2 = role;
                    }
                    modifier3 = modifier2;
                    i20 = i24;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1585925488, i20, i17, "androidx.compose.material.Surface (Surface.kt:569)");
                }
                float fM5160constructorimpl5 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + fM5160constructorimpl);
                composer2 = composerStartRestartGroup;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(jM1069contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl5))}, ComposableLambdaKt.composableLambda(composer2, 149594672, true, new SurfaceKt$Surface$13(modifier3, rectangleShape, j3, fM5160constructorimpl5, i20, borderStroke2, fM5160constructorimpl, mutableInteractionSource2, indication2, z2, str2, role2, interfaceC3588op, interfaceC0526Fp, i17)), composer2, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape2 = rectangleShape;
                j4 = jM1069contentColorForek8zF_U;
                j5 = j3;
                borderStroke3 = borderStroke2;
                f2 = fM5160constructorimpl;
                mutableInteractionSource3 = mutableInteractionSource2;
                indication3 = indication2;
                z3 = z2;
                str3 = str2;
                role3 = role2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i25 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i3 & 8) != 0) {
                        i24 &= -7169;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i19 = 16;
                    } else {
                        i19 = 16;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i19 & i3) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i24 >> 9) & 14);
                        i24 &= -57345;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i5 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    j3 = jM1055getSurface0d7_KjU;
                    if (i7 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i9 != 0) {
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
                    if ((256 & i3) != 0) {
                        indication2 = (Indication) composerStartRestartGroup.consume(IndicationKt.getLocalIndication());
                        i24 &= -234881025;
                    } else {
                        indication2 = indication;
                    }
                    if (i11 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i13 != 0) {
                        str2 = null;
                    } else {
                        str2 = str;
                    }
                    if (i15 != 0) {
                        role2 = null;
                    } else {
                        role2 = role;
                    }
                    modifier3 = modifier2;
                    i20 = i24;
                } else {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i25 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i3 & 8) != 0) {
                        i24 &= -7169;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i19 = 16;
                    } else {
                        i19 = 16;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i19 & i3) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i24 >> 9) & 14);
                        i24 &= -57345;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i5 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    j3 = jM1055getSurface0d7_KjU;
                    if (i7 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i9 != 0) {
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
                    if ((256 & i3) != 0) {
                        indication2 = (Indication) composerStartRestartGroup.consume(IndicationKt.getLocalIndication());
                        i24 &= -234881025;
                    } else {
                        indication2 = indication;
                    }
                    if (i11 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i13 != 0) {
                        str2 = null;
                    } else {
                        str2 = str;
                    }
                    if (i15 != 0) {
                        role2 = null;
                    } else {
                        role2 = role;
                    }
                    modifier3 = modifier2;
                    i20 = i24;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1585925488, i20, i17, "androidx.compose.material.Surface (Surface.kt:569)");
                }
                float fM5160constructorimpl6 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + fM5160constructorimpl);
                composer2 = composerStartRestartGroup;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(jM1069contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl6))}, ComposableLambdaKt.composableLambda(composer2, 149594672, true, new SurfaceKt$Surface$13(modifier3, rectangleShape, j3, fM5160constructorimpl6, i20, borderStroke2, fM5160constructorimpl, mutableInteractionSource2, indication2, z2, str2, role2, interfaceC3588op, interfaceC0526Fp, i17)), composer2, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape2 = rectangleShape;
                j4 = jM1069contentColorForek8zF_U;
                j5 = j3;
                borderStroke3 = borderStroke2;
                f2 = fM5160constructorimpl;
                mutableInteractionSource3 = mutableInteractionSource2;
                indication3 = indication2;
                z3 = z2;
                str3 = str2;
                role3 = role2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$14(interfaceC3588op, modifier4, shape2, j5, j4, borderStroke3, f2, mutableInteractionSource3, indication3, z3, str3, role3, interfaceC0526Fp, i, i2, i3));
        }
        i12 = 805306368;
        i24 |= i12;
        i13 = 1024 & i3;
        if (i13 != 0) {
            i14 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i14 = i2 | (composerStartRestartGroup.changed(str) ? 4 : 2);
        } else {
            i14 = i2;
        }
        i15 = 2048 & i3;
        if (i15 != 0) {
            i14 |= 48;
        } else if ((i2 & 112) == 0) {
            if (composerStartRestartGroup.changed(role)) {
                i16 = 32;
            } else {
                i16 = 16;
            }
            i14 |= i16;
        }
        i17 = i14;
        if ((i3 & 4096) != 0) {
            i17 |= 384;
        } else if ((i2 & 896) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                i18 = 256;
            } else {
                i18 = 128;
            }
            i17 |= i18;
        }
        if ((1533916891 & i24) != 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i23 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i25 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                if ((i3 & 8) != 0) {
                    i24 &= -7169;
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i19 = 16;
                } else {
                    i19 = 16;
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i19 & i3) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i24 >> 9) & 14);
                    i24 &= -57345;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if (i5 != 0) {
                    borderStroke2 = null;
                } else {
                    borderStroke2 = borderStroke;
                }
                j3 = jM1055getSurface0d7_KjU;
                if (i7 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                } else {
                    fM5160constructorimpl = f;
                }
                if (i9 != 0) {
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
                if ((256 & i3) != 0) {
                    indication2 = (Indication) composerStartRestartGroup.consume(IndicationKt.getLocalIndication());
                    i24 &= -234881025;
                } else {
                    indication2 = indication;
                }
                if (i11 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if (i13 != 0) {
                    str2 = null;
                } else {
                    str2 = str;
                }
                if (i15 != 0) {
                    role2 = null;
                } else {
                    role2 = role;
                }
                modifier3 = modifier2;
                i20 = i24;
            } else {
                if (i23 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i25 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                if ((i3 & 8) != 0) {
                    i24 &= -7169;
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i19 = 16;
                } else {
                    i19 = 16;
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i19 & i3) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i24 >> 9) & 14);
                    i24 &= -57345;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if (i5 != 0) {
                    borderStroke2 = null;
                } else {
                    borderStroke2 = borderStroke;
                }
                j3 = jM1055getSurface0d7_KjU;
                if (i7 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                } else {
                    fM5160constructorimpl = f;
                }
                if (i9 != 0) {
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
                if ((256 & i3) != 0) {
                    indication2 = (Indication) composerStartRestartGroup.consume(IndicationKt.getLocalIndication());
                    i24 &= -234881025;
                } else {
                    indication2 = indication;
                }
                if (i11 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if (i13 != 0) {
                    str2 = null;
                } else {
                    str2 = str;
                }
                if (i15 != 0) {
                    role2 = null;
                } else {
                    role2 = role;
                }
                modifier3 = modifier2;
                i20 = i24;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1585925488, i20, i17, "androidx.compose.material.Surface (Surface.kt:569)");
            }
            float fM5160constructorimpl7 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + fM5160constructorimpl);
            composer2 = composerStartRestartGroup;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(jM1069contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl7))}, ComposableLambdaKt.composableLambda(composer2, 149594672, true, new SurfaceKt$Surface$13(modifier3, rectangleShape, j3, fM5160constructorimpl7, i20, borderStroke2, fM5160constructorimpl, mutableInteractionSource2, indication2, z2, str2, role2, interfaceC3588op, interfaceC0526Fp, i17)), composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            shape2 = rectangleShape;
            j4 = jM1069contentColorForek8zF_U;
            j5 = j3;
            borderStroke3 = borderStroke2;
            f2 = fM5160constructorimpl;
            mutableInteractionSource3 = mutableInteractionSource2;
            indication3 = indication2;
            z3 = z2;
            str3 = str2;
            role3 = role2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i23 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i25 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                if ((i3 & 8) != 0) {
                    i24 &= -7169;
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i19 = 16;
                } else {
                    i19 = 16;
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i19 & i3) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i24 >> 9) & 14);
                    i24 &= -57345;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if (i5 != 0) {
                    borderStroke2 = null;
                } else {
                    borderStroke2 = borderStroke;
                }
                j3 = jM1055getSurface0d7_KjU;
                if (i7 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                } else {
                    fM5160constructorimpl = f;
                }
                if (i9 != 0) {
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
                if ((256 & i3) != 0) {
                    indication2 = (Indication) composerStartRestartGroup.consume(IndicationKt.getLocalIndication());
                    i24 &= -234881025;
                } else {
                    indication2 = indication;
                }
                if (i11 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if (i13 != 0) {
                    str2 = null;
                } else {
                    str2 = str;
                }
                if (i15 != 0) {
                    role2 = null;
                } else {
                    role2 = role;
                }
                modifier3 = modifier2;
                i20 = i24;
            } else {
                if (i23 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i25 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                if ((i3 & 8) != 0) {
                    i24 &= -7169;
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i19 = 16;
                } else {
                    i19 = 16;
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i19 & i3) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i24 >> 9) & 14);
                    i24 &= -57345;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if (i5 != 0) {
                    borderStroke2 = null;
                } else {
                    borderStroke2 = borderStroke;
                }
                j3 = jM1055getSurface0d7_KjU;
                if (i7 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                } else {
                    fM5160constructorimpl = f;
                }
                if (i9 != 0) {
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
                if ((256 & i3) != 0) {
                    indication2 = (Indication) composerStartRestartGroup.consume(IndicationKt.getLocalIndication());
                    i24 &= -234881025;
                } else {
                    indication2 = indication;
                }
                if (i11 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if (i13 != 0) {
                    str2 = null;
                } else {
                    str2 = str;
                }
                if (i15 != 0) {
                    role2 = null;
                } else {
                    role2 = role;
                }
                modifier3 = modifier2;
                i20 = i24;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1585925488, i20, i17, "androidx.compose.material.Surface (Surface.kt:569)");
            }
            float fM5160constructorimpl8 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + fM5160constructorimpl);
            composer2 = composerStartRestartGroup;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(jM1069contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl8))}, ComposableLambdaKt.composableLambda(composer2, 149594672, true, new SurfaceKt$Surface$13(modifier3, rectangleShape, j3, fM5160constructorimpl8, i20, borderStroke2, fM5160constructorimpl, mutableInteractionSource2, indication2, z2, str2, role2, interfaceC3588op, interfaceC0526Fp, i17)), composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            shape2 = rectangleShape;
            j4 = jM1069contentColorForek8zF_U;
            j5 = j3;
            borderStroke3 = borderStroke2;
            f2 = fM5160constructorimpl;
            mutableInteractionSource3 = mutableInteractionSource2;
            indication3 = indication2;
            z3 = z2;
            str3 = str2;
            role3 = role2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$14(interfaceC3588op, modifier4, shape2, j5, j4, borderStroke3, f2, mutableInteractionSource3, indication3, z3, str3, role3, interfaceC0526Fp, i, i2, i3));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0158  */
    /* JADX WARN: Code duplicated, block: B:103:0x015d  */
    /* JADX WARN: Code duplicated, block: B:105:0x0169  */
    /* JADX WARN: Code duplicated, block: B:106:0x016b  */
    /* JADX WARN: Code duplicated, block: B:108:0x016e  */
    /* JADX WARN: Code duplicated, block: B:109:0x0178  */
    /* JADX WARN: Code duplicated, block: B:112:0x0185  */
    /* JADX WARN: Code duplicated, block: B:115:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:120:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0058  */
    /* JADX WARN: Code duplicated, block: B:31:0x0069  */
    /* JADX WARN: Code duplicated, block: B:33:0x006e  */
    /* JADX WARN: Code duplicated, block: B:36:0x0076  */
    /* JADX WARN: Code duplicated, block: B:41:0x0085  */
    /* JADX WARN: Code duplicated, block: B:43:0x008a  */
    /* JADX WARN: Code duplicated, block: B:46:0x0090  */
    /* JADX WARN: Code duplicated, block: B:47:0x0095  */
    /* JADX WARN: Code duplicated, block: B:49:0x009e  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:56:0x00af  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:59:0x00be  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:68:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00da  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:76:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:80:0x0106  */
    /* JADX WARN: Code duplicated, block: B:82:0x010e  */
    /* JADX WARN: Code duplicated, block: B:93:0x0139 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:94:0x013b  */
    /* JADX WARN: Code duplicated, block: B:96:0x0140  */
    /* JADX WARN: Code duplicated, block: B:99:0x014a  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Surface-F-jzlyU, reason: not valid java name */
    public static final void m1227SurfaceFjzlyU(Modifier modifier, Shape shape, long j, long j2, BorderStroke borderStroke, float f, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        Modifier modifier2;
        int i3;
        Shape rectangleShape;
        long jM1055getSurface0d7_KjU;
        long jM1069contentColorForek8zF_U;
        int i4;
        BorderStroke borderStroke2;
        int i5;
        int i6;
        int i7;
        int i8;
        BorderStroke borderStroke3;
        float fM5160constructorimpl;
        BorderStroke borderStroke4;
        long j3;
        long j4;
        Modifier modifier3;
        int i9;
        Modifier modifier4;
        BorderStroke borderStroke5;
        Shape shape2;
        long j5;
        float f2;
        long j6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i10;
        int i11;
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(1412203386);
        int i12 = i2 & 1;
        if (i12 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i13 = i2 & 2;
        if (i13 == 0) {
            if ((i & 112) == 0) {
                rectangleShape = shape;
                i3 |= composerStartRestartGroup.changed(rectangleShape) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                jM1055getSurface0d7_KjU = j;
                if ((i2 & 4) == 0 || !composerStartRestartGroup.changed(jM1055getSurface0d7_KjU)) {
                    i11 = 128;
                } else {
                    i11 = 256;
                }
                i3 |= i11;
            } else {
                jM1055getSurface0d7_KjU = j;
            }
            if ((i & 7168) == 0) {
                jM1069contentColorForek8zF_U = j2;
                if ((i2 & 8) == 0 || !composerStartRestartGroup.changed(jM1069contentColorForek8zF_U)) {
                    i10 = 1024;
                } else {
                    i10 = 2048;
                }
                i3 |= i10;
            } else {
                jM1069contentColorForek8zF_U = j2;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                i3 |= 24576;
                borderStroke2 = borderStroke;
            } else {
                borderStroke2 = borderStroke;
                if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((i2 & 64) != 0) {
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                }
                if ((i3 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i13 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke2;
                        }
                        if (i6 != 0) {
                            borderStroke4 = borderStroke3;
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                            borderStroke4 = borderStroke3;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            fM5160constructorimpl = f;
                            borderStroke4 = borderStroke2;
                            j3 = jM1069contentColorForek8zF_U;
                            j4 = jM1055getSurface0d7_KjU;
                            modifier3 = modifier2;
                            i9 = i3 & (-7169);
                        } else {
                            fM5160constructorimpl = f;
                            borderStroke4 = borderStroke2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1412203386, i9, -1, "androidx.compose.material.Surface (Surface.kt:104)");
                        }
                        float fM5160constructorimpl2 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + fM5160constructorimpl);
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl2))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1822160838, true, new SurfaceKt$Surface$1(modifier3, rectangleShape, j4, fM5160constructorimpl2, i9, borderStroke4, fM5160constructorimpl, interfaceC0526Fp)), composerStartRestartGroup, 56);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        borderStroke5 = borderStroke4;
                        shape2 = rectangleShape;
                        j5 = j4;
                        f2 = fM5160constructorimpl;
                        j6 = j3;
                    }
                    j3 = jM1069contentColorForek8zF_U;
                    j4 = jM1055getSurface0d7_KjU;
                    modifier3 = modifier2;
                    i9 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1412203386, i9, -1, "androidx.compose.material.Surface (Surface.kt:104)");
                    }
                    float fM5160constructorimpl3 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + fM5160constructorimpl);
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl3))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1822160838, true, new SurfaceKt$Surface$1(modifier3, rectangleShape, j4, fM5160constructorimpl3, i9, borderStroke4, fM5160constructorimpl, interfaceC0526Fp)), composerStartRestartGroup, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    borderStroke5 = borderStroke4;
                    shape2 = rectangleShape;
                    j5 = j4;
                    f2 = fM5160constructorimpl;
                    j6 = j3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier4 = modifier2;
                    shape2 = rectangleShape;
                    f2 = f;
                    borderStroke5 = borderStroke2;
                    j6 = jM1069contentColorForek8zF_U;
                    j5 = jM1055getSurface0d7_KjU;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$2(modifier4, shape2, j5, j6, borderStroke5, f2, interfaceC0526Fp, i, i2));
            }
            i8 = 1572864;
            i3 |= i8;
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i13 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke2;
                    }
                    if (i6 != 0) {
                        borderStroke4 = borderStroke3;
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                        borderStroke4 = borderStroke3;
                    }
                    j3 = jM1069contentColorForek8zF_U;
                    j4 = jM1055getSurface0d7_KjU;
                    modifier3 = modifier2;
                    i9 = i3;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i13 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke2;
                    }
                    if (i6 != 0) {
                        borderStroke4 = borderStroke3;
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                        borderStroke4 = borderStroke3;
                    }
                    j3 = jM1069contentColorForek8zF_U;
                    j4 = jM1055getSurface0d7_KjU;
                    modifier3 = modifier2;
                    i9 = i3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1412203386, i9, -1, "androidx.compose.material.Surface (Surface.kt:104)");
                }
                float fM5160constructorimpl4 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + fM5160constructorimpl);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl4))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1822160838, true, new SurfaceKt$Surface$1(modifier3, rectangleShape, j4, fM5160constructorimpl4, i9, borderStroke4, fM5160constructorimpl, interfaceC0526Fp)), composerStartRestartGroup, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                borderStroke5 = borderStroke4;
                shape2 = rectangleShape;
                j5 = j4;
                f2 = fM5160constructorimpl;
                j6 = j3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i13 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke2;
                    }
                    if (i6 != 0) {
                        borderStroke4 = borderStroke3;
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                        borderStroke4 = borderStroke3;
                    }
                    j3 = jM1069contentColorForek8zF_U;
                    j4 = jM1055getSurface0d7_KjU;
                    modifier3 = modifier2;
                    i9 = i3;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i13 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke2;
                    }
                    if (i6 != 0) {
                        borderStroke4 = borderStroke3;
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                        borderStroke4 = borderStroke3;
                    }
                    j3 = jM1069contentColorForek8zF_U;
                    j4 = jM1055getSurface0d7_KjU;
                    modifier3 = modifier2;
                    i9 = i3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1412203386, i9, -1, "androidx.compose.material.Surface (Surface.kt:104)");
                }
                float fM5160constructorimpl5 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + fM5160constructorimpl);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl5))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1822160838, true, new SurfaceKt$Surface$1(modifier3, rectangleShape, j4, fM5160constructorimpl5, i9, borderStroke4, fM5160constructorimpl, interfaceC0526Fp)), composerStartRestartGroup, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                borderStroke5 = borderStroke4;
                shape2 = rectangleShape;
                j5 = j4;
                f2 = fM5160constructorimpl;
                j6 = j3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$2(modifier4, shape2, j5, j6, borderStroke5, f2, interfaceC0526Fp, i, i2));
        }
        i3 |= 48;
        rectangleShape = shape;
        if ((i & 896) == 0) {
            jM1055getSurface0d7_KjU = j;
            if ((i2 & 4) == 0) {
                i11 = 128;
            } else {
                i11 = 128;
            }
            i3 |= i11;
        } else {
            jM1055getSurface0d7_KjU = j;
        }
        if ((i & 7168) == 0) {
            jM1069contentColorForek8zF_U = j2;
            if ((i2 & 8) == 0) {
                i10 = 1024;
            } else {
                i10 = 1024;
            }
            i3 |= i10;
        } else {
            jM1069contentColorForek8zF_U = j2;
        }
        i4 = i2 & 16;
        if (i4 != 0) {
            i3 |= 24576;
            borderStroke2 = borderStroke;
        } else {
            borderStroke2 = borderStroke;
            if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changed(borderStroke2)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & 458752) == 0) {
            if (composerStartRestartGroup.changed(f)) {
                i7 = 131072;
            } else {
                i7 = 65536;
            }
            i3 |= i7;
        }
        if ((i2 & 64) != 0) {
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
            }
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i13 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke2;
                    }
                    if (i6 != 0) {
                        borderStroke4 = borderStroke3;
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                        borderStroke4 = borderStroke3;
                    }
                    j3 = jM1069contentColorForek8zF_U;
                    j4 = jM1055getSurface0d7_KjU;
                    modifier3 = modifier2;
                    i9 = i3;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i13 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke2;
                    }
                    if (i6 != 0) {
                        borderStroke4 = borderStroke3;
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                        borderStroke4 = borderStroke3;
                    }
                    j3 = jM1069contentColorForek8zF_U;
                    j4 = jM1055getSurface0d7_KjU;
                    modifier3 = modifier2;
                    i9 = i3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1412203386, i9, -1, "androidx.compose.material.Surface (Surface.kt:104)");
                }
                float fM5160constructorimpl6 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + fM5160constructorimpl);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl6))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1822160838, true, new SurfaceKt$Surface$1(modifier3, rectangleShape, j4, fM5160constructorimpl6, i9, borderStroke4, fM5160constructorimpl, interfaceC0526Fp)), composerStartRestartGroup, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                borderStroke5 = borderStroke4;
                shape2 = rectangleShape;
                j5 = j4;
                f2 = fM5160constructorimpl;
                j6 = j3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i13 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke2;
                    }
                    if (i6 != 0) {
                        borderStroke4 = borderStroke3;
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                        borderStroke4 = borderStroke3;
                    }
                    j3 = jM1069contentColorForek8zF_U;
                    j4 = jM1055getSurface0d7_KjU;
                    modifier3 = modifier2;
                    i9 = i3;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i13 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke2;
                    }
                    if (i6 != 0) {
                        borderStroke4 = borderStroke3;
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                        borderStroke4 = borderStroke3;
                    }
                    j3 = jM1069contentColorForek8zF_U;
                    j4 = jM1055getSurface0d7_KjU;
                    modifier3 = modifier2;
                    i9 = i3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1412203386, i9, -1, "androidx.compose.material.Surface (Surface.kt:104)");
                }
                float fM5160constructorimpl7 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + fM5160constructorimpl);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl7))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1822160838, true, new SurfaceKt$Surface$1(modifier3, rectangleShape, j4, fM5160constructorimpl7, i9, borderStroke4, fM5160constructorimpl, interfaceC0526Fp)), composerStartRestartGroup, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                borderStroke5 = borderStroke4;
                shape2 = rectangleShape;
                j5 = j4;
                f2 = fM5160constructorimpl;
                j6 = j3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$2(modifier4, shape2, j5, j6, borderStroke5, f2, interfaceC0526Fp, i, i2));
        }
        i8 = 1572864;
        i3 |= i8;
        if ((i3 & 2995931) == 599186) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i13 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                if ((i2 & 4) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    borderStroke3 = null;
                } else {
                    borderStroke3 = borderStroke2;
                }
                if (i6 != 0) {
                    borderStroke4 = borderStroke3;
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                } else {
                    fM5160constructorimpl = f;
                    borderStroke4 = borderStroke3;
                }
                j3 = jM1069contentColorForek8zF_U;
                j4 = jM1055getSurface0d7_KjU;
                modifier3 = modifier2;
                i9 = i3;
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i13 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                if ((i2 & 4) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    borderStroke3 = null;
                } else {
                    borderStroke3 = borderStroke2;
                }
                if (i6 != 0) {
                    borderStroke4 = borderStroke3;
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                } else {
                    fM5160constructorimpl = f;
                    borderStroke4 = borderStroke3;
                }
                j3 = jM1069contentColorForek8zF_U;
                j4 = jM1055getSurface0d7_KjU;
                modifier3 = modifier2;
                i9 = i3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1412203386, i9, -1, "androidx.compose.material.Surface (Surface.kt:104)");
            }
            float fM5160constructorimpl8 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + fM5160constructorimpl);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl8))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1822160838, true, new SurfaceKt$Surface$1(modifier3, rectangleShape, j4, fM5160constructorimpl8, i9, borderStroke4, fM5160constructorimpl, interfaceC0526Fp)), composerStartRestartGroup, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            borderStroke5 = borderStroke4;
            shape2 = rectangleShape;
            j5 = j4;
            f2 = fM5160constructorimpl;
            j6 = j3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i13 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                if ((i2 & 4) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    borderStroke3 = null;
                } else {
                    borderStroke3 = borderStroke2;
                }
                if (i6 != 0) {
                    borderStroke4 = borderStroke3;
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                } else {
                    fM5160constructorimpl = f;
                    borderStroke4 = borderStroke3;
                }
                j3 = jM1069contentColorForek8zF_U;
                j4 = jM1055getSurface0d7_KjU;
                modifier3 = modifier2;
                i9 = i3;
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i13 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                if ((i2 & 4) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    borderStroke3 = null;
                } else {
                    borderStroke3 = borderStroke2;
                }
                if (i6 != 0) {
                    borderStroke4 = borderStroke3;
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                } else {
                    fM5160constructorimpl = f;
                    borderStroke4 = borderStroke3;
                }
                j3 = jM1069contentColorForek8zF_U;
                j4 = jM1055getSurface0d7_KjU;
                modifier3 = modifier2;
                i9 = i3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1412203386, i9, -1, "androidx.compose.material.Surface (Surface.kt:104)");
            }
            float fM5160constructorimpl9 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + fM5160constructorimpl);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl9))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1822160838, true, new SurfaceKt$Surface$1(modifier3, rectangleShape, j4, fM5160constructorimpl9, i9, borderStroke4, fM5160constructorimpl, interfaceC0526Fp)), composerStartRestartGroup, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            borderStroke5 = borderStroke4;
            shape2 = rectangleShape;
            j5 = j4;
            f2 = fM5160constructorimpl;
            j6 = j3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$2(modifier4, shape2, j5, j6, borderStroke5, f2, interfaceC0526Fp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0135  */
    /* JADX WARN: Code duplicated, block: B:103:0x013b  */
    /* JADX WARN: Code duplicated, block: B:104:0x013e  */
    /* JADX WARN: Code duplicated, block: B:107:0x014a  */
    /* JADX WARN: Code duplicated, block: B:111:0x0162  */
    /* JADX WARN: Code duplicated, block: B:113:0x0170  */
    /* JADX WARN: Code duplicated, block: B:123:0x01ac A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:124:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:125:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:127:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:128:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:130:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:132:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:135:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:136:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:139:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:141:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:143:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:145:0x0207  */
    /* JADX WARN: Code duplicated, block: B:147:0x0219  */
    /* JADX WARN: Code duplicated, block: B:150:0x0237  */
    /* JADX WARN: Code duplicated, block: B:153:0x0245  */
    /* JADX WARN: Code duplicated, block: B:156:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:161:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0079  */
    /* JADX WARN: Code duplicated, block: B:38:0x007e  */
    /* JADX WARN: Code duplicated, block: B:40:0x0082  */
    /* JADX WARN: Code duplicated, block: B:42:0x008a  */
    /* JADX WARN: Code duplicated, block: B:43:0x008d  */
    /* JADX WARN: Code duplicated, block: B:47:0x0098  */
    /* JADX WARN: Code duplicated, block: B:49:0x009e  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:68:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:70:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:77:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:80:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:82:0x0102  */
    /* JADX WARN: Code duplicated, block: B:83:0x0105  */
    /* JADX WARN: Code duplicated, block: B:87:0x010c  */
    /* JADX WARN: Code duplicated, block: B:88:0x0113  */
    /* JADX WARN: Code duplicated, block: B:90:0x011b  */
    /* JADX WARN: Code duplicated, block: B:92:0x0121  */
    /* JADX WARN: Code duplicated, block: B:93:0x0124  */
    /* JADX WARN: Code duplicated, block: B:97:0x012c  */
    /* JADX WARN: Code duplicated, block: B:99:0x0130  */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Surface-LPr_se0, reason: not valid java name */
    public static final void m1228SurfaceLPr_se0(InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z, Shape shape, long j, long j2, BorderStroke borderStroke, float f, MutableInteractionSource mutableInteractionSource, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        int i3;
        int i4;
        int i5;
        long jM1069contentColorForek8zF_U;
        int i6;
        BorderStroke borderStroke2;
        int i7;
        int i8;
        float fM5160constructorimpl;
        int i9;
        int i10;
        int i11;
        int i12;
        Modifier modifier2;
        boolean z2;
        Shape rectangleShape;
        int i13;
        long jM1055getSurface0d7_KjU;
        MutableInteractionSource mutableInteractionSource2;
        long j3;
        BorderStroke borderStroke3;
        long j4;
        int i14;
        float f2;
        Shape shape2;
        Modifier modifier3;
        Object objRememberedValue;
        Composer composer2;
        Modifier modifier4;
        boolean z3;
        Shape shape3;
        long j5;
        BorderStroke borderStroke4;
        MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i15;
        int i16;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(1560876237);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC3588op) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i17 = i2 & 2;
        if (i17 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i18 = 4 & i2;
        if (i18 == 0) {
            if ((i & 896) == 0) {
                i3 |= composerStartRestartGroup.changed(z) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    if (composerStartRestartGroup.changed(shape)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i & 57344) != 0) {
                    if ((i2 & 16) == 0 || !composerStartRestartGroup.changed(j)) {
                        i16 = 8192;
                    } else {
                        i16 = 16384;
                    }
                    i3 |= i16;
                }
                if ((i & 458752) == 0) {
                    jM1069contentColorForek8zF_U = j2;
                    if ((i2 & 32) == 0 || !composerStartRestartGroup.changed(jM1069contentColorForek8zF_U)) {
                        i15 = 65536;
                    } else {
                        i15 = 131072;
                    }
                    i3 |= i15;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i3 |= 1572864;
                    borderStroke2 = borderStroke;
                } else {
                    borderStroke2 = borderStroke;
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke2)) {
                            i7 = 1048576;
                        } else {
                            i7 = 524288;
                        }
                        i3 |= i7;
                    }
                }
                i8 = 128 & i2;
                if (i8 != 0) {
                    i3 |= 12582912;
                    fM5160constructorimpl = f;
                } else {
                    fM5160constructorimpl = f;
                    if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(fM5160constructorimpl)) {
                            i9 = 8388608;
                        } else {
                            i9 = 4194304;
                        }
                        i3 |= i9;
                    }
                }
                i10 = 256 & i2;
                if (i10 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                            i12 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i12 = 268435456;
                        }
                    }
                    if ((1533916891 & i3) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i17 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i18 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i4 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            } else {
                                rectangleShape = shape;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i13 = 32;
                            } else {
                                i13 = 32;
                                jM1055getSurface0d7_KjU = j;
                            }
                            if ((i13 & i2) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                                i3 &= -458753;
                            }
                            if (i6 != 0) {
                                borderStroke2 = null;
                            }
                            if (i8 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            }
                            if (i10 != 0) {
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
                            j3 = jM1055getSurface0d7_KjU;
                            borderStroke3 = borderStroke2;
                            j4 = jM1069contentColorForek8zF_U;
                            i14 = i3;
                            f2 = fM5160constructorimpl;
                            shape2 = rectangleShape;
                            modifier3 = modifier2;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((16 & i2) != 0) {
                                i3 &= -57345;
                            }
                            if ((32 & i2) != 0) {
                                modifier3 = modifier;
                                z2 = z;
                                shape2 = shape;
                                j3 = j;
                                mutableInteractionSource2 = mutableInteractionSource;
                                borderStroke3 = borderStroke2;
                                j4 = jM1069contentColorForek8zF_U;
                                f2 = fM5160constructorimpl;
                                i14 = (-458753) & i3;
                            } else {
                                modifier3 = modifier;
                                z2 = z;
                                shape2 = shape;
                                j3 = j;
                                mutableInteractionSource2 = mutableInteractionSource;
                                borderStroke3 = borderStroke2;
                                j4 = jM1069contentColorForek8zF_U;
                                i14 = i3;
                                f2 = fM5160constructorimpl;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1560876237, i14, -1, "androidx.compose.material.Surface (Surface.kt:211)");
                        }
                        float fM5160constructorimpl2 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                        composer2 = composerStartRestartGroup;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j4)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl2))}, ComposableLambdaKt.composableLambda(composer2, 2031491085, true, new SurfaceKt$Surface$4(modifier3, shape2, j3, fM5160constructorimpl2, i14, borderStroke3, f2, mutableInteractionSource2, z2, interfaceC3588op, interfaceC0526Fp)), composer2, 56);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z3 = z2;
                        shape3 = shape2;
                        j5 = j3;
                        jM1069contentColorForek8zF_U = j4;
                        borderStroke4 = borderStroke3;
                        fM5160constructorimpl = f2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier4 = modifier;
                        z3 = z;
                        shape3 = shape;
                        borderStroke4 = borderStroke2;
                        composer2 = composerStartRestartGroup;
                        j5 = j;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$5(interfaceC3588op, modifier4, z3, shape3, j5, jM1069contentColorForek8zF_U, borderStroke4, fM5160constructorimpl, mutableInteractionSource3, interfaceC0526Fp, i, i2));
                }
                i12 = 805306368;
                i3 |= i12;
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i18 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i13 = 32;
                        } else {
                            i13 = 32;
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i13 & i2) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        }
                        if (i6 != 0) {
                            borderStroke2 = null;
                        }
                        if (i8 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        if (i10 != 0) {
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
                        j3 = jM1055getSurface0d7_KjU;
                        borderStroke3 = borderStroke2;
                        j4 = jM1069contentColorForek8zF_U;
                        i14 = i3;
                        f2 = fM5160constructorimpl;
                        shape2 = rectangleShape;
                        modifier3 = modifier2;
                    } else {
                        if (i17 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i18 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i13 = 32;
                        } else {
                            i13 = 32;
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i13 & i2) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        }
                        if (i6 != 0) {
                            borderStroke2 = null;
                        }
                        if (i8 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        if (i10 != 0) {
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
                        j3 = jM1055getSurface0d7_KjU;
                        borderStroke3 = borderStroke2;
                        j4 = jM1069contentColorForek8zF_U;
                        i14 = i3;
                        f2 = fM5160constructorimpl;
                        shape2 = rectangleShape;
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1560876237, i14, -1, "androidx.compose.material.Surface (Surface.kt:211)");
                    }
                    float fM5160constructorimpl3 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                    composer2 = composerStartRestartGroup;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j4)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl3))}, ComposableLambdaKt.composableLambda(composer2, 2031491085, true, new SurfaceKt$Surface$4(modifier3, shape2, j3, fM5160constructorimpl3, i14, borderStroke3, f2, mutableInteractionSource2, z2, interfaceC3588op, interfaceC0526Fp)), composer2, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z3 = z2;
                    shape3 = shape2;
                    j5 = j3;
                    jM1069contentColorForek8zF_U = j4;
                    borderStroke4 = borderStroke3;
                    fM5160constructorimpl = f2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i18 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i13 = 32;
                        } else {
                            i13 = 32;
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i13 & i2) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        }
                        if (i6 != 0) {
                            borderStroke2 = null;
                        }
                        if (i8 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        if (i10 != 0) {
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
                        j3 = jM1055getSurface0d7_KjU;
                        borderStroke3 = borderStroke2;
                        j4 = jM1069contentColorForek8zF_U;
                        i14 = i3;
                        f2 = fM5160constructorimpl;
                        shape2 = rectangleShape;
                        modifier3 = modifier2;
                    } else {
                        if (i17 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i18 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i13 = 32;
                        } else {
                            i13 = 32;
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i13 & i2) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        }
                        if (i6 != 0) {
                            borderStroke2 = null;
                        }
                        if (i8 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        if (i10 != 0) {
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
                        j3 = jM1055getSurface0d7_KjU;
                        borderStroke3 = borderStroke2;
                        j4 = jM1069contentColorForek8zF_U;
                        i14 = i3;
                        f2 = fM5160constructorimpl;
                        shape2 = rectangleShape;
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1560876237, i14, -1, "androidx.compose.material.Surface (Surface.kt:211)");
                    }
                    float fM5160constructorimpl4 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                    composer2 = composerStartRestartGroup;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j4)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl4))}, ComposableLambdaKt.composableLambda(composer2, 2031491085, true, new SurfaceKt$Surface$4(modifier3, shape2, j3, fM5160constructorimpl4, i14, borderStroke3, f2, mutableInteractionSource2, z2, interfaceC3588op, interfaceC0526Fp)), composer2, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z3 = z2;
                    shape3 = shape2;
                    j5 = j3;
                    jM1069contentColorForek8zF_U = j4;
                    borderStroke4 = borderStroke3;
                    fM5160constructorimpl = f2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$5(interfaceC3588op, modifier4, z3, shape3, j5, jM1069contentColorForek8zF_U, borderStroke4, fM5160constructorimpl, mutableInteractionSource3, interfaceC0526Fp, i, i2));
            }
            i3 |= 3072;
            if ((i & 57344) != 0) {
                if ((i2 & 16) == 0) {
                    i16 = 8192;
                } else {
                    i16 = 8192;
                }
                i3 |= i16;
            }
            if ((i & 458752) == 0) {
                jM1069contentColorForek8zF_U = j2;
                if ((i2 & 32) == 0) {
                    i15 = 65536;
                } else {
                    i15 = 65536;
                }
                i3 |= i15;
            } else {
                jM1069contentColorForek8zF_U = j2;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
                borderStroke2 = borderStroke;
            } else {
                borderStroke2 = borderStroke;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
            }
            i8 = 128 & i2;
            if (i8 != 0) {
                i3 |= 12582912;
                fM5160constructorimpl = f;
            } else {
                fM5160constructorimpl = f;
                if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(fM5160constructorimpl)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
            }
            i10 = 256 & i2;
            if (i10 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i12 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i12 = 268435456;
                    }
                }
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i18 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i13 = 32;
                        } else {
                            i13 = 32;
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i13 & i2) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        }
                        if (i6 != 0) {
                            borderStroke2 = null;
                        }
                        if (i8 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        if (i10 != 0) {
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
                        j3 = jM1055getSurface0d7_KjU;
                        borderStroke3 = borderStroke2;
                        j4 = jM1069contentColorForek8zF_U;
                        i14 = i3;
                        f2 = fM5160constructorimpl;
                        shape2 = rectangleShape;
                        modifier3 = modifier2;
                    } else {
                        if (i17 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i18 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i13 = 32;
                        } else {
                            i13 = 32;
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i13 & i2) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        }
                        if (i6 != 0) {
                            borderStroke2 = null;
                        }
                        if (i8 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        if (i10 != 0) {
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
                        j3 = jM1055getSurface0d7_KjU;
                        borderStroke3 = borderStroke2;
                        j4 = jM1069contentColorForek8zF_U;
                        i14 = i3;
                        f2 = fM5160constructorimpl;
                        shape2 = rectangleShape;
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1560876237, i14, -1, "androidx.compose.material.Surface (Surface.kt:211)");
                    }
                    float fM5160constructorimpl5 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                    composer2 = composerStartRestartGroup;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j4)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl5))}, ComposableLambdaKt.composableLambda(composer2, 2031491085, true, new SurfaceKt$Surface$4(modifier3, shape2, j3, fM5160constructorimpl5, i14, borderStroke3, f2, mutableInteractionSource2, z2, interfaceC3588op, interfaceC0526Fp)), composer2, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z3 = z2;
                    shape3 = shape2;
                    j5 = j3;
                    jM1069contentColorForek8zF_U = j4;
                    borderStroke4 = borderStroke3;
                    fM5160constructorimpl = f2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i18 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i13 = 32;
                        } else {
                            i13 = 32;
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i13 & i2) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        }
                        if (i6 != 0) {
                            borderStroke2 = null;
                        }
                        if (i8 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        if (i10 != 0) {
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
                        j3 = jM1055getSurface0d7_KjU;
                        borderStroke3 = borderStroke2;
                        j4 = jM1069contentColorForek8zF_U;
                        i14 = i3;
                        f2 = fM5160constructorimpl;
                        shape2 = rectangleShape;
                        modifier3 = modifier2;
                    } else {
                        if (i17 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i18 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i13 = 32;
                        } else {
                            i13 = 32;
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i13 & i2) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        }
                        if (i6 != 0) {
                            borderStroke2 = null;
                        }
                        if (i8 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        if (i10 != 0) {
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
                        j3 = jM1055getSurface0d7_KjU;
                        borderStroke3 = borderStroke2;
                        j4 = jM1069contentColorForek8zF_U;
                        i14 = i3;
                        f2 = fM5160constructorimpl;
                        shape2 = rectangleShape;
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1560876237, i14, -1, "androidx.compose.material.Surface (Surface.kt:211)");
                    }
                    float fM5160constructorimpl6 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                    composer2 = composerStartRestartGroup;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j4)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl6))}, ComposableLambdaKt.composableLambda(composer2, 2031491085, true, new SurfaceKt$Surface$4(modifier3, shape2, j3, fM5160constructorimpl6, i14, borderStroke3, f2, mutableInteractionSource2, z2, interfaceC3588op, interfaceC0526Fp)), composer2, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z3 = z2;
                    shape3 = shape2;
                    j5 = j3;
                    jM1069contentColorForek8zF_U = j4;
                    borderStroke4 = borderStroke3;
                    fM5160constructorimpl = f2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$5(interfaceC3588op, modifier4, z3, shape3, j5, jM1069contentColorForek8zF_U, borderStroke4, fM5160constructorimpl, mutableInteractionSource3, interfaceC0526Fp, i, i2));
            }
            i12 = 805306368;
            i3 |= i12;
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i17 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i18 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i13 = 32;
                    } else {
                        i13 = 32;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i13 & i2) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    }
                    if (i6 != 0) {
                        borderStroke2 = null;
                    }
                    if (i8 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    if (i10 != 0) {
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
                    j3 = jM1055getSurface0d7_KjU;
                    borderStroke3 = borderStroke2;
                    j4 = jM1069contentColorForek8zF_U;
                    i14 = i3;
                    f2 = fM5160constructorimpl;
                    shape2 = rectangleShape;
                    modifier3 = modifier2;
                } else {
                    if (i17 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i18 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i13 = 32;
                    } else {
                        i13 = 32;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i13 & i2) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    }
                    if (i6 != 0) {
                        borderStroke2 = null;
                    }
                    if (i8 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    if (i10 != 0) {
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
                    j3 = jM1055getSurface0d7_KjU;
                    borderStroke3 = borderStroke2;
                    j4 = jM1069contentColorForek8zF_U;
                    i14 = i3;
                    f2 = fM5160constructorimpl;
                    shape2 = rectangleShape;
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1560876237, i14, -1, "androidx.compose.material.Surface (Surface.kt:211)");
                }
                float fM5160constructorimpl7 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                composer2 = composerStartRestartGroup;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j4)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl7))}, ComposableLambdaKt.composableLambda(composer2, 2031491085, true, new SurfaceKt$Surface$4(modifier3, shape2, j3, fM5160constructorimpl7, i14, borderStroke3, f2, mutableInteractionSource2, z2, interfaceC3588op, interfaceC0526Fp)), composer2, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z3 = z2;
                shape3 = shape2;
                j5 = j3;
                jM1069contentColorForek8zF_U = j4;
                borderStroke4 = borderStroke3;
                fM5160constructorimpl = f2;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i17 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i18 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i13 = 32;
                    } else {
                        i13 = 32;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i13 & i2) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    }
                    if (i6 != 0) {
                        borderStroke2 = null;
                    }
                    if (i8 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    if (i10 != 0) {
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
                    j3 = jM1055getSurface0d7_KjU;
                    borderStroke3 = borderStroke2;
                    j4 = jM1069contentColorForek8zF_U;
                    i14 = i3;
                    f2 = fM5160constructorimpl;
                    shape2 = rectangleShape;
                    modifier3 = modifier2;
                } else {
                    if (i17 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i18 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i13 = 32;
                    } else {
                        i13 = 32;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i13 & i2) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    }
                    if (i6 != 0) {
                        borderStroke2 = null;
                    }
                    if (i8 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    if (i10 != 0) {
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
                    j3 = jM1055getSurface0d7_KjU;
                    borderStroke3 = borderStroke2;
                    j4 = jM1069contentColorForek8zF_U;
                    i14 = i3;
                    f2 = fM5160constructorimpl;
                    shape2 = rectangleShape;
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1560876237, i14, -1, "androidx.compose.material.Surface (Surface.kt:211)");
                }
                float fM5160constructorimpl8 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                composer2 = composerStartRestartGroup;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j4)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl8))}, ComposableLambdaKt.composableLambda(composer2, 2031491085, true, new SurfaceKt$Surface$4(modifier3, shape2, j3, fM5160constructorimpl8, i14, borderStroke3, f2, mutableInteractionSource2, z2, interfaceC3588op, interfaceC0526Fp)), composer2, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z3 = z2;
                shape3 = shape2;
                j5 = j3;
                jM1069contentColorForek8zF_U = j4;
                borderStroke4 = borderStroke3;
                fM5160constructorimpl = f2;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$5(interfaceC3588op, modifier4, z3, shape3, j5, jM1069contentColorForek8zF_U, borderStroke4, fM5160constructorimpl, mutableInteractionSource3, interfaceC0526Fp, i, i2));
        }
        i3 |= 384;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changed(shape)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i & 57344) != 0) {
                if ((i2 & 16) == 0) {
                    i16 = 8192;
                } else {
                    i16 = 8192;
                }
                i3 |= i16;
            }
            if ((i & 458752) == 0) {
                jM1069contentColorForek8zF_U = j2;
                if ((i2 & 32) == 0) {
                    i15 = 65536;
                } else {
                    i15 = 65536;
                }
                i3 |= i15;
            } else {
                jM1069contentColorForek8zF_U = j2;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
                borderStroke2 = borderStroke;
            } else {
                borderStroke2 = borderStroke;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
            }
            i8 = 128 & i2;
            if (i8 != 0) {
                i3 |= 12582912;
                fM5160constructorimpl = f;
            } else {
                fM5160constructorimpl = f;
                if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(fM5160constructorimpl)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
            }
            i10 = 256 & i2;
            if (i10 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i12 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i12 = 268435456;
                    }
                }
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i18 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i13 = 32;
                        } else {
                            i13 = 32;
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i13 & i2) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        }
                        if (i6 != 0) {
                            borderStroke2 = null;
                        }
                        if (i8 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        if (i10 != 0) {
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
                        j3 = jM1055getSurface0d7_KjU;
                        borderStroke3 = borderStroke2;
                        j4 = jM1069contentColorForek8zF_U;
                        i14 = i3;
                        f2 = fM5160constructorimpl;
                        shape2 = rectangleShape;
                        modifier3 = modifier2;
                    } else {
                        if (i17 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i18 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i13 = 32;
                        } else {
                            i13 = 32;
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i13 & i2) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        }
                        if (i6 != 0) {
                            borderStroke2 = null;
                        }
                        if (i8 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        if (i10 != 0) {
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
                        j3 = jM1055getSurface0d7_KjU;
                        borderStroke3 = borderStroke2;
                        j4 = jM1069contentColorForek8zF_U;
                        i14 = i3;
                        f2 = fM5160constructorimpl;
                        shape2 = rectangleShape;
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1560876237, i14, -1, "androidx.compose.material.Surface (Surface.kt:211)");
                    }
                    float fM5160constructorimpl9 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                    composer2 = composerStartRestartGroup;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j4)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl9))}, ComposableLambdaKt.composableLambda(composer2, 2031491085, true, new SurfaceKt$Surface$4(modifier3, shape2, j3, fM5160constructorimpl9, i14, borderStroke3, f2, mutableInteractionSource2, z2, interfaceC3588op, interfaceC0526Fp)), composer2, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z3 = z2;
                    shape3 = shape2;
                    j5 = j3;
                    jM1069contentColorForek8zF_U = j4;
                    borderStroke4 = borderStroke3;
                    fM5160constructorimpl = f2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i18 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i13 = 32;
                        } else {
                            i13 = 32;
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i13 & i2) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        }
                        if (i6 != 0) {
                            borderStroke2 = null;
                        }
                        if (i8 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        if (i10 != 0) {
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
                        j3 = jM1055getSurface0d7_KjU;
                        borderStroke3 = borderStroke2;
                        j4 = jM1069contentColorForek8zF_U;
                        i14 = i3;
                        f2 = fM5160constructorimpl;
                        shape2 = rectangleShape;
                        modifier3 = modifier2;
                    } else {
                        if (i17 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i18 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i13 = 32;
                        } else {
                            i13 = 32;
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i13 & i2) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        }
                        if (i6 != 0) {
                            borderStroke2 = null;
                        }
                        if (i8 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        if (i10 != 0) {
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
                        j3 = jM1055getSurface0d7_KjU;
                        borderStroke3 = borderStroke2;
                        j4 = jM1069contentColorForek8zF_U;
                        i14 = i3;
                        f2 = fM5160constructorimpl;
                        shape2 = rectangleShape;
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1560876237, i14, -1, "androidx.compose.material.Surface (Surface.kt:211)");
                    }
                    float fM5160constructorimpl10 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                    composer2 = composerStartRestartGroup;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j4)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl10))}, ComposableLambdaKt.composableLambda(composer2, 2031491085, true, new SurfaceKt$Surface$4(modifier3, shape2, j3, fM5160constructorimpl10, i14, borderStroke3, f2, mutableInteractionSource2, z2, interfaceC3588op, interfaceC0526Fp)), composer2, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z3 = z2;
                    shape3 = shape2;
                    j5 = j3;
                    jM1069contentColorForek8zF_U = j4;
                    borderStroke4 = borderStroke3;
                    fM5160constructorimpl = f2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$5(interfaceC3588op, modifier4, z3, shape3, j5, jM1069contentColorForek8zF_U, borderStroke4, fM5160constructorimpl, mutableInteractionSource3, interfaceC0526Fp, i, i2));
            }
            i12 = 805306368;
            i3 |= i12;
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i17 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i18 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i13 = 32;
                    } else {
                        i13 = 32;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i13 & i2) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    }
                    if (i6 != 0) {
                        borderStroke2 = null;
                    }
                    if (i8 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    if (i10 != 0) {
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
                    j3 = jM1055getSurface0d7_KjU;
                    borderStroke3 = borderStroke2;
                    j4 = jM1069contentColorForek8zF_U;
                    i14 = i3;
                    f2 = fM5160constructorimpl;
                    shape2 = rectangleShape;
                    modifier3 = modifier2;
                } else {
                    if (i17 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i18 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i13 = 32;
                    } else {
                        i13 = 32;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i13 & i2) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    }
                    if (i6 != 0) {
                        borderStroke2 = null;
                    }
                    if (i8 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    if (i10 != 0) {
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
                    j3 = jM1055getSurface0d7_KjU;
                    borderStroke3 = borderStroke2;
                    j4 = jM1069contentColorForek8zF_U;
                    i14 = i3;
                    f2 = fM5160constructorimpl;
                    shape2 = rectangleShape;
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1560876237, i14, -1, "androidx.compose.material.Surface (Surface.kt:211)");
                }
                float fM5160constructorimpl11 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                composer2 = composerStartRestartGroup;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j4)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl11))}, ComposableLambdaKt.composableLambda(composer2, 2031491085, true, new SurfaceKt$Surface$4(modifier3, shape2, j3, fM5160constructorimpl11, i14, borderStroke3, f2, mutableInteractionSource2, z2, interfaceC3588op, interfaceC0526Fp)), composer2, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z3 = z2;
                shape3 = shape2;
                j5 = j3;
                jM1069contentColorForek8zF_U = j4;
                borderStroke4 = borderStroke3;
                fM5160constructorimpl = f2;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i17 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i18 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i13 = 32;
                    } else {
                        i13 = 32;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i13 & i2) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    }
                    if (i6 != 0) {
                        borderStroke2 = null;
                    }
                    if (i8 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    if (i10 != 0) {
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
                    j3 = jM1055getSurface0d7_KjU;
                    borderStroke3 = borderStroke2;
                    j4 = jM1069contentColorForek8zF_U;
                    i14 = i3;
                    f2 = fM5160constructorimpl;
                    shape2 = rectangleShape;
                    modifier3 = modifier2;
                } else {
                    if (i17 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i18 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i13 = 32;
                    } else {
                        i13 = 32;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i13 & i2) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    }
                    if (i6 != 0) {
                        borderStroke2 = null;
                    }
                    if (i8 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    if (i10 != 0) {
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
                    j3 = jM1055getSurface0d7_KjU;
                    borderStroke3 = borderStroke2;
                    j4 = jM1069contentColorForek8zF_U;
                    i14 = i3;
                    f2 = fM5160constructorimpl;
                    shape2 = rectangleShape;
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1560876237, i14, -1, "androidx.compose.material.Surface (Surface.kt:211)");
                }
                float fM5160constructorimpl12 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                composer2 = composerStartRestartGroup;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j4)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl12))}, ComposableLambdaKt.composableLambda(composer2, 2031491085, true, new SurfaceKt$Surface$4(modifier3, shape2, j3, fM5160constructorimpl12, i14, borderStroke3, f2, mutableInteractionSource2, z2, interfaceC3588op, interfaceC0526Fp)), composer2, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z3 = z2;
                shape3 = shape2;
                j5 = j3;
                jM1069contentColorForek8zF_U = j4;
                borderStroke4 = borderStroke3;
                fM5160constructorimpl = f2;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$5(interfaceC3588op, modifier4, z3, shape3, j5, jM1069contentColorForek8zF_U, borderStroke4, fM5160constructorimpl, mutableInteractionSource3, interfaceC0526Fp, i, i2));
        }
        i3 |= 3072;
        if ((i & 57344) != 0) {
            if ((i2 & 16) == 0) {
                i16 = 8192;
            } else {
                i16 = 8192;
            }
            i3 |= i16;
        }
        if ((i & 458752) == 0) {
            jM1069contentColorForek8zF_U = j2;
            if ((i2 & 32) == 0) {
                i15 = 65536;
            } else {
                i15 = 65536;
            }
            i3 |= i15;
        } else {
            jM1069contentColorForek8zF_U = j2;
        }
        i6 = i2 & 64;
        if (i6 != 0) {
            i3 |= 1572864;
            borderStroke2 = borderStroke;
        } else {
            borderStroke2 = borderStroke;
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(borderStroke2)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
        }
        i8 = 128 & i2;
        if (i8 != 0) {
            i3 |= 12582912;
            fM5160constructorimpl = f;
        } else {
            fM5160constructorimpl = f;
            if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(fM5160constructorimpl)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
        }
        i10 = 256 & i2;
        if (i10 != 0) {
            i3 |= 100663296;
        } else if ((i & 234881024) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i11 = 67108864;
            } else {
                i11 = 33554432;
            }
            i3 |= i11;
        }
        if ((i2 & 512) != 0) {
            if ((1879048192 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i12 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i12 = 268435456;
                }
            }
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i17 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i18 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i13 = 32;
                    } else {
                        i13 = 32;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i13 & i2) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    }
                    if (i6 != 0) {
                        borderStroke2 = null;
                    }
                    if (i8 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    if (i10 != 0) {
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
                    j3 = jM1055getSurface0d7_KjU;
                    borderStroke3 = borderStroke2;
                    j4 = jM1069contentColorForek8zF_U;
                    i14 = i3;
                    f2 = fM5160constructorimpl;
                    shape2 = rectangleShape;
                    modifier3 = modifier2;
                } else {
                    if (i17 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i18 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i13 = 32;
                    } else {
                        i13 = 32;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i13 & i2) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    }
                    if (i6 != 0) {
                        borderStroke2 = null;
                    }
                    if (i8 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    if (i10 != 0) {
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
                    j3 = jM1055getSurface0d7_KjU;
                    borderStroke3 = borderStroke2;
                    j4 = jM1069contentColorForek8zF_U;
                    i14 = i3;
                    f2 = fM5160constructorimpl;
                    shape2 = rectangleShape;
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1560876237, i14, -1, "androidx.compose.material.Surface (Surface.kt:211)");
                }
                float fM5160constructorimpl13 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                composer2 = composerStartRestartGroup;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j4)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl13))}, ComposableLambdaKt.composableLambda(composer2, 2031491085, true, new SurfaceKt$Surface$4(modifier3, shape2, j3, fM5160constructorimpl13, i14, borderStroke3, f2, mutableInteractionSource2, z2, interfaceC3588op, interfaceC0526Fp)), composer2, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z3 = z2;
                shape3 = shape2;
                j5 = j3;
                jM1069contentColorForek8zF_U = j4;
                borderStroke4 = borderStroke3;
                fM5160constructorimpl = f2;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i17 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i18 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i13 = 32;
                    } else {
                        i13 = 32;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i13 & i2) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    }
                    if (i6 != 0) {
                        borderStroke2 = null;
                    }
                    if (i8 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    if (i10 != 0) {
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
                    j3 = jM1055getSurface0d7_KjU;
                    borderStroke3 = borderStroke2;
                    j4 = jM1069contentColorForek8zF_U;
                    i14 = i3;
                    f2 = fM5160constructorimpl;
                    shape2 = rectangleShape;
                    modifier3 = modifier2;
                } else {
                    if (i17 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i18 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i13 = 32;
                    } else {
                        i13 = 32;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i13 & i2) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    }
                    if (i6 != 0) {
                        borderStroke2 = null;
                    }
                    if (i8 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    if (i10 != 0) {
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
                    j3 = jM1055getSurface0d7_KjU;
                    borderStroke3 = borderStroke2;
                    j4 = jM1069contentColorForek8zF_U;
                    i14 = i3;
                    f2 = fM5160constructorimpl;
                    shape2 = rectangleShape;
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1560876237, i14, -1, "androidx.compose.material.Surface (Surface.kt:211)");
                }
                float fM5160constructorimpl14 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                composer2 = composerStartRestartGroup;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j4)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl14))}, ComposableLambdaKt.composableLambda(composer2, 2031491085, true, new SurfaceKt$Surface$4(modifier3, shape2, j3, fM5160constructorimpl14, i14, borderStroke3, f2, mutableInteractionSource2, z2, interfaceC3588op, interfaceC0526Fp)), composer2, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z3 = z2;
                shape3 = shape2;
                j5 = j3;
                jM1069contentColorForek8zF_U = j4;
                borderStroke4 = borderStroke3;
                fM5160constructorimpl = f2;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$5(interfaceC3588op, modifier4, z3, shape3, j5, jM1069contentColorForek8zF_U, borderStroke4, fM5160constructorimpl, mutableInteractionSource3, interfaceC0526Fp, i, i2));
        }
        i12 = 805306368;
        i3 |= i12;
        if ((1533916891 & i3) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i17 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i18 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if (i4 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = shape;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i13 = 32;
                } else {
                    i13 = 32;
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i13 & i2) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                    i3 &= -458753;
                }
                if (i6 != 0) {
                    borderStroke2 = null;
                }
                if (i8 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                if (i10 != 0) {
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
                j3 = jM1055getSurface0d7_KjU;
                borderStroke3 = borderStroke2;
                j4 = jM1069contentColorForek8zF_U;
                i14 = i3;
                f2 = fM5160constructorimpl;
                shape2 = rectangleShape;
                modifier3 = modifier2;
            } else {
                if (i17 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i18 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if (i4 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = shape;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i13 = 32;
                } else {
                    i13 = 32;
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i13 & i2) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                    i3 &= -458753;
                }
                if (i6 != 0) {
                    borderStroke2 = null;
                }
                if (i8 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                if (i10 != 0) {
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
                j3 = jM1055getSurface0d7_KjU;
                borderStroke3 = borderStroke2;
                j4 = jM1069contentColorForek8zF_U;
                i14 = i3;
                f2 = fM5160constructorimpl;
                shape2 = rectangleShape;
                modifier3 = modifier2;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1560876237, i14, -1, "androidx.compose.material.Surface (Surface.kt:211)");
            }
            float fM5160constructorimpl15 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
            composer2 = composerStartRestartGroup;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j4)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl15))}, ComposableLambdaKt.composableLambda(composer2, 2031491085, true, new SurfaceKt$Surface$4(modifier3, shape2, j3, fM5160constructorimpl15, i14, borderStroke3, f2, mutableInteractionSource2, z2, interfaceC3588op, interfaceC0526Fp)), composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            z3 = z2;
            shape3 = shape2;
            j5 = j3;
            jM1069contentColorForek8zF_U = j4;
            borderStroke4 = borderStroke3;
            fM5160constructorimpl = f2;
            mutableInteractionSource3 = mutableInteractionSource2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i17 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i18 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if (i4 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = shape;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i13 = 32;
                } else {
                    i13 = 32;
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i13 & i2) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                    i3 &= -458753;
                }
                if (i6 != 0) {
                    borderStroke2 = null;
                }
                if (i8 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                if (i10 != 0) {
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
                j3 = jM1055getSurface0d7_KjU;
                borderStroke3 = borderStroke2;
                j4 = jM1069contentColorForek8zF_U;
                i14 = i3;
                f2 = fM5160constructorimpl;
                shape2 = rectangleShape;
                modifier3 = modifier2;
            } else {
                if (i17 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i18 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if (i4 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = shape;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i13 = 32;
                } else {
                    i13 = 32;
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i13 & i2) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                    i3 &= -458753;
                }
                if (i6 != 0) {
                    borderStroke2 = null;
                }
                if (i8 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                if (i10 != 0) {
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
                j3 = jM1055getSurface0d7_KjU;
                borderStroke3 = borderStroke2;
                j4 = jM1069contentColorForek8zF_U;
                i14 = i3;
                f2 = fM5160constructorimpl;
                shape2 = rectangleShape;
                modifier3 = modifier2;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1560876237, i14, -1, "androidx.compose.material.Surface (Surface.kt:211)");
            }
            float fM5160constructorimpl16 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
            composer2 = composerStartRestartGroup;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j4)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl16))}, ComposableLambdaKt.composableLambda(composer2, 2031491085, true, new SurfaceKt$Surface$4(modifier3, shape2, j3, fM5160constructorimpl16, i14, borderStroke3, f2, mutableInteractionSource2, z2, interfaceC3588op, interfaceC0526Fp)), composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            z3 = z2;
            shape3 = shape2;
            j5 = j3;
            jM1069contentColorForek8zF_U = j4;
            borderStroke4 = borderStroke3;
            fM5160constructorimpl = f2;
            mutableInteractionSource3 = mutableInteractionSource2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$5(interfaceC3588op, modifier4, z3, shape3, j5, jM1069contentColorForek8zF_U, borderStroke4, fM5160constructorimpl, mutableInteractionSource3, interfaceC0526Fp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x013b  */
    /* JADX WARN: Code duplicated, block: B:103:0x0143  */
    /* JADX WARN: Code duplicated, block: B:105:0x0149  */
    /* JADX WARN: Code duplicated, block: B:106:0x014c  */
    /* JADX WARN: Code duplicated, block: B:110:0x0153  */
    /* JADX WARN: Code duplicated, block: B:111:0x0159  */
    /* JADX WARN: Code duplicated, block: B:113:0x015d  */
    /* JADX WARN: Code duplicated, block: B:115:0x0163  */
    /* JADX WARN: Code duplicated, block: B:116:0x0165  */
    /* JADX WARN: Code duplicated, block: B:118:0x0169  */
    /* JADX WARN: Code duplicated, block: B:121:0x0175  */
    /* JADX WARN: Code duplicated, block: B:127:0x0195  */
    /* JADX WARN: Code duplicated, block: B:129:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:139:0x01cc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:140:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:141:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:143:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:145:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:147:0x01de  */
    /* JADX WARN: Code duplicated, block: B:150:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:151:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:154:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:155:0x020b  */
    /* JADX WARN: Code duplicated, block: B:157:0x020f  */
    /* JADX WARN: Code duplicated, block: B:158:0x0211  */
    /* JADX WARN: Code duplicated, block: B:160:0x0215  */
    /* JADX WARN: Code duplicated, block: B:161:0x021c  */
    /* JADX WARN: Code duplicated, block: B:163:0x0220  */
    /* JADX WARN: Code duplicated, block: B:165:0x0232  */
    /* JADX WARN: Code duplicated, block: B:168:0x0250  */
    /* JADX WARN: Code duplicated, block: B:171:0x025c  */
    /* JADX WARN: Code duplicated, block: B:174:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:179:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:181:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0085  */
    /* JADX WARN: Code duplicated, block: B:39:0x008a  */
    /* JADX WARN: Code duplicated, block: B:41:0x008e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0096  */
    /* JADX WARN: Code duplicated, block: B:44:0x0099  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:75:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:80:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:82:0x0100  */
    /* JADX WARN: Code duplicated, block: B:84:0x0108  */
    /* JADX WARN: Code duplicated, block: B:85:0x010b  */
    /* JADX WARN: Code duplicated, block: B:89:0x0112  */
    /* JADX WARN: Code duplicated, block: B:90:0x0119  */
    /* JADX WARN: Code duplicated, block: B:92:0x0121  */
    /* JADX WARN: Code duplicated, block: B:94:0x0127  */
    /* JADX WARN: Code duplicated, block: B:95:0x012a  */
    /* JADX WARN: Code duplicated, block: B:99:0x0132  */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Surface-Ny5ogXk, reason: not valid java name */
    public static final void m1229SurfaceNy5ogXk(boolean z, InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z2, Shape shape, long j, long j2, BorderStroke borderStroke, float f, MutableInteractionSource mutableInteractionSource, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2, int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        Modifier modifier3;
        Shape rectangleShape;
        long jM1055getSurface0d7_KjU;
        long jM1069contentColorForek8zF_U;
        BorderStroke borderStroke2;
        float fM5160constructorimpl;
        MutableInteractionSource mutableInteractionSource2;
        BorderStroke borderStroke3;
        float f2;
        Modifier modifier4;
        boolean z4;
        long j3;
        Shape shape2;
        int i17;
        long j4;
        Object objRememberedValue;
        Composer composer2;
        Modifier modifier5;
        boolean z5;
        Shape shape3;
        long j5;
        long j6;
        BorderStroke borderStroke4;
        float f3;
        MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i18;
        int i19;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(262027249);
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = i | (composerStartRestartGroup.changed(z) ? 4 : 2);
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC3588op) ? 32 : 16;
        }
        int i20 = i4;
        int i21 = i3 & 4;
        if (i21 == 0) {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i20 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i & 7168) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i20 |= i6;
                }
                i7 = 16 & i3;
                if (i7 != 0) {
                    i20 |= 24576;
                } else if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changed(shape)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i20 |= i8;
                }
                if ((i & 458752) != 0) {
                    if ((i3 & 32) == 0 || !composerStartRestartGroup.changed(j)) {
                        i19 = 65536;
                    } else {
                        i19 = 131072;
                    }
                    i20 |= i19;
                }
                if ((i & 3670016) != 0) {
                    if ((i3 & 64) == 0 || !composerStartRestartGroup.changed(j2)) {
                        i18 = 524288;
                    } else {
                        i18 = 1048576;
                    }
                    i20 |= i18;
                }
                i9 = 128 & i3;
                if (i9 != 0) {
                    if ((29360128 & i) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke)) {
                            i10 = 8388608;
                        } else {
                            i10 = 4194304;
                        }
                        i20 |= i10;
                    }
                    i11 = 256 & i3;
                    if (i11 != 0) {
                        i20 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changed(f)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                        i20 |= i12;
                    }
                    i13 = i3 & 512;
                    if (i13 != 0) {
                        i20 |= 805306368;
                    } else if ((i & 1879048192) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i14 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i14 = 268435456;
                        }
                        i20 |= i14;
                    }
                    if ((1024 & i3) != 0) {
                        i15 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                            i16 = 4;
                        } else {
                            i16 = 2;
                        }
                        i15 = i2 | i16;
                    } else {
                        i15 = i2;
                    }
                    if ((i20 & 1533916891) != 306783378 && (i15 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        shape3 = shape;
                        j5 = j;
                        mutableInteractionSource3 = mutableInteractionSource;
                        modifier5 = modifier2;
                        z5 = z3;
                        composer2 = composerStartRestartGroup;
                        j6 = j2;
                        borderStroke4 = borderStroke;
                        f3 = f;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i21 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i7 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            } else {
                                rectangleShape = shape;
                            }
                            if ((32 & i3) != 0) {
                                i20 &= -458753;
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            } else {
                                jM1055getSurface0d7_KjU = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                                i20 &= -3670017;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if (i11 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f;
                            }
                            if (i13 != 0) {
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
                            borderStroke3 = borderStroke2;
                            f2 = fM5160constructorimpl;
                            modifier4 = modifier3;
                            z4 = z3;
                            j3 = jM1069contentColorForek8zF_U;
                            shape2 = rectangleShape;
                            i17 = i20;
                            j4 = jM1055getSurface0d7_KjU;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((32 & i3) != 0) {
                                i20 &= -458753;
                            }
                            if ((i3 & 64) != 0) {
                                i20 &= -3670017;
                            }
                            shape2 = shape;
                            j4 = j;
                            j3 = j2;
                            borderStroke3 = borderStroke;
                            f2 = f;
                            mutableInteractionSource2 = mutableInteractionSource;
                            i17 = i20;
                            modifier4 = modifier2;
                            z4 = z3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(262027249, i17, i15, "androidx.compose.material.Surface (Surface.kt:324)");
                        }
                        float fM5160constructorimpl2 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                        composer2 = composerStartRestartGroup;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl2))}, ComposableLambdaKt.composableLambda(composer2, -1391199439, true, new SurfaceKt$Surface$7(modifier4, shape2, j4, fM5160constructorimpl2, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3588op, interfaceC0526Fp, i15)), composer2, 56);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        z5 = z4;
                        shape3 = shape2;
                        j5 = j4;
                        j6 = j3;
                        borderStroke4 = borderStroke3;
                        f3 = f2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$8(z, interfaceC3588op, modifier5, z5, shape3, j5, j6, borderStroke4, f3, mutableInteractionSource3, interfaceC0526Fp, i, i2, i3));
                }
                i20 |= 12582912;
                i11 = 256 & i3;
                if (i11 != 0) {
                    i20 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i20 |= i12;
                }
                i13 = i3 & 512;
                if (i13 != 0) {
                    i20 |= 805306368;
                } else if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i14 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i14 = 268435456;
                    }
                    i20 |= i14;
                }
                if ((1024 & i3) != 0) {
                    i15 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i15 = i2 | i16;
                } else {
                    i15 = i2;
                }
                if ((i20 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i21 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((32 & i3) != 0) {
                            i20 &= -458753;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                            i20 &= -3670017;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if (i13 != 0) {
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
                        borderStroke3 = borderStroke2;
                        f2 = fM5160constructorimpl;
                        modifier4 = modifier3;
                        z4 = z3;
                        j3 = jM1069contentColorForek8zF_U;
                        shape2 = rectangleShape;
                        i17 = i20;
                        j4 = jM1055getSurface0d7_KjU;
                    } else {
                        if (i21 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((32 & i3) != 0) {
                            i20 &= -458753;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                            i20 &= -3670017;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if (i13 != 0) {
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
                        borderStroke3 = borderStroke2;
                        f2 = fM5160constructorimpl;
                        modifier4 = modifier3;
                        z4 = z3;
                        j3 = jM1069contentColorForek8zF_U;
                        shape2 = rectangleShape;
                        i17 = i20;
                        j4 = jM1055getSurface0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(262027249, i17, i15, "androidx.compose.material.Surface (Surface.kt:324)");
                    }
                    float fM5160constructorimpl3 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                    composer2 = composerStartRestartGroup;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl3))}, ComposableLambdaKt.composableLambda(composer2, -1391199439, true, new SurfaceKt$Surface$7(modifier4, shape2, j4, fM5160constructorimpl3, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3588op, interfaceC0526Fp, i15)), composer2, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z5 = z4;
                    shape3 = shape2;
                    j5 = j4;
                    j6 = j3;
                    borderStroke4 = borderStroke3;
                    f3 = f2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i21 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((32 & i3) != 0) {
                            i20 &= -458753;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                            i20 &= -3670017;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if (i13 != 0) {
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
                        borderStroke3 = borderStroke2;
                        f2 = fM5160constructorimpl;
                        modifier4 = modifier3;
                        z4 = z3;
                        j3 = jM1069contentColorForek8zF_U;
                        shape2 = rectangleShape;
                        i17 = i20;
                        j4 = jM1055getSurface0d7_KjU;
                    } else {
                        if (i21 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((32 & i3) != 0) {
                            i20 &= -458753;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                            i20 &= -3670017;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if (i13 != 0) {
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
                        borderStroke3 = borderStroke2;
                        f2 = fM5160constructorimpl;
                        modifier4 = modifier3;
                        z4 = z3;
                        j3 = jM1069contentColorForek8zF_U;
                        shape2 = rectangleShape;
                        i17 = i20;
                        j4 = jM1055getSurface0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(262027249, i17, i15, "androidx.compose.material.Surface (Surface.kt:324)");
                    }
                    float fM5160constructorimpl4 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                    composer2 = composerStartRestartGroup;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl4))}, ComposableLambdaKt.composableLambda(composer2, -1391199439, true, new SurfaceKt$Surface$7(modifier4, shape2, j4, fM5160constructorimpl4, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3588op, interfaceC0526Fp, i15)), composer2, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z5 = z4;
                    shape3 = shape2;
                    j5 = j4;
                    j6 = j3;
                    borderStroke4 = borderStroke3;
                    f3 = f2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$8(z, interfaceC3588op, modifier5, z5, shape3, j5, j6, borderStroke4, f3, mutableInteractionSource3, interfaceC0526Fp, i, i2, i3));
            }
            i20 |= 3072;
            z3 = z2;
            i7 = 16 & i3;
            if (i7 != 0) {
                i20 |= 24576;
            } else if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changed(shape)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i20 |= i8;
            }
            if ((i & 458752) != 0) {
                if ((i3 & 32) == 0) {
                    i19 = 65536;
                } else {
                    i19 = 65536;
                }
                i20 |= i19;
            }
            if ((i & 3670016) != 0) {
                if ((i3 & 64) == 0) {
                    i18 = 524288;
                } else {
                    i18 = 524288;
                }
                i20 |= i18;
            }
            i9 = 128 & i3;
            if (i9 != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i20 |= i10;
                }
                i11 = 256 & i3;
                if (i11 != 0) {
                    i20 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i20 |= i12;
                }
                i13 = i3 & 512;
                if (i13 != 0) {
                    i20 |= 805306368;
                } else if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i14 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i14 = 268435456;
                    }
                    i20 |= i14;
                }
                if ((1024 & i3) != 0) {
                    i15 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i15 = i2 | i16;
                } else {
                    i15 = i2;
                }
                if ((i20 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i21 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((32 & i3) != 0) {
                            i20 &= -458753;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                            i20 &= -3670017;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if (i13 != 0) {
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
                        borderStroke3 = borderStroke2;
                        f2 = fM5160constructorimpl;
                        modifier4 = modifier3;
                        z4 = z3;
                        j3 = jM1069contentColorForek8zF_U;
                        shape2 = rectangleShape;
                        i17 = i20;
                        j4 = jM1055getSurface0d7_KjU;
                    } else {
                        if (i21 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((32 & i3) != 0) {
                            i20 &= -458753;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                            i20 &= -3670017;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if (i13 != 0) {
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
                        borderStroke3 = borderStroke2;
                        f2 = fM5160constructorimpl;
                        modifier4 = modifier3;
                        z4 = z3;
                        j3 = jM1069contentColorForek8zF_U;
                        shape2 = rectangleShape;
                        i17 = i20;
                        j4 = jM1055getSurface0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(262027249, i17, i15, "androidx.compose.material.Surface (Surface.kt:324)");
                    }
                    float fM5160constructorimpl5 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                    composer2 = composerStartRestartGroup;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl5))}, ComposableLambdaKt.composableLambda(composer2, -1391199439, true, new SurfaceKt$Surface$7(modifier4, shape2, j4, fM5160constructorimpl5, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3588op, interfaceC0526Fp, i15)), composer2, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z5 = z4;
                    shape3 = shape2;
                    j5 = j4;
                    j6 = j3;
                    borderStroke4 = borderStroke3;
                    f3 = f2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i21 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((32 & i3) != 0) {
                            i20 &= -458753;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                            i20 &= -3670017;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if (i13 != 0) {
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
                        borderStroke3 = borderStroke2;
                        f2 = fM5160constructorimpl;
                        modifier4 = modifier3;
                        z4 = z3;
                        j3 = jM1069contentColorForek8zF_U;
                        shape2 = rectangleShape;
                        i17 = i20;
                        j4 = jM1055getSurface0d7_KjU;
                    } else {
                        if (i21 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((32 & i3) != 0) {
                            i20 &= -458753;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                            i20 &= -3670017;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if (i13 != 0) {
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
                        borderStroke3 = borderStroke2;
                        f2 = fM5160constructorimpl;
                        modifier4 = modifier3;
                        z4 = z3;
                        j3 = jM1069contentColorForek8zF_U;
                        shape2 = rectangleShape;
                        i17 = i20;
                        j4 = jM1055getSurface0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(262027249, i17, i15, "androidx.compose.material.Surface (Surface.kt:324)");
                    }
                    float fM5160constructorimpl6 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                    composer2 = composerStartRestartGroup;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl6))}, ComposableLambdaKt.composableLambda(composer2, -1391199439, true, new SurfaceKt$Surface$7(modifier4, shape2, j4, fM5160constructorimpl6, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3588op, interfaceC0526Fp, i15)), composer2, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z5 = z4;
                    shape3 = shape2;
                    j5 = j4;
                    j6 = j3;
                    borderStroke4 = borderStroke3;
                    f3 = f2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$8(z, interfaceC3588op, modifier5, z5, shape3, j5, j6, borderStroke4, f3, mutableInteractionSource3, interfaceC0526Fp, i, i2, i3));
            }
            i20 |= 12582912;
            i11 = 256 & i3;
            if (i11 != 0) {
                i20 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i20 |= i12;
            }
            i13 = i3 & 512;
            if (i13 != 0) {
                i20 |= 805306368;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i14 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i14 = 268435456;
                }
                i20 |= i14;
            }
            if ((1024 & i3) != 0) {
                i15 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i15 = i2 | i16;
            } else {
                i15 = i2;
            }
            if ((i20 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i21 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((32 & i3) != 0) {
                        i20 &= -458753;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                        i20 &= -3670017;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i13 != 0) {
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
                    borderStroke3 = borderStroke2;
                    f2 = fM5160constructorimpl;
                    modifier4 = modifier3;
                    z4 = z3;
                    j3 = jM1069contentColorForek8zF_U;
                    shape2 = rectangleShape;
                    i17 = i20;
                    j4 = jM1055getSurface0d7_KjU;
                } else {
                    if (i21 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((32 & i3) != 0) {
                        i20 &= -458753;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                        i20 &= -3670017;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i13 != 0) {
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
                    borderStroke3 = borderStroke2;
                    f2 = fM5160constructorimpl;
                    modifier4 = modifier3;
                    z4 = z3;
                    j3 = jM1069contentColorForek8zF_U;
                    shape2 = rectangleShape;
                    i17 = i20;
                    j4 = jM1055getSurface0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(262027249, i17, i15, "androidx.compose.material.Surface (Surface.kt:324)");
                }
                float fM5160constructorimpl7 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                composer2 = composerStartRestartGroup;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl7))}, ComposableLambdaKt.composableLambda(composer2, -1391199439, true, new SurfaceKt$Surface$7(modifier4, shape2, j4, fM5160constructorimpl7, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3588op, interfaceC0526Fp, i15)), composer2, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z5 = z4;
                shape3 = shape2;
                j5 = j4;
                j6 = j3;
                borderStroke4 = borderStroke3;
                f3 = f2;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i21 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((32 & i3) != 0) {
                        i20 &= -458753;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                        i20 &= -3670017;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i13 != 0) {
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
                    borderStroke3 = borderStroke2;
                    f2 = fM5160constructorimpl;
                    modifier4 = modifier3;
                    z4 = z3;
                    j3 = jM1069contentColorForek8zF_U;
                    shape2 = rectangleShape;
                    i17 = i20;
                    j4 = jM1055getSurface0d7_KjU;
                } else {
                    if (i21 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((32 & i3) != 0) {
                        i20 &= -458753;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                        i20 &= -3670017;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i13 != 0) {
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
                    borderStroke3 = borderStroke2;
                    f2 = fM5160constructorimpl;
                    modifier4 = modifier3;
                    z4 = z3;
                    j3 = jM1069contentColorForek8zF_U;
                    shape2 = rectangleShape;
                    i17 = i20;
                    j4 = jM1055getSurface0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(262027249, i17, i15, "androidx.compose.material.Surface (Surface.kt:324)");
                }
                float fM5160constructorimpl8 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                composer2 = composerStartRestartGroup;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl8))}, ComposableLambdaKt.composableLambda(composer2, -1391199439, true, new SurfaceKt$Surface$7(modifier4, shape2, j4, fM5160constructorimpl8, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3588op, interfaceC0526Fp, i15)), composer2, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z5 = z4;
                shape3 = shape2;
                j5 = j4;
                j6 = j3;
                borderStroke4 = borderStroke3;
                f3 = f2;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$8(z, interfaceC3588op, modifier5, z5, shape3, j5, j6, borderStroke4, f3, mutableInteractionSource3, interfaceC0526Fp, i, i2, i3));
        }
        i20 |= 384;
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i & 7168) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i20 |= i6;
            }
            i7 = 16 & i3;
            if (i7 != 0) {
                i20 |= 24576;
            } else if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changed(shape)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i20 |= i8;
            }
            if ((i & 458752) != 0) {
                if ((i3 & 32) == 0) {
                    i19 = 65536;
                } else {
                    i19 = 65536;
                }
                i20 |= i19;
            }
            if ((i & 3670016) != 0) {
                if ((i3 & 64) == 0) {
                    i18 = 524288;
                } else {
                    i18 = 524288;
                }
                i20 |= i18;
            }
            i9 = 128 & i3;
            if (i9 != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i20 |= i10;
                }
                i11 = 256 & i3;
                if (i11 != 0) {
                    i20 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i20 |= i12;
                }
                i13 = i3 & 512;
                if (i13 != 0) {
                    i20 |= 805306368;
                } else if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i14 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i14 = 268435456;
                    }
                    i20 |= i14;
                }
                if ((1024 & i3) != 0) {
                    i15 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i15 = i2 | i16;
                } else {
                    i15 = i2;
                }
                if ((i20 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i21 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((32 & i3) != 0) {
                            i20 &= -458753;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                            i20 &= -3670017;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if (i13 != 0) {
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
                        borderStroke3 = borderStroke2;
                        f2 = fM5160constructorimpl;
                        modifier4 = modifier3;
                        z4 = z3;
                        j3 = jM1069contentColorForek8zF_U;
                        shape2 = rectangleShape;
                        i17 = i20;
                        j4 = jM1055getSurface0d7_KjU;
                    } else {
                        if (i21 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((32 & i3) != 0) {
                            i20 &= -458753;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                            i20 &= -3670017;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if (i13 != 0) {
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
                        borderStroke3 = borderStroke2;
                        f2 = fM5160constructorimpl;
                        modifier4 = modifier3;
                        z4 = z3;
                        j3 = jM1069contentColorForek8zF_U;
                        shape2 = rectangleShape;
                        i17 = i20;
                        j4 = jM1055getSurface0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(262027249, i17, i15, "androidx.compose.material.Surface (Surface.kt:324)");
                    }
                    float fM5160constructorimpl9 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                    composer2 = composerStartRestartGroup;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl9))}, ComposableLambdaKt.composableLambda(composer2, -1391199439, true, new SurfaceKt$Surface$7(modifier4, shape2, j4, fM5160constructorimpl9, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3588op, interfaceC0526Fp, i15)), composer2, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z5 = z4;
                    shape3 = shape2;
                    j5 = j4;
                    j6 = j3;
                    borderStroke4 = borderStroke3;
                    f3 = f2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i21 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((32 & i3) != 0) {
                            i20 &= -458753;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                            i20 &= -3670017;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if (i13 != 0) {
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
                        borderStroke3 = borderStroke2;
                        f2 = fM5160constructorimpl;
                        modifier4 = modifier3;
                        z4 = z3;
                        j3 = jM1069contentColorForek8zF_U;
                        shape2 = rectangleShape;
                        i17 = i20;
                        j4 = jM1055getSurface0d7_KjU;
                    } else {
                        if (i21 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((32 & i3) != 0) {
                            i20 &= -458753;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                            i20 &= -3670017;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if (i13 != 0) {
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
                        borderStroke3 = borderStroke2;
                        f2 = fM5160constructorimpl;
                        modifier4 = modifier3;
                        z4 = z3;
                        j3 = jM1069contentColorForek8zF_U;
                        shape2 = rectangleShape;
                        i17 = i20;
                        j4 = jM1055getSurface0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(262027249, i17, i15, "androidx.compose.material.Surface (Surface.kt:324)");
                    }
                    float fM5160constructorimpl10 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                    composer2 = composerStartRestartGroup;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl10))}, ComposableLambdaKt.composableLambda(composer2, -1391199439, true, new SurfaceKt$Surface$7(modifier4, shape2, j4, fM5160constructorimpl10, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3588op, interfaceC0526Fp, i15)), composer2, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z5 = z4;
                    shape3 = shape2;
                    j5 = j4;
                    j6 = j3;
                    borderStroke4 = borderStroke3;
                    f3 = f2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$8(z, interfaceC3588op, modifier5, z5, shape3, j5, j6, borderStroke4, f3, mutableInteractionSource3, interfaceC0526Fp, i, i2, i3));
            }
            i20 |= 12582912;
            i11 = 256 & i3;
            if (i11 != 0) {
                i20 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i20 |= i12;
            }
            i13 = i3 & 512;
            if (i13 != 0) {
                i20 |= 805306368;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i14 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i14 = 268435456;
                }
                i20 |= i14;
            }
            if ((1024 & i3) != 0) {
                i15 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i15 = i2 | i16;
            } else {
                i15 = i2;
            }
            if ((i20 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i21 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((32 & i3) != 0) {
                        i20 &= -458753;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                        i20 &= -3670017;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i13 != 0) {
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
                    borderStroke3 = borderStroke2;
                    f2 = fM5160constructorimpl;
                    modifier4 = modifier3;
                    z4 = z3;
                    j3 = jM1069contentColorForek8zF_U;
                    shape2 = rectangleShape;
                    i17 = i20;
                    j4 = jM1055getSurface0d7_KjU;
                } else {
                    if (i21 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((32 & i3) != 0) {
                        i20 &= -458753;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                        i20 &= -3670017;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i13 != 0) {
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
                    borderStroke3 = borderStroke2;
                    f2 = fM5160constructorimpl;
                    modifier4 = modifier3;
                    z4 = z3;
                    j3 = jM1069contentColorForek8zF_U;
                    shape2 = rectangleShape;
                    i17 = i20;
                    j4 = jM1055getSurface0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(262027249, i17, i15, "androidx.compose.material.Surface (Surface.kt:324)");
                }
                float fM5160constructorimpl11 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                composer2 = composerStartRestartGroup;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl11))}, ComposableLambdaKt.composableLambda(composer2, -1391199439, true, new SurfaceKt$Surface$7(modifier4, shape2, j4, fM5160constructorimpl11, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3588op, interfaceC0526Fp, i15)), composer2, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z5 = z4;
                shape3 = shape2;
                j5 = j4;
                j6 = j3;
                borderStroke4 = borderStroke3;
                f3 = f2;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i21 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((32 & i3) != 0) {
                        i20 &= -458753;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                        i20 &= -3670017;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i13 != 0) {
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
                    borderStroke3 = borderStroke2;
                    f2 = fM5160constructorimpl;
                    modifier4 = modifier3;
                    z4 = z3;
                    j3 = jM1069contentColorForek8zF_U;
                    shape2 = rectangleShape;
                    i17 = i20;
                    j4 = jM1055getSurface0d7_KjU;
                } else {
                    if (i21 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((32 & i3) != 0) {
                        i20 &= -458753;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                        i20 &= -3670017;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i13 != 0) {
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
                    borderStroke3 = borderStroke2;
                    f2 = fM5160constructorimpl;
                    modifier4 = modifier3;
                    z4 = z3;
                    j3 = jM1069contentColorForek8zF_U;
                    shape2 = rectangleShape;
                    i17 = i20;
                    j4 = jM1055getSurface0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(262027249, i17, i15, "androidx.compose.material.Surface (Surface.kt:324)");
                }
                float fM5160constructorimpl12 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                composer2 = composerStartRestartGroup;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl12))}, ComposableLambdaKt.composableLambda(composer2, -1391199439, true, new SurfaceKt$Surface$7(modifier4, shape2, j4, fM5160constructorimpl12, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3588op, interfaceC0526Fp, i15)), composer2, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z5 = z4;
                shape3 = shape2;
                j5 = j4;
                j6 = j3;
                borderStroke4 = borderStroke3;
                f3 = f2;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$8(z, interfaceC3588op, modifier5, z5, shape3, j5, j6, borderStroke4, f3, mutableInteractionSource3, interfaceC0526Fp, i, i2, i3));
        }
        i20 |= 3072;
        z3 = z2;
        i7 = 16 & i3;
        if (i7 != 0) {
            i20 |= 24576;
        } else if ((i & 57344) == 0) {
            if (composerStartRestartGroup.changed(shape)) {
                i8 = 16384;
            } else {
                i8 = 8192;
            }
            i20 |= i8;
        }
        if ((i & 458752) != 0) {
            if ((i3 & 32) == 0) {
                i19 = 65536;
            } else {
                i19 = 65536;
            }
            i20 |= i19;
        }
        if ((i & 3670016) != 0) {
            if ((i3 & 64) == 0) {
                i18 = 524288;
            } else {
                i18 = 524288;
            }
            i20 |= i18;
        }
        i9 = 128 & i3;
        if (i9 != 0) {
            if ((29360128 & i) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i20 |= i10;
            }
            i11 = 256 & i3;
            if (i11 != 0) {
                i20 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i20 |= i12;
            }
            i13 = i3 & 512;
            if (i13 != 0) {
                i20 |= 805306368;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i14 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i14 = 268435456;
                }
                i20 |= i14;
            }
            if ((1024 & i3) != 0) {
                i15 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i15 = i2 | i16;
            } else {
                i15 = i2;
            }
            if ((i20 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i21 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((32 & i3) != 0) {
                        i20 &= -458753;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                        i20 &= -3670017;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i13 != 0) {
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
                    borderStroke3 = borderStroke2;
                    f2 = fM5160constructorimpl;
                    modifier4 = modifier3;
                    z4 = z3;
                    j3 = jM1069contentColorForek8zF_U;
                    shape2 = rectangleShape;
                    i17 = i20;
                    j4 = jM1055getSurface0d7_KjU;
                } else {
                    if (i21 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((32 & i3) != 0) {
                        i20 &= -458753;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                        i20 &= -3670017;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i13 != 0) {
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
                    borderStroke3 = borderStroke2;
                    f2 = fM5160constructorimpl;
                    modifier4 = modifier3;
                    z4 = z3;
                    j3 = jM1069contentColorForek8zF_U;
                    shape2 = rectangleShape;
                    i17 = i20;
                    j4 = jM1055getSurface0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(262027249, i17, i15, "androidx.compose.material.Surface (Surface.kt:324)");
                }
                float fM5160constructorimpl13 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                composer2 = composerStartRestartGroup;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl13))}, ComposableLambdaKt.composableLambda(composer2, -1391199439, true, new SurfaceKt$Surface$7(modifier4, shape2, j4, fM5160constructorimpl13, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3588op, interfaceC0526Fp, i15)), composer2, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z5 = z4;
                shape3 = shape2;
                j5 = j4;
                j6 = j3;
                borderStroke4 = borderStroke3;
                f3 = f2;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i21 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((32 & i3) != 0) {
                        i20 &= -458753;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                        i20 &= -3670017;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i13 != 0) {
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
                    borderStroke3 = borderStroke2;
                    f2 = fM5160constructorimpl;
                    modifier4 = modifier3;
                    z4 = z3;
                    j3 = jM1069contentColorForek8zF_U;
                    shape2 = rectangleShape;
                    i17 = i20;
                    j4 = jM1055getSurface0d7_KjU;
                } else {
                    if (i21 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((32 & i3) != 0) {
                        i20 &= -458753;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                        i20 &= -3670017;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i13 != 0) {
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
                    borderStroke3 = borderStroke2;
                    f2 = fM5160constructorimpl;
                    modifier4 = modifier3;
                    z4 = z3;
                    j3 = jM1069contentColorForek8zF_U;
                    shape2 = rectangleShape;
                    i17 = i20;
                    j4 = jM1055getSurface0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(262027249, i17, i15, "androidx.compose.material.Surface (Surface.kt:324)");
                }
                float fM5160constructorimpl14 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                composer2 = composerStartRestartGroup;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl14))}, ComposableLambdaKt.composableLambda(composer2, -1391199439, true, new SurfaceKt$Surface$7(modifier4, shape2, j4, fM5160constructorimpl14, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3588op, interfaceC0526Fp, i15)), composer2, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z5 = z4;
                shape3 = shape2;
                j5 = j4;
                j6 = j3;
                borderStroke4 = borderStroke3;
                f3 = f2;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$8(z, interfaceC3588op, modifier5, z5, shape3, j5, j6, borderStroke4, f3, mutableInteractionSource3, interfaceC0526Fp, i, i2, i3));
        }
        i20 |= 12582912;
        i11 = 256 & i3;
        if (i11 != 0) {
            i20 |= 100663296;
        } else if ((i & 234881024) == 0) {
            if (composerStartRestartGroup.changed(f)) {
                i12 = 67108864;
            } else {
                i12 = 33554432;
            }
            i20 |= i12;
        }
        i13 = i3 & 512;
        if (i13 != 0) {
            i20 |= 805306368;
        } else if ((i & 1879048192) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i14 = PropertyOptions.DELETE_EXISTING;
            } else {
                i14 = 268435456;
            }
            i20 |= i14;
        }
        if ((1024 & i3) != 0) {
            i15 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i15 = i2 | i16;
        } else {
            i15 = i2;
        }
        if ((i20 & 1533916891) != 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i21 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if (i7 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = shape;
                }
                if ((32 & i3) != 0) {
                    i20 &= -458753;
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                } else {
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i3 & 64) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                    i20 &= -3670017;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if (i9 != 0) {
                    borderStroke2 = null;
                } else {
                    borderStroke2 = borderStroke;
                }
                if (i11 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                } else {
                    fM5160constructorimpl = f;
                }
                if (i13 != 0) {
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
                borderStroke3 = borderStroke2;
                f2 = fM5160constructorimpl;
                modifier4 = modifier3;
                z4 = z3;
                j3 = jM1069contentColorForek8zF_U;
                shape2 = rectangleShape;
                i17 = i20;
                j4 = jM1055getSurface0d7_KjU;
            } else {
                if (i21 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if (i7 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = shape;
                }
                if ((32 & i3) != 0) {
                    i20 &= -458753;
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                } else {
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i3 & 64) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                    i20 &= -3670017;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if (i9 != 0) {
                    borderStroke2 = null;
                } else {
                    borderStroke2 = borderStroke;
                }
                if (i11 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                } else {
                    fM5160constructorimpl = f;
                }
                if (i13 != 0) {
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
                borderStroke3 = borderStroke2;
                f2 = fM5160constructorimpl;
                modifier4 = modifier3;
                z4 = z3;
                j3 = jM1069contentColorForek8zF_U;
                shape2 = rectangleShape;
                i17 = i20;
                j4 = jM1055getSurface0d7_KjU;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(262027249, i17, i15, "androidx.compose.material.Surface (Surface.kt:324)");
            }
            float fM5160constructorimpl15 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
            composer2 = composerStartRestartGroup;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl15))}, ComposableLambdaKt.composableLambda(composer2, -1391199439, true, new SurfaceKt$Surface$7(modifier4, shape2, j4, fM5160constructorimpl15, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3588op, interfaceC0526Fp, i15)), composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            z5 = z4;
            shape3 = shape2;
            j5 = j4;
            j6 = j3;
            borderStroke4 = borderStroke3;
            f3 = f2;
            mutableInteractionSource3 = mutableInteractionSource2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i21 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if (i7 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = shape;
                }
                if ((32 & i3) != 0) {
                    i20 &= -458753;
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                } else {
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i3 & 64) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                    i20 &= -3670017;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if (i9 != 0) {
                    borderStroke2 = null;
                } else {
                    borderStroke2 = borderStroke;
                }
                if (i11 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                } else {
                    fM5160constructorimpl = f;
                }
                if (i13 != 0) {
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
                borderStroke3 = borderStroke2;
                f2 = fM5160constructorimpl;
                modifier4 = modifier3;
                z4 = z3;
                j3 = jM1069contentColorForek8zF_U;
                shape2 = rectangleShape;
                i17 = i20;
                j4 = jM1055getSurface0d7_KjU;
            } else {
                if (i21 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if (i7 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = shape;
                }
                if ((32 & i3) != 0) {
                    i20 &= -458753;
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                } else {
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i3 & 64) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                    i20 &= -3670017;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if (i9 != 0) {
                    borderStroke2 = null;
                } else {
                    borderStroke2 = borderStroke;
                }
                if (i11 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                } else {
                    fM5160constructorimpl = f;
                }
                if (i13 != 0) {
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
                borderStroke3 = borderStroke2;
                f2 = fM5160constructorimpl;
                modifier4 = modifier3;
                z4 = z3;
                j3 = jM1069contentColorForek8zF_U;
                shape2 = rectangleShape;
                i17 = i20;
                j4 = jM1055getSurface0d7_KjU;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(262027249, i17, i15, "androidx.compose.material.Surface (Surface.kt:324)");
            }
            float fM5160constructorimpl16 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
            composer2 = composerStartRestartGroup;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl16))}, ComposableLambdaKt.composableLambda(composer2, -1391199439, true, new SurfaceKt$Surface$7(modifier4, shape2, j4, fM5160constructorimpl16, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3588op, interfaceC0526Fp, i15)), composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            z5 = z4;
            shape3 = shape2;
            j5 = j4;
            j6 = j3;
            borderStroke4 = borderStroke3;
            f3 = f2;
            mutableInteractionSource3 = mutableInteractionSource2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$8(z, interfaceC3588op, modifier5, z5, shape3, j5, j6, borderStroke4, f3, mutableInteractionSource3, interfaceC0526Fp, i, i2, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: surface-8ww4TTg, reason: not valid java name */
    public static final Modifier m1233surface8ww4TTg(Modifier modifier, Shape shape, long j, BorderStroke borderStroke, float f) {
        return ClipKt.clip(BackgroundKt.m166backgroundbw27NRU(ShadowKt.m2707shadows4CzXII$default(modifier, f, shape, false, 0L, 0L, 24, null).then(borderStroke != null ? BorderKt.border(Modifier.Companion, borderStroke, shape) : Modifier.Companion), j, shape), shape);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    /* JADX INFO: renamed from: surfaceColorAtElevation-cq6XJ1M, reason: not valid java name */
    public static final long m1234surfaceColorAtElevationcq6XJ1M(long j, ElevationOverlay elevationOverlay, float f, Composer composer, int i) {
        composer.startReplaceableGroup(1561611256);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1561611256, i, -1, "androidx.compose.material.surfaceColorAtElevation (Surface.kt:630)");
        }
        if (Color.m3033equalsimpl0(j, MaterialTheme.INSTANCE.getColors(composer, 6).m1055getSurface0d7_KjU()) && elevationOverlay != null) {
            j = elevationOverlay.mo1085apply7g2Lkgo(j, f, composer, (i & 14) | ((i >> 3) & 112) | ((i << 3) & 896));
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return j;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x013b  */
    /* JADX WARN: Code duplicated, block: B:103:0x0143  */
    /* JADX WARN: Code duplicated, block: B:105:0x0149  */
    /* JADX WARN: Code duplicated, block: B:106:0x014c  */
    /* JADX WARN: Code duplicated, block: B:110:0x0153  */
    /* JADX WARN: Code duplicated, block: B:111:0x0159  */
    /* JADX WARN: Code duplicated, block: B:113:0x015d  */
    /* JADX WARN: Code duplicated, block: B:115:0x0163  */
    /* JADX WARN: Code duplicated, block: B:116:0x0165  */
    /* JADX WARN: Code duplicated, block: B:118:0x0169  */
    /* JADX WARN: Code duplicated, block: B:121:0x0175  */
    /* JADX WARN: Code duplicated, block: B:127:0x0195  */
    /* JADX WARN: Code duplicated, block: B:129:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:139:0x01cc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:140:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:141:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:143:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:145:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:147:0x01de  */
    /* JADX WARN: Code duplicated, block: B:150:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:151:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:154:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:155:0x020b  */
    /* JADX WARN: Code duplicated, block: B:157:0x020f  */
    /* JADX WARN: Code duplicated, block: B:158:0x0211  */
    /* JADX WARN: Code duplicated, block: B:160:0x0215  */
    /* JADX WARN: Code duplicated, block: B:161:0x021c  */
    /* JADX WARN: Code duplicated, block: B:163:0x0220  */
    /* JADX WARN: Code duplicated, block: B:165:0x0232  */
    /* JADX WARN: Code duplicated, block: B:168:0x0250  */
    /* JADX WARN: Code duplicated, block: B:171:0x025c  */
    /* JADX WARN: Code duplicated, block: B:174:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:179:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:181:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0085  */
    /* JADX WARN: Code duplicated, block: B:39:0x008a  */
    /* JADX WARN: Code duplicated, block: B:41:0x008e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0096  */
    /* JADX WARN: Code duplicated, block: B:44:0x0099  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:75:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:80:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:82:0x0100  */
    /* JADX WARN: Code duplicated, block: B:84:0x0108  */
    /* JADX WARN: Code duplicated, block: B:85:0x010b  */
    /* JADX WARN: Code duplicated, block: B:89:0x0112  */
    /* JADX WARN: Code duplicated, block: B:90:0x0119  */
    /* JADX WARN: Code duplicated, block: B:92:0x0121  */
    /* JADX WARN: Code duplicated, block: B:94:0x0127  */
    /* JADX WARN: Code duplicated, block: B:95:0x012a  */
    /* JADX WARN: Code duplicated, block: B:99:0x0132  */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Surface-Ny5ogXk, reason: not valid java name */
    public static final void m1230SurfaceNy5ogXk(boolean z, InterfaceC3750qp interfaceC3750qp, Modifier modifier, boolean z2, Shape shape, long j, long j2, BorderStroke borderStroke, float f, MutableInteractionSource mutableInteractionSource, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2, int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        Modifier modifier3;
        Shape rectangleShape;
        long jM1055getSurface0d7_KjU;
        long jM1069contentColorForek8zF_U;
        BorderStroke borderStroke2;
        float fM5160constructorimpl;
        MutableInteractionSource mutableInteractionSource2;
        BorderStroke borderStroke3;
        float f2;
        Modifier modifier4;
        boolean z4;
        long j3;
        Shape shape2;
        int i17;
        long j4;
        Object objRememberedValue;
        Composer composer2;
        Modifier modifier5;
        boolean z5;
        Shape shape3;
        long j5;
        long j6;
        BorderStroke borderStroke4;
        float f3;
        MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i18;
        int i19;
        AbstractC4492zt.h(interfaceC3750qp, "onCheckedChange");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(1341569296);
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = i | (composerStartRestartGroup.changed(z) ? 4 : 2);
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC3750qp) ? 32 : 16;
        }
        int i20 = i4;
        int i21 = i3 & 4;
        if (i21 == 0) {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i20 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i & 7168) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i20 |= i6;
                }
                i7 = 16 & i3;
                if (i7 != 0) {
                    i20 |= 24576;
                } else if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changed(shape)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i20 |= i8;
                }
                if ((i & 458752) != 0) {
                    if ((i3 & 32) == 0 || !composerStartRestartGroup.changed(j)) {
                        i19 = 65536;
                    } else {
                        i19 = 131072;
                    }
                    i20 |= i19;
                }
                if ((i & 3670016) != 0) {
                    if ((i3 & 64) == 0 || !composerStartRestartGroup.changed(j2)) {
                        i18 = 524288;
                    } else {
                        i18 = 1048576;
                    }
                    i20 |= i18;
                }
                i9 = 128 & i3;
                if (i9 != 0) {
                    if ((29360128 & i) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke)) {
                            i10 = 8388608;
                        } else {
                            i10 = 4194304;
                        }
                        i20 |= i10;
                    }
                    i11 = 256 & i3;
                    if (i11 != 0) {
                        i20 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changed(f)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                        i20 |= i12;
                    }
                    i13 = i3 & 512;
                    if (i13 != 0) {
                        i20 |= 805306368;
                    } else if ((i & 1879048192) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i14 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i14 = 268435456;
                        }
                        i20 |= i14;
                    }
                    if ((1024 & i3) != 0) {
                        i15 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                            i16 = 4;
                        } else {
                            i16 = 2;
                        }
                        i15 = i2 | i16;
                    } else {
                        i15 = i2;
                    }
                    if ((i20 & 1533916891) != 306783378 && (i15 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        shape3 = shape;
                        j5 = j;
                        mutableInteractionSource3 = mutableInteractionSource;
                        modifier5 = modifier2;
                        z5 = z3;
                        composer2 = composerStartRestartGroup;
                        j6 = j2;
                        borderStroke4 = borderStroke;
                        f3 = f;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i21 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i7 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            } else {
                                rectangleShape = shape;
                            }
                            if ((32 & i3) != 0) {
                                i20 &= -458753;
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            } else {
                                jM1055getSurface0d7_KjU = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                                i20 &= -3670017;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if (i11 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f;
                            }
                            if (i13 != 0) {
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
                            borderStroke3 = borderStroke2;
                            f2 = fM5160constructorimpl;
                            modifier4 = modifier3;
                            z4 = z3;
                            j3 = jM1069contentColorForek8zF_U;
                            shape2 = rectangleShape;
                            i17 = i20;
                            j4 = jM1055getSurface0d7_KjU;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((32 & i3) != 0) {
                                i20 &= -458753;
                            }
                            if ((i3 & 64) != 0) {
                                i20 &= -3670017;
                            }
                            shape2 = shape;
                            j4 = j;
                            j3 = j2;
                            borderStroke3 = borderStroke;
                            f2 = f;
                            mutableInteractionSource2 = mutableInteractionSource;
                            i17 = i20;
                            modifier4 = modifier2;
                            z4 = z3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1341569296, i17, i15, "androidx.compose.material.Surface (Surface.kt:439)");
                        }
                        float fM5160constructorimpl2 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                        composer2 = composerStartRestartGroup;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl2))}, ComposableLambdaKt.composableLambda(composer2, -311657392, true, new SurfaceKt$Surface$10(modifier4, shape2, j4, fM5160constructorimpl2, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3750qp, interfaceC0526Fp, i15)), composer2, 56);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        z5 = z4;
                        shape3 = shape2;
                        j5 = j4;
                        j6 = j3;
                        borderStroke4 = borderStroke3;
                        f3 = f2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$11(z, interfaceC3750qp, modifier5, z5, shape3, j5, j6, borderStroke4, f3, mutableInteractionSource3, interfaceC0526Fp, i, i2, i3));
                }
                i20 |= 12582912;
                i11 = 256 & i3;
                if (i11 != 0) {
                    i20 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i20 |= i12;
                }
                i13 = i3 & 512;
                if (i13 != 0) {
                    i20 |= 805306368;
                } else if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i14 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i14 = 268435456;
                    }
                    i20 |= i14;
                }
                if ((1024 & i3) != 0) {
                    i15 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i15 = i2 | i16;
                } else {
                    i15 = i2;
                }
                if ((i20 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i21 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((32 & i3) != 0) {
                            i20 &= -458753;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                            i20 &= -3670017;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if (i13 != 0) {
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
                        borderStroke3 = borderStroke2;
                        f2 = fM5160constructorimpl;
                        modifier4 = modifier3;
                        z4 = z3;
                        j3 = jM1069contentColorForek8zF_U;
                        shape2 = rectangleShape;
                        i17 = i20;
                        j4 = jM1055getSurface0d7_KjU;
                    } else {
                        if (i21 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((32 & i3) != 0) {
                            i20 &= -458753;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                            i20 &= -3670017;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if (i13 != 0) {
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
                        borderStroke3 = borderStroke2;
                        f2 = fM5160constructorimpl;
                        modifier4 = modifier3;
                        z4 = z3;
                        j3 = jM1069contentColorForek8zF_U;
                        shape2 = rectangleShape;
                        i17 = i20;
                        j4 = jM1055getSurface0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1341569296, i17, i15, "androidx.compose.material.Surface (Surface.kt:439)");
                    }
                    float fM5160constructorimpl3 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                    composer2 = composerStartRestartGroup;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl3))}, ComposableLambdaKt.composableLambda(composer2, -311657392, true, new SurfaceKt$Surface$10(modifier4, shape2, j4, fM5160constructorimpl3, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3750qp, interfaceC0526Fp, i15)), composer2, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z5 = z4;
                    shape3 = shape2;
                    j5 = j4;
                    j6 = j3;
                    borderStroke4 = borderStroke3;
                    f3 = f2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i21 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((32 & i3) != 0) {
                            i20 &= -458753;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                            i20 &= -3670017;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if (i13 != 0) {
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
                        borderStroke3 = borderStroke2;
                        f2 = fM5160constructorimpl;
                        modifier4 = modifier3;
                        z4 = z3;
                        j3 = jM1069contentColorForek8zF_U;
                        shape2 = rectangleShape;
                        i17 = i20;
                        j4 = jM1055getSurface0d7_KjU;
                    } else {
                        if (i21 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((32 & i3) != 0) {
                            i20 &= -458753;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                            i20 &= -3670017;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if (i13 != 0) {
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
                        borderStroke3 = borderStroke2;
                        f2 = fM5160constructorimpl;
                        modifier4 = modifier3;
                        z4 = z3;
                        j3 = jM1069contentColorForek8zF_U;
                        shape2 = rectangleShape;
                        i17 = i20;
                        j4 = jM1055getSurface0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1341569296, i17, i15, "androidx.compose.material.Surface (Surface.kt:439)");
                    }
                    float fM5160constructorimpl4 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                    composer2 = composerStartRestartGroup;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl4))}, ComposableLambdaKt.composableLambda(composer2, -311657392, true, new SurfaceKt$Surface$10(modifier4, shape2, j4, fM5160constructorimpl4, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3750qp, interfaceC0526Fp, i15)), composer2, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z5 = z4;
                    shape3 = shape2;
                    j5 = j4;
                    j6 = j3;
                    borderStroke4 = borderStroke3;
                    f3 = f2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$11(z, interfaceC3750qp, modifier5, z5, shape3, j5, j6, borderStroke4, f3, mutableInteractionSource3, interfaceC0526Fp, i, i2, i3));
            }
            i20 |= 3072;
            z3 = z2;
            i7 = 16 & i3;
            if (i7 != 0) {
                i20 |= 24576;
            } else if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changed(shape)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i20 |= i8;
            }
            if ((i & 458752) != 0) {
                if ((i3 & 32) == 0) {
                    i19 = 65536;
                } else {
                    i19 = 65536;
                }
                i20 |= i19;
            }
            if ((i & 3670016) != 0) {
                if ((i3 & 64) == 0) {
                    i18 = 524288;
                } else {
                    i18 = 524288;
                }
                i20 |= i18;
            }
            i9 = 128 & i3;
            if (i9 != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i20 |= i10;
                }
                i11 = 256 & i3;
                if (i11 != 0) {
                    i20 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i20 |= i12;
                }
                i13 = i3 & 512;
                if (i13 != 0) {
                    i20 |= 805306368;
                } else if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i14 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i14 = 268435456;
                    }
                    i20 |= i14;
                }
                if ((1024 & i3) != 0) {
                    i15 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i15 = i2 | i16;
                } else {
                    i15 = i2;
                }
                if ((i20 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i21 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((32 & i3) != 0) {
                            i20 &= -458753;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                            i20 &= -3670017;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if (i13 != 0) {
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
                        borderStroke3 = borderStroke2;
                        f2 = fM5160constructorimpl;
                        modifier4 = modifier3;
                        z4 = z3;
                        j3 = jM1069contentColorForek8zF_U;
                        shape2 = rectangleShape;
                        i17 = i20;
                        j4 = jM1055getSurface0d7_KjU;
                    } else {
                        if (i21 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((32 & i3) != 0) {
                            i20 &= -458753;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                            i20 &= -3670017;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if (i13 != 0) {
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
                        borderStroke3 = borderStroke2;
                        f2 = fM5160constructorimpl;
                        modifier4 = modifier3;
                        z4 = z3;
                        j3 = jM1069contentColorForek8zF_U;
                        shape2 = rectangleShape;
                        i17 = i20;
                        j4 = jM1055getSurface0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1341569296, i17, i15, "androidx.compose.material.Surface (Surface.kt:439)");
                    }
                    float fM5160constructorimpl5 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                    composer2 = composerStartRestartGroup;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl5))}, ComposableLambdaKt.composableLambda(composer2, -311657392, true, new SurfaceKt$Surface$10(modifier4, shape2, j4, fM5160constructorimpl5, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3750qp, interfaceC0526Fp, i15)), composer2, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z5 = z4;
                    shape3 = shape2;
                    j5 = j4;
                    j6 = j3;
                    borderStroke4 = borderStroke3;
                    f3 = f2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i21 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((32 & i3) != 0) {
                            i20 &= -458753;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                            i20 &= -3670017;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if (i13 != 0) {
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
                        borderStroke3 = borderStroke2;
                        f2 = fM5160constructorimpl;
                        modifier4 = modifier3;
                        z4 = z3;
                        j3 = jM1069contentColorForek8zF_U;
                        shape2 = rectangleShape;
                        i17 = i20;
                        j4 = jM1055getSurface0d7_KjU;
                    } else {
                        if (i21 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((32 & i3) != 0) {
                            i20 &= -458753;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                            i20 &= -3670017;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if (i13 != 0) {
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
                        borderStroke3 = borderStroke2;
                        f2 = fM5160constructorimpl;
                        modifier4 = modifier3;
                        z4 = z3;
                        j3 = jM1069contentColorForek8zF_U;
                        shape2 = rectangleShape;
                        i17 = i20;
                        j4 = jM1055getSurface0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1341569296, i17, i15, "androidx.compose.material.Surface (Surface.kt:439)");
                    }
                    float fM5160constructorimpl6 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                    composer2 = composerStartRestartGroup;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl6))}, ComposableLambdaKt.composableLambda(composer2, -311657392, true, new SurfaceKt$Surface$10(modifier4, shape2, j4, fM5160constructorimpl6, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3750qp, interfaceC0526Fp, i15)), composer2, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z5 = z4;
                    shape3 = shape2;
                    j5 = j4;
                    j6 = j3;
                    borderStroke4 = borderStroke3;
                    f3 = f2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$11(z, interfaceC3750qp, modifier5, z5, shape3, j5, j6, borderStroke4, f3, mutableInteractionSource3, interfaceC0526Fp, i, i2, i3));
            }
            i20 |= 12582912;
            i11 = 256 & i3;
            if (i11 != 0) {
                i20 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i20 |= i12;
            }
            i13 = i3 & 512;
            if (i13 != 0) {
                i20 |= 805306368;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i14 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i14 = 268435456;
                }
                i20 |= i14;
            }
            if ((1024 & i3) != 0) {
                i15 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i15 = i2 | i16;
            } else {
                i15 = i2;
            }
            if ((i20 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i21 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((32 & i3) != 0) {
                        i20 &= -458753;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                        i20 &= -3670017;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i13 != 0) {
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
                    borderStroke3 = borderStroke2;
                    f2 = fM5160constructorimpl;
                    modifier4 = modifier3;
                    z4 = z3;
                    j3 = jM1069contentColorForek8zF_U;
                    shape2 = rectangleShape;
                    i17 = i20;
                    j4 = jM1055getSurface0d7_KjU;
                } else {
                    if (i21 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((32 & i3) != 0) {
                        i20 &= -458753;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                        i20 &= -3670017;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i13 != 0) {
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
                    borderStroke3 = borderStroke2;
                    f2 = fM5160constructorimpl;
                    modifier4 = modifier3;
                    z4 = z3;
                    j3 = jM1069contentColorForek8zF_U;
                    shape2 = rectangleShape;
                    i17 = i20;
                    j4 = jM1055getSurface0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1341569296, i17, i15, "androidx.compose.material.Surface (Surface.kt:439)");
                }
                float fM5160constructorimpl7 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                composer2 = composerStartRestartGroup;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl7))}, ComposableLambdaKt.composableLambda(composer2, -311657392, true, new SurfaceKt$Surface$10(modifier4, shape2, j4, fM5160constructorimpl7, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3750qp, interfaceC0526Fp, i15)), composer2, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z5 = z4;
                shape3 = shape2;
                j5 = j4;
                j6 = j3;
                borderStroke4 = borderStroke3;
                f3 = f2;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i21 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((32 & i3) != 0) {
                        i20 &= -458753;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                        i20 &= -3670017;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i13 != 0) {
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
                    borderStroke3 = borderStroke2;
                    f2 = fM5160constructorimpl;
                    modifier4 = modifier3;
                    z4 = z3;
                    j3 = jM1069contentColorForek8zF_U;
                    shape2 = rectangleShape;
                    i17 = i20;
                    j4 = jM1055getSurface0d7_KjU;
                } else {
                    if (i21 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((32 & i3) != 0) {
                        i20 &= -458753;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                        i20 &= -3670017;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i13 != 0) {
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
                    borderStroke3 = borderStroke2;
                    f2 = fM5160constructorimpl;
                    modifier4 = modifier3;
                    z4 = z3;
                    j3 = jM1069contentColorForek8zF_U;
                    shape2 = rectangleShape;
                    i17 = i20;
                    j4 = jM1055getSurface0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1341569296, i17, i15, "androidx.compose.material.Surface (Surface.kt:439)");
                }
                float fM5160constructorimpl8 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                composer2 = composerStartRestartGroup;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl8))}, ComposableLambdaKt.composableLambda(composer2, -311657392, true, new SurfaceKt$Surface$10(modifier4, shape2, j4, fM5160constructorimpl8, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3750qp, interfaceC0526Fp, i15)), composer2, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z5 = z4;
                shape3 = shape2;
                j5 = j4;
                j6 = j3;
                borderStroke4 = borderStroke3;
                f3 = f2;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$11(z, interfaceC3750qp, modifier5, z5, shape3, j5, j6, borderStroke4, f3, mutableInteractionSource3, interfaceC0526Fp, i, i2, i3));
        }
        i20 |= 384;
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i & 7168) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i20 |= i6;
            }
            i7 = 16 & i3;
            if (i7 != 0) {
                i20 |= 24576;
            } else if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changed(shape)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i20 |= i8;
            }
            if ((i & 458752) != 0) {
                if ((i3 & 32) == 0) {
                    i19 = 65536;
                } else {
                    i19 = 65536;
                }
                i20 |= i19;
            }
            if ((i & 3670016) != 0) {
                if ((i3 & 64) == 0) {
                    i18 = 524288;
                } else {
                    i18 = 524288;
                }
                i20 |= i18;
            }
            i9 = 128 & i3;
            if (i9 != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i20 |= i10;
                }
                i11 = 256 & i3;
                if (i11 != 0) {
                    i20 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i20 |= i12;
                }
                i13 = i3 & 512;
                if (i13 != 0) {
                    i20 |= 805306368;
                } else if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i14 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i14 = 268435456;
                    }
                    i20 |= i14;
                }
                if ((1024 & i3) != 0) {
                    i15 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i15 = i2 | i16;
                } else {
                    i15 = i2;
                }
                if ((i20 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i21 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((32 & i3) != 0) {
                            i20 &= -458753;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                            i20 &= -3670017;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if (i13 != 0) {
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
                        borderStroke3 = borderStroke2;
                        f2 = fM5160constructorimpl;
                        modifier4 = modifier3;
                        z4 = z3;
                        j3 = jM1069contentColorForek8zF_U;
                        shape2 = rectangleShape;
                        i17 = i20;
                        j4 = jM1055getSurface0d7_KjU;
                    } else {
                        if (i21 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((32 & i3) != 0) {
                            i20 &= -458753;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                            i20 &= -3670017;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if (i13 != 0) {
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
                        borderStroke3 = borderStroke2;
                        f2 = fM5160constructorimpl;
                        modifier4 = modifier3;
                        z4 = z3;
                        j3 = jM1069contentColorForek8zF_U;
                        shape2 = rectangleShape;
                        i17 = i20;
                        j4 = jM1055getSurface0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1341569296, i17, i15, "androidx.compose.material.Surface (Surface.kt:439)");
                    }
                    float fM5160constructorimpl9 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                    composer2 = composerStartRestartGroup;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl9))}, ComposableLambdaKt.composableLambda(composer2, -311657392, true, new SurfaceKt$Surface$10(modifier4, shape2, j4, fM5160constructorimpl9, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3750qp, interfaceC0526Fp, i15)), composer2, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z5 = z4;
                    shape3 = shape2;
                    j5 = j4;
                    j6 = j3;
                    borderStroke4 = borderStroke3;
                    f3 = f2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i21 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((32 & i3) != 0) {
                            i20 &= -458753;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                            i20 &= -3670017;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if (i13 != 0) {
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
                        borderStroke3 = borderStroke2;
                        f2 = fM5160constructorimpl;
                        modifier4 = modifier3;
                        z4 = z3;
                        j3 = jM1069contentColorForek8zF_U;
                        shape2 = rectangleShape;
                        i17 = i20;
                        j4 = jM1055getSurface0d7_KjU;
                    } else {
                        if (i21 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape;
                        }
                        if ((32 & i3) != 0) {
                            i20 &= -458753;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                            i20 &= -3670017;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if (i13 != 0) {
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
                        borderStroke3 = borderStroke2;
                        f2 = fM5160constructorimpl;
                        modifier4 = modifier3;
                        z4 = z3;
                        j3 = jM1069contentColorForek8zF_U;
                        shape2 = rectangleShape;
                        i17 = i20;
                        j4 = jM1055getSurface0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1341569296, i17, i15, "androidx.compose.material.Surface (Surface.kt:439)");
                    }
                    float fM5160constructorimpl10 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                    composer2 = composerStartRestartGroup;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl10))}, ComposableLambdaKt.composableLambda(composer2, -311657392, true, new SurfaceKt$Surface$10(modifier4, shape2, j4, fM5160constructorimpl10, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3750qp, interfaceC0526Fp, i15)), composer2, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z5 = z4;
                    shape3 = shape2;
                    j5 = j4;
                    j6 = j3;
                    borderStroke4 = borderStroke3;
                    f3 = f2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$11(z, interfaceC3750qp, modifier5, z5, shape3, j5, j6, borderStroke4, f3, mutableInteractionSource3, interfaceC0526Fp, i, i2, i3));
            }
            i20 |= 12582912;
            i11 = 256 & i3;
            if (i11 != 0) {
                i20 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i20 |= i12;
            }
            i13 = i3 & 512;
            if (i13 != 0) {
                i20 |= 805306368;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i14 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i14 = 268435456;
                }
                i20 |= i14;
            }
            if ((1024 & i3) != 0) {
                i15 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i15 = i2 | i16;
            } else {
                i15 = i2;
            }
            if ((i20 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i21 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((32 & i3) != 0) {
                        i20 &= -458753;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                        i20 &= -3670017;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i13 != 0) {
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
                    borderStroke3 = borderStroke2;
                    f2 = fM5160constructorimpl;
                    modifier4 = modifier3;
                    z4 = z3;
                    j3 = jM1069contentColorForek8zF_U;
                    shape2 = rectangleShape;
                    i17 = i20;
                    j4 = jM1055getSurface0d7_KjU;
                } else {
                    if (i21 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((32 & i3) != 0) {
                        i20 &= -458753;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                        i20 &= -3670017;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i13 != 0) {
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
                    borderStroke3 = borderStroke2;
                    f2 = fM5160constructorimpl;
                    modifier4 = modifier3;
                    z4 = z3;
                    j3 = jM1069contentColorForek8zF_U;
                    shape2 = rectangleShape;
                    i17 = i20;
                    j4 = jM1055getSurface0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1341569296, i17, i15, "androidx.compose.material.Surface (Surface.kt:439)");
                }
                float fM5160constructorimpl11 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                composer2 = composerStartRestartGroup;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl11))}, ComposableLambdaKt.composableLambda(composer2, -311657392, true, new SurfaceKt$Surface$10(modifier4, shape2, j4, fM5160constructorimpl11, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3750qp, interfaceC0526Fp, i15)), composer2, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z5 = z4;
                shape3 = shape2;
                j5 = j4;
                j6 = j3;
                borderStroke4 = borderStroke3;
                f3 = f2;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i21 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((32 & i3) != 0) {
                        i20 &= -458753;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                        i20 &= -3670017;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i13 != 0) {
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
                    borderStroke3 = borderStroke2;
                    f2 = fM5160constructorimpl;
                    modifier4 = modifier3;
                    z4 = z3;
                    j3 = jM1069contentColorForek8zF_U;
                    shape2 = rectangleShape;
                    i17 = i20;
                    j4 = jM1055getSurface0d7_KjU;
                } else {
                    if (i21 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((32 & i3) != 0) {
                        i20 &= -458753;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                        i20 &= -3670017;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i13 != 0) {
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
                    borderStroke3 = borderStroke2;
                    f2 = fM5160constructorimpl;
                    modifier4 = modifier3;
                    z4 = z3;
                    j3 = jM1069contentColorForek8zF_U;
                    shape2 = rectangleShape;
                    i17 = i20;
                    j4 = jM1055getSurface0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1341569296, i17, i15, "androidx.compose.material.Surface (Surface.kt:439)");
                }
                float fM5160constructorimpl12 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                composer2 = composerStartRestartGroup;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl12))}, ComposableLambdaKt.composableLambda(composer2, -311657392, true, new SurfaceKt$Surface$10(modifier4, shape2, j4, fM5160constructorimpl12, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3750qp, interfaceC0526Fp, i15)), composer2, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z5 = z4;
                shape3 = shape2;
                j5 = j4;
                j6 = j3;
                borderStroke4 = borderStroke3;
                f3 = f2;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$11(z, interfaceC3750qp, modifier5, z5, shape3, j5, j6, borderStroke4, f3, mutableInteractionSource3, interfaceC0526Fp, i, i2, i3));
        }
        i20 |= 3072;
        z3 = z2;
        i7 = 16 & i3;
        if (i7 != 0) {
            i20 |= 24576;
        } else if ((i & 57344) == 0) {
            if (composerStartRestartGroup.changed(shape)) {
                i8 = 16384;
            } else {
                i8 = 8192;
            }
            i20 |= i8;
        }
        if ((i & 458752) != 0) {
            if ((i3 & 32) == 0) {
                i19 = 65536;
            } else {
                i19 = 65536;
            }
            i20 |= i19;
        }
        if ((i & 3670016) != 0) {
            if ((i3 & 64) == 0) {
                i18 = 524288;
            } else {
                i18 = 524288;
            }
            i20 |= i18;
        }
        i9 = 128 & i3;
        if (i9 != 0) {
            if ((29360128 & i) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i20 |= i10;
            }
            i11 = 256 & i3;
            if (i11 != 0) {
                i20 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i20 |= i12;
            }
            i13 = i3 & 512;
            if (i13 != 0) {
                i20 |= 805306368;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i14 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i14 = 268435456;
                }
                i20 |= i14;
            }
            if ((1024 & i3) != 0) {
                i15 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i15 = i2 | i16;
            } else {
                i15 = i2;
            }
            if ((i20 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i21 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((32 & i3) != 0) {
                        i20 &= -458753;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                        i20 &= -3670017;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i13 != 0) {
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
                    borderStroke3 = borderStroke2;
                    f2 = fM5160constructorimpl;
                    modifier4 = modifier3;
                    z4 = z3;
                    j3 = jM1069contentColorForek8zF_U;
                    shape2 = rectangleShape;
                    i17 = i20;
                    j4 = jM1055getSurface0d7_KjU;
                } else {
                    if (i21 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((32 & i3) != 0) {
                        i20 &= -458753;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                        i20 &= -3670017;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i13 != 0) {
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
                    borderStroke3 = borderStroke2;
                    f2 = fM5160constructorimpl;
                    modifier4 = modifier3;
                    z4 = z3;
                    j3 = jM1069contentColorForek8zF_U;
                    shape2 = rectangleShape;
                    i17 = i20;
                    j4 = jM1055getSurface0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1341569296, i17, i15, "androidx.compose.material.Surface (Surface.kt:439)");
                }
                float fM5160constructorimpl13 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                composer2 = composerStartRestartGroup;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl13))}, ComposableLambdaKt.composableLambda(composer2, -311657392, true, new SurfaceKt$Surface$10(modifier4, shape2, j4, fM5160constructorimpl13, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3750qp, interfaceC0526Fp, i15)), composer2, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z5 = z4;
                shape3 = shape2;
                j5 = j4;
                j6 = j3;
                borderStroke4 = borderStroke3;
                f3 = f2;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i21 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((32 & i3) != 0) {
                        i20 &= -458753;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                        i20 &= -3670017;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i13 != 0) {
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
                    borderStroke3 = borderStroke2;
                    f2 = fM5160constructorimpl;
                    modifier4 = modifier3;
                    z4 = z3;
                    j3 = jM1069contentColorForek8zF_U;
                    shape2 = rectangleShape;
                    i17 = i20;
                    j4 = jM1055getSurface0d7_KjU;
                } else {
                    if (i21 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape;
                    }
                    if ((32 & i3) != 0) {
                        i20 &= -458753;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                        i20 &= -3670017;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if (i13 != 0) {
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
                    borderStroke3 = borderStroke2;
                    f2 = fM5160constructorimpl;
                    modifier4 = modifier3;
                    z4 = z3;
                    j3 = jM1069contentColorForek8zF_U;
                    shape2 = rectangleShape;
                    i17 = i20;
                    j4 = jM1055getSurface0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1341569296, i17, i15, "androidx.compose.material.Surface (Surface.kt:439)");
                }
                float fM5160constructorimpl14 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
                composer2 = composerStartRestartGroup;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl14))}, ComposableLambdaKt.composableLambda(composer2, -311657392, true, new SurfaceKt$Surface$10(modifier4, shape2, j4, fM5160constructorimpl14, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3750qp, interfaceC0526Fp, i15)), composer2, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z5 = z4;
                shape3 = shape2;
                j5 = j4;
                j6 = j3;
                borderStroke4 = borderStroke3;
                f3 = f2;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$11(z, interfaceC3750qp, modifier5, z5, shape3, j5, j6, borderStroke4, f3, mutableInteractionSource3, interfaceC0526Fp, i, i2, i3));
        }
        i20 |= 12582912;
        i11 = 256 & i3;
        if (i11 != 0) {
            i20 |= 100663296;
        } else if ((i & 234881024) == 0) {
            if (composerStartRestartGroup.changed(f)) {
                i12 = 67108864;
            } else {
                i12 = 33554432;
            }
            i20 |= i12;
        }
        i13 = i3 & 512;
        if (i13 != 0) {
            i20 |= 805306368;
        } else if ((i & 1879048192) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i14 = PropertyOptions.DELETE_EXISTING;
            } else {
                i14 = 268435456;
            }
            i20 |= i14;
        }
        if ((1024 & i3) != 0) {
            i15 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i15 = i2 | i16;
        } else {
            i15 = i2;
        }
        if ((i20 & 1533916891) != 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i21 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if (i7 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = shape;
                }
                if ((32 & i3) != 0) {
                    i20 &= -458753;
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                } else {
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i3 & 64) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                    i20 &= -3670017;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if (i9 != 0) {
                    borderStroke2 = null;
                } else {
                    borderStroke2 = borderStroke;
                }
                if (i11 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                } else {
                    fM5160constructorimpl = f;
                }
                if (i13 != 0) {
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
                borderStroke3 = borderStroke2;
                f2 = fM5160constructorimpl;
                modifier4 = modifier3;
                z4 = z3;
                j3 = jM1069contentColorForek8zF_U;
                shape2 = rectangleShape;
                i17 = i20;
                j4 = jM1055getSurface0d7_KjU;
            } else {
                if (i21 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if (i7 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = shape;
                }
                if ((32 & i3) != 0) {
                    i20 &= -458753;
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                } else {
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i3 & 64) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                    i20 &= -3670017;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if (i9 != 0) {
                    borderStroke2 = null;
                } else {
                    borderStroke2 = borderStroke;
                }
                if (i11 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                } else {
                    fM5160constructorimpl = f;
                }
                if (i13 != 0) {
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
                borderStroke3 = borderStroke2;
                f2 = fM5160constructorimpl;
                modifier4 = modifier3;
                z4 = z3;
                j3 = jM1069contentColorForek8zF_U;
                shape2 = rectangleShape;
                i17 = i20;
                j4 = jM1055getSurface0d7_KjU;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1341569296, i17, i15, "androidx.compose.material.Surface (Surface.kt:439)");
            }
            float fM5160constructorimpl15 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
            composer2 = composerStartRestartGroup;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl15))}, ComposableLambdaKt.composableLambda(composer2, -311657392, true, new SurfaceKt$Surface$10(modifier4, shape2, j4, fM5160constructorimpl15, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3750qp, interfaceC0526Fp, i15)), composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            z5 = z4;
            shape3 = shape2;
            j5 = j4;
            j6 = j3;
            borderStroke4 = borderStroke3;
            f3 = f2;
            mutableInteractionSource3 = mutableInteractionSource2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i21 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if (i7 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = shape;
                }
                if ((32 & i3) != 0) {
                    i20 &= -458753;
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                } else {
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i3 & 64) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                    i20 &= -3670017;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if (i9 != 0) {
                    borderStroke2 = null;
                } else {
                    borderStroke2 = borderStroke;
                }
                if (i11 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                } else {
                    fM5160constructorimpl = f;
                }
                if (i13 != 0) {
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
                borderStroke3 = borderStroke2;
                f2 = fM5160constructorimpl;
                modifier4 = modifier3;
                z4 = z3;
                j3 = jM1069contentColorForek8zF_U;
                shape2 = rectangleShape;
                i17 = i20;
                j4 = jM1055getSurface0d7_KjU;
            } else {
                if (i21 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if (i7 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = shape;
                }
                if ((32 & i3) != 0) {
                    i20 &= -458753;
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                } else {
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i3 & 64) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i20 >> 15) & 14);
                    i20 &= -3670017;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if (i9 != 0) {
                    borderStroke2 = null;
                } else {
                    borderStroke2 = borderStroke;
                }
                if (i11 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                } else {
                    fM5160constructorimpl = f;
                }
                if (i13 != 0) {
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
                borderStroke3 = borderStroke2;
                f2 = fM5160constructorimpl;
                modifier4 = modifier3;
                z4 = z3;
                j3 = jM1069contentColorForek8zF_U;
                shape2 = rectangleShape;
                i17 = i20;
                j4 = jM1055getSurface0d7_KjU;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1341569296, i17, i15, "androidx.compose.material.Surface (Surface.kt:439)");
            }
            float fM5160constructorimpl16 = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f2);
            composer2 = composerStartRestartGroup;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5158boximpl(fM5160constructorimpl16))}, ComposableLambdaKt.composableLambda(composer2, -311657392, true, new SurfaceKt$Surface$10(modifier4, shape2, j4, fM5160constructorimpl16, i17, borderStroke3, f2, z, mutableInteractionSource2, z4, interfaceC3750qp, interfaceC0526Fp, i15)), composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            z5 = z4;
            shape3 = shape2;
            j5 = j4;
            j6 = j3;
            borderStroke4 = borderStroke3;
            f3 = f2;
            mutableInteractionSource3 = mutableInteractionSource2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new SurfaceKt$Surface$11(z, interfaceC3750qp, modifier5, z5, shape3, j5, j6, borderStroke4, f3, mutableInteractionSource3, interfaceC0526Fp, i, i2, i3));
    }
}
