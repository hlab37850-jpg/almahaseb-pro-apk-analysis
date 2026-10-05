package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;
import defpackage.FW;
import defpackage.HV;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.QO;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class SwipeToDismissKt {
    private static final float DISMISS_THRESHOLD = Dp.m5160constructorimpl(56);

    /* JADX INFO: renamed from: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final FixedThreshold invoke(DismissDirection dismissDirection) {
            AbstractC4492zt.h(dismissDirection, "it");
            return new FixedThreshold(SwipeToDismissKt.DISMISS_THRESHOLD, null);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ InterfaceC0552Gp $background;
        final /* synthetic */ Set<DismissDirection> $directions;
        final /* synthetic */ InterfaceC0552Gp $dismissContent;
        final /* synthetic */ InterfaceC3750qp $dismissThresholds;
        final /* synthetic */ DismissState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Set<? extends DismissDirection> set, InterfaceC3750qp interfaceC3750qp, int i, DismissState dismissState, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0552Gp interfaceC0552Gp2) {
            super(3);
            this.$directions = set;
            this.$dismissThresholds = interfaceC3750qp;
            this.$$dirty = i;
            this.$state = dismissState;
            this.$background = interfaceC0552Gp;
            this.$dismissContent = interfaceC0552Gp2;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
            return FW.a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i) {
            int i2;
            AbstractC4492zt.h(boxWithConstraintsScope, "$this$BoxWithConstraints");
            if ((i & 14) == 0) {
                i2 = (composer.changed(boxWithConstraintsScope) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i2 & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(338007641, i, -1, "androidx.compose.material.SwipeToDismiss.<anonymous> (SwipeToDismiss.kt:181)");
            }
            float fM5128getMaxWidthimpl = Constraints.m5128getMaxWidthimpl(boxWithConstraintsScope.mo423getConstraintsmsEJaDk());
            boolean z = composer.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl;
            Float fValueOf = Float.valueOf(0.0f);
            DismissValue dismissValue = DismissValue.Default;
            Map mapK = AbstractC4243wx.k(HV.a(fValueOf, dismissValue));
            Set<DismissDirection> set = this.$directions;
            DismissDirection dismissDirection = DismissDirection.StartToEnd;
            if (set.contains(dismissDirection)) {
                C2020dG c2020dGA = HV.a(Float.valueOf(fM5128getMaxWidthimpl), DismissValue.DismissedToEnd);
                mapK.put(c2020dGA.c(), c2020dGA.e());
            }
            Set<DismissDirection> set2 = this.$directions;
            DismissDirection dismissDirection2 = DismissDirection.EndToStart;
            if (set2.contains(dismissDirection2)) {
                C2020dG c2020dGA2 = HV.a(Float.valueOf(-fM5128getMaxWidthimpl), DismissValue.DismissedToStart);
                mapK.put(c2020dGA2.c(), c2020dGA2.e());
            }
            InterfaceC3750qp interfaceC3750qp = this.$dismissThresholds;
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(interfaceC3750qp);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1(interfaceC3750qp);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            InterfaceC0526Fp interfaceC0526Fp = (InterfaceC0526Fp) objRememberedValue;
            float f = this.$directions.contains(dismissDirection2) ? 10.0f : 20.0f;
            float f2 = this.$directions.contains(dismissDirection) ? 10.0f : 20.0f;
            Modifier.Companion companion = Modifier.Companion;
            Modifier modifierM1237swipeablepPrIpRY = SwipeableKt.m1237swipeablepPrIpRY(companion, this.$state, mapK, Orientation.Horizontal, (TIFFConstants.TIFFTAG_FREEOFFSETS & 8) != 0 ? true : this.$state.getCurrentValue() == dismissValue, (TIFFConstants.TIFFTAG_FREEOFFSETS & 16) != 0 ? false : z, (TIFFConstants.TIFFTAG_FREEOFFSETS & 32) != 0 ? null : null, (TIFFConstants.TIFFTAG_FREEOFFSETS & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : interfaceC0526Fp, (TIFFConstants.TIFFTAG_FREEOFFSETS & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapK.keySet(), 0.0f, 0.0f, 6, null) : new ResistanceConfig(fM5128getMaxWidthimpl, f, f2), (TIFFConstants.TIFFTAG_FREEOFFSETS & 256) != 0 ? SwipeableDefaults.INSTANCE.m1236getVelocityThresholdD9Ej5fM() : 0.0f);
            InterfaceC0552Gp interfaceC0552Gp = this.$background;
            int i3 = this.$$dirty;
            DismissState dismissState = this.$state;
            InterfaceC0552Gp interfaceC0552Gp2 = this.$dismissContent;
            composer.startReplaceableGroup(733328855);
            Alignment.Companion companion2 = Alignment.Companion;
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer, 0);
            composer.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierM1237swipeablepPrIpRY);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composer);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            InterfaceC0526Fp setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            Modifier modifierMatchParentSize = BoxScopeInstance.INSTANCE.matchParentSize(companion);
            int i4 = (i3 >> 3) & 7168;
            composer.startReplaceableGroup(693286680);
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer, 0);
            composer.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            InterfaceC3588op constructor2 = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifierMatchParentSize);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composer);
            Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            InterfaceC0526Fp setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (composerM2661constructorimpl2.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            interfaceC0552GpModifierMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            interfaceC0552Gp.invoke(rowScopeInstance, composer, Integer.valueOf(((i4 >> 6) & 112) | 6));
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.startReplaceableGroup(1157296644);
            boolean zChanged2 = composer.changed(dismissState);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new SwipeToDismissKt$SwipeToDismiss$2$1$1$1(dismissState);
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            Modifier modifierOffset = OffsetKt.offset(companion, (InterfaceC3750qp) objRememberedValue2);
            int i5 = (i3 >> 6) & 7168;
            composer.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer, 0);
            composer.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            InterfaceC3588op constructor3 = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifierOffset);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            Composer composerM2661constructorimpl3 = Updater.m2661constructorimpl(composer);
            Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyRowMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            InterfaceC0526Fp setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
            if (composerM2661constructorimpl3.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM2661constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM2661constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            interfaceC0552GpModifierMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            interfaceC0552Gp2.invoke(rowScopeInstance, composer, Integer.valueOf(((i5 >> 6) & 112) | 6));
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC0552Gp $background;
        final /* synthetic */ Set<DismissDirection> $directions;
        final /* synthetic */ InterfaceC0552Gp $dismissContent;
        final /* synthetic */ InterfaceC3750qp $dismissThresholds;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ DismissState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(DismissState dismissState, Modifier modifier, Set<? extends DismissDirection> set, InterfaceC3750qp interfaceC3750qp, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0552Gp interfaceC0552Gp2, int i, int i2) {
            super(2);
            this.$state = dismissState;
            this.$modifier = modifier;
            this.$directions = set;
            this.$dismissThresholds = interfaceC3750qp;
            this.$background = interfaceC0552Gp;
            this.$dismissContent = interfaceC0552Gp2;
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
            SwipeToDismissKt.SwipeToDismiss(this.$state, this.$modifier, this.$directions, this.$dismissThresholds, this.$background, this.$dismissContent, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeToDismissKt$rememberDismissState$1, reason: invalid class name and case insensitive filesystem */
    public static final class C14501 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C14501 INSTANCE = new C14501();

        public C14501() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(DismissValue dismissValue) {
            AbstractC4492zt.h(dismissValue, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x005d  */
    /* JADX WARN: Code duplicated, block: B:29:0x0063  */
    /* JADX WARN: Code duplicated, block: B:31:0x0068  */
    /* JADX WARN: Code duplicated, block: B:33:0x006c  */
    /* JADX WARN: Code duplicated, block: B:35:0x0074  */
    /* JADX WARN: Code duplicated, block: B:36:0x0077  */
    /* JADX WARN: Code duplicated, block: B:40:0x007f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0082  */
    /* JADX WARN: Code duplicated, block: B:43:0x0088  */
    /* JADX WARN: Code duplicated, block: B:45:0x008e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0091  */
    /* JADX WARN: Code duplicated, block: B:50:0x0098  */
    /* JADX WARN: Code duplicated, block: B:52:0x009c  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:57:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:59:0x00af  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:66:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:76:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:79:0x0131  */
    /* JADX WARN: Code duplicated, block: B:84:0x0141  */
    /* JADX WARN: Code duplicated, block: B:86:? A[RETURN, SYNTHETIC] */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void SwipeToDismiss(DismissState dismissState, Modifier modifier, Set<? extends DismissDirection> set, InterfaceC3750qp interfaceC3750qp, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0552Gp interfaceC0552Gp2, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        InterfaceC3750qp interfaceC3750qp2;
        int i6;
        int i7;
        int i8;
        Modifier modifier3;
        Set<? extends DismissDirection> setH;
        InterfaceC3750qp interfaceC3750qp3;
        Modifier modifier4;
        Set<? extends DismissDirection> set2;
        InterfaceC3750qp interfaceC3750qp4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(dismissState, "state");
        AbstractC4492zt.h(interfaceC0552Gp, CSS.Property.BACKGROUND);
        AbstractC4492zt.h(interfaceC0552Gp2, "dismissContent");
        Composer composerStartRestartGroup = composer.startRestartGroup(634380143);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(dismissState) ? 4 : 2) | i;
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
                i3 |= 128;
            }
            i5 = i2 & 8;
            if (i5 != 0) {
                if ((i & 7168) == 0) {
                    interfaceC3750qp2 = interfaceC3750qp;
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i3 |= i6;
                }
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((57344 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((i2 & 32) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                            i8 = 131072;
                        } else {
                            i8 = 65536;
                        }
                    }
                    if (i4 != 4 && (374491 & i3) == 74898 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        interfaceC3750qp4 = interfaceC3750qp2;
                        modifier4 = modifier2;
                        set2 = set;
                    } else {
                        if (i9 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            setH = QO.h(DismissDirection.EndToStart, DismissDirection.StartToEnd);
                        } else {
                            setH = set;
                        }
                        if (i5 != 0) {
                            interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(634380143, i3, -1, "androidx.compose.material.SwipeToDismiss (SwipeToDismiss.kt:172)");
                        }
                        BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 338007641, true, new AnonymousClass2(setH, interfaceC3750qp3, i3, dismissState, interfaceC0552Gp, interfaceC0552Gp2)), composerStartRestartGroup, ((i3 >> 3) & 14) | 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        set2 = setH;
                        interfaceC3750qp4 = interfaceC3750qp3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(dismissState, modifier4, set2, interfaceC3750qp4, interfaceC0552Gp, interfaceC0552Gp2, i, i2));
                }
                i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i8;
                if (i4 != 4) {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        setH = QO.h(DismissDirection.EndToStart, DismissDirection.StartToEnd);
                    } else {
                        setH = set;
                    }
                    if (i5 != 0) {
                        interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(634380143, i3, -1, "androidx.compose.material.SwipeToDismiss (SwipeToDismiss.kt:172)");
                    }
                    BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 338007641, true, new AnonymousClass2(setH, interfaceC3750qp3, i3, dismissState, interfaceC0552Gp, interfaceC0552Gp2)), composerStartRestartGroup, ((i3 >> 3) & 14) | 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    set2 = setH;
                    interfaceC3750qp4 = interfaceC3750qp3;
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        setH = QO.h(DismissDirection.EndToStart, DismissDirection.StartToEnd);
                    } else {
                        setH = set;
                    }
                    if (i5 != 0) {
                        interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(634380143, i3, -1, "androidx.compose.material.SwipeToDismiss (SwipeToDismiss.kt:172)");
                    }
                    BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 338007641, true, new AnonymousClass2(setH, interfaceC3750qp3, i3, dismissState, interfaceC0552Gp, interfaceC0552Gp2)), composerStartRestartGroup, ((i3 >> 3) & 14) | 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    set2 = setH;
                    interfaceC3750qp4 = interfaceC3750qp3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(dismissState, modifier4, set2, interfaceC3750qp4, interfaceC0552Gp, interfaceC0552Gp2, i, i2));
            }
            i3 |= 3072;
            interfaceC3750qp2 = interfaceC3750qp;
            if ((i2 & 16) != 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((i2 & 32) != 0) {
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                }
                if (i4 != 4) {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        setH = QO.h(DismissDirection.EndToStart, DismissDirection.StartToEnd);
                    } else {
                        setH = set;
                    }
                    if (i5 != 0) {
                        interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(634380143, i3, -1, "androidx.compose.material.SwipeToDismiss (SwipeToDismiss.kt:172)");
                    }
                    BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 338007641, true, new AnonymousClass2(setH, interfaceC3750qp3, i3, dismissState, interfaceC0552Gp, interfaceC0552Gp2)), composerStartRestartGroup, ((i3 >> 3) & 14) | 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    set2 = setH;
                    interfaceC3750qp4 = interfaceC3750qp3;
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        setH = QO.h(DismissDirection.EndToStart, DismissDirection.StartToEnd);
                    } else {
                        setH = set;
                    }
                    if (i5 != 0) {
                        interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(634380143, i3, -1, "androidx.compose.material.SwipeToDismiss (SwipeToDismiss.kt:172)");
                    }
                    BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 338007641, true, new AnonymousClass2(setH, interfaceC3750qp3, i3, dismissState, interfaceC0552Gp, interfaceC0552Gp2)), composerStartRestartGroup, ((i3 >> 3) & 14) | 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    set2 = setH;
                    interfaceC3750qp4 = interfaceC3750qp3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(dismissState, modifier4, set2, interfaceC3750qp4, interfaceC0552Gp, interfaceC0552Gp2, i, i2));
            }
            i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i8;
            if (i4 != 4) {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    setH = QO.h(DismissDirection.EndToStart, DismissDirection.StartToEnd);
                } else {
                    setH = set;
                }
                if (i5 != 0) {
                    interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                } else {
                    interfaceC3750qp3 = interfaceC3750qp2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(634380143, i3, -1, "androidx.compose.material.SwipeToDismiss (SwipeToDismiss.kt:172)");
                }
                BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 338007641, true, new AnonymousClass2(setH, interfaceC3750qp3, i3, dismissState, interfaceC0552Gp, interfaceC0552Gp2)), composerStartRestartGroup, ((i3 >> 3) & 14) | 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                set2 = setH;
                interfaceC3750qp4 = interfaceC3750qp3;
            } else {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    setH = QO.h(DismissDirection.EndToStart, DismissDirection.StartToEnd);
                } else {
                    setH = set;
                }
                if (i5 != 0) {
                    interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                } else {
                    interfaceC3750qp3 = interfaceC3750qp2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(634380143, i3, -1, "androidx.compose.material.SwipeToDismiss (SwipeToDismiss.kt:172)");
                }
                BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 338007641, true, new AnonymousClass2(setH, interfaceC3750qp3, i3, dismissState, interfaceC0552Gp, interfaceC0552Gp2)), composerStartRestartGroup, ((i3 >> 3) & 14) | 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                set2 = setH;
                interfaceC3750qp4 = interfaceC3750qp3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(dismissState, modifier4, set2, interfaceC3750qp4, interfaceC0552Gp, interfaceC0552Gp2, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 128;
        }
        i5 = i2 & 8;
        if (i5 != 0) {
            if ((i & 7168) == 0) {
                interfaceC3750qp2 = interfaceC3750qp;
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            if ((i2 & 16) != 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((i2 & 32) != 0) {
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                }
                if (i4 != 4) {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        setH = QO.h(DismissDirection.EndToStart, DismissDirection.StartToEnd);
                    } else {
                        setH = set;
                    }
                    if (i5 != 0) {
                        interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(634380143, i3, -1, "androidx.compose.material.SwipeToDismiss (SwipeToDismiss.kt:172)");
                    }
                    BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 338007641, true, new AnonymousClass2(setH, interfaceC3750qp3, i3, dismissState, interfaceC0552Gp, interfaceC0552Gp2)), composerStartRestartGroup, ((i3 >> 3) & 14) | 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    set2 = setH;
                    interfaceC3750qp4 = interfaceC3750qp3;
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        setH = QO.h(DismissDirection.EndToStart, DismissDirection.StartToEnd);
                    } else {
                        setH = set;
                    }
                    if (i5 != 0) {
                        interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(634380143, i3, -1, "androidx.compose.material.SwipeToDismiss (SwipeToDismiss.kt:172)");
                    }
                    BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 338007641, true, new AnonymousClass2(setH, interfaceC3750qp3, i3, dismissState, interfaceC0552Gp, interfaceC0552Gp2)), composerStartRestartGroup, ((i3 >> 3) & 14) | 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    set2 = setH;
                    interfaceC3750qp4 = interfaceC3750qp3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(dismissState, modifier4, set2, interfaceC3750qp4, interfaceC0552Gp, interfaceC0552Gp2, i, i2));
            }
            i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i8;
            if (i4 != 4) {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    setH = QO.h(DismissDirection.EndToStart, DismissDirection.StartToEnd);
                } else {
                    setH = set;
                }
                if (i5 != 0) {
                    interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                } else {
                    interfaceC3750qp3 = interfaceC3750qp2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(634380143, i3, -1, "androidx.compose.material.SwipeToDismiss (SwipeToDismiss.kt:172)");
                }
                BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 338007641, true, new AnonymousClass2(setH, interfaceC3750qp3, i3, dismissState, interfaceC0552Gp, interfaceC0552Gp2)), composerStartRestartGroup, ((i3 >> 3) & 14) | 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                set2 = setH;
                interfaceC3750qp4 = interfaceC3750qp3;
            } else {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    setH = QO.h(DismissDirection.EndToStart, DismissDirection.StartToEnd);
                } else {
                    setH = set;
                }
                if (i5 != 0) {
                    interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                } else {
                    interfaceC3750qp3 = interfaceC3750qp2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(634380143, i3, -1, "androidx.compose.material.SwipeToDismiss (SwipeToDismiss.kt:172)");
                }
                BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 338007641, true, new AnonymousClass2(setH, interfaceC3750qp3, i3, dismissState, interfaceC0552Gp, interfaceC0552Gp2)), composerStartRestartGroup, ((i3 >> 3) & 14) | 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                set2 = setH;
                interfaceC3750qp4 = interfaceC3750qp3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(dismissState, modifier4, set2, interfaceC3750qp4, interfaceC0552Gp, interfaceC0552Gp2, i, i2));
        }
        i3 |= 3072;
        interfaceC3750qp2 = interfaceC3750qp;
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((57344 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                i7 = 16384;
            } else {
                i7 = 8192;
            }
            i3 |= i7;
        }
        if ((i2 & 32) != 0) {
            if ((458752 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
            }
            if (i4 != 4) {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    setH = QO.h(DismissDirection.EndToStart, DismissDirection.StartToEnd);
                } else {
                    setH = set;
                }
                if (i5 != 0) {
                    interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                } else {
                    interfaceC3750qp3 = interfaceC3750qp2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(634380143, i3, -1, "androidx.compose.material.SwipeToDismiss (SwipeToDismiss.kt:172)");
                }
                BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 338007641, true, new AnonymousClass2(setH, interfaceC3750qp3, i3, dismissState, interfaceC0552Gp, interfaceC0552Gp2)), composerStartRestartGroup, ((i3 >> 3) & 14) | 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                set2 = setH;
                interfaceC3750qp4 = interfaceC3750qp3;
            } else {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    setH = QO.h(DismissDirection.EndToStart, DismissDirection.StartToEnd);
                } else {
                    setH = set;
                }
                if (i5 != 0) {
                    interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                } else {
                    interfaceC3750qp3 = interfaceC3750qp2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(634380143, i3, -1, "androidx.compose.material.SwipeToDismiss (SwipeToDismiss.kt:172)");
                }
                BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 338007641, true, new AnonymousClass2(setH, interfaceC3750qp3, i3, dismissState, interfaceC0552Gp, interfaceC0552Gp2)), composerStartRestartGroup, ((i3 >> 3) & 14) | 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                set2 = setH;
                interfaceC3750qp4 = interfaceC3750qp3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(dismissState, modifier4, set2, interfaceC3750qp4, interfaceC0552Gp, interfaceC0552Gp2, i, i2));
        }
        i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i3 |= i8;
        if (i4 != 4) {
            if (i9 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                setH = QO.h(DismissDirection.EndToStart, DismissDirection.StartToEnd);
            } else {
                setH = set;
            }
            if (i5 != 0) {
                interfaceC3750qp3 = AnonymousClass1.INSTANCE;
            } else {
                interfaceC3750qp3 = interfaceC3750qp2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(634380143, i3, -1, "androidx.compose.material.SwipeToDismiss (SwipeToDismiss.kt:172)");
            }
            BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 338007641, true, new AnonymousClass2(setH, interfaceC3750qp3, i3, dismissState, interfaceC0552Gp, interfaceC0552Gp2)), composerStartRestartGroup, ((i3 >> 3) & 14) | 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            set2 = setH;
            interfaceC3750qp4 = interfaceC3750qp3;
        } else {
            if (i9 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                setH = QO.h(DismissDirection.EndToStart, DismissDirection.StartToEnd);
            } else {
                setH = set;
            }
            if (i5 != 0) {
                interfaceC3750qp3 = AnonymousClass1.INSTANCE;
            } else {
                interfaceC3750qp3 = interfaceC3750qp2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(634380143, i3, -1, "androidx.compose.material.SwipeToDismiss (SwipeToDismiss.kt:172)");
            }
            BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 338007641, true, new AnonymousClass2(setH, interfaceC3750qp3, i3, dismissState, interfaceC0552Gp, interfaceC0552Gp2)), composerStartRestartGroup, ((i3 >> 3) & 14) | 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            set2 = setH;
            interfaceC3750qp4 = interfaceC3750qp3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(dismissState, modifier4, set2, interfaceC3750qp4, interfaceC0552Gp, interfaceC0552Gp2, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DismissDirection getDismissDirection(DismissValue dismissValue, DismissValue dismissValue2) {
        if (dismissValue == dismissValue2 && dismissValue == DismissValue.Default) {
            return null;
        }
        if (dismissValue == dismissValue2 && dismissValue == DismissValue.DismissedToEnd) {
            return DismissDirection.StartToEnd;
        }
        if (dismissValue == dismissValue2 && dismissValue == DismissValue.DismissedToStart) {
            return DismissDirection.EndToStart;
        }
        DismissValue dismissValue3 = DismissValue.Default;
        if (dismissValue == dismissValue3 && dismissValue2 == DismissValue.DismissedToEnd) {
            return DismissDirection.StartToEnd;
        }
        if (dismissValue == dismissValue3 && dismissValue2 == DismissValue.DismissedToStart) {
            return DismissDirection.EndToStart;
        }
        if (dismissValue == DismissValue.DismissedToEnd && dismissValue2 == dismissValue3) {
            return DismissDirection.StartToEnd;
        }
        if (dismissValue == DismissValue.DismissedToStart && dismissValue2 == dismissValue3) {
            return DismissDirection.EndToStart;
        }
        return null;
    }

    @Composable
    @ExperimentalMaterialApi
    public static final DismissState rememberDismissState(DismissValue dismissValue, InterfaceC3750qp interfaceC3750qp, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1753522702);
        if ((i2 & 1) != 0) {
            dismissValue = DismissValue.Default;
        }
        if ((i2 & 2) != 0) {
            interfaceC3750qp = C14501.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1753522702, i, -1, "androidx.compose.material.rememberDismissState (SwipeToDismiss.kt:148)");
        }
        Object[] objArr = new Object[0];
        Saver<DismissState, DismissValue> Saver = DismissState.Companion.Saver(interfaceC3750qp);
        composer.startReplaceableGroup(511388516);
        boolean zChanged = composer.changed(dismissValue) | composer.changed(interfaceC3750qp);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new SwipeToDismissKt$rememberDismissState$2$1(dismissValue, interfaceC3750qp);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        DismissState dismissState = (DismissState) RememberSaveableKt.m2674rememberSaveable(objArr, (Saver) Saver, (String) null, (InterfaceC3588op) objRememberedValue, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return dismissState;
    }
}
