package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
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

    /* JADX WARN: Code duplicated, block: B:100:0x011d  */
    /* JADX WARN: Code duplicated, block: B:102:0x0121  */
    /* JADX WARN: Code duplicated, block: B:104:0x0126  */
    /* JADX WARN: Code duplicated, block: B:106:0x012c  */
    /* JADX WARN: Code duplicated, block: B:107:0x012f  */
    /* JADX WARN: Code duplicated, block: B:110:0x013b  */
    /* JADX WARN: Code duplicated, block: B:114:0x0154  */
    /* JADX WARN: Code duplicated, block: B:116:0x0164  */
    /* JADX WARN: Code duplicated, block: B:129:0x018f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:130:0x0191  */
    /* JADX WARN: Code duplicated, block: B:131:0x0194  */
    /* JADX WARN: Code duplicated, block: B:133:0x0198  */
    /* JADX WARN: Code duplicated, block: B:134:0x019f  */
    /* JADX WARN: Code duplicated, block: B:136:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:137:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:139:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:140:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:142:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:143:0x01be  */
    /* JADX WARN: Code duplicated, block: B:145:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:146:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:149:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:150:0x01df  */
    /* JADX WARN: Code duplicated, block: B:153:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:156:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:157:0x0206  */
    /* JADX WARN: Code duplicated, block: B:160:0x0214  */
    /* JADX WARN: Code duplicated, block: B:163:0x0264  */
    /* JADX WARN: Code duplicated, block: B:168:0x0276  */
    /* JADX WARN: Code duplicated, block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:33:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    /* JADX WARN: Code duplicated, block: B:43:0x007d  */
    /* JADX WARN: Code duplicated, block: B:44:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x0087  */
    /* JADX WARN: Code duplicated, block: B:50:0x008c  */
    /* JADX WARN: Code duplicated, block: B:52:0x0092  */
    /* JADX WARN: Code duplicated, block: B:54:0x009a  */
    /* JADX WARN: Code duplicated, block: B:55:0x009d  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:76:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:89:0x0101  */
    /* JADX WARN: Code duplicated, block: B:91:0x0105  */
    /* JADX WARN: Code duplicated, block: B:94:0x0110 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:97:0x0117  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_][_][_][_]]")
    /* JADX INFO: renamed from: Scaffold-TvnljyQ, reason: not valid java name */
    public static final void m1725ScaffoldTvnljyQ(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, int i, long j, long j2, WindowInsets windowInsets, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i2, int i3) {
        int i4;
        InterfaceC0526Fp interfaceC0526Fp5;
        int i5;
        InterfaceC0526Fp interfaceC0526Fp6;
        int i6;
        int i7;
        int i8;
        int i9;
        InterfaceC0526Fp interfaceC0526Fp7;
        int i10;
        int i11;
        int i12;
        long jM1449contentColorForek8zF_U;
        int i13;
        Modifier modifier2;
        InterfaceC0526Fp interfaceC0526FpM1475getLambda1$material3_release;
        InterfaceC0526Fp interfaceC0526FpM1476getLambda2$material3_release;
        InterfaceC0526Fp interfaceC0526FpM1477getLambda3$material3_release;
        InterfaceC0526Fp interfaceC0526FpM1478getLambda4$material3_release;
        int iM1571getEndERTFSPs;
        int i14;
        long jM1389getBackground0d7_KjU;
        int i15;
        WindowInsets contentWindowInsets;
        WindowInsets windowInsets2;
        long j3;
        long j4;
        InterfaceC0526Fp interfaceC0526Fp8;
        InterfaceC0526Fp interfaceC0526Fp9;
        InterfaceC0526Fp interfaceC0526Fp10;
        Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i16;
        int i17;
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-1219521777);
        int i18 = i3 & 1;
        if (i18 != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i19 = i3 & 2;
        if (i19 == 0) {
            if ((i2 & 112) == 0) {
                interfaceC0526Fp5 = interfaceC0526Fp;
                i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp5) ? 32 : 16;
            }
            i5 = i3 & 4;
            if (i5 != 0) {
                if ((i2 & 896) == 0) {
                    interfaceC0526Fp6 = interfaceC0526Fp2;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp6)) {
                        i6 = 256;
                    } else {
                        i6 = 128;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 8;
                if (i7 != 0) {
                    if ((i2 & 7168) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                            i8 = 2048;
                        } else {
                            i8 = 1024;
                        }
                        i4 |= i8;
                    }
                    i9 = i3 & 16;
                    if (i9 != 0) {
                        if ((57344 & i2) == 0) {
                            interfaceC0526Fp7 = interfaceC0526Fp4;
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp7)) {
                                i10 = 16384;
                            } else {
                                i10 = 8192;
                            }
                            i4 |= i10;
                        }
                        i11 = i3 & 32;
                        if (i11 != 0) {
                            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i2 & 458752) == 0) {
                            if (composerStartRestartGroup.changed(i)) {
                                i12 = 131072;
                            } else {
                                i12 = 65536;
                            }
                            i4 |= i12;
                        }
                        if ((i2 & 3670016) != 0) {
                            if ((i3 & 64) == 0 || !composerStartRestartGroup.changed(j)) {
                                i17 = 524288;
                            } else {
                                i17 = 1048576;
                            }
                            i4 |= i17;
                        }
                        if ((i2 & 29360128) == 0) {
                            jM1449contentColorForek8zF_U = j2;
                            if ((i3 & 128) == 0 || !composerStartRestartGroup.changed(jM1449contentColorForek8zF_U)) {
                                i16 = 4194304;
                            } else {
                                i16 = 8388608;
                            }
                            i4 |= i16;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if ((234881024 & i2) != 0) {
                            i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
                        }
                        if ((i3 & 512) != 0) {
                            if ((1879048192 & i2) == 0) {
                                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                    i13 = PropertyOptions.DELETE_EXISTING;
                                } else {
                                    i13 = 268435456;
                                }
                            }
                            if ((1533916891 & i4) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.startDefaults();
                                if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i18 != 0) {
                                        modifier2 = Modifier.Companion;
                                    } else {
                                        modifier2 = modifier;
                                    }
                                    if (i19 != 0) {
                                        interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                                    } else {
                                        interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                                    }
                                    if (i5 != 0) {
                                        interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                                    } else {
                                        interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                                    }
                                    if (i7 != 0) {
                                        interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                                    } else {
                                        interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                                    }
                                    if (i9 != 0) {
                                        interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                                    } else {
                                        interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                                    }
                                    if (i11 != 0) {
                                        iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                                    } else {
                                        iM1571getEndERTFSPs = i;
                                    }
                                    if ((i3 & 64) != 0) {
                                        i14 = i4 & (-3670017);
                                        jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                                    } else {
                                        i14 = i4;
                                        jM1389getBackground0d7_KjU = j;
                                    }
                                    if ((i3 & 128) != 0) {
                                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                        i14 &= -29360129;
                                    }
                                    if ((i3 & 256) != 0) {
                                        i15 = i14 & (-234881025);
                                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                        modifier2 = modifier2;
                                    } else {
                                        i15 = i14;
                                        contentWindowInsets = windowInsets;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i3 & 64) != 0) {
                                        i4 &= -3670017;
                                    }
                                    if ((i3 & 128) != 0) {
                                        i4 &= -29360129;
                                    }
                                    if ((i3 & 256) != 0) {
                                        i4 &= -234881025;
                                    }
                                    modifier2 = modifier;
                                    contentWindowInsets = windowInsets;
                                    interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                                    interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                                    interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                                    interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                                    iM1571getEndERTFSPs = i;
                                    i15 = i4;
                                    jM1389getBackground0d7_KjU = j;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                                }
                                int i20 = i15 >> 12;
                                SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i20 & 896) | (i20 & 7168), 114);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                windowInsets2 = contentWindowInsets;
                                j3 = jM1449contentColorForek8zF_U;
                                j4 = jM1389getBackground0d7_KjU;
                                interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                                interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                                interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                                interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                                modifier3 = modifier2;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                modifier3 = modifier;
                                interfaceC0526Fp9 = interfaceC0526Fp3;
                                windowInsets2 = windowInsets;
                                interfaceC0526Fp8 = interfaceC0526Fp6;
                                j3 = jM1449contentColorForek8zF_U;
                                interfaceC0526Fp10 = interfaceC0526Fp7;
                                iM1571getEndERTFSPs = i;
                                j4 = j;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
                        }
                        i13 = 805306368;
                        i4 |= i13;
                        if ((1533916891 & i4) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i2 & 1) != 0) {
                                if (i18 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i19 != 0) {
                                    interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                                } else {
                                    interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                                }
                                if (i5 != 0) {
                                    interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                                } else {
                                    interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                                }
                                if (i7 != 0) {
                                    interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                                } else {
                                    interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                                }
                                if (i9 != 0) {
                                    interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                                } else {
                                    interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                                }
                                if (i11 != 0) {
                                    iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                                } else {
                                    iM1571getEndERTFSPs = i;
                                }
                                if ((i3 & 64) != 0) {
                                    i14 = i4 & (-3670017);
                                    jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                                } else {
                                    i14 = i4;
                                    jM1389getBackground0d7_KjU = j;
                                }
                                if ((i3 & 128) != 0) {
                                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                    i14 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i15 = i14 & (-234881025);
                                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                    modifier2 = modifier2;
                                } else {
                                    i15 = i14;
                                    contentWindowInsets = windowInsets;
                                }
                            } else {
                                if (i18 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i19 != 0) {
                                    interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                                } else {
                                    interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                                }
                                if (i5 != 0) {
                                    interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                                } else {
                                    interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                                }
                                if (i7 != 0) {
                                    interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                                } else {
                                    interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                                }
                                if (i9 != 0) {
                                    interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                                } else {
                                    interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                                }
                                if (i11 != 0) {
                                    iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                                } else {
                                    iM1571getEndERTFSPs = i;
                                }
                                if ((i3 & 64) != 0) {
                                    i14 = i4 & (-3670017);
                                    jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                                } else {
                                    i14 = i4;
                                    jM1389getBackground0d7_KjU = j;
                                }
                                if ((i3 & 128) != 0) {
                                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                    i14 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i15 = i14 & (-234881025);
                                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                    modifier2 = modifier2;
                                } else {
                                    i15 = i14;
                                    contentWindowInsets = windowInsets;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                            }
                            int i21 = i15 >> 12;
                            SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i21 & 896) | (i21 & 7168), 114);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            windowInsets2 = contentWindowInsets;
                            j3 = jM1449contentColorForek8zF_U;
                            j4 = jM1389getBackground0d7_KjU;
                            interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                            interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                            interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                            interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                            modifier3 = modifier2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i2 & 1) != 0) {
                                if (i18 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i19 != 0) {
                                    interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                                } else {
                                    interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                                }
                                if (i5 != 0) {
                                    interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                                } else {
                                    interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                                }
                                if (i7 != 0) {
                                    interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                                } else {
                                    interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                                }
                                if (i9 != 0) {
                                    interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                                } else {
                                    interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                                }
                                if (i11 != 0) {
                                    iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                                } else {
                                    iM1571getEndERTFSPs = i;
                                }
                                if ((i3 & 64) != 0) {
                                    i14 = i4 & (-3670017);
                                    jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                                } else {
                                    i14 = i4;
                                    jM1389getBackground0d7_KjU = j;
                                }
                                if ((i3 & 128) != 0) {
                                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                    i14 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i15 = i14 & (-234881025);
                                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                    modifier2 = modifier2;
                                } else {
                                    i15 = i14;
                                    contentWindowInsets = windowInsets;
                                }
                            } else {
                                if (i18 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i19 != 0) {
                                    interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                                } else {
                                    interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                                }
                                if (i5 != 0) {
                                    interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                                } else {
                                    interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                                }
                                if (i7 != 0) {
                                    interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                                } else {
                                    interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                                }
                                if (i9 != 0) {
                                    interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                                } else {
                                    interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                                }
                                if (i11 != 0) {
                                    iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                                } else {
                                    iM1571getEndERTFSPs = i;
                                }
                                if ((i3 & 64) != 0) {
                                    i14 = i4 & (-3670017);
                                    jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                                } else {
                                    i14 = i4;
                                    jM1389getBackground0d7_KjU = j;
                                }
                                if ((i3 & 128) != 0) {
                                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                    i14 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i15 = i14 & (-234881025);
                                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                    modifier2 = modifier2;
                                } else {
                                    i15 = i14;
                                    contentWindowInsets = windowInsets;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                            }
                            int i22 = i15 >> 12;
                            SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i22 & 896) | (i22 & 7168), 114);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            windowInsets2 = contentWindowInsets;
                            j3 = jM1449contentColorForek8zF_U;
                            j4 = jM1389getBackground0d7_KjU;
                            interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                            interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                            interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                            interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                            modifier3 = modifier2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
                    }
                    i4 |= 24576;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    i11 = i3 & 32;
                    if (i11 != 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i2 & 458752) == 0) {
                        if (composerStartRestartGroup.changed(i)) {
                            i12 = 131072;
                        } else {
                            i12 = 65536;
                        }
                        i4 |= i12;
                    }
                    if ((i2 & 3670016) != 0) {
                        if ((i3 & 64) == 0) {
                            i17 = 524288;
                        } else {
                            i17 = 524288;
                        }
                        i4 |= i17;
                    }
                    if ((i2 & 29360128) == 0) {
                        jM1449contentColorForek8zF_U = j2;
                        if ((i3 & 128) == 0) {
                            i16 = 4194304;
                        } else {
                            i16 = 4194304;
                        }
                        i4 |= i16;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if ((234881024 & i2) != 0) {
                        i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
                    }
                    if ((i3 & 512) != 0) {
                        if ((1879048192 & i2) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i13 = PropertyOptions.DELETE_EXISTING;
                            } else {
                                i13 = 268435456;
                            }
                        }
                        if ((1533916891 & i4) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i2 & 1) != 0) {
                                if (i18 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i19 != 0) {
                                    interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                                } else {
                                    interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                                }
                                if (i5 != 0) {
                                    interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                                } else {
                                    interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                                }
                                if (i7 != 0) {
                                    interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                                } else {
                                    interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                                }
                                if (i9 != 0) {
                                    interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                                } else {
                                    interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                                }
                                if (i11 != 0) {
                                    iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                                } else {
                                    iM1571getEndERTFSPs = i;
                                }
                                if ((i3 & 64) != 0) {
                                    i14 = i4 & (-3670017);
                                    jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                                } else {
                                    i14 = i4;
                                    jM1389getBackground0d7_KjU = j;
                                }
                                if ((i3 & 128) != 0) {
                                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                    i14 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i15 = i14 & (-234881025);
                                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                    modifier2 = modifier2;
                                } else {
                                    i15 = i14;
                                    contentWindowInsets = windowInsets;
                                }
                            } else {
                                if (i18 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i19 != 0) {
                                    interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                                } else {
                                    interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                                }
                                if (i5 != 0) {
                                    interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                                } else {
                                    interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                                }
                                if (i7 != 0) {
                                    interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                                } else {
                                    interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                                }
                                if (i9 != 0) {
                                    interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                                } else {
                                    interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                                }
                                if (i11 != 0) {
                                    iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                                } else {
                                    iM1571getEndERTFSPs = i;
                                }
                                if ((i3 & 64) != 0) {
                                    i14 = i4 & (-3670017);
                                    jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                                } else {
                                    i14 = i4;
                                    jM1389getBackground0d7_KjU = j;
                                }
                                if ((i3 & 128) != 0) {
                                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                    i14 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i15 = i14 & (-234881025);
                                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                    modifier2 = modifier2;
                                } else {
                                    i15 = i14;
                                    contentWindowInsets = windowInsets;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                            }
                            int i23 = i15 >> 12;
                            SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i23 & 896) | (i23 & 7168), 114);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            windowInsets2 = contentWindowInsets;
                            j3 = jM1449contentColorForek8zF_U;
                            j4 = jM1389getBackground0d7_KjU;
                            interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                            interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                            interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                            interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                            modifier3 = modifier2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i2 & 1) != 0) {
                                if (i18 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i19 != 0) {
                                    interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                                } else {
                                    interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                                }
                                if (i5 != 0) {
                                    interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                                } else {
                                    interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                                }
                                if (i7 != 0) {
                                    interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                                } else {
                                    interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                                }
                                if (i9 != 0) {
                                    interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                                } else {
                                    interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                                }
                                if (i11 != 0) {
                                    iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                                } else {
                                    iM1571getEndERTFSPs = i;
                                }
                                if ((i3 & 64) != 0) {
                                    i14 = i4 & (-3670017);
                                    jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                                } else {
                                    i14 = i4;
                                    jM1389getBackground0d7_KjU = j;
                                }
                                if ((i3 & 128) != 0) {
                                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                    i14 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i15 = i14 & (-234881025);
                                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                    modifier2 = modifier2;
                                } else {
                                    i15 = i14;
                                    contentWindowInsets = windowInsets;
                                }
                            } else {
                                if (i18 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i19 != 0) {
                                    interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                                } else {
                                    interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                                }
                                if (i5 != 0) {
                                    interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                                } else {
                                    interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                                }
                                if (i7 != 0) {
                                    interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                                } else {
                                    interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                                }
                                if (i9 != 0) {
                                    interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                                } else {
                                    interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                                }
                                if (i11 != 0) {
                                    iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                                } else {
                                    iM1571getEndERTFSPs = i;
                                }
                                if ((i3 & 64) != 0) {
                                    i14 = i4 & (-3670017);
                                    jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                                } else {
                                    i14 = i4;
                                    jM1389getBackground0d7_KjU = j;
                                }
                                if ((i3 & 128) != 0) {
                                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                    i14 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i15 = i14 & (-234881025);
                                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                    modifier2 = modifier2;
                                } else {
                                    i15 = i14;
                                    contentWindowInsets = windowInsets;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                            }
                            int i24 = i15 >> 12;
                            SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i24 & 896) | (i24 & 7168), 114);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            windowInsets2 = contentWindowInsets;
                            j3 = jM1449contentColorForek8zF_U;
                            j4 = jM1389getBackground0d7_KjU;
                            interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                            interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                            interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                            interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                            modifier3 = modifier2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
                    }
                    i13 = 805306368;
                    i4 |= i13;
                    if ((1533916891 & i4) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                        }
                        int i25 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i25 & 896) | (i25 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets2 = contentWindowInsets;
                        j3 = jM1449contentColorForek8zF_U;
                        j4 = jM1389getBackground0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                        interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                        interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                        interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                        }
                        int i26 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i26 & 896) | (i26 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets2 = contentWindowInsets;
                        j3 = jM1449contentColorForek8zF_U;
                        j4 = jM1389getBackground0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                        interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                        interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                        interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
                }
                i4 |= 3072;
                i9 = i3 & 16;
                if (i9 != 0) {
                    if ((57344 & i2) == 0) {
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp7)) {
                            i10 = 16384;
                        } else {
                            i10 = 8192;
                        }
                        i4 |= i10;
                    }
                    i11 = i3 & 32;
                    if (i11 != 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i2 & 458752) == 0) {
                        if (composerStartRestartGroup.changed(i)) {
                            i12 = 131072;
                        } else {
                            i12 = 65536;
                        }
                        i4 |= i12;
                    }
                    if ((i2 & 3670016) != 0) {
                        if ((i3 & 64) == 0) {
                            i17 = 524288;
                        } else {
                            i17 = 524288;
                        }
                        i4 |= i17;
                    }
                    if ((i2 & 29360128) == 0) {
                        jM1449contentColorForek8zF_U = j2;
                        if ((i3 & 128) == 0) {
                            i16 = 4194304;
                        } else {
                            i16 = 4194304;
                        }
                        i4 |= i16;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if ((234881024 & i2) != 0) {
                        i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
                    }
                    if ((i3 & 512) != 0) {
                        if ((1879048192 & i2) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i13 = PropertyOptions.DELETE_EXISTING;
                            } else {
                                i13 = 268435456;
                            }
                        }
                        if ((1533916891 & i4) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i2 & 1) != 0) {
                                if (i18 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i19 != 0) {
                                    interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                                } else {
                                    interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                                }
                                if (i5 != 0) {
                                    interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                                } else {
                                    interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                                }
                                if (i7 != 0) {
                                    interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                                } else {
                                    interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                                }
                                if (i9 != 0) {
                                    interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                                } else {
                                    interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                                }
                                if (i11 != 0) {
                                    iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                                } else {
                                    iM1571getEndERTFSPs = i;
                                }
                                if ((i3 & 64) != 0) {
                                    i14 = i4 & (-3670017);
                                    jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                                } else {
                                    i14 = i4;
                                    jM1389getBackground0d7_KjU = j;
                                }
                                if ((i3 & 128) != 0) {
                                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                    i14 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i15 = i14 & (-234881025);
                                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                    modifier2 = modifier2;
                                } else {
                                    i15 = i14;
                                    contentWindowInsets = windowInsets;
                                }
                            } else {
                                if (i18 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i19 != 0) {
                                    interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                                } else {
                                    interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                                }
                                if (i5 != 0) {
                                    interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                                } else {
                                    interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                                }
                                if (i7 != 0) {
                                    interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                                } else {
                                    interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                                }
                                if (i9 != 0) {
                                    interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                                } else {
                                    interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                                }
                                if (i11 != 0) {
                                    iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                                } else {
                                    iM1571getEndERTFSPs = i;
                                }
                                if ((i3 & 64) != 0) {
                                    i14 = i4 & (-3670017);
                                    jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                                } else {
                                    i14 = i4;
                                    jM1389getBackground0d7_KjU = j;
                                }
                                if ((i3 & 128) != 0) {
                                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                    i14 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i15 = i14 & (-234881025);
                                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                    modifier2 = modifier2;
                                } else {
                                    i15 = i14;
                                    contentWindowInsets = windowInsets;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                            }
                            int i27 = i15 >> 12;
                            SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i27 & 896) | (i27 & 7168), 114);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            windowInsets2 = contentWindowInsets;
                            j3 = jM1449contentColorForek8zF_U;
                            j4 = jM1389getBackground0d7_KjU;
                            interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                            interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                            interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                            interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                            modifier3 = modifier2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i2 & 1) != 0) {
                                if (i18 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i19 != 0) {
                                    interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                                } else {
                                    interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                                }
                                if (i5 != 0) {
                                    interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                                } else {
                                    interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                                }
                                if (i7 != 0) {
                                    interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                                } else {
                                    interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                                }
                                if (i9 != 0) {
                                    interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                                } else {
                                    interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                                }
                                if (i11 != 0) {
                                    iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                                } else {
                                    iM1571getEndERTFSPs = i;
                                }
                                if ((i3 & 64) != 0) {
                                    i14 = i4 & (-3670017);
                                    jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                                } else {
                                    i14 = i4;
                                    jM1389getBackground0d7_KjU = j;
                                }
                                if ((i3 & 128) != 0) {
                                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                    i14 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i15 = i14 & (-234881025);
                                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                    modifier2 = modifier2;
                                } else {
                                    i15 = i14;
                                    contentWindowInsets = windowInsets;
                                }
                            } else {
                                if (i18 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i19 != 0) {
                                    interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                                } else {
                                    interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                                }
                                if (i5 != 0) {
                                    interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                                } else {
                                    interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                                }
                                if (i7 != 0) {
                                    interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                                } else {
                                    interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                                }
                                if (i9 != 0) {
                                    interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                                } else {
                                    interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                                }
                                if (i11 != 0) {
                                    iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                                } else {
                                    iM1571getEndERTFSPs = i;
                                }
                                if ((i3 & 64) != 0) {
                                    i14 = i4 & (-3670017);
                                    jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                                } else {
                                    i14 = i4;
                                    jM1389getBackground0d7_KjU = j;
                                }
                                if ((i3 & 128) != 0) {
                                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                    i14 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i15 = i14 & (-234881025);
                                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                    modifier2 = modifier2;
                                } else {
                                    i15 = i14;
                                    contentWindowInsets = windowInsets;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                            }
                            int i28 = i15 >> 12;
                            SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i28 & 896) | (i28 & 7168), 114);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            windowInsets2 = contentWindowInsets;
                            j3 = jM1449contentColorForek8zF_U;
                            j4 = jM1389getBackground0d7_KjU;
                            interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                            interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                            interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                            interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                            modifier3 = modifier2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
                    }
                    i13 = 805306368;
                    i4 |= i13;
                    if ((1533916891 & i4) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                        }
                        int i29 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i29 & 896) | (i29 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets2 = contentWindowInsets;
                        j3 = jM1449contentColorForek8zF_U;
                        j4 = jM1389getBackground0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                        interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                        interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                        interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                        }
                        int i210 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i210 & 896) | (i210 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets2 = contentWindowInsets;
                        j3 = jM1449contentColorForek8zF_U;
                        j4 = jM1389getBackground0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                        interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                        interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                        interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
                }
                i4 |= 24576;
                interfaceC0526Fp7 = interfaceC0526Fp4;
                i11 = i3 & 32;
                if (i11 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i2 & 458752) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i4 |= i12;
                }
                if ((i2 & 3670016) != 0) {
                    if ((i3 & 64) == 0) {
                        i17 = 524288;
                    } else {
                        i17 = 524288;
                    }
                    i4 |= i17;
                }
                if ((i2 & 29360128) == 0) {
                    jM1449contentColorForek8zF_U = j2;
                    if ((i3 & 128) == 0) {
                        i16 = 4194304;
                    } else {
                        i16 = 4194304;
                    }
                    i4 |= i16;
                } else {
                    jM1449contentColorForek8zF_U = j2;
                }
                if ((234881024 & i2) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
                }
                if ((i3 & 512) != 0) {
                    if ((1879048192 & i2) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i13 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i13 = 268435456;
                        }
                    }
                    if ((1533916891 & i4) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                        }
                        int i211 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i211 & 896) | (i211 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets2 = contentWindowInsets;
                        j3 = jM1449contentColorForek8zF_U;
                        j4 = jM1389getBackground0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                        interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                        interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                        interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                        }
                        int i212 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i212 & 896) | (i212 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets2 = contentWindowInsets;
                        j3 = jM1449contentColorForek8zF_U;
                        j4 = jM1389getBackground0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                        interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                        interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                        interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
                }
                i13 = 805306368;
                i4 |= i13;
                if ((1533916891 & i4) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                    }
                    int i213 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i213 & 896) | (i213 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets2 = contentWindowInsets;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = jM1389getBackground0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                    interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                    interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                    interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                    }
                    int i214 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i214 & 896) | (i214 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets2 = contentWindowInsets;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = jM1389getBackground0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                    interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                    interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                    interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
            }
            i4 |= 384;
            interfaceC0526Fp6 = interfaceC0526Fp2;
            i7 = i3 & 8;
            if (i7 != 0) {
                if ((i2 & 7168) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i8 = 2048;
                    } else {
                        i8 = 1024;
                    }
                    i4 |= i8;
                }
                i9 = i3 & 16;
                if (i9 != 0) {
                    if ((57344 & i2) == 0) {
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp7)) {
                            i10 = 16384;
                        } else {
                            i10 = 8192;
                        }
                        i4 |= i10;
                    }
                    i11 = i3 & 32;
                    if (i11 != 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i2 & 458752) == 0) {
                        if (composerStartRestartGroup.changed(i)) {
                            i12 = 131072;
                        } else {
                            i12 = 65536;
                        }
                        i4 |= i12;
                    }
                    if ((i2 & 3670016) != 0) {
                        if ((i3 & 64) == 0) {
                            i17 = 524288;
                        } else {
                            i17 = 524288;
                        }
                        i4 |= i17;
                    }
                    if ((i2 & 29360128) == 0) {
                        jM1449contentColorForek8zF_U = j2;
                        if ((i3 & 128) == 0) {
                            i16 = 4194304;
                        } else {
                            i16 = 4194304;
                        }
                        i4 |= i16;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if ((234881024 & i2) != 0) {
                        i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
                    }
                    if ((i3 & 512) != 0) {
                        if ((1879048192 & i2) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i13 = PropertyOptions.DELETE_EXISTING;
                            } else {
                                i13 = 268435456;
                            }
                        }
                        if ((1533916891 & i4) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i2 & 1) != 0) {
                                if (i18 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i19 != 0) {
                                    interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                                } else {
                                    interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                                }
                                if (i5 != 0) {
                                    interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                                } else {
                                    interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                                }
                                if (i7 != 0) {
                                    interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                                } else {
                                    interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                                }
                                if (i9 != 0) {
                                    interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                                } else {
                                    interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                                }
                                if (i11 != 0) {
                                    iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                                } else {
                                    iM1571getEndERTFSPs = i;
                                }
                                if ((i3 & 64) != 0) {
                                    i14 = i4 & (-3670017);
                                    jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                                } else {
                                    i14 = i4;
                                    jM1389getBackground0d7_KjU = j;
                                }
                                if ((i3 & 128) != 0) {
                                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                    i14 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i15 = i14 & (-234881025);
                                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                    modifier2 = modifier2;
                                } else {
                                    i15 = i14;
                                    contentWindowInsets = windowInsets;
                                }
                            } else {
                                if (i18 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i19 != 0) {
                                    interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                                } else {
                                    interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                                }
                                if (i5 != 0) {
                                    interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                                } else {
                                    interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                                }
                                if (i7 != 0) {
                                    interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                                } else {
                                    interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                                }
                                if (i9 != 0) {
                                    interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                                } else {
                                    interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                                }
                                if (i11 != 0) {
                                    iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                                } else {
                                    iM1571getEndERTFSPs = i;
                                }
                                if ((i3 & 64) != 0) {
                                    i14 = i4 & (-3670017);
                                    jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                                } else {
                                    i14 = i4;
                                    jM1389getBackground0d7_KjU = j;
                                }
                                if ((i3 & 128) != 0) {
                                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                    i14 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i15 = i14 & (-234881025);
                                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                    modifier2 = modifier2;
                                } else {
                                    i15 = i14;
                                    contentWindowInsets = windowInsets;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                            }
                            int i215 = i15 >> 12;
                            SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i215 & 896) | (i215 & 7168), 114);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            windowInsets2 = contentWindowInsets;
                            j3 = jM1449contentColorForek8zF_U;
                            j4 = jM1389getBackground0d7_KjU;
                            interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                            interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                            interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                            interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                            modifier3 = modifier2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i2 & 1) != 0) {
                                if (i18 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i19 != 0) {
                                    interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                                } else {
                                    interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                                }
                                if (i5 != 0) {
                                    interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                                } else {
                                    interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                                }
                                if (i7 != 0) {
                                    interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                                } else {
                                    interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                                }
                                if (i9 != 0) {
                                    interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                                } else {
                                    interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                                }
                                if (i11 != 0) {
                                    iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                                } else {
                                    iM1571getEndERTFSPs = i;
                                }
                                if ((i3 & 64) != 0) {
                                    i14 = i4 & (-3670017);
                                    jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                                } else {
                                    i14 = i4;
                                    jM1389getBackground0d7_KjU = j;
                                }
                                if ((i3 & 128) != 0) {
                                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                    i14 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i15 = i14 & (-234881025);
                                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                    modifier2 = modifier2;
                                } else {
                                    i15 = i14;
                                    contentWindowInsets = windowInsets;
                                }
                            } else {
                                if (i18 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i19 != 0) {
                                    interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                                } else {
                                    interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                                }
                                if (i5 != 0) {
                                    interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                                } else {
                                    interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                                }
                                if (i7 != 0) {
                                    interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                                } else {
                                    interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                                }
                                if (i9 != 0) {
                                    interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                                } else {
                                    interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                                }
                                if (i11 != 0) {
                                    iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                                } else {
                                    iM1571getEndERTFSPs = i;
                                }
                                if ((i3 & 64) != 0) {
                                    i14 = i4 & (-3670017);
                                    jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                                } else {
                                    i14 = i4;
                                    jM1389getBackground0d7_KjU = j;
                                }
                                if ((i3 & 128) != 0) {
                                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                    i14 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i15 = i14 & (-234881025);
                                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                    modifier2 = modifier2;
                                } else {
                                    i15 = i14;
                                    contentWindowInsets = windowInsets;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                            }
                            int i216 = i15 >> 12;
                            SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i216 & 896) | (i216 & 7168), 114);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            windowInsets2 = contentWindowInsets;
                            j3 = jM1449contentColorForek8zF_U;
                            j4 = jM1389getBackground0d7_KjU;
                            interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                            interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                            interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                            interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                            modifier3 = modifier2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
                    }
                    i13 = 805306368;
                    i4 |= i13;
                    if ((1533916891 & i4) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                        }
                        int i217 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i217 & 896) | (i217 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets2 = contentWindowInsets;
                        j3 = jM1449contentColorForek8zF_U;
                        j4 = jM1389getBackground0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                        interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                        interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                        interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                        }
                        int i218 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i218 & 896) | (i218 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets2 = contentWindowInsets;
                        j3 = jM1449contentColorForek8zF_U;
                        j4 = jM1389getBackground0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                        interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                        interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                        interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
                }
                i4 |= 24576;
                interfaceC0526Fp7 = interfaceC0526Fp4;
                i11 = i3 & 32;
                if (i11 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i2 & 458752) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i4 |= i12;
                }
                if ((i2 & 3670016) != 0) {
                    if ((i3 & 64) == 0) {
                        i17 = 524288;
                    } else {
                        i17 = 524288;
                    }
                    i4 |= i17;
                }
                if ((i2 & 29360128) == 0) {
                    jM1449contentColorForek8zF_U = j2;
                    if ((i3 & 128) == 0) {
                        i16 = 4194304;
                    } else {
                        i16 = 4194304;
                    }
                    i4 |= i16;
                } else {
                    jM1449contentColorForek8zF_U = j2;
                }
                if ((234881024 & i2) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
                }
                if ((i3 & 512) != 0) {
                    if ((1879048192 & i2) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i13 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i13 = 268435456;
                        }
                    }
                    if ((1533916891 & i4) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                        }
                        int i219 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i219 & 896) | (i219 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets2 = contentWindowInsets;
                        j3 = jM1449contentColorForek8zF_U;
                        j4 = jM1389getBackground0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                        interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                        interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                        interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                        }
                        int i2110 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i2110 & 896) | (i2110 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets2 = contentWindowInsets;
                        j3 = jM1449contentColorForek8zF_U;
                        j4 = jM1389getBackground0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                        interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                        interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                        interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
                }
                i13 = 805306368;
                i4 |= i13;
                if ((1533916891 & i4) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                    }
                    int i2111 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i2111 & 896) | (i2111 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets2 = contentWindowInsets;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = jM1389getBackground0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                    interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                    interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                    interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                    }
                    int i2112 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i2112 & 896) | (i2112 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets2 = contentWindowInsets;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = jM1389getBackground0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                    interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                    interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                    interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
            }
            i4 |= 3072;
            i9 = i3 & 16;
            if (i9 != 0) {
                if ((57344 & i2) == 0) {
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp7)) {
                        i10 = 16384;
                    } else {
                        i10 = 8192;
                    }
                    i4 |= i10;
                }
                i11 = i3 & 32;
                if (i11 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i2 & 458752) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i4 |= i12;
                }
                if ((i2 & 3670016) != 0) {
                    if ((i3 & 64) == 0) {
                        i17 = 524288;
                    } else {
                        i17 = 524288;
                    }
                    i4 |= i17;
                }
                if ((i2 & 29360128) == 0) {
                    jM1449contentColorForek8zF_U = j2;
                    if ((i3 & 128) == 0) {
                        i16 = 4194304;
                    } else {
                        i16 = 4194304;
                    }
                    i4 |= i16;
                } else {
                    jM1449contentColorForek8zF_U = j2;
                }
                if ((234881024 & i2) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
                }
                if ((i3 & 512) != 0) {
                    if ((1879048192 & i2) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i13 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i13 = 268435456;
                        }
                    }
                    if ((1533916891 & i4) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                        }
                        int i2113 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i2113 & 896) | (i2113 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets2 = contentWindowInsets;
                        j3 = jM1449contentColorForek8zF_U;
                        j4 = jM1389getBackground0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                        interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                        interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                        interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                        }
                        int i2114 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i2114 & 896) | (i2114 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets2 = contentWindowInsets;
                        j3 = jM1449contentColorForek8zF_U;
                        j4 = jM1389getBackground0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                        interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                        interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                        interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
                }
                i13 = 805306368;
                i4 |= i13;
                if ((1533916891 & i4) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                    }
                    int i2115 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i2115 & 896) | (i2115 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets2 = contentWindowInsets;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = jM1389getBackground0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                    interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                    interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                    interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                    }
                    int i2116 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i2116 & 896) | (i2116 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets2 = contentWindowInsets;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = jM1389getBackground0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                    interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                    interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                    interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
            }
            i4 |= 24576;
            interfaceC0526Fp7 = interfaceC0526Fp4;
            i11 = i3 & 32;
            if (i11 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i2 & 458752) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i12 = 131072;
                } else {
                    i12 = 65536;
                }
                i4 |= i12;
            }
            if ((i2 & 3670016) != 0) {
                if ((i3 & 64) == 0) {
                    i17 = 524288;
                } else {
                    i17 = 524288;
                }
                i4 |= i17;
            }
            if ((i2 & 29360128) == 0) {
                jM1449contentColorForek8zF_U = j2;
                if ((i3 & 128) == 0) {
                    i16 = 4194304;
                } else {
                    i16 = 4194304;
                }
                i4 |= i16;
            } else {
                jM1449contentColorForek8zF_U = j2;
            }
            if ((234881024 & i2) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
            }
            if ((i3 & 512) != 0) {
                if ((1879048192 & i2) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i13 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i13 = 268435456;
                    }
                }
                if ((1533916891 & i4) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                    }
                    int i2117 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i2117 & 896) | (i2117 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets2 = contentWindowInsets;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = jM1389getBackground0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                    interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                    interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                    interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                    }
                    int i2118 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i2118 & 896) | (i2118 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets2 = contentWindowInsets;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = jM1389getBackground0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                    interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                    interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                    interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
            }
            i13 = 805306368;
            i4 |= i13;
            if ((1533916891 & i4) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i18 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i19 != 0) {
                        interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                    }
                    if (i5 != 0) {
                        interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                    } else {
                        interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                    } else {
                        interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                    }
                    if (i11 != 0) {
                        iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                    } else {
                        iM1571getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i14 = i4 & (-3670017);
                        jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                    } else {
                        i14 = i4;
                        jM1389getBackground0d7_KjU = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                        i14 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i14 & (-234881025);
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        modifier2 = modifier2;
                    } else {
                        i15 = i14;
                        contentWindowInsets = windowInsets;
                    }
                } else {
                    if (i18 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i19 != 0) {
                        interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                    }
                    if (i5 != 0) {
                        interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                    } else {
                        interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                    } else {
                        interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                    }
                    if (i11 != 0) {
                        iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                    } else {
                        iM1571getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i14 = i4 & (-3670017);
                        jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                    } else {
                        i14 = i4;
                        jM1389getBackground0d7_KjU = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                        i14 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i14 & (-234881025);
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        modifier2 = modifier2;
                    } else {
                        i15 = i14;
                        contentWindowInsets = windowInsets;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                }
                int i2119 = i15 >> 12;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i2119 & 896) | (i2119 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets2 = contentWindowInsets;
                j3 = jM1449contentColorForek8zF_U;
                j4 = jM1389getBackground0d7_KjU;
                interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                modifier3 = modifier2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i18 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i19 != 0) {
                        interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                    }
                    if (i5 != 0) {
                        interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                    } else {
                        interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                    } else {
                        interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                    }
                    if (i11 != 0) {
                        iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                    } else {
                        iM1571getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i14 = i4 & (-3670017);
                        jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                    } else {
                        i14 = i4;
                        jM1389getBackground0d7_KjU = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                        i14 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i14 & (-234881025);
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        modifier2 = modifier2;
                    } else {
                        i15 = i14;
                        contentWindowInsets = windowInsets;
                    }
                } else {
                    if (i18 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i19 != 0) {
                        interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                    }
                    if (i5 != 0) {
                        interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                    } else {
                        interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                    } else {
                        interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                    }
                    if (i11 != 0) {
                        iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                    } else {
                        iM1571getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i14 = i4 & (-3670017);
                        jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                    } else {
                        i14 = i4;
                        jM1389getBackground0d7_KjU = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                        i14 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i14 & (-234881025);
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        modifier2 = modifier2;
                    } else {
                        i15 = i14;
                        contentWindowInsets = windowInsets;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                }
                int i21110 = i15 >> 12;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i21110 & 896) | (i21110 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets2 = contentWindowInsets;
                j3 = jM1449contentColorForek8zF_U;
                j4 = jM1389getBackground0d7_KjU;
                interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
        }
        i4 |= 48;
        interfaceC0526Fp5 = interfaceC0526Fp;
        i5 = i3 & 4;
        if (i5 != 0) {
            if ((i2 & 896) == 0) {
                interfaceC0526Fp6 = interfaceC0526Fp2;
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp6)) {
                    i6 = 256;
                } else {
                    i6 = 128;
                }
                i4 |= i6;
            }
            i7 = i3 & 8;
            if (i7 != 0) {
                if ((i2 & 7168) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i8 = 2048;
                    } else {
                        i8 = 1024;
                    }
                    i4 |= i8;
                }
                i9 = i3 & 16;
                if (i9 != 0) {
                    if ((57344 & i2) == 0) {
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp7)) {
                            i10 = 16384;
                        } else {
                            i10 = 8192;
                        }
                        i4 |= i10;
                    }
                    i11 = i3 & 32;
                    if (i11 != 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i2 & 458752) == 0) {
                        if (composerStartRestartGroup.changed(i)) {
                            i12 = 131072;
                        } else {
                            i12 = 65536;
                        }
                        i4 |= i12;
                    }
                    if ((i2 & 3670016) != 0) {
                        if ((i3 & 64) == 0) {
                            i17 = 524288;
                        } else {
                            i17 = 524288;
                        }
                        i4 |= i17;
                    }
                    if ((i2 & 29360128) == 0) {
                        jM1449contentColorForek8zF_U = j2;
                        if ((i3 & 128) == 0) {
                            i16 = 4194304;
                        } else {
                            i16 = 4194304;
                        }
                        i4 |= i16;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if ((234881024 & i2) != 0) {
                        i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
                    }
                    if ((i3 & 512) != 0) {
                        if ((1879048192 & i2) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i13 = PropertyOptions.DELETE_EXISTING;
                            } else {
                                i13 = 268435456;
                            }
                        }
                        if ((1533916891 & i4) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i2 & 1) != 0) {
                                if (i18 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i19 != 0) {
                                    interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                                } else {
                                    interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                                }
                                if (i5 != 0) {
                                    interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                                } else {
                                    interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                                }
                                if (i7 != 0) {
                                    interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                                } else {
                                    interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                                }
                                if (i9 != 0) {
                                    interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                                } else {
                                    interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                                }
                                if (i11 != 0) {
                                    iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                                } else {
                                    iM1571getEndERTFSPs = i;
                                }
                                if ((i3 & 64) != 0) {
                                    i14 = i4 & (-3670017);
                                    jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                                } else {
                                    i14 = i4;
                                    jM1389getBackground0d7_KjU = j;
                                }
                                if ((i3 & 128) != 0) {
                                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                    i14 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i15 = i14 & (-234881025);
                                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                    modifier2 = modifier2;
                                } else {
                                    i15 = i14;
                                    contentWindowInsets = windowInsets;
                                }
                            } else {
                                if (i18 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i19 != 0) {
                                    interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                                } else {
                                    interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                                }
                                if (i5 != 0) {
                                    interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                                } else {
                                    interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                                }
                                if (i7 != 0) {
                                    interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                                } else {
                                    interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                                }
                                if (i9 != 0) {
                                    interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                                } else {
                                    interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                                }
                                if (i11 != 0) {
                                    iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                                } else {
                                    iM1571getEndERTFSPs = i;
                                }
                                if ((i3 & 64) != 0) {
                                    i14 = i4 & (-3670017);
                                    jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                                } else {
                                    i14 = i4;
                                    jM1389getBackground0d7_KjU = j;
                                }
                                if ((i3 & 128) != 0) {
                                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                    i14 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i15 = i14 & (-234881025);
                                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                    modifier2 = modifier2;
                                } else {
                                    i15 = i14;
                                    contentWindowInsets = windowInsets;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                            }
                            int i21111 = i15 >> 12;
                            SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i21111 & 896) | (i21111 & 7168), 114);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            windowInsets2 = contentWindowInsets;
                            j3 = jM1449contentColorForek8zF_U;
                            j4 = jM1389getBackground0d7_KjU;
                            interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                            interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                            interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                            interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                            modifier3 = modifier2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i2 & 1) != 0) {
                                if (i18 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i19 != 0) {
                                    interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                                } else {
                                    interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                                }
                                if (i5 != 0) {
                                    interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                                } else {
                                    interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                                }
                                if (i7 != 0) {
                                    interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                                } else {
                                    interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                                }
                                if (i9 != 0) {
                                    interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                                } else {
                                    interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                                }
                                if (i11 != 0) {
                                    iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                                } else {
                                    iM1571getEndERTFSPs = i;
                                }
                                if ((i3 & 64) != 0) {
                                    i14 = i4 & (-3670017);
                                    jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                                } else {
                                    i14 = i4;
                                    jM1389getBackground0d7_KjU = j;
                                }
                                if ((i3 & 128) != 0) {
                                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                    i14 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i15 = i14 & (-234881025);
                                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                    modifier2 = modifier2;
                                } else {
                                    i15 = i14;
                                    contentWindowInsets = windowInsets;
                                }
                            } else {
                                if (i18 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i19 != 0) {
                                    interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                                } else {
                                    interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                                }
                                if (i5 != 0) {
                                    interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                                } else {
                                    interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                                }
                                if (i7 != 0) {
                                    interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                                } else {
                                    interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                                }
                                if (i9 != 0) {
                                    interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                                } else {
                                    interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                                }
                                if (i11 != 0) {
                                    iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                                } else {
                                    iM1571getEndERTFSPs = i;
                                }
                                if ((i3 & 64) != 0) {
                                    i14 = i4 & (-3670017);
                                    jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                                } else {
                                    i14 = i4;
                                    jM1389getBackground0d7_KjU = j;
                                }
                                if ((i3 & 128) != 0) {
                                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                    i14 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i15 = i14 & (-234881025);
                                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                    modifier2 = modifier2;
                                } else {
                                    i15 = i14;
                                    contentWindowInsets = windowInsets;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                            }
                            int i21112 = i15 >> 12;
                            SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i21112 & 896) | (i21112 & 7168), 114);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            windowInsets2 = contentWindowInsets;
                            j3 = jM1449contentColorForek8zF_U;
                            j4 = jM1389getBackground0d7_KjU;
                            interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                            interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                            interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                            interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                            modifier3 = modifier2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
                    }
                    i13 = 805306368;
                    i4 |= i13;
                    if ((1533916891 & i4) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                        }
                        int i21113 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i21113 & 896) | (i21113 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets2 = contentWindowInsets;
                        j3 = jM1449contentColorForek8zF_U;
                        j4 = jM1389getBackground0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                        interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                        interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                        interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                        }
                        int i21114 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i21114 & 896) | (i21114 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets2 = contentWindowInsets;
                        j3 = jM1449contentColorForek8zF_U;
                        j4 = jM1389getBackground0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                        interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                        interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                        interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
                }
                i4 |= 24576;
                interfaceC0526Fp7 = interfaceC0526Fp4;
                i11 = i3 & 32;
                if (i11 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i2 & 458752) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i4 |= i12;
                }
                if ((i2 & 3670016) != 0) {
                    if ((i3 & 64) == 0) {
                        i17 = 524288;
                    } else {
                        i17 = 524288;
                    }
                    i4 |= i17;
                }
                if ((i2 & 29360128) == 0) {
                    jM1449contentColorForek8zF_U = j2;
                    if ((i3 & 128) == 0) {
                        i16 = 4194304;
                    } else {
                        i16 = 4194304;
                    }
                    i4 |= i16;
                } else {
                    jM1449contentColorForek8zF_U = j2;
                }
                if ((234881024 & i2) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
                }
                if ((i3 & 512) != 0) {
                    if ((1879048192 & i2) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i13 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i13 = 268435456;
                        }
                    }
                    if ((1533916891 & i4) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                        }
                        int i21115 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i21115 & 896) | (i21115 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets2 = contentWindowInsets;
                        j3 = jM1449contentColorForek8zF_U;
                        j4 = jM1389getBackground0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                        interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                        interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                        interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                        }
                        int i21116 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i21116 & 896) | (i21116 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets2 = contentWindowInsets;
                        j3 = jM1449contentColorForek8zF_U;
                        j4 = jM1389getBackground0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                        interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                        interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                        interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
                }
                i13 = 805306368;
                i4 |= i13;
                if ((1533916891 & i4) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                    }
                    int i21117 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i21117 & 896) | (i21117 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets2 = contentWindowInsets;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = jM1389getBackground0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                    interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                    interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                    interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                    }
                    int i21118 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i21118 & 896) | (i21118 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets2 = contentWindowInsets;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = jM1389getBackground0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                    interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                    interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                    interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
            }
            i4 |= 3072;
            i9 = i3 & 16;
            if (i9 != 0) {
                if ((57344 & i2) == 0) {
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp7)) {
                        i10 = 16384;
                    } else {
                        i10 = 8192;
                    }
                    i4 |= i10;
                }
                i11 = i3 & 32;
                if (i11 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i2 & 458752) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i4 |= i12;
                }
                if ((i2 & 3670016) != 0) {
                    if ((i3 & 64) == 0) {
                        i17 = 524288;
                    } else {
                        i17 = 524288;
                    }
                    i4 |= i17;
                }
                if ((i2 & 29360128) == 0) {
                    jM1449contentColorForek8zF_U = j2;
                    if ((i3 & 128) == 0) {
                        i16 = 4194304;
                    } else {
                        i16 = 4194304;
                    }
                    i4 |= i16;
                } else {
                    jM1449contentColorForek8zF_U = j2;
                }
                if ((234881024 & i2) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
                }
                if ((i3 & 512) != 0) {
                    if ((1879048192 & i2) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i13 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i13 = 268435456;
                        }
                    }
                    if ((1533916891 & i4) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                        }
                        int i21119 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i21119 & 896) | (i21119 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets2 = contentWindowInsets;
                        j3 = jM1449contentColorForek8zF_U;
                        j4 = jM1389getBackground0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                        interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                        interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                        interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                        }
                        int i211110 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i211110 & 896) | (i211110 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets2 = contentWindowInsets;
                        j3 = jM1449contentColorForek8zF_U;
                        j4 = jM1389getBackground0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                        interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                        interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                        interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
                }
                i13 = 805306368;
                i4 |= i13;
                if ((1533916891 & i4) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                    }
                    int i211111 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i211111 & 896) | (i211111 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets2 = contentWindowInsets;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = jM1389getBackground0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                    interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                    interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                    interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                    }
                    int i211112 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i211112 & 896) | (i211112 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets2 = contentWindowInsets;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = jM1389getBackground0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                    interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                    interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                    interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
            }
            i4 |= 24576;
            interfaceC0526Fp7 = interfaceC0526Fp4;
            i11 = i3 & 32;
            if (i11 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i2 & 458752) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i12 = 131072;
                } else {
                    i12 = 65536;
                }
                i4 |= i12;
            }
            if ((i2 & 3670016) != 0) {
                if ((i3 & 64) == 0) {
                    i17 = 524288;
                } else {
                    i17 = 524288;
                }
                i4 |= i17;
            }
            if ((i2 & 29360128) == 0) {
                jM1449contentColorForek8zF_U = j2;
                if ((i3 & 128) == 0) {
                    i16 = 4194304;
                } else {
                    i16 = 4194304;
                }
                i4 |= i16;
            } else {
                jM1449contentColorForek8zF_U = j2;
            }
            if ((234881024 & i2) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
            }
            if ((i3 & 512) != 0) {
                if ((1879048192 & i2) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i13 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i13 = 268435456;
                    }
                }
                if ((1533916891 & i4) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                    }
                    int i211113 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i211113 & 896) | (i211113 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets2 = contentWindowInsets;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = jM1389getBackground0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                    interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                    interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                    interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                    }
                    int i211114 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i211114 & 896) | (i211114 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets2 = contentWindowInsets;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = jM1389getBackground0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                    interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                    interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                    interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
            }
            i13 = 805306368;
            i4 |= i13;
            if ((1533916891 & i4) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i18 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i19 != 0) {
                        interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                    }
                    if (i5 != 0) {
                        interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                    } else {
                        interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                    } else {
                        interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                    }
                    if (i11 != 0) {
                        iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                    } else {
                        iM1571getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i14 = i4 & (-3670017);
                        jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                    } else {
                        i14 = i4;
                        jM1389getBackground0d7_KjU = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                        i14 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i14 & (-234881025);
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        modifier2 = modifier2;
                    } else {
                        i15 = i14;
                        contentWindowInsets = windowInsets;
                    }
                } else {
                    if (i18 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i19 != 0) {
                        interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                    }
                    if (i5 != 0) {
                        interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                    } else {
                        interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                    } else {
                        interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                    }
                    if (i11 != 0) {
                        iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                    } else {
                        iM1571getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i14 = i4 & (-3670017);
                        jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                    } else {
                        i14 = i4;
                        jM1389getBackground0d7_KjU = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                        i14 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i14 & (-234881025);
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        modifier2 = modifier2;
                    } else {
                        i15 = i14;
                        contentWindowInsets = windowInsets;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                }
                int i211115 = i15 >> 12;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i211115 & 896) | (i211115 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets2 = contentWindowInsets;
                j3 = jM1449contentColorForek8zF_U;
                j4 = jM1389getBackground0d7_KjU;
                interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                modifier3 = modifier2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i18 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i19 != 0) {
                        interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                    }
                    if (i5 != 0) {
                        interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                    } else {
                        interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                    } else {
                        interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                    }
                    if (i11 != 0) {
                        iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                    } else {
                        iM1571getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i14 = i4 & (-3670017);
                        jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                    } else {
                        i14 = i4;
                        jM1389getBackground0d7_KjU = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                        i14 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i14 & (-234881025);
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        modifier2 = modifier2;
                    } else {
                        i15 = i14;
                        contentWindowInsets = windowInsets;
                    }
                } else {
                    if (i18 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i19 != 0) {
                        interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                    }
                    if (i5 != 0) {
                        interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                    } else {
                        interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                    } else {
                        interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                    }
                    if (i11 != 0) {
                        iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                    } else {
                        iM1571getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i14 = i4 & (-3670017);
                        jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                    } else {
                        i14 = i4;
                        jM1389getBackground0d7_KjU = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                        i14 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i14 & (-234881025);
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        modifier2 = modifier2;
                    } else {
                        i15 = i14;
                        contentWindowInsets = windowInsets;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                }
                int i211116 = i15 >> 12;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i211116 & 896) | (i211116 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets2 = contentWindowInsets;
                j3 = jM1449contentColorForek8zF_U;
                j4 = jM1389getBackground0d7_KjU;
                interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
        }
        i4 |= 384;
        interfaceC0526Fp6 = interfaceC0526Fp2;
        i7 = i3 & 8;
        if (i7 != 0) {
            if ((i2 & 7168) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                    i8 = 2048;
                } else {
                    i8 = 1024;
                }
                i4 |= i8;
            }
            i9 = i3 & 16;
            if (i9 != 0) {
                if ((57344 & i2) == 0) {
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp7)) {
                        i10 = 16384;
                    } else {
                        i10 = 8192;
                    }
                    i4 |= i10;
                }
                i11 = i3 & 32;
                if (i11 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i2 & 458752) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i4 |= i12;
                }
                if ((i2 & 3670016) != 0) {
                    if ((i3 & 64) == 0) {
                        i17 = 524288;
                    } else {
                        i17 = 524288;
                    }
                    i4 |= i17;
                }
                if ((i2 & 29360128) == 0) {
                    jM1449contentColorForek8zF_U = j2;
                    if ((i3 & 128) == 0) {
                        i16 = 4194304;
                    } else {
                        i16 = 4194304;
                    }
                    i4 |= i16;
                } else {
                    jM1449contentColorForek8zF_U = j2;
                }
                if ((234881024 & i2) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
                }
                if ((i3 & 512) != 0) {
                    if ((1879048192 & i2) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i13 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i13 = 268435456;
                        }
                    }
                    if ((1533916891 & i4) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                        }
                        int i211117 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i211117 & 896) | (i211117 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets2 = contentWindowInsets;
                        j3 = jM1449contentColorForek8zF_U;
                        j4 = jM1389getBackground0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                        interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                        interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                        interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i19 != 0) {
                                interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                            }
                            if (i5 != 0) {
                                interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                            } else {
                                interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                            } else {
                                interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                            }
                            if (i11 != 0) {
                                iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                            } else {
                                iM1571getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i14 = i4 & (-3670017);
                                jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                            } else {
                                i14 = i4;
                                jM1389getBackground0d7_KjU = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                                i14 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                modifier2 = modifier2;
                            } else {
                                i15 = i14;
                                contentWindowInsets = windowInsets;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                        }
                        int i211118 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i211118 & 896) | (i211118 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets2 = contentWindowInsets;
                        j3 = jM1449contentColorForek8zF_U;
                        j4 = jM1389getBackground0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                        interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                        interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                        interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
                }
                i13 = 805306368;
                i4 |= i13;
                if ((1533916891 & i4) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                    }
                    int i211119 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i211119 & 896) | (i211119 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets2 = contentWindowInsets;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = jM1389getBackground0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                    interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                    interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                    interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                    }
                    int i2111110 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i2111110 & 896) | (i2111110 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets2 = contentWindowInsets;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = jM1389getBackground0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                    interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                    interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                    interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
            }
            i4 |= 24576;
            interfaceC0526Fp7 = interfaceC0526Fp4;
            i11 = i3 & 32;
            if (i11 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i2 & 458752) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i12 = 131072;
                } else {
                    i12 = 65536;
                }
                i4 |= i12;
            }
            if ((i2 & 3670016) != 0) {
                if ((i3 & 64) == 0) {
                    i17 = 524288;
                } else {
                    i17 = 524288;
                }
                i4 |= i17;
            }
            if ((i2 & 29360128) == 0) {
                jM1449contentColorForek8zF_U = j2;
                if ((i3 & 128) == 0) {
                    i16 = 4194304;
                } else {
                    i16 = 4194304;
                }
                i4 |= i16;
            } else {
                jM1449contentColorForek8zF_U = j2;
            }
            if ((234881024 & i2) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
            }
            if ((i3 & 512) != 0) {
                if ((1879048192 & i2) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i13 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i13 = 268435456;
                    }
                }
                if ((1533916891 & i4) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                    }
                    int i2111111 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i2111111 & 896) | (i2111111 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets2 = contentWindowInsets;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = jM1389getBackground0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                    interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                    interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                    interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                    }
                    int i2111112 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i2111112 & 896) | (i2111112 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets2 = contentWindowInsets;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = jM1389getBackground0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                    interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                    interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                    interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
            }
            i13 = 805306368;
            i4 |= i13;
            if ((1533916891 & i4) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i18 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i19 != 0) {
                        interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                    }
                    if (i5 != 0) {
                        interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                    } else {
                        interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                    } else {
                        interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                    }
                    if (i11 != 0) {
                        iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                    } else {
                        iM1571getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i14 = i4 & (-3670017);
                        jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                    } else {
                        i14 = i4;
                        jM1389getBackground0d7_KjU = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                        i14 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i14 & (-234881025);
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        modifier2 = modifier2;
                    } else {
                        i15 = i14;
                        contentWindowInsets = windowInsets;
                    }
                } else {
                    if (i18 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i19 != 0) {
                        interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                    }
                    if (i5 != 0) {
                        interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                    } else {
                        interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                    } else {
                        interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                    }
                    if (i11 != 0) {
                        iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                    } else {
                        iM1571getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i14 = i4 & (-3670017);
                        jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                    } else {
                        i14 = i4;
                        jM1389getBackground0d7_KjU = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                        i14 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i14 & (-234881025);
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        modifier2 = modifier2;
                    } else {
                        i15 = i14;
                        contentWindowInsets = windowInsets;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                }
                int i2111113 = i15 >> 12;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i2111113 & 896) | (i2111113 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets2 = contentWindowInsets;
                j3 = jM1449contentColorForek8zF_U;
                j4 = jM1389getBackground0d7_KjU;
                interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                modifier3 = modifier2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i18 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i19 != 0) {
                        interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                    }
                    if (i5 != 0) {
                        interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                    } else {
                        interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                    } else {
                        interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                    }
                    if (i11 != 0) {
                        iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                    } else {
                        iM1571getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i14 = i4 & (-3670017);
                        jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                    } else {
                        i14 = i4;
                        jM1389getBackground0d7_KjU = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                        i14 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i14 & (-234881025);
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        modifier2 = modifier2;
                    } else {
                        i15 = i14;
                        contentWindowInsets = windowInsets;
                    }
                } else {
                    if (i18 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i19 != 0) {
                        interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                    }
                    if (i5 != 0) {
                        interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                    } else {
                        interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                    } else {
                        interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                    }
                    if (i11 != 0) {
                        iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                    } else {
                        iM1571getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i14 = i4 & (-3670017);
                        jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                    } else {
                        i14 = i4;
                        jM1389getBackground0d7_KjU = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                        i14 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i14 & (-234881025);
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        modifier2 = modifier2;
                    } else {
                        i15 = i14;
                        contentWindowInsets = windowInsets;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                }
                int i2111114 = i15 >> 12;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i2111114 & 896) | (i2111114 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets2 = contentWindowInsets;
                j3 = jM1449contentColorForek8zF_U;
                j4 = jM1389getBackground0d7_KjU;
                interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
        }
        i4 |= 3072;
        i9 = i3 & 16;
        if (i9 != 0) {
            if ((57344 & i2) == 0) {
                interfaceC0526Fp7 = interfaceC0526Fp4;
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp7)) {
                    i10 = 16384;
                } else {
                    i10 = 8192;
                }
                i4 |= i10;
            }
            i11 = i3 & 32;
            if (i11 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i2 & 458752) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i12 = 131072;
                } else {
                    i12 = 65536;
                }
                i4 |= i12;
            }
            if ((i2 & 3670016) != 0) {
                if ((i3 & 64) == 0) {
                    i17 = 524288;
                } else {
                    i17 = 524288;
                }
                i4 |= i17;
            }
            if ((i2 & 29360128) == 0) {
                jM1449contentColorForek8zF_U = j2;
                if ((i3 & 128) == 0) {
                    i16 = 4194304;
                } else {
                    i16 = 4194304;
                }
                i4 |= i16;
            } else {
                jM1449contentColorForek8zF_U = j2;
            }
            if ((234881024 & i2) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
            }
            if ((i3 & 512) != 0) {
                if ((1879048192 & i2) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i13 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i13 = 268435456;
                    }
                }
                if ((1533916891 & i4) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                    }
                    int i2111115 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i2111115 & 896) | (i2111115 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets2 = contentWindowInsets;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = jM1389getBackground0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                    interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                    interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                    interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i19 != 0) {
                            interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                        }
                        if (i5 != 0) {
                            interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                        } else {
                            interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                        } else {
                            interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                        }
                        if (i11 != 0) {
                            iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                        } else {
                            iM1571getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i14 = i4 & (-3670017);
                            jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                        } else {
                            i14 = i4;
                            jM1389getBackground0d7_KjU = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                            i14 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i14 & (-234881025);
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            modifier2 = modifier2;
                        } else {
                            i15 = i14;
                            contentWindowInsets = windowInsets;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                    }
                    int i2111116 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i2111116 & 896) | (i2111116 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets2 = contentWindowInsets;
                    j3 = jM1449contentColorForek8zF_U;
                    j4 = jM1389getBackground0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                    interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                    interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                    interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
            }
            i13 = 805306368;
            i4 |= i13;
            if ((1533916891 & i4) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i18 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i19 != 0) {
                        interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                    }
                    if (i5 != 0) {
                        interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                    } else {
                        interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                    } else {
                        interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                    }
                    if (i11 != 0) {
                        iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                    } else {
                        iM1571getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i14 = i4 & (-3670017);
                        jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                    } else {
                        i14 = i4;
                        jM1389getBackground0d7_KjU = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                        i14 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i14 & (-234881025);
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        modifier2 = modifier2;
                    } else {
                        i15 = i14;
                        contentWindowInsets = windowInsets;
                    }
                } else {
                    if (i18 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i19 != 0) {
                        interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                    }
                    if (i5 != 0) {
                        interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                    } else {
                        interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                    } else {
                        interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                    }
                    if (i11 != 0) {
                        iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                    } else {
                        iM1571getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i14 = i4 & (-3670017);
                        jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                    } else {
                        i14 = i4;
                        jM1389getBackground0d7_KjU = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                        i14 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i14 & (-234881025);
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        modifier2 = modifier2;
                    } else {
                        i15 = i14;
                        contentWindowInsets = windowInsets;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                }
                int i2111117 = i15 >> 12;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i2111117 & 896) | (i2111117 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets2 = contentWindowInsets;
                j3 = jM1449contentColorForek8zF_U;
                j4 = jM1389getBackground0d7_KjU;
                interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                modifier3 = modifier2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i18 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i19 != 0) {
                        interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                    }
                    if (i5 != 0) {
                        interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                    } else {
                        interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                    } else {
                        interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                    }
                    if (i11 != 0) {
                        iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                    } else {
                        iM1571getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i14 = i4 & (-3670017);
                        jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                    } else {
                        i14 = i4;
                        jM1389getBackground0d7_KjU = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                        i14 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i14 & (-234881025);
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        modifier2 = modifier2;
                    } else {
                        i15 = i14;
                        contentWindowInsets = windowInsets;
                    }
                } else {
                    if (i18 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i19 != 0) {
                        interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                    }
                    if (i5 != 0) {
                        interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                    } else {
                        interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                    } else {
                        interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                    }
                    if (i11 != 0) {
                        iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                    } else {
                        iM1571getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i14 = i4 & (-3670017);
                        jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                    } else {
                        i14 = i4;
                        jM1389getBackground0d7_KjU = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                        i14 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i14 & (-234881025);
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        modifier2 = modifier2;
                    } else {
                        i15 = i14;
                        contentWindowInsets = windowInsets;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                }
                int i2111118 = i15 >> 12;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i2111118 & 896) | (i2111118 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets2 = contentWindowInsets;
                j3 = jM1449contentColorForek8zF_U;
                j4 = jM1389getBackground0d7_KjU;
                interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
        }
        i4 |= 24576;
        interfaceC0526Fp7 = interfaceC0526Fp4;
        i11 = i3 & 32;
        if (i11 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i2 & 458752) == 0) {
            if (composerStartRestartGroup.changed(i)) {
                i12 = 131072;
            } else {
                i12 = 65536;
            }
            i4 |= i12;
        }
        if ((i2 & 3670016) != 0) {
            if ((i3 & 64) == 0) {
                i17 = 524288;
            } else {
                i17 = 524288;
            }
            i4 |= i17;
        }
        if ((i2 & 29360128) == 0) {
            jM1449contentColorForek8zF_U = j2;
            if ((i3 & 128) == 0) {
                i16 = 4194304;
            } else {
                i16 = 4194304;
            }
            i4 |= i16;
        } else {
            jM1449contentColorForek8zF_U = j2;
        }
        if ((234881024 & i2) != 0) {
            i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
        }
        if ((i3 & 512) != 0) {
            if ((1879048192 & i2) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i13 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i13 = 268435456;
                }
            }
            if ((1533916891 & i4) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i18 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i19 != 0) {
                        interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                    }
                    if (i5 != 0) {
                        interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                    } else {
                        interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                    } else {
                        interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                    }
                    if (i11 != 0) {
                        iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                    } else {
                        iM1571getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i14 = i4 & (-3670017);
                        jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                    } else {
                        i14 = i4;
                        jM1389getBackground0d7_KjU = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                        i14 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i14 & (-234881025);
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        modifier2 = modifier2;
                    } else {
                        i15 = i14;
                        contentWindowInsets = windowInsets;
                    }
                } else {
                    if (i18 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i19 != 0) {
                        interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                    }
                    if (i5 != 0) {
                        interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                    } else {
                        interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                    } else {
                        interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                    }
                    if (i11 != 0) {
                        iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                    } else {
                        iM1571getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i14 = i4 & (-3670017);
                        jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                    } else {
                        i14 = i4;
                        jM1389getBackground0d7_KjU = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                        i14 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i14 & (-234881025);
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        modifier2 = modifier2;
                    } else {
                        i15 = i14;
                        contentWindowInsets = windowInsets;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                }
                int i2111119 = i15 >> 12;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i2111119 & 896) | (i2111119 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets2 = contentWindowInsets;
                j3 = jM1449contentColorForek8zF_U;
                j4 = jM1389getBackground0d7_KjU;
                interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                modifier3 = modifier2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i18 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i19 != 0) {
                        interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                    }
                    if (i5 != 0) {
                        interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                    } else {
                        interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                    } else {
                        interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                    }
                    if (i11 != 0) {
                        iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                    } else {
                        iM1571getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i14 = i4 & (-3670017);
                        jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                    } else {
                        i14 = i4;
                        jM1389getBackground0d7_KjU = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                        i14 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i14 & (-234881025);
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        modifier2 = modifier2;
                    } else {
                        i15 = i14;
                        contentWindowInsets = windowInsets;
                    }
                } else {
                    if (i18 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i19 != 0) {
                        interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                    }
                    if (i5 != 0) {
                        interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                    } else {
                        interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                    } else {
                        interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                    }
                    if (i11 != 0) {
                        iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                    } else {
                        iM1571getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i14 = i4 & (-3670017);
                        jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                    } else {
                        i14 = i4;
                        jM1389getBackground0d7_KjU = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                        i14 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i14 & (-234881025);
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        modifier2 = modifier2;
                    } else {
                        i15 = i14;
                        contentWindowInsets = windowInsets;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
                }
                int i21111110 = i15 >> 12;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i21111110 & 896) | (i21111110 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets2 = contentWindowInsets;
                j3 = jM1449contentColorForek8zF_U;
                j4 = jM1389getBackground0d7_KjU;
                interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
                interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
                interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
                interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
        }
        i13 = 805306368;
        i4 |= i13;
        if ((1533916891 & i4) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i18 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i19 != 0) {
                    interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                } else {
                    interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                }
                if (i5 != 0) {
                    interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                } else {
                    interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                }
                if (i7 != 0) {
                    interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                } else {
                    interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                }
                if (i9 != 0) {
                    interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                } else {
                    interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                }
                if (i11 != 0) {
                    iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                } else {
                    iM1571getEndERTFSPs = i;
                }
                if ((i3 & 64) != 0) {
                    i14 = i4 & (-3670017);
                    jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                } else {
                    i14 = i4;
                    jM1389getBackground0d7_KjU = j;
                }
                if ((i3 & 128) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                    i14 &= -29360129;
                }
                if ((i3 & 256) != 0) {
                    i15 = i14 & (-234881025);
                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                    modifier2 = modifier2;
                } else {
                    i15 = i14;
                    contentWindowInsets = windowInsets;
                }
            } else {
                if (i18 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i19 != 0) {
                    interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                } else {
                    interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                }
                if (i5 != 0) {
                    interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                } else {
                    interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                }
                if (i7 != 0) {
                    interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                } else {
                    interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                }
                if (i9 != 0) {
                    interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                } else {
                    interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                }
                if (i11 != 0) {
                    iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                } else {
                    iM1571getEndERTFSPs = i;
                }
                if ((i3 & 64) != 0) {
                    i14 = i4 & (-3670017);
                    jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                } else {
                    i14 = i4;
                    jM1389getBackground0d7_KjU = j;
                }
                if ((i3 & 128) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                    i14 &= -29360129;
                }
                if ((i3 & 256) != 0) {
                    i15 = i14 & (-234881025);
                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                    modifier2 = modifier2;
                } else {
                    i15 = i14;
                    contentWindowInsets = windowInsets;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
            }
            int i21111111 = i15 >> 12;
            SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i21111111 & 896) | (i21111111 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            windowInsets2 = contentWindowInsets;
            j3 = jM1449contentColorForek8zF_U;
            j4 = jM1389getBackground0d7_KjU;
            interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
            interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
            interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
            interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
            modifier3 = modifier2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i18 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i19 != 0) {
                    interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                } else {
                    interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                }
                if (i5 != 0) {
                    interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                } else {
                    interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                }
                if (i7 != 0) {
                    interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                } else {
                    interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                }
                if (i9 != 0) {
                    interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                } else {
                    interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                }
                if (i11 != 0) {
                    iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                } else {
                    iM1571getEndERTFSPs = i;
                }
                if ((i3 & 64) != 0) {
                    i14 = i4 & (-3670017);
                    jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                } else {
                    i14 = i4;
                    jM1389getBackground0d7_KjU = j;
                }
                if ((i3 & 128) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                    i14 &= -29360129;
                }
                if ((i3 & 256) != 0) {
                    i15 = i14 & (-234881025);
                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                    modifier2 = modifier2;
                } else {
                    i15 = i14;
                    contentWindowInsets = windowInsets;
                }
            } else {
                if (i18 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i19 != 0) {
                    interfaceC0526FpM1475getLambda1$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1475getLambda1$material3_release();
                } else {
                    interfaceC0526FpM1475getLambda1$material3_release = interfaceC0526Fp5;
                }
                if (i5 != 0) {
                    interfaceC0526FpM1476getLambda2$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1476getLambda2$material3_release();
                } else {
                    interfaceC0526FpM1476getLambda2$material3_release = interfaceC0526Fp6;
                }
                if (i7 != 0) {
                    interfaceC0526FpM1477getLambda3$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1477getLambda3$material3_release();
                } else {
                    interfaceC0526FpM1477getLambda3$material3_release = interfaceC0526Fp3;
                }
                if (i9 != 0) {
                    interfaceC0526FpM1478getLambda4$material3_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1478getLambda4$material3_release();
                } else {
                    interfaceC0526FpM1478getLambda4$material3_release = interfaceC0526Fp7;
                }
                if (i11 != 0) {
                    iM1571getEndERTFSPs = FabPosition.Companion.m1571getEndERTFSPs();
                } else {
                    iM1571getEndERTFSPs = i;
                }
                if ((i3 & 64) != 0) {
                    i14 = i4 & (-3670017);
                    jM1389getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1389getBackground0d7_KjU();
                } else {
                    i14 = i4;
                    jM1389getBackground0d7_KjU = j;
                }
                if ((i3 & 128) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1389getBackground0d7_KjU, composerStartRestartGroup, (i14 >> 18) & 14);
                    i14 &= -29360129;
                }
                if ((i3 & 256) != 0) {
                    i15 = i14 & (-234881025);
                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                    modifier2 = modifier2;
                } else {
                    i15 = i14;
                    contentWindowInsets = windowInsets;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1219521777, i15, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:73)");
            }
            int i21111112 = i15 >> 12;
            SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, jM1389getBackground0d7_KjU, jM1449contentColorForek8zF_U, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new ScaffoldKt$Scaffold$1(iM1571getEndERTFSPs, interfaceC0526FpM1475getLambda1$material3_release, interfaceC0552Gp, interfaceC0526FpM1477getLambda3$material3_release, interfaceC0526FpM1478getLambda4$material3_release, contentWindowInsets, interfaceC0526FpM1476getLambda2$material3_release, i15)), composerStartRestartGroup, (i15 & 14) | 12582912 | (i21111112 & 896) | (i21111112 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            windowInsets2 = contentWindowInsets;
            j3 = jM1449contentColorForek8zF_U;
            j4 = jM1389getBackground0d7_KjU;
            interfaceC0526Fp8 = interfaceC0526FpM1476getLambda2$material3_release;
            interfaceC0526Fp9 = interfaceC0526FpM1477getLambda3$material3_release;
            interfaceC0526Fp10 = interfaceC0526FpM1478getLambda4$material3_release;
            interfaceC0526Fp5 = interfaceC0526FpM1475getLambda1$material3_release;
            modifier3 = modifier2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$Scaffold$2(modifier3, interfaceC0526Fp5, interfaceC0526Fp8, interfaceC0526Fp9, interfaceC0526Fp10, iM1571getEndERTFSPs, j4, j3, windowInsets2, interfaceC0552Gp, i2, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_][_][_][_]]")
    /* JADX INFO: renamed from: ScaffoldLayout-FMILGgc, reason: not valid java name */
    public static final void m1726ScaffoldLayoutFMILGgc(int i, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, WindowInsets windowInsets, InterfaceC0526Fp interfaceC0526Fp4, Composer composer, int i2) {
        Composer composer2;
        int i3;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-975511942);
        int i5 = (i2 & 14) == 0 ? (composerStartRestartGroup.changed(i) ? 4 : 2) | i2 : i2;
        if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(interfaceC0552Gp) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp2) ? 2048 : 1024;
        }
        if ((57344 & i2) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp3) ? 16384 : 8192;
        }
        if ((458752 & i2) == 0) {
            i5 |= composerStartRestartGroup.changed(windowInsets) ? 131072 : 65536;
        }
        if ((3670016 & i2) == 0) {
            i5 = (composerStartRestartGroup.changedInstance(interfaceC0526Fp4) ? 1048576 : 524288) | i5;
        }
        if ((2995931 & i5) == 599186 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-975511942, i5, -1, "androidx.compose.material3.ScaffoldLayout (Scaffold.kt:111)");
            }
            Object[] objArr = {interfaceC0526Fp, interfaceC0526Fp2, windowInsets, interfaceC0526Fp3, FabPosition.m1563boximpl(i), interfaceC0526Fp4, interfaceC0552Gp};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            int i6 = 0;
            boolean zChanged = false;
            for (int i7 = 7; i6 < i7; i7 = 7) {
                zChanged |= composerStartRestartGroup.changed(objArr[i6]);
                i6++;
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                composer2 = composerStartRestartGroup;
                i3 = 1;
                i4 = 0;
                ScaffoldKt$ScaffoldLayout$1$1 scaffoldKt$ScaffoldLayout$1$1 = new ScaffoldKt$ScaffoldLayout$1$1(interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, i, windowInsets, interfaceC0526Fp4, i5, interfaceC0552Gp);
                composer2.updateRememberedValue(scaffoldKt$ScaffoldLayout$1$1);
                objRememberedValue = scaffoldKt$ScaffoldLayout$1$1;
            } else {
                composer2 = composerStartRestartGroup;
                i3 = 1;
                i4 = 0;
            }
            composer2.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (InterfaceC0526Fp) objRememberedValue, composer2, i4, i3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$ScaffoldLayout$2(i, interfaceC0526Fp, interfaceC0552Gp, interfaceC0526Fp2, interfaceC0526Fp3, windowInsets, interfaceC0526Fp4, i2));
    }

    public static final ProvidableCompositionLocal<FabPlacement> getLocalFabPlacement() {
        return LocalFabPlacement;
    }
}
