package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2260gB;
import defpackage.AbstractC3955tM;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes.dex */
public final class NavigationBarKt {
    private static final String IconLayoutIdTag = "icon";
    private static final float IndicatorHorizontalPadding;
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalOffset;
    private static final float IndicatorVerticalPadding;
    private static final int ItemAnimationDurationMillis = 100;
    private static final String LabelLayoutIdTag = "label";
    private static final float NavigationBarHeight;
    private static final float NavigationBarItemHorizontalPadding;
    private static final float NavigationBarItemVerticalPadding;

    /* JADX INFO: renamed from: androidx.compose.material3.NavigationBarKt$NavigationBarItem$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ boolean $alwaysShowLabel;
        final /* synthetic */ NavigationBarItemColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ InterfaceC0526Fp $icon;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ InterfaceC0526Fp $label;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3588op $onClick;
        final /* synthetic */ boolean $selected;
        final /* synthetic */ RowScope $this_NavigationBarItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(RowScope rowScope, boolean z, InterfaceC3588op interfaceC3588op, InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, boolean z2, InterfaceC0526Fp interfaceC0526Fp2, boolean z3, NavigationBarItemColors navigationBarItemColors, MutableInteractionSource mutableInteractionSource, int i, int i2) {
            super(2);
            this.$this_NavigationBarItem = rowScope;
            this.$selected = z;
            this.$onClick = interfaceC3588op;
            this.$icon = interfaceC0526Fp;
            this.$modifier = modifier;
            this.$enabled = z2;
            this.$label = interfaceC0526Fp2;
            this.$alwaysShowLabel = z3;
            this.$colors = navigationBarItemColors;
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
            NavigationBarKt.NavigationBarItem(this.$this_NavigationBarItem, this.$selected, this.$onClick, this.$icon, this.$modifier, this.$enabled, this.$label, this.$alwaysShowLabel, this.$colors, this.$interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.NavigationBarKt$NavigationBarItemBaselineLayout$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ boolean $alwaysShowLabel;
        final /* synthetic */ float $animationProgress;
        final /* synthetic */ InterfaceC0526Fp $icon;
        final /* synthetic */ InterfaceC0526Fp $indicator;
        final /* synthetic */ InterfaceC0526Fp $indicatorRipple;
        final /* synthetic */ InterfaceC0526Fp $label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, boolean z, float f, int i) {
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
            NavigationBarKt.NavigationBarItemBaselineLayout(this.$indicatorRipple, this.$indicator, this.$icon, this.$label, this.$alwaysShowLabel, this.$animationProgress, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    static {
        NavigationBarTokens navigationBarTokens = NavigationBarTokens.INSTANCE;
        NavigationBarHeight = navigationBarTokens.m2355getContainerHeightD9Ej5fM();
        NavigationBarItemHorizontalPadding = Dp.m5160constructorimpl(8);
        NavigationBarItemVerticalPadding = Dp.m5160constructorimpl(16);
        float f = 2;
        IndicatorHorizontalPadding = Dp.m5160constructorimpl(Dp.m5160constructorimpl(navigationBarTokens.m2353getActiveIndicatorWidthD9Ej5fM() - navigationBarTokens.m2356getIconSizeD9Ej5fM()) / f);
        IndicatorVerticalPadding = Dp.m5160constructorimpl(Dp.m5160constructorimpl(navigationBarTokens.m2352getActiveIndicatorHeightD9Ej5fM() - navigationBarTokens.m2356getIconSizeD9Ej5fM()) / f);
        IndicatorVerticalOffset = Dp.m5160constructorimpl(12);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x012b  */
    /* JADX WARN: Code duplicated, block: B:104:0x013d  */
    /* JADX WARN: Code duplicated, block: B:107:0x017b  */
    /* JADX WARN: Code duplicated, block: B:112:0x0187  */
    /* JADX WARN: Code duplicated, block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x0086  */
    /* JADX WARN: Code duplicated, block: B:49:0x008a  */
    /* JADX WARN: Code duplicated, block: B:51:0x0092  */
    /* JADX WARN: Code duplicated, block: B:52:0x0095  */
    /* JADX WARN: Code duplicated, block: B:55:0x009b  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:89:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:90:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:93:0x0105  */
    /* JADX WARN: Code duplicated, block: B:96:0x0111  */
    /* JADX WARN: Code duplicated, block: B:98:0x0120  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: NavigationBar-HsRjFd4, reason: not valid java name */
    public static final void m1659NavigationBarHsRjFd4(Modifier modifier, long j, long j2, float f, WindowInsets windowInsets, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        Modifier modifier2;
        int i3;
        long containerColor;
        long jM1448contentColorFor4WTKRHQ;
        float fM1655getElevationD9Ej5fM;
        WindowInsets windowInsets2;
        int i4;
        Modifier modifier3;
        float f2;
        int i5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(1596802123);
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
            jM1448contentColorFor4WTKRHQ = j2;
            i3 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(jM1448contentColorFor4WTKRHQ)) ? 256 : 128;
        } else {
            jM1448contentColorFor4WTKRHQ = j2;
        }
        int i8 = i2 & 8;
        if (i8 == 0) {
            if ((i & 7168) == 0) {
                fM1655getElevationD9Ej5fM = f;
                i3 |= composerStartRestartGroup.changed(fM1655getElevationD9Ej5fM) ? 2048 : 1024;
            }
            if ((i & 57344) == 0) {
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
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
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
                            containerColor = NavigationBarDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            jM1448contentColorFor4WTKRHQ = ColorSchemeKt.m1448contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6), containerColor);
                            i3 &= -897;
                        }
                        if (i8 != 0) {
                            fM1655getElevationD9Ej5fM = NavigationBarDefaults.INSTANCE.m1655getElevationD9Ej5fM();
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            windowInsets2 = NavigationBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        }
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
                    f2 = fM1655getElevationD9Ej5fM;
                    long j3 = jM1448contentColorFor4WTKRHQ;
                    i5 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1596802123, i5, -1, "androidx.compose.material3.NavigationBar (NavigationBar.kt:98)");
                    }
                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 105663120, true, new NavigationBarKt$NavigationBar$1(windowInsets2, interfaceC0552Gp, i5));
                    int i10 = 12582912 | (i5 & 14);
                    int i11 = i5 << 3;
                    int i12 = i10 | (i11 & 896) | (i11 & 7168) | (i11 & 57344);
                    WindowInsets windowInsets3 = windowInsets2;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier3, null, containerColor, j3, f2, 0.0f, null, composableLambda, composerStartRestartGroup, i12, 98);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets2 = windowInsets3;
                    jM1448contentColorFor4WTKRHQ = j3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    f2 = fM1655getElevationD9Ej5fM;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new NavigationBarKt$NavigationBar$2(modifier3, containerColor, jM1448contentColorFor4WTKRHQ, f2, windowInsets2, interfaceC0552Gp, i, i2));
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
                        containerColor = NavigationBarDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM1448contentColorFor4WTKRHQ = ColorSchemeKt.m1448contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6), containerColor);
                        i3 &= -897;
                    }
                    if (i8 != 0) {
                        fM1655getElevationD9Ej5fM = NavigationBarDefaults.INSTANCE.m1655getElevationD9Ej5fM();
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        windowInsets2 = NavigationBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    }
                } else {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        containerColor = NavigationBarDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM1448contentColorFor4WTKRHQ = ColorSchemeKt.m1448contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6), containerColor);
                        i3 &= -897;
                    }
                    if (i8 != 0) {
                        fM1655getElevationD9Ej5fM = NavigationBarDefaults.INSTANCE.m1655getElevationD9Ej5fM();
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        windowInsets2 = NavigationBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    }
                }
                f2 = fM1655getElevationD9Ej5fM;
                long j4 = jM1448contentColorFor4WTKRHQ;
                i5 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1596802123, i5, -1, "androidx.compose.material3.NavigationBar (NavigationBar.kt:98)");
                }
                ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 105663120, true, new NavigationBarKt$NavigationBar$1(windowInsets2, interfaceC0552Gp, i5));
                int i13 = 12582912 | (i5 & 14);
                int i14 = i5 << 3;
                int i15 = i13 | (i14 & 896) | (i14 & 7168) | (i14 & 57344);
                WindowInsets windowInsets4 = windowInsets2;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier3, null, containerColor, j4, f2, 0.0f, null, composableLambda2, composerStartRestartGroup, i15, 98);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets2 = windowInsets4;
                jM1448contentColorFor4WTKRHQ = j4;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        containerColor = NavigationBarDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM1448contentColorFor4WTKRHQ = ColorSchemeKt.m1448contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6), containerColor);
                        i3 &= -897;
                    }
                    if (i8 != 0) {
                        fM1655getElevationD9Ej5fM = NavigationBarDefaults.INSTANCE.m1655getElevationD9Ej5fM();
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        windowInsets2 = NavigationBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    }
                } else {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        containerColor = NavigationBarDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM1448contentColorFor4WTKRHQ = ColorSchemeKt.m1448contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6), containerColor);
                        i3 &= -897;
                    }
                    if (i8 != 0) {
                        fM1655getElevationD9Ej5fM = NavigationBarDefaults.INSTANCE.m1655getElevationD9Ej5fM();
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        windowInsets2 = NavigationBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    }
                }
                f2 = fM1655getElevationD9Ej5fM;
                long j5 = jM1448contentColorFor4WTKRHQ;
                i5 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1596802123, i5, -1, "androidx.compose.material3.NavigationBar (NavigationBar.kt:98)");
                }
                ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 105663120, true, new NavigationBarKt$NavigationBar$1(windowInsets2, interfaceC0552Gp, i5));
                int i16 = 12582912 | (i5 & 14);
                int i17 = i5 << 3;
                int i18 = i16 | (i17 & 896) | (i17 & 7168) | (i17 & 57344);
                WindowInsets windowInsets5 = windowInsets2;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier3, null, containerColor, j5, f2, 0.0f, null, composableLambda3, composerStartRestartGroup, i18, 98);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets2 = windowInsets5;
                jM1448contentColorFor4WTKRHQ = j5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new NavigationBarKt$NavigationBar$2(modifier3, containerColor, jM1448contentColorFor4WTKRHQ, f2, windowInsets2, interfaceC0552Gp, i, i2));
        }
        i3 |= 3072;
        fM1655getElevationD9Ej5fM = f;
        if ((i & 57344) == 0) {
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
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
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
                        containerColor = NavigationBarDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM1448contentColorFor4WTKRHQ = ColorSchemeKt.m1448contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6), containerColor);
                        i3 &= -897;
                    }
                    if (i8 != 0) {
                        fM1655getElevationD9Ej5fM = NavigationBarDefaults.INSTANCE.m1655getElevationD9Ej5fM();
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        windowInsets2 = NavigationBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    }
                } else {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        containerColor = NavigationBarDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM1448contentColorFor4WTKRHQ = ColorSchemeKt.m1448contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6), containerColor);
                        i3 &= -897;
                    }
                    if (i8 != 0) {
                        fM1655getElevationD9Ej5fM = NavigationBarDefaults.INSTANCE.m1655getElevationD9Ej5fM();
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        windowInsets2 = NavigationBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    }
                }
                f2 = fM1655getElevationD9Ej5fM;
                long j6 = jM1448contentColorFor4WTKRHQ;
                i5 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1596802123, i5, -1, "androidx.compose.material3.NavigationBar (NavigationBar.kt:98)");
                }
                ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 105663120, true, new NavigationBarKt$NavigationBar$1(windowInsets2, interfaceC0552Gp, i5));
                int i19 = 12582912 | (i5 & 14);
                int i110 = i5 << 3;
                int i111 = i19 | (i110 & 896) | (i110 & 7168) | (i110 & 57344);
                WindowInsets windowInsets6 = windowInsets2;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier3, null, containerColor, j6, f2, 0.0f, null, composableLambda4, composerStartRestartGroup, i111, 98);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets2 = windowInsets6;
                jM1448contentColorFor4WTKRHQ = j6;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        containerColor = NavigationBarDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM1448contentColorFor4WTKRHQ = ColorSchemeKt.m1448contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6), containerColor);
                        i3 &= -897;
                    }
                    if (i8 != 0) {
                        fM1655getElevationD9Ej5fM = NavigationBarDefaults.INSTANCE.m1655getElevationD9Ej5fM();
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        windowInsets2 = NavigationBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    }
                } else {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        containerColor = NavigationBarDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM1448contentColorFor4WTKRHQ = ColorSchemeKt.m1448contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6), containerColor);
                        i3 &= -897;
                    }
                    if (i8 != 0) {
                        fM1655getElevationD9Ej5fM = NavigationBarDefaults.INSTANCE.m1655getElevationD9Ej5fM();
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        windowInsets2 = NavigationBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    }
                }
                f2 = fM1655getElevationD9Ej5fM;
                long j7 = jM1448contentColorFor4WTKRHQ;
                i5 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1596802123, i5, -1, "androidx.compose.material3.NavigationBar (NavigationBar.kt:98)");
                }
                ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 105663120, true, new NavigationBarKt$NavigationBar$1(windowInsets2, interfaceC0552Gp, i5));
                int i112 = 12582912 | (i5 & 14);
                int i113 = i5 << 3;
                int i114 = i112 | (i113 & 896) | (i113 & 7168) | (i113 & 57344);
                WindowInsets windowInsets7 = windowInsets2;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier3, null, containerColor, j7, f2, 0.0f, null, composableLambda5, composerStartRestartGroup, i114, 98);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets2 = windowInsets7;
                jM1448contentColorFor4WTKRHQ = j7;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new NavigationBarKt$NavigationBar$2(modifier3, containerColor, jM1448contentColorFor4WTKRHQ, f2, windowInsets2, interfaceC0552Gp, i, i2));
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
                    containerColor = NavigationBarDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM1448contentColorFor4WTKRHQ = ColorSchemeKt.m1448contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6), containerColor);
                    i3 &= -897;
                }
                if (i8 != 0) {
                    fM1655getElevationD9Ej5fM = NavigationBarDefaults.INSTANCE.m1655getElevationD9Ej5fM();
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    windowInsets2 = NavigationBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                }
            } else {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    containerColor = NavigationBarDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM1448contentColorFor4WTKRHQ = ColorSchemeKt.m1448contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6), containerColor);
                    i3 &= -897;
                }
                if (i8 != 0) {
                    fM1655getElevationD9Ej5fM = NavigationBarDefaults.INSTANCE.m1655getElevationD9Ej5fM();
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    windowInsets2 = NavigationBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                }
            }
            f2 = fM1655getElevationD9Ej5fM;
            long j8 = jM1448contentColorFor4WTKRHQ;
            i5 = i3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1596802123, i5, -1, "androidx.compose.material3.NavigationBar (NavigationBar.kt:98)");
            }
            ComposableLambda composableLambda6 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 105663120, true, new NavigationBarKt$NavigationBar$1(windowInsets2, interfaceC0552Gp, i5));
            int i115 = 12582912 | (i5 & 14);
            int i116 = i5 << 3;
            int i117 = i115 | (i116 & 896) | (i116 & 7168) | (i116 & 57344);
            WindowInsets windowInsets8 = windowInsets2;
            SurfaceKt.m1850SurfaceT9BRK9s(modifier3, null, containerColor, j8, f2, 0.0f, null, composableLambda6, composerStartRestartGroup, i117, 98);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            windowInsets2 = windowInsets8;
            jM1448contentColorFor4WTKRHQ = j8;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    containerColor = NavigationBarDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM1448contentColorFor4WTKRHQ = ColorSchemeKt.m1448contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6), containerColor);
                    i3 &= -897;
                }
                if (i8 != 0) {
                    fM1655getElevationD9Ej5fM = NavigationBarDefaults.INSTANCE.m1655getElevationD9Ej5fM();
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    windowInsets2 = NavigationBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                }
            } else {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    containerColor = NavigationBarDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM1448contentColorFor4WTKRHQ = ColorSchemeKt.m1448contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6), containerColor);
                    i3 &= -897;
                }
                if (i8 != 0) {
                    fM1655getElevationD9Ej5fM = NavigationBarDefaults.INSTANCE.m1655getElevationD9Ej5fM();
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    windowInsets2 = NavigationBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                }
            }
            f2 = fM1655getElevationD9Ej5fM;
            long j9 = jM1448contentColorFor4WTKRHQ;
            i5 = i3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1596802123, i5, -1, "androidx.compose.material3.NavigationBar (NavigationBar.kt:98)");
            }
            ComposableLambda composableLambda7 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 105663120, true, new NavigationBarKt$NavigationBar$1(windowInsets2, interfaceC0552Gp, i5));
            int i118 = 12582912 | (i5 & 14);
            int i119 = i5 << 3;
            int i1110 = i118 | (i119 & 896) | (i119 & 7168) | (i119 & 57344);
            WindowInsets windowInsets9 = windowInsets2;
            SurfaceKt.m1850SurfaceT9BRK9s(modifier3, null, containerColor, j9, f2, 0.0f, null, composableLambda7, composerStartRestartGroup, i1110, 98);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            windowInsets2 = windowInsets9;
            jM1448contentColorFor4WTKRHQ = j9;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new NavigationBarKt$NavigationBar$2(modifier3, containerColor, jM1448contentColorFor4WTKRHQ, f2, windowInsets2, interfaceC0552Gp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x013b  */
    /* JADX WARN: Code duplicated, block: B:103:0x0141  */
    /* JADX WARN: Code duplicated, block: B:104:0x0144  */
    /* JADX WARN: Code duplicated, block: B:112:0x0168  */
    /* JADX WARN: Code duplicated, block: B:114:0x0173  */
    /* JADX WARN: Code duplicated, block: B:121:0x0190 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:122:0x0192  */
    /* JADX WARN: Code duplicated, block: B:124:0x0197  */
    /* JADX WARN: Code duplicated, block: B:126:0x019a  */
    /* JADX WARN: Code duplicated, block: B:128:0x019d  */
    /* JADX WARN: Code duplicated, block: B:130:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:133:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:134:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:136:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:138:0x01da  */
    /* JADX WARN: Code duplicated, block: B:140:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:143:0x0201  */
    /* JADX WARN: Code duplicated, block: B:146:0x022d  */
    /* JADX WARN: Code duplicated, block: B:148:0x0249  */
    /* JADX WARN: Code duplicated, block: B:151:0x025b  */
    /* JADX WARN: Code duplicated, block: B:154:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:156:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:159:0x0310  */
    /* JADX WARN: Code duplicated, block: B:162:0x031c  */
    /* JADX WARN: Code duplicated, block: B:163:0x0320  */
    /* JADX WARN: Code duplicated, block: B:166:0x0363  */
    /* JADX WARN: Code duplicated, block: B:167:0x0368  */
    /* JADX WARN: Code duplicated, block: B:170:0x03c7  */
    /* JADX WARN: Code duplicated, block: B:172:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:175:0x041f  */
    /* JADX WARN: Code duplicated, block: B:180:0x0432  */
    /* JADX WARN: Code duplicated, block: B:182:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:59:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:66:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:69:0x00db  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:76:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:79:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:81:0x0101  */
    /* JADX WARN: Code duplicated, block: B:82:0x0104  */
    /* JADX WARN: Code duplicated, block: B:86:0x010e  */
    /* JADX WARN: Code duplicated, block: B:95:0x0126  */
    /* JADX WARN: Code duplicated, block: B:98:0x012c  */
    /* JADX WARN: Code duplicated, block: B:99:0x0133  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void NavigationBarItem(RowScope rowScope, boolean z, InterfaceC3588op interfaceC3588op, InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, boolean z2, InterfaceC0526Fp interfaceC0526Fp2, boolean z3, NavigationBarItemColors navigationBarItemColors, MutableInteractionSource mutableInteractionSource, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z4;
        int i5;
        int i6;
        InterfaceC0526Fp interfaceC0526Fp3;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z5;
        NavigationBarItemColors navigationBarItemColorsM1657colors69fazGs;
        boolean z6;
        Modifier modifier3;
        int i12;
        InterfaceC0526Fp interfaceC0526Fp4;
        MutableInteractionSource mutableInteractionSource2;
        NavigationBarItemColors navigationBarItemColors2;
        Object objRememberedValue;
        int i13;
        MutableInteractionSource mutableInteractionSource3;
        Composer composer2;
        NavigationBarItemColors navigationBarItemColors3;
        ComposableLambda composableLambda;
        Object objRememberedValue2;
        Composer.Companion companion;
        MutableState mutableState;
        boolean zChanged;
        Object objRememberedValue3;
        InterfaceC3588op constructor;
        float f;
        long jOffset;
        boolean zChanged2;
        Object objRememberedValue4;
        Modifier modifier4;
        NavigationBarItemColors navigationBarItemColors4;
        MutableInteractionSource mutableInteractionSource4;
        boolean z7;
        InterfaceC0526Fp interfaceC0526Fp5;
        boolean z8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(rowScope, "<this>");
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0526Fp, IconLayoutIdTag);
        Composer composerStartRestartGroup = composer.startRestartGroup(-663510974);
        if ((Integer.MIN_VALUE & i2) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(rowScope) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 1) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 2) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC3588op) ? 256 : 128;
        }
        if ((4 & i2) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 2048 : 1024;
        }
        int i14 = i2 & 8;
        if (i14 == 0) {
            if ((i & 57344) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i4 = 16 & i2;
            if (i4 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z4 = z2;
            } else {
                z4 = z2;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(z4)) {
                        i5 = 131072;
                    } else {
                        i5 = 65536;
                    }
                    i3 |= i5;
                }
            }
            i6 = 32 & i2;
            if (i6 != 0) {
                i3 |= 1572864;
                interfaceC0526Fp3 = interfaceC0526Fp2;
            } else {
                interfaceC0526Fp3 = interfaceC0526Fp2;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i & 234881024) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationBarItemColors)) ? 33554432 : 67108864;
            }
            i10 = 256 & i2;
            if (i10 != 0) {
                i3 |= 805306368;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i11 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i11 = 268435456;
                }
                i3 |= i11;
            }
            if ((i3 & 1533916891) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp3 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z3;
                    }
                    if ((128 & i2) != 0) {
                        navigationBarItemColorsM1657colors69fazGs = NavigationBarItemDefaults.INSTANCE.m1657colors69fazGs(0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 12582912, ShapeTypes.VERTICAL_SCROLL);
                        i3 &= -234881025;
                    } else {
                        navigationBarItemColorsM1657colors69fazGs = navigationBarItemColors;
                    }
                    if (i10 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        z6 = z5;
                        modifier3 = modifier2;
                        i12 = i3;
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                        navigationBarItemColors2 = navigationBarItemColorsM1657colors69fazGs;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        z6 = z5;
                        modifier3 = modifier2;
                        i12 = i3;
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                        mutableInteractionSource2 = mutableInteractionSource;
                        navigationBarItemColors2 = navigationBarItemColorsM1657colors69fazGs;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((128 & i2) != 0) {
                        i3 &= -234881025;
                    }
                    z6 = z3;
                    modifier3 = modifier2;
                    i12 = i3;
                    interfaceC0526Fp4 = interfaceC0526Fp3;
                    navigationBarItemColors2 = navigationBarItemColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-663510974, i12, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:159)");
                }
                i13 = i12;
                mutableInteractionSource3 = mutableInteractionSource2;
                composer2 = composerStartRestartGroup;
                navigationBarItemColors3 = navigationBarItemColors2;
                ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer2, -1419576100, true, new NavigationBarKt$NavigationBarItem$styledIcon$1(navigationBarItemColors2, z, z4, i12, interfaceC0526Fp4, z6, interfaceC0526Fp));
                if (interfaceC0526Fp4 != null) {
                    composableLambda = ComposableLambdaKt.composableLambda(composer2, 1644987592, true, new NavigationBarKt$NavigationBarItem$styledLabel$1$1(navigationBarItemColors3, z, z4, i13, interfaceC0526Fp4));
                } else {
                    composableLambda = null;
                }
                composer2.startReplaceableGroup(-492369756);
                objRememberedValue2 = composer2.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                composer2.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue2;
                Modifier modifierA = AbstractC3955tM.a(rowScope, SelectableKt.m707selectableO2vRcR0(modifier3, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4556getTabo7Vup1c()), interfaceC3588op), 1.0f, false, 2, null);
                composer2.startReplaceableGroup(1157296644);
                zChanged = composer2.changed(mutableState);
                objRememberedValue3 = composer2.rememberedValue();
                if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new NavigationBarKt$NavigationBarItem$2$1(mutableState);
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                composer2.endReplaceableGroup();
                Modifier modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(modifierA, (InterfaceC3750qp) objRememberedValue3);
                Alignment center = Alignment.Companion.getCenter();
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                composer2.startReplaceableGroup(-1323940314);
                Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                constructor = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierOnSizeChanged);
                Modifier modifier5 = modifier3;
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
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, density, companion2.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
                composer2.enableReusing();
                interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                if (z) {
                    f = 1.0f;
                } else {
                    f = 0.0f;
                }
                State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, null, null, composer2, 48, 28);
                Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                jOffset = OffsetKt.Offset((NavigationBarItem$lambda$3(mutableState) - density2.mo327roundToPx0680j_4(NavigationBarTokens.INSTANCE.m2353getActiveIndicatorWidthD9Ej5fM())) / 2, density2.mo333toPx0680j_4(IndicatorVerticalOffset));
                FW fw = FW.a;
                Offset offsetM2787boximpl = Offset.m2787boximpl(jOffset);
                composer2.startReplaceableGroup(511388516);
                zChanged2 = composer2.changed(offsetM2787boximpl) | composer2.changed(mutableInteractionSource3);
                objRememberedValue4 = composer2.rememberedValue();
                if (zChanged2 || objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource3, jOffset, null);
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                composer2.endReplaceableGroup();
                NavigationBarItemBaselineLayout(ComposableLambdaKt.composableLambda(composer2, 691730997, true, new NavigationBarKt$NavigationBarItem$3$indicatorRipple$1((MappedInteractionSource) objRememberedValue4)), ComposableLambdaKt.composableLambda(composer2, -474426875, true, new NavigationBarKt$NavigationBarItem$3$indicator$1(navigationBarItemColors3, stateAnimateFloatAsState)), composableLambda2, composableLambda, z6, NavigationBarItem$lambda$9$lambda$6(stateAnimateFloatAsState), composer2, ((i13 >> 9) & 57344) | 438);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier5;
                navigationBarItemColors4 = navigationBarItemColors3;
                mutableInteractionSource4 = mutableInteractionSource3;
                z7 = z4;
                interfaceC0526Fp5 = interfaceC0526Fp4;
                z8 = z6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                mutableInteractionSource4 = mutableInteractionSource;
                modifier4 = modifier2;
                composer2 = composerStartRestartGroup;
                interfaceC0526Fp5 = interfaceC0526Fp3;
                z7 = z4;
                z8 = z3;
                navigationBarItemColors4 = navigationBarItemColors;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(rowScope, z, interfaceC3588op, interfaceC0526Fp, modifier4, z7, interfaceC0526Fp5, z8, navigationBarItemColors4, mutableInteractionSource4, i, i2));
        }
        i3 |= 24576;
        modifier2 = modifier;
        i4 = 16 & i2;
        if (i4 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z4 = z2;
        } else {
            z4 = z2;
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(z4)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i3 |= i5;
            }
        }
        i6 = 32 & i2;
        if (i6 != 0) {
            i3 |= 1572864;
            interfaceC0526Fp3 = interfaceC0526Fp2;
        } else {
            interfaceC0526Fp3 = interfaceC0526Fp2;
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
        }
        i8 = i2 & 64;
        if (i8 != 0) {
            i3 |= 12582912;
        } else if ((i & 29360128) == 0) {
            if (composerStartRestartGroup.changed(z3)) {
                i9 = 8388608;
            } else {
                i9 = 4194304;
            }
            i3 |= i9;
        }
        if ((i & 234881024) != 0) {
            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationBarItemColors)) ? 33554432 : 67108864;
        }
        i10 = 256 & i2;
        if (i10 != 0) {
            i3 |= 805306368;
        } else if ((i & 1879048192) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i11 = PropertyOptions.DELETE_EXISTING;
            } else {
                i11 = 268435456;
            }
            i3 |= i11;
        }
        if ((i3 & 1533916891) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    z4 = true;
                }
                if (i6 != 0) {
                    interfaceC0526Fp3 = null;
                }
                if (i8 != 0) {
                    z5 = true;
                } else {
                    z5 = z3;
                }
                if ((128 & i2) != 0) {
                    navigationBarItemColorsM1657colors69fazGs = NavigationBarItemDefaults.INSTANCE.m1657colors69fazGs(0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 12582912, ShapeTypes.VERTICAL_SCROLL);
                    i3 &= -234881025;
                } else {
                    navigationBarItemColorsM1657colors69fazGs = navigationBarItemColors;
                }
                if (i10 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    z6 = z5;
                    modifier3 = modifier2;
                    i12 = i3;
                    interfaceC0526Fp4 = interfaceC0526Fp3;
                    navigationBarItemColors2 = navigationBarItemColorsM1657colors69fazGs;
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    z6 = z5;
                    modifier3 = modifier2;
                    i12 = i3;
                    interfaceC0526Fp4 = interfaceC0526Fp3;
                    mutableInteractionSource2 = mutableInteractionSource;
                    navigationBarItemColors2 = navigationBarItemColorsM1657colors69fazGs;
                }
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    z4 = true;
                }
                if (i6 != 0) {
                    interfaceC0526Fp3 = null;
                }
                if (i8 != 0) {
                    z5 = true;
                } else {
                    z5 = z3;
                }
                if ((128 & i2) != 0) {
                    navigationBarItemColorsM1657colors69fazGs = NavigationBarItemDefaults.INSTANCE.m1657colors69fazGs(0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 12582912, ShapeTypes.VERTICAL_SCROLL);
                    i3 &= -234881025;
                } else {
                    navigationBarItemColorsM1657colors69fazGs = navigationBarItemColors;
                }
                if (i10 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    z6 = z5;
                    modifier3 = modifier2;
                    i12 = i3;
                    interfaceC0526Fp4 = interfaceC0526Fp3;
                    navigationBarItemColors2 = navigationBarItemColorsM1657colors69fazGs;
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    z6 = z5;
                    modifier3 = modifier2;
                    i12 = i3;
                    interfaceC0526Fp4 = interfaceC0526Fp3;
                    mutableInteractionSource2 = mutableInteractionSource;
                    navigationBarItemColors2 = navigationBarItemColorsM1657colors69fazGs;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-663510974, i12, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:159)");
            }
            i13 = i12;
            mutableInteractionSource3 = mutableInteractionSource2;
            composer2 = composerStartRestartGroup;
            navigationBarItemColors3 = navigationBarItemColors2;
            ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer2, -1419576100, true, new NavigationBarKt$NavigationBarItem$styledIcon$1(navigationBarItemColors2, z, z4, i12, interfaceC0526Fp4, z6, interfaceC0526Fp));
            if (interfaceC0526Fp4 != null) {
                composableLambda = ComposableLambdaKt.composableLambda(composer2, 1644987592, true, new NavigationBarKt$NavigationBarItem$styledLabel$1$1(navigationBarItemColors3, z, z4, i13, interfaceC0526Fp4));
            } else {
                composableLambda = null;
            }
            composer2.startReplaceableGroup(-492369756);
            objRememberedValue2 = composer2.rememberedValue();
            companion = Composer.Companion;
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                composer2.updateRememberedValue(objRememberedValue2);
            }
            composer2.endReplaceableGroup();
            mutableState = (MutableState) objRememberedValue2;
            Modifier modifierA2 = AbstractC3955tM.a(rowScope, SelectableKt.m707selectableO2vRcR0(modifier3, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4556getTabo7Vup1c()), interfaceC3588op), 1.0f, false, 2, null);
            composer2.startReplaceableGroup(1157296644);
            zChanged = composer2.changed(mutableState);
            objRememberedValue3 = composer2.rememberedValue();
            if (zChanged) {
                objRememberedValue3 = new NavigationBarKt$NavigationBarItem$2$1(mutableState);
                composer2.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new NavigationBarKt$NavigationBarItem$2$1(mutableState);
                composer2.updateRememberedValue(objRememberedValue3);
            }
            composer2.endReplaceableGroup();
            Modifier modifierOnSizeChanged2 = OnRemeasuredModifierKt.onSizeChanged(modifierA2, (InterfaceC3750qp) objRememberedValue3);
            Alignment center2 = Alignment.Companion.getCenter();
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, composer2, 6);
            composer2.startReplaceableGroup(-1323940314);
            Density density3 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            constructor = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(modifierOnSizeChanged2);
            Modifier modifier6 = modifier3;
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
            Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl2, density3, companion3.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion3.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion3.getSetViewConfiguration());
            composer2.enableReusing();
            interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            if (z) {
                f = 1.0f;
            } else {
                f = 0.0f;
            }
            State<Float> stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f, AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, null, null, composer2, 48, 28);
            Density density4 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            jOffset = OffsetKt.Offset((NavigationBarItem$lambda$3(mutableState) - density4.mo327roundToPx0680j_4(NavigationBarTokens.INSTANCE.m2353getActiveIndicatorWidthD9Ej5fM())) / 2, density4.mo333toPx0680j_4(IndicatorVerticalOffset));
            FW fw2 = FW.a;
            Offset offsetM2787boximpl2 = Offset.m2787boximpl(jOffset);
            composer2.startReplaceableGroup(511388516);
            zChanged2 = composer2.changed(offsetM2787boximpl2) | composer2.changed(mutableInteractionSource3);
            objRememberedValue4 = composer2.rememberedValue();
            if (zChanged2) {
                objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource3, jOffset, null);
                composer2.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource3, jOffset, null);
                composer2.updateRememberedValue(objRememberedValue4);
            }
            composer2.endReplaceableGroup();
            NavigationBarItemBaselineLayout(ComposableLambdaKt.composableLambda(composer2, 691730997, true, new NavigationBarKt$NavigationBarItem$3$indicatorRipple$1((MappedInteractionSource) objRememberedValue4)), ComposableLambdaKt.composableLambda(composer2, -474426875, true, new NavigationBarKt$NavigationBarItem$3$indicator$1(navigationBarItemColors3, stateAnimateFloatAsState2)), composableLambda3, composableLambda, z6, NavigationBarItem$lambda$9$lambda$6(stateAnimateFloatAsState2), composer2, ((i13 >> 9) & 57344) | 438);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier6;
            navigationBarItemColors4 = navigationBarItemColors3;
            mutableInteractionSource4 = mutableInteractionSource3;
            z7 = z4;
            interfaceC0526Fp5 = interfaceC0526Fp4;
            z8 = z6;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    z4 = true;
                }
                if (i6 != 0) {
                    interfaceC0526Fp3 = null;
                }
                if (i8 != 0) {
                    z5 = true;
                } else {
                    z5 = z3;
                }
                if ((128 & i2) != 0) {
                    navigationBarItemColorsM1657colors69fazGs = NavigationBarItemDefaults.INSTANCE.m1657colors69fazGs(0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 12582912, ShapeTypes.VERTICAL_SCROLL);
                    i3 &= -234881025;
                } else {
                    navigationBarItemColorsM1657colors69fazGs = navigationBarItemColors;
                }
                if (i10 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    z6 = z5;
                    modifier3 = modifier2;
                    i12 = i3;
                    interfaceC0526Fp4 = interfaceC0526Fp3;
                    navigationBarItemColors2 = navigationBarItemColorsM1657colors69fazGs;
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    z6 = z5;
                    modifier3 = modifier2;
                    i12 = i3;
                    interfaceC0526Fp4 = interfaceC0526Fp3;
                    mutableInteractionSource2 = mutableInteractionSource;
                    navigationBarItemColors2 = navigationBarItemColorsM1657colors69fazGs;
                }
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    z4 = true;
                }
                if (i6 != 0) {
                    interfaceC0526Fp3 = null;
                }
                if (i8 != 0) {
                    z5 = true;
                } else {
                    z5 = z3;
                }
                if ((128 & i2) != 0) {
                    navigationBarItemColorsM1657colors69fazGs = NavigationBarItemDefaults.INSTANCE.m1657colors69fazGs(0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 12582912, ShapeTypes.VERTICAL_SCROLL);
                    i3 &= -234881025;
                } else {
                    navigationBarItemColorsM1657colors69fazGs = navigationBarItemColors;
                }
                if (i10 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    z6 = z5;
                    modifier3 = modifier2;
                    i12 = i3;
                    interfaceC0526Fp4 = interfaceC0526Fp3;
                    navigationBarItemColors2 = navigationBarItemColorsM1657colors69fazGs;
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    z6 = z5;
                    modifier3 = modifier2;
                    i12 = i3;
                    interfaceC0526Fp4 = interfaceC0526Fp3;
                    mutableInteractionSource2 = mutableInteractionSource;
                    navigationBarItemColors2 = navigationBarItemColorsM1657colors69fazGs;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-663510974, i12, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:159)");
            }
            i13 = i12;
            mutableInteractionSource3 = mutableInteractionSource2;
            composer2 = composerStartRestartGroup;
            navigationBarItemColors3 = navigationBarItemColors2;
            ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composer2, -1419576100, true, new NavigationBarKt$NavigationBarItem$styledIcon$1(navigationBarItemColors2, z, z4, i12, interfaceC0526Fp4, z6, interfaceC0526Fp));
            if (interfaceC0526Fp4 != null) {
                composableLambda = ComposableLambdaKt.composableLambda(composer2, 1644987592, true, new NavigationBarKt$NavigationBarItem$styledLabel$1$1(navigationBarItemColors3, z, z4, i13, interfaceC0526Fp4));
            } else {
                composableLambda = null;
            }
            composer2.startReplaceableGroup(-492369756);
            objRememberedValue2 = composer2.rememberedValue();
            companion = Composer.Companion;
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                composer2.updateRememberedValue(objRememberedValue2);
            }
            composer2.endReplaceableGroup();
            mutableState = (MutableState) objRememberedValue2;
            Modifier modifierA3 = AbstractC3955tM.a(rowScope, SelectableKt.m707selectableO2vRcR0(modifier3, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4556getTabo7Vup1c()), interfaceC3588op), 1.0f, false, 2, null);
            composer2.startReplaceableGroup(1157296644);
            zChanged = composer2.changed(mutableState);
            objRememberedValue3 = composer2.rememberedValue();
            if (zChanged) {
                objRememberedValue3 = new NavigationBarKt$NavigationBarItem$2$1(mutableState);
                composer2.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new NavigationBarKt$NavigationBarItem$2$1(mutableState);
                composer2.updateRememberedValue(objRememberedValue3);
            }
            composer2.endReplaceableGroup();
            Modifier modifierOnSizeChanged3 = OnRemeasuredModifierKt.onSizeChanged(modifierA3, (InterfaceC3750qp) objRememberedValue3);
            Alignment center3 = Alignment.Companion.getCenter();
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(center3, false, composer2, 6);
            composer2.startReplaceableGroup(-1323940314);
            Density density5 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion4 = ComposeUiNode.Companion;
            constructor = companion4.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf3 = LayoutKt.materializerOf(modifierOnSizeChanged3);
            Modifier modifier7 = modifier3;
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
            Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyRememberBoxMeasurePolicy3, companion4.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl3, density5, companion4.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl3, layoutDirection3, companion4.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl3, viewConfiguration3, companion4.getSetViewConfiguration());
            composer2.enableReusing();
            interfaceC0552GpMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            if (z) {
                f = 1.0f;
            } else {
                f = 0.0f;
            }
            State<Float> stateAnimateFloatAsState3 = AnimateAsStateKt.animateFloatAsState(f, AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, null, null, composer2, 48, 28);
            Density density6 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            jOffset = OffsetKt.Offset((NavigationBarItem$lambda$3(mutableState) - density6.mo327roundToPx0680j_4(NavigationBarTokens.INSTANCE.m2353getActiveIndicatorWidthD9Ej5fM())) / 2, density6.mo333toPx0680j_4(IndicatorVerticalOffset));
            FW fw3 = FW.a;
            Offset offsetM2787boximpl3 = Offset.m2787boximpl(jOffset);
            composer2.startReplaceableGroup(511388516);
            zChanged2 = composer2.changed(offsetM2787boximpl3) | composer2.changed(mutableInteractionSource3);
            objRememberedValue4 = composer2.rememberedValue();
            if (zChanged2) {
                objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource3, jOffset, null);
                composer2.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource3, jOffset, null);
                composer2.updateRememberedValue(objRememberedValue4);
            }
            composer2.endReplaceableGroup();
            NavigationBarItemBaselineLayout(ComposableLambdaKt.composableLambda(composer2, 691730997, true, new NavigationBarKt$NavigationBarItem$3$indicatorRipple$1((MappedInteractionSource) objRememberedValue4)), ComposableLambdaKt.composableLambda(composer2, -474426875, true, new NavigationBarKt$NavigationBarItem$3$indicator$1(navigationBarItemColors3, stateAnimateFloatAsState3)), composableLambda4, composableLambda, z6, NavigationBarItem$lambda$9$lambda$6(stateAnimateFloatAsState3), composer2, ((i13 >> 9) & 57344) | 438);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier7;
            navigationBarItemColors4 = navigationBarItemColors3;
            mutableInteractionSource4 = mutableInteractionSource3;
            z7 = z4;
            interfaceC0526Fp5 = interfaceC0526Fp4;
            z8 = z6;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(rowScope, z, interfaceC3588op, interfaceC0526Fp, modifier4, z7, interfaceC0526Fp5, z8, navigationBarItemColors4, mutableInteractionSource4, i, i2));
    }

    private static final int NavigationBarItem$lambda$3(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NavigationBarItem$lambda$4(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float NavigationBarItem$lambda$9$lambda$6(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void NavigationBarItemBaselineLayout(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, final InterfaceC0526Fp interfaceC0526Fp4, final boolean z, final float f, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(591111291);
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
                ComposerKt.traceEventStart(591111291, i2, -1, "androidx.compose.material3.NavigationBarItemBaselineLayout (NavigationBar.kt:426)");
            }
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationBarKt.NavigationBarItemBaselineLayout.2
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
                        if (AbstractC4492zt.d(LayoutIdKt.getLayoutId(measurable2), NavigationBarKt.IconLayoutIdTag)) {
                            Placeable placeableMo4159measureBRTryo1 = measurable2.mo4159measureBRTryo0(j);
                            float f2 = 2;
                            int width = placeableMo4159measureBRTryo1.getWidth() + measureScope.mo327roundToPx0680j_4(Dp.m5160constructorimpl(NavigationBarKt.IndicatorHorizontalPadding * f2));
                            int iC = AbstractC1210aB.c(width * f);
                            int height = placeableMo4159measureBRTryo1.getHeight() + measureScope.mo327roundToPx0680j_4(Dp.m5160constructorimpl(NavigationBarKt.IndicatorVerticalPadding * f2));
                            for (Measurable measurable3 : list2) {
                                if (AbstractC4492zt.d(LayoutIdKt.getLayoutId(measurable3), NavigationBarKt.IndicatorRippleLayoutIdTag)) {
                                    Placeable placeableMo4159measureBRTryo2 = measurable3.mo4159measureBRTryo0(Constraints.Companion.m5136fixedJhjzzOo(width, height));
                                    Iterator<T> it = list2.iterator();
                                    do {
                                        if (!it.hasNext()) {
                                            next = null;
                                            break;
                                        }
                                        next = it.next();
                                    } while (!AbstractC4492zt.d(LayoutIdKt.getLayoutId((Measurable) next), NavigationBarKt.IndicatorLayoutIdTag));
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
                                        return NavigationBarKt.m1662placeIconX9ElhV4(measureScope, placeableMo4159measureBRTryo1, placeableMo4159measureBRTryo2, placeableMo4159measureBRTryo3, j);
                                    }
                                    AbstractC4492zt.e(placeableMo4159measureBRTryo0);
                                    return NavigationBarKt.m1663placeLabelAndIconzUg2_y0(measureScope, placeableMo4159measureBRTryo0, placeableMo4159measureBRTryo1, placeableMo4159measureBRTryo2, placeableMo4159measureBRTryo3, j, z, f);
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
            composerStartRestartGroup.startReplaceableGroup(-311734399);
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
            composerStartRestartGroup.startReplaceableGroup(1204551908);
            if (interfaceC0526Fp4 != null) {
                Modifier modifierM487paddingVpY3zN4$default = PaddingKt.m487paddingVpY3zN4$default(AlphaKt.alpha(LayoutIdKt.layoutId(companion, "label"), z ? 1.0f : f), Dp.m5160constructorimpl(NavigationBarItemHorizontalPadding / 2), 0.0f, 2, null);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                InterfaceC3588op constructor3 = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf3 = LayoutKt.materializerOf(modifierM487paddingVpY3zN4$default);
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
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, z, f, i));
    }

    public static final float getNavigationBarItemHorizontalPadding() {
        return NavigationBarItemHorizontalPadding;
    }

    public static final float getNavigationBarItemVerticalPadding() {
        return NavigationBarItemVerticalPadding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeIcon-X9ElhV4, reason: not valid java name */
    public static final MeasureResult m1662placeIconX9ElhV4(MeasureScope measureScope, Placeable placeable, Placeable placeable2, Placeable placeable3, long j) {
        int iM5128getMaxWidthimpl = Constraints.m5128getMaxWidthimpl(j);
        int iM5127getMaxHeightimpl = Constraints.m5127getMaxHeightimpl(j);
        return MeasureScope.CC.q(measureScope, iM5128getMaxWidthimpl, iM5127getMaxHeightimpl, null, new NavigationBarKt$placeIcon$1(placeable3, placeable, (iM5128getMaxWidthimpl - placeable.getWidth()) / 2, (iM5127getMaxHeightimpl - placeable.getHeight()) / 2, placeable2, (iM5128getMaxWidthimpl - placeable2.getWidth()) / 2, (iM5127getMaxHeightimpl - placeable2.getHeight()) / 2, iM5128getMaxWidthimpl, iM5127getMaxHeightimpl), 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeLabelAndIcon-zUg2_y0, reason: not valid java name */
    public static final MeasureResult m1663placeLabelAndIconzUg2_y0(MeasureScope measureScope, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, long j, boolean z, float f) {
        int iM5127getMaxHeightimpl = Constraints.m5127getMaxHeightimpl(j);
        int height = iM5127getMaxHeightimpl - placeable.getHeight();
        float f2 = NavigationBarItemVerticalPadding;
        int iMo327roundToPx0680j_4 = height - measureScope.mo327roundToPx0680j_4(f2);
        int iMo327roundToPx0680j_5 = measureScope.mo327roundToPx0680j_4(f2);
        int iC = AbstractC1210aB.c(((z ? iMo327roundToPx0680j_5 : (iM5127getMaxHeightimpl - placeable2.getHeight()) / 2) - iMo327roundToPx0680j_5) * (1 - f));
        int iM5128getMaxWidthimpl = Constraints.m5128getMaxWidthimpl(j);
        return MeasureScope.CC.q(measureScope, iM5128getMaxWidthimpl, iM5127getMaxHeightimpl, null, new NavigationBarKt$placeLabelAndIcon$1(placeable4, z, f, placeable, (iM5128getMaxWidthimpl - placeable.getWidth()) / 2, iMo327roundToPx0680j_4, iC, placeable2, (iM5128getMaxWidthimpl - placeable2.getWidth()) / 2, iMo327roundToPx0680j_5, placeable3, (iM5128getMaxWidthimpl - placeable3.getWidth()) / 2, iMo327roundToPx0680j_5 - measureScope.mo327roundToPx0680j_4(IndicatorVerticalPadding), iM5128getMaxWidthimpl, measureScope), 4, null);
    }
}
