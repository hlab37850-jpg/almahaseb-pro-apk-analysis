package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import androidx.recyclerview.widget.ItemTouchHelper;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
public final class TabRowKt {
    private static final float ScrollableTabRowMinimumTabWidth = Dp.m5160constructorimpl(90);
    private static final float ScrollableTabRowPadding = Dp.m5160constructorimpl(52);
    private static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, null);

    /* JADX WARN: Code duplicated, block: B:106:0x0137 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:107:0x0139  */
    /* JADX WARN: Code duplicated, block: B:108:0x013c  */
    /* JADX WARN: Code duplicated, block: B:111:0x0143  */
    /* JADX WARN: Code duplicated, block: B:114:0x014f  */
    /* JADX WARN: Code duplicated, block: B:115:0x0158  */
    /* JADX WARN: Code duplicated, block: B:117:0x015b  */
    /* JADX WARN: Code duplicated, block: B:118:0x015e  */
    /* JADX WARN: Code duplicated, block: B:120:0x0161  */
    /* JADX WARN: Code duplicated, block: B:121:0x016f  */
    /* JADX WARN: Code duplicated, block: B:123:0x0173  */
    /* JADX WARN: Code duplicated, block: B:124:0x017f  */
    /* JADX WARN: Code duplicated, block: B:127:0x018a  */
    /* JADX WARN: Code duplicated, block: B:130:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:135:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004c  */
    /* JADX WARN: Code duplicated, block: B:28:0x0050  */
    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:31:0x005b  */
    /* JADX WARN: Code duplicated, block: B:34:0x0061  */
    /* JADX WARN: Code duplicated, block: B:37:0x0067  */
    /* JADX WARN: Code duplicated, block: B:39:0x006b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x0076  */
    /* JADX WARN: Code duplicated, block: B:45:0x007c  */
    /* JADX WARN: Code duplicated, block: B:48:0x0082  */
    /* JADX WARN: Code duplicated, block: B:50:0x0087  */
    /* JADX WARN: Code duplicated, block: B:52:0x008d  */
    /* JADX WARN: Code duplicated, block: B:54:0x0095  */
    /* JADX WARN: Code duplicated, block: B:55:0x0098  */
    /* JADX WARN: Code duplicated, block: B:59:0x009f  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:93:0x0110  */
    /* JADX WARN: Code duplicated, block: B:95:0x0117  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_][_]]")
    /* JADX INFO: renamed from: ScrollableTabRow-sKfQg0A, reason: not valid java name */
    public static final void m1886ScrollableTabRowsKfQg0A(int i, Modifier modifier, long j, long j2, float f, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, Composer composer, int i2, int i3) {
        int i4;
        long containerColor;
        long j3;
        int i5;
        float f2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Modifier modifier2;
        long contentColor;
        float f3;
        InterfaceC0552Gp interfaceC0552GpComposableLambda;
        int i12;
        InterfaceC0526Fp interfaceC0526FpM1483getLambda2$material3_release;
        InterfaceC0526Fp interfaceC0526Fp3;
        InterfaceC0552Gp interfaceC0552Gp2;
        Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0526Fp2, "tabs");
        Composer composerStartRestartGroup = composer.startRestartGroup(-497821003);
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i13 = i3 & 2;
        if (i13 == 0) {
            if ((i2 & 112) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i2 & 896) == 0) {
                if ((i3 & 4) == 0) {
                    containerColor = j;
                    int i14 = composerStartRestartGroup.changed(containerColor) ? 256 : 128;
                    i4 |= i14;
                } else {
                    containerColor = j;
                }
                i4 |= i14;
            } else {
                containerColor = j;
            }
            if ((i2 & 7168) == 0) {
                if ((i3 & 8) == 0) {
                    j3 = j2;
                    int i15 = composerStartRestartGroup.changed(j3) ? 2048 : 1024;
                    i4 |= i15;
                } else {
                    j3 = j2;
                }
                i4 |= i15;
            } else {
                j3 = j2;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                if ((57344 & i2) == 0) {
                    f2 = f;
                    if (composerStartRestartGroup.changed(f2)) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 32;
                if (i7 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i2 & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i4 |= i8;
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                if ((i3 & 128) != 0) {
                    i4 |= 12582912;
                } else if ((29360128 & i2) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i4 |= i11;
                }
                if ((23967451 & i4) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            contentColor = j3;
                        }
                        if (i5 != 0) {
                            f3 = ScrollableTabRowPadding;
                        } else {
                            f3 = f2;
                        }
                        if (i7 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -913748678, true, new TabRowKt$ScrollableTabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp;
                        }
                        if (i9 != 0) {
                            i12 = i4;
                            interfaceC0526FpM1483getLambda2$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1483getLambda2$material3_release();
                        } else {
                            i12 = i4;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-497821003, i12, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:227)");
                        }
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 286469328, true, new TabRowKt$ScrollableTabRow$2(f3, interfaceC0526Fp2, interfaceC0526FpM1483getLambda2$material3_release, i, interfaceC0552GpComposableLambda, i12)), composerStartRestartGroup, ((i12 >> 3) & 14) | 12582912 | (i12 & 896) | (i12 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp3 = interfaceC0526FpM1483getLambda2$material3_release;
                        f2 = f3;
                        interfaceC0552Gp2 = interfaceC0552GpComposableLambda;
                        modifier3 = modifier2;
                        j3 = contentColor;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 4) != 0) {
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            i4 &= -7169;
                        }
                        modifier2 = modifier;
                        i12 = i4;
                        contentColor = j3;
                        f3 = f2;
                        interfaceC0552GpComposableLambda = interfaceC0552Gp;
                    }
                    interfaceC0526FpM1483getLambda2$material3_release = interfaceC0526Fp;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-497821003, i12, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:227)");
                    }
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 286469328, true, new TabRowKt$ScrollableTabRow$2(f3, interfaceC0526Fp2, interfaceC0526FpM1483getLambda2$material3_release, i, interfaceC0552GpComposableLambda, i12)), composerStartRestartGroup, ((i12 >> 3) & 14) | 12582912 | (i12 & 896) | (i12 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp3 = interfaceC0526FpM1483getLambda2$material3_release;
                    f2 = f3;
                    interfaceC0552Gp2 = interfaceC0552GpComposableLambda;
                    modifier3 = modifier2;
                    j3 = contentColor;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier;
                    interfaceC0552Gp2 = interfaceC0552Gp;
                    interfaceC0526Fp3 = interfaceC0526Fp;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$ScrollableTabRow$3(i, modifier3, containerColor, j3, f2, interfaceC0552Gp2, interfaceC0526Fp3, interfaceC0526Fp2, i2, i3));
            }
            i4 |= 24576;
            f2 = f;
            i7 = i3 & 32;
            if (i7 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i2 & 458752) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i4 |= i8;
            }
            i9 = i3 & 64;
            if (i9 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
            if ((i3 & 128) != 0) {
                i4 |= 12582912;
            } else if ((29360128 & i2) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i4 |= i11;
            }
            if ((23967451 & i4) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        contentColor = j3;
                    }
                    if (i5 != 0) {
                        f3 = ScrollableTabRowPadding;
                    } else {
                        f3 = f2;
                    }
                    if (i7 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -913748678, true, new TabRowKt$ScrollableTabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp;
                    }
                    if (i9 != 0) {
                        i12 = i4;
                        interfaceC0526FpM1483getLambda2$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1483getLambda2$material3_release();
                    } else {
                        i12 = i4;
                        interfaceC0526FpM1483getLambda2$material3_release = interfaceC0526Fp;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        contentColor = j3;
                    }
                    if (i5 != 0) {
                        f3 = ScrollableTabRowPadding;
                    } else {
                        f3 = f2;
                    }
                    if (i7 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -913748678, true, new TabRowKt$ScrollableTabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp;
                    }
                    if (i9 != 0) {
                        i12 = i4;
                        interfaceC0526FpM1483getLambda2$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1483getLambda2$material3_release();
                    } else {
                        i12 = i4;
                        interfaceC0526FpM1483getLambda2$material3_release = interfaceC0526Fp;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-497821003, i12, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:227)");
                }
                SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 286469328, true, new TabRowKt$ScrollableTabRow$2(f3, interfaceC0526Fp2, interfaceC0526FpM1483getLambda2$material3_release, i, interfaceC0552GpComposableLambda, i12)), composerStartRestartGroup, ((i12 >> 3) & 14) | 12582912 | (i12 & 896) | (i12 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp3 = interfaceC0526FpM1483getLambda2$material3_release;
                f2 = f3;
                interfaceC0552Gp2 = interfaceC0552GpComposableLambda;
                modifier3 = modifier2;
                j3 = contentColor;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        contentColor = j3;
                    }
                    if (i5 != 0) {
                        f3 = ScrollableTabRowPadding;
                    } else {
                        f3 = f2;
                    }
                    if (i7 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -913748678, true, new TabRowKt$ScrollableTabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp;
                    }
                    if (i9 != 0) {
                        i12 = i4;
                        interfaceC0526FpM1483getLambda2$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1483getLambda2$material3_release();
                    } else {
                        i12 = i4;
                        interfaceC0526FpM1483getLambda2$material3_release = interfaceC0526Fp;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        contentColor = j3;
                    }
                    if (i5 != 0) {
                        f3 = ScrollableTabRowPadding;
                    } else {
                        f3 = f2;
                    }
                    if (i7 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -913748678, true, new TabRowKt$ScrollableTabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp;
                    }
                    if (i9 != 0) {
                        i12 = i4;
                        interfaceC0526FpM1483getLambda2$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1483getLambda2$material3_release();
                    } else {
                        i12 = i4;
                        interfaceC0526FpM1483getLambda2$material3_release = interfaceC0526Fp;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-497821003, i12, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:227)");
                }
                SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 286469328, true, new TabRowKt$ScrollableTabRow$2(f3, interfaceC0526Fp2, interfaceC0526FpM1483getLambda2$material3_release, i, interfaceC0552GpComposableLambda, i12)), composerStartRestartGroup, ((i12 >> 3) & 14) | 12582912 | (i12 & 896) | (i12 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp3 = interfaceC0526FpM1483getLambda2$material3_release;
                f2 = f3;
                interfaceC0552Gp2 = interfaceC0552GpComposableLambda;
                modifier3 = modifier2;
                j3 = contentColor;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$ScrollableTabRow$3(i, modifier3, containerColor, j3, f2, interfaceC0552Gp2, interfaceC0526Fp3, interfaceC0526Fp2, i2, i3));
        }
        i4 |= 48;
        if ((i2 & 896) == 0) {
            if ((i3 & 4) == 0) {
                containerColor = j;
                if (composerStartRestartGroup.changed(containerColor)) {
                }
                i4 |= i14;
            } else {
                containerColor = j;
            }
            i4 |= i14;
        } else {
            containerColor = j;
        }
        if ((i2 & 7168) == 0) {
            if ((i3 & 8) == 0) {
                j3 = j2;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i4 |= i15;
            } else {
                j3 = j2;
            }
            i4 |= i15;
        } else {
            j3 = j2;
        }
        i5 = i3 & 16;
        if (i5 != 0) {
            if ((57344 & i2) == 0) {
                f2 = f;
                if (composerStartRestartGroup.changed(f2)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i4 |= i6;
            }
            i7 = i3 & 32;
            if (i7 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i2 & 458752) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i4 |= i8;
            }
            i9 = i3 & 64;
            if (i9 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
            if ((i3 & 128) != 0) {
                i4 |= 12582912;
            } else if ((29360128 & i2) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i4 |= i11;
            }
            if ((23967451 & i4) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        contentColor = j3;
                    }
                    if (i5 != 0) {
                        f3 = ScrollableTabRowPadding;
                    } else {
                        f3 = f2;
                    }
                    if (i7 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -913748678, true, new TabRowKt$ScrollableTabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp;
                    }
                    if (i9 != 0) {
                        i12 = i4;
                        interfaceC0526FpM1483getLambda2$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1483getLambda2$material3_release();
                    } else {
                        i12 = i4;
                        interfaceC0526FpM1483getLambda2$material3_release = interfaceC0526Fp;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        contentColor = j3;
                    }
                    if (i5 != 0) {
                        f3 = ScrollableTabRowPadding;
                    } else {
                        f3 = f2;
                    }
                    if (i7 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -913748678, true, new TabRowKt$ScrollableTabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp;
                    }
                    if (i9 != 0) {
                        i12 = i4;
                        interfaceC0526FpM1483getLambda2$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1483getLambda2$material3_release();
                    } else {
                        i12 = i4;
                        interfaceC0526FpM1483getLambda2$material3_release = interfaceC0526Fp;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-497821003, i12, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:227)");
                }
                SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 286469328, true, new TabRowKt$ScrollableTabRow$2(f3, interfaceC0526Fp2, interfaceC0526FpM1483getLambda2$material3_release, i, interfaceC0552GpComposableLambda, i12)), composerStartRestartGroup, ((i12 >> 3) & 14) | 12582912 | (i12 & 896) | (i12 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp3 = interfaceC0526FpM1483getLambda2$material3_release;
                f2 = f3;
                interfaceC0552Gp2 = interfaceC0552GpComposableLambda;
                modifier3 = modifier2;
                j3 = contentColor;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        contentColor = j3;
                    }
                    if (i5 != 0) {
                        f3 = ScrollableTabRowPadding;
                    } else {
                        f3 = f2;
                    }
                    if (i7 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -913748678, true, new TabRowKt$ScrollableTabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp;
                    }
                    if (i9 != 0) {
                        i12 = i4;
                        interfaceC0526FpM1483getLambda2$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1483getLambda2$material3_release();
                    } else {
                        i12 = i4;
                        interfaceC0526FpM1483getLambda2$material3_release = interfaceC0526Fp;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        contentColor = j3;
                    }
                    if (i5 != 0) {
                        f3 = ScrollableTabRowPadding;
                    } else {
                        f3 = f2;
                    }
                    if (i7 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -913748678, true, new TabRowKt$ScrollableTabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp;
                    }
                    if (i9 != 0) {
                        i12 = i4;
                        interfaceC0526FpM1483getLambda2$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1483getLambda2$material3_release();
                    } else {
                        i12 = i4;
                        interfaceC0526FpM1483getLambda2$material3_release = interfaceC0526Fp;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-497821003, i12, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:227)");
                }
                SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 286469328, true, new TabRowKt$ScrollableTabRow$2(f3, interfaceC0526Fp2, interfaceC0526FpM1483getLambda2$material3_release, i, interfaceC0552GpComposableLambda, i12)), composerStartRestartGroup, ((i12 >> 3) & 14) | 12582912 | (i12 & 896) | (i12 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp3 = interfaceC0526FpM1483getLambda2$material3_release;
                f2 = f3;
                interfaceC0552Gp2 = interfaceC0552GpComposableLambda;
                modifier3 = modifier2;
                j3 = contentColor;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$ScrollableTabRow$3(i, modifier3, containerColor, j3, f2, interfaceC0552Gp2, interfaceC0526Fp3, interfaceC0526Fp2, i2, i3));
        }
        i4 |= 24576;
        f2 = f;
        i7 = i3 & 32;
        if (i7 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i2 & 458752) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                i8 = 131072;
            } else {
                i8 = 65536;
            }
            i4 |= i8;
        }
        i9 = i3 & 64;
        if (i9 != 0) {
            i4 |= 1572864;
        } else if ((i2 & 3670016) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                i10 = 1048576;
            } else {
                i10 = 524288;
            }
            i4 |= i10;
        }
        if ((i3 & 128) != 0) {
            i4 |= 12582912;
        } else if ((29360128 & i2) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                i11 = 8388608;
            } else {
                i11 = 4194304;
            }
            i4 |= i11;
        }
        if ((23967451 & i4) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i3 & 4) != 0) {
                    containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    contentColor = j3;
                }
                if (i5 != 0) {
                    f3 = ScrollableTabRowPadding;
                } else {
                    f3 = f2;
                }
                if (i7 != 0) {
                    interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -913748678, true, new TabRowKt$ScrollableTabRow$1(i));
                } else {
                    interfaceC0552GpComposableLambda = interfaceC0552Gp;
                }
                if (i9 != 0) {
                    i12 = i4;
                    interfaceC0526FpM1483getLambda2$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1483getLambda2$material3_release();
                } else {
                    i12 = i4;
                    interfaceC0526FpM1483getLambda2$material3_release = interfaceC0526Fp;
                }
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i3 & 4) != 0) {
                    containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    contentColor = j3;
                }
                if (i5 != 0) {
                    f3 = ScrollableTabRowPadding;
                } else {
                    f3 = f2;
                }
                if (i7 != 0) {
                    interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -913748678, true, new TabRowKt$ScrollableTabRow$1(i));
                } else {
                    interfaceC0552GpComposableLambda = interfaceC0552Gp;
                }
                if (i9 != 0) {
                    i12 = i4;
                    interfaceC0526FpM1483getLambda2$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1483getLambda2$material3_release();
                } else {
                    i12 = i4;
                    interfaceC0526FpM1483getLambda2$material3_release = interfaceC0526Fp;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-497821003, i12, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:227)");
            }
            SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 286469328, true, new TabRowKt$ScrollableTabRow$2(f3, interfaceC0526Fp2, interfaceC0526FpM1483getLambda2$material3_release, i, interfaceC0552GpComposableLambda, i12)), composerStartRestartGroup, ((i12 >> 3) & 14) | 12582912 | (i12 & 896) | (i12 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC0526Fp3 = interfaceC0526FpM1483getLambda2$material3_release;
            f2 = f3;
            interfaceC0552Gp2 = interfaceC0552GpComposableLambda;
            modifier3 = modifier2;
            j3 = contentColor;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i3 & 4) != 0) {
                    containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    contentColor = j3;
                }
                if (i5 != 0) {
                    f3 = ScrollableTabRowPadding;
                } else {
                    f3 = f2;
                }
                if (i7 != 0) {
                    interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -913748678, true, new TabRowKt$ScrollableTabRow$1(i));
                } else {
                    interfaceC0552GpComposableLambda = interfaceC0552Gp;
                }
                if (i9 != 0) {
                    i12 = i4;
                    interfaceC0526FpM1483getLambda2$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1483getLambda2$material3_release();
                } else {
                    i12 = i4;
                    interfaceC0526FpM1483getLambda2$material3_release = interfaceC0526Fp;
                }
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i3 & 4) != 0) {
                    containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    contentColor = j3;
                }
                if (i5 != 0) {
                    f3 = ScrollableTabRowPadding;
                } else {
                    f3 = f2;
                }
                if (i7 != 0) {
                    interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -913748678, true, new TabRowKt$ScrollableTabRow$1(i));
                } else {
                    interfaceC0552GpComposableLambda = interfaceC0552Gp;
                }
                if (i9 != 0) {
                    i12 = i4;
                    interfaceC0526FpM1483getLambda2$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1483getLambda2$material3_release();
                } else {
                    i12 = i4;
                    interfaceC0526FpM1483getLambda2$material3_release = interfaceC0526Fp;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-497821003, i12, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:227)");
            }
            SurfaceKt.m1850SurfaceT9BRK9s(modifier2, null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 286469328, true, new TabRowKt$ScrollableTabRow$2(f3, interfaceC0526Fp2, interfaceC0526FpM1483getLambda2$material3_release, i, interfaceC0552GpComposableLambda, i12)), composerStartRestartGroup, ((i12 >> 3) & 14) | 12582912 | (i12 & 896) | (i12 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC0526Fp3 = interfaceC0526FpM1483getLambda2$material3_release;
            f2 = f3;
            interfaceC0552Gp2 = interfaceC0552GpComposableLambda;
            modifier3 = modifier2;
            j3 = contentColor;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$ScrollableTabRow$3(i, modifier3, containerColor, j3, f2, interfaceC0552Gp2, interfaceC0526Fp3, interfaceC0526Fp2, i2, i3));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0119  */
    /* JADX WARN: Code duplicated, block: B:104:0x0125  */
    /* JADX WARN: Code duplicated, block: B:105:0x012e  */
    /* JADX WARN: Code duplicated, block: B:107:0x0131  */
    /* JADX WARN: Code duplicated, block: B:108:0x013f  */
    /* JADX WARN: Code duplicated, block: B:110:0x0142  */
    /* JADX WARN: Code duplicated, block: B:113:0x0156  */
    /* JADX WARN: Code duplicated, block: B:116:0x0191  */
    /* JADX WARN: Code duplicated, block: B:121:0x019e  */
    /* JADX WARN: Code duplicated, block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004a  */
    /* JADX WARN: Code duplicated, block: B:28:0x004e  */
    /* JADX WARN: Code duplicated, block: B:30:0x0056  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x005f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0065  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074  */
    /* JADX WARN: Code duplicated, block: B:44:0x0078  */
    /* JADX WARN: Code duplicated, block: B:47:0x007e  */
    /* JADX WARN: Code duplicated, block: B:49:0x0083  */
    /* JADX WARN: Code duplicated, block: B:51:0x0089  */
    /* JADX WARN: Code duplicated, block: B:53:0x0091  */
    /* JADX WARN: Code duplicated, block: B:54:0x0094  */
    /* JADX WARN: Code duplicated, block: B:58:0x009b  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:71:0x00be  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:76:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:79:0x00da  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:95:0x010a A[PHI: r0 r3 r4 r6 r8
      0x010a: PHI (r0v8 androidx.compose.ui.Modifier) = (r0v5 androidx.compose.ui.Modifier), (r0v12 androidx.compose.ui.Modifier) binds: [B:109:0x0140, B:94:0x0106] A[DONT_GENERATE, DONT_INLINE]
      0x010a: PHI (r3v25 int) = (r3v19 int), (r3v28 int) binds: [B:109:0x0140, B:94:0x0106] A[DONT_GENERATE, DONT_INLINE]
      0x010a: PHI (r4v9 long) = (r4v4 long), (r4v10 long) binds: [B:109:0x0140, B:94:0x0106] A[DONT_GENERATE, DONT_INLINE]
      0x010a: PHI (r6v10 long) = (r6v7 long), (r6v6 long) binds: [B:109:0x0140, B:94:0x0106] A[DONT_GENERATE, DONT_INLINE]
      0x010a: PHI (r8v7 Gp) = (r8v3 Gp), (r8v8 Gp) binds: [B:109:0x0140, B:94:0x0106] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:96:0x010d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:97:0x010f  */
    /* JADX WARN: Code duplicated, block: B:98:0x0112  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_][_]]")
    /* JADX INFO: renamed from: TabRow-pAZo6Ak, reason: not valid java name */
    public static final void m1887TabRowpAZo6Ak(int i, Modifier modifier, long j, long j2, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, Composer composer, int i2, int i3) {
        int i4;
        long containerColor;
        long j3;
        int i5;
        InterfaceC0552Gp interfaceC0552Gp2;
        int i6;
        int i7;
        InterfaceC0526Fp interfaceC0526Fp3;
        int i8;
        int i9;
        Modifier modifier2;
        long contentColor;
        InterfaceC0552Gp interfaceC0552GpComposableLambda;
        int i10;
        InterfaceC0526Fp interfaceC0526FpM1482getLambda1$material3_release;
        Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        AbstractC4492zt.h(interfaceC0526Fp2, "tabs");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1199178586);
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i12 = i3 & 2;
        if (i12 == 0) {
            if ((i2 & 112) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i2 & 896) == 0) {
                if ((i3 & 4) == 0) {
                    containerColor = j;
                    int i13 = composerStartRestartGroup.changed(containerColor) ? 256 : 128;
                    i4 |= i13;
                } else {
                    containerColor = j;
                }
                i4 |= i13;
            } else {
                containerColor = j;
            }
            if ((i2 & 7168) == 0) {
                j3 = j2;
                if ((i3 & 8) == 0 || !composerStartRestartGroup.changed(j3)) {
                    i11 = 1024;
                } else {
                    i11 = 2048;
                }
                i4 |= i11;
            } else {
                j3 = j2;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                if ((57344 & i2) == 0) {
                    interfaceC0552Gp2 = interfaceC0552Gp;
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 32;
                if (i7 != 0) {
                    if ((458752 & i2) == 0) {
                        interfaceC0526Fp3 = interfaceC0526Fp;
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                            i8 = 131072;
                        } else {
                            i8 = 65536;
                        }
                        i4 |= i8;
                    }
                    if ((i3 & 64) != 0) {
                        if ((i2 & 3670016) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                                i9 = 1048576;
                            } else {
                                i9 = 524288;
                            }
                        }
                        if ((i4 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i12 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if ((i3 & 4) != 0) {
                                    containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                    i4 &= -7169;
                                } else {
                                    contentColor = j3;
                                }
                                if (i5 != 0) {
                                    interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                                } else {
                                    interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                                }
                                if (i7 != 0) {
                                    i10 = i4;
                                    interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                                }
                                SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                                j3 = contentColor;
                                modifier3 = modifier2;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    i4 &= -7169;
                                }
                                modifier2 = modifier;
                                contentColor = j3;
                                interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                            }
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                            }
                            SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                            j3 = contentColor;
                            modifier3 = modifier2;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier;
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$TabRow$3(i, modifier3, containerColor, j3, interfaceC0552GpComposableLambda, interfaceC0526Fp3, interfaceC0526Fp2, i2, i3));
                    }
                    i9 = 1572864;
                    i4 |= i9;
                    if ((i4 & 2995931) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                contentColor = j3;
                            }
                            if (i5 != 0) {
                                interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                            } else {
                                interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                            }
                            if (i7 != 0) {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                            } else {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                contentColor = j3;
                            }
                            if (i5 != 0) {
                                interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                            } else {
                                interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                            }
                            if (i7 != 0) {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                            } else {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                        }
                        SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                        j3 = contentColor;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                contentColor = j3;
                            }
                            if (i5 != 0) {
                                interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                            } else {
                                interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                            }
                            if (i7 != 0) {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                            } else {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                contentColor = j3;
                            }
                            if (i5 != 0) {
                                interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                            } else {
                                interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                            }
                            if (i7 != 0) {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                            } else {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                        }
                        SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                        j3 = contentColor;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$TabRow$3(i, modifier3, containerColor, j3, interfaceC0552GpComposableLambda, interfaceC0526Fp3, interfaceC0526Fp2, i2, i3));
                }
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                interfaceC0526Fp3 = interfaceC0526Fp;
                if ((i3 & 64) != 0) {
                    if ((i2 & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                    }
                    if ((i4 & 2995931) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                contentColor = j3;
                            }
                            if (i5 != 0) {
                                interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                            } else {
                                interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                            }
                            if (i7 != 0) {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                            } else {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                contentColor = j3;
                            }
                            if (i5 != 0) {
                                interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                            } else {
                                interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                            }
                            if (i7 != 0) {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                            } else {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                        }
                        SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                        j3 = contentColor;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                contentColor = j3;
                            }
                            if (i5 != 0) {
                                interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                            } else {
                                interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                            }
                            if (i7 != 0) {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                            } else {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                contentColor = j3;
                            }
                            if (i5 != 0) {
                                interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                            } else {
                                interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                            }
                            if (i7 != 0) {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                            } else {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                        }
                        SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                        j3 = contentColor;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$TabRow$3(i, modifier3, containerColor, j3, interfaceC0552GpComposableLambda, interfaceC0526Fp3, interfaceC0526Fp2, i2, i3));
                }
                i9 = 1572864;
                i4 |= i9;
                if ((i4 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            contentColor = j3;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                        } else {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            contentColor = j3;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                        } else {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                    }
                    SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                    j3 = contentColor;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            contentColor = j3;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                        } else {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            contentColor = j3;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                        } else {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                    }
                    SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                    j3 = contentColor;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$TabRow$3(i, modifier3, containerColor, j3, interfaceC0552GpComposableLambda, interfaceC0526Fp3, interfaceC0526Fp2, i2, i3));
            }
            i4 |= 24576;
            interfaceC0552Gp2 = interfaceC0552Gp;
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((458752 & i2) == 0) {
                    interfaceC0526Fp3 = interfaceC0526Fp;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i4 |= i8;
                }
                if ((i3 & 64) != 0) {
                    if ((i2 & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                    }
                    if ((i4 & 2995931) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                contentColor = j3;
                            }
                            if (i5 != 0) {
                                interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                            } else {
                                interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                            }
                            if (i7 != 0) {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                            } else {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                contentColor = j3;
                            }
                            if (i5 != 0) {
                                interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                            } else {
                                interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                            }
                            if (i7 != 0) {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                            } else {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                        }
                        SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                        j3 = contentColor;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                contentColor = j3;
                            }
                            if (i5 != 0) {
                                interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                            } else {
                                interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                            }
                            if (i7 != 0) {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                            } else {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                contentColor = j3;
                            }
                            if (i5 != 0) {
                                interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                            } else {
                                interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                            }
                            if (i7 != 0) {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                            } else {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                        }
                        SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                        j3 = contentColor;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$TabRow$3(i, modifier3, containerColor, j3, interfaceC0552GpComposableLambda, interfaceC0526Fp3, interfaceC0526Fp2, i2, i3));
                }
                i9 = 1572864;
                i4 |= i9;
                if ((i4 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            contentColor = j3;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                        } else {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            contentColor = j3;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                        } else {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                    }
                    SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                    j3 = contentColor;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            contentColor = j3;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                        } else {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            contentColor = j3;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                        } else {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                    }
                    SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                    j3 = contentColor;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$TabRow$3(i, modifier3, containerColor, j3, interfaceC0552GpComposableLambda, interfaceC0526Fp3, interfaceC0526Fp2, i2, i3));
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            interfaceC0526Fp3 = interfaceC0526Fp;
            if ((i3 & 64) != 0) {
                if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                }
                if ((i4 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            contentColor = j3;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                        } else {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            contentColor = j3;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                        } else {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                    }
                    SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                    j3 = contentColor;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            contentColor = j3;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                        } else {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            contentColor = j3;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                        } else {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                    }
                    SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                    j3 = contentColor;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$TabRow$3(i, modifier3, containerColor, j3, interfaceC0552GpComposableLambda, interfaceC0526Fp3, interfaceC0526Fp2, i2, i3));
            }
            i9 = 1572864;
            i4 |= i9;
            if ((i4 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        contentColor = j3;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                    } else {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        contentColor = j3;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                    } else {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                }
                SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                j3 = contentColor;
                modifier3 = modifier2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        contentColor = j3;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                    } else {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        contentColor = j3;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                    } else {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                }
                SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                j3 = contentColor;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$TabRow$3(i, modifier3, containerColor, j3, interfaceC0552GpComposableLambda, interfaceC0526Fp3, interfaceC0526Fp2, i2, i3));
        }
        i4 |= 48;
        if ((i2 & 896) == 0) {
            if ((i3 & 4) == 0) {
                containerColor = j;
                if (composerStartRestartGroup.changed(containerColor)) {
                }
                i4 |= i13;
            } else {
                containerColor = j;
            }
            i4 |= i13;
        } else {
            containerColor = j;
        }
        if ((i2 & 7168) == 0) {
            j3 = j2;
            if ((i3 & 8) == 0) {
                i11 = 1024;
            } else {
                i11 = 1024;
            }
            i4 |= i11;
        } else {
            j3 = j2;
        }
        i5 = i3 & 16;
        if (i5 != 0) {
            if ((57344 & i2) == 0) {
                interfaceC0552Gp2 = interfaceC0552Gp;
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i4 |= i6;
            }
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((458752 & i2) == 0) {
                    interfaceC0526Fp3 = interfaceC0526Fp;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i4 |= i8;
                }
                if ((i3 & 64) != 0) {
                    if ((i2 & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                    }
                    if ((i4 & 2995931) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                contentColor = j3;
                            }
                            if (i5 != 0) {
                                interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                            } else {
                                interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                            }
                            if (i7 != 0) {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                            } else {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                contentColor = j3;
                            }
                            if (i5 != 0) {
                                interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                            } else {
                                interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                            }
                            if (i7 != 0) {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                            } else {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                        }
                        SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                        j3 = contentColor;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                contentColor = j3;
                            }
                            if (i5 != 0) {
                                interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                            } else {
                                interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                            }
                            if (i7 != 0) {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                            } else {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                contentColor = j3;
                            }
                            if (i5 != 0) {
                                interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                            } else {
                                interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                            }
                            if (i7 != 0) {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                            } else {
                                i10 = i4;
                                interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                        }
                        SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                        j3 = contentColor;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$TabRow$3(i, modifier3, containerColor, j3, interfaceC0552GpComposableLambda, interfaceC0526Fp3, interfaceC0526Fp2, i2, i3));
                }
                i9 = 1572864;
                i4 |= i9;
                if ((i4 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            contentColor = j3;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                        } else {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            contentColor = j3;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                        } else {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                    }
                    SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                    j3 = contentColor;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            contentColor = j3;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                        } else {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            contentColor = j3;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                        } else {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                    }
                    SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                    j3 = contentColor;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$TabRow$3(i, modifier3, containerColor, j3, interfaceC0552GpComposableLambda, interfaceC0526Fp3, interfaceC0526Fp2, i2, i3));
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            interfaceC0526Fp3 = interfaceC0526Fp;
            if ((i3 & 64) != 0) {
                if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                }
                if ((i4 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            contentColor = j3;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                        } else {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            contentColor = j3;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                        } else {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                    }
                    SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                    j3 = contentColor;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            contentColor = j3;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                        } else {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            contentColor = j3;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                        } else {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                    }
                    SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                    j3 = contentColor;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$TabRow$3(i, modifier3, containerColor, j3, interfaceC0552GpComposableLambda, interfaceC0526Fp3, interfaceC0526Fp2, i2, i3));
            }
            i9 = 1572864;
            i4 |= i9;
            if ((i4 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        contentColor = j3;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                    } else {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        contentColor = j3;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                    } else {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                }
                SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                j3 = contentColor;
                modifier3 = modifier2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        contentColor = j3;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                    } else {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        contentColor = j3;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                    } else {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                }
                SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                j3 = contentColor;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$TabRow$3(i, modifier3, containerColor, j3, interfaceC0552GpComposableLambda, interfaceC0526Fp3, interfaceC0526Fp2, i2, i3));
        }
        i4 |= 24576;
        interfaceC0552Gp2 = interfaceC0552Gp;
        i7 = i3 & 32;
        if (i7 != 0) {
            if ((458752 & i2) == 0) {
                interfaceC0526Fp3 = interfaceC0526Fp;
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i4 |= i8;
            }
            if ((i3 & 64) != 0) {
                if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                }
                if ((i4 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            contentColor = j3;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                        } else {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            contentColor = j3;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                        } else {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                    }
                    SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                    j3 = contentColor;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            contentColor = j3;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                        } else {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            contentColor = j3;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                        } else {
                            i10 = i4;
                            interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                    }
                    SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                    j3 = contentColor;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$TabRow$3(i, modifier3, containerColor, j3, interfaceC0552GpComposableLambda, interfaceC0526Fp3, interfaceC0526Fp2, i2, i3));
            }
            i9 = 1572864;
            i4 |= i9;
            if ((i4 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        contentColor = j3;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                    } else {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        contentColor = j3;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                    } else {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                }
                SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                j3 = contentColor;
                modifier3 = modifier2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        contentColor = j3;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                    } else {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        contentColor = j3;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                    } else {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                }
                SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                j3 = contentColor;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$TabRow$3(i, modifier3, containerColor, j3, interfaceC0552GpComposableLambda, interfaceC0526Fp3, interfaceC0526Fp2, i2, i3));
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        interfaceC0526Fp3 = interfaceC0526Fp;
        if ((i3 & 64) != 0) {
            if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
            }
            if ((i4 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        contentColor = j3;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                    } else {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        contentColor = j3;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                    } else {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                }
                SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                j3 = contentColor;
                modifier3 = modifier2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        contentColor = j3;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                    } else {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        contentColor = j3;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                    } else {
                        i10 = i4;
                        interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                }
                SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
                j3 = contentColor;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$TabRow$3(i, modifier3, containerColor, j3, interfaceC0552GpComposableLambda, interfaceC0526Fp3, interfaceC0526Fp2, i2, i3));
        }
        i9 = 1572864;
        i4 |= i9;
        if ((i4 & 2995931) == 599186) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i3 & 4) != 0) {
                    containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    contentColor = j3;
                }
                if (i5 != 0) {
                    interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                } else {
                    interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                }
                if (i7 != 0) {
                    i10 = i4;
                    interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                } else {
                    i10 = i4;
                    interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                }
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i3 & 4) != 0) {
                    containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    contentColor = j3;
                }
                if (i5 != 0) {
                    interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                } else {
                    interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                }
                if (i7 != 0) {
                    i10 = i4;
                    interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                } else {
                    i10 = i4;
                    interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
            }
            SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
            j3 = contentColor;
            modifier3 = modifier2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i3 & 4) != 0) {
                    containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    contentColor = j3;
                }
                if (i5 != 0) {
                    interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                } else {
                    interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                }
                if (i7 != 0) {
                    i10 = i4;
                    interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                } else {
                    i10 = i4;
                    interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                }
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i3 & 4) != 0) {
                    containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    contentColor = j3;
                }
                if (i5 != 0) {
                    interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new TabRowKt$TabRow$1(i));
                } else {
                    interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                }
                if (i7 != 0) {
                    i10 = i4;
                    interfaceC0526FpM1482getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m1482getLambda1$material3_release();
                } else {
                    i10 = i4;
                    interfaceC0526FpM1482getLambda1$material3_release = interfaceC0526Fp3;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1199178586, i10, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
            }
            SurfaceKt.m1850SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1482getLambda1$material3_release, interfaceC0552GpComposableLambda, i10)), composerStartRestartGroup, 12582912 | (i10 & 896) | (i10 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC0526Fp3 = interfaceC0526FpM1482getLambda1$material3_release;
            j3 = contentColor;
            modifier3 = modifier2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$TabRow$3(i, modifier3, containerColor, j3, interfaceC0552GpComposableLambda, interfaceC0526Fp3, interfaceC0526Fp2, i2, i3));
    }
}
