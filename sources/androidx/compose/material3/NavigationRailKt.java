package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.tokens.NavigationRailTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
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
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
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
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes.dex */
public final class NavigationRailKt {
    private static final String IconLayoutIdTag = "icon";
    private static final float IndicatorHorizontalPadding;
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalPaddingNoLabel;
    private static final float IndicatorVerticalPaddingWithLabel;
    private static final int ItemAnimationDurationMillis = 150;
    private static final String LabelLayoutIdTag = "label";
    private static final float NavigationRailHeaderPadding = Dp.m5160constructorimpl(8);
    private static final float NavigationRailItemHeight;
    private static final float NavigationRailItemVerticalPadding;
    private static final float NavigationRailItemWidth;
    private static final float NavigationRailVerticalPadding;

    /* JADX INFO: renamed from: androidx.compose.material3.NavigationRailKt$NavigationRailItem$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ boolean $alwaysShowLabel;
        final /* synthetic */ NavigationRailItemColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ InterfaceC0526Fp $icon;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ InterfaceC0526Fp $label;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3588op $onClick;
        final /* synthetic */ boolean $selected;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(boolean z, InterfaceC3588op interfaceC3588op, InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, boolean z2, InterfaceC0526Fp interfaceC0526Fp2, boolean z3, NavigationRailItemColors navigationRailItemColors, MutableInteractionSource mutableInteractionSource, int i, int i2) {
            super(2);
            this.$selected = z;
            this.$onClick = interfaceC3588op;
            this.$icon = interfaceC0526Fp;
            this.$modifier = modifier;
            this.$enabled = z2;
            this.$label = interfaceC0526Fp2;
            this.$alwaysShowLabel = z3;
            this.$colors = navigationRailItemColors;
            this.$interactionSource = mutableInteractionSource;
            this.$$changed = i;
            this.$$default = i2;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            NavigationRailKt.NavigationRailItem(this.$selected, this.$onClick, this.$icon, this.$modifier, this.$enabled, this.$label, this.$alwaysShowLabel, this.$colors, this.$interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.NavigationRailKt$NavigationRailItemBaselineLayout$3, reason: invalid class name and case insensitive filesystem */
    public static final class C15383 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ boolean $alwaysShowLabel;
        final /* synthetic */ float $animationProgress;
        final /* synthetic */ InterfaceC0526Fp $icon;
        final /* synthetic */ InterfaceC0526Fp $indicator;
        final /* synthetic */ InterfaceC0526Fp $indicatorRipple;
        final /* synthetic */ InterfaceC0526Fp $label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15383(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, boolean z, float f, int i) {
            super(2);
            this.$indicatorRipple = interfaceC0526Fp;
            this.$indicator = interfaceC0526Fp2;
            this.$icon = interfaceC0526Fp3;
            this.$label = interfaceC0526Fp4;
            this.$alwaysShowLabel = z;
            this.$animationProgress = f;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            NavigationRailKt.NavigationRailItemBaselineLayout(this.$indicatorRipple, this.$indicator, this.$icon, this.$label, this.$alwaysShowLabel, this.$animationProgress, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    static {
        float f = 4;
        NavigationRailVerticalPadding = Dp.m5160constructorimpl(f);
        NavigationRailTokens navigationRailTokens = NavigationRailTokens.INSTANCE;
        NavigationRailItemWidth = navigationRailTokens.m2366getContainerWidthD9Ej5fM();
        NavigationRailItemHeight = navigationRailTokens.m2369getNoLabelActiveIndicatorHeightD9Ej5fM();
        NavigationRailItemVerticalPadding = Dp.m5160constructorimpl(f);
        float f2 = 2;
        IndicatorHorizontalPadding = Dp.m5160constructorimpl(Dp.m5160constructorimpl(navigationRailTokens.m2364getActiveIndicatorWidthD9Ej5fM() - navigationRailTokens.m2367getIconSizeD9Ej5fM()) / f2);
        IndicatorVerticalPaddingWithLabel = Dp.m5160constructorimpl(Dp.m5160constructorimpl(navigationRailTokens.m2363getActiveIndicatorHeightD9Ej5fM() - navigationRailTokens.m2367getIconSizeD9Ej5fM()) / f2);
        IndicatorVerticalPaddingNoLabel = Dp.m5160constructorimpl(Dp.m5160constructorimpl(navigationRailTokens.m2369getNoLabelActiveIndicatorHeightD9Ej5fM() - navigationRailTokens.m2367getIconSizeD9Ej5fM()) / f2);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0124  */
    /* JADX WARN: Code duplicated, block: B:105:0x0137  */
    /* JADX WARN: Code duplicated, block: B:108:0x0170  */
    /* JADX WARN: Code duplicated, block: B:113:0x017c  */
    /* JADX WARN: Code duplicated, block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x0085  */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:51:0x0091  */
    /* JADX WARN: Code duplicated, block: B:52:0x0094  */
    /* JADX WARN: Code duplicated, block: B:55:0x009a  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:64:0x00af  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:68:0x00be  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f2 A[PHI: r2 r4 r5 r10 r12
      0x00f2: PHI (r2v5 androidx.compose.ui.Modifier) = (r2v2 androidx.compose.ui.Modifier), (r2v9 androidx.compose.ui.Modifier) binds: [B:101:0x0122, B:86:0x00f1] A[DONT_GENERATE, DONT_INLINE]
      0x00f2: PHI (r4v19 int) = (r4v14 int), (r4v22 int) binds: [B:101:0x0122, B:86:0x00f1] A[DONT_GENERATE, DONT_INLINE]
      0x00f2: PHI (r5v6 long) = (r5v3 long), (r5v2 long) binds: [B:101:0x0122, B:86:0x00f1] A[DONT_GENERATE, DONT_INLINE]
      0x00f2: PHI (r10v11 long) = (r10v2 long), (r10v1 long) binds: [B:101:0x0122, B:86:0x00f1] A[DONT_GENERATE, DONT_INLINE]
      0x00f2: PHI (r12v8 Gp) = (r12v3 Gp), (r12v2 Gp) binds: [B:101:0x0122, B:86:0x00f1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:89:0x00fa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:90:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:91:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:94:0x0105  */
    /* JADX WARN: Code duplicated, block: B:97:0x0111  */
    /* JADX WARN: Code duplicated, block: B:99:0x011e  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: NavigationRail-qi6gXK8, reason: not valid java name */
    public static final void m1679NavigationRailqi6gXK8(Modifier modifier, long j, long j2, InterfaceC0552Gp interfaceC0552Gp, WindowInsets windowInsets, InterfaceC0552Gp interfaceC0552Gp2, Composer composer, int i, int i2) {
        Modifier modifier2;
        int i3;
        long containerColor;
        long jM1449contentColorForek8zF_U;
        InterfaceC0552Gp interfaceC0552Gp3;
        WindowInsets windowInsets2;
        int i4;
        Modifier modifier3;
        WindowInsets windowInsets3;
        InterfaceC0552Gp interfaceC0552Gp4;
        int i5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0552Gp2, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(118552648);
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
                containerColor = j;
                int i7 = composerStartRestartGroup.changed(containerColor) ? 32 : 16;
                i3 |= i7;
            } else {
                containerColor = j;
            }
            i3 |= i7;
        } else {
            containerColor = j;
        }
        if ((i & 896) == 0) {
            jM1449contentColorForek8zF_U = j2;
            i3 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(jM1449contentColorForek8zF_U)) ? 256 : 128;
        } else {
            jM1449contentColorForek8zF_U = j2;
        }
        int i8 = i2 & 8;
        if (i8 == 0) {
            if ((i & 7168) == 0) {
                interfaceC0552Gp3 = interfaceC0552Gp;
                i3 |= composerStartRestartGroup.changedInstance(interfaceC0552Gp3) ? 2048 : 1024;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    windowInsets2 = windowInsets;
                    int i9 = composerStartRestartGroup.changed(windowInsets2) ? 16384 : 8192;
                    i3 |= i9;
                } else {
                    windowInsets2 = windowInsets;
                }
                i3 |= i9;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((i2 & 32) != 0) {
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                        i4 = 131072;
                    } else {
                        i4 = 65536;
                    }
                }
                if ((374491 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i6 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            containerColor = NavigationRailDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i8 != 0) {
                            interfaceC0552Gp3 = null;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            windowInsets3 = NavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                            interfaceC0552Gp4 = interfaceC0552Gp3;
                        }
                        long j3 = jM1449contentColorForek8zF_U;
                        i5 = i3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(118552648, i5, -1, "androidx.compose.material3.NavigationRail (NavigationRail.kt:100)");
                        }
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2092683357, true, new NavigationRailKt$NavigationRail$1(windowInsets3, interfaceC0552Gp4, i5, interfaceC0552Gp2));
                        int i10 = (i5 & 14) | 12582912;
                        int i11 = i5 << 3;
                        int i12 = i10 | (i11 & 896) | (i11 & 7168);
                        WindowInsets windowInsets4 = windowInsets3;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier3, null, containerColor, j3, 0.0f, 0.0f, null, composableLambda, composerStartRestartGroup, i12, 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets2 = windowInsets4;
                        jM1449contentColorForek8zF_U = j3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        modifier3 = modifier2;
                    }
                    interfaceC0552Gp4 = interfaceC0552Gp3;
                    windowInsets3 = windowInsets2;
                    long j4 = jM1449contentColorForek8zF_U;
                    i5 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(118552648, i5, -1, "androidx.compose.material3.NavigationRail (NavigationRail.kt:100)");
                    }
                    ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2092683357, true, new NavigationRailKt$NavigationRail$1(windowInsets3, interfaceC0552Gp4, i5, interfaceC0552Gp2));
                    int i13 = (i5 & 14) | 12582912;
                    int i14 = i5 << 3;
                    int i15 = i13 | (i14 & 896) | (i14 & 7168);
                    WindowInsets windowInsets5 = windowInsets3;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier3, null, containerColor, j4, 0.0f, 0.0f, null, composableLambda2, composerStartRestartGroup, i15, 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets2 = windowInsets5;
                    jM1449contentColorForek8zF_U = j4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    interfaceC0552Gp4 = interfaceC0552Gp3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new NavigationRailKt$NavigationRail$2(modifier3, containerColor, jM1449contentColorForek8zF_U, interfaceC0552Gp4, windowInsets2, interfaceC0552Gp2, i, i2));
            }
            i4 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i4;
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        containerColor = NavigationRailDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i8 != 0) {
                        interfaceC0552Gp3 = null;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        windowInsets3 = NavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                    } else {
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                        windowInsets3 = windowInsets2;
                    }
                } else {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        containerColor = NavigationRailDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i8 != 0) {
                        interfaceC0552Gp3 = null;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        windowInsets3 = NavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                    } else {
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                        windowInsets3 = windowInsets2;
                    }
                }
                long j5 = jM1449contentColorForek8zF_U;
                i5 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(118552648, i5, -1, "androidx.compose.material3.NavigationRail (NavigationRail.kt:100)");
                }
                ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2092683357, true, new NavigationRailKt$NavigationRail$1(windowInsets3, interfaceC0552Gp4, i5, interfaceC0552Gp2));
                int i16 = (i5 & 14) | 12582912;
                int i17 = i5 << 3;
                int i18 = i16 | (i17 & 896) | (i17 & 7168);
                WindowInsets windowInsets6 = windowInsets3;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier3, null, containerColor, j5, 0.0f, 0.0f, null, composableLambda3, composerStartRestartGroup, i18, 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets2 = windowInsets6;
                jM1449contentColorForek8zF_U = j5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        containerColor = NavigationRailDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i8 != 0) {
                        interfaceC0552Gp3 = null;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        windowInsets3 = NavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                    } else {
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                        windowInsets3 = windowInsets2;
                    }
                } else {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        containerColor = NavigationRailDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i8 != 0) {
                        interfaceC0552Gp3 = null;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        windowInsets3 = NavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                    } else {
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                        windowInsets3 = windowInsets2;
                    }
                }
                long j6 = jM1449contentColorForek8zF_U;
                i5 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(118552648, i5, -1, "androidx.compose.material3.NavigationRail (NavigationRail.kt:100)");
                }
                ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2092683357, true, new NavigationRailKt$NavigationRail$1(windowInsets3, interfaceC0552Gp4, i5, interfaceC0552Gp2));
                int i19 = (i5 & 14) | 12582912;
                int i110 = i5 << 3;
                int i111 = i19 | (i110 & 896) | (i110 & 7168);
                WindowInsets windowInsets7 = windowInsets3;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier3, null, containerColor, j6, 0.0f, 0.0f, null, composableLambda4, composerStartRestartGroup, i111, 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets2 = windowInsets7;
                jM1449contentColorForek8zF_U = j6;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new NavigationRailKt$NavigationRail$2(modifier3, containerColor, jM1449contentColorForek8zF_U, interfaceC0552Gp4, windowInsets2, interfaceC0552Gp2, i, i2));
        }
        i3 |= 3072;
        interfaceC0552Gp3 = interfaceC0552Gp;
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                windowInsets2 = windowInsets;
                if (composerStartRestartGroup.changed(windowInsets2)) {
                }
                i3 |= i9;
            } else {
                windowInsets2 = windowInsets;
            }
            i3 |= i9;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((i2 & 32) != 0) {
            if ((458752 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                    i4 = 131072;
                } else {
                    i4 = 65536;
                }
            }
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        containerColor = NavigationRailDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i8 != 0) {
                        interfaceC0552Gp3 = null;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        windowInsets3 = NavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                    } else {
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                        windowInsets3 = windowInsets2;
                    }
                } else {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        containerColor = NavigationRailDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i8 != 0) {
                        interfaceC0552Gp3 = null;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        windowInsets3 = NavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                    } else {
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                        windowInsets3 = windowInsets2;
                    }
                }
                long j7 = jM1449contentColorForek8zF_U;
                i5 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(118552648, i5, -1, "androidx.compose.material3.NavigationRail (NavigationRail.kt:100)");
                }
                ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2092683357, true, new NavigationRailKt$NavigationRail$1(windowInsets3, interfaceC0552Gp4, i5, interfaceC0552Gp2));
                int i112 = (i5 & 14) | 12582912;
                int i113 = i5 << 3;
                int i114 = i112 | (i113 & 896) | (i113 & 7168);
                WindowInsets windowInsets8 = windowInsets3;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier3, null, containerColor, j7, 0.0f, 0.0f, null, composableLambda5, composerStartRestartGroup, i114, 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets2 = windowInsets8;
                jM1449contentColorForek8zF_U = j7;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        containerColor = NavigationRailDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i8 != 0) {
                        interfaceC0552Gp3 = null;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        windowInsets3 = NavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                    } else {
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                        windowInsets3 = windowInsets2;
                    }
                } else {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        containerColor = NavigationRailDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i8 != 0) {
                        interfaceC0552Gp3 = null;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        windowInsets3 = NavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                    } else {
                        interfaceC0552Gp4 = interfaceC0552Gp3;
                        windowInsets3 = windowInsets2;
                    }
                }
                long j8 = jM1449contentColorForek8zF_U;
                i5 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(118552648, i5, -1, "androidx.compose.material3.NavigationRail (NavigationRail.kt:100)");
                }
                ComposableLambda composableLambda6 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2092683357, true, new NavigationRailKt$NavigationRail$1(windowInsets3, interfaceC0552Gp4, i5, interfaceC0552Gp2));
                int i115 = (i5 & 14) | 12582912;
                int i116 = i5 << 3;
                int i117 = i115 | (i116 & 896) | (i116 & 7168);
                WindowInsets windowInsets9 = windowInsets3;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier3, null, containerColor, j8, 0.0f, 0.0f, null, composableLambda6, composerStartRestartGroup, i117, 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets2 = windowInsets9;
                jM1449contentColorForek8zF_U = j8;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new NavigationRailKt$NavigationRail$2(modifier3, containerColor, jM1449contentColorForek8zF_U, interfaceC0552Gp4, windowInsets2, interfaceC0552Gp2, i, i2));
        }
        i4 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i3 |= i4;
        if ((374491 & i3) == 74898) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    containerColor = NavigationRailDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i8 != 0) {
                    interfaceC0552Gp3 = null;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    windowInsets3 = NavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    interfaceC0552Gp4 = interfaceC0552Gp3;
                } else {
                    interfaceC0552Gp4 = interfaceC0552Gp3;
                    windowInsets3 = windowInsets2;
                }
            } else {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    containerColor = NavigationRailDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i8 != 0) {
                    interfaceC0552Gp3 = null;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    windowInsets3 = NavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    interfaceC0552Gp4 = interfaceC0552Gp3;
                } else {
                    interfaceC0552Gp4 = interfaceC0552Gp3;
                    windowInsets3 = windowInsets2;
                }
            }
            long j9 = jM1449contentColorForek8zF_U;
            i5 = i3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(118552648, i5, -1, "androidx.compose.material3.NavigationRail (NavigationRail.kt:100)");
            }
            ComposableLambda composableLambda7 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2092683357, true, new NavigationRailKt$NavigationRail$1(windowInsets3, interfaceC0552Gp4, i5, interfaceC0552Gp2));
            int i118 = (i5 & 14) | 12582912;
            int i119 = i5 << 3;
            int i1110 = i118 | (i119 & 896) | (i119 & 7168);
            WindowInsets windowInsets10 = windowInsets3;
            SurfaceKt.m1850SurfaceT9BRK9s(modifier3, null, containerColor, j9, 0.0f, 0.0f, null, composableLambda7, composerStartRestartGroup, i1110, 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            windowInsets2 = windowInsets10;
            jM1449contentColorForek8zF_U = j9;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    containerColor = NavigationRailDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i8 != 0) {
                    interfaceC0552Gp3 = null;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    windowInsets3 = NavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    interfaceC0552Gp4 = interfaceC0552Gp3;
                } else {
                    interfaceC0552Gp4 = interfaceC0552Gp3;
                    windowInsets3 = windowInsets2;
                }
            } else {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    containerColor = NavigationRailDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i8 != 0) {
                    interfaceC0552Gp3 = null;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    windowInsets3 = NavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    interfaceC0552Gp4 = interfaceC0552Gp3;
                } else {
                    interfaceC0552Gp4 = interfaceC0552Gp3;
                    windowInsets3 = windowInsets2;
                }
            }
            long j10 = jM1449contentColorForek8zF_U;
            i5 = i3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(118552648, i5, -1, "androidx.compose.material3.NavigationRail (NavigationRail.kt:100)");
            }
            ComposableLambda composableLambda8 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2092683357, true, new NavigationRailKt$NavigationRail$1(windowInsets3, interfaceC0552Gp4, i5, interfaceC0552Gp2));
            int i1111 = (i5 & 14) | 12582912;
            int i1112 = i5 << 3;
            int i1113 = i1111 | (i1112 & 896) | (i1112 & 7168);
            WindowInsets windowInsets11 = windowInsets3;
            SurfaceKt.m1850SurfaceT9BRK9s(modifier3, null, containerColor, j10, 0.0f, 0.0f, null, composableLambda8, composerStartRestartGroup, i1113, 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            windowInsets2 = windowInsets11;
            jM1449contentColorForek8zF_U = j10;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new NavigationRailKt$NavigationRail$2(modifier3, containerColor, jM1449contentColorForek8zF_U, interfaceC0552Gp4, windowInsets2, interfaceC0552Gp2, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0146  */
    /* JADX WARN: Code duplicated, block: B:105:0x0153  */
    /* JADX WARN: Code duplicated, block: B:112:0x0175 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:113:0x0177  */
    /* JADX WARN: Code duplicated, block: B:114:0x017a  */
    /* JADX WARN: Code duplicated, block: B:116:0x017e  */
    /* JADX WARN: Code duplicated, block: B:118:0x0181  */
    /* JADX WARN: Code duplicated, block: B:121:0x0186  */
    /* JADX WARN: Code duplicated, block: B:124:0x018a  */
    /* JADX WARN: Code duplicated, block: B:125:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:127:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:129:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:132:0x01db  */
    /* JADX WARN: Code duplicated, block: B:135:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:138:0x0213  */
    /* JADX WARN: Code duplicated, block: B:139:0x022c  */
    /* JADX WARN: Code duplicated, block: B:142:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:145:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:146:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:149:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:150:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:153:0x0351  */
    /* JADX WARN: Code duplicated, block: B:155:0x0359  */
    /* JADX WARN: Code duplicated, block: B:158:0x0369  */
    /* JADX WARN: Code duplicated, block: B:159:0x037c  */
    /* JADX WARN: Code duplicated, block: B:162:0x03d3  */
    /* JADX WARN: Code duplicated, block: B:167:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:169:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x008e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0093  */
    /* JADX WARN: Code duplicated, block: B:49:0x0099  */
    /* JADX WARN: Code duplicated, block: B:51:0x009f  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:61:0x00be  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:71:0x00de  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:76:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:85:0x0103  */
    /* JADX WARN: Code duplicated, block: B:88:0x0109  */
    /* JADX WARN: Code duplicated, block: B:90:0x0112  */
    /* JADX WARN: Code duplicated, block: B:92:0x011a  */
    /* JADX WARN: Code duplicated, block: B:94:0x0120  */
    /* JADX WARN: Code duplicated, block: B:95:0x0123  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void NavigationRailItem(boolean z, InterfaceC3588op interfaceC3588op, InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, boolean z2, InterfaceC0526Fp interfaceC0526Fp2, boolean z3, NavigationRailItemColors navigationRailItemColors, MutableInteractionSource mutableInteractionSource, Composer composer, int i, int i2) {
        int i3;
        int i4;
        boolean z4;
        int i5;
        int i6;
        InterfaceC0526Fp interfaceC0526Fp3;
        int i7;
        int i8;
        boolean z5;
        int i9;
        int i10;
        MutableInteractionSource mutableInteractionSource2;
        int i11;
        int i12;
        Modifier modifier2;
        NavigationRailItemColors navigationRailItemColorsM1677colors69fazGs;
        MutableInteractionSource mutableInteractionSource3;
        InterfaceC0526Fp interfaceC0526Fp4;
        boolean z6;
        boolean z7;
        int i13;
        Modifier modifier3;
        Object objRememberedValue;
        int i14;
        Composer composer2;
        ComposableLambda composableLambda;
        InterfaceC3588op constructor;
        float f;
        MutableInteractionSource mutableInteractionSource4;
        NavigationRailTokens navigationRailTokens;
        long jOffset;
        boolean zChanged;
        Object objRememberedValue2;
        Shape shape;
        NavigationRailItemColors navigationRailItemColors2;
        Modifier modifier4;
        boolean z8;
        InterfaceC0526Fp interfaceC0526Fp5;
        boolean z9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0526Fp, IconLayoutIdTag);
        Composer composerStartRestartGroup = composer.startRestartGroup(-1533971045);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC3588op) ? 32 : 16;
        }
        if ((4 & i2) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 256 : 128;
        }
        int i15 = i2 & 8;
        if (i15 == 0) {
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
                interfaceC0526Fp3 = interfaceC0526Fp2;
            } else {
                interfaceC0526Fp3 = interfaceC0526Fp2;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
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
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationRailItemColors)) ? 4194304 : 8388608;
            }
            i10 = 256 & i2;
            if (i10 != 0) {
                i3 |= 100663296;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
            }
            i12 = i3;
            if ((i12 & 191739611) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                Object obj = null;
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp3 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if ((128 & i2) != 0) {
                        navigationRailItemColorsM1677colors69fazGs = NavigationRailItemDefaults.INSTANCE.m1677colors69fazGs(0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 12582912, ShapeTypes.VERTICAL_SCROLL);
                        i12 &= -29360129;
                    } else {
                        navigationRailItemColorsM1677colors69fazGs = navigationRailItemColors;
                    }
                    if (i10 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    interfaceC0526Fp4 = interfaceC0526Fp3;
                    z6 = z5;
                    z7 = z4;
                    i13 = i12;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((128 & i2) != 0) {
                        i12 &= -29360129;
                    }
                    interfaceC0526Fp4 = interfaceC0526Fp3;
                    z6 = z5;
                    z7 = z4;
                    obj = null;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    i13 = i12;
                    modifier3 = modifier;
                    navigationRailItemColorsM1677colors69fazGs = navigationRailItemColors;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1533971045, i13, -1, "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:160)");
                }
                i14 = i13;
                composer2 = composerStartRestartGroup;
                ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer2, -1023357515, true, new NavigationRailKt$NavigationRailItem$styledIcon$1(navigationRailItemColorsM1677colors69fazGs, z, z7, i13, interfaceC0526Fp4, z6, interfaceC0526Fp));
                if (interfaceC0526Fp4 != null) {
                    composableLambda = ComposableLambdaKt.composableLambda(composer2, -105269599, true, new NavigationRailKt$NavigationRailItem$styledLabel$1$1(navigationRailItemColorsM1677colors69fazGs, z, z7, i14, interfaceC0526Fp4));
                } else {
                    composableLambda = null;
                }
                Modifier modifierM518height3ABfNKs = SizeKt.m518height3ABfNKs(SelectableKt.m707selectableO2vRcR0(modifier3, z, mutableInteractionSource3, null, z7, Role.m4543boximpl(Role.Companion.m4556getTabo7Vup1c()), interfaceC3588op), NavigationRailItemHeight);
                float f2 = NavigationRailItemWidth;
                Modifier modifierM539widthInVpY3zN4$default = SizeKt.m539widthInVpY3zN4$default(modifierM518height3ABfNKs, f2, 0.0f, 2, null);
                Alignment center = Alignment.Companion.getCenter();
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                composer2.startReplaceableGroup(-1323940314);
                Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                constructor = companion.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierM539widthInVpY3zN4$default);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composer2);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, density, companion.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
                composer2.enableReusing();
                interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                if (z) {
                    f = 1.0f;
                } else {
                    f = 0.0f;
                }
                mutableInteractionSource4 = mutableInteractionSource3;
                float f3 = f;
                NavigationRailItemColors navigationRailItemColors3 = navigationRailItemColorsM1677colors69fazGs;
                State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f3, AnimationSpecKt.tween$default(150, 0, null, 6, null), 0.0f, null, null, composer2, 48, 28);
                Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                int iMo327roundToPx0680j_4 = density2.mo327roundToPx0680j_4(f2);
                navigationRailTokens = NavigationRailTokens.INSTANCE;
                jOffset = OffsetKt.Offset((iMo327roundToPx0680j_4 - density2.mo327roundToPx0680j_4(navigationRailTokens.m2364getActiveIndicatorWidthD9Ej5fM())) / 2, 0.0f);
                FW fw = FW.a;
                Offset offsetM2787boximpl = Offset.m2787boximpl(jOffset);
                composer2.startReplaceableGroup(511388516);
                zChanged = composer2.changed(offsetM2787boximpl) | composer2.changed(mutableInteractionSource4);
                objRememberedValue2 = composer2.rememberedValue();
                if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource4, jOffset, null);
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                composer2.endReplaceableGroup();
                MappedInteractionSource mappedInteractionSource = (MappedInteractionSource) objRememberedValue2;
                if (interfaceC0526Fp4 != null) {
                    composer2.startReplaceableGroup(1104516975);
                    shape = ShapesKt.toShape(navigationRailTokens.getActiveIndicatorShape(), composer2, 6);
                    composer2.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(1104517056);
                    shape = ShapesKt.toShape(navigationRailTokens.getNoLabelActiveIndicatorShape(), composer2, 6);
                    composer2.endReplaceableGroup();
                }
                NavigationRailItemBaselineLayout(ComposableLambdaKt.composableLambda(composer2, 211026382, true, new NavigationRailKt$NavigationRailItem$2$indicatorRipple$1(shape, mappedInteractionSource)), ComposableLambdaKt.composableLambda(composer2, -1862011490, true, new NavigationRailKt$NavigationRailItem$2$indicator$1(navigationRailItemColors3, i14, shape, stateAnimateFloatAsState)), composableLambda2, composableLambda, z6, NavigationRailItem$lambda$5$lambda$2(stateAnimateFloatAsState), composer2, ((i14 >> 6) & 57344) | 438);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                navigationRailItemColors2 = navigationRailItemColors3;
                mutableInteractionSource2 = mutableInteractionSource4;
                modifier4 = modifier3;
                z8 = z7;
                interfaceC0526Fp5 = interfaceC0526Fp4;
                z9 = z6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier4 = modifier;
                navigationRailItemColors2 = navigationRailItemColors;
                composer2 = composerStartRestartGroup;
                z9 = z5;
                interfaceC0526Fp5 = interfaceC0526Fp3;
                z8 = z4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(z, interfaceC3588op, interfaceC0526Fp, modifier4, z8, interfaceC0526Fp5, z9, navigationRailItemColors2, mutableInteractionSource2, i, i2));
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
            interfaceC0526Fp3 = interfaceC0526Fp2;
        } else {
            interfaceC0526Fp3 = interfaceC0526Fp2;
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
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
        if ((i & 29360128) != 0) {
            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationRailItemColors)) ? 4194304 : 8388608;
        }
        i10 = 256 & i2;
        if (i10 != 0) {
            i3 |= 100663296;
            mutableInteractionSource2 = mutableInteractionSource;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
        }
        i12 = i3;
        if ((i12 & 191739611) == 38347922) {
            composerStartRestartGroup.startDefaults();
            Object obj2 = null;
            if ((i & 1) != 0) {
                if (i15 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z4 = true;
                }
                if (i6 != 0) {
                    interfaceC0526Fp3 = null;
                }
                if (i8 != 0) {
                    z5 = true;
                }
                if ((128 & i2) != 0) {
                    navigationRailItemColorsM1677colors69fazGs = NavigationRailItemDefaults.INSTANCE.m1677colors69fazGs(0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 12582912, ShapeTypes.VERTICAL_SCROLL);
                    i12 &= -29360129;
                } else {
                    navigationRailItemColorsM1677colors69fazGs = navigationRailItemColors;
                }
                if (i10 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                interfaceC0526Fp4 = interfaceC0526Fp3;
                z6 = z5;
                z7 = z4;
                i13 = i12;
                modifier3 = modifier2;
            } else {
                if (i15 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z4 = true;
                }
                if (i6 != 0) {
                    interfaceC0526Fp3 = null;
                }
                if (i8 != 0) {
                    z5 = true;
                }
                if ((128 & i2) != 0) {
                    navigationRailItemColorsM1677colors69fazGs = NavigationRailItemDefaults.INSTANCE.m1677colors69fazGs(0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 12582912, ShapeTypes.VERTICAL_SCROLL);
                    i12 &= -29360129;
                } else {
                    navigationRailItemColorsM1677colors69fazGs = navigationRailItemColors;
                }
                if (i10 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                interfaceC0526Fp4 = interfaceC0526Fp3;
                z6 = z5;
                z7 = z4;
                i13 = i12;
                modifier3 = modifier2;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1533971045, i13, -1, "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:160)");
            }
            i14 = i13;
            composer2 = composerStartRestartGroup;
            ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer2, -1023357515, true, new NavigationRailKt$NavigationRailItem$styledIcon$1(navigationRailItemColorsM1677colors69fazGs, z, z7, i13, interfaceC0526Fp4, z6, interfaceC0526Fp));
            if (interfaceC0526Fp4 != null) {
                composableLambda = ComposableLambdaKt.composableLambda(composer2, -105269599, true, new NavigationRailKt$NavigationRailItem$styledLabel$1$1(navigationRailItemColorsM1677colors69fazGs, z, z7, i14, interfaceC0526Fp4));
            } else {
                composableLambda = null;
            }
            Modifier modifierM518height3ABfNKs2 = SizeKt.m518height3ABfNKs(SelectableKt.m707selectableO2vRcR0(modifier3, z, mutableInteractionSource3, null, z7, Role.m4543boximpl(Role.Companion.m4556getTabo7Vup1c()), interfaceC3588op), NavigationRailItemHeight);
            float f4 = NavigationRailItemWidth;
            Modifier modifierM539widthInVpY3zN4$default2 = SizeKt.m539widthInVpY3zN4$default(modifierM518height3ABfNKs2, f4, 0.0f, 2, null);
            Alignment center2 = Alignment.Companion.getCenter();
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, composer2, 6);
            composer2.startReplaceableGroup(-1323940314);
            Density density3 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            constructor = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(modifierM539widthInVpY3zN4$default2);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composer2);
            Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl2, density3, companion2.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion2.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion2.getSetViewConfiguration());
            composer2.enableReusing();
            interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            if (z) {
                f = 1.0f;
            } else {
                f = 0.0f;
            }
            mutableInteractionSource4 = mutableInteractionSource3;
            float f5 = f;
            NavigationRailItemColors navigationRailItemColors4 = navigationRailItemColorsM1677colors69fazGs;
            State<Float> stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f5, AnimationSpecKt.tween$default(150, 0, null, 6, null), 0.0f, null, null, composer2, 48, 28);
            Density density4 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            int iMo327roundToPx0680j_5 = density4.mo327roundToPx0680j_4(f4);
            navigationRailTokens = NavigationRailTokens.INSTANCE;
            jOffset = OffsetKt.Offset((iMo327roundToPx0680j_5 - density4.mo327roundToPx0680j_4(navigationRailTokens.m2364getActiveIndicatorWidthD9Ej5fM())) / 2, 0.0f);
            FW fw2 = FW.a;
            Offset offsetM2787boximpl2 = Offset.m2787boximpl(jOffset);
            composer2.startReplaceableGroup(511388516);
            zChanged = composer2.changed(offsetM2787boximpl2) | composer2.changed(mutableInteractionSource4);
            objRememberedValue2 = composer2.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource4, jOffset, null);
                composer2.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource4, jOffset, null);
                composer2.updateRememberedValue(objRememberedValue2);
            }
            composer2.endReplaceableGroup();
            MappedInteractionSource mappedInteractionSource2 = (MappedInteractionSource) objRememberedValue2;
            if (interfaceC0526Fp4 != null) {
                composer2.startReplaceableGroup(1104516975);
                shape = ShapesKt.toShape(navigationRailTokens.getActiveIndicatorShape(), composer2, 6);
                composer2.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(1104517056);
                shape = ShapesKt.toShape(navigationRailTokens.getNoLabelActiveIndicatorShape(), composer2, 6);
                composer2.endReplaceableGroup();
            }
            NavigationRailItemBaselineLayout(ComposableLambdaKt.composableLambda(composer2, 211026382, true, new NavigationRailKt$NavigationRailItem$2$indicatorRipple$1(shape, mappedInteractionSource2)), ComposableLambdaKt.composableLambda(composer2, -1862011490, true, new NavigationRailKt$NavigationRailItem$2$indicator$1(navigationRailItemColors4, i14, shape, stateAnimateFloatAsState2)), composableLambda3, composableLambda, z6, NavigationRailItem$lambda$5$lambda$2(stateAnimateFloatAsState2), composer2, ((i14 >> 6) & 57344) | 438);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            navigationRailItemColors2 = navigationRailItemColors4;
            mutableInteractionSource2 = mutableInteractionSource4;
            modifier4 = modifier3;
            z8 = z7;
            interfaceC0526Fp5 = interfaceC0526Fp4;
            z9 = z6;
        } else {
            composerStartRestartGroup.startDefaults();
            Object obj3 = null;
            if ((i & 1) != 0) {
                if (i15 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z4 = true;
                }
                if (i6 != 0) {
                    interfaceC0526Fp3 = null;
                }
                if (i8 != 0) {
                    z5 = true;
                }
                if ((128 & i2) != 0) {
                    navigationRailItemColorsM1677colors69fazGs = NavigationRailItemDefaults.INSTANCE.m1677colors69fazGs(0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 12582912, ShapeTypes.VERTICAL_SCROLL);
                    i12 &= -29360129;
                } else {
                    navigationRailItemColorsM1677colors69fazGs = navigationRailItemColors;
                }
                if (i10 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                interfaceC0526Fp4 = interfaceC0526Fp3;
                z6 = z5;
                z7 = z4;
                i13 = i12;
                modifier3 = modifier2;
            } else {
                if (i15 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z4 = true;
                }
                if (i6 != 0) {
                    interfaceC0526Fp3 = null;
                }
                if (i8 != 0) {
                    z5 = true;
                }
                if ((128 & i2) != 0) {
                    navigationRailItemColorsM1677colors69fazGs = NavigationRailItemDefaults.INSTANCE.m1677colors69fazGs(0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 12582912, ShapeTypes.VERTICAL_SCROLL);
                    i12 &= -29360129;
                } else {
                    navigationRailItemColorsM1677colors69fazGs = navigationRailItemColors;
                }
                if (i10 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                interfaceC0526Fp4 = interfaceC0526Fp3;
                z6 = z5;
                z7 = z4;
                i13 = i12;
                modifier3 = modifier2;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1533971045, i13, -1, "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:160)");
            }
            i14 = i13;
            composer2 = composerStartRestartGroup;
            ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composer2, -1023357515, true, new NavigationRailKt$NavigationRailItem$styledIcon$1(navigationRailItemColorsM1677colors69fazGs, z, z7, i13, interfaceC0526Fp4, z6, interfaceC0526Fp));
            if (interfaceC0526Fp4 != null) {
                composableLambda = ComposableLambdaKt.composableLambda(composer2, -105269599, true, new NavigationRailKt$NavigationRailItem$styledLabel$1$1(navigationRailItemColorsM1677colors69fazGs, z, z7, i14, interfaceC0526Fp4));
            } else {
                composableLambda = null;
            }
            Modifier modifierM518height3ABfNKs3 = SizeKt.m518height3ABfNKs(SelectableKt.m707selectableO2vRcR0(modifier3, z, mutableInteractionSource3, null, z7, Role.m4543boximpl(Role.Companion.m4556getTabo7Vup1c()), interfaceC3588op), NavigationRailItemHeight);
            float f6 = NavigationRailItemWidth;
            Modifier modifierM539widthInVpY3zN4$default3 = SizeKt.m539widthInVpY3zN4$default(modifierM518height3ABfNKs3, f6, 0.0f, 2, null);
            Alignment center3 = Alignment.Companion.getCenter();
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(center3, false, composer2, 6);
            composer2.startReplaceableGroup(-1323940314);
            Density density5 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            constructor = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf3 = LayoutKt.materializerOf(modifierM539widthInVpY3zN4$default3);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer composerM2661constructorimpl3 = Updater.m2661constructorimpl(composer2);
            Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyRememberBoxMeasurePolicy3, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl3, density5, companion3.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl3, layoutDirection3, companion3.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl3, viewConfiguration3, companion3.getSetViewConfiguration());
            composer2.enableReusing();
            interfaceC0552GpMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            if (z) {
                f = 1.0f;
            } else {
                f = 0.0f;
            }
            mutableInteractionSource4 = mutableInteractionSource3;
            float f7 = f;
            NavigationRailItemColors navigationRailItemColors5 = navigationRailItemColorsM1677colors69fazGs;
            State<Float> stateAnimateFloatAsState3 = AnimateAsStateKt.animateFloatAsState(f7, AnimationSpecKt.tween$default(150, 0, null, 6, null), 0.0f, null, null, composer2, 48, 28);
            Density density6 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            int iMo327roundToPx0680j_6 = density6.mo327roundToPx0680j_4(f6);
            navigationRailTokens = NavigationRailTokens.INSTANCE;
            jOffset = OffsetKt.Offset((iMo327roundToPx0680j_6 - density6.mo327roundToPx0680j_4(navigationRailTokens.m2364getActiveIndicatorWidthD9Ej5fM())) / 2, 0.0f);
            FW fw3 = FW.a;
            Offset offsetM2787boximpl3 = Offset.m2787boximpl(jOffset);
            composer2.startReplaceableGroup(511388516);
            zChanged = composer2.changed(offsetM2787boximpl3) | composer2.changed(mutableInteractionSource4);
            objRememberedValue2 = composer2.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource4, jOffset, null);
                composer2.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource4, jOffset, null);
                composer2.updateRememberedValue(objRememberedValue2);
            }
            composer2.endReplaceableGroup();
            MappedInteractionSource mappedInteractionSource3 = (MappedInteractionSource) objRememberedValue2;
            if (interfaceC0526Fp4 != null) {
                composer2.startReplaceableGroup(1104516975);
                shape = ShapesKt.toShape(navigationRailTokens.getActiveIndicatorShape(), composer2, 6);
                composer2.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(1104517056);
                shape = ShapesKt.toShape(navigationRailTokens.getNoLabelActiveIndicatorShape(), composer2, 6);
                composer2.endReplaceableGroup();
            }
            NavigationRailItemBaselineLayout(ComposableLambdaKt.composableLambda(composer2, 211026382, true, new NavigationRailKt$NavigationRailItem$2$indicatorRipple$1(shape, mappedInteractionSource3)), ComposableLambdaKt.composableLambda(composer2, -1862011490, true, new NavigationRailKt$NavigationRailItem$2$indicator$1(navigationRailItemColors5, i14, shape, stateAnimateFloatAsState3)), composableLambda4, composableLambda, z6, NavigationRailItem$lambda$5$lambda$2(stateAnimateFloatAsState3), composer2, ((i14 >> 6) & 57344) | 438);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            navigationRailItemColors2 = navigationRailItemColors5;
            mutableInteractionSource2 = mutableInteractionSource4;
            modifier4 = modifier3;
            z8 = z7;
            interfaceC0526Fp5 = interfaceC0526Fp4;
            z9 = z6;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(z, interfaceC3588op, interfaceC0526Fp, modifier4, z8, interfaceC0526Fp5, z9, navigationRailItemColors2, mutableInteractionSource2, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float NavigationRailItem$lambda$5$lambda$2(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void NavigationRailItemBaselineLayout(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, final InterfaceC0526Fp interfaceC0526Fp4, final boolean z, final float f, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-876426901);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp3) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp4) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 131072 : 65536;
        }
        if ((374491 & i2) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-876426901, i2, -1, "androidx.compose.material3.NavigationRailItemBaselineLayout (NavigationRail.kt:426)");
            }
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationRailKt.NavigationRailItemBaselineLayout.2
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
                    Object next;
                    Placeable placeableMo4159measureBRTryo0;
                    Measurable measurable;
                    AbstractC4492zt.h(measureScope, "$this$Layout");
                    AbstractC4492zt.h(list, "measurables");
                    List<? extends Measurable> list2 = list;
                    for (Measurable measurable2 : list2) {
                        if (AbstractC4492zt.d(LayoutIdKt.getLayoutId(measurable2), NavigationRailKt.IconLayoutIdTag)) {
                            Placeable placeableMo4159measureBRTryo1 = measurable2.mo4159measureBRTryo0(j);
                            float f2 = 2;
                            int width = placeableMo4159measureBRTryo1.getWidth() + measureScope.mo327roundToPx0680j_4(Dp.m5160constructorimpl(NavigationRailKt.IndicatorHorizontalPadding * f2));
                            int iC = AbstractC1210aB.c(width * f);
                            int height = placeableMo4159measureBRTryo1.getHeight() + measureScope.mo327roundToPx0680j_4(Dp.m5160constructorimpl((interfaceC0526Fp4 == null ? NavigationRailKt.IndicatorVerticalPaddingNoLabel : NavigationRailKt.IndicatorVerticalPaddingWithLabel) * f2));
                            for (Measurable measurable3 : list2) {
                                if (AbstractC4492zt.d(LayoutIdKt.getLayoutId(measurable3), NavigationRailKt.IndicatorRippleLayoutIdTag)) {
                                    Placeable placeableMo4159measureBRTryo2 = measurable3.mo4159measureBRTryo0(Constraints.Companion.m5136fixedJhjzzOo(width, height));
                                    Iterator<T> it = list2.iterator();
                                    do {
                                        if (!it.hasNext()) {
                                            next = null;
                                            break;
                                        }
                                        next = it.next();
                                    } while (!AbstractC4492zt.d(LayoutIdKt.getLayoutId((Measurable) next), NavigationRailKt.IndicatorLayoutIdTag));
                                    Measurable measurable4 = (Measurable) next;
                                    Placeable placeableMo4159measureBRTryo3 = measurable4 != null ? measurable4.mo4159measureBRTryo0(Constraints.Companion.m5136fixedJhjzzOo(iC, height)) : null;
                                    if (interfaceC0526Fp4 != null) {
                                        Iterator<T> it2 = list2.iterator();
                                        do {
                                            if (!it2.hasNext()) {
                                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                            }
                                            measurable = (Measurable) it2.next();
                                        } while (!AbstractC4492zt.d(LayoutIdKt.getLayoutId(measurable), "label"));
                                        placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(Constraints.m5119copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                                    } else {
                                        placeableMo4159measureBRTryo0 = null;
                                    }
                                    if (interfaceC0526Fp4 == null) {
                                        return NavigationRailKt.m1682placeIconX9ElhV4(measureScope, placeableMo4159measureBRTryo1, placeableMo4159measureBRTryo2, placeableMo4159measureBRTryo3, j);
                                    }
                                    AbstractC4492zt.e(placeableMo4159measureBRTryo0);
                                    return NavigationRailKt.m1683placeLabelAndIconzUg2_y0(measureScope, placeableMo4159measureBRTryo0, placeableMo4159measureBRTryo1, placeableMo4159measureBRTryo2, placeableMo4159measureBRTryo3, j, z, f);
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
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
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(companion);
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
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion2.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf(i2 & 14));
            composerStartRestartGroup.startReplaceableGroup(935757179);
            if (f > 0.0f) {
                interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierLayoutId = LayoutIdKt.layoutId(companion, IconLayoutIdTag);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            Alignment.Companion companion3 = Alignment.Companion;
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            InterfaceC3588op constructor2 = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(modifierLayoutId);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl2, density2, companion2.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion2.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion2.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            interfaceC0526Fp3.mo13invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 6) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(-853550242);
            if (interfaceC0526Fp4 != null) {
                Modifier modifierAlpha = AlphaKt.alpha(LayoutIdKt.layoutId(companion, "label"), z ? 1.0f : f);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                InterfaceC3588op constructor3 = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf3 = LayoutKt.materializerOf(modifierAlpha);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl3 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyRememberBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl3, density3, companion2.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl3, layoutDirection3, companion2.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl3, viewConfiguration3, companion2.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                interfaceC0526Fp4.mo13invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 9) & 14));
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
        scopeUpdateScopeEndRestartGroup.updateScope(new C15383(interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, z, f, i));
    }

    public static final float getNavigationRailItemHeight() {
        return NavigationRailItemHeight;
    }

    public static final float getNavigationRailItemVerticalPadding() {
        return NavigationRailItemVerticalPadding;
    }

    public static final float getNavigationRailItemWidth() {
        return NavigationRailItemWidth;
    }

    public static final float getNavigationRailVerticalPadding() {
        return NavigationRailVerticalPadding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeIcon-X9ElhV4, reason: not valid java name */
    public static final MeasureResult m1682placeIconX9ElhV4(MeasureScope measureScope, Placeable placeable, Placeable placeable2, Placeable placeable3, long j) {
        int iM5142constrainWidthK40F9xA = ConstraintsKt.m5142constrainWidthK40F9xA(j, Math.max(placeable.getWidth(), Math.max(placeable2.getWidth(), placeable3 != null ? placeable3.getWidth() : 0)));
        int iM5127getMaxHeightimpl = Constraints.m5127getMaxHeightimpl(j);
        return MeasureScope.CC.q(measureScope, iM5142constrainWidthK40F9xA, iM5127getMaxHeightimpl, null, new NavigationRailKt$placeIcon$1(placeable3, placeable, (iM5142constrainWidthK40F9xA - placeable.getWidth()) / 2, (iM5127getMaxHeightimpl - placeable.getHeight()) / 2, placeable2, (iM5142constrainWidthK40F9xA - placeable2.getWidth()) / 2, (iM5127getMaxHeightimpl - placeable2.getHeight()) / 2, iM5142constrainWidthK40F9xA, iM5127getMaxHeightimpl), 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeLabelAndIcon-zUg2_y0, reason: not valid java name */
    public static final MeasureResult m1683placeLabelAndIconzUg2_y0(MeasureScope measureScope, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, long j, boolean z, float f) {
        int iM5127getMaxHeightimpl = Constraints.m5127getMaxHeightimpl(j);
        int height = iM5127getMaxHeightimpl - placeable.getHeight();
        float f2 = NavigationRailItemVerticalPadding;
        int iMo327roundToPx0680j_4 = height - measureScope.mo327roundToPx0680j_4(f2);
        int iMo327roundToPx0680j_5 = measureScope.mo327roundToPx0680j_4(f2);
        int iC = AbstractC1210aB.c(((z ? iMo327roundToPx0680j_5 : (iM5127getMaxHeightimpl - placeable2.getHeight()) / 2) - iMo327roundToPx0680j_5) * (1 - f));
        int iM5142constrainWidthK40F9xA = ConstraintsKt.m5142constrainWidthK40F9xA(j, Math.max(placeable2.getWidth(), Math.max(placeable.getWidth(), placeable4 != null ? placeable4.getWidth() : 0)));
        return MeasureScope.CC.q(measureScope, iM5142constrainWidthK40F9xA, iM5127getMaxHeightimpl, null, new NavigationRailKt$placeLabelAndIcon$1(placeable4, z, f, placeable, (iM5142constrainWidthK40F9xA - placeable.getWidth()) / 2, iMo327roundToPx0680j_4, iC, placeable2, (iM5142constrainWidthK40F9xA - placeable2.getWidth()) / 2, iMo327roundToPx0680j_5, placeable3, (iM5142constrainWidthK40F9xA - placeable3.getWidth()) / 2, iMo327roundToPx0680j_5 - measureScope.mo327roundToPx0680j_4(IndicatorVerticalPaddingWithLabel), iM5142constrainWidthK40F9xA, measureScope), 4, null);
    }
}
