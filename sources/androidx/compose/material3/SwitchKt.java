package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteractionKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C1172Zk;
import defpackage.E8;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.O8;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
public final class SwitchKt {
    private static final TweenSpec<Float> AnimationSpec;
    private static final float SwitchHeight;
    private static final float SwitchWidth;
    private static final float ThumbDiameter;
    private static final float ThumbPadding;
    private static final float ThumbPathLength;
    private static final float UncheckedThumbDiameter;

    /* JADX INFO: renamed from: androidx.compose.material3.SwitchKt$Switch$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ float $minBound;
        final /* synthetic */ Animatable<Float, AnimationVector1D> $offset;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Animatable<Float, AnimationVector1D> animatable, float f) {
            super(0);
            this.$offset = animatable;
            this.$minBound = f;
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m1875invoke();
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m1875invoke() {
            Animatable.updateBounds$default(this.$offset, Float.valueOf(this.$minBound), null, 2, null);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SwitchKt$Switch$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ Animatable<Float, AnimationVector1D> $offset;
        final /* synthetic */ InterfaceC2052dg $scope;
        final /* synthetic */ float $targetValue;

        /* JADX INFO: renamed from: androidx.compose.material3.SwitchKt$Switch$3$1, reason: invalid class name */
        @InterfaceC3252ki(c = "androidx.compose.material3.SwitchKt$Switch$3$1", f = "Switch.kt", l = {125}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
            final /* synthetic */ Animatable<Float, AnimationVector1D> $offset;
            final /* synthetic */ float $targetValue;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Animatable<Float, AnimationVector1D> animatable, float f, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$offset = animatable;
                this.$targetValue = f;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                return new AnonymousClass1(this.$offset, this.$targetValue, interfaceC0793Of);
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                return ((AnonymousClass1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objD = AbstractC0378Bt.d();
                int i = this.label;
                if (i == 0) {
                    LL.b(obj);
                    Animatable<Float, AnimationVector1D> animatable = this.$offset;
                    Float fB = E8.b(this.$targetValue);
                    TweenSpec tweenSpec = SwitchKt.AnimationSpec;
                    this.label = 1;
                    if (Animatable.animateTo$default(animatable, fB, tweenSpec, null, null, this, 12, null) == objD) {
                        return objD;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                }
                return FW.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Animatable<Float, AnimationVector1D> animatable, float f, InterfaceC2052dg interfaceC2052dg) {
            super(1);
            this.$offset = animatable;
            this.$targetValue = f;
            this.$scope = interfaceC2052dg;
        }

        @Override // defpackage.InterfaceC3750qp
        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
            AbstractC4492zt.h(disposableEffectScope, "$this$DisposableEffect");
            float fFloatValue = this.$offset.getTargetValue().floatValue();
            float f = this.$targetValue;
            if (fFloatValue != f) {
                O8.d(this.$scope, null, null, new AnonymousClass1(this.$offset, f, null), 3, null);
            }
            return new DisposableEffectResult() { // from class: androidx.compose.material3.SwitchKt$Switch$3$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SwitchKt$Switch$5, reason: invalid class name */
    public static final class AnonymousClass5 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ boolean $checked;
        final /* synthetic */ SwitchColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3750qp $onCheckedChange;
        final /* synthetic */ InterfaceC0526Fp $thumbContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(boolean z, InterfaceC3750qp interfaceC3750qp, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, boolean z2, SwitchColors switchColors, MutableInteractionSource mutableInteractionSource, int i, int i2) {
            super(2);
            this.$checked = z;
            this.$onCheckedChange = interfaceC3750qp;
            this.$modifier = modifier;
            this.$thumbContent = interfaceC0526Fp;
            this.$enabled = z2;
            this.$colors = switchColors;
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
            SwitchKt.Switch(this.$checked, this.$onCheckedChange, this.$modifier, this.$thumbContent, this.$enabled, this.$colors, this.$interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    static {
        SwitchTokens switchTokens = SwitchTokens.INSTANCE;
        float fM2531getSelectedHandleWidthD9Ej5fM = switchTokens.m2531getSelectedHandleWidthD9Ej5fM();
        ThumbDiameter = fM2531getSelectedHandleWidthD9Ej5fM;
        UncheckedThumbDiameter = switchTokens.m2538getUnselectedHandleWidthD9Ej5fM();
        float fM2536getTrackWidthD9Ej5fM = switchTokens.m2536getTrackWidthD9Ej5fM();
        SwitchWidth = fM2536getTrackWidthD9Ej5fM;
        float fM2534getTrackHeightD9Ej5fM = switchTokens.m2534getTrackHeightD9Ej5fM();
        SwitchHeight = fM2534getTrackHeightD9Ej5fM;
        float fM5160constructorimpl = Dp.m5160constructorimpl(Dp.m5160constructorimpl(fM2534getTrackHeightD9Ej5fM - fM2531getSelectedHandleWidthD9Ej5fM) / 2);
        ThumbPadding = fM5160constructorimpl;
        ThumbPathLength = Dp.m5160constructorimpl(Dp.m5160constructorimpl(fM2536getTrackWidthD9Ej5fM - fM2531getSelectedHandleWidthD9Ej5fM) - fM5160constructorimpl);
        AnimationSpec = new TweenSpec<>(100, 0, null, 6, null);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0125  */
    /* JADX WARN: Code duplicated, block: B:101:0x0129  */
    /* JADX WARN: Code duplicated, block: B:104:0x012f  */
    /* JADX WARN: Code duplicated, block: B:105:0x0164  */
    /* JADX WARN: Code duplicated, block: B:107:0x016a  */
    /* JADX WARN: Code duplicated, block: B:109:0x0179  */
    /* JADX WARN: Code duplicated, block: B:112:0x018e  */
    /* JADX WARN: Code duplicated, block: B:115:0x019f  */
    /* JADX WARN: Code duplicated, block: B:117:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:119:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:122:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:124:0x0201  */
    /* JADX WARN: Code duplicated, block: B:127:0x022b  */
    /* JADX WARN: Code duplicated, block: B:128:0x0236  */
    /* JADX WARN: Code duplicated, block: B:131:0x0250  */
    /* JADX WARN: Code duplicated, block: B:134:0x0284  */
    /* JADX WARN: Code duplicated, block: B:135:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:137:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:138:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:141:0x0312  */
    /* JADX WARN: Code duplicated, block: B:144:0x031e  */
    /* JADX WARN: Code duplicated, block: B:145:0x0322  */
    /* JADX WARN: Code duplicated, block: B:148:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:153:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:155:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x005e  */
    /* JADX WARN: Code duplicated, block: B:38:0x0063  */
    /* JADX WARN: Code duplicated, block: B:40:0x0067  */
    /* JADX WARN: Code duplicated, block: B:42:0x006f  */
    /* JADX WARN: Code duplicated, block: B:43:0x0072  */
    /* JADX WARN: Code duplicated, block: B:47:0x0079  */
    /* JADX WARN: Code duplicated, block: B:49:0x007e  */
    /* JADX WARN: Code duplicated, block: B:51:0x0084  */
    /* JADX WARN: Code duplicated, block: B:53:0x008c  */
    /* JADX WARN: Code duplicated, block: B:54:0x008f  */
    /* JADX WARN: Code duplicated, block: B:58:0x0098  */
    /* JADX WARN: Code duplicated, block: B:60:0x009c  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:63:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:71:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:73:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:75:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:76:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:80:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:93:0x0117 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:94:0x0119  */
    /* JADX WARN: Code duplicated, block: B:95:0x011c  */
    /* JADX WARN: Code duplicated, block: B:97:0x0120  */
    /* JADX WARN: Code duplicated, block: B:98:0x0122  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void Switch(boolean z, InterfaceC3750qp interfaceC3750qp, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, boolean z2, SwitchColors switchColors, MutableInteractionSource mutableInteractionSource, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        InterfaceC0526Fp interfaceC0526Fp2;
        int i5;
        int i6;
        boolean z3;
        int i7;
        SwitchColors switchColors2;
        int i8;
        MutableInteractionSource mutableInteractionSource2;
        int i9;
        Modifier modifier3;
        InterfaceC0526Fp interfaceC0526Fp3;
        boolean z4;
        int i10;
        SwitchColors switchColorsM1871colorsV1nXRL4;
        MutableInteractionSource mutableInteractionSource3;
        int i11;
        Object objRememberedValue;
        float f;
        float fMo333toPx0680j_4;
        float fMo333toPx0680j_5;
        boolean zChanged;
        Object objRememberedValue2;
        float fFloatValue;
        Object objRememberedValue3;
        Composer.Companion companion;
        Object obj;
        Object objRememberedValue4;
        Modifier modifierM711toggleableO2vRcR0;
        Modifier modifierMinimumInteractiveComponentSize;
        Composer composer2;
        InterfaceC3588op constructor;
        Modifier modifier4;
        SwitchColors switchColors3;
        boolean z5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1580463220);
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
            i3 |= composerStartRestartGroup.changedInstance(interfaceC3750qp) ? 32 : 16;
        }
        int i12 = i2 & 4;
        if (i12 == 0) {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    interfaceC0526Fp2 = interfaceC0526Fp;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((57344 & i) == 0) {
                        z3 = z2;
                        if (composerStartRestartGroup.changed(z3)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    if ((i & 458752) == 0) {
                        if ((i2 & 32) == 0) {
                            switchColors2 = switchColors;
                            int i13 = composerStartRestartGroup.changed(switchColors2) ? 131072 : 65536;
                            i3 |= i13;
                        } else {
                            switchColors2 = switchColors;
                        }
                        i3 |= i13;
                    } else {
                        switchColors2 = switchColors;
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                        if ((i & 3670016) == 0) {
                            mutableInteractionSource2 = mutableInteractionSource;
                            if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                                i9 = 1048576;
                            } else {
                                i9 = 524288;
                            }
                            i3 |= i9;
                        }
                        if ((2995931 & i3) == 599186 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i12 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier;
                                }
                                if (i4 != 0) {
                                    interfaceC0526Fp3 = null;
                                } else {
                                    interfaceC0526Fp3 = interfaceC0526Fp2;
                                }
                                if (i6 != 0) {
                                    z4 = true;
                                } else {
                                    z4 = z3;
                                }
                                if ((i2 & 32) != 0) {
                                    i10 = -492369756;
                                    switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                                    i3 &= -458753;
                                } else {
                                    i10 = -492369756;
                                    switchColorsM1871colorsV1nXRL4 = switchColors2;
                                }
                                if (i8 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(i10);
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
                                i11 = i3;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                modifier3 = modifier;
                                i11 = i3;
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                                z4 = z3;
                                switchColorsM1871colorsV1nXRL4 = switchColors2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                i10 = -492369756;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                            }
                            if (interfaceC0526Fp3 == null) {
                                f = UncheckedThumbDiameter;
                            } else {
                                f = ThumbDiameter;
                            }
                            float f2 = f;
                            float f3 = SwitchHeight;
                            float fM5160constructorimpl = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f3 - f2) / 2);
                            fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl);
                            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                            float f4 = ThumbPathLength;
                            fMo333toPx0680j_5 = density.mo333toPx0680j_4(f4);
                            Float fValueOf = Float.valueOf(fMo333toPx0680j_4);
                            Float fValueOf2 = Float.valueOf(fMo333toPx0680j_5);
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(fValueOf) | composerStartRestartGroup.changed(fValueOf2);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                            composerStartRestartGroup.startReplaceableGroup(i10);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            companion = Composer.Companion;
                            if (objRememberedValue3 == companion.getEmpty()) {
                                obj = null;
                                objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                obj = null;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Animatable animatable = (Animatable) objRememberedValue3;
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            composerStartRestartGroup.startReplaceableGroup(i10);
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == companion.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                objRememberedValue4 = compositionScopedCoroutineScopeCanceller;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            InterfaceC2052dg coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            EffectsKt.SideEffect(new AnonymousClass2(animatable, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                            EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable, fFloatValue, coroutineScope), composerStartRestartGroup, i11 & 14);
                            if (interfaceC3750qp != null) {
                                modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                            } else {
                                modifierM711toggleableO2vRcR0 = Modifier.Companion;
                            }
                            if (interfaceC3750qp != null) {
                                modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                            } else {
                                modifierMinimumInteractiveComponentSize = Modifier.Companion;
                            }
                            Modifier modifierThen = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                            Alignment.Companion companion2 = Alignment.Companion;
                            Modifier modifierM526requiredSizeVpY3zN4 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen, companion2.getCenter(), false, 2, obj), SwitchWidth, f3);
                            composer2 = composerStartRestartGroup;
                            composer2.startReplaceableGroup(733328855);
                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer2, 0);
                            composer2.startReplaceableGroup(-1323940314);
                            Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
                            constructor = companion3.getConstructor();
                            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN4);
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
                            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                            Updater.m2668setimpl(composerM2661constructorimpl, density2, companion3.getSetDensity());
                            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion3.getSetLayoutDirection());
                            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion3.getSetViewConfiguration());
                            composer2.enableReusing();
                            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            int i14 = i11 >> 6;
                            Modifier modifier5 = modifier3;
                            m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f2, fM5160constructorimpl, f4, composer2, ((i11 << 3) & 112) | 6 | (i14 & 896) | (i14 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier5;
                            switchColors3 = switchColorsM1871colorsV1nXRL4;
                            z5 = z4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            composer2 = composerStartRestartGroup;
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                            z5 = z3;
                            switchColors3 = switchColors2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(z, interfaceC3750qp, modifier4, interfaceC0526Fp3, z5, switchColors3, mutableInteractionSource3, i, i2));
                    }
                    i3 |= 1572864;
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((2995931 & i3) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z3;
                            }
                            if ((i2 & 32) != 0) {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                                i3 &= -458753;
                            } else {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = switchColors2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(i10);
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
                            i11 = i3;
                        } else {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z3;
                            }
                            if ((i2 & 32) != 0) {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                                i3 &= -458753;
                            } else {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = switchColors2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(i10);
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
                            i11 = i3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                        }
                        if (interfaceC0526Fp3 == null) {
                            f = UncheckedThumbDiameter;
                        } else {
                            f = ThumbDiameter;
                        }
                        float f5 = f;
                        float f6 = SwitchHeight;
                        float fM5160constructorimpl2 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f6 - f5) / 2);
                        fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl2);
                        Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        float f7 = ThumbPathLength;
                        fMo333toPx0680j_5 = density3.mo333toPx0680j_4(f7);
                        Float fValueOf3 = Float.valueOf(fMo333toPx0680j_4);
                        Float fValueOf4 = Float.valueOf(fMo333toPx0680j_5);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(fValueOf3) | composerStartRestartGroup.changed(fValueOf4);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                        composerStartRestartGroup.startReplaceableGroup(i10);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue3 == companion.getEmpty()) {
                            obj = null;
                            objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            obj = null;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Animatable animatable2 = (Animatable) objRememberedValue3;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(i10);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller2 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller2);
                            objRememberedValue4 = compositionScopedCoroutineScopeCanceller2;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect(new AnonymousClass2(animatable2, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                        EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable2, fFloatValue, coroutineScope2), composerStartRestartGroup, i11 & 14);
                        if (interfaceC3750qp != null) {
                            modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                        } else {
                            modifierM711toggleableO2vRcR0 = Modifier.Companion;
                        }
                        if (interfaceC3750qp != null) {
                            modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                        } else {
                            modifierMinimumInteractiveComponentSize = Modifier.Companion;
                        }
                        Modifier modifierThen2 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                        Alignment.Companion companion4 = Alignment.Companion;
                        Modifier modifierM526requiredSizeVpY3zN5 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen2, companion4.getCenter(), false, 2, obj), SwitchWidth, f6);
                        composer2 = composerStartRestartGroup;
                        composer2.startReplaceableGroup(733328855);
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion4.getTopStart(), false, composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        Density density4 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion5 = ComposeUiNode.Companion;
                        constructor = companion5.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN5);
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
                        Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy2, companion5.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl2, density4, companion5.getSetDensity());
                        Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion5.getSetLayoutDirection());
                        Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion5.getSetViewConfiguration());
                        composer2.enableReusing();
                        interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        int i15 = i11 >> 6;
                        Modifier modifier6 = modifier3;
                        m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable2.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f5, fM5160constructorimpl2, f7, composer2, ((i11 << 3) & 112) | 6 | (i15 & 896) | (i15 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier6;
                        switchColors3 = switchColorsM1871colorsV1nXRL4;
                        z5 = z4;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z3;
                            }
                            if ((i2 & 32) != 0) {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                                i3 &= -458753;
                            } else {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = switchColors2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(i10);
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
                            i11 = i3;
                        } else {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z3;
                            }
                            if ((i2 & 32) != 0) {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                                i3 &= -458753;
                            } else {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = switchColors2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(i10);
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
                            i11 = i3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                        }
                        if (interfaceC0526Fp3 == null) {
                            f = UncheckedThumbDiameter;
                        } else {
                            f = ThumbDiameter;
                        }
                        float f8 = f;
                        float f9 = SwitchHeight;
                        float fM5160constructorimpl3 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f9 - f8) / 2);
                        fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl3);
                        Density density5 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        float f10 = ThumbPathLength;
                        fMo333toPx0680j_5 = density5.mo333toPx0680j_4(f10);
                        Float fValueOf5 = Float.valueOf(fMo333toPx0680j_4);
                        Float fValueOf6 = Float.valueOf(fMo333toPx0680j_5);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(fValueOf5) | composerStartRestartGroup.changed(fValueOf6);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                        composerStartRestartGroup.startReplaceableGroup(i10);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue3 == companion.getEmpty()) {
                            obj = null;
                            objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            obj = null;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Animatable animatable3 = (Animatable) objRememberedValue3;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(i10);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller3 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller3);
                            objRememberedValue4 = compositionScopedCoroutineScopeCanceller3;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope3 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect(new AnonymousClass2(animatable3, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                        EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable3, fFloatValue, coroutineScope3), composerStartRestartGroup, i11 & 14);
                        if (interfaceC3750qp != null) {
                            modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                        } else {
                            modifierM711toggleableO2vRcR0 = Modifier.Companion;
                        }
                        if (interfaceC3750qp != null) {
                            modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                        } else {
                            modifierMinimumInteractiveComponentSize = Modifier.Companion;
                        }
                        Modifier modifierThen3 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                        Alignment.Companion companion6 = Alignment.Companion;
                        Modifier modifierM526requiredSizeVpY3zN6 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen3, companion6.getCenter(), false, 2, obj), SwitchWidth, f9);
                        composer2 = composerStartRestartGroup;
                        composer2.startReplaceableGroup(733328855);
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(companion6.getTopStart(), false, composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        Density density6 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection3 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion7 = ComposeUiNode.Companion;
                        constructor = companion7.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpMaterializerOf3 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN6);
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
                        Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyRememberBoxMeasurePolicy3, companion7.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl3, density6, companion7.getSetDensity());
                        Updater.m2668setimpl(composerM2661constructorimpl3, layoutDirection3, companion7.getSetLayoutDirection());
                        Updater.m2668setimpl(composerM2661constructorimpl3, viewConfiguration3, companion7.getSetViewConfiguration());
                        composer2.enableReusing();
                        interfaceC0552GpMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        int i16 = i11 >> 6;
                        Modifier modifier7 = modifier3;
                        m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable3.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f8, fM5160constructorimpl3, f10, composer2, ((i11 << 3) & 112) | 6 | (i16 & 896) | (i16 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier7;
                        switchColors3 = switchColorsM1871colorsV1nXRL4;
                        z5 = z4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(z, interfaceC3750qp, modifier4, interfaceC0526Fp3, z5, switchColors3, mutableInteractionSource3, i, i2));
                }
                i3 |= 24576;
                z3 = z2;
                if ((i & 458752) == 0) {
                    if ((i2 & 32) == 0) {
                        switchColors2 = switchColors;
                        if (composerStartRestartGroup.changed(switchColors2)) {
                        }
                        i3 |= i13;
                    } else {
                        switchColors2 = switchColors;
                    }
                    i3 |= i13;
                } else {
                    switchColors2 = switchColors;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((i & 3670016) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((2995931 & i3) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z3;
                            }
                            if ((i2 & 32) != 0) {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                                i3 &= -458753;
                            } else {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = switchColors2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(i10);
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
                            i11 = i3;
                        } else {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z3;
                            }
                            if ((i2 & 32) != 0) {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                                i3 &= -458753;
                            } else {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = switchColors2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(i10);
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
                            i11 = i3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                        }
                        if (interfaceC0526Fp3 == null) {
                            f = UncheckedThumbDiameter;
                        } else {
                            f = ThumbDiameter;
                        }
                        float f11 = f;
                        float f12 = SwitchHeight;
                        float fM5160constructorimpl4 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f12 - f11) / 2);
                        fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl4);
                        Density density7 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        float f13 = ThumbPathLength;
                        fMo333toPx0680j_5 = density7.mo333toPx0680j_4(f13);
                        Float fValueOf7 = Float.valueOf(fMo333toPx0680j_4);
                        Float fValueOf8 = Float.valueOf(fMo333toPx0680j_5);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(fValueOf7) | composerStartRestartGroup.changed(fValueOf8);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                        composerStartRestartGroup.startReplaceableGroup(i10);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue3 == companion.getEmpty()) {
                            obj = null;
                            objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            obj = null;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Animatable animatable4 = (Animatable) objRememberedValue3;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(i10);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller4 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller4);
                            objRememberedValue4 = compositionScopedCoroutineScopeCanceller4;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope4 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect(new AnonymousClass2(animatable4, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                        EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable4, fFloatValue, coroutineScope4), composerStartRestartGroup, i11 & 14);
                        if (interfaceC3750qp != null) {
                            modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                        } else {
                            modifierM711toggleableO2vRcR0 = Modifier.Companion;
                        }
                        if (interfaceC3750qp != null) {
                            modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                        } else {
                            modifierMinimumInteractiveComponentSize = Modifier.Companion;
                        }
                        Modifier modifierThen4 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                        Alignment.Companion companion8 = Alignment.Companion;
                        Modifier modifierM526requiredSizeVpY3zN7 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen4, companion8.getCenter(), false, 2, obj), SwitchWidth, f12);
                        composer2 = composerStartRestartGroup;
                        composer2.startReplaceableGroup(733328855);
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(companion8.getTopStart(), false, composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        Density density8 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection4 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration4 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion9 = ComposeUiNode.Companion;
                        constructor = companion9.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpMaterializerOf4 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN7);
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
                        Composer composerM2661constructorimpl4 = Updater.m2661constructorimpl(composer2);
                        Updater.m2668setimpl(composerM2661constructorimpl4, measurePolicyRememberBoxMeasurePolicy4, companion9.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl4, density8, companion9.getSetDensity());
                        Updater.m2668setimpl(composerM2661constructorimpl4, layoutDirection4, companion9.getSetLayoutDirection());
                        Updater.m2668setimpl(composerM2661constructorimpl4, viewConfiguration4, companion9.getSetViewConfiguration());
                        composer2.enableReusing();
                        interfaceC0552GpMaterializerOf4.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        int i17 = i11 >> 6;
                        Modifier modifier8 = modifier3;
                        m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable4.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f11, fM5160constructorimpl4, f13, composer2, ((i11 << 3) & 112) | 6 | (i17 & 896) | (i17 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier8;
                        switchColors3 = switchColorsM1871colorsV1nXRL4;
                        z5 = z4;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z3;
                            }
                            if ((i2 & 32) != 0) {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                                i3 &= -458753;
                            } else {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = switchColors2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(i10);
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
                            i11 = i3;
                        } else {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z3;
                            }
                            if ((i2 & 32) != 0) {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                                i3 &= -458753;
                            } else {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = switchColors2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(i10);
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
                            i11 = i3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                        }
                        if (interfaceC0526Fp3 == null) {
                            f = UncheckedThumbDiameter;
                        } else {
                            f = ThumbDiameter;
                        }
                        float f14 = f;
                        float f15 = SwitchHeight;
                        float fM5160constructorimpl5 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f15 - f14) / 2);
                        fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl5);
                        Density density9 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        float f16 = ThumbPathLength;
                        fMo333toPx0680j_5 = density9.mo333toPx0680j_4(f16);
                        Float fValueOf9 = Float.valueOf(fMo333toPx0680j_4);
                        Float fValueOf10 = Float.valueOf(fMo333toPx0680j_5);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(fValueOf9) | composerStartRestartGroup.changed(fValueOf10);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                        composerStartRestartGroup.startReplaceableGroup(i10);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue3 == companion.getEmpty()) {
                            obj = null;
                            objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            obj = null;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Animatable animatable5 = (Animatable) objRememberedValue3;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(i10);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller5 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller5);
                            objRememberedValue4 = compositionScopedCoroutineScopeCanceller5;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope5 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect(new AnonymousClass2(animatable5, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                        EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable5, fFloatValue, coroutineScope5), composerStartRestartGroup, i11 & 14);
                        if (interfaceC3750qp != null) {
                            modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                        } else {
                            modifierM711toggleableO2vRcR0 = Modifier.Companion;
                        }
                        if (interfaceC3750qp != null) {
                            modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                        } else {
                            modifierMinimumInteractiveComponentSize = Modifier.Companion;
                        }
                        Modifier modifierThen5 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                        Alignment.Companion companion10 = Alignment.Companion;
                        Modifier modifierM526requiredSizeVpY3zN8 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen5, companion10.getCenter(), false, 2, obj), SwitchWidth, f15);
                        composer2 = composerStartRestartGroup;
                        composer2.startReplaceableGroup(733328855);
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy5 = BoxKt.rememberBoxMeasurePolicy(companion10.getTopStart(), false, composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        Density density10 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection5 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration5 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion11 = ComposeUiNode.Companion;
                        constructor = companion11.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpMaterializerOf5 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN8);
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
                        Composer composerM2661constructorimpl5 = Updater.m2661constructorimpl(composer2);
                        Updater.m2668setimpl(composerM2661constructorimpl5, measurePolicyRememberBoxMeasurePolicy5, companion11.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl5, density10, companion11.getSetDensity());
                        Updater.m2668setimpl(composerM2661constructorimpl5, layoutDirection5, companion11.getSetLayoutDirection());
                        Updater.m2668setimpl(composerM2661constructorimpl5, viewConfiguration5, companion11.getSetViewConfiguration());
                        composer2.enableReusing();
                        interfaceC0552GpMaterializerOf5.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        int i18 = i11 >> 6;
                        Modifier modifier9 = modifier3;
                        m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable5.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f14, fM5160constructorimpl5, f16, composer2, ((i11 << 3) & 112) | 6 | (i18 & 896) | (i18 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier9;
                        switchColors3 = switchColorsM1871colorsV1nXRL4;
                        z5 = z4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(z, interfaceC3750qp, modifier4, interfaceC0526Fp3, z5, switchColors3, mutableInteractionSource3, i, i2));
                }
                i3 |= 1572864;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((2995931 & i3) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if ((i2 & 32) != 0) {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                            i3 &= -458753;
                        } else {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = switchColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(i10);
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
                        i11 = i3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if ((i2 & 32) != 0) {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                            i3 &= -458753;
                        } else {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = switchColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(i10);
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
                        i11 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                    }
                    if (interfaceC0526Fp3 == null) {
                        f = UncheckedThumbDiameter;
                    } else {
                        f = ThumbDiameter;
                    }
                    float f17 = f;
                    float f18 = SwitchHeight;
                    float fM5160constructorimpl6 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f18 - f17) / 2);
                    fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl6);
                    Density density11 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    float f19 = ThumbPathLength;
                    fMo333toPx0680j_5 = density11.mo333toPx0680j_4(f19);
                    Float fValueOf11 = Float.valueOf(fMo333toPx0680j_4);
                    Float fValueOf12 = Float.valueOf(fMo333toPx0680j_5);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(fValueOf11) | composerStartRestartGroup.changed(fValueOf12);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                    composerStartRestartGroup.startReplaceableGroup(i10);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue3 == companion.getEmpty()) {
                        obj = null;
                        objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        obj = null;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Animatable animatable6 = (Animatable) objRememberedValue3;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(i10);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller6 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller6);
                        objRememberedValue4 = compositionScopedCoroutineScopeCanceller6;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope6 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect(new AnonymousClass2(animatable6, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                    EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable6, fFloatValue, coroutineScope6), composerStartRestartGroup, i11 & 14);
                    if (interfaceC3750qp != null) {
                        modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                    } else {
                        modifierM711toggleableO2vRcR0 = Modifier.Companion;
                    }
                    if (interfaceC3750qp != null) {
                        modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                    } else {
                        modifierMinimumInteractiveComponentSize = Modifier.Companion;
                    }
                    Modifier modifierThen6 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                    Alignment.Companion companion12 = Alignment.Companion;
                    Modifier modifierM526requiredSizeVpY3zN9 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen6, companion12.getCenter(), false, 2, obj), SwitchWidth, f18);
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy6 = BoxKt.rememberBoxMeasurePolicy(companion12.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    Density density12 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection6 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration6 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion13 = ComposeUiNode.Companion;
                    constructor = companion13.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf6 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN9);
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
                    Composer composerM2661constructorimpl6 = Updater.m2661constructorimpl(composer2);
                    Updater.m2668setimpl(composerM2661constructorimpl6, measurePolicyRememberBoxMeasurePolicy6, companion13.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl6, density12, companion13.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl6, layoutDirection6, companion13.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl6, viewConfiguration6, companion13.getSetViewConfiguration());
                    composer2.enableReusing();
                    interfaceC0552GpMaterializerOf6.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    int i19 = i11 >> 6;
                    Modifier modifier10 = modifier3;
                    m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable6.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f17, fM5160constructorimpl6, f19, composer2, ((i11 << 3) & 112) | 6 | (i19 & 896) | (i19 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier10;
                    switchColors3 = switchColorsM1871colorsV1nXRL4;
                    z5 = z4;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if ((i2 & 32) != 0) {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                            i3 &= -458753;
                        } else {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = switchColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(i10);
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
                        i11 = i3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if ((i2 & 32) != 0) {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                            i3 &= -458753;
                        } else {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = switchColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(i10);
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
                        i11 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                    }
                    if (interfaceC0526Fp3 == null) {
                        f = UncheckedThumbDiameter;
                    } else {
                        f = ThumbDiameter;
                    }
                    float f110 = f;
                    float f111 = SwitchHeight;
                    float fM5160constructorimpl7 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f111 - f110) / 2);
                    fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl7);
                    Density density13 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    float f112 = ThumbPathLength;
                    fMo333toPx0680j_5 = density13.mo333toPx0680j_4(f112);
                    Float fValueOf13 = Float.valueOf(fMo333toPx0680j_4);
                    Float fValueOf14 = Float.valueOf(fMo333toPx0680j_5);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(fValueOf13) | composerStartRestartGroup.changed(fValueOf14);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                    composerStartRestartGroup.startReplaceableGroup(i10);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue3 == companion.getEmpty()) {
                        obj = null;
                        objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        obj = null;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Animatable animatable7 = (Animatable) objRememberedValue3;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(i10);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller7 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller7);
                        objRememberedValue4 = compositionScopedCoroutineScopeCanceller7;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope7 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect(new AnonymousClass2(animatable7, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                    EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable7, fFloatValue, coroutineScope7), composerStartRestartGroup, i11 & 14);
                    if (interfaceC3750qp != null) {
                        modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                    } else {
                        modifierM711toggleableO2vRcR0 = Modifier.Companion;
                    }
                    if (interfaceC3750qp != null) {
                        modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                    } else {
                        modifierMinimumInteractiveComponentSize = Modifier.Companion;
                    }
                    Modifier modifierThen7 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                    Alignment.Companion companion14 = Alignment.Companion;
                    Modifier modifierM526requiredSizeVpY3zN10 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen7, companion14.getCenter(), false, 2, obj), SwitchWidth, f111);
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy7 = BoxKt.rememberBoxMeasurePolicy(companion14.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    Density density14 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection7 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration7 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion15 = ComposeUiNode.Companion;
                    constructor = companion15.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf7 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN10);
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
                    Composer composerM2661constructorimpl7 = Updater.m2661constructorimpl(composer2);
                    Updater.m2668setimpl(composerM2661constructorimpl7, measurePolicyRememberBoxMeasurePolicy7, companion15.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl7, density14, companion15.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl7, layoutDirection7, companion15.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl7, viewConfiguration7, companion15.getSetViewConfiguration());
                    composer2.enableReusing();
                    interfaceC0552GpMaterializerOf7.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    int i110 = i11 >> 6;
                    Modifier modifier11 = modifier3;
                    m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable7.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f110, fM5160constructorimpl7, f112, composer2, ((i11 << 3) & 112) | 6 | (i110 & 896) | (i110 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier11;
                    switchColors3 = switchColorsM1871colorsV1nXRL4;
                    z5 = z4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(z, interfaceC3750qp, modifier4, interfaceC0526Fp3, z5, switchColors3, mutableInteractionSource3, i, i2));
            }
            i3 |= 3072;
            interfaceC0526Fp2 = interfaceC0526Fp;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((57344 & i) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((i & 458752) == 0) {
                    if ((i2 & 32) == 0) {
                        switchColors2 = switchColors;
                        if (composerStartRestartGroup.changed(switchColors2)) {
                        }
                        i3 |= i13;
                    } else {
                        switchColors2 = switchColors;
                    }
                    i3 |= i13;
                } else {
                    switchColors2 = switchColors;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((i & 3670016) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((2995931 & i3) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z3;
                            }
                            if ((i2 & 32) != 0) {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                                i3 &= -458753;
                            } else {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = switchColors2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(i10);
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
                            i11 = i3;
                        } else {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z3;
                            }
                            if ((i2 & 32) != 0) {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                                i3 &= -458753;
                            } else {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = switchColors2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(i10);
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
                            i11 = i3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                        }
                        if (interfaceC0526Fp3 == null) {
                            f = UncheckedThumbDiameter;
                        } else {
                            f = ThumbDiameter;
                        }
                        float f113 = f;
                        float f114 = SwitchHeight;
                        float fM5160constructorimpl8 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f114 - f113) / 2);
                        fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl8);
                        Density density15 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        float f115 = ThumbPathLength;
                        fMo333toPx0680j_5 = density15.mo333toPx0680j_4(f115);
                        Float fValueOf15 = Float.valueOf(fMo333toPx0680j_4);
                        Float fValueOf16 = Float.valueOf(fMo333toPx0680j_5);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(fValueOf15) | composerStartRestartGroup.changed(fValueOf16);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                        composerStartRestartGroup.startReplaceableGroup(i10);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue3 == companion.getEmpty()) {
                            obj = null;
                            objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            obj = null;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Animatable animatable8 = (Animatable) objRememberedValue3;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(i10);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller8 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller8);
                            objRememberedValue4 = compositionScopedCoroutineScopeCanceller8;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope8 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect(new AnonymousClass2(animatable8, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                        EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable8, fFloatValue, coroutineScope8), composerStartRestartGroup, i11 & 14);
                        if (interfaceC3750qp != null) {
                            modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                        } else {
                            modifierM711toggleableO2vRcR0 = Modifier.Companion;
                        }
                        if (interfaceC3750qp != null) {
                            modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                        } else {
                            modifierMinimumInteractiveComponentSize = Modifier.Companion;
                        }
                        Modifier modifierThen8 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                        Alignment.Companion companion16 = Alignment.Companion;
                        Modifier modifierM526requiredSizeVpY3zN11 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen8, companion16.getCenter(), false, 2, obj), SwitchWidth, f114);
                        composer2 = composerStartRestartGroup;
                        composer2.startReplaceableGroup(733328855);
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy8 = BoxKt.rememberBoxMeasurePolicy(companion16.getTopStart(), false, composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        Density density16 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection8 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration8 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion17 = ComposeUiNode.Companion;
                        constructor = companion17.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpMaterializerOf8 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN11);
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
                        Composer composerM2661constructorimpl8 = Updater.m2661constructorimpl(composer2);
                        Updater.m2668setimpl(composerM2661constructorimpl8, measurePolicyRememberBoxMeasurePolicy8, companion17.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl8, density16, companion17.getSetDensity());
                        Updater.m2668setimpl(composerM2661constructorimpl8, layoutDirection8, companion17.getSetLayoutDirection());
                        Updater.m2668setimpl(composerM2661constructorimpl8, viewConfiguration8, companion17.getSetViewConfiguration());
                        composer2.enableReusing();
                        interfaceC0552GpMaterializerOf8.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        int i111 = i11 >> 6;
                        Modifier modifier12 = modifier3;
                        m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable8.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f113, fM5160constructorimpl8, f115, composer2, ((i11 << 3) & 112) | 6 | (i111 & 896) | (i111 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier12;
                        switchColors3 = switchColorsM1871colorsV1nXRL4;
                        z5 = z4;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z3;
                            }
                            if ((i2 & 32) != 0) {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                                i3 &= -458753;
                            } else {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = switchColors2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(i10);
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
                            i11 = i3;
                        } else {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z3;
                            }
                            if ((i2 & 32) != 0) {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                                i3 &= -458753;
                            } else {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = switchColors2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(i10);
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
                            i11 = i3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                        }
                        if (interfaceC0526Fp3 == null) {
                            f = UncheckedThumbDiameter;
                        } else {
                            f = ThumbDiameter;
                        }
                        float f116 = f;
                        float f117 = SwitchHeight;
                        float fM5160constructorimpl9 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f117 - f116) / 2);
                        fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl9);
                        Density density17 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        float f118 = ThumbPathLength;
                        fMo333toPx0680j_5 = density17.mo333toPx0680j_4(f118);
                        Float fValueOf17 = Float.valueOf(fMo333toPx0680j_4);
                        Float fValueOf18 = Float.valueOf(fMo333toPx0680j_5);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(fValueOf17) | composerStartRestartGroup.changed(fValueOf18);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                        composerStartRestartGroup.startReplaceableGroup(i10);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue3 == companion.getEmpty()) {
                            obj = null;
                            objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            obj = null;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Animatable animatable9 = (Animatable) objRememberedValue3;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(i10);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller9 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller9);
                            objRememberedValue4 = compositionScopedCoroutineScopeCanceller9;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope9 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect(new AnonymousClass2(animatable9, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                        EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable9, fFloatValue, coroutineScope9), composerStartRestartGroup, i11 & 14);
                        if (interfaceC3750qp != null) {
                            modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                        } else {
                            modifierM711toggleableO2vRcR0 = Modifier.Companion;
                        }
                        if (interfaceC3750qp != null) {
                            modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                        } else {
                            modifierMinimumInteractiveComponentSize = Modifier.Companion;
                        }
                        Modifier modifierThen9 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                        Alignment.Companion companion18 = Alignment.Companion;
                        Modifier modifierM526requiredSizeVpY3zN12 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen9, companion18.getCenter(), false, 2, obj), SwitchWidth, f117);
                        composer2 = composerStartRestartGroup;
                        composer2.startReplaceableGroup(733328855);
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy9 = BoxKt.rememberBoxMeasurePolicy(companion18.getTopStart(), false, composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        Density density18 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection9 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration9 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion19 = ComposeUiNode.Companion;
                        constructor = companion19.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpMaterializerOf9 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN12);
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
                        Composer composerM2661constructorimpl9 = Updater.m2661constructorimpl(composer2);
                        Updater.m2668setimpl(composerM2661constructorimpl9, measurePolicyRememberBoxMeasurePolicy9, companion19.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl9, density18, companion19.getSetDensity());
                        Updater.m2668setimpl(composerM2661constructorimpl9, layoutDirection9, companion19.getSetLayoutDirection());
                        Updater.m2668setimpl(composerM2661constructorimpl9, viewConfiguration9, companion19.getSetViewConfiguration());
                        composer2.enableReusing();
                        interfaceC0552GpMaterializerOf9.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        int i112 = i11 >> 6;
                        Modifier modifier13 = modifier3;
                        m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable9.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f116, fM5160constructorimpl9, f118, composer2, ((i11 << 3) & 112) | 6 | (i112 & 896) | (i112 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier13;
                        switchColors3 = switchColorsM1871colorsV1nXRL4;
                        z5 = z4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(z, interfaceC3750qp, modifier4, interfaceC0526Fp3, z5, switchColors3, mutableInteractionSource3, i, i2));
                }
                i3 |= 1572864;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((2995931 & i3) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if ((i2 & 32) != 0) {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                            i3 &= -458753;
                        } else {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = switchColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(i10);
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
                        i11 = i3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if ((i2 & 32) != 0) {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                            i3 &= -458753;
                        } else {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = switchColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(i10);
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
                        i11 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                    }
                    if (interfaceC0526Fp3 == null) {
                        f = UncheckedThumbDiameter;
                    } else {
                        f = ThumbDiameter;
                    }
                    float f119 = f;
                    float f1110 = SwitchHeight;
                    float fM5160constructorimpl10 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f1110 - f119) / 2);
                    fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl10);
                    Density density19 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    float f1111 = ThumbPathLength;
                    fMo333toPx0680j_5 = density19.mo333toPx0680j_4(f1111);
                    Float fValueOf19 = Float.valueOf(fMo333toPx0680j_4);
                    Float fValueOf110 = Float.valueOf(fMo333toPx0680j_5);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(fValueOf19) | composerStartRestartGroup.changed(fValueOf110);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                    composerStartRestartGroup.startReplaceableGroup(i10);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue3 == companion.getEmpty()) {
                        obj = null;
                        objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        obj = null;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Animatable animatable10 = (Animatable) objRememberedValue3;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(i10);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller10 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller10);
                        objRememberedValue4 = compositionScopedCoroutineScopeCanceller10;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope10 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect(new AnonymousClass2(animatable10, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                    EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable10, fFloatValue, coroutineScope10), composerStartRestartGroup, i11 & 14);
                    if (interfaceC3750qp != null) {
                        modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                    } else {
                        modifierM711toggleableO2vRcR0 = Modifier.Companion;
                    }
                    if (interfaceC3750qp != null) {
                        modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                    } else {
                        modifierMinimumInteractiveComponentSize = Modifier.Companion;
                    }
                    Modifier modifierThen10 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                    Alignment.Companion companion110 = Alignment.Companion;
                    Modifier modifierM526requiredSizeVpY3zN13 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen10, companion110.getCenter(), false, 2, obj), SwitchWidth, f1110);
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy10 = BoxKt.rememberBoxMeasurePolicy(companion110.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    Density density110 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection10 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration10 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion111 = ComposeUiNode.Companion;
                    constructor = companion111.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf10 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN13);
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
                    Composer composerM2661constructorimpl10 = Updater.m2661constructorimpl(composer2);
                    Updater.m2668setimpl(composerM2661constructorimpl10, measurePolicyRememberBoxMeasurePolicy10, companion111.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl10, density110, companion111.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl10, layoutDirection10, companion111.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl10, viewConfiguration10, companion111.getSetViewConfiguration());
                    composer2.enableReusing();
                    interfaceC0552GpMaterializerOf10.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    int i113 = i11 >> 6;
                    Modifier modifier14 = modifier3;
                    m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable10.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f119, fM5160constructorimpl10, f1111, composer2, ((i11 << 3) & 112) | 6 | (i113 & 896) | (i113 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier14;
                    switchColors3 = switchColorsM1871colorsV1nXRL4;
                    z5 = z4;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if ((i2 & 32) != 0) {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                            i3 &= -458753;
                        } else {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = switchColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(i10);
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
                        i11 = i3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if ((i2 & 32) != 0) {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                            i3 &= -458753;
                        } else {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = switchColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(i10);
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
                        i11 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                    }
                    if (interfaceC0526Fp3 == null) {
                        f = UncheckedThumbDiameter;
                    } else {
                        f = ThumbDiameter;
                    }
                    float f1112 = f;
                    float f1113 = SwitchHeight;
                    float fM5160constructorimpl11 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f1113 - f1112) / 2);
                    fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl11);
                    Density density111 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    float f1114 = ThumbPathLength;
                    fMo333toPx0680j_5 = density111.mo333toPx0680j_4(f1114);
                    Float fValueOf111 = Float.valueOf(fMo333toPx0680j_4);
                    Float fValueOf112 = Float.valueOf(fMo333toPx0680j_5);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(fValueOf111) | composerStartRestartGroup.changed(fValueOf112);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                    composerStartRestartGroup.startReplaceableGroup(i10);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue3 == companion.getEmpty()) {
                        obj = null;
                        objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        obj = null;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Animatable animatable11 = (Animatable) objRememberedValue3;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(i10);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11);
                        objRememberedValue4 = compositionScopedCoroutineScopeCanceller11;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope11 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect(new AnonymousClass2(animatable11, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                    EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable11, fFloatValue, coroutineScope11), composerStartRestartGroup, i11 & 14);
                    if (interfaceC3750qp != null) {
                        modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                    } else {
                        modifierM711toggleableO2vRcR0 = Modifier.Companion;
                    }
                    if (interfaceC3750qp != null) {
                        modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                    } else {
                        modifierMinimumInteractiveComponentSize = Modifier.Companion;
                    }
                    Modifier modifierThen11 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                    Alignment.Companion companion112 = Alignment.Companion;
                    Modifier modifierM526requiredSizeVpY3zN14 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen11, companion112.getCenter(), false, 2, obj), SwitchWidth, f1113);
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy11 = BoxKt.rememberBoxMeasurePolicy(companion112.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    Density density112 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection11 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration11 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion113 = ComposeUiNode.Companion;
                    constructor = companion113.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf11 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN14);
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
                    Composer composerM2661constructorimpl11 = Updater.m2661constructorimpl(composer2);
                    Updater.m2668setimpl(composerM2661constructorimpl11, measurePolicyRememberBoxMeasurePolicy11, companion113.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl11, density112, companion113.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl11, layoutDirection11, companion113.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl11, viewConfiguration11, companion113.getSetViewConfiguration());
                    composer2.enableReusing();
                    interfaceC0552GpMaterializerOf11.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    int i114 = i11 >> 6;
                    Modifier modifier15 = modifier3;
                    m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable11.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f1112, fM5160constructorimpl11, f1114, composer2, ((i11 << 3) & 112) | 6 | (i114 & 896) | (i114 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier15;
                    switchColors3 = switchColorsM1871colorsV1nXRL4;
                    z5 = z4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(z, interfaceC3750qp, modifier4, interfaceC0526Fp3, z5, switchColors3, mutableInteractionSource3, i, i2));
            }
            i3 |= 24576;
            z3 = z2;
            if ((i & 458752) == 0) {
                if ((i2 & 32) == 0) {
                    switchColors2 = switchColors;
                    if (composerStartRestartGroup.changed(switchColors2)) {
                    }
                    i3 |= i13;
                } else {
                    switchColors2 = switchColors;
                }
                i3 |= i13;
            } else {
                switchColors2 = switchColors;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((i & 3670016) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((2995931 & i3) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if ((i2 & 32) != 0) {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                            i3 &= -458753;
                        } else {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = switchColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(i10);
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
                        i11 = i3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if ((i2 & 32) != 0) {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                            i3 &= -458753;
                        } else {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = switchColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(i10);
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
                        i11 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                    }
                    if (interfaceC0526Fp3 == null) {
                        f = UncheckedThumbDiameter;
                    } else {
                        f = ThumbDiameter;
                    }
                    float f1115 = f;
                    float f1116 = SwitchHeight;
                    float fM5160constructorimpl12 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f1116 - f1115) / 2);
                    fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl12);
                    Density density113 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    float f1117 = ThumbPathLength;
                    fMo333toPx0680j_5 = density113.mo333toPx0680j_4(f1117);
                    Float fValueOf113 = Float.valueOf(fMo333toPx0680j_4);
                    Float fValueOf114 = Float.valueOf(fMo333toPx0680j_5);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(fValueOf113) | composerStartRestartGroup.changed(fValueOf114);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                    composerStartRestartGroup.startReplaceableGroup(i10);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue3 == companion.getEmpty()) {
                        obj = null;
                        objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        obj = null;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Animatable animatable12 = (Animatable) objRememberedValue3;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(i10);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller12 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller12);
                        objRememberedValue4 = compositionScopedCoroutineScopeCanceller12;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope12 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect(new AnonymousClass2(animatable12, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                    EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable12, fFloatValue, coroutineScope12), composerStartRestartGroup, i11 & 14);
                    if (interfaceC3750qp != null) {
                        modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                    } else {
                        modifierM711toggleableO2vRcR0 = Modifier.Companion;
                    }
                    if (interfaceC3750qp != null) {
                        modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                    } else {
                        modifierMinimumInteractiveComponentSize = Modifier.Companion;
                    }
                    Modifier modifierThen12 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                    Alignment.Companion companion114 = Alignment.Companion;
                    Modifier modifierM526requiredSizeVpY3zN15 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen12, companion114.getCenter(), false, 2, obj), SwitchWidth, f1116);
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy12 = BoxKt.rememberBoxMeasurePolicy(companion114.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    Density density114 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection12 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration12 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion115 = ComposeUiNode.Companion;
                    constructor = companion115.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf12 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN15);
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
                    Composer composerM2661constructorimpl12 = Updater.m2661constructorimpl(composer2);
                    Updater.m2668setimpl(composerM2661constructorimpl12, measurePolicyRememberBoxMeasurePolicy12, companion115.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl12, density114, companion115.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl12, layoutDirection12, companion115.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl12, viewConfiguration12, companion115.getSetViewConfiguration());
                    composer2.enableReusing();
                    interfaceC0552GpMaterializerOf12.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    int i115 = i11 >> 6;
                    Modifier modifier16 = modifier3;
                    m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable12.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f1115, fM5160constructorimpl12, f1117, composer2, ((i11 << 3) & 112) | 6 | (i115 & 896) | (i115 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier16;
                    switchColors3 = switchColorsM1871colorsV1nXRL4;
                    z5 = z4;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if ((i2 & 32) != 0) {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                            i3 &= -458753;
                        } else {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = switchColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(i10);
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
                        i11 = i3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if ((i2 & 32) != 0) {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                            i3 &= -458753;
                        } else {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = switchColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(i10);
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
                        i11 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                    }
                    if (interfaceC0526Fp3 == null) {
                        f = UncheckedThumbDiameter;
                    } else {
                        f = ThumbDiameter;
                    }
                    float f1118 = f;
                    float f1119 = SwitchHeight;
                    float fM5160constructorimpl13 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f1119 - f1118) / 2);
                    fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl13);
                    Density density115 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    float f11110 = ThumbPathLength;
                    fMo333toPx0680j_5 = density115.mo333toPx0680j_4(f11110);
                    Float fValueOf115 = Float.valueOf(fMo333toPx0680j_4);
                    Float fValueOf116 = Float.valueOf(fMo333toPx0680j_5);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(fValueOf115) | composerStartRestartGroup.changed(fValueOf116);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                    composerStartRestartGroup.startReplaceableGroup(i10);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue3 == companion.getEmpty()) {
                        obj = null;
                        objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        obj = null;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Animatable animatable13 = (Animatable) objRememberedValue3;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(i10);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller13 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller13);
                        objRememberedValue4 = compositionScopedCoroutineScopeCanceller13;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope13 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect(new AnonymousClass2(animatable13, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                    EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable13, fFloatValue, coroutineScope13), composerStartRestartGroup, i11 & 14);
                    if (interfaceC3750qp != null) {
                        modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                    } else {
                        modifierM711toggleableO2vRcR0 = Modifier.Companion;
                    }
                    if (interfaceC3750qp != null) {
                        modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                    } else {
                        modifierMinimumInteractiveComponentSize = Modifier.Companion;
                    }
                    Modifier modifierThen13 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                    Alignment.Companion companion116 = Alignment.Companion;
                    Modifier modifierM526requiredSizeVpY3zN16 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen13, companion116.getCenter(), false, 2, obj), SwitchWidth, f1119);
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy13 = BoxKt.rememberBoxMeasurePolicy(companion116.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    Density density116 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection13 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration13 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion117 = ComposeUiNode.Companion;
                    constructor = companion117.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf13 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN16);
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
                    Composer composerM2661constructorimpl13 = Updater.m2661constructorimpl(composer2);
                    Updater.m2668setimpl(composerM2661constructorimpl13, measurePolicyRememberBoxMeasurePolicy13, companion117.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl13, density116, companion117.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl13, layoutDirection13, companion117.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl13, viewConfiguration13, companion117.getSetViewConfiguration());
                    composer2.enableReusing();
                    interfaceC0552GpMaterializerOf13.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    int i116 = i11 >> 6;
                    Modifier modifier17 = modifier3;
                    m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable13.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f1118, fM5160constructorimpl13, f11110, composer2, ((i11 << 3) & 112) | 6 | (i116 & 896) | (i116 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier17;
                    switchColors3 = switchColorsM1871colorsV1nXRL4;
                    z5 = z4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(z, interfaceC3750qp, modifier4, interfaceC0526Fp3, z5, switchColors3, mutableInteractionSource3, i, i2));
            }
            i3 |= 1572864;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((2995931 & i3) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if ((i2 & 32) != 0) {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                        i3 &= -458753;
                    } else {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = switchColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(i10);
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
                    i11 = i3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if ((i2 & 32) != 0) {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                        i3 &= -458753;
                    } else {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = switchColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(i10);
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
                    i11 = i3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                }
                if (interfaceC0526Fp3 == null) {
                    f = UncheckedThumbDiameter;
                } else {
                    f = ThumbDiameter;
                }
                float f11111 = f;
                float f11112 = SwitchHeight;
                float fM5160constructorimpl14 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f11112 - f11111) / 2);
                fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl14);
                Density density117 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                float f11113 = ThumbPathLength;
                fMo333toPx0680j_5 = density117.mo333toPx0680j_4(f11113);
                Float fValueOf117 = Float.valueOf(fMo333toPx0680j_4);
                Float fValueOf118 = Float.valueOf(fMo333toPx0680j_5);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(fValueOf117) | composerStartRestartGroup.changed(fValueOf118);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                composerStartRestartGroup.startReplaceableGroup(i10);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue3 == companion.getEmpty()) {
                    obj = null;
                    objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    obj = null;
                }
                composerStartRestartGroup.endReplaceableGroup();
                Animatable animatable14 = (Animatable) objRememberedValue3;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(i10);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller14 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller14);
                    objRememberedValue4 = compositionScopedCoroutineScopeCanceller14;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope14 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect(new AnonymousClass2(animatable14, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable14, fFloatValue, coroutineScope14), composerStartRestartGroup, i11 & 14);
                if (interfaceC3750qp != null) {
                    modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                } else {
                    modifierM711toggleableO2vRcR0 = Modifier.Companion;
                }
                if (interfaceC3750qp != null) {
                    modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                } else {
                    modifierMinimumInteractiveComponentSize = Modifier.Companion;
                }
                Modifier modifierThen14 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                Alignment.Companion companion118 = Alignment.Companion;
                Modifier modifierM526requiredSizeVpY3zN17 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen14, companion118.getCenter(), false, 2, obj), SwitchWidth, f11112);
                composer2 = composerStartRestartGroup;
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy14 = BoxKt.rememberBoxMeasurePolicy(companion118.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                Density density118 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection14 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration14 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion119 = ComposeUiNode.Companion;
                constructor = companion119.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf14 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN17);
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
                Composer composerM2661constructorimpl14 = Updater.m2661constructorimpl(composer2);
                Updater.m2668setimpl(composerM2661constructorimpl14, measurePolicyRememberBoxMeasurePolicy14, companion119.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl14, density118, companion119.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl14, layoutDirection14, companion119.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl14, viewConfiguration14, companion119.getSetViewConfiguration());
                composer2.enableReusing();
                interfaceC0552GpMaterializerOf14.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                int i117 = i11 >> 6;
                Modifier modifier18 = modifier3;
                m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable14.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f11111, fM5160constructorimpl14, f11113, composer2, ((i11 << 3) & 112) | 6 | (i117 & 896) | (i117 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier18;
                switchColors3 = switchColorsM1871colorsV1nXRL4;
                z5 = z4;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if ((i2 & 32) != 0) {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                        i3 &= -458753;
                    } else {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = switchColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(i10);
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
                    i11 = i3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if ((i2 & 32) != 0) {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                        i3 &= -458753;
                    } else {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = switchColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(i10);
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
                    i11 = i3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                }
                if (interfaceC0526Fp3 == null) {
                    f = UncheckedThumbDiameter;
                } else {
                    f = ThumbDiameter;
                }
                float f11114 = f;
                float f11115 = SwitchHeight;
                float fM5160constructorimpl15 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f11115 - f11114) / 2);
                fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl15);
                Density density119 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                float f11116 = ThumbPathLength;
                fMo333toPx0680j_5 = density119.mo333toPx0680j_4(f11116);
                Float fValueOf119 = Float.valueOf(fMo333toPx0680j_4);
                Float fValueOf1110 = Float.valueOf(fMo333toPx0680j_5);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(fValueOf119) | composerStartRestartGroup.changed(fValueOf1110);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                composerStartRestartGroup.startReplaceableGroup(i10);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue3 == companion.getEmpty()) {
                    obj = null;
                    objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    obj = null;
                }
                composerStartRestartGroup.endReplaceableGroup();
                Animatable animatable15 = (Animatable) objRememberedValue3;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(i10);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller15 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller15);
                    objRememberedValue4 = compositionScopedCoroutineScopeCanceller15;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope15 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect(new AnonymousClass2(animatable15, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable15, fFloatValue, coroutineScope15), composerStartRestartGroup, i11 & 14);
                if (interfaceC3750qp != null) {
                    modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                } else {
                    modifierM711toggleableO2vRcR0 = Modifier.Companion;
                }
                if (interfaceC3750qp != null) {
                    modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                } else {
                    modifierMinimumInteractiveComponentSize = Modifier.Companion;
                }
                Modifier modifierThen15 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                Alignment.Companion companion1110 = Alignment.Companion;
                Modifier modifierM526requiredSizeVpY3zN18 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen15, companion1110.getCenter(), false, 2, obj), SwitchWidth, f11115);
                composer2 = composerStartRestartGroup;
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy15 = BoxKt.rememberBoxMeasurePolicy(companion1110.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                Density density1110 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection15 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration15 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion1111 = ComposeUiNode.Companion;
                constructor = companion1111.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf15 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN18);
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
                Composer composerM2661constructorimpl15 = Updater.m2661constructorimpl(composer2);
                Updater.m2668setimpl(composerM2661constructorimpl15, measurePolicyRememberBoxMeasurePolicy15, companion1111.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl15, density1110, companion1111.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl15, layoutDirection15, companion1111.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl15, viewConfiguration15, companion1111.getSetViewConfiguration());
                composer2.enableReusing();
                interfaceC0552GpMaterializerOf15.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                int i118 = i11 >> 6;
                Modifier modifier19 = modifier3;
                m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable15.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f11114, fM5160constructorimpl15, f11116, composer2, ((i11 << 3) & 112) | 6 | (i118 & 896) | (i118 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier19;
                switchColors3 = switchColorsM1871colorsV1nXRL4;
                z5 = z4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(z, interfaceC3750qp, modifier4, interfaceC0526Fp3, z5, switchColors3, mutableInteractionSource3, i, i2));
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                interfaceC0526Fp2 = interfaceC0526Fp;
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((57344 & i) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((i & 458752) == 0) {
                    if ((i2 & 32) == 0) {
                        switchColors2 = switchColors;
                        if (composerStartRestartGroup.changed(switchColors2)) {
                        }
                        i3 |= i13;
                    } else {
                        switchColors2 = switchColors;
                    }
                    i3 |= i13;
                } else {
                    switchColors2 = switchColors;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((i & 3670016) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((2995931 & i3) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z3;
                            }
                            if ((i2 & 32) != 0) {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                                i3 &= -458753;
                            } else {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = switchColors2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(i10);
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
                            i11 = i3;
                        } else {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z3;
                            }
                            if ((i2 & 32) != 0) {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                                i3 &= -458753;
                            } else {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = switchColors2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(i10);
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
                            i11 = i3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                        }
                        if (interfaceC0526Fp3 == null) {
                            f = UncheckedThumbDiameter;
                        } else {
                            f = ThumbDiameter;
                        }
                        float f11117 = f;
                        float f11118 = SwitchHeight;
                        float fM5160constructorimpl16 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f11118 - f11117) / 2);
                        fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl16);
                        Density density1111 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        float f11119 = ThumbPathLength;
                        fMo333toPx0680j_5 = density1111.mo333toPx0680j_4(f11119);
                        Float fValueOf1111 = Float.valueOf(fMo333toPx0680j_4);
                        Float fValueOf1112 = Float.valueOf(fMo333toPx0680j_5);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(fValueOf1111) | composerStartRestartGroup.changed(fValueOf1112);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                        composerStartRestartGroup.startReplaceableGroup(i10);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue3 == companion.getEmpty()) {
                            obj = null;
                            objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            obj = null;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Animatable animatable16 = (Animatable) objRememberedValue3;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(i10);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller16 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller16);
                            objRememberedValue4 = compositionScopedCoroutineScopeCanceller16;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope16 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect(new AnonymousClass2(animatable16, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                        EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable16, fFloatValue, coroutineScope16), composerStartRestartGroup, i11 & 14);
                        if (interfaceC3750qp != null) {
                            modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                        } else {
                            modifierM711toggleableO2vRcR0 = Modifier.Companion;
                        }
                        if (interfaceC3750qp != null) {
                            modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                        } else {
                            modifierMinimumInteractiveComponentSize = Modifier.Companion;
                        }
                        Modifier modifierThen16 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                        Alignment.Companion companion1112 = Alignment.Companion;
                        Modifier modifierM526requiredSizeVpY3zN19 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen16, companion1112.getCenter(), false, 2, obj), SwitchWidth, f11118);
                        composer2 = composerStartRestartGroup;
                        composer2.startReplaceableGroup(733328855);
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy16 = BoxKt.rememberBoxMeasurePolicy(companion1112.getTopStart(), false, composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        Density density1112 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection16 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration16 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion1113 = ComposeUiNode.Companion;
                        constructor = companion1113.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpMaterializerOf16 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN19);
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
                        Composer composerM2661constructorimpl16 = Updater.m2661constructorimpl(composer2);
                        Updater.m2668setimpl(composerM2661constructorimpl16, measurePolicyRememberBoxMeasurePolicy16, companion1113.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl16, density1112, companion1113.getSetDensity());
                        Updater.m2668setimpl(composerM2661constructorimpl16, layoutDirection16, companion1113.getSetLayoutDirection());
                        Updater.m2668setimpl(composerM2661constructorimpl16, viewConfiguration16, companion1113.getSetViewConfiguration());
                        composer2.enableReusing();
                        interfaceC0552GpMaterializerOf16.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        int i119 = i11 >> 6;
                        Modifier modifier110 = modifier3;
                        m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable16.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f11117, fM5160constructorimpl16, f11119, composer2, ((i11 << 3) & 112) | 6 | (i119 & 896) | (i119 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier110;
                        switchColors3 = switchColorsM1871colorsV1nXRL4;
                        z5 = z4;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z3;
                            }
                            if ((i2 & 32) != 0) {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                                i3 &= -458753;
                            } else {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = switchColors2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(i10);
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
                            i11 = i3;
                        } else {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z3;
                            }
                            if ((i2 & 32) != 0) {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                                i3 &= -458753;
                            } else {
                                i10 = -492369756;
                                switchColorsM1871colorsV1nXRL4 = switchColors2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(i10);
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
                            i11 = i3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                        }
                        if (interfaceC0526Fp3 == null) {
                            f = UncheckedThumbDiameter;
                        } else {
                            f = ThumbDiameter;
                        }
                        float f111110 = f;
                        float f111111 = SwitchHeight;
                        float fM5160constructorimpl17 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f111111 - f111110) / 2);
                        fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl17);
                        Density density1113 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        float f111112 = ThumbPathLength;
                        fMo333toPx0680j_5 = density1113.mo333toPx0680j_4(f111112);
                        Float fValueOf1113 = Float.valueOf(fMo333toPx0680j_4);
                        Float fValueOf1114 = Float.valueOf(fMo333toPx0680j_5);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(fValueOf1113) | composerStartRestartGroup.changed(fValueOf1114);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                        composerStartRestartGroup.startReplaceableGroup(i10);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue3 == companion.getEmpty()) {
                            obj = null;
                            objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            obj = null;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Animatable animatable17 = (Animatable) objRememberedValue3;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(i10);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller17 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller17);
                            objRememberedValue4 = compositionScopedCoroutineScopeCanceller17;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope17 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect(new AnonymousClass2(animatable17, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                        EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable17, fFloatValue, coroutineScope17), composerStartRestartGroup, i11 & 14);
                        if (interfaceC3750qp != null) {
                            modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                        } else {
                            modifierM711toggleableO2vRcR0 = Modifier.Companion;
                        }
                        if (interfaceC3750qp != null) {
                            modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                        } else {
                            modifierMinimumInteractiveComponentSize = Modifier.Companion;
                        }
                        Modifier modifierThen17 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                        Alignment.Companion companion1114 = Alignment.Companion;
                        Modifier modifierM526requiredSizeVpY3zN110 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen17, companion1114.getCenter(), false, 2, obj), SwitchWidth, f111111);
                        composer2 = composerStartRestartGroup;
                        composer2.startReplaceableGroup(733328855);
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy17 = BoxKt.rememberBoxMeasurePolicy(companion1114.getTopStart(), false, composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        Density density1114 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection17 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration17 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion1115 = ComposeUiNode.Companion;
                        constructor = companion1115.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpMaterializerOf17 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN110);
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
                        Composer composerM2661constructorimpl17 = Updater.m2661constructorimpl(composer2);
                        Updater.m2668setimpl(composerM2661constructorimpl17, measurePolicyRememberBoxMeasurePolicy17, companion1115.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl17, density1114, companion1115.getSetDensity());
                        Updater.m2668setimpl(composerM2661constructorimpl17, layoutDirection17, companion1115.getSetLayoutDirection());
                        Updater.m2668setimpl(composerM2661constructorimpl17, viewConfiguration17, companion1115.getSetViewConfiguration());
                        composer2.enableReusing();
                        interfaceC0552GpMaterializerOf17.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        int i1110 = i11 >> 6;
                        Modifier modifier111 = modifier3;
                        m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable17.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f111110, fM5160constructorimpl17, f111112, composer2, ((i11 << 3) & 112) | 6 | (i1110 & 896) | (i1110 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier111;
                        switchColors3 = switchColorsM1871colorsV1nXRL4;
                        z5 = z4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(z, interfaceC3750qp, modifier4, interfaceC0526Fp3, z5, switchColors3, mutableInteractionSource3, i, i2));
                }
                i3 |= 1572864;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((2995931 & i3) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if ((i2 & 32) != 0) {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                            i3 &= -458753;
                        } else {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = switchColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(i10);
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
                        i11 = i3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if ((i2 & 32) != 0) {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                            i3 &= -458753;
                        } else {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = switchColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(i10);
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
                        i11 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                    }
                    if (interfaceC0526Fp3 == null) {
                        f = UncheckedThumbDiameter;
                    } else {
                        f = ThumbDiameter;
                    }
                    float f111113 = f;
                    float f111114 = SwitchHeight;
                    float fM5160constructorimpl18 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f111114 - f111113) / 2);
                    fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl18);
                    Density density1115 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    float f111115 = ThumbPathLength;
                    fMo333toPx0680j_5 = density1115.mo333toPx0680j_4(f111115);
                    Float fValueOf1115 = Float.valueOf(fMo333toPx0680j_4);
                    Float fValueOf1116 = Float.valueOf(fMo333toPx0680j_5);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(fValueOf1115) | composerStartRestartGroup.changed(fValueOf1116);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                    composerStartRestartGroup.startReplaceableGroup(i10);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue3 == companion.getEmpty()) {
                        obj = null;
                        objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        obj = null;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Animatable animatable18 = (Animatable) objRememberedValue3;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(i10);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller18 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller18);
                        objRememberedValue4 = compositionScopedCoroutineScopeCanceller18;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope18 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect(new AnonymousClass2(animatable18, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                    EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable18, fFloatValue, coroutineScope18), composerStartRestartGroup, i11 & 14);
                    if (interfaceC3750qp != null) {
                        modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                    } else {
                        modifierM711toggleableO2vRcR0 = Modifier.Companion;
                    }
                    if (interfaceC3750qp != null) {
                        modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                    } else {
                        modifierMinimumInteractiveComponentSize = Modifier.Companion;
                    }
                    Modifier modifierThen18 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                    Alignment.Companion companion1116 = Alignment.Companion;
                    Modifier modifierM526requiredSizeVpY3zN111 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen18, companion1116.getCenter(), false, 2, obj), SwitchWidth, f111114);
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy18 = BoxKt.rememberBoxMeasurePolicy(companion1116.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    Density density1116 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection18 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration18 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion1117 = ComposeUiNode.Companion;
                    constructor = companion1117.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf18 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN111);
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
                    Composer composerM2661constructorimpl18 = Updater.m2661constructorimpl(composer2);
                    Updater.m2668setimpl(composerM2661constructorimpl18, measurePolicyRememberBoxMeasurePolicy18, companion1117.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl18, density1116, companion1117.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl18, layoutDirection18, companion1117.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl18, viewConfiguration18, companion1117.getSetViewConfiguration());
                    composer2.enableReusing();
                    interfaceC0552GpMaterializerOf18.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    int i1111 = i11 >> 6;
                    Modifier modifier112 = modifier3;
                    m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable18.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f111113, fM5160constructorimpl18, f111115, composer2, ((i11 << 3) & 112) | 6 | (i1111 & 896) | (i1111 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier112;
                    switchColors3 = switchColorsM1871colorsV1nXRL4;
                    z5 = z4;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if ((i2 & 32) != 0) {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                            i3 &= -458753;
                        } else {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = switchColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(i10);
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
                        i11 = i3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if ((i2 & 32) != 0) {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                            i3 &= -458753;
                        } else {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = switchColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(i10);
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
                        i11 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                    }
                    if (interfaceC0526Fp3 == null) {
                        f = UncheckedThumbDiameter;
                    } else {
                        f = ThumbDiameter;
                    }
                    float f111116 = f;
                    float f111117 = SwitchHeight;
                    float fM5160constructorimpl19 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f111117 - f111116) / 2);
                    fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl19);
                    Density density1117 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    float f111118 = ThumbPathLength;
                    fMo333toPx0680j_5 = density1117.mo333toPx0680j_4(f111118);
                    Float fValueOf1117 = Float.valueOf(fMo333toPx0680j_4);
                    Float fValueOf1118 = Float.valueOf(fMo333toPx0680j_5);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(fValueOf1117) | composerStartRestartGroup.changed(fValueOf1118);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                    composerStartRestartGroup.startReplaceableGroup(i10);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue3 == companion.getEmpty()) {
                        obj = null;
                        objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        obj = null;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Animatable animatable19 = (Animatable) objRememberedValue3;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(i10);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller19 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller19);
                        objRememberedValue4 = compositionScopedCoroutineScopeCanceller19;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope19 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect(new AnonymousClass2(animatable19, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                    EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable19, fFloatValue, coroutineScope19), composerStartRestartGroup, i11 & 14);
                    if (interfaceC3750qp != null) {
                        modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                    } else {
                        modifierM711toggleableO2vRcR0 = Modifier.Companion;
                    }
                    if (interfaceC3750qp != null) {
                        modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                    } else {
                        modifierMinimumInteractiveComponentSize = Modifier.Companion;
                    }
                    Modifier modifierThen19 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                    Alignment.Companion companion1118 = Alignment.Companion;
                    Modifier modifierM526requiredSizeVpY3zN112 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen19, companion1118.getCenter(), false, 2, obj), SwitchWidth, f111117);
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy19 = BoxKt.rememberBoxMeasurePolicy(companion1118.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    Density density1118 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection19 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration19 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion1119 = ComposeUiNode.Companion;
                    constructor = companion1119.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf19 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN112);
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
                    Composer composerM2661constructorimpl19 = Updater.m2661constructorimpl(composer2);
                    Updater.m2668setimpl(composerM2661constructorimpl19, measurePolicyRememberBoxMeasurePolicy19, companion1119.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl19, density1118, companion1119.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl19, layoutDirection19, companion1119.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl19, viewConfiguration19, companion1119.getSetViewConfiguration());
                    composer2.enableReusing();
                    interfaceC0552GpMaterializerOf19.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    int i1112 = i11 >> 6;
                    Modifier modifier113 = modifier3;
                    m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable19.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f111116, fM5160constructorimpl19, f111118, composer2, ((i11 << 3) & 112) | 6 | (i1112 & 896) | (i1112 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier113;
                    switchColors3 = switchColorsM1871colorsV1nXRL4;
                    z5 = z4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(z, interfaceC3750qp, modifier4, interfaceC0526Fp3, z5, switchColors3, mutableInteractionSource3, i, i2));
            }
            i3 |= 24576;
            z3 = z2;
            if ((i & 458752) == 0) {
                if ((i2 & 32) == 0) {
                    switchColors2 = switchColors;
                    if (composerStartRestartGroup.changed(switchColors2)) {
                    }
                    i3 |= i13;
                } else {
                    switchColors2 = switchColors;
                }
                i3 |= i13;
            } else {
                switchColors2 = switchColors;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((i & 3670016) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((2995931 & i3) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if ((i2 & 32) != 0) {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                            i3 &= -458753;
                        } else {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = switchColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(i10);
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
                        i11 = i3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if ((i2 & 32) != 0) {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                            i3 &= -458753;
                        } else {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = switchColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(i10);
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
                        i11 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                    }
                    if (interfaceC0526Fp3 == null) {
                        f = UncheckedThumbDiameter;
                    } else {
                        f = ThumbDiameter;
                    }
                    float f111119 = f;
                    float f1111110 = SwitchHeight;
                    float fM5160constructorimpl110 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f1111110 - f111119) / 2);
                    fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl110);
                    Density density1119 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    float f1111111 = ThumbPathLength;
                    fMo333toPx0680j_5 = density1119.mo333toPx0680j_4(f1111111);
                    Float fValueOf1119 = Float.valueOf(fMo333toPx0680j_4);
                    Float fValueOf11110 = Float.valueOf(fMo333toPx0680j_5);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(fValueOf1119) | composerStartRestartGroup.changed(fValueOf11110);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                    composerStartRestartGroup.startReplaceableGroup(i10);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue3 == companion.getEmpty()) {
                        obj = null;
                        objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        obj = null;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Animatable animatable110 = (Animatable) objRememberedValue3;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(i10);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller110 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller110);
                        objRememberedValue4 = compositionScopedCoroutineScopeCanceller110;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope110 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect(new AnonymousClass2(animatable110, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                    EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable110, fFloatValue, coroutineScope110), composerStartRestartGroup, i11 & 14);
                    if (interfaceC3750qp != null) {
                        modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                    } else {
                        modifierM711toggleableO2vRcR0 = Modifier.Companion;
                    }
                    if (interfaceC3750qp != null) {
                        modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                    } else {
                        modifierMinimumInteractiveComponentSize = Modifier.Companion;
                    }
                    Modifier modifierThen110 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                    Alignment.Companion companion11110 = Alignment.Companion;
                    Modifier modifierM526requiredSizeVpY3zN113 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen110, companion11110.getCenter(), false, 2, obj), SwitchWidth, f1111110);
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy110 = BoxKt.rememberBoxMeasurePolicy(companion11110.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    Density density11110 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection110 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration110 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion11111 = ComposeUiNode.Companion;
                    constructor = companion11111.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf110 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN113);
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
                    Composer composerM2661constructorimpl110 = Updater.m2661constructorimpl(composer2);
                    Updater.m2668setimpl(composerM2661constructorimpl110, measurePolicyRememberBoxMeasurePolicy110, companion11111.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl110, density11110, companion11111.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl110, layoutDirection110, companion11111.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl110, viewConfiguration110, companion11111.getSetViewConfiguration());
                    composer2.enableReusing();
                    interfaceC0552GpMaterializerOf110.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    int i1113 = i11 >> 6;
                    Modifier modifier114 = modifier3;
                    m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable110.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f111119, fM5160constructorimpl110, f1111111, composer2, ((i11 << 3) & 112) | 6 | (i1113 & 896) | (i1113 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier114;
                    switchColors3 = switchColorsM1871colorsV1nXRL4;
                    z5 = z4;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if ((i2 & 32) != 0) {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                            i3 &= -458753;
                        } else {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = switchColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(i10);
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
                        i11 = i3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if ((i2 & 32) != 0) {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                            i3 &= -458753;
                        } else {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = switchColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(i10);
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
                        i11 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                    }
                    if (interfaceC0526Fp3 == null) {
                        f = UncheckedThumbDiameter;
                    } else {
                        f = ThumbDiameter;
                    }
                    float f1111112 = f;
                    float f1111113 = SwitchHeight;
                    float fM5160constructorimpl111 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f1111113 - f1111112) / 2);
                    fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl111);
                    Density density11111 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    float f1111114 = ThumbPathLength;
                    fMo333toPx0680j_5 = density11111.mo333toPx0680j_4(f1111114);
                    Float fValueOf11111 = Float.valueOf(fMo333toPx0680j_4);
                    Float fValueOf11112 = Float.valueOf(fMo333toPx0680j_5);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(fValueOf11111) | composerStartRestartGroup.changed(fValueOf11112);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                    composerStartRestartGroup.startReplaceableGroup(i10);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue3 == companion.getEmpty()) {
                        obj = null;
                        objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        obj = null;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Animatable animatable111 = (Animatable) objRememberedValue3;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(i10);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller111 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller111);
                        objRememberedValue4 = compositionScopedCoroutineScopeCanceller111;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope111 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect(new AnonymousClass2(animatable111, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                    EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable111, fFloatValue, coroutineScope111), composerStartRestartGroup, i11 & 14);
                    if (interfaceC3750qp != null) {
                        modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                    } else {
                        modifierM711toggleableO2vRcR0 = Modifier.Companion;
                    }
                    if (interfaceC3750qp != null) {
                        modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                    } else {
                        modifierMinimumInteractiveComponentSize = Modifier.Companion;
                    }
                    Modifier modifierThen111 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                    Alignment.Companion companion11112 = Alignment.Companion;
                    Modifier modifierM526requiredSizeVpY3zN114 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen111, companion11112.getCenter(), false, 2, obj), SwitchWidth, f1111113);
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy111 = BoxKt.rememberBoxMeasurePolicy(companion11112.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    Density density11112 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection111 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration111 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion11113 = ComposeUiNode.Companion;
                    constructor = companion11113.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf111 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN114);
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
                    Composer composerM2661constructorimpl111 = Updater.m2661constructorimpl(composer2);
                    Updater.m2668setimpl(composerM2661constructorimpl111, measurePolicyRememberBoxMeasurePolicy111, companion11113.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl111, density11112, companion11113.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl111, layoutDirection111, companion11113.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl111, viewConfiguration111, companion11113.getSetViewConfiguration());
                    composer2.enableReusing();
                    interfaceC0552GpMaterializerOf111.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    int i1114 = i11 >> 6;
                    Modifier modifier115 = modifier3;
                    m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable111.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f1111112, fM5160constructorimpl111, f1111114, composer2, ((i11 << 3) & 112) | 6 | (i1114 & 896) | (i1114 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier115;
                    switchColors3 = switchColorsM1871colorsV1nXRL4;
                    z5 = z4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(z, interfaceC3750qp, modifier4, interfaceC0526Fp3, z5, switchColors3, mutableInteractionSource3, i, i2));
            }
            i3 |= 1572864;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((2995931 & i3) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if ((i2 & 32) != 0) {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                        i3 &= -458753;
                    } else {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = switchColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(i10);
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
                    i11 = i3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if ((i2 & 32) != 0) {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                        i3 &= -458753;
                    } else {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = switchColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(i10);
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
                    i11 = i3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                }
                if (interfaceC0526Fp3 == null) {
                    f = UncheckedThumbDiameter;
                } else {
                    f = ThumbDiameter;
                }
                float f1111115 = f;
                float f1111116 = SwitchHeight;
                float fM5160constructorimpl112 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f1111116 - f1111115) / 2);
                fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl112);
                Density density11113 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                float f1111117 = ThumbPathLength;
                fMo333toPx0680j_5 = density11113.mo333toPx0680j_4(f1111117);
                Float fValueOf11113 = Float.valueOf(fMo333toPx0680j_4);
                Float fValueOf11114 = Float.valueOf(fMo333toPx0680j_5);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(fValueOf11113) | composerStartRestartGroup.changed(fValueOf11114);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                composerStartRestartGroup.startReplaceableGroup(i10);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue3 == companion.getEmpty()) {
                    obj = null;
                    objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    obj = null;
                }
                composerStartRestartGroup.endReplaceableGroup();
                Animatable animatable112 = (Animatable) objRememberedValue3;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(i10);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller112 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller112);
                    objRememberedValue4 = compositionScopedCoroutineScopeCanceller112;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope112 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect(new AnonymousClass2(animatable112, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable112, fFloatValue, coroutineScope112), composerStartRestartGroup, i11 & 14);
                if (interfaceC3750qp != null) {
                    modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                } else {
                    modifierM711toggleableO2vRcR0 = Modifier.Companion;
                }
                if (interfaceC3750qp != null) {
                    modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                } else {
                    modifierMinimumInteractiveComponentSize = Modifier.Companion;
                }
                Modifier modifierThen112 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                Alignment.Companion companion11114 = Alignment.Companion;
                Modifier modifierM526requiredSizeVpY3zN115 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen112, companion11114.getCenter(), false, 2, obj), SwitchWidth, f1111116);
                composer2 = composerStartRestartGroup;
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy112 = BoxKt.rememberBoxMeasurePolicy(companion11114.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                Density density11114 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection112 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration112 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion11115 = ComposeUiNode.Companion;
                constructor = companion11115.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf112 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN115);
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
                Composer composerM2661constructorimpl112 = Updater.m2661constructorimpl(composer2);
                Updater.m2668setimpl(composerM2661constructorimpl112, measurePolicyRememberBoxMeasurePolicy112, companion11115.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl112, density11114, companion11115.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl112, layoutDirection112, companion11115.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl112, viewConfiguration112, companion11115.getSetViewConfiguration());
                composer2.enableReusing();
                interfaceC0552GpMaterializerOf112.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                int i1115 = i11 >> 6;
                Modifier modifier116 = modifier3;
                m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable112.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f1111115, fM5160constructorimpl112, f1111117, composer2, ((i11 << 3) & 112) | 6 | (i1115 & 896) | (i1115 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier116;
                switchColors3 = switchColorsM1871colorsV1nXRL4;
                z5 = z4;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if ((i2 & 32) != 0) {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                        i3 &= -458753;
                    } else {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = switchColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(i10);
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
                    i11 = i3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if ((i2 & 32) != 0) {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                        i3 &= -458753;
                    } else {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = switchColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(i10);
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
                    i11 = i3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                }
                if (interfaceC0526Fp3 == null) {
                    f = UncheckedThumbDiameter;
                } else {
                    f = ThumbDiameter;
                }
                float f1111118 = f;
                float f1111119 = SwitchHeight;
                float fM5160constructorimpl113 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f1111119 - f1111118) / 2);
                fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl113);
                Density density11115 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                float f11111110 = ThumbPathLength;
                fMo333toPx0680j_5 = density11115.mo333toPx0680j_4(f11111110);
                Float fValueOf11115 = Float.valueOf(fMo333toPx0680j_4);
                Float fValueOf11116 = Float.valueOf(fMo333toPx0680j_5);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(fValueOf11115) | composerStartRestartGroup.changed(fValueOf11116);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                composerStartRestartGroup.startReplaceableGroup(i10);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue3 == companion.getEmpty()) {
                    obj = null;
                    objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    obj = null;
                }
                composerStartRestartGroup.endReplaceableGroup();
                Animatable animatable113 = (Animatable) objRememberedValue3;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(i10);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller113 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller113);
                    objRememberedValue4 = compositionScopedCoroutineScopeCanceller113;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope113 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect(new AnonymousClass2(animatable113, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable113, fFloatValue, coroutineScope113), composerStartRestartGroup, i11 & 14);
                if (interfaceC3750qp != null) {
                    modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                } else {
                    modifierM711toggleableO2vRcR0 = Modifier.Companion;
                }
                if (interfaceC3750qp != null) {
                    modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                } else {
                    modifierMinimumInteractiveComponentSize = Modifier.Companion;
                }
                Modifier modifierThen113 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                Alignment.Companion companion11116 = Alignment.Companion;
                Modifier modifierM526requiredSizeVpY3zN116 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen113, companion11116.getCenter(), false, 2, obj), SwitchWidth, f1111119);
                composer2 = composerStartRestartGroup;
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy113 = BoxKt.rememberBoxMeasurePolicy(companion11116.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                Density density11116 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection113 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration113 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion11117 = ComposeUiNode.Companion;
                constructor = companion11117.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf113 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN116);
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
                Composer composerM2661constructorimpl113 = Updater.m2661constructorimpl(composer2);
                Updater.m2668setimpl(composerM2661constructorimpl113, measurePolicyRememberBoxMeasurePolicy113, companion11117.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl113, density11116, companion11117.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl113, layoutDirection113, companion11117.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl113, viewConfiguration113, companion11117.getSetViewConfiguration());
                composer2.enableReusing();
                interfaceC0552GpMaterializerOf113.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                int i1116 = i11 >> 6;
                Modifier modifier117 = modifier3;
                m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable113.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f1111118, fM5160constructorimpl113, f11111110, composer2, ((i11 << 3) & 112) | 6 | (i1116 & 896) | (i1116 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier117;
                switchColors3 = switchColorsM1871colorsV1nXRL4;
                z5 = z4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(z, interfaceC3750qp, modifier4, interfaceC0526Fp3, z5, switchColors3, mutableInteractionSource3, i, i2));
        }
        i3 |= 3072;
        interfaceC0526Fp2 = interfaceC0526Fp;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((57344 & i) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((i & 458752) == 0) {
                if ((i2 & 32) == 0) {
                    switchColors2 = switchColors;
                    if (composerStartRestartGroup.changed(switchColors2)) {
                    }
                    i3 |= i13;
                } else {
                    switchColors2 = switchColors;
                }
                i3 |= i13;
            } else {
                switchColors2 = switchColors;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((i & 3670016) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((2995931 & i3) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if ((i2 & 32) != 0) {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                            i3 &= -458753;
                        } else {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = switchColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(i10);
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
                        i11 = i3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if ((i2 & 32) != 0) {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                            i3 &= -458753;
                        } else {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = switchColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(i10);
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
                        i11 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                    }
                    if (interfaceC0526Fp3 == null) {
                        f = UncheckedThumbDiameter;
                    } else {
                        f = ThumbDiameter;
                    }
                    float f11111111 = f;
                    float f11111112 = SwitchHeight;
                    float fM5160constructorimpl114 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f11111112 - f11111111) / 2);
                    fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl114);
                    Density density11117 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    float f11111113 = ThumbPathLength;
                    fMo333toPx0680j_5 = density11117.mo333toPx0680j_4(f11111113);
                    Float fValueOf11117 = Float.valueOf(fMo333toPx0680j_4);
                    Float fValueOf11118 = Float.valueOf(fMo333toPx0680j_5);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(fValueOf11117) | composerStartRestartGroup.changed(fValueOf11118);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                    composerStartRestartGroup.startReplaceableGroup(i10);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue3 == companion.getEmpty()) {
                        obj = null;
                        objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        obj = null;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Animatable animatable114 = (Animatable) objRememberedValue3;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(i10);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller114 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller114);
                        objRememberedValue4 = compositionScopedCoroutineScopeCanceller114;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope114 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect(new AnonymousClass2(animatable114, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                    EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable114, fFloatValue, coroutineScope114), composerStartRestartGroup, i11 & 14);
                    if (interfaceC3750qp != null) {
                        modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                    } else {
                        modifierM711toggleableO2vRcR0 = Modifier.Companion;
                    }
                    if (interfaceC3750qp != null) {
                        modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                    } else {
                        modifierMinimumInteractiveComponentSize = Modifier.Companion;
                    }
                    Modifier modifierThen114 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                    Alignment.Companion companion11118 = Alignment.Companion;
                    Modifier modifierM526requiredSizeVpY3zN117 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen114, companion11118.getCenter(), false, 2, obj), SwitchWidth, f11111112);
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy114 = BoxKt.rememberBoxMeasurePolicy(companion11118.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    Density density11118 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection114 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration114 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion11119 = ComposeUiNode.Companion;
                    constructor = companion11119.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf114 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN117);
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
                    Composer composerM2661constructorimpl114 = Updater.m2661constructorimpl(composer2);
                    Updater.m2668setimpl(composerM2661constructorimpl114, measurePolicyRememberBoxMeasurePolicy114, companion11119.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl114, density11118, companion11119.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl114, layoutDirection114, companion11119.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl114, viewConfiguration114, companion11119.getSetViewConfiguration());
                    composer2.enableReusing();
                    interfaceC0552GpMaterializerOf114.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    int i1117 = i11 >> 6;
                    Modifier modifier118 = modifier3;
                    m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable114.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f11111111, fM5160constructorimpl114, f11111113, composer2, ((i11 << 3) & 112) | 6 | (i1117 & 896) | (i1117 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier118;
                    switchColors3 = switchColorsM1871colorsV1nXRL4;
                    z5 = z4;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if ((i2 & 32) != 0) {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                            i3 &= -458753;
                        } else {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = switchColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(i10);
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
                        i11 = i3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if ((i2 & 32) != 0) {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                            i3 &= -458753;
                        } else {
                            i10 = -492369756;
                            switchColorsM1871colorsV1nXRL4 = switchColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(i10);
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
                        i11 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                    }
                    if (interfaceC0526Fp3 == null) {
                        f = UncheckedThumbDiameter;
                    } else {
                        f = ThumbDiameter;
                    }
                    float f11111114 = f;
                    float f11111115 = SwitchHeight;
                    float fM5160constructorimpl115 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f11111115 - f11111114) / 2);
                    fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl115);
                    Density density11119 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    float f11111116 = ThumbPathLength;
                    fMo333toPx0680j_5 = density11119.mo333toPx0680j_4(f11111116);
                    Float fValueOf11119 = Float.valueOf(fMo333toPx0680j_4);
                    Float fValueOf111110 = Float.valueOf(fMo333toPx0680j_5);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(fValueOf11119) | composerStartRestartGroup.changed(fValueOf111110);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                    composerStartRestartGroup.startReplaceableGroup(i10);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue3 == companion.getEmpty()) {
                        obj = null;
                        objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        obj = null;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Animatable animatable115 = (Animatable) objRememberedValue3;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(i10);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller115 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller115);
                        objRememberedValue4 = compositionScopedCoroutineScopeCanceller115;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope115 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect(new AnonymousClass2(animatable115, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                    EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable115, fFloatValue, coroutineScope115), composerStartRestartGroup, i11 & 14);
                    if (interfaceC3750qp != null) {
                        modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                    } else {
                        modifierM711toggleableO2vRcR0 = Modifier.Companion;
                    }
                    if (interfaceC3750qp != null) {
                        modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                    } else {
                        modifierMinimumInteractiveComponentSize = Modifier.Companion;
                    }
                    Modifier modifierThen115 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                    Alignment.Companion companion111110 = Alignment.Companion;
                    Modifier modifierM526requiredSizeVpY3zN118 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen115, companion111110.getCenter(), false, 2, obj), SwitchWidth, f11111115);
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy115 = BoxKt.rememberBoxMeasurePolicy(companion111110.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    Density density111110 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection115 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration115 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion111111 = ComposeUiNode.Companion;
                    constructor = companion111111.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf115 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN118);
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
                    Composer composerM2661constructorimpl115 = Updater.m2661constructorimpl(composer2);
                    Updater.m2668setimpl(composerM2661constructorimpl115, measurePolicyRememberBoxMeasurePolicy115, companion111111.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl115, density111110, companion111111.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl115, layoutDirection115, companion111111.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl115, viewConfiguration115, companion111111.getSetViewConfiguration());
                    composer2.enableReusing();
                    interfaceC0552GpMaterializerOf115.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    int i1118 = i11 >> 6;
                    Modifier modifier119 = modifier3;
                    m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable115.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f11111114, fM5160constructorimpl115, f11111116, composer2, ((i11 << 3) & 112) | 6 | (i1118 & 896) | (i1118 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier119;
                    switchColors3 = switchColorsM1871colorsV1nXRL4;
                    z5 = z4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(z, interfaceC3750qp, modifier4, interfaceC0526Fp3, z5, switchColors3, mutableInteractionSource3, i, i2));
            }
            i3 |= 1572864;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((2995931 & i3) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if ((i2 & 32) != 0) {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                        i3 &= -458753;
                    } else {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = switchColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(i10);
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
                    i11 = i3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if ((i2 & 32) != 0) {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                        i3 &= -458753;
                    } else {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = switchColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(i10);
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
                    i11 = i3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                }
                if (interfaceC0526Fp3 == null) {
                    f = UncheckedThumbDiameter;
                } else {
                    f = ThumbDiameter;
                }
                float f11111117 = f;
                float f11111118 = SwitchHeight;
                float fM5160constructorimpl116 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f11111118 - f11111117) / 2);
                fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl116);
                Density density111111 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                float f11111119 = ThumbPathLength;
                fMo333toPx0680j_5 = density111111.mo333toPx0680j_4(f11111119);
                Float fValueOf111111 = Float.valueOf(fMo333toPx0680j_4);
                Float fValueOf111112 = Float.valueOf(fMo333toPx0680j_5);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(fValueOf111111) | composerStartRestartGroup.changed(fValueOf111112);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                composerStartRestartGroup.startReplaceableGroup(i10);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue3 == companion.getEmpty()) {
                    obj = null;
                    objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    obj = null;
                }
                composerStartRestartGroup.endReplaceableGroup();
                Animatable animatable116 = (Animatable) objRememberedValue3;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(i10);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller116 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller116);
                    objRememberedValue4 = compositionScopedCoroutineScopeCanceller116;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope116 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect(new AnonymousClass2(animatable116, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable116, fFloatValue, coroutineScope116), composerStartRestartGroup, i11 & 14);
                if (interfaceC3750qp != null) {
                    modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                } else {
                    modifierM711toggleableO2vRcR0 = Modifier.Companion;
                }
                if (interfaceC3750qp != null) {
                    modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                } else {
                    modifierMinimumInteractiveComponentSize = Modifier.Companion;
                }
                Modifier modifierThen116 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                Alignment.Companion companion111112 = Alignment.Companion;
                Modifier modifierM526requiredSizeVpY3zN119 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen116, companion111112.getCenter(), false, 2, obj), SwitchWidth, f11111118);
                composer2 = composerStartRestartGroup;
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy116 = BoxKt.rememberBoxMeasurePolicy(companion111112.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                Density density111112 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection116 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration116 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion111113 = ComposeUiNode.Companion;
                constructor = companion111113.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf116 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN119);
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
                Composer composerM2661constructorimpl116 = Updater.m2661constructorimpl(composer2);
                Updater.m2668setimpl(composerM2661constructorimpl116, measurePolicyRememberBoxMeasurePolicy116, companion111113.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl116, density111112, companion111113.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl116, layoutDirection116, companion111113.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl116, viewConfiguration116, companion111113.getSetViewConfiguration());
                composer2.enableReusing();
                interfaceC0552GpMaterializerOf116.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                int i1119 = i11 >> 6;
                Modifier modifier1110 = modifier3;
                m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable116.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f11111117, fM5160constructorimpl116, f11111119, composer2, ((i11 << 3) & 112) | 6 | (i1119 & 896) | (i1119 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier1110;
                switchColors3 = switchColorsM1871colorsV1nXRL4;
                z5 = z4;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if ((i2 & 32) != 0) {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                        i3 &= -458753;
                    } else {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = switchColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(i10);
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
                    i11 = i3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if ((i2 & 32) != 0) {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                        i3 &= -458753;
                    } else {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = switchColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(i10);
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
                    i11 = i3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                }
                if (interfaceC0526Fp3 == null) {
                    f = UncheckedThumbDiameter;
                } else {
                    f = ThumbDiameter;
                }
                float f111111110 = f;
                float f111111111 = SwitchHeight;
                float fM5160constructorimpl117 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f111111111 - f111111110) / 2);
                fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl117);
                Density density111113 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                float f111111112 = ThumbPathLength;
                fMo333toPx0680j_5 = density111113.mo333toPx0680j_4(f111111112);
                Float fValueOf111113 = Float.valueOf(fMo333toPx0680j_4);
                Float fValueOf111114 = Float.valueOf(fMo333toPx0680j_5);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(fValueOf111113) | composerStartRestartGroup.changed(fValueOf111114);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                composerStartRestartGroup.startReplaceableGroup(i10);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue3 == companion.getEmpty()) {
                    obj = null;
                    objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    obj = null;
                }
                composerStartRestartGroup.endReplaceableGroup();
                Animatable animatable117 = (Animatable) objRememberedValue3;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(i10);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller117 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller117);
                    objRememberedValue4 = compositionScopedCoroutineScopeCanceller117;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope117 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect(new AnonymousClass2(animatable117, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable117, fFloatValue, coroutineScope117), composerStartRestartGroup, i11 & 14);
                if (interfaceC3750qp != null) {
                    modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                } else {
                    modifierM711toggleableO2vRcR0 = Modifier.Companion;
                }
                if (interfaceC3750qp != null) {
                    modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                } else {
                    modifierMinimumInteractiveComponentSize = Modifier.Companion;
                }
                Modifier modifierThen117 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                Alignment.Companion companion111114 = Alignment.Companion;
                Modifier modifierM526requiredSizeVpY3zN1110 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen117, companion111114.getCenter(), false, 2, obj), SwitchWidth, f111111111);
                composer2 = composerStartRestartGroup;
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy117 = BoxKt.rememberBoxMeasurePolicy(companion111114.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                Density density111114 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection117 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration117 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion111115 = ComposeUiNode.Companion;
                constructor = companion111115.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf117 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN1110);
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
                Composer composerM2661constructorimpl117 = Updater.m2661constructorimpl(composer2);
                Updater.m2668setimpl(composerM2661constructorimpl117, measurePolicyRememberBoxMeasurePolicy117, companion111115.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl117, density111114, companion111115.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl117, layoutDirection117, companion111115.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl117, viewConfiguration117, companion111115.getSetViewConfiguration());
                composer2.enableReusing();
                interfaceC0552GpMaterializerOf117.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                int i11110 = i11 >> 6;
                Modifier modifier1111 = modifier3;
                m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable117.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f111111110, fM5160constructorimpl117, f111111112, composer2, ((i11 << 3) & 112) | 6 | (i11110 & 896) | (i11110 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier1111;
                switchColors3 = switchColorsM1871colorsV1nXRL4;
                z5 = z4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(z, interfaceC3750qp, modifier4, interfaceC0526Fp3, z5, switchColors3, mutableInteractionSource3, i, i2));
        }
        i3 |= 24576;
        z3 = z2;
        if ((i & 458752) == 0) {
            if ((i2 & 32) == 0) {
                switchColors2 = switchColors;
                if (composerStartRestartGroup.changed(switchColors2)) {
                }
                i3 |= i13;
            } else {
                switchColors2 = switchColors;
            }
            i3 |= i13;
        } else {
            switchColors2 = switchColors;
        }
        i8 = i2 & 64;
        if (i8 != 0) {
            if ((i & 3670016) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((2995931 & i3) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if ((i2 & 32) != 0) {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                        i3 &= -458753;
                    } else {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = switchColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(i10);
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
                    i11 = i3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if ((i2 & 32) != 0) {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                        i3 &= -458753;
                    } else {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = switchColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(i10);
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
                    i11 = i3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                }
                if (interfaceC0526Fp3 == null) {
                    f = UncheckedThumbDiameter;
                } else {
                    f = ThumbDiameter;
                }
                float f111111113 = f;
                float f111111114 = SwitchHeight;
                float fM5160constructorimpl118 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f111111114 - f111111113) / 2);
                fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl118);
                Density density111115 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                float f111111115 = ThumbPathLength;
                fMo333toPx0680j_5 = density111115.mo333toPx0680j_4(f111111115);
                Float fValueOf111115 = Float.valueOf(fMo333toPx0680j_4);
                Float fValueOf111116 = Float.valueOf(fMo333toPx0680j_5);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(fValueOf111115) | composerStartRestartGroup.changed(fValueOf111116);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                composerStartRestartGroup.startReplaceableGroup(i10);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue3 == companion.getEmpty()) {
                    obj = null;
                    objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    obj = null;
                }
                composerStartRestartGroup.endReplaceableGroup();
                Animatable animatable118 = (Animatable) objRememberedValue3;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(i10);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller118 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller118);
                    objRememberedValue4 = compositionScopedCoroutineScopeCanceller118;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope118 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect(new AnonymousClass2(animatable118, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable118, fFloatValue, coroutineScope118), composerStartRestartGroup, i11 & 14);
                if (interfaceC3750qp != null) {
                    modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                } else {
                    modifierM711toggleableO2vRcR0 = Modifier.Companion;
                }
                if (interfaceC3750qp != null) {
                    modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                } else {
                    modifierMinimumInteractiveComponentSize = Modifier.Companion;
                }
                Modifier modifierThen118 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                Alignment.Companion companion111116 = Alignment.Companion;
                Modifier modifierM526requiredSizeVpY3zN1111 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen118, companion111116.getCenter(), false, 2, obj), SwitchWidth, f111111114);
                composer2 = composerStartRestartGroup;
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy118 = BoxKt.rememberBoxMeasurePolicy(companion111116.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                Density density111116 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection118 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration118 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion111117 = ComposeUiNode.Companion;
                constructor = companion111117.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf118 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN1111);
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
                Composer composerM2661constructorimpl118 = Updater.m2661constructorimpl(composer2);
                Updater.m2668setimpl(composerM2661constructorimpl118, measurePolicyRememberBoxMeasurePolicy118, companion111117.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl118, density111116, companion111117.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl118, layoutDirection118, companion111117.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl118, viewConfiguration118, companion111117.getSetViewConfiguration());
                composer2.enableReusing();
                interfaceC0552GpMaterializerOf118.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                int i11111 = i11 >> 6;
                Modifier modifier1112 = modifier3;
                m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable118.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f111111113, fM5160constructorimpl118, f111111115, composer2, ((i11 << 3) & 112) | 6 | (i11111 & 896) | (i11111 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier1112;
                switchColors3 = switchColorsM1871colorsV1nXRL4;
                z5 = z4;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if ((i2 & 32) != 0) {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                        i3 &= -458753;
                    } else {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = switchColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(i10);
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
                    i11 = i3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if ((i2 & 32) != 0) {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                        i3 &= -458753;
                    } else {
                        i10 = -492369756;
                        switchColorsM1871colorsV1nXRL4 = switchColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(i10);
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
                    i11 = i3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                }
                if (interfaceC0526Fp3 == null) {
                    f = UncheckedThumbDiameter;
                } else {
                    f = ThumbDiameter;
                }
                float f111111116 = f;
                float f111111117 = SwitchHeight;
                float fM5160constructorimpl119 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f111111117 - f111111116) / 2);
                fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl119);
                Density density111117 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                float f111111118 = ThumbPathLength;
                fMo333toPx0680j_5 = density111117.mo333toPx0680j_4(f111111118);
                Float fValueOf111117 = Float.valueOf(fMo333toPx0680j_4);
                Float fValueOf111118 = Float.valueOf(fMo333toPx0680j_5);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(fValueOf111117) | composerStartRestartGroup.changed(fValueOf111118);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
                composerStartRestartGroup.startReplaceableGroup(i10);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue3 == companion.getEmpty()) {
                    obj = null;
                    objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    obj = null;
                }
                composerStartRestartGroup.endReplaceableGroup();
                Animatable animatable119 = (Animatable) objRememberedValue3;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(i10);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller119 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller119);
                    objRememberedValue4 = compositionScopedCoroutineScopeCanceller119;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope119 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect(new AnonymousClass2(animatable119, fMo333toPx0680j_4), composerStartRestartGroup, 0);
                EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable119, fFloatValue, coroutineScope119), composerStartRestartGroup, i11 & 14);
                if (interfaceC3750qp != null) {
                    modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                } else {
                    modifierM711toggleableO2vRcR0 = Modifier.Companion;
                }
                if (interfaceC3750qp != null) {
                    modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                } else {
                    modifierMinimumInteractiveComponentSize = Modifier.Companion;
                }
                Modifier modifierThen119 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                Alignment.Companion companion111118 = Alignment.Companion;
                Modifier modifierM526requiredSizeVpY3zN1112 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen119, companion111118.getCenter(), false, 2, obj), SwitchWidth, f111111117);
                composer2 = composerStartRestartGroup;
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy119 = BoxKt.rememberBoxMeasurePolicy(companion111118.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                Density density111118 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection119 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration119 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion111119 = ComposeUiNode.Companion;
                constructor = companion111119.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf119 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN1112);
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
                Composer composerM2661constructorimpl119 = Updater.m2661constructorimpl(composer2);
                Updater.m2668setimpl(composerM2661constructorimpl119, measurePolicyRememberBoxMeasurePolicy119, companion111119.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl119, density111118, companion111119.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl119, layoutDirection119, companion111119.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl119, viewConfiguration119, companion111119.getSetViewConfiguration());
                composer2.enableReusing();
                interfaceC0552GpMaterializerOf119.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                int i11112 = i11 >> 6;
                Modifier modifier1113 = modifier3;
                m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable119.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f111111116, fM5160constructorimpl119, f111111118, composer2, ((i11 << 3) & 112) | 6 | (i11112 & 896) | (i11112 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier1113;
                switchColors3 = switchColorsM1871colorsV1nXRL4;
                z5 = z4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(z, interfaceC3750qp, modifier4, interfaceC0526Fp3, z5, switchColors3, mutableInteractionSource3, i, i2));
        }
        i3 |= 1572864;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((2995931 & i3) == 599186) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp3 = null;
                } else {
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                }
                if (i6 != 0) {
                    z4 = true;
                } else {
                    z4 = z3;
                }
                if ((i2 & 32) != 0) {
                    i10 = -492369756;
                    switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                    i3 &= -458753;
                } else {
                    i10 = -492369756;
                    switchColorsM1871colorsV1nXRL4 = switchColors2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(i10);
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
                i11 = i3;
            } else {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp3 = null;
                } else {
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                }
                if (i6 != 0) {
                    z4 = true;
                } else {
                    z4 = z3;
                }
                if ((i2 & 32) != 0) {
                    i10 = -492369756;
                    switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                    i3 &= -458753;
                } else {
                    i10 = -492369756;
                    switchColorsM1871colorsV1nXRL4 = switchColors2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(i10);
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
                i11 = i3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
            }
            if (interfaceC0526Fp3 == null) {
                f = UncheckedThumbDiameter;
            } else {
                f = ThumbDiameter;
            }
            float f111111119 = f;
            float f1111111110 = SwitchHeight;
            float fM5160constructorimpl1110 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f1111111110 - f111111119) / 2);
            fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl1110);
            Density density111119 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            float f1111111111 = ThumbPathLength;
            fMo333toPx0680j_5 = density111119.mo333toPx0680j_4(f1111111111);
            Float fValueOf111119 = Float.valueOf(fMo333toPx0680j_4);
            Float fValueOf1111110 = Float.valueOf(fMo333toPx0680j_5);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged = composerStartRestartGroup.changed(fValueOf111119) | composerStartRestartGroup.changed(fValueOf1111110);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
            composerStartRestartGroup.startReplaceableGroup(i10);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            companion = Composer.Companion;
            if (objRememberedValue3 == companion.getEmpty()) {
                obj = null;
                objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                obj = null;
            }
            composerStartRestartGroup.endReplaceableGroup();
            Animatable animatable1110 = (Animatable) objRememberedValue3;
            composerStartRestartGroup.startReplaceableGroup(773894976);
            composerStartRestartGroup.startReplaceableGroup(i10);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1110 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1110);
                objRememberedValue4 = compositionScopedCoroutineScopeCanceller1110;
            }
            composerStartRestartGroup.endReplaceableGroup();
            InterfaceC2052dg coroutineScope1110 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.SideEffect(new AnonymousClass2(animatable1110, fMo333toPx0680j_4), composerStartRestartGroup, 0);
            EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable1110, fFloatValue, coroutineScope1110), composerStartRestartGroup, i11 & 14);
            if (interfaceC3750qp != null) {
                modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
            } else {
                modifierM711toggleableO2vRcR0 = Modifier.Companion;
            }
            if (interfaceC3750qp != null) {
                modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
            } else {
                modifierMinimumInteractiveComponentSize = Modifier.Companion;
            }
            Modifier modifierThen1110 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
            Alignment.Companion companion1111110 = Alignment.Companion;
            Modifier modifierM526requiredSizeVpY3zN1113 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen1110, companion1111110.getCenter(), false, 2, obj), SwitchWidth, f1111111110);
            composer2 = composerStartRestartGroup;
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy1110 = BoxKt.rememberBoxMeasurePolicy(companion1111110.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            Density density1111110 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection1110 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration1110 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion1111111 = ComposeUiNode.Companion;
            constructor = companion1111111.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf1110 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN1113);
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
            Composer composerM2661constructorimpl1110 = Updater.m2661constructorimpl(composer2);
            Updater.m2668setimpl(composerM2661constructorimpl1110, measurePolicyRememberBoxMeasurePolicy1110, companion1111111.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl1110, density1111110, companion1111111.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl1110, layoutDirection1110, companion1111111.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl1110, viewConfiguration1110, companion1111111.getSetViewConfiguration());
            composer2.enableReusing();
            interfaceC0552GpMaterializerOf1110.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            int i11113 = i11 >> 6;
            Modifier modifier1114 = modifier3;
            m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable1110.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f111111119, fM5160constructorimpl1110, f1111111111, composer2, ((i11 << 3) & 112) | 6 | (i11113 & 896) | (i11113 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier1114;
            switchColors3 = switchColorsM1871colorsV1nXRL4;
            z5 = z4;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp3 = null;
                } else {
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                }
                if (i6 != 0) {
                    z4 = true;
                } else {
                    z4 = z3;
                }
                if ((i2 & 32) != 0) {
                    i10 = -492369756;
                    switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                    i3 &= -458753;
                } else {
                    i10 = -492369756;
                    switchColorsM1871colorsV1nXRL4 = switchColors2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(i10);
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
                i11 = i3;
            } else {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp3 = null;
                } else {
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                }
                if (i6 != 0) {
                    z4 = true;
                } else {
                    z4 = z3;
                }
                if ((i2 & 32) != 0) {
                    i10 = -492369756;
                    switchColorsM1871colorsV1nXRL4 = SwitchDefaults.INSTANCE.m1871colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                    i3 &= -458753;
                } else {
                    i10 = -492369756;
                    switchColorsM1871colorsV1nXRL4 = switchColors2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(i10);
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
                i11 = i3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
            }
            if (interfaceC0526Fp3 == null) {
                f = UncheckedThumbDiameter;
            } else {
                f = ThumbDiameter;
            }
            float f1111111112 = f;
            float f1111111113 = SwitchHeight;
            float fM5160constructorimpl1111 = Dp.m5160constructorimpl(Dp.m5160constructorimpl(f1111111113 - f1111111112) / 2);
            fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM5160constructorimpl1111);
            Density density1111111 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            float f1111111114 = ThumbPathLength;
            fMo333toPx0680j_5 = density1111111.mo333toPx0680j_4(f1111111114);
            Float fValueOf1111111 = Float.valueOf(fMo333toPx0680j_4);
            Float fValueOf1111112 = Float.valueOf(fMo333toPx0680j_5);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged = composerStartRestartGroup.changed(fValueOf1111111) | composerStartRestartGroup.changed(fValueOf1111112);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new SwitchKt$Switch$valueToOffset$1$1(fMo333toPx0680j_5, fMo333toPx0680j_4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            fFloatValue = ((Number) ((InterfaceC3750qp) objRememberedValue2).invoke(Boolean.valueOf(z))).floatValue();
            composerStartRestartGroup.startReplaceableGroup(i10);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            companion = Composer.Companion;
            if (objRememberedValue3 == companion.getEmpty()) {
                obj = null;
                objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                obj = null;
            }
            composerStartRestartGroup.endReplaceableGroup();
            Animatable animatable1111 = (Animatable) objRememberedValue3;
            composerStartRestartGroup.startReplaceableGroup(773894976);
            composerStartRestartGroup.startReplaceableGroup(i10);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1111 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1111);
                objRememberedValue4 = compositionScopedCoroutineScopeCanceller1111;
            }
            composerStartRestartGroup.endReplaceableGroup();
            InterfaceC2052dg coroutineScope1111 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.SideEffect(new AnonymousClass2(animatable1111, fMo333toPx0680j_4), composerStartRestartGroup, 0);
            EffectsKt.DisposableEffect(Boolean.valueOf(z), new AnonymousClass3(animatable1111, fFloatValue, coroutineScope1111), composerStartRestartGroup, i11 & 14);
            if (interfaceC3750qp != null) {
                modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z4, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
            } else {
                modifierM711toggleableO2vRcR0 = Modifier.Companion;
            }
            if (interfaceC3750qp != null) {
                modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
            } else {
                modifierMinimumInteractiveComponentSize = Modifier.Companion;
            }
            Modifier modifierThen1111 = modifier3.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
            Alignment.Companion companion1111112 = Alignment.Companion;
            Modifier modifierM526requiredSizeVpY3zN1114 = SizeKt.m526requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen1111, companion1111112.getCenter(), false, 2, obj), SwitchWidth, f1111111113);
            composer2 = composerStartRestartGroup;
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy1111 = BoxKt.rememberBoxMeasurePolicy(companion1111112.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            Density density1111112 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection1111 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration1111 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion1111113 = ComposeUiNode.Companion;
            constructor = companion1111113.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf1111 = LayoutKt.materializerOf(modifierM526requiredSizeVpY3zN1114);
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
            Composer composerM2661constructorimpl1111 = Updater.m2661constructorimpl(composer2);
            Updater.m2668setimpl(composerM2661constructorimpl1111, measurePolicyRememberBoxMeasurePolicy1111, companion1111113.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl1111, density1111112, companion1111113.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl1111, layoutDirection1111, companion1111113.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl1111, viewConfiguration1111, companion1111113.getSetViewConfiguration());
            composer2.enableReusing();
            interfaceC0552GpMaterializerOf1111.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            int i11114 = i11 >> 6;
            Modifier modifier1115 = modifier3;
            m1873SwitchImpl0DmnUew(BoxScopeInstance.INSTANCE, z, z4, switchColorsM1871colorsV1nXRL4, animatable1111.asState(), interfaceC0526Fp3, mutableInteractionSource3, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f1111111112, fM5160constructorimpl1111, f1111111114, composer2, ((i11 << 3) & 112) | 6 | (i11114 & 896) | (i11114 & 7168) | ((i11 << 6) & 458752) | (i11 & 3670016), 6);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier1115;
            switchColors3 = switchColorsM1871colorsV1nXRL4;
            z5 = z4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(z, interfaceC3750qp, modifier4, interfaceC0526Fp3, z5, switchColors3, mutableInteractionSource3, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: SwitchImpl-0DmnUew, reason: not valid java name */
    public static final void m1873SwitchImpl0DmnUew(BoxScope boxScope, boolean z, boolean z2, SwitchColors switchColors, State<Float> state, InterfaceC0526Fp interfaceC0526Fp, InteractionSource interactionSource, Shape shape, float f, float f2, float f3, Composer composer, int i, int i2) {
        int i3;
        int i4;
        float fFloatValue;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1968109941);
        if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i3 |= composerStartRestartGroup.changed(switchColors) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(state) ? 16384 : 8192;
        }
        if ((i & 458752) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 131072 : 65536;
        }
        if ((i & 3670016) == 0) {
            i3 |= composerStartRestartGroup.changed(interactionSource) ? 1048576 : 524288;
        }
        if ((i & 29360128) == 0) {
            i3 |= composerStartRestartGroup.changed(shape) ? 8388608 : 4194304;
        }
        if ((i & 234881024) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 67108864 : 33554432;
        }
        if ((i & 1879048192) == 0) {
            i3 |= composerStartRestartGroup.changed(f2) ? PropertyOptions.DELETE_EXISTING : 268435456;
        }
        if ((i2 & 14) == 0) {
            i4 = i2 | (composerStartRestartGroup.changed(f3) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i3 & 1533916891) == 306783378 && (i4 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1968109941, i3, i4, "androidx.compose.material3.SwitchImpl (Switch.kt:175)");
            }
            int i5 = ((i3 >> 6) & 14) | (i3 & 112) | ((i3 >> 3) & 896);
            State<Color> stateTrackColor$material3_release = switchColors.trackColor$material3_release(z2, z, composerStartRestartGroup, i5);
            State<Boolean> stateCollectIsPressedAsState = PressInteractionKt.collectIsPressedAsState(interactionSource, composerStartRestartGroup, (i3 >> 18) & 14);
            int i6 = i3;
            float fM2529getPressedHandleWidthD9Ej5fM = SwitchImpl_0DmnUew$lambda$7(stateCollectIsPressedAsState) ? SwitchTokens.INSTANCE.m2529getPressedHandleWidthD9Ej5fM() : Dp.m5160constructorimpl(Dp.m5160constructorimpl(Dp.m5160constructorimpl(ThumbDiameter - f) * (Dp.m5160constructorimpl(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo329toDpu2uoSUM(state.getValue().floatValue()) - f2) / Dp.m5160constructorimpl(f3 - f2))) + f);
            composerStartRestartGroup.startReplaceableGroup(-993794105);
            if (SwitchImpl_0DmnUew$lambda$7(stateCollectIsPressedAsState)) {
                fFloatValue = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(z ? Dp.m5160constructorimpl(ThumbPathLength - SwitchTokens.INSTANCE.m2535getTrackOutlineWidthD9Ej5fM()) : SwitchTokens.INSTANCE.m2535getTrackOutlineWidthD9Ej5fM());
            } else {
                fFloatValue = state.getValue().floatValue();
            }
            composerStartRestartGroup.endReplaceableGroup();
            SwitchTokens switchTokens = SwitchTokens.INSTANCE;
            Shape shape2 = ShapesKt.toShape(switchTokens.getTrackShape(), composerStartRestartGroup, 6);
            Modifier.Companion companion = Modifier.Companion;
            Alignment.Companion companion2 = Alignment.Companion;
            Modifier modifierM166backgroundbw27NRU = BackgroundKt.m166backgroundbw27NRU(BorderKt.m178borderxT4_qwU(SizeKt.m518height3ABfNKs(SizeKt.m537width3ABfNKs(boxScope.align(companion, companion2.getCenter()), SwitchWidth), SwitchHeight), switchTokens.m2535getTrackOutlineWidthD9Ej5fM(), switchColors.borderColor$material3_release(z2, z, composerStartRestartGroup, i5).getValue().m3042unboximpl(), shape2), SwitchImpl_0DmnUew$lambda$6(stateTrackColor$material3_release), shape2);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierM166backgroundbw27NRU);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion3.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion3.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion3.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            long jSwitchImpl_0DmnUew$lambda$13$lambda$10 = SwitchImpl_0DmnUew$lambda$13$lambda$10(switchColors.thumbColor$material3_release(z2, z, composerStartRestartGroup, i5));
            Modifier modifierAlign = boxScopeInstance.align(companion, companion2.getCenterStart());
            Float fValueOf = Float.valueOf(fFloatValue);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed(fValueOf);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new SwitchKt$SwitchImpl$1$1$1(fFloatValue);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composer2 = composerStartRestartGroup;
            Modifier modifierM166backgroundbw27NRU2 = BackgroundKt.m166backgroundbw27NRU(SizeKt.m524requiredSize3ABfNKs(IndicationKt.indication(OffsetKt.offset(modifierAlign, (InterfaceC3750qp) objRememberedValue), interactionSource, RippleKt.m1318rememberRipple9IZ8Weo(false, Dp.m5160constructorimpl(switchTokens.m2533getStateLayerSizeD9Ej5fM() / 2), 0L, composer2, 54, 4)), fM2529getPressedHandleWidthD9Ej5fM), jSwitchImpl_0DmnUew$lambda$13$lambda$10, shape);
            Alignment center = companion2.getCenter();
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
            composer2.startReplaceableGroup(-1323940314);
            Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            InterfaceC3588op constructor2 = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(modifierM166backgroundbw27NRU2);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composer2);
            Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl2, density2, companion3.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion3.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion3.getSetViewConfiguration());
            composer2.enableReusing();
            interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(1420970387);
            if (interfaceC0526Fp != null) {
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(switchColors.iconColor$material3_release(z2, z, composer2, i5).getValue())}, interfaceC0526Fp, composer2, ((i6 >> 12) & 112) | 8);
            }
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new SwitchKt$SwitchImpl$2(boxScope, z, z2, switchColors, state, interfaceC0526Fp, interactionSource, shape, f, f2, f3, i, i2));
    }

    private static final long SwitchImpl_0DmnUew$lambda$13$lambda$10(State<Color> state) {
        return state.getValue().m3042unboximpl();
    }

    private static final long SwitchImpl_0DmnUew$lambda$6(State<Color> state) {
        return state.getValue().m3042unboximpl();
    }

    private static final boolean SwitchImpl_0DmnUew$lambda$7(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }

    public static final float getUncheckedThumbDiameter() {
        return UncheckedThumbDiameter;
    }
}
