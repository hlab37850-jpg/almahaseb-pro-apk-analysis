package androidx.compose.material3;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AD;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.QO;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class SwipeToDismissKt {
    private static final float DismissThreshold = Dp.m5160constructorimpl(125);

    /* JADX INFO: renamed from: androidx.compose.material3.SwipeToDismissKt$SwipeToDismiss$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ Set<DismissDirection> $directions;

        /* JADX INFO: renamed from: androidx.compose.material3.SwipeToDismissKt$SwipeToDismiss$1$WhenMappings */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[DismissValue.values().length];
                try {
                    iArr[DismissValue.DismissedToEnd.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DismissValue.DismissedToStart.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[DismissValue.Default.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Set<? extends DismissDirection> set) {
            super(2);
            this.$directions = set;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            return m1859invokeO0kMr_c((DismissValue) obj, ((IntSize) obj2).m5324unboximpl());
        }

        /* JADX INFO: renamed from: invoke-O0kMr_c, reason: not valid java name */
        public final Float m1859invokeO0kMr_c(DismissValue dismissValue, long j) {
            AbstractC4492zt.h(dismissValue, "value");
            float fM5320getWidthimpl = IntSize.m5320getWidthimpl(j);
            int i = WhenMappings.$EnumSwitchMapping$0[dismissValue.ordinal()];
            if (i == 1) {
                if (this.$directions.contains(DismissDirection.StartToEnd)) {
                    return Float.valueOf(fM5320getWidthimpl);
                }
                return null;
            }
            if (i != 2) {
                if (i == 3) {
                    return Float.valueOf(0.0f);
                }
                throw new AD();
            }
            if (this.$directions.contains(DismissDirection.EndToStart)) {
                return Float.valueOf(-fM5320getWidthimpl);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SwipeToDismissKt$SwipeToDismiss$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC0552Gp $background;
        final /* synthetic */ Set<DismissDirection> $directions;
        final /* synthetic */ InterfaceC0552Gp $dismissContent;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ DismissState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(DismissState dismissState, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0552Gp interfaceC0552Gp2, Modifier modifier, Set<? extends DismissDirection> set, int i, int i2) {
            super(2);
            this.$state = dismissState;
            this.$background = interfaceC0552Gp;
            this.$dismissContent = interfaceC0552Gp2;
            this.$modifier = modifier;
            this.$directions = set;
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
            SwipeToDismissKt.SwipeToDismiss(this.$state, this.$background, this.$dismissContent, this.$modifier, this.$directions, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SwipeToDismissKt$rememberDismissState$1, reason: invalid class name and case insensitive filesystem */
    public static final class C15651 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C15651 INSTANCE = new C15651();

        public C15651() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(DismissValue dismissValue) {
            AbstractC4492zt.h(dismissValue, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0373  */
    /* JADX WARN: Code duplicated, block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x008b  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:58:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:65:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:68:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:72:0x0164  */
    /* JADX WARN: Code duplicated, block: B:75:0x0170  */
    /* JADX WARN: Code duplicated, block: B:76:0x0174  */
    /* JADX WARN: Code duplicated, block: B:79:0x020c  */
    /* JADX WARN: Code duplicated, block: B:82:0x0218  */
    /* JADX WARN: Code duplicated, block: B:83:0x021c  */
    /* JADX WARN: Code duplicated, block: B:86:0x0286  */
    /* JADX WARN: Code duplicated, block: B:88:0x028e  */
    /* JADX WARN: Code duplicated, block: B:91:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:94:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:95:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:98:0x0365  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void SwipeToDismiss(DismissState dismissState, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0552Gp interfaceC0552Gp2, Modifier modifier, Set<? extends DismissDirection> set, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Set<? extends DismissDirection> setH;
        boolean z;
        DismissValue currentValue;
        DismissValue dismissValue;
        boolean z2;
        InterfaceC3588op constructor;
        InterfaceC3588op constructor2;
        boolean zChanged;
        Object objRememberedValue;
        InterfaceC3588op constructor3;
        Set<? extends DismissDirection> set2;
        Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(dismissState, "state");
        AbstractC4492zt.h(interfaceC0552Gp, CSS.Property.BACKGROUND);
        AbstractC4492zt.h(interfaceC0552Gp2, "dismissContent");
        Composer composerStartRestartGroup = composer.startRestartGroup(-373200705);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(dismissState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC0552Gp) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC0552Gp2) ? 256 : 128;
        }
        int i5 = i2 & 8;
        if (i5 == 0) {
            if ((i & 7168) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                i3 |= 8192;
            }
            if (i4 != 16 && (46811 & i3) == 9362 && composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.skipToGroupEnd();
                set2 = set;
                modifier3 = modifier2;
            } else {
                if (i5 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    setH = QO.h(DismissDirection.EndToStart, DismissDirection.StartToEnd);
                } else {
                    setH = set;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-373200705, i3, -1, "androidx.compose.material3.SwipeToDismiss (SwipeToDismiss.kt:231)");
                }
                if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                    z = true;
                } else {
                    z = false;
                }
                SwipeableV2State<DismissValue> swipeableState$material3_release = dismissState.getSwipeableState$material3_release();
                Orientation orientation = Orientation.Horizontal;
                currentValue = dismissState.getCurrentValue();
                dismissValue = DismissValue.Default;
                if (currentValue == dismissValue) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Modifier modifierSwipeAnchors$default = SwipeableV2Kt.swipeAnchors$default(SwipeableV2Kt.swipeableV2$default(modifier2, swipeableState$material3_release, orientation, z2, z, null, 16, null), dismissState.getSwipeableState$material3_release(), QO.h(dismissValue, DismissValue.DismissedToEnd, DismissValue.DismissedToStart), null, new AnonymousClass1(setH), 4, null);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                Alignment.Companion companion = Alignment.Companion;
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                constructor = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierSwipeAnchors$default);
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
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, density, companion2.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                Modifier.Companion companion3 = Modifier.Companion;
                Modifier modifierMatchParentSize = boxScopeInstance.matchParentSize(companion3);
                int i6 = (i3 << 6) & 7168;
                composerStartRestartGroup.startReplaceableGroup(693286680);
                Arrangement arrangement = Arrangement.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getTop(), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                Set<? extends DismissDirection> set3 = setH;
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor2 = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(modifierMatchParentSize);
                Modifier modifier4 = modifier2;
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl2, density2, companion2.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion2.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion2.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                interfaceC0552Gp.invoke(rowScopeInstance, composerStartRestartGroup, Integer.valueOf(((i6 >> 6) & 112) | 6));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(dismissState);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new SwipeToDismissKt$SwipeToDismiss$2$1$1(dismissState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierOffset = OffsetKt.offset(companion3, (InterfaceC3750qp) objRememberedValue);
                int i7 = (i3 << 3) & 7168;
                composerStartRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getTop(), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor3 = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf3 = LayoutKt.materializerOf(modifierOffset);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl3 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyRowMeasurePolicy2, companion2.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl3, density3, companion2.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl3, layoutDirection3, companion2.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl3, viewConfiguration3, companion2.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                interfaceC0552Gp2.invoke(rowScopeInstance, composerStartRestartGroup, Integer.valueOf(((i7 >> 6) & 112) | 6));
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
                set2 = set3;
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(dismissState, interfaceC0552Gp, interfaceC0552Gp2, modifier3, set2, i, i2));
        }
        i3 |= 3072;
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 != 0) {
            i3 |= 8192;
        }
        if (i4 != 16) {
            if (i5 != 0) {
                modifier2 = Modifier.Companion;
            }
            if (i4 != 0) {
                setH = QO.h(DismissDirection.EndToStart, DismissDirection.StartToEnd);
            } else {
                setH = set;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-373200705, i3, -1, "androidx.compose.material3.SwipeToDismiss (SwipeToDismiss.kt:231)");
            }
            if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                z = true;
            } else {
                z = false;
            }
            SwipeableV2State<DismissValue> swipeableState$material3_release2 = dismissState.getSwipeableState$material3_release();
            Orientation orientation2 = Orientation.Horizontal;
            currentValue = dismissState.getCurrentValue();
            dismissValue = DismissValue.Default;
            if (currentValue == dismissValue) {
                z2 = true;
            } else {
                z2 = false;
            }
            Modifier modifierSwipeAnchors$default2 = SwipeableV2Kt.swipeAnchors$default(SwipeableV2Kt.swipeableV2$default(modifier2, swipeableState$material3_release2, orientation2, z2, z, null, 16, null), dismissState.getSwipeableState$material3_release(), QO.h(dismissValue, DismissValue.DismissedToEnd, DismissValue.DismissedToStart), null, new AnonymousClass1(setH), 4, null);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            Alignment.Companion companion4 = Alignment.Companion;
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion4.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density4 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection4 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration4 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion5 = ComposeUiNode.Companion;
            constructor = companion5.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf4 = LayoutKt.materializerOf(modifierSwipeAnchors$default2);
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
            Composer composerM2661constructorimpl4 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl4, measurePolicyRememberBoxMeasurePolicy2, companion5.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl4, density4, companion5.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl4, layoutDirection4, companion5.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl4, viewConfiguration4, companion5.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf4.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            Modifier.Companion companion6 = Modifier.Companion;
            Modifier modifierMatchParentSize2 = boxScopeInstance2.matchParentSize(companion6);
            int i8 = (i3 << 6) & 7168;
            composerStartRestartGroup.startReplaceableGroup(693286680);
            Arrangement arrangement2 = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement2.getStart(), companion4.getTop(), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density5 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection5 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            Set<? extends DismissDirection> set4 = setH;
            ViewConfiguration viewConfiguration5 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            constructor2 = companion5.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf5 = LayoutKt.materializerOf(modifierMatchParentSize2);
            Modifier modifier5 = modifier2;
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl5 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl5, measurePolicyRowMeasurePolicy3, companion5.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl5, density5, companion5.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl5, layoutDirection5, companion5.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl5, viewConfiguration5, companion5.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf5.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            interfaceC0552Gp.invoke(rowScopeInstance2, composerStartRestartGroup, Integer.valueOf(((i8 >> 6) & 112) | 6));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(dismissState);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue = new SwipeToDismissKt$SwipeToDismiss$2$1$1(dismissState);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new SwipeToDismissKt$SwipeToDismiss$2$1$1(dismissState);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierOffset2 = OffsetKt.offset(companion6, (InterfaceC3750qp) objRememberedValue);
            int i9 = (i3 << 3) & 7168;
            composerStartRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(arrangement2.getStart(), companion4.getTop(), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density6 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection6 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration6 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            constructor3 = companion5.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf6 = LayoutKt.materializerOf(modifierOffset2);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl6 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl6, measurePolicyRowMeasurePolicy4, companion5.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl6, density6, companion5.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl6, layoutDirection6, companion5.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl6, viewConfiguration6, companion5.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf6.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            interfaceC0552Gp2.invoke(rowScopeInstance2, composerStartRestartGroup, Integer.valueOf(((i9 >> 6) & 112) | 6));
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
            set2 = set4;
            modifier3 = modifier5;
        } else {
            if (i5 != 0) {
                modifier2 = Modifier.Companion;
            }
            if (i4 != 0) {
                setH = QO.h(DismissDirection.EndToStart, DismissDirection.StartToEnd);
            } else {
                setH = set;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-373200705, i3, -1, "androidx.compose.material3.SwipeToDismiss (SwipeToDismiss.kt:231)");
            }
            if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                z = true;
            } else {
                z = false;
            }
            SwipeableV2State<DismissValue> swipeableState$material3_release3 = dismissState.getSwipeableState$material3_release();
            Orientation orientation3 = Orientation.Horizontal;
            currentValue = dismissState.getCurrentValue();
            dismissValue = DismissValue.Default;
            if (currentValue == dismissValue) {
                z2 = true;
            } else {
                z2 = false;
            }
            Modifier modifierSwipeAnchors$default3 = SwipeableV2Kt.swipeAnchors$default(SwipeableV2Kt.swipeableV2$default(modifier2, swipeableState$material3_release3, orientation3, z2, z, null, 16, null), dismissState.getSwipeableState$material3_release(), QO.h(dismissValue, DismissValue.DismissedToEnd, DismissValue.DismissedToStart), null, new AnonymousClass1(setH), 4, null);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            Alignment.Companion companion7 = Alignment.Companion;
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(companion7.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density7 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection7 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration7 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion8 = ComposeUiNode.Companion;
            constructor = companion8.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf7 = LayoutKt.materializerOf(modifierSwipeAnchors$default3);
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
            Composer composerM2661constructorimpl7 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl7, measurePolicyRememberBoxMeasurePolicy3, companion8.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl7, density7, companion8.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl7, layoutDirection7, companion8.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl7, viewConfiguration7, companion8.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf7.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            Modifier.Companion companion9 = Modifier.Companion;
            Modifier modifierMatchParentSize3 = boxScopeInstance3.matchParentSize(companion9);
            int i10 = (i3 << 6) & 7168;
            composerStartRestartGroup.startReplaceableGroup(693286680);
            Arrangement arrangement3 = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(arrangement3.getStart(), companion7.getTop(), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density8 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection8 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            Set<? extends DismissDirection> set5 = setH;
            ViewConfiguration viewConfiguration8 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            constructor2 = companion8.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf8 = LayoutKt.materializerOf(modifierMatchParentSize3);
            Modifier modifier6 = modifier2;
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl8 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl8, measurePolicyRowMeasurePolicy5, companion8.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl8, density8, companion8.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl8, layoutDirection8, companion8.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl8, viewConfiguration8, companion8.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf8.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
            interfaceC0552Gp.invoke(rowScopeInstance3, composerStartRestartGroup, Integer.valueOf(((i10 >> 6) & 112) | 6));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(dismissState);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue = new SwipeToDismissKt$SwipeToDismiss$2$1$1(dismissState);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new SwipeToDismissKt$SwipeToDismiss$2$1$1(dismissState);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierOffset3 = OffsetKt.offset(companion9, (InterfaceC3750qp) objRememberedValue);
            int i11 = (i3 << 3) & 7168;
            composerStartRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(arrangement3.getStart(), companion7.getTop(), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density9 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection9 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration9 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            constructor3 = companion8.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf9 = LayoutKt.materializerOf(modifierOffset3);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl9 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl9, measurePolicyRowMeasurePolicy6, companion8.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl9, density9, companion8.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl9, layoutDirection9, companion8.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl9, viewConfiguration9, companion8.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf9.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            interfaceC0552Gp2.invoke(rowScopeInstance3, composerStartRestartGroup, Integer.valueOf(((i11 >> 6) & 112) | 6));
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
            set2 = set5;
            modifier3 = modifier6;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(dismissState, interfaceC0552Gp, interfaceC0552Gp2, modifier3, set2, i, i2));
    }

    @Composable
    @ExperimentalMaterial3Api
    public static final DismissState rememberDismissState(DismissValue dismissValue, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-263967123);
        if ((i2 & 1) != 0) {
            dismissValue = DismissValue.Default;
        }
        if ((i2 & 2) != 0) {
            interfaceC3750qp = C15651.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            interfaceC0526Fp = SwipeToDismissDefaults.INSTANCE.getFixedPositionalThreshold();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-263967123, i, -1, "androidx.compose.material3.rememberDismissState (SwipeToDismiss.kt:205)");
        }
        Object[] objArr = new Object[0];
        Saver<DismissState, DismissValue> Saver = DismissState.Companion.Saver(interfaceC3750qp, interfaceC0526Fp);
        composer.startReplaceableGroup(1618982084);
        boolean zChanged = composer.changed(dismissValue) | composer.changed(interfaceC3750qp) | composer.changed(interfaceC0526Fp);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new SwipeToDismissKt$rememberDismissState$2$1(dismissValue, interfaceC3750qp, interfaceC0526Fp);
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
