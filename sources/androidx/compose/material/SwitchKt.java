package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3255kk;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import org.apache.poi.ss.util.IEEEDouble;

/* JADX INFO: loaded from: classes.dex */
public final class SwitchKt {
    private static final TweenSpec<Float> AnimationSpec;
    private static final float DefaultSwitchPadding;
    private static final float SwitchHeight;
    private static final float SwitchPositionalThreshold = 0.7f;
    private static final float SwitchVelocityThreshold;
    private static final float SwitchWidth;
    private static final float ThumbDefaultElevation;
    private static final float ThumbDiameter;
    private static final float ThumbPathLength;
    private static final float ThumbPressedElevation;
    private static final float ThumbRippleRadius;
    private static final float TrackStrokeWidth;
    private static final float TrackWidth;

    /* JADX INFO: renamed from: androidx.compose.material.SwitchKt$Switch$6, reason: invalid class name */
    public static final class AnonymousClass6 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ boolean $checked;
        final /* synthetic */ SwitchColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3750qp $onCheckedChange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(boolean z, InterfaceC3750qp interfaceC3750qp, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, SwitchColors switchColors, int i, int i2) {
            super(2);
            this.$checked = z;
            this.$onCheckedChange = interfaceC3750qp;
            this.$modifier = modifier;
            this.$enabled = z2;
            this.$interactionSource = mutableInteractionSource;
            this.$colors = switchColors;
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
            SwitchKt.Switch(this.$checked, this.$onCheckedChange, this.$modifier, this.$enabled, this.$interactionSource, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwitchKt$SwitchImpl$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ boolean $checked;
        final /* synthetic */ SwitchColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ InteractionSource $interactionSource;
        final /* synthetic */ BoxScope $this_SwitchImpl;
        final /* synthetic */ InterfaceC3588op $thumbValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(BoxScope boxScope, boolean z, boolean z2, SwitchColors switchColors, InterfaceC3588op interfaceC3588op, InteractionSource interactionSource, int i) {
            super(2);
            this.$this_SwitchImpl = boxScope;
            this.$checked = z;
            this.$enabled = z2;
            this.$colors = switchColors;
            this.$thumbValue = interfaceC3588op;
            this.$interactionSource = interactionSource;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            SwitchKt.SwitchImpl(this.$this_SwitchImpl, this.$checked, this.$enabled, this.$colors, this.$thumbValue, this.$interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    static {
        float fM5160constructorimpl = Dp.m5160constructorimpl(34);
        TrackWidth = fM5160constructorimpl;
        TrackStrokeWidth = Dp.m5160constructorimpl(14);
        float fM5160constructorimpl2 = Dp.m5160constructorimpl(20);
        ThumbDiameter = fM5160constructorimpl2;
        ThumbRippleRadius = Dp.m5160constructorimpl(24);
        DefaultSwitchPadding = Dp.m5160constructorimpl(2);
        SwitchWidth = fM5160constructorimpl;
        SwitchHeight = fM5160constructorimpl2;
        ThumbPathLength = Dp.m5160constructorimpl(fM5160constructorimpl - fM5160constructorimpl2);
        AnimationSpec = new TweenSpec<>(100, 0, null, 6, null);
        ThumbDefaultElevation = Dp.m5160constructorimpl(1);
        ThumbPressedElevation = Dp.m5160constructorimpl(6);
        SwitchVelocityThreshold = Dp.m5160constructorimpl(125);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0183  */
    /* JADX WARN: Code duplicated, block: B:104:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:106:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:109:0x0219  */
    /* JADX WARN: Code duplicated, block: B:111:0x021f  */
    /* JADX WARN: Code duplicated, block: B:114:0x0248 A[LOOP:0: B:113:0x0246->B:114:0x0248, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:117:0x0259  */
    /* JADX WARN: Code duplicated, block: B:119:0x0261  */
    /* JADX WARN: Code duplicated, block: B:122:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:124:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:127:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:128:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:130:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:131:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:133:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:134:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:137:0x0307 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:139:0x030d  */
    /* JADX WARN: Code duplicated, block: B:142:0x0366  */
    /* JADX WARN: Code duplicated, block: B:145:0x0372  */
    /* JADX WARN: Code duplicated, block: B:146:0x0376  */
    /* JADX WARN: Code duplicated, block: B:149:0x0395  */
    /* JADX WARN: Code duplicated, block: B:151:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:154:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:156:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:159:0x0425  */
    /* JADX WARN: Code duplicated, block: B:164:0x0435  */
    /* JADX WARN: Code duplicated, block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0065  */
    /* JADX WARN: Code duplicated, block: B:38:0x006a  */
    /* JADX WARN: Code duplicated, block: B:40:0x006e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0076  */
    /* JADX WARN: Code duplicated, block: B:43:0x0079  */
    /* JADX WARN: Code duplicated, block: B:47:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:50:0x008f  */
    /* JADX WARN: Code duplicated, block: B:52:0x0095  */
    /* JADX WARN: Code duplicated, block: B:53:0x0098  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:80:0x00f7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:82:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:86:0x0102  */
    /* JADX WARN: Code duplicated, block: B:88:0x0111  */
    /* JADX WARN: Code duplicated, block: B:90:0x011e  */
    /* JADX WARN: Code duplicated, block: B:93:0x0123  */
    /* JADX WARN: Code duplicated, block: B:95:0x014e  */
    /* JADX WARN: Code duplicated, block: B:98:0x015d  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Switch(boolean z, InterfaceC3750qp interfaceC3750qp, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, SwitchColors switchColors, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        SwitchColors switchColors2;
        Modifier modifier3;
        MutableInteractionSource mutableInteractionSource3;
        int i8;
        SwitchColors switchColorsM1239colorsSQMK_m0;
        Modifier modifier4;
        Object objRememberedValue;
        float fMo333toPx0680j_4;
        Object objRememberedValue2;
        Composer.Companion companion;
        MutableState mutableState;
        float fMo333toPx0680j_5;
        boolean zChanged;
        Object objRememberedValue3;
        AnchoredDraggableState anchoredDraggableState;
        State stateRememberUpdatedState;
        State stateRememberUpdatedState2;
        boolean zChanged2;
        Object objRememberedValue4;
        int i9;
        Object[] objArr;
        int i10;
        boolean zChanged3;
        Object objRememberedValue5;
        boolean zChanged4;
        Object objRememberedValue6;
        boolean z4;
        Modifier modifierM711toggleableO2vRcR0;
        Modifier modifierMinimumInteractiveComponentSize;
        boolean z5;
        Composer composer2;
        int currentCompositeKeyHash;
        InterfaceC3588op constructor;
        Composer composerM2661constructorimpl;
        InterfaceC0526Fp setCompositeKeyHash;
        boolean zChanged5;
        Object objRememberedValue7;
        Modifier modifier5;
        boolean z6;
        MutableInteractionSource mutableInteractionSource4;
        SwitchColors switchColors3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(25866825);
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
                    i3 |= 24576;
                    mutableInteractionSource2 = mutableInteractionSource;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i & 57344) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                }
                if ((i & 458752) == 0) {
                    switchColors2 = switchColors;
                    if ((i2 & 32) == 0 || !composerStartRestartGroup.changed(switchColors2)) {
                        i11 = 65536;
                    } else {
                        i11 = 131072;
                    }
                    i3 |= i11;
                } else {
                    switchColors2 = switchColors;
                }
                if ((i3 & 374491) == 74898 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
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
                            switchColorsM1239colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1239colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                            i8 = i3 & (-458753);
                        } else {
                            i8 = i3;
                            switchColorsM1239colorsSQMK_m0 = switchColors2;
                        }
                        modifier4 = modifier3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        i8 = i3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        switchColorsM1239colorsSQMK_m0 = switchColors2;
                        modifier4 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(25866825, i8, -1, "androidx.compose.material.Switch (Switch.kt:94)");
                    }
                    fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(ThumbPathLength);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue2;
                    fMo333toPx0680j_5 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(SwitchVelocityThreshold);
                    Float fValueOf = Float.valueOf(fMo333toPx0680j_5);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(fValueOf);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = new AnchoredDraggableState(Boolean.valueOf(z), SwitchKt$Switch$anchoredDraggableState$1$1.INSTANCE, new SwitchKt$Switch$anchoredDraggableState$1$2(fMo333toPx0680j_5), AnimationSpec, null, 16, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    anchoredDraggableState = (AnchoredDraggableState) objRememberedValue3;
                    int i13 = i8 >> 3;
                    stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, i13 & 14);
                    int i14 = i8 & 14;
                    stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(z), composerStartRestartGroup, i14);
                    Float fValueOf2 = Float.valueOf(0.0f);
                    Float fValueOf3 = Float.valueOf(fMo333toPx0680j_4);
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged2 = composerStartRestartGroup.changed(anchoredDraggableState) | composerStartRestartGroup.changed(fValueOf2) | composerStartRestartGroup.changed(fValueOf3);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2 || objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new SwitchKt$Switch$2$1(anchoredDraggableState, 0.0f, fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue4, composerStartRestartGroup, 0);
                    objArr = new Object[]{anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState};
                    composerStartRestartGroup.startReplaceableGroup(-568225417);
                    i10 = 0;
                    zChanged3 = false;
                    for (i9 = 4; i10 < i9; i9 = 4) {
                        zChanged3 |= composerStartRestartGroup.changed(objArr[i10]);
                        i10++;
                    }
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (zChanged3 || objRememberedValue5 == Composer.Companion.getEmpty()) {
                        objRememberedValue5 = new SwitchKt$Switch$3$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(anchoredDraggableState, (InterfaceC0526Fp) objRememberedValue5, composerStartRestartGroup, 64);
                    Boolean boolValueOf = Boolean.valueOf(z);
                    Boolean boolValueOf2 = Boolean.valueOf(Switch$lambda$3(mutableState));
                    Boolean boolValueOf3 = Boolean.valueOf(z);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged4 = composerStartRestartGroup.changed(boolValueOf3) | composerStartRestartGroup.changed(anchoredDraggableState);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (zChanged4 || objRememberedValue6 == Composer.Companion.getEmpty()) {
                        objRememberedValue6 = new SwitchKt$Switch$4$1(z, anchoredDraggableState, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(boolValueOf, boolValueOf2, (InterfaceC0526Fp) objRememberedValue6, composerStartRestartGroup, i14 | 512);
                    if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (interfaceC3750qp != null) {
                        modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z3, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                    } else {
                        modifierM711toggleableO2vRcR0 = Modifier.Companion;
                    }
                    if (interfaceC3750qp != null) {
                        modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                    } else {
                        modifierMinimumInteractiveComponentSize = Modifier.Companion;
                    }
                    Modifier modifierThen = modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                    Orientation orientation = Orientation.Horizontal;
                    if (z3 || interfaceC3750qp == null) {
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    composer2 = composerStartRestartGroup;
                    int i15 = i8;
                    Modifier modifierAnchoredDraggable = AnchoredDraggableKt.anchoredDraggable(modifierThen, anchoredDraggableState, orientation, z5, z4, mutableInteractionSource3);
                    Alignment.Companion companion2 = Alignment.Companion;
                    Modifier modifierM526requiredSizeVpY3zN4 = SizeKt.m526requiredSizeVpY3zN4(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifierAnchoredDraggable, companion2.getCenter(), false, 2, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
                    constructor = companion3.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierM526requiredSizeVpY3zN4);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    composerM2661constructorimpl = Updater.m2661constructorimpl(composer2);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    boolean zBooleanValue = ((Boolean) anchoredDraggableState.getTargetValue()).booleanValue();
                    composer2.startReplaceableGroup(1157296644);
                    zChanged5 = composer2.changed(anchoredDraggableState);
                    objRememberedValue7 = composer2.rememberedValue();
                    if (zChanged5 || objRememberedValue7 == Composer.Companion.getEmpty()) {
                        objRememberedValue7 = new SwitchKt$Switch$5$1$1(anchoredDraggableState);
                        composer2.updateRememberedValue(objRememberedValue7);
                    }
                    composer2.endReplaceableGroup();
                    SwitchImpl(boxScopeInstance, zBooleanValue, z3, switchColorsM1239colorsSQMK_m0, (InterfaceC3588op) objRememberedValue7, mutableInteractionSource3, composer2, (i13 & 896) | 6 | ((i15 >> 6) & 7168) | ((i15 << 3) & 458752));
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z6 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    switchColors3 = switchColorsM1239colorsSQMK_m0;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    mutableInteractionSource4 = mutableInteractionSource2;
                    composer2 = composerStartRestartGroup;
                    switchColors3 = switchColors2;
                    z6 = z3;
                    modifier5 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass6(z, interfaceC3750qp, modifier5, z6, mutableInteractionSource4, switchColors3, i, i2));
            }
            i3 |= 3072;
            z3 = z2;
            i6 = i2 & 16;
            if (i6 != 0) {
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
            }
            if ((i & 458752) == 0) {
                switchColors2 = switchColors;
                if ((i2 & 32) == 0) {
                    i11 = 65536;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            } else {
                switchColors2 = switchColors;
            }
            if ((i3 & 374491) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
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
                        switchColorsM1239colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1239colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        i8 = i3 & (-458753);
                    } else {
                        i8 = i3;
                        switchColorsM1239colorsSQMK_m0 = switchColors2;
                    }
                    modifier4 = modifier3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
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
                        switchColorsM1239colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1239colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        i8 = i3 & (-458753);
                    } else {
                        i8 = i3;
                        switchColorsM1239colorsSQMK_m0 = switchColors2;
                    }
                    modifier4 = modifier3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(25866825, i8, -1, "androidx.compose.material.Switch (Switch.kt:94)");
                }
                fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(ThumbPathLength);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue2;
                fMo333toPx0680j_5 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(SwitchVelocityThreshold);
                Float fValueOf4 = Float.valueOf(fMo333toPx0680j_5);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(fValueOf4);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new AnchoredDraggableState(Boolean.valueOf(z), SwitchKt$Switch$anchoredDraggableState$1$1.INSTANCE, new SwitchKt$Switch$anchoredDraggableState$1$2(fMo333toPx0680j_5), AnimationSpec, null, 16, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new AnchoredDraggableState(Boolean.valueOf(z), SwitchKt$Switch$anchoredDraggableState$1$1.INSTANCE, new SwitchKt$Switch$anchoredDraggableState$1$2(fMo333toPx0680j_5), AnimationSpec, null, 16, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                anchoredDraggableState = (AnchoredDraggableState) objRememberedValue3;
                int i16 = i8 >> 3;
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, i16 & 14);
                int i17 = i8 & 14;
                stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(z), composerStartRestartGroup, i17);
                Float fValueOf5 = Float.valueOf(0.0f);
                Float fValueOf6 = Float.valueOf(fMo333toPx0680j_4);
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                zChanged2 = composerStartRestartGroup.changed(anchoredDraggableState) | composerStartRestartGroup.changed(fValueOf5) | composerStartRestartGroup.changed(fValueOf6);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    objRememberedValue4 = new SwitchKt$Switch$2$1(anchoredDraggableState, 0.0f, fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new SwitchKt$Switch$2$1(anchoredDraggableState, 0.0f, fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue4, composerStartRestartGroup, 0);
                objArr = new Object[]{anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState};
                composerStartRestartGroup.startReplaceableGroup(-568225417);
                i10 = 0;
                zChanged3 = false;
                while (i10 < i9) {
                    zChanged3 |= composerStartRestartGroup.changed(objArr[i10]);
                    i10++;
                }
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (zChanged3) {
                    objRememberedValue5 = new SwitchKt$Switch$3$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new SwitchKt$Switch$3$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect(anchoredDraggableState, (InterfaceC0526Fp) objRememberedValue5, composerStartRestartGroup, 64);
                Boolean boolValueOf4 = Boolean.valueOf(z);
                Boolean boolValueOf5 = Boolean.valueOf(Switch$lambda$3(mutableState));
                Boolean boolValueOf6 = Boolean.valueOf(z);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged4 = composerStartRestartGroup.changed(boolValueOf6) | composerStartRestartGroup.changed(anchoredDraggableState);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChanged4) {
                    objRememberedValue6 = new SwitchKt$Switch$4$1(z, anchoredDraggableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new SwitchKt$Switch$4$1(z, anchoredDraggableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect(boolValueOf4, boolValueOf5, (InterfaceC0526Fp) objRememberedValue6, composerStartRestartGroup, i17 | 512);
                if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (interfaceC3750qp != null) {
                    modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z3, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                } else {
                    modifierM711toggleableO2vRcR0 = Modifier.Companion;
                }
                if (interfaceC3750qp != null) {
                    modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                } else {
                    modifierMinimumInteractiveComponentSize = Modifier.Companion;
                }
                Modifier modifierThen2 = modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                Orientation orientation2 = Orientation.Horizontal;
                if (z3) {
                    z5 = false;
                } else {
                    z5 = false;
                }
                composer2 = composerStartRestartGroup;
                int i18 = i8;
                Modifier modifierAnchoredDraggable2 = AnchoredDraggableKt.anchoredDraggable(modifierThen2, anchoredDraggableState, orientation2, z5, z4, mutableInteractionSource3);
                Alignment.Companion companion4 = Alignment.Companion;
                Modifier modifierM526requiredSizeVpY3zN5 = SizeKt.m526requiredSizeVpY3zN4(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifierAnchoredDraggable2, companion4.getCenter(), false, 2, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion4.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion5 = ComposeUiNode.Companion;
                constructor = companion5.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifierM526requiredSizeVpY3zN5);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composerM2661constructorimpl = Updater.m2661constructorimpl(composer2);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy2, companion5.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion5.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                boolean zBooleanValue2 = ((Boolean) anchoredDraggableState.getTargetValue()).booleanValue();
                composer2.startReplaceableGroup(1157296644);
                zChanged5 = composer2.changed(anchoredDraggableState);
                objRememberedValue7 = composer2.rememberedValue();
                if (zChanged5) {
                    objRememberedValue7 = new SwitchKt$Switch$5$1$1(anchoredDraggableState);
                    composer2.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new SwitchKt$Switch$5$1$1(anchoredDraggableState);
                    composer2.updateRememberedValue(objRememberedValue7);
                }
                composer2.endReplaceableGroup();
                SwitchImpl(boxScopeInstance2, zBooleanValue2, z3, switchColorsM1239colorsSQMK_m0, (InterfaceC3588op) objRememberedValue7, mutableInteractionSource3, composer2, (i16 & 896) | 6 | ((i18 >> 6) & 7168) | ((i18 << 3) & 458752));
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z6 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
                switchColors3 = switchColorsM1239colorsSQMK_m0;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
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
                        switchColorsM1239colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1239colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        i8 = i3 & (-458753);
                    } else {
                        i8 = i3;
                        switchColorsM1239colorsSQMK_m0 = switchColors2;
                    }
                    modifier4 = modifier3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
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
                        switchColorsM1239colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1239colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        i8 = i3 & (-458753);
                    } else {
                        i8 = i3;
                        switchColorsM1239colorsSQMK_m0 = switchColors2;
                    }
                    modifier4 = modifier3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(25866825, i8, -1, "androidx.compose.material.Switch (Switch.kt:94)");
                }
                fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(ThumbPathLength);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue2;
                fMo333toPx0680j_5 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(SwitchVelocityThreshold);
                Float fValueOf7 = Float.valueOf(fMo333toPx0680j_5);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(fValueOf7);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new AnchoredDraggableState(Boolean.valueOf(z), SwitchKt$Switch$anchoredDraggableState$1$1.INSTANCE, new SwitchKt$Switch$anchoredDraggableState$1$2(fMo333toPx0680j_5), AnimationSpec, null, 16, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new AnchoredDraggableState(Boolean.valueOf(z), SwitchKt$Switch$anchoredDraggableState$1$1.INSTANCE, new SwitchKt$Switch$anchoredDraggableState$1$2(fMo333toPx0680j_5), AnimationSpec, null, 16, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                anchoredDraggableState = (AnchoredDraggableState) objRememberedValue3;
                int i19 = i8 >> 3;
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, i19 & 14);
                int i110 = i8 & 14;
                stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(z), composerStartRestartGroup, i110);
                Float fValueOf8 = Float.valueOf(0.0f);
                Float fValueOf9 = Float.valueOf(fMo333toPx0680j_4);
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                zChanged2 = composerStartRestartGroup.changed(anchoredDraggableState) | composerStartRestartGroup.changed(fValueOf8) | composerStartRestartGroup.changed(fValueOf9);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    objRememberedValue4 = new SwitchKt$Switch$2$1(anchoredDraggableState, 0.0f, fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new SwitchKt$Switch$2$1(anchoredDraggableState, 0.0f, fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue4, composerStartRestartGroup, 0);
                objArr = new Object[]{anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState};
                composerStartRestartGroup.startReplaceableGroup(-568225417);
                i10 = 0;
                zChanged3 = false;
                while (i10 < i9) {
                    zChanged3 |= composerStartRestartGroup.changed(objArr[i10]);
                    i10++;
                }
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (zChanged3) {
                    objRememberedValue5 = new SwitchKt$Switch$3$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new SwitchKt$Switch$3$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect(anchoredDraggableState, (InterfaceC0526Fp) objRememberedValue5, composerStartRestartGroup, 64);
                Boolean boolValueOf7 = Boolean.valueOf(z);
                Boolean boolValueOf8 = Boolean.valueOf(Switch$lambda$3(mutableState));
                Boolean boolValueOf9 = Boolean.valueOf(z);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged4 = composerStartRestartGroup.changed(boolValueOf9) | composerStartRestartGroup.changed(anchoredDraggableState);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChanged4) {
                    objRememberedValue6 = new SwitchKt$Switch$4$1(z, anchoredDraggableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new SwitchKt$Switch$4$1(z, anchoredDraggableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect(boolValueOf7, boolValueOf8, (InterfaceC0526Fp) objRememberedValue6, composerStartRestartGroup, i110 | 512);
                if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (interfaceC3750qp != null) {
                    modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z3, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                } else {
                    modifierM711toggleableO2vRcR0 = Modifier.Companion;
                }
                if (interfaceC3750qp != null) {
                    modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                } else {
                    modifierMinimumInteractiveComponentSize = Modifier.Companion;
                }
                Modifier modifierThen3 = modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                Orientation orientation3 = Orientation.Horizontal;
                if (z3) {
                    z5 = false;
                } else {
                    z5 = false;
                }
                composer2 = composerStartRestartGroup;
                int i111 = i8;
                Modifier modifierAnchoredDraggable3 = AnchoredDraggableKt.anchoredDraggable(modifierThen3, anchoredDraggableState, orientation3, z5, z4, mutableInteractionSource3);
                Alignment.Companion companion6 = Alignment.Companion;
                Modifier modifierM526requiredSizeVpY3zN6 = SizeKt.m526requiredSizeVpY3zN4(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifierAnchoredDraggable3, companion6.getCenter(), false, 2, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(companion6.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion7 = ComposeUiNode.Companion;
                constructor = companion7.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifierM526requiredSizeVpY3zN6);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composerM2661constructorimpl = Updater.m2661constructorimpl(composer2);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy3, companion7.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap3, companion7.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion7.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                boolean zBooleanValue3 = ((Boolean) anchoredDraggableState.getTargetValue()).booleanValue();
                composer2.startReplaceableGroup(1157296644);
                zChanged5 = composer2.changed(anchoredDraggableState);
                objRememberedValue7 = composer2.rememberedValue();
                if (zChanged5) {
                    objRememberedValue7 = new SwitchKt$Switch$5$1$1(anchoredDraggableState);
                    composer2.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new SwitchKt$Switch$5$1$1(anchoredDraggableState);
                    composer2.updateRememberedValue(objRememberedValue7);
                }
                composer2.endReplaceableGroup();
                SwitchImpl(boxScopeInstance3, zBooleanValue3, z3, switchColorsM1239colorsSQMK_m0, (InterfaceC3588op) objRememberedValue7, mutableInteractionSource3, composer2, (i19 & 896) | 6 | ((i111 >> 6) & 7168) | ((i111 << 3) & 458752));
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z6 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
                switchColors3 = switchColorsM1239colorsSQMK_m0;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass6(z, interfaceC3750qp, modifier5, z6, mutableInteractionSource4, switchColors3, i, i2));
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
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
            }
            if ((i & 458752) == 0) {
                switchColors2 = switchColors;
                if ((i2 & 32) == 0) {
                    i11 = 65536;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            } else {
                switchColors2 = switchColors;
            }
            if ((i3 & 374491) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
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
                        switchColorsM1239colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1239colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        i8 = i3 & (-458753);
                    } else {
                        i8 = i3;
                        switchColorsM1239colorsSQMK_m0 = switchColors2;
                    }
                    modifier4 = modifier3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
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
                        switchColorsM1239colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1239colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        i8 = i3 & (-458753);
                    } else {
                        i8 = i3;
                        switchColorsM1239colorsSQMK_m0 = switchColors2;
                    }
                    modifier4 = modifier3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(25866825, i8, -1, "androidx.compose.material.Switch (Switch.kt:94)");
                }
                fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(ThumbPathLength);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue2;
                fMo333toPx0680j_5 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(SwitchVelocityThreshold);
                Float fValueOf10 = Float.valueOf(fMo333toPx0680j_5);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(fValueOf10);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new AnchoredDraggableState(Boolean.valueOf(z), SwitchKt$Switch$anchoredDraggableState$1$1.INSTANCE, new SwitchKt$Switch$anchoredDraggableState$1$2(fMo333toPx0680j_5), AnimationSpec, null, 16, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new AnchoredDraggableState(Boolean.valueOf(z), SwitchKt$Switch$anchoredDraggableState$1$1.INSTANCE, new SwitchKt$Switch$anchoredDraggableState$1$2(fMo333toPx0680j_5), AnimationSpec, null, 16, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                anchoredDraggableState = (AnchoredDraggableState) objRememberedValue3;
                int i112 = i8 >> 3;
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, i112 & 14);
                int i113 = i8 & 14;
                stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(z), composerStartRestartGroup, i113);
                Float fValueOf11 = Float.valueOf(0.0f);
                Float fValueOf12 = Float.valueOf(fMo333toPx0680j_4);
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                zChanged2 = composerStartRestartGroup.changed(anchoredDraggableState) | composerStartRestartGroup.changed(fValueOf11) | composerStartRestartGroup.changed(fValueOf12);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    objRememberedValue4 = new SwitchKt$Switch$2$1(anchoredDraggableState, 0.0f, fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new SwitchKt$Switch$2$1(anchoredDraggableState, 0.0f, fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue4, composerStartRestartGroup, 0);
                objArr = new Object[]{anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState};
                composerStartRestartGroup.startReplaceableGroup(-568225417);
                i10 = 0;
                zChanged3 = false;
                while (i10 < i9) {
                    zChanged3 |= composerStartRestartGroup.changed(objArr[i10]);
                    i10++;
                }
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (zChanged3) {
                    objRememberedValue5 = new SwitchKt$Switch$3$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new SwitchKt$Switch$3$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect(anchoredDraggableState, (InterfaceC0526Fp) objRememberedValue5, composerStartRestartGroup, 64);
                Boolean boolValueOf10 = Boolean.valueOf(z);
                Boolean boolValueOf11 = Boolean.valueOf(Switch$lambda$3(mutableState));
                Boolean boolValueOf12 = Boolean.valueOf(z);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged4 = composerStartRestartGroup.changed(boolValueOf12) | composerStartRestartGroup.changed(anchoredDraggableState);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChanged4) {
                    objRememberedValue6 = new SwitchKt$Switch$4$1(z, anchoredDraggableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new SwitchKt$Switch$4$1(z, anchoredDraggableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect(boolValueOf10, boolValueOf11, (InterfaceC0526Fp) objRememberedValue6, composerStartRestartGroup, i113 | 512);
                if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (interfaceC3750qp != null) {
                    modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z3, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                } else {
                    modifierM711toggleableO2vRcR0 = Modifier.Companion;
                }
                if (interfaceC3750qp != null) {
                    modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                } else {
                    modifierMinimumInteractiveComponentSize = Modifier.Companion;
                }
                Modifier modifierThen4 = modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                Orientation orientation4 = Orientation.Horizontal;
                if (z3) {
                    z5 = false;
                } else {
                    z5 = false;
                }
                composer2 = composerStartRestartGroup;
                int i114 = i8;
                Modifier modifierAnchoredDraggable4 = AnchoredDraggableKt.anchoredDraggable(modifierThen4, anchoredDraggableState, orientation4, z5, z4, mutableInteractionSource3);
                Alignment.Companion companion8 = Alignment.Companion;
                Modifier modifierM526requiredSizeVpY3zN7 = SizeKt.m526requiredSizeVpY3zN4(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifierAnchoredDraggable4, companion8.getCenter(), false, 2, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(companion8.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion9 = ComposeUiNode.Companion;
                constructor = companion9.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(modifierM526requiredSizeVpY3zN7);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composerM2661constructorimpl = Updater.m2661constructorimpl(composer2);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy4, companion9.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap4, companion9.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion9.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf4.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                boolean zBooleanValue4 = ((Boolean) anchoredDraggableState.getTargetValue()).booleanValue();
                composer2.startReplaceableGroup(1157296644);
                zChanged5 = composer2.changed(anchoredDraggableState);
                objRememberedValue7 = composer2.rememberedValue();
                if (zChanged5) {
                    objRememberedValue7 = new SwitchKt$Switch$5$1$1(anchoredDraggableState);
                    composer2.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new SwitchKt$Switch$5$1$1(anchoredDraggableState);
                    composer2.updateRememberedValue(objRememberedValue7);
                }
                composer2.endReplaceableGroup();
                SwitchImpl(boxScopeInstance4, zBooleanValue4, z3, switchColorsM1239colorsSQMK_m0, (InterfaceC3588op) objRememberedValue7, mutableInteractionSource3, composer2, (i112 & 896) | 6 | ((i114 >> 6) & 7168) | ((i114 << 3) & 458752));
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z6 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
                switchColors3 = switchColorsM1239colorsSQMK_m0;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
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
                        switchColorsM1239colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1239colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        i8 = i3 & (-458753);
                    } else {
                        i8 = i3;
                        switchColorsM1239colorsSQMK_m0 = switchColors2;
                    }
                    modifier4 = modifier3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
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
                        switchColorsM1239colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1239colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                        i8 = i3 & (-458753);
                    } else {
                        i8 = i3;
                        switchColorsM1239colorsSQMK_m0 = switchColors2;
                    }
                    modifier4 = modifier3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(25866825, i8, -1, "androidx.compose.material.Switch (Switch.kt:94)");
                }
                fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(ThumbPathLength);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue2;
                fMo333toPx0680j_5 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(SwitchVelocityThreshold);
                Float fValueOf13 = Float.valueOf(fMo333toPx0680j_5);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(fValueOf13);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new AnchoredDraggableState(Boolean.valueOf(z), SwitchKt$Switch$anchoredDraggableState$1$1.INSTANCE, new SwitchKt$Switch$anchoredDraggableState$1$2(fMo333toPx0680j_5), AnimationSpec, null, 16, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new AnchoredDraggableState(Boolean.valueOf(z), SwitchKt$Switch$anchoredDraggableState$1$1.INSTANCE, new SwitchKt$Switch$anchoredDraggableState$1$2(fMo333toPx0680j_5), AnimationSpec, null, 16, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                anchoredDraggableState = (AnchoredDraggableState) objRememberedValue3;
                int i115 = i8 >> 3;
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, i115 & 14);
                int i116 = i8 & 14;
                stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(z), composerStartRestartGroup, i116);
                Float fValueOf14 = Float.valueOf(0.0f);
                Float fValueOf15 = Float.valueOf(fMo333toPx0680j_4);
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                zChanged2 = composerStartRestartGroup.changed(anchoredDraggableState) | composerStartRestartGroup.changed(fValueOf14) | composerStartRestartGroup.changed(fValueOf15);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    objRememberedValue4 = new SwitchKt$Switch$2$1(anchoredDraggableState, 0.0f, fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new SwitchKt$Switch$2$1(anchoredDraggableState, 0.0f, fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue4, composerStartRestartGroup, 0);
                objArr = new Object[]{anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState};
                composerStartRestartGroup.startReplaceableGroup(-568225417);
                i10 = 0;
                zChanged3 = false;
                while (i10 < i9) {
                    zChanged3 |= composerStartRestartGroup.changed(objArr[i10]);
                    i10++;
                }
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (zChanged3) {
                    objRememberedValue5 = new SwitchKt$Switch$3$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new SwitchKt$Switch$3$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect(anchoredDraggableState, (InterfaceC0526Fp) objRememberedValue5, composerStartRestartGroup, 64);
                Boolean boolValueOf13 = Boolean.valueOf(z);
                Boolean boolValueOf14 = Boolean.valueOf(Switch$lambda$3(mutableState));
                Boolean boolValueOf15 = Boolean.valueOf(z);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged4 = composerStartRestartGroup.changed(boolValueOf15) | composerStartRestartGroup.changed(anchoredDraggableState);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChanged4) {
                    objRememberedValue6 = new SwitchKt$Switch$4$1(z, anchoredDraggableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new SwitchKt$Switch$4$1(z, anchoredDraggableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect(boolValueOf13, boolValueOf14, (InterfaceC0526Fp) objRememberedValue6, composerStartRestartGroup, i116 | 512);
                if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (interfaceC3750qp != null) {
                    modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z3, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
                } else {
                    modifierM711toggleableO2vRcR0 = Modifier.Companion;
                }
                if (interfaceC3750qp != null) {
                    modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                } else {
                    modifierMinimumInteractiveComponentSize = Modifier.Companion;
                }
                Modifier modifierThen5 = modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
                Orientation orientation5 = Orientation.Horizontal;
                if (z3) {
                    z5 = false;
                } else {
                    z5 = false;
                }
                composer2 = composerStartRestartGroup;
                int i117 = i8;
                Modifier modifierAnchoredDraggable5 = AnchoredDraggableKt.anchoredDraggable(modifierThen5, anchoredDraggableState, orientation5, z5, z4, mutableInteractionSource3);
                Alignment.Companion companion10 = Alignment.Companion;
                Modifier modifierM526requiredSizeVpY3zN8 = SizeKt.m526requiredSizeVpY3zN4(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifierAnchoredDraggable5, companion10.getCenter(), false, 2, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy5 = BoxKt.rememberBoxMeasurePolicy(companion10.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion11 = ComposeUiNode.Companion;
                constructor = companion11.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(modifierM526requiredSizeVpY3zN8);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composerM2661constructorimpl = Updater.m2661constructorimpl(composer2);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy5, companion11.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap5, companion11.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion11.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf5.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                boolean zBooleanValue5 = ((Boolean) anchoredDraggableState.getTargetValue()).booleanValue();
                composer2.startReplaceableGroup(1157296644);
                zChanged5 = composer2.changed(anchoredDraggableState);
                objRememberedValue7 = composer2.rememberedValue();
                if (zChanged5) {
                    objRememberedValue7 = new SwitchKt$Switch$5$1$1(anchoredDraggableState);
                    composer2.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new SwitchKt$Switch$5$1$1(anchoredDraggableState);
                    composer2.updateRememberedValue(objRememberedValue7);
                }
                composer2.endReplaceableGroup();
                SwitchImpl(boxScopeInstance5, zBooleanValue5, z3, switchColorsM1239colorsSQMK_m0, (InterfaceC3588op) objRememberedValue7, mutableInteractionSource3, composer2, (i115 & 896) | 6 | ((i117 >> 6) & 7168) | ((i117 << 3) & 458752));
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z6 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
                switchColors3 = switchColorsM1239colorsSQMK_m0;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass6(z, interfaceC3750qp, modifier5, z6, mutableInteractionSource4, switchColors3, i, i2));
        }
        i3 |= 3072;
        z3 = z2;
        i6 = i2 & 16;
        if (i6 != 0) {
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
        }
        if ((i & 458752) == 0) {
            switchColors2 = switchColors;
            if ((i2 & 32) == 0) {
                i11 = 65536;
            } else {
                i11 = 65536;
            }
            i3 |= i11;
        } else {
            switchColors2 = switchColors;
        }
        if ((i3 & 374491) == 74898) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
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
                    switchColorsM1239colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1239colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                    i8 = i3 & (-458753);
                } else {
                    i8 = i3;
                    switchColorsM1239colorsSQMK_m0 = switchColors2;
                }
                modifier4 = modifier3;
            } else {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
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
                    switchColorsM1239colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1239colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                    i8 = i3 & (-458753);
                } else {
                    i8 = i3;
                    switchColorsM1239colorsSQMK_m0 = switchColors2;
                }
                modifier4 = modifier3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(25866825, i8, -1, "androidx.compose.material.Switch (Switch.kt:94)");
            }
            fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(ThumbPathLength);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            companion = Composer.Companion;
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableState = (MutableState) objRememberedValue2;
            fMo333toPx0680j_5 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(SwitchVelocityThreshold);
            Float fValueOf16 = Float.valueOf(fMo333toPx0680j_5);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(fValueOf16);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue3 = new AnchoredDraggableState(Boolean.valueOf(z), SwitchKt$Switch$anchoredDraggableState$1$1.INSTANCE, new SwitchKt$Switch$anchoredDraggableState$1$2(fMo333toPx0680j_5), AnimationSpec, null, 16, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new AnchoredDraggableState(Boolean.valueOf(z), SwitchKt$Switch$anchoredDraggableState$1$1.INSTANCE, new SwitchKt$Switch$anchoredDraggableState$1$2(fMo333toPx0680j_5), AnimationSpec, null, 16, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            anchoredDraggableState = (AnchoredDraggableState) objRememberedValue3;
            int i118 = i8 >> 3;
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, i118 & 14);
            int i119 = i8 & 14;
            stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(z), composerStartRestartGroup, i119);
            Float fValueOf17 = Float.valueOf(0.0f);
            Float fValueOf18 = Float.valueOf(fMo333toPx0680j_4);
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            zChanged2 = composerStartRestartGroup.changed(anchoredDraggableState) | composerStartRestartGroup.changed(fValueOf17) | composerStartRestartGroup.changed(fValueOf18);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged2) {
                objRememberedValue4 = new SwitchKt$Switch$2$1(anchoredDraggableState, 0.0f, fMo333toPx0680j_4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new SwitchKt$Switch$2$1(anchoredDraggableState, 0.0f, fMo333toPx0680j_4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue4, composerStartRestartGroup, 0);
            objArr = new Object[]{anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            i10 = 0;
            zChanged3 = false;
            while (i10 < i9) {
                zChanged3 |= composerStartRestartGroup.changed(objArr[i10]);
                i10++;
            }
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged3) {
                objRememberedValue5 = new SwitchKt$Switch$3$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new SwitchKt$Switch$3$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(anchoredDraggableState, (InterfaceC0526Fp) objRememberedValue5, composerStartRestartGroup, 64);
            Boolean boolValueOf16 = Boolean.valueOf(z);
            Boolean boolValueOf17 = Boolean.valueOf(Switch$lambda$3(mutableState));
            Boolean boolValueOf18 = Boolean.valueOf(z);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged4 = composerStartRestartGroup.changed(boolValueOf18) | composerStartRestartGroup.changed(anchoredDraggableState);
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChanged4) {
                objRememberedValue6 = new SwitchKt$Switch$4$1(z, anchoredDraggableState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new SwitchKt$Switch$4$1(z, anchoredDraggableState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(boolValueOf16, boolValueOf17, (InterfaceC0526Fp) objRememberedValue6, composerStartRestartGroup, i119 | 512);
            if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (interfaceC3750qp != null) {
                modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z3, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
            } else {
                modifierM711toggleableO2vRcR0 = Modifier.Companion;
            }
            if (interfaceC3750qp != null) {
                modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
            } else {
                modifierMinimumInteractiveComponentSize = Modifier.Companion;
            }
            Modifier modifierThen6 = modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
            Orientation orientation6 = Orientation.Horizontal;
            if (z3) {
                z5 = false;
            } else {
                z5 = false;
            }
            composer2 = composerStartRestartGroup;
            int i1110 = i8;
            Modifier modifierAnchoredDraggable6 = AnchoredDraggableKt.anchoredDraggable(modifierThen6, anchoredDraggableState, orientation6, z5, z4, mutableInteractionSource3);
            Alignment.Companion companion12 = Alignment.Companion;
            Modifier modifierM526requiredSizeVpY3zN9 = SizeKt.m526requiredSizeVpY3zN4(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifierAnchoredDraggable6, companion12.getCenter(), false, 2, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy6 = BoxKt.rememberBoxMeasurePolicy(companion12.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap6 = composer2.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion13 = ComposeUiNode.Companion;
            constructor = companion13.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf6 = LayoutKt.modifierMaterializerOf(modifierM526requiredSizeVpY3zN9);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            composerM2661constructorimpl = Updater.m2661constructorimpl(composer2);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy6, companion13.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap6, companion13.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion13.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting()) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf6.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
            boolean zBooleanValue6 = ((Boolean) anchoredDraggableState.getTargetValue()).booleanValue();
            composer2.startReplaceableGroup(1157296644);
            zChanged5 = composer2.changed(anchoredDraggableState);
            objRememberedValue7 = composer2.rememberedValue();
            if (zChanged5) {
                objRememberedValue7 = new SwitchKt$Switch$5$1$1(anchoredDraggableState);
                composer2.updateRememberedValue(objRememberedValue7);
            } else {
                objRememberedValue7 = new SwitchKt$Switch$5$1$1(anchoredDraggableState);
                composer2.updateRememberedValue(objRememberedValue7);
            }
            composer2.endReplaceableGroup();
            SwitchImpl(boxScopeInstance6, zBooleanValue6, z3, switchColorsM1239colorsSQMK_m0, (InterfaceC3588op) objRememberedValue7, mutableInteractionSource3, composer2, (i118 & 896) | 6 | ((i1110 >> 6) & 7168) | ((i1110 << 3) & 458752));
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            z6 = z3;
            mutableInteractionSource4 = mutableInteractionSource3;
            switchColors3 = switchColorsM1239colorsSQMK_m0;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
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
                    switchColorsM1239colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1239colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                    i8 = i3 & (-458753);
                } else {
                    i8 = i3;
                    switchColorsM1239colorsSQMK_m0 = switchColors2;
                }
                modifier4 = modifier3;
            } else {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
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
                    switchColorsM1239colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1239colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, IEEEDouble.EXPONENT_BIAS);
                    i8 = i3 & (-458753);
                } else {
                    i8 = i3;
                    switchColorsM1239colorsSQMK_m0 = switchColors2;
                }
                modifier4 = modifier3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(25866825, i8, -1, "androidx.compose.material.Switch (Switch.kt:94)");
            }
            fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(ThumbPathLength);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            companion = Composer.Companion;
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableState = (MutableState) objRememberedValue2;
            fMo333toPx0680j_5 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(SwitchVelocityThreshold);
            Float fValueOf19 = Float.valueOf(fMo333toPx0680j_5);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(fValueOf19);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue3 = new AnchoredDraggableState(Boolean.valueOf(z), SwitchKt$Switch$anchoredDraggableState$1$1.INSTANCE, new SwitchKt$Switch$anchoredDraggableState$1$2(fMo333toPx0680j_5), AnimationSpec, null, 16, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new AnchoredDraggableState(Boolean.valueOf(z), SwitchKt$Switch$anchoredDraggableState$1$1.INSTANCE, new SwitchKt$Switch$anchoredDraggableState$1$2(fMo333toPx0680j_5), AnimationSpec, null, 16, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            anchoredDraggableState = (AnchoredDraggableState) objRememberedValue3;
            int i1111 = i8 >> 3;
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composerStartRestartGroup, i1111 & 14);
            int i1112 = i8 & 14;
            stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(z), composerStartRestartGroup, i1112);
            Float fValueOf110 = Float.valueOf(0.0f);
            Float fValueOf111 = Float.valueOf(fMo333toPx0680j_4);
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            zChanged2 = composerStartRestartGroup.changed(anchoredDraggableState) | composerStartRestartGroup.changed(fValueOf110) | composerStartRestartGroup.changed(fValueOf111);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged2) {
                objRememberedValue4 = new SwitchKt$Switch$2$1(anchoredDraggableState, 0.0f, fMo333toPx0680j_4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new SwitchKt$Switch$2$1(anchoredDraggableState, 0.0f, fMo333toPx0680j_4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue4, composerStartRestartGroup, 0);
            objArr = new Object[]{anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            i10 = 0;
            zChanged3 = false;
            while (i10 < i9) {
                zChanged3 |= composerStartRestartGroup.changed(objArr[i10]);
                i10++;
            }
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged3) {
                objRememberedValue5 = new SwitchKt$Switch$3$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new SwitchKt$Switch$3$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(anchoredDraggableState, (InterfaceC0526Fp) objRememberedValue5, composerStartRestartGroup, 64);
            Boolean boolValueOf19 = Boolean.valueOf(z);
            Boolean boolValueOf110 = Boolean.valueOf(Switch$lambda$3(mutableState));
            Boolean boolValueOf111 = Boolean.valueOf(z);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged4 = composerStartRestartGroup.changed(boolValueOf111) | composerStartRestartGroup.changed(anchoredDraggableState);
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChanged4) {
                objRememberedValue6 = new SwitchKt$Switch$4$1(z, anchoredDraggableState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new SwitchKt$Switch$4$1(z, anchoredDraggableState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(boolValueOf19, boolValueOf110, (InterfaceC0526Fp) objRememberedValue6, composerStartRestartGroup, i1112 | 512);
            if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (interfaceC3750qp != null) {
                modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(Modifier.Companion, z, mutableInteractionSource3, null, z3, Role.m4543boximpl(Role.Companion.m4555getSwitcho7Vup1c()), interfaceC3750qp);
            } else {
                modifierM711toggleableO2vRcR0 = Modifier.Companion;
            }
            if (interfaceC3750qp != null) {
                modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
            } else {
                modifierMinimumInteractiveComponentSize = Modifier.Companion;
            }
            Modifier modifierThen7 = modifier4.then(modifierMinimumInteractiveComponentSize).then(modifierM711toggleableO2vRcR0);
            Orientation orientation7 = Orientation.Horizontal;
            if (z3) {
                z5 = false;
            } else {
                z5 = false;
            }
            composer2 = composerStartRestartGroup;
            int i1113 = i8;
            Modifier modifierAnchoredDraggable7 = AnchoredDraggableKt.anchoredDraggable(modifierThen7, anchoredDraggableState, orientation7, z5, z4, mutableInteractionSource3);
            Alignment.Companion companion14 = Alignment.Companion;
            Modifier modifierM526requiredSizeVpY3zN10 = SizeKt.m526requiredSizeVpY3zN4(PaddingKt.m485padding3ABfNKs(SizeKt.wrapContentSize$default(modifierAnchoredDraggable7, companion14.getCenter(), false, 2, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy7 = BoxKt.rememberBoxMeasurePolicy(companion14.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap7 = composer2.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion15 = ComposeUiNode.Companion;
            constructor = companion15.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf7 = LayoutKt.modifierMaterializerOf(modifierM526requiredSizeVpY3zN10);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            composerM2661constructorimpl = Updater.m2661constructorimpl(composer2);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy7, companion15.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap7, companion15.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion15.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting()) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf7.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
            boolean zBooleanValue7 = ((Boolean) anchoredDraggableState.getTargetValue()).booleanValue();
            composer2.startReplaceableGroup(1157296644);
            zChanged5 = composer2.changed(anchoredDraggableState);
            objRememberedValue7 = composer2.rememberedValue();
            if (zChanged5) {
                objRememberedValue7 = new SwitchKt$Switch$5$1$1(anchoredDraggableState);
                composer2.updateRememberedValue(objRememberedValue7);
            } else {
                objRememberedValue7 = new SwitchKt$Switch$5$1$1(anchoredDraggableState);
                composer2.updateRememberedValue(objRememberedValue7);
            }
            composer2.endReplaceableGroup();
            SwitchImpl(boxScopeInstance7, zBooleanValue7, z3, switchColorsM1239colorsSQMK_m0, (InterfaceC3588op) objRememberedValue7, mutableInteractionSource3, composer2, (i1111 & 896) | 6 | ((i1113 >> 6) & 7168) | ((i1113 << 3) & 458752));
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            z6 = z3;
            mutableInteractionSource4 = mutableInteractionSource3;
            switchColors3 = switchColorsM1239colorsSQMK_m0;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass6(z, interfaceC3750qp, modifier5, z6, mutableInteractionSource4, switchColors3, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Switch$lambda$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Switch$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC3750qp Switch$lambda$7(State<? extends InterfaceC3750qp> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Switch$lambda$8(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SwitchImpl(BoxScope boxScope, boolean z, boolean z2, SwitchColors switchColors, InterfaceC3588op interfaceC3588op, InteractionSource interactionSource, Composer composer, int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(70908914);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(switchColors) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC3588op) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(interactionSource) ? 131072 : 65536;
        }
        if ((374491 & i2) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(70908914, i2, -1, "androidx.compose.material.SwitchImpl (Switch.kt:212)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateListOf();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue;
            int i3 = (i2 >> 15) & 14;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged = composerStartRestartGroup.changed(interactionSource) | composerStartRestartGroup.changed(snapshotStateList);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new SwitchKt$SwitchImpl$1$1(interactionSource, snapshotStateList, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(interactionSource, (InterfaceC0526Fp) objRememberedValue2, composerStartRestartGroup, i3 | 64);
            float f = !snapshotStateList.isEmpty() ? ThumbPressedElevation : ThumbDefaultElevation;
            int i4 = ((i2 >> 6) & 14) | (i2 & 112) | ((i2 >> 3) & 896);
            State<Color> stateTrackColor = switchColors.trackColor(z2, z, composerStartRestartGroup, i4);
            Modifier.Companion companion2 = Modifier.Companion;
            Alignment.Companion companion3 = Alignment.Companion;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(boxScope.align(companion2, companion3.getCenter()), 0.0f, 1, null);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged2 = composerStartRestartGroup.changed(stateTrackColor);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new SwitchKt$SwitchImpl$2$1(stateTrackColor);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(modifierFillMaxSize$default, (InterfaceC3750qp) objRememberedValue3, composerStartRestartGroup, 0);
            State<Color> stateThumbColor = switchColors.thumbColor(z2, z, composerStartRestartGroup, i4);
            ElevationOverlay elevationOverlay = (ElevationOverlay) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalElevationOverlay());
            float fM5160constructorimpl = Dp.m5160constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5174unboximpl() + f);
            composerStartRestartGroup.startReplaceableGroup(-539243578);
            long jSwitchImpl$lambda$18 = (!Color.m3033equalsimpl0(SwitchImpl$lambda$18(stateThumbColor), MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU()) || elevationOverlay == null) ? SwitchImpl$lambda$18(stateThumbColor) : elevationOverlay.mo1085apply7g2Lkgo(SwitchImpl$lambda$18(stateThumbColor), fM5160constructorimpl, composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceableGroup();
            composer2 = composerStartRestartGroup;
            State<Color> stateM72animateColorAsStateeuL9pac = SingleValueAnimationKt.m72animateColorAsStateeuL9pac(jSwitchImpl$lambda$18, null, null, null, composerStartRestartGroup, 0, 14);
            Modifier modifierAlign = boxScope.align(companion2, companion3.getCenterStart());
            composer2.startReplaceableGroup(1157296644);
            boolean zChanged3 = composer2.changed(interfaceC3588op);
            Object objRememberedValue4 = composer2.rememberedValue();
            if (zChanged3 || objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new SwitchKt$SwitchImpl$3$1(interfaceC3588op);
                composer2.updateRememberedValue(objRememberedValue4);
            }
            composer2.endReplaceableGroup();
            SpacerKt.Spacer(BackgroundKt.m166backgroundbw27NRU(ShadowKt.m2707shadows4CzXII$default(SizeKt.m524requiredSize3ABfNKs(IndicationKt.indication(OffsetKt.offset(modifierAlign, (InterfaceC3750qp) objRememberedValue4), interactionSource, RippleKt.m1318rememberRipple9IZ8Weo(false, ThumbRippleRadius, 0L, composer2, 54, 4)), ThumbDiameter), f, RoundedCornerShapeKt.getCircleShape(), false, 0L, 0L, 24, null), SwitchImpl$lambda$19(stateM72animateColorAsStateeuL9pac), RoundedCornerShapeKt.getCircleShape()), composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(boxScope, z, z2, switchColors, interfaceC3588op, interactionSource, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long SwitchImpl$lambda$16(State<Color> state) {
        return state.getValue().m3042unboximpl();
    }

    private static final long SwitchImpl$lambda$18(State<Color> state) {
        return state.getValue().m3042unboximpl();
    }

    private static final long SwitchImpl$lambda$19(State<Color> state) {
        return state.getValue().m3042unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawTrack-RPmYEkk, reason: not valid java name */
    public static final void m1241drawTrackRPmYEkk(DrawScope drawScope, long j, float f, float f2) {
        float f3 = f2 / 2;
        AbstractC3255kk.C(drawScope, j, androidx.compose.ui.geometry.OffsetKt.Offset(f3, Offset.m2799getYimpl(drawScope.mo3468getCenterF1C5BW0())), androidx.compose.ui.geometry.OffsetKt.Offset(f - f3, Offset.m2799getYimpl(drawScope.mo3468getCenterF1C5BW0())), f2, StrokeCap.Companion.m3357getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }

    public static final float getTrackStrokeWidth() {
        return TrackStrokeWidth;
    }

    public static final float getTrackWidth() {
        return TrackWidth;
    }
}
