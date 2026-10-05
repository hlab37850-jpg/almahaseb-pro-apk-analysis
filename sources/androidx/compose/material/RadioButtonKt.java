package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class RadioButtonKt {
    private static final int RadioAnimationDuration = 100;
    private static final float RadioButtonDotSize;
    private static final float RadioButtonPadding;
    private static final float RadioButtonRippleRadius = Dp.m5160constructorimpl(24);
    private static final float RadioButtonSize;
    private static final float RadioRadius;
    private static final float RadioStrokeWidth;

    /* JADX INFO: renamed from: androidx.compose.material.RadioButtonKt$RadioButton$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ RadioButtonColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3588op $onClick;
        final /* synthetic */ boolean $selected;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(boolean z, InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, RadioButtonColors radioButtonColors, int i, int i2) {
            super(2);
            this.$selected = z;
            this.$onClick = interfaceC3588op;
            this.$modifier = modifier;
            this.$enabled = z2;
            this.$interactionSource = mutableInteractionSource;
            this.$colors = radioButtonColors;
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
            RadioButtonKt.RadioButton(this.$selected, this.$onClick, this.$modifier, this.$enabled, this.$interactionSource, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    static {
        float f = 2;
        RadioButtonPadding = Dp.m5160constructorimpl(f);
        float fM5160constructorimpl = Dp.m5160constructorimpl(20);
        RadioButtonSize = fM5160constructorimpl;
        RadioRadius = Dp.m5160constructorimpl(fM5160constructorimpl / f);
        RadioButtonDotSize = Dp.m5160constructorimpl(12);
        RadioStrokeWidth = Dp.m5160constructorimpl(f);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x013d  */
    /* JADX WARN: Code duplicated, block: B:104:0x0146  */
    /* JADX WARN: Code duplicated, block: B:105:0x014f  */
    /* JADX WARN: Code duplicated, block: B:108:0x0183  */
    /* JADX WARN: Code duplicated, block: B:109:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:112:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:113:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:116:0x0209  */
    /* JADX WARN: Code duplicated, block: B:118:0x0211  */
    /* JADX WARN: Code duplicated, block: B:121:0x0227  */
    /* JADX WARN: Code duplicated, block: B:126:0x0236  */
    /* JADX WARN: Code duplicated, block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x005d  */
    /* JADX WARN: Code duplicated, block: B:38:0x0062  */
    /* JADX WARN: Code duplicated, block: B:40:0x0066  */
    /* JADX WARN: Code duplicated, block: B:42:0x006e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0071  */
    /* JADX WARN: Code duplicated, block: B:47:0x0078  */
    /* JADX WARN: Code duplicated, block: B:49:0x007d  */
    /* JADX WARN: Code duplicated, block: B:51:0x0083  */
    /* JADX WARN: Code duplicated, block: B:53:0x008b  */
    /* JADX WARN: Code duplicated, block: B:54:0x008e  */
    /* JADX WARN: Code duplicated, block: B:58:0x0096  */
    /* JADX WARN: Code duplicated, block: B:60:0x009a  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:63:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:85:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:87:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:90:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:92:0x0105  */
    /* JADX WARN: Code duplicated, block: B:94:0x0112  */
    /* JADX WARN: Code duplicated, block: B:97:0x0117  */
    /* JADX WARN: Code duplicated, block: B:98:0x0130  */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v9 */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void RadioButton(boolean z, InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, RadioButtonColors radioButtonColors, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        RadioButtonColors radioButtonColors2;
        Modifier modifier3;
        boolean z4;
        MutableInteractionSource mutableInteractionSource3;
        MutableInteractionSource mutableInteractionSource4;
        Modifier modifier4;
        RadioButtonColors radioButtonColorsM1193colorsRGew2ao;
        Object objRememberedValue;
        float fM5160constructorimpl;
        State<Dp> stateM84animateDpAsStateAjpBEmI;
        State<Color> stateRadioColor;
        int i8;
        ?? r12;
        boolean z5;
        Modifier modifierM707selectableO2vRcR0;
        Modifier modifierMinimumInteractiveComponentSize;
        boolean zChanged;
        Object objRememberedValue2;
        RadioButtonColors radioButtonColors3;
        boolean z6;
        MutableInteractionSource mutableInteractionSource5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1314435585);
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
        int i9 = i2 & 4;
        if (i9 == 0) {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((57344 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    if ((458752 & i) == 0) {
                        if ((i2 & 32) == 0) {
                            radioButtonColors2 = radioButtonColors;
                            int i10 = composerStartRestartGroup.changed(radioButtonColors2) ? 131072 : 65536;
                            i3 |= i10;
                        } else {
                            radioButtonColors2 = radioButtonColors;
                        }
                        i3 |= i10;
                    } else {
                        radioButtonColors2 = radioButtonColors;
                    }
                    if ((374491 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            } else {
                                z4 = z3;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                modifier4 = modifier3;
                                radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                            } else {
                                mutableInteractionSource4 = mutableInteractionSource3;
                                modifier4 = modifier3;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1314435585, i3, -1, "androidx.compose.material.RadioButton (RadioButton.kt:73)");
                            }
                            if (z) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(RadioButtonDotSize / 2);
                            } else {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            }
                            stateM84animateDpAsStateAjpBEmI = AnimateAsStateKt.m84animateDpAsStateAjpBEmI(fM5160constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                            int i11 = i3 >> 9;
                            stateRadioColor = radioButtonColorsM1193colorsRGew2ao.radioColor(z4, z, composerStartRestartGroup, ((i3 << 3) & 112) | (i11 & 14) | (i11 & 896));
                            composerStartRestartGroup.startReplaceableGroup(1941632354);
                            if (interfaceC3588op != null) {
                                r12 = 0;
                                z5 = z4;
                                i8 = 2;
                                modifierM707selectableO2vRcR0 = SelectableKt.m707selectableO2vRcR0(Modifier.Companion, z, mutableInteractionSource4, RippleKt.m1318rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z5, Role.m4543boximpl(Role.Companion.m4554getRadioButtono7Vup1c()), interfaceC3588op);
                            } else {
                                i8 = 2;
                                r12 = 0;
                                z5 = z4;
                                modifierM707selectableO2vRcR0 = Modifier.Companion;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            if (interfaceC3588op != null) {
                                modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                            } else {
                                modifierMinimumInteractiveComponentSize = Modifier.Companion;
                            }
                            Modifier modifierM524requiredSize3ABfNKs = SizeKt.m524requiredSize3ABfNKs(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM707selectableO2vRcR0), Alignment.Companion.getCenter(), r12, i8, null), RadioButtonPadding), RadioButtonSize);
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM84animateDpAsStateAjpBEmI);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            CanvasKt.Canvas(modifierM524requiredSize3ABfNKs, (InterfaceC3750qp) objRememberedValue2, composerStartRestartGroup, r12);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier4;
                            radioButtonColors3 = radioButtonColorsM1193colorsRGew2ao;
                            z6 = z5;
                            mutableInteractionSource5 = mutableInteractionSource4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            modifier4 = modifier2;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1314435585, i3, -1, "androidx.compose.material.RadioButton (RadioButton.kt:73)");
                        }
                        if (z) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(RadioButtonDotSize / 2);
                        } else {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        stateM84animateDpAsStateAjpBEmI = AnimateAsStateKt.m84animateDpAsStateAjpBEmI(fM5160constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                        int i12 = i3 >> 9;
                        stateRadioColor = radioButtonColorsM1193colorsRGew2ao.radioColor(z4, z, composerStartRestartGroup, ((i3 << 3) & 112) | (i12 & 14) | (i12 & 896));
                        composerStartRestartGroup.startReplaceableGroup(1941632354);
                        if (interfaceC3588op != null) {
                            r12 = 0;
                            z5 = z4;
                            i8 = 2;
                            modifierM707selectableO2vRcR0 = SelectableKt.m707selectableO2vRcR0(Modifier.Companion, z, mutableInteractionSource4, RippleKt.m1318rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z5, Role.m4543boximpl(Role.Companion.m4554getRadioButtono7Vup1c()), interfaceC3588op);
                        } else {
                            i8 = 2;
                            r12 = 0;
                            z5 = z4;
                            modifierM707selectableO2vRcR0 = Modifier.Companion;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        if (interfaceC3588op != null) {
                            modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                        } else {
                            modifierMinimumInteractiveComponentSize = Modifier.Companion;
                        }
                        Modifier modifierM524requiredSize3ABfNKs2 = SizeKt.m524requiredSize3ABfNKs(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM707selectableO2vRcR0), Alignment.Companion.getCenter(), r12, i8, null), RadioButtonPadding), RadioButtonSize);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM84animateDpAsStateAjpBEmI);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CanvasKt.Canvas(modifierM524requiredSize3ABfNKs2, (InterfaceC3750qp) objRememberedValue2, composerStartRestartGroup, r12);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier4;
                        radioButtonColors3 = radioButtonColorsM1193colorsRGew2ao;
                        z6 = z5;
                        mutableInteractionSource5 = mutableInteractionSource4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        composerStartRestartGroup = composerStartRestartGroup;
                        z6 = z3;
                        mutableInteractionSource5 = mutableInteractionSource2;
                        radioButtonColors3 = radioButtonColors2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(z, interfaceC3588op, modifier2, z6, mutableInteractionSource5, radioButtonColors3, i, i2));
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        radioButtonColors2 = radioButtonColors;
                        if (composerStartRestartGroup.changed(radioButtonColors2)) {
                        }
                        i3 |= i10;
                    } else {
                        radioButtonColors2 = radioButtonColors;
                    }
                    i3 |= i10;
                } else {
                    radioButtonColors2 = radioButtonColors;
                }
                if ((374491 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier3;
                            radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier3;
                            radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier3;
                            radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier3;
                            radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1314435585, i3, -1, "androidx.compose.material.RadioButton (RadioButton.kt:73)");
                    }
                    if (z) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(RadioButtonDotSize / 2);
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    stateM84animateDpAsStateAjpBEmI = AnimateAsStateKt.m84animateDpAsStateAjpBEmI(fM5160constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                    int i13 = i3 >> 9;
                    stateRadioColor = radioButtonColorsM1193colorsRGew2ao.radioColor(z4, z, composerStartRestartGroup, ((i3 << 3) & 112) | (i13 & 14) | (i13 & 896));
                    composerStartRestartGroup.startReplaceableGroup(1941632354);
                    if (interfaceC3588op != null) {
                        r12 = 0;
                        z5 = z4;
                        i8 = 2;
                        modifierM707selectableO2vRcR0 = SelectableKt.m707selectableO2vRcR0(Modifier.Companion, z, mutableInteractionSource4, RippleKt.m1318rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z5, Role.m4543boximpl(Role.Companion.m4554getRadioButtono7Vup1c()), interfaceC3588op);
                    } else {
                        i8 = 2;
                        r12 = 0;
                        z5 = z4;
                        modifierM707selectableO2vRcR0 = Modifier.Companion;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC3588op != null) {
                        modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                    } else {
                        modifierMinimumInteractiveComponentSize = Modifier.Companion;
                    }
                    Modifier modifierM524requiredSize3ABfNKs3 = SizeKt.m524requiredSize3ABfNKs(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM707selectableO2vRcR0), Alignment.Companion.getCenter(), r12, i8, null), RadioButtonPadding), RadioButtonSize);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM84animateDpAsStateAjpBEmI);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CanvasKt.Canvas(modifierM524requiredSize3ABfNKs3, (InterfaceC3750qp) objRememberedValue2, composerStartRestartGroup, r12);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier4;
                    radioButtonColors3 = radioButtonColorsM1193colorsRGew2ao;
                    z6 = z5;
                    mutableInteractionSource5 = mutableInteractionSource4;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier3;
                            radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier3;
                            radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier3;
                            radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier3;
                            radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1314435585, i3, -1, "androidx.compose.material.RadioButton (RadioButton.kt:73)");
                    }
                    if (z) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(RadioButtonDotSize / 2);
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    stateM84animateDpAsStateAjpBEmI = AnimateAsStateKt.m84animateDpAsStateAjpBEmI(fM5160constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                    int i14 = i3 >> 9;
                    stateRadioColor = radioButtonColorsM1193colorsRGew2ao.radioColor(z4, z, composerStartRestartGroup, ((i3 << 3) & 112) | (i14 & 14) | (i14 & 896));
                    composerStartRestartGroup.startReplaceableGroup(1941632354);
                    if (interfaceC3588op != null) {
                        r12 = 0;
                        z5 = z4;
                        i8 = 2;
                        modifierM707selectableO2vRcR0 = SelectableKt.m707selectableO2vRcR0(Modifier.Companion, z, mutableInteractionSource4, RippleKt.m1318rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z5, Role.m4543boximpl(Role.Companion.m4554getRadioButtono7Vup1c()), interfaceC3588op);
                    } else {
                        i8 = 2;
                        r12 = 0;
                        z5 = z4;
                        modifierM707selectableO2vRcR0 = Modifier.Companion;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC3588op != null) {
                        modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                    } else {
                        modifierMinimumInteractiveComponentSize = Modifier.Companion;
                    }
                    Modifier modifierM524requiredSize3ABfNKs4 = SizeKt.m524requiredSize3ABfNKs(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM707selectableO2vRcR0), Alignment.Companion.getCenter(), r12, i8, null), RadioButtonPadding), RadioButtonSize);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM84animateDpAsStateAjpBEmI);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CanvasKt.Canvas(modifierM524requiredSize3ABfNKs4, (InterfaceC3750qp) objRememberedValue2, composerStartRestartGroup, r12);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier4;
                    radioButtonColors3 = radioButtonColorsM1193colorsRGew2ao;
                    z6 = z5;
                    mutableInteractionSource5 = mutableInteractionSource4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(z, interfaceC3588op, modifier2, z6, mutableInteractionSource5, radioButtonColors3, i, i2));
            }
            i3 |= 3072;
            z3 = z2;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((57344 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        radioButtonColors2 = radioButtonColors;
                        if (composerStartRestartGroup.changed(radioButtonColors2)) {
                        }
                        i3 |= i10;
                    } else {
                        radioButtonColors2 = radioButtonColors;
                    }
                    i3 |= i10;
                } else {
                    radioButtonColors2 = radioButtonColors;
                }
                if ((374491 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier3;
                            radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier3;
                            radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier3;
                            radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier3;
                            radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1314435585, i3, -1, "androidx.compose.material.RadioButton (RadioButton.kt:73)");
                    }
                    if (z) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(RadioButtonDotSize / 2);
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    stateM84animateDpAsStateAjpBEmI = AnimateAsStateKt.m84animateDpAsStateAjpBEmI(fM5160constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                    int i15 = i3 >> 9;
                    stateRadioColor = radioButtonColorsM1193colorsRGew2ao.radioColor(z4, z, composerStartRestartGroup, ((i3 << 3) & 112) | (i15 & 14) | (i15 & 896));
                    composerStartRestartGroup.startReplaceableGroup(1941632354);
                    if (interfaceC3588op != null) {
                        r12 = 0;
                        z5 = z4;
                        i8 = 2;
                        modifierM707selectableO2vRcR0 = SelectableKt.m707selectableO2vRcR0(Modifier.Companion, z, mutableInteractionSource4, RippleKt.m1318rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z5, Role.m4543boximpl(Role.Companion.m4554getRadioButtono7Vup1c()), interfaceC3588op);
                    } else {
                        i8 = 2;
                        r12 = 0;
                        z5 = z4;
                        modifierM707selectableO2vRcR0 = Modifier.Companion;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC3588op != null) {
                        modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                    } else {
                        modifierMinimumInteractiveComponentSize = Modifier.Companion;
                    }
                    Modifier modifierM524requiredSize3ABfNKs5 = SizeKt.m524requiredSize3ABfNKs(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM707selectableO2vRcR0), Alignment.Companion.getCenter(), r12, i8, null), RadioButtonPadding), RadioButtonSize);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM84animateDpAsStateAjpBEmI);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CanvasKt.Canvas(modifierM524requiredSize3ABfNKs5, (InterfaceC3750qp) objRememberedValue2, composerStartRestartGroup, r12);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier4;
                    radioButtonColors3 = radioButtonColorsM1193colorsRGew2ao;
                    z6 = z5;
                    mutableInteractionSource5 = mutableInteractionSource4;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier3;
                            radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier3;
                            radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier3;
                            radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier3;
                            radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1314435585, i3, -1, "androidx.compose.material.RadioButton (RadioButton.kt:73)");
                    }
                    if (z) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(RadioButtonDotSize / 2);
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    stateM84animateDpAsStateAjpBEmI = AnimateAsStateKt.m84animateDpAsStateAjpBEmI(fM5160constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                    int i16 = i3 >> 9;
                    stateRadioColor = radioButtonColorsM1193colorsRGew2ao.radioColor(z4, z, composerStartRestartGroup, ((i3 << 3) & 112) | (i16 & 14) | (i16 & 896));
                    composerStartRestartGroup.startReplaceableGroup(1941632354);
                    if (interfaceC3588op != null) {
                        r12 = 0;
                        z5 = z4;
                        i8 = 2;
                        modifierM707selectableO2vRcR0 = SelectableKt.m707selectableO2vRcR0(Modifier.Companion, z, mutableInteractionSource4, RippleKt.m1318rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z5, Role.m4543boximpl(Role.Companion.m4554getRadioButtono7Vup1c()), interfaceC3588op);
                    } else {
                        i8 = 2;
                        r12 = 0;
                        z5 = z4;
                        modifierM707selectableO2vRcR0 = Modifier.Companion;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC3588op != null) {
                        modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                    } else {
                        modifierMinimumInteractiveComponentSize = Modifier.Companion;
                    }
                    Modifier modifierM524requiredSize3ABfNKs6 = SizeKt.m524requiredSize3ABfNKs(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM707selectableO2vRcR0), Alignment.Companion.getCenter(), r12, i8, null), RadioButtonPadding), RadioButtonSize);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM84animateDpAsStateAjpBEmI);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CanvasKt.Canvas(modifierM524requiredSize3ABfNKs6, (InterfaceC3750qp) objRememberedValue2, composerStartRestartGroup, r12);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier4;
                    radioButtonColors3 = radioButtonColorsM1193colorsRGew2ao;
                    z6 = z5;
                    mutableInteractionSource5 = mutableInteractionSource4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(z, interfaceC3588op, modifier2, z6, mutableInteractionSource5, radioButtonColors3, i, i2));
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    radioButtonColors2 = radioButtonColors;
                    if (composerStartRestartGroup.changed(radioButtonColors2)) {
                    }
                    i3 |= i10;
                } else {
                    radioButtonColors2 = radioButtonColors;
                }
                i3 |= i10;
            } else {
                radioButtonColors2 = radioButtonColors;
            }
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier4 = modifier3;
                        radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier4 = modifier3;
                        radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                    }
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier4 = modifier3;
                        radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier4 = modifier3;
                        radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1314435585, i3, -1, "androidx.compose.material.RadioButton (RadioButton.kt:73)");
                }
                if (z) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(RadioButtonDotSize / 2);
                } else {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                stateM84animateDpAsStateAjpBEmI = AnimateAsStateKt.m84animateDpAsStateAjpBEmI(fM5160constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                int i17 = i3 >> 9;
                stateRadioColor = radioButtonColorsM1193colorsRGew2ao.radioColor(z4, z, composerStartRestartGroup, ((i3 << 3) & 112) | (i17 & 14) | (i17 & 896));
                composerStartRestartGroup.startReplaceableGroup(1941632354);
                if (interfaceC3588op != null) {
                    r12 = 0;
                    z5 = z4;
                    i8 = 2;
                    modifierM707selectableO2vRcR0 = SelectableKt.m707selectableO2vRcR0(Modifier.Companion, z, mutableInteractionSource4, RippleKt.m1318rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z5, Role.m4543boximpl(Role.Companion.m4554getRadioButtono7Vup1c()), interfaceC3588op);
                } else {
                    i8 = 2;
                    r12 = 0;
                    z5 = z4;
                    modifierM707selectableO2vRcR0 = Modifier.Companion;
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (interfaceC3588op != null) {
                    modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                } else {
                    modifierMinimumInteractiveComponentSize = Modifier.Companion;
                }
                Modifier modifierM524requiredSize3ABfNKs7 = SizeKt.m524requiredSize3ABfNKs(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM707selectableO2vRcR0), Alignment.Companion.getCenter(), r12, i8, null), RadioButtonPadding), RadioButtonSize);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM84animateDpAsStateAjpBEmI);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierM524requiredSize3ABfNKs7, (InterfaceC3750qp) objRememberedValue2, composerStartRestartGroup, r12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
                radioButtonColors3 = radioButtonColorsM1193colorsRGew2ao;
                z6 = z5;
                mutableInteractionSource5 = mutableInteractionSource4;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier4 = modifier3;
                        radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier4 = modifier3;
                        radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                    }
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier4 = modifier3;
                        radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier4 = modifier3;
                        radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1314435585, i3, -1, "androidx.compose.material.RadioButton (RadioButton.kt:73)");
                }
                if (z) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(RadioButtonDotSize / 2);
                } else {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                stateM84animateDpAsStateAjpBEmI = AnimateAsStateKt.m84animateDpAsStateAjpBEmI(fM5160constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                int i18 = i3 >> 9;
                stateRadioColor = radioButtonColorsM1193colorsRGew2ao.radioColor(z4, z, composerStartRestartGroup, ((i3 << 3) & 112) | (i18 & 14) | (i18 & 896));
                composerStartRestartGroup.startReplaceableGroup(1941632354);
                if (interfaceC3588op != null) {
                    r12 = 0;
                    z5 = z4;
                    i8 = 2;
                    modifierM707selectableO2vRcR0 = SelectableKt.m707selectableO2vRcR0(Modifier.Companion, z, mutableInteractionSource4, RippleKt.m1318rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z5, Role.m4543boximpl(Role.Companion.m4554getRadioButtono7Vup1c()), interfaceC3588op);
                } else {
                    i8 = 2;
                    r12 = 0;
                    z5 = z4;
                    modifierM707selectableO2vRcR0 = Modifier.Companion;
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (interfaceC3588op != null) {
                    modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                } else {
                    modifierMinimumInteractiveComponentSize = Modifier.Companion;
                }
                Modifier modifierM524requiredSize3ABfNKs8 = SizeKt.m524requiredSize3ABfNKs(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM707selectableO2vRcR0), Alignment.Companion.getCenter(), r12, i8, null), RadioButtonPadding), RadioButtonSize);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM84animateDpAsStateAjpBEmI);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierM524requiredSize3ABfNKs8, (InterfaceC3750qp) objRememberedValue2, composerStartRestartGroup, r12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
                radioButtonColors3 = radioButtonColorsM1193colorsRGew2ao;
                z6 = z5;
                mutableInteractionSource5 = mutableInteractionSource4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(z, interfaceC3588op, modifier2, z6, mutableInteractionSource5, radioButtonColors3, i, i2));
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((57344 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        radioButtonColors2 = radioButtonColors;
                        if (composerStartRestartGroup.changed(radioButtonColors2)) {
                        }
                        i3 |= i10;
                    } else {
                        radioButtonColors2 = radioButtonColors;
                    }
                    i3 |= i10;
                } else {
                    radioButtonColors2 = radioButtonColors;
                }
                if ((374491 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier3;
                            radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier3;
                            radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier3;
                            radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier3;
                            radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1314435585, i3, -1, "androidx.compose.material.RadioButton (RadioButton.kt:73)");
                    }
                    if (z) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(RadioButtonDotSize / 2);
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    stateM84animateDpAsStateAjpBEmI = AnimateAsStateKt.m84animateDpAsStateAjpBEmI(fM5160constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                    int i19 = i3 >> 9;
                    stateRadioColor = radioButtonColorsM1193colorsRGew2ao.radioColor(z4, z, composerStartRestartGroup, ((i3 << 3) & 112) | (i19 & 14) | (i19 & 896));
                    composerStartRestartGroup.startReplaceableGroup(1941632354);
                    if (interfaceC3588op != null) {
                        r12 = 0;
                        z5 = z4;
                        i8 = 2;
                        modifierM707selectableO2vRcR0 = SelectableKt.m707selectableO2vRcR0(Modifier.Companion, z, mutableInteractionSource4, RippleKt.m1318rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z5, Role.m4543boximpl(Role.Companion.m4554getRadioButtono7Vup1c()), interfaceC3588op);
                    } else {
                        i8 = 2;
                        r12 = 0;
                        z5 = z4;
                        modifierM707selectableO2vRcR0 = Modifier.Companion;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC3588op != null) {
                        modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                    } else {
                        modifierMinimumInteractiveComponentSize = Modifier.Companion;
                    }
                    Modifier modifierM524requiredSize3ABfNKs9 = SizeKt.m524requiredSize3ABfNKs(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM707selectableO2vRcR0), Alignment.Companion.getCenter(), r12, i8, null), RadioButtonPadding), RadioButtonSize);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM84animateDpAsStateAjpBEmI);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CanvasKt.Canvas(modifierM524requiredSize3ABfNKs9, (InterfaceC3750qp) objRememberedValue2, composerStartRestartGroup, r12);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier4;
                    radioButtonColors3 = radioButtonColorsM1193colorsRGew2ao;
                    z6 = z5;
                    mutableInteractionSource5 = mutableInteractionSource4;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier3;
                            radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier3;
                            radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier3;
                            radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier3;
                            radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1314435585, i3, -1, "androidx.compose.material.RadioButton (RadioButton.kt:73)");
                    }
                    if (z) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(RadioButtonDotSize / 2);
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    stateM84animateDpAsStateAjpBEmI = AnimateAsStateKt.m84animateDpAsStateAjpBEmI(fM5160constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                    int i110 = i3 >> 9;
                    stateRadioColor = radioButtonColorsM1193colorsRGew2ao.radioColor(z4, z, composerStartRestartGroup, ((i3 << 3) & 112) | (i110 & 14) | (i110 & 896));
                    composerStartRestartGroup.startReplaceableGroup(1941632354);
                    if (interfaceC3588op != null) {
                        r12 = 0;
                        z5 = z4;
                        i8 = 2;
                        modifierM707selectableO2vRcR0 = SelectableKt.m707selectableO2vRcR0(Modifier.Companion, z, mutableInteractionSource4, RippleKt.m1318rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z5, Role.m4543boximpl(Role.Companion.m4554getRadioButtono7Vup1c()), interfaceC3588op);
                    } else {
                        i8 = 2;
                        r12 = 0;
                        z5 = z4;
                        modifierM707selectableO2vRcR0 = Modifier.Companion;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC3588op != null) {
                        modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                    } else {
                        modifierMinimumInteractiveComponentSize = Modifier.Companion;
                    }
                    Modifier modifierM524requiredSize3ABfNKs10 = SizeKt.m524requiredSize3ABfNKs(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM707selectableO2vRcR0), Alignment.Companion.getCenter(), r12, i8, null), RadioButtonPadding), RadioButtonSize);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM84animateDpAsStateAjpBEmI);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CanvasKt.Canvas(modifierM524requiredSize3ABfNKs10, (InterfaceC3750qp) objRememberedValue2, composerStartRestartGroup, r12);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier4;
                    radioButtonColors3 = radioButtonColorsM1193colorsRGew2ao;
                    z6 = z5;
                    mutableInteractionSource5 = mutableInteractionSource4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(z, interfaceC3588op, modifier2, z6, mutableInteractionSource5, radioButtonColors3, i, i2));
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    radioButtonColors2 = radioButtonColors;
                    if (composerStartRestartGroup.changed(radioButtonColors2)) {
                    }
                    i3 |= i10;
                } else {
                    radioButtonColors2 = radioButtonColors;
                }
                i3 |= i10;
            } else {
                radioButtonColors2 = radioButtonColors;
            }
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier4 = modifier3;
                        radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier4 = modifier3;
                        radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                    }
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier4 = modifier3;
                        radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier4 = modifier3;
                        radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1314435585, i3, -1, "androidx.compose.material.RadioButton (RadioButton.kt:73)");
                }
                if (z) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(RadioButtonDotSize / 2);
                } else {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                stateM84animateDpAsStateAjpBEmI = AnimateAsStateKt.m84animateDpAsStateAjpBEmI(fM5160constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                int i111 = i3 >> 9;
                stateRadioColor = radioButtonColorsM1193colorsRGew2ao.radioColor(z4, z, composerStartRestartGroup, ((i3 << 3) & 112) | (i111 & 14) | (i111 & 896));
                composerStartRestartGroup.startReplaceableGroup(1941632354);
                if (interfaceC3588op != null) {
                    r12 = 0;
                    z5 = z4;
                    i8 = 2;
                    modifierM707selectableO2vRcR0 = SelectableKt.m707selectableO2vRcR0(Modifier.Companion, z, mutableInteractionSource4, RippleKt.m1318rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z5, Role.m4543boximpl(Role.Companion.m4554getRadioButtono7Vup1c()), interfaceC3588op);
                } else {
                    i8 = 2;
                    r12 = 0;
                    z5 = z4;
                    modifierM707selectableO2vRcR0 = Modifier.Companion;
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (interfaceC3588op != null) {
                    modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                } else {
                    modifierMinimumInteractiveComponentSize = Modifier.Companion;
                }
                Modifier modifierM524requiredSize3ABfNKs11 = SizeKt.m524requiredSize3ABfNKs(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM707selectableO2vRcR0), Alignment.Companion.getCenter(), r12, i8, null), RadioButtonPadding), RadioButtonSize);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM84animateDpAsStateAjpBEmI);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierM524requiredSize3ABfNKs11, (InterfaceC3750qp) objRememberedValue2, composerStartRestartGroup, r12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
                radioButtonColors3 = radioButtonColorsM1193colorsRGew2ao;
                z6 = z5;
                mutableInteractionSource5 = mutableInteractionSource4;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier4 = modifier3;
                        radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier4 = modifier3;
                        radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                    }
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier4 = modifier3;
                        radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier4 = modifier3;
                        radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1314435585, i3, -1, "androidx.compose.material.RadioButton (RadioButton.kt:73)");
                }
                if (z) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(RadioButtonDotSize / 2);
                } else {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                stateM84animateDpAsStateAjpBEmI = AnimateAsStateKt.m84animateDpAsStateAjpBEmI(fM5160constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                int i112 = i3 >> 9;
                stateRadioColor = radioButtonColorsM1193colorsRGew2ao.radioColor(z4, z, composerStartRestartGroup, ((i3 << 3) & 112) | (i112 & 14) | (i112 & 896));
                composerStartRestartGroup.startReplaceableGroup(1941632354);
                if (interfaceC3588op != null) {
                    r12 = 0;
                    z5 = z4;
                    i8 = 2;
                    modifierM707selectableO2vRcR0 = SelectableKt.m707selectableO2vRcR0(Modifier.Companion, z, mutableInteractionSource4, RippleKt.m1318rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z5, Role.m4543boximpl(Role.Companion.m4554getRadioButtono7Vup1c()), interfaceC3588op);
                } else {
                    i8 = 2;
                    r12 = 0;
                    z5 = z4;
                    modifierM707selectableO2vRcR0 = Modifier.Companion;
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (interfaceC3588op != null) {
                    modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                } else {
                    modifierMinimumInteractiveComponentSize = Modifier.Companion;
                }
                Modifier modifierM524requiredSize3ABfNKs12 = SizeKt.m524requiredSize3ABfNKs(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM707selectableO2vRcR0), Alignment.Companion.getCenter(), r12, i8, null), RadioButtonPadding), RadioButtonSize);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM84animateDpAsStateAjpBEmI);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierM524requiredSize3ABfNKs12, (InterfaceC3750qp) objRememberedValue2, composerStartRestartGroup, r12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
                radioButtonColors3 = radioButtonColorsM1193colorsRGew2ao;
                z6 = z5;
                mutableInteractionSource5 = mutableInteractionSource4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(z, interfaceC3588op, modifier2, z6, mutableInteractionSource5, radioButtonColors3, i, i2));
        }
        i3 |= 3072;
        z3 = z2;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((57344 & i) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    radioButtonColors2 = radioButtonColors;
                    if (composerStartRestartGroup.changed(radioButtonColors2)) {
                    }
                    i3 |= i10;
                } else {
                    radioButtonColors2 = radioButtonColors;
                }
                i3 |= i10;
            } else {
                radioButtonColors2 = radioButtonColors;
            }
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier4 = modifier3;
                        radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier4 = modifier3;
                        radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                    }
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier4 = modifier3;
                        radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier4 = modifier3;
                        radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1314435585, i3, -1, "androidx.compose.material.RadioButton (RadioButton.kt:73)");
                }
                if (z) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(RadioButtonDotSize / 2);
                } else {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                stateM84animateDpAsStateAjpBEmI = AnimateAsStateKt.m84animateDpAsStateAjpBEmI(fM5160constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                int i113 = i3 >> 9;
                stateRadioColor = radioButtonColorsM1193colorsRGew2ao.radioColor(z4, z, composerStartRestartGroup, ((i3 << 3) & 112) | (i113 & 14) | (i113 & 896));
                composerStartRestartGroup.startReplaceableGroup(1941632354);
                if (interfaceC3588op != null) {
                    r12 = 0;
                    z5 = z4;
                    i8 = 2;
                    modifierM707selectableO2vRcR0 = SelectableKt.m707selectableO2vRcR0(Modifier.Companion, z, mutableInteractionSource4, RippleKt.m1318rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z5, Role.m4543boximpl(Role.Companion.m4554getRadioButtono7Vup1c()), interfaceC3588op);
                } else {
                    i8 = 2;
                    r12 = 0;
                    z5 = z4;
                    modifierM707selectableO2vRcR0 = Modifier.Companion;
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (interfaceC3588op != null) {
                    modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                } else {
                    modifierMinimumInteractiveComponentSize = Modifier.Companion;
                }
                Modifier modifierM524requiredSize3ABfNKs13 = SizeKt.m524requiredSize3ABfNKs(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM707selectableO2vRcR0), Alignment.Companion.getCenter(), r12, i8, null), RadioButtonPadding), RadioButtonSize);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM84animateDpAsStateAjpBEmI);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierM524requiredSize3ABfNKs13, (InterfaceC3750qp) objRememberedValue2, composerStartRestartGroup, r12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
                radioButtonColors3 = radioButtonColorsM1193colorsRGew2ao;
                z6 = z5;
                mutableInteractionSource5 = mutableInteractionSource4;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier4 = modifier3;
                        radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier4 = modifier3;
                        radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                    }
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier4 = modifier3;
                        radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier4 = modifier3;
                        radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1314435585, i3, -1, "androidx.compose.material.RadioButton (RadioButton.kt:73)");
                }
                if (z) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(RadioButtonDotSize / 2);
                } else {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                stateM84animateDpAsStateAjpBEmI = AnimateAsStateKt.m84animateDpAsStateAjpBEmI(fM5160constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                int i114 = i3 >> 9;
                stateRadioColor = radioButtonColorsM1193colorsRGew2ao.radioColor(z4, z, composerStartRestartGroup, ((i3 << 3) & 112) | (i114 & 14) | (i114 & 896));
                composerStartRestartGroup.startReplaceableGroup(1941632354);
                if (interfaceC3588op != null) {
                    r12 = 0;
                    z5 = z4;
                    i8 = 2;
                    modifierM707selectableO2vRcR0 = SelectableKt.m707selectableO2vRcR0(Modifier.Companion, z, mutableInteractionSource4, RippleKt.m1318rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z5, Role.m4543boximpl(Role.Companion.m4554getRadioButtono7Vup1c()), interfaceC3588op);
                } else {
                    i8 = 2;
                    r12 = 0;
                    z5 = z4;
                    modifierM707selectableO2vRcR0 = Modifier.Companion;
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (interfaceC3588op != null) {
                    modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                } else {
                    modifierMinimumInteractiveComponentSize = Modifier.Companion;
                }
                Modifier modifierM524requiredSize3ABfNKs14 = SizeKt.m524requiredSize3ABfNKs(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM707selectableO2vRcR0), Alignment.Companion.getCenter(), r12, i8, null), RadioButtonPadding), RadioButtonSize);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM84animateDpAsStateAjpBEmI);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierM524requiredSize3ABfNKs14, (InterfaceC3750qp) objRememberedValue2, composerStartRestartGroup, r12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
                radioButtonColors3 = radioButtonColorsM1193colorsRGew2ao;
                z6 = z5;
                mutableInteractionSource5 = mutableInteractionSource4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(z, interfaceC3588op, modifier2, z6, mutableInteractionSource5, radioButtonColors3, i, i2));
        }
        i3 |= 24576;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((458752 & i) == 0) {
            if ((i2 & 32) == 0) {
                radioButtonColors2 = radioButtonColors;
                if (composerStartRestartGroup.changed(radioButtonColors2)) {
                }
                i3 |= i10;
            } else {
                radioButtonColors2 = radioButtonColors;
            }
            i3 |= i10;
        } else {
            radioButtonColors2 = radioButtonColors;
        }
        if ((374491 & i3) == 74898) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z4 = true;
                } else {
                    z4 = z3;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    modifier4 = modifier3;
                    radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                } else {
                    mutableInteractionSource4 = mutableInteractionSource3;
                    modifier4 = modifier3;
                    radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                }
            } else {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z4 = true;
                } else {
                    z4 = z3;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    modifier4 = modifier3;
                    radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                } else {
                    mutableInteractionSource4 = mutableInteractionSource3;
                    modifier4 = modifier3;
                    radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1314435585, i3, -1, "androidx.compose.material.RadioButton (RadioButton.kt:73)");
            }
            if (z) {
                fM5160constructorimpl = Dp.m5160constructorimpl(RadioButtonDotSize / 2);
            } else {
                fM5160constructorimpl = Dp.m5160constructorimpl(0);
            }
            stateM84animateDpAsStateAjpBEmI = AnimateAsStateKt.m84animateDpAsStateAjpBEmI(fM5160constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
            int i115 = i3 >> 9;
            stateRadioColor = radioButtonColorsM1193colorsRGew2ao.radioColor(z4, z, composerStartRestartGroup, ((i3 << 3) & 112) | (i115 & 14) | (i115 & 896));
            composerStartRestartGroup.startReplaceableGroup(1941632354);
            if (interfaceC3588op != null) {
                r12 = 0;
                z5 = z4;
                i8 = 2;
                modifierM707selectableO2vRcR0 = SelectableKt.m707selectableO2vRcR0(Modifier.Companion, z, mutableInteractionSource4, RippleKt.m1318rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z5, Role.m4543boximpl(Role.Companion.m4554getRadioButtono7Vup1c()), interfaceC3588op);
            } else {
                i8 = 2;
                r12 = 0;
                z5 = z4;
                modifierM707selectableO2vRcR0 = Modifier.Companion;
            }
            composerStartRestartGroup.endReplaceableGroup();
            if (interfaceC3588op != null) {
                modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
            } else {
                modifierMinimumInteractiveComponentSize = Modifier.Companion;
            }
            Modifier modifierM524requiredSize3ABfNKs15 = SizeKt.m524requiredSize3ABfNKs(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM707selectableO2vRcR0), Alignment.Companion.getCenter(), r12, i8, null), RadioButtonPadding), RadioButtonSize);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM84animateDpAsStateAjpBEmI);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(modifierM524requiredSize3ABfNKs15, (InterfaceC3750qp) objRememberedValue2, composerStartRestartGroup, r12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
            radioButtonColors3 = radioButtonColorsM1193colorsRGew2ao;
            z6 = z5;
            mutableInteractionSource5 = mutableInteractionSource4;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z4 = true;
                } else {
                    z4 = z3;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    modifier4 = modifier3;
                    radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                } else {
                    mutableInteractionSource4 = mutableInteractionSource3;
                    modifier4 = modifier3;
                    radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                }
            } else {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z4 = true;
                } else {
                    z4 = z3;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    modifier4 = modifier3;
                    radioButtonColorsM1193colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1193colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                } else {
                    mutableInteractionSource4 = mutableInteractionSource3;
                    modifier4 = modifier3;
                    radioButtonColorsM1193colorsRGew2ao = radioButtonColors2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1314435585, i3, -1, "androidx.compose.material.RadioButton (RadioButton.kt:73)");
            }
            if (z) {
                fM5160constructorimpl = Dp.m5160constructorimpl(RadioButtonDotSize / 2);
            } else {
                fM5160constructorimpl = Dp.m5160constructorimpl(0);
            }
            stateM84animateDpAsStateAjpBEmI = AnimateAsStateKt.m84animateDpAsStateAjpBEmI(fM5160constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
            int i116 = i3 >> 9;
            stateRadioColor = radioButtonColorsM1193colorsRGew2ao.radioColor(z4, z, composerStartRestartGroup, ((i3 << 3) & 112) | (i116 & 14) | (i116 & 896));
            composerStartRestartGroup.startReplaceableGroup(1941632354);
            if (interfaceC3588op != null) {
                r12 = 0;
                z5 = z4;
                i8 = 2;
                modifierM707selectableO2vRcR0 = SelectableKt.m707selectableO2vRcR0(Modifier.Companion, z, mutableInteractionSource4, RippleKt.m1318rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z5, Role.m4543boximpl(Role.Companion.m4554getRadioButtono7Vup1c()), interfaceC3588op);
            } else {
                i8 = 2;
                r12 = 0;
                z5 = z4;
                modifierM707selectableO2vRcR0 = Modifier.Companion;
            }
            composerStartRestartGroup.endReplaceableGroup();
            if (interfaceC3588op != null) {
                modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
            } else {
                modifierMinimumInteractiveComponentSize = Modifier.Companion;
            }
            Modifier modifierM524requiredSize3ABfNKs16 = SizeKt.m524requiredSize3ABfNKs(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM707selectableO2vRcR0), Alignment.Companion.getCenter(), r12, i8, null), RadioButtonPadding), RadioButtonSize);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM84animateDpAsStateAjpBEmI);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor, stateM84animateDpAsStateAjpBEmI);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(modifierM524requiredSize3ABfNKs16, (InterfaceC3750qp) objRememberedValue2, composerStartRestartGroup, r12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
            radioButtonColors3 = radioButtonColorsM1193colorsRGew2ao;
            z6 = z5;
            mutableInteractionSource5 = mutableInteractionSource4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(z, interfaceC3588op, modifier2, z6, mutableInteractionSource5, radioButtonColors3, i, i2));
    }
}
