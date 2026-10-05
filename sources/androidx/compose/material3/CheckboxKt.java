package androidx.compose.material3;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.CheckboxTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.state.ToggleableStateKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Jpeg;
import defpackage.AD;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3255kk;
import defpackage.AbstractC4492zt;
import defpackage.C0774Nm;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class CheckboxKt {
    private static final int BoxInDuration = 50;
    private static final int BoxOutDuration = 100;
    private static final int CheckAnimationDuration = 100;
    private static final float CheckboxDefaultPadding;
    private static final float CheckboxSize = Dp.m5160constructorimpl(20);
    private static final float RadiusSize;
    private static final float StrokeWidth;

    /* JADX INFO: renamed from: androidx.compose.material3.CheckboxKt$Checkbox$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ boolean $checked;
        final /* synthetic */ CheckboxColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3750qp $onCheckedChange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(boolean z, InterfaceC3750qp interfaceC3750qp, Modifier modifier, boolean z2, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, int i, int i2) {
            super(2);
            this.$checked = z;
            this.$onCheckedChange = interfaceC3750qp;
            this.$modifier = modifier;
            this.$enabled = z2;
            this.$colors = checkboxColors;
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
            CheckboxKt.Checkbox(this.$checked, this.$onCheckedChange, this.$modifier, this.$enabled, this.$colors, this.$interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.CheckboxKt$CheckboxImpl$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ CheckboxColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ ToggleableState $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(boolean z, ToggleableState toggleableState, Modifier modifier, CheckboxColors checkboxColors, int i) {
            super(2);
            this.$enabled = z;
            this.$value = toggleableState;
            this.$modifier = modifier;
            this.$colors = checkboxColors;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            CheckboxKt.CheckboxImpl(this.$enabled, this.$value, this.$modifier, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.CheckboxKt$TriStateCheckbox$2, reason: invalid class name and case insensitive filesystem */
    public static final class C14792 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ CheckboxColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3588op $onClick;
        final /* synthetic */ ToggleableState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14792(ToggleableState toggleableState, InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, int i, int i2) {
            super(2);
            this.$state = toggleableState;
            this.$onClick = interfaceC3588op;
            this.$modifier = modifier;
            this.$enabled = z;
            this.$colors = checkboxColors;
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
            CheckboxKt.TriStateCheckbox(this.$state, this.$onClick, this.$modifier, this.$enabled, this.$colors, this.$interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        float f = 2;
        CheckboxDefaultPadding = Dp.m5160constructorimpl(f);
        StrokeWidth = Dp.m5160constructorimpl(f);
        RadiusSize = Dp.m5160constructorimpl(f);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x014b  */
    /* JADX WARN: Code duplicated, block: B:103:0x015d  */
    /* JADX WARN: Code duplicated, block: B:105:0x0176  */
    /* JADX WARN: Code duplicated, block: B:107:0x017e  */
    /* JADX WARN: Code duplicated, block: B:109:0x018d  */
    /* JADX WARN: Code duplicated, block: B:112:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:117:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x005c  */
    /* JADX WARN: Code duplicated, block: B:38:0x0061  */
    /* JADX WARN: Code duplicated, block: B:40:0x0065  */
    /* JADX WARN: Code duplicated, block: B:42:0x006d  */
    /* JADX WARN: Code duplicated, block: B:43:0x0070  */
    /* JADX WARN: Code duplicated, block: B:47:0x0079  */
    /* JADX WARN: Code duplicated, block: B:49:0x007d  */
    /* JADX WARN: Code duplicated, block: B:51:0x0085  */
    /* JADX WARN: Code duplicated, block: B:52:0x0088  */
    /* JADX WARN: Code duplicated, block: B:55:0x008e  */
    /* JADX WARN: Code duplicated, block: B:58:0x0094  */
    /* JADX WARN: Code duplicated, block: B:59:0x009a  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:63:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:83:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:90:0x0116  */
    /* JADX WARN: Code duplicated, block: B:92:0x0119  */
    /* JADX WARN: Code duplicated, block: B:94:0x012b  */
    /* JADX WARN: Code duplicated, block: B:97:0x013f  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Checkbox(boolean z, InterfaceC3750qp interfaceC3750qp, Modifier modifier, boolean z2, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        CheckboxColors checkboxColors2;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        Modifier modifier3;
        boolean z4;
        CheckboxColors checkboxColorsM1374colors5tl4gsc;
        MutableInteractionSource mutableInteractionSource3;
        int i8;
        CheckboxColors checkboxColors3;
        Object objRememberedValue;
        InterfaceC3588op interfaceC3588op;
        boolean z5;
        MutableInteractionSource mutableInteractionSource4;
        boolean zChanged;
        Object objRememberedValue2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1406741137);
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
                        checkboxColors2 = checkboxColors;
                        int i10 = composerStartRestartGroup.changed(checkboxColors2) ? 16384 : 8192;
                        i3 |= i10;
                    } else {
                        checkboxColors2 = checkboxColors;
                    }
                    i3 |= i10;
                } else {
                    checkboxColors2 = checkboxColors;
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
                            checkboxColorsM1374colors5tl4gsc = CheckboxDefaults.INSTANCE.m1374colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -57345;
                        } else {
                            checkboxColorsM1374colors5tl4gsc = checkboxColors2;
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
                        CheckboxColors checkboxColors4 = checkboxColorsM1374colors5tl4gsc;
                        i8 = i3;
                        checkboxColors3 = checkboxColors4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        i8 = i3;
                        modifier3 = modifier2;
                        z4 = z3;
                        checkboxColors3 = checkboxColors2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1406741137, i8, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:87)");
                    }
                    ToggleableState ToggleableState = ToggleableStateKt.ToggleableState(z);
                    composerStartRestartGroup.startReplaceableGroup(1557792622);
                    if (interfaceC3750qp != null) {
                        Boolean boolValueOf = Boolean.valueOf(z);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(boolValueOf) | composerStartRestartGroup.changed(interfaceC3750qp);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = new CheckboxKt$Checkbox$2$1(interfaceC3750qp, z);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        interfaceC3588op = (InterfaceC3588op) objRememberedValue2;
                    } else {
                        interfaceC3588op = null;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TriStateCheckbox(ToggleableState, interfaceC3588op, modifier3, z4, checkboxColors3, mutableInteractionSource3, composerStartRestartGroup, i8 & 524160, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    checkboxColors2 = checkboxColors3;
                    z5 = z4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z5 = z3;
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(z, interfaceC3750qp, modifier3, z5, checkboxColors2, mutableInteractionSource4, i, i2));
            }
            i3 |= 3072;
            z3 = z2;
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    checkboxColors2 = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColors2)) {
                    }
                    i3 |= i10;
                } else {
                    checkboxColors2 = checkboxColors;
                }
                i3 |= i10;
            } else {
                checkboxColors2 = checkboxColors;
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
                        checkboxColorsM1374colors5tl4gsc = CheckboxDefaults.INSTANCE.m1374colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -57345;
                    } else {
                        checkboxColorsM1374colors5tl4gsc = checkboxColors2;
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
                    CheckboxColors checkboxColors5 = checkboxColorsM1374colors5tl4gsc;
                    i8 = i3;
                    checkboxColors3 = checkboxColors5;
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
                        checkboxColorsM1374colors5tl4gsc = CheckboxDefaults.INSTANCE.m1374colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -57345;
                    } else {
                        checkboxColorsM1374colors5tl4gsc = checkboxColors2;
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
                    CheckboxColors checkboxColors6 = checkboxColorsM1374colors5tl4gsc;
                    i8 = i3;
                    checkboxColors3 = checkboxColors6;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1406741137, i8, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:87)");
                }
                ToggleableState ToggleableState2 = ToggleableStateKt.ToggleableState(z);
                composerStartRestartGroup.startReplaceableGroup(1557792622);
                if (interfaceC3750qp != null) {
                    Boolean boolValueOf2 = Boolean.valueOf(z);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(boolValueOf2) | composerStartRestartGroup.changed(interfaceC3750qp);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new CheckboxKt$Checkbox$2$1(interfaceC3750qp, z);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new CheckboxKt$Checkbox$2$1(interfaceC3750qp, z);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    interfaceC3588op = (InterfaceC3588op) objRememberedValue2;
                } else {
                    interfaceC3588op = null;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TriStateCheckbox(ToggleableState2, interfaceC3588op, modifier3, z4, checkboxColors3, mutableInteractionSource3, composerStartRestartGroup, i8 & 524160, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                checkboxColors2 = checkboxColors3;
                z5 = z4;
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
                        checkboxColorsM1374colors5tl4gsc = CheckboxDefaults.INSTANCE.m1374colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -57345;
                    } else {
                        checkboxColorsM1374colors5tl4gsc = checkboxColors2;
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
                    CheckboxColors checkboxColors7 = checkboxColorsM1374colors5tl4gsc;
                    i8 = i3;
                    checkboxColors3 = checkboxColors7;
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
                        checkboxColorsM1374colors5tl4gsc = CheckboxDefaults.INSTANCE.m1374colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -57345;
                    } else {
                        checkboxColorsM1374colors5tl4gsc = checkboxColors2;
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
                    CheckboxColors checkboxColors8 = checkboxColorsM1374colors5tl4gsc;
                    i8 = i3;
                    checkboxColors3 = checkboxColors8;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1406741137, i8, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:87)");
                }
                ToggleableState ToggleableState3 = ToggleableStateKt.ToggleableState(z);
                composerStartRestartGroup.startReplaceableGroup(1557792622);
                if (interfaceC3750qp != null) {
                    Boolean boolValueOf3 = Boolean.valueOf(z);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(boolValueOf3) | composerStartRestartGroup.changed(interfaceC3750qp);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new CheckboxKt$Checkbox$2$1(interfaceC3750qp, z);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new CheckboxKt$Checkbox$2$1(interfaceC3750qp, z);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    interfaceC3588op = (InterfaceC3588op) objRememberedValue2;
                } else {
                    interfaceC3588op = null;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TriStateCheckbox(ToggleableState3, interfaceC3588op, modifier3, z4, checkboxColors3, mutableInteractionSource3, composerStartRestartGroup, i8 & 524160, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                checkboxColors2 = checkboxColors3;
                z5 = z4;
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(z, interfaceC3750qp, modifier3, z5, checkboxColors2, mutableInteractionSource4, i, i2));
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
                    checkboxColors2 = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColors2)) {
                    }
                    i3 |= i10;
                } else {
                    checkboxColors2 = checkboxColors;
                }
                i3 |= i10;
            } else {
                checkboxColors2 = checkboxColors;
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
                        checkboxColorsM1374colors5tl4gsc = CheckboxDefaults.INSTANCE.m1374colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -57345;
                    } else {
                        checkboxColorsM1374colors5tl4gsc = checkboxColors2;
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
                    CheckboxColors checkboxColors9 = checkboxColorsM1374colors5tl4gsc;
                    i8 = i3;
                    checkboxColors3 = checkboxColors9;
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
                        checkboxColorsM1374colors5tl4gsc = CheckboxDefaults.INSTANCE.m1374colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -57345;
                    } else {
                        checkboxColorsM1374colors5tl4gsc = checkboxColors2;
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
                    CheckboxColors checkboxColors10 = checkboxColorsM1374colors5tl4gsc;
                    i8 = i3;
                    checkboxColors3 = checkboxColors10;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1406741137, i8, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:87)");
                }
                ToggleableState ToggleableState4 = ToggleableStateKt.ToggleableState(z);
                composerStartRestartGroup.startReplaceableGroup(1557792622);
                if (interfaceC3750qp != null) {
                    Boolean boolValueOf4 = Boolean.valueOf(z);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(boolValueOf4) | composerStartRestartGroup.changed(interfaceC3750qp);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new CheckboxKt$Checkbox$2$1(interfaceC3750qp, z);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new CheckboxKt$Checkbox$2$1(interfaceC3750qp, z);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    interfaceC3588op = (InterfaceC3588op) objRememberedValue2;
                } else {
                    interfaceC3588op = null;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TriStateCheckbox(ToggleableState4, interfaceC3588op, modifier3, z4, checkboxColors3, mutableInteractionSource3, composerStartRestartGroup, i8 & 524160, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                checkboxColors2 = checkboxColors3;
                z5 = z4;
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
                        checkboxColorsM1374colors5tl4gsc = CheckboxDefaults.INSTANCE.m1374colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -57345;
                    } else {
                        checkboxColorsM1374colors5tl4gsc = checkboxColors2;
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
                    CheckboxColors checkboxColors11 = checkboxColorsM1374colors5tl4gsc;
                    i8 = i3;
                    checkboxColors3 = checkboxColors11;
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
                        checkboxColorsM1374colors5tl4gsc = CheckboxDefaults.INSTANCE.m1374colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -57345;
                    } else {
                        checkboxColorsM1374colors5tl4gsc = checkboxColors2;
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
                    CheckboxColors checkboxColors12 = checkboxColorsM1374colors5tl4gsc;
                    i8 = i3;
                    checkboxColors3 = checkboxColors12;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1406741137, i8, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:87)");
                }
                ToggleableState ToggleableState5 = ToggleableStateKt.ToggleableState(z);
                composerStartRestartGroup.startReplaceableGroup(1557792622);
                if (interfaceC3750qp != null) {
                    Boolean boolValueOf5 = Boolean.valueOf(z);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(boolValueOf5) | composerStartRestartGroup.changed(interfaceC3750qp);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new CheckboxKt$Checkbox$2$1(interfaceC3750qp, z);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new CheckboxKt$Checkbox$2$1(interfaceC3750qp, z);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    interfaceC3588op = (InterfaceC3588op) objRememberedValue2;
                } else {
                    interfaceC3588op = null;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TriStateCheckbox(ToggleableState5, interfaceC3588op, modifier3, z4, checkboxColors3, mutableInteractionSource3, composerStartRestartGroup, i8 & 524160, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                checkboxColors2 = checkboxColors3;
                z5 = z4;
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(z, interfaceC3750qp, modifier3, z5, checkboxColors2, mutableInteractionSource4, i, i2));
        }
        i3 |= 3072;
        z3 = z2;
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                checkboxColors2 = checkboxColors;
                if (composerStartRestartGroup.changed(checkboxColors2)) {
                }
                i3 |= i10;
            } else {
                checkboxColors2 = checkboxColors;
            }
            i3 |= i10;
        } else {
            checkboxColors2 = checkboxColors;
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
                    checkboxColorsM1374colors5tl4gsc = CheckboxDefaults.INSTANCE.m1374colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    i3 &= -57345;
                } else {
                    checkboxColorsM1374colors5tl4gsc = checkboxColors2;
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
                CheckboxColors checkboxColors13 = checkboxColorsM1374colors5tl4gsc;
                i8 = i3;
                checkboxColors3 = checkboxColors13;
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
                    checkboxColorsM1374colors5tl4gsc = CheckboxDefaults.INSTANCE.m1374colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    i3 &= -57345;
                } else {
                    checkboxColorsM1374colors5tl4gsc = checkboxColors2;
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
                CheckboxColors checkboxColors14 = checkboxColorsM1374colors5tl4gsc;
                i8 = i3;
                checkboxColors3 = checkboxColors14;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1406741137, i8, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:87)");
            }
            ToggleableState ToggleableState6 = ToggleableStateKt.ToggleableState(z);
            composerStartRestartGroup.startReplaceableGroup(1557792622);
            if (interfaceC3750qp != null) {
                Boolean boolValueOf6 = Boolean.valueOf(z);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(boolValueOf6) | composerStartRestartGroup.changed(interfaceC3750qp);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new CheckboxKt$Checkbox$2$1(interfaceC3750qp, z);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new CheckboxKt$Checkbox$2$1(interfaceC3750qp, z);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                interfaceC3588op = (InterfaceC3588op) objRememberedValue2;
            } else {
                interfaceC3588op = null;
            }
            composerStartRestartGroup.endReplaceableGroup();
            TriStateCheckbox(ToggleableState6, interfaceC3588op, modifier3, z4, checkboxColors3, mutableInteractionSource3, composerStartRestartGroup, i8 & 524160, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            checkboxColors2 = checkboxColors3;
            z5 = z4;
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
                    checkboxColorsM1374colors5tl4gsc = CheckboxDefaults.INSTANCE.m1374colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    i3 &= -57345;
                } else {
                    checkboxColorsM1374colors5tl4gsc = checkboxColors2;
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
                CheckboxColors checkboxColors15 = checkboxColorsM1374colors5tl4gsc;
                i8 = i3;
                checkboxColors3 = checkboxColors15;
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
                    checkboxColorsM1374colors5tl4gsc = CheckboxDefaults.INSTANCE.m1374colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    i3 &= -57345;
                } else {
                    checkboxColorsM1374colors5tl4gsc = checkboxColors2;
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
                CheckboxColors checkboxColors16 = checkboxColorsM1374colors5tl4gsc;
                i8 = i3;
                checkboxColors3 = checkboxColors16;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1406741137, i8, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:87)");
            }
            ToggleableState ToggleableState7 = ToggleableStateKt.ToggleableState(z);
            composerStartRestartGroup.startReplaceableGroup(1557792622);
            if (interfaceC3750qp != null) {
                Boolean boolValueOf7 = Boolean.valueOf(z);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(boolValueOf7) | composerStartRestartGroup.changed(interfaceC3750qp);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new CheckboxKt$Checkbox$2$1(interfaceC3750qp, z);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new CheckboxKt$Checkbox$2$1(interfaceC3750qp, z);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                interfaceC3588op = (InterfaceC3588op) objRememberedValue2;
            } else {
                interfaceC3588op = null;
            }
            composerStartRestartGroup.endReplaceableGroup();
            TriStateCheckbox(ToggleableState7, interfaceC3588op, modifier3, z4, checkboxColors3, mutableInteractionSource3, composerStartRestartGroup, i8 & 524160, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            checkboxColors2 = checkboxColors3;
            z5 = z4;
            mutableInteractionSource4 = mutableInteractionSource3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(z, interfaceC3750qp, modifier3, z5, checkboxColors2, mutableInteractionSource4, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:102:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:105:0x0212  */
    /* JADX WARN: Code duplicated, block: B:108:0x026f A[LOOP:0: B:107:0x026d->B:108:0x026f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:113:0x0287  */
    /* JADX WARN: Code duplicated, block: B:116:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:71:0x010d  */
    /* JADX WARN: Code duplicated, block: B:74:0x016d  */
    /* JADX WARN: Code duplicated, block: B:75:0x0173  */
    /* JADX WARN: Code duplicated, block: B:84:0x018b  */
    /* JADX WARN: Code duplicated, block: B:87:0x0192  */
    /* JADX WARN: Code duplicated, block: B:90:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:97:0x01be  */
    /* JADX WARN: Code duplicated, block: B:98:0x01c1  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CheckboxImpl(boolean z, ToggleableState toggleableState, Modifier modifier, CheckboxColors checkboxColors, Composer composer, int i) {
        float f;
        float f2;
        State stateCreateTransitionAnimation;
        int i2;
        int i3;
        float f3;
        int i4;
        Composer composer2;
        State stateCreateTransitionAnimation2;
        Object objRememberedValue;
        CheckDrawingCache checkDrawingCache;
        State<Color> stateCheckmarkColor$material3_release;
        State<Color> stateBoxColor$material3_release;
        State<Color> stateBorderColor$material3_release;
        Object[] objArr;
        int i5;
        boolean zChanged;
        Object objRememberedValue2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2007131616);
        int i6 = (i & 14) == 0 ? (composerStartRestartGroup.changed(z) ? 4 : 2) | i : i;
        if ((i & 112) == 0) {
            i6 |= composerStartRestartGroup.changed(toggleableState) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i6 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i6 |= composerStartRestartGroup.changed(checkboxColors) ? 2048 : 1024;
        }
        int i7 = i6;
        if ((i7 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2007131616, i7, -1, "androidx.compose.material3.CheckboxImpl (Checkbox.kt:229)");
            }
            int i8 = i7 >> 3;
            int i9 = i8 & 14;
            Transition transitionUpdateTransition = TransitionKt.updateTransition(toggleableState, (String) null, composerStartRestartGroup, i9, 2);
            CheckboxKt$CheckboxImpl$checkDrawFraction$1 checkboxKt$CheckboxImpl$checkDrawFraction$1 = CheckboxKt$CheckboxImpl$checkDrawFraction$1.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-1338768149);
            C0774Nm c0774Nm = C0774Nm.a;
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(c0774Nm);
            composerStartRestartGroup.startReplaceableGroup(-142660079);
            ToggleableState toggleableState2 = (ToggleableState) transitionUpdateTransition.getCurrentState();
            composerStartRestartGroup.startReplaceableGroup(1800065638);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1800065638, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:244)");
            }
            int[] iArr = WhenMappings.$EnumSwitchMapping$0;
            int i10 = iArr[toggleableState2.ordinal()];
            float f4 = 0.0f;
            if (i10 == 1) {
                f = 1.0f;
            } else if (i10 != 2) {
                if (i10 != 3) {
                    throw new AD();
                }
                f = 1.0f;
            } else {
                f = 0.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            Float fValueOf = Float.valueOf(f);
            ToggleableState toggleableState3 = (ToggleableState) transitionUpdateTransition.getTargetState();
            composerStartRestartGroup.startReplaceableGroup(1800065638);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1800065638, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:244)");
            }
            int i11 = iArr[toggleableState3.ordinal()];
            if (i11 != 1) {
                if (i11 == 2) {
                    f2 = 0.0f;
                } else if (i11 != 3) {
                    throw new AD();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, Float.valueOf(f2), (FiniteAnimationSpec) checkboxKt$CheckboxImpl$checkDrawFraction$1.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), vectorConverter, "FloatAnimation", composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1 checkboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1 = CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-1338768149);
                TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(c0774Nm);
                composerStartRestartGroup.startReplaceableGroup(-142660079);
                ToggleableState toggleableState4 = (ToggleableState) transitionUpdateTransition.getCurrentState();
                composerStartRestartGroup.startReplaceableGroup(-1426969489);
                if (ComposerKt.isTraceInProgress()) {
                    i2 = -1;
                    ComposerKt.traceEventStart(-1426969489, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:260)");
                } else {
                    i2 = -1;
                }
                i3 = iArr[toggleableState4.ordinal()];
                if (i3 != 1 || i3 == 2) {
                    f3 = 0.0f;
                } else {
                    if (i3 != 3) {
                        throw new AD();
                    }
                    f3 = 1.0f;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                Float fValueOf2 = Float.valueOf(f3);
                ToggleableState toggleableState5 = (ToggleableState) transitionUpdateTransition.getTargetState();
                composerStartRestartGroup.startReplaceableGroup(-1426969489);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1426969489, 0, i2, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:260)");
                }
                i4 = iArr[toggleableState5.ordinal()];
                if (i4 != 1 && i4 != 2) {
                    if (i4 == 3) {
                        throw new AD();
                    }
                    f4 = 1.0f;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                composer2 = composerStartRestartGroup;
                stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf2, Float.valueOf(f4), (FiniteAnimationSpec) checkboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), vectorConverter2, "FloatAnimation", composer2, 0);
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.startReplaceableGroup(-492369756);
                objRememberedValue = composer2.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new CheckDrawingCache(null, null, null, 7, null);
                    composer2.updateRememberedValue(objRememberedValue);
                }
                composer2.endReplaceableGroup();
                checkDrawingCache = (CheckDrawingCache) objRememberedValue;
                stateCheckmarkColor$material3_release = checkboxColors.checkmarkColor$material3_release(toggleableState, composer2, ((i7 >> 6) & 112) | i9);
                int i12 = (i7 & 126) | (i8 & 896);
                stateBoxColor$material3_release = checkboxColors.boxColor$material3_release(z, toggleableState, composer2, i12);
                stateBorderColor$material3_release = checkboxColors.borderColor$material3_release(z, toggleableState, composer2, i12);
                Modifier modifierM524requiredSize3ABfNKs = SizeKt.m524requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier, Alignment.Companion.getCenter(), false, 2, null), CheckboxSize);
                objArr = new Object[]{stateBoxColor$material3_release, stateBorderColor$material3_release, stateCheckmarkColor$material3_release, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, checkDrawingCache};
                composer2.startReplaceableGroup(-568225417);
                zChanged = false;
                for (i5 = 0; i5 < 6; i5++) {
                    zChanged |= composer2.changed(objArr[i5]);
                }
                objRememberedValue2 = composer2.rememberedValue();
                if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new CheckboxKt$CheckboxImpl$1$1(stateBoxColor$material3_release, stateBorderColor$material3_release, stateCheckmarkColor$material3_release, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, checkDrawingCache);
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                composer2.endReplaceableGroup();
                CanvasKt.Canvas(modifierM524requiredSize3ABfNKs, (InterfaceC3750qp) objRememberedValue2, composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            f2 = 1.0f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, Float.valueOf(f2), (FiniteAnimationSpec) checkboxKt$CheckboxImpl$checkDrawFraction$1.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), vectorConverter, "FloatAnimation", composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1 checkboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2 = CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-1338768149);
            TwoWayConverter<Float, AnimationVector1D> vectorConverter3 = VectorConvertersKt.getVectorConverter(c0774Nm);
            composerStartRestartGroup.startReplaceableGroup(-142660079);
            ToggleableState toggleableState6 = (ToggleableState) transitionUpdateTransition.getCurrentState();
            composerStartRestartGroup.startReplaceableGroup(-1426969489);
            if (ComposerKt.isTraceInProgress()) {
                i2 = -1;
                ComposerKt.traceEventStart(-1426969489, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:260)");
            } else {
                i2 = -1;
            }
            i3 = iArr[toggleableState6.ordinal()];
            if (i3 != 1) {
                f3 = 0.0f;
            } else {
                f3 = 0.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            Float fValueOf3 = Float.valueOf(f3);
            ToggleableState toggleableState7 = (ToggleableState) transitionUpdateTransition.getTargetState();
            composerStartRestartGroup.startReplaceableGroup(-1426969489);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1426969489, 0, i2, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:260)");
            }
            i4 = iArr[toggleableState7.ordinal()];
            if (i4 != 1) {
                if (i4 == 3) {
                    throw new AD();
                }
                f4 = 1.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            composer2 = composerStartRestartGroup;
            stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf3, Float.valueOf(f4), (FiniteAnimationSpec) checkboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), vectorConverter3, "FloatAnimation", composer2, 0);
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.startReplaceableGroup(-492369756);
            objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new CheckDrawingCache(null, null, null, 7, null);
                composer2.updateRememberedValue(objRememberedValue);
            }
            composer2.endReplaceableGroup();
            checkDrawingCache = (CheckDrawingCache) objRememberedValue;
            stateCheckmarkColor$material3_release = checkboxColors.checkmarkColor$material3_release(toggleableState, composer2, ((i7 >> 6) & 112) | i9);
            int i13 = (i7 & 126) | (i8 & 896);
            stateBoxColor$material3_release = checkboxColors.boxColor$material3_release(z, toggleableState, composer2, i13);
            stateBorderColor$material3_release = checkboxColors.borderColor$material3_release(z, toggleableState, composer2, i13);
            Modifier modifierM524requiredSize3ABfNKs2 = SizeKt.m524requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier, Alignment.Companion.getCenter(), false, 2, null), CheckboxSize);
            objArr = new Object[]{stateBoxColor$material3_release, stateBorderColor$material3_release, stateCheckmarkColor$material3_release, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, checkDrawingCache};
            composer2.startReplaceableGroup(-568225417);
            zChanged = false;
            while (i5 < 6) {
                zChanged |= composer2.changed(objArr[i5]);
            }
            objRememberedValue2 = composer2.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = new CheckboxKt$CheckboxImpl$1$1(stateBoxColor$material3_release, stateBorderColor$material3_release, stateCheckmarkColor$material3_release, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, checkDrawingCache);
                composer2.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new CheckboxKt$CheckboxImpl$1$1(stateBoxColor$material3_release, stateBorderColor$material3_release, stateCheckmarkColor$material3_release, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, checkDrawingCache);
                composer2.updateRememberedValue(objRememberedValue2);
            }
            composer2.endReplaceableGroup();
            CanvasKt.Canvas(modifierM524requiredSize3ABfNKs2, (InterfaceC3750qp) objRememberedValue2, composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(z, toggleableState, modifier, checkboxColors, i));
    }

    /* JADX WARN: Code duplicated, block: B:102:0x016b  */
    /* JADX WARN: Code duplicated, block: B:103:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:106:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:107:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:110:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:115:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0062  */
    /* JADX WARN: Code duplicated, block: B:38:0x0067  */
    /* JADX WARN: Code duplicated, block: B:40:0x006b  */
    /* JADX WARN: Code duplicated, block: B:42:0x0073  */
    /* JADX WARN: Code duplicated, block: B:43:0x0076  */
    /* JADX WARN: Code duplicated, block: B:47:0x007f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0083  */
    /* JADX WARN: Code duplicated, block: B:51:0x008b  */
    /* JADX WARN: Code duplicated, block: B:52:0x008e  */
    /* JADX WARN: Code duplicated, block: B:55:0x0094  */
    /* JADX WARN: Code duplicated, block: B:58:0x009a  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:90:0x0100  */
    /* JADX WARN: Code duplicated, block: B:92:0x0125  */
    /* JADX WARN: Code duplicated, block: B:94:0x0137  */
    /* JADX WARN: Code duplicated, block: B:96:0x014c  */
    /* JADX WARN: Code duplicated, block: B:99:0x015d  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TriStateCheckbox(ToggleableState toggleableState, InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        CheckboxColors checkboxColorsM1374colors5tl4gsc;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        Modifier modifier3;
        boolean z3;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier4;
        boolean z4;
        CheckboxColors checkboxColors2;
        Object objRememberedValue;
        int i8;
        Modifier modifierM715triStateToggleableO2vRcR0;
        Modifier modifierMinimumInteractiveComponentSize;
        Modifier modifier5;
        boolean z5;
        CheckboxColors checkboxColors3;
        MutableInteractionSource mutableInteractionSource4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(toggleableState, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1608358065);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(toggleableState) ? 4 : 2) | i;
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
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        checkboxColorsM1374colors5tl4gsc = checkboxColors;
                        int i10 = composerStartRestartGroup.changed(checkboxColorsM1374colors5tl4gsc) ? 16384 : 8192;
                        i3 |= i10;
                    } else {
                        checkboxColorsM1374colors5tl4gsc = checkboxColors;
                    }
                    i3 |= i10;
                } else {
                    checkboxColorsM1374colors5tl4gsc = checkboxColors;
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
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            checkboxColorsM1374colors5tl4gsc = CheckboxDefaults.INSTANCE.m1374colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            z4 = z3;
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                            i8 = i3;
                            modifier4 = modifier3;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            modifier4 = modifier3;
                            z4 = z3;
                            checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1608358065, i8, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:137)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(1797978260);
                        if (interfaceC3588op != null) {
                            modifierM715triStateToggleableO2vRcR0 = ToggleableKt.m715triStateToggleableO2vRcR0(Modifier.Companion, toggleableState, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, Dp.m5160constructorimpl(CheckboxTokens.INSTANCE.m2096getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4), z4, Role.m4543boximpl(Role.Companion.m4551getCheckboxo7Vup1c()), interfaceC3588op);
                        } else {
                            modifierM715triStateToggleableO2vRcR0 = Modifier.Companion;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        if (interfaceC3588op != null) {
                            modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                        } else {
                            modifierMinimumInteractiveComponentSize = Modifier.Companion;
                        }
                        CheckboxImpl(z4, toggleableState, PaddingKt.m485padding3ABfNKs(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM715triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColors2, composerStartRestartGroup, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 3) & 7168));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        z5 = z4;
                        checkboxColors3 = checkboxColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        modifier4 = modifier2;
                        z4 = z2;
                        checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    i8 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1608358065, i8, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:137)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(1797978260);
                    if (interfaceC3588op != null) {
                        modifierM715triStateToggleableO2vRcR0 = ToggleableKt.m715triStateToggleableO2vRcR0(Modifier.Companion, toggleableState, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, Dp.m5160constructorimpl(CheckboxTokens.INSTANCE.m2096getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4), z4, Role.m4543boximpl(Role.Companion.m4551getCheckboxo7Vup1c()), interfaceC3588op);
                    } else {
                        modifierM715triStateToggleableO2vRcR0 = Modifier.Companion;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC3588op != null) {
                        modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                    } else {
                        modifierMinimumInteractiveComponentSize = Modifier.Companion;
                    }
                    CheckboxImpl(z4, toggleableState, PaddingKt.m485padding3ABfNKs(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM715triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColors2, composerStartRestartGroup, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 3) & 7168));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z5 = z4;
                    checkboxColors3 = checkboxColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier5 = modifier2;
                    z5 = z2;
                    checkboxColors3 = checkboxColorsM1374colors5tl4gsc;
                    composerStartRestartGroup = composerStartRestartGroup;
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14792(toggleableState, interfaceC3588op, modifier5, z5, checkboxColors3, mutableInteractionSource4, i, i2));
            }
            i3 |= 3072;
            z2 = z;
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    checkboxColorsM1374colors5tl4gsc = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColorsM1374colors5tl4gsc)) {
                    }
                    i3 |= i10;
                } else {
                    checkboxColorsM1374colors5tl4gsc = checkboxColors;
                }
                i3 |= i10;
            } else {
                checkboxColorsM1374colors5tl4gsc = checkboxColors;
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
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        checkboxColorsM1374colors5tl4gsc = CheckboxDefaults.INSTANCE.m1374colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        z4 = z3;
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                        i8 = i3;
                        modifier4 = modifier3;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                        modifier4 = modifier3;
                        z4 = z3;
                        checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                        i8 = i3;
                    }
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        checkboxColorsM1374colors5tl4gsc = CheckboxDefaults.INSTANCE.m1374colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        z4 = z3;
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                        i8 = i3;
                        modifier4 = modifier3;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                        modifier4 = modifier3;
                        z4 = z3;
                        checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                        i8 = i3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1608358065, i8, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:137)");
                }
                composerStartRestartGroup.startReplaceableGroup(1797978260);
                if (interfaceC3588op != null) {
                    modifierM715triStateToggleableO2vRcR0 = ToggleableKt.m715triStateToggleableO2vRcR0(Modifier.Companion, toggleableState, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, Dp.m5160constructorimpl(CheckboxTokens.INSTANCE.m2096getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4), z4, Role.m4543boximpl(Role.Companion.m4551getCheckboxo7Vup1c()), interfaceC3588op);
                } else {
                    modifierM715triStateToggleableO2vRcR0 = Modifier.Companion;
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (interfaceC3588op != null) {
                    modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                } else {
                    modifierMinimumInteractiveComponentSize = Modifier.Companion;
                }
                CheckboxImpl(z4, toggleableState, PaddingKt.m485padding3ABfNKs(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM715triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColors2, composerStartRestartGroup, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 3) & 7168));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z5 = z4;
                checkboxColors3 = checkboxColors2;
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
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        checkboxColorsM1374colors5tl4gsc = CheckboxDefaults.INSTANCE.m1374colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        z4 = z3;
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                        i8 = i3;
                        modifier4 = modifier3;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                        modifier4 = modifier3;
                        z4 = z3;
                        checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                        i8 = i3;
                    }
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        checkboxColorsM1374colors5tl4gsc = CheckboxDefaults.INSTANCE.m1374colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        z4 = z3;
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                        i8 = i3;
                        modifier4 = modifier3;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                        modifier4 = modifier3;
                        z4 = z3;
                        checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                        i8 = i3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1608358065, i8, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:137)");
                }
                composerStartRestartGroup.startReplaceableGroup(1797978260);
                if (interfaceC3588op != null) {
                    modifierM715triStateToggleableO2vRcR0 = ToggleableKt.m715triStateToggleableO2vRcR0(Modifier.Companion, toggleableState, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, Dp.m5160constructorimpl(CheckboxTokens.INSTANCE.m2096getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4), z4, Role.m4543boximpl(Role.Companion.m4551getCheckboxo7Vup1c()), interfaceC3588op);
                } else {
                    modifierM715triStateToggleableO2vRcR0 = Modifier.Companion;
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (interfaceC3588op != null) {
                    modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                } else {
                    modifierMinimumInteractiveComponentSize = Modifier.Companion;
                }
                CheckboxImpl(z4, toggleableState, PaddingKt.m485padding3ABfNKs(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM715triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColors2, composerStartRestartGroup, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 3) & 7168));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z5 = z4;
                checkboxColors3 = checkboxColors2;
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C14792(toggleableState, interfaceC3588op, modifier5, z5, checkboxColors3, mutableInteractionSource4, i, i2));
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    checkboxColorsM1374colors5tl4gsc = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColorsM1374colors5tl4gsc)) {
                    }
                    i3 |= i10;
                } else {
                    checkboxColorsM1374colors5tl4gsc = checkboxColors;
                }
                i3 |= i10;
            } else {
                checkboxColorsM1374colors5tl4gsc = checkboxColors;
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
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        checkboxColorsM1374colors5tl4gsc = CheckboxDefaults.INSTANCE.m1374colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        z4 = z3;
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                        i8 = i3;
                        modifier4 = modifier3;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                        modifier4 = modifier3;
                        z4 = z3;
                        checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                        i8 = i3;
                    }
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        checkboxColorsM1374colors5tl4gsc = CheckboxDefaults.INSTANCE.m1374colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        z4 = z3;
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                        i8 = i3;
                        modifier4 = modifier3;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                        modifier4 = modifier3;
                        z4 = z3;
                        checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                        i8 = i3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1608358065, i8, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:137)");
                }
                composerStartRestartGroup.startReplaceableGroup(1797978260);
                if (interfaceC3588op != null) {
                    modifierM715triStateToggleableO2vRcR0 = ToggleableKt.m715triStateToggleableO2vRcR0(Modifier.Companion, toggleableState, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, Dp.m5160constructorimpl(CheckboxTokens.INSTANCE.m2096getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4), z4, Role.m4543boximpl(Role.Companion.m4551getCheckboxo7Vup1c()), interfaceC3588op);
                } else {
                    modifierM715triStateToggleableO2vRcR0 = Modifier.Companion;
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (interfaceC3588op != null) {
                    modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                } else {
                    modifierMinimumInteractiveComponentSize = Modifier.Companion;
                }
                CheckboxImpl(z4, toggleableState, PaddingKt.m485padding3ABfNKs(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM715triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColors2, composerStartRestartGroup, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 3) & 7168));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z5 = z4;
                checkboxColors3 = checkboxColors2;
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
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        checkboxColorsM1374colors5tl4gsc = CheckboxDefaults.INSTANCE.m1374colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        z4 = z3;
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                        i8 = i3;
                        modifier4 = modifier3;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                        modifier4 = modifier3;
                        z4 = z3;
                        checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                        i8 = i3;
                    }
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        checkboxColorsM1374colors5tl4gsc = CheckboxDefaults.INSTANCE.m1374colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        z4 = z3;
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                        i8 = i3;
                        modifier4 = modifier3;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                        modifier4 = modifier3;
                        z4 = z3;
                        checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                        i8 = i3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1608358065, i8, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:137)");
                }
                composerStartRestartGroup.startReplaceableGroup(1797978260);
                if (interfaceC3588op != null) {
                    modifierM715triStateToggleableO2vRcR0 = ToggleableKt.m715triStateToggleableO2vRcR0(Modifier.Companion, toggleableState, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, Dp.m5160constructorimpl(CheckboxTokens.INSTANCE.m2096getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4), z4, Role.m4543boximpl(Role.Companion.m4551getCheckboxo7Vup1c()), interfaceC3588op);
                } else {
                    modifierM715triStateToggleableO2vRcR0 = Modifier.Companion;
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (interfaceC3588op != null) {
                    modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                } else {
                    modifierMinimumInteractiveComponentSize = Modifier.Companion;
                }
                CheckboxImpl(z4, toggleableState, PaddingKt.m485padding3ABfNKs(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM715triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColors2, composerStartRestartGroup, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 3) & 7168));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z5 = z4;
                checkboxColors3 = checkboxColors2;
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C14792(toggleableState, interfaceC3588op, modifier5, z5, checkboxColors3, mutableInteractionSource4, i, i2));
        }
        i3 |= 3072;
        z2 = z;
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                checkboxColorsM1374colors5tl4gsc = checkboxColors;
                if (composerStartRestartGroup.changed(checkboxColorsM1374colors5tl4gsc)) {
                }
                i3 |= i10;
            } else {
                checkboxColorsM1374colors5tl4gsc = checkboxColors;
            }
            i3 |= i10;
        } else {
            checkboxColorsM1374colors5tl4gsc = checkboxColors;
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
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    checkboxColorsM1374colors5tl4gsc = CheckboxDefaults.INSTANCE.m1374colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    z4 = z3;
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                    i8 = i3;
                    modifier4 = modifier3;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                    modifier4 = modifier3;
                    z4 = z3;
                    checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                    i8 = i3;
                }
            } else {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    checkboxColorsM1374colors5tl4gsc = CheckboxDefaults.INSTANCE.m1374colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    z4 = z3;
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                    i8 = i3;
                    modifier4 = modifier3;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                    modifier4 = modifier3;
                    z4 = z3;
                    checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                    i8 = i3;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1608358065, i8, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:137)");
            }
            composerStartRestartGroup.startReplaceableGroup(1797978260);
            if (interfaceC3588op != null) {
                modifierM715triStateToggleableO2vRcR0 = ToggleableKt.m715triStateToggleableO2vRcR0(Modifier.Companion, toggleableState, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, Dp.m5160constructorimpl(CheckboxTokens.INSTANCE.m2096getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4), z4, Role.m4543boximpl(Role.Companion.m4551getCheckboxo7Vup1c()), interfaceC3588op);
            } else {
                modifierM715triStateToggleableO2vRcR0 = Modifier.Companion;
            }
            composerStartRestartGroup.endReplaceableGroup();
            if (interfaceC3588op != null) {
                modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
            } else {
                modifierMinimumInteractiveComponentSize = Modifier.Companion;
            }
            CheckboxImpl(z4, toggleableState, PaddingKt.m485padding3ABfNKs(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM715triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColors2, composerStartRestartGroup, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 3) & 7168));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            z5 = z4;
            checkboxColors3 = checkboxColors2;
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
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    checkboxColorsM1374colors5tl4gsc = CheckboxDefaults.INSTANCE.m1374colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    z4 = z3;
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                    i8 = i3;
                    modifier4 = modifier3;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                    modifier4 = modifier3;
                    z4 = z3;
                    checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                    i8 = i3;
                }
            } else {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    checkboxColorsM1374colors5tl4gsc = CheckboxDefaults.INSTANCE.m1374colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    z4 = z3;
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                    i8 = i3;
                    modifier4 = modifier3;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                    modifier4 = modifier3;
                    z4 = z3;
                    checkboxColors2 = checkboxColorsM1374colors5tl4gsc;
                    i8 = i3;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1608358065, i8, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:137)");
            }
            composerStartRestartGroup.startReplaceableGroup(1797978260);
            if (interfaceC3588op != null) {
                modifierM715triStateToggleableO2vRcR0 = ToggleableKt.m715triStateToggleableO2vRcR0(Modifier.Companion, toggleableState, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, Dp.m5160constructorimpl(CheckboxTokens.INSTANCE.m2096getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4), z4, Role.m4543boximpl(Role.Companion.m4551getCheckboxo7Vup1c()), interfaceC3588op);
            } else {
                modifierM715triStateToggleableO2vRcR0 = Modifier.Companion;
            }
            composerStartRestartGroup.endReplaceableGroup();
            if (interfaceC3588op != null) {
                modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
            } else {
                modifierMinimumInteractiveComponentSize = Modifier.Companion;
            }
            CheckboxImpl(z4, toggleableState, PaddingKt.m485padding3ABfNKs(modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM715triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColors2, composerStartRestartGroup, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 3) & 7168));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            z5 = z4;
            checkboxColors3 = checkboxColors2;
            mutableInteractionSource4 = mutableInteractionSource3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C14792(toggleableState, interfaceC3588op, modifier5, z5, checkboxColors3, mutableInteractionSource4, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawBox-1wkBAMs, reason: not valid java name */
    public static final void m1377drawBox1wkBAMs(DrawScope drawScope, long j, long j2, float f, float f2) {
        float f3 = f2 / 2.0f;
        Stroke stroke = new Stroke(f2, 0.0f, 0, 0, null, 30, null);
        float fM2867getWidthimpl = Size.m2867getWidthimpl(drawScope.mo3469getSizeNHjbRc());
        if (Color.m3033equalsimpl0(j, j2)) {
            AbstractC3255kk.M(drawScope, j, 0L, androidx.compose.ui.geometry.SizeKt.Size(fM2867getWidthimpl, fM2867getWidthimpl), CornerRadiusKt.CornerRadius$default(f, 0.0f, 2, null), Fill.INSTANCE, 0.0f, null, 0, Jpeg.M_APP2, null);
            return;
        }
        float f4 = fM2867getWidthimpl - (2 * f2);
        AbstractC3255kk.M(drawScope, j, OffsetKt.Offset(f2, f2), androidx.compose.ui.geometry.SizeKt.Size(f4, f4), CornerRadiusKt.CornerRadius$default(Math.max(0.0f, f - f2), 0.0f, 2, null), Fill.INSTANCE, 0.0f, null, 0, 224, null);
        float f5 = fM2867getWidthimpl - f2;
        AbstractC3255kk.M(drawScope, j2, OffsetKt.Offset(f3, f3), androidx.compose.ui.geometry.SizeKt.Size(f5, f5), CornerRadiusKt.CornerRadius$default(f - f3, 0.0f, 2, null), stroke, 0.0f, null, 0, 224, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawCheck-3IgeMak, reason: not valid java name */
    public static final void m1378drawCheck3IgeMak(DrawScope drawScope, long j, float f, float f2, float f3, CheckDrawingCache checkDrawingCache) {
        Stroke stroke = new Stroke(f3, 0.0f, StrokeCap.Companion.m3358getSquareKaPHkGw(), 0, null, 26, null);
        float fM2867getWidthimpl = Size.m2867getWidthimpl(drawScope.mo3469getSizeNHjbRc());
        float fLerp = MathHelpersKt.lerp(0.4f, 0.5f, f2);
        float fLerp2 = MathHelpersKt.lerp(0.7f, 0.5f, f2);
        float fLerp3 = MathHelpersKt.lerp(0.5f, 0.5f, f2);
        float fLerp4 = MathHelpersKt.lerp(0.3f, 0.5f, f2);
        checkDrawingCache.getCheckPath().reset();
        checkDrawingCache.getCheckPath().moveTo(0.2f * fM2867getWidthimpl, fLerp3 * fM2867getWidthimpl);
        checkDrawingCache.getCheckPath().lineTo(fLerp * fM2867getWidthimpl, fLerp2 * fM2867getWidthimpl);
        checkDrawingCache.getCheckPath().lineTo(0.8f * fM2867getWidthimpl, fM2867getWidthimpl * fLerp4);
        checkDrawingCache.getPathMeasure().setPath(checkDrawingCache.getCheckPath(), false);
        checkDrawingCache.getPathToDraw().reset();
        checkDrawingCache.getPathMeasure().getSegment(0.0f, checkDrawingCache.getPathMeasure().getLength() * f, checkDrawingCache.getPathToDraw(), true);
        AbstractC3255kk.G(drawScope, checkDrawingCache.getPathToDraw(), j, 0.0f, stroke, null, 0, 52, null);
    }
}
