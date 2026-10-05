package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
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
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC3955tM;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class BottomNavigationKt {
    private static final TweenSpec<Float> BottomNavigationAnimationSpec = new TweenSpec<>(300, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
    private static final float BottomNavigationHeight = Dp.m5160constructorimpl(56);
    private static final float BottomNavigationItemHorizontalPadding;
    private static final float CombinedItemTextBaseline;

    /* JADX INFO: renamed from: androidx.compose.material.BottomNavigationKt$BottomNavigationItemBaselineLayout$3, reason: invalid class name */
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
            BottomNavigationKt.BottomNavigationItemBaselineLayout(this.$icon, this.$label, this.$iconPositionAnimationProgress, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    static {
        float f = 12;
        BottomNavigationItemHorizontalPadding = Dp.m5160constructorimpl(f);
        CombinedItemTextBaseline = Dp.m5160constructorimpl(f);
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088  */
    /* JADX WARN: Code duplicated, block: B:51:0x008e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:54:0x0097  */
    /* JADX WARN: Code duplicated, block: B:62:0x00af  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ce A[PHI: r2 r4 r5 r9
      0x00ce: PHI (r2v5 androidx.compose.ui.Modifier) = (r2v2 androidx.compose.ui.Modifier), (r2v8 androidx.compose.ui.Modifier) binds: [B:85:0x00fb, B:73:0x00cd] A[DONT_GENERATE, DONT_INLINE]
      0x00ce: PHI (r4v18 int) = (r4v14 int), (r4v20 int) binds: [B:85:0x00fb, B:73:0x00cd] A[DONT_GENERATE, DONT_INLINE]
      0x00ce: PHI (r5v6 long) = (r5v3 long), (r5v2 long) binds: [B:85:0x00fb, B:73:0x00cd] A[DONT_GENERATE, DONT_INLINE]
      0x00ce: PHI (r9v11 long) = (r9v3 long), (r9v2 long) binds: [B:85:0x00fb, B:73:0x00cd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:76:0x00d6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:78:0x00db  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:89:0x010f  */
    /* JADX WARN: Code duplicated, block: B:92:0x0149  */
    /* JADX WARN: Code duplicated, block: B:97:0x0156  */
    /* JADX WARN: Code duplicated, block: B:99:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: BottomNavigation-PEIptTM, reason: not valid java name */
    public static final void m996BottomNavigationPEIptTM(Modifier modifier, long j, long j2, float f, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        Modifier modifier2;
        int i3;
        long primarySurface;
        long jM1069contentColorForek8zF_U;
        float f2;
        int i4;
        Modifier modifier3;
        float fM995getElevationD9Ej5fM;
        int i5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(456489494);
        int i6 = i2 & 1;
        if (i6 != 0) {
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
                primarySurface = j;
                int i7 = composerStartRestartGroup.changed(primarySurface) ? 32 : 16;
                i3 |= i7;
            } else {
                primarySurface = j;
            }
            i3 |= i7;
        } else {
            primarySurface = j;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                jM1069contentColorForek8zF_U = j2;
                int i8 = composerStartRestartGroup.changed(jM1069contentColorForek8zF_U) ? 256 : 128;
                i3 |= i8;
            } else {
                jM1069contentColorForek8zF_U = j2;
            }
            i3 |= i8;
        } else {
            jM1069contentColorForek8zF_U = j2;
        }
        int i9 = i2 & 8;
        if (i9 == 0) {
            if ((i & 7168) == 0) {
                f2 = f;
                i3 |= composerStartRestartGroup.changed(f2) ? 2048 : 1024;
            }
            if ((i2 & 16) != 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i4 = 16384;
                } else {
                    i4 = 8192;
                }
                i3 |= i4;
            }
            if ((46811 & i3) == 9362 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i9 != 0) {
                        fM995getElevationD9Ej5fM = BottomNavigationDefaults.INSTANCE.m995getElevationD9Ej5fM();
                    }
                    long j3 = jM1069contentColorForek8zF_U;
                    i5 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(456489494, i5, -1, "androidx.compose.material.BottomNavigation (BottomNavigation.kt:89)");
                    }
                    int i10 = i5 << 3;
                    SurfaceKt.m1227SurfaceFjzlyU(modifier3, null, primarySurface, j3, null, fM995getElevationD9Ej5fM, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 678339930, true, new BottomNavigationKt$BottomNavigation$1(interfaceC0552Gp, i5)), composerStartRestartGroup, (i5 & 14) | 1572864 | (i10 & 896) | (i10 & 7168) | ((i5 << 6) & 458752), 18);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    jM1069contentColorForek8zF_U = j3;
                    f2 = fM995getElevationD9Ej5fM;
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
                fM995getElevationD9Ej5fM = f2;
                long j4 = jM1069contentColorForek8zF_U;
                i5 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(456489494, i5, -1, "androidx.compose.material.BottomNavigation (BottomNavigation.kt:89)");
                }
                int i11 = i5 << 3;
                SurfaceKt.m1227SurfaceFjzlyU(modifier3, null, primarySurface, j4, null, fM995getElevationD9Ej5fM, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 678339930, true, new BottomNavigationKt$BottomNavigation$1(interfaceC0552Gp, i5)), composerStartRestartGroup, (i5 & 14) | 1572864 | (i11 & 896) | (i11 & 7168) | ((i5 << 6) & 458752), 18);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                jM1069contentColorForek8zF_U = j4;
                f2 = fM995getElevationD9Ej5fM;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new BottomNavigationKt$BottomNavigation$2(modifier3, primarySurface, jM1069contentColorForek8zF_U, f2, interfaceC0552Gp, i, i2));
        }
        i3 |= 3072;
        f2 = f;
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((57344 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                i4 = 16384;
            } else {
                i4 = 8192;
            }
            i3 |= i4;
        }
        if ((46811 & i3) == 9362) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i9 != 0) {
                    fM995getElevationD9Ej5fM = BottomNavigationDefaults.INSTANCE.m995getElevationD9Ej5fM();
                } else {
                    fM995getElevationD9Ej5fM = f2;
                }
            } else {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i9 != 0) {
                    fM995getElevationD9Ej5fM = BottomNavigationDefaults.INSTANCE.m995getElevationD9Ej5fM();
                } else {
                    fM995getElevationD9Ej5fM = f2;
                }
            }
            long j5 = jM1069contentColorForek8zF_U;
            i5 = i3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(456489494, i5, -1, "androidx.compose.material.BottomNavigation (BottomNavigation.kt:89)");
            }
            int i12 = i5 << 3;
            SurfaceKt.m1227SurfaceFjzlyU(modifier3, null, primarySurface, j5, null, fM995getElevationD9Ej5fM, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 678339930, true, new BottomNavigationKt$BottomNavigation$1(interfaceC0552Gp, i5)), composerStartRestartGroup, (i5 & 14) | 1572864 | (i12 & 896) | (i12 & 7168) | ((i5 << 6) & 458752), 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            jM1069contentColorForek8zF_U = j5;
            f2 = fM995getElevationD9Ej5fM;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i9 != 0) {
                    fM995getElevationD9Ej5fM = BottomNavigationDefaults.INSTANCE.m995getElevationD9Ej5fM();
                } else {
                    fM995getElevationD9Ej5fM = f2;
                }
            } else {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i9 != 0) {
                    fM995getElevationD9Ej5fM = BottomNavigationDefaults.INSTANCE.m995getElevationD9Ej5fM();
                } else {
                    fM995getElevationD9Ej5fM = f2;
                }
            }
            long j6 = jM1069contentColorForek8zF_U;
            i5 = i3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(456489494, i5, -1, "androidx.compose.material.BottomNavigation (BottomNavigation.kt:89)");
            }
            int i13 = i5 << 3;
            SurfaceKt.m1227SurfaceFjzlyU(modifier3, null, primarySurface, j6, null, fM995getElevationD9Ej5fM, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 678339930, true, new BottomNavigationKt$BottomNavigation$1(interfaceC0552Gp, i5)), composerStartRestartGroup, (i5 & 14) | 1572864 | (i13 & 896) | (i13 & 7168) | ((i5 << 6) & 458752), 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            jM1069contentColorForek8zF_U = j6;
            f2 = fM995getElevationD9Ej5fM;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new BottomNavigationKt$BottomNavigation$2(modifier3, primarySurface, jM1069contentColorForek8zF_U, f2, interfaceC0552Gp, i, i2));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: BottomNavigationItem-jY6E1Zs, reason: not valid java name */
    public static final void m997BottomNavigationItemjY6E1Zs(RowScope rowScope, boolean z, InterfaceC3588op interfaceC3588op, InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, boolean z2, InterfaceC0526Fp interfaceC0526Fp2, boolean z3, MutableInteractionSource mutableInteractionSource, long j, long j2, Composer composer, int i, int i2, int i3) {
        int i4;
        Modifier modifier2;
        InterfaceC0526Fp interfaceC0526Fp3;
        int i5;
        Modifier modifier3;
        boolean z4;
        boolean z5;
        MutableInteractionSource mutableInteractionSource2;
        long jM3042unboximpl;
        long jM3031copywmQWz5c$default;
        MutableInteractionSource mutableInteractionSource3;
        boolean z6;
        long j3;
        InterfaceC0526Fp interfaceC0526Fp4;
        boolean z7;
        Modifier modifier4;
        AbstractC4492zt.h(rowScope, "$this$BottomNavigationItem");
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0526Fp, "icon");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1473735525);
        if ((Integer.MIN_VALUE & i3) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(rowScope) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 1) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i3 & 2) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC3588op) ? 256 : 128;
        }
        if ((i3 & 4) != 0) {
            i4 |= 3072;
        } else if ((i & 7168) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 2048 : 1024;
        }
        int i6 = i3 & 8;
        if (i6 != 0) {
            i4 |= 24576;
            modifier2 = modifier;
        } else {
            modifier2 = modifier;
            if ((i & 57344) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
        }
        int i7 = 16 & i3;
        if (i7 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & 458752) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? 131072 : 65536;
        }
        int i8 = 32 & i3;
        if (i8 != 0) {
            i4 |= 1572864;
            interfaceC0526Fp3 = interfaceC0526Fp2;
        } else {
            interfaceC0526Fp3 = interfaceC0526Fp2;
            if ((i & 3670016) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp3) ? 1048576 : 524288;
            }
        }
        int i9 = i3 & 64;
        if (i9 != 0) {
            i4 |= 12582912;
        } else if ((i & 29360128) == 0) {
            i4 |= composerStartRestartGroup.changed(z3) ? 8388608 : 4194304;
        }
        int i10 = 128 & i3;
        if (i10 != 0) {
            i4 |= 100663296;
        } else if ((i & 234881024) == 0) {
            i4 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
        }
        if ((i & 1879048192) == 0) {
            i4 |= ((i3 & 256) == 0 && composerStartRestartGroup.changed(j)) ? PropertyOptions.DELETE_EXISTING : 268435456;
        }
        if ((i2 & 14) == 0) {
            i5 = i2 | (((i3 & 512) == 0 && composerStartRestartGroup.changed(j2)) ? 4 : 2);
        } else {
            i5 = i2;
        }
        if ((1533916891 & i4) == 306783378 && (i5 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            z6 = z2;
            z7 = z3;
            mutableInteractionSource3 = mutableInteractionSource;
            jM3042unboximpl = j;
            modifier4 = modifier2;
            interfaceC0526Fp4 = interfaceC0526Fp3;
            j3 = j2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                modifier3 = i6 != 0 ? Modifier.Companion : modifier2;
                z4 = i7 != 0 ? true : z2;
                if (i8 != 0) {
                    interfaceC0526Fp3 = null;
                }
                z5 = i9 != 0 ? true : z3;
                if (i10 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
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
                    jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                    i4 &= -1879048193;
                } else {
                    jM3042unboximpl = j;
                }
                if ((i3 & 512) != 0) {
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    i5 &= -15;
                } else {
                    jM3031copywmQWz5c$default = j2;
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((256 & i3) != 0) {
                    i4 &= -1879048193;
                }
                if ((i3 & 512) != 0) {
                    i5 &= -15;
                }
                z4 = z2;
                z5 = z3;
                mutableInteractionSource2 = mutableInteractionSource;
                jM3042unboximpl = j;
                jM3031copywmQWz5c$default = j2;
                modifier3 = modifier2;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1473735525, i4, i5, "androidx.compose.material.BottomNavigationItem (BottomNavigation.kt:146)");
            }
            ComposableLambda composableLambda = interfaceC0526Fp3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new BottomNavigationKt$BottomNavigationItem$styledLabel$1$1(interfaceC0526Fp3, i4)) : null;
            Modifier modifierA = AbstractC3955tM.a(rowScope, SelectableKt.m707selectableO2vRcR0(modifier3, z, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(false, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m4543boximpl(Role.Companion.m4556getTabo7Vup1c()), interfaceC3588op), 1.0f, false, 2, null);
            Alignment center = Alignment.Companion.getCenter();
            MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
            composerStartRestartGroup.startReplaceableGroup(733328855);
            boolean z8 = z4;
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Modifier modifier5 = modifier3;
            InterfaceC3588op constructor = companion.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierA);
            InterfaceC0526Fp interfaceC0526Fp5 = interfaceC0526Fp3;
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
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            InterfaceC0526Fp setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            m998BottomNavigationTransitionKlgxPg(jM3042unboximpl, jM3031copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new BottomNavigationKt$BottomNavigationItem$2$1(z5, interfaceC0526Fp, composableLambda, i4)), composerStartRestartGroup, ((i5 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            mutableInteractionSource3 = mutableInteractionSource4;
            z6 = z8;
            j3 = jM3031copywmQWz5c$default;
            interfaceC0526Fp4 = interfaceC0526Fp5;
            z7 = z5;
            modifier4 = modifier5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new BottomNavigationKt$BottomNavigationItem$3(rowScope, z, interfaceC3588op, interfaceC0526Fp, modifier4, z6, interfaceC0526Fp4, z7, mutableInteractionSource3, jM3042unboximpl, j3, i, i2, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void BottomNavigationItemBaselineLayout(InterfaceC0526Fp interfaceC0526Fp, final InterfaceC0526Fp interfaceC0526Fp2, final float f, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1162995092);
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
                ComposerKt.traceEventStart(-1162995092, i2, -1, "androidx.compose.material.BottomNavigationItemBaselineLayout (BottomNavigation.kt:253)");
            }
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material.BottomNavigationKt.BottomNavigationItemBaselineLayout.2
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
                                return BottomNavigationKt.m1002placeIcon3p2s80s(measureScope, placeableMo4159measureBRTryo1, j);
                            }
                            AbstractC4492zt.e(placeableMo4159measureBRTryo0);
                            return BottomNavigationKt.m1003placeLabelAndIconDIyivk0(measureScope, placeableMo4159measureBRTryo0, placeableMo4159measureBRTryo1, j, f);
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
            composerStartRestartGroup.startReplaceableGroup(-1198312436);
            if (interfaceC0526Fp2 != null) {
                Modifier modifierM487paddingVpY3zN4$default = PaddingKt.m487paddingVpY3zN4$default(AlphaKt.alpha(LayoutIdKt.layoutId(companion, HTML.Tag.LABEL), f), BottomNavigationItemHorizontalPadding, 0.0f, 2, null);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                InterfaceC3588op constructor3 = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifierM487paddingVpY3zN4$default);
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
    /* JADX INFO: renamed from: BottomNavigationTransition-Klgx-Pg, reason: not valid java name */
    public static final void m998BottomNavigationTransitionKlgxPg(long j, long j2, boolean z, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-985175058);
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
                ComposerKt.traceEventStart(-985175058, i3, -1, "androidx.compose.material.BottomNavigationTransition (BottomNavigation.kt:221)");
            }
            composer2 = composerStartRestartGroup;
            State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, BottomNavigationAnimationSpec, 0.0f, null, null, composerStartRestartGroup, 48, 28);
            long jM3083lerpjxsXWHM = ColorKt.m3083lerpjxsXWHM(j2, j, BottomNavigationTransition_Klgx_Pg$lambda$3(stateAnimateFloatAsState));
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(Color.m3031copywmQWz5c$default(jM3083lerpjxsXWHM, 1.0f, 0.0f, 0.0f, 0.0f, 14, null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m3034getAlphaimpl(jM3083lerpjxsXWHM)))}, ComposableLambdaKt.composableLambda(composer2, -138092754, true, new BottomNavigationKt$BottomNavigationTransition$1(interfaceC0552Gp, i3, stateAnimateFloatAsState)), composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new BottomNavigationKt$BottomNavigationTransition$2(j, j2, z, interfaceC0552Gp, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float BottomNavigationTransition_Klgx_Pg$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeIcon-3p2s80s, reason: not valid java name */
    public static final MeasureResult m1002placeIcon3p2s80s(MeasureScope measureScope, Placeable placeable, long j) {
        int iM5127getMaxHeightimpl = Constraints.m5127getMaxHeightimpl(j);
        return MeasureScope.CC.q(measureScope, placeable.getWidth(), iM5127getMaxHeightimpl, null, new BottomNavigationKt$placeIcon$1(placeable, (iM5127getMaxHeightimpl - placeable.getHeight()) / 2), 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeLabelAndIcon-DIyivk0, reason: not valid java name */
    public static final MeasureResult m1003placeLabelAndIconDIyivk0(MeasureScope measureScope, Placeable placeable, Placeable placeable2, long j, float f) {
        int iM5127getMaxHeightimpl = Constraints.m5127getMaxHeightimpl(j);
        int iMo327roundToPx0680j_4 = measureScope.mo327roundToPx0680j_4(CombinedItemTextBaseline) - placeable.get(AlignmentLineKt.getFirstBaseline());
        int iD = AbstractC3871sJ.d((iM5127getMaxHeightimpl - ((placeable2.getHeight() + placeable.getHeight()) + iMo327roundToPx0680j_4)) / 2, 0);
        int height = (iM5127getMaxHeightimpl - placeable2.getHeight()) / 2;
        int height2 = placeable2.getHeight() + iD + iMo327roundToPx0680j_4;
        int iMax = Math.max(placeable.getWidth(), placeable2.getWidth());
        return MeasureScope.CC.q(measureScope, iMax, iM5127getMaxHeightimpl, null, new BottomNavigationKt$placeLabelAndIcon$1(f, placeable, (iMax - placeable.getWidth()) / 2, height2, AbstractC1210aB.c((height - iD) * (1 - f)), placeable2, (iMax - placeable2.getWidth()) / 2, iD), 4, null);
    }
}
