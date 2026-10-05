package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3955tM;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class ThreeLine {
    private static final float ContentLeftPadding;
    private static final float ContentRightPadding;
    private static final float IconLeftPadding;
    private static final float IconThreeLineVerticalPadding;
    private static final float ThreeLineBaselineSecondOffset;
    private static final float ThreeLineBaselineThirdOffset;
    private static final float ThreeLineTrailingTopPadding;
    private static final float TrailingRightPadding;
    public static final ThreeLine INSTANCE = new ThreeLine();
    private static final float MinHeight = Dp.m5160constructorimpl(88);
    private static final float IconMinPaddedWidth = Dp.m5160constructorimpl(40);
    private static final float ThreeLineBaselineFirstOffset = Dp.m5160constructorimpl(28);

    /* JADX INFO: renamed from: androidx.compose.material.ThreeLine$ListItem$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC0526Fp $icon;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC0526Fp $overlineText;
        final /* synthetic */ InterfaceC0526Fp $secondaryText;
        final /* synthetic */ InterfaceC0526Fp $text;
        final /* synthetic */ InterfaceC0526Fp $trailing;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, InterfaceC0526Fp interfaceC0526Fp5, int i, int i2) {
            super(2);
            this.$modifier = modifier;
            this.$icon = interfaceC0526Fp;
            this.$text = interfaceC0526Fp2;
            this.$secondaryText = interfaceC0526Fp3;
            this.$overlineText = interfaceC0526Fp4;
            this.$trailing = interfaceC0526Fp5;
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
            ThreeLine.this.ListItem(this.$modifier, this.$icon, this.$text, this.$secondaryText, this.$overlineText, this.$trailing, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    static {
        float f = 16;
        IconLeftPadding = Dp.m5160constructorimpl(f);
        IconThreeLineVerticalPadding = Dp.m5160constructorimpl(f);
        ContentLeftPadding = Dp.m5160constructorimpl(f);
        ContentRightPadding = Dp.m5160constructorimpl(f);
        float f2 = 20;
        ThreeLineBaselineSecondOffset = Dp.m5160constructorimpl(f2);
        ThreeLineBaselineThirdOffset = Dp.m5160constructorimpl(f2);
        ThreeLineTrailingTopPadding = Dp.m5160constructorimpl(f);
        TrailingRightPadding = Dp.m5160constructorimpl(f);
    }

    private ThreeLine() {
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:102:0x0207  */
    /* JADX WARN: Code duplicated, block: B:105:0x0213  */
    /* JADX WARN: Code duplicated, block: B:106:0x0217  */
    /* JADX WARN: Code duplicated, block: B:109:0x0236  */
    /* JADX WARN: Code duplicated, block: B:111:0x0244  */
    /* JADX WARN: Code duplicated, block: B:115:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:116:0x030e  */
    /* JADX WARN: Code duplicated, block: B:119:0x0324  */
    /* JADX WARN: Code duplicated, block: B:124:0x032f  */
    /* JADX WARN: Code duplicated, block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:72:0x00db  */
    /* JADX WARN: Code duplicated, block: B:73:0x00de  */
    /* JADX WARN: Code duplicated, block: B:77:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:85:0x0102  */
    /* JADX WARN: Code duplicated, block: B:88:0x0146  */
    /* JADX WARN: Code duplicated, block: B:91:0x0152  */
    /* JADX WARN: Code duplicated, block: B:92:0x0156  */
    /* JADX WARN: Code duplicated, block: B:95:0x0175  */
    /* JADX WARN: Code duplicated, block: B:97:0x0183  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public final void ListItem(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, InterfaceC0526Fp interfaceC0526Fp5, Composer composer, int i, int i2) {
        Modifier modifier2;
        int i3;
        int i4;
        int i5;
        Alignment.Companion companion;
        int currentCompositeKeyHash;
        ComposeUiNode.Companion companion2;
        InterfaceC3588op constructor;
        Composer composerM2661constructorimpl;
        InterfaceC0526Fp setCompositeKeyHash;
        float f;
        Modifier.Companion companion3;
        Modifier modifier3;
        int currentCompositeKeyHash2;
        InterfaceC3588op constructor2;
        Composer composerM2661constructorimpl2;
        InterfaceC0526Fp setCompositeKeyHash2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0526Fp2, "text");
        AbstractC4492zt.h(interfaceC0526Fp3, "secondaryText");
        Composer composerStartRestartGroup = composer.startRestartGroup(1749738797);
        int i6 = i2 & 1;
        if (i6 != 0) {
            modifier2 = modifier;
            i3 = i | 6;
        } else {
            modifier2 = modifier;
            if ((i & 14) == 0) {
                i3 = i | (composerStartRestartGroup.changed(modifier2) ? 4 : 2);
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 32 : 16;
        }
        int i7 = i3;
        if ((i2 & 4) != 0) {
            i7 |= 384;
        } else if ((i & 896) == 0) {
            i7 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp2) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i7 |= 3072;
        } else if ((i & 7168) == 0) {
            i7 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp3) ? 2048 : 1024;
        }
        if ((i2 & 16) != 0) {
            i7 |= 24576;
        } else if ((57344 & i) == 0) {
            i7 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp4) ? 16384 : 8192;
        }
        if ((i2 & 32) == 0) {
            if ((458752 & i) == 0) {
                i4 = composerStartRestartGroup.changedInstance(interfaceC0526Fp5) ? 131072 : 65536;
            }
            if ((i2 & 64) != 0) {
                if ((3670016 & i) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i5 = 1048576;
                    } else {
                        i5 = 524288;
                    }
                    i7 |= i5;
                }
                if ((2995931 & i7) == 599186 || !composerStartRestartGroup.getSkipping()) {
                    if (i6 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1749738797, i7, -1, "androidx.compose.material.ThreeLine.ListItem (ListItem.kt:294)");
                    }
                    Modifier modifierM520heightInVpY3zN4$default = SizeKt.m520heightInVpY3zN4$default(modifier2, MinHeight, 0.0f, 2, null);
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                    companion = Alignment.Companion;
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, companion.getTop(), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    companion2 = ComposeUiNode.Companion;
                    constructor = companion2.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierM520heightInVpY3zN4$default);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-280382992);
                    if (interfaceC0526Fp != null) {
                        float f2 = IconLeftPadding;
                        float fM5160constructorimpl = Dp.m5160constructorimpl(f2 + IconMinPaddedWidth);
                        Modifier modifierM536sizeInqDBjuR0$default = SizeKt.m536sizeInqDBjuR0$default(Modifier.Companion, fM5160constructorimpl, fM5160constructorimpl, 0.0f, 0.0f, 12, null);
                        float f3 = IconThreeLineVerticalPadding;
                        Modifier modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(modifierM536sizeInqDBjuR0$default, f2, f3, 0.0f, f3, 4, null);
                        Alignment centerStart = companion.getCenterStart();
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(centerStart, false, composerStartRestartGroup, 6);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        constructor2 = companion2.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifierM489paddingqDBjuR0$default);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor2);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                        setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                        if (composerM2661constructorimpl2.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        interfaceC0552GpModifierMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i7 >> 3) & 14));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    f = ThreeLineBaselineFirstOffset;
                    List listP = AbstractC1886cc.p(Dp.m5158boximpl(f), Dp.m5158boximpl(ThreeLineBaselineSecondOffset), Dp.m5158boximpl(ThreeLineBaselineThirdOffset));
                    companion3 = Modifier.Companion;
                    ListItemKt.BaselinesOffsetColumn(listP, PaddingKt.m489paddingqDBjuR0$default(AbstractC3955tM.a(rowScopeInstance, companion3, 1.0f, false, 2, null), ContentLeftPadding, 0.0f, ContentRightPadding, 0.0f, 10, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -318094245, true, new ThreeLine$ListItem$1$2(interfaceC0526Fp4, i7, interfaceC0526Fp2, interfaceC0526Fp3)), composerStartRestartGroup, 390, 0);
                    composerStartRestartGroup.startReplaceableGroup(-678936717);
                    if (interfaceC0526Fp5 != null) {
                        float f4 = ThreeLineTrailingTopPadding;
                        ListItemKt.m1142OffsetToBaselineOrCenterKz89ssw(Dp.m5160constructorimpl(f - f4), PaddingKt.m489paddingqDBjuR0$default(companion3, 0.0f, f4, TrailingRightPadding, 0.0f, 9, null), interfaceC0526Fp5, composerStartRestartGroup, ((i7 >> 9) & 896) | 54, 0);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    composerStartRestartGroup = composerStartRestartGroup;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(modifier3, interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, interfaceC0526Fp5, i, i2));
            }
            i7 |= 1572864;
            if ((2995931 & i7) == 599186) {
                if (i6 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1749738797, i7, -1, "androidx.compose.material.ThreeLine.ListItem (ListItem.kt:294)");
                }
                Modifier modifierM520heightInVpY3zN4$default2 = SizeKt.m520heightInVpY3zN4$default(modifier2, MinHeight, 0.0f, 2, null);
                composerStartRestartGroup.startReplaceableGroup(693286680);
                Arrangement.Horizontal start2 = Arrangement.INSTANCE.getStart();
                companion = Alignment.Companion;
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(start2, companion.getTop(), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                companion2 = ComposeUiNode.Companion;
                constructor = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifierM520heightInVpY3zN4$default2);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy2, companion2.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap3, companion2.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-280382992);
                if (interfaceC0526Fp != null) {
                    float f5 = IconLeftPadding;
                    float fM5160constructorimpl2 = Dp.m5160constructorimpl(f5 + IconMinPaddedWidth);
                    Modifier modifierM536sizeInqDBjuR0$default2 = SizeKt.m536sizeInqDBjuR0$default(Modifier.Companion, fM5160constructorimpl2, fM5160constructorimpl2, 0.0f, 0.0f, 12, null);
                    float f6 = IconThreeLineVerticalPadding;
                    Modifier modifierM489paddingqDBjuR0$default2 = PaddingKt.m489paddingqDBjuR0$default(modifierM536sizeInqDBjuR0$default2, f5, f6, 0.0f, f6, 4, null);
                    Alignment centerStart2 = companion.getCenterStart();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(centerStart2, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    constructor2 = companion2.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(modifierM489paddingqDBjuR0$default2);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl2, currentCompositionLocalMap4, companion2.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl2.getInserting()) {
                        composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    } else {
                        composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    interfaceC0552GpModifierMaterializerOf4.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i7 >> 3) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                }
                composerStartRestartGroup.endReplaceableGroup();
                f = ThreeLineBaselineFirstOffset;
                List listP2 = AbstractC1886cc.p(Dp.m5158boximpl(f), Dp.m5158boximpl(ThreeLineBaselineSecondOffset), Dp.m5158boximpl(ThreeLineBaselineThirdOffset));
                companion3 = Modifier.Companion;
                ListItemKt.BaselinesOffsetColumn(listP2, PaddingKt.m489paddingqDBjuR0$default(AbstractC3955tM.a(rowScopeInstance2, companion3, 1.0f, false, 2, null), ContentLeftPadding, 0.0f, ContentRightPadding, 0.0f, 10, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -318094245, true, new ThreeLine$ListItem$1$2(interfaceC0526Fp4, i7, interfaceC0526Fp2, interfaceC0526Fp3)), composerStartRestartGroup, 390, 0);
                composerStartRestartGroup.startReplaceableGroup(-678936717);
                if (interfaceC0526Fp5 != null) {
                    float f7 = ThreeLineTrailingTopPadding;
                    ListItemKt.m1142OffsetToBaselineOrCenterKz89ssw(Dp.m5160constructorimpl(f - f7), PaddingKt.m489paddingqDBjuR0$default(companion3, 0.0f, f7, TrailingRightPadding, 0.0f, 9, null), interfaceC0526Fp5, composerStartRestartGroup, ((i7 >> 9) & 896) | 54, 0);
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
            } else {
                if (i6 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1749738797, i7, -1, "androidx.compose.material.ThreeLine.ListItem (ListItem.kt:294)");
                }
                Modifier modifierM520heightInVpY3zN4$default3 = SizeKt.m520heightInVpY3zN4$default(modifier2, MinHeight, 0.0f, 2, null);
                composerStartRestartGroup.startReplaceableGroup(693286680);
                Arrangement.Horizontal start3 = Arrangement.INSTANCE.getStart();
                companion = Alignment.Companion;
                MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(start3, companion.getTop(), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                companion2 = ComposeUiNode.Companion;
                constructor = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(modifierM520heightInVpY3zN4$default3);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy3, companion2.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap5, companion2.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf5.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-280382992);
                if (interfaceC0526Fp != null) {
                    float f8 = IconLeftPadding;
                    float fM5160constructorimpl3 = Dp.m5160constructorimpl(f8 + IconMinPaddedWidth);
                    Modifier modifierM536sizeInqDBjuR0$default3 = SizeKt.m536sizeInqDBjuR0$default(Modifier.Companion, fM5160constructorimpl3, fM5160constructorimpl3, 0.0f, 0.0f, 12, null);
                    float f9 = IconThreeLineVerticalPadding;
                    Modifier modifierM489paddingqDBjuR0$default3 = PaddingKt.m489paddingqDBjuR0$default(modifierM536sizeInqDBjuR0$default3, f8, f9, 0.0f, f9, 4, null);
                    Alignment centerStart3 = companion.getCenterStart();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(centerStart3, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    constructor2 = companion2.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf6 = LayoutKt.modifierMaterializerOf(modifierM489paddingqDBjuR0$default3);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy3, companion2.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl2, currentCompositionLocalMap6, companion2.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl2.getInserting()) {
                        composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    } else {
                        composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    interfaceC0552GpModifierMaterializerOf6.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i7 >> 3) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                }
                composerStartRestartGroup.endReplaceableGroup();
                f = ThreeLineBaselineFirstOffset;
                List listP3 = AbstractC1886cc.p(Dp.m5158boximpl(f), Dp.m5158boximpl(ThreeLineBaselineSecondOffset), Dp.m5158boximpl(ThreeLineBaselineThirdOffset));
                companion3 = Modifier.Companion;
                ListItemKt.BaselinesOffsetColumn(listP3, PaddingKt.m489paddingqDBjuR0$default(AbstractC3955tM.a(rowScopeInstance3, companion3, 1.0f, false, 2, null), ContentLeftPadding, 0.0f, ContentRightPadding, 0.0f, 10, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -318094245, true, new ThreeLine$ListItem$1$2(interfaceC0526Fp4, i7, interfaceC0526Fp2, interfaceC0526Fp3)), composerStartRestartGroup, 390, 0);
                composerStartRestartGroup.startReplaceableGroup(-678936717);
                if (interfaceC0526Fp5 != null) {
                    float f10 = ThreeLineTrailingTopPadding;
                    ListItemKt.m1142OffsetToBaselineOrCenterKz89ssw(Dp.m5160constructorimpl(f - f10), PaddingKt.m489paddingqDBjuR0$default(companion3, 0.0f, f10, TrailingRightPadding, 0.0f, 9, null), interfaceC0526Fp5, composerStartRestartGroup, ((i7 >> 9) & 896) | 54, 0);
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(modifier3, interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, interfaceC0526Fp5, i, i2));
        }
        i4 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i7 |= i4;
        if ((i2 & 64) != 0) {
            if ((3670016 & i) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i5 = 1048576;
                } else {
                    i5 = 524288;
                }
                i7 |= i5;
            }
            if ((2995931 & i7) == 599186) {
                if (i6 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1749738797, i7, -1, "androidx.compose.material.ThreeLine.ListItem (ListItem.kt:294)");
                }
                Modifier modifierM520heightInVpY3zN4$default4 = SizeKt.m520heightInVpY3zN4$default(modifier2, MinHeight, 0.0f, 2, null);
                composerStartRestartGroup.startReplaceableGroup(693286680);
                Arrangement.Horizontal start4 = Arrangement.INSTANCE.getStart();
                companion = Alignment.Companion;
                MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(start4, companion.getTop(), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                companion2 = ComposeUiNode.Companion;
                constructor = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf7 = LayoutKt.modifierMaterializerOf(modifierM520heightInVpY3zN4$default4);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy4, companion2.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap7, companion2.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf7.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-280382992);
                if (interfaceC0526Fp != null) {
                    float f11 = IconLeftPadding;
                    float fM5160constructorimpl4 = Dp.m5160constructorimpl(f11 + IconMinPaddedWidth);
                    Modifier modifierM536sizeInqDBjuR0$default4 = SizeKt.m536sizeInqDBjuR0$default(Modifier.Companion, fM5160constructorimpl4, fM5160constructorimpl4, 0.0f, 0.0f, 12, null);
                    float f12 = IconThreeLineVerticalPadding;
                    Modifier modifierM489paddingqDBjuR0$default4 = PaddingKt.m489paddingqDBjuR0$default(modifierM536sizeInqDBjuR0$default4, f11, f12, 0.0f, f12, 4, null);
                    Alignment centerStart4 = companion.getCenterStart();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(centerStart4, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    constructor2 = companion2.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf8 = LayoutKt.modifierMaterializerOf(modifierM489paddingqDBjuR0$default4);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy4, companion2.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl2, currentCompositionLocalMap8, companion2.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl2.getInserting()) {
                        composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    } else {
                        composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    interfaceC0552GpModifierMaterializerOf8.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                    interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i7 >> 3) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                }
                composerStartRestartGroup.endReplaceableGroup();
                f = ThreeLineBaselineFirstOffset;
                List listP4 = AbstractC1886cc.p(Dp.m5158boximpl(f), Dp.m5158boximpl(ThreeLineBaselineSecondOffset), Dp.m5158boximpl(ThreeLineBaselineThirdOffset));
                companion3 = Modifier.Companion;
                ListItemKt.BaselinesOffsetColumn(listP4, PaddingKt.m489paddingqDBjuR0$default(AbstractC3955tM.a(rowScopeInstance4, companion3, 1.0f, false, 2, null), ContentLeftPadding, 0.0f, ContentRightPadding, 0.0f, 10, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -318094245, true, new ThreeLine$ListItem$1$2(interfaceC0526Fp4, i7, interfaceC0526Fp2, interfaceC0526Fp3)), composerStartRestartGroup, 390, 0);
                composerStartRestartGroup.startReplaceableGroup(-678936717);
                if (interfaceC0526Fp5 != null) {
                    float f13 = ThreeLineTrailingTopPadding;
                    ListItemKt.m1142OffsetToBaselineOrCenterKz89ssw(Dp.m5160constructorimpl(f - f13), PaddingKt.m489paddingqDBjuR0$default(companion3, 0.0f, f13, TrailingRightPadding, 0.0f, 9, null), interfaceC0526Fp5, composerStartRestartGroup, ((i7 >> 9) & 896) | 54, 0);
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
            } else {
                if (i6 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1749738797, i7, -1, "androidx.compose.material.ThreeLine.ListItem (ListItem.kt:294)");
                }
                Modifier modifierM520heightInVpY3zN4$default5 = SizeKt.m520heightInVpY3zN4$default(modifier2, MinHeight, 0.0f, 2, null);
                composerStartRestartGroup.startReplaceableGroup(693286680);
                Arrangement.Horizontal start5 = Arrangement.INSTANCE.getStart();
                companion = Alignment.Companion;
                MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(start5, companion.getTop(), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                companion2 = ComposeUiNode.Companion;
                constructor = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf9 = LayoutKt.modifierMaterializerOf(modifierM520heightInVpY3zN4$default5);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy5, companion2.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap9, companion2.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf9.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-280382992);
                if (interfaceC0526Fp != null) {
                    float f14 = IconLeftPadding;
                    float fM5160constructorimpl5 = Dp.m5160constructorimpl(f14 + IconMinPaddedWidth);
                    Modifier modifierM536sizeInqDBjuR0$default5 = SizeKt.m536sizeInqDBjuR0$default(Modifier.Companion, fM5160constructorimpl5, fM5160constructorimpl5, 0.0f, 0.0f, 12, null);
                    float f15 = IconThreeLineVerticalPadding;
                    Modifier modifierM489paddingqDBjuR0$default5 = PaddingKt.m489paddingqDBjuR0$default(modifierM536sizeInqDBjuR0$default5, f14, f15, 0.0f, f15, 4, null);
                    Alignment centerStart5 = companion.getCenterStart();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy5 = BoxKt.rememberBoxMeasurePolicy(centerStart5, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    constructor2 = companion2.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf10 = LayoutKt.modifierMaterializerOf(modifierM489paddingqDBjuR0$default5);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy5, companion2.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl2, currentCompositionLocalMap10, companion2.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl2.getInserting()) {
                        composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    } else {
                        composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    interfaceC0552GpModifierMaterializerOf10.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                    interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i7 >> 3) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                }
                composerStartRestartGroup.endReplaceableGroup();
                f = ThreeLineBaselineFirstOffset;
                List listP5 = AbstractC1886cc.p(Dp.m5158boximpl(f), Dp.m5158boximpl(ThreeLineBaselineSecondOffset), Dp.m5158boximpl(ThreeLineBaselineThirdOffset));
                companion3 = Modifier.Companion;
                ListItemKt.BaselinesOffsetColumn(listP5, PaddingKt.m489paddingqDBjuR0$default(AbstractC3955tM.a(rowScopeInstance5, companion3, 1.0f, false, 2, null), ContentLeftPadding, 0.0f, ContentRightPadding, 0.0f, 10, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -318094245, true, new ThreeLine$ListItem$1$2(interfaceC0526Fp4, i7, interfaceC0526Fp2, interfaceC0526Fp3)), composerStartRestartGroup, 390, 0);
                composerStartRestartGroup.startReplaceableGroup(-678936717);
                if (interfaceC0526Fp5 != null) {
                    float f16 = ThreeLineTrailingTopPadding;
                    ListItemKt.m1142OffsetToBaselineOrCenterKz89ssw(Dp.m5160constructorimpl(f - f16), PaddingKt.m489paddingqDBjuR0$default(companion3, 0.0f, f16, TrailingRightPadding, 0.0f, 9, null), interfaceC0526Fp5, composerStartRestartGroup, ((i7 >> 9) & 896) | 54, 0);
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(modifier3, interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, interfaceC0526Fp5, i, i2));
        }
        i7 |= 1572864;
        if ((2995931 & i7) == 599186) {
            if (i6 != 0) {
                modifier2 = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1749738797, i7, -1, "androidx.compose.material.ThreeLine.ListItem (ListItem.kt:294)");
            }
            Modifier modifierM520heightInVpY3zN4$default6 = SizeKt.m520heightInVpY3zN4$default(modifier2, MinHeight, 0.0f, 2, null);
            composerStartRestartGroup.startReplaceableGroup(693286680);
            Arrangement.Horizontal start6 = Arrangement.INSTANCE.getStart();
            companion = Alignment.Companion;
            MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(start6, companion.getTop(), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            companion2 = ComposeUiNode.Companion;
            constructor = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf11 = LayoutKt.modifierMaterializerOf(modifierM520heightInVpY3zN4$default6);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy6, companion2.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap11, companion2.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting()) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf11.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            RowScopeInstance rowScopeInstance6 = RowScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-280382992);
            if (interfaceC0526Fp != null) {
                float f17 = IconLeftPadding;
                float fM5160constructorimpl6 = Dp.m5160constructorimpl(f17 + IconMinPaddedWidth);
                Modifier modifierM536sizeInqDBjuR0$default6 = SizeKt.m536sizeInqDBjuR0$default(Modifier.Companion, fM5160constructorimpl6, fM5160constructorimpl6, 0.0f, 0.0f, 12, null);
                float f18 = IconThreeLineVerticalPadding;
                Modifier modifierM489paddingqDBjuR0$default6 = PaddingKt.m489paddingqDBjuR0$default(modifierM536sizeInqDBjuR0$default6, f17, f18, 0.0f, f18, 4, null);
                Alignment centerStart6 = companion.getCenterStart();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy6 = BoxKt.rememberBoxMeasurePolicy(centerStart6, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                constructor2 = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf12 = LayoutKt.modifierMaterializerOf(modifierM489paddingqDBjuR0$default6);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy6, companion2.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl2, currentCompositionLocalMap12, companion2.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                if (composerM2661constructorimpl2.getInserting()) {
                    composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                interfaceC0552GpModifierMaterializerOf12.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i7 >> 3) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            f = ThreeLineBaselineFirstOffset;
            List listP6 = AbstractC1886cc.p(Dp.m5158boximpl(f), Dp.m5158boximpl(ThreeLineBaselineSecondOffset), Dp.m5158boximpl(ThreeLineBaselineThirdOffset));
            companion3 = Modifier.Companion;
            ListItemKt.BaselinesOffsetColumn(listP6, PaddingKt.m489paddingqDBjuR0$default(AbstractC3955tM.a(rowScopeInstance6, companion3, 1.0f, false, 2, null), ContentLeftPadding, 0.0f, ContentRightPadding, 0.0f, 10, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -318094245, true, new ThreeLine$ListItem$1$2(interfaceC0526Fp4, i7, interfaceC0526Fp2, interfaceC0526Fp3)), composerStartRestartGroup, 390, 0);
            composerStartRestartGroup.startReplaceableGroup(-678936717);
            if (interfaceC0526Fp5 != null) {
                float f19 = ThreeLineTrailingTopPadding;
                ListItemKt.m1142OffsetToBaselineOrCenterKz89ssw(Dp.m5160constructorimpl(f - f19), PaddingKt.m489paddingqDBjuR0$default(companion3, 0.0f, f19, TrailingRightPadding, 0.0f, 9, null), interfaceC0526Fp5, composerStartRestartGroup, ((i7 >> 9) & 896) | 54, 0);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
        } else {
            if (i6 != 0) {
                modifier2 = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1749738797, i7, -1, "androidx.compose.material.ThreeLine.ListItem (ListItem.kt:294)");
            }
            Modifier modifierM520heightInVpY3zN4$default7 = SizeKt.m520heightInVpY3zN4$default(modifier2, MinHeight, 0.0f, 2, null);
            composerStartRestartGroup.startReplaceableGroup(693286680);
            Arrangement.Horizontal start7 = Arrangement.INSTANCE.getStart();
            companion = Alignment.Companion;
            MeasurePolicy measurePolicyRowMeasurePolicy7 = RowKt.rowMeasurePolicy(start7, companion.getTop(), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            companion2 = ComposeUiNode.Companion;
            constructor = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf13 = LayoutKt.modifierMaterializerOf(modifierM520heightInVpY3zN4$default7);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy7, companion2.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap13, companion2.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting()) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf13.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            RowScopeInstance rowScopeInstance7 = RowScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-280382992);
            if (interfaceC0526Fp != null) {
                float f110 = IconLeftPadding;
                float fM5160constructorimpl7 = Dp.m5160constructorimpl(f110 + IconMinPaddedWidth);
                Modifier modifierM536sizeInqDBjuR0$default7 = SizeKt.m536sizeInqDBjuR0$default(Modifier.Companion, fM5160constructorimpl7, fM5160constructorimpl7, 0.0f, 0.0f, 12, null);
                float f111 = IconThreeLineVerticalPadding;
                Modifier modifierM489paddingqDBjuR0$default7 = PaddingKt.m489paddingqDBjuR0$default(modifierM536sizeInqDBjuR0$default7, f110, f111, 0.0f, f111, 4, null);
                Alignment centerStart7 = companion.getCenterStart();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy7 = BoxKt.rememberBoxMeasurePolicy(centerStart7, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                constructor2 = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf14 = LayoutKt.modifierMaterializerOf(modifierM489paddingqDBjuR0$default7);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy7, companion2.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl2, currentCompositionLocalMap14, companion2.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                if (composerM2661constructorimpl2.getInserting()) {
                    composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                interfaceC0552GpModifierMaterializerOf14.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i7 >> 3) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            f = ThreeLineBaselineFirstOffset;
            List listP7 = AbstractC1886cc.p(Dp.m5158boximpl(f), Dp.m5158boximpl(ThreeLineBaselineSecondOffset), Dp.m5158boximpl(ThreeLineBaselineThirdOffset));
            companion3 = Modifier.Companion;
            ListItemKt.BaselinesOffsetColumn(listP7, PaddingKt.m489paddingqDBjuR0$default(AbstractC3955tM.a(rowScopeInstance7, companion3, 1.0f, false, 2, null), ContentLeftPadding, 0.0f, ContentRightPadding, 0.0f, 10, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -318094245, true, new ThreeLine$ListItem$1$2(interfaceC0526Fp4, i7, interfaceC0526Fp2, interfaceC0526Fp3)), composerStartRestartGroup, 390, 0);
            composerStartRestartGroup.startReplaceableGroup(-678936717);
            if (interfaceC0526Fp5 != null) {
                float f112 = ThreeLineTrailingTopPadding;
                ListItemKt.m1142OffsetToBaselineOrCenterKz89ssw(Dp.m5160constructorimpl(f - f112), PaddingKt.m489paddingqDBjuR0$default(companion3, 0.0f, f112, TrailingRightPadding, 0.0f, 9, null), interfaceC0526Fp5, composerStartRestartGroup, ((i7 >> 9) & 896) | 54, 0);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(modifier3, interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, interfaceC0526Fp5, i, i2));
    }
}
