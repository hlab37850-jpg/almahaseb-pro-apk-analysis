package androidx.compose.material;

import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2260gB;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class SnackbarKt {
    private static final float HorizontalSpacingButtonSide;
    private static final float TextEndExtraSpacing;
    private static final float HeightToFirstLine = Dp.m5160constructorimpl(30);
    private static final float HorizontalSpacing = Dp.m5160constructorimpl(16);
    private static final float SeparateButtonExtraY = Dp.m5160constructorimpl(2);
    private static final float SnackbarVerticalPadding = Dp.m5160constructorimpl(6);
    private static final float LongButtonVerticalOffset = Dp.m5160constructorimpl(12);
    private static final float SnackbarMinHeightOneLine = Dp.m5160constructorimpl(48);
    private static final float SnackbarMinHeightTwoLines = Dp.m5160constructorimpl(68);

    /* JADX INFO: renamed from: androidx.compose.material.SnackbarKt$NewLineButtonSnackbar$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ InterfaceC0526Fp $action;
        final /* synthetic */ InterfaceC0526Fp $text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, int i) {
            super(2);
            this.$text = interfaceC0526Fp;
            this.$action = interfaceC0526Fp2;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            SnackbarKt.NewLineButtonSnackbar(this.$text, this.$action, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SnackbarKt$OneRowSnackbar$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ InterfaceC0526Fp $action;
        final /* synthetic */ InterfaceC0526Fp $text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, int i) {
            super(2);
            this.$text = interfaceC0526Fp;
            this.$action = interfaceC0526Fp2;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            SnackbarKt.OneRowSnackbar(this.$text, this.$action, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SnackbarKt$TextOnlySnackbar$3, reason: invalid class name and case insensitive filesystem */
    public static final class C14493 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ InterfaceC0526Fp $content;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14493(InterfaceC0526Fp interfaceC0526Fp, int i) {
            super(2);
            this.$content = interfaceC0526Fp;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            SnackbarKt.TextOnlySnackbar(this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    static {
        float f = 8;
        HorizontalSpacingButtonSide = Dp.m5160constructorimpl(f);
        TextEndExtraSpacing = Dp.m5160constructorimpl(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void NewLineButtonSnackbar(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1229075900);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp2) ? 32 : 16;
        }
        if ((i2 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1229075900, i2, -1, "androidx.compose.material.NewLineButtonSnackbar (Snackbar.kt:270)");
            }
            Modifier.Companion companion = Modifier.Companion;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            float f = HorizontalSpacing;
            float f2 = HorizontalSpacingButtonSide;
            Modifier modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(modifierFillMaxWidth$default, f, 0.0f, f2, SeparateButtonExtraY, 2, null);
            composerStartRestartGroup.startReplaceableGroup(-483455358);
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion2 = Alignment.Companion;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierM489paddingqDBjuR0$default);
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
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            InterfaceC0526Fp setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier modifierM489paddingqDBjuR0$default2 = PaddingKt.m489paddingqDBjuR0$default(AlignmentLineKt.m373paddingFromBaselineVpY3zN4(companion, HeightToFirstLine, LongButtonVerticalOffset), 0.0f, 0.0f, f2, 0.0f, 11, null);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            InterfaceC3588op constructor2 = companion3.getConstructor();
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
            Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            InterfaceC0526Fp setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (composerM2661constructorimpl2.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            interfaceC0552GpModifierMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf(i2 & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierAlign = columnScopeInstance.align(companion, companion2.getEnd());
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            InterfaceC3588op constructor3 = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifierAlign);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM2661constructorimpl3 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyRememberBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            InterfaceC0526Fp setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
            if (composerM2661constructorimpl3.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM2661constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM2661constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            interfaceC0552GpModifierMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC0526Fp, interfaceC0526Fp2, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void OneRowSnackbar(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-534813202);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp2) ? 32 : 16;
        }
        if ((i2 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-534813202, i2, -1, "androidx.compose.material.OneRowSnackbar (Snackbar.kt:291)");
            }
            Modifier.Companion companion = Modifier.Companion;
            Modifier modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(companion, HorizontalSpacing, 0.0f, HorizontalSpacingButtonSide, 0.0f, 10, null);
            final String str = "action";
            final String str2 = "text";
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material.SnackbarKt.OneRowSnackbar.2
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
                    int iMax;
                    int i3;
                    int height;
                    AbstractC4492zt.h(measureScope, "$this$Layout");
                    AbstractC4492zt.h(list, "measurables");
                    List<? extends Measurable> list2 = list;
                    String str3 = str;
                    for (Measurable measurable : list2) {
                        if (AbstractC4492zt.d(LayoutIdKt.getLayoutId(measurable), str3)) {
                            Placeable placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(j);
                            int iD = AbstractC3871sJ.d((Constraints.m5128getMaxWidthimpl(j) - placeableMo4159measureBRTryo0.getWidth()) - measureScope.mo327roundToPx0680j_4(SnackbarKt.TextEndExtraSpacing), Constraints.m5130getMinWidthimpl(j));
                            String str4 = str2;
                            for (Measurable measurable2 : list2) {
                                if (AbstractC4492zt.d(LayoutIdKt.getLayoutId(measurable2), str4)) {
                                    Placeable placeableMo4159measureBRTryo1 = measurable2.mo4159measureBRTryo0(Constraints.m5119copyZbe2FdA$default(j, 0, iD, 0, 0, 9, null));
                                    int i4 = placeableMo4159measureBRTryo1.get(androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline());
                                    if (i4 == Integer.MIN_VALUE) {
                                        throw new IllegalArgumentException("No baselines for text");
                                    }
                                    int i5 = placeableMo4159measureBRTryo1.get(androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline());
                                    if (i5 == Integer.MIN_VALUE) {
                                        throw new IllegalArgumentException("No baselines for text");
                                    }
                                    boolean z = i4 == i5;
                                    int iM5128getMaxWidthimpl = Constraints.m5128getMaxWidthimpl(j) - placeableMo4159measureBRTryo0.getWidth();
                                    if (z) {
                                        iMax = Math.max(measureScope.mo327roundToPx0680j_4(SnackbarKt.SnackbarMinHeightOneLine), placeableMo4159measureBRTryo0.getHeight());
                                        int height2 = (iMax - placeableMo4159measureBRTryo1.getHeight()) / 2;
                                        int i6 = placeableMo4159measureBRTryo0.get(androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline());
                                        height = i6 != Integer.MIN_VALUE ? (i4 + height2) - i6 : 0;
                                        i3 = height2;
                                    } else {
                                        int iMo327roundToPx0680j_4 = measureScope.mo327roundToPx0680j_4(SnackbarKt.HeightToFirstLine) - i4;
                                        int iMax2 = Math.max(measureScope.mo327roundToPx0680j_4(SnackbarKt.SnackbarMinHeightTwoLines), placeableMo4159measureBRTryo1.getHeight() + iMo327roundToPx0680j_4);
                                        iMax = iMax2;
                                        i3 = iMo327roundToPx0680j_4;
                                        height = (iMax2 - placeableMo4159measureBRTryo0.getHeight()) / 2;
                                    }
                                    return MeasureScope.CC.q(measureScope, Constraints.m5128getMaxWidthimpl(j), iMax, null, new SnackbarKt$OneRowSnackbar$2$measure$4(placeableMo4159measureBRTryo1, i3, placeableMo4159measureBRTryo0, iM5128getMaxWidthimpl, height), 4, null);
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
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierM489paddingqDBjuR0$default);
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
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            InterfaceC0526Fp setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            Modifier modifierM487paddingVpY3zN4$default = PaddingKt.m487paddingVpY3zN4$default(LayoutIdKt.layoutId(companion, "text"), 0.0f, SnackbarVerticalPadding, 1, null);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            Alignment.Companion companion3 = Alignment.Companion;
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            InterfaceC3588op constructor2 = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifierM487paddingVpY3zN4$default);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            InterfaceC0526Fp setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
            if (composerM2661constructorimpl2.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            interfaceC0552GpModifierMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf(i2 & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierLayoutId = LayoutIdKt.layoutId(companion, "action");
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            InterfaceC3588op constructor3 = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifierLayoutId);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM2661constructorimpl3 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyRememberBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl3, currentCompositionLocalMap3, companion2.getSetResolvedCompositionLocals());
            InterfaceC0526Fp setCompositeKeyHash3 = companion2.getSetCompositeKeyHash();
            if (composerM2661constructorimpl3.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM2661constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM2661constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            interfaceC0552GpModifierMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
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
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC0526Fp, interfaceC0526Fp2, i));
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0140 A[PHI: r0 r2 r4 r5 r6 r8 r13
      0x0140: PHI (r0v15 androidx.compose.ui.Modifier) = (r0v12 androidx.compose.ui.Modifier), (r0v20 androidx.compose.ui.Modifier) binds: [B:128:0x0188, B:107:0x013a] A[DONT_GENERATE, DONT_INLINE]
      0x0140: PHI (r2v7 boolean) = (r2v2 boolean), (r2v8 boolean) binds: [B:128:0x0188, B:107:0x013a] A[DONT_GENERATE, DONT_INLINE]
      0x0140: PHI (r4v25 int) = (r4v19 int), (r4v28 int) binds: [B:128:0x0188, B:107:0x013a] A[DONT_GENERATE, DONT_INLINE]
      0x0140: PHI (r5v8 androidx.compose.ui.graphics.Shape) = (r5v3 androidx.compose.ui.graphics.Shape), (r5v9 androidx.compose.ui.graphics.Shape) binds: [B:128:0x0188, B:107:0x013a] A[DONT_GENERATE, DONT_INLINE]
      0x0140: PHI (r6v6 Fp) = (r6v3 Fp), (r6v2 Fp) binds: [B:128:0x0188, B:107:0x013a] A[DONT_GENERATE, DONT_INLINE]
      0x0140: PHI (r8v9 long) = (r8v4 long), (r8v3 long) binds: [B:128:0x0188, B:107:0x013a] A[DONT_GENERATE, DONT_INLINE]
      0x0140: PHI (r13v13 long) = (r13v4 long), (r13v3 long) binds: [B:128:0x0188, B:107:0x013a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:110:0x0147 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:111:0x0149  */
    /* JADX WARN: Code duplicated, block: B:112:0x014c  */
    /* JADX WARN: Code duplicated, block: B:114:0x0150  */
    /* JADX WARN: Code duplicated, block: B:116:0x0154  */
    /* JADX WARN: Code duplicated, block: B:117:0x0156  */
    /* JADX WARN: Code duplicated, block: B:120:0x015d  */
    /* JADX WARN: Code duplicated, block: B:121:0x016a  */
    /* JADX WARN: Code duplicated, block: B:124:0x0170  */
    /* JADX WARN: Code duplicated, block: B:127:0x017c  */
    /* JADX WARN: Code duplicated, block: B:129:0x018a  */
    /* JADX WARN: Code duplicated, block: B:132:0x019a  */
    /* JADX WARN: Code duplicated, block: B:135:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:140:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:33:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0095  */
    /* JADX WARN: Code duplicated, block: B:53:0x0098  */
    /* JADX WARN: Code duplicated, block: B:56:0x009e  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:93:0x0112  */
    /* JADX WARN: Code duplicated, block: B:95:0x011f  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Snackbar-7zSek6w, reason: not valid java name */
    public static final void m1208Snackbar7zSek6w(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, boolean z, Shape shape, long j, long j2, float f, InterfaceC0526Fp interfaceC0526Fp2, Composer composer, int i, int i2) {
        int i3;
        InterfaceC0526Fp interfaceC0526Fp3;
        int i4;
        int i5;
        long backgroundColor;
        long jM1055getSurface0d7_KjU;
        int i6;
        float f2;
        int i7;
        int i8;
        Modifier modifier2;
        boolean z2;
        Shape small;
        float fM5160constructorimpl;
        int i9;
        Shape shape2;
        boolean z3;
        Modifier modifier3;
        float f3;
        long j3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i10;
        AbstractC4492zt.h(interfaceC0526Fp2, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-558258760);
        int i11 = i2 & 1;
        if (i11 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 == 0) {
            if ((i & 112) == 0) {
                interfaceC0526Fp3 = interfaceC0526Fp;
                i3 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp3) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 7168) != 0) {
                    i3 |= ((i2 & 8) == 0 || !composerStartRestartGroup.changed(shape)) ? 1024 : 2048;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        backgroundColor = j;
                        int i13 = composerStartRestartGroup.changed(backgroundColor) ? 16384 : 8192;
                        i3 |= i13;
                    } else {
                        backgroundColor = j;
                    }
                    i3 |= i13;
                } else {
                    backgroundColor = j;
                }
                if ((i & 458752) == 0) {
                    jM1055getSurface0d7_KjU = j2;
                    if ((i2 & 32) == 0 || !composerStartRestartGroup.changed(jM1055getSurface0d7_KjU)) {
                        i10 = 65536;
                    } else {
                        i10 = 131072;
                    }
                    i3 |= i10;
                } else {
                    jM1055getSurface0d7_KjU = j2;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i3 |= 1572864;
                    f2 = f;
                } else {
                    f2 = f;
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(f2)) {
                            i7 = 1048576;
                        } else {
                            i7 = 524288;
                        }
                        i3 |= i7;
                    }
                }
                if ((i2 & 128) != 0) {
                    if ((29360128 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                            i8 = 8388608;
                        } else {
                            i8 = 4194304;
                        }
                    }
                    if ((23967451 & i3) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp3 = null;
                            }
                            if (i4 != 0) {
                                z2 = false;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 8) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i3 &= -7169;
                            } else {
                                small = shape;
                            }
                            if ((i2 & 16) != 0) {
                                backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 = (-458753) & i3;
                            }
                            if (i6 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(6);
                            }
                            long j4 = backgroundColor;
                            i9 = i3;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-558258760, i9, -1, "androidx.compose.material.Snackbar (Snackbar.kt:80)");
                            }
                            int i14 = i9 >> 6;
                            SurfaceKt.m1227SurfaceFjzlyU(modifier2, small, j4, jM1055getSurface0d7_KjU, null, fM5160constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2084221700, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp3, interfaceC0526Fp2, i9, z2)), composerStartRestartGroup, (i9 & 14) | 1572864 | (i14 & 112) | (i14 & 896) | (i14 & 7168) | ((i9 >> 3) & 458752), 16);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            backgroundColor = j4;
                            shape2 = small;
                            z3 = z2;
                            modifier3 = modifier2;
                            f3 = fM5160constructorimpl;
                            j3 = jM1055getSurface0d7_KjU;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            modifier2 = modifier;
                            z2 = z;
                            small = shape;
                        }
                        fM5160constructorimpl = f2;
                        long j5 = backgroundColor;
                        i9 = i3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-558258760, i9, -1, "androidx.compose.material.Snackbar (Snackbar.kt:80)");
                        }
                        int i15 = i9 >> 6;
                        SurfaceKt.m1227SurfaceFjzlyU(modifier2, small, j5, jM1055getSurface0d7_KjU, null, fM5160constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2084221700, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp3, interfaceC0526Fp2, i9, z2)), composerStartRestartGroup, (i9 & 14) | 1572864 | (i15 & 112) | (i15 & 896) | (i15 & 7168) | ((i9 >> 3) & 458752), 16);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        backgroundColor = j5;
                        shape2 = small;
                        z3 = z2;
                        modifier3 = modifier2;
                        f3 = fM5160constructorimpl;
                        j3 = jM1055getSurface0d7_KjU;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier;
                        z3 = z;
                        shape2 = shape;
                        j3 = jM1055getSurface0d7_KjU;
                        f3 = f2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$2(modifier3, interfaceC0526Fp3, z3, shape2, backgroundColor, j3, f3, interfaceC0526Fp2, i, i2));
                }
                i8 = 12582912;
                i3 |= i8;
                if ((23967451 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp3 = null;
                        }
                        if (i4 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 8) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i3 &= -7169;
                        } else {
                            small = shape;
                        }
                        if ((i2 & 16) != 0) {
                            backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 = (-458753) & i3;
                        }
                        if (i6 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(6);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp3 = null;
                        }
                        if (i4 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 8) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i3 &= -7169;
                        } else {
                            small = shape;
                        }
                        if ((i2 & 16) != 0) {
                            backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 = (-458753) & i3;
                        }
                        if (i6 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(6);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                    }
                    long j6 = backgroundColor;
                    i9 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-558258760, i9, -1, "androidx.compose.material.Snackbar (Snackbar.kt:80)");
                    }
                    int i16 = i9 >> 6;
                    SurfaceKt.m1227SurfaceFjzlyU(modifier2, small, j6, jM1055getSurface0d7_KjU, null, fM5160constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2084221700, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp3, interfaceC0526Fp2, i9, z2)), composerStartRestartGroup, (i9 & 14) | 1572864 | (i16 & 112) | (i16 & 896) | (i16 & 7168) | ((i9 >> 3) & 458752), 16);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    backgroundColor = j6;
                    shape2 = small;
                    z3 = z2;
                    modifier3 = modifier2;
                    f3 = fM5160constructorimpl;
                    j3 = jM1055getSurface0d7_KjU;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp3 = null;
                        }
                        if (i4 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 8) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i3 &= -7169;
                        } else {
                            small = shape;
                        }
                        if ((i2 & 16) != 0) {
                            backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 = (-458753) & i3;
                        }
                        if (i6 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(6);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp3 = null;
                        }
                        if (i4 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 8) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i3 &= -7169;
                        } else {
                            small = shape;
                        }
                        if ((i2 & 16) != 0) {
                            backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 = (-458753) & i3;
                        }
                        if (i6 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(6);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                    }
                    long j7 = backgroundColor;
                    i9 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-558258760, i9, -1, "androidx.compose.material.Snackbar (Snackbar.kt:80)");
                    }
                    int i17 = i9 >> 6;
                    SurfaceKt.m1227SurfaceFjzlyU(modifier2, small, j7, jM1055getSurface0d7_KjU, null, fM5160constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2084221700, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp3, interfaceC0526Fp2, i9, z2)), composerStartRestartGroup, (i9 & 14) | 1572864 | (i17 & 112) | (i17 & 896) | (i17 & 7168) | ((i9 >> 3) & 458752), 16);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    backgroundColor = j7;
                    shape2 = small;
                    z3 = z2;
                    modifier3 = modifier2;
                    f3 = fM5160constructorimpl;
                    j3 = jM1055getSurface0d7_KjU;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$2(modifier3, interfaceC0526Fp3, z3, shape2, backgroundColor, j3, f3, interfaceC0526Fp2, i, i2));
            }
            i3 |= 384;
            if ((i & 7168) != 0) {
                i3 |= ((i2 & 8) == 0 || !composerStartRestartGroup.changed(shape)) ? 1024 : 2048;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    backgroundColor = j;
                    if (composerStartRestartGroup.changed(backgroundColor)) {
                    }
                    i3 |= i13;
                } else {
                    backgroundColor = j;
                }
                i3 |= i13;
            } else {
                backgroundColor = j;
            }
            if ((i & 458752) == 0) {
                jM1055getSurface0d7_KjU = j2;
                if ((i2 & 32) == 0) {
                    i10 = 65536;
                } else {
                    i10 = 65536;
                }
                i3 |= i10;
            } else {
                jM1055getSurface0d7_KjU = j2;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
                f2 = f;
            } else {
                f2 = f;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
            }
            if ((i2 & 128) != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                }
                if ((23967451 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp3 = null;
                        }
                        if (i4 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 8) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i3 &= -7169;
                        } else {
                            small = shape;
                        }
                        if ((i2 & 16) != 0) {
                            backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 = (-458753) & i3;
                        }
                        if (i6 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(6);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp3 = null;
                        }
                        if (i4 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 8) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i3 &= -7169;
                        } else {
                            small = shape;
                        }
                        if ((i2 & 16) != 0) {
                            backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 = (-458753) & i3;
                        }
                        if (i6 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(6);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                    }
                    long j8 = backgroundColor;
                    i9 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-558258760, i9, -1, "androidx.compose.material.Snackbar (Snackbar.kt:80)");
                    }
                    int i18 = i9 >> 6;
                    SurfaceKt.m1227SurfaceFjzlyU(modifier2, small, j8, jM1055getSurface0d7_KjU, null, fM5160constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2084221700, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp3, interfaceC0526Fp2, i9, z2)), composerStartRestartGroup, (i9 & 14) | 1572864 | (i18 & 112) | (i18 & 896) | (i18 & 7168) | ((i9 >> 3) & 458752), 16);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    backgroundColor = j8;
                    shape2 = small;
                    z3 = z2;
                    modifier3 = modifier2;
                    f3 = fM5160constructorimpl;
                    j3 = jM1055getSurface0d7_KjU;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp3 = null;
                        }
                        if (i4 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 8) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i3 &= -7169;
                        } else {
                            small = shape;
                        }
                        if ((i2 & 16) != 0) {
                            backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 = (-458753) & i3;
                        }
                        if (i6 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(6);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp3 = null;
                        }
                        if (i4 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 8) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i3 &= -7169;
                        } else {
                            small = shape;
                        }
                        if ((i2 & 16) != 0) {
                            backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 = (-458753) & i3;
                        }
                        if (i6 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(6);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                    }
                    long j9 = backgroundColor;
                    i9 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-558258760, i9, -1, "androidx.compose.material.Snackbar (Snackbar.kt:80)");
                    }
                    int i19 = i9 >> 6;
                    SurfaceKt.m1227SurfaceFjzlyU(modifier2, small, j9, jM1055getSurface0d7_KjU, null, fM5160constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2084221700, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp3, interfaceC0526Fp2, i9, z2)), composerStartRestartGroup, (i9 & 14) | 1572864 | (i19 & 112) | (i19 & 896) | (i19 & 7168) | ((i9 >> 3) & 458752), 16);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    backgroundColor = j9;
                    shape2 = small;
                    z3 = z2;
                    modifier3 = modifier2;
                    f3 = fM5160constructorimpl;
                    j3 = jM1055getSurface0d7_KjU;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$2(modifier3, interfaceC0526Fp3, z3, shape2, backgroundColor, j3, f3, interfaceC0526Fp2, i, i2));
            }
            i8 = 12582912;
            i3 |= i8;
            if ((23967451 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp3 = null;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 = (-458753) & i3;
                    }
                    if (i6 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(6);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp3 = null;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 = (-458753) & i3;
                    }
                    if (i6 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(6);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                }
                long j10 = backgroundColor;
                i9 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-558258760, i9, -1, "androidx.compose.material.Snackbar (Snackbar.kt:80)");
                }
                int i110 = i9 >> 6;
                SurfaceKt.m1227SurfaceFjzlyU(modifier2, small, j10, jM1055getSurface0d7_KjU, null, fM5160constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2084221700, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp3, interfaceC0526Fp2, i9, z2)), composerStartRestartGroup, (i9 & 14) | 1572864 | (i110 & 112) | (i110 & 896) | (i110 & 7168) | ((i9 >> 3) & 458752), 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                backgroundColor = j10;
                shape2 = small;
                z3 = z2;
                modifier3 = modifier2;
                f3 = fM5160constructorimpl;
                j3 = jM1055getSurface0d7_KjU;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp3 = null;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 = (-458753) & i3;
                    }
                    if (i6 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(6);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp3 = null;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 = (-458753) & i3;
                    }
                    if (i6 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(6);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                }
                long j11 = backgroundColor;
                i9 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-558258760, i9, -1, "androidx.compose.material.Snackbar (Snackbar.kt:80)");
                }
                int i111 = i9 >> 6;
                SurfaceKt.m1227SurfaceFjzlyU(modifier2, small, j11, jM1055getSurface0d7_KjU, null, fM5160constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2084221700, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp3, interfaceC0526Fp2, i9, z2)), composerStartRestartGroup, (i9 & 14) | 1572864 | (i111 & 112) | (i111 & 896) | (i111 & 7168) | ((i9 >> 3) & 458752), 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                backgroundColor = j11;
                shape2 = small;
                z3 = z2;
                modifier3 = modifier2;
                f3 = fM5160constructorimpl;
                j3 = jM1055getSurface0d7_KjU;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$2(modifier3, interfaceC0526Fp3, z3, shape2, backgroundColor, j3, f3, interfaceC0526Fp2, i, i2));
        }
        i3 |= 48;
        interfaceC0526Fp3 = interfaceC0526Fp;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 7168) != 0) {
                i3 |= ((i2 & 8) == 0 || !composerStartRestartGroup.changed(shape)) ? 1024 : 2048;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    backgroundColor = j;
                    if (composerStartRestartGroup.changed(backgroundColor)) {
                    }
                    i3 |= i13;
                } else {
                    backgroundColor = j;
                }
                i3 |= i13;
            } else {
                backgroundColor = j;
            }
            if ((i & 458752) == 0) {
                jM1055getSurface0d7_KjU = j2;
                if ((i2 & 32) == 0) {
                    i10 = 65536;
                } else {
                    i10 = 65536;
                }
                i3 |= i10;
            } else {
                jM1055getSurface0d7_KjU = j2;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
                f2 = f;
            } else {
                f2 = f;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
            }
            if ((i2 & 128) != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                }
                if ((23967451 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp3 = null;
                        }
                        if (i4 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 8) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i3 &= -7169;
                        } else {
                            small = shape;
                        }
                        if ((i2 & 16) != 0) {
                            backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 = (-458753) & i3;
                        }
                        if (i6 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(6);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp3 = null;
                        }
                        if (i4 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 8) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i3 &= -7169;
                        } else {
                            small = shape;
                        }
                        if ((i2 & 16) != 0) {
                            backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 = (-458753) & i3;
                        }
                        if (i6 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(6);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                    }
                    long j12 = backgroundColor;
                    i9 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-558258760, i9, -1, "androidx.compose.material.Snackbar (Snackbar.kt:80)");
                    }
                    int i112 = i9 >> 6;
                    SurfaceKt.m1227SurfaceFjzlyU(modifier2, small, j12, jM1055getSurface0d7_KjU, null, fM5160constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2084221700, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp3, interfaceC0526Fp2, i9, z2)), composerStartRestartGroup, (i9 & 14) | 1572864 | (i112 & 112) | (i112 & 896) | (i112 & 7168) | ((i9 >> 3) & 458752), 16);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    backgroundColor = j12;
                    shape2 = small;
                    z3 = z2;
                    modifier3 = modifier2;
                    f3 = fM5160constructorimpl;
                    j3 = jM1055getSurface0d7_KjU;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp3 = null;
                        }
                        if (i4 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 8) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i3 &= -7169;
                        } else {
                            small = shape;
                        }
                        if ((i2 & 16) != 0) {
                            backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 = (-458753) & i3;
                        }
                        if (i6 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(6);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp3 = null;
                        }
                        if (i4 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 8) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i3 &= -7169;
                        } else {
                            small = shape;
                        }
                        if ((i2 & 16) != 0) {
                            backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 = (-458753) & i3;
                        }
                        if (i6 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(6);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                    }
                    long j13 = backgroundColor;
                    i9 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-558258760, i9, -1, "androidx.compose.material.Snackbar (Snackbar.kt:80)");
                    }
                    int i113 = i9 >> 6;
                    SurfaceKt.m1227SurfaceFjzlyU(modifier2, small, j13, jM1055getSurface0d7_KjU, null, fM5160constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2084221700, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp3, interfaceC0526Fp2, i9, z2)), composerStartRestartGroup, (i9 & 14) | 1572864 | (i113 & 112) | (i113 & 896) | (i113 & 7168) | ((i9 >> 3) & 458752), 16);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    backgroundColor = j13;
                    shape2 = small;
                    z3 = z2;
                    modifier3 = modifier2;
                    f3 = fM5160constructorimpl;
                    j3 = jM1055getSurface0d7_KjU;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$2(modifier3, interfaceC0526Fp3, z3, shape2, backgroundColor, j3, f3, interfaceC0526Fp2, i, i2));
            }
            i8 = 12582912;
            i3 |= i8;
            if ((23967451 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp3 = null;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 = (-458753) & i3;
                    }
                    if (i6 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(6);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp3 = null;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 = (-458753) & i3;
                    }
                    if (i6 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(6);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                }
                long j14 = backgroundColor;
                i9 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-558258760, i9, -1, "androidx.compose.material.Snackbar (Snackbar.kt:80)");
                }
                int i114 = i9 >> 6;
                SurfaceKt.m1227SurfaceFjzlyU(modifier2, small, j14, jM1055getSurface0d7_KjU, null, fM5160constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2084221700, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp3, interfaceC0526Fp2, i9, z2)), composerStartRestartGroup, (i9 & 14) | 1572864 | (i114 & 112) | (i114 & 896) | (i114 & 7168) | ((i9 >> 3) & 458752), 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                backgroundColor = j14;
                shape2 = small;
                z3 = z2;
                modifier3 = modifier2;
                f3 = fM5160constructorimpl;
                j3 = jM1055getSurface0d7_KjU;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp3 = null;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 = (-458753) & i3;
                    }
                    if (i6 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(6);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp3 = null;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 = (-458753) & i3;
                    }
                    if (i6 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(6);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                }
                long j15 = backgroundColor;
                i9 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-558258760, i9, -1, "androidx.compose.material.Snackbar (Snackbar.kt:80)");
                }
                int i115 = i9 >> 6;
                SurfaceKt.m1227SurfaceFjzlyU(modifier2, small, j15, jM1055getSurface0d7_KjU, null, fM5160constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2084221700, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp3, interfaceC0526Fp2, i9, z2)), composerStartRestartGroup, (i9 & 14) | 1572864 | (i115 & 112) | (i115 & 896) | (i115 & 7168) | ((i9 >> 3) & 458752), 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                backgroundColor = j15;
                shape2 = small;
                z3 = z2;
                modifier3 = modifier2;
                f3 = fM5160constructorimpl;
                j3 = jM1055getSurface0d7_KjU;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$2(modifier3, interfaceC0526Fp3, z3, shape2, backgroundColor, j3, f3, interfaceC0526Fp2, i, i2));
        }
        i3 |= 384;
        if ((i & 7168) != 0) {
            i3 |= ((i2 & 8) == 0 || !composerStartRestartGroup.changed(shape)) ? 1024 : 2048;
        }
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                backgroundColor = j;
                if (composerStartRestartGroup.changed(backgroundColor)) {
                }
                i3 |= i13;
            } else {
                backgroundColor = j;
            }
            i3 |= i13;
        } else {
            backgroundColor = j;
        }
        if ((i & 458752) == 0) {
            jM1055getSurface0d7_KjU = j2;
            if ((i2 & 32) == 0) {
                i10 = 65536;
            } else {
                i10 = 65536;
            }
            i3 |= i10;
        } else {
            jM1055getSurface0d7_KjU = j2;
        }
        i6 = i2 & 64;
        if (i6 != 0) {
            i3 |= 1572864;
            f2 = f;
        } else {
            f2 = f;
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
        }
        if ((i2 & 128) != 0) {
            if ((29360128 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
            }
            if ((23967451 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp3 = null;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 = (-458753) & i3;
                    }
                    if (i6 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(6);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp3 = null;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 = (-458753) & i3;
                    }
                    if (i6 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(6);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                }
                long j16 = backgroundColor;
                i9 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-558258760, i9, -1, "androidx.compose.material.Snackbar (Snackbar.kt:80)");
                }
                int i116 = i9 >> 6;
                SurfaceKt.m1227SurfaceFjzlyU(modifier2, small, j16, jM1055getSurface0d7_KjU, null, fM5160constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2084221700, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp3, interfaceC0526Fp2, i9, z2)), composerStartRestartGroup, (i9 & 14) | 1572864 | (i116 & 112) | (i116 & 896) | (i116 & 7168) | ((i9 >> 3) & 458752), 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                backgroundColor = j16;
                shape2 = small;
                z3 = z2;
                modifier3 = modifier2;
                f3 = fM5160constructorimpl;
                j3 = jM1055getSurface0d7_KjU;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp3 = null;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 = (-458753) & i3;
                    }
                    if (i6 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(6);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp3 = null;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 = (-458753) & i3;
                    }
                    if (i6 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(6);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                }
                long j17 = backgroundColor;
                i9 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-558258760, i9, -1, "androidx.compose.material.Snackbar (Snackbar.kt:80)");
                }
                int i117 = i9 >> 6;
                SurfaceKt.m1227SurfaceFjzlyU(modifier2, small, j17, jM1055getSurface0d7_KjU, null, fM5160constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2084221700, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp3, interfaceC0526Fp2, i9, z2)), composerStartRestartGroup, (i9 & 14) | 1572864 | (i117 & 112) | (i117 & 896) | (i117 & 7168) | ((i9 >> 3) & 458752), 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                backgroundColor = j17;
                shape2 = small;
                z3 = z2;
                modifier3 = modifier2;
                f3 = fM5160constructorimpl;
                j3 = jM1055getSurface0d7_KjU;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$2(modifier3, interfaceC0526Fp3, z3, shape2, backgroundColor, j3, f3, interfaceC0526Fp2, i, i2));
        }
        i8 = 12582912;
        i3 |= i8;
        if ((23967451 & i3) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i12 != 0) {
                    interfaceC0526Fp3 = null;
                }
                if (i4 != 0) {
                    z2 = false;
                } else {
                    z2 = z;
                }
                if ((i2 & 8) != 0) {
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    i3 &= -7169;
                } else {
                    small = shape;
                }
                if ((i2 & 16) != 0) {
                    backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 = (-458753) & i3;
                }
                if (i6 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(6);
                } else {
                    fM5160constructorimpl = f2;
                }
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i12 != 0) {
                    interfaceC0526Fp3 = null;
                }
                if (i4 != 0) {
                    z2 = false;
                } else {
                    z2 = z;
                }
                if ((i2 & 8) != 0) {
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    i3 &= -7169;
                } else {
                    small = shape;
                }
                if ((i2 & 16) != 0) {
                    backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 = (-458753) & i3;
                }
                if (i6 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(6);
                } else {
                    fM5160constructorimpl = f2;
                }
            }
            long j18 = backgroundColor;
            i9 = i3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-558258760, i9, -1, "androidx.compose.material.Snackbar (Snackbar.kt:80)");
            }
            int i118 = i9 >> 6;
            SurfaceKt.m1227SurfaceFjzlyU(modifier2, small, j18, jM1055getSurface0d7_KjU, null, fM5160constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2084221700, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp3, interfaceC0526Fp2, i9, z2)), composerStartRestartGroup, (i9 & 14) | 1572864 | (i118 & 112) | (i118 & 896) | (i118 & 7168) | ((i9 >> 3) & 458752), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            backgroundColor = j18;
            shape2 = small;
            z3 = z2;
            modifier3 = modifier2;
            f3 = fM5160constructorimpl;
            j3 = jM1055getSurface0d7_KjU;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i12 != 0) {
                    interfaceC0526Fp3 = null;
                }
                if (i4 != 0) {
                    z2 = false;
                } else {
                    z2 = z;
                }
                if ((i2 & 8) != 0) {
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    i3 &= -7169;
                } else {
                    small = shape;
                }
                if ((i2 & 16) != 0) {
                    backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 = (-458753) & i3;
                }
                if (i6 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(6);
                } else {
                    fM5160constructorimpl = f2;
                }
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i12 != 0) {
                    interfaceC0526Fp3 = null;
                }
                if (i4 != 0) {
                    z2 = false;
                } else {
                    z2 = z;
                }
                if ((i2 & 8) != 0) {
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    i3 &= -7169;
                } else {
                    small = shape;
                }
                if ((i2 & 16) != 0) {
                    backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 = (-458753) & i3;
                }
                if (i6 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(6);
                } else {
                    fM5160constructorimpl = f2;
                }
            }
            long j19 = backgroundColor;
            i9 = i3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-558258760, i9, -1, "androidx.compose.material.Snackbar (Snackbar.kt:80)");
            }
            int i119 = i9 >> 6;
            SurfaceKt.m1227SurfaceFjzlyU(modifier2, small, j19, jM1055getSurface0d7_KjU, null, fM5160constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2084221700, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp3, interfaceC0526Fp2, i9, z2)), composerStartRestartGroup, (i9 & 14) | 1572864 | (i119 & 112) | (i119 & 896) | (i119 & 7168) | ((i9 >> 3) & 458752), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            backgroundColor = j19;
            shape2 = small;
            z3 = z2;
            modifier3 = modifier2;
            f3 = fM5160constructorimpl;
            j3 = jM1055getSurface0d7_KjU;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$2(modifier3, interfaceC0526Fp3, z3, shape2, backgroundColor, j3, f3, interfaceC0526Fp2, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:112:0x0152 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:113:0x0154  */
    /* JADX WARN: Code duplicated, block: B:114:0x0157  */
    /* JADX WARN: Code duplicated, block: B:116:0x015b  */
    /* JADX WARN: Code duplicated, block: B:117:0x015d  */
    /* JADX WARN: Code duplicated, block: B:120:0x0163  */
    /* JADX WARN: Code duplicated, block: B:121:0x0170  */
    /* JADX WARN: Code duplicated, block: B:124:0x0175  */
    /* JADX WARN: Code duplicated, block: B:125:0x017e  */
    /* JADX WARN: Code duplicated, block: B:128:0x0184  */
    /* JADX WARN: Code duplicated, block: B:131:0x0194  */
    /* JADX WARN: Code duplicated, block: B:132:0x019c  */
    /* JADX WARN: Code duplicated, block: B:134:0x019f  */
    /* JADX WARN: Code duplicated, block: B:136:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:139:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:142:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:144:0x01de  */
    /* JADX WARN: Code duplicated, block: B:147:0x0228  */
    /* JADX WARN: Code duplicated, block: B:152:0x0235  */
    /* JADX WARN: Code duplicated, block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004a  */
    /* JADX WARN: Code duplicated, block: B:28:0x004f  */
    /* JADX WARN: Code duplicated, block: B:30:0x0053  */
    /* JADX WARN: Code duplicated, block: B:32:0x005b  */
    /* JADX WARN: Code duplicated, block: B:33:0x005e  */
    /* JADX WARN: Code duplicated, block: B:37:0x0065  */
    /* JADX WARN: Code duplicated, block: B:39:0x0069  */
    /* JADX WARN: Code duplicated, block: B:41:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074  */
    /* JADX WARN: Code duplicated, block: B:45:0x007a  */
    /* JADX WARN: Code duplicated, block: B:48:0x0083  */
    /* JADX WARN: Code duplicated, block: B:50:0x0087  */
    /* JADX WARN: Code duplicated, block: B:53:0x0092 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:56:0x0098  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:64:0x00af  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:70:0x00be  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:80:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:81:0x00de  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:86:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:94:0x0114  */
    /* JADX WARN: Code duplicated, block: B:96:0x0124  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Snackbar-sPrSdHI, reason: not valid java name */
    public static final void m1209SnackbarsPrSdHI(SnackbarData snackbarData, Modifier modifier, boolean z, Shape shape, long j, long j2, long j3, float f, Composer composer, int i, int i2) {
        int i3;
        int i4;
        boolean z2;
        int i5;
        Shape shape2;
        long jM1055getSurface0d7_KjU;
        long j4;
        int i6;
        int i7;
        Modifier modifier2;
        boolean z3;
        Shape small;
        long backgroundColor;
        long primaryActionColor;
        float fM5160constructorimpl;
        long j5;
        long j6;
        long j7;
        String actionLabel;
        ComposableLambda composableLambda;
        Modifier modifier3;
        float f2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        AbstractC4492zt.h(snackbarData, "snackbarData");
        Composer composerStartRestartGroup = composer.startRestartGroup(258660814);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(snackbarData) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
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
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        int i10 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                        i3 |= i10;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i10;
                } else {
                    shape2 = shape;
                }
                if ((i & 57344) != 0) {
                    i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changed(j)) ? 8192 : 16384;
                }
                if ((i & 458752) == 0) {
                    if ((i2 & 32) == 0) {
                        jM1055getSurface0d7_KjU = j2;
                        int i11 = composerStartRestartGroup.changed(jM1055getSurface0d7_KjU) ? 131072 : 65536;
                        i3 |= i11;
                    } else {
                        jM1055getSurface0d7_KjU = j2;
                    }
                    i3 |= i11;
                } else {
                    jM1055getSurface0d7_KjU = j2;
                }
                if ((i & 3670016) == 0) {
                    j4 = j3;
                    if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(j4)) {
                        i8 = 524288;
                    } else {
                        i8 = 1048576;
                    }
                    i3 |= i8;
                } else {
                    j4 = j3;
                }
                i6 = i2 & 128;
                if (i6 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i7 = 8388608;
                    } else {
                        i7 = 4194304;
                    }
                    i3 |= i7;
                }
                if ((i3 & 23967451) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i9 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = false;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 8) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i3 &= -7169;
                        } else {
                            small = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            backgroundColor = j;
                        }
                        if ((i2 & 32) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            primaryActionColor = j4;
                        }
                        if (i6 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(6);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        j5 = primaryActionColor;
                        j6 = jM1055getSurface0d7_KjU;
                        j7 = backgroundColor;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                        }
                        modifier2 = modifier;
                        fM5160constructorimpl = f;
                        z3 = z2;
                        small = shape2;
                        j5 = j4;
                        j6 = jM1055getSurface0d7_KjU;
                        j7 = j;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(258660814, i3, -1, "androidx.compose.material.Snackbar (Snackbar.kt:151)");
                    }
                    actionLabel = snackbarData.getActionLabel();
                    if (actionLabel != null) {
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1843479216, true, new SnackbarKt$Snackbar$actionComposable$1(j5, i3, snackbarData, actionLabel));
                    } else {
                        composableLambda = null;
                    }
                    Modifier modifier4 = modifier2;
                    m1208Snackbar7zSek6w(PaddingKt.m485padding3ABfNKs(modifier2, Dp.m5160constructorimpl(12)), composableLambda, z3, small, j7, j6, fM5160constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -261845785, true, new SnackbarKt$Snackbar$3(snackbarData)), composerStartRestartGroup, (i3 & 896) | 12582912 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 >> 3) & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    f2 = fM5160constructorimpl;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier;
                    f2 = f;
                    z3 = z2;
                    small = shape2;
                    j5 = j4;
                    j6 = jM1055getSurface0d7_KjU;
                    j7 = j;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$4(snackbarData, modifier3, z3, small, j7, j6, j5, f2, i, i2));
            }
            i3 |= 384;
            z2 = z;
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i10;
                } else {
                    shape2 = shape;
                }
                i3 |= i10;
            } else {
                shape2 = shape;
            }
            if ((i & 57344) != 0) {
                i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changed(j)) ? 8192 : 16384;
            }
            if ((i & 458752) == 0) {
                if ((i2 & 32) == 0) {
                    jM1055getSurface0d7_KjU = j2;
                    if (composerStartRestartGroup.changed(jM1055getSurface0d7_KjU)) {
                    }
                    i3 |= i11;
                } else {
                    jM1055getSurface0d7_KjU = j2;
                }
                i3 |= i11;
            } else {
                jM1055getSurface0d7_KjU = j2;
            }
            if ((i & 3670016) == 0) {
                j4 = j3;
                if ((i2 & 64) == 0) {
                    i8 = 524288;
                } else {
                    i8 = 524288;
                }
                i3 |= i8;
            } else {
                j4 = j3;
            }
            i6 = i2 & 128;
            if (i6 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i7 = 8388608;
                } else {
                    i7 = 4194304;
                }
                i3 |= i7;
            }
            if ((i3 & 23967451) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        backgroundColor = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        primaryActionColor = j4;
                    }
                    if (i6 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(6);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    j5 = primaryActionColor;
                    j6 = jM1055getSurface0d7_KjU;
                    j7 = backgroundColor;
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        backgroundColor = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        primaryActionColor = j4;
                    }
                    if (i6 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(6);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    j5 = primaryActionColor;
                    j6 = jM1055getSurface0d7_KjU;
                    j7 = backgroundColor;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(258660814, i3, -1, "androidx.compose.material.Snackbar (Snackbar.kt:151)");
                }
                actionLabel = snackbarData.getActionLabel();
                if (actionLabel != null) {
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1843479216, true, new SnackbarKt$Snackbar$actionComposable$1(j5, i3, snackbarData, actionLabel));
                } else {
                    composableLambda = null;
                }
                Modifier modifier5 = modifier2;
                m1208Snackbar7zSek6w(PaddingKt.m485padding3ABfNKs(modifier2, Dp.m5160constructorimpl(12)), composableLambda, z3, small, j7, j6, fM5160constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -261845785, true, new SnackbarKt$Snackbar$3(snackbarData)), composerStartRestartGroup, (i3 & 896) | 12582912 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 >> 3) & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
                f2 = fM5160constructorimpl;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        backgroundColor = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        primaryActionColor = j4;
                    }
                    if (i6 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(6);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    j5 = primaryActionColor;
                    j6 = jM1055getSurface0d7_KjU;
                    j7 = backgroundColor;
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        backgroundColor = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        primaryActionColor = j4;
                    }
                    if (i6 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(6);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    j5 = primaryActionColor;
                    j6 = jM1055getSurface0d7_KjU;
                    j7 = backgroundColor;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(258660814, i3, -1, "androidx.compose.material.Snackbar (Snackbar.kt:151)");
                }
                actionLabel = snackbarData.getActionLabel();
                if (actionLabel != null) {
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1843479216, true, new SnackbarKt$Snackbar$actionComposable$1(j5, i3, snackbarData, actionLabel));
                } else {
                    composableLambda = null;
                }
                Modifier modifier6 = modifier2;
                m1208Snackbar7zSek6w(PaddingKt.m485padding3ABfNKs(modifier2, Dp.m5160constructorimpl(12)), composableLambda, z3, small, j7, j6, fM5160constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -261845785, true, new SnackbarKt$Snackbar$3(snackbarData)), composerStartRestartGroup, (i3 & 896) | 12582912 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 >> 3) & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier6;
                f2 = fM5160constructorimpl;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$4(snackbarData, modifier3, z3, small, j7, j6, j5, f2, i, i2));
        }
        i3 |= 48;
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
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i10;
                } else {
                    shape2 = shape;
                }
                i3 |= i10;
            } else {
                shape2 = shape;
            }
            if ((i & 57344) != 0) {
                i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changed(j)) ? 8192 : 16384;
            }
            if ((i & 458752) == 0) {
                if ((i2 & 32) == 0) {
                    jM1055getSurface0d7_KjU = j2;
                    if (composerStartRestartGroup.changed(jM1055getSurface0d7_KjU)) {
                    }
                    i3 |= i11;
                } else {
                    jM1055getSurface0d7_KjU = j2;
                }
                i3 |= i11;
            } else {
                jM1055getSurface0d7_KjU = j2;
            }
            if ((i & 3670016) == 0) {
                j4 = j3;
                if ((i2 & 64) == 0) {
                    i8 = 524288;
                } else {
                    i8 = 524288;
                }
                i3 |= i8;
            } else {
                j4 = j3;
            }
            i6 = i2 & 128;
            if (i6 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i7 = 8388608;
                } else {
                    i7 = 4194304;
                }
                i3 |= i7;
            }
            if ((i3 & 23967451) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        backgroundColor = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        primaryActionColor = j4;
                    }
                    if (i6 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(6);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    j5 = primaryActionColor;
                    j6 = jM1055getSurface0d7_KjU;
                    j7 = backgroundColor;
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        backgroundColor = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        primaryActionColor = j4;
                    }
                    if (i6 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(6);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    j5 = primaryActionColor;
                    j6 = jM1055getSurface0d7_KjU;
                    j7 = backgroundColor;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(258660814, i3, -1, "androidx.compose.material.Snackbar (Snackbar.kt:151)");
                }
                actionLabel = snackbarData.getActionLabel();
                if (actionLabel != null) {
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1843479216, true, new SnackbarKt$Snackbar$actionComposable$1(j5, i3, snackbarData, actionLabel));
                } else {
                    composableLambda = null;
                }
                Modifier modifier7 = modifier2;
                m1208Snackbar7zSek6w(PaddingKt.m485padding3ABfNKs(modifier2, Dp.m5160constructorimpl(12)), composableLambda, z3, small, j7, j6, fM5160constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -261845785, true, new SnackbarKt$Snackbar$3(snackbarData)), composerStartRestartGroup, (i3 & 896) | 12582912 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 >> 3) & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier7;
                f2 = fM5160constructorimpl;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        backgroundColor = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        primaryActionColor = j4;
                    }
                    if (i6 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(6);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    j5 = primaryActionColor;
                    j6 = jM1055getSurface0d7_KjU;
                    j7 = backgroundColor;
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        backgroundColor = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        primaryActionColor = j4;
                    }
                    if (i6 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(6);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    j5 = primaryActionColor;
                    j6 = jM1055getSurface0d7_KjU;
                    j7 = backgroundColor;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(258660814, i3, -1, "androidx.compose.material.Snackbar (Snackbar.kt:151)");
                }
                actionLabel = snackbarData.getActionLabel();
                if (actionLabel != null) {
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1843479216, true, new SnackbarKt$Snackbar$actionComposable$1(j5, i3, snackbarData, actionLabel));
                } else {
                    composableLambda = null;
                }
                Modifier modifier8 = modifier2;
                m1208Snackbar7zSek6w(PaddingKt.m485padding3ABfNKs(modifier2, Dp.m5160constructorimpl(12)), composableLambda, z3, small, j7, j6, fM5160constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -261845785, true, new SnackbarKt$Snackbar$3(snackbarData)), composerStartRestartGroup, (i3 & 896) | 12582912 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 >> 3) & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier8;
                f2 = fM5160constructorimpl;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$4(snackbarData, modifier3, z3, small, j7, j6, j5, f2, i, i2));
        }
        i3 |= 384;
        z2 = z;
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i10;
            } else {
                shape2 = shape;
            }
            i3 |= i10;
        } else {
            shape2 = shape;
        }
        if ((i & 57344) != 0) {
            i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changed(j)) ? 8192 : 16384;
        }
        if ((i & 458752) == 0) {
            if ((i2 & 32) == 0) {
                jM1055getSurface0d7_KjU = j2;
                if (composerStartRestartGroup.changed(jM1055getSurface0d7_KjU)) {
                }
                i3 |= i11;
            } else {
                jM1055getSurface0d7_KjU = j2;
            }
            i3 |= i11;
        } else {
            jM1055getSurface0d7_KjU = j2;
        }
        if ((i & 3670016) == 0) {
            j4 = j3;
            if ((i2 & 64) == 0) {
                i8 = 524288;
            } else {
                i8 = 524288;
            }
            i3 |= i8;
        } else {
            j4 = j3;
        }
        i6 = i2 & 128;
        if (i6 != 0) {
            i3 |= 12582912;
        } else if ((i & 29360128) == 0) {
            if (composerStartRestartGroup.changed(f)) {
                i7 = 8388608;
            } else {
                i7 = 4194304;
            }
            i3 |= i7;
        }
        if ((i3 & 23967451) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z3 = false;
                } else {
                    z3 = z2;
                }
                if ((i2 & 8) != 0) {
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    i3 &= -7169;
                } else {
                    small = shape2;
                }
                if ((i2 & 16) != 0) {
                    backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                } else {
                    backgroundColor = j;
                }
                if ((i2 & 32) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    primaryActionColor = j4;
                }
                if (i6 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(6);
                } else {
                    fM5160constructorimpl = f;
                }
                j5 = primaryActionColor;
                j6 = jM1055getSurface0d7_KjU;
                j7 = backgroundColor;
            } else {
                if (i9 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z3 = false;
                } else {
                    z3 = z2;
                }
                if ((i2 & 8) != 0) {
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    i3 &= -7169;
                } else {
                    small = shape2;
                }
                if ((i2 & 16) != 0) {
                    backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                } else {
                    backgroundColor = j;
                }
                if ((i2 & 32) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    primaryActionColor = j4;
                }
                if (i6 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(6);
                } else {
                    fM5160constructorimpl = f;
                }
                j5 = primaryActionColor;
                j6 = jM1055getSurface0d7_KjU;
                j7 = backgroundColor;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(258660814, i3, -1, "androidx.compose.material.Snackbar (Snackbar.kt:151)");
            }
            actionLabel = snackbarData.getActionLabel();
            if (actionLabel != null) {
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1843479216, true, new SnackbarKt$Snackbar$actionComposable$1(j5, i3, snackbarData, actionLabel));
            } else {
                composableLambda = null;
            }
            Modifier modifier9 = modifier2;
            m1208Snackbar7zSek6w(PaddingKt.m485padding3ABfNKs(modifier2, Dp.m5160constructorimpl(12)), composableLambda, z3, small, j7, j6, fM5160constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -261845785, true, new SnackbarKt$Snackbar$3(snackbarData)), composerStartRestartGroup, (i3 & 896) | 12582912 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 >> 3) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier9;
            f2 = fM5160constructorimpl;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z3 = false;
                } else {
                    z3 = z2;
                }
                if ((i2 & 8) != 0) {
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    i3 &= -7169;
                } else {
                    small = shape2;
                }
                if ((i2 & 16) != 0) {
                    backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                } else {
                    backgroundColor = j;
                }
                if ((i2 & 32) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    primaryActionColor = j4;
                }
                if (i6 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(6);
                } else {
                    fM5160constructorimpl = f;
                }
                j5 = primaryActionColor;
                j6 = jM1055getSurface0d7_KjU;
                j7 = backgroundColor;
            } else {
                if (i9 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z3 = false;
                } else {
                    z3 = z2;
                }
                if ((i2 & 8) != 0) {
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    i3 &= -7169;
                } else {
                    small = shape2;
                }
                if ((i2 & 16) != 0) {
                    backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                } else {
                    backgroundColor = j;
                }
                if ((i2 & 32) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    primaryActionColor = j4;
                }
                if (i6 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(6);
                } else {
                    fM5160constructorimpl = f;
                }
                j5 = primaryActionColor;
                j6 = jM1055getSurface0d7_KjU;
                j7 = backgroundColor;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(258660814, i3, -1, "androidx.compose.material.Snackbar (Snackbar.kt:151)");
            }
            actionLabel = snackbarData.getActionLabel();
            if (actionLabel != null) {
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1843479216, true, new SnackbarKt$Snackbar$actionComposable$1(j5, i3, snackbarData, actionLabel));
            } else {
                composableLambda = null;
            }
            Modifier modifier10 = modifier2;
            m1208Snackbar7zSek6w(PaddingKt.m485padding3ABfNKs(modifier2, Dp.m5160constructorimpl(12)), composableLambda, z3, small, j7, j6, fM5160constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -261845785, true, new SnackbarKt$Snackbar$3(snackbarData)), composerStartRestartGroup, (i3 & 896) | 12582912 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 >> 3) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier10;
            f2 = fM5160constructorimpl;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$4(snackbarData, modifier3, z3, small, j7, j6, j5, f2, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void TextOnlySnackbar(InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(917397959);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(917397959, i2, -1, "androidx.compose.material.TextOnlySnackbar (Snackbar.kt:235)");
            }
            C14482 c14482 = new MeasurePolicy() { // from class: androidx.compose.material.SnackbarKt.TextOnlySnackbar.2
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
                    AbstractC4492zt.h(measureScope, "$this$Layout");
                    AbstractC4492zt.h(list, "measurables");
                    if (list.size() != 1) {
                        throw new IllegalArgumentException("text for Snackbar expected to have exactly only one child");
                    }
                    Placeable placeableMo4159measureBRTryo0 = ((Measurable) AbstractC3240kc.b0(list)).mo4159measureBRTryo0(j);
                    int i3 = placeableMo4159measureBRTryo0.get(androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline());
                    int i4 = placeableMo4159measureBRTryo0.get(androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline());
                    if (i3 == Integer.MIN_VALUE) {
                        throw new IllegalArgumentException("No baselines for text");
                    }
                    if (i4 == Integer.MIN_VALUE) {
                        throw new IllegalArgumentException("No baselines for text");
                    }
                    int iMax = Math.max(measureScope.mo327roundToPx0680j_4(i3 == i4 ? SnackbarKt.SnackbarMinHeightOneLine : SnackbarKt.SnackbarMinHeightTwoLines), placeableMo4159measureBRTryo0.getHeight());
                    return MeasureScope.CC.q(measureScope, Constraints.m5128getMaxWidthimpl(j), iMax, null, new SnackbarKt$TextOnlySnackbar$2$measure$4(iMax, placeableMo4159measureBRTryo0), 4, null);
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
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
            Updater.m2668setimpl(composerM2661constructorimpl, c14482, companion2.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            InterfaceC0526Fp setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            Modifier modifierM486paddingVpY3zN4 = PaddingKt.m486paddingVpY3zN4(companion, HorizontalSpacing, SnackbarVerticalPadding);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            InterfaceC3588op constructor2 = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifierM486paddingVpY3zN4);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            InterfaceC0526Fp setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
            if (composerM2661constructorimpl2.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            interfaceC0552GpModifierMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf(i2 & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
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
        scopeUpdateScopeEndRestartGroup.updateScope(new C14493(interfaceC0526Fp, i));
    }
}
