package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.RadioButtonTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
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
import androidx.profileinstaller.ProfileVerifier;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class RadioButtonKt {
    private static final int RadioAnimationDuration = 100;
    private static final float RadioButtonDotSize = Dp.m5160constructorimpl(12);
    private static final float RadioButtonPadding;
    private static final float RadioStrokeWidth;

    /* JADX INFO: renamed from: androidx.compose.material3.RadioButtonKt$RadioButton$3, reason: invalid class name */
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
        public AnonymousClass3(boolean z, InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z2, RadioButtonColors radioButtonColors, MutableInteractionSource mutableInteractionSource, int i, int i2) {
            super(2);
            this.$selected = z;
            this.$onClick = interfaceC3588op;
            this.$modifier = modifier;
            this.$enabled = z2;
            this.$colors = radioButtonColors;
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
            RadioButtonKt.RadioButton(this.$selected, this.$onClick, this.$modifier, this.$enabled, this.$colors, this.$interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    static {
        float f = 2;
        RadioButtonPadding = Dp.m5160constructorimpl(f);
        RadioStrokeWidth = Dp.m5160constructorimpl(f);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x014b  */
    /* JADX WARN: Code duplicated, block: B:103:0x0154  */
    /* JADX WARN: Code duplicated, block: B:106:0x018c  */
    /* JADX WARN: Code duplicated, block: B:107:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:110:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:111:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:114:0x0220  */
    /* JADX WARN: Code duplicated, block: B:116:0x0228  */
    /* JADX WARN: Code duplicated, block: B:119:0x023e  */
    /* JADX WARN: Code duplicated, block: B:124:0x024d  */
    /* JADX WARN: Code duplicated, block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x005d  */
    /* JADX WARN: Code duplicated, block: B:38:0x0062  */
    /* JADX WARN: Code duplicated, block: B:40:0x0066  */
    /* JADX WARN: Code duplicated, block: B:42:0x006e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0071  */
    /* JADX WARN: Code duplicated, block: B:47:0x007a  */
    /* JADX WARN: Code duplicated, block: B:49:0x007e  */
    /* JADX WARN: Code duplicated, block: B:51:0x0086  */
    /* JADX WARN: Code duplicated, block: B:52:0x0089  */
    /* JADX WARN: Code duplicated, block: B:55:0x008f  */
    /* JADX WARN: Code duplicated, block: B:58:0x0095  */
    /* JADX WARN: Code duplicated, block: B:59:0x009b  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:63:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:91:0x0113  */
    /* JADX WARN: Code duplicated, block: B:93:0x0125  */
    /* JADX WARN: Code duplicated, block: B:96:0x0136  */
    /* JADX WARN: Code duplicated, block: B:99:0x0142  */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v13 */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void RadioButton(boolean z, InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z2, RadioButtonColors radioButtonColors, MutableInteractionSource mutableInteractionSource, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        RadioButtonColors radioButtonColorsM1720colorsro_MJ88;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        Modifier modifier3;
        boolean z4;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier4;
        RadioButtonColors radioButtonColors2;
        Object objRememberedValue;
        float fM5160constructorimpl;
        State<Dp> stateM84animateDpAsStateAjpBEmI;
        State<Color> stateRadioColor$material3_release;
        int i8;
        ?? r12;
        boolean z5;
        Modifier modifierM707selectableO2vRcR0;
        Modifier modifierMinimumInteractiveComponentSize;
        boolean zChanged;
        Object objRememberedValue2;
        RadioButtonColors radioButtonColors3;
        boolean z6;
        MutableInteractionSource mutableInteractionSource4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(408580840);
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
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        radioButtonColorsM1720colorsro_MJ88 = radioButtonColors;
                        int i10 = composerStartRestartGroup.changed(radioButtonColorsM1720colorsro_MJ88) ? 16384 : 8192;
                        i3 |= i10;
                    } else {
                        radioButtonColorsM1720colorsro_MJ88 = radioButtonColors;
                    }
                    i3 |= i10;
                } else {
                    radioButtonColorsM1720colorsro_MJ88 = radioButtonColors;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    mutableInteractionSource2 = mutableInteractionSource;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
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
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            radioButtonColorsM1720colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m1720colorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
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
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier4 = modifier3;
                        radioButtonColors2 = radioButtonColorsM1720colorsro_MJ88;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        modifier4 = modifier2;
                        z4 = z3;
                        radioButtonColors2 = radioButtonColorsM1720colorsro_MJ88;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(408580840, i3, -1, "androidx.compose.material3.RadioButton (RadioButton.kt:72)");
                    }
                    if (z) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(RadioButtonDotSize / 2);
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    stateM84animateDpAsStateAjpBEmI = AnimateAsStateKt.m84animateDpAsStateAjpBEmI(fM5160constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                    stateRadioColor$material3_release = radioButtonColors2.radioColor$material3_release(z4, z, composerStartRestartGroup, ((i3 >> 6) & 896) | ((i3 >> 9) & 14) | ((i3 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(735546407);
                    if (interfaceC3588op != null) {
                        r12 = 0;
                        z5 = z4;
                        i8 = 2;
                        modifierM707selectableO2vRcR0 = SelectableKt.m707selectableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, Dp.m5160constructorimpl(RadioButtonTokens.INSTANCE.m2488getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4), z5, Role.m4543boximpl(Role.Companion.m4554getRadioButtono7Vup1c()), interfaceC3588op);
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
                    Modifier modifierM524requiredSize3ABfNKs = SizeKt.m524requiredSize3ABfNKs(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM707selectableO2vRcR0), Alignment.Companion.getCenter(), r12, i8, null), RadioButtonPadding), RadioButtonTokens.INSTANCE.m2487getIconSizeD9Ej5fM());
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(stateRadioColor$material3_release) | composerStartRestartGroup.changed(stateM84animateDpAsStateAjpBEmI);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor$material3_release, stateM84animateDpAsStateAjpBEmI);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CanvasKt.Canvas(modifierM524requiredSize3ABfNKs, (InterfaceC3750qp) objRememberedValue2, composerStartRestartGroup, r12);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier4;
                    radioButtonColors3 = radioButtonColors2;
                    z6 = z5;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z6 = z3;
                    radioButtonColors3 = radioButtonColorsM1720colorsro_MJ88;
                    composerStartRestartGroup = composerStartRestartGroup;
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(z, interfaceC3588op, modifier2, z6, radioButtonColors3, mutableInteractionSource4, i, i2));
            }
            i3 |= 3072;
            z3 = z2;
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    radioButtonColorsM1720colorsro_MJ88 = radioButtonColors;
                    if (composerStartRestartGroup.changed(radioButtonColorsM1720colorsro_MJ88)) {
                    }
                    i3 |= i10;
                } else {
                    radioButtonColorsM1720colorsro_MJ88 = radioButtonColors;
                }
                i3 |= i10;
            } else {
                radioButtonColorsM1720colorsro_MJ88 = radioButtonColors;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                mutableInteractionSource2 = mutableInteractionSource;
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
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
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        radioButtonColorsM1720colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m1720colorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
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
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier4 = modifier3;
                    radioButtonColors2 = radioButtonColorsM1720colorsro_MJ88;
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
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        radioButtonColorsM1720colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m1720colorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
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
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier4 = modifier3;
                    radioButtonColors2 = radioButtonColorsM1720colorsro_MJ88;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(408580840, i3, -1, "androidx.compose.material3.RadioButton (RadioButton.kt:72)");
                }
                if (z) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(RadioButtonDotSize / 2);
                } else {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                stateM84animateDpAsStateAjpBEmI = AnimateAsStateKt.m84animateDpAsStateAjpBEmI(fM5160constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                stateRadioColor$material3_release = radioButtonColors2.radioColor$material3_release(z4, z, composerStartRestartGroup, ((i3 >> 6) & 896) | ((i3 >> 9) & 14) | ((i3 << 3) & 112));
                composerStartRestartGroup.startReplaceableGroup(735546407);
                if (interfaceC3588op != null) {
                    r12 = 0;
                    z5 = z4;
                    i8 = 2;
                    modifierM707selectableO2vRcR0 = SelectableKt.m707selectableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, Dp.m5160constructorimpl(RadioButtonTokens.INSTANCE.m2488getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4), z5, Role.m4543boximpl(Role.Companion.m4554getRadioButtono7Vup1c()), interfaceC3588op);
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
                Modifier modifierM524requiredSize3ABfNKs2 = SizeKt.m524requiredSize3ABfNKs(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM707selectableO2vRcR0), Alignment.Companion.getCenter(), r12, i8, null), RadioButtonPadding), RadioButtonTokens.INSTANCE.m2487getIconSizeD9Ej5fM());
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(stateRadioColor$material3_release) | composerStartRestartGroup.changed(stateM84animateDpAsStateAjpBEmI);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor$material3_release, stateM84animateDpAsStateAjpBEmI);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor$material3_release, stateM84animateDpAsStateAjpBEmI);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierM524requiredSize3ABfNKs2, (InterfaceC3750qp) objRememberedValue2, composerStartRestartGroup, r12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
                radioButtonColors3 = radioButtonColors2;
                z6 = z5;
                mutableInteractionSource4 = mutableInteractionSource3;
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
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        radioButtonColorsM1720colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m1720colorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
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
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier4 = modifier3;
                    radioButtonColors2 = radioButtonColorsM1720colorsro_MJ88;
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
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        radioButtonColorsM1720colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m1720colorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
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
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier4 = modifier3;
                    radioButtonColors2 = radioButtonColorsM1720colorsro_MJ88;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(408580840, i3, -1, "androidx.compose.material3.RadioButton (RadioButton.kt:72)");
                }
                if (z) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(RadioButtonDotSize / 2);
                } else {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                stateM84animateDpAsStateAjpBEmI = AnimateAsStateKt.m84animateDpAsStateAjpBEmI(fM5160constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                stateRadioColor$material3_release = radioButtonColors2.radioColor$material3_release(z4, z, composerStartRestartGroup, ((i3 >> 6) & 896) | ((i3 >> 9) & 14) | ((i3 << 3) & 112));
                composerStartRestartGroup.startReplaceableGroup(735546407);
                if (interfaceC3588op != null) {
                    r12 = 0;
                    z5 = z4;
                    i8 = 2;
                    modifierM707selectableO2vRcR0 = SelectableKt.m707selectableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, Dp.m5160constructorimpl(RadioButtonTokens.INSTANCE.m2488getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4), z5, Role.m4543boximpl(Role.Companion.m4554getRadioButtono7Vup1c()), interfaceC3588op);
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
                Modifier modifierM524requiredSize3ABfNKs3 = SizeKt.m524requiredSize3ABfNKs(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM707selectableO2vRcR0), Alignment.Companion.getCenter(), r12, i8, null), RadioButtonPadding), RadioButtonTokens.INSTANCE.m2487getIconSizeD9Ej5fM());
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(stateRadioColor$material3_release) | composerStartRestartGroup.changed(stateM84animateDpAsStateAjpBEmI);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor$material3_release, stateM84animateDpAsStateAjpBEmI);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor$material3_release, stateM84animateDpAsStateAjpBEmI);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierM524requiredSize3ABfNKs3, (InterfaceC3750qp) objRememberedValue2, composerStartRestartGroup, r12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
                radioButtonColors3 = radioButtonColors2;
                z6 = z5;
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(z, interfaceC3588op, modifier2, z6, radioButtonColors3, mutableInteractionSource4, i, i2));
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
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    radioButtonColorsM1720colorsro_MJ88 = radioButtonColors;
                    if (composerStartRestartGroup.changed(radioButtonColorsM1720colorsro_MJ88)) {
                    }
                    i3 |= i10;
                } else {
                    radioButtonColorsM1720colorsro_MJ88 = radioButtonColors;
                }
                i3 |= i10;
            } else {
                radioButtonColorsM1720colorsro_MJ88 = radioButtonColors;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                mutableInteractionSource2 = mutableInteractionSource;
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
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
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        radioButtonColorsM1720colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m1720colorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
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
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier4 = modifier3;
                    radioButtonColors2 = radioButtonColorsM1720colorsro_MJ88;
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
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        radioButtonColorsM1720colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m1720colorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
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
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier4 = modifier3;
                    radioButtonColors2 = radioButtonColorsM1720colorsro_MJ88;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(408580840, i3, -1, "androidx.compose.material3.RadioButton (RadioButton.kt:72)");
                }
                if (z) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(RadioButtonDotSize / 2);
                } else {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                stateM84animateDpAsStateAjpBEmI = AnimateAsStateKt.m84animateDpAsStateAjpBEmI(fM5160constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                stateRadioColor$material3_release = radioButtonColors2.radioColor$material3_release(z4, z, composerStartRestartGroup, ((i3 >> 6) & 896) | ((i3 >> 9) & 14) | ((i3 << 3) & 112));
                composerStartRestartGroup.startReplaceableGroup(735546407);
                if (interfaceC3588op != null) {
                    r12 = 0;
                    z5 = z4;
                    i8 = 2;
                    modifierM707selectableO2vRcR0 = SelectableKt.m707selectableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, Dp.m5160constructorimpl(RadioButtonTokens.INSTANCE.m2488getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4), z5, Role.m4543boximpl(Role.Companion.m4554getRadioButtono7Vup1c()), interfaceC3588op);
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
                Modifier modifierM524requiredSize3ABfNKs4 = SizeKt.m524requiredSize3ABfNKs(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM707selectableO2vRcR0), Alignment.Companion.getCenter(), r12, i8, null), RadioButtonPadding), RadioButtonTokens.INSTANCE.m2487getIconSizeD9Ej5fM());
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(stateRadioColor$material3_release) | composerStartRestartGroup.changed(stateM84animateDpAsStateAjpBEmI);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor$material3_release, stateM84animateDpAsStateAjpBEmI);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor$material3_release, stateM84animateDpAsStateAjpBEmI);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierM524requiredSize3ABfNKs4, (InterfaceC3750qp) objRememberedValue2, composerStartRestartGroup, r12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
                radioButtonColors3 = radioButtonColors2;
                z6 = z5;
                mutableInteractionSource4 = mutableInteractionSource3;
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
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        radioButtonColorsM1720colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m1720colorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
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
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier4 = modifier3;
                    radioButtonColors2 = radioButtonColorsM1720colorsro_MJ88;
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
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        radioButtonColorsM1720colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m1720colorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
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
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier4 = modifier3;
                    radioButtonColors2 = radioButtonColorsM1720colorsro_MJ88;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(408580840, i3, -1, "androidx.compose.material3.RadioButton (RadioButton.kt:72)");
                }
                if (z) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(RadioButtonDotSize / 2);
                } else {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                stateM84animateDpAsStateAjpBEmI = AnimateAsStateKt.m84animateDpAsStateAjpBEmI(fM5160constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                stateRadioColor$material3_release = radioButtonColors2.radioColor$material3_release(z4, z, composerStartRestartGroup, ((i3 >> 6) & 896) | ((i3 >> 9) & 14) | ((i3 << 3) & 112));
                composerStartRestartGroup.startReplaceableGroup(735546407);
                if (interfaceC3588op != null) {
                    r12 = 0;
                    z5 = z4;
                    i8 = 2;
                    modifierM707selectableO2vRcR0 = SelectableKt.m707selectableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, Dp.m5160constructorimpl(RadioButtonTokens.INSTANCE.m2488getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4), z5, Role.m4543boximpl(Role.Companion.m4554getRadioButtono7Vup1c()), interfaceC3588op);
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
                Modifier modifierM524requiredSize3ABfNKs5 = SizeKt.m524requiredSize3ABfNKs(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM707selectableO2vRcR0), Alignment.Companion.getCenter(), r12, i8, null), RadioButtonPadding), RadioButtonTokens.INSTANCE.m2487getIconSizeD9Ej5fM());
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(stateRadioColor$material3_release) | composerStartRestartGroup.changed(stateM84animateDpAsStateAjpBEmI);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor$material3_release, stateM84animateDpAsStateAjpBEmI);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor$material3_release, stateM84animateDpAsStateAjpBEmI);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierM524requiredSize3ABfNKs5, (InterfaceC3750qp) objRememberedValue2, composerStartRestartGroup, r12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
                radioButtonColors3 = radioButtonColors2;
                z6 = z5;
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(z, interfaceC3588op, modifier2, z6, radioButtonColors3, mutableInteractionSource4, i, i2));
        }
        i3 |= 3072;
        z3 = z2;
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                radioButtonColorsM1720colorsro_MJ88 = radioButtonColors;
                if (composerStartRestartGroup.changed(radioButtonColorsM1720colorsro_MJ88)) {
                }
                i3 |= i10;
            } else {
                radioButtonColorsM1720colorsro_MJ88 = radioButtonColors;
            }
            i3 |= i10;
        } else {
            radioButtonColorsM1720colorsro_MJ88 = radioButtonColors;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            mutableInteractionSource2 = mutableInteractionSource;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
            if ((458752 & i) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
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
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    radioButtonColorsM1720colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m1720colorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
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
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                modifier4 = modifier3;
                radioButtonColors2 = radioButtonColorsM1720colorsro_MJ88;
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
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    radioButtonColorsM1720colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m1720colorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
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
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                modifier4 = modifier3;
                radioButtonColors2 = radioButtonColorsM1720colorsro_MJ88;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(408580840, i3, -1, "androidx.compose.material3.RadioButton (RadioButton.kt:72)");
            }
            if (z) {
                fM5160constructorimpl = Dp.m5160constructorimpl(RadioButtonDotSize / 2);
            } else {
                fM5160constructorimpl = Dp.m5160constructorimpl(0);
            }
            stateM84animateDpAsStateAjpBEmI = AnimateAsStateKt.m84animateDpAsStateAjpBEmI(fM5160constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
            stateRadioColor$material3_release = radioButtonColors2.radioColor$material3_release(z4, z, composerStartRestartGroup, ((i3 >> 6) & 896) | ((i3 >> 9) & 14) | ((i3 << 3) & 112));
            composerStartRestartGroup.startReplaceableGroup(735546407);
            if (interfaceC3588op != null) {
                r12 = 0;
                z5 = z4;
                i8 = 2;
                modifierM707selectableO2vRcR0 = SelectableKt.m707selectableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, Dp.m5160constructorimpl(RadioButtonTokens.INSTANCE.m2488getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4), z5, Role.m4543boximpl(Role.Companion.m4554getRadioButtono7Vup1c()), interfaceC3588op);
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
            Modifier modifierM524requiredSize3ABfNKs6 = SizeKt.m524requiredSize3ABfNKs(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM707selectableO2vRcR0), Alignment.Companion.getCenter(), r12, i8, null), RadioButtonPadding), RadioButtonTokens.INSTANCE.m2487getIconSizeD9Ej5fM());
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged = composerStartRestartGroup.changed(stateRadioColor$material3_release) | composerStartRestartGroup.changed(stateM84animateDpAsStateAjpBEmI);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor$material3_release, stateM84animateDpAsStateAjpBEmI);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor$material3_release, stateM84animateDpAsStateAjpBEmI);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(modifierM524requiredSize3ABfNKs6, (InterfaceC3750qp) objRememberedValue2, composerStartRestartGroup, r12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
            radioButtonColors3 = radioButtonColors2;
            z6 = z5;
            mutableInteractionSource4 = mutableInteractionSource3;
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
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    radioButtonColorsM1720colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m1720colorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
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
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                modifier4 = modifier3;
                radioButtonColors2 = radioButtonColorsM1720colorsro_MJ88;
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
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    radioButtonColorsM1720colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m1720colorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
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
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                modifier4 = modifier3;
                radioButtonColors2 = radioButtonColorsM1720colorsro_MJ88;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(408580840, i3, -1, "androidx.compose.material3.RadioButton (RadioButton.kt:72)");
            }
            if (z) {
                fM5160constructorimpl = Dp.m5160constructorimpl(RadioButtonDotSize / 2);
            } else {
                fM5160constructorimpl = Dp.m5160constructorimpl(0);
            }
            stateM84animateDpAsStateAjpBEmI = AnimateAsStateKt.m84animateDpAsStateAjpBEmI(fM5160constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
            stateRadioColor$material3_release = radioButtonColors2.radioColor$material3_release(z4, z, composerStartRestartGroup, ((i3 >> 6) & 896) | ((i3 >> 9) & 14) | ((i3 << 3) & 112));
            composerStartRestartGroup.startReplaceableGroup(735546407);
            if (interfaceC3588op != null) {
                r12 = 0;
                z5 = z4;
                i8 = 2;
                modifierM707selectableO2vRcR0 = SelectableKt.m707selectableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, Dp.m5160constructorimpl(RadioButtonTokens.INSTANCE.m2488getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4), z5, Role.m4543boximpl(Role.Companion.m4554getRadioButtono7Vup1c()), interfaceC3588op);
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
            Modifier modifierM524requiredSize3ABfNKs7 = SizeKt.m524requiredSize3ABfNKs(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM707selectableO2vRcR0), Alignment.Companion.getCenter(), r12, i8, null), RadioButtonPadding), RadioButtonTokens.INSTANCE.m2487getIconSizeD9Ej5fM());
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged = composerStartRestartGroup.changed(stateRadioColor$material3_release) | composerStartRestartGroup.changed(stateM84animateDpAsStateAjpBEmI);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor$material3_release, stateM84animateDpAsStateAjpBEmI);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new RadioButtonKt$RadioButton$2$1(stateRadioColor$material3_release, stateM84animateDpAsStateAjpBEmI);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(modifierM524requiredSize3ABfNKs7, (InterfaceC3750qp) objRememberedValue2, composerStartRestartGroup, r12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
            radioButtonColors3 = radioButtonColors2;
            z6 = z5;
            mutableInteractionSource4 = mutableInteractionSource3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(z, interfaceC3588op, modifier2, z6, radioButtonColors3, mutableInteractionSource4, i, i2));
    }
}
