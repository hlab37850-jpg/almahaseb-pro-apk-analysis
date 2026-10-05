package androidx.compose.material;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.selection.ToggleableKt;
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
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class IconButtonKt {
    private static final float RippleRadius = Dp.m5160constructorimpl(24);

    /* JADX INFO: renamed from: androidx.compose.material.IconButtonKt$IconButton$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC0526Fp $content;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3588op $onClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, InterfaceC0526Fp interfaceC0526Fp, int i, int i2) {
            super(2);
            this.$onClick = interfaceC3588op;
            this.$modifier = modifier;
            this.$enabled = z;
            this.$interactionSource = mutableInteractionSource;
            this.$content = interfaceC0526Fp;
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
            IconButtonKt.IconButton(this.$onClick, this.$modifier, this.$enabled, this.$interactionSource, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.IconButtonKt$IconToggleButton$3, reason: invalid class name and case insensitive filesystem */
    public static final class C14233 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ boolean $checked;
        final /* synthetic */ InterfaceC0526Fp $content;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3750qp $onCheckedChange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14233(boolean z, InterfaceC3750qp interfaceC3750qp, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, InterfaceC0526Fp interfaceC0526Fp, int i, int i2) {
            super(2);
            this.$checked = z;
            this.$onCheckedChange = interfaceC3750qp;
            this.$modifier = modifier;
            this.$enabled = z2;
            this.$interactionSource = mutableInteractionSource;
            this.$content = interfaceC0526Fp;
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
            IconButtonKt.IconToggleButton(this.$checked, this.$onCheckedChange, this.$modifier, this.$enabled, this.$interactionSource, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0221  */
    /* JADX WARN: Code duplicated, block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0055  */
    /* JADX WARN: Code duplicated, block: B:28:0x005a  */
    /* JADX WARN: Code duplicated, block: B:30:0x005e  */
    /* JADX WARN: Code duplicated, block: B:32:0x0066  */
    /* JADX WARN: Code duplicated, block: B:33:0x0069  */
    /* JADX WARN: Code duplicated, block: B:37:0x0070  */
    /* JADX WARN: Code duplicated, block: B:39:0x0075  */
    /* JADX WARN: Code duplicated, block: B:41:0x0079  */
    /* JADX WARN: Code duplicated, block: B:43:0x0081  */
    /* JADX WARN: Code duplicated, block: B:44:0x0084  */
    /* JADX WARN: Code duplicated, block: B:48:0x008c  */
    /* JADX WARN: Code duplicated, block: B:49:0x008f  */
    /* JADX WARN: Code duplicated, block: B:51:0x0095  */
    /* JADX WARN: Code duplicated, block: B:53:0x009b  */
    /* JADX WARN: Code duplicated, block: B:54:0x009e  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:69:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:71:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:76:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:79:0x015a  */
    /* JADX WARN: Code duplicated, block: B:82:0x0166  */
    /* JADX WARN: Code duplicated, block: B:83:0x016a  */
    /* JADX WARN: Code duplicated, block: B:86:0x0189  */
    /* JADX WARN: Code duplicated, block: B:88:0x0197  */
    /* JADX WARN: Code duplicated, block: B:91:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:93:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:96:0x0211  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void IconButton(InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        int i8;
        Modifier modifier3;
        boolean z3;
        MutableInteractionSource mutableInteractionSource3;
        Composer composer2;
        int currentCompositeKeyHash;
        InterfaceC3588op constructor;
        Composer composerM2661constructorimpl;
        InterfaceC0526Fp setCompositeKeyHash;
        float disabled;
        Modifier modifier4;
        boolean z4;
        MutableInteractionSource mutableInteractionSource4;
        Object objRememberedValue;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-111063634);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC3588op) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 7168) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((i2 & 16) != 0) {
                        i3 |= 24576;
                    } else if ((57344 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                            i8 = 16384;
                        } else {
                            i8 = 8192;
                        }
                        i3 |= i8;
                    }
                    if ((46811 & i3) == 9362 || !composerStartRestartGroup.getSkipping()) {
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
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-111063634, i3, -1, "androidx.compose.material.IconButton (IconButton.kt:58)");
                        }
                        int i10 = i3;
                        composer2 = composerStartRestartGroup;
                        Modifier modifierM197clickableO2vRcR0 = ClickableKt.m197clickableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : Role.m4543boximpl(Role.Companion.m4550getButtono7Vup1c()), interfaceC3588op);
                        Alignment center = Alignment.Companion.getCenter();
                        composer2.startReplaceableGroup(733328855);
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                        composer2.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                        constructor = companion.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierM197clickableO2vRcR0);
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
                        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion.getSetCompositeKeyHash();
                        if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        if (z3) {
                            composer2.startReplaceableGroup(753555784);
                            disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                        } else {
                            composer2.startReplaceableGroup(753555810);
                            disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                        }
                        composer2.endReplaceableGroup();
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i10 >> 9) & 112) | 8);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier4 = modifier2;
                        z4 = z2;
                        composer2 = composerStartRestartGroup;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC3588op, modifier4, z4, mutableInteractionSource4, interfaceC0526Fp, i, i2));
                }
                i3 |= 3072;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((57344 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                if ((46811 & i3) == 9362) {
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
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-111063634, i3, -1, "androidx.compose.material.IconButton (IconButton.kt:58)");
                    }
                    int i11 = i3;
                    composer2 = composerStartRestartGroup;
                    Modifier modifierM197clickableO2vRcR1 = ClickableKt.m197clickableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : Role.m4543boximpl(Role.Companion.m4550getButtono7Vup1c()), interfaceC3588op);
                    Alignment center2 = Alignment.Companion.getCenter();
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                    constructor = companion2.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifierM197clickableO2vRcR1);
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
                    interfaceC0552GpModifierMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    if (z3) {
                        composer2.startReplaceableGroup(753555784);
                        disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                    } else {
                        composer2.startReplaceableGroup(753555810);
                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                    }
                    composer2.endReplaceableGroup();
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i11 >> 9) & 112) | 8);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
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
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-111063634, i3, -1, "androidx.compose.material.IconButton (IconButton.kt:58)");
                    }
                    int i12 = i3;
                    composer2 = composerStartRestartGroup;
                    Modifier modifierM197clickableO2vRcR2 = ClickableKt.m197clickableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : Role.m4543boximpl(Role.Companion.m4550getButtono7Vup1c()), interfaceC3588op);
                    Alignment center3 = Alignment.Companion.getCenter();
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(center3, false, composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
                    constructor = companion3.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifierM197clickableO2vRcR2);
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
                    interfaceC0552GpModifierMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    if (z3) {
                        composer2.startReplaceableGroup(753555784);
                        disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                    } else {
                        composer2.startReplaceableGroup(753555810);
                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                    }
                    composer2.endReplaceableGroup();
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i12 >> 9) & 112) | 8);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC3588op, modifier4, z4, mutableInteractionSource4, interfaceC0526Fp, i, i2));
            }
            i3 |= 384;
            z2 = z;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((57344 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                if ((46811 & i3) == 9362) {
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
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-111063634, i3, -1, "androidx.compose.material.IconButton (IconButton.kt:58)");
                    }
                    int i13 = i3;
                    composer2 = composerStartRestartGroup;
                    Modifier modifierM197clickableO2vRcR3 = ClickableKt.m197clickableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : Role.m4543boximpl(Role.Companion.m4550getButtono7Vup1c()), interfaceC3588op);
                    Alignment center4 = Alignment.Companion.getCenter();
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(center4, false, composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion4 = ComposeUiNode.Companion;
                    constructor = companion4.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(modifierM197clickableO2vRcR3);
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
                    interfaceC0552GpModifierMaterializerOf4.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                    if (z3) {
                        composer2.startReplaceableGroup(753555784);
                        disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                    } else {
                        composer2.startReplaceableGroup(753555810);
                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                    }
                    composer2.endReplaceableGroup();
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i13 >> 9) & 112) | 8);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
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
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-111063634, i3, -1, "androidx.compose.material.IconButton (IconButton.kt:58)");
                    }
                    int i14 = i3;
                    composer2 = composerStartRestartGroup;
                    Modifier modifierM197clickableO2vRcR4 = ClickableKt.m197clickableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : Role.m4543boximpl(Role.Companion.m4550getButtono7Vup1c()), interfaceC3588op);
                    Alignment center5 = Alignment.Companion.getCenter();
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy5 = BoxKt.rememberBoxMeasurePolicy(center5, false, composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion5 = ComposeUiNode.Companion;
                    constructor = companion5.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(modifierM197clickableO2vRcR4);
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
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy5, companion5.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap5, companion5.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion5.getSetCompositeKeyHash();
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
                    if (z3) {
                        composer2.startReplaceableGroup(753555784);
                        disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                    } else {
                        composer2.startReplaceableGroup(753555810);
                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                    }
                    composer2.endReplaceableGroup();
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i14 >> 9) & 112) | 8);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC3588op, modifier4, z4, mutableInteractionSource4, interfaceC0526Fp, i, i2));
            }
            i3 |= 3072;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 16) != 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            }
            if ((46811 & i3) == 9362) {
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
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-111063634, i3, -1, "androidx.compose.material.IconButton (IconButton.kt:58)");
                }
                int i15 = i3;
                composer2 = composerStartRestartGroup;
                Modifier modifierM197clickableO2vRcR5 = ClickableKt.m197clickableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : Role.m4543boximpl(Role.Companion.m4550getButtono7Vup1c()), interfaceC3588op);
                Alignment center6 = Alignment.Companion.getCenter();
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy6 = BoxKt.rememberBoxMeasurePolicy(center6, false, composer2, 6);
                composer2.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap6 = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion6 = ComposeUiNode.Companion;
                constructor = companion6.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf6 = LayoutKt.modifierMaterializerOf(modifierM197clickableO2vRcR5);
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
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy6, companion6.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap6, companion6.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion6.getSetCompositeKeyHash();
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
                if (z3) {
                    composer2.startReplaceableGroup(753555784);
                    disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                } else {
                    composer2.startReplaceableGroup(753555810);
                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                }
                composer2.endReplaceableGroup();
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i15 >> 9) & 112) | 8);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z4 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
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
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-111063634, i3, -1, "androidx.compose.material.IconButton (IconButton.kt:58)");
                }
                int i16 = i3;
                composer2 = composerStartRestartGroup;
                Modifier modifierM197clickableO2vRcR6 = ClickableKt.m197clickableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : Role.m4543boximpl(Role.Companion.m4550getButtono7Vup1c()), interfaceC3588op);
                Alignment center7 = Alignment.Companion.getCenter();
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy7 = BoxKt.rememberBoxMeasurePolicy(center7, false, composer2, 6);
                composer2.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap7 = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion7 = ComposeUiNode.Companion;
                constructor = companion7.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf7 = LayoutKt.modifierMaterializerOf(modifierM197clickableO2vRcR6);
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
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy7, companion7.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap7, companion7.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion7.getSetCompositeKeyHash();
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
                if (z3) {
                    composer2.startReplaceableGroup(753555784);
                    disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                } else {
                    composer2.startReplaceableGroup(753555810);
                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                }
                composer2.endReplaceableGroup();
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i16 >> 9) & 112) | 8);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z4 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC3588op, modifier4, z4, mutableInteractionSource4, interfaceC0526Fp, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((57344 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                if ((46811 & i3) == 9362) {
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
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-111063634, i3, -1, "androidx.compose.material.IconButton (IconButton.kt:58)");
                    }
                    int i17 = i3;
                    composer2 = composerStartRestartGroup;
                    Modifier modifierM197clickableO2vRcR7 = ClickableKt.m197clickableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : Role.m4543boximpl(Role.Companion.m4550getButtono7Vup1c()), interfaceC3588op);
                    Alignment center8 = Alignment.Companion.getCenter();
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy8 = BoxKt.rememberBoxMeasurePolicy(center8, false, composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap8 = composer2.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion8 = ComposeUiNode.Companion;
                    constructor = companion8.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf8 = LayoutKt.modifierMaterializerOf(modifierM197clickableO2vRcR7);
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
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy8, companion8.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap8, companion8.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion8.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf8.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
                    if (z3) {
                        composer2.startReplaceableGroup(753555784);
                        disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                    } else {
                        composer2.startReplaceableGroup(753555810);
                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                    }
                    composer2.endReplaceableGroup();
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i17 >> 9) & 112) | 8);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
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
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-111063634, i3, -1, "androidx.compose.material.IconButton (IconButton.kt:58)");
                    }
                    int i18 = i3;
                    composer2 = composerStartRestartGroup;
                    Modifier modifierM197clickableO2vRcR8 = ClickableKt.m197clickableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : Role.m4543boximpl(Role.Companion.m4550getButtono7Vup1c()), interfaceC3588op);
                    Alignment center9 = Alignment.Companion.getCenter();
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy9 = BoxKt.rememberBoxMeasurePolicy(center9, false, composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap9 = composer2.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion9 = ComposeUiNode.Companion;
                    constructor = companion9.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf9 = LayoutKt.modifierMaterializerOf(modifierM197clickableO2vRcR8);
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
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy9, companion9.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap9, companion9.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion9.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf9.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance9 = BoxScopeInstance.INSTANCE;
                    if (z3) {
                        composer2.startReplaceableGroup(753555784);
                        disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                    } else {
                        composer2.startReplaceableGroup(753555810);
                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                    }
                    composer2.endReplaceableGroup();
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i18 >> 9) & 112) | 8);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC3588op, modifier4, z4, mutableInteractionSource4, interfaceC0526Fp, i, i2));
            }
            i3 |= 3072;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 16) != 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            }
            if ((46811 & i3) == 9362) {
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
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-111063634, i3, -1, "androidx.compose.material.IconButton (IconButton.kt:58)");
                }
                int i19 = i3;
                composer2 = composerStartRestartGroup;
                Modifier modifierM197clickableO2vRcR9 = ClickableKt.m197clickableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : Role.m4543boximpl(Role.Companion.m4550getButtono7Vup1c()), interfaceC3588op);
                Alignment center10 = Alignment.Companion.getCenter();
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy10 = BoxKt.rememberBoxMeasurePolicy(center10, false, composer2, 6);
                composer2.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap10 = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion10 = ComposeUiNode.Companion;
                constructor = companion10.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf10 = LayoutKt.modifierMaterializerOf(modifierM197clickableO2vRcR9);
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
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy10, companion10.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap10, companion10.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion10.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf10.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance10 = BoxScopeInstance.INSTANCE;
                if (z3) {
                    composer2.startReplaceableGroup(753555784);
                    disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                } else {
                    composer2.startReplaceableGroup(753555810);
                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                }
                composer2.endReplaceableGroup();
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i19 >> 9) & 112) | 8);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z4 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
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
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-111063634, i3, -1, "androidx.compose.material.IconButton (IconButton.kt:58)");
                }
                int i110 = i3;
                composer2 = composerStartRestartGroup;
                Modifier modifierM197clickableO2vRcR10 = ClickableKt.m197clickableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : Role.m4543boximpl(Role.Companion.m4550getButtono7Vup1c()), interfaceC3588op);
                Alignment center11 = Alignment.Companion.getCenter();
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy11 = BoxKt.rememberBoxMeasurePolicy(center11, false, composer2, 6);
                composer2.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap11 = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion11 = ComposeUiNode.Companion;
                constructor = companion11.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf11 = LayoutKt.modifierMaterializerOf(modifierM197clickableO2vRcR10);
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
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy11, companion11.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap11, companion11.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion11.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf11.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance11 = BoxScopeInstance.INSTANCE;
                if (z3) {
                    composer2.startReplaceableGroup(753555784);
                    disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                } else {
                    composer2.startReplaceableGroup(753555810);
                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                }
                composer2.endReplaceableGroup();
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i110 >> 9) & 112) | 8);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z4 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC3588op, modifier4, z4, mutableInteractionSource4, interfaceC0526Fp, i, i2));
        }
        i3 |= 384;
        z2 = z;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 7168) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i2 & 16) != 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            }
            if ((46811 & i3) == 9362) {
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
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-111063634, i3, -1, "androidx.compose.material.IconButton (IconButton.kt:58)");
                }
                int i111 = i3;
                composer2 = composerStartRestartGroup;
                Modifier modifierM197clickableO2vRcR11 = ClickableKt.m197clickableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : Role.m4543boximpl(Role.Companion.m4550getButtono7Vup1c()), interfaceC3588op);
                Alignment center12 = Alignment.Companion.getCenter();
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy12 = BoxKt.rememberBoxMeasurePolicy(center12, false, composer2, 6);
                composer2.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap12 = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion12 = ComposeUiNode.Companion;
                constructor = companion12.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf12 = LayoutKt.modifierMaterializerOf(modifierM197clickableO2vRcR11);
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
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy12, companion12.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap12, companion12.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion12.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf12.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance12 = BoxScopeInstance.INSTANCE;
                if (z3) {
                    composer2.startReplaceableGroup(753555784);
                    disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                } else {
                    composer2.startReplaceableGroup(753555810);
                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                }
                composer2.endReplaceableGroup();
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i111 >> 9) & 112) | 8);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z4 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
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
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-111063634, i3, -1, "androidx.compose.material.IconButton (IconButton.kt:58)");
                }
                int i112 = i3;
                composer2 = composerStartRestartGroup;
                Modifier modifierM197clickableO2vRcR12 = ClickableKt.m197clickableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : Role.m4543boximpl(Role.Companion.m4550getButtono7Vup1c()), interfaceC3588op);
                Alignment center13 = Alignment.Companion.getCenter();
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy13 = BoxKt.rememberBoxMeasurePolicy(center13, false, composer2, 6);
                composer2.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap13 = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion13 = ComposeUiNode.Companion;
                constructor = companion13.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf13 = LayoutKt.modifierMaterializerOf(modifierM197clickableO2vRcR12);
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
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy13, companion13.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap13, companion13.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion13.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf13.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance13 = BoxScopeInstance.INSTANCE;
                if (z3) {
                    composer2.startReplaceableGroup(753555784);
                    disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                } else {
                    composer2.startReplaceableGroup(753555810);
                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                }
                composer2.endReplaceableGroup();
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i112 >> 9) & 112) | 8);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z4 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC3588op, modifier4, z4, mutableInteractionSource4, interfaceC0526Fp, i, i2));
        }
        i3 |= 3072;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((57344 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                i8 = 16384;
            } else {
                i8 = 8192;
            }
            i3 |= i8;
        }
        if ((46811 & i3) == 9362) {
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
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-111063634, i3, -1, "androidx.compose.material.IconButton (IconButton.kt:58)");
            }
            int i113 = i3;
            composer2 = composerStartRestartGroup;
            Modifier modifierM197clickableO2vRcR13 = ClickableKt.m197clickableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : Role.m4543boximpl(Role.Companion.m4550getButtono7Vup1c()), interfaceC3588op);
            Alignment center14 = Alignment.Companion.getCenter();
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy14 = BoxKt.rememberBoxMeasurePolicy(center14, false, composer2, 6);
            composer2.startReplaceableGroup(-1323940314);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap14 = composer2.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion14 = ComposeUiNode.Companion;
            constructor = companion14.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf14 = LayoutKt.modifierMaterializerOf(modifierM197clickableO2vRcR13);
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
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy14, companion14.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap14, companion14.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion14.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting()) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf14.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance14 = BoxScopeInstance.INSTANCE;
            if (z3) {
                composer2.startReplaceableGroup(753555784);
                disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
            } else {
                composer2.startReplaceableGroup(753555810);
                disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
            }
            composer2.endReplaceableGroup();
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i113 >> 9) & 112) | 8);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            z4 = z3;
            mutableInteractionSource4 = mutableInteractionSource3;
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
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-111063634, i3, -1, "androidx.compose.material.IconButton (IconButton.kt:58)");
            }
            int i114 = i3;
            composer2 = composerStartRestartGroup;
            Modifier modifierM197clickableO2vRcR14 = ClickableKt.m197clickableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : Role.m4543boximpl(Role.Companion.m4550getButtono7Vup1c()), interfaceC3588op);
            Alignment center15 = Alignment.Companion.getCenter();
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy15 = BoxKt.rememberBoxMeasurePolicy(center15, false, composer2, 6);
            composer2.startReplaceableGroup(-1323940314);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap15 = composer2.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion15 = ComposeUiNode.Companion;
            constructor = companion15.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf15 = LayoutKt.modifierMaterializerOf(modifierM197clickableO2vRcR14);
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
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy15, companion15.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap15, companion15.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion15.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting()) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf15.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance15 = BoxScopeInstance.INSTANCE;
            if (z3) {
                composer2.startReplaceableGroup(753555784);
                disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
            } else {
                composer2.startReplaceableGroup(753555810);
                disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
            }
            composer2.endReplaceableGroup();
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i114 >> 9) & 112) | 8);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            z4 = z3;
            mutableInteractionSource4 = mutableInteractionSource3;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC3588op, modifier4, z4, mutableInteractionSource4, interfaceC0526Fp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:103:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:106:0x022d  */
    /* JADX WARN: Code duplicated, block: B:111:0x023c  */
    /* JADX WARN: Code duplicated, block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0072  */
    /* JADX WARN: Code duplicated, block: B:38:0x0077  */
    /* JADX WARN: Code duplicated, block: B:40:0x007b  */
    /* JADX WARN: Code duplicated, block: B:42:0x0083  */
    /* JADX WARN: Code duplicated, block: B:43:0x0086  */
    /* JADX WARN: Code duplicated, block: B:47:0x008e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0093  */
    /* JADX WARN: Code duplicated, block: B:50:0x009c  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:68:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:72:0x00da A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:81:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:83:0x010b  */
    /* JADX WARN: Code duplicated, block: B:86:0x0113  */
    /* JADX WARN: Code duplicated, block: B:89:0x0177  */
    /* JADX WARN: Code duplicated, block: B:92:0x0183  */
    /* JADX WARN: Code duplicated, block: B:93:0x0187  */
    /* JADX WARN: Code duplicated, block: B:96:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:98:0x01b4  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void IconToggleButton(boolean z, InterfaceC3750qp interfaceC3750qp, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        int i8;
        int i9;
        Modifier modifier3;
        boolean z4;
        MutableInteractionSource mutableInteractionSource3;
        Composer composer2;
        int currentCompositeKeyHash;
        InterfaceC3588op constructor;
        Composer composerM2661constructorimpl;
        InterfaceC0526Fp setCompositeKeyHash;
        float disabled;
        boolean z5;
        Object objRememberedValue;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC3750qp, "onCheckedChange");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-54657793);
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
        int i10 = i2 & 4;
        if (i10 == 0) {
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
                if ((i2 & 32) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                            i8 = 131072;
                        } else {
                            i8 = 65536;
                        }
                    }
                    i9 = i3;
                    if ((374491 & i9) == 74898 || !composerStartRestartGroup.getSkipping()) {
                        if (i10 != 0) {
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
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-54657793, i9, -1, "androidx.compose.material.IconToggleButton (IconButton.kt:101)");
                        }
                        composer2 = composerStartRestartGroup;
                        Modifier modifierM711toggleableO2vRcR0 = ToggleableKt.m711toggleableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m4543boximpl(Role.Companion.m4551getCheckboxo7Vup1c()), interfaceC3750qp);
                        Alignment center = Alignment.Companion.getCenter();
                        composer2.startReplaceableGroup(733328855);
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                        composer2.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                        constructor = companion.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierM711toggleableO2vRcR0);
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
                        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion.getSetCompositeKeyHash();
                        if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        if (z4) {
                            composer2.startReplaceableGroup(-1866758084);
                            disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                        } else {
                            composer2.startReplaceableGroup(-1866758058);
                            disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                        }
                        composer2.endReplaceableGroup();
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i9 >> 12) & 112) | 8);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        z5 = z4;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        composer2 = composerStartRestartGroup;
                        z5 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new C14233(z, interfaceC3750qp, modifier2, z5, mutableInteractionSource2, interfaceC0526Fp, i, i2));
                }
                i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i8;
                i9 = i3;
                if ((374491 & i9) == 74898) {
                    if (i10 != 0) {
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
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-54657793, i9, -1, "androidx.compose.material.IconToggleButton (IconButton.kt:101)");
                    }
                    composer2 = composerStartRestartGroup;
                    Modifier modifierM711toggleableO2vRcR1 = ToggleableKt.m711toggleableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m4543boximpl(Role.Companion.m4551getCheckboxo7Vup1c()), interfaceC3750qp);
                    Alignment center2 = Alignment.Companion.getCenter();
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                    constructor = companion2.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifierM711toggleableO2vRcR1);
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
                    interfaceC0552GpModifierMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    if (z4) {
                        composer2.startReplaceableGroup(-1866758084);
                        disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                    } else {
                        composer2.startReplaceableGroup(-1866758058);
                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                    }
                    composer2.endReplaceableGroup();
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i9 >> 12) & 112) | 8);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    z5 = z4;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    if (i10 != 0) {
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
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-54657793, i9, -1, "androidx.compose.material.IconToggleButton (IconButton.kt:101)");
                    }
                    composer2 = composerStartRestartGroup;
                    Modifier modifierM711toggleableO2vRcR2 = ToggleableKt.m711toggleableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m4543boximpl(Role.Companion.m4551getCheckboxo7Vup1c()), interfaceC3750qp);
                    Alignment center3 = Alignment.Companion.getCenter();
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(center3, false, composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
                    constructor = companion3.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifierM711toggleableO2vRcR2);
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
                    interfaceC0552GpModifierMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    if (z4) {
                        composer2.startReplaceableGroup(-1866758084);
                        disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                    } else {
                        composer2.startReplaceableGroup(-1866758058);
                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                    }
                    composer2.endReplaceableGroup();
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i9 >> 12) & 112) | 8);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    z5 = z4;
                    mutableInteractionSource2 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14233(z, interfaceC3750qp, modifier2, z5, mutableInteractionSource2, interfaceC0526Fp, i, i2));
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
            if ((i2 & 32) != 0) {
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                }
                i9 = i3;
                if ((374491 & i9) == 74898) {
                    if (i10 != 0) {
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
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-54657793, i9, -1, "androidx.compose.material.IconToggleButton (IconButton.kt:101)");
                    }
                    composer2 = composerStartRestartGroup;
                    Modifier modifierM711toggleableO2vRcR3 = ToggleableKt.m711toggleableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m4543boximpl(Role.Companion.m4551getCheckboxo7Vup1c()), interfaceC3750qp);
                    Alignment center4 = Alignment.Companion.getCenter();
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(center4, false, composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion4 = ComposeUiNode.Companion;
                    constructor = companion4.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(modifierM711toggleableO2vRcR3);
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
                    interfaceC0552GpModifierMaterializerOf4.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                    if (z4) {
                        composer2.startReplaceableGroup(-1866758084);
                        disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                    } else {
                        composer2.startReplaceableGroup(-1866758058);
                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                    }
                    composer2.endReplaceableGroup();
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i9 >> 12) & 112) | 8);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    z5 = z4;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    if (i10 != 0) {
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
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-54657793, i9, -1, "androidx.compose.material.IconToggleButton (IconButton.kt:101)");
                    }
                    composer2 = composerStartRestartGroup;
                    Modifier modifierM711toggleableO2vRcR4 = ToggleableKt.m711toggleableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m4543boximpl(Role.Companion.m4551getCheckboxo7Vup1c()), interfaceC3750qp);
                    Alignment center5 = Alignment.Companion.getCenter();
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy5 = BoxKt.rememberBoxMeasurePolicy(center5, false, composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion5 = ComposeUiNode.Companion;
                    constructor = companion5.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(modifierM711toggleableO2vRcR4);
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
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy5, companion5.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap5, companion5.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion5.getSetCompositeKeyHash();
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
                    if (z4) {
                        composer2.startReplaceableGroup(-1866758084);
                        disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                    } else {
                        composer2.startReplaceableGroup(-1866758058);
                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                    }
                    composer2.endReplaceableGroup();
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i9 >> 12) & 112) | 8);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    z5 = z4;
                    mutableInteractionSource2 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14233(z, interfaceC3750qp, modifier2, z5, mutableInteractionSource2, interfaceC0526Fp, i, i2));
            }
            i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i8;
            i9 = i3;
            if ((374491 & i9) == 74898) {
                if (i10 != 0) {
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
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-54657793, i9, -1, "androidx.compose.material.IconToggleButton (IconButton.kt:101)");
                }
                composer2 = composerStartRestartGroup;
                Modifier modifierM711toggleableO2vRcR5 = ToggleableKt.m711toggleableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m4543boximpl(Role.Companion.m4551getCheckboxo7Vup1c()), interfaceC3750qp);
                Alignment center6 = Alignment.Companion.getCenter();
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy6 = BoxKt.rememberBoxMeasurePolicy(center6, false, composer2, 6);
                composer2.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap6 = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion6 = ComposeUiNode.Companion;
                constructor = companion6.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf6 = LayoutKt.modifierMaterializerOf(modifierM711toggleableO2vRcR5);
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
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy6, companion6.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap6, companion6.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion6.getSetCompositeKeyHash();
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
                if (z4) {
                    composer2.startReplaceableGroup(-1866758084);
                    disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                } else {
                    composer2.startReplaceableGroup(-1866758058);
                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                }
                composer2.endReplaceableGroup();
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i9 >> 12) & 112) | 8);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                z5 = z4;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                if (i10 != 0) {
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
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-54657793, i9, -1, "androidx.compose.material.IconToggleButton (IconButton.kt:101)");
                }
                composer2 = composerStartRestartGroup;
                Modifier modifierM711toggleableO2vRcR6 = ToggleableKt.m711toggleableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m4543boximpl(Role.Companion.m4551getCheckboxo7Vup1c()), interfaceC3750qp);
                Alignment center7 = Alignment.Companion.getCenter();
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy7 = BoxKt.rememberBoxMeasurePolicy(center7, false, composer2, 6);
                composer2.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap7 = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion7 = ComposeUiNode.Companion;
                constructor = companion7.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf7 = LayoutKt.modifierMaterializerOf(modifierM711toggleableO2vRcR6);
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
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy7, companion7.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap7, companion7.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion7.getSetCompositeKeyHash();
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
                if (z4) {
                    composer2.startReplaceableGroup(-1866758084);
                    disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                } else {
                    composer2.startReplaceableGroup(-1866758058);
                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                }
                composer2.endReplaceableGroup();
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i9 >> 12) & 112) | 8);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                z5 = z4;
                mutableInteractionSource2 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C14233(z, interfaceC3750qp, modifier2, z5, mutableInteractionSource2, interfaceC0526Fp, i, i2));
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
            if ((i2 & 32) != 0) {
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                }
                i9 = i3;
                if ((374491 & i9) == 74898) {
                    if (i10 != 0) {
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
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-54657793, i9, -1, "androidx.compose.material.IconToggleButton (IconButton.kt:101)");
                    }
                    composer2 = composerStartRestartGroup;
                    Modifier modifierM711toggleableO2vRcR7 = ToggleableKt.m711toggleableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m4543boximpl(Role.Companion.m4551getCheckboxo7Vup1c()), interfaceC3750qp);
                    Alignment center8 = Alignment.Companion.getCenter();
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy8 = BoxKt.rememberBoxMeasurePolicy(center8, false, composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap8 = composer2.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion8 = ComposeUiNode.Companion;
                    constructor = companion8.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf8 = LayoutKt.modifierMaterializerOf(modifierM711toggleableO2vRcR7);
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
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy8, companion8.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap8, companion8.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion8.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf8.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
                    if (z4) {
                        composer2.startReplaceableGroup(-1866758084);
                        disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                    } else {
                        composer2.startReplaceableGroup(-1866758058);
                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                    }
                    composer2.endReplaceableGroup();
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i9 >> 12) & 112) | 8);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    z5 = z4;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    if (i10 != 0) {
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
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-54657793, i9, -1, "androidx.compose.material.IconToggleButton (IconButton.kt:101)");
                    }
                    composer2 = composerStartRestartGroup;
                    Modifier modifierM711toggleableO2vRcR8 = ToggleableKt.m711toggleableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m4543boximpl(Role.Companion.m4551getCheckboxo7Vup1c()), interfaceC3750qp);
                    Alignment center9 = Alignment.Companion.getCenter();
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy9 = BoxKt.rememberBoxMeasurePolicy(center9, false, composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap9 = composer2.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion9 = ComposeUiNode.Companion;
                    constructor = companion9.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf9 = LayoutKt.modifierMaterializerOf(modifierM711toggleableO2vRcR8);
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
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy9, companion9.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap9, companion9.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion9.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf9.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance9 = BoxScopeInstance.INSTANCE;
                    if (z4) {
                        composer2.startReplaceableGroup(-1866758084);
                        disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                    } else {
                        composer2.startReplaceableGroup(-1866758058);
                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                    }
                    composer2.endReplaceableGroup();
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i9 >> 12) & 112) | 8);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    z5 = z4;
                    mutableInteractionSource2 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14233(z, interfaceC3750qp, modifier2, z5, mutableInteractionSource2, interfaceC0526Fp, i, i2));
            }
            i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i8;
            i9 = i3;
            if ((374491 & i9) == 74898) {
                if (i10 != 0) {
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
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-54657793, i9, -1, "androidx.compose.material.IconToggleButton (IconButton.kt:101)");
                }
                composer2 = composerStartRestartGroup;
                Modifier modifierM711toggleableO2vRcR9 = ToggleableKt.m711toggleableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m4543boximpl(Role.Companion.m4551getCheckboxo7Vup1c()), interfaceC3750qp);
                Alignment center10 = Alignment.Companion.getCenter();
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy10 = BoxKt.rememberBoxMeasurePolicy(center10, false, composer2, 6);
                composer2.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap10 = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion10 = ComposeUiNode.Companion;
                constructor = companion10.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf10 = LayoutKt.modifierMaterializerOf(modifierM711toggleableO2vRcR9);
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
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy10, companion10.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap10, companion10.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion10.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf10.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance10 = BoxScopeInstance.INSTANCE;
                if (z4) {
                    composer2.startReplaceableGroup(-1866758084);
                    disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                } else {
                    composer2.startReplaceableGroup(-1866758058);
                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                }
                composer2.endReplaceableGroup();
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i9 >> 12) & 112) | 8);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                z5 = z4;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                if (i10 != 0) {
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
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-54657793, i9, -1, "androidx.compose.material.IconToggleButton (IconButton.kt:101)");
                }
                composer2 = composerStartRestartGroup;
                Modifier modifierM711toggleableO2vRcR10 = ToggleableKt.m711toggleableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m4543boximpl(Role.Companion.m4551getCheckboxo7Vup1c()), interfaceC3750qp);
                Alignment center11 = Alignment.Companion.getCenter();
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy11 = BoxKt.rememberBoxMeasurePolicy(center11, false, composer2, 6);
                composer2.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap11 = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion11 = ComposeUiNode.Companion;
                constructor = companion11.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf11 = LayoutKt.modifierMaterializerOf(modifierM711toggleableO2vRcR10);
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
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy11, companion11.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap11, companion11.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion11.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf11.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance11 = BoxScopeInstance.INSTANCE;
                if (z4) {
                    composer2.startReplaceableGroup(-1866758084);
                    disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                } else {
                    composer2.startReplaceableGroup(-1866758058);
                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                }
                composer2.endReplaceableGroup();
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i9 >> 12) & 112) | 8);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                z5 = z4;
                mutableInteractionSource2 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C14233(z, interfaceC3750qp, modifier2, z5, mutableInteractionSource2, interfaceC0526Fp, i, i2));
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
        if ((i2 & 32) != 0) {
            if ((458752 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
            }
            i9 = i3;
            if ((374491 & i9) == 74898) {
                if (i10 != 0) {
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
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-54657793, i9, -1, "androidx.compose.material.IconToggleButton (IconButton.kt:101)");
                }
                composer2 = composerStartRestartGroup;
                Modifier modifierM711toggleableO2vRcR11 = ToggleableKt.m711toggleableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m4543boximpl(Role.Companion.m4551getCheckboxo7Vup1c()), interfaceC3750qp);
                Alignment center12 = Alignment.Companion.getCenter();
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy12 = BoxKt.rememberBoxMeasurePolicy(center12, false, composer2, 6);
                composer2.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap12 = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion12 = ComposeUiNode.Companion;
                constructor = companion12.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf12 = LayoutKt.modifierMaterializerOf(modifierM711toggleableO2vRcR11);
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
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy12, companion12.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap12, companion12.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion12.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf12.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance12 = BoxScopeInstance.INSTANCE;
                if (z4) {
                    composer2.startReplaceableGroup(-1866758084);
                    disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                } else {
                    composer2.startReplaceableGroup(-1866758058);
                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                }
                composer2.endReplaceableGroup();
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i9 >> 12) & 112) | 8);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                z5 = z4;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                if (i10 != 0) {
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
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-54657793, i9, -1, "androidx.compose.material.IconToggleButton (IconButton.kt:101)");
                }
                composer2 = composerStartRestartGroup;
                Modifier modifierM711toggleableO2vRcR12 = ToggleableKt.m711toggleableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m4543boximpl(Role.Companion.m4551getCheckboxo7Vup1c()), interfaceC3750qp);
                Alignment center13 = Alignment.Companion.getCenter();
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy13 = BoxKt.rememberBoxMeasurePolicy(center13, false, composer2, 6);
                composer2.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap13 = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion13 = ComposeUiNode.Companion;
                constructor = companion13.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf13 = LayoutKt.modifierMaterializerOf(modifierM711toggleableO2vRcR12);
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
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy13, companion13.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap13, companion13.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion13.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf13.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance13 = BoxScopeInstance.INSTANCE;
                if (z4) {
                    composer2.startReplaceableGroup(-1866758084);
                    disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                } else {
                    composer2.startReplaceableGroup(-1866758058);
                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                }
                composer2.endReplaceableGroup();
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i9 >> 12) & 112) | 8);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                z5 = z4;
                mutableInteractionSource2 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C14233(z, interfaceC3750qp, modifier2, z5, mutableInteractionSource2, interfaceC0526Fp, i, i2));
        }
        i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i3 |= i8;
        i9 = i3;
        if ((374491 & i9) == 74898) {
            if (i10 != 0) {
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
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-54657793, i9, -1, "androidx.compose.material.IconToggleButton (IconButton.kt:101)");
            }
            composer2 = composerStartRestartGroup;
            Modifier modifierM711toggleableO2vRcR13 = ToggleableKt.m711toggleableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m4543boximpl(Role.Companion.m4551getCheckboxo7Vup1c()), interfaceC3750qp);
            Alignment center14 = Alignment.Companion.getCenter();
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy14 = BoxKt.rememberBoxMeasurePolicy(center14, false, composer2, 6);
            composer2.startReplaceableGroup(-1323940314);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap14 = composer2.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion14 = ComposeUiNode.Companion;
            constructor = companion14.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf14 = LayoutKt.modifierMaterializerOf(modifierM711toggleableO2vRcR13);
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
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy14, companion14.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap14, companion14.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion14.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting()) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf14.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance14 = BoxScopeInstance.INSTANCE;
            if (z4) {
                composer2.startReplaceableGroup(-1866758084);
                disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
            } else {
                composer2.startReplaceableGroup(-1866758058);
                disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
            }
            composer2.endReplaceableGroup();
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i9 >> 12) & 112) | 8);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            z5 = z4;
            mutableInteractionSource2 = mutableInteractionSource3;
        } else {
            if (i10 != 0) {
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
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-54657793, i9, -1, "androidx.compose.material.IconToggleButton (IconButton.kt:101)");
            }
            composer2 = composerStartRestartGroup;
            Modifier modifierM711toggleableO2vRcR14 = ToggleableKt.m711toggleableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m4543boximpl(Role.Companion.m4551getCheckboxo7Vup1c()), interfaceC3750qp);
            Alignment center15 = Alignment.Companion.getCenter();
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy15 = BoxKt.rememberBoxMeasurePolicy(center15, false, composer2, 6);
            composer2.startReplaceableGroup(-1323940314);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap15 = composer2.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion15 = ComposeUiNode.Companion;
            constructor = companion15.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf15 = LayoutKt.modifierMaterializerOf(modifierM711toggleableO2vRcR14);
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
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy15, companion15.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap15, companion15.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion15.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting()) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf15.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance15 = BoxScopeInstance.INSTANCE;
            if (z4) {
                composer2.startReplaceableGroup(-1866758084);
                disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
            } else {
                composer2.startReplaceableGroup(-1866758058);
                disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
            }
            composer2.endReplaceableGroup();
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, interfaceC0526Fp, composer2, ((i9 >> 12) & 112) | 8);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            z5 = z4;
            mutableInteractionSource2 = mutableInteractionSource3;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C14233(z, interfaceC3750qp, modifier2, z5, mutableInteractionSource2, interfaceC0526Fp, i, i2));
    }
}
