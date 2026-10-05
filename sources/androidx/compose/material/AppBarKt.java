package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;
import defpackage.HV;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
public final class AppBarKt {
    private static final float AppBarHeight = Dp.m5160constructorimpl(56);
    private static final float AppBarHorizontalPadding;
    private static final float BottomAppBarCutoutOffset;
    private static final float BottomAppBarRoundedEdgeRadius;
    private static final Modifier TitleIconModifier;
    private static final Modifier TitleInsetWithoutIcon;

    static {
        float f = 4;
        float fM5160constructorimpl = Dp.m5160constructorimpl(f);
        AppBarHorizontalPadding = fM5160constructorimpl;
        Modifier.Companion companion = Modifier.Companion;
        TitleInsetWithoutIcon = SizeKt.m537width3ABfNKs(companion, Dp.m5160constructorimpl(Dp.m5160constructorimpl(16) - fM5160constructorimpl));
        TitleIconModifier = SizeKt.m537width3ABfNKs(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null), Dp.m5160constructorimpl(Dp.m5160constructorimpl(72) - fM5160constructorimpl));
        BottomAppBarCutoutOffset = Dp.m5160constructorimpl(8);
        BottomAppBarRoundedEdgeRadius = Dp.m5160constructorimpl(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:36:0x0067  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0074  */
    /* JADX WARN: Code duplicated, block: B:42:0x0077  */
    /* JADX WARN: Code duplicated, block: B:46:0x007e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0083  */
    /* JADX WARN: Code duplicated, block: B:49:0x008b  */
    /* JADX WARN: Code duplicated, block: B:51:0x0091  */
    /* JADX WARN: Code duplicated, block: B:52:0x0094  */
    /* JADX WARN: Code duplicated, block: B:56:0x009d  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:62:0x00af  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:68:0x00be  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:89:0x013a  */
    /* JADX WARN: Code duplicated, block: B:93:0x0144  */
    /* JADX WARN: Code duplicated, block: B:95:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: AppBar-celAv9A, reason: not valid java name */
    public static final void m977AppBarcelAv9A(long j, long j2, float f, PaddingValues paddingValues, Shape shape, Modifier modifier, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        Modifier modifier2;
        int i7;
        int i8;
        Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1249680788);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(j2) ? 32 : 16;
        }
        if ((i2 & 4) == 0) {
            if ((i & 896) == 0) {
                i3 |= composerStartRestartGroup.changed(f) ? 256 : 128;
            }
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i4 = 2048;
                } else {
                    i4 = 1024;
                }
                i3 |= i4;
            }
            if ((i2 & 16) != 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                if (composerStartRestartGroup.changed(shape)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((i & 458752) == 0) {
                    modifier2 = modifier;
                    if (composerStartRestartGroup.changed(modifier2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((3670016 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i3 |= i8;
                }
                if ((2995931 & i3) == 599186 || !composerStartRestartGroup.getSkipping()) {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1249680788, i3, -1, "androidx.compose.material.AppBar (AppBar.kt:504)");
                    }
                    int i9 = i3 << 6;
                    SurfaceKt.m1227SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new AppBarKt$AppBar$1(paddingValues, interfaceC0552Gp, i3)), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i9 & 896) | (i9 & 7168) | ((i3 << 9) & 458752), 16);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$AppBar$2(j, j2, f, paddingValues, shape, modifier3, interfaceC0552Gp, i, i2));
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            modifier2 = modifier;
            if ((i2 & 64) != 0) {
                i3 |= 1572864;
            } else if ((3670016 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i3 |= i8;
            }
            if ((2995931 & i3) == 599186) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1249680788, i3, -1, "androidx.compose.material.AppBar (AppBar.kt:504)");
                }
                int i10 = i3 << 6;
                SurfaceKt.m1227SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new AppBarKt$AppBar$1(paddingValues, interfaceC0552Gp, i3)), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i10 & 896) | (i10 & 7168) | ((i3 << 9) & 458752), 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1249680788, i3, -1, "androidx.compose.material.AppBar (AppBar.kt:504)");
                }
                int i11 = i3 << 6;
                SurfaceKt.m1227SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new AppBarKt$AppBar$1(paddingValues, interfaceC0552Gp, i3)), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i11 & 896) | (i11 & 7168) | ((i3 << 9) & 458752), 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$AppBar$2(j, j2, f, paddingValues, shape, modifier3, interfaceC0552Gp, i, i2));
        }
        i3 |= 384;
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            if (composerStartRestartGroup.changed(paddingValues)) {
                i4 = 2048;
            } else {
                i4 = 1024;
            }
            i3 |= i4;
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((57344 & i) == 0) {
            if (composerStartRestartGroup.changed(shape)) {
                i5 = 16384;
            } else {
                i5 = 8192;
            }
            i3 |= i5;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((i & 458752) == 0) {
                modifier2 = modifier;
                if (composerStartRestartGroup.changed(modifier2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((i2 & 64) != 0) {
                i3 |= 1572864;
            } else if ((3670016 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i3 |= i8;
            }
            if ((2995931 & i3) == 599186) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1249680788, i3, -1, "androidx.compose.material.AppBar (AppBar.kt:504)");
                }
                int i12 = i3 << 6;
                SurfaceKt.m1227SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new AppBarKt$AppBar$1(paddingValues, interfaceC0552Gp, i3)), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i12 & 896) | (i12 & 7168) | ((i3 << 9) & 458752), 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1249680788, i3, -1, "androidx.compose.material.AppBar (AppBar.kt:504)");
                }
                int i13 = i3 << 6;
                SurfaceKt.m1227SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new AppBarKt$AppBar$1(paddingValues, interfaceC0552Gp, i3)), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i13 & 896) | (i13 & 7168) | ((i3 << 9) & 458752), 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$AppBar$2(j, j2, f, paddingValues, shape, modifier3, interfaceC0552Gp, i, i2));
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        modifier2 = modifier;
        if ((i2 & 64) != 0) {
            i3 |= 1572864;
        } else if ((3670016 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                i8 = 1048576;
            } else {
                i8 = 524288;
            }
            i3 |= i8;
        }
        if ((2995931 & i3) == 599186) {
            if (i6 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1249680788, i3, -1, "androidx.compose.material.AppBar (AppBar.kt:504)");
            }
            int i14 = i3 << 6;
            SurfaceKt.m1227SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new AppBarKt$AppBar$1(paddingValues, interfaceC0552Gp, i3)), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i14 & 896) | (i14 & 7168) | ((i3 << 9) & 458752), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            if (i6 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1249680788, i3, -1, "androidx.compose.material.AppBar (AppBar.kt:504)");
            }
            int i15 = i3 << 6;
            SurfaceKt.m1227SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new AppBarKt$AppBar$1(paddingValues, interfaceC0552Gp, i3)), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i15 & 896) | (i15 & 7168) | ((i3 << 9) & 458752), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$AppBar$2(j, j2, f, paddingValues, shape, modifier3, interfaceC0552Gp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x012b  */
    /* JADX WARN: Code duplicated, block: B:104:0x013d  */
    /* JADX WARN: Code duplicated, block: B:106:0x014a  */
    /* JADX WARN: Code duplicated, block: B:108:0x014e  */
    /* JADX WARN: Code duplicated, block: B:110:0x0157  */
    /* JADX WARN: Code duplicated, block: B:111:0x0161  */
    /* JADX WARN: Code duplicated, block: B:114:0x016e  */
    /* JADX WARN: Code duplicated, block: B:117:0x0183 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:121:0x0193  */
    /* JADX WARN: Code duplicated, block: B:124:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:129:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:54:0x0098  */
    /* JADX WARN: Code duplicated, block: B:55:0x009b  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:96:0x0120 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:97:0x0122  */
    /* JADX WARN: Code duplicated, block: B:98:0x0125  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: BottomAppBar-Y1yfwus, reason: not valid java name */
    public static final void m978BottomAppBarY1yfwus(Modifier modifier, long j, long j2, Shape shape, float f, PaddingValues paddingValues, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        int i3;
        long primarySurface;
        long j3;
        Shape shape2;
        int i4;
        float fM975getBottomAppBarElevationD9Ej5fM;
        int i5;
        int i6;
        int i7;
        int i8;
        Modifier modifier2;
        PaddingValues contentPadding;
        Modifier modifier3;
        Shape shape3;
        Shape rectangleShape;
        Modifier modifier4;
        Shape shape4;
        float f2;
        long j4;
        long j5;
        PaddingValues paddingValues2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-1651948973);
        int i9 = i2 & 1;
        if (i9 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                primarySurface = j;
                int i10 = composerStartRestartGroup.changed(primarySurface) ? 32 : 16;
                i3 |= i10;
            } else {
                primarySurface = j;
            }
            i3 |= i10;
        } else {
            primarySurface = j;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                j3 = j2;
                int i11 = composerStartRestartGroup.changed(j3) ? 256 : 128;
                i3 |= i11;
            } else {
                j3 = j2;
            }
            i3 |= i11;
        } else {
            j3 = j2;
        }
        int i12 = i2 & 8;
        if (i12 == 0) {
            if ((i & 7168) == 0) {
                shape2 = shape;
                i3 |= composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((57344 & i) == 0) {
                    fM975getBottomAppBarElevationD9Ej5fM = f;
                    if (composerStartRestartGroup.changed(fM975getBottomAppBarElevationD9Ej5fM)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((i2 & 64) != 0) {
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i8 = 1048576;
                        } else {
                            i8 = 524288;
                        }
                    }
                    if ((i3 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                i3 &= -113;
                                primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            }
                            if ((i2 & 4) != 0) {
                                long jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                                i3 &= -897;
                                j3 = jM1069contentColorForek8zF_U;
                            }
                            if (i12 != 0) {
                                shape2 = null;
                            }
                            if (i4 != 0) {
                                fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                            }
                            if (i6 != 0) {
                                modifier3 = modifier2;
                                contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            } else {
                                contentPadding = paddingValues;
                                modifier3 = modifier2;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 2) != 0) {
                                i3 &= -113;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            modifier3 = modifier;
                            contentPadding = paddingValues;
                        }
                        long j6 = primarySurface;
                        long j7 = j3;
                        float f3 = fM975getBottomAppBarElevationD9Ej5fM;
                        shape3 = shape2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1651948973, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:214)");
                        }
                        FabPlacement fabPlacement = (FabPlacement) composerStartRestartGroup.consume(ScaffoldKt.getLocalFabPlacement());
                        if (shape3 == null && fabPlacement != null && fabPlacement.isDocked()) {
                            rectangleShape = new BottomAppBarCutoutShape(shape3, fabPlacement);
                        } else {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        int i13 = i3 >> 6;
                        m977AppBarcelAv9A(j6, j7, f3, contentPadding, rectangleShape, modifier3, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 3) & 126) | (i13 & 896) | (i13 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        shape4 = shape3;
                        f2 = f3;
                        j4 = j6;
                        j5 = j7;
                        paddingValues2 = contentPadding;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier4 = modifier;
                        paddingValues2 = paddingValues;
                        j4 = primarySurface;
                        j5 = j3;
                        shape4 = shape2;
                        f2 = fM975getBottomAppBarElevationD9Ej5fM;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$BottomAppBar$1(modifier4, j4, j5, shape4, f2, paddingValues2, interfaceC0552Gp, i, i2));
                }
                i8 = 1572864;
                i3 |= i8;
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM1069contentColorForek8zF_U2;
                        }
                        if (i12 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            modifier3 = modifier2;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                            modifier3 = modifier2;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U3 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM1069contentColorForek8zF_U3;
                        }
                        if (i12 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            modifier3 = modifier2;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                            modifier3 = modifier2;
                        }
                    }
                    long j8 = primarySurface;
                    long j9 = j3;
                    float f4 = fM975getBottomAppBarElevationD9Ej5fM;
                    shape3 = shape2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1651948973, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:214)");
                    }
                    FabPlacement fabPlacement2 = (FabPlacement) composerStartRestartGroup.consume(ScaffoldKt.getLocalFabPlacement());
                    if (shape3 == null) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    int i14 = i3 >> 6;
                    m977AppBarcelAv9A(j8, j9, f4, contentPadding, rectangleShape, modifier3, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 3) & 126) | (i14 & 896) | (i14 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape4 = shape3;
                    f2 = f4;
                    j4 = j8;
                    j5 = j9;
                    paddingValues2 = contentPadding;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U4 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM1069contentColorForek8zF_U4;
                        }
                        if (i12 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            modifier3 = modifier2;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                            modifier3 = modifier2;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U5 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM1069contentColorForek8zF_U5;
                        }
                        if (i12 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            modifier3 = modifier2;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                            modifier3 = modifier2;
                        }
                    }
                    long j10 = primarySurface;
                    long j11 = j3;
                    float f5 = fM975getBottomAppBarElevationD9Ej5fM;
                    shape3 = shape2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1651948973, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:214)");
                    }
                    FabPlacement fabPlacement3 = (FabPlacement) composerStartRestartGroup.consume(ScaffoldKt.getLocalFabPlacement());
                    if (shape3 == null) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    int i15 = i3 >> 6;
                    m977AppBarcelAv9A(j10, j11, f5, contentPadding, rectangleShape, modifier3, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 3) & 126) | (i15 & 896) | (i15 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape4 = shape3;
                    f2 = f5;
                    j4 = j10;
                    j5 = j11;
                    paddingValues2 = contentPadding;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$BottomAppBar$1(modifier4, j4, j5, shape4, f2, paddingValues2, interfaceC0552Gp, i, i2));
            }
            i3 |= 24576;
            fM975getBottomAppBarElevationD9Ej5fM = f;
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((i2 & 64) != 0) {
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                }
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U6 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM1069contentColorForek8zF_U6;
                        }
                        if (i12 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            modifier3 = modifier2;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                            modifier3 = modifier2;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U7 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM1069contentColorForek8zF_U7;
                        }
                        if (i12 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            modifier3 = modifier2;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                            modifier3 = modifier2;
                        }
                    }
                    long j12 = primarySurface;
                    long j13 = j3;
                    float f6 = fM975getBottomAppBarElevationD9Ej5fM;
                    shape3 = shape2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1651948973, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:214)");
                    }
                    FabPlacement fabPlacement4 = (FabPlacement) composerStartRestartGroup.consume(ScaffoldKt.getLocalFabPlacement());
                    if (shape3 == null) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    int i16 = i3 >> 6;
                    m977AppBarcelAv9A(j12, j13, f6, contentPadding, rectangleShape, modifier3, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 3) & 126) | (i16 & 896) | (i16 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape4 = shape3;
                    f2 = f6;
                    j4 = j12;
                    j5 = j13;
                    paddingValues2 = contentPadding;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U8 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM1069contentColorForek8zF_U8;
                        }
                        if (i12 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            modifier3 = modifier2;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                            modifier3 = modifier2;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U9 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM1069contentColorForek8zF_U9;
                        }
                        if (i12 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            modifier3 = modifier2;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                            modifier3 = modifier2;
                        }
                    }
                    long j14 = primarySurface;
                    long j15 = j3;
                    float f7 = fM975getBottomAppBarElevationD9Ej5fM;
                    shape3 = shape2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1651948973, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:214)");
                    }
                    FabPlacement fabPlacement5 = (FabPlacement) composerStartRestartGroup.consume(ScaffoldKt.getLocalFabPlacement());
                    if (shape3 == null) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    int i17 = i3 >> 6;
                    m977AppBarcelAv9A(j14, j15, f7, contentPadding, rectangleShape, modifier3, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 3) & 126) | (i17 & 896) | (i17 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape4 = shape3;
                    f2 = f7;
                    j4 = j14;
                    j5 = j15;
                    paddingValues2 = contentPadding;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$BottomAppBar$1(modifier4, j4, j5, shape4, f2, paddingValues2, interfaceC0552Gp, i, i2));
            }
            i8 = 1572864;
            i3 |= i8;
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U10 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM1069contentColorForek8zF_U10;
                    }
                    if (i12 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier3 = modifier2;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                        modifier3 = modifier2;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U11 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM1069contentColorForek8zF_U11;
                    }
                    if (i12 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier3 = modifier2;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                        modifier3 = modifier2;
                    }
                }
                long j16 = primarySurface;
                long j17 = j3;
                float f8 = fM975getBottomAppBarElevationD9Ej5fM;
                shape3 = shape2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1651948973, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:214)");
                }
                FabPlacement fabPlacement6 = (FabPlacement) composerStartRestartGroup.consume(ScaffoldKt.getLocalFabPlacement());
                if (shape3 == null) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                int i18 = i3 >> 6;
                m977AppBarcelAv9A(j16, j17, f8, contentPadding, rectangleShape, modifier3, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 3) & 126) | (i18 & 896) | (i18 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape4 = shape3;
                f2 = f8;
                j4 = j16;
                j5 = j17;
                paddingValues2 = contentPadding;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U12 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM1069contentColorForek8zF_U12;
                    }
                    if (i12 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier3 = modifier2;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                        modifier3 = modifier2;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U13 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM1069contentColorForek8zF_U13;
                    }
                    if (i12 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier3 = modifier2;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                        modifier3 = modifier2;
                    }
                }
                long j18 = primarySurface;
                long j19 = j3;
                float f9 = fM975getBottomAppBarElevationD9Ej5fM;
                shape3 = shape2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1651948973, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:214)");
                }
                FabPlacement fabPlacement7 = (FabPlacement) composerStartRestartGroup.consume(ScaffoldKt.getLocalFabPlacement());
                if (shape3 == null) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                int i19 = i3 >> 6;
                m977AppBarcelAv9A(j18, j19, f9, contentPadding, rectangleShape, modifier3, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 3) & 126) | (i19 & 896) | (i19 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape4 = shape3;
                f2 = f9;
                j4 = j18;
                j5 = j19;
                paddingValues2 = contentPadding;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$BottomAppBar$1(modifier4, j4, j5, shape4, f2, paddingValues2, interfaceC0552Gp, i, i2));
        }
        i3 |= 3072;
        shape2 = shape;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((57344 & i) == 0) {
                fM975getBottomAppBarElevationD9Ej5fM = f;
                if (composerStartRestartGroup.changed(fM975getBottomAppBarElevationD9Ej5fM)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((i2 & 64) != 0) {
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                }
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U14 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM1069contentColorForek8zF_U14;
                        }
                        if (i12 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            modifier3 = modifier2;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                            modifier3 = modifier2;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U15 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM1069contentColorForek8zF_U15;
                        }
                        if (i12 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            modifier3 = modifier2;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                            modifier3 = modifier2;
                        }
                    }
                    long j110 = primarySurface;
                    long j111 = j3;
                    float f10 = fM975getBottomAppBarElevationD9Ej5fM;
                    shape3 = shape2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1651948973, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:214)");
                    }
                    FabPlacement fabPlacement8 = (FabPlacement) composerStartRestartGroup.consume(ScaffoldKt.getLocalFabPlacement());
                    if (shape3 == null) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    int i110 = i3 >> 6;
                    m977AppBarcelAv9A(j110, j111, f10, contentPadding, rectangleShape, modifier3, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 3) & 126) | (i110 & 896) | (i110 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape4 = shape3;
                    f2 = f10;
                    j4 = j110;
                    j5 = j111;
                    paddingValues2 = contentPadding;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U16 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM1069contentColorForek8zF_U16;
                        }
                        if (i12 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            modifier3 = modifier2;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                            modifier3 = modifier2;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U17 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM1069contentColorForek8zF_U17;
                        }
                        if (i12 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            modifier3 = modifier2;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                            modifier3 = modifier2;
                        }
                    }
                    long j112 = primarySurface;
                    long j113 = j3;
                    float f11 = fM975getBottomAppBarElevationD9Ej5fM;
                    shape3 = shape2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1651948973, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:214)");
                    }
                    FabPlacement fabPlacement9 = (FabPlacement) composerStartRestartGroup.consume(ScaffoldKt.getLocalFabPlacement());
                    if (shape3 == null) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    int i111 = i3 >> 6;
                    m977AppBarcelAv9A(j112, j113, f11, contentPadding, rectangleShape, modifier3, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 3) & 126) | (i111 & 896) | (i111 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape4 = shape3;
                    f2 = f11;
                    j4 = j112;
                    j5 = j113;
                    paddingValues2 = contentPadding;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$BottomAppBar$1(modifier4, j4, j5, shape4, f2, paddingValues2, interfaceC0552Gp, i, i2));
            }
            i8 = 1572864;
            i3 |= i8;
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U18 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM1069contentColorForek8zF_U18;
                    }
                    if (i12 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier3 = modifier2;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                        modifier3 = modifier2;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U19 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM1069contentColorForek8zF_U19;
                    }
                    if (i12 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier3 = modifier2;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                        modifier3 = modifier2;
                    }
                }
                long j114 = primarySurface;
                long j115 = j3;
                float f12 = fM975getBottomAppBarElevationD9Ej5fM;
                shape3 = shape2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1651948973, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:214)");
                }
                FabPlacement fabPlacement10 = (FabPlacement) composerStartRestartGroup.consume(ScaffoldKt.getLocalFabPlacement());
                if (shape3 == null) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                int i112 = i3 >> 6;
                m977AppBarcelAv9A(j114, j115, f12, contentPadding, rectangleShape, modifier3, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 3) & 126) | (i112 & 896) | (i112 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape4 = shape3;
                f2 = f12;
                j4 = j114;
                j5 = j115;
                paddingValues2 = contentPadding;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U110 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM1069contentColorForek8zF_U110;
                    }
                    if (i12 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier3 = modifier2;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                        modifier3 = modifier2;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U111 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM1069contentColorForek8zF_U111;
                    }
                    if (i12 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier3 = modifier2;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                        modifier3 = modifier2;
                    }
                }
                long j116 = primarySurface;
                long j117 = j3;
                float f13 = fM975getBottomAppBarElevationD9Ej5fM;
                shape3 = shape2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1651948973, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:214)");
                }
                FabPlacement fabPlacement11 = (FabPlacement) composerStartRestartGroup.consume(ScaffoldKt.getLocalFabPlacement());
                if (shape3 == null) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                int i113 = i3 >> 6;
                m977AppBarcelAv9A(j116, j117, f13, contentPadding, rectangleShape, modifier3, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 3) & 126) | (i113 & 896) | (i113 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape4 = shape3;
                f2 = f13;
                j4 = j116;
                j5 = j117;
                paddingValues2 = contentPadding;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$BottomAppBar$1(modifier4, j4, j5, shape4, f2, paddingValues2, interfaceC0552Gp, i, i2));
        }
        i3 |= 24576;
        fM975getBottomAppBarElevationD9Ej5fM = f;
        i6 = i2 & 32;
        if (i6 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & 458752) == 0) {
            if (composerStartRestartGroup.changed(paddingValues)) {
                i7 = 131072;
            } else {
                i7 = 65536;
            }
            i3 |= i7;
        }
        if ((i2 & 64) != 0) {
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
            }
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U112 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM1069contentColorForek8zF_U112;
                    }
                    if (i12 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier3 = modifier2;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                        modifier3 = modifier2;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U113 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM1069contentColorForek8zF_U113;
                    }
                    if (i12 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier3 = modifier2;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                        modifier3 = modifier2;
                    }
                }
                long j118 = primarySurface;
                long j119 = j3;
                float f14 = fM975getBottomAppBarElevationD9Ej5fM;
                shape3 = shape2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1651948973, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:214)");
                }
                FabPlacement fabPlacement12 = (FabPlacement) composerStartRestartGroup.consume(ScaffoldKt.getLocalFabPlacement());
                if (shape3 == null) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                int i114 = i3 >> 6;
                m977AppBarcelAv9A(j118, j119, f14, contentPadding, rectangleShape, modifier3, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 3) & 126) | (i114 & 896) | (i114 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape4 = shape3;
                f2 = f14;
                j4 = j118;
                j5 = j119;
                paddingValues2 = contentPadding;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U114 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM1069contentColorForek8zF_U114;
                    }
                    if (i12 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier3 = modifier2;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                        modifier3 = modifier2;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U115 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM1069contentColorForek8zF_U115;
                    }
                    if (i12 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier3 = modifier2;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                        modifier3 = modifier2;
                    }
                }
                long j1110 = primarySurface;
                long j1111 = j3;
                float f15 = fM975getBottomAppBarElevationD9Ej5fM;
                shape3 = shape2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1651948973, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:214)");
                }
                FabPlacement fabPlacement13 = (FabPlacement) composerStartRestartGroup.consume(ScaffoldKt.getLocalFabPlacement());
                if (shape3 == null) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                int i115 = i3 >> 6;
                m977AppBarcelAv9A(j1110, j1111, f15, contentPadding, rectangleShape, modifier3, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 3) & 126) | (i115 & 896) | (i115 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape4 = shape3;
                f2 = f15;
                j4 = j1110;
                j5 = j1111;
                paddingValues2 = contentPadding;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$BottomAppBar$1(modifier4, j4, j5, shape4, f2, paddingValues2, interfaceC0552Gp, i, i2));
        }
        i8 = 1572864;
        i3 |= i8;
        if ((i3 & 2995931) == 599186) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                }
                if ((i2 & 4) != 0) {
                    long jM1069contentColorForek8zF_U116 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                    j3 = jM1069contentColorForek8zF_U116;
                }
                if (i12 != 0) {
                    shape2 = null;
                }
                if (i4 != 0) {
                    fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                }
                if (i6 != 0) {
                    modifier3 = modifier2;
                    contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                } else {
                    contentPadding = paddingValues;
                    modifier3 = modifier2;
                }
            } else {
                if (i9 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                }
                if ((i2 & 4) != 0) {
                    long jM1069contentColorForek8zF_U117 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                    j3 = jM1069contentColorForek8zF_U117;
                }
                if (i12 != 0) {
                    shape2 = null;
                }
                if (i4 != 0) {
                    fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                }
                if (i6 != 0) {
                    modifier3 = modifier2;
                    contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                } else {
                    contentPadding = paddingValues;
                    modifier3 = modifier2;
                }
            }
            long j1112 = primarySurface;
            long j1113 = j3;
            float f16 = fM975getBottomAppBarElevationD9Ej5fM;
            shape3 = shape2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1651948973, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:214)");
            }
            FabPlacement fabPlacement14 = (FabPlacement) composerStartRestartGroup.consume(ScaffoldKt.getLocalFabPlacement());
            if (shape3 == null) {
                rectangleShape = RectangleShapeKt.getRectangleShape();
            } else {
                rectangleShape = RectangleShapeKt.getRectangleShape();
            }
            int i116 = i3 >> 6;
            m977AppBarcelAv9A(j1112, j1113, f16, contentPadding, rectangleShape, modifier3, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 3) & 126) | (i116 & 896) | (i116 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            shape4 = shape3;
            f2 = f16;
            j4 = j1112;
            j5 = j1113;
            paddingValues2 = contentPadding;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                }
                if ((i2 & 4) != 0) {
                    long jM1069contentColorForek8zF_U118 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                    j3 = jM1069contentColorForek8zF_U118;
                }
                if (i12 != 0) {
                    shape2 = null;
                }
                if (i4 != 0) {
                    fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                }
                if (i6 != 0) {
                    modifier3 = modifier2;
                    contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                } else {
                    contentPadding = paddingValues;
                    modifier3 = modifier2;
                }
            } else {
                if (i9 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                }
                if ((i2 & 4) != 0) {
                    long jM1069contentColorForek8zF_U119 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                    j3 = jM1069contentColorForek8zF_U119;
                }
                if (i12 != 0) {
                    shape2 = null;
                }
                if (i4 != 0) {
                    fM975getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m975getBottomAppBarElevationD9Ej5fM();
                }
                if (i6 != 0) {
                    modifier3 = modifier2;
                    contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                } else {
                    contentPadding = paddingValues;
                    modifier3 = modifier2;
                }
            }
            long j1114 = primarySurface;
            long j1115 = j3;
            float f17 = fM975getBottomAppBarElevationD9Ej5fM;
            shape3 = shape2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1651948973, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:214)");
            }
            FabPlacement fabPlacement15 = (FabPlacement) composerStartRestartGroup.consume(ScaffoldKt.getLocalFabPlacement());
            if (shape3 == null) {
                rectangleShape = RectangleShapeKt.getRectangleShape();
            } else {
                rectangleShape = RectangleShapeKt.getRectangleShape();
            }
            int i117 = i3 >> 6;
            m977AppBarcelAv9A(j1114, j1115, f17, contentPadding, rectangleShape, modifier3, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 3) & 126) | (i117 & 896) | (i117 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            shape4 = shape3;
            f2 = f17;
            j4 = j1114;
            j5 = j1115;
            paddingValues2 = contentPadding;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$BottomAppBar$1(modifier4, j4, j5, shape4, f2, paddingValues2, interfaceC0552Gp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x013c  */
    /* JADX WARN: Code duplicated, block: B:103:0x0149  */
    /* JADX WARN: Code duplicated, block: B:106:0x0187  */
    /* JADX WARN: Code duplicated, block: B:111:0x019a  */
    /* JADX WARN: Code duplicated, block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:54:0x0098  */
    /* JADX WARN: Code duplicated, block: B:55:0x009b  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:91:0x0103  */
    /* JADX WARN: Code duplicated, block: B:92:0x0111  */
    /* JADX WARN: Code duplicated, block: B:95:0x0116  */
    /* JADX WARN: Code duplicated, block: B:97:0x0123  */
    /* JADX WARN: Code duplicated, block: B:99:0x012c  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: TopAppBar-HsRjFd4, reason: not valid java name */
    public static final void m979TopAppBarHsRjFd4(Modifier modifier, long j, long j2, float f, PaddingValues paddingValues, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        Modifier modifier2;
        int i3;
        long j3;
        long j4;
        float fM976getTopAppBarElevationD9Ej5fM;
        int i4;
        PaddingValues paddingValues2;
        int i5;
        int i6;
        Modifier modifier3;
        long primarySurface;
        Modifier modifier4;
        long j5;
        PaddingValues contentPadding;
        long j6;
        float f2;
        Modifier modifier5;
        long j7;
        long j8;
        float f3;
        PaddingValues paddingValues3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(1897058582);
        int i7 = i2 & 1;
        if (i7 != 0) {
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
                j3 = j;
                int i8 = composerStartRestartGroup.changed(j3) ? 32 : 16;
                i3 |= i8;
            } else {
                j3 = j;
            }
            i3 |= i8;
        } else {
            j3 = j;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                j4 = j2;
                int i9 = composerStartRestartGroup.changed(j4) ? 256 : 128;
                i3 |= i9;
            } else {
                j4 = j2;
            }
            i3 |= i9;
        } else {
            j4 = j2;
        }
        int i10 = i2 & 8;
        if (i10 == 0) {
            if ((i & 7168) == 0) {
                fM976getTopAppBarElevationD9Ej5fM = f;
                i3 |= composerStartRestartGroup.changed(fM976getTopAppBarElevationD9Ej5fM) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((57344 & i) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                if ((i2 & 32) != 0) {
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i6 = 131072;
                        } else {
                            i6 = 65536;
                        }
                    }
                    if ((374491 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i7 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 2) != 0) {
                                primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                                i3 &= -113;
                            } else {
                                primarySurface = j3;
                            }
                            if ((i2 & 4) != 0) {
                                long jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                                i3 &= -897;
                                j4 = jM1069contentColorForek8zF_U;
                            }
                            if (i10 != 0) {
                                fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                            }
                            if (i4 != 0) {
                                modifier4 = modifier3;
                                j5 = primarySurface;
                                contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                                j6 = j4;
                                f2 = fM976getTopAppBarElevationD9Ej5fM;
                            } else {
                                modifier4 = modifier3;
                                j5 = primarySurface;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1897058582, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:154)");
                            }
                            int i11 = i3 >> 3;
                            m977AppBarcelAv9A(j5, j6, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier4, interfaceC0552Gp, composerStartRestartGroup, (i11 & 7168) | (i11 & 14) | 24576 | (i11 & 112) | (i11 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier5 = modifier4;
                            j7 = j5;
                            j8 = j6;
                            f3 = f2;
                            paddingValues3 = contentPadding;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 2) != 0) {
                                i3 &= -113;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            modifier4 = modifier2;
                            j5 = j3;
                        }
                        j6 = j4;
                        f2 = fM976getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1897058582, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:154)");
                        }
                        int i12 = i3 >> 3;
                        m977AppBarcelAv9A(j5, j6, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier4, interfaceC0552Gp, composerStartRestartGroup, (i12 & 7168) | (i12 & 14) | 24576 | (i12 & 112) | (i12 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        j7 = j5;
                        j8 = j6;
                        f3 = f2;
                        paddingValues3 = contentPadding;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier5 = modifier2;
                        j7 = j3;
                        j8 = j4;
                        f3 = fM976getTopAppBarElevationD9Ej5fM;
                        paddingValues3 = paddingValues2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$TopAppBar$3(modifier5, j7, j8, f3, paddingValues3, interfaceC0552Gp, i, i2));
                }
                i6 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i6;
                if ((374491 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -113;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j4 = jM1069contentColorForek8zF_U2;
                        }
                        if (i10 != 0) {
                            fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            modifier4 = modifier3;
                            j5 = primarySurface;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j6 = j4;
                            f2 = fM976getTopAppBarElevationD9Ej5fM;
                        } else {
                            modifier4 = modifier3;
                            j5 = primarySurface;
                            j6 = j4;
                            f2 = fM976getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -113;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U3 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j4 = jM1069contentColorForek8zF_U3;
                        }
                        if (i10 != 0) {
                            fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            modifier4 = modifier3;
                            j5 = primarySurface;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j6 = j4;
                            f2 = fM976getTopAppBarElevationD9Ej5fM;
                        } else {
                            modifier4 = modifier3;
                            j5 = primarySurface;
                            j6 = j4;
                            f2 = fM976getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1897058582, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:154)");
                    }
                    int i13 = i3 >> 3;
                    m977AppBarcelAv9A(j5, j6, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier4, interfaceC0552Gp, composerStartRestartGroup, (i13 & 7168) | (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    j7 = j5;
                    j8 = j6;
                    f3 = f2;
                    paddingValues3 = contentPadding;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -113;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U4 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j4 = jM1069contentColorForek8zF_U4;
                        }
                        if (i10 != 0) {
                            fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            modifier4 = modifier3;
                            j5 = primarySurface;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j6 = j4;
                            f2 = fM976getTopAppBarElevationD9Ej5fM;
                        } else {
                            modifier4 = modifier3;
                            j5 = primarySurface;
                            j6 = j4;
                            f2 = fM976getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -113;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U5 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j4 = jM1069contentColorForek8zF_U5;
                        }
                        if (i10 != 0) {
                            fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            modifier4 = modifier3;
                            j5 = primarySurface;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j6 = j4;
                            f2 = fM976getTopAppBarElevationD9Ej5fM;
                        } else {
                            modifier4 = modifier3;
                            j5 = primarySurface;
                            j6 = j4;
                            f2 = fM976getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1897058582, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:154)");
                    }
                    int i14 = i3 >> 3;
                    m977AppBarcelAv9A(j5, j6, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier4, interfaceC0552Gp, composerStartRestartGroup, (i14 & 7168) | (i14 & 14) | 24576 | (i14 & 112) | (i14 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    j7 = j5;
                    j8 = j6;
                    f3 = f2;
                    paddingValues3 = contentPadding;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$TopAppBar$3(modifier5, j7, j8, f3, paddingValues3, interfaceC0552Gp, i, i2));
            }
            i3 |= 24576;
            paddingValues2 = paddingValues;
            if ((i2 & 32) != 0) {
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i6 = 131072;
                    } else {
                        i6 = 65536;
                    }
                }
                if ((374491 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -113;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U6 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j4 = jM1069contentColorForek8zF_U6;
                        }
                        if (i10 != 0) {
                            fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            modifier4 = modifier3;
                            j5 = primarySurface;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j6 = j4;
                            f2 = fM976getTopAppBarElevationD9Ej5fM;
                        } else {
                            modifier4 = modifier3;
                            j5 = primarySurface;
                            j6 = j4;
                            f2 = fM976getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -113;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U7 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j4 = jM1069contentColorForek8zF_U7;
                        }
                        if (i10 != 0) {
                            fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            modifier4 = modifier3;
                            j5 = primarySurface;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j6 = j4;
                            f2 = fM976getTopAppBarElevationD9Ej5fM;
                        } else {
                            modifier4 = modifier3;
                            j5 = primarySurface;
                            j6 = j4;
                            f2 = fM976getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1897058582, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:154)");
                    }
                    int i15 = i3 >> 3;
                    m977AppBarcelAv9A(j5, j6, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier4, interfaceC0552Gp, composerStartRestartGroup, (i15 & 7168) | (i15 & 14) | 24576 | (i15 & 112) | (i15 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    j7 = j5;
                    j8 = j6;
                    f3 = f2;
                    paddingValues3 = contentPadding;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -113;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U8 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j4 = jM1069contentColorForek8zF_U8;
                        }
                        if (i10 != 0) {
                            fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            modifier4 = modifier3;
                            j5 = primarySurface;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j6 = j4;
                            f2 = fM976getTopAppBarElevationD9Ej5fM;
                        } else {
                            modifier4 = modifier3;
                            j5 = primarySurface;
                            j6 = j4;
                            f2 = fM976getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -113;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U9 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j4 = jM1069contentColorForek8zF_U9;
                        }
                        if (i10 != 0) {
                            fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            modifier4 = modifier3;
                            j5 = primarySurface;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j6 = j4;
                            f2 = fM976getTopAppBarElevationD9Ej5fM;
                        } else {
                            modifier4 = modifier3;
                            j5 = primarySurface;
                            j6 = j4;
                            f2 = fM976getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1897058582, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:154)");
                    }
                    int i16 = i3 >> 3;
                    m977AppBarcelAv9A(j5, j6, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier4, interfaceC0552Gp, composerStartRestartGroup, (i16 & 7168) | (i16 & 14) | 24576 | (i16 & 112) | (i16 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    j7 = j5;
                    j8 = j6;
                    f3 = f2;
                    paddingValues3 = contentPadding;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$TopAppBar$3(modifier5, j7, j8, f3, paddingValues3, interfaceC0552Gp, i, i2));
            }
            i6 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i6;
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U10 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j4 = jM1069contentColorForek8zF_U10;
                    }
                    if (i10 != 0) {
                        fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        j5 = primarySurface;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j6 = j4;
                        f2 = fM976getTopAppBarElevationD9Ej5fM;
                    } else {
                        modifier4 = modifier3;
                        j5 = primarySurface;
                        j6 = j4;
                        f2 = fM976getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U11 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j4 = jM1069contentColorForek8zF_U11;
                    }
                    if (i10 != 0) {
                        fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        j5 = primarySurface;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j6 = j4;
                        f2 = fM976getTopAppBarElevationD9Ej5fM;
                    } else {
                        modifier4 = modifier3;
                        j5 = primarySurface;
                        j6 = j4;
                        f2 = fM976getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1897058582, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:154)");
                }
                int i17 = i3 >> 3;
                m977AppBarcelAv9A(j5, j6, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier4, interfaceC0552Gp, composerStartRestartGroup, (i17 & 7168) | (i17 & 14) | 24576 | (i17 & 112) | (i17 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                j7 = j5;
                j8 = j6;
                f3 = f2;
                paddingValues3 = contentPadding;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U12 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j4 = jM1069contentColorForek8zF_U12;
                    }
                    if (i10 != 0) {
                        fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        j5 = primarySurface;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j6 = j4;
                        f2 = fM976getTopAppBarElevationD9Ej5fM;
                    } else {
                        modifier4 = modifier3;
                        j5 = primarySurface;
                        j6 = j4;
                        f2 = fM976getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U13 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j4 = jM1069contentColorForek8zF_U13;
                    }
                    if (i10 != 0) {
                        fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        j5 = primarySurface;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j6 = j4;
                        f2 = fM976getTopAppBarElevationD9Ej5fM;
                    } else {
                        modifier4 = modifier3;
                        j5 = primarySurface;
                        j6 = j4;
                        f2 = fM976getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1897058582, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:154)");
                }
                int i18 = i3 >> 3;
                m977AppBarcelAv9A(j5, j6, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier4, interfaceC0552Gp, composerStartRestartGroup, (i18 & 7168) | (i18 & 14) | 24576 | (i18 & 112) | (i18 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                j7 = j5;
                j8 = j6;
                f3 = f2;
                paddingValues3 = contentPadding;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$TopAppBar$3(modifier5, j7, j8, f3, paddingValues3, interfaceC0552Gp, i, i2));
        }
        i3 |= 3072;
        fM976getTopAppBarElevationD9Ej5fM = f;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((57344 & i) == 0) {
                paddingValues2 = paddingValues;
                if (composerStartRestartGroup.changed(paddingValues2)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((i2 & 32) != 0) {
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i6 = 131072;
                    } else {
                        i6 = 65536;
                    }
                }
                if ((374491 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -113;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U14 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j4 = jM1069contentColorForek8zF_U14;
                        }
                        if (i10 != 0) {
                            fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            modifier4 = modifier3;
                            j5 = primarySurface;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j6 = j4;
                            f2 = fM976getTopAppBarElevationD9Ej5fM;
                        } else {
                            modifier4 = modifier3;
                            j5 = primarySurface;
                            j6 = j4;
                            f2 = fM976getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -113;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U15 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j4 = jM1069contentColorForek8zF_U15;
                        }
                        if (i10 != 0) {
                            fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            modifier4 = modifier3;
                            j5 = primarySurface;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j6 = j4;
                            f2 = fM976getTopAppBarElevationD9Ej5fM;
                        } else {
                            modifier4 = modifier3;
                            j5 = primarySurface;
                            j6 = j4;
                            f2 = fM976getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1897058582, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:154)");
                    }
                    int i19 = i3 >> 3;
                    m977AppBarcelAv9A(j5, j6, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier4, interfaceC0552Gp, composerStartRestartGroup, (i19 & 7168) | (i19 & 14) | 24576 | (i19 & 112) | (i19 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    j7 = j5;
                    j8 = j6;
                    f3 = f2;
                    paddingValues3 = contentPadding;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -113;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U16 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j4 = jM1069contentColorForek8zF_U16;
                        }
                        if (i10 != 0) {
                            fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            modifier4 = modifier3;
                            j5 = primarySurface;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j6 = j4;
                            f2 = fM976getTopAppBarElevationD9Ej5fM;
                        } else {
                            modifier4 = modifier3;
                            j5 = primarySurface;
                            j6 = j4;
                            f2 = fM976getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -113;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U17 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j4 = jM1069contentColorForek8zF_U17;
                        }
                        if (i10 != 0) {
                            fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            modifier4 = modifier3;
                            j5 = primarySurface;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j6 = j4;
                            f2 = fM976getTopAppBarElevationD9Ej5fM;
                        } else {
                            modifier4 = modifier3;
                            j5 = primarySurface;
                            j6 = j4;
                            f2 = fM976getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1897058582, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:154)");
                    }
                    int i110 = i3 >> 3;
                    m977AppBarcelAv9A(j5, j6, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier4, interfaceC0552Gp, composerStartRestartGroup, (i110 & 7168) | (i110 & 14) | 24576 | (i110 & 112) | (i110 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    j7 = j5;
                    j8 = j6;
                    f3 = f2;
                    paddingValues3 = contentPadding;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$TopAppBar$3(modifier5, j7, j8, f3, paddingValues3, interfaceC0552Gp, i, i2));
            }
            i6 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i6;
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U18 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j4 = jM1069contentColorForek8zF_U18;
                    }
                    if (i10 != 0) {
                        fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        j5 = primarySurface;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j6 = j4;
                        f2 = fM976getTopAppBarElevationD9Ej5fM;
                    } else {
                        modifier4 = modifier3;
                        j5 = primarySurface;
                        j6 = j4;
                        f2 = fM976getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U19 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j4 = jM1069contentColorForek8zF_U19;
                    }
                    if (i10 != 0) {
                        fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        j5 = primarySurface;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j6 = j4;
                        f2 = fM976getTopAppBarElevationD9Ej5fM;
                    } else {
                        modifier4 = modifier3;
                        j5 = primarySurface;
                        j6 = j4;
                        f2 = fM976getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1897058582, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:154)");
                }
                int i111 = i3 >> 3;
                m977AppBarcelAv9A(j5, j6, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier4, interfaceC0552Gp, composerStartRestartGroup, (i111 & 7168) | (i111 & 14) | 24576 | (i111 & 112) | (i111 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                j7 = j5;
                j8 = j6;
                f3 = f2;
                paddingValues3 = contentPadding;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U110 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j4 = jM1069contentColorForek8zF_U110;
                    }
                    if (i10 != 0) {
                        fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        j5 = primarySurface;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j6 = j4;
                        f2 = fM976getTopAppBarElevationD9Ej5fM;
                    } else {
                        modifier4 = modifier3;
                        j5 = primarySurface;
                        j6 = j4;
                        f2 = fM976getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U111 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j4 = jM1069contentColorForek8zF_U111;
                    }
                    if (i10 != 0) {
                        fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        j5 = primarySurface;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j6 = j4;
                        f2 = fM976getTopAppBarElevationD9Ej5fM;
                    } else {
                        modifier4 = modifier3;
                        j5 = primarySurface;
                        j6 = j4;
                        f2 = fM976getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1897058582, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:154)");
                }
                int i112 = i3 >> 3;
                m977AppBarcelAv9A(j5, j6, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier4, interfaceC0552Gp, composerStartRestartGroup, (i112 & 7168) | (i112 & 14) | 24576 | (i112 & 112) | (i112 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                j7 = j5;
                j8 = j6;
                f3 = f2;
                paddingValues3 = contentPadding;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$TopAppBar$3(modifier5, j7, j8, f3, paddingValues3, interfaceC0552Gp, i, i2));
        }
        i3 |= 24576;
        paddingValues2 = paddingValues;
        if ((i2 & 32) != 0) {
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
            }
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U112 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j4 = jM1069contentColorForek8zF_U112;
                    }
                    if (i10 != 0) {
                        fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        j5 = primarySurface;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j6 = j4;
                        f2 = fM976getTopAppBarElevationD9Ej5fM;
                    } else {
                        modifier4 = modifier3;
                        j5 = primarySurface;
                        j6 = j4;
                        f2 = fM976getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U113 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j4 = jM1069contentColorForek8zF_U113;
                    }
                    if (i10 != 0) {
                        fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        j5 = primarySurface;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j6 = j4;
                        f2 = fM976getTopAppBarElevationD9Ej5fM;
                    } else {
                        modifier4 = modifier3;
                        j5 = primarySurface;
                        j6 = j4;
                        f2 = fM976getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1897058582, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:154)");
                }
                int i113 = i3 >> 3;
                m977AppBarcelAv9A(j5, j6, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier4, interfaceC0552Gp, composerStartRestartGroup, (i113 & 7168) | (i113 & 14) | 24576 | (i113 & 112) | (i113 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                j7 = j5;
                j8 = j6;
                f3 = f2;
                paddingValues3 = contentPadding;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U114 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j4 = jM1069contentColorForek8zF_U114;
                    }
                    if (i10 != 0) {
                        fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        j5 = primarySurface;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j6 = j4;
                        f2 = fM976getTopAppBarElevationD9Ej5fM;
                    } else {
                        modifier4 = modifier3;
                        j5 = primarySurface;
                        j6 = j4;
                        f2 = fM976getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U115 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j4 = jM1069contentColorForek8zF_U115;
                    }
                    if (i10 != 0) {
                        fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        j5 = primarySurface;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j6 = j4;
                        f2 = fM976getTopAppBarElevationD9Ej5fM;
                    } else {
                        modifier4 = modifier3;
                        j5 = primarySurface;
                        j6 = j4;
                        f2 = fM976getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1897058582, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:154)");
                }
                int i114 = i3 >> 3;
                m977AppBarcelAv9A(j5, j6, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier4, interfaceC0552Gp, composerStartRestartGroup, (i114 & 7168) | (i114 & 14) | 24576 | (i114 & 112) | (i114 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                j7 = j5;
                j8 = j6;
                f3 = f2;
                paddingValues3 = contentPadding;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$TopAppBar$3(modifier5, j7, j8, f3, paddingValues3, interfaceC0552Gp, i, i2));
        }
        i6 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i3 |= i6;
        if ((374491 & i3) == 74898) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -113;
                } else {
                    primarySurface = j3;
                }
                if ((i2 & 4) != 0) {
                    long jM1069contentColorForek8zF_U116 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                    j4 = jM1069contentColorForek8zF_U116;
                }
                if (i10 != 0) {
                    fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                }
                if (i4 != 0) {
                    modifier4 = modifier3;
                    j5 = primarySurface;
                    contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    j6 = j4;
                    f2 = fM976getTopAppBarElevationD9Ej5fM;
                } else {
                    modifier4 = modifier3;
                    j5 = primarySurface;
                    j6 = j4;
                    f2 = fM976getTopAppBarElevationD9Ej5fM;
                    contentPadding = paddingValues2;
                }
            } else {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -113;
                } else {
                    primarySurface = j3;
                }
                if ((i2 & 4) != 0) {
                    long jM1069contentColorForek8zF_U117 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                    j4 = jM1069contentColorForek8zF_U117;
                }
                if (i10 != 0) {
                    fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                }
                if (i4 != 0) {
                    modifier4 = modifier3;
                    j5 = primarySurface;
                    contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    j6 = j4;
                    f2 = fM976getTopAppBarElevationD9Ej5fM;
                } else {
                    modifier4 = modifier3;
                    j5 = primarySurface;
                    j6 = j4;
                    f2 = fM976getTopAppBarElevationD9Ej5fM;
                    contentPadding = paddingValues2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1897058582, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:154)");
            }
            int i115 = i3 >> 3;
            m977AppBarcelAv9A(j5, j6, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier4, interfaceC0552Gp, composerStartRestartGroup, (i115 & 7168) | (i115 & 14) | 24576 | (i115 & 112) | (i115 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            j7 = j5;
            j8 = j6;
            f3 = f2;
            paddingValues3 = contentPadding;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -113;
                } else {
                    primarySurface = j3;
                }
                if ((i2 & 4) != 0) {
                    long jM1069contentColorForek8zF_U118 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                    j4 = jM1069contentColorForek8zF_U118;
                }
                if (i10 != 0) {
                    fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                }
                if (i4 != 0) {
                    modifier4 = modifier3;
                    j5 = primarySurface;
                    contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    j6 = j4;
                    f2 = fM976getTopAppBarElevationD9Ej5fM;
                } else {
                    modifier4 = modifier3;
                    j5 = primarySurface;
                    j6 = j4;
                    f2 = fM976getTopAppBarElevationD9Ej5fM;
                    contentPadding = paddingValues2;
                }
            } else {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -113;
                } else {
                    primarySurface = j3;
                }
                if ((i2 & 4) != 0) {
                    long jM1069contentColorForek8zF_U119 = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                    j4 = jM1069contentColorForek8zF_U119;
                }
                if (i10 != 0) {
                    fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                }
                if (i4 != 0) {
                    modifier4 = modifier3;
                    j5 = primarySurface;
                    contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    j6 = j4;
                    f2 = fM976getTopAppBarElevationD9Ej5fM;
                } else {
                    modifier4 = modifier3;
                    j5 = primarySurface;
                    j6 = j4;
                    f2 = fM976getTopAppBarElevationD9Ej5fM;
                    contentPadding = paddingValues2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1897058582, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:154)");
            }
            int i116 = i3 >> 3;
            m977AppBarcelAv9A(j5, j6, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier4, interfaceC0552Gp, composerStartRestartGroup, (i116 & 7168) | (i116 & 14) | 24576 | (i116 & 112) | (i116 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            j7 = j5;
            j8 = j6;
            f3 = f2;
            paddingValues3 = contentPadding;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$TopAppBar$3(modifier5, j7, j8, f3, paddingValues3, interfaceC0552Gp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0127  */
    /* JADX WARN: Code duplicated, block: B:101:0x0129  */
    /* JADX WARN: Code duplicated, block: B:103:0x012c  */
    /* JADX WARN: Code duplicated, block: B:104:0x0133  */
    /* JADX WARN: Code duplicated, block: B:107:0x0138  */
    /* JADX WARN: Code duplicated, block: B:108:0x0146  */
    /* JADX WARN: Code duplicated, block: B:111:0x014b  */
    /* JADX WARN: Code duplicated, block: B:112:0x0155  */
    /* JADX WARN: Code duplicated, block: B:114:0x0158  */
    /* JADX WARN: Code duplicated, block: B:115:0x0161  */
    /* JADX WARN: Code duplicated, block: B:118:0x016d  */
    /* JADX WARN: Code duplicated, block: B:121:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:126:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    /* JADX WARN: Code duplicated, block: B:28:0x004d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0051  */
    /* JADX WARN: Code duplicated, block: B:32:0x0059  */
    /* JADX WARN: Code duplicated, block: B:33:0x005c  */
    /* JADX WARN: Code duplicated, block: B:37:0x0063  */
    /* JADX WARN: Code duplicated, block: B:39:0x0068  */
    /* JADX WARN: Code duplicated, block: B:41:0x006c  */
    /* JADX WARN: Code duplicated, block: B:43:0x0074  */
    /* JADX WARN: Code duplicated, block: B:44:0x0077  */
    /* JADX WARN: Code duplicated, block: B:48:0x0080  */
    /* JADX WARN: Code duplicated, block: B:50:0x0084  */
    /* JADX WARN: Code duplicated, block: B:52:0x008c  */
    /* JADX WARN: Code duplicated, block: B:53:0x008f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0095  */
    /* JADX WARN: Code duplicated, block: B:59:0x009d  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:63:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:70:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:80:0x00df  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:86:0x0100  */
    /* JADX WARN: Code duplicated, block: B:96:0x011e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:97:0x0120  */
    /* JADX WARN: Code duplicated, block: B:98:0x0123  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: TopAppBar-xWeB9-s, reason: not valid java name */
    public static final void m980TopAppBarxWeB9s(InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0552Gp interfaceC0552Gp, long j, long j2, float f, Composer composer, int i, int i2) {
        int i3;
        int i4;
        InterfaceC0526Fp interfaceC0526Fp3;
        int i5;
        int i6;
        InterfaceC0552Gp interfaceC0552Gp2;
        int i7;
        long j3;
        long j4;
        int i8;
        float f2;
        int i9;
        Modifier modifier2;
        InterfaceC0526Fp interfaceC0526Fp4;
        InterfaceC0552Gp interfaceC0552GpM1074getLambda1$material_release;
        long primarySurface;
        long jM1069contentColorForek8zF_U;
        long j5;
        float fM976getTopAppBarElevationD9Ej5fM;
        Modifier modifier3;
        float f3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0526Fp, "title");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2087748139);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 7168) == 0) {
                        interfaceC0552Gp2 = interfaceC0552Gp;
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((57344 & i) == 0) {
                        if ((i2 & 16) == 0) {
                            j3 = j;
                            int i11 = composerStartRestartGroup.changed(j3) ? 16384 : 8192;
                            i3 |= i11;
                        } else {
                            j3 = j;
                        }
                        i3 |= i11;
                    } else {
                        j3 = j;
                    }
                    if ((i & 458752) == 0) {
                        if ((i2 & 32) == 0) {
                            j4 = j2;
                            int i12 = composerStartRestartGroup.changed(j4) ? 131072 : 65536;
                            i3 |= i12;
                        } else {
                            j4 = j2;
                        }
                        i3 |= i12;
                    } else {
                        j4 = j2;
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                        i3 |= 1572864;
                        f2 = f;
                    } else {
                        f2 = f;
                        if ((i & 3670016) == 0) {
                            if (composerStartRestartGroup.changed(f2)) {
                                i9 = 1048576;
                            } else {
                                i9 = 524288;
                            }
                            i3 |= i9;
                        }
                    }
                    if ((i3 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i10 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp3;
                            }
                            if (i6 != 0) {
                                interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                            } else {
                                interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                            }
                            if ((i2 & 16) != 0) {
                                primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                                i3 &= -57345;
                            } else {
                                primarySurface = j3;
                            }
                            if ((i2 & 32) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                                i3 &= -458753;
                            } else {
                                jM1069contentColorForek8zF_U = j4;
                            }
                            if (i8 != 0) {
                                fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                                j5 = jM1069contentColorForek8zF_U;
                            } else {
                                j5 = jM1069contentColorForek8zF_U;
                                fM976getTopAppBarElevationD9Ej5fM = f2;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            modifier2 = modifier;
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                            interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                            primarySurface = j3;
                            fM976getTopAppBarElevationD9Ej5fM = f2;
                            j5 = j4;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2087748139, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:76)");
                        }
                        int i13 = i3 >> 12;
                        m977AppBarcelAv9A(primarySurface, j5, fM976getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), modifier2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new AppBarKt$TopAppBar$1(interfaceC0526Fp4, i3, interfaceC0526Fp, interfaceC0552GpM1074getLambda1$material_release)), composerStartRestartGroup, (i13 & 896) | (i13 & 14) | 1600512 | (i13 & 112) | ((i3 << 12) & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        f3 = fM976getTopAppBarElevationD9Ej5fM;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier;
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                        interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                        primarySurface = j3;
                        f3 = f2;
                        j5 = j4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$TopAppBar$2(interfaceC0526Fp, modifier3, interfaceC0526Fp4, interfaceC0552GpM1074getLambda1$material_release, primarySurface, j5, f3, i, i2));
                }
                i3 |= 3072;
                interfaceC0552Gp2 = interfaceC0552Gp;
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        j3 = j;
                        if (composerStartRestartGroup.changed(j3)) {
                        }
                        i3 |= i11;
                    } else {
                        j3 = j;
                    }
                    i3 |= i11;
                } else {
                    j3 = j;
                }
                if ((i & 458752) == 0) {
                    if ((i2 & 32) == 0) {
                        j4 = j2;
                        if (composerStartRestartGroup.changed(j4)) {
                        }
                        i3 |= i12;
                    } else {
                        j4 = j2;
                    }
                    i3 |= i12;
                } else {
                    j4 = j2;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    f2 = f;
                } else {
                    f2 = f;
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(f2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                }
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if (i6 != 0) {
                            interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -57345;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U = j4;
                        }
                        if (i8 != 0) {
                            fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                            j5 = jM1069contentColorForek8zF_U;
                        } else {
                            j5 = jM1069contentColorForek8zF_U;
                            fM976getTopAppBarElevationD9Ej5fM = f2;
                        }
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if (i6 != 0) {
                            interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -57345;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U = j4;
                        }
                        if (i8 != 0) {
                            fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                            j5 = jM1069contentColorForek8zF_U;
                        } else {
                            j5 = jM1069contentColorForek8zF_U;
                            fM976getTopAppBarElevationD9Ej5fM = f2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2087748139, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:76)");
                    }
                    int i14 = i3 >> 12;
                    m977AppBarcelAv9A(primarySurface, j5, fM976getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), modifier2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new AppBarKt$TopAppBar$1(interfaceC0526Fp4, i3, interfaceC0526Fp, interfaceC0552GpM1074getLambda1$material_release)), composerStartRestartGroup, (i14 & 896) | (i14 & 14) | 1600512 | (i14 & 112) | ((i3 << 12) & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    f3 = fM976getTopAppBarElevationD9Ej5fM;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if (i6 != 0) {
                            interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -57345;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U = j4;
                        }
                        if (i8 != 0) {
                            fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                            j5 = jM1069contentColorForek8zF_U;
                        } else {
                            j5 = jM1069contentColorForek8zF_U;
                            fM976getTopAppBarElevationD9Ej5fM = f2;
                        }
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if (i6 != 0) {
                            interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -57345;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U = j4;
                        }
                        if (i8 != 0) {
                            fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                            j5 = jM1069contentColorForek8zF_U;
                        } else {
                            j5 = jM1069contentColorForek8zF_U;
                            fM976getTopAppBarElevationD9Ej5fM = f2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2087748139, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:76)");
                    }
                    int i15 = i3 >> 12;
                    m977AppBarcelAv9A(primarySurface, j5, fM976getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), modifier2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new AppBarKt$TopAppBar$1(interfaceC0526Fp4, i3, interfaceC0526Fp, interfaceC0552GpM1074getLambda1$material_release)), composerStartRestartGroup, (i15 & 896) | (i15 & 14) | 1600512 | (i15 & 112) | ((i3 << 12) & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    f3 = fM976getTopAppBarElevationD9Ej5fM;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$TopAppBar$2(interfaceC0526Fp, modifier3, interfaceC0526Fp4, interfaceC0552GpM1074getLambda1$material_release, primarySurface, j5, f3, i, i2));
            }
            i3 |= 384;
            interfaceC0526Fp3 = interfaceC0526Fp2;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    interfaceC0552Gp2 = interfaceC0552Gp;
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        j3 = j;
                        if (composerStartRestartGroup.changed(j3)) {
                        }
                        i3 |= i11;
                    } else {
                        j3 = j;
                    }
                    i3 |= i11;
                } else {
                    j3 = j;
                }
                if ((i & 458752) == 0) {
                    if ((i2 & 32) == 0) {
                        j4 = j2;
                        if (composerStartRestartGroup.changed(j4)) {
                        }
                        i3 |= i12;
                    } else {
                        j4 = j2;
                    }
                    i3 |= i12;
                } else {
                    j4 = j2;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    f2 = f;
                } else {
                    f2 = f;
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(f2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                }
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if (i6 != 0) {
                            interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -57345;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U = j4;
                        }
                        if (i8 != 0) {
                            fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                            j5 = jM1069contentColorForek8zF_U;
                        } else {
                            j5 = jM1069contentColorForek8zF_U;
                            fM976getTopAppBarElevationD9Ej5fM = f2;
                        }
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if (i6 != 0) {
                            interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -57345;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U = j4;
                        }
                        if (i8 != 0) {
                            fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                            j5 = jM1069contentColorForek8zF_U;
                        } else {
                            j5 = jM1069contentColorForek8zF_U;
                            fM976getTopAppBarElevationD9Ej5fM = f2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2087748139, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:76)");
                    }
                    int i16 = i3 >> 12;
                    m977AppBarcelAv9A(primarySurface, j5, fM976getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), modifier2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new AppBarKt$TopAppBar$1(interfaceC0526Fp4, i3, interfaceC0526Fp, interfaceC0552GpM1074getLambda1$material_release)), composerStartRestartGroup, (i16 & 896) | (i16 & 14) | 1600512 | (i16 & 112) | ((i3 << 12) & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    f3 = fM976getTopAppBarElevationD9Ej5fM;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if (i6 != 0) {
                            interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -57345;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U = j4;
                        }
                        if (i8 != 0) {
                            fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                            j5 = jM1069contentColorForek8zF_U;
                        } else {
                            j5 = jM1069contentColorForek8zF_U;
                            fM976getTopAppBarElevationD9Ej5fM = f2;
                        }
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if (i6 != 0) {
                            interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -57345;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U = j4;
                        }
                        if (i8 != 0) {
                            fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                            j5 = jM1069contentColorForek8zF_U;
                        } else {
                            j5 = jM1069contentColorForek8zF_U;
                            fM976getTopAppBarElevationD9Ej5fM = f2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2087748139, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:76)");
                    }
                    int i17 = i3 >> 12;
                    m977AppBarcelAv9A(primarySurface, j5, fM976getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), modifier2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new AppBarKt$TopAppBar$1(interfaceC0526Fp4, i3, interfaceC0526Fp, interfaceC0552GpM1074getLambda1$material_release)), composerStartRestartGroup, (i17 & 896) | (i17 & 14) | 1600512 | (i17 & 112) | ((i3 << 12) & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    f3 = fM976getTopAppBarElevationD9Ej5fM;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$TopAppBar$2(interfaceC0526Fp, modifier3, interfaceC0526Fp4, interfaceC0552GpM1074getLambda1$material_release, primarySurface, j5, f3, i, i2));
            }
            i3 |= 3072;
            interfaceC0552Gp2 = interfaceC0552Gp;
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    j3 = j;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i3 |= i11;
                } else {
                    j3 = j;
                }
                i3 |= i11;
            } else {
                j3 = j;
            }
            if ((i & 458752) == 0) {
                if ((i2 & 32) == 0) {
                    j4 = j2;
                    if (composerStartRestartGroup.changed(j4)) {
                    }
                    i3 |= i12;
                } else {
                    j4 = j2;
                }
                i3 |= i12;
            } else {
                j4 = j2;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                f2 = f;
            } else {
                f2 = f;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if (i6 != 0) {
                        interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -57345;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U = j4;
                    }
                    if (i8 != 0) {
                        fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                        j5 = jM1069contentColorForek8zF_U;
                    } else {
                        j5 = jM1069contentColorForek8zF_U;
                        fM976getTopAppBarElevationD9Ej5fM = f2;
                    }
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if (i6 != 0) {
                        interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -57345;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U = j4;
                    }
                    if (i8 != 0) {
                        fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                        j5 = jM1069contentColorForek8zF_U;
                    } else {
                        j5 = jM1069contentColorForek8zF_U;
                        fM976getTopAppBarElevationD9Ej5fM = f2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2087748139, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:76)");
                }
                int i18 = i3 >> 12;
                m977AppBarcelAv9A(primarySurface, j5, fM976getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), modifier2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new AppBarKt$TopAppBar$1(interfaceC0526Fp4, i3, interfaceC0526Fp, interfaceC0552GpM1074getLambda1$material_release)), composerStartRestartGroup, (i18 & 896) | (i18 & 14) | 1600512 | (i18 & 112) | ((i3 << 12) & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                f3 = fM976getTopAppBarElevationD9Ej5fM;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if (i6 != 0) {
                        interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -57345;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U = j4;
                    }
                    if (i8 != 0) {
                        fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                        j5 = jM1069contentColorForek8zF_U;
                    } else {
                        j5 = jM1069contentColorForek8zF_U;
                        fM976getTopAppBarElevationD9Ej5fM = f2;
                    }
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if (i6 != 0) {
                        interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -57345;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U = j4;
                    }
                    if (i8 != 0) {
                        fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                        j5 = jM1069contentColorForek8zF_U;
                    } else {
                        j5 = jM1069contentColorForek8zF_U;
                        fM976getTopAppBarElevationD9Ej5fM = f2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2087748139, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:76)");
                }
                int i19 = i3 >> 12;
                m977AppBarcelAv9A(primarySurface, j5, fM976getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), modifier2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new AppBarKt$TopAppBar$1(interfaceC0526Fp4, i3, interfaceC0526Fp, interfaceC0552GpM1074getLambda1$material_release)), composerStartRestartGroup, (i19 & 896) | (i19 & 14) | 1600512 | (i19 & 112) | ((i3 << 12) & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                f3 = fM976getTopAppBarElevationD9Ej5fM;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$TopAppBar$2(interfaceC0526Fp, modifier3, interfaceC0526Fp4, interfaceC0552GpM1074getLambda1$material_release, primarySurface, j5, f3, i, i2));
        }
        i3 |= 48;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                interfaceC0526Fp3 = interfaceC0526Fp2;
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    interfaceC0552Gp2 = interfaceC0552Gp;
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        j3 = j;
                        if (composerStartRestartGroup.changed(j3)) {
                        }
                        i3 |= i11;
                    } else {
                        j3 = j;
                    }
                    i3 |= i11;
                } else {
                    j3 = j;
                }
                if ((i & 458752) == 0) {
                    if ((i2 & 32) == 0) {
                        j4 = j2;
                        if (composerStartRestartGroup.changed(j4)) {
                        }
                        i3 |= i12;
                    } else {
                        j4 = j2;
                    }
                    i3 |= i12;
                } else {
                    j4 = j2;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    f2 = f;
                } else {
                    f2 = f;
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(f2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                }
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if (i6 != 0) {
                            interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -57345;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U = j4;
                        }
                        if (i8 != 0) {
                            fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                            j5 = jM1069contentColorForek8zF_U;
                        } else {
                            j5 = jM1069contentColorForek8zF_U;
                            fM976getTopAppBarElevationD9Ej5fM = f2;
                        }
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if (i6 != 0) {
                            interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -57345;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U = j4;
                        }
                        if (i8 != 0) {
                            fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                            j5 = jM1069contentColorForek8zF_U;
                        } else {
                            j5 = jM1069contentColorForek8zF_U;
                            fM976getTopAppBarElevationD9Ej5fM = f2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2087748139, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:76)");
                    }
                    int i110 = i3 >> 12;
                    m977AppBarcelAv9A(primarySurface, j5, fM976getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), modifier2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new AppBarKt$TopAppBar$1(interfaceC0526Fp4, i3, interfaceC0526Fp, interfaceC0552GpM1074getLambda1$material_release)), composerStartRestartGroup, (i110 & 896) | (i110 & 14) | 1600512 | (i110 & 112) | ((i3 << 12) & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    f3 = fM976getTopAppBarElevationD9Ej5fM;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if (i6 != 0) {
                            interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -57345;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U = j4;
                        }
                        if (i8 != 0) {
                            fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                            j5 = jM1069contentColorForek8zF_U;
                        } else {
                            j5 = jM1069contentColorForek8zF_U;
                            fM976getTopAppBarElevationD9Ej5fM = f2;
                        }
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if (i6 != 0) {
                            interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -57345;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U = j4;
                        }
                        if (i8 != 0) {
                            fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                            j5 = jM1069contentColorForek8zF_U;
                        } else {
                            j5 = jM1069contentColorForek8zF_U;
                            fM976getTopAppBarElevationD9Ej5fM = f2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2087748139, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:76)");
                    }
                    int i111 = i3 >> 12;
                    m977AppBarcelAv9A(primarySurface, j5, fM976getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), modifier2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new AppBarKt$TopAppBar$1(interfaceC0526Fp4, i3, interfaceC0526Fp, interfaceC0552GpM1074getLambda1$material_release)), composerStartRestartGroup, (i111 & 896) | (i111 & 14) | 1600512 | (i111 & 112) | ((i3 << 12) & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    f3 = fM976getTopAppBarElevationD9Ej5fM;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$TopAppBar$2(interfaceC0526Fp, modifier3, interfaceC0526Fp4, interfaceC0552GpM1074getLambda1$material_release, primarySurface, j5, f3, i, i2));
            }
            i3 |= 3072;
            interfaceC0552Gp2 = interfaceC0552Gp;
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    j3 = j;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i3 |= i11;
                } else {
                    j3 = j;
                }
                i3 |= i11;
            } else {
                j3 = j;
            }
            if ((i & 458752) == 0) {
                if ((i2 & 32) == 0) {
                    j4 = j2;
                    if (composerStartRestartGroup.changed(j4)) {
                    }
                    i3 |= i12;
                } else {
                    j4 = j2;
                }
                i3 |= i12;
            } else {
                j4 = j2;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                f2 = f;
            } else {
                f2 = f;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if (i6 != 0) {
                        interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -57345;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U = j4;
                    }
                    if (i8 != 0) {
                        fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                        j5 = jM1069contentColorForek8zF_U;
                    } else {
                        j5 = jM1069contentColorForek8zF_U;
                        fM976getTopAppBarElevationD9Ej5fM = f2;
                    }
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if (i6 != 0) {
                        interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -57345;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U = j4;
                    }
                    if (i8 != 0) {
                        fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                        j5 = jM1069contentColorForek8zF_U;
                    } else {
                        j5 = jM1069contentColorForek8zF_U;
                        fM976getTopAppBarElevationD9Ej5fM = f2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2087748139, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:76)");
                }
                int i112 = i3 >> 12;
                m977AppBarcelAv9A(primarySurface, j5, fM976getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), modifier2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new AppBarKt$TopAppBar$1(interfaceC0526Fp4, i3, interfaceC0526Fp, interfaceC0552GpM1074getLambda1$material_release)), composerStartRestartGroup, (i112 & 896) | (i112 & 14) | 1600512 | (i112 & 112) | ((i3 << 12) & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                f3 = fM976getTopAppBarElevationD9Ej5fM;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if (i6 != 0) {
                        interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -57345;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U = j4;
                    }
                    if (i8 != 0) {
                        fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                        j5 = jM1069contentColorForek8zF_U;
                    } else {
                        j5 = jM1069contentColorForek8zF_U;
                        fM976getTopAppBarElevationD9Ej5fM = f2;
                    }
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if (i6 != 0) {
                        interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -57345;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U = j4;
                    }
                    if (i8 != 0) {
                        fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                        j5 = jM1069contentColorForek8zF_U;
                    } else {
                        j5 = jM1069contentColorForek8zF_U;
                        fM976getTopAppBarElevationD9Ej5fM = f2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2087748139, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:76)");
                }
                int i113 = i3 >> 12;
                m977AppBarcelAv9A(primarySurface, j5, fM976getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), modifier2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new AppBarKt$TopAppBar$1(interfaceC0526Fp4, i3, interfaceC0526Fp, interfaceC0552GpM1074getLambda1$material_release)), composerStartRestartGroup, (i113 & 896) | (i113 & 14) | 1600512 | (i113 & 112) | ((i3 << 12) & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                f3 = fM976getTopAppBarElevationD9Ej5fM;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$TopAppBar$2(interfaceC0526Fp, modifier3, interfaceC0526Fp4, interfaceC0552GpM1074getLambda1$material_release, primarySurface, j5, f3, i, i2));
        }
        i3 |= 384;
        interfaceC0526Fp3 = interfaceC0526Fp2;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 7168) == 0) {
                interfaceC0552Gp2 = interfaceC0552Gp;
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    j3 = j;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i3 |= i11;
                } else {
                    j3 = j;
                }
                i3 |= i11;
            } else {
                j3 = j;
            }
            if ((i & 458752) == 0) {
                if ((i2 & 32) == 0) {
                    j4 = j2;
                    if (composerStartRestartGroup.changed(j4)) {
                    }
                    i3 |= i12;
                } else {
                    j4 = j2;
                }
                i3 |= i12;
            } else {
                j4 = j2;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                f2 = f;
            } else {
                f2 = f;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if (i6 != 0) {
                        interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -57345;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U = j4;
                    }
                    if (i8 != 0) {
                        fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                        j5 = jM1069contentColorForek8zF_U;
                    } else {
                        j5 = jM1069contentColorForek8zF_U;
                        fM976getTopAppBarElevationD9Ej5fM = f2;
                    }
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if (i6 != 0) {
                        interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -57345;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U = j4;
                    }
                    if (i8 != 0) {
                        fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                        j5 = jM1069contentColorForek8zF_U;
                    } else {
                        j5 = jM1069contentColorForek8zF_U;
                        fM976getTopAppBarElevationD9Ej5fM = f2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2087748139, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:76)");
                }
                int i114 = i3 >> 12;
                m977AppBarcelAv9A(primarySurface, j5, fM976getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), modifier2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new AppBarKt$TopAppBar$1(interfaceC0526Fp4, i3, interfaceC0526Fp, interfaceC0552GpM1074getLambda1$material_release)), composerStartRestartGroup, (i114 & 896) | (i114 & 14) | 1600512 | (i114 & 112) | ((i3 << 12) & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                f3 = fM976getTopAppBarElevationD9Ej5fM;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if (i6 != 0) {
                        interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -57345;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U = j4;
                    }
                    if (i8 != 0) {
                        fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                        j5 = jM1069contentColorForek8zF_U;
                    } else {
                        j5 = jM1069contentColorForek8zF_U;
                        fM976getTopAppBarElevationD9Ej5fM = f2;
                    }
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if (i6 != 0) {
                        interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -57345;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U = j4;
                    }
                    if (i8 != 0) {
                        fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                        j5 = jM1069contentColorForek8zF_U;
                    } else {
                        j5 = jM1069contentColorForek8zF_U;
                        fM976getTopAppBarElevationD9Ej5fM = f2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2087748139, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:76)");
                }
                int i115 = i3 >> 12;
                m977AppBarcelAv9A(primarySurface, j5, fM976getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), modifier2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new AppBarKt$TopAppBar$1(interfaceC0526Fp4, i3, interfaceC0526Fp, interfaceC0552GpM1074getLambda1$material_release)), composerStartRestartGroup, (i115 & 896) | (i115 & 14) | 1600512 | (i115 & 112) | ((i3 << 12) & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                f3 = fM976getTopAppBarElevationD9Ej5fM;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$TopAppBar$2(interfaceC0526Fp, modifier3, interfaceC0526Fp4, interfaceC0552GpM1074getLambda1$material_release, primarySurface, j5, f3, i, i2));
        }
        i3 |= 3072;
        interfaceC0552Gp2 = interfaceC0552Gp;
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                j3 = j;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i3 |= i11;
            } else {
                j3 = j;
            }
            i3 |= i11;
        } else {
            j3 = j;
        }
        if ((i & 458752) == 0) {
            if ((i2 & 32) == 0) {
                j4 = j2;
                if (composerStartRestartGroup.changed(j4)) {
                }
                i3 |= i12;
            } else {
                j4 = j2;
            }
            i3 |= i12;
        } else {
            j4 = j2;
        }
        i8 = i2 & 64;
        if (i8 != 0) {
            i3 |= 1572864;
            f2 = f;
        } else {
            f2 = f;
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
        }
        if ((i3 & 2995931) == 599186) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp3;
                }
                if (i6 != 0) {
                    interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                } else {
                    interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                }
                if ((i2 & 16) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -57345;
                } else {
                    primarySurface = j3;
                }
                if ((i2 & 32) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                    i3 &= -458753;
                } else {
                    jM1069contentColorForek8zF_U = j4;
                }
                if (i8 != 0) {
                    fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                    j5 = jM1069contentColorForek8zF_U;
                } else {
                    j5 = jM1069contentColorForek8zF_U;
                    fM976getTopAppBarElevationD9Ej5fM = f2;
                }
            } else {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp3;
                }
                if (i6 != 0) {
                    interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                } else {
                    interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                }
                if ((i2 & 16) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -57345;
                } else {
                    primarySurface = j3;
                }
                if ((i2 & 32) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                    i3 &= -458753;
                } else {
                    jM1069contentColorForek8zF_U = j4;
                }
                if (i8 != 0) {
                    fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                    j5 = jM1069contentColorForek8zF_U;
                } else {
                    j5 = jM1069contentColorForek8zF_U;
                    fM976getTopAppBarElevationD9Ej5fM = f2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2087748139, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:76)");
            }
            int i116 = i3 >> 12;
            m977AppBarcelAv9A(primarySurface, j5, fM976getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), modifier2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new AppBarKt$TopAppBar$1(interfaceC0526Fp4, i3, interfaceC0526Fp, interfaceC0552GpM1074getLambda1$material_release)), composerStartRestartGroup, (i116 & 896) | (i116 & 14) | 1600512 | (i116 & 112) | ((i3 << 12) & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            f3 = fM976getTopAppBarElevationD9Ej5fM;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp3;
                }
                if (i6 != 0) {
                    interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                } else {
                    interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                }
                if ((i2 & 16) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -57345;
                } else {
                    primarySurface = j3;
                }
                if ((i2 & 32) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                    i3 &= -458753;
                } else {
                    jM1069contentColorForek8zF_U = j4;
                }
                if (i8 != 0) {
                    fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                    j5 = jM1069contentColorForek8zF_U;
                } else {
                    j5 = jM1069contentColorForek8zF_U;
                    fM976getTopAppBarElevationD9Ej5fM = f2;
                }
            } else {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp3;
                }
                if (i6 != 0) {
                    interfaceC0552GpM1074getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1074getLambda1$material_release();
                } else {
                    interfaceC0552GpM1074getLambda1$material_release = interfaceC0552Gp2;
                }
                if ((i2 & 16) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -57345;
                } else {
                    primarySurface = j3;
                }
                if ((i2 & 32) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                    i3 &= -458753;
                } else {
                    jM1069contentColorForek8zF_U = j4;
                }
                if (i8 != 0) {
                    fM976getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m976getTopAppBarElevationD9Ej5fM();
                    j5 = jM1069contentColorForek8zF_U;
                } else {
                    j5 = jM1069contentColorForek8zF_U;
                    fM976getTopAppBarElevationD9Ej5fM = f2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2087748139, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:76)");
            }
            int i117 = i3 >> 12;
            m977AppBarcelAv9A(primarySurface, j5, fM976getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), modifier2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new AppBarKt$TopAppBar$1(interfaceC0526Fp4, i3, interfaceC0526Fp, interfaceC0552GpM1074getLambda1$material_release)), composerStartRestartGroup, (i117 & 896) | (i117 & 14) | 1600512 | (i117 & 112) | ((i3 << 12) & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            f3 = fM976getTopAppBarElevationD9Ej5fM;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AppBarKt$TopAppBar$2(interfaceC0526Fp, modifier3, interfaceC0526Fp4, interfaceC0552GpM1074getLambda1$material_release, primarySurface, j5, f3, i, i2));
    }

    public static final float calculateCutoutCircleYIntercept(float f, float f2) {
        return -((float) Math.sqrt((f * f) - (f2 * f2)));
    }

    public static final C2020dG calculateRoundedEdgeIntercept(float f, float f2, float f3) {
        Float fValueOf;
        Float fValueOf2;
        C2020dG c2020dGA;
        Float fValueOf3;
        Float fValueOf4;
        float f4 = f2 * f2;
        float f5 = f3 * f3;
        float f6 = (f * f) + f4;
        float f7 = f4 * f5 * (f6 - f5);
        float f8 = f * f5;
        double d = f7;
        float fSqrt = (f8 - ((float) Math.sqrt(d))) / f6;
        float fSqrt2 = (f8 + ((float) Math.sqrt(d))) / f6;
        float fSqrt3 = (float) Math.sqrt(f5 - (fSqrt * fSqrt));
        float fSqrt4 = (float) Math.sqrt(f5 - (fSqrt2 * fSqrt2));
        if (f2 > 0.0f) {
            if (fSqrt3 > fSqrt4) {
                fValueOf3 = Float.valueOf(fSqrt);
                fValueOf4 = Float.valueOf(fSqrt3);
            } else {
                fValueOf3 = Float.valueOf(fSqrt2);
                fValueOf4 = Float.valueOf(fSqrt4);
            }
            c2020dGA = HV.a(fValueOf3, fValueOf4);
        } else {
            if (fSqrt3 < fSqrt4) {
                fValueOf = Float.valueOf(fSqrt);
                fValueOf2 = Float.valueOf(fSqrt3);
            } else {
                fValueOf = Float.valueOf(fSqrt2);
                fValueOf2 = Float.valueOf(fSqrt4);
            }
            c2020dGA = HV.a(fValueOf, fValueOf2);
        }
        float fFloatValue = ((Number) c2020dGA.a()).floatValue();
        float fFloatValue2 = ((Number) c2020dGA.b()).floatValue();
        if (fFloatValue < f) {
            fFloatValue2 = -fFloatValue2;
        }
        return HV.a(Float.valueOf(fFloatValue), Float.valueOf(fFloatValue2));
    }

    private static final float square(float f) {
        return f * f;
    }
}
