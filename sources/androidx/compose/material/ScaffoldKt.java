package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.UiComposable;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
public final class ScaffoldKt {
    private static final ProvidableCompositionLocal<FabPlacement> LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(ScaffoldKt$LocalFabPlacement$1.INSTANCE);
    private static final float FabSpacing = Dp.m5160constructorimpl(16);

    /* JADX WARN: Code duplicated, block: B:101:0x0145  */
    /* JADX WARN: Code duplicated, block: B:103:0x014b  */
    /* JADX WARN: Code duplicated, block: B:104:0x014e  */
    /* JADX WARN: Code duplicated, block: B:108:0x0156  */
    /* JADX WARN: Code duplicated, block: B:110:0x015a  */
    /* JADX WARN: Code duplicated, block: B:113:0x0165 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:116:0x016c  */
    /* JADX WARN: Code duplicated, block: B:119:0x0174  */
    /* JADX WARN: Code duplicated, block: B:120:0x0179  */
    /* JADX WARN: Code duplicated, block: B:122:0x017f  */
    /* JADX WARN: Code duplicated, block: B:124:0x0185  */
    /* JADX WARN: Code duplicated, block: B:125:0x0188  */
    /* JADX WARN: Code duplicated, block: B:129:0x0190  */
    /* JADX WARN: Code duplicated, block: B:131:0x0194  */
    /* JADX WARN: Code duplicated, block: B:134:0x019f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:137:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:140:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:142:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:145:0x01b9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:148:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:151:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:153:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:156:0x01d5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:158:0x01da  */
    /* JADX WARN: Code duplicated, block: B:161:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:163:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:166:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:168:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:171:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:173:0x0203  */
    /* JADX WARN: Code duplicated, block: B:176:0x020c  */
    /* JADX WARN: Code duplicated, block: B:178:0x0211  */
    /* JADX WARN: Code duplicated, block: B:181:0x0217  */
    /* JADX WARN: Code duplicated, block: B:183:0x021c  */
    /* JADX WARN: Code duplicated, block: B:185:0x0220  */
    /* JADX WARN: Code duplicated, block: B:187:0x0226  */
    /* JADX WARN: Code duplicated, block: B:188:0x0229  */
    /* JADX WARN: Code duplicated, block: B:191:0x0236  */
    /* JADX WARN: Code duplicated, block: B:197:0x026c  */
    /* JADX WARN: Code duplicated, block: B:199:0x0273  */
    /* JADX WARN: Code duplicated, block: B:224:0x02d4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:225:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:226:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:229:0x02df  */
    /* JADX WARN: Code duplicated, block: B:230:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:232:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:233:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:235:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:236:0x0304  */
    /* JADX WARN: Code duplicated, block: B:238:0x0308  */
    /* JADX WARN: Code duplicated, block: B:239:0x030f  */
    /* JADX WARN: Code duplicated, block: B:241:0x0313  */
    /* JADX WARN: Code duplicated, block: B:242:0x031a  */
    /* JADX WARN: Code duplicated, block: B:244:0x031e  */
    /* JADX WARN: Code duplicated, block: B:246:0x0326  */
    /* JADX WARN: Code duplicated, block: B:247:0x0328  */
    /* JADX WARN: Code duplicated, block: B:249:0x032c  */
    /* JADX WARN: Code duplicated, block: B:250:0x032e  */
    /* JADX WARN: Code duplicated, block: B:252:0x0332  */
    /* JADX WARN: Code duplicated, block: B:253:0x0334  */
    /* JADX WARN: Code duplicated, block: B:256:0x033f  */
    /* JADX WARN: Code duplicated, block: B:258:0x034e  */
    /* JADX WARN: Code duplicated, block: B:260:0x0353  */
    /* JADX WARN: Code duplicated, block: B:261:0x035a  */
    /* JADX WARN: Code duplicated, block: B:264:0x0360  */
    /* JADX WARN: Code duplicated, block: B:265:0x037b  */
    /* JADX WARN: Code duplicated, block: B:268:0x038a  */
    /* JADX WARN: Code duplicated, block: B:269:0x0395  */
    /* JADX WARN: Code duplicated, block: B:272:0x039b  */
    /* JADX WARN: Code duplicated, block: B:273:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:276:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:277:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:280:0x03c9  */
    /* JADX WARN: Code duplicated, block: B:282:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:285:0x0408  */
    /* JADX WARN: Code duplicated, block: B:288:0x043b  */
    /* JADX WARN: Code duplicated, block: B:289:0x0499  */
    /* JADX WARN: Code duplicated, block: B:292:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:297:0x04dd  */
    /* JADX WARN: Code duplicated, block: B:299:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0073  */
    /* JADX WARN: Code duplicated, block: B:39:0x0078  */
    /* JADX WARN: Code duplicated, block: B:41:0x007c  */
    /* JADX WARN: Code duplicated, block: B:43:0x0084  */
    /* JADX WARN: Code duplicated, block: B:44:0x0087  */
    /* JADX WARN: Code duplicated, block: B:48:0x0096  */
    /* JADX WARN: Code duplicated, block: B:49:0x009b  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:54:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:59:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:63:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:68:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:69:0x00df  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:73:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:81:0x0105  */
    /* JADX WARN: Code duplicated, block: B:83:0x010b  */
    /* JADX WARN: Code duplicated, block: B:84:0x010e  */
    /* JADX WARN: Code duplicated, block: B:88:0x0116  */
    /* JADX WARN: Code duplicated, block: B:89:0x011d  */
    /* JADX WARN: Code duplicated, block: B:91:0x0125  */
    /* JADX WARN: Code duplicated, block: B:93:0x012b  */
    /* JADX WARN: Code duplicated, block: B:94:0x012e  */
    /* JADX WARN: Code duplicated, block: B:98:0x0136  */
    /* JADX WARN: Code duplicated, block: B:99:0x013d  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Scaffold-27mzLpw, reason: not valid java name */
    public static final void m1194Scaffold27mzLpw(Modifier modifier, ScaffoldState scaffoldState, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0526Fp interfaceC0526Fp3, int i, boolean z, InterfaceC0552Gp interfaceC0552Gp2, boolean z2, Shape shape, float f, long j, long j2, long j3, long j4, long j5, InterfaceC0552Gp interfaceC0552Gp3, Composer composer, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        InterfaceC0526Fp interfaceC0526Fp4;
        int i12;
        int i13;
        int iM1130getEnd5ygKITE;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        Modifier modifier2;
        ScaffoldState scaffoldStateRememberScaffoldState;
        InterfaceC0526Fp interfaceC0526FpM1077getLambda1$material_release;
        InterfaceC0526Fp interfaceC0526FpM1078getLambda2$material_release;
        InterfaceC0552Gp interfaceC0552GpM1079getLambda3$material_release;
        InterfaceC0526Fp interfaceC0526FpM1080getLambda4$material_release;
        boolean z3;
        InterfaceC0552Gp interfaceC0552Gp4;
        boolean z4;
        ScaffoldState scaffoldState2;
        InterfaceC0552Gp interfaceC0552Gp5;
        Shape large;
        int i25;
        float fM1091getElevationD9Ej5fM;
        boolean z5;
        int i26;
        long jM1055getSurface0d7_KjU;
        long jM1069contentColorForek8zF_U;
        int i27;
        long scrimColor;
        long jM1044getBackground0d7_KjU;
        long jM1069contentColorForek8zF_U2;
        int i28;
        long j6;
        float f2;
        ComposableLambda composableLambda;
        ScaffoldState scaffoldState3;
        InterfaceC0526Fp interfaceC0526Fp5;
        float f3;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11;
        InterfaceC0552Gp interfaceC0552Gp6;
        InterfaceC0526Fp interfaceC0526Fp6;
        boolean z6;
        InterfaceC0526Fp interfaceC0526Fp7;
        int i29;
        Shape shape2;
        InterfaceC0552Gp interfaceC0552Gp7;
        boolean z7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i30;
        int i31;
        AbstractC4492zt.h(interfaceC0552Gp3, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(1037492569);
        int i32 = i4 & 1;
        if (i32 != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i2 & 112) == 0) {
            i5 |= ((i4 & 2) == 0 && composerStartRestartGroup.changed(scaffoldState)) ? 32 : 16;
        }
        int i33 = i4 & 4;
        if (i33 == 0) {
            if ((i2 & 896) == 0) {
                i5 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 256 : 128;
            }
            i6 = i4 & 8;
            if (i6 != 0) {
                if ((i2 & 7168) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i5 |= i7;
                }
                i8 = i4 & 16;
                i9 = 8192;
                if (i8 != 0) {
                    i5 |= 24576;
                } else if ((i2 & 57344) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i10 = 16384;
                    } else {
                        i10 = 8192;
                    }
                    i5 |= i10;
                }
                i11 = i4 & 32;
                if (i11 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    interfaceC0526Fp4 = interfaceC0526Fp3;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp3;
                    if ((i2 & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                            i12 = 131072;
                        } else {
                            i12 = 65536;
                        }
                        i5 |= i12;
                    }
                }
                i13 = i4 & 64;
                if (i13 != 0) {
                    i5 |= 1572864;
                    iM1130getEnd5ygKITE = i;
                } else {
                    iM1130getEnd5ygKITE = i;
                    if ((i2 & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(iM1130getEnd5ygKITE)) {
                            i14 = 1048576;
                        } else {
                            i14 = 524288;
                        }
                        i5 |= i14;
                    }
                }
                i15 = i4 & 128;
                if (i15 != 0) {
                    i5 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i16 = 8388608;
                    } else {
                        i16 = 4194304;
                    }
                    i5 |= i16;
                }
                i17 = i4 & 256;
                if (i17 != 0) {
                    i5 |= 100663296;
                } else if ((i2 & 234881024) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                        i18 = 67108864;
                    } else {
                        i18 = 33554432;
                    }
                    i5 |= i18;
                }
                i19 = i4 & 512;
                if (i19 != 0) {
                    i5 |= 805306368;
                } else if ((i2 & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i20 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i20 = 268435456;
                    }
                    i5 |= i20;
                }
                if ((i3 & 14) == 0) {
                    i21 = i3 | (((i4 & 1024) == 0 || !composerStartRestartGroup.changed(shape)) ? 2 : 4);
                } else {
                    i21 = i3;
                }
                i22 = i4 & 2048;
                if (i22 != 0) {
                    i21 |= 48;
                } else if ((i3 & 112) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i23 = 32;
                    } else {
                        i23 = 16;
                    }
                    i21 |= i23;
                }
                if ((i3 & 896) != 0) {
                    i21 |= ((i4 & 4096) == 0 || !composerStartRestartGroup.changed(j)) ? 128 : 256;
                }
                if ((i3 & 7168) != 0) {
                    i21 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(j2)) ? 1024 : 2048;
                }
                if ((i3 & 57344) != 0) {
                    if ((i4 & 16384) == 0 && composerStartRestartGroup.changed(j3)) {
                        i9 = 16384;
                    }
                    i21 |= i9;
                }
                if ((i3 & 458752) != 0) {
                    if ((i4 & 32768) == 0 || !composerStartRestartGroup.changed(j4)) {
                        i31 = 65536;
                    } else {
                        i31 = 131072;
                    }
                    i21 |= i31;
                }
                if ((i3 & 3670016) != 0) {
                    if ((i4 & 65536) == 0 || !composerStartRestartGroup.changed(j5)) {
                        i30 = 524288;
                    } else {
                        i30 = 1048576;
                    }
                    i21 |= i30;
                }
                if ((i4 & 131072) != 0) {
                    if ((i3 & 29360128) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp3)) {
                            i24 = 8388608;
                        } else {
                            i24 = 4194304;
                        }
                    }
                    if ((i5 & 1533916891) != 306783378 && (i21 & 23967451) == 4793490 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        scaffoldState3 = scaffoldState;
                        interfaceC0526Fp6 = interfaceC0526Fp;
                        interfaceC0526Fp7 = interfaceC0526Fp2;
                        interfaceC0552Gp7 = interfaceC0552Gp;
                        interfaceC0552Gp6 = interfaceC0552Gp2;
                        shape2 = shape;
                        f3 = f;
                        j7 = j;
                        j8 = j2;
                        j9 = j3;
                        j10 = j4;
                        j11 = j5;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        i29 = iM1130getEnd5ygKITE;
                        z7 = z;
                        z6 = z2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i32 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i4 & 2) != 0) {
                                scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                i5 &= -113;
                            } else {
                                scaffoldStateRememberScaffoldState = scaffoldState;
                            }
                            if (i33 != 0) {
                                interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                            } else {
                                interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                            }
                            if (i6 != 0) {
                                interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                            } else {
                                interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                            }
                            if (i8 != 0) {
                                interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                            } else {
                                interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                            }
                            if (i11 != 0) {
                                interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                            } else {
                                interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                            }
                            if (i13 != 0) {
                                iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                            }
                            if (i15 != 0) {
                                z3 = false;
                            } else {
                                z3 = z;
                            }
                            if (i17 != 0) {
                                interfaceC0552Gp4 = null;
                            } else {
                                interfaceC0552Gp4 = interfaceC0552Gp2;
                            }
                            if (i19 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            scaffoldState2 = scaffoldStateRememberScaffoldState;
                            interfaceC0552Gp5 = interfaceC0552Gp4;
                            if ((i4 & 1024) != 0) {
                                large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                i21 &= -15;
                            } else {
                                large = shape;
                            }
                            i25 = i21;
                            if (i22 != 0) {
                                fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                            } else {
                                fM1091getElevationD9Ej5fM = f;
                            }
                            if ((i4 & 4096) != 0) {
                                boolean z8 = z4;
                                i26 = i25 & (-897);
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                z5 = z8;
                            } else {
                                z5 = z4;
                                i26 = i25;
                                jM1055getSurface0d7_KjU = j;
                            }
                            float f4 = fM1091getElevationD9Ej5fM;
                            if ((i4 & 8192) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                                i26 &= -7169;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if ((i4 & 16384) != 0) {
                                i27 = 6;
                                scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                i26 &= -57345;
                            } else {
                                i27 = 6;
                                scrimColor = j3;
                            }
                            if ((32768 & i4) != 0) {
                                jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                                i26 &= -458753;
                            } else {
                                jM1044getBackground0d7_KjU = j4;
                            }
                            if ((i4 & 65536) != 0) {
                                i28 = i26 & (-3670017);
                                jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                            } else {
                                jM1069contentColorForek8zF_U2 = j5;
                                i28 = i26;
                            }
                            j6 = jM1069contentColorForek8zF_U;
                            f2 = f4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i4 & 2) != 0) {
                                i5 &= -113;
                            }
                            if ((i4 & 1024) != 0) {
                                i21 &= -15;
                            }
                            int i34 = i21;
                            if ((i4 & 4096) != 0) {
                                i34 &= -897;
                            }
                            if ((i4 & 8192) != 0) {
                                i34 &= -7169;
                            }
                            if ((i4 & 16384) != 0) {
                                i34 &= -57345;
                            }
                            if ((32768 & i4) != 0) {
                                i34 &= -458753;
                            }
                            if ((i4 & 65536) != 0) {
                                i34 &= -3670017;
                            }
                            scaffoldState2 = scaffoldState;
                            interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                            interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                            z3 = z;
                            interfaceC0552Gp5 = interfaceC0552Gp2;
                            z5 = z2;
                            f2 = f;
                            jM1055getSurface0d7_KjU = j;
                            j6 = j2;
                            scrimColor = j3;
                            jM1044getBackground0d7_KjU = j4;
                            jM1069contentColorForek8zF_U2 = j5;
                            i28 = i34;
                            i5 = i5;
                            interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp4;
                            modifier2 = modifier;
                            interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                            large = shape;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1037492569, i5, i28, "androidx.compose.material.Scaffold (Scaffold.kt:158)");
                        }
                        InterfaceC0526Fp interfaceC0526Fp8 = interfaceC0526FpM1077getLambda1$material_release;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new ScaffoldKt$Scaffold$child$1(jM1044getBackground0d7_KjU, jM1069contentColorForek8zF_U2, i28, z3, iM1130getEnd5ygKITE, interfaceC0526FpM1077getLambda1$material_release, interfaceC0552Gp3, interfaceC0526FpM1080getLambda4$material_release, interfaceC0526FpM1078getLambda2$material_release, i5, interfaceC0552GpM1079getLambda3$material_release, scaffoldState2));
                        if (interfaceC0552Gp5 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-1013848234);
                            int i35 = i28 << 12;
                            DrawerKt.m1094ModalDrawerGs3lGvM(interfaceC0552Gp5, modifier2, scaffoldState2.getDrawerState(), z5, large, f2, jM1055getSurface0d7_KjU, j6, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new ScaffoldKt$Scaffold$1(composableLambda)), composerStartRestartGroup, ((i5 >> 24) & 14) | 805306368 | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i35 & 57344) | (i35 & 458752) | (i35 & 3670016) | (i35 & 29360128) | (i35 & 234881024), 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-1013847725);
                            composableLambda.invoke(modifier2, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scaffoldState3 = scaffoldState2;
                        interfaceC0526Fp5 = interfaceC0526FpM1080getLambda4$material_release;
                        f3 = f2;
                        j7 = jM1055getSurface0d7_KjU;
                        j8 = j6;
                        j9 = scrimColor;
                        j10 = jM1044getBackground0d7_KjU;
                        j11 = jM1069contentColorForek8zF_U2;
                        interfaceC0552Gp6 = interfaceC0552Gp5;
                        interfaceC0526Fp6 = interfaceC0526Fp8;
                        int i36 = iM1130getEnd5ygKITE;
                        z6 = z5;
                        interfaceC0526Fp7 = interfaceC0526FpM1078getLambda2$material_release;
                        i29 = i36;
                        boolean z9 = z3;
                        shape2 = large;
                        interfaceC0552Gp7 = interfaceC0552GpM1079getLambda3$material_release;
                        z7 = z9;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier2, scaffoldState3, interfaceC0526Fp6, interfaceC0526Fp7, interfaceC0552Gp7, interfaceC0526Fp5, i29, z7, interfaceC0552Gp6, z6, shape2, f3, j7, j8, j9, j10, j11, interfaceC0552Gp3, i2, i3, i4));
                }
                i24 = 12582912;
                i21 |= i24;
                if ((i5 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i32 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i4 & 2) != 0) {
                            scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        } else {
                            scaffoldStateRememberScaffoldState = scaffoldState;
                        }
                        if (i33 != 0) {
                            interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                        } else {
                            interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                        }
                        if (i6 != 0) {
                            interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                        } else {
                            interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                        }
                        if (i8 != 0) {
                            interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                        } else {
                            interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                        }
                        if (i11 != 0) {
                            interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                        } else {
                            interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                        }
                        if (i15 != 0) {
                            z3 = false;
                        } else {
                            z3 = z;
                        }
                        if (i17 != 0) {
                            interfaceC0552Gp4 = null;
                        } else {
                            interfaceC0552Gp4 = interfaceC0552Gp2;
                        }
                        if (i19 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        scaffoldState2 = scaffoldStateRememberScaffoldState;
                        interfaceC0552Gp5 = interfaceC0552Gp4;
                        if ((i4 & 1024) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i21 &= -15;
                        } else {
                            large = shape;
                        }
                        i25 = i21;
                        if (i22 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f;
                        }
                        if ((i4 & 4096) != 0) {
                            boolean z10 = z4;
                            i26 = i25 & (-897);
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            z5 = z10;
                        } else {
                            z5 = z4;
                            i26 = i25;
                            jM1055getSurface0d7_KjU = j;
                        }
                        float f5 = fM1091getElevationD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                            i26 &= -7169;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i4 & 16384) != 0) {
                            i27 = 6;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i26 &= -57345;
                        } else {
                            i27 = 6;
                            scrimColor = j3;
                        }
                        if ((32768 & i4) != 0) {
                            jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                            i26 &= -458753;
                        } else {
                            jM1044getBackground0d7_KjU = j4;
                        }
                        if ((i4 & 65536) != 0) {
                            i28 = i26 & (-3670017);
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                        } else {
                            jM1069contentColorForek8zF_U2 = j5;
                            i28 = i26;
                        }
                        j6 = jM1069contentColorForek8zF_U;
                        f2 = f5;
                    } else {
                        if (i32 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i4 & 2) != 0) {
                            scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        } else {
                            scaffoldStateRememberScaffoldState = scaffoldState;
                        }
                        if (i33 != 0) {
                            interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                        } else {
                            interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                        }
                        if (i6 != 0) {
                            interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                        } else {
                            interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                        }
                        if (i8 != 0) {
                            interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                        } else {
                            interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                        }
                        if (i11 != 0) {
                            interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                        } else {
                            interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                        }
                        if (i15 != 0) {
                            z3 = false;
                        } else {
                            z3 = z;
                        }
                        if (i17 != 0) {
                            interfaceC0552Gp4 = null;
                        } else {
                            interfaceC0552Gp4 = interfaceC0552Gp2;
                        }
                        if (i19 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        scaffoldState2 = scaffoldStateRememberScaffoldState;
                        interfaceC0552Gp5 = interfaceC0552Gp4;
                        if ((i4 & 1024) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i21 &= -15;
                        } else {
                            large = shape;
                        }
                        i25 = i21;
                        if (i22 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f;
                        }
                        if ((i4 & 4096) != 0) {
                            boolean z11 = z4;
                            i26 = i25 & (-897);
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            z5 = z11;
                        } else {
                            z5 = z4;
                            i26 = i25;
                            jM1055getSurface0d7_KjU = j;
                        }
                        float f6 = fM1091getElevationD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                            i26 &= -7169;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i4 & 16384) != 0) {
                            i27 = 6;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i26 &= -57345;
                        } else {
                            i27 = 6;
                            scrimColor = j3;
                        }
                        if ((32768 & i4) != 0) {
                            jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                            i26 &= -458753;
                        } else {
                            jM1044getBackground0d7_KjU = j4;
                        }
                        if ((i4 & 65536) != 0) {
                            i28 = i26 & (-3670017);
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                        } else {
                            jM1069contentColorForek8zF_U2 = j5;
                            i28 = i26;
                        }
                        j6 = jM1069contentColorForek8zF_U;
                        f2 = f6;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1037492569, i5, i28, "androidx.compose.material.Scaffold (Scaffold.kt:158)");
                    }
                    InterfaceC0526Fp interfaceC0526Fp9 = interfaceC0526FpM1077getLambda1$material_release;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new ScaffoldKt$Scaffold$child$1(jM1044getBackground0d7_KjU, jM1069contentColorForek8zF_U2, i28, z3, iM1130getEnd5ygKITE, interfaceC0526FpM1077getLambda1$material_release, interfaceC0552Gp3, interfaceC0526FpM1080getLambda4$material_release, interfaceC0526FpM1078getLambda2$material_release, i5, interfaceC0552GpM1079getLambda3$material_release, scaffoldState2));
                    if (interfaceC0552Gp5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-1013848234);
                        int i37 = i28 << 12;
                        DrawerKt.m1094ModalDrawerGs3lGvM(interfaceC0552Gp5, modifier2, scaffoldState2.getDrawerState(), z5, large, f2, jM1055getSurface0d7_KjU, j6, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new ScaffoldKt$Scaffold$1(composableLambda)), composerStartRestartGroup, ((i5 >> 24) & 14) | 805306368 | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i37 & 57344) | (i37 & 458752) | (i37 & 3670016) | (i37 & 29360128) | (i37 & 234881024), 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-1013847725);
                        composableLambda.invoke(modifier2, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scaffoldState3 = scaffoldState2;
                    interfaceC0526Fp5 = interfaceC0526FpM1080getLambda4$material_release;
                    f3 = f2;
                    j7 = jM1055getSurface0d7_KjU;
                    j8 = j6;
                    j9 = scrimColor;
                    j10 = jM1044getBackground0d7_KjU;
                    j11 = jM1069contentColorForek8zF_U2;
                    interfaceC0552Gp6 = interfaceC0552Gp5;
                    interfaceC0526Fp6 = interfaceC0526Fp9;
                    int i38 = iM1130getEnd5ygKITE;
                    z6 = z5;
                    interfaceC0526Fp7 = interfaceC0526FpM1078getLambda2$material_release;
                    i29 = i38;
                    boolean z12 = z3;
                    shape2 = large;
                    interfaceC0552Gp7 = interfaceC0552GpM1079getLambda3$material_release;
                    z7 = z12;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i32 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i4 & 2) != 0) {
                            scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        } else {
                            scaffoldStateRememberScaffoldState = scaffoldState;
                        }
                        if (i33 != 0) {
                            interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                        } else {
                            interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                        }
                        if (i6 != 0) {
                            interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                        } else {
                            interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                        }
                        if (i8 != 0) {
                            interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                        } else {
                            interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                        }
                        if (i11 != 0) {
                            interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                        } else {
                            interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                        }
                        if (i15 != 0) {
                            z3 = false;
                        } else {
                            z3 = z;
                        }
                        if (i17 != 0) {
                            interfaceC0552Gp4 = null;
                        } else {
                            interfaceC0552Gp4 = interfaceC0552Gp2;
                        }
                        if (i19 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        scaffoldState2 = scaffoldStateRememberScaffoldState;
                        interfaceC0552Gp5 = interfaceC0552Gp4;
                        if ((i4 & 1024) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i21 &= -15;
                        } else {
                            large = shape;
                        }
                        i25 = i21;
                        if (i22 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f;
                        }
                        if ((i4 & 4096) != 0) {
                            boolean z13 = z4;
                            i26 = i25 & (-897);
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            z5 = z13;
                        } else {
                            z5 = z4;
                            i26 = i25;
                            jM1055getSurface0d7_KjU = j;
                        }
                        float f7 = fM1091getElevationD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                            i26 &= -7169;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i4 & 16384) != 0) {
                            i27 = 6;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i26 &= -57345;
                        } else {
                            i27 = 6;
                            scrimColor = j3;
                        }
                        if ((32768 & i4) != 0) {
                            jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                            i26 &= -458753;
                        } else {
                            jM1044getBackground0d7_KjU = j4;
                        }
                        if ((i4 & 65536) != 0) {
                            i28 = i26 & (-3670017);
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                        } else {
                            jM1069contentColorForek8zF_U2 = j5;
                            i28 = i26;
                        }
                        j6 = jM1069contentColorForek8zF_U;
                        f2 = f7;
                    } else {
                        if (i32 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i4 & 2) != 0) {
                            scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        } else {
                            scaffoldStateRememberScaffoldState = scaffoldState;
                        }
                        if (i33 != 0) {
                            interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                        } else {
                            interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                        }
                        if (i6 != 0) {
                            interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                        } else {
                            interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                        }
                        if (i8 != 0) {
                            interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                        } else {
                            interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                        }
                        if (i11 != 0) {
                            interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                        } else {
                            interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                        }
                        if (i15 != 0) {
                            z3 = false;
                        } else {
                            z3 = z;
                        }
                        if (i17 != 0) {
                            interfaceC0552Gp4 = null;
                        } else {
                            interfaceC0552Gp4 = interfaceC0552Gp2;
                        }
                        if (i19 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        scaffoldState2 = scaffoldStateRememberScaffoldState;
                        interfaceC0552Gp5 = interfaceC0552Gp4;
                        if ((i4 & 1024) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i21 &= -15;
                        } else {
                            large = shape;
                        }
                        i25 = i21;
                        if (i22 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f;
                        }
                        if ((i4 & 4096) != 0) {
                            boolean z14 = z4;
                            i26 = i25 & (-897);
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            z5 = z14;
                        } else {
                            z5 = z4;
                            i26 = i25;
                            jM1055getSurface0d7_KjU = j;
                        }
                        float f8 = fM1091getElevationD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                            i26 &= -7169;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i4 & 16384) != 0) {
                            i27 = 6;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i26 &= -57345;
                        } else {
                            i27 = 6;
                            scrimColor = j3;
                        }
                        if ((32768 & i4) != 0) {
                            jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                            i26 &= -458753;
                        } else {
                            jM1044getBackground0d7_KjU = j4;
                        }
                        if ((i4 & 65536) != 0) {
                            i28 = i26 & (-3670017);
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                        } else {
                            jM1069contentColorForek8zF_U2 = j5;
                            i28 = i26;
                        }
                        j6 = jM1069contentColorForek8zF_U;
                        f2 = f8;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1037492569, i5, i28, "androidx.compose.material.Scaffold (Scaffold.kt:158)");
                    }
                    InterfaceC0526Fp interfaceC0526Fp10 = interfaceC0526FpM1077getLambda1$material_release;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new ScaffoldKt$Scaffold$child$1(jM1044getBackground0d7_KjU, jM1069contentColorForek8zF_U2, i28, z3, iM1130getEnd5ygKITE, interfaceC0526FpM1077getLambda1$material_release, interfaceC0552Gp3, interfaceC0526FpM1080getLambda4$material_release, interfaceC0526FpM1078getLambda2$material_release, i5, interfaceC0552GpM1079getLambda3$material_release, scaffoldState2));
                    if (interfaceC0552Gp5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-1013848234);
                        int i39 = i28 << 12;
                        DrawerKt.m1094ModalDrawerGs3lGvM(interfaceC0552Gp5, modifier2, scaffoldState2.getDrawerState(), z5, large, f2, jM1055getSurface0d7_KjU, j6, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new ScaffoldKt$Scaffold$1(composableLambda)), composerStartRestartGroup, ((i5 >> 24) & 14) | 805306368 | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i39 & 57344) | (i39 & 458752) | (i39 & 3670016) | (i39 & 29360128) | (i39 & 234881024), 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-1013847725);
                        composableLambda.invoke(modifier2, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scaffoldState3 = scaffoldState2;
                    interfaceC0526Fp5 = interfaceC0526FpM1080getLambda4$material_release;
                    f3 = f2;
                    j7 = jM1055getSurface0d7_KjU;
                    j8 = j6;
                    j9 = scrimColor;
                    j10 = jM1044getBackground0d7_KjU;
                    j11 = jM1069contentColorForek8zF_U2;
                    interfaceC0552Gp6 = interfaceC0552Gp5;
                    interfaceC0526Fp6 = interfaceC0526Fp10;
                    int i310 = iM1130getEnd5ygKITE;
                    z6 = z5;
                    interfaceC0526Fp7 = interfaceC0526FpM1078getLambda2$material_release;
                    i29 = i310;
                    boolean z15 = z3;
                    shape2 = large;
                    interfaceC0552Gp7 = interfaceC0552GpM1079getLambda3$material_release;
                    z7 = z15;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier2, scaffoldState3, interfaceC0526Fp6, interfaceC0526Fp7, interfaceC0552Gp7, interfaceC0526Fp5, i29, z7, interfaceC0552Gp6, z6, shape2, f3, j7, j8, j9, j10, j11, interfaceC0552Gp3, i2, i3, i4));
            }
            i5 |= 3072;
            i8 = i4 & 16;
            i9 = 8192;
            if (i8 != 0) {
                i5 |= 24576;
            } else if ((i2 & 57344) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i10 = 16384;
                } else {
                    i10 = 8192;
                }
                i5 |= i10;
            }
            i11 = i4 & 32;
            if (i11 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                interfaceC0526Fp4 = interfaceC0526Fp3;
            } else {
                interfaceC0526Fp4 = interfaceC0526Fp3;
                if ((i2 & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i5 |= i12;
                }
            }
            i13 = i4 & 64;
            if (i13 != 0) {
                i5 |= 1572864;
                iM1130getEnd5ygKITE = i;
            } else {
                iM1130getEnd5ygKITE = i;
                if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(iM1130getEnd5ygKITE)) {
                        i14 = 1048576;
                    } else {
                        i14 = 524288;
                    }
                    i5 |= i14;
                }
            }
            i15 = i4 & 128;
            if (i15 != 0) {
                i5 |= 12582912;
            } else if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i16 = 8388608;
                } else {
                    i16 = 4194304;
                }
                i5 |= i16;
            }
            i17 = i4 & 256;
            if (i17 != 0) {
                i5 |= 100663296;
            } else if ((i2 & 234881024) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                    i18 = 67108864;
                } else {
                    i18 = 33554432;
                }
                i5 |= i18;
            }
            i19 = i4 & 512;
            if (i19 != 0) {
                i5 |= 805306368;
            } else if ((i2 & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i20 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i20 = 268435456;
                }
                i5 |= i20;
            }
            if ((i3 & 14) == 0) {
                i21 = i3 | (((i4 & 1024) == 0 || !composerStartRestartGroup.changed(shape)) ? 2 : 4);
            } else {
                i21 = i3;
            }
            i22 = i4 & 2048;
            if (i22 != 0) {
                i21 |= 48;
            } else if ((i3 & 112) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i23 = 32;
                } else {
                    i23 = 16;
                }
                i21 |= i23;
            }
            if ((i3 & 896) != 0) {
                i21 |= ((i4 & 4096) == 0 || !composerStartRestartGroup.changed(j)) ? 128 : 256;
            }
            if ((i3 & 7168) != 0) {
                i21 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(j2)) ? 1024 : 2048;
            }
            if ((i3 & 57344) != 0) {
                if ((i4 & 16384) == 0) {
                    i9 = 16384;
                }
                i21 |= i9;
            }
            if ((i3 & 458752) != 0) {
                if ((i4 & 32768) == 0) {
                    i31 = 65536;
                } else {
                    i31 = 65536;
                }
                i21 |= i31;
            }
            if ((i3 & 3670016) != 0) {
                if ((i4 & 65536) == 0) {
                    i30 = 524288;
                } else {
                    i30 = 524288;
                }
                i21 |= i30;
            }
            if ((i4 & 131072) != 0) {
                if ((i3 & 29360128) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp3)) {
                        i24 = 8388608;
                    } else {
                        i24 = 4194304;
                    }
                }
                if ((i5 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i32 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i4 & 2) != 0) {
                            scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        } else {
                            scaffoldStateRememberScaffoldState = scaffoldState;
                        }
                        if (i33 != 0) {
                            interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                        } else {
                            interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                        }
                        if (i6 != 0) {
                            interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                        } else {
                            interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                        }
                        if (i8 != 0) {
                            interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                        } else {
                            interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                        }
                        if (i11 != 0) {
                            interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                        } else {
                            interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                        }
                        if (i15 != 0) {
                            z3 = false;
                        } else {
                            z3 = z;
                        }
                        if (i17 != 0) {
                            interfaceC0552Gp4 = null;
                        } else {
                            interfaceC0552Gp4 = interfaceC0552Gp2;
                        }
                        if (i19 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        scaffoldState2 = scaffoldStateRememberScaffoldState;
                        interfaceC0552Gp5 = interfaceC0552Gp4;
                        if ((i4 & 1024) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i21 &= -15;
                        } else {
                            large = shape;
                        }
                        i25 = i21;
                        if (i22 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f;
                        }
                        if ((i4 & 4096) != 0) {
                            boolean z16 = z4;
                            i26 = i25 & (-897);
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            z5 = z16;
                        } else {
                            z5 = z4;
                            i26 = i25;
                            jM1055getSurface0d7_KjU = j;
                        }
                        float f9 = fM1091getElevationD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                            i26 &= -7169;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i4 & 16384) != 0) {
                            i27 = 6;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i26 &= -57345;
                        } else {
                            i27 = 6;
                            scrimColor = j3;
                        }
                        if ((32768 & i4) != 0) {
                            jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                            i26 &= -458753;
                        } else {
                            jM1044getBackground0d7_KjU = j4;
                        }
                        if ((i4 & 65536) != 0) {
                            i28 = i26 & (-3670017);
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                        } else {
                            jM1069contentColorForek8zF_U2 = j5;
                            i28 = i26;
                        }
                        j6 = jM1069contentColorForek8zF_U;
                        f2 = f9;
                    } else {
                        if (i32 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i4 & 2) != 0) {
                            scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        } else {
                            scaffoldStateRememberScaffoldState = scaffoldState;
                        }
                        if (i33 != 0) {
                            interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                        } else {
                            interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                        }
                        if (i6 != 0) {
                            interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                        } else {
                            interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                        }
                        if (i8 != 0) {
                            interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                        } else {
                            interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                        }
                        if (i11 != 0) {
                            interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                        } else {
                            interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                        }
                        if (i15 != 0) {
                            z3 = false;
                        } else {
                            z3 = z;
                        }
                        if (i17 != 0) {
                            interfaceC0552Gp4 = null;
                        } else {
                            interfaceC0552Gp4 = interfaceC0552Gp2;
                        }
                        if (i19 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        scaffoldState2 = scaffoldStateRememberScaffoldState;
                        interfaceC0552Gp5 = interfaceC0552Gp4;
                        if ((i4 & 1024) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i21 &= -15;
                        } else {
                            large = shape;
                        }
                        i25 = i21;
                        if (i22 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f;
                        }
                        if ((i4 & 4096) != 0) {
                            boolean z17 = z4;
                            i26 = i25 & (-897);
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            z5 = z17;
                        } else {
                            z5 = z4;
                            i26 = i25;
                            jM1055getSurface0d7_KjU = j;
                        }
                        float f10 = fM1091getElevationD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                            i26 &= -7169;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i4 & 16384) != 0) {
                            i27 = 6;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i26 &= -57345;
                        } else {
                            i27 = 6;
                            scrimColor = j3;
                        }
                        if ((32768 & i4) != 0) {
                            jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                            i26 &= -458753;
                        } else {
                            jM1044getBackground0d7_KjU = j4;
                        }
                        if ((i4 & 65536) != 0) {
                            i28 = i26 & (-3670017);
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                        } else {
                            jM1069contentColorForek8zF_U2 = j5;
                            i28 = i26;
                        }
                        j6 = jM1069contentColorForek8zF_U;
                        f2 = f10;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1037492569, i5, i28, "androidx.compose.material.Scaffold (Scaffold.kt:158)");
                    }
                    InterfaceC0526Fp interfaceC0526Fp11 = interfaceC0526FpM1077getLambda1$material_release;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new ScaffoldKt$Scaffold$child$1(jM1044getBackground0d7_KjU, jM1069contentColorForek8zF_U2, i28, z3, iM1130getEnd5ygKITE, interfaceC0526FpM1077getLambda1$material_release, interfaceC0552Gp3, interfaceC0526FpM1080getLambda4$material_release, interfaceC0526FpM1078getLambda2$material_release, i5, interfaceC0552GpM1079getLambda3$material_release, scaffoldState2));
                    if (interfaceC0552Gp5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-1013848234);
                        int i311 = i28 << 12;
                        DrawerKt.m1094ModalDrawerGs3lGvM(interfaceC0552Gp5, modifier2, scaffoldState2.getDrawerState(), z5, large, f2, jM1055getSurface0d7_KjU, j6, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new ScaffoldKt$Scaffold$1(composableLambda)), composerStartRestartGroup, ((i5 >> 24) & 14) | 805306368 | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i311 & 57344) | (i311 & 458752) | (i311 & 3670016) | (i311 & 29360128) | (i311 & 234881024), 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-1013847725);
                        composableLambda.invoke(modifier2, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scaffoldState3 = scaffoldState2;
                    interfaceC0526Fp5 = interfaceC0526FpM1080getLambda4$material_release;
                    f3 = f2;
                    j7 = jM1055getSurface0d7_KjU;
                    j8 = j6;
                    j9 = scrimColor;
                    j10 = jM1044getBackground0d7_KjU;
                    j11 = jM1069contentColorForek8zF_U2;
                    interfaceC0552Gp6 = interfaceC0552Gp5;
                    interfaceC0526Fp6 = interfaceC0526Fp11;
                    int i312 = iM1130getEnd5ygKITE;
                    z6 = z5;
                    interfaceC0526Fp7 = interfaceC0526FpM1078getLambda2$material_release;
                    i29 = i312;
                    boolean z18 = z3;
                    shape2 = large;
                    interfaceC0552Gp7 = interfaceC0552GpM1079getLambda3$material_release;
                    z7 = z18;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i32 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i4 & 2) != 0) {
                            scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        } else {
                            scaffoldStateRememberScaffoldState = scaffoldState;
                        }
                        if (i33 != 0) {
                            interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                        } else {
                            interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                        }
                        if (i6 != 0) {
                            interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                        } else {
                            interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                        }
                        if (i8 != 0) {
                            interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                        } else {
                            interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                        }
                        if (i11 != 0) {
                            interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                        } else {
                            interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                        }
                        if (i15 != 0) {
                            z3 = false;
                        } else {
                            z3 = z;
                        }
                        if (i17 != 0) {
                            interfaceC0552Gp4 = null;
                        } else {
                            interfaceC0552Gp4 = interfaceC0552Gp2;
                        }
                        if (i19 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        scaffoldState2 = scaffoldStateRememberScaffoldState;
                        interfaceC0552Gp5 = interfaceC0552Gp4;
                        if ((i4 & 1024) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i21 &= -15;
                        } else {
                            large = shape;
                        }
                        i25 = i21;
                        if (i22 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f;
                        }
                        if ((i4 & 4096) != 0) {
                            boolean z19 = z4;
                            i26 = i25 & (-897);
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            z5 = z19;
                        } else {
                            z5 = z4;
                            i26 = i25;
                            jM1055getSurface0d7_KjU = j;
                        }
                        float f11 = fM1091getElevationD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                            i26 &= -7169;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i4 & 16384) != 0) {
                            i27 = 6;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i26 &= -57345;
                        } else {
                            i27 = 6;
                            scrimColor = j3;
                        }
                        if ((32768 & i4) != 0) {
                            jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                            i26 &= -458753;
                        } else {
                            jM1044getBackground0d7_KjU = j4;
                        }
                        if ((i4 & 65536) != 0) {
                            i28 = i26 & (-3670017);
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                        } else {
                            jM1069contentColorForek8zF_U2 = j5;
                            i28 = i26;
                        }
                        j6 = jM1069contentColorForek8zF_U;
                        f2 = f11;
                    } else {
                        if (i32 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i4 & 2) != 0) {
                            scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        } else {
                            scaffoldStateRememberScaffoldState = scaffoldState;
                        }
                        if (i33 != 0) {
                            interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                        } else {
                            interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                        }
                        if (i6 != 0) {
                            interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                        } else {
                            interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                        }
                        if (i8 != 0) {
                            interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                        } else {
                            interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                        }
                        if (i11 != 0) {
                            interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                        } else {
                            interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                        }
                        if (i15 != 0) {
                            z3 = false;
                        } else {
                            z3 = z;
                        }
                        if (i17 != 0) {
                            interfaceC0552Gp4 = null;
                        } else {
                            interfaceC0552Gp4 = interfaceC0552Gp2;
                        }
                        if (i19 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        scaffoldState2 = scaffoldStateRememberScaffoldState;
                        interfaceC0552Gp5 = interfaceC0552Gp4;
                        if ((i4 & 1024) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i21 &= -15;
                        } else {
                            large = shape;
                        }
                        i25 = i21;
                        if (i22 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f;
                        }
                        if ((i4 & 4096) != 0) {
                            boolean z110 = z4;
                            i26 = i25 & (-897);
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            z5 = z110;
                        } else {
                            z5 = z4;
                            i26 = i25;
                            jM1055getSurface0d7_KjU = j;
                        }
                        float f12 = fM1091getElevationD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                            i26 &= -7169;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i4 & 16384) != 0) {
                            i27 = 6;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i26 &= -57345;
                        } else {
                            i27 = 6;
                            scrimColor = j3;
                        }
                        if ((32768 & i4) != 0) {
                            jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                            i26 &= -458753;
                        } else {
                            jM1044getBackground0d7_KjU = j4;
                        }
                        if ((i4 & 65536) != 0) {
                            i28 = i26 & (-3670017);
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                        } else {
                            jM1069contentColorForek8zF_U2 = j5;
                            i28 = i26;
                        }
                        j6 = jM1069contentColorForek8zF_U;
                        f2 = f12;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1037492569, i5, i28, "androidx.compose.material.Scaffold (Scaffold.kt:158)");
                    }
                    InterfaceC0526Fp interfaceC0526Fp12 = interfaceC0526FpM1077getLambda1$material_release;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new ScaffoldKt$Scaffold$child$1(jM1044getBackground0d7_KjU, jM1069contentColorForek8zF_U2, i28, z3, iM1130getEnd5ygKITE, interfaceC0526FpM1077getLambda1$material_release, interfaceC0552Gp3, interfaceC0526FpM1080getLambda4$material_release, interfaceC0526FpM1078getLambda2$material_release, i5, interfaceC0552GpM1079getLambda3$material_release, scaffoldState2));
                    if (interfaceC0552Gp5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-1013848234);
                        int i313 = i28 << 12;
                        DrawerKt.m1094ModalDrawerGs3lGvM(interfaceC0552Gp5, modifier2, scaffoldState2.getDrawerState(), z5, large, f2, jM1055getSurface0d7_KjU, j6, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new ScaffoldKt$Scaffold$1(composableLambda)), composerStartRestartGroup, ((i5 >> 24) & 14) | 805306368 | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i313 & 57344) | (i313 & 458752) | (i313 & 3670016) | (i313 & 29360128) | (i313 & 234881024), 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-1013847725);
                        composableLambda.invoke(modifier2, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scaffoldState3 = scaffoldState2;
                    interfaceC0526Fp5 = interfaceC0526FpM1080getLambda4$material_release;
                    f3 = f2;
                    j7 = jM1055getSurface0d7_KjU;
                    j8 = j6;
                    j9 = scrimColor;
                    j10 = jM1044getBackground0d7_KjU;
                    j11 = jM1069contentColorForek8zF_U2;
                    interfaceC0552Gp6 = interfaceC0552Gp5;
                    interfaceC0526Fp6 = interfaceC0526Fp12;
                    int i314 = iM1130getEnd5ygKITE;
                    z6 = z5;
                    interfaceC0526Fp7 = interfaceC0526FpM1078getLambda2$material_release;
                    i29 = i314;
                    boolean z111 = z3;
                    shape2 = large;
                    interfaceC0552Gp7 = interfaceC0552GpM1079getLambda3$material_release;
                    z7 = z111;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier2, scaffoldState3, interfaceC0526Fp6, interfaceC0526Fp7, interfaceC0552Gp7, interfaceC0526Fp5, i29, z7, interfaceC0552Gp6, z6, shape2, f3, j7, j8, j9, j10, j11, interfaceC0552Gp3, i2, i3, i4));
            }
            i24 = 12582912;
            i21 |= i24;
            if ((i5 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i32 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i4 & 2) != 0) {
                        scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    } else {
                        scaffoldStateRememberScaffoldState = scaffoldState;
                    }
                    if (i33 != 0) {
                        interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                    } else {
                        interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                    }
                    if (i6 != 0) {
                        interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                    } else {
                        interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                    }
                    if (i8 != 0) {
                        interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                    } else {
                        interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                    }
                    if (i11 != 0) {
                        interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                    } else {
                        interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                    }
                    if (i15 != 0) {
                        z3 = false;
                    } else {
                        z3 = z;
                    }
                    if (i17 != 0) {
                        interfaceC0552Gp4 = null;
                    } else {
                        interfaceC0552Gp4 = interfaceC0552Gp2;
                    }
                    if (i19 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                    interfaceC0552Gp5 = interfaceC0552Gp4;
                    if ((i4 & 1024) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i21 &= -15;
                    } else {
                        large = shape;
                    }
                    i25 = i21;
                    if (i22 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f;
                    }
                    if ((i4 & 4096) != 0) {
                        boolean z112 = z4;
                        i26 = i25 & (-897);
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        z5 = z112;
                    } else {
                        z5 = z4;
                        i26 = i25;
                        jM1055getSurface0d7_KjU = j;
                    }
                    float f13 = fM1091getElevationD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                        i26 &= -7169;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i4 & 16384) != 0) {
                        i27 = 6;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i26 &= -57345;
                    } else {
                        i27 = 6;
                        scrimColor = j3;
                    }
                    if ((32768 & i4) != 0) {
                        jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                        i26 &= -458753;
                    } else {
                        jM1044getBackground0d7_KjU = j4;
                    }
                    if ((i4 & 65536) != 0) {
                        i28 = i26 & (-3670017);
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                    } else {
                        jM1069contentColorForek8zF_U2 = j5;
                        i28 = i26;
                    }
                    j6 = jM1069contentColorForek8zF_U;
                    f2 = f13;
                } else {
                    if (i32 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i4 & 2) != 0) {
                        scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    } else {
                        scaffoldStateRememberScaffoldState = scaffoldState;
                    }
                    if (i33 != 0) {
                        interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                    } else {
                        interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                    }
                    if (i6 != 0) {
                        interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                    } else {
                        interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                    }
                    if (i8 != 0) {
                        interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                    } else {
                        interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                    }
                    if (i11 != 0) {
                        interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                    } else {
                        interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                    }
                    if (i15 != 0) {
                        z3 = false;
                    } else {
                        z3 = z;
                    }
                    if (i17 != 0) {
                        interfaceC0552Gp4 = null;
                    } else {
                        interfaceC0552Gp4 = interfaceC0552Gp2;
                    }
                    if (i19 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                    interfaceC0552Gp5 = interfaceC0552Gp4;
                    if ((i4 & 1024) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i21 &= -15;
                    } else {
                        large = shape;
                    }
                    i25 = i21;
                    if (i22 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f;
                    }
                    if ((i4 & 4096) != 0) {
                        boolean z113 = z4;
                        i26 = i25 & (-897);
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        z5 = z113;
                    } else {
                        z5 = z4;
                        i26 = i25;
                        jM1055getSurface0d7_KjU = j;
                    }
                    float f14 = fM1091getElevationD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                        i26 &= -7169;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i4 & 16384) != 0) {
                        i27 = 6;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i26 &= -57345;
                    } else {
                        i27 = 6;
                        scrimColor = j3;
                    }
                    if ((32768 & i4) != 0) {
                        jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                        i26 &= -458753;
                    } else {
                        jM1044getBackground0d7_KjU = j4;
                    }
                    if ((i4 & 65536) != 0) {
                        i28 = i26 & (-3670017);
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                    } else {
                        jM1069contentColorForek8zF_U2 = j5;
                        i28 = i26;
                    }
                    j6 = jM1069contentColorForek8zF_U;
                    f2 = f14;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1037492569, i5, i28, "androidx.compose.material.Scaffold (Scaffold.kt:158)");
                }
                InterfaceC0526Fp interfaceC0526Fp13 = interfaceC0526FpM1077getLambda1$material_release;
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new ScaffoldKt$Scaffold$child$1(jM1044getBackground0d7_KjU, jM1069contentColorForek8zF_U2, i28, z3, iM1130getEnd5ygKITE, interfaceC0526FpM1077getLambda1$material_release, interfaceC0552Gp3, interfaceC0526FpM1080getLambda4$material_release, interfaceC0526FpM1078getLambda2$material_release, i5, interfaceC0552GpM1079getLambda3$material_release, scaffoldState2));
                if (interfaceC0552Gp5 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-1013848234);
                    int i315 = i28 << 12;
                    DrawerKt.m1094ModalDrawerGs3lGvM(interfaceC0552Gp5, modifier2, scaffoldState2.getDrawerState(), z5, large, f2, jM1055getSurface0d7_KjU, j6, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new ScaffoldKt$Scaffold$1(composableLambda)), composerStartRestartGroup, ((i5 >> 24) & 14) | 805306368 | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i315 & 57344) | (i315 & 458752) | (i315 & 3670016) | (i315 & 29360128) | (i315 & 234881024), 0);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-1013847725);
                    composableLambda.invoke(modifier2, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                    composerStartRestartGroup.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scaffoldState3 = scaffoldState2;
                interfaceC0526Fp5 = interfaceC0526FpM1080getLambda4$material_release;
                f3 = f2;
                j7 = jM1055getSurface0d7_KjU;
                j8 = j6;
                j9 = scrimColor;
                j10 = jM1044getBackground0d7_KjU;
                j11 = jM1069contentColorForek8zF_U2;
                interfaceC0552Gp6 = interfaceC0552Gp5;
                interfaceC0526Fp6 = interfaceC0526Fp13;
                int i316 = iM1130getEnd5ygKITE;
                z6 = z5;
                interfaceC0526Fp7 = interfaceC0526FpM1078getLambda2$material_release;
                i29 = i316;
                boolean z114 = z3;
                shape2 = large;
                interfaceC0552Gp7 = interfaceC0552GpM1079getLambda3$material_release;
                z7 = z114;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i32 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i4 & 2) != 0) {
                        scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    } else {
                        scaffoldStateRememberScaffoldState = scaffoldState;
                    }
                    if (i33 != 0) {
                        interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                    } else {
                        interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                    }
                    if (i6 != 0) {
                        interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                    } else {
                        interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                    }
                    if (i8 != 0) {
                        interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                    } else {
                        interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                    }
                    if (i11 != 0) {
                        interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                    } else {
                        interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                    }
                    if (i15 != 0) {
                        z3 = false;
                    } else {
                        z3 = z;
                    }
                    if (i17 != 0) {
                        interfaceC0552Gp4 = null;
                    } else {
                        interfaceC0552Gp4 = interfaceC0552Gp2;
                    }
                    if (i19 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                    interfaceC0552Gp5 = interfaceC0552Gp4;
                    if ((i4 & 1024) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i21 &= -15;
                    } else {
                        large = shape;
                    }
                    i25 = i21;
                    if (i22 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f;
                    }
                    if ((i4 & 4096) != 0) {
                        boolean z115 = z4;
                        i26 = i25 & (-897);
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        z5 = z115;
                    } else {
                        z5 = z4;
                        i26 = i25;
                        jM1055getSurface0d7_KjU = j;
                    }
                    float f15 = fM1091getElevationD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                        i26 &= -7169;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i4 & 16384) != 0) {
                        i27 = 6;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i26 &= -57345;
                    } else {
                        i27 = 6;
                        scrimColor = j3;
                    }
                    if ((32768 & i4) != 0) {
                        jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                        i26 &= -458753;
                    } else {
                        jM1044getBackground0d7_KjU = j4;
                    }
                    if ((i4 & 65536) != 0) {
                        i28 = i26 & (-3670017);
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                    } else {
                        jM1069contentColorForek8zF_U2 = j5;
                        i28 = i26;
                    }
                    j6 = jM1069contentColorForek8zF_U;
                    f2 = f15;
                } else {
                    if (i32 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i4 & 2) != 0) {
                        scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    } else {
                        scaffoldStateRememberScaffoldState = scaffoldState;
                    }
                    if (i33 != 0) {
                        interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                    } else {
                        interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                    }
                    if (i6 != 0) {
                        interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                    } else {
                        interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                    }
                    if (i8 != 0) {
                        interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                    } else {
                        interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                    }
                    if (i11 != 0) {
                        interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                    } else {
                        interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                    }
                    if (i15 != 0) {
                        z3 = false;
                    } else {
                        z3 = z;
                    }
                    if (i17 != 0) {
                        interfaceC0552Gp4 = null;
                    } else {
                        interfaceC0552Gp4 = interfaceC0552Gp2;
                    }
                    if (i19 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                    interfaceC0552Gp5 = interfaceC0552Gp4;
                    if ((i4 & 1024) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i21 &= -15;
                    } else {
                        large = shape;
                    }
                    i25 = i21;
                    if (i22 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f;
                    }
                    if ((i4 & 4096) != 0) {
                        boolean z116 = z4;
                        i26 = i25 & (-897);
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        z5 = z116;
                    } else {
                        z5 = z4;
                        i26 = i25;
                        jM1055getSurface0d7_KjU = j;
                    }
                    float f16 = fM1091getElevationD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                        i26 &= -7169;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i4 & 16384) != 0) {
                        i27 = 6;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i26 &= -57345;
                    } else {
                        i27 = 6;
                        scrimColor = j3;
                    }
                    if ((32768 & i4) != 0) {
                        jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                        i26 &= -458753;
                    } else {
                        jM1044getBackground0d7_KjU = j4;
                    }
                    if ((i4 & 65536) != 0) {
                        i28 = i26 & (-3670017);
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                    } else {
                        jM1069contentColorForek8zF_U2 = j5;
                        i28 = i26;
                    }
                    j6 = jM1069contentColorForek8zF_U;
                    f2 = f16;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1037492569, i5, i28, "androidx.compose.material.Scaffold (Scaffold.kt:158)");
                }
                InterfaceC0526Fp interfaceC0526Fp14 = interfaceC0526FpM1077getLambda1$material_release;
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new ScaffoldKt$Scaffold$child$1(jM1044getBackground0d7_KjU, jM1069contentColorForek8zF_U2, i28, z3, iM1130getEnd5ygKITE, interfaceC0526FpM1077getLambda1$material_release, interfaceC0552Gp3, interfaceC0526FpM1080getLambda4$material_release, interfaceC0526FpM1078getLambda2$material_release, i5, interfaceC0552GpM1079getLambda3$material_release, scaffoldState2));
                if (interfaceC0552Gp5 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-1013848234);
                    int i317 = i28 << 12;
                    DrawerKt.m1094ModalDrawerGs3lGvM(interfaceC0552Gp5, modifier2, scaffoldState2.getDrawerState(), z5, large, f2, jM1055getSurface0d7_KjU, j6, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new ScaffoldKt$Scaffold$1(composableLambda)), composerStartRestartGroup, ((i5 >> 24) & 14) | 805306368 | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i317 & 57344) | (i317 & 458752) | (i317 & 3670016) | (i317 & 29360128) | (i317 & 234881024), 0);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-1013847725);
                    composableLambda.invoke(modifier2, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                    composerStartRestartGroup.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scaffoldState3 = scaffoldState2;
                interfaceC0526Fp5 = interfaceC0526FpM1080getLambda4$material_release;
                f3 = f2;
                j7 = jM1055getSurface0d7_KjU;
                j8 = j6;
                j9 = scrimColor;
                j10 = jM1044getBackground0d7_KjU;
                j11 = jM1069contentColorForek8zF_U2;
                interfaceC0552Gp6 = interfaceC0552Gp5;
                interfaceC0526Fp6 = interfaceC0526Fp14;
                int i318 = iM1130getEnd5ygKITE;
                z6 = z5;
                interfaceC0526Fp7 = interfaceC0526FpM1078getLambda2$material_release;
                i29 = i318;
                boolean z117 = z3;
                shape2 = large;
                interfaceC0552Gp7 = interfaceC0552GpM1079getLambda3$material_release;
                z7 = z117;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier2, scaffoldState3, interfaceC0526Fp6, interfaceC0526Fp7, interfaceC0552Gp7, interfaceC0526Fp5, i29, z7, interfaceC0552Gp6, z6, shape2, f3, j7, j8, j9, j10, j11, interfaceC0552Gp3, i2, i3, i4));
        }
        i5 |= 384;
        i6 = i4 & 8;
        if (i6 != 0) {
            if ((i2 & 7168) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i5 |= i7;
            }
            i8 = i4 & 16;
            i9 = 8192;
            if (i8 != 0) {
                i5 |= 24576;
            } else if ((i2 & 57344) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i10 = 16384;
                } else {
                    i10 = 8192;
                }
                i5 |= i10;
            }
            i11 = i4 & 32;
            if (i11 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                interfaceC0526Fp4 = interfaceC0526Fp3;
            } else {
                interfaceC0526Fp4 = interfaceC0526Fp3;
                if ((i2 & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i5 |= i12;
                }
            }
            i13 = i4 & 64;
            if (i13 != 0) {
                i5 |= 1572864;
                iM1130getEnd5ygKITE = i;
            } else {
                iM1130getEnd5ygKITE = i;
                if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(iM1130getEnd5ygKITE)) {
                        i14 = 1048576;
                    } else {
                        i14 = 524288;
                    }
                    i5 |= i14;
                }
            }
            i15 = i4 & 128;
            if (i15 != 0) {
                i5 |= 12582912;
            } else if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i16 = 8388608;
                } else {
                    i16 = 4194304;
                }
                i5 |= i16;
            }
            i17 = i4 & 256;
            if (i17 != 0) {
                i5 |= 100663296;
            } else if ((i2 & 234881024) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                    i18 = 67108864;
                } else {
                    i18 = 33554432;
                }
                i5 |= i18;
            }
            i19 = i4 & 512;
            if (i19 != 0) {
                i5 |= 805306368;
            } else if ((i2 & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i20 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i20 = 268435456;
                }
                i5 |= i20;
            }
            if ((i3 & 14) == 0) {
                i21 = i3 | (((i4 & 1024) == 0 || !composerStartRestartGroup.changed(shape)) ? 2 : 4);
            } else {
                i21 = i3;
            }
            i22 = i4 & 2048;
            if (i22 != 0) {
                i21 |= 48;
            } else if ((i3 & 112) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i23 = 32;
                } else {
                    i23 = 16;
                }
                i21 |= i23;
            }
            if ((i3 & 896) != 0) {
                i21 |= ((i4 & 4096) == 0 || !composerStartRestartGroup.changed(j)) ? 128 : 256;
            }
            if ((i3 & 7168) != 0) {
                i21 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(j2)) ? 1024 : 2048;
            }
            if ((i3 & 57344) != 0) {
                if ((i4 & 16384) == 0) {
                    i9 = 16384;
                }
                i21 |= i9;
            }
            if ((i3 & 458752) != 0) {
                if ((i4 & 32768) == 0) {
                    i31 = 65536;
                } else {
                    i31 = 65536;
                }
                i21 |= i31;
            }
            if ((i3 & 3670016) != 0) {
                if ((i4 & 65536) == 0) {
                    i30 = 524288;
                } else {
                    i30 = 524288;
                }
                i21 |= i30;
            }
            if ((i4 & 131072) != 0) {
                if ((i3 & 29360128) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp3)) {
                        i24 = 8388608;
                    } else {
                        i24 = 4194304;
                    }
                }
                if ((i5 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i32 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i4 & 2) != 0) {
                            scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        } else {
                            scaffoldStateRememberScaffoldState = scaffoldState;
                        }
                        if (i33 != 0) {
                            interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                        } else {
                            interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                        }
                        if (i6 != 0) {
                            interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                        } else {
                            interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                        }
                        if (i8 != 0) {
                            interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                        } else {
                            interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                        }
                        if (i11 != 0) {
                            interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                        } else {
                            interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                        }
                        if (i15 != 0) {
                            z3 = false;
                        } else {
                            z3 = z;
                        }
                        if (i17 != 0) {
                            interfaceC0552Gp4 = null;
                        } else {
                            interfaceC0552Gp4 = interfaceC0552Gp2;
                        }
                        if (i19 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        scaffoldState2 = scaffoldStateRememberScaffoldState;
                        interfaceC0552Gp5 = interfaceC0552Gp4;
                        if ((i4 & 1024) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i21 &= -15;
                        } else {
                            large = shape;
                        }
                        i25 = i21;
                        if (i22 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f;
                        }
                        if ((i4 & 4096) != 0) {
                            boolean z118 = z4;
                            i26 = i25 & (-897);
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            z5 = z118;
                        } else {
                            z5 = z4;
                            i26 = i25;
                            jM1055getSurface0d7_KjU = j;
                        }
                        float f17 = fM1091getElevationD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                            i26 &= -7169;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i4 & 16384) != 0) {
                            i27 = 6;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i26 &= -57345;
                        } else {
                            i27 = 6;
                            scrimColor = j3;
                        }
                        if ((32768 & i4) != 0) {
                            jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                            i26 &= -458753;
                        } else {
                            jM1044getBackground0d7_KjU = j4;
                        }
                        if ((i4 & 65536) != 0) {
                            i28 = i26 & (-3670017);
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                        } else {
                            jM1069contentColorForek8zF_U2 = j5;
                            i28 = i26;
                        }
                        j6 = jM1069contentColorForek8zF_U;
                        f2 = f17;
                    } else {
                        if (i32 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i4 & 2) != 0) {
                            scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        } else {
                            scaffoldStateRememberScaffoldState = scaffoldState;
                        }
                        if (i33 != 0) {
                            interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                        } else {
                            interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                        }
                        if (i6 != 0) {
                            interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                        } else {
                            interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                        }
                        if (i8 != 0) {
                            interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                        } else {
                            interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                        }
                        if (i11 != 0) {
                            interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                        } else {
                            interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                        }
                        if (i15 != 0) {
                            z3 = false;
                        } else {
                            z3 = z;
                        }
                        if (i17 != 0) {
                            interfaceC0552Gp4 = null;
                        } else {
                            interfaceC0552Gp4 = interfaceC0552Gp2;
                        }
                        if (i19 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        scaffoldState2 = scaffoldStateRememberScaffoldState;
                        interfaceC0552Gp5 = interfaceC0552Gp4;
                        if ((i4 & 1024) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i21 &= -15;
                        } else {
                            large = shape;
                        }
                        i25 = i21;
                        if (i22 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f;
                        }
                        if ((i4 & 4096) != 0) {
                            boolean z119 = z4;
                            i26 = i25 & (-897);
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            z5 = z119;
                        } else {
                            z5 = z4;
                            i26 = i25;
                            jM1055getSurface0d7_KjU = j;
                        }
                        float f18 = fM1091getElevationD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                            i26 &= -7169;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i4 & 16384) != 0) {
                            i27 = 6;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i26 &= -57345;
                        } else {
                            i27 = 6;
                            scrimColor = j3;
                        }
                        if ((32768 & i4) != 0) {
                            jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                            i26 &= -458753;
                        } else {
                            jM1044getBackground0d7_KjU = j4;
                        }
                        if ((i4 & 65536) != 0) {
                            i28 = i26 & (-3670017);
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                        } else {
                            jM1069contentColorForek8zF_U2 = j5;
                            i28 = i26;
                        }
                        j6 = jM1069contentColorForek8zF_U;
                        f2 = f18;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1037492569, i5, i28, "androidx.compose.material.Scaffold (Scaffold.kt:158)");
                    }
                    InterfaceC0526Fp interfaceC0526Fp15 = interfaceC0526FpM1077getLambda1$material_release;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new ScaffoldKt$Scaffold$child$1(jM1044getBackground0d7_KjU, jM1069contentColorForek8zF_U2, i28, z3, iM1130getEnd5ygKITE, interfaceC0526FpM1077getLambda1$material_release, interfaceC0552Gp3, interfaceC0526FpM1080getLambda4$material_release, interfaceC0526FpM1078getLambda2$material_release, i5, interfaceC0552GpM1079getLambda3$material_release, scaffoldState2));
                    if (interfaceC0552Gp5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-1013848234);
                        int i319 = i28 << 12;
                        DrawerKt.m1094ModalDrawerGs3lGvM(interfaceC0552Gp5, modifier2, scaffoldState2.getDrawerState(), z5, large, f2, jM1055getSurface0d7_KjU, j6, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new ScaffoldKt$Scaffold$1(composableLambda)), composerStartRestartGroup, ((i5 >> 24) & 14) | 805306368 | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i319 & 57344) | (i319 & 458752) | (i319 & 3670016) | (i319 & 29360128) | (i319 & 234881024), 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-1013847725);
                        composableLambda.invoke(modifier2, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scaffoldState3 = scaffoldState2;
                    interfaceC0526Fp5 = interfaceC0526FpM1080getLambda4$material_release;
                    f3 = f2;
                    j7 = jM1055getSurface0d7_KjU;
                    j8 = j6;
                    j9 = scrimColor;
                    j10 = jM1044getBackground0d7_KjU;
                    j11 = jM1069contentColorForek8zF_U2;
                    interfaceC0552Gp6 = interfaceC0552Gp5;
                    interfaceC0526Fp6 = interfaceC0526Fp15;
                    int i3110 = iM1130getEnd5ygKITE;
                    z6 = z5;
                    interfaceC0526Fp7 = interfaceC0526FpM1078getLambda2$material_release;
                    i29 = i3110;
                    boolean z1110 = z3;
                    shape2 = large;
                    interfaceC0552Gp7 = interfaceC0552GpM1079getLambda3$material_release;
                    z7 = z1110;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i32 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i4 & 2) != 0) {
                            scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        } else {
                            scaffoldStateRememberScaffoldState = scaffoldState;
                        }
                        if (i33 != 0) {
                            interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                        } else {
                            interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                        }
                        if (i6 != 0) {
                            interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                        } else {
                            interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                        }
                        if (i8 != 0) {
                            interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                        } else {
                            interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                        }
                        if (i11 != 0) {
                            interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                        } else {
                            interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                        }
                        if (i15 != 0) {
                            z3 = false;
                        } else {
                            z3 = z;
                        }
                        if (i17 != 0) {
                            interfaceC0552Gp4 = null;
                        } else {
                            interfaceC0552Gp4 = interfaceC0552Gp2;
                        }
                        if (i19 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        scaffoldState2 = scaffoldStateRememberScaffoldState;
                        interfaceC0552Gp5 = interfaceC0552Gp4;
                        if ((i4 & 1024) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i21 &= -15;
                        } else {
                            large = shape;
                        }
                        i25 = i21;
                        if (i22 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f;
                        }
                        if ((i4 & 4096) != 0) {
                            boolean z1111 = z4;
                            i26 = i25 & (-897);
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            z5 = z1111;
                        } else {
                            z5 = z4;
                            i26 = i25;
                            jM1055getSurface0d7_KjU = j;
                        }
                        float f19 = fM1091getElevationD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                            i26 &= -7169;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i4 & 16384) != 0) {
                            i27 = 6;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i26 &= -57345;
                        } else {
                            i27 = 6;
                            scrimColor = j3;
                        }
                        if ((32768 & i4) != 0) {
                            jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                            i26 &= -458753;
                        } else {
                            jM1044getBackground0d7_KjU = j4;
                        }
                        if ((i4 & 65536) != 0) {
                            i28 = i26 & (-3670017);
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                        } else {
                            jM1069contentColorForek8zF_U2 = j5;
                            i28 = i26;
                        }
                        j6 = jM1069contentColorForek8zF_U;
                        f2 = f19;
                    } else {
                        if (i32 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i4 & 2) != 0) {
                            scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        } else {
                            scaffoldStateRememberScaffoldState = scaffoldState;
                        }
                        if (i33 != 0) {
                            interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                        } else {
                            interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                        }
                        if (i6 != 0) {
                            interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                        } else {
                            interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                        }
                        if (i8 != 0) {
                            interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                        } else {
                            interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                        }
                        if (i11 != 0) {
                            interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                        } else {
                            interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                        }
                        if (i15 != 0) {
                            z3 = false;
                        } else {
                            z3 = z;
                        }
                        if (i17 != 0) {
                            interfaceC0552Gp4 = null;
                        } else {
                            interfaceC0552Gp4 = interfaceC0552Gp2;
                        }
                        if (i19 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        scaffoldState2 = scaffoldStateRememberScaffoldState;
                        interfaceC0552Gp5 = interfaceC0552Gp4;
                        if ((i4 & 1024) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i21 &= -15;
                        } else {
                            large = shape;
                        }
                        i25 = i21;
                        if (i22 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f;
                        }
                        if ((i4 & 4096) != 0) {
                            boolean z1112 = z4;
                            i26 = i25 & (-897);
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            z5 = z1112;
                        } else {
                            z5 = z4;
                            i26 = i25;
                            jM1055getSurface0d7_KjU = j;
                        }
                        float f110 = fM1091getElevationD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                            i26 &= -7169;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i4 & 16384) != 0) {
                            i27 = 6;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i26 &= -57345;
                        } else {
                            i27 = 6;
                            scrimColor = j3;
                        }
                        if ((32768 & i4) != 0) {
                            jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                            i26 &= -458753;
                        } else {
                            jM1044getBackground0d7_KjU = j4;
                        }
                        if ((i4 & 65536) != 0) {
                            i28 = i26 & (-3670017);
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                        } else {
                            jM1069contentColorForek8zF_U2 = j5;
                            i28 = i26;
                        }
                        j6 = jM1069contentColorForek8zF_U;
                        f2 = f110;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1037492569, i5, i28, "androidx.compose.material.Scaffold (Scaffold.kt:158)");
                    }
                    InterfaceC0526Fp interfaceC0526Fp16 = interfaceC0526FpM1077getLambda1$material_release;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new ScaffoldKt$Scaffold$child$1(jM1044getBackground0d7_KjU, jM1069contentColorForek8zF_U2, i28, z3, iM1130getEnd5ygKITE, interfaceC0526FpM1077getLambda1$material_release, interfaceC0552Gp3, interfaceC0526FpM1080getLambda4$material_release, interfaceC0526FpM1078getLambda2$material_release, i5, interfaceC0552GpM1079getLambda3$material_release, scaffoldState2));
                    if (interfaceC0552Gp5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-1013848234);
                        int i3111 = i28 << 12;
                        DrawerKt.m1094ModalDrawerGs3lGvM(interfaceC0552Gp5, modifier2, scaffoldState2.getDrawerState(), z5, large, f2, jM1055getSurface0d7_KjU, j6, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new ScaffoldKt$Scaffold$1(composableLambda)), composerStartRestartGroup, ((i5 >> 24) & 14) | 805306368 | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i3111 & 57344) | (i3111 & 458752) | (i3111 & 3670016) | (i3111 & 29360128) | (i3111 & 234881024), 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-1013847725);
                        composableLambda.invoke(modifier2, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scaffoldState3 = scaffoldState2;
                    interfaceC0526Fp5 = interfaceC0526FpM1080getLambda4$material_release;
                    f3 = f2;
                    j7 = jM1055getSurface0d7_KjU;
                    j8 = j6;
                    j9 = scrimColor;
                    j10 = jM1044getBackground0d7_KjU;
                    j11 = jM1069contentColorForek8zF_U2;
                    interfaceC0552Gp6 = interfaceC0552Gp5;
                    interfaceC0526Fp6 = interfaceC0526Fp16;
                    int i3112 = iM1130getEnd5ygKITE;
                    z6 = z5;
                    interfaceC0526Fp7 = interfaceC0526FpM1078getLambda2$material_release;
                    i29 = i3112;
                    boolean z1113 = z3;
                    shape2 = large;
                    interfaceC0552Gp7 = interfaceC0552GpM1079getLambda3$material_release;
                    z7 = z1113;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier2, scaffoldState3, interfaceC0526Fp6, interfaceC0526Fp7, interfaceC0552Gp7, interfaceC0526Fp5, i29, z7, interfaceC0552Gp6, z6, shape2, f3, j7, j8, j9, j10, j11, interfaceC0552Gp3, i2, i3, i4));
            }
            i24 = 12582912;
            i21 |= i24;
            if ((i5 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i32 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i4 & 2) != 0) {
                        scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    } else {
                        scaffoldStateRememberScaffoldState = scaffoldState;
                    }
                    if (i33 != 0) {
                        interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                    } else {
                        interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                    }
                    if (i6 != 0) {
                        interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                    } else {
                        interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                    }
                    if (i8 != 0) {
                        interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                    } else {
                        interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                    }
                    if (i11 != 0) {
                        interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                    } else {
                        interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                    }
                    if (i15 != 0) {
                        z3 = false;
                    } else {
                        z3 = z;
                    }
                    if (i17 != 0) {
                        interfaceC0552Gp4 = null;
                    } else {
                        interfaceC0552Gp4 = interfaceC0552Gp2;
                    }
                    if (i19 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                    interfaceC0552Gp5 = interfaceC0552Gp4;
                    if ((i4 & 1024) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i21 &= -15;
                    } else {
                        large = shape;
                    }
                    i25 = i21;
                    if (i22 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f;
                    }
                    if ((i4 & 4096) != 0) {
                        boolean z1114 = z4;
                        i26 = i25 & (-897);
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        z5 = z1114;
                    } else {
                        z5 = z4;
                        i26 = i25;
                        jM1055getSurface0d7_KjU = j;
                    }
                    float f111 = fM1091getElevationD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                        i26 &= -7169;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i4 & 16384) != 0) {
                        i27 = 6;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i26 &= -57345;
                    } else {
                        i27 = 6;
                        scrimColor = j3;
                    }
                    if ((32768 & i4) != 0) {
                        jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                        i26 &= -458753;
                    } else {
                        jM1044getBackground0d7_KjU = j4;
                    }
                    if ((i4 & 65536) != 0) {
                        i28 = i26 & (-3670017);
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                    } else {
                        jM1069contentColorForek8zF_U2 = j5;
                        i28 = i26;
                    }
                    j6 = jM1069contentColorForek8zF_U;
                    f2 = f111;
                } else {
                    if (i32 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i4 & 2) != 0) {
                        scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    } else {
                        scaffoldStateRememberScaffoldState = scaffoldState;
                    }
                    if (i33 != 0) {
                        interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                    } else {
                        interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                    }
                    if (i6 != 0) {
                        interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                    } else {
                        interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                    }
                    if (i8 != 0) {
                        interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                    } else {
                        interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                    }
                    if (i11 != 0) {
                        interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                    } else {
                        interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                    }
                    if (i15 != 0) {
                        z3 = false;
                    } else {
                        z3 = z;
                    }
                    if (i17 != 0) {
                        interfaceC0552Gp4 = null;
                    } else {
                        interfaceC0552Gp4 = interfaceC0552Gp2;
                    }
                    if (i19 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                    interfaceC0552Gp5 = interfaceC0552Gp4;
                    if ((i4 & 1024) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i21 &= -15;
                    } else {
                        large = shape;
                    }
                    i25 = i21;
                    if (i22 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f;
                    }
                    if ((i4 & 4096) != 0) {
                        boolean z1115 = z4;
                        i26 = i25 & (-897);
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        z5 = z1115;
                    } else {
                        z5 = z4;
                        i26 = i25;
                        jM1055getSurface0d7_KjU = j;
                    }
                    float f112 = fM1091getElevationD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                        i26 &= -7169;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i4 & 16384) != 0) {
                        i27 = 6;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i26 &= -57345;
                    } else {
                        i27 = 6;
                        scrimColor = j3;
                    }
                    if ((32768 & i4) != 0) {
                        jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                        i26 &= -458753;
                    } else {
                        jM1044getBackground0d7_KjU = j4;
                    }
                    if ((i4 & 65536) != 0) {
                        i28 = i26 & (-3670017);
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                    } else {
                        jM1069contentColorForek8zF_U2 = j5;
                        i28 = i26;
                    }
                    j6 = jM1069contentColorForek8zF_U;
                    f2 = f112;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1037492569, i5, i28, "androidx.compose.material.Scaffold (Scaffold.kt:158)");
                }
                InterfaceC0526Fp interfaceC0526Fp17 = interfaceC0526FpM1077getLambda1$material_release;
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new ScaffoldKt$Scaffold$child$1(jM1044getBackground0d7_KjU, jM1069contentColorForek8zF_U2, i28, z3, iM1130getEnd5ygKITE, interfaceC0526FpM1077getLambda1$material_release, interfaceC0552Gp3, interfaceC0526FpM1080getLambda4$material_release, interfaceC0526FpM1078getLambda2$material_release, i5, interfaceC0552GpM1079getLambda3$material_release, scaffoldState2));
                if (interfaceC0552Gp5 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-1013848234);
                    int i3113 = i28 << 12;
                    DrawerKt.m1094ModalDrawerGs3lGvM(interfaceC0552Gp5, modifier2, scaffoldState2.getDrawerState(), z5, large, f2, jM1055getSurface0d7_KjU, j6, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new ScaffoldKt$Scaffold$1(composableLambda)), composerStartRestartGroup, ((i5 >> 24) & 14) | 805306368 | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i3113 & 57344) | (i3113 & 458752) | (i3113 & 3670016) | (i3113 & 29360128) | (i3113 & 234881024), 0);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-1013847725);
                    composableLambda.invoke(modifier2, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                    composerStartRestartGroup.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scaffoldState3 = scaffoldState2;
                interfaceC0526Fp5 = interfaceC0526FpM1080getLambda4$material_release;
                f3 = f2;
                j7 = jM1055getSurface0d7_KjU;
                j8 = j6;
                j9 = scrimColor;
                j10 = jM1044getBackground0d7_KjU;
                j11 = jM1069contentColorForek8zF_U2;
                interfaceC0552Gp6 = interfaceC0552Gp5;
                interfaceC0526Fp6 = interfaceC0526Fp17;
                int i3114 = iM1130getEnd5ygKITE;
                z6 = z5;
                interfaceC0526Fp7 = interfaceC0526FpM1078getLambda2$material_release;
                i29 = i3114;
                boolean z1116 = z3;
                shape2 = large;
                interfaceC0552Gp7 = interfaceC0552GpM1079getLambda3$material_release;
                z7 = z1116;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i32 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i4 & 2) != 0) {
                        scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    } else {
                        scaffoldStateRememberScaffoldState = scaffoldState;
                    }
                    if (i33 != 0) {
                        interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                    } else {
                        interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                    }
                    if (i6 != 0) {
                        interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                    } else {
                        interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                    }
                    if (i8 != 0) {
                        interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                    } else {
                        interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                    }
                    if (i11 != 0) {
                        interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                    } else {
                        interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                    }
                    if (i15 != 0) {
                        z3 = false;
                    } else {
                        z3 = z;
                    }
                    if (i17 != 0) {
                        interfaceC0552Gp4 = null;
                    } else {
                        interfaceC0552Gp4 = interfaceC0552Gp2;
                    }
                    if (i19 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                    interfaceC0552Gp5 = interfaceC0552Gp4;
                    if ((i4 & 1024) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i21 &= -15;
                    } else {
                        large = shape;
                    }
                    i25 = i21;
                    if (i22 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f;
                    }
                    if ((i4 & 4096) != 0) {
                        boolean z1117 = z4;
                        i26 = i25 & (-897);
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        z5 = z1117;
                    } else {
                        z5 = z4;
                        i26 = i25;
                        jM1055getSurface0d7_KjU = j;
                    }
                    float f113 = fM1091getElevationD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                        i26 &= -7169;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i4 & 16384) != 0) {
                        i27 = 6;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i26 &= -57345;
                    } else {
                        i27 = 6;
                        scrimColor = j3;
                    }
                    if ((32768 & i4) != 0) {
                        jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                        i26 &= -458753;
                    } else {
                        jM1044getBackground0d7_KjU = j4;
                    }
                    if ((i4 & 65536) != 0) {
                        i28 = i26 & (-3670017);
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                    } else {
                        jM1069contentColorForek8zF_U2 = j5;
                        i28 = i26;
                    }
                    j6 = jM1069contentColorForek8zF_U;
                    f2 = f113;
                } else {
                    if (i32 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i4 & 2) != 0) {
                        scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    } else {
                        scaffoldStateRememberScaffoldState = scaffoldState;
                    }
                    if (i33 != 0) {
                        interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                    } else {
                        interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                    }
                    if (i6 != 0) {
                        interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                    } else {
                        interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                    }
                    if (i8 != 0) {
                        interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                    } else {
                        interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                    }
                    if (i11 != 0) {
                        interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                    } else {
                        interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                    }
                    if (i15 != 0) {
                        z3 = false;
                    } else {
                        z3 = z;
                    }
                    if (i17 != 0) {
                        interfaceC0552Gp4 = null;
                    } else {
                        interfaceC0552Gp4 = interfaceC0552Gp2;
                    }
                    if (i19 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                    interfaceC0552Gp5 = interfaceC0552Gp4;
                    if ((i4 & 1024) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i21 &= -15;
                    } else {
                        large = shape;
                    }
                    i25 = i21;
                    if (i22 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f;
                    }
                    if ((i4 & 4096) != 0) {
                        boolean z1118 = z4;
                        i26 = i25 & (-897);
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        z5 = z1118;
                    } else {
                        z5 = z4;
                        i26 = i25;
                        jM1055getSurface0d7_KjU = j;
                    }
                    float f114 = fM1091getElevationD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                        i26 &= -7169;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i4 & 16384) != 0) {
                        i27 = 6;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i26 &= -57345;
                    } else {
                        i27 = 6;
                        scrimColor = j3;
                    }
                    if ((32768 & i4) != 0) {
                        jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                        i26 &= -458753;
                    } else {
                        jM1044getBackground0d7_KjU = j4;
                    }
                    if ((i4 & 65536) != 0) {
                        i28 = i26 & (-3670017);
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                    } else {
                        jM1069contentColorForek8zF_U2 = j5;
                        i28 = i26;
                    }
                    j6 = jM1069contentColorForek8zF_U;
                    f2 = f114;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1037492569, i5, i28, "androidx.compose.material.Scaffold (Scaffold.kt:158)");
                }
                InterfaceC0526Fp interfaceC0526Fp18 = interfaceC0526FpM1077getLambda1$material_release;
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new ScaffoldKt$Scaffold$child$1(jM1044getBackground0d7_KjU, jM1069contentColorForek8zF_U2, i28, z3, iM1130getEnd5ygKITE, interfaceC0526FpM1077getLambda1$material_release, interfaceC0552Gp3, interfaceC0526FpM1080getLambda4$material_release, interfaceC0526FpM1078getLambda2$material_release, i5, interfaceC0552GpM1079getLambda3$material_release, scaffoldState2));
                if (interfaceC0552Gp5 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-1013848234);
                    int i3115 = i28 << 12;
                    DrawerKt.m1094ModalDrawerGs3lGvM(interfaceC0552Gp5, modifier2, scaffoldState2.getDrawerState(), z5, large, f2, jM1055getSurface0d7_KjU, j6, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new ScaffoldKt$Scaffold$1(composableLambda)), composerStartRestartGroup, ((i5 >> 24) & 14) | 805306368 | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i3115 & 57344) | (i3115 & 458752) | (i3115 & 3670016) | (i3115 & 29360128) | (i3115 & 234881024), 0);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-1013847725);
                    composableLambda.invoke(modifier2, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                    composerStartRestartGroup.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scaffoldState3 = scaffoldState2;
                interfaceC0526Fp5 = interfaceC0526FpM1080getLambda4$material_release;
                f3 = f2;
                j7 = jM1055getSurface0d7_KjU;
                j8 = j6;
                j9 = scrimColor;
                j10 = jM1044getBackground0d7_KjU;
                j11 = jM1069contentColorForek8zF_U2;
                interfaceC0552Gp6 = interfaceC0552Gp5;
                interfaceC0526Fp6 = interfaceC0526Fp18;
                int i3116 = iM1130getEnd5ygKITE;
                z6 = z5;
                interfaceC0526Fp7 = interfaceC0526FpM1078getLambda2$material_release;
                i29 = i3116;
                boolean z1119 = z3;
                shape2 = large;
                interfaceC0552Gp7 = interfaceC0552GpM1079getLambda3$material_release;
                z7 = z1119;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier2, scaffoldState3, interfaceC0526Fp6, interfaceC0526Fp7, interfaceC0552Gp7, interfaceC0526Fp5, i29, z7, interfaceC0552Gp6, z6, shape2, f3, j7, j8, j9, j10, j11, interfaceC0552Gp3, i2, i3, i4));
        }
        i5 |= 3072;
        i8 = i4 & 16;
        i9 = 8192;
        if (i8 != 0) {
            i5 |= 24576;
        } else if ((i2 & 57344) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                i10 = 16384;
            } else {
                i10 = 8192;
            }
            i5 |= i10;
        }
        i11 = i4 & 32;
        if (i11 != 0) {
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            interfaceC0526Fp4 = interfaceC0526Fp3;
        } else {
            interfaceC0526Fp4 = interfaceC0526Fp3;
            if ((i2 & 458752) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                    i12 = 131072;
                } else {
                    i12 = 65536;
                }
                i5 |= i12;
            }
        }
        i13 = i4 & 64;
        if (i13 != 0) {
            i5 |= 1572864;
            iM1130getEnd5ygKITE = i;
        } else {
            iM1130getEnd5ygKITE = i;
            if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changed(iM1130getEnd5ygKITE)) {
                    i14 = 1048576;
                } else {
                    i14 = 524288;
                }
                i5 |= i14;
            }
        }
        i15 = i4 & 128;
        if (i15 != 0) {
            i5 |= 12582912;
        } else if ((i2 & 29360128) == 0) {
            if (composerStartRestartGroup.changed(z)) {
                i16 = 8388608;
            } else {
                i16 = 4194304;
            }
            i5 |= i16;
        }
        i17 = i4 & 256;
        if (i17 != 0) {
            i5 |= 100663296;
        } else if ((i2 & 234881024) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                i18 = 67108864;
            } else {
                i18 = 33554432;
            }
            i5 |= i18;
        }
        i19 = i4 & 512;
        if (i19 != 0) {
            i5 |= 805306368;
        } else if ((i2 & 1879048192) == 0) {
            if (composerStartRestartGroup.changed(z2)) {
                i20 = PropertyOptions.DELETE_EXISTING;
            } else {
                i20 = 268435456;
            }
            i5 |= i20;
        }
        if ((i3 & 14) == 0) {
            i21 = i3 | (((i4 & 1024) == 0 || !composerStartRestartGroup.changed(shape)) ? 2 : 4);
        } else {
            i21 = i3;
        }
        i22 = i4 & 2048;
        if (i22 != 0) {
            i21 |= 48;
        } else if ((i3 & 112) == 0) {
            if (composerStartRestartGroup.changed(f)) {
                i23 = 32;
            } else {
                i23 = 16;
            }
            i21 |= i23;
        }
        if ((i3 & 896) != 0) {
            i21 |= ((i4 & 4096) == 0 || !composerStartRestartGroup.changed(j)) ? 128 : 256;
        }
        if ((i3 & 7168) != 0) {
            i21 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(j2)) ? 1024 : 2048;
        }
        if ((i3 & 57344) != 0) {
            if ((i4 & 16384) == 0) {
                i9 = 16384;
            }
            i21 |= i9;
        }
        if ((i3 & 458752) != 0) {
            if ((i4 & 32768) == 0) {
                i31 = 65536;
            } else {
                i31 = 65536;
            }
            i21 |= i31;
        }
        if ((i3 & 3670016) != 0) {
            if ((i4 & 65536) == 0) {
                i30 = 524288;
            } else {
                i30 = 524288;
            }
            i21 |= i30;
        }
        if ((i4 & 131072) != 0) {
            if ((i3 & 29360128) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp3)) {
                    i24 = 8388608;
                } else {
                    i24 = 4194304;
                }
            }
            if ((i5 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i32 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i4 & 2) != 0) {
                        scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    } else {
                        scaffoldStateRememberScaffoldState = scaffoldState;
                    }
                    if (i33 != 0) {
                        interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                    } else {
                        interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                    }
                    if (i6 != 0) {
                        interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                    } else {
                        interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                    }
                    if (i8 != 0) {
                        interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                    } else {
                        interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                    }
                    if (i11 != 0) {
                        interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                    } else {
                        interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                    }
                    if (i15 != 0) {
                        z3 = false;
                    } else {
                        z3 = z;
                    }
                    if (i17 != 0) {
                        interfaceC0552Gp4 = null;
                    } else {
                        interfaceC0552Gp4 = interfaceC0552Gp2;
                    }
                    if (i19 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                    interfaceC0552Gp5 = interfaceC0552Gp4;
                    if ((i4 & 1024) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i21 &= -15;
                    } else {
                        large = shape;
                    }
                    i25 = i21;
                    if (i22 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f;
                    }
                    if ((i4 & 4096) != 0) {
                        boolean z11110 = z4;
                        i26 = i25 & (-897);
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        z5 = z11110;
                    } else {
                        z5 = z4;
                        i26 = i25;
                        jM1055getSurface0d7_KjU = j;
                    }
                    float f115 = fM1091getElevationD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                        i26 &= -7169;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i4 & 16384) != 0) {
                        i27 = 6;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i26 &= -57345;
                    } else {
                        i27 = 6;
                        scrimColor = j3;
                    }
                    if ((32768 & i4) != 0) {
                        jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                        i26 &= -458753;
                    } else {
                        jM1044getBackground0d7_KjU = j4;
                    }
                    if ((i4 & 65536) != 0) {
                        i28 = i26 & (-3670017);
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                    } else {
                        jM1069contentColorForek8zF_U2 = j5;
                        i28 = i26;
                    }
                    j6 = jM1069contentColorForek8zF_U;
                    f2 = f115;
                } else {
                    if (i32 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i4 & 2) != 0) {
                        scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    } else {
                        scaffoldStateRememberScaffoldState = scaffoldState;
                    }
                    if (i33 != 0) {
                        interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                    } else {
                        interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                    }
                    if (i6 != 0) {
                        interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                    } else {
                        interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                    }
                    if (i8 != 0) {
                        interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                    } else {
                        interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                    }
                    if (i11 != 0) {
                        interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                    } else {
                        interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                    }
                    if (i15 != 0) {
                        z3 = false;
                    } else {
                        z3 = z;
                    }
                    if (i17 != 0) {
                        interfaceC0552Gp4 = null;
                    } else {
                        interfaceC0552Gp4 = interfaceC0552Gp2;
                    }
                    if (i19 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                    interfaceC0552Gp5 = interfaceC0552Gp4;
                    if ((i4 & 1024) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i21 &= -15;
                    } else {
                        large = shape;
                    }
                    i25 = i21;
                    if (i22 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f;
                    }
                    if ((i4 & 4096) != 0) {
                        boolean z11111 = z4;
                        i26 = i25 & (-897);
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        z5 = z11111;
                    } else {
                        z5 = z4;
                        i26 = i25;
                        jM1055getSurface0d7_KjU = j;
                    }
                    float f116 = fM1091getElevationD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                        i26 &= -7169;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i4 & 16384) != 0) {
                        i27 = 6;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i26 &= -57345;
                    } else {
                        i27 = 6;
                        scrimColor = j3;
                    }
                    if ((32768 & i4) != 0) {
                        jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                        i26 &= -458753;
                    } else {
                        jM1044getBackground0d7_KjU = j4;
                    }
                    if ((i4 & 65536) != 0) {
                        i28 = i26 & (-3670017);
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                    } else {
                        jM1069contentColorForek8zF_U2 = j5;
                        i28 = i26;
                    }
                    j6 = jM1069contentColorForek8zF_U;
                    f2 = f116;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1037492569, i5, i28, "androidx.compose.material.Scaffold (Scaffold.kt:158)");
                }
                InterfaceC0526Fp interfaceC0526Fp19 = interfaceC0526FpM1077getLambda1$material_release;
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new ScaffoldKt$Scaffold$child$1(jM1044getBackground0d7_KjU, jM1069contentColorForek8zF_U2, i28, z3, iM1130getEnd5ygKITE, interfaceC0526FpM1077getLambda1$material_release, interfaceC0552Gp3, interfaceC0526FpM1080getLambda4$material_release, interfaceC0526FpM1078getLambda2$material_release, i5, interfaceC0552GpM1079getLambda3$material_release, scaffoldState2));
                if (interfaceC0552Gp5 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-1013848234);
                    int i3117 = i28 << 12;
                    DrawerKt.m1094ModalDrawerGs3lGvM(interfaceC0552Gp5, modifier2, scaffoldState2.getDrawerState(), z5, large, f2, jM1055getSurface0d7_KjU, j6, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new ScaffoldKt$Scaffold$1(composableLambda)), composerStartRestartGroup, ((i5 >> 24) & 14) | 805306368 | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i3117 & 57344) | (i3117 & 458752) | (i3117 & 3670016) | (i3117 & 29360128) | (i3117 & 234881024), 0);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-1013847725);
                    composableLambda.invoke(modifier2, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                    composerStartRestartGroup.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scaffoldState3 = scaffoldState2;
                interfaceC0526Fp5 = interfaceC0526FpM1080getLambda4$material_release;
                f3 = f2;
                j7 = jM1055getSurface0d7_KjU;
                j8 = j6;
                j9 = scrimColor;
                j10 = jM1044getBackground0d7_KjU;
                j11 = jM1069contentColorForek8zF_U2;
                interfaceC0552Gp6 = interfaceC0552Gp5;
                interfaceC0526Fp6 = interfaceC0526Fp19;
                int i3118 = iM1130getEnd5ygKITE;
                z6 = z5;
                interfaceC0526Fp7 = interfaceC0526FpM1078getLambda2$material_release;
                i29 = i3118;
                boolean z11112 = z3;
                shape2 = large;
                interfaceC0552Gp7 = interfaceC0552GpM1079getLambda3$material_release;
                z7 = z11112;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i32 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i4 & 2) != 0) {
                        scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    } else {
                        scaffoldStateRememberScaffoldState = scaffoldState;
                    }
                    if (i33 != 0) {
                        interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                    } else {
                        interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                    }
                    if (i6 != 0) {
                        interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                    } else {
                        interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                    }
                    if (i8 != 0) {
                        interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                    } else {
                        interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                    }
                    if (i11 != 0) {
                        interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                    } else {
                        interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                    }
                    if (i15 != 0) {
                        z3 = false;
                    } else {
                        z3 = z;
                    }
                    if (i17 != 0) {
                        interfaceC0552Gp4 = null;
                    } else {
                        interfaceC0552Gp4 = interfaceC0552Gp2;
                    }
                    if (i19 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                    interfaceC0552Gp5 = interfaceC0552Gp4;
                    if ((i4 & 1024) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i21 &= -15;
                    } else {
                        large = shape;
                    }
                    i25 = i21;
                    if (i22 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f;
                    }
                    if ((i4 & 4096) != 0) {
                        boolean z11113 = z4;
                        i26 = i25 & (-897);
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        z5 = z11113;
                    } else {
                        z5 = z4;
                        i26 = i25;
                        jM1055getSurface0d7_KjU = j;
                    }
                    float f117 = fM1091getElevationD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                        i26 &= -7169;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i4 & 16384) != 0) {
                        i27 = 6;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i26 &= -57345;
                    } else {
                        i27 = 6;
                        scrimColor = j3;
                    }
                    if ((32768 & i4) != 0) {
                        jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                        i26 &= -458753;
                    } else {
                        jM1044getBackground0d7_KjU = j4;
                    }
                    if ((i4 & 65536) != 0) {
                        i28 = i26 & (-3670017);
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                    } else {
                        jM1069contentColorForek8zF_U2 = j5;
                        i28 = i26;
                    }
                    j6 = jM1069contentColorForek8zF_U;
                    f2 = f117;
                } else {
                    if (i32 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i4 & 2) != 0) {
                        scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    } else {
                        scaffoldStateRememberScaffoldState = scaffoldState;
                    }
                    if (i33 != 0) {
                        interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                    } else {
                        interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                    }
                    if (i6 != 0) {
                        interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                    } else {
                        interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                    }
                    if (i8 != 0) {
                        interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                    } else {
                        interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                    }
                    if (i11 != 0) {
                        interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                    } else {
                        interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                    }
                    if (i15 != 0) {
                        z3 = false;
                    } else {
                        z3 = z;
                    }
                    if (i17 != 0) {
                        interfaceC0552Gp4 = null;
                    } else {
                        interfaceC0552Gp4 = interfaceC0552Gp2;
                    }
                    if (i19 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                    interfaceC0552Gp5 = interfaceC0552Gp4;
                    if ((i4 & 1024) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i21 &= -15;
                    } else {
                        large = shape;
                    }
                    i25 = i21;
                    if (i22 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f;
                    }
                    if ((i4 & 4096) != 0) {
                        boolean z11114 = z4;
                        i26 = i25 & (-897);
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        z5 = z11114;
                    } else {
                        z5 = z4;
                        i26 = i25;
                        jM1055getSurface0d7_KjU = j;
                    }
                    float f118 = fM1091getElevationD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                        i26 &= -7169;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i4 & 16384) != 0) {
                        i27 = 6;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i26 &= -57345;
                    } else {
                        i27 = 6;
                        scrimColor = j3;
                    }
                    if ((32768 & i4) != 0) {
                        jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                        i26 &= -458753;
                    } else {
                        jM1044getBackground0d7_KjU = j4;
                    }
                    if ((i4 & 65536) != 0) {
                        i28 = i26 & (-3670017);
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                    } else {
                        jM1069contentColorForek8zF_U2 = j5;
                        i28 = i26;
                    }
                    j6 = jM1069contentColorForek8zF_U;
                    f2 = f118;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1037492569, i5, i28, "androidx.compose.material.Scaffold (Scaffold.kt:158)");
                }
                InterfaceC0526Fp interfaceC0526Fp110 = interfaceC0526FpM1077getLambda1$material_release;
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new ScaffoldKt$Scaffold$child$1(jM1044getBackground0d7_KjU, jM1069contentColorForek8zF_U2, i28, z3, iM1130getEnd5ygKITE, interfaceC0526FpM1077getLambda1$material_release, interfaceC0552Gp3, interfaceC0526FpM1080getLambda4$material_release, interfaceC0526FpM1078getLambda2$material_release, i5, interfaceC0552GpM1079getLambda3$material_release, scaffoldState2));
                if (interfaceC0552Gp5 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-1013848234);
                    int i3119 = i28 << 12;
                    DrawerKt.m1094ModalDrawerGs3lGvM(interfaceC0552Gp5, modifier2, scaffoldState2.getDrawerState(), z5, large, f2, jM1055getSurface0d7_KjU, j6, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new ScaffoldKt$Scaffold$1(composableLambda)), composerStartRestartGroup, ((i5 >> 24) & 14) | 805306368 | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i3119 & 57344) | (i3119 & 458752) | (i3119 & 3670016) | (i3119 & 29360128) | (i3119 & 234881024), 0);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-1013847725);
                    composableLambda.invoke(modifier2, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                    composerStartRestartGroup.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scaffoldState3 = scaffoldState2;
                interfaceC0526Fp5 = interfaceC0526FpM1080getLambda4$material_release;
                f3 = f2;
                j7 = jM1055getSurface0d7_KjU;
                j8 = j6;
                j9 = scrimColor;
                j10 = jM1044getBackground0d7_KjU;
                j11 = jM1069contentColorForek8zF_U2;
                interfaceC0552Gp6 = interfaceC0552Gp5;
                interfaceC0526Fp6 = interfaceC0526Fp110;
                int i31110 = iM1130getEnd5ygKITE;
                z6 = z5;
                interfaceC0526Fp7 = interfaceC0526FpM1078getLambda2$material_release;
                i29 = i31110;
                boolean z11115 = z3;
                shape2 = large;
                interfaceC0552Gp7 = interfaceC0552GpM1079getLambda3$material_release;
                z7 = z11115;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier2, scaffoldState3, interfaceC0526Fp6, interfaceC0526Fp7, interfaceC0552Gp7, interfaceC0526Fp5, i29, z7, interfaceC0552Gp6, z6, shape2, f3, j7, j8, j9, j10, j11, interfaceC0552Gp3, i2, i3, i4));
        }
        i24 = 12582912;
        i21 |= i24;
        if ((i5 & 1533916891) != 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i32 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i4 & 2) != 0) {
                    scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                    i5 &= -113;
                } else {
                    scaffoldStateRememberScaffoldState = scaffoldState;
                }
                if (i33 != 0) {
                    interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                } else {
                    interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                }
                if (i6 != 0) {
                    interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                } else {
                    interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                }
                if (i8 != 0) {
                    interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                } else {
                    interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                }
                if (i11 != 0) {
                    interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                } else {
                    interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                }
                if (i13 != 0) {
                    iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                }
                if (i15 != 0) {
                    z3 = false;
                } else {
                    z3 = z;
                }
                if (i17 != 0) {
                    interfaceC0552Gp4 = null;
                } else {
                    interfaceC0552Gp4 = interfaceC0552Gp2;
                }
                if (i19 != 0) {
                    z4 = true;
                } else {
                    z4 = z2;
                }
                scaffoldState2 = scaffoldStateRememberScaffoldState;
                interfaceC0552Gp5 = interfaceC0552Gp4;
                if ((i4 & 1024) != 0) {
                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                    i21 &= -15;
                } else {
                    large = shape;
                }
                i25 = i21;
                if (i22 != 0) {
                    fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                } else {
                    fM1091getElevationD9Ej5fM = f;
                }
                if ((i4 & 4096) != 0) {
                    boolean z11116 = z4;
                    i26 = i25 & (-897);
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    z5 = z11116;
                } else {
                    z5 = z4;
                    i26 = i25;
                    jM1055getSurface0d7_KjU = j;
                }
                float f119 = fM1091getElevationD9Ej5fM;
                if ((i4 & 8192) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                    i26 &= -7169;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if ((i4 & 16384) != 0) {
                    i27 = 6;
                    scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    i26 &= -57345;
                } else {
                    i27 = 6;
                    scrimColor = j3;
                }
                if ((32768 & i4) != 0) {
                    jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                    i26 &= -458753;
                } else {
                    jM1044getBackground0d7_KjU = j4;
                }
                if ((i4 & 65536) != 0) {
                    i28 = i26 & (-3670017);
                    jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                } else {
                    jM1069contentColorForek8zF_U2 = j5;
                    i28 = i26;
                }
                j6 = jM1069contentColorForek8zF_U;
                f2 = f119;
            } else {
                if (i32 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i4 & 2) != 0) {
                    scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                    i5 &= -113;
                } else {
                    scaffoldStateRememberScaffoldState = scaffoldState;
                }
                if (i33 != 0) {
                    interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                } else {
                    interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                }
                if (i6 != 0) {
                    interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                } else {
                    interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                }
                if (i8 != 0) {
                    interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                } else {
                    interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                }
                if (i11 != 0) {
                    interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                } else {
                    interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                }
                if (i13 != 0) {
                    iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                }
                if (i15 != 0) {
                    z3 = false;
                } else {
                    z3 = z;
                }
                if (i17 != 0) {
                    interfaceC0552Gp4 = null;
                } else {
                    interfaceC0552Gp4 = interfaceC0552Gp2;
                }
                if (i19 != 0) {
                    z4 = true;
                } else {
                    z4 = z2;
                }
                scaffoldState2 = scaffoldStateRememberScaffoldState;
                interfaceC0552Gp5 = interfaceC0552Gp4;
                if ((i4 & 1024) != 0) {
                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                    i21 &= -15;
                } else {
                    large = shape;
                }
                i25 = i21;
                if (i22 != 0) {
                    fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                } else {
                    fM1091getElevationD9Ej5fM = f;
                }
                if ((i4 & 4096) != 0) {
                    boolean z11117 = z4;
                    i26 = i25 & (-897);
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    z5 = z11117;
                } else {
                    z5 = z4;
                    i26 = i25;
                    jM1055getSurface0d7_KjU = j;
                }
                float f1110 = fM1091getElevationD9Ej5fM;
                if ((i4 & 8192) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                    i26 &= -7169;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if ((i4 & 16384) != 0) {
                    i27 = 6;
                    scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    i26 &= -57345;
                } else {
                    i27 = 6;
                    scrimColor = j3;
                }
                if ((32768 & i4) != 0) {
                    jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                    i26 &= -458753;
                } else {
                    jM1044getBackground0d7_KjU = j4;
                }
                if ((i4 & 65536) != 0) {
                    i28 = i26 & (-3670017);
                    jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                } else {
                    jM1069contentColorForek8zF_U2 = j5;
                    i28 = i26;
                }
                j6 = jM1069contentColorForek8zF_U;
                f2 = f1110;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1037492569, i5, i28, "androidx.compose.material.Scaffold (Scaffold.kt:158)");
            }
            InterfaceC0526Fp interfaceC0526Fp111 = interfaceC0526FpM1077getLambda1$material_release;
            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new ScaffoldKt$Scaffold$child$1(jM1044getBackground0d7_KjU, jM1069contentColorForek8zF_U2, i28, z3, iM1130getEnd5ygKITE, interfaceC0526FpM1077getLambda1$material_release, interfaceC0552Gp3, interfaceC0526FpM1080getLambda4$material_release, interfaceC0526FpM1078getLambda2$material_release, i5, interfaceC0552GpM1079getLambda3$material_release, scaffoldState2));
            if (interfaceC0552Gp5 != null) {
                composerStartRestartGroup.startReplaceableGroup(-1013848234);
                int i31111 = i28 << 12;
                DrawerKt.m1094ModalDrawerGs3lGvM(interfaceC0552Gp5, modifier2, scaffoldState2.getDrawerState(), z5, large, f2, jM1055getSurface0d7_KjU, j6, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new ScaffoldKt$Scaffold$1(composableLambda)), composerStartRestartGroup, ((i5 >> 24) & 14) | 805306368 | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i31111 & 57344) | (i31111 & 458752) | (i31111 & 3670016) | (i31111 & 29360128) | (i31111 & 234881024), 0);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(-1013847725);
                composableLambda.invoke(modifier2, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                composerStartRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            scaffoldState3 = scaffoldState2;
            interfaceC0526Fp5 = interfaceC0526FpM1080getLambda4$material_release;
            f3 = f2;
            j7 = jM1055getSurface0d7_KjU;
            j8 = j6;
            j9 = scrimColor;
            j10 = jM1044getBackground0d7_KjU;
            j11 = jM1069contentColorForek8zF_U2;
            interfaceC0552Gp6 = interfaceC0552Gp5;
            interfaceC0526Fp6 = interfaceC0526Fp111;
            int i31112 = iM1130getEnd5ygKITE;
            z6 = z5;
            interfaceC0526Fp7 = interfaceC0526FpM1078getLambda2$material_release;
            i29 = i31112;
            boolean z11118 = z3;
            shape2 = large;
            interfaceC0552Gp7 = interfaceC0552GpM1079getLambda3$material_release;
            z7 = z11118;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i32 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i4 & 2) != 0) {
                    scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                    i5 &= -113;
                } else {
                    scaffoldStateRememberScaffoldState = scaffoldState;
                }
                if (i33 != 0) {
                    interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                } else {
                    interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                }
                if (i6 != 0) {
                    interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                } else {
                    interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                }
                if (i8 != 0) {
                    interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                } else {
                    interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                }
                if (i11 != 0) {
                    interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                } else {
                    interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                }
                if (i13 != 0) {
                    iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                }
                if (i15 != 0) {
                    z3 = false;
                } else {
                    z3 = z;
                }
                if (i17 != 0) {
                    interfaceC0552Gp4 = null;
                } else {
                    interfaceC0552Gp4 = interfaceC0552Gp2;
                }
                if (i19 != 0) {
                    z4 = true;
                } else {
                    z4 = z2;
                }
                scaffoldState2 = scaffoldStateRememberScaffoldState;
                interfaceC0552Gp5 = interfaceC0552Gp4;
                if ((i4 & 1024) != 0) {
                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                    i21 &= -15;
                } else {
                    large = shape;
                }
                i25 = i21;
                if (i22 != 0) {
                    fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                } else {
                    fM1091getElevationD9Ej5fM = f;
                }
                if ((i4 & 4096) != 0) {
                    boolean z11119 = z4;
                    i26 = i25 & (-897);
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    z5 = z11119;
                } else {
                    z5 = z4;
                    i26 = i25;
                    jM1055getSurface0d7_KjU = j;
                }
                float f1111 = fM1091getElevationD9Ej5fM;
                if ((i4 & 8192) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                    i26 &= -7169;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if ((i4 & 16384) != 0) {
                    i27 = 6;
                    scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    i26 &= -57345;
                } else {
                    i27 = 6;
                    scrimColor = j3;
                }
                if ((32768 & i4) != 0) {
                    jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                    i26 &= -458753;
                } else {
                    jM1044getBackground0d7_KjU = j4;
                }
                if ((i4 & 65536) != 0) {
                    i28 = i26 & (-3670017);
                    jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                } else {
                    jM1069contentColorForek8zF_U2 = j5;
                    i28 = i26;
                }
                j6 = jM1069contentColorForek8zF_U;
                f2 = f1111;
            } else {
                if (i32 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i4 & 2) != 0) {
                    scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                    i5 &= -113;
                } else {
                    scaffoldStateRememberScaffoldState = scaffoldState;
                }
                if (i33 != 0) {
                    interfaceC0526FpM1077getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1077getLambda1$material_release();
                } else {
                    interfaceC0526FpM1077getLambda1$material_release = interfaceC0526Fp;
                }
                if (i6 != 0) {
                    interfaceC0526FpM1078getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1078getLambda2$material_release();
                } else {
                    interfaceC0526FpM1078getLambda2$material_release = interfaceC0526Fp2;
                }
                if (i8 != 0) {
                    interfaceC0552GpM1079getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1079getLambda3$material_release();
                } else {
                    interfaceC0552GpM1079getLambda3$material_release = interfaceC0552Gp;
                }
                if (i11 != 0) {
                    interfaceC0526FpM1080getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1080getLambda4$material_release();
                } else {
                    interfaceC0526FpM1080getLambda4$material_release = interfaceC0526Fp3;
                }
                if (i13 != 0) {
                    iM1130getEnd5ygKITE = FabPosition.Companion.m1130getEnd5ygKITE();
                }
                if (i15 != 0) {
                    z3 = false;
                } else {
                    z3 = z;
                }
                if (i17 != 0) {
                    interfaceC0552Gp4 = null;
                } else {
                    interfaceC0552Gp4 = interfaceC0552Gp2;
                }
                if (i19 != 0) {
                    z4 = true;
                } else {
                    z4 = z2;
                }
                scaffoldState2 = scaffoldStateRememberScaffoldState;
                interfaceC0552Gp5 = interfaceC0552Gp4;
                if ((i4 & 1024) != 0) {
                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                    i21 &= -15;
                } else {
                    large = shape;
                }
                i25 = i21;
                if (i22 != 0) {
                    fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                } else {
                    fM1091getElevationD9Ej5fM = f;
                }
                if ((i4 & 4096) != 0) {
                    boolean z111110 = z4;
                    i26 = i25 & (-897);
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    z5 = z111110;
                } else {
                    z5 = z4;
                    i26 = i25;
                    jM1055getSurface0d7_KjU = j;
                }
                float f1112 = fM1091getElevationD9Ej5fM;
                if ((i4 & 8192) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i26 >> 6) & 14);
                    i26 &= -7169;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if ((i4 & 16384) != 0) {
                    i27 = 6;
                    scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    i26 &= -57345;
                } else {
                    i27 = 6;
                    scrimColor = j3;
                }
                if ((32768 & i4) != 0) {
                    jM1044getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i27).m1044getBackground0d7_KjU();
                    i26 &= -458753;
                } else {
                    jM1044getBackground0d7_KjU = j4;
                }
                if ((i4 & 65536) != 0) {
                    i28 = i26 & (-3670017);
                    jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1044getBackground0d7_KjU, composerStartRestartGroup, (i26 >> 15) & 14);
                } else {
                    jM1069contentColorForek8zF_U2 = j5;
                    i28 = i26;
                }
                j6 = jM1069contentColorForek8zF_U;
                f2 = f1112;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1037492569, i5, i28, "androidx.compose.material.Scaffold (Scaffold.kt:158)");
            }
            InterfaceC0526Fp interfaceC0526Fp112 = interfaceC0526FpM1077getLambda1$material_release;
            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new ScaffoldKt$Scaffold$child$1(jM1044getBackground0d7_KjU, jM1069contentColorForek8zF_U2, i28, z3, iM1130getEnd5ygKITE, interfaceC0526FpM1077getLambda1$material_release, interfaceC0552Gp3, interfaceC0526FpM1080getLambda4$material_release, interfaceC0526FpM1078getLambda2$material_release, i5, interfaceC0552GpM1079getLambda3$material_release, scaffoldState2));
            if (interfaceC0552Gp5 != null) {
                composerStartRestartGroup.startReplaceableGroup(-1013848234);
                int i31113 = i28 << 12;
                DrawerKt.m1094ModalDrawerGs3lGvM(interfaceC0552Gp5, modifier2, scaffoldState2.getDrawerState(), z5, large, f2, jM1055getSurface0d7_KjU, j6, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new ScaffoldKt$Scaffold$1(composableLambda)), composerStartRestartGroup, ((i5 >> 24) & 14) | 805306368 | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i31113 & 57344) | (i31113 & 458752) | (i31113 & 3670016) | (i31113 & 29360128) | (i31113 & 234881024), 0);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(-1013847725);
                composableLambda.invoke(modifier2, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                composerStartRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            scaffoldState3 = scaffoldState2;
            interfaceC0526Fp5 = interfaceC0526FpM1080getLambda4$material_release;
            f3 = f2;
            j7 = jM1055getSurface0d7_KjU;
            j8 = j6;
            j9 = scrimColor;
            j10 = jM1044getBackground0d7_KjU;
            j11 = jM1069contentColorForek8zF_U2;
            interfaceC0552Gp6 = interfaceC0552Gp5;
            interfaceC0526Fp6 = interfaceC0526Fp112;
            int i31114 = iM1130getEnd5ygKITE;
            z6 = z5;
            interfaceC0526Fp7 = interfaceC0526FpM1078getLambda2$material_release;
            i29 = i31114;
            boolean z111111 = z3;
            shape2 = large;
            interfaceC0552Gp7 = interfaceC0552GpM1079getLambda3$material_release;
            z7 = z111111;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier2, scaffoldState3, interfaceC0526Fp6, interfaceC0526Fp7, interfaceC0552Gp7, interfaceC0526Fp5, i29, z7, interfaceC0552Gp6, z6, shape2, f3, j7, j8, j9, j10, j11, interfaceC0552Gp3, i2, i3, i4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @UiComposable
    /* JADX INFO: renamed from: ScaffoldLayout-MDYNRJg, reason: not valid java name */
    public static final void m1195ScaffoldLayoutMDYNRJg(boolean z, int i, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, Composer composer, int i2) {
        Composer composer2;
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1401632215);
        int i4 = (i2 & 14) == 0 ? (composerStartRestartGroup.changed(z) ? 4 : 2) | i2 : i2;
        if ((i2 & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0552Gp) ? 2048 : 1024;
        }
        if ((57344 & i2) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp2) ? 16384 : 8192;
        }
        if ((458752 & i2) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp3) ? 131072 : 65536;
        }
        if ((3670016 & i2) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(interfaceC0526Fp4) ? 1048576 : 524288) | i4;
        }
        if ((2995931 & i4) == 599186 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1401632215, i4, -1, "androidx.compose.material.ScaffoldLayout (Scaffold.kt:227)");
            }
            Object[] objArr = {interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, FabPosition.m1122boximpl(i), Boolean.valueOf(z), interfaceC0526Fp4, interfaceC0552Gp};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            int i5 = 0;
            boolean zChanged = false;
            for (int i6 = 7; i5 < i6; i6 = 7) {
                zChanged |= composerStartRestartGroup.changed(objArr[i5]);
                i5++;
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                composer2 = composerStartRestartGroup;
                i3 = 1;
                ScaffoldKt$ScaffoldLayout$1$1 scaffoldKt$ScaffoldLayout$1$1 = new ScaffoldKt$ScaffoldLayout$1$1(interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, i, z, interfaceC0526Fp4, i4, interfaceC0552Gp);
                composer2.updateRememberedValue(scaffoldKt$ScaffoldLayout$1$1);
                objRememberedValue = scaffoldKt$ScaffoldLayout$1$1;
            } else {
                composer2 = composerStartRestartGroup;
                i3 = 1;
            }
            composer2.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (InterfaceC0526Fp) objRememberedValue, composer2, 0, i3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$ScaffoldLayout$2(z, i, interfaceC0526Fp, interfaceC0552Gp, interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, i2));
    }

    public static final ProvidableCompositionLocal<FabPlacement> getLocalFabPlacement() {
        return LocalFabPlacement;
    }

    @Composable
    public static final ScaffoldState rememberScaffoldState(DrawerState drawerState, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1569641925);
        if ((i2 & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, null, composer, 6, 2);
        }
        if ((i2 & 2) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) objRememberedValue;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1569641925, i, -1, "androidx.compose.material.rememberScaffoldState (Scaffold.kt:62)");
        }
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new ScaffoldState(drawerState, snackbarHostState);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        ScaffoldState scaffoldState = (ScaffoldState) objRememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return scaffoldState;
    }
}
