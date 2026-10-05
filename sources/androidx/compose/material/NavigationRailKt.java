package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2260gB;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class NavigationRailKt {
    private static final float HeaderPadding;
    private static final float NavigationRailPadding;
    private static final TweenSpec<Float> NavigationRailAnimationSpec = new TweenSpec<>(300, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
    private static final float NavigationRailItemSize = Dp.m5160constructorimpl(72);
    private static final float NavigationRailItemCompactSize = Dp.m5160constructorimpl(56);
    private static final float ItemLabelBaselineBottomOffset = Dp.m5160constructorimpl(16);
    private static final float ItemIconTopOffset = Dp.m5160constructorimpl(14);

    /* JADX INFO: renamed from: androidx.compose.material.NavigationRailKt$NavigationRailItemBaselineLayout$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ InterfaceC0526Fp $icon;
        final /* synthetic */ float $iconPositionAnimationProgress;
        final /* synthetic */ InterfaceC0526Fp $label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, float f, int i) {
            super(2);
            this.$icon = interfaceC0526Fp;
            this.$label = interfaceC0526Fp2;
            this.$iconPositionAnimationProgress = f;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            NavigationRailKt.NavigationRailItemBaselineLayout(this.$icon, this.$label, this.$iconPositionAnimationProgress, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    static {
        float f = 8;
        NavigationRailPadding = Dp.m5160constructorimpl(f);
        HeaderPadding = Dp.m5160constructorimpl(f);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x012e  */
    /* JADX WARN: Code duplicated, block: B:104:0x016b  */
    /* JADX WARN: Code duplicated, block: B:109:0x0178  */
    /* JADX WARN: Code duplicated, block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x0083  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088  */
    /* JADX WARN: Code duplicated, block: B:51:0x008e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0096  */
    /* JADX WARN: Code duplicated, block: B:54:0x0099  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:84:0x00eb A[PHI: r0 r4 r5 r10 r12
      0x00eb: PHI (r0v8 androidx.compose.ui.Modifier) = (r0v5 androidx.compose.ui.Modifier), (r0v12 androidx.compose.ui.Modifier) binds: [B:97:0x011f, B:83:0x00ea] A[DONT_GENERATE, DONT_INLINE]
      0x00eb: PHI (r4v20 int) = (r4v15 int), (r4v22 int) binds: [B:97:0x011f, B:83:0x00ea] A[DONT_GENERATE, DONT_INLINE]
      0x00eb: PHI (r5v6 long) = (r5v3 long), (r5v2 long) binds: [B:97:0x011f, B:83:0x00ea] A[DONT_GENERATE, DONT_INLINE]
      0x00eb: PHI (r10v10 long) = (r10v2 long), (r10v1 long) binds: [B:97:0x011f, B:83:0x00ea] A[DONT_GENERATE, DONT_INLINE]
      0x00eb: PHI (r12v13 float) = (r12v3 float), (r12v2 float) binds: [B:97:0x011f, B:83:0x00ea] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:86:0x00f0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:91:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:94:0x010b  */
    /* JADX WARN: Code duplicated, block: B:96:0x0118  */
    /* JADX WARN: Code duplicated, block: B:98:0x0121  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: NavigationRail-HsRjFd4, reason: not valid java name */
    public static final void m1160NavigationRailHsRjFd4(Modifier modifier, long j, long j2, float f, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0552Gp interfaceC0552Gp2, Composer composer, int i, int i2) {
        Modifier modifier2;
        int i3;
        long jM1055getSurface0d7_KjU;
        long j3;
        float fM1159getElevationD9Ej5fM;
        int i4;
        InterfaceC0552Gp interfaceC0552Gp3;
        int i5;
        int i6;
        Modifier modifier3;
        InterfaceC0552Gp interfaceC0552Gp4;
        long j4;
        int i7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0552Gp2, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(1790971523);
        int i8 = i2 & 1;
        if (i8 != 0) {
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
                jM1055getSurface0d7_KjU = j;
                int i9 = composerStartRestartGroup.changed(jM1055getSurface0d7_KjU) ? 32 : 16;
                i3 |= i9;
            } else {
                jM1055getSurface0d7_KjU = j;
            }
            i3 |= i9;
        } else {
            jM1055getSurface0d7_KjU = j;
        }
        if ((i & 896) == 0) {
            j3 = j2;
            i3 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(j3)) ? 256 : 128;
        } else {
            j3 = j2;
        }
        int i10 = i2 & 8;
        if (i10 == 0) {
            if ((i & 7168) == 0) {
                fM1159getElevationD9Ej5fM = f;
                i3 |= composerStartRestartGroup.changed(fM1159getElevationD9Ej5fM) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((57344 & i) == 0) {
                    interfaceC0552Gp3 = interfaceC0552Gp;
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp3)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                if ((i2 & 32) != 0) {
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                            i6 = 131072;
                        } else {
                            i6 = 65536;
                        }
                    }
                    if ((374491 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i8 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 2) != 0) {
                                i3 &= -113;
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            }
                            if ((i2 & 4) != 0) {
                                long jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                                i3 &= -897;
                                j3 = jM1069contentColorForek8zF_U;
                            }
                            if (i10 != 0) {
                                fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                            }
                            if (i4 != 0) {
                                interfaceC0552Gp4 = null;
                                j4 = j3;
                            }
                            i7 = i3;
                            float f2 = fM1159getElevationD9Ej5fM;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1790971523, i7, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:92)");
                            }
                            int i11 = i7 << 3;
                            SurfaceKt.m1227SurfaceFjzlyU(modifier3, null, jM1055getSurface0d7_KjU, j4, null, f2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new NavigationRailKt$NavigationRail$1(interfaceC0552Gp4, i7, interfaceC0552Gp2)), composerStartRestartGroup, (i7 & 14) | 1572864 | (i11 & 896) | (i11 & 7168) | ((i7 << 6) & 458752), 18);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j3 = j4;
                            fM1159getElevationD9Ej5fM = f2;
                            modifier2 = modifier3;
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
                        j4 = j3;
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                        i7 = i3;
                        float f3 = fM1159getElevationD9Ej5fM;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1790971523, i7, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:92)");
                        }
                        int i12 = i7 << 3;
                        SurfaceKt.m1227SurfaceFjzlyU(modifier3, null, jM1055getSurface0d7_KjU, j4, null, f3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new NavigationRailKt$NavigationRail$1(interfaceC0552Gp4, i7, interfaceC0552Gp2)), composerStartRestartGroup, (i7 & 14) | 1572864 | (i12 & 896) | (i12 & 7168) | ((i7 << 6) & 458752), 18);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j3 = j4;
                        fM1159getElevationD9Ej5fM = f3;
                        modifier2 = modifier3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new NavigationRailKt$NavigationRail$2(modifier2, jM1055getSurface0d7_KjU, j3, fM1159getElevationD9Ej5fM, interfaceC0552Gp4, interfaceC0552Gp2, i, i2));
                }
                i6 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i6;
                if ((374491 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM1069contentColorForek8zF_U2;
                        }
                        if (i10 != 0) {
                            fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            interfaceC0552Gp4 = null;
                            j4 = j3;
                        } else {
                            j4 = j3;
                            interfaceC0552Gp4 = interfaceC0552Gp3;
                        }
                    } else {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U3 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM1069contentColorForek8zF_U3;
                        }
                        if (i10 != 0) {
                            fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            interfaceC0552Gp4 = null;
                            j4 = j3;
                        } else {
                            j4 = j3;
                            interfaceC0552Gp4 = interfaceC0552Gp3;
                        }
                    }
                    i7 = i3;
                    float f4 = fM1159getElevationD9Ej5fM;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1790971523, i7, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:92)");
                    }
                    int i13 = i7 << 3;
                    SurfaceKt.m1227SurfaceFjzlyU(modifier3, null, jM1055getSurface0d7_KjU, j4, null, f4, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new NavigationRailKt$NavigationRail$1(interfaceC0552Gp4, i7, interfaceC0552Gp2)), composerStartRestartGroup, (i7 & 14) | 1572864 | (i13 & 896) | (i13 & 7168) | ((i7 << 6) & 458752), 18);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = j4;
                    fM1159getElevationD9Ej5fM = f4;
                    modifier2 = modifier3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U4 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM1069contentColorForek8zF_U4;
                        }
                        if (i10 != 0) {
                            fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            interfaceC0552Gp4 = null;
                            j4 = j3;
                        } else {
                            j4 = j3;
                            interfaceC0552Gp4 = interfaceC0552Gp3;
                        }
                    } else {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U5 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM1069contentColorForek8zF_U5;
                        }
                        if (i10 != 0) {
                            fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            interfaceC0552Gp4 = null;
                            j4 = j3;
                        } else {
                            j4 = j3;
                            interfaceC0552Gp4 = interfaceC0552Gp3;
                        }
                    }
                    i7 = i3;
                    float f5 = fM1159getElevationD9Ej5fM;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1790971523, i7, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:92)");
                    }
                    int i14 = i7 << 3;
                    SurfaceKt.m1227SurfaceFjzlyU(modifier3, null, jM1055getSurface0d7_KjU, j4, null, f5, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new NavigationRailKt$NavigationRail$1(interfaceC0552Gp4, i7, interfaceC0552Gp2)), composerStartRestartGroup, (i7 & 14) | 1572864 | (i14 & 896) | (i14 & 7168) | ((i7 << 6) & 458752), 18);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = j4;
                    fM1159getElevationD9Ej5fM = f5;
                    modifier2 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new NavigationRailKt$NavigationRail$2(modifier2, jM1055getSurface0d7_KjU, j3, fM1159getElevationD9Ej5fM, interfaceC0552Gp4, interfaceC0552Gp2, i, i2));
            }
            i3 |= 24576;
            interfaceC0552Gp3 = interfaceC0552Gp;
            if ((i2 & 32) != 0) {
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                        i6 = 131072;
                    } else {
                        i6 = 65536;
                    }
                }
                if ((374491 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U6 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM1069contentColorForek8zF_U6;
                        }
                        if (i10 != 0) {
                            fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            interfaceC0552Gp4 = null;
                            j4 = j3;
                        } else {
                            j4 = j3;
                            interfaceC0552Gp4 = interfaceC0552Gp3;
                        }
                    } else {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U7 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM1069contentColorForek8zF_U7;
                        }
                        if (i10 != 0) {
                            fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            interfaceC0552Gp4 = null;
                            j4 = j3;
                        } else {
                            j4 = j3;
                            interfaceC0552Gp4 = interfaceC0552Gp3;
                        }
                    }
                    i7 = i3;
                    float f6 = fM1159getElevationD9Ej5fM;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1790971523, i7, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:92)");
                    }
                    int i15 = i7 << 3;
                    SurfaceKt.m1227SurfaceFjzlyU(modifier3, null, jM1055getSurface0d7_KjU, j4, null, f6, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new NavigationRailKt$NavigationRail$1(interfaceC0552Gp4, i7, interfaceC0552Gp2)), composerStartRestartGroup, (i7 & 14) | 1572864 | (i15 & 896) | (i15 & 7168) | ((i7 << 6) & 458752), 18);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = j4;
                    fM1159getElevationD9Ej5fM = f6;
                    modifier2 = modifier3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U8 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM1069contentColorForek8zF_U8;
                        }
                        if (i10 != 0) {
                            fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            interfaceC0552Gp4 = null;
                            j4 = j3;
                        } else {
                            j4 = j3;
                            interfaceC0552Gp4 = interfaceC0552Gp3;
                        }
                    } else {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U9 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM1069contentColorForek8zF_U9;
                        }
                        if (i10 != 0) {
                            fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            interfaceC0552Gp4 = null;
                            j4 = j3;
                        } else {
                            j4 = j3;
                            interfaceC0552Gp4 = interfaceC0552Gp3;
                        }
                    }
                    i7 = i3;
                    float f7 = fM1159getElevationD9Ej5fM;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1790971523, i7, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:92)");
                    }
                    int i16 = i7 << 3;
                    SurfaceKt.m1227SurfaceFjzlyU(modifier3, null, jM1055getSurface0d7_KjU, j4, null, f7, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new NavigationRailKt$NavigationRail$1(interfaceC0552Gp4, i7, interfaceC0552Gp2)), composerStartRestartGroup, (i7 & 14) | 1572864 | (i16 & 896) | (i16 & 7168) | ((i7 << 6) & 458752), 18);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = j4;
                    fM1159getElevationD9Ej5fM = f7;
                    modifier2 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new NavigationRailKt$NavigationRail$2(modifier2, jM1055getSurface0d7_KjU, j3, fM1159getElevationD9Ej5fM, interfaceC0552Gp4, interfaceC0552Gp2, i, i2));
            }
            i6 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i6;
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U10 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM1069contentColorForek8zF_U10;
                    }
                    if (i10 != 0) {
                        fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        interfaceC0552Gp4 = null;
                        j4 = j3;
                    } else {
                        j4 = j3;
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                    }
                } else {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U11 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM1069contentColorForek8zF_U11;
                    }
                    if (i10 != 0) {
                        fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        interfaceC0552Gp4 = null;
                        j4 = j3;
                    } else {
                        j4 = j3;
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                    }
                }
                i7 = i3;
                float f8 = fM1159getElevationD9Ej5fM;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1790971523, i7, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:92)");
                }
                int i17 = i7 << 3;
                SurfaceKt.m1227SurfaceFjzlyU(modifier3, null, jM1055getSurface0d7_KjU, j4, null, f8, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new NavigationRailKt$NavigationRail$1(interfaceC0552Gp4, i7, interfaceC0552Gp2)), composerStartRestartGroup, (i7 & 14) | 1572864 | (i17 & 896) | (i17 & 7168) | ((i7 << 6) & 458752), 18);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = j4;
                fM1159getElevationD9Ej5fM = f8;
                modifier2 = modifier3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U12 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM1069contentColorForek8zF_U12;
                    }
                    if (i10 != 0) {
                        fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        interfaceC0552Gp4 = null;
                        j4 = j3;
                    } else {
                        j4 = j3;
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                    }
                } else {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U13 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM1069contentColorForek8zF_U13;
                    }
                    if (i10 != 0) {
                        fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        interfaceC0552Gp4 = null;
                        j4 = j3;
                    } else {
                        j4 = j3;
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                    }
                }
                i7 = i3;
                float f9 = fM1159getElevationD9Ej5fM;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1790971523, i7, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:92)");
                }
                int i18 = i7 << 3;
                SurfaceKt.m1227SurfaceFjzlyU(modifier3, null, jM1055getSurface0d7_KjU, j4, null, f9, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new NavigationRailKt$NavigationRail$1(interfaceC0552Gp4, i7, interfaceC0552Gp2)), composerStartRestartGroup, (i7 & 14) | 1572864 | (i18 & 896) | (i18 & 7168) | ((i7 << 6) & 458752), 18);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = j4;
                fM1159getElevationD9Ej5fM = f9;
                modifier2 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new NavigationRailKt$NavigationRail$2(modifier2, jM1055getSurface0d7_KjU, j3, fM1159getElevationD9Ej5fM, interfaceC0552Gp4, interfaceC0552Gp2, i, i2));
        }
        i3 |= 3072;
        fM1159getElevationD9Ej5fM = f;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((57344 & i) == 0) {
                interfaceC0552Gp3 = interfaceC0552Gp;
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp3)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((i2 & 32) != 0) {
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                        i6 = 131072;
                    } else {
                        i6 = 65536;
                    }
                }
                if ((374491 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U14 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM1069contentColorForek8zF_U14;
                        }
                        if (i10 != 0) {
                            fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            interfaceC0552Gp4 = null;
                            j4 = j3;
                        } else {
                            j4 = j3;
                            interfaceC0552Gp4 = interfaceC0552Gp3;
                        }
                    } else {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U15 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM1069contentColorForek8zF_U15;
                        }
                        if (i10 != 0) {
                            fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            interfaceC0552Gp4 = null;
                            j4 = j3;
                        } else {
                            j4 = j3;
                            interfaceC0552Gp4 = interfaceC0552Gp3;
                        }
                    }
                    i7 = i3;
                    float f10 = fM1159getElevationD9Ej5fM;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1790971523, i7, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:92)");
                    }
                    int i19 = i7 << 3;
                    SurfaceKt.m1227SurfaceFjzlyU(modifier3, null, jM1055getSurface0d7_KjU, j4, null, f10, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new NavigationRailKt$NavigationRail$1(interfaceC0552Gp4, i7, interfaceC0552Gp2)), composerStartRestartGroup, (i7 & 14) | 1572864 | (i19 & 896) | (i19 & 7168) | ((i7 << 6) & 458752), 18);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = j4;
                    fM1159getElevationD9Ej5fM = f10;
                    modifier2 = modifier3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U16 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM1069contentColorForek8zF_U16;
                        }
                        if (i10 != 0) {
                            fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            interfaceC0552Gp4 = null;
                            j4 = j3;
                        } else {
                            j4 = j3;
                            interfaceC0552Gp4 = interfaceC0552Gp3;
                        }
                    } else {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        }
                        if ((i2 & 4) != 0) {
                            long jM1069contentColorForek8zF_U17 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM1069contentColorForek8zF_U17;
                        }
                        if (i10 != 0) {
                            fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            interfaceC0552Gp4 = null;
                            j4 = j3;
                        } else {
                            j4 = j3;
                            interfaceC0552Gp4 = interfaceC0552Gp3;
                        }
                    }
                    i7 = i3;
                    float f11 = fM1159getElevationD9Ej5fM;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1790971523, i7, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:92)");
                    }
                    int i110 = i7 << 3;
                    SurfaceKt.m1227SurfaceFjzlyU(modifier3, null, jM1055getSurface0d7_KjU, j4, null, f11, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new NavigationRailKt$NavigationRail$1(interfaceC0552Gp4, i7, interfaceC0552Gp2)), composerStartRestartGroup, (i7 & 14) | 1572864 | (i110 & 896) | (i110 & 7168) | ((i7 << 6) & 458752), 18);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = j4;
                    fM1159getElevationD9Ej5fM = f11;
                    modifier2 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new NavigationRailKt$NavigationRail$2(modifier2, jM1055getSurface0d7_KjU, j3, fM1159getElevationD9Ej5fM, interfaceC0552Gp4, interfaceC0552Gp2, i, i2));
            }
            i6 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i6;
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U18 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM1069contentColorForek8zF_U18;
                    }
                    if (i10 != 0) {
                        fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        interfaceC0552Gp4 = null;
                        j4 = j3;
                    } else {
                        j4 = j3;
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                    }
                } else {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U19 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM1069contentColorForek8zF_U19;
                    }
                    if (i10 != 0) {
                        fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        interfaceC0552Gp4 = null;
                        j4 = j3;
                    } else {
                        j4 = j3;
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                    }
                }
                i7 = i3;
                float f12 = fM1159getElevationD9Ej5fM;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1790971523, i7, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:92)");
                }
                int i111 = i7 << 3;
                SurfaceKt.m1227SurfaceFjzlyU(modifier3, null, jM1055getSurface0d7_KjU, j4, null, f12, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new NavigationRailKt$NavigationRail$1(interfaceC0552Gp4, i7, interfaceC0552Gp2)), composerStartRestartGroup, (i7 & 14) | 1572864 | (i111 & 896) | (i111 & 7168) | ((i7 << 6) & 458752), 18);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = j4;
                fM1159getElevationD9Ej5fM = f12;
                modifier2 = modifier3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U110 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM1069contentColorForek8zF_U110;
                    }
                    if (i10 != 0) {
                        fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        interfaceC0552Gp4 = null;
                        j4 = j3;
                    } else {
                        j4 = j3;
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                    }
                } else {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U111 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM1069contentColorForek8zF_U111;
                    }
                    if (i10 != 0) {
                        fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        interfaceC0552Gp4 = null;
                        j4 = j3;
                    } else {
                        j4 = j3;
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                    }
                }
                i7 = i3;
                float f13 = fM1159getElevationD9Ej5fM;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1790971523, i7, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:92)");
                }
                int i112 = i7 << 3;
                SurfaceKt.m1227SurfaceFjzlyU(modifier3, null, jM1055getSurface0d7_KjU, j4, null, f13, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new NavigationRailKt$NavigationRail$1(interfaceC0552Gp4, i7, interfaceC0552Gp2)), composerStartRestartGroup, (i7 & 14) | 1572864 | (i112 & 896) | (i112 & 7168) | ((i7 << 6) & 458752), 18);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = j4;
                fM1159getElevationD9Ej5fM = f13;
                modifier2 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new NavigationRailKt$NavigationRail$2(modifier2, jM1055getSurface0d7_KjU, j3, fM1159getElevationD9Ej5fM, interfaceC0552Gp4, interfaceC0552Gp2, i, i2));
        }
        i3 |= 24576;
        interfaceC0552Gp3 = interfaceC0552Gp;
        if ((i2 & 32) != 0) {
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
            }
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U112 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM1069contentColorForek8zF_U112;
                    }
                    if (i10 != 0) {
                        fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        interfaceC0552Gp4 = null;
                        j4 = j3;
                    } else {
                        j4 = j3;
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                    }
                } else {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U113 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM1069contentColorForek8zF_U113;
                    }
                    if (i10 != 0) {
                        fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        interfaceC0552Gp4 = null;
                        j4 = j3;
                    } else {
                        j4 = j3;
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                    }
                }
                i7 = i3;
                float f14 = fM1159getElevationD9Ej5fM;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1790971523, i7, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:92)");
                }
                int i113 = i7 << 3;
                SurfaceKt.m1227SurfaceFjzlyU(modifier3, null, jM1055getSurface0d7_KjU, j4, null, f14, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new NavigationRailKt$NavigationRail$1(interfaceC0552Gp4, i7, interfaceC0552Gp2)), composerStartRestartGroup, (i7 & 14) | 1572864 | (i113 & 896) | (i113 & 7168) | ((i7 << 6) & 458752), 18);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = j4;
                fM1159getElevationD9Ej5fM = f14;
                modifier2 = modifier3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U114 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM1069contentColorForek8zF_U114;
                    }
                    if (i10 != 0) {
                        fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        interfaceC0552Gp4 = null;
                        j4 = j3;
                    } else {
                        j4 = j3;
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                    }
                } else {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    }
                    if ((i2 & 4) != 0) {
                        long jM1069contentColorForek8zF_U115 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM1069contentColorForek8zF_U115;
                    }
                    if (i10 != 0) {
                        fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        interfaceC0552Gp4 = null;
                        j4 = j3;
                    } else {
                        j4 = j3;
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                    }
                }
                i7 = i3;
                float f15 = fM1159getElevationD9Ej5fM;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1790971523, i7, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:92)");
                }
                int i114 = i7 << 3;
                SurfaceKt.m1227SurfaceFjzlyU(modifier3, null, jM1055getSurface0d7_KjU, j4, null, f15, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new NavigationRailKt$NavigationRail$1(interfaceC0552Gp4, i7, interfaceC0552Gp2)), composerStartRestartGroup, (i7 & 14) | 1572864 | (i114 & 896) | (i114 & 7168) | ((i7 << 6) & 458752), 18);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = j4;
                fM1159getElevationD9Ej5fM = f15;
                modifier2 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new NavigationRailKt$NavigationRail$2(modifier2, jM1055getSurface0d7_KjU, j3, fM1159getElevationD9Ej5fM, interfaceC0552Gp4, interfaceC0552Gp2, i, i2));
        }
        i6 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i3 |= i6;
        if ((374491 & i3) == 74898) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                }
                if ((i2 & 4) != 0) {
                    long jM1069contentColorForek8zF_U116 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                    j3 = jM1069contentColorForek8zF_U116;
                }
                if (i10 != 0) {
                    fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                }
                if (i4 != 0) {
                    interfaceC0552Gp4 = null;
                    j4 = j3;
                } else {
                    j4 = j3;
                    interfaceC0552Gp4 = interfaceC0552Gp3;
                }
            } else {
                if (i8 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                }
                if ((i2 & 4) != 0) {
                    long jM1069contentColorForek8zF_U117 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                    j3 = jM1069contentColorForek8zF_U117;
                }
                if (i10 != 0) {
                    fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                }
                if (i4 != 0) {
                    interfaceC0552Gp4 = null;
                    j4 = j3;
                } else {
                    j4 = j3;
                    interfaceC0552Gp4 = interfaceC0552Gp3;
                }
            }
            i7 = i3;
            float f16 = fM1159getElevationD9Ej5fM;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1790971523, i7, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:92)");
            }
            int i115 = i7 << 3;
            SurfaceKt.m1227SurfaceFjzlyU(modifier3, null, jM1055getSurface0d7_KjU, j4, null, f16, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new NavigationRailKt$NavigationRail$1(interfaceC0552Gp4, i7, interfaceC0552Gp2)), composerStartRestartGroup, (i7 & 14) | 1572864 | (i115 & 896) | (i115 & 7168) | ((i7 << 6) & 458752), 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j3 = j4;
            fM1159getElevationD9Ej5fM = f16;
            modifier2 = modifier3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                }
                if ((i2 & 4) != 0) {
                    long jM1069contentColorForek8zF_U118 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                    j3 = jM1069contentColorForek8zF_U118;
                }
                if (i10 != 0) {
                    fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                }
                if (i4 != 0) {
                    interfaceC0552Gp4 = null;
                    j4 = j3;
                } else {
                    j4 = j3;
                    interfaceC0552Gp4 = interfaceC0552Gp3;
                }
            } else {
                if (i8 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                }
                if ((i2 & 4) != 0) {
                    long jM1069contentColorForek8zF_U119 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                    j3 = jM1069contentColorForek8zF_U119;
                }
                if (i10 != 0) {
                    fM1159getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1159getElevationD9Ej5fM();
                }
                if (i4 != 0) {
                    interfaceC0552Gp4 = null;
                    j4 = j3;
                } else {
                    j4 = j3;
                    interfaceC0552Gp4 = interfaceC0552Gp3;
                }
            }
            i7 = i3;
            float f17 = fM1159getElevationD9Ej5fM;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1790971523, i7, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:92)");
            }
            int i116 = i7 << 3;
            SurfaceKt.m1227SurfaceFjzlyU(modifier3, null, jM1055getSurface0d7_KjU, j4, null, f17, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new NavigationRailKt$NavigationRail$1(interfaceC0552Gp4, i7, interfaceC0552Gp2)), composerStartRestartGroup, (i7 & 14) | 1572864 | (i116 & 896) | (i116 & 7168) | ((i7 << 6) & 458752), 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j3 = j4;
            fM1159getElevationD9Ej5fM = f17;
            modifier2 = modifier3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new NavigationRailKt$NavigationRail$2(modifier2, jM1055getSurface0d7_KjU, j3, fM1159getElevationD9Ej5fM, interfaceC0552Gp4, interfaceC0552Gp2, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:102:0x013b  */
    /* JADX WARN: Code duplicated, block: B:104:0x013f  */
    /* JADX WARN: Code duplicated, block: B:111:0x0160  */
    /* JADX WARN: Code duplicated, block: B:113:0x016f  */
    /* JADX WARN: Code duplicated, block: B:123:0x018b A[PHI: r1 r5 r8 r9 r11 r15 r18
      0x018b: PHI (r1v15 Fp) = (r1v3 Fp), (r1v16 Fp) binds: [B:144:0x01da, B:122:0x0185] A[DONT_GENERATE, DONT_INLINE]
      0x018b: PHI (r5v28 androidx.compose.ui.Modifier) = (r5v15 androidx.compose.ui.Modifier), (r5v29 androidx.compose.ui.Modifier) binds: [B:144:0x01da, B:122:0x0185] A[DONT_GENERATE, DONT_INLINE]
      0x018b: PHI (r8v5 androidx.compose.foundation.interaction.MutableInteractionSource) = 
      (r8v2 androidx.compose.foundation.interaction.MutableInteractionSource)
      (r8v1 androidx.compose.foundation.interaction.MutableInteractionSource)
     binds: [B:144:0x01da, B:122:0x0185] A[DONT_GENERATE, DONT_INLINE]
      0x018b: PHI (r9v8 boolean) = (r9v5 boolean), (r9v4 boolean) binds: [B:144:0x01da, B:122:0x0185] A[DONT_GENERATE, DONT_INLINE]
      0x018b: PHI (r11v6 boolean) = (r11v3 boolean), (r11v2 boolean) binds: [B:144:0x01da, B:122:0x0185] A[DONT_GENERATE, DONT_INLINE]
      0x018b: PHI (r15v27 int) = (r15v23 int), (r15v29 int) binds: [B:144:0x01da, B:122:0x0185] A[DONT_GENERATE, DONT_INLINE]
      0x018b: PHI (r18v9 long) = (r18v6 long), (r18v10 long) binds: [B:144:0x01da, B:122:0x0185] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:124:0x018f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:125:0x0191  */
    /* JADX WARN: Code duplicated, block: B:126:0x0194  */
    /* JADX WARN: Code duplicated, block: B:128:0x0198  */
    /* JADX WARN: Code duplicated, block: B:130:0x019b  */
    /* JADX WARN: Code duplicated, block: B:131:0x019d  */
    /* JADX WARN: Code duplicated, block: B:133:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:135:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:137:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:141:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:142:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:145:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:148:0x0216  */
    /* JADX WARN: Code duplicated, block: B:150:0x0221  */
    /* JADX WARN: Code duplicated, block: B:152:0x0230  */
    /* JADX WARN: Code duplicated, block: B:153:0x0233  */
    /* JADX WARN: Code duplicated, block: B:156:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:159:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:160:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:163:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:165:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:168:0x0345  */
    /* JADX WARN: Code duplicated, block: B:173:0x0355  */
    /* JADX WARN: Code duplicated, block: B:175:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x008f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0094  */
    /* JADX WARN: Code duplicated, block: B:49:0x009d  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:59:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:66:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:69:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:76:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:79:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:81:0x0101  */
    /* JADX WARN: Code duplicated, block: B:82:0x0104  */
    /* JADX WARN: Code duplicated, block: B:86:0x010e  */
    /* JADX WARN: Code duplicated, block: B:94:0x0125  */
    /* JADX WARN: Code duplicated, block: B:97:0x012c  */
    /* JADX WARN: Instruction removed from duplicated block: B:111:0x0160, please report this as an issue */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: NavigationRailItem-0S3VyRs, reason: not valid java name */
    public static final void m1161NavigationRailItem0S3VyRs(boolean z, InterfaceC3588op interfaceC3588op, InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, boolean z2, InterfaceC0526Fp interfaceC0526Fp2, boolean z3, MutableInteractionSource mutableInteractionSource, long j, long j2, Composer composer, int i, int i2) {
        int i3;
        int i4;
        boolean z4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z5;
        int i9;
        int i10;
        MutableInteractionSource mutableInteractionSource2;
        int i11;
        Modifier modifier2;
        InterfaceC0526Fp interfaceC0526Fp3;
        long jM1051getPrimary0d7_KjU;
        long jM3031copywmQWz5c$default;
        Object objRememberedValue;
        float f;
        int currentCompositeKeyHash;
        InterfaceC3588op constructor;
        Composer composerM2661constructorimpl;
        InterfaceC0526Fp setCompositeKeyHash;
        InterfaceC0526Fp interfaceC0526Fp4;
        boolean z6;
        boolean z7;
        Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i12;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0526Fp, "icon");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1813548445);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((2 & i2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC3588op) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 256 : 128;
        }
        int i13 = i2 & 8;
        if (i13 == 0) {
            if ((i & 7168) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 2048 : 1024;
            }
            i4 = 16 & i2;
            if (i4 != 0) {
                i3 |= 24576;
                z4 = z2;
            } else {
                z4 = z2;
                if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changed(z4)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
            }
            i6 = 32 & i2;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                z5 = z3;
            } else {
                z5 = z3;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(z5)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            i10 = 128 & i2;
            if (i10 != 0) {
                i3 |= 12582912;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
            }
            if ((i & 234881024) != 0) {
                i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
            }
            if ((1879048192 & i) != 0) {
                if ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) {
                    i12 = 268435456;
                } else {
                    i12 = PropertyOptions.DELETE_EXISTING;
                }
                i3 |= i12;
            }
            if ((1533916891 & i3) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i8 != 0) {
                        z5 = true;
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
                    }
                    if ((256 & i2) != 0) {
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        i3 &= -234881025;
                    } else {
                        jM1051getPrimary0d7_KjU = j;
                    }
                    if ((i2 & 512) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -1879048193;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1813548445, i3, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:146)");
                    }
                    ComposableLambda composableLambda = interfaceC0526Fp3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new NavigationRailKt$NavigationRailItem$styledLabel$1$1(interfaceC0526Fp3, i3)) : null;
                    if (interfaceC0526Fp3 == null) {
                        f = NavigationRailItemCompactSize;
                    } else {
                        f = NavigationRailItemSize;
                    }
                    Modifier modifierM532size3ABfNKs = SizeKt.m532size3ABfNKs(SelectableKt.m707selectableO2vRcR0(modifier2, z, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(false, 0.0f, jM1051getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m4543boximpl(Role.Companion.m4556getTabo7Vup1c()), interfaceC3588op), f);
                    Alignment center = Alignment.Companion.getCenter();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                    InterfaceC0526Fp interfaceC0526Fp5 = interfaceC0526Fp3;
                    constructor = companion.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierM532size3ABfNKs);
                    Modifier modifier4 = modifier2;
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    int i14 = i3 >> 24;
                    m1162NavigationRailTransitionKlgxPg(jM1051getPrimary0d7_KjU, jM3031copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new NavigationRailKt$NavigationRailItem$2$1(z5, interfaceC0526Fp, composableLambda, i3)), composerStartRestartGroup, (i14 & 112) | (i14 & 14) | 3072 | ((i3 << 6) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp4 = interfaceC0526Fp5;
                    z6 = z4;
                    z7 = z5;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((256 & i2) != 0) {
                        i3 &= -234881025;
                    }
                    if ((i2 & 512) != 0) {
                        i3 &= -1879048193;
                    }
                    modifier2 = modifier;
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    jM1051getPrimary0d7_KjU = j;
                }
                jM3031copywmQWz5c$default = j2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1813548445, i3, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:146)");
                }
                if (interfaceC0526Fp3 != null) {
                }
                if (interfaceC0526Fp3 == null) {
                    f = NavigationRailItemCompactSize;
                } else {
                    f = NavigationRailItemSize;
                }
                Modifier modifierM532size3ABfNKs2 = SizeKt.m532size3ABfNKs(SelectableKt.m707selectableO2vRcR0(modifier2, z, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(false, 0.0f, jM1051getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m4543boximpl(Role.Companion.m4556getTabo7Vup1c()), interfaceC3588op), f);
                Alignment center2 = Alignment.Companion.getCenter();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                InterfaceC0526Fp interfaceC0526Fp6 = interfaceC0526Fp3;
                constructor = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifierM532size3ABfNKs2);
                Modifier modifier5 = modifier2;
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                int i15 = i3 >> 24;
                m1162NavigationRailTransitionKlgxPg(jM1051getPrimary0d7_KjU, jM3031copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new NavigationRailKt$NavigationRailItem$2$1(z5, interfaceC0526Fp, composableLambda, i3)), composerStartRestartGroup, (i15 & 112) | (i15 & 14) | 3072 | ((i3 << 6) & 896));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp4 = interfaceC0526Fp6;
                z6 = z4;
                z7 = z5;
                modifier3 = modifier5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier;
                interfaceC0526Fp4 = interfaceC0526Fp2;
                jM1051getPrimary0d7_KjU = j;
                jM3031copywmQWz5c$default = j2;
                z6 = z4;
                z7 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new NavigationRailKt$NavigationRailItem$3(z, interfaceC3588op, interfaceC0526Fp, modifier3, z6, interfaceC0526Fp4, z7, mutableInteractionSource2, jM1051getPrimary0d7_KjU, jM3031copywmQWz5c$default, i, i2));
        }
        i3 |= 3072;
        i4 = 16 & i2;
        if (i4 != 0) {
            i3 |= 24576;
            z4 = z2;
        } else {
            z4 = z2;
            if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changed(z4)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
        }
        i6 = 32 & i2;
        if (i6 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & 458752) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                i7 = 131072;
            } else {
                i7 = 65536;
            }
            i3 |= i7;
        }
        i8 = i2 & 64;
        if (i8 != 0) {
            i3 |= 1572864;
            z5 = z3;
        } else {
            z5 = z3;
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(z5)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
        }
        i10 = 128 & i2;
        if (i10 != 0) {
            i3 |= 12582912;
            mutableInteractionSource2 = mutableInteractionSource;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
        }
        if ((i & 234881024) != 0) {
            i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
        }
        if ((1879048192 & i) != 0) {
            if ((i2 & 512) == 0) {
                i12 = 268435456;
            } else {
                i12 = 268435456;
            }
            i3 |= i12;
        }
        if ((1533916891 & i3) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z4 = true;
                }
                if (i6 != 0) {
                    interfaceC0526Fp3 = null;
                } else {
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                }
                if (i8 != 0) {
                    z5 = true;
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
                }
                if ((256 & i2) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    i3 &= -234881025;
                } else {
                    jM1051getPrimary0d7_KjU = j;
                }
                if ((i2 & 512) != 0) {
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    i3 &= -1879048193;
                } else {
                    jM3031copywmQWz5c$default = j2;
                }
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z4 = true;
                }
                if (i6 != 0) {
                    interfaceC0526Fp3 = null;
                } else {
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                }
                if (i8 != 0) {
                    z5 = true;
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
                }
                if ((256 & i2) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    i3 &= -234881025;
                } else {
                    jM1051getPrimary0d7_KjU = j;
                }
                if ((i2 & 512) != 0) {
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    i3 &= -1879048193;
                } else {
                    jM3031copywmQWz5c$default = j2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1813548445, i3, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:146)");
            }
            if (interfaceC0526Fp3 != null) {
            }
            if (interfaceC0526Fp3 == null) {
                f = NavigationRailItemCompactSize;
            } else {
                f = NavigationRailItemSize;
            }
            Modifier modifierM532size3ABfNKs3 = SizeKt.m532size3ABfNKs(SelectableKt.m707selectableO2vRcR0(modifier2, z, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(false, 0.0f, jM1051getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m4543boximpl(Role.Companion.m4556getTabo7Vup1c()), interfaceC3588op), f);
            Alignment center3 = Alignment.Companion.getCenter();
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(center3, false, composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            InterfaceC0526Fp interfaceC0526Fp7 = interfaceC0526Fp3;
            constructor = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifierM532size3ABfNKs3);
            Modifier modifier6 = modifier2;
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy3, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting()) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            int i16 = i3 >> 24;
            m1162NavigationRailTransitionKlgxPg(jM1051getPrimary0d7_KjU, jM3031copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new NavigationRailKt$NavigationRailItem$2$1(z5, interfaceC0526Fp, composableLambda, i3)), composerStartRestartGroup, (i16 & 112) | (i16 & 14) | 3072 | ((i3 << 6) & 896));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC0526Fp4 = interfaceC0526Fp7;
            z6 = z4;
            z7 = z5;
            modifier3 = modifier6;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z4 = true;
                }
                if (i6 != 0) {
                    interfaceC0526Fp3 = null;
                } else {
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                }
                if (i8 != 0) {
                    z5 = true;
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
                }
                if ((256 & i2) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    i3 &= -234881025;
                } else {
                    jM1051getPrimary0d7_KjU = j;
                }
                if ((i2 & 512) != 0) {
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    i3 &= -1879048193;
                } else {
                    jM3031copywmQWz5c$default = j2;
                }
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z4 = true;
                }
                if (i6 != 0) {
                    interfaceC0526Fp3 = null;
                } else {
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                }
                if (i8 != 0) {
                    z5 = true;
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
                }
                if ((256 & i2) != 0) {
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    i3 &= -234881025;
                } else {
                    jM1051getPrimary0d7_KjU = j;
                }
                if ((i2 & 512) != 0) {
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    i3 &= -1879048193;
                } else {
                    jM3031copywmQWz5c$default = j2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1813548445, i3, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:146)");
            }
            if (interfaceC0526Fp3 != null) {
            }
            if (interfaceC0526Fp3 == null) {
                f = NavigationRailItemCompactSize;
            } else {
                f = NavigationRailItemSize;
            }
            Modifier modifierM532size3ABfNKs4 = SizeKt.m532size3ABfNKs(SelectableKt.m707selectableO2vRcR0(modifier2, z, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(false, 0.0f, jM1051getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m4543boximpl(Role.Companion.m4556getTabo7Vup1c()), interfaceC3588op), f);
            Alignment center4 = Alignment.Companion.getCenter();
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(center4, false, composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion4 = ComposeUiNode.Companion;
            InterfaceC0526Fp interfaceC0526Fp8 = interfaceC0526Fp3;
            constructor = companion4.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(modifierM532size3ABfNKs4);
            Modifier modifier7 = modifier2;
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy4, companion4.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap4, companion4.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion4.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting()) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf4.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
            int i17 = i3 >> 24;
            m1162NavigationRailTransitionKlgxPg(jM1051getPrimary0d7_KjU, jM3031copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new NavigationRailKt$NavigationRailItem$2$1(z5, interfaceC0526Fp, composableLambda, i3)), composerStartRestartGroup, (i17 & 112) | (i17 & 14) | 3072 | ((i3 << 6) & 896));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC0526Fp4 = interfaceC0526Fp8;
            z6 = z4;
            z7 = z5;
            modifier3 = modifier7;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new NavigationRailKt$NavigationRailItem$3(z, interfaceC3588op, interfaceC0526Fp, modifier3, z6, interfaceC0526Fp4, z7, mutableInteractionSource2, jM1051getPrimary0d7_KjU, jM3031copywmQWz5c$default, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void NavigationRailItemBaselineLayout(InterfaceC0526Fp interfaceC0526Fp, final InterfaceC0526Fp interfaceC0526Fp2, final float f, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1903861684);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 256 : 128;
        }
        if ((i2 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1903861684, i2, -1, "androidx.compose.material.NavigationRailItemBaselineLayout (NavigationRail.kt:258)");
            }
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material.NavigationRailKt.NavigationRailItemBaselineLayout.2
                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                    return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i3);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                    return AbstractC2260gB.b(this, intrinsicMeasureScope, list, i3);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                    Placeable placeableMo4159measureBRTryo0;
                    Measurable measurable;
                    AbstractC4492zt.h(measureScope, "$this$Layout");
                    AbstractC4492zt.h(list, "measurables");
                    List<? extends Measurable> list2 = list;
                    for (Measurable measurable2 : list2) {
                        if (AbstractC4492zt.d(LayoutIdKt.getLayoutId(measurable2), "icon")) {
                            Placeable placeableMo4159measureBRTryo1 = measurable2.mo4159measureBRTryo0(j);
                            if (interfaceC0526Fp2 != null) {
                                Iterator<T> it = list2.iterator();
                                do {
                                    if (!it.hasNext()) {
                                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                    }
                                    measurable = (Measurable) it.next();
                                } while (!AbstractC4492zt.d(LayoutIdKt.getLayoutId(measurable), HTML.Tag.LABEL));
                                placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(Constraints.m5119copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                            } else {
                                placeableMo4159measureBRTryo0 = null;
                            }
                            if (interfaceC0526Fp2 == null) {
                                return NavigationRailKt.m1166placeIcon3p2s80s(measureScope, placeableMo4159measureBRTryo1, j);
                            }
                            AbstractC4492zt.e(placeableMo4159measureBRTryo0);
                            return NavigationRailKt.m1167placeLabelAndIconDIyivk0(measureScope, placeableMo4159measureBRTryo0, placeableMo4159measureBRTryo1, j, f);
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                    return AbstractC2260gB.c(this, intrinsicMeasureScope, list, i3);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                    return AbstractC2260gB.d(this, intrinsicMeasureScope, list, i3);
                }
            };
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Modifier.Companion companion = Modifier.Companion;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            InterfaceC0526Fp setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            Modifier modifierLayoutId = LayoutIdKt.layoutId(companion, "icon");
            composerStartRestartGroup.startReplaceableGroup(733328855);
            Alignment.Companion companion3 = Alignment.Companion;
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            InterfaceC3588op constructor2 = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifierLayoutId);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            InterfaceC0526Fp setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
            if (composerM2661constructorimpl2.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            interfaceC0552GpModifierMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf(i2 & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(286683862);
            if (interfaceC0526Fp2 != null) {
                Modifier modifierAlpha = AlphaKt.alpha(LayoutIdKt.layoutId(companion, HTML.Tag.LABEL), f);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                InterfaceC3588op constructor3 = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifierAlpha);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM2661constructorimpl3 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyRememberBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl3, currentCompositionLocalMap3, companion2.getSetResolvedCompositionLocals());
                InterfaceC0526Fp setCompositeKeyHash3 = companion2.getSetCompositeKeyHash();
                if (composerM2661constructorimpl3.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    composerM2661constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM2661constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                interfaceC0552GpModifierMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC0526Fp, interfaceC0526Fp2, f, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    /* JADX INFO: renamed from: NavigationRailTransition-Klgx-Pg, reason: not valid java name */
    public static final void m1162NavigationRailTransitionKlgxPg(long j, long j2, boolean z, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-207161906);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0552Gp) ? 2048 : 1024;
        }
        int i3 = i2;
        if ((i3 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-207161906, i3, -1, "androidx.compose.material.NavigationRailTransition (NavigationRail.kt:226)");
            }
            composer2 = composerStartRestartGroup;
            State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, NavigationRailAnimationSpec, 0.0f, null, null, composerStartRestartGroup, 48, 28);
            long jM3083lerpjxsXWHM = ColorKt.m3083lerpjxsXWHM(j2, j, NavigationRailTransition_Klgx_Pg$lambda$3(stateAnimateFloatAsState));
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(Color.m3031copywmQWz5c$default(jM3083lerpjxsXWHM, 1.0f, 0.0f, 0.0f, 0.0f, 14, null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m3034getAlphaimpl(jM3083lerpjxsXWHM)))}, ComposableLambdaKt.composableLambda(composer2, -1688205042, true, new NavigationRailKt$NavigationRailTransition$1(interfaceC0552Gp, i3, stateAnimateFloatAsState)), composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new NavigationRailKt$NavigationRailTransition$2(j, j2, z, interfaceC0552Gp, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float NavigationRailTransition_Klgx_Pg$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeIcon-3p2s80s, reason: not valid java name */
    public static final MeasureResult m1166placeIcon3p2s80s(MeasureScope measureScope, Placeable placeable, long j) {
        return MeasureScope.CC.q(measureScope, Constraints.m5128getMaxWidthimpl(j), Constraints.m5127getMaxHeightimpl(j), null, new NavigationRailKt$placeIcon$1(placeable, Math.max(0, (Constraints.m5128getMaxWidthimpl(j) - placeable.getWidth()) / 2), Math.max(0, (Constraints.m5127getMaxHeightimpl(j) - placeable.getHeight()) / 2)), 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeLabelAndIcon-DIyivk0, reason: not valid java name */
    public static final MeasureResult m1167placeLabelAndIconDIyivk0(MeasureScope measureScope, Placeable placeable, Placeable placeable2, long j, float f) {
        int iM5127getMaxHeightimpl = (Constraints.m5127getMaxHeightimpl(j) - placeable.get(AlignmentLineKt.getLastBaseline())) - measureScope.mo327roundToPx0680j_4(ItemLabelBaselineBottomOffset);
        int iM5128getMaxWidthimpl = (Constraints.m5128getMaxWidthimpl(j) - placeable.getWidth()) / 2;
        int iMo327roundToPx0680j_4 = measureScope.mo327roundToPx0680j_4(ItemIconTopOffset);
        int iM5127getMaxHeightimpl2 = (Constraints.m5127getMaxHeightimpl(j) - placeable2.getHeight()) / 2;
        return MeasureScope.CC.q(measureScope, Constraints.m5128getMaxWidthimpl(j), Constraints.m5127getMaxHeightimpl(j), null, new NavigationRailKt$placeLabelAndIcon$1(f, placeable, iM5128getMaxWidthimpl, iM5127getMaxHeightimpl, AbstractC1210aB.c((iM5127getMaxHeightimpl2 - iMo327roundToPx0680j_4) * (1 - f)), placeable2, (Constraints.m5128getMaxWidthimpl(j) - placeable2.getWidth()) / 2, iMo327roundToPx0680j_4), 4, null);
    }
}
