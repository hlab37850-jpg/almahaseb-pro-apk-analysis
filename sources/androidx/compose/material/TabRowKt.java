package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.UiComposable;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import androidx.recyclerview.widget.ItemTouchHelper;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
public final class TabRowKt {
    private static final float ScrollableTabRowMinimumTabWidth = Dp.m5160constructorimpl(90);
    private static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, null);

    /* JADX WARN: Code duplicated, block: B:105:0x0136 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:106:0x0138  */
    /* JADX WARN: Code duplicated, block: B:107:0x013b  */
    /* JADX WARN: Code duplicated, block: B:110:0x0141  */
    /* JADX WARN: Code duplicated, block: B:113:0x0152  */
    /* JADX WARN: Code duplicated, block: B:115:0x015e  */
    /* JADX WARN: Code duplicated, block: B:116:0x0165  */
    /* JADX WARN: Code duplicated, block: B:118:0x0168  */
    /* JADX WARN: Code duplicated, block: B:119:0x0175  */
    /* JADX WARN: Code duplicated, block: B:121:0x0179  */
    /* JADX WARN: Code duplicated, block: B:123:0x0187  */
    /* JADX WARN: Code duplicated, block: B:126:0x0193  */
    /* JADX WARN: Code duplicated, block: B:129:0x01da  */
    /* JADX WARN: Code duplicated, block: B:134:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:136:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARN: Code duplicated, block: B:69:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:79:0x00df  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:93:0x010f  */
    /* JADX WARN: Code duplicated, block: B:95:0x0117  */
    @Composable
    @UiComposable
    /* JADX INFO: renamed from: ScrollableTabRow-sKfQg0A, reason: not valid java name */
    public static final void m1257ScrollableTabRowsKfQg0A(int i, Modifier modifier, long j, long j2, float f, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, Composer composer, int i2, int i3) {
        int i4;
        long primarySurface;
        long jM1069contentColorForek8zF_U;
        int i5;
        float f2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Modifier modifier2;
        float fM1256getScrollableTabRowPaddingD9Ej5fM;
        InterfaceC0552Gp interfaceC0552GpComposableLambda;
        InterfaceC0526Fp interfaceC0526FpM1083getLambda2$material_release;
        int i12;
        InterfaceC0552Gp interfaceC0552Gp2;
        InterfaceC0552Gp interfaceC0552Gp3;
        Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0526Fp2, "tabs");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1473476840);
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
                    primarySurface = j;
                    int i14 = composerStartRestartGroup.changed(primarySurface) ? 256 : 128;
                    i4 |= i14;
                } else {
                    primarySurface = j;
                }
                i4 |= i14;
            } else {
                primarySurface = j;
            }
            if ((i2 & 7168) == 0) {
                if ((i3 & 8) == 0) {
                    jM1069contentColorForek8zF_U = j2;
                    int i15 = composerStartRestartGroup.changed(jM1069contentColorForek8zF_U) ? 2048 : 1024;
                    i4 |= i15;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                i4 |= i15;
            } else {
                jM1069contentColorForek8zF_U = j2;
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
                    if ((29360128 & i2) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
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
                                primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                                i4 &= -7169;
                            }
                            if (i5 != 0) {
                                fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                            } else {
                                fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                            }
                            if (i7 != 0) {
                                interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                            } else {
                                interfaceC0552GpComposableLambda = interfaceC0552Gp;
                            }
                            if (i9 != 0) {
                                interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                            } else {
                                interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                            }
                            InterfaceC0552Gp interfaceC0552Gp4 = interfaceC0552GpComposableLambda;
                            i12 = i4;
                            interfaceC0552Gp2 = interfaceC0552Gp4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                i4 &= -7169;
                            }
                            modifier2 = modifier;
                            interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                            i12 = i4;
                            fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                            interfaceC0552Gp2 = interfaceC0552Gp;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1473476840, i12, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:222)");
                        }
                        SurfaceKt.m1227SurfaceFjzlyU(modifier2, null, primarySurface, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1455860572, true, new TabRowKt$ScrollableTabRow$2(fM1256getScrollableTabRowPaddingD9Ej5fM, interfaceC0526Fp2, interfaceC0526FpM1083getLambda2$material_release, i, interfaceC0552Gp2, i12)), composerStartRestartGroup, ((i12 >> 3) & 14) | 1572864 | (i12 & 896) | (i12 & 7168), 50);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0552Gp3 = interfaceC0552Gp2;
                        f2 = fM1256getScrollableTabRowPaddingD9Ej5fM;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier;
                        interfaceC0552Gp3 = interfaceC0552Gp;
                        interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$ScrollableTabRow$3(i, modifier3, primarySurface, jM1069contentColorForek8zF_U, f2, interfaceC0552Gp3, interfaceC0526FpM1083getLambda2$material_release, interfaceC0526Fp2, i2, i3));
                }
                i11 = 12582912;
                i4 |= i11;
                if ((23967451 & i4) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                        } else {
                            fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                        }
                        if (i7 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                        } else {
                            interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                        }
                        InterfaceC0552Gp interfaceC0552Gp5 = interfaceC0552GpComposableLambda;
                        i12 = i4;
                        interfaceC0552Gp2 = interfaceC0552Gp5;
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                        } else {
                            fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                        }
                        if (i7 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                        } else {
                            interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                        }
                        InterfaceC0552Gp interfaceC0552Gp6 = interfaceC0552GpComposableLambda;
                        i12 = i4;
                        interfaceC0552Gp2 = interfaceC0552Gp6;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1473476840, i12, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:222)");
                    }
                    SurfaceKt.m1227SurfaceFjzlyU(modifier2, null, primarySurface, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1455860572, true, new TabRowKt$ScrollableTabRow$2(fM1256getScrollableTabRowPaddingD9Ej5fM, interfaceC0526Fp2, interfaceC0526FpM1083getLambda2$material_release, i, interfaceC0552Gp2, i12)), composerStartRestartGroup, ((i12 >> 3) & 14) | 1572864 | (i12 & 896) | (i12 & 7168), 50);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0552Gp3 = interfaceC0552Gp2;
                    f2 = fM1256getScrollableTabRowPaddingD9Ej5fM;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                        } else {
                            fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                        }
                        if (i7 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                        } else {
                            interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                        }
                        InterfaceC0552Gp interfaceC0552Gp7 = interfaceC0552GpComposableLambda;
                        i12 = i4;
                        interfaceC0552Gp2 = interfaceC0552Gp7;
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                        } else {
                            fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                        }
                        if (i7 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                        } else {
                            interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                        }
                        InterfaceC0552Gp interfaceC0552Gp8 = interfaceC0552GpComposableLambda;
                        i12 = i4;
                        interfaceC0552Gp2 = interfaceC0552Gp8;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1473476840, i12, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:222)");
                    }
                    SurfaceKt.m1227SurfaceFjzlyU(modifier2, null, primarySurface, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1455860572, true, new TabRowKt$ScrollableTabRow$2(fM1256getScrollableTabRowPaddingD9Ej5fM, interfaceC0526Fp2, interfaceC0526FpM1083getLambda2$material_release, i, interfaceC0552Gp2, i12)), composerStartRestartGroup, ((i12 >> 3) & 14) | 1572864 | (i12 & 896) | (i12 & 7168), 50);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0552Gp3 = interfaceC0552Gp2;
                    f2 = fM1256getScrollableTabRowPaddingD9Ej5fM;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$ScrollableTabRow$3(i, modifier3, primarySurface, jM1069contentColorForek8zF_U, f2, interfaceC0552Gp3, interfaceC0526FpM1083getLambda2$material_release, interfaceC0526Fp2, i2, i3));
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
                if ((29360128 & i2) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
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
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                        } else {
                            fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                        }
                        if (i7 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                        } else {
                            interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                        }
                        InterfaceC0552Gp interfaceC0552Gp9 = interfaceC0552GpComposableLambda;
                        i12 = i4;
                        interfaceC0552Gp2 = interfaceC0552Gp9;
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                        } else {
                            fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                        }
                        if (i7 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                        } else {
                            interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                        }
                        InterfaceC0552Gp interfaceC0552Gp10 = interfaceC0552GpComposableLambda;
                        i12 = i4;
                        interfaceC0552Gp2 = interfaceC0552Gp10;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1473476840, i12, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:222)");
                    }
                    SurfaceKt.m1227SurfaceFjzlyU(modifier2, null, primarySurface, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1455860572, true, new TabRowKt$ScrollableTabRow$2(fM1256getScrollableTabRowPaddingD9Ej5fM, interfaceC0526Fp2, interfaceC0526FpM1083getLambda2$material_release, i, interfaceC0552Gp2, i12)), composerStartRestartGroup, ((i12 >> 3) & 14) | 1572864 | (i12 & 896) | (i12 & 7168), 50);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0552Gp3 = interfaceC0552Gp2;
                    f2 = fM1256getScrollableTabRowPaddingD9Ej5fM;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                        } else {
                            fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                        }
                        if (i7 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                        } else {
                            interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                        }
                        InterfaceC0552Gp interfaceC0552Gp11 = interfaceC0552GpComposableLambda;
                        i12 = i4;
                        interfaceC0552Gp2 = interfaceC0552Gp11;
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                        } else {
                            fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                        }
                        if (i7 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                        } else {
                            interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                        }
                        InterfaceC0552Gp interfaceC0552Gp12 = interfaceC0552GpComposableLambda;
                        i12 = i4;
                        interfaceC0552Gp2 = interfaceC0552Gp12;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1473476840, i12, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:222)");
                    }
                    SurfaceKt.m1227SurfaceFjzlyU(modifier2, null, primarySurface, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1455860572, true, new TabRowKt$ScrollableTabRow$2(fM1256getScrollableTabRowPaddingD9Ej5fM, interfaceC0526Fp2, interfaceC0526FpM1083getLambda2$material_release, i, interfaceC0552Gp2, i12)), composerStartRestartGroup, ((i12 >> 3) & 14) | 1572864 | (i12 & 896) | (i12 & 7168), 50);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0552Gp3 = interfaceC0552Gp2;
                    f2 = fM1256getScrollableTabRowPaddingD9Ej5fM;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$ScrollableTabRow$3(i, modifier3, primarySurface, jM1069contentColorForek8zF_U, f2, interfaceC0552Gp3, interfaceC0526FpM1083getLambda2$material_release, interfaceC0526Fp2, i2, i3));
            }
            i11 = 12582912;
            i4 |= i11;
            if ((23967451 & i4) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                    } else {
                        fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                    }
                    if (i7 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                    } else {
                        interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                    }
                    InterfaceC0552Gp interfaceC0552Gp13 = interfaceC0552GpComposableLambda;
                    i12 = i4;
                    interfaceC0552Gp2 = interfaceC0552Gp13;
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                    } else {
                        fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                    }
                    if (i7 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                    } else {
                        interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                    }
                    InterfaceC0552Gp interfaceC0552Gp14 = interfaceC0552GpComposableLambda;
                    i12 = i4;
                    interfaceC0552Gp2 = interfaceC0552Gp14;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1473476840, i12, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:222)");
                }
                SurfaceKt.m1227SurfaceFjzlyU(modifier2, null, primarySurface, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1455860572, true, new TabRowKt$ScrollableTabRow$2(fM1256getScrollableTabRowPaddingD9Ej5fM, interfaceC0526Fp2, interfaceC0526FpM1083getLambda2$material_release, i, interfaceC0552Gp2, i12)), composerStartRestartGroup, ((i12 >> 3) & 14) | 1572864 | (i12 & 896) | (i12 & 7168), 50);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0552Gp3 = interfaceC0552Gp2;
                f2 = fM1256getScrollableTabRowPaddingD9Ej5fM;
                modifier3 = modifier2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                    } else {
                        fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                    }
                    if (i7 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                    } else {
                        interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                    }
                    InterfaceC0552Gp interfaceC0552Gp15 = interfaceC0552GpComposableLambda;
                    i12 = i4;
                    interfaceC0552Gp2 = interfaceC0552Gp15;
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                    } else {
                        fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                    }
                    if (i7 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                    } else {
                        interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                    }
                    InterfaceC0552Gp interfaceC0552Gp16 = interfaceC0552GpComposableLambda;
                    i12 = i4;
                    interfaceC0552Gp2 = interfaceC0552Gp16;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1473476840, i12, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:222)");
                }
                SurfaceKt.m1227SurfaceFjzlyU(modifier2, null, primarySurface, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1455860572, true, new TabRowKt$ScrollableTabRow$2(fM1256getScrollableTabRowPaddingD9Ej5fM, interfaceC0526Fp2, interfaceC0526FpM1083getLambda2$material_release, i, interfaceC0552Gp2, i12)), composerStartRestartGroup, ((i12 >> 3) & 14) | 1572864 | (i12 & 896) | (i12 & 7168), 50);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0552Gp3 = interfaceC0552Gp2;
                f2 = fM1256getScrollableTabRowPaddingD9Ej5fM;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$ScrollableTabRow$3(i, modifier3, primarySurface, jM1069contentColorForek8zF_U, f2, interfaceC0552Gp3, interfaceC0526FpM1083getLambda2$material_release, interfaceC0526Fp2, i2, i3));
        }
        i4 |= 48;
        if ((i2 & 896) == 0) {
            if ((i3 & 4) == 0) {
                primarySurface = j;
                if (composerStartRestartGroup.changed(primarySurface)) {
                }
                i4 |= i14;
            } else {
                primarySurface = j;
            }
            i4 |= i14;
        } else {
            primarySurface = j;
        }
        if ((i2 & 7168) == 0) {
            if ((i3 & 8) == 0) {
                jM1069contentColorForek8zF_U = j2;
                if (composerStartRestartGroup.changed(jM1069contentColorForek8zF_U)) {
                }
                i4 |= i15;
            } else {
                jM1069contentColorForek8zF_U = j2;
            }
            i4 |= i15;
        } else {
            jM1069contentColorForek8zF_U = j2;
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
                if ((29360128 & i2) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
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
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                        } else {
                            fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                        }
                        if (i7 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                        } else {
                            interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                        }
                        InterfaceC0552Gp interfaceC0552Gp17 = interfaceC0552GpComposableLambda;
                        i12 = i4;
                        interfaceC0552Gp2 = interfaceC0552Gp17;
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                        } else {
                            fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                        }
                        if (i7 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                        } else {
                            interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                        }
                        InterfaceC0552Gp interfaceC0552Gp18 = interfaceC0552GpComposableLambda;
                        i12 = i4;
                        interfaceC0552Gp2 = interfaceC0552Gp18;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1473476840, i12, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:222)");
                    }
                    SurfaceKt.m1227SurfaceFjzlyU(modifier2, null, primarySurface, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1455860572, true, new TabRowKt$ScrollableTabRow$2(fM1256getScrollableTabRowPaddingD9Ej5fM, interfaceC0526Fp2, interfaceC0526FpM1083getLambda2$material_release, i, interfaceC0552Gp2, i12)), composerStartRestartGroup, ((i12 >> 3) & 14) | 1572864 | (i12 & 896) | (i12 & 7168), 50);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0552Gp3 = interfaceC0552Gp2;
                    f2 = fM1256getScrollableTabRowPaddingD9Ej5fM;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                        } else {
                            fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                        }
                        if (i7 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                        } else {
                            interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                        }
                        InterfaceC0552Gp interfaceC0552Gp19 = interfaceC0552GpComposableLambda;
                        i12 = i4;
                        interfaceC0552Gp2 = interfaceC0552Gp19;
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                        } else {
                            fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                        }
                        if (i7 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp;
                        }
                        if (i9 != 0) {
                            interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                        } else {
                            interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                        }
                        InterfaceC0552Gp interfaceC0552Gp110 = interfaceC0552GpComposableLambda;
                        i12 = i4;
                        interfaceC0552Gp2 = interfaceC0552Gp110;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1473476840, i12, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:222)");
                    }
                    SurfaceKt.m1227SurfaceFjzlyU(modifier2, null, primarySurface, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1455860572, true, new TabRowKt$ScrollableTabRow$2(fM1256getScrollableTabRowPaddingD9Ej5fM, interfaceC0526Fp2, interfaceC0526FpM1083getLambda2$material_release, i, interfaceC0552Gp2, i12)), composerStartRestartGroup, ((i12 >> 3) & 14) | 1572864 | (i12 & 896) | (i12 & 7168), 50);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0552Gp3 = interfaceC0552Gp2;
                    f2 = fM1256getScrollableTabRowPaddingD9Ej5fM;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$ScrollableTabRow$3(i, modifier3, primarySurface, jM1069contentColorForek8zF_U, f2, interfaceC0552Gp3, interfaceC0526FpM1083getLambda2$material_release, interfaceC0526Fp2, i2, i3));
            }
            i11 = 12582912;
            i4 |= i11;
            if ((23967451 & i4) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                    } else {
                        fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                    }
                    if (i7 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                    } else {
                        interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                    }
                    InterfaceC0552Gp interfaceC0552Gp111 = interfaceC0552GpComposableLambda;
                    i12 = i4;
                    interfaceC0552Gp2 = interfaceC0552Gp111;
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                    } else {
                        fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                    }
                    if (i7 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                    } else {
                        interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                    }
                    InterfaceC0552Gp interfaceC0552Gp112 = interfaceC0552GpComposableLambda;
                    i12 = i4;
                    interfaceC0552Gp2 = interfaceC0552Gp112;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1473476840, i12, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:222)");
                }
                SurfaceKt.m1227SurfaceFjzlyU(modifier2, null, primarySurface, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1455860572, true, new TabRowKt$ScrollableTabRow$2(fM1256getScrollableTabRowPaddingD9Ej5fM, interfaceC0526Fp2, interfaceC0526FpM1083getLambda2$material_release, i, interfaceC0552Gp2, i12)), composerStartRestartGroup, ((i12 >> 3) & 14) | 1572864 | (i12 & 896) | (i12 & 7168), 50);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0552Gp3 = interfaceC0552Gp2;
                f2 = fM1256getScrollableTabRowPaddingD9Ej5fM;
                modifier3 = modifier2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                    } else {
                        fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                    }
                    if (i7 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                    } else {
                        interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                    }
                    InterfaceC0552Gp interfaceC0552Gp113 = interfaceC0552GpComposableLambda;
                    i12 = i4;
                    interfaceC0552Gp2 = interfaceC0552Gp113;
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                    } else {
                        fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                    }
                    if (i7 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                    } else {
                        interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                    }
                    InterfaceC0552Gp interfaceC0552Gp114 = interfaceC0552GpComposableLambda;
                    i12 = i4;
                    interfaceC0552Gp2 = interfaceC0552Gp114;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1473476840, i12, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:222)");
                }
                SurfaceKt.m1227SurfaceFjzlyU(modifier2, null, primarySurface, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1455860572, true, new TabRowKt$ScrollableTabRow$2(fM1256getScrollableTabRowPaddingD9Ej5fM, interfaceC0526Fp2, interfaceC0526FpM1083getLambda2$material_release, i, interfaceC0552Gp2, i12)), composerStartRestartGroup, ((i12 >> 3) & 14) | 1572864 | (i12 & 896) | (i12 & 7168), 50);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0552Gp3 = interfaceC0552Gp2;
                f2 = fM1256getScrollableTabRowPaddingD9Ej5fM;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$ScrollableTabRow$3(i, modifier3, primarySurface, jM1069contentColorForek8zF_U, f2, interfaceC0552Gp3, interfaceC0526FpM1083getLambda2$material_release, interfaceC0526Fp2, i2, i3));
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
            if ((29360128 & i2) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
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
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                    } else {
                        fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                    }
                    if (i7 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                    } else {
                        interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                    }
                    InterfaceC0552Gp interfaceC0552Gp115 = interfaceC0552GpComposableLambda;
                    i12 = i4;
                    interfaceC0552Gp2 = interfaceC0552Gp115;
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                    } else {
                        fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                    }
                    if (i7 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                    } else {
                        interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                    }
                    InterfaceC0552Gp interfaceC0552Gp116 = interfaceC0552GpComposableLambda;
                    i12 = i4;
                    interfaceC0552Gp2 = interfaceC0552Gp116;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1473476840, i12, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:222)");
                }
                SurfaceKt.m1227SurfaceFjzlyU(modifier2, null, primarySurface, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1455860572, true, new TabRowKt$ScrollableTabRow$2(fM1256getScrollableTabRowPaddingD9Ej5fM, interfaceC0526Fp2, interfaceC0526FpM1083getLambda2$material_release, i, interfaceC0552Gp2, i12)), composerStartRestartGroup, ((i12 >> 3) & 14) | 1572864 | (i12 & 896) | (i12 & 7168), 50);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0552Gp3 = interfaceC0552Gp2;
                f2 = fM1256getScrollableTabRowPaddingD9Ej5fM;
                modifier3 = modifier2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                    } else {
                        fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                    }
                    if (i7 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                    } else {
                        interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                    }
                    InterfaceC0552Gp interfaceC0552Gp117 = interfaceC0552GpComposableLambda;
                    i12 = i4;
                    interfaceC0552Gp2 = interfaceC0552Gp117;
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                    } else {
                        fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                    }
                    if (i7 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp;
                    }
                    if (i9 != 0) {
                        interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                    } else {
                        interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                    }
                    InterfaceC0552Gp interfaceC0552Gp118 = interfaceC0552GpComposableLambda;
                    i12 = i4;
                    interfaceC0552Gp2 = interfaceC0552Gp118;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1473476840, i12, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:222)");
                }
                SurfaceKt.m1227SurfaceFjzlyU(modifier2, null, primarySurface, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1455860572, true, new TabRowKt$ScrollableTabRow$2(fM1256getScrollableTabRowPaddingD9Ej5fM, interfaceC0526Fp2, interfaceC0526FpM1083getLambda2$material_release, i, interfaceC0552Gp2, i12)), composerStartRestartGroup, ((i12 >> 3) & 14) | 1572864 | (i12 & 896) | (i12 & 7168), 50);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0552Gp3 = interfaceC0552Gp2;
                f2 = fM1256getScrollableTabRowPaddingD9Ej5fM;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$ScrollableTabRow$3(i, modifier3, primarySurface, jM1069contentColorForek8zF_U, f2, interfaceC0552Gp3, interfaceC0526FpM1083getLambda2$material_release, interfaceC0526Fp2, i2, i3));
        }
        i11 = 12582912;
        i4 |= i11;
        if ((23967451 & i4) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i3 & 4) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                    i4 &= -7169;
                }
                if (i5 != 0) {
                    fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                } else {
                    fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                }
                if (i7 != 0) {
                    interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                } else {
                    interfaceC0552GpComposableLambda = interfaceC0552Gp;
                }
                if (i9 != 0) {
                    interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                } else {
                    interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                }
                InterfaceC0552Gp interfaceC0552Gp119 = interfaceC0552GpComposableLambda;
                i12 = i4;
                interfaceC0552Gp2 = interfaceC0552Gp119;
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i3 & 4) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                    i4 &= -7169;
                }
                if (i5 != 0) {
                    fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                } else {
                    fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                }
                if (i7 != 0) {
                    interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                } else {
                    interfaceC0552GpComposableLambda = interfaceC0552Gp;
                }
                if (i9 != 0) {
                    interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                } else {
                    interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                }
                InterfaceC0552Gp interfaceC0552Gp1110 = interfaceC0552GpComposableLambda;
                i12 = i4;
                interfaceC0552Gp2 = interfaceC0552Gp1110;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1473476840, i12, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:222)");
            }
            SurfaceKt.m1227SurfaceFjzlyU(modifier2, null, primarySurface, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1455860572, true, new TabRowKt$ScrollableTabRow$2(fM1256getScrollableTabRowPaddingD9Ej5fM, interfaceC0526Fp2, interfaceC0526FpM1083getLambda2$material_release, i, interfaceC0552Gp2, i12)), composerStartRestartGroup, ((i12 >> 3) & 14) | 1572864 | (i12 & 896) | (i12 & 7168), 50);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC0552Gp3 = interfaceC0552Gp2;
            f2 = fM1256getScrollableTabRowPaddingD9Ej5fM;
            modifier3 = modifier2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i3 & 4) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                    i4 &= -7169;
                }
                if (i5 != 0) {
                    fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                } else {
                    fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                }
                if (i7 != 0) {
                    interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                } else {
                    interfaceC0552GpComposableLambda = interfaceC0552Gp;
                }
                if (i9 != 0) {
                    interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                } else {
                    interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                }
                InterfaceC0552Gp interfaceC0552Gp1111 = interfaceC0552GpComposableLambda;
                i12 = i4;
                interfaceC0552Gp2 = interfaceC0552Gp1111;
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i3 & 4) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                    i4 &= -7169;
                }
                if (i5 != 0) {
                    fM1256getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m1256getScrollableTabRowPaddingD9Ej5fM();
                } else {
                    fM1256getScrollableTabRowPaddingD9Ej5fM = f2;
                }
                if (i7 != 0) {
                    interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new TabRowKt$ScrollableTabRow$1(i));
                } else {
                    interfaceC0552GpComposableLambda = interfaceC0552Gp;
                }
                if (i9 != 0) {
                    interfaceC0526FpM1083getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1083getLambda2$material_release();
                } else {
                    interfaceC0526FpM1083getLambda2$material_release = interfaceC0526Fp;
                }
                InterfaceC0552Gp interfaceC0552Gp1112 = interfaceC0552GpComposableLambda;
                i12 = i4;
                interfaceC0552Gp2 = interfaceC0552Gp1112;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1473476840, i12, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:222)");
            }
            SurfaceKt.m1227SurfaceFjzlyU(modifier2, null, primarySurface, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1455860572, true, new TabRowKt$ScrollableTabRow$2(fM1256getScrollableTabRowPaddingD9Ej5fM, interfaceC0526Fp2, interfaceC0526FpM1083getLambda2$material_release, i, interfaceC0552Gp2, i12)), composerStartRestartGroup, ((i12 >> 3) & 14) | 1572864 | (i12 & 896) | (i12 & 7168), 50);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC0552Gp3 = interfaceC0552Gp2;
            f2 = fM1256getScrollableTabRowPaddingD9Ej5fM;
            modifier3 = modifier2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$ScrollableTabRow$3(i, modifier3, primarySurface, jM1069contentColorForek8zF_U, f2, interfaceC0552Gp3, interfaceC0526FpM1083getLambda2$material_release, interfaceC0526Fp2, i2, i3));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x011c  */
    /* JADX WARN: Code duplicated, block: B:104:0x012d  */
    /* JADX WARN: Code duplicated, block: B:106:0x0139  */
    /* JADX WARN: Code duplicated, block: B:107:0x0146  */
    /* JADX WARN: Code duplicated, block: B:109:0x0149  */
    /* JADX WARN: Code duplicated, block: B:113:0x015b  */
    /* JADX WARN: Code duplicated, block: B:116:0x0193  */
    /* JADX WARN: Code duplicated, block: B:121:0x01a0  */
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
    /* JADX WARN: Code duplicated, block: B:69:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:70:0x00be  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:79:0x00db  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:96:0x0111 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:97:0x0113  */
    /* JADX WARN: Code duplicated, block: B:98:0x0116  */
    @Composable
    @UiComposable
    /* JADX INFO: renamed from: TabRow-pAZo6Ak, reason: not valid java name */
    public static final void m1258TabRowpAZo6Ak(int i, Modifier modifier, long j, long j2, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, Composer composer, int i2, int i3) {
        int i4;
        long primarySurface;
        long jM1069contentColorForek8zF_U;
        int i5;
        InterfaceC0552Gp interfaceC0552Gp2;
        int i6;
        int i7;
        InterfaceC0526Fp interfaceC0526FpM1082getLambda1$material_release;
        int i8;
        int i9;
        Modifier modifier2;
        InterfaceC0552Gp interfaceC0552GpComposableLambda;
        InterfaceC0552Gp interfaceC0552Gp3;
        int i10;
        Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        AbstractC4492zt.h(interfaceC0526Fp2, "tabs");
        Composer composerStartRestartGroup = composer.startRestartGroup(-249175289);
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
                    primarySurface = j;
                    int i13 = composerStartRestartGroup.changed(primarySurface) ? 256 : 128;
                    i4 |= i13;
                } else {
                    primarySurface = j;
                }
                i4 |= i13;
            } else {
                primarySurface = j;
            }
            if ((i2 & 7168) == 0) {
                jM1069contentColorForek8zF_U = j2;
                if ((i3 & 8) == 0 || !composerStartRestartGroup.changed(jM1069contentColorForek8zF_U)) {
                    i11 = 1024;
                } else {
                    i11 = 2048;
                }
                i4 |= i11;
            } else {
                jM1069contentColorForek8zF_U = j2;
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
                        interfaceC0526FpM1082getLambda1$material_release = interfaceC0526Fp;
                        if (composerStartRestartGroup.changedInstance(interfaceC0526FpM1082getLambda1$material_release)) {
                            i8 = 131072;
                        } else {
                            i8 = 65536;
                        }
                        i4 |= i8;
                    }
                    if ((i3 & 64) != 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i4 |= i9;
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
                                primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                                i4 &= -7169;
                            }
                            if (i5 != 0) {
                                interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                            } else {
                                interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                            }
                            interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                i4 &= -7169;
                            }
                            modifier2 = modifier;
                            interfaceC0552Gp3 = interfaceC0552Gp2;
                        }
                        long j3 = jM1069contentColorForek8zF_U;
                        i10 = i4;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-249175289, i10, -1, "androidx.compose.material.TabRow (TabRow.kt:128)");
                        }
                        InterfaceC0526Fp interfaceC0526Fp3 = interfaceC0526FpM1082getLambda1$material_release;
                        SurfaceKt.m1227SurfaceFjzlyU(SelectableGroupKt.selectableGroup(modifier2), null, primarySurface, j3, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1961746365, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1082getLambda1$material_release, interfaceC0552Gp3, i10)), composerStartRestartGroup, (i10 & 896) | 1572864 | (i10 & 7168), 50);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        jM1069contentColorForek8zF_U = j3;
                        interfaceC0526FpM1082getLambda1$material_release = interfaceC0526Fp3;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier;
                        interfaceC0552Gp3 = interfaceC0552Gp2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$TabRow$3(i, modifier3, primarySurface, jM1069contentColorForek8zF_U, interfaceC0552Gp3, interfaceC0526FpM1082getLambda1$material_release, interfaceC0526Fp2, i2, i3));
                }
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                interfaceC0526FpM1082getLambda1$material_release = interfaceC0526Fp;
                if ((i3 & 64) != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i4 |= i9;
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
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                        }
                        interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                        }
                        interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
                    }
                    long j4 = jM1069contentColorForek8zF_U;
                    i10 = i4;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-249175289, i10, -1, "androidx.compose.material.TabRow (TabRow.kt:128)");
                    }
                    InterfaceC0526Fp interfaceC0526Fp4 = interfaceC0526FpM1082getLambda1$material_release;
                    SurfaceKt.m1227SurfaceFjzlyU(SelectableGroupKt.selectableGroup(modifier2), null, primarySurface, j4, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1961746365, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1082getLambda1$material_release, interfaceC0552Gp3, i10)), composerStartRestartGroup, (i10 & 896) | 1572864 | (i10 & 7168), 50);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    jM1069contentColorForek8zF_U = j4;
                    interfaceC0526FpM1082getLambda1$material_release = interfaceC0526Fp4;
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
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                        }
                        interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                        }
                        interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
                    }
                    long j5 = jM1069contentColorForek8zF_U;
                    i10 = i4;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-249175289, i10, -1, "androidx.compose.material.TabRow (TabRow.kt:128)");
                    }
                    InterfaceC0526Fp interfaceC0526Fp5 = interfaceC0526FpM1082getLambda1$material_release;
                    SurfaceKt.m1227SurfaceFjzlyU(SelectableGroupKt.selectableGroup(modifier2), null, primarySurface, j5, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1961746365, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1082getLambda1$material_release, interfaceC0552Gp3, i10)), composerStartRestartGroup, (i10 & 896) | 1572864 | (i10 & 7168), 50);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    jM1069contentColorForek8zF_U = j5;
                    interfaceC0526FpM1082getLambda1$material_release = interfaceC0526Fp5;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$TabRow$3(i, modifier3, primarySurface, jM1069contentColorForek8zF_U, interfaceC0552Gp3, interfaceC0526FpM1082getLambda1$material_release, interfaceC0526Fp2, i2, i3));
            }
            i4 |= 24576;
            interfaceC0552Gp2 = interfaceC0552Gp;
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((458752 & i2) == 0) {
                    interfaceC0526FpM1082getLambda1$material_release = interfaceC0526Fp;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526FpM1082getLambda1$material_release)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i4 |= i8;
                }
                if ((i3 & 64) != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i4 |= i9;
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
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                        }
                        interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                        }
                        interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
                    }
                    long j6 = jM1069contentColorForek8zF_U;
                    i10 = i4;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-249175289, i10, -1, "androidx.compose.material.TabRow (TabRow.kt:128)");
                    }
                    InterfaceC0526Fp interfaceC0526Fp6 = interfaceC0526FpM1082getLambda1$material_release;
                    SurfaceKt.m1227SurfaceFjzlyU(SelectableGroupKt.selectableGroup(modifier2), null, primarySurface, j6, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1961746365, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1082getLambda1$material_release, interfaceC0552Gp3, i10)), composerStartRestartGroup, (i10 & 896) | 1572864 | (i10 & 7168), 50);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    jM1069contentColorForek8zF_U = j6;
                    interfaceC0526FpM1082getLambda1$material_release = interfaceC0526Fp6;
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
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                        }
                        interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                        }
                        interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
                    }
                    long j7 = jM1069contentColorForek8zF_U;
                    i10 = i4;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-249175289, i10, -1, "androidx.compose.material.TabRow (TabRow.kt:128)");
                    }
                    InterfaceC0526Fp interfaceC0526Fp7 = interfaceC0526FpM1082getLambda1$material_release;
                    SurfaceKt.m1227SurfaceFjzlyU(SelectableGroupKt.selectableGroup(modifier2), null, primarySurface, j7, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1961746365, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1082getLambda1$material_release, interfaceC0552Gp3, i10)), composerStartRestartGroup, (i10 & 896) | 1572864 | (i10 & 7168), 50);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    jM1069contentColorForek8zF_U = j7;
                    interfaceC0526FpM1082getLambda1$material_release = interfaceC0526Fp7;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$TabRow$3(i, modifier3, primarySurface, jM1069contentColorForek8zF_U, interfaceC0552Gp3, interfaceC0526FpM1082getLambda1$material_release, interfaceC0526Fp2, i2, i3));
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            interfaceC0526FpM1082getLambda1$material_release = interfaceC0526Fp;
            if ((i3 & 64) != 0) {
                i4 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i4 |= i9;
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
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                    }
                    interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                    }
                    interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
                }
                long j8 = jM1069contentColorForek8zF_U;
                i10 = i4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-249175289, i10, -1, "androidx.compose.material.TabRow (TabRow.kt:128)");
                }
                InterfaceC0526Fp interfaceC0526Fp8 = interfaceC0526FpM1082getLambda1$material_release;
                SurfaceKt.m1227SurfaceFjzlyU(SelectableGroupKt.selectableGroup(modifier2), null, primarySurface, j8, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1961746365, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1082getLambda1$material_release, interfaceC0552Gp3, i10)), composerStartRestartGroup, (i10 & 896) | 1572864 | (i10 & 7168), 50);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                jM1069contentColorForek8zF_U = j8;
                interfaceC0526FpM1082getLambda1$material_release = interfaceC0526Fp8;
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
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                    }
                    interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                    }
                    interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
                }
                long j9 = jM1069contentColorForek8zF_U;
                i10 = i4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-249175289, i10, -1, "androidx.compose.material.TabRow (TabRow.kt:128)");
                }
                InterfaceC0526Fp interfaceC0526Fp9 = interfaceC0526FpM1082getLambda1$material_release;
                SurfaceKt.m1227SurfaceFjzlyU(SelectableGroupKt.selectableGroup(modifier2), null, primarySurface, j9, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1961746365, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1082getLambda1$material_release, interfaceC0552Gp3, i10)), composerStartRestartGroup, (i10 & 896) | 1572864 | (i10 & 7168), 50);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                jM1069contentColorForek8zF_U = j9;
                interfaceC0526FpM1082getLambda1$material_release = interfaceC0526Fp9;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$TabRow$3(i, modifier3, primarySurface, jM1069contentColorForek8zF_U, interfaceC0552Gp3, interfaceC0526FpM1082getLambda1$material_release, interfaceC0526Fp2, i2, i3));
        }
        i4 |= 48;
        if ((i2 & 896) == 0) {
            if ((i3 & 4) == 0) {
                primarySurface = j;
                if (composerStartRestartGroup.changed(primarySurface)) {
                }
                i4 |= i13;
            } else {
                primarySurface = j;
            }
            i4 |= i13;
        } else {
            primarySurface = j;
        }
        if ((i2 & 7168) == 0) {
            jM1069contentColorForek8zF_U = j2;
            if ((i3 & 8) == 0) {
                i11 = 1024;
            } else {
                i11 = 1024;
            }
            i4 |= i11;
        } else {
            jM1069contentColorForek8zF_U = j2;
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
                    interfaceC0526FpM1082getLambda1$material_release = interfaceC0526Fp;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526FpM1082getLambda1$material_release)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i4 |= i8;
                }
                if ((i3 & 64) != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i4 |= i9;
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
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                        }
                        interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                        }
                        interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
                    }
                    long j10 = jM1069contentColorForek8zF_U;
                    i10 = i4;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-249175289, i10, -1, "androidx.compose.material.TabRow (TabRow.kt:128)");
                    }
                    InterfaceC0526Fp interfaceC0526Fp10 = interfaceC0526FpM1082getLambda1$material_release;
                    SurfaceKt.m1227SurfaceFjzlyU(SelectableGroupKt.selectableGroup(modifier2), null, primarySurface, j10, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1961746365, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1082getLambda1$material_release, interfaceC0552Gp3, i10)), composerStartRestartGroup, (i10 & 896) | 1572864 | (i10 & 7168), 50);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    jM1069contentColorForek8zF_U = j10;
                    interfaceC0526FpM1082getLambda1$material_release = interfaceC0526Fp10;
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
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                        }
                        interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                        } else {
                            interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                        }
                        interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
                    }
                    long j11 = jM1069contentColorForek8zF_U;
                    i10 = i4;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-249175289, i10, -1, "androidx.compose.material.TabRow (TabRow.kt:128)");
                    }
                    InterfaceC0526Fp interfaceC0526Fp11 = interfaceC0526FpM1082getLambda1$material_release;
                    SurfaceKt.m1227SurfaceFjzlyU(SelectableGroupKt.selectableGroup(modifier2), null, primarySurface, j11, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1961746365, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1082getLambda1$material_release, interfaceC0552Gp3, i10)), composerStartRestartGroup, (i10 & 896) | 1572864 | (i10 & 7168), 50);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    jM1069contentColorForek8zF_U = j11;
                    interfaceC0526FpM1082getLambda1$material_release = interfaceC0526Fp11;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$TabRow$3(i, modifier3, primarySurface, jM1069contentColorForek8zF_U, interfaceC0552Gp3, interfaceC0526FpM1082getLambda1$material_release, interfaceC0526Fp2, i2, i3));
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            interfaceC0526FpM1082getLambda1$material_release = interfaceC0526Fp;
            if ((i3 & 64) != 0) {
                i4 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i4 |= i9;
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
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                    }
                    interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                    }
                    interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
                }
                long j12 = jM1069contentColorForek8zF_U;
                i10 = i4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-249175289, i10, -1, "androidx.compose.material.TabRow (TabRow.kt:128)");
                }
                InterfaceC0526Fp interfaceC0526Fp12 = interfaceC0526FpM1082getLambda1$material_release;
                SurfaceKt.m1227SurfaceFjzlyU(SelectableGroupKt.selectableGroup(modifier2), null, primarySurface, j12, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1961746365, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1082getLambda1$material_release, interfaceC0552Gp3, i10)), composerStartRestartGroup, (i10 & 896) | 1572864 | (i10 & 7168), 50);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                jM1069contentColorForek8zF_U = j12;
                interfaceC0526FpM1082getLambda1$material_release = interfaceC0526Fp12;
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
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                    }
                    interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                    }
                    interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
                }
                long j13 = jM1069contentColorForek8zF_U;
                i10 = i4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-249175289, i10, -1, "androidx.compose.material.TabRow (TabRow.kt:128)");
                }
                InterfaceC0526Fp interfaceC0526Fp13 = interfaceC0526FpM1082getLambda1$material_release;
                SurfaceKt.m1227SurfaceFjzlyU(SelectableGroupKt.selectableGroup(modifier2), null, primarySurface, j13, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1961746365, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1082getLambda1$material_release, interfaceC0552Gp3, i10)), composerStartRestartGroup, (i10 & 896) | 1572864 | (i10 & 7168), 50);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                jM1069contentColorForek8zF_U = j13;
                interfaceC0526FpM1082getLambda1$material_release = interfaceC0526Fp13;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$TabRow$3(i, modifier3, primarySurface, jM1069contentColorForek8zF_U, interfaceC0552Gp3, interfaceC0526FpM1082getLambda1$material_release, interfaceC0526Fp2, i2, i3));
        }
        i4 |= 24576;
        interfaceC0552Gp2 = interfaceC0552Gp;
        i7 = i3 & 32;
        if (i7 != 0) {
            if ((458752 & i2) == 0) {
                interfaceC0526FpM1082getLambda1$material_release = interfaceC0526Fp;
                if (composerStartRestartGroup.changedInstance(interfaceC0526FpM1082getLambda1$material_release)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i4 |= i8;
            }
            if ((i3 & 64) != 0) {
                i4 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i4 |= i9;
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
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                    }
                    interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                    }
                    interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
                }
                long j14 = jM1069contentColorForek8zF_U;
                i10 = i4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-249175289, i10, -1, "androidx.compose.material.TabRow (TabRow.kt:128)");
                }
                InterfaceC0526Fp interfaceC0526Fp14 = interfaceC0526FpM1082getLambda1$material_release;
                SurfaceKt.m1227SurfaceFjzlyU(SelectableGroupKt.selectableGroup(modifier2), null, primarySurface, j14, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1961746365, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1082getLambda1$material_release, interfaceC0552Gp3, i10)), composerStartRestartGroup, (i10 & 896) | 1572864 | (i10 & 7168), 50);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                jM1069contentColorForek8zF_U = j14;
                interfaceC0526FpM1082getLambda1$material_release = interfaceC0526Fp14;
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
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                    }
                    interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                    } else {
                        interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                    }
                    interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
                }
                long j15 = jM1069contentColorForek8zF_U;
                i10 = i4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-249175289, i10, -1, "androidx.compose.material.TabRow (TabRow.kt:128)");
                }
                InterfaceC0526Fp interfaceC0526Fp15 = interfaceC0526FpM1082getLambda1$material_release;
                SurfaceKt.m1227SurfaceFjzlyU(SelectableGroupKt.selectableGroup(modifier2), null, primarySurface, j15, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1961746365, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1082getLambda1$material_release, interfaceC0552Gp3, i10)), composerStartRestartGroup, (i10 & 896) | 1572864 | (i10 & 7168), 50);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                jM1069contentColorForek8zF_U = j15;
                interfaceC0526FpM1082getLambda1$material_release = interfaceC0526Fp15;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$TabRow$3(i, modifier3, primarySurface, jM1069contentColorForek8zF_U, interfaceC0552Gp3, interfaceC0526FpM1082getLambda1$material_release, interfaceC0526Fp2, i2, i3));
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        interfaceC0526FpM1082getLambda1$material_release = interfaceC0526Fp;
        if ((i3 & 64) != 0) {
            i4 |= 1572864;
        } else if ((i2 & 3670016) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                i9 = 1048576;
            } else {
                i9 = 524288;
            }
            i4 |= i9;
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
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                    i4 &= -7169;
                }
                if (i5 != 0) {
                    interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                } else {
                    interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                }
                if (i7 != 0) {
                    interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                }
                interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i3 & 4) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                    i4 &= -7169;
                }
                if (i5 != 0) {
                    interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                } else {
                    interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                }
                if (i7 != 0) {
                    interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                }
                interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
            }
            long j16 = jM1069contentColorForek8zF_U;
            i10 = i4;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-249175289, i10, -1, "androidx.compose.material.TabRow (TabRow.kt:128)");
            }
            InterfaceC0526Fp interfaceC0526Fp16 = interfaceC0526FpM1082getLambda1$material_release;
            SurfaceKt.m1227SurfaceFjzlyU(SelectableGroupKt.selectableGroup(modifier2), null, primarySurface, j16, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1961746365, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1082getLambda1$material_release, interfaceC0552Gp3, i10)), composerStartRestartGroup, (i10 & 896) | 1572864 | (i10 & 7168), 50);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            jM1069contentColorForek8zF_U = j16;
            interfaceC0526FpM1082getLambda1$material_release = interfaceC0526Fp16;
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
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                    i4 &= -7169;
                }
                if (i5 != 0) {
                    interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                } else {
                    interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                }
                if (i7 != 0) {
                    interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                }
                interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i3 & 4) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                    i4 &= -7169;
                }
                if (i5 != 0) {
                    interfaceC0552GpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new TabRowKt$TabRow$1(i));
                } else {
                    interfaceC0552GpComposableLambda = interfaceC0552Gp2;
                }
                if (i7 != 0) {
                    interfaceC0526FpM1082getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1082getLambda1$material_release();
                }
                interfaceC0552Gp3 = interfaceC0552GpComposableLambda;
            }
            long j17 = jM1069contentColorForek8zF_U;
            i10 = i4;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-249175289, i10, -1, "androidx.compose.material.TabRow (TabRow.kt:128)");
            }
            InterfaceC0526Fp interfaceC0526Fp17 = interfaceC0526FpM1082getLambda1$material_release;
            SurfaceKt.m1227SurfaceFjzlyU(SelectableGroupKt.selectableGroup(modifier2), null, primarySurface, j17, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1961746365, true, new TabRowKt$TabRow$2(interfaceC0526Fp2, interfaceC0526FpM1082getLambda1$material_release, interfaceC0552Gp3, i10)), composerStartRestartGroup, (i10 & 896) | 1572864 | (i10 & 7168), 50);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            jM1069contentColorForek8zF_U = j17;
            interfaceC0526FpM1082getLambda1$material_release = interfaceC0526Fp17;
            modifier3 = modifier2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new TabRowKt$TabRow$3(i, modifier3, primarySurface, jM1069contentColorForek8zF_U, interfaceC0552Gp3, interfaceC0526FpM1082getLambda1$material_release, interfaceC0526Fp2, i2, i3));
    }
}
