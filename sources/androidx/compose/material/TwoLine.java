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

/* JADX INFO: loaded from: classes.dex */
final class TwoLine {
    private static final float ContentLeftPadding;
    private static final float ContentRightPadding;
    private static final float IconLeftPadding;
    private static final float IconVerticalPadding;
    private static final float OverlineToPrimaryBaselineOffset;
    private static final float PrimaryToSecondaryBaselineOffsetNoIcon;
    private static final float PrimaryToSecondaryBaselineOffsetWithIcon;
    private static final float TrailingRightPadding;
    public static final TwoLine INSTANCE = new TwoLine();
    private static final float MinHeight = Dp.m5160constructorimpl(64);
    private static final float MinHeightWithIcon = Dp.m5160constructorimpl(72);
    private static final float IconMinPaddedWidth = Dp.m5160constructorimpl(40);
    private static final float OverlineBaselineOffset = Dp.m5160constructorimpl(24);
    private static final float PrimaryBaselineOffsetNoIcon = Dp.m5160constructorimpl(28);
    private static final float PrimaryBaselineOffsetWithIcon = Dp.m5160constructorimpl(32);

    /* JADX INFO: renamed from: androidx.compose.material.TwoLine$ListItem$2, reason: invalid class name */
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
            TwoLine.this.ListItem(this.$modifier, this.$icon, this.$text, this.$secondaryText, this.$overlineText, this.$trailing, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    static {
        float f = 16;
        IconLeftPadding = Dp.m5160constructorimpl(f);
        IconVerticalPadding = Dp.m5160constructorimpl(f);
        ContentLeftPadding = Dp.m5160constructorimpl(f);
        ContentRightPadding = Dp.m5160constructorimpl(f);
        float f2 = 20;
        OverlineToPrimaryBaselineOffset = Dp.m5160constructorimpl(f2);
        PrimaryToSecondaryBaselineOffsetNoIcon = Dp.m5160constructorimpl(f2);
        PrimaryToSecondaryBaselineOffsetWithIcon = Dp.m5160constructorimpl(f2);
        TrailingRightPadding = Dp.m5160constructorimpl(f);
    }

    private TwoLine() {
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0186  */
    /* JADX WARN: Code duplicated, block: B:103:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:105:0x0227  */
    /* JADX WARN: Code duplicated, block: B:108:0x0233  */
    /* JADX WARN: Code duplicated, block: B:109:0x0237  */
    /* JADX WARN: Code duplicated, block: B:112:0x0256  */
    /* JADX WARN: Code duplicated, block: B:114:0x0264  */
    /* JADX WARN: Code duplicated, block: B:118:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:119:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:121:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:122:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:125:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:126:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:130:0x0326 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:131:0x0328  */
    /* JADX WARN: Code duplicated, block: B:133:0x032c  */
    /* JADX WARN: Code duplicated, block: B:137:0x0359  */
    /* JADX WARN: Code duplicated, block: B:141:0x0363  */
    /* JADX WARN: Code duplicated, block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:80:0x00f2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:87:0x0106  */
    /* JADX WARN: Code duplicated, block: B:88:0x0109  */
    /* JADX WARN: Code duplicated, block: B:91:0x0149  */
    /* JADX WARN: Code duplicated, block: B:94:0x0155  */
    /* JADX WARN: Code duplicated, block: B:95:0x0159  */
    /* JADX WARN: Code duplicated, block: B:98:0x0178  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public final void ListItem(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, InterfaceC0526Fp interfaceC0526Fp5, Composer composer, int i, int i2) {
        Modifier modifier2;
        int i3;
        int i4;
        int i5;
        Modifier modifier3;
        float f;
        Alignment.Companion companion;
        int currentCompositeKeyHash;
        ComposeUiNode.Companion companion2;
        InterfaceC3588op constructor;
        Modifier modifier4;
        Composer composerM2661constructorimpl;
        InterfaceC0526Fp setCompositeKeyHash;
        Modifier.Companion companion3;
        Modifier modifierM489paddingqDBjuR0$default;
        Composer composer2;
        boolean z;
        float f2;
        float f3;
        float f4;
        int currentCompositeKeyHash2;
        InterfaceC3588op constructor2;
        Composer composerM2661constructorimpl2;
        InterfaceC0526Fp setCompositeKeyHash2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0526Fp2, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1340612993);
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
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
                i7 |= 1572864;
            } else if ((3670016 & i) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i5 = 1048576;
                } else {
                    i5 = 524288;
                }
                i7 |= i5;
            }
            if ((2995931 & i7) == 599186 || !composerStartRestartGroup.getSkipping()) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1340612993, i7, -1, "androidx.compose.material.TwoLine.ListItem (ListItem.kt:196)");
                }
                if (interfaceC0526Fp == null) {
                    f = MinHeight;
                } else {
                    f = MinHeightWithIcon;
                }
                Modifier modifierM520heightInVpY3zN4$default = SizeKt.m520heightInVpY3zN4$default(modifier3, f, 0.0f, 2, null);
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
                modifier4 = modifier3;
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
                companion3 = Modifier.Companion;
                modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(AbstractC3955tM.a(rowScopeInstance, companion3, 1.0f, false, 2, null), ContentLeftPadding, 0.0f, ContentRightPadding, 0.0f, 10, null);
                composerStartRestartGroup.startReplaceableGroup(-269995367);
                if (interfaceC0526Fp != null) {
                    float f5 = IconLeftPadding;
                    Modifier modifierM536sizeInqDBjuR0$default = SizeKt.m536sizeInqDBjuR0$default(companion3, Dp.m5160constructorimpl(IconMinPaddedWidth + f5), f, 0.0f, 0.0f, 12, null);
                    float f6 = IconVerticalPadding;
                    Modifier modifierM489paddingqDBjuR0$default2 = PaddingKt.m489paddingqDBjuR0$default(modifierM536sizeInqDBjuR0$default, f5, f6, 0.0f, f6, 4, null);
                    Alignment topStart = companion.getTopStart();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(topStart, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    constructor2 = companion2.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifierM489paddingqDBjuR0$default2);
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
                if (interfaceC0526Fp4 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-269994745);
                    z = true;
                    composer2 = composerStartRestartGroup;
                    ListItemKt.BaselinesOffsetColumn(AbstractC1886cc.p(Dp.m5158boximpl(OverlineBaselineOffset), Dp.m5158boximpl(OverlineToPrimaryBaselineOffset)), modifierM489paddingqDBjuR0$default, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1675021441, true, new TwoLine$ListItem$1$2(interfaceC0526Fp4, i7, interfaceC0526Fp2)), composerStartRestartGroup, 390, 0);
                    composer2.endReplaceableGroup();
                } else {
                    composer2 = composerStartRestartGroup;
                    z = true;
                    composer2.startReplaceableGroup(-269994465);
                    if (interfaceC0526Fp != null) {
                        f2 = PrimaryBaselineOffsetWithIcon;
                    } else {
                        f2 = PrimaryBaselineOffsetNoIcon;
                    }
                    Dp dpM5158boximpl = Dp.m5158boximpl(f2);
                    if (interfaceC0526Fp != null) {
                        f3 = PrimaryToSecondaryBaselineOffsetWithIcon;
                    } else {
                        f3 = PrimaryToSecondaryBaselineOffsetNoIcon;
                    }
                    ListItemKt.BaselinesOffsetColumn(AbstractC1886cc.p(dpM5158boximpl, Dp.m5158boximpl(f3)), modifierM489paddingqDBjuR0$default, ComposableLambdaKt.composableLambda(composer2, 993836488, true, new TwoLine$ListItem$1$3(interfaceC0526Fp2, i7, interfaceC0526Fp3)), composer2, 384, 0);
                    composer2.endReplaceableGroup();
                }
                composer2.startReplaceableGroup(-2000988345);
                if (interfaceC0526Fp5 != null) {
                    if (interfaceC0526Fp != null) {
                        f4 = PrimaryBaselineOffsetWithIcon;
                    } else {
                        f4 = PrimaryBaselineOffsetNoIcon;
                    }
                    ListItemKt.m1142OffsetToBaselineOrCenterKz89ssw(f4, null, ComposableLambdaKt.composableLambda(composer2, -1696992176, z, new TwoLine$ListItem$1$4(f, interfaceC0526Fp5, i7)), composer2, 384, 2);
                }
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier4 = modifier2;
                composer2 = composerStartRestartGroup;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(modifier4, interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, interfaceC0526Fp5, i, i2));
        }
        i4 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i7 |= i4;
        if ((i2 & 64) != 0) {
            i7 |= 1572864;
        } else if ((3670016 & i) == 0) {
            if (composerStartRestartGroup.changed(this)) {
                i5 = 1048576;
            } else {
                i5 = 524288;
            }
            i7 |= i5;
        }
        if ((2995931 & i7) == 599186) {
            if (i6 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1340612993, i7, -1, "androidx.compose.material.TwoLine.ListItem (ListItem.kt:196)");
            }
            if (interfaceC0526Fp == null) {
                f = MinHeight;
            } else {
                f = MinHeightWithIcon;
            }
            Modifier modifierM520heightInVpY3zN4$default2 = SizeKt.m520heightInVpY3zN4$default(modifier3, f, 0.0f, 2, null);
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
            modifier4 = modifier3;
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
            companion3 = Modifier.Companion;
            modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(AbstractC3955tM.a(rowScopeInstance2, companion3, 1.0f, false, 2, null), ContentLeftPadding, 0.0f, ContentRightPadding, 0.0f, 10, null);
            composerStartRestartGroup.startReplaceableGroup(-269995367);
            if (interfaceC0526Fp != null) {
                float f7 = IconLeftPadding;
                Modifier modifierM536sizeInqDBjuR0$default2 = SizeKt.m536sizeInqDBjuR0$default(companion3, Dp.m5160constructorimpl(IconMinPaddedWidth + f7), f, 0.0f, 0.0f, 12, null);
                float f8 = IconVerticalPadding;
                Modifier modifierM489paddingqDBjuR0$default3 = PaddingKt.m489paddingqDBjuR0$default(modifierM536sizeInqDBjuR0$default2, f7, f8, 0.0f, f8, 4, null);
                Alignment topStart2 = companion.getTopStart();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(topStart2, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                constructor2 = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(modifierM489paddingqDBjuR0$default3);
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
            if (interfaceC0526Fp4 != null) {
                composerStartRestartGroup.startReplaceableGroup(-269994745);
                z = true;
                composer2 = composerStartRestartGroup;
                ListItemKt.BaselinesOffsetColumn(AbstractC1886cc.p(Dp.m5158boximpl(OverlineBaselineOffset), Dp.m5158boximpl(OverlineToPrimaryBaselineOffset)), modifierM489paddingqDBjuR0$default, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1675021441, true, new TwoLine$ListItem$1$2(interfaceC0526Fp4, i7, interfaceC0526Fp2)), composerStartRestartGroup, 390, 0);
                composer2.endReplaceableGroup();
            } else {
                composer2 = composerStartRestartGroup;
                z = true;
                composer2.startReplaceableGroup(-269994465);
                if (interfaceC0526Fp != null) {
                    f2 = PrimaryBaselineOffsetWithIcon;
                } else {
                    f2 = PrimaryBaselineOffsetNoIcon;
                }
                Dp dpM5158boximpl2 = Dp.m5158boximpl(f2);
                if (interfaceC0526Fp != null) {
                    f3 = PrimaryToSecondaryBaselineOffsetWithIcon;
                } else {
                    f3 = PrimaryToSecondaryBaselineOffsetNoIcon;
                }
                ListItemKt.BaselinesOffsetColumn(AbstractC1886cc.p(dpM5158boximpl2, Dp.m5158boximpl(f3)), modifierM489paddingqDBjuR0$default, ComposableLambdaKt.composableLambda(composer2, 993836488, true, new TwoLine$ListItem$1$3(interfaceC0526Fp2, i7, interfaceC0526Fp3)), composer2, 384, 0);
                composer2.endReplaceableGroup();
            }
            composer2.startReplaceableGroup(-2000988345);
            if (interfaceC0526Fp5 != null) {
                if (interfaceC0526Fp != null) {
                    f4 = PrimaryBaselineOffsetWithIcon;
                } else {
                    f4 = PrimaryBaselineOffsetNoIcon;
                }
                ListItemKt.m1142OffsetToBaselineOrCenterKz89ssw(f4, null, ComposableLambdaKt.composableLambda(composer2, -1696992176, z, new TwoLine$ListItem$1$4(f, interfaceC0526Fp5, i7)), composer2, 384, 2);
            }
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            if (i6 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1340612993, i7, -1, "androidx.compose.material.TwoLine.ListItem (ListItem.kt:196)");
            }
            if (interfaceC0526Fp == null) {
                f = MinHeight;
            } else {
                f = MinHeightWithIcon;
            }
            Modifier modifierM520heightInVpY3zN4$default3 = SizeKt.m520heightInVpY3zN4$default(modifier3, f, 0.0f, 2, null);
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
            modifier4 = modifier3;
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
            companion3 = Modifier.Companion;
            modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(AbstractC3955tM.a(rowScopeInstance3, companion3, 1.0f, false, 2, null), ContentLeftPadding, 0.0f, ContentRightPadding, 0.0f, 10, null);
            composerStartRestartGroup.startReplaceableGroup(-269995367);
            if (interfaceC0526Fp != null) {
                float f9 = IconLeftPadding;
                Modifier modifierM536sizeInqDBjuR0$default3 = SizeKt.m536sizeInqDBjuR0$default(companion3, Dp.m5160constructorimpl(IconMinPaddedWidth + f9), f, 0.0f, 0.0f, 12, null);
                float f10 = IconVerticalPadding;
                Modifier modifierM489paddingqDBjuR0$default4 = PaddingKt.m489paddingqDBjuR0$default(modifierM536sizeInqDBjuR0$default3, f9, f10, 0.0f, f10, 4, null);
                Alignment topStart3 = companion.getTopStart();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(topStart3, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                constructor2 = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf6 = LayoutKt.modifierMaterializerOf(modifierM489paddingqDBjuR0$default4);
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
            if (interfaceC0526Fp4 != null) {
                composerStartRestartGroup.startReplaceableGroup(-269994745);
                z = true;
                composer2 = composerStartRestartGroup;
                ListItemKt.BaselinesOffsetColumn(AbstractC1886cc.p(Dp.m5158boximpl(OverlineBaselineOffset), Dp.m5158boximpl(OverlineToPrimaryBaselineOffset)), modifierM489paddingqDBjuR0$default, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1675021441, true, new TwoLine$ListItem$1$2(interfaceC0526Fp4, i7, interfaceC0526Fp2)), composerStartRestartGroup, 390, 0);
                composer2.endReplaceableGroup();
            } else {
                composer2 = composerStartRestartGroup;
                z = true;
                composer2.startReplaceableGroup(-269994465);
                if (interfaceC0526Fp != null) {
                    f2 = PrimaryBaselineOffsetWithIcon;
                } else {
                    f2 = PrimaryBaselineOffsetNoIcon;
                }
                Dp dpM5158boximpl3 = Dp.m5158boximpl(f2);
                if (interfaceC0526Fp != null) {
                    f3 = PrimaryToSecondaryBaselineOffsetWithIcon;
                } else {
                    f3 = PrimaryToSecondaryBaselineOffsetNoIcon;
                }
                ListItemKt.BaselinesOffsetColumn(AbstractC1886cc.p(dpM5158boximpl3, Dp.m5158boximpl(f3)), modifierM489paddingqDBjuR0$default, ComposableLambdaKt.composableLambda(composer2, 993836488, true, new TwoLine$ListItem$1$3(interfaceC0526Fp2, i7, interfaceC0526Fp3)), composer2, 384, 0);
                composer2.endReplaceableGroup();
            }
            composer2.startReplaceableGroup(-2000988345);
            if (interfaceC0526Fp5 != null) {
                if (interfaceC0526Fp != null) {
                    f4 = PrimaryBaselineOffsetWithIcon;
                } else {
                    f4 = PrimaryBaselineOffsetNoIcon;
                }
                ListItemKt.m1142OffsetToBaselineOrCenterKz89ssw(f4, null, ComposableLambdaKt.composableLambda(composer2, -1696992176, z, new TwoLine$ListItem$1$4(f, interfaceC0526Fp5, i7)), composer2, 384, 2);
            }
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(modifier4, interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, interfaceC0526Fp5, i, i2));
    }
}
