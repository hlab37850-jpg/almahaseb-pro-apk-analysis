package androidx.compose.material3;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.shape.GenericShape;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.gms.actions.SearchIntents;
import com.itextpdf.text.Annotation;
import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SearchBarKt {
    private static final int AnimationDelayMillis = 100;
    private static final int AnimationEnterDurationMillis = 600;
    private static final CubicBezierEasing AnimationEnterEasing;
    private static final FiniteAnimationSpec<Float> AnimationEnterFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationEnterSizeSpec;
    private static final int AnimationExitDurationMillis = 350;
    private static final CubicBezierEasing AnimationExitEasing;
    private static final FiniteAnimationSpec<Float> AnimationExitFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationExitSizeSpec;
    private static final float DockedActiveTableMaxHeightScreenRatio = 0.6666667f;
    private static final EnterTransition DockedEnterTransition;
    private static final ExitTransition DockedExitTransition;
    private static final float SearchBarCornerRadius = Dp.m5160constructorimpl(SearchBarDefaults.INSTANCE.m1733getInputFieldHeightD9Ej5fM() / 2);
    private static final float DockedActiveTableMinHeight = Dp.m5160constructorimpl(240);
    private static final float SearchBarMinWidth = Dp.m5160constructorimpl(360);
    private static final float SearchBarMaxWidth = Dp.m5160constructorimpl(720);
    private static final float SearchBarVerticalPadding = Dp.m5160constructorimpl(8);
    private static final float SearchBarIconOffsetX = Dp.m5160constructorimpl(4);

    /* JADX INFO: renamed from: androidx.compose.material3.SearchBarKt$SearchBarInputField$5, reason: invalid class name */
    public static final class AnonymousClass5 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ int $$dirty1;
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ InterfaceC0526Fp $leadingIcon;
        final /* synthetic */ InterfaceC0526Fp $placeholder;
        final /* synthetic */ String $query;
        final /* synthetic */ InterfaceC0526Fp $trailingIcon;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(String str, boolean z, MutableInteractionSource mutableInteractionSource, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, TextFieldColors textFieldColors, int i, int i2) {
            super(3);
            this.$query = str;
            this.$enabled = z;
            this.$interactionSource = mutableInteractionSource;
            this.$placeholder = interfaceC0526Fp;
            this.$leadingIcon = interfaceC0526Fp2;
            this.$trailingIcon = interfaceC0526Fp3;
            this.$colors = textFieldColors;
            this.$$dirty = i;
            this.$$dirty1 = i2;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((InterfaceC0526Fp) obj, (Composer) obj2, ((Number) obj3).intValue());
            return FW.a;
        }

        @Composable
        @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
        public final void invoke(InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
            int i2;
            AbstractC4492zt.h(interfaceC0526Fp, "innerTextField");
            if ((i & 14) == 0) {
                i2 = i | (composer.changedInstance(interfaceC0526Fp) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(584727264, i2, -1, "androidx.compose.material3.SearchBarInputField.<anonymous> (SearchBar.kt:468)");
            }
            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
            String str = this.$query;
            boolean z = this.$enabled;
            VisualTransformation none = VisualTransformation.Companion.getNone();
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            InterfaceC0526Fp interfaceC0526Fp2 = this.$placeholder;
            InterfaceC0526Fp interfaceC0526Fp3 = this.$leadingIcon;
            ComposableLambda composableLambda = interfaceC0526Fp3 != null ? ComposableLambdaKt.composableLambda(composer, -967380630, true, new SearchBarKt$SearchBarInputField$5$1$1(interfaceC0526Fp3)) : null;
            InterfaceC0526Fp interfaceC0526Fp4 = this.$trailingIcon;
            ComposableLambda composableLambda2 = interfaceC0526Fp4 != null ? ComposableLambdaKt.composableLambda(composer, -2117865162, true, new SearchBarKt$SearchBarInputField$5$2$1(interfaceC0526Fp4)) : null;
            Shape inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(composer, 6);
            TextFieldColors textFieldColors = this.$colors;
            PaddingValues paddingValuesM1891contentPaddingWithoutLabela9UjIt4$default = TextFieldDefaults.m1891contentPaddingWithoutLabela9UjIt4$default(textFieldDefaults, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
            InterfaceC0526Fp interfaceC0526FpM1479getLambda1$material3_release = ComposableSingletons$SearchBarKt.INSTANCE.m1479getLambda1$material3_release();
            int i3 = this.$$dirty;
            int i4 = this.$$dirty1;
            textFieldDefaults.DecorationBox(str, interfaceC0526Fp, z, true, none, mutableInteractionSource, false, null, interfaceC0526Fp2, composableLambda, composableLambda2, null, null, null, inputFieldShape, textFieldColors, paddingValuesM1891contentPaddingWithoutLabela9UjIt4$default, interfaceC0526FpM1479getLambda1$material3_release, composer, ((i2 << 3) & 112) | (i3 & 14) | 27648 | ((i3 >> 12) & 896) | ((i4 << 12) & 458752) | ((i3 << 3) & 234881024), ((i4 << 15) & 458752) | 113246208, 14528);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SearchBarKt$SearchBarInputField$6, reason: invalid class name */
    public static final class AnonymousClass6 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$changed1;
        final /* synthetic */ int $$default;
        final /* synthetic */ boolean $active;
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ InterfaceC0526Fp $leadingIcon;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3750qp $onActiveChange;
        final /* synthetic */ InterfaceC3750qp $onQueryChange;
        final /* synthetic */ InterfaceC3750qp $onSearch;
        final /* synthetic */ InterfaceC0526Fp $placeholder;
        final /* synthetic */ String $query;
        final /* synthetic */ InterfaceC0526Fp $trailingIcon;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(String str, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, boolean z, InterfaceC3750qp interfaceC3750qp3, Modifier modifier, boolean z2, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, TextFieldColors textFieldColors, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3) {
            super(2);
            this.$query = str;
            this.$onQueryChange = interfaceC3750qp;
            this.$onSearch = interfaceC3750qp2;
            this.$active = z;
            this.$onActiveChange = interfaceC3750qp3;
            this.$modifier = modifier;
            this.$enabled = z2;
            this.$placeholder = interfaceC0526Fp;
            this.$leadingIcon = interfaceC0526Fp2;
            this.$trailingIcon = interfaceC0526Fp3;
            this.$colors = textFieldColors;
            this.$interactionSource = mutableInteractionSource;
            this.$$changed = i;
            this.$$changed1 = i2;
            this.$$default = i3;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            SearchBarKt.SearchBarInputField(this.$query, this.$onQueryChange, this.$onSearch, this.$active, this.$onActiveChange, this.$modifier, this.$enabled, this.$placeholder, this.$leadingIcon, this.$trailingIcon, this.$colors, this.$interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
        }
    }

    static {
        CubicBezierEasing easingEmphasizedDecelerateCubicBezier = MotionTokens.INSTANCE.getEasingEmphasizedDecelerateCubicBezier();
        AnimationEnterEasing = easingEmphasizedDecelerateCubicBezier;
        CubicBezierEasing cubicBezierEasing = new CubicBezierEasing(0.0f, 1.0f, 0.0f, 1.0f);
        AnimationExitEasing = cubicBezierEasing;
        TweenSpec tweenSpecTween = AnimationSpecKt.tween(600, 100, easingEmphasizedDecelerateCubicBezier);
        AnimationEnterFloatSpec = tweenSpecTween;
        TweenSpec tweenSpecTween2 = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, cubicBezierEasing);
        AnimationExitFloatSpec = tweenSpecTween2;
        TweenSpec tweenSpecTween3 = AnimationSpecKt.tween(600, 100, easingEmphasizedDecelerateCubicBezier);
        AnimationEnterSizeSpec = tweenSpecTween3;
        TweenSpec tweenSpecTween4 = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, cubicBezierEasing);
        AnimationExitSizeSpec = tweenSpecTween4;
        DockedEnterTransition = EnterExitTransitionKt.fadeIn$default(tweenSpecTween, 0.0f, 2, null).plus(EnterExitTransitionKt.expandVertically$default(tweenSpecTween3, null, false, null, 14, null));
        DockedExitTransition = EnterExitTransitionKt.fadeOut$default(tweenSpecTween2, 0.0f, 2, null).plus(EnterExitTransitionKt.shrinkVertically$default(tweenSpecTween4, null, false, null, 14, null));
    }

    /* JADX WARN: Code duplicated, block: B:138:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:140:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:142:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:144:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:148:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:149:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:151:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:153:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:157:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:163:0x020e  */
    /* JADX WARN: Code duplicated, block: B:165:0x0215  */
    /* JADX WARN: Code duplicated, block: B:175:0x0240 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:176:0x0242  */
    /* JADX WARN: Code duplicated, block: B:177:0x0245  */
    /* JADX WARN: Code duplicated, block: B:179:0x0249  */
    /* JADX WARN: Code duplicated, block: B:180:0x024b  */
    /* JADX WARN: Code duplicated, block: B:182:0x024f  */
    /* JADX WARN: Code duplicated, block: B:183:0x0251  */
    /* JADX WARN: Code duplicated, block: B:185:0x0255  */
    /* JADX WARN: Code duplicated, block: B:186:0x0257  */
    /* JADX WARN: Code duplicated, block: B:188:0x025b  */
    /* JADX WARN: Code duplicated, block: B:189:0x025d  */
    /* JADX WARN: Code duplicated, block: B:192:0x0263  */
    /* JADX WARN: Code duplicated, block: B:193:0x026d  */
    /* JADX WARN: Code duplicated, block: B:196:0x0274  */
    /* JADX WARN: Code duplicated, block: B:197:0x0289  */
    /* JADX WARN: Code duplicated, block: B:199:0x028d  */
    /* JADX WARN: Code duplicated, block: B:200:0x0294  */
    /* JADX WARN: Code duplicated, block: B:202:0x0298  */
    /* JADX WARN: Code duplicated, block: B:204:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:207:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:210:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:213:0x0388  */
    /* JADX WARN: Code duplicated, block: B:215:0x0390  */
    /* JADX WARN: Code duplicated, block: B:218:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:223:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:225:? A[RETURN, SYNTHETIC] */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: DockedSearchBar-rpjkMjA, reason: not valid java name */
    public static final void m1736DockedSearchBarrpjkMjA(String str, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, boolean z, InterfaceC3750qp interfaceC3750qp3, Modifier modifier, boolean z2, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, Shape shape, SearchBarColors searchBarColors, float f, MutableInteractionSource mutableInteractionSource, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        Modifier modifier2;
        boolean z3;
        InterfaceC0526Fp interfaceC0526Fp4;
        InterfaceC0526Fp interfaceC0526Fp5;
        InterfaceC0526Fp interfaceC0526Fp6;
        Shape dockedShape;
        SearchBarColors searchBarColorsM1731colorsKlgxPg;
        float fM1732getElevationD9Ej5fM;
        InterfaceC0526Fp interfaceC0526Fp7;
        MutableInteractionSource mutableInteractionSource2;
        InterfaceC0526Fp interfaceC0526Fp8;
        InterfaceC0526Fp interfaceC0526Fp9;
        boolean z4;
        float f2;
        Shape shape2;
        SearchBarColors searchBarColors2;
        int i7;
        Modifier modifier3;
        Object objRememberedValue;
        Composer composer2;
        boolean zChanged;
        Object objRememberedValue2;
        Modifier modifier4;
        boolean z5;
        InterfaceC0526Fp interfaceC0526Fp10;
        InterfaceC0526Fp interfaceC0526Fp11;
        InterfaceC0526Fp interfaceC0526Fp12;
        Shape shape3;
        SearchBarColors searchBarColors3;
        float f3;
        MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(str, SearchIntents.EXTRA_QUERY);
        AbstractC4492zt.h(interfaceC3750qp, "onQueryChange");
        AbstractC4492zt.h(interfaceC3750qp2, "onSearch");
        AbstractC4492zt.h(interfaceC3750qp3, "onActiveChange");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-451213062);
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC3750qp) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC3750qp2) ? 256 : 128;
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 7168) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i3 & 16) != 0) {
            i4 |= 24576;
        } else if ((i & 57344) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC3750qp3) ? 16384 : 8192;
        }
        int i8 = i3 & 32;
        if (i8 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & 458752) == 0) {
            i4 |= composerStartRestartGroup.changed(modifier) ? 131072 : 65536;
        }
        int i9 = i3 & 64;
        if (i9 != 0) {
            i4 |= 1572864;
        } else if ((i & 3670016) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? 1048576 : 524288;
        }
        int i10 = i3 & 128;
        if (i10 != 0) {
            i4 |= 12582912;
        } else if ((i & 29360128) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 8388608 : 4194304;
        }
        int i11 = i3 & 256;
        if (i11 != 0) {
            i4 |= 100663296;
        } else if ((i & 234881024) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp2) ? 67108864 : 33554432;
        }
        int i12 = i3 & 512;
        if (i12 != 0) {
            i4 |= 805306368;
        } else if ((i & 1879048192) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp3) ? PropertyOptions.DELETE_EXISTING : 268435456;
        }
        if ((i2 & 14) == 0) {
            i5 = i2 | (((i3 & 1024) == 0 && composerStartRestartGroup.changed(shape)) ? 4 : 2);
        } else {
            i5 = i2;
        }
        if ((i2 & 112) == 0) {
            i5 |= ((i3 & 2048) == 0 && composerStartRestartGroup.changed(searchBarColors)) ? 32 : 16;
        }
        int i13 = i5;
        int i14 = i3 & 4096;
        if (i14 == 0) {
            if ((i2 & 896) == 0) {
                i13 |= composerStartRestartGroup.changed(f) ? 256 : 128;
            }
            i6 = i3 & 8192;
            if (i6 != 0) {
                if ((i2 & 7168) == 0) {
                    i13 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 2048 : 1024;
                }
                if ((i3 & 16384) != 0) {
                    i13 |= 24576;
                } else if ((i2 & 57344) == 0) {
                    i13 |= composerStartRestartGroup.changedInstance(interfaceC0552Gp) ? 16384 : 8192;
                }
                if ((1533916891 & i4) != 306783378 && (46811 & i13) == 9362 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z5 = z2;
                    interfaceC0526Fp10 = interfaceC0526Fp;
                    interfaceC0526Fp11 = interfaceC0526Fp2;
                    interfaceC0526Fp12 = interfaceC0526Fp3;
                    shape3 = shape;
                    searchBarColors3 = searchBarColors;
                    f3 = f;
                    mutableInteractionSource3 = mutableInteractionSource;
                    composer2 = composerStartRestartGroup;
                    modifier4 = modifier;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i9 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp5 = null;
                        } else {
                            interfaceC0526Fp5 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp3;
                        }
                        if ((i3 & 1024) != 0) {
                            dockedShape = SearchBarDefaults.INSTANCE.getDockedShape(composerStartRestartGroup, 6);
                            i13 &= -15;
                        } else {
                            dockedShape = shape;
                        }
                        if ((i3 & 2048) != 0) {
                            searchBarColorsM1731colorsKlgxPg = SearchBarDefaults.INSTANCE.m1731colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                            i13 &= -113;
                        } else {
                            searchBarColorsM1731colorsKlgxPg = searchBarColors;
                        }
                        if (i14 != 0) {
                            fM1732getElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m1732getElevationD9Ej5fM();
                        } else {
                            fM1732getElevationD9Ej5fM = f;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            InterfaceC0526Fp interfaceC0526Fp13 = interfaceC0526Fp5;
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            interfaceC0526Fp7 = interfaceC0526Fp13;
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp5;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                        z4 = z3;
                        f2 = fM1732getElevationD9Ej5fM;
                        shape2 = dockedShape;
                        searchBarColors2 = searchBarColorsM1731colorsKlgxPg;
                        i7 = i13;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 1024) != 0) {
                            i13 &= -15;
                        }
                        if ((i3 & 2048) != 0) {
                            i13 &= -113;
                        }
                        modifier3 = modifier;
                        z4 = z2;
                        interfaceC0526Fp9 = interfaceC0526Fp;
                        interfaceC0526Fp7 = interfaceC0526Fp2;
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                        shape2 = shape;
                        searchBarColors2 = searchBarColors;
                        f2 = f;
                        mutableInteractionSource2 = mutableInteractionSource;
                        i7 = i13;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-451213062, i4, i7, "androidx.compose.material3.DockedSearchBar (SearchBar.kt:342)");
                    }
                    FocusManager focusManager = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                    long jM1729getContainerColor0d7_KjU = searchBarColors2.m1729getContainerColor0d7_KjU();
                    long jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(searchBarColors2.m1729getContainerColor0d7_KjU(), composerStartRestartGroup, 0);
                    Modifier modifierM537width3ABfNKs = SizeKt.m537width3ABfNKs(ZIndexModifierKt.zIndex(modifier3, 1.0f), SearchBarMinWidth);
                    int i15 = i4;
                    Modifier modifier5 = modifier3;
                    composer2 = composerStartRestartGroup;
                    int i16 = i7;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifierM537width3ABfNKs, shape2, jM1729getContainerColor0d7_KjU, jM1449contentColorForek8zF_U, f2, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -1764436203, true, new SearchBarKt$DockedSearchBar$2(str, interfaceC3750qp, interfaceC3750qp2, z, interfaceC3750qp3, z4, interfaceC0526Fp9, interfaceC0526Fp7, interfaceC0526Fp8, searchBarColors2, mutableInteractionSource2, i15, i7, interfaceC0552Gp)), composer2, ((i16 << 3) & 112) | 12582912 | ((i16 << 6) & 57344), 96);
                    int i17 = (i15 >> 9) & 14;
                    EffectsKt.LaunchedEffect(Boolean.valueOf(z), new SearchBarKt$DockedSearchBar$3(z, focusManager, null), composer2, i17 | 64);
                    composer2.startReplaceableGroup(1157296644);
                    zChanged = composer2.changed(interfaceC3750qp3);
                    objRememberedValue2 = composer2.rememberedValue();
                    if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = new SearchBarKt$DockedSearchBar$4$1(interfaceC3750qp3);
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    composer2.endReplaceableGroup();
                    BackHandlerKt.BackHandler(z, (InterfaceC3588op) objRememberedValue2, composer2, i17, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier5;
                    z5 = z4;
                    interfaceC0526Fp10 = interfaceC0526Fp9;
                    interfaceC0526Fp11 = interfaceC0526Fp7;
                    interfaceC0526Fp12 = interfaceC0526Fp8;
                    shape3 = shape2;
                    searchBarColors3 = searchBarColors2;
                    f3 = f2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new SearchBarKt$DockedSearchBar$5(str, interfaceC3750qp, interfaceC3750qp2, z, interfaceC3750qp3, modifier4, z5, interfaceC0526Fp10, interfaceC0526Fp11, interfaceC0526Fp12, shape3, searchBarColors3, f3, mutableInteractionSource3, interfaceC0552Gp, i, i2, i3));
            }
            i13 |= 3072;
            if ((i3 & 16384) != 0) {
                i13 |= 24576;
            } else if ((i2 & 57344) == 0) {
                i13 |= composerStartRestartGroup.changedInstance(interfaceC0552Gp) ? 16384 : 8192;
            }
            if ((1533916891 & i4) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp5 = null;
                    } else {
                        interfaceC0526Fp5 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp3;
                    }
                    if ((i3 & 1024) != 0) {
                        dockedShape = SearchBarDefaults.INSTANCE.getDockedShape(composerStartRestartGroup, 6);
                        i13 &= -15;
                    } else {
                        dockedShape = shape;
                    }
                    if ((i3 & 2048) != 0) {
                        searchBarColorsM1731colorsKlgxPg = SearchBarDefaults.INSTANCE.m1731colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                        i13 &= -113;
                    } else {
                        searchBarColorsM1731colorsKlgxPg = searchBarColors;
                    }
                    if (i14 != 0) {
                        fM1732getElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m1732getElevationD9Ej5fM();
                    } else {
                        fM1732getElevationD9Ej5fM = f;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        InterfaceC0526Fp interfaceC0526Fp14 = interfaceC0526Fp5;
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        interfaceC0526Fp7 = interfaceC0526Fp14;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    interfaceC0526Fp9 = interfaceC0526Fp4;
                    z4 = z3;
                    f2 = fM1732getElevationD9Ej5fM;
                    shape2 = dockedShape;
                    searchBarColors2 = searchBarColorsM1731colorsKlgxPg;
                    i7 = i13;
                    modifier3 = modifier2;
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp5 = null;
                    } else {
                        interfaceC0526Fp5 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp3;
                    }
                    if ((i3 & 1024) != 0) {
                        dockedShape = SearchBarDefaults.INSTANCE.getDockedShape(composerStartRestartGroup, 6);
                        i13 &= -15;
                    } else {
                        dockedShape = shape;
                    }
                    if ((i3 & 2048) != 0) {
                        searchBarColorsM1731colorsKlgxPg = SearchBarDefaults.INSTANCE.m1731colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                        i13 &= -113;
                    } else {
                        searchBarColorsM1731colorsKlgxPg = searchBarColors;
                    }
                    if (i14 != 0) {
                        fM1732getElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m1732getElevationD9Ej5fM();
                    } else {
                        fM1732getElevationD9Ej5fM = f;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        InterfaceC0526Fp interfaceC0526Fp15 = interfaceC0526Fp5;
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        interfaceC0526Fp7 = interfaceC0526Fp15;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    interfaceC0526Fp9 = interfaceC0526Fp4;
                    z4 = z3;
                    f2 = fM1732getElevationD9Ej5fM;
                    shape2 = dockedShape;
                    searchBarColors2 = searchBarColorsM1731colorsKlgxPg;
                    i7 = i13;
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-451213062, i4, i7, "androidx.compose.material3.DockedSearchBar (SearchBar.kt:342)");
                }
                FocusManager focusManager2 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                long jM1729getContainerColor0d7_KjU2 = searchBarColors2.m1729getContainerColor0d7_KjU();
                long jM1449contentColorForek8zF_U2 = ColorSchemeKt.m1449contentColorForek8zF_U(searchBarColors2.m1729getContainerColor0d7_KjU(), composerStartRestartGroup, 0);
                Modifier modifierM537width3ABfNKs2 = SizeKt.m537width3ABfNKs(ZIndexModifierKt.zIndex(modifier3, 1.0f), SearchBarMinWidth);
                int i18 = i4;
                Modifier modifier6 = modifier3;
                composer2 = composerStartRestartGroup;
                int i19 = i7;
                SurfaceKt.m1850SurfaceT9BRK9s(modifierM537width3ABfNKs2, shape2, jM1729getContainerColor0d7_KjU2, jM1449contentColorForek8zF_U2, f2, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -1764436203, true, new SearchBarKt$DockedSearchBar$2(str, interfaceC3750qp, interfaceC3750qp2, z, interfaceC3750qp3, z4, interfaceC0526Fp9, interfaceC0526Fp7, interfaceC0526Fp8, searchBarColors2, mutableInteractionSource2, i18, i7, interfaceC0552Gp)), composer2, ((i19 << 3) & 112) | 12582912 | ((i19 << 6) & 57344), 96);
                int i110 = (i18 >> 9) & 14;
                EffectsKt.LaunchedEffect(Boolean.valueOf(z), new SearchBarKt$DockedSearchBar$3(z, focusManager2, null), composer2, i110 | 64);
                composer2.startReplaceableGroup(1157296644);
                zChanged = composer2.changed(interfaceC3750qp3);
                objRememberedValue2 = composer2.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new SearchBarKt$DockedSearchBar$4$1(interfaceC3750qp3);
                    composer2.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new SearchBarKt$DockedSearchBar$4$1(interfaceC3750qp3);
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                composer2.endReplaceableGroup();
                BackHandlerKt.BackHandler(z, (InterfaceC3588op) objRememberedValue2, composer2, i110, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier6;
                z5 = z4;
                interfaceC0526Fp10 = interfaceC0526Fp9;
                interfaceC0526Fp11 = interfaceC0526Fp7;
                interfaceC0526Fp12 = interfaceC0526Fp8;
                shape3 = shape2;
                searchBarColors3 = searchBarColors2;
                f3 = f2;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp5 = null;
                    } else {
                        interfaceC0526Fp5 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp3;
                    }
                    if ((i3 & 1024) != 0) {
                        dockedShape = SearchBarDefaults.INSTANCE.getDockedShape(composerStartRestartGroup, 6);
                        i13 &= -15;
                    } else {
                        dockedShape = shape;
                    }
                    if ((i3 & 2048) != 0) {
                        searchBarColorsM1731colorsKlgxPg = SearchBarDefaults.INSTANCE.m1731colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                        i13 &= -113;
                    } else {
                        searchBarColorsM1731colorsKlgxPg = searchBarColors;
                    }
                    if (i14 != 0) {
                        fM1732getElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m1732getElevationD9Ej5fM();
                    } else {
                        fM1732getElevationD9Ej5fM = f;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        InterfaceC0526Fp interfaceC0526Fp16 = interfaceC0526Fp5;
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        interfaceC0526Fp7 = interfaceC0526Fp16;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    interfaceC0526Fp9 = interfaceC0526Fp4;
                    z4 = z3;
                    f2 = fM1732getElevationD9Ej5fM;
                    shape2 = dockedShape;
                    searchBarColors2 = searchBarColorsM1731colorsKlgxPg;
                    i7 = i13;
                    modifier3 = modifier2;
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp5 = null;
                    } else {
                        interfaceC0526Fp5 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp3;
                    }
                    if ((i3 & 1024) != 0) {
                        dockedShape = SearchBarDefaults.INSTANCE.getDockedShape(composerStartRestartGroup, 6);
                        i13 &= -15;
                    } else {
                        dockedShape = shape;
                    }
                    if ((i3 & 2048) != 0) {
                        searchBarColorsM1731colorsKlgxPg = SearchBarDefaults.INSTANCE.m1731colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                        i13 &= -113;
                    } else {
                        searchBarColorsM1731colorsKlgxPg = searchBarColors;
                    }
                    if (i14 != 0) {
                        fM1732getElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m1732getElevationD9Ej5fM();
                    } else {
                        fM1732getElevationD9Ej5fM = f;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        InterfaceC0526Fp interfaceC0526Fp17 = interfaceC0526Fp5;
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        interfaceC0526Fp7 = interfaceC0526Fp17;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    interfaceC0526Fp9 = interfaceC0526Fp4;
                    z4 = z3;
                    f2 = fM1732getElevationD9Ej5fM;
                    shape2 = dockedShape;
                    searchBarColors2 = searchBarColorsM1731colorsKlgxPg;
                    i7 = i13;
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-451213062, i4, i7, "androidx.compose.material3.DockedSearchBar (SearchBar.kt:342)");
                }
                FocusManager focusManager3 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                long jM1729getContainerColor0d7_KjU3 = searchBarColors2.m1729getContainerColor0d7_KjU();
                long jM1449contentColorForek8zF_U3 = ColorSchemeKt.m1449contentColorForek8zF_U(searchBarColors2.m1729getContainerColor0d7_KjU(), composerStartRestartGroup, 0);
                Modifier modifierM537width3ABfNKs3 = SizeKt.m537width3ABfNKs(ZIndexModifierKt.zIndex(modifier3, 1.0f), SearchBarMinWidth);
                int i111 = i4;
                Modifier modifier7 = modifier3;
                composer2 = composerStartRestartGroup;
                int i112 = i7;
                SurfaceKt.m1850SurfaceT9BRK9s(modifierM537width3ABfNKs3, shape2, jM1729getContainerColor0d7_KjU3, jM1449contentColorForek8zF_U3, f2, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -1764436203, true, new SearchBarKt$DockedSearchBar$2(str, interfaceC3750qp, interfaceC3750qp2, z, interfaceC3750qp3, z4, interfaceC0526Fp9, interfaceC0526Fp7, interfaceC0526Fp8, searchBarColors2, mutableInteractionSource2, i111, i7, interfaceC0552Gp)), composer2, ((i112 << 3) & 112) | 12582912 | ((i112 << 6) & 57344), 96);
                int i113 = (i111 >> 9) & 14;
                EffectsKt.LaunchedEffect(Boolean.valueOf(z), new SearchBarKt$DockedSearchBar$3(z, focusManager3, null), composer2, i113 | 64);
                composer2.startReplaceableGroup(1157296644);
                zChanged = composer2.changed(interfaceC3750qp3);
                objRememberedValue2 = composer2.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new SearchBarKt$DockedSearchBar$4$1(interfaceC3750qp3);
                    composer2.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new SearchBarKt$DockedSearchBar$4$1(interfaceC3750qp3);
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                composer2.endReplaceableGroup();
                BackHandlerKt.BackHandler(z, (InterfaceC3588op) objRememberedValue2, composer2, i113, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier7;
                z5 = z4;
                interfaceC0526Fp10 = interfaceC0526Fp9;
                interfaceC0526Fp11 = interfaceC0526Fp7;
                interfaceC0526Fp12 = interfaceC0526Fp8;
                shape3 = shape2;
                searchBarColors3 = searchBarColors2;
                f3 = f2;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SearchBarKt$DockedSearchBar$5(str, interfaceC3750qp, interfaceC3750qp2, z, interfaceC3750qp3, modifier4, z5, interfaceC0526Fp10, interfaceC0526Fp11, interfaceC0526Fp12, shape3, searchBarColors3, f3, mutableInteractionSource3, interfaceC0552Gp, i, i2, i3));
        }
        i13 |= 384;
        i6 = i3 & 8192;
        if (i6 != 0) {
            if ((i2 & 7168) == 0) {
                i13 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 2048 : 1024;
            }
            if ((i3 & 16384) != 0) {
                i13 |= 24576;
            } else if ((i2 & 57344) == 0) {
                i13 |= composerStartRestartGroup.changedInstance(interfaceC0552Gp) ? 16384 : 8192;
            }
            if ((1533916891 & i4) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp5 = null;
                    } else {
                        interfaceC0526Fp5 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp3;
                    }
                    if ((i3 & 1024) != 0) {
                        dockedShape = SearchBarDefaults.INSTANCE.getDockedShape(composerStartRestartGroup, 6);
                        i13 &= -15;
                    } else {
                        dockedShape = shape;
                    }
                    if ((i3 & 2048) != 0) {
                        searchBarColorsM1731colorsKlgxPg = SearchBarDefaults.INSTANCE.m1731colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                        i13 &= -113;
                    } else {
                        searchBarColorsM1731colorsKlgxPg = searchBarColors;
                    }
                    if (i14 != 0) {
                        fM1732getElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m1732getElevationD9Ej5fM();
                    } else {
                        fM1732getElevationD9Ej5fM = f;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        InterfaceC0526Fp interfaceC0526Fp18 = interfaceC0526Fp5;
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        interfaceC0526Fp7 = interfaceC0526Fp18;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    interfaceC0526Fp9 = interfaceC0526Fp4;
                    z4 = z3;
                    f2 = fM1732getElevationD9Ej5fM;
                    shape2 = dockedShape;
                    searchBarColors2 = searchBarColorsM1731colorsKlgxPg;
                    i7 = i13;
                    modifier3 = modifier2;
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp5 = null;
                    } else {
                        interfaceC0526Fp5 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp3;
                    }
                    if ((i3 & 1024) != 0) {
                        dockedShape = SearchBarDefaults.INSTANCE.getDockedShape(composerStartRestartGroup, 6);
                        i13 &= -15;
                    } else {
                        dockedShape = shape;
                    }
                    if ((i3 & 2048) != 0) {
                        searchBarColorsM1731colorsKlgxPg = SearchBarDefaults.INSTANCE.m1731colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                        i13 &= -113;
                    } else {
                        searchBarColorsM1731colorsKlgxPg = searchBarColors;
                    }
                    if (i14 != 0) {
                        fM1732getElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m1732getElevationD9Ej5fM();
                    } else {
                        fM1732getElevationD9Ej5fM = f;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        InterfaceC0526Fp interfaceC0526Fp19 = interfaceC0526Fp5;
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        interfaceC0526Fp7 = interfaceC0526Fp19;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    interfaceC0526Fp9 = interfaceC0526Fp4;
                    z4 = z3;
                    f2 = fM1732getElevationD9Ej5fM;
                    shape2 = dockedShape;
                    searchBarColors2 = searchBarColorsM1731colorsKlgxPg;
                    i7 = i13;
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-451213062, i4, i7, "androidx.compose.material3.DockedSearchBar (SearchBar.kt:342)");
                }
                FocusManager focusManager4 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                long jM1729getContainerColor0d7_KjU4 = searchBarColors2.m1729getContainerColor0d7_KjU();
                long jM1449contentColorForek8zF_U4 = ColorSchemeKt.m1449contentColorForek8zF_U(searchBarColors2.m1729getContainerColor0d7_KjU(), composerStartRestartGroup, 0);
                Modifier modifierM537width3ABfNKs4 = SizeKt.m537width3ABfNKs(ZIndexModifierKt.zIndex(modifier3, 1.0f), SearchBarMinWidth);
                int i114 = i4;
                Modifier modifier8 = modifier3;
                composer2 = composerStartRestartGroup;
                int i115 = i7;
                SurfaceKt.m1850SurfaceT9BRK9s(modifierM537width3ABfNKs4, shape2, jM1729getContainerColor0d7_KjU4, jM1449contentColorForek8zF_U4, f2, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -1764436203, true, new SearchBarKt$DockedSearchBar$2(str, interfaceC3750qp, interfaceC3750qp2, z, interfaceC3750qp3, z4, interfaceC0526Fp9, interfaceC0526Fp7, interfaceC0526Fp8, searchBarColors2, mutableInteractionSource2, i114, i7, interfaceC0552Gp)), composer2, ((i115 << 3) & 112) | 12582912 | ((i115 << 6) & 57344), 96);
                int i116 = (i114 >> 9) & 14;
                EffectsKt.LaunchedEffect(Boolean.valueOf(z), new SearchBarKt$DockedSearchBar$3(z, focusManager4, null), composer2, i116 | 64);
                composer2.startReplaceableGroup(1157296644);
                zChanged = composer2.changed(interfaceC3750qp3);
                objRememberedValue2 = composer2.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new SearchBarKt$DockedSearchBar$4$1(interfaceC3750qp3);
                    composer2.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new SearchBarKt$DockedSearchBar$4$1(interfaceC3750qp3);
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                composer2.endReplaceableGroup();
                BackHandlerKt.BackHandler(z, (InterfaceC3588op) objRememberedValue2, composer2, i116, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier8;
                z5 = z4;
                interfaceC0526Fp10 = interfaceC0526Fp9;
                interfaceC0526Fp11 = interfaceC0526Fp7;
                interfaceC0526Fp12 = interfaceC0526Fp8;
                shape3 = shape2;
                searchBarColors3 = searchBarColors2;
                f3 = f2;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp5 = null;
                    } else {
                        interfaceC0526Fp5 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp3;
                    }
                    if ((i3 & 1024) != 0) {
                        dockedShape = SearchBarDefaults.INSTANCE.getDockedShape(composerStartRestartGroup, 6);
                        i13 &= -15;
                    } else {
                        dockedShape = shape;
                    }
                    if ((i3 & 2048) != 0) {
                        searchBarColorsM1731colorsKlgxPg = SearchBarDefaults.INSTANCE.m1731colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                        i13 &= -113;
                    } else {
                        searchBarColorsM1731colorsKlgxPg = searchBarColors;
                    }
                    if (i14 != 0) {
                        fM1732getElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m1732getElevationD9Ej5fM();
                    } else {
                        fM1732getElevationD9Ej5fM = f;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        InterfaceC0526Fp interfaceC0526Fp110 = interfaceC0526Fp5;
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        interfaceC0526Fp7 = interfaceC0526Fp110;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    interfaceC0526Fp9 = interfaceC0526Fp4;
                    z4 = z3;
                    f2 = fM1732getElevationD9Ej5fM;
                    shape2 = dockedShape;
                    searchBarColors2 = searchBarColorsM1731colorsKlgxPg;
                    i7 = i13;
                    modifier3 = modifier2;
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp5 = null;
                    } else {
                        interfaceC0526Fp5 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp3;
                    }
                    if ((i3 & 1024) != 0) {
                        dockedShape = SearchBarDefaults.INSTANCE.getDockedShape(composerStartRestartGroup, 6);
                        i13 &= -15;
                    } else {
                        dockedShape = shape;
                    }
                    if ((i3 & 2048) != 0) {
                        searchBarColorsM1731colorsKlgxPg = SearchBarDefaults.INSTANCE.m1731colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                        i13 &= -113;
                    } else {
                        searchBarColorsM1731colorsKlgxPg = searchBarColors;
                    }
                    if (i14 != 0) {
                        fM1732getElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m1732getElevationD9Ej5fM();
                    } else {
                        fM1732getElevationD9Ej5fM = f;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        InterfaceC0526Fp interfaceC0526Fp111 = interfaceC0526Fp5;
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        interfaceC0526Fp7 = interfaceC0526Fp111;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    interfaceC0526Fp9 = interfaceC0526Fp4;
                    z4 = z3;
                    f2 = fM1732getElevationD9Ej5fM;
                    shape2 = dockedShape;
                    searchBarColors2 = searchBarColorsM1731colorsKlgxPg;
                    i7 = i13;
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-451213062, i4, i7, "androidx.compose.material3.DockedSearchBar (SearchBar.kt:342)");
                }
                FocusManager focusManager5 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                long jM1729getContainerColor0d7_KjU5 = searchBarColors2.m1729getContainerColor0d7_KjU();
                long jM1449contentColorForek8zF_U5 = ColorSchemeKt.m1449contentColorForek8zF_U(searchBarColors2.m1729getContainerColor0d7_KjU(), composerStartRestartGroup, 0);
                Modifier modifierM537width3ABfNKs5 = SizeKt.m537width3ABfNKs(ZIndexModifierKt.zIndex(modifier3, 1.0f), SearchBarMinWidth);
                int i117 = i4;
                Modifier modifier9 = modifier3;
                composer2 = composerStartRestartGroup;
                int i118 = i7;
                SurfaceKt.m1850SurfaceT9BRK9s(modifierM537width3ABfNKs5, shape2, jM1729getContainerColor0d7_KjU5, jM1449contentColorForek8zF_U5, f2, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -1764436203, true, new SearchBarKt$DockedSearchBar$2(str, interfaceC3750qp, interfaceC3750qp2, z, interfaceC3750qp3, z4, interfaceC0526Fp9, interfaceC0526Fp7, interfaceC0526Fp8, searchBarColors2, mutableInteractionSource2, i117, i7, interfaceC0552Gp)), composer2, ((i118 << 3) & 112) | 12582912 | ((i118 << 6) & 57344), 96);
                int i119 = (i117 >> 9) & 14;
                EffectsKt.LaunchedEffect(Boolean.valueOf(z), new SearchBarKt$DockedSearchBar$3(z, focusManager5, null), composer2, i119 | 64);
                composer2.startReplaceableGroup(1157296644);
                zChanged = composer2.changed(interfaceC3750qp3);
                objRememberedValue2 = composer2.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new SearchBarKt$DockedSearchBar$4$1(interfaceC3750qp3);
                    composer2.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new SearchBarKt$DockedSearchBar$4$1(interfaceC3750qp3);
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                composer2.endReplaceableGroup();
                BackHandlerKt.BackHandler(z, (InterfaceC3588op) objRememberedValue2, composer2, i119, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier9;
                z5 = z4;
                interfaceC0526Fp10 = interfaceC0526Fp9;
                interfaceC0526Fp11 = interfaceC0526Fp7;
                interfaceC0526Fp12 = interfaceC0526Fp8;
                shape3 = shape2;
                searchBarColors3 = searchBarColors2;
                f3 = f2;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SearchBarKt$DockedSearchBar$5(str, interfaceC3750qp, interfaceC3750qp2, z, interfaceC3750qp3, modifier4, z5, interfaceC0526Fp10, interfaceC0526Fp11, interfaceC0526Fp12, shape3, searchBarColors3, f3, mutableInteractionSource3, interfaceC0552Gp, i, i2, i3));
        }
        i13 |= 3072;
        if ((i3 & 16384) != 0) {
            i13 |= 24576;
        } else if ((i2 & 57344) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(interfaceC0552Gp) ? 16384 : 8192;
        }
        if ((1533916891 & i4) != 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i9 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i10 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp;
                }
                if (i11 != 0) {
                    interfaceC0526Fp5 = null;
                } else {
                    interfaceC0526Fp5 = interfaceC0526Fp2;
                }
                if (i12 != 0) {
                    interfaceC0526Fp6 = null;
                } else {
                    interfaceC0526Fp6 = interfaceC0526Fp3;
                }
                if ((i3 & 1024) != 0) {
                    dockedShape = SearchBarDefaults.INSTANCE.getDockedShape(composerStartRestartGroup, 6);
                    i13 &= -15;
                } else {
                    dockedShape = shape;
                }
                if ((i3 & 2048) != 0) {
                    searchBarColorsM1731colorsKlgxPg = SearchBarDefaults.INSTANCE.m1731colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                    i13 &= -113;
                } else {
                    searchBarColorsM1731colorsKlgxPg = searchBarColors;
                }
                if (i14 != 0) {
                    fM1732getElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m1732getElevationD9Ej5fM();
                } else {
                    fM1732getElevationD9Ej5fM = f;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    InterfaceC0526Fp interfaceC0526Fp112 = interfaceC0526Fp5;
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    interfaceC0526Fp7 = interfaceC0526Fp112;
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                interfaceC0526Fp8 = interfaceC0526Fp6;
                interfaceC0526Fp9 = interfaceC0526Fp4;
                z4 = z3;
                f2 = fM1732getElevationD9Ej5fM;
                shape2 = dockedShape;
                searchBarColors2 = searchBarColorsM1731colorsKlgxPg;
                i7 = i13;
                modifier3 = modifier2;
            } else {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i9 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i10 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp;
                }
                if (i11 != 0) {
                    interfaceC0526Fp5 = null;
                } else {
                    interfaceC0526Fp5 = interfaceC0526Fp2;
                }
                if (i12 != 0) {
                    interfaceC0526Fp6 = null;
                } else {
                    interfaceC0526Fp6 = interfaceC0526Fp3;
                }
                if ((i3 & 1024) != 0) {
                    dockedShape = SearchBarDefaults.INSTANCE.getDockedShape(composerStartRestartGroup, 6);
                    i13 &= -15;
                } else {
                    dockedShape = shape;
                }
                if ((i3 & 2048) != 0) {
                    searchBarColorsM1731colorsKlgxPg = SearchBarDefaults.INSTANCE.m1731colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                    i13 &= -113;
                } else {
                    searchBarColorsM1731colorsKlgxPg = searchBarColors;
                }
                if (i14 != 0) {
                    fM1732getElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m1732getElevationD9Ej5fM();
                } else {
                    fM1732getElevationD9Ej5fM = f;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    InterfaceC0526Fp interfaceC0526Fp113 = interfaceC0526Fp5;
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    interfaceC0526Fp7 = interfaceC0526Fp113;
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                interfaceC0526Fp8 = interfaceC0526Fp6;
                interfaceC0526Fp9 = interfaceC0526Fp4;
                z4 = z3;
                f2 = fM1732getElevationD9Ej5fM;
                shape2 = dockedShape;
                searchBarColors2 = searchBarColorsM1731colorsKlgxPg;
                i7 = i13;
                modifier3 = modifier2;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-451213062, i4, i7, "androidx.compose.material3.DockedSearchBar (SearchBar.kt:342)");
            }
            FocusManager focusManager6 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            long jM1729getContainerColor0d7_KjU6 = searchBarColors2.m1729getContainerColor0d7_KjU();
            long jM1449contentColorForek8zF_U6 = ColorSchemeKt.m1449contentColorForek8zF_U(searchBarColors2.m1729getContainerColor0d7_KjU(), composerStartRestartGroup, 0);
            Modifier modifierM537width3ABfNKs6 = SizeKt.m537width3ABfNKs(ZIndexModifierKt.zIndex(modifier3, 1.0f), SearchBarMinWidth);
            int i1110 = i4;
            Modifier modifier10 = modifier3;
            composer2 = composerStartRestartGroup;
            int i1111 = i7;
            SurfaceKt.m1850SurfaceT9BRK9s(modifierM537width3ABfNKs6, shape2, jM1729getContainerColor0d7_KjU6, jM1449contentColorForek8zF_U6, f2, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -1764436203, true, new SearchBarKt$DockedSearchBar$2(str, interfaceC3750qp, interfaceC3750qp2, z, interfaceC3750qp3, z4, interfaceC0526Fp9, interfaceC0526Fp7, interfaceC0526Fp8, searchBarColors2, mutableInteractionSource2, i1110, i7, interfaceC0552Gp)), composer2, ((i1111 << 3) & 112) | 12582912 | ((i1111 << 6) & 57344), 96);
            int i1112 = (i1110 >> 9) & 14;
            EffectsKt.LaunchedEffect(Boolean.valueOf(z), new SearchBarKt$DockedSearchBar$3(z, focusManager6, null), composer2, i1112 | 64);
            composer2.startReplaceableGroup(1157296644);
            zChanged = composer2.changed(interfaceC3750qp3);
            objRememberedValue2 = composer2.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = new SearchBarKt$DockedSearchBar$4$1(interfaceC3750qp3);
                composer2.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new SearchBarKt$DockedSearchBar$4$1(interfaceC3750qp3);
                composer2.updateRememberedValue(objRememberedValue2);
            }
            composer2.endReplaceableGroup();
            BackHandlerKt.BackHandler(z, (InterfaceC3588op) objRememberedValue2, composer2, i1112, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier10;
            z5 = z4;
            interfaceC0526Fp10 = interfaceC0526Fp9;
            interfaceC0526Fp11 = interfaceC0526Fp7;
            interfaceC0526Fp12 = interfaceC0526Fp8;
            shape3 = shape2;
            searchBarColors3 = searchBarColors2;
            f3 = f2;
            mutableInteractionSource3 = mutableInteractionSource2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i9 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i10 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp;
                }
                if (i11 != 0) {
                    interfaceC0526Fp5 = null;
                } else {
                    interfaceC0526Fp5 = interfaceC0526Fp2;
                }
                if (i12 != 0) {
                    interfaceC0526Fp6 = null;
                } else {
                    interfaceC0526Fp6 = interfaceC0526Fp3;
                }
                if ((i3 & 1024) != 0) {
                    dockedShape = SearchBarDefaults.INSTANCE.getDockedShape(composerStartRestartGroup, 6);
                    i13 &= -15;
                } else {
                    dockedShape = shape;
                }
                if ((i3 & 2048) != 0) {
                    searchBarColorsM1731colorsKlgxPg = SearchBarDefaults.INSTANCE.m1731colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                    i13 &= -113;
                } else {
                    searchBarColorsM1731colorsKlgxPg = searchBarColors;
                }
                if (i14 != 0) {
                    fM1732getElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m1732getElevationD9Ej5fM();
                } else {
                    fM1732getElevationD9Ej5fM = f;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    InterfaceC0526Fp interfaceC0526Fp114 = interfaceC0526Fp5;
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    interfaceC0526Fp7 = interfaceC0526Fp114;
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                interfaceC0526Fp8 = interfaceC0526Fp6;
                interfaceC0526Fp9 = interfaceC0526Fp4;
                z4 = z3;
                f2 = fM1732getElevationD9Ej5fM;
                shape2 = dockedShape;
                searchBarColors2 = searchBarColorsM1731colorsKlgxPg;
                i7 = i13;
                modifier3 = modifier2;
            } else {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i9 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i10 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp;
                }
                if (i11 != 0) {
                    interfaceC0526Fp5 = null;
                } else {
                    interfaceC0526Fp5 = interfaceC0526Fp2;
                }
                if (i12 != 0) {
                    interfaceC0526Fp6 = null;
                } else {
                    interfaceC0526Fp6 = interfaceC0526Fp3;
                }
                if ((i3 & 1024) != 0) {
                    dockedShape = SearchBarDefaults.INSTANCE.getDockedShape(composerStartRestartGroup, 6);
                    i13 &= -15;
                } else {
                    dockedShape = shape;
                }
                if ((i3 & 2048) != 0) {
                    searchBarColorsM1731colorsKlgxPg = SearchBarDefaults.INSTANCE.m1731colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                    i13 &= -113;
                } else {
                    searchBarColorsM1731colorsKlgxPg = searchBarColors;
                }
                if (i14 != 0) {
                    fM1732getElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m1732getElevationD9Ej5fM();
                } else {
                    fM1732getElevationD9Ej5fM = f;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    InterfaceC0526Fp interfaceC0526Fp115 = interfaceC0526Fp5;
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    interfaceC0526Fp7 = interfaceC0526Fp115;
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                interfaceC0526Fp8 = interfaceC0526Fp6;
                interfaceC0526Fp9 = interfaceC0526Fp4;
                z4 = z3;
                f2 = fM1732getElevationD9Ej5fM;
                shape2 = dockedShape;
                searchBarColors2 = searchBarColorsM1731colorsKlgxPg;
                i7 = i13;
                modifier3 = modifier2;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-451213062, i4, i7, "androidx.compose.material3.DockedSearchBar (SearchBar.kt:342)");
            }
            FocusManager focusManager7 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            long jM1729getContainerColor0d7_KjU7 = searchBarColors2.m1729getContainerColor0d7_KjU();
            long jM1449contentColorForek8zF_U7 = ColorSchemeKt.m1449contentColorForek8zF_U(searchBarColors2.m1729getContainerColor0d7_KjU(), composerStartRestartGroup, 0);
            Modifier modifierM537width3ABfNKs7 = SizeKt.m537width3ABfNKs(ZIndexModifierKt.zIndex(modifier3, 1.0f), SearchBarMinWidth);
            int i1113 = i4;
            Modifier modifier11 = modifier3;
            composer2 = composerStartRestartGroup;
            int i1114 = i7;
            SurfaceKt.m1850SurfaceT9BRK9s(modifierM537width3ABfNKs7, shape2, jM1729getContainerColor0d7_KjU7, jM1449contentColorForek8zF_U7, f2, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -1764436203, true, new SearchBarKt$DockedSearchBar$2(str, interfaceC3750qp, interfaceC3750qp2, z, interfaceC3750qp3, z4, interfaceC0526Fp9, interfaceC0526Fp7, interfaceC0526Fp8, searchBarColors2, mutableInteractionSource2, i1113, i7, interfaceC0552Gp)), composer2, ((i1114 << 3) & 112) | 12582912 | ((i1114 << 6) & 57344), 96);
            int i1115 = (i1113 >> 9) & 14;
            EffectsKt.LaunchedEffect(Boolean.valueOf(z), new SearchBarKt$DockedSearchBar$3(z, focusManager7, null), composer2, i1115 | 64);
            composer2.startReplaceableGroup(1157296644);
            zChanged = composer2.changed(interfaceC3750qp3);
            objRememberedValue2 = composer2.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = new SearchBarKt$DockedSearchBar$4$1(interfaceC3750qp3);
                composer2.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new SearchBarKt$DockedSearchBar$4$1(interfaceC3750qp3);
                composer2.updateRememberedValue(objRememberedValue2);
            }
            composer2.endReplaceableGroup();
            BackHandlerKt.BackHandler(z, (InterfaceC3588op) objRememberedValue2, composer2, i1115, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier11;
            z5 = z4;
            interfaceC0526Fp10 = interfaceC0526Fp9;
            interfaceC0526Fp11 = interfaceC0526Fp7;
            interfaceC0526Fp12 = interfaceC0526Fp8;
            shape3 = shape2;
            searchBarColors3 = searchBarColors2;
            f3 = f2;
            mutableInteractionSource3 = mutableInteractionSource2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new SearchBarKt$DockedSearchBar$5(str, interfaceC3750qp, interfaceC3750qp2, z, interfaceC3750qp3, modifier4, z5, interfaceC0526Fp10, interfaceC0526Fp11, interfaceC0526Fp12, shape3, searchBarColors3, f3, mutableInteractionSource3, interfaceC0552Gp, i, i2, i3));
    }

    /* JADX WARN: Code duplicated, block: B:138:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:145:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:148:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:149:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:151:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:154:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:158:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:160:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:162:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:164:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:165:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:168:0x0208  */
    /* JADX WARN: Code duplicated, block: B:174:0x0234  */
    /* JADX WARN: Code duplicated, block: B:176:0x023b  */
    /* JADX WARN: Code duplicated, block: B:189:0x026e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:190:0x0270  */
    /* JADX WARN: Code duplicated, block: B:191:0x0273  */
    /* JADX WARN: Code duplicated, block: B:193:0x0277  */
    /* JADX WARN: Code duplicated, block: B:194:0x0279  */
    /* JADX WARN: Code duplicated, block: B:196:0x027d  */
    /* JADX WARN: Code duplicated, block: B:197:0x027f  */
    /* JADX WARN: Code duplicated, block: B:199:0x0283  */
    /* JADX WARN: Code duplicated, block: B:200:0x0285  */
    /* JADX WARN: Code duplicated, block: B:202:0x0289  */
    /* JADX WARN: Code duplicated, block: B:203:0x028b  */
    /* JADX WARN: Code duplicated, block: B:206:0x0291  */
    /* JADX WARN: Code duplicated, block: B:207:0x029d  */
    /* JADX WARN: Code duplicated, block: B:210:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:211:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:213:0x02be  */
    /* JADX WARN: Code duplicated, block: B:214:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:217:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:218:0x02da  */
    /* JADX WARN: Code duplicated, block: B:220:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:222:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:224:0x0311  */
    /* JADX WARN: Code duplicated, block: B:227:0x032c  */
    /* JADX WARN: Code duplicated, block: B:229:0x0336  */
    /* JADX WARN: Code duplicated, block: B:230:0x0339  */
    /* JADX WARN: Code duplicated, block: B:232:0x033c  */
    /* JADX WARN: Code duplicated, block: B:233:0x033f  */
    /* JADX WARN: Code duplicated, block: B:236:0x0391  */
    /* JADX WARN: Code duplicated, block: B:239:0x03c6  */
    /* JADX WARN: Code duplicated, block: B:241:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:243:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:244:0x03dd  */
    /* JADX WARN: Code duplicated, block: B:246:0x03e3  */
    /* JADX WARN: Code duplicated, block: B:247:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:251:0x0401  */
    /* JADX WARN: Code duplicated, block: B:252:0x040c  */
    /* JADX WARN: Code duplicated, block: B:255:0x0423  */
    /* JADX WARN: Code duplicated, block: B:257:0x0429  */
    /* JADX WARN: Code duplicated, block: B:260:0x0464  */
    /* JADX WARN: Code duplicated, block: B:262:0x046a  */
    /* JADX WARN: Code duplicated, block: B:265:0x0494  */
    /* JADX WARN: Code duplicated, block: B:267:0x049a  */
    /* JADX WARN: Code duplicated, block: B:270:0x053c  */
    /* JADX WARN: Code duplicated, block: B:272:0x0542  */
    /* JADX WARN: Code duplicated, block: B:275:0x0559  */
    /* JADX WARN: Code duplicated, block: B:280:0x0575  */
    /* JADX WARN: Code duplicated, block: B:282:? A[RETURN, SYNTHETIC] */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: SearchBar-Id_Pb_0, reason: not valid java name */
    public static final void m1737SearchBarId_Pb_0(String str, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, boolean z, InterfaceC3750qp interfaceC3750qp3, Modifier modifier, boolean z2, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, Shape shape, SearchBarColors searchBarColors, float f, WindowInsets windowInsets, MutableInteractionSource mutableInteractionSource, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        Modifier modifier2;
        boolean z3;
        InterfaceC0526Fp interfaceC0526Fp4;
        InterfaceC0526Fp interfaceC0526Fp5;
        InterfaceC0526Fp interfaceC0526Fp6;
        Shape inputFieldShape;
        SearchBarColors searchBarColorsM1731colorsKlgxPg;
        float fM1732getElevationD9Ej5fM;
        SearchBarColors searchBarColors2;
        WindowInsets windowInsets2;
        InterfaceC0526Fp interfaceC0526Fp7;
        SearchBarColors searchBarColors3;
        InterfaceC0526Fp interfaceC0526Fp8;
        InterfaceC0526Fp interfaceC0526Fp9;
        boolean z4;
        Shape shape2;
        float f2;
        MutableInteractionSource mutableInteractionSource3;
        WindowInsets windowInsets3;
        int i8;
        Modifier modifier3;
        Object objRememberedValue;
        float f3;
        FiniteAnimationSpec<Float> finiteAnimationSpec;
        State<Float> stateAnimateFloatAsState;
        Density density;
        Shape inputFieldShape2;
        Shape fullScreenShape;
        Object objRememberedValue2;
        Composer.Companion companion;
        State state;
        boolean zChanged;
        Object objRememberedValue3;
        Object objRememberedValue4;
        MutableWindowInsets mutableWindowInsets;
        boolean zChanged2;
        Object objRememberedValue5;
        State state2;
        boolean zChanged3;
        Object objRememberedValue6;
        boolean zChanged4;
        Object objRememberedValue7;
        WindowInsets windowInsets4;
        Composer composer2;
        boolean zChanged5;
        Object objRememberedValue8;
        boolean z5;
        InterfaceC0526Fp interfaceC0526Fp10;
        InterfaceC0526Fp interfaceC0526Fp11;
        InterfaceC0526Fp interfaceC0526Fp12;
        SearchBarColors searchBarColors4;
        float f4;
        MutableInteractionSource mutableInteractionSource4;
        Shape shape3;
        Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(str, SearchIntents.EXTRA_QUERY);
        AbstractC4492zt.h(interfaceC3750qp, "onQueryChange");
        AbstractC4492zt.h(interfaceC3750qp2, "onSearch");
        AbstractC4492zt.h(interfaceC3750qp3, "onActiveChange");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(156000634);
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC3750qp) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC3750qp2) ? 256 : 128;
        }
        int i9 = 1024;
        if ((i3 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 7168) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i3 & 16) != 0) {
            i4 |= 24576;
        } else if ((i & 57344) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC3750qp3) ? 16384 : 8192;
        }
        int i10 = i3 & 32;
        if (i10 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & 458752) == 0) {
            i4 |= composerStartRestartGroup.changed(modifier) ? 131072 : 65536;
        }
        int i11 = i3 & 64;
        if (i11 != 0) {
            i4 |= 1572864;
        } else if ((i & 3670016) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? 1048576 : 524288;
        }
        int i12 = i3 & 128;
        if (i12 != 0) {
            i4 |= 12582912;
        } else if ((i & 29360128) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 8388608 : 4194304;
        }
        int i13 = i3 & 256;
        if (i13 != 0) {
            i4 |= 100663296;
        } else if ((i & 234881024) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp2) ? 67108864 : 33554432;
        }
        int i14 = i3 & 512;
        if (i14 != 0) {
            i4 |= 805306368;
        } else if ((i & 1879048192) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp3) ? PropertyOptions.DELETE_EXISTING : 268435456;
        }
        if ((i2 & 14) == 0) {
            i5 = i2 | (((i3 & 1024) == 0 && composerStartRestartGroup.changed(shape)) ? 4 : 2);
        } else {
            i5 = i2;
        }
        if ((i2 & 112) == 0) {
            i5 |= ((i3 & 2048) == 0 && composerStartRestartGroup.changed(searchBarColors)) ? 32 : 16;
        }
        int i15 = i5;
        int i16 = i3 & 4096;
        if (i16 == 0) {
            if ((i2 & 896) == 0) {
                i15 |= composerStartRestartGroup.changed(f) ? 256 : 128;
            }
            if ((i2 & 7168) != 0) {
                if ((i3 & 8192) == 0 && composerStartRestartGroup.changed(windowInsets)) {
                    i9 = 2048;
                }
                i15 |= i9;
            }
            i6 = i3 & 16384;
            if (i6 != 0) {
                i15 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 57344) == 0) {
                    i15 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
                }
            }
            if ((i3 & 32768) != 0) {
                if ((i2 & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                }
                if ((i4 & 1533916891) != 306783378 && (374491 & i15) == 74898 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z5 = z2;
                    interfaceC0526Fp10 = interfaceC0526Fp;
                    interfaceC0526Fp11 = interfaceC0526Fp2;
                    interfaceC0526Fp12 = interfaceC0526Fp3;
                    shape3 = shape;
                    f4 = f;
                    windowInsets4 = windowInsets;
                    mutableInteractionSource4 = mutableInteractionSource2;
                    searchBarColors4 = searchBarColors;
                    composer2 = composerStartRestartGroup;
                    modifier4 = modifier;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i11 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp5 = null;
                        } else {
                            interfaceC0526Fp5 = interfaceC0526Fp2;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp3;
                        }
                        if ((i3 & 1024) != 0) {
                            inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(composerStartRestartGroup, 6);
                            i15 &= -15;
                        } else {
                            inputFieldShape = shape;
                        }
                        if ((i3 & 2048) != 0) {
                            searchBarColorsM1731colorsKlgxPg = SearchBarDefaults.INSTANCE.m1731colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                            i15 &= -113;
                        } else {
                            searchBarColorsM1731colorsKlgxPg = searchBarColors;
                        }
                        if (i16 != 0) {
                            fM1732getElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m1732getElevationD9Ej5fM();
                        } else {
                            fM1732getElevationD9Ej5fM = f;
                        }
                        searchBarColors2 = searchBarColorsM1731colorsKlgxPg;
                        if ((i3 & 8192) != 0) {
                            windowInsets2 = SearchBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                            i15 &= -7169;
                        } else {
                            windowInsets2 = windowInsets;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            interfaceC0526Fp7 = interfaceC0526Fp5;
                            searchBarColors3 = searchBarColors2;
                            interfaceC0526Fp8 = interfaceC0526Fp6;
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            modifier3 = modifier2;
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                            z4 = z3;
                            shape2 = inputFieldShape;
                            f2 = fM1732getElevationD9Ej5fM;
                            windowInsets3 = windowInsets2;
                            i8 = i15;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp5;
                            searchBarColors3 = searchBarColors2;
                            interfaceC0526Fp8 = interfaceC0526Fp6;
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                            z4 = z3;
                            shape2 = inputFieldShape;
                            f2 = fM1732getElevationD9Ej5fM;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            windowInsets3 = windowInsets2;
                            i8 = i15;
                            modifier3 = modifier2;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 1024) != 0) {
                            i15 &= -15;
                        }
                        if ((i3 & 2048) != 0) {
                            i15 &= -113;
                        }
                        if ((i3 & 8192) != 0) {
                            i15 &= -7169;
                        }
                        z4 = z2;
                        interfaceC0526Fp9 = interfaceC0526Fp;
                        interfaceC0526Fp7 = interfaceC0526Fp2;
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                        shape2 = shape;
                        searchBarColors3 = searchBarColors;
                        f2 = f;
                        windowInsets3 = windowInsets;
                        i8 = i15;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier3 = modifier;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(156000634, i4, i8, "androidx.compose.material3.SearchBar (SearchBar.kt:159)");
                    }
                    if (z) {
                        f3 = 1.0f;
                    } else {
                        f3 = 0.0f;
                    }
                    if (z) {
                        finiteAnimationSpec = AnimationEnterFloatSpec;
                    } else {
                        finiteAnimationSpec = AnimationExitFloatSpec;
                    }
                    stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f3, finiteAnimationSpec, 0.0f, null, null, composerStartRestartGroup, 64, 28);
                    FocusManager focusManager = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                    density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    SearchBarDefaults searchBarDefaults = SearchBarDefaults.INSTANCE;
                    inputFieldShape2 = searchBarDefaults.getInputFieldShape(composerStartRestartGroup, 6);
                    fullScreenShape = searchBarDefaults.getFullScreenShape(composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    int i17 = i4;
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new SearchBarKt$SearchBar$useFullScreenShape$2$1(stateAnimateFloatAsState));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    state = (State) objRememberedValue2;
                    Boolean boolValueOf = Boolean.valueOf(SearchBar_Id_Pb_0$lambda$2(state));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(boolValueOf) | composerStartRestartGroup.changed(shape2);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                        if (AbstractC4492zt.d(shape2, inputFieldShape2)) {
                            objRememberedValue3 = new GenericShape(new SearchBarKt$SearchBar$animatedShape$1$1(density, stateAnimateFloatAsState));
                        } else if (SearchBar_Id_Pb_0$lambda$2(state)) {
                            objRememberedValue3 = fullScreenShape;
                        } else {
                            objRememberedValue3 = shape2;
                        }
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Shape shape4 = (Shape) objRememberedValue3;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new MutableWindowInsets(null, 1, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableWindowInsets = (MutableWindowInsets) objRememberedValue4;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged2 = composerStartRestartGroup.changed(density);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2 || objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = SnapshotStateKt.derivedStateOf(new SearchBarKt$SearchBar$topPadding$1$1(mutableWindowInsets, density));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    state2 = (State) objRememberedValue5;
                    long jM1729getContainerColor0d7_KjU = searchBarColors3.m1729getContainerColor0d7_KjU();
                    long jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(searchBarColors3.m1729getContainerColor0d7_KjU(), composerStartRestartGroup, 0);
                    Modifier modifierZIndex = ZIndexModifierKt.zIndex(modifier3, 1.0f);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged3 = composerStartRestartGroup.changed(mutableWindowInsets) | composerStartRestartGroup.changed(windowInsets3);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (zChanged3 || objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = new SearchBarKt$SearchBar$2$1(mutableWindowInsets, windowInsets3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierConsumeWindowInsets = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifierZIndex, (InterfaceC3750qp) objRememberedValue6), mutableWindowInsets);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged4 = composerStartRestartGroup.changed(state2) | composerStartRestartGroup.changed(stateAnimateFloatAsState);
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (zChanged4 || objRememberedValue7 == companion.getEmpty()) {
                        objRememberedValue7 = new SearchBarKt$SearchBar$3$1(state2, stateAnimateFloatAsState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i18 = i8;
                    windowInsets4 = windowInsets3;
                    Shape shape5 = shape2;
                    Modifier modifier5 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1850SurfaceT9BRK9s(LayoutModifierKt.layout(modifierConsumeWindowInsets, (InterfaceC0552Gp) objRememberedValue7), shape4, jM1729getContainerColor0d7_KjU, jM1449contentColorForek8zF_U, f2, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -867266817, true, new SearchBarKt$SearchBar$4(str, interfaceC3750qp, interfaceC3750qp2, z, interfaceC3750qp3, z4, interfaceC0526Fp9, interfaceC0526Fp7, interfaceC0526Fp8, searchBarColors3, mutableInteractionSource3, i17, i18, stateAnimateFloatAsState, state2, interfaceC0552Gp)), composer2, ((i18 << 6) & 57344) | 12582912, 96);
                    int i19 = (i17 >> 9) & 14;
                    EffectsKt.LaunchedEffect(Boolean.valueOf(z), new SearchBarKt$SearchBar$5(z, focusManager, null), composer2, i19 | 64);
                    composer2.startReplaceableGroup(1157296644);
                    zChanged5 = composer2.changed(interfaceC3750qp3);
                    objRememberedValue8 = composer2.rememberedValue();
                    if (zChanged5 || objRememberedValue8 == companion.getEmpty()) {
                        objRememberedValue8 = new SearchBarKt$SearchBar$6$1(interfaceC3750qp3);
                        composer2.updateRememberedValue(objRememberedValue8);
                    }
                    composer2.endReplaceableGroup();
                    BackHandlerKt.BackHandler(z, (InterfaceC3588op) objRememberedValue8, composer2, i19, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z4;
                    interfaceC0526Fp10 = interfaceC0526Fp9;
                    interfaceC0526Fp11 = interfaceC0526Fp7;
                    interfaceC0526Fp12 = interfaceC0526Fp8;
                    searchBarColors4 = searchBarColors3;
                    f4 = f2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shape5;
                    modifier4 = modifier5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new SearchBarKt$SearchBar$7(str, interfaceC3750qp, interfaceC3750qp2, z, interfaceC3750qp3, modifier4, z5, interfaceC0526Fp10, interfaceC0526Fp11, interfaceC0526Fp12, shape3, searchBarColors4, f4, windowInsets4, mutableInteractionSource4, interfaceC0552Gp, i, i2, i3));
            }
            i7 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i15 |= i7;
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i11 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp5 = null;
                    } else {
                        interfaceC0526Fp5 = interfaceC0526Fp2;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp3;
                    }
                    if ((i3 & 1024) != 0) {
                        inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(composerStartRestartGroup, 6);
                        i15 &= -15;
                    } else {
                        inputFieldShape = shape;
                    }
                    if ((i3 & 2048) != 0) {
                        searchBarColorsM1731colorsKlgxPg = SearchBarDefaults.INSTANCE.m1731colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                        i15 &= -113;
                    } else {
                        searchBarColorsM1731colorsKlgxPg = searchBarColors;
                    }
                    if (i16 != 0) {
                        fM1732getElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m1732getElevationD9Ej5fM();
                    } else {
                        fM1732getElevationD9Ej5fM = f;
                    }
                    searchBarColors2 = searchBarColorsM1731colorsKlgxPg;
                    if ((i3 & 8192) != 0) {
                        windowInsets2 = SearchBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        i15 &= -7169;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        searchBarColors3 = searchBarColors2;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        modifier3 = modifier2;
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                        z4 = z3;
                        shape2 = inputFieldShape;
                        f2 = fM1732getElevationD9Ej5fM;
                        windowInsets3 = windowInsets2;
                        i8 = i15;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        searchBarColors3 = searchBarColors2;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                        z4 = z3;
                        shape2 = inputFieldShape;
                        f2 = fM1732getElevationD9Ej5fM;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        windowInsets3 = windowInsets2;
                        i8 = i15;
                        modifier3 = modifier2;
                    }
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i11 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp5 = null;
                    } else {
                        interfaceC0526Fp5 = interfaceC0526Fp2;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp3;
                    }
                    if ((i3 & 1024) != 0) {
                        inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(composerStartRestartGroup, 6);
                        i15 &= -15;
                    } else {
                        inputFieldShape = shape;
                    }
                    if ((i3 & 2048) != 0) {
                        searchBarColorsM1731colorsKlgxPg = SearchBarDefaults.INSTANCE.m1731colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                        i15 &= -113;
                    } else {
                        searchBarColorsM1731colorsKlgxPg = searchBarColors;
                    }
                    if (i16 != 0) {
                        fM1732getElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m1732getElevationD9Ej5fM();
                    } else {
                        fM1732getElevationD9Ej5fM = f;
                    }
                    searchBarColors2 = searchBarColorsM1731colorsKlgxPg;
                    if ((i3 & 8192) != 0) {
                        windowInsets2 = SearchBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        i15 &= -7169;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        searchBarColors3 = searchBarColors2;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        modifier3 = modifier2;
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                        z4 = z3;
                        shape2 = inputFieldShape;
                        f2 = fM1732getElevationD9Ej5fM;
                        windowInsets3 = windowInsets2;
                        i8 = i15;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        searchBarColors3 = searchBarColors2;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                        z4 = z3;
                        shape2 = inputFieldShape;
                        f2 = fM1732getElevationD9Ej5fM;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        windowInsets3 = windowInsets2;
                        i8 = i15;
                        modifier3 = modifier2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(156000634, i4, i8, "androidx.compose.material3.SearchBar (SearchBar.kt:159)");
                }
                if (z) {
                    f3 = 1.0f;
                } else {
                    f3 = 0.0f;
                }
                if (z) {
                    finiteAnimationSpec = AnimationEnterFloatSpec;
                } else {
                    finiteAnimationSpec = AnimationExitFloatSpec;
                }
                stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f3, finiteAnimationSpec, 0.0f, null, null, composerStartRestartGroup, 64, 28);
                FocusManager focusManager2 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                SearchBarDefaults searchBarDefaults2 = SearchBarDefaults.INSTANCE;
                inputFieldShape2 = searchBarDefaults2.getInputFieldShape(composerStartRestartGroup, 6);
                fullScreenShape = searchBarDefaults2.getFullScreenShape(composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                int i110 = i4;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new SearchBarKt$SearchBar$useFullScreenShape$2$1(stateAnimateFloatAsState));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                state = (State) objRememberedValue2;
                Boolean boolValueOf2 = Boolean.valueOf(SearchBar_Id_Pb_0$lambda$2(state));
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(boolValueOf2) | composerStartRestartGroup.changed(shape2);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    if (AbstractC4492zt.d(shape2, inputFieldShape2)) {
                        objRememberedValue3 = new GenericShape(new SearchBarKt$SearchBar$animatedShape$1$1(density, stateAnimateFloatAsState));
                    } else if (SearchBar_Id_Pb_0$lambda$2(state)) {
                        objRememberedValue3 = fullScreenShape;
                    } else {
                        objRememberedValue3 = shape2;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (AbstractC4492zt.d(shape2, inputFieldShape2)) {
                        objRememberedValue3 = new GenericShape(new SearchBarKt$SearchBar$animatedShape$1$1(density, stateAnimateFloatAsState));
                    } else if (SearchBar_Id_Pb_0$lambda$2(state)) {
                        objRememberedValue3 = fullScreenShape;
                    } else {
                        objRememberedValue3 = shape2;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Shape shape6 = (Shape) objRememberedValue3;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new MutableWindowInsets(null, 1, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableWindowInsets = (MutableWindowInsets) objRememberedValue4;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged2 = composerStartRestartGroup.changed(density);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    objRememberedValue5 = SnapshotStateKt.derivedStateOf(new SearchBarKt$SearchBar$topPadding$1$1(mutableWindowInsets, density));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = SnapshotStateKt.derivedStateOf(new SearchBarKt$SearchBar$topPadding$1$1(mutableWindowInsets, density));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                composerStartRestartGroup.endReplaceableGroup();
                state2 = (State) objRememberedValue5;
                long jM1729getContainerColor0d7_KjU2 = searchBarColors3.m1729getContainerColor0d7_KjU();
                long jM1449contentColorForek8zF_U2 = ColorSchemeKt.m1449contentColorForek8zF_U(searchBarColors3.m1729getContainerColor0d7_KjU(), composerStartRestartGroup, 0);
                Modifier modifierZIndex2 = ZIndexModifierKt.zIndex(modifier3, 1.0f);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged3 = composerStartRestartGroup.changed(mutableWindowInsets) | composerStartRestartGroup.changed(windowInsets3);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChanged3) {
                    objRememberedValue6 = new SearchBarKt$SearchBar$2$1(mutableWindowInsets, windowInsets3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new SearchBarKt$SearchBar$2$1(mutableWindowInsets, windowInsets3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierConsumeWindowInsets2 = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifierZIndex2, (InterfaceC3750qp) objRememberedValue6), mutableWindowInsets);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged4 = composerStartRestartGroup.changed(state2) | composerStartRestartGroup.changed(stateAnimateFloatAsState);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (zChanged4) {
                    objRememberedValue7 = new SearchBarKt$SearchBar$3$1(state2, stateAnimateFloatAsState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new SearchBarKt$SearchBar$3$1(state2, stateAnimateFloatAsState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i111 = i8;
                windowInsets4 = windowInsets3;
                Shape shape7 = shape2;
                Modifier modifier6 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1850SurfaceT9BRK9s(LayoutModifierKt.layout(modifierConsumeWindowInsets2, (InterfaceC0552Gp) objRememberedValue7), shape6, jM1729getContainerColor0d7_KjU2, jM1449contentColorForek8zF_U2, f2, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -867266817, true, new SearchBarKt$SearchBar$4(str, interfaceC3750qp, interfaceC3750qp2, z, interfaceC3750qp3, z4, interfaceC0526Fp9, interfaceC0526Fp7, interfaceC0526Fp8, searchBarColors3, mutableInteractionSource3, i110, i111, stateAnimateFloatAsState, state2, interfaceC0552Gp)), composer2, ((i111 << 6) & 57344) | 12582912, 96);
                int i112 = (i110 >> 9) & 14;
                EffectsKt.LaunchedEffect(Boolean.valueOf(z), new SearchBarKt$SearchBar$5(z, focusManager2, null), composer2, i112 | 64);
                composer2.startReplaceableGroup(1157296644);
                zChanged5 = composer2.changed(interfaceC3750qp3);
                objRememberedValue8 = composer2.rememberedValue();
                if (zChanged5) {
                    objRememberedValue8 = new SearchBarKt$SearchBar$6$1(interfaceC3750qp3);
                    composer2.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new SearchBarKt$SearchBar$6$1(interfaceC3750qp3);
                    composer2.updateRememberedValue(objRememberedValue8);
                }
                composer2.endReplaceableGroup();
                BackHandlerKt.BackHandler(z, (InterfaceC3588op) objRememberedValue8, composer2, i112, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z4;
                interfaceC0526Fp10 = interfaceC0526Fp9;
                interfaceC0526Fp11 = interfaceC0526Fp7;
                interfaceC0526Fp12 = interfaceC0526Fp8;
                searchBarColors4 = searchBarColors3;
                f4 = f2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape3 = shape7;
                modifier4 = modifier6;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i11 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp5 = null;
                    } else {
                        interfaceC0526Fp5 = interfaceC0526Fp2;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp3;
                    }
                    if ((i3 & 1024) != 0) {
                        inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(composerStartRestartGroup, 6);
                        i15 &= -15;
                    } else {
                        inputFieldShape = shape;
                    }
                    if ((i3 & 2048) != 0) {
                        searchBarColorsM1731colorsKlgxPg = SearchBarDefaults.INSTANCE.m1731colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                        i15 &= -113;
                    } else {
                        searchBarColorsM1731colorsKlgxPg = searchBarColors;
                    }
                    if (i16 != 0) {
                        fM1732getElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m1732getElevationD9Ej5fM();
                    } else {
                        fM1732getElevationD9Ej5fM = f;
                    }
                    searchBarColors2 = searchBarColorsM1731colorsKlgxPg;
                    if ((i3 & 8192) != 0) {
                        windowInsets2 = SearchBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        i15 &= -7169;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        searchBarColors3 = searchBarColors2;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        modifier3 = modifier2;
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                        z4 = z3;
                        shape2 = inputFieldShape;
                        f2 = fM1732getElevationD9Ej5fM;
                        windowInsets3 = windowInsets2;
                        i8 = i15;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        searchBarColors3 = searchBarColors2;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                        z4 = z3;
                        shape2 = inputFieldShape;
                        f2 = fM1732getElevationD9Ej5fM;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        windowInsets3 = windowInsets2;
                        i8 = i15;
                        modifier3 = modifier2;
                    }
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i11 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp5 = null;
                    } else {
                        interfaceC0526Fp5 = interfaceC0526Fp2;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp3;
                    }
                    if ((i3 & 1024) != 0) {
                        inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(composerStartRestartGroup, 6);
                        i15 &= -15;
                    } else {
                        inputFieldShape = shape;
                    }
                    if ((i3 & 2048) != 0) {
                        searchBarColorsM1731colorsKlgxPg = SearchBarDefaults.INSTANCE.m1731colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                        i15 &= -113;
                    } else {
                        searchBarColorsM1731colorsKlgxPg = searchBarColors;
                    }
                    if (i16 != 0) {
                        fM1732getElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m1732getElevationD9Ej5fM();
                    } else {
                        fM1732getElevationD9Ej5fM = f;
                    }
                    searchBarColors2 = searchBarColorsM1731colorsKlgxPg;
                    if ((i3 & 8192) != 0) {
                        windowInsets2 = SearchBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        i15 &= -7169;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        searchBarColors3 = searchBarColors2;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        modifier3 = modifier2;
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                        z4 = z3;
                        shape2 = inputFieldShape;
                        f2 = fM1732getElevationD9Ej5fM;
                        windowInsets3 = windowInsets2;
                        i8 = i15;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        searchBarColors3 = searchBarColors2;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                        z4 = z3;
                        shape2 = inputFieldShape;
                        f2 = fM1732getElevationD9Ej5fM;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        windowInsets3 = windowInsets2;
                        i8 = i15;
                        modifier3 = modifier2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(156000634, i4, i8, "androidx.compose.material3.SearchBar (SearchBar.kt:159)");
                }
                if (z) {
                    f3 = 1.0f;
                } else {
                    f3 = 0.0f;
                }
                if (z) {
                    finiteAnimationSpec = AnimationEnterFloatSpec;
                } else {
                    finiteAnimationSpec = AnimationExitFloatSpec;
                }
                stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f3, finiteAnimationSpec, 0.0f, null, null, composerStartRestartGroup, 64, 28);
                FocusManager focusManager3 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                SearchBarDefaults searchBarDefaults3 = SearchBarDefaults.INSTANCE;
                inputFieldShape2 = searchBarDefaults3.getInputFieldShape(composerStartRestartGroup, 6);
                fullScreenShape = searchBarDefaults3.getFullScreenShape(composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                int i113 = i4;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new SearchBarKt$SearchBar$useFullScreenShape$2$1(stateAnimateFloatAsState));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                state = (State) objRememberedValue2;
                Boolean boolValueOf3 = Boolean.valueOf(SearchBar_Id_Pb_0$lambda$2(state));
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(boolValueOf3) | composerStartRestartGroup.changed(shape2);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    if (AbstractC4492zt.d(shape2, inputFieldShape2)) {
                        objRememberedValue3 = new GenericShape(new SearchBarKt$SearchBar$animatedShape$1$1(density, stateAnimateFloatAsState));
                    } else if (SearchBar_Id_Pb_0$lambda$2(state)) {
                        objRememberedValue3 = fullScreenShape;
                    } else {
                        objRememberedValue3 = shape2;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (AbstractC4492zt.d(shape2, inputFieldShape2)) {
                        objRememberedValue3 = new GenericShape(new SearchBarKt$SearchBar$animatedShape$1$1(density, stateAnimateFloatAsState));
                    } else if (SearchBar_Id_Pb_0$lambda$2(state)) {
                        objRememberedValue3 = fullScreenShape;
                    } else {
                        objRememberedValue3 = shape2;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Shape shape8 = (Shape) objRememberedValue3;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new MutableWindowInsets(null, 1, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableWindowInsets = (MutableWindowInsets) objRememberedValue4;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged2 = composerStartRestartGroup.changed(density);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    objRememberedValue5 = SnapshotStateKt.derivedStateOf(new SearchBarKt$SearchBar$topPadding$1$1(mutableWindowInsets, density));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = SnapshotStateKt.derivedStateOf(new SearchBarKt$SearchBar$topPadding$1$1(mutableWindowInsets, density));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                composerStartRestartGroup.endReplaceableGroup();
                state2 = (State) objRememberedValue5;
                long jM1729getContainerColor0d7_KjU3 = searchBarColors3.m1729getContainerColor0d7_KjU();
                long jM1449contentColorForek8zF_U3 = ColorSchemeKt.m1449contentColorForek8zF_U(searchBarColors3.m1729getContainerColor0d7_KjU(), composerStartRestartGroup, 0);
                Modifier modifierZIndex3 = ZIndexModifierKt.zIndex(modifier3, 1.0f);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged3 = composerStartRestartGroup.changed(mutableWindowInsets) | composerStartRestartGroup.changed(windowInsets3);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChanged3) {
                    objRememberedValue6 = new SearchBarKt$SearchBar$2$1(mutableWindowInsets, windowInsets3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new SearchBarKt$SearchBar$2$1(mutableWindowInsets, windowInsets3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierConsumeWindowInsets3 = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifierZIndex3, (InterfaceC3750qp) objRememberedValue6), mutableWindowInsets);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged4 = composerStartRestartGroup.changed(state2) | composerStartRestartGroup.changed(stateAnimateFloatAsState);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (zChanged4) {
                    objRememberedValue7 = new SearchBarKt$SearchBar$3$1(state2, stateAnimateFloatAsState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new SearchBarKt$SearchBar$3$1(state2, stateAnimateFloatAsState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i114 = i8;
                windowInsets4 = windowInsets3;
                Shape shape9 = shape2;
                Modifier modifier7 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1850SurfaceT9BRK9s(LayoutModifierKt.layout(modifierConsumeWindowInsets3, (InterfaceC0552Gp) objRememberedValue7), shape8, jM1729getContainerColor0d7_KjU3, jM1449contentColorForek8zF_U3, f2, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -867266817, true, new SearchBarKt$SearchBar$4(str, interfaceC3750qp, interfaceC3750qp2, z, interfaceC3750qp3, z4, interfaceC0526Fp9, interfaceC0526Fp7, interfaceC0526Fp8, searchBarColors3, mutableInteractionSource3, i113, i114, stateAnimateFloatAsState, state2, interfaceC0552Gp)), composer2, ((i114 << 6) & 57344) | 12582912, 96);
                int i115 = (i113 >> 9) & 14;
                EffectsKt.LaunchedEffect(Boolean.valueOf(z), new SearchBarKt$SearchBar$5(z, focusManager3, null), composer2, i115 | 64);
                composer2.startReplaceableGroup(1157296644);
                zChanged5 = composer2.changed(interfaceC3750qp3);
                objRememberedValue8 = composer2.rememberedValue();
                if (zChanged5) {
                    objRememberedValue8 = new SearchBarKt$SearchBar$6$1(interfaceC3750qp3);
                    composer2.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new SearchBarKt$SearchBar$6$1(interfaceC3750qp3);
                    composer2.updateRememberedValue(objRememberedValue8);
                }
                composer2.endReplaceableGroup();
                BackHandlerKt.BackHandler(z, (InterfaceC3588op) objRememberedValue8, composer2, i115, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z4;
                interfaceC0526Fp10 = interfaceC0526Fp9;
                interfaceC0526Fp11 = interfaceC0526Fp7;
                interfaceC0526Fp12 = interfaceC0526Fp8;
                searchBarColors4 = searchBarColors3;
                f4 = f2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape3 = shape9;
                modifier4 = modifier7;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SearchBarKt$SearchBar$7(str, interfaceC3750qp, interfaceC3750qp2, z, interfaceC3750qp3, modifier4, z5, interfaceC0526Fp10, interfaceC0526Fp11, interfaceC0526Fp12, shape3, searchBarColors4, f4, windowInsets4, mutableInteractionSource4, interfaceC0552Gp, i, i2, i3));
        }
        i15 |= 384;
        if ((i2 & 7168) != 0) {
            if ((i3 & 8192) == 0) {
                i9 = 2048;
            }
            i15 |= i9;
        }
        i6 = i3 & 16384;
        if (i6 != 0) {
            i15 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 57344) == 0) {
                i15 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
            }
        }
        if ((i3 & 32768) != 0) {
            if ((i2 & 458752) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
            }
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i11 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp5 = null;
                    } else {
                        interfaceC0526Fp5 = interfaceC0526Fp2;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp3;
                    }
                    if ((i3 & 1024) != 0) {
                        inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(composerStartRestartGroup, 6);
                        i15 &= -15;
                    } else {
                        inputFieldShape = shape;
                    }
                    if ((i3 & 2048) != 0) {
                        searchBarColorsM1731colorsKlgxPg = SearchBarDefaults.INSTANCE.m1731colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                        i15 &= -113;
                    } else {
                        searchBarColorsM1731colorsKlgxPg = searchBarColors;
                    }
                    if (i16 != 0) {
                        fM1732getElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m1732getElevationD9Ej5fM();
                    } else {
                        fM1732getElevationD9Ej5fM = f;
                    }
                    searchBarColors2 = searchBarColorsM1731colorsKlgxPg;
                    if ((i3 & 8192) != 0) {
                        windowInsets2 = SearchBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        i15 &= -7169;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        searchBarColors3 = searchBarColors2;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        modifier3 = modifier2;
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                        z4 = z3;
                        shape2 = inputFieldShape;
                        f2 = fM1732getElevationD9Ej5fM;
                        windowInsets3 = windowInsets2;
                        i8 = i15;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        searchBarColors3 = searchBarColors2;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                        z4 = z3;
                        shape2 = inputFieldShape;
                        f2 = fM1732getElevationD9Ej5fM;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        windowInsets3 = windowInsets2;
                        i8 = i15;
                        modifier3 = modifier2;
                    }
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i11 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp5 = null;
                    } else {
                        interfaceC0526Fp5 = interfaceC0526Fp2;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp3;
                    }
                    if ((i3 & 1024) != 0) {
                        inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(composerStartRestartGroup, 6);
                        i15 &= -15;
                    } else {
                        inputFieldShape = shape;
                    }
                    if ((i3 & 2048) != 0) {
                        searchBarColorsM1731colorsKlgxPg = SearchBarDefaults.INSTANCE.m1731colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                        i15 &= -113;
                    } else {
                        searchBarColorsM1731colorsKlgxPg = searchBarColors;
                    }
                    if (i16 != 0) {
                        fM1732getElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m1732getElevationD9Ej5fM();
                    } else {
                        fM1732getElevationD9Ej5fM = f;
                    }
                    searchBarColors2 = searchBarColorsM1731colorsKlgxPg;
                    if ((i3 & 8192) != 0) {
                        windowInsets2 = SearchBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        i15 &= -7169;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        searchBarColors3 = searchBarColors2;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        modifier3 = modifier2;
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                        z4 = z3;
                        shape2 = inputFieldShape;
                        f2 = fM1732getElevationD9Ej5fM;
                        windowInsets3 = windowInsets2;
                        i8 = i15;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        searchBarColors3 = searchBarColors2;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                        z4 = z3;
                        shape2 = inputFieldShape;
                        f2 = fM1732getElevationD9Ej5fM;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        windowInsets3 = windowInsets2;
                        i8 = i15;
                        modifier3 = modifier2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(156000634, i4, i8, "androidx.compose.material3.SearchBar (SearchBar.kt:159)");
                }
                if (z) {
                    f3 = 1.0f;
                } else {
                    f3 = 0.0f;
                }
                if (z) {
                    finiteAnimationSpec = AnimationEnterFloatSpec;
                } else {
                    finiteAnimationSpec = AnimationExitFloatSpec;
                }
                stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f3, finiteAnimationSpec, 0.0f, null, null, composerStartRestartGroup, 64, 28);
                FocusManager focusManager4 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                SearchBarDefaults searchBarDefaults4 = SearchBarDefaults.INSTANCE;
                inputFieldShape2 = searchBarDefaults4.getInputFieldShape(composerStartRestartGroup, 6);
                fullScreenShape = searchBarDefaults4.getFullScreenShape(composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                int i116 = i4;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new SearchBarKt$SearchBar$useFullScreenShape$2$1(stateAnimateFloatAsState));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                state = (State) objRememberedValue2;
                Boolean boolValueOf4 = Boolean.valueOf(SearchBar_Id_Pb_0$lambda$2(state));
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(boolValueOf4) | composerStartRestartGroup.changed(shape2);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    if (AbstractC4492zt.d(shape2, inputFieldShape2)) {
                        objRememberedValue3 = new GenericShape(new SearchBarKt$SearchBar$animatedShape$1$1(density, stateAnimateFloatAsState));
                    } else if (SearchBar_Id_Pb_0$lambda$2(state)) {
                        objRememberedValue3 = fullScreenShape;
                    } else {
                        objRememberedValue3 = shape2;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (AbstractC4492zt.d(shape2, inputFieldShape2)) {
                        objRememberedValue3 = new GenericShape(new SearchBarKt$SearchBar$animatedShape$1$1(density, stateAnimateFloatAsState));
                    } else if (SearchBar_Id_Pb_0$lambda$2(state)) {
                        objRememberedValue3 = fullScreenShape;
                    } else {
                        objRememberedValue3 = shape2;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Shape shape10 = (Shape) objRememberedValue3;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new MutableWindowInsets(null, 1, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableWindowInsets = (MutableWindowInsets) objRememberedValue4;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged2 = composerStartRestartGroup.changed(density);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    objRememberedValue5 = SnapshotStateKt.derivedStateOf(new SearchBarKt$SearchBar$topPadding$1$1(mutableWindowInsets, density));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = SnapshotStateKt.derivedStateOf(new SearchBarKt$SearchBar$topPadding$1$1(mutableWindowInsets, density));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                composerStartRestartGroup.endReplaceableGroup();
                state2 = (State) objRememberedValue5;
                long jM1729getContainerColor0d7_KjU4 = searchBarColors3.m1729getContainerColor0d7_KjU();
                long jM1449contentColorForek8zF_U4 = ColorSchemeKt.m1449contentColorForek8zF_U(searchBarColors3.m1729getContainerColor0d7_KjU(), composerStartRestartGroup, 0);
                Modifier modifierZIndex4 = ZIndexModifierKt.zIndex(modifier3, 1.0f);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged3 = composerStartRestartGroup.changed(mutableWindowInsets) | composerStartRestartGroup.changed(windowInsets3);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChanged3) {
                    objRememberedValue6 = new SearchBarKt$SearchBar$2$1(mutableWindowInsets, windowInsets3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new SearchBarKt$SearchBar$2$1(mutableWindowInsets, windowInsets3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierConsumeWindowInsets4 = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifierZIndex4, (InterfaceC3750qp) objRememberedValue6), mutableWindowInsets);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged4 = composerStartRestartGroup.changed(state2) | composerStartRestartGroup.changed(stateAnimateFloatAsState);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (zChanged4) {
                    objRememberedValue7 = new SearchBarKt$SearchBar$3$1(state2, stateAnimateFloatAsState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new SearchBarKt$SearchBar$3$1(state2, stateAnimateFloatAsState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i117 = i8;
                windowInsets4 = windowInsets3;
                Shape shape11 = shape2;
                Modifier modifier8 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1850SurfaceT9BRK9s(LayoutModifierKt.layout(modifierConsumeWindowInsets4, (InterfaceC0552Gp) objRememberedValue7), shape10, jM1729getContainerColor0d7_KjU4, jM1449contentColorForek8zF_U4, f2, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -867266817, true, new SearchBarKt$SearchBar$4(str, interfaceC3750qp, interfaceC3750qp2, z, interfaceC3750qp3, z4, interfaceC0526Fp9, interfaceC0526Fp7, interfaceC0526Fp8, searchBarColors3, mutableInteractionSource3, i116, i117, stateAnimateFloatAsState, state2, interfaceC0552Gp)), composer2, ((i117 << 6) & 57344) | 12582912, 96);
                int i118 = (i116 >> 9) & 14;
                EffectsKt.LaunchedEffect(Boolean.valueOf(z), new SearchBarKt$SearchBar$5(z, focusManager4, null), composer2, i118 | 64);
                composer2.startReplaceableGroup(1157296644);
                zChanged5 = composer2.changed(interfaceC3750qp3);
                objRememberedValue8 = composer2.rememberedValue();
                if (zChanged5) {
                    objRememberedValue8 = new SearchBarKt$SearchBar$6$1(interfaceC3750qp3);
                    composer2.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new SearchBarKt$SearchBar$6$1(interfaceC3750qp3);
                    composer2.updateRememberedValue(objRememberedValue8);
                }
                composer2.endReplaceableGroup();
                BackHandlerKt.BackHandler(z, (InterfaceC3588op) objRememberedValue8, composer2, i118, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z4;
                interfaceC0526Fp10 = interfaceC0526Fp9;
                interfaceC0526Fp11 = interfaceC0526Fp7;
                interfaceC0526Fp12 = interfaceC0526Fp8;
                searchBarColors4 = searchBarColors3;
                f4 = f2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape3 = shape11;
                modifier4 = modifier8;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i11 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp5 = null;
                    } else {
                        interfaceC0526Fp5 = interfaceC0526Fp2;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp3;
                    }
                    if ((i3 & 1024) != 0) {
                        inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(composerStartRestartGroup, 6);
                        i15 &= -15;
                    } else {
                        inputFieldShape = shape;
                    }
                    if ((i3 & 2048) != 0) {
                        searchBarColorsM1731colorsKlgxPg = SearchBarDefaults.INSTANCE.m1731colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                        i15 &= -113;
                    } else {
                        searchBarColorsM1731colorsKlgxPg = searchBarColors;
                    }
                    if (i16 != 0) {
                        fM1732getElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m1732getElevationD9Ej5fM();
                    } else {
                        fM1732getElevationD9Ej5fM = f;
                    }
                    searchBarColors2 = searchBarColorsM1731colorsKlgxPg;
                    if ((i3 & 8192) != 0) {
                        windowInsets2 = SearchBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        i15 &= -7169;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        searchBarColors3 = searchBarColors2;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        modifier3 = modifier2;
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                        z4 = z3;
                        shape2 = inputFieldShape;
                        f2 = fM1732getElevationD9Ej5fM;
                        windowInsets3 = windowInsets2;
                        i8 = i15;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        searchBarColors3 = searchBarColors2;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                        z4 = z3;
                        shape2 = inputFieldShape;
                        f2 = fM1732getElevationD9Ej5fM;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        windowInsets3 = windowInsets2;
                        i8 = i15;
                        modifier3 = modifier2;
                    }
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i11 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp5 = null;
                    } else {
                        interfaceC0526Fp5 = interfaceC0526Fp2;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp3;
                    }
                    if ((i3 & 1024) != 0) {
                        inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(composerStartRestartGroup, 6);
                        i15 &= -15;
                    } else {
                        inputFieldShape = shape;
                    }
                    if ((i3 & 2048) != 0) {
                        searchBarColorsM1731colorsKlgxPg = SearchBarDefaults.INSTANCE.m1731colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                        i15 &= -113;
                    } else {
                        searchBarColorsM1731colorsKlgxPg = searchBarColors;
                    }
                    if (i16 != 0) {
                        fM1732getElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m1732getElevationD9Ej5fM();
                    } else {
                        fM1732getElevationD9Ej5fM = f;
                    }
                    searchBarColors2 = searchBarColorsM1731colorsKlgxPg;
                    if ((i3 & 8192) != 0) {
                        windowInsets2 = SearchBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        i15 &= -7169;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        searchBarColors3 = searchBarColors2;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        modifier3 = modifier2;
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                        z4 = z3;
                        shape2 = inputFieldShape;
                        f2 = fM1732getElevationD9Ej5fM;
                        windowInsets3 = windowInsets2;
                        i8 = i15;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        searchBarColors3 = searchBarColors2;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                        z4 = z3;
                        shape2 = inputFieldShape;
                        f2 = fM1732getElevationD9Ej5fM;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        windowInsets3 = windowInsets2;
                        i8 = i15;
                        modifier3 = modifier2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(156000634, i4, i8, "androidx.compose.material3.SearchBar (SearchBar.kt:159)");
                }
                if (z) {
                    f3 = 1.0f;
                } else {
                    f3 = 0.0f;
                }
                if (z) {
                    finiteAnimationSpec = AnimationEnterFloatSpec;
                } else {
                    finiteAnimationSpec = AnimationExitFloatSpec;
                }
                stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f3, finiteAnimationSpec, 0.0f, null, null, composerStartRestartGroup, 64, 28);
                FocusManager focusManager5 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                SearchBarDefaults searchBarDefaults5 = SearchBarDefaults.INSTANCE;
                inputFieldShape2 = searchBarDefaults5.getInputFieldShape(composerStartRestartGroup, 6);
                fullScreenShape = searchBarDefaults5.getFullScreenShape(composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                int i119 = i4;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new SearchBarKt$SearchBar$useFullScreenShape$2$1(stateAnimateFloatAsState));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                state = (State) objRememberedValue2;
                Boolean boolValueOf5 = Boolean.valueOf(SearchBar_Id_Pb_0$lambda$2(state));
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(boolValueOf5) | composerStartRestartGroup.changed(shape2);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    if (AbstractC4492zt.d(shape2, inputFieldShape2)) {
                        objRememberedValue3 = new GenericShape(new SearchBarKt$SearchBar$animatedShape$1$1(density, stateAnimateFloatAsState));
                    } else if (SearchBar_Id_Pb_0$lambda$2(state)) {
                        objRememberedValue3 = fullScreenShape;
                    } else {
                        objRememberedValue3 = shape2;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (AbstractC4492zt.d(shape2, inputFieldShape2)) {
                        objRememberedValue3 = new GenericShape(new SearchBarKt$SearchBar$animatedShape$1$1(density, stateAnimateFloatAsState));
                    } else if (SearchBar_Id_Pb_0$lambda$2(state)) {
                        objRememberedValue3 = fullScreenShape;
                    } else {
                        objRememberedValue3 = shape2;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Shape shape12 = (Shape) objRememberedValue3;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new MutableWindowInsets(null, 1, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableWindowInsets = (MutableWindowInsets) objRememberedValue4;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged2 = composerStartRestartGroup.changed(density);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    objRememberedValue5 = SnapshotStateKt.derivedStateOf(new SearchBarKt$SearchBar$topPadding$1$1(mutableWindowInsets, density));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = SnapshotStateKt.derivedStateOf(new SearchBarKt$SearchBar$topPadding$1$1(mutableWindowInsets, density));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                composerStartRestartGroup.endReplaceableGroup();
                state2 = (State) objRememberedValue5;
                long jM1729getContainerColor0d7_KjU5 = searchBarColors3.m1729getContainerColor0d7_KjU();
                long jM1449contentColorForek8zF_U5 = ColorSchemeKt.m1449contentColorForek8zF_U(searchBarColors3.m1729getContainerColor0d7_KjU(), composerStartRestartGroup, 0);
                Modifier modifierZIndex5 = ZIndexModifierKt.zIndex(modifier3, 1.0f);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged3 = composerStartRestartGroup.changed(mutableWindowInsets) | composerStartRestartGroup.changed(windowInsets3);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChanged3) {
                    objRememberedValue6 = new SearchBarKt$SearchBar$2$1(mutableWindowInsets, windowInsets3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new SearchBarKt$SearchBar$2$1(mutableWindowInsets, windowInsets3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierConsumeWindowInsets5 = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifierZIndex5, (InterfaceC3750qp) objRememberedValue6), mutableWindowInsets);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged4 = composerStartRestartGroup.changed(state2) | composerStartRestartGroup.changed(stateAnimateFloatAsState);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (zChanged4) {
                    objRememberedValue7 = new SearchBarKt$SearchBar$3$1(state2, stateAnimateFloatAsState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new SearchBarKt$SearchBar$3$1(state2, stateAnimateFloatAsState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i1110 = i8;
                windowInsets4 = windowInsets3;
                Shape shape13 = shape2;
                Modifier modifier9 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1850SurfaceT9BRK9s(LayoutModifierKt.layout(modifierConsumeWindowInsets5, (InterfaceC0552Gp) objRememberedValue7), shape12, jM1729getContainerColor0d7_KjU5, jM1449contentColorForek8zF_U5, f2, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -867266817, true, new SearchBarKt$SearchBar$4(str, interfaceC3750qp, interfaceC3750qp2, z, interfaceC3750qp3, z4, interfaceC0526Fp9, interfaceC0526Fp7, interfaceC0526Fp8, searchBarColors3, mutableInteractionSource3, i119, i1110, stateAnimateFloatAsState, state2, interfaceC0552Gp)), composer2, ((i1110 << 6) & 57344) | 12582912, 96);
                int i1111 = (i119 >> 9) & 14;
                EffectsKt.LaunchedEffect(Boolean.valueOf(z), new SearchBarKt$SearchBar$5(z, focusManager5, null), composer2, i1111 | 64);
                composer2.startReplaceableGroup(1157296644);
                zChanged5 = composer2.changed(interfaceC3750qp3);
                objRememberedValue8 = composer2.rememberedValue();
                if (zChanged5) {
                    objRememberedValue8 = new SearchBarKt$SearchBar$6$1(interfaceC3750qp3);
                    composer2.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new SearchBarKt$SearchBar$6$1(interfaceC3750qp3);
                    composer2.updateRememberedValue(objRememberedValue8);
                }
                composer2.endReplaceableGroup();
                BackHandlerKt.BackHandler(z, (InterfaceC3588op) objRememberedValue8, composer2, i1111, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z4;
                interfaceC0526Fp10 = interfaceC0526Fp9;
                interfaceC0526Fp11 = interfaceC0526Fp7;
                interfaceC0526Fp12 = interfaceC0526Fp8;
                searchBarColors4 = searchBarColors3;
                f4 = f2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape3 = shape13;
                modifier4 = modifier9;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SearchBarKt$SearchBar$7(str, interfaceC3750qp, interfaceC3750qp2, z, interfaceC3750qp3, modifier4, z5, interfaceC0526Fp10, interfaceC0526Fp11, interfaceC0526Fp12, shape3, searchBarColors4, f4, windowInsets4, mutableInteractionSource4, interfaceC0552Gp, i, i2, i3));
        }
        i7 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i15 |= i7;
        if ((i4 & 1533916891) != 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i11 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i12 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp;
                }
                if (i13 != 0) {
                    interfaceC0526Fp5 = null;
                } else {
                    interfaceC0526Fp5 = interfaceC0526Fp2;
                }
                if (i14 != 0) {
                    interfaceC0526Fp6 = null;
                } else {
                    interfaceC0526Fp6 = interfaceC0526Fp3;
                }
                if ((i3 & 1024) != 0) {
                    inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(composerStartRestartGroup, 6);
                    i15 &= -15;
                } else {
                    inputFieldShape = shape;
                }
                if ((i3 & 2048) != 0) {
                    searchBarColorsM1731colorsKlgxPg = SearchBarDefaults.INSTANCE.m1731colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                    i15 &= -113;
                } else {
                    searchBarColorsM1731colorsKlgxPg = searchBarColors;
                }
                if (i16 != 0) {
                    fM1732getElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m1732getElevationD9Ej5fM();
                } else {
                    fM1732getElevationD9Ej5fM = f;
                }
                searchBarColors2 = searchBarColorsM1731colorsKlgxPg;
                if ((i3 & 8192) != 0) {
                    windowInsets2 = SearchBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    i15 &= -7169;
                } else {
                    windowInsets2 = windowInsets;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    searchBarColors3 = searchBarColors2;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    modifier3 = modifier2;
                    interfaceC0526Fp9 = interfaceC0526Fp4;
                    z4 = z3;
                    shape2 = inputFieldShape;
                    f2 = fM1732getElevationD9Ej5fM;
                    windowInsets3 = windowInsets2;
                    i8 = i15;
                } else {
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    searchBarColors3 = searchBarColors2;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    interfaceC0526Fp9 = interfaceC0526Fp4;
                    z4 = z3;
                    shape2 = inputFieldShape;
                    f2 = fM1732getElevationD9Ej5fM;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    windowInsets3 = windowInsets2;
                    i8 = i15;
                    modifier3 = modifier2;
                }
            } else {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i11 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i12 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp;
                }
                if (i13 != 0) {
                    interfaceC0526Fp5 = null;
                } else {
                    interfaceC0526Fp5 = interfaceC0526Fp2;
                }
                if (i14 != 0) {
                    interfaceC0526Fp6 = null;
                } else {
                    interfaceC0526Fp6 = interfaceC0526Fp3;
                }
                if ((i3 & 1024) != 0) {
                    inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(composerStartRestartGroup, 6);
                    i15 &= -15;
                } else {
                    inputFieldShape = shape;
                }
                if ((i3 & 2048) != 0) {
                    searchBarColorsM1731colorsKlgxPg = SearchBarDefaults.INSTANCE.m1731colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                    i15 &= -113;
                } else {
                    searchBarColorsM1731colorsKlgxPg = searchBarColors;
                }
                if (i16 != 0) {
                    fM1732getElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m1732getElevationD9Ej5fM();
                } else {
                    fM1732getElevationD9Ej5fM = f;
                }
                searchBarColors2 = searchBarColorsM1731colorsKlgxPg;
                if ((i3 & 8192) != 0) {
                    windowInsets2 = SearchBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    i15 &= -7169;
                } else {
                    windowInsets2 = windowInsets;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    searchBarColors3 = searchBarColors2;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    modifier3 = modifier2;
                    interfaceC0526Fp9 = interfaceC0526Fp4;
                    z4 = z3;
                    shape2 = inputFieldShape;
                    f2 = fM1732getElevationD9Ej5fM;
                    windowInsets3 = windowInsets2;
                    i8 = i15;
                } else {
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    searchBarColors3 = searchBarColors2;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    interfaceC0526Fp9 = interfaceC0526Fp4;
                    z4 = z3;
                    shape2 = inputFieldShape;
                    f2 = fM1732getElevationD9Ej5fM;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    windowInsets3 = windowInsets2;
                    i8 = i15;
                    modifier3 = modifier2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(156000634, i4, i8, "androidx.compose.material3.SearchBar (SearchBar.kt:159)");
            }
            if (z) {
                f3 = 1.0f;
            } else {
                f3 = 0.0f;
            }
            if (z) {
                finiteAnimationSpec = AnimationEnterFloatSpec;
            } else {
                finiteAnimationSpec = AnimationExitFloatSpec;
            }
            stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f3, finiteAnimationSpec, 0.0f, null, null, composerStartRestartGroup, 64, 28);
            FocusManager focusManager6 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            SearchBarDefaults searchBarDefaults6 = SearchBarDefaults.INSTANCE;
            inputFieldShape2 = searchBarDefaults6.getInputFieldShape(composerStartRestartGroup, 6);
            fullScreenShape = searchBarDefaults6.getFullScreenShape(composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            companion = Composer.Companion;
            int i1112 = i4;
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new SearchBarKt$SearchBar$useFullScreenShape$2$1(stateAnimateFloatAsState));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            state = (State) objRememberedValue2;
            Boolean boolValueOf6 = Boolean.valueOf(SearchBar_Id_Pb_0$lambda$2(state));
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged = composerStartRestartGroup.changed(boolValueOf6) | composerStartRestartGroup.changed(shape2);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                if (AbstractC4492zt.d(shape2, inputFieldShape2)) {
                    objRememberedValue3 = new GenericShape(new SearchBarKt$SearchBar$animatedShape$1$1(density, stateAnimateFloatAsState));
                } else if (SearchBar_Id_Pb_0$lambda$2(state)) {
                    objRememberedValue3 = fullScreenShape;
                } else {
                    objRememberedValue3 = shape2;
                }
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                if (AbstractC4492zt.d(shape2, inputFieldShape2)) {
                    objRememberedValue3 = new GenericShape(new SearchBarKt$SearchBar$animatedShape$1$1(density, stateAnimateFloatAsState));
                } else if (SearchBar_Id_Pb_0$lambda$2(state)) {
                    objRememberedValue3 = fullScreenShape;
                } else {
                    objRememberedValue3 = shape2;
                }
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Shape shape14 = (Shape) objRememberedValue3;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new MutableWindowInsets(null, 1, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableWindowInsets = (MutableWindowInsets) objRememberedValue4;
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged2 = composerStartRestartGroup.changed(density);
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged2) {
                objRememberedValue5 = SnapshotStateKt.derivedStateOf(new SearchBarKt$SearchBar$topPadding$1$1(mutableWindowInsets, density));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = SnapshotStateKt.derivedStateOf(new SearchBarKt$SearchBar$topPadding$1$1(mutableWindowInsets, density));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            composerStartRestartGroup.endReplaceableGroup();
            state2 = (State) objRememberedValue5;
            long jM1729getContainerColor0d7_KjU6 = searchBarColors3.m1729getContainerColor0d7_KjU();
            long jM1449contentColorForek8zF_U6 = ColorSchemeKt.m1449contentColorForek8zF_U(searchBarColors3.m1729getContainerColor0d7_KjU(), composerStartRestartGroup, 0);
            Modifier modifierZIndex6 = ZIndexModifierKt.zIndex(modifier3, 1.0f);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged3 = composerStartRestartGroup.changed(mutableWindowInsets) | composerStartRestartGroup.changed(windowInsets3);
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChanged3) {
                objRememberedValue6 = new SearchBarKt$SearchBar$2$1(mutableWindowInsets, windowInsets3);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new SearchBarKt$SearchBar$2$1(mutableWindowInsets, windowInsets3);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierConsumeWindowInsets6 = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifierZIndex6, (InterfaceC3750qp) objRememberedValue6), mutableWindowInsets);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged4 = composerStartRestartGroup.changed(state2) | composerStartRestartGroup.changed(stateAnimateFloatAsState);
            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (zChanged4) {
                objRememberedValue7 = new SearchBarKt$SearchBar$3$1(state2, stateAnimateFloatAsState);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            } else {
                objRememberedValue7 = new SearchBarKt$SearchBar$3$1(state2, stateAnimateFloatAsState);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            composerStartRestartGroup.endReplaceableGroup();
            int i1113 = i8;
            windowInsets4 = windowInsets3;
            Shape shape15 = shape2;
            Modifier modifier10 = modifier3;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m1850SurfaceT9BRK9s(LayoutModifierKt.layout(modifierConsumeWindowInsets6, (InterfaceC0552Gp) objRememberedValue7), shape14, jM1729getContainerColor0d7_KjU6, jM1449contentColorForek8zF_U6, f2, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -867266817, true, new SearchBarKt$SearchBar$4(str, interfaceC3750qp, interfaceC3750qp2, z, interfaceC3750qp3, z4, interfaceC0526Fp9, interfaceC0526Fp7, interfaceC0526Fp8, searchBarColors3, mutableInteractionSource3, i1112, i1113, stateAnimateFloatAsState, state2, interfaceC0552Gp)), composer2, ((i1113 << 6) & 57344) | 12582912, 96);
            int i1114 = (i1112 >> 9) & 14;
            EffectsKt.LaunchedEffect(Boolean.valueOf(z), new SearchBarKt$SearchBar$5(z, focusManager6, null), composer2, i1114 | 64);
            composer2.startReplaceableGroup(1157296644);
            zChanged5 = composer2.changed(interfaceC3750qp3);
            objRememberedValue8 = composer2.rememberedValue();
            if (zChanged5) {
                objRememberedValue8 = new SearchBarKt$SearchBar$6$1(interfaceC3750qp3);
                composer2.updateRememberedValue(objRememberedValue8);
            } else {
                objRememberedValue8 = new SearchBarKt$SearchBar$6$1(interfaceC3750qp3);
                composer2.updateRememberedValue(objRememberedValue8);
            }
            composer2.endReplaceableGroup();
            BackHandlerKt.BackHandler(z, (InterfaceC3588op) objRememberedValue8, composer2, i1114, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z5 = z4;
            interfaceC0526Fp10 = interfaceC0526Fp9;
            interfaceC0526Fp11 = interfaceC0526Fp7;
            interfaceC0526Fp12 = interfaceC0526Fp8;
            searchBarColors4 = searchBarColors3;
            f4 = f2;
            mutableInteractionSource4 = mutableInteractionSource3;
            shape3 = shape15;
            modifier4 = modifier10;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i11 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i12 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp;
                }
                if (i13 != 0) {
                    interfaceC0526Fp5 = null;
                } else {
                    interfaceC0526Fp5 = interfaceC0526Fp2;
                }
                if (i14 != 0) {
                    interfaceC0526Fp6 = null;
                } else {
                    interfaceC0526Fp6 = interfaceC0526Fp3;
                }
                if ((i3 & 1024) != 0) {
                    inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(composerStartRestartGroup, 6);
                    i15 &= -15;
                } else {
                    inputFieldShape = shape;
                }
                if ((i3 & 2048) != 0) {
                    searchBarColorsM1731colorsKlgxPg = SearchBarDefaults.INSTANCE.m1731colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                    i15 &= -113;
                } else {
                    searchBarColorsM1731colorsKlgxPg = searchBarColors;
                }
                if (i16 != 0) {
                    fM1732getElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m1732getElevationD9Ej5fM();
                } else {
                    fM1732getElevationD9Ej5fM = f;
                }
                searchBarColors2 = searchBarColorsM1731colorsKlgxPg;
                if ((i3 & 8192) != 0) {
                    windowInsets2 = SearchBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    i15 &= -7169;
                } else {
                    windowInsets2 = windowInsets;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    searchBarColors3 = searchBarColors2;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    modifier3 = modifier2;
                    interfaceC0526Fp9 = interfaceC0526Fp4;
                    z4 = z3;
                    shape2 = inputFieldShape;
                    f2 = fM1732getElevationD9Ej5fM;
                    windowInsets3 = windowInsets2;
                    i8 = i15;
                } else {
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    searchBarColors3 = searchBarColors2;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    interfaceC0526Fp9 = interfaceC0526Fp4;
                    z4 = z3;
                    shape2 = inputFieldShape;
                    f2 = fM1732getElevationD9Ej5fM;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    windowInsets3 = windowInsets2;
                    i8 = i15;
                    modifier3 = modifier2;
                }
            } else {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i11 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i12 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp;
                }
                if (i13 != 0) {
                    interfaceC0526Fp5 = null;
                } else {
                    interfaceC0526Fp5 = interfaceC0526Fp2;
                }
                if (i14 != 0) {
                    interfaceC0526Fp6 = null;
                } else {
                    interfaceC0526Fp6 = interfaceC0526Fp3;
                }
                if ((i3 & 1024) != 0) {
                    inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(composerStartRestartGroup, 6);
                    i15 &= -15;
                } else {
                    inputFieldShape = shape;
                }
                if ((i3 & 2048) != 0) {
                    searchBarColorsM1731colorsKlgxPg = SearchBarDefaults.INSTANCE.m1731colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                    i15 &= -113;
                } else {
                    searchBarColorsM1731colorsKlgxPg = searchBarColors;
                }
                if (i16 != 0) {
                    fM1732getElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m1732getElevationD9Ej5fM();
                } else {
                    fM1732getElevationD9Ej5fM = f;
                }
                searchBarColors2 = searchBarColorsM1731colorsKlgxPg;
                if ((i3 & 8192) != 0) {
                    windowInsets2 = SearchBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    i15 &= -7169;
                } else {
                    windowInsets2 = windowInsets;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    searchBarColors3 = searchBarColors2;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    modifier3 = modifier2;
                    interfaceC0526Fp9 = interfaceC0526Fp4;
                    z4 = z3;
                    shape2 = inputFieldShape;
                    f2 = fM1732getElevationD9Ej5fM;
                    windowInsets3 = windowInsets2;
                    i8 = i15;
                } else {
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    searchBarColors3 = searchBarColors2;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    interfaceC0526Fp9 = interfaceC0526Fp4;
                    z4 = z3;
                    shape2 = inputFieldShape;
                    f2 = fM1732getElevationD9Ej5fM;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    windowInsets3 = windowInsets2;
                    i8 = i15;
                    modifier3 = modifier2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(156000634, i4, i8, "androidx.compose.material3.SearchBar (SearchBar.kt:159)");
            }
            if (z) {
                f3 = 1.0f;
            } else {
                f3 = 0.0f;
            }
            if (z) {
                finiteAnimationSpec = AnimationEnterFloatSpec;
            } else {
                finiteAnimationSpec = AnimationExitFloatSpec;
            }
            stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f3, finiteAnimationSpec, 0.0f, null, null, composerStartRestartGroup, 64, 28);
            FocusManager focusManager7 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            SearchBarDefaults searchBarDefaults7 = SearchBarDefaults.INSTANCE;
            inputFieldShape2 = searchBarDefaults7.getInputFieldShape(composerStartRestartGroup, 6);
            fullScreenShape = searchBarDefaults7.getFullScreenShape(composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            companion = Composer.Companion;
            int i1115 = i4;
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new SearchBarKt$SearchBar$useFullScreenShape$2$1(stateAnimateFloatAsState));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            state = (State) objRememberedValue2;
            Boolean boolValueOf7 = Boolean.valueOf(SearchBar_Id_Pb_0$lambda$2(state));
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged = composerStartRestartGroup.changed(boolValueOf7) | composerStartRestartGroup.changed(shape2);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                if (AbstractC4492zt.d(shape2, inputFieldShape2)) {
                    objRememberedValue3 = new GenericShape(new SearchBarKt$SearchBar$animatedShape$1$1(density, stateAnimateFloatAsState));
                } else if (SearchBar_Id_Pb_0$lambda$2(state)) {
                    objRememberedValue3 = fullScreenShape;
                } else {
                    objRememberedValue3 = shape2;
                }
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                if (AbstractC4492zt.d(shape2, inputFieldShape2)) {
                    objRememberedValue3 = new GenericShape(new SearchBarKt$SearchBar$animatedShape$1$1(density, stateAnimateFloatAsState));
                } else if (SearchBar_Id_Pb_0$lambda$2(state)) {
                    objRememberedValue3 = fullScreenShape;
                } else {
                    objRememberedValue3 = shape2;
                }
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Shape shape16 = (Shape) objRememberedValue3;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new MutableWindowInsets(null, 1, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableWindowInsets = (MutableWindowInsets) objRememberedValue4;
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged2 = composerStartRestartGroup.changed(density);
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged2) {
                objRememberedValue5 = SnapshotStateKt.derivedStateOf(new SearchBarKt$SearchBar$topPadding$1$1(mutableWindowInsets, density));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = SnapshotStateKt.derivedStateOf(new SearchBarKt$SearchBar$topPadding$1$1(mutableWindowInsets, density));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            composerStartRestartGroup.endReplaceableGroup();
            state2 = (State) objRememberedValue5;
            long jM1729getContainerColor0d7_KjU7 = searchBarColors3.m1729getContainerColor0d7_KjU();
            long jM1449contentColorForek8zF_U7 = ColorSchemeKt.m1449contentColorForek8zF_U(searchBarColors3.m1729getContainerColor0d7_KjU(), composerStartRestartGroup, 0);
            Modifier modifierZIndex7 = ZIndexModifierKt.zIndex(modifier3, 1.0f);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged3 = composerStartRestartGroup.changed(mutableWindowInsets) | composerStartRestartGroup.changed(windowInsets3);
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChanged3) {
                objRememberedValue6 = new SearchBarKt$SearchBar$2$1(mutableWindowInsets, windowInsets3);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new SearchBarKt$SearchBar$2$1(mutableWindowInsets, windowInsets3);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierConsumeWindowInsets7 = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifierZIndex7, (InterfaceC3750qp) objRememberedValue6), mutableWindowInsets);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged4 = composerStartRestartGroup.changed(state2) | composerStartRestartGroup.changed(stateAnimateFloatAsState);
            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (zChanged4) {
                objRememberedValue7 = new SearchBarKt$SearchBar$3$1(state2, stateAnimateFloatAsState);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            } else {
                objRememberedValue7 = new SearchBarKt$SearchBar$3$1(state2, stateAnimateFloatAsState);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            composerStartRestartGroup.endReplaceableGroup();
            int i1116 = i8;
            windowInsets4 = windowInsets3;
            Shape shape17 = shape2;
            Modifier modifier11 = modifier3;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m1850SurfaceT9BRK9s(LayoutModifierKt.layout(modifierConsumeWindowInsets7, (InterfaceC0552Gp) objRememberedValue7), shape16, jM1729getContainerColor0d7_KjU7, jM1449contentColorForek8zF_U7, f2, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -867266817, true, new SearchBarKt$SearchBar$4(str, interfaceC3750qp, interfaceC3750qp2, z, interfaceC3750qp3, z4, interfaceC0526Fp9, interfaceC0526Fp7, interfaceC0526Fp8, searchBarColors3, mutableInteractionSource3, i1115, i1116, stateAnimateFloatAsState, state2, interfaceC0552Gp)), composer2, ((i1116 << 6) & 57344) | 12582912, 96);
            int i1117 = (i1115 >> 9) & 14;
            EffectsKt.LaunchedEffect(Boolean.valueOf(z), new SearchBarKt$SearchBar$5(z, focusManager7, null), composer2, i1117 | 64);
            composer2.startReplaceableGroup(1157296644);
            zChanged5 = composer2.changed(interfaceC3750qp3);
            objRememberedValue8 = composer2.rememberedValue();
            if (zChanged5) {
                objRememberedValue8 = new SearchBarKt$SearchBar$6$1(interfaceC3750qp3);
                composer2.updateRememberedValue(objRememberedValue8);
            } else {
                objRememberedValue8 = new SearchBarKt$SearchBar$6$1(interfaceC3750qp3);
                composer2.updateRememberedValue(objRememberedValue8);
            }
            composer2.endReplaceableGroup();
            BackHandlerKt.BackHandler(z, (InterfaceC3588op) objRememberedValue8, composer2, i1117, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z5 = z4;
            interfaceC0526Fp10 = interfaceC0526Fp9;
            interfaceC0526Fp11 = interfaceC0526Fp7;
            interfaceC0526Fp12 = interfaceC0526Fp8;
            searchBarColors4 = searchBarColors3;
            f4 = f2;
            mutableInteractionSource4 = mutableInteractionSource3;
            shape3 = shape17;
            modifier4 = modifier11;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new SearchBarKt$SearchBar$7(str, interfaceC3750qp, interfaceC3750qp2, z, interfaceC3750qp3, modifier4, z5, interfaceC0526Fp10, interfaceC0526Fp11, interfaceC0526Fp12, shape3, searchBarColors4, f4, windowInsets4, mutableInteractionSource4, interfaceC0552Gp, i, i2, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void SearchBarInputField(String str, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, boolean z, InterfaceC3750qp interfaceC3750qp3, Modifier modifier, boolean z2, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, TextFieldColors textFieldColors, MutableInteractionSource mutableInteractionSource, Composer composer, int i, int i2, int i3) {
        int i4;
        TextFieldColors textFieldColorsM1735inputFieldColorsITpI4ow;
        MutableInteractionSource mutableInteractionSource2;
        InterfaceC0526Fp interfaceC0526Fp4;
        InterfaceC0526Fp interfaceC0526Fp5;
        InterfaceC0526Fp interfaceC0526Fp6;
        boolean z3;
        Modifier modifier2;
        Composer composer2;
        boolean z4;
        InterfaceC0526Fp interfaceC0526Fp7;
        InterfaceC0526Fp interfaceC0526Fp8;
        InterfaceC0526Fp interfaceC0526Fp9;
        MutableInteractionSource mutableInteractionSource3;
        TextFieldColors textFieldColors2;
        Modifier modifier3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1330051158);
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = i | (composerStartRestartGroup.changed(str) ? 4 : 2);
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC3750qp) ? 32 : 16;
        }
        int i5 = i4;
        if ((i3 & 4) != 0) {
            i5 |= 384;
        } else if ((i & 896) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(interfaceC3750qp2) ? 256 : 128;
        }
        if ((i3 & 8) != 0) {
            i5 |= 3072;
        } else if ((i & 7168) == 0) {
            i5 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i3 & 16) != 0) {
            i5 |= 24576;
        } else if ((57344 & i) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(interfaceC3750qp3) ? 16384 : 8192;
        }
        int i6 = i3 & 32;
        if (i6 != 0) {
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & 458752) == 0) {
            i5 |= composerStartRestartGroup.changed(modifier) ? 131072 : 65536;
        }
        int i7 = i3 & 64;
        if (i7 != 0) {
            i5 |= 1572864;
        } else if ((i & 3670016) == 0) {
            i5 |= composerStartRestartGroup.changed(z2) ? 1048576 : 524288;
        }
        int i8 = 128 & i3;
        if (i8 != 0) {
            i5 |= 12582912;
        } else if ((i & 29360128) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 8388608 : 4194304;
        }
        int i9 = 256 & i3;
        if (i9 != 0) {
            i5 |= 100663296;
        } else if ((i & 234881024) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp2) ? 67108864 : 33554432;
        }
        int i10 = i3 & 512;
        if (i10 != 0) {
            i5 |= 805306368;
        } else if ((i & 1879048192) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp3) ? PropertyOptions.DELETE_EXISTING : 268435456;
        }
        int i11 = (i2 & 14) == 0 ? i2 | (((i3 & 1024) == 0 && composerStartRestartGroup.changed(textFieldColors)) ? 4 : 2) : i2;
        int i12 = 2048 & i3;
        if (i12 != 0) {
            i11 |= 48;
        } else if ((i2 & 112) == 0) {
            i11 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 32 : 16;
        }
        if ((i5 & 1533916891) == 306783378 && (i11 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier;
            interfaceC0526Fp7 = interfaceC0526Fp;
            interfaceC0526Fp8 = interfaceC0526Fp2;
            interfaceC0526Fp9 = interfaceC0526Fp3;
            textFieldColors2 = textFieldColors;
            mutableInteractionSource3 = mutableInteractionSource;
            composer2 = composerStartRestartGroup;
            z4 = z2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                Modifier modifier4 = i6 != 0 ? Modifier.Companion : modifier;
                boolean z5 = i7 != 0 ? true : z2;
                InterfaceC0526Fp interfaceC0526Fp10 = i8 != 0 ? null : interfaceC0526Fp;
                InterfaceC0526Fp interfaceC0526Fp11 = i9 != 0 ? null : interfaceC0526Fp2;
                InterfaceC0526Fp interfaceC0526Fp12 = i10 != 0 ? null : interfaceC0526Fp3;
                if ((1024 & i3) != 0) {
                    textFieldColorsM1735inputFieldColorsITpI4ow = SearchBarDefaults.INSTANCE.m1735inputFieldColorsITpI4ow(0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 24576, 16383);
                    i11 &= -15;
                } else {
                    textFieldColorsM1735inputFieldColorsITpI4ow = textFieldColors;
                }
                if (i12 != 0) {
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
                interfaceC0526Fp4 = interfaceC0526Fp12;
                interfaceC0526Fp5 = interfaceC0526Fp10;
                interfaceC0526Fp6 = interfaceC0526Fp11;
                z3 = z5;
                modifier2 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((1024 & i3) != 0) {
                    i11 &= -15;
                }
                modifier2 = modifier;
                z3 = z2;
                interfaceC0526Fp5 = interfaceC0526Fp;
                interfaceC0526Fp6 = interfaceC0526Fp2;
                interfaceC0526Fp4 = interfaceC0526Fp3;
                textFieldColorsM1735inputFieldColorsITpI4ow = textFieldColors;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1330051158, i5, i11, "androidx.compose.material3.SearchBarInputField (SearchBar.kt:422)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new FocusRequester();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            FocusRequester focusRequester = (FocusRequester) objRememberedValue2;
            Strings.Companion companion2 = Strings.Companion;
            String strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(companion2.m1822getSearchBarSearchadMyvUU(), composerStartRestartGroup, 6);
            String strM1841getStringNWtq29 = Strings_androidKt.m1841getStringNWtq28(companion2.m1826getSuggestionsAvailableadMyvUU(), composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(462567106);
            long jM4726getColor0d7_KjU = ((TextStyle) composerStartRestartGroup.consume(TextKt.getLocalTextStyle())).m4726getColor0d7_KjU();
            long jM3042unboximpl = jM4726getColor0d7_KjU != Color.Companion.m3068getUnspecified0d7_KjU() ? jM4726getColor0d7_KjU : textFieldColorsM1735inputFieldColorsITpI4ow.textColor$material3_release(z3, false, mutableInteractionSource2, composerStartRestartGroup, ((i11 << 3) & 896) | ((i5 >> 18) & 14) | 48 | ((i11 << 9) & 7168)).getValue().m3042unboximpl();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifier5 = modifier2;
            Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(SizeKt.m518height3ABfNKs(modifier2, SearchBarDefaults.INSTANCE.m1733getInputFieldHeightD9Ej5fM()), 0.0f, 1, null), focusRequester);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed(interfaceC3750qp3);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new SearchBarKt$SearchBarInputField$2$1(interfaceC3750qp3);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierOnFocusChanged = FocusChangedModifierKt.onFocusChanged(modifierFocusRequester, (InterfaceC3750qp) objRememberedValue3);
            Object[] objArr = {strM1841getStringNWtq28, Boolean.valueOf(z), strM1841getStringNWtq29, focusRequester};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            int i13 = 0;
            boolean zChanged2 = false;
            for (int i14 = 4; i13 < i14; i14 = 4) {
                zChanged2 |= composerStartRestartGroup.changed(objArr[i13]);
                i13++;
            }
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                objRememberedValue4 = new SearchBarKt$SearchBarInputField$3$1(strM1841getStringNWtq28, z, strM1841getStringNWtq29, focusRequester);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierOnFocusChanged, false, (InterfaceC3750qp) objRememberedValue4, 1, null);
            TextStyle textStyleMerge = ((TextStyle) composerStartRestartGroup.consume(TextKt.getLocalTextStyle())).merge(new TextStyle(jM3042unboximpl, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 4194302, (AbstractC0419Di) null));
            SolidColor solidColor = new SolidColor(textFieldColorsM1735inputFieldColorsITpI4ow.cursorColor$material3_release(false, composerStartRestartGroup, ((i11 << 3) & 112) | 6).getValue().m3042unboximpl(), null);
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, false, 0, ImeAction.Companion.m4868getSearcheUduSuo(), 7, null);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged3 = composerStartRestartGroup.changed(interfaceC3750qp2) | composerStartRestartGroup.changed(str);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue5 == Composer.Companion.getEmpty()) {
                objRememberedValue5 = new SearchBarKt$SearchBarInputField$4$1(interfaceC3750qp2, str);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            composerStartRestartGroup.endReplaceableGroup();
            int i15 = i11;
            TextFieldColors textFieldColors3 = textFieldColorsM1735inputFieldColorsITpI4ow;
            composer2 = composerStartRestartGroup;
            BasicTextFieldKt.BasicTextField(str, interfaceC3750qp, modifierSemantics$default, z3, false, textStyleMerge, keyboardOptions, new KeyboardActions(null, null, null, null, (InterfaceC3750qp) objRememberedValue5, null, 47, null), true, 0, 0, (VisualTransformation) null, (InterfaceC3750qp) null, mutableInteractionSource2, (Brush) solidColor, (InterfaceC0552Gp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 584727264, true, new AnonymousClass5(str, z3, mutableInteractionSource2, interfaceC0526Fp5, interfaceC0526Fp6, interfaceC0526Fp4, textFieldColorsM1735inputFieldColorsITpI4ow, i5, i15)), composer2, (i5 & 14) | 102236160 | (i5 & 112) | ((i5 >> 9) & 7168), ((i15 << 6) & 7168) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 7696);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z3;
            interfaceC0526Fp7 = interfaceC0526Fp5;
            interfaceC0526Fp8 = interfaceC0526Fp6;
            interfaceC0526Fp9 = interfaceC0526Fp4;
            mutableInteractionSource3 = mutableInteractionSource2;
            textFieldColors2 = textFieldColors3;
            modifier3 = modifier5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass6(str, interfaceC3750qp, interfaceC3750qp2, z, interfaceC3750qp3, modifier3, z4, interfaceC0526Fp7, interfaceC0526Fp8, interfaceC0526Fp9, textFieldColors2, mutableInteractionSource3, i, i2, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SearchBar_Id_Pb_0$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    public static final float getDockedActiveTableMinHeight() {
        return DockedActiveTableMinHeight;
    }

    private static /* synthetic */ void getSearchBarCornerRadius$annotations() {
    }

    public static final float getSearchBarMinWidth() {
        return SearchBarMinWidth;
    }

    public static final float getSearchBarVerticalPadding() {
        return SearchBarVerticalPadding;
    }
}
