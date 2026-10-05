package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.AlignmentLineKt;
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
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2260gB;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.MJ;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AlertDialogKt {
    private static final long TextBaselineDistanceFromTitle;
    private static final long TextBaselineDistanceFromTop;
    private static final Modifier TextPadding;
    private static final long TitleBaselineDistanceFromTop;
    private static final Modifier TitlePadding;

    /* JADX INFO: renamed from: androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ InterfaceC0526Fp $text;
        final /* synthetic */ ColumnScope $this_AlertDialogBaselineLayout;
        final /* synthetic */ InterfaceC0526Fp $title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(ColumnScope columnScope, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, int i) {
            super(2);
            this.$this_AlertDialogBaselineLayout = columnScope;
            this.$title = interfaceC0526Fp;
            this.$text = interfaceC0526Fp2;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            AlertDialogKt.AlertDialogBaselineLayout(this.$this_AlertDialogBaselineLayout, this.$title, this.$text, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    static {
        Modifier.Companion companion = Modifier.Companion;
        float f = 24;
        TitlePadding = PaddingKt.m489paddingqDBjuR0$default(companion, Dp.m5160constructorimpl(f), 0.0f, Dp.m5160constructorimpl(f), 0.0f, 10, null);
        TextPadding = PaddingKt.m489paddingqDBjuR0$default(companion, Dp.m5160constructorimpl(f), 0.0f, Dp.m5160constructorimpl(f), Dp.m5160constructorimpl(28), 2, null);
        TitleBaselineDistanceFromTop = TextUnitKt.getSp(40);
        TextBaselineDistanceFromTitle = TextUnitKt.getSp(36);
        TextBaselineDistanceFromTop = TextUnitKt.getSp(38);
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void AlertDialogBaselineLayout(ColumnScope columnScope, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, Composer composer, int i) {
        int i2;
        AbstractC4492zt.h(columnScope, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(-555573207);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(columnScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp2) ? 256 : 128;
        }
        if ((i2 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-555573207, i, -1, "androidx.compose.material.AlertDialogBaselineLayout (AlertDialog.kt:92)");
            }
            Modifier modifierWeight = columnScope.weight(Modifier.Companion, 1.0f, false);
            AnonymousClass2 anonymousClass2 = new MeasurePolicy() { // from class: androidx.compose.material.AlertDialogKt.AlertDialogBaselineLayout.2
                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                    return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i3);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                    return AbstractC2260gB.b(this, intrinsicMeasureScope, list, i3);
                }

                /* JADX WARN: Code duplicated, block: B:39:0x00af  */
                /* JADX WARN: Code duplicated, block: B:47:0x00c9  */
                /* JADX WARN: Code duplicated, block: B:56:0x00eb  */
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                    Object next;
                    Object next2;
                    int iIntValue;
                    int iIntValue2;
                    int iIntValue3;
                    int i3;
                    AbstractC4492zt.h(measureScope, "$this$Layout");
                    AbstractC4492zt.h(list, "measurables");
                    List<? extends Measurable> list2 = list;
                    Iterator<T> it = list2.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!AbstractC4492zt.d(LayoutIdKt.getLayoutId((Measurable) next), "title"));
                    Measurable measurable = (Measurable) next;
                    Placeable placeableMo4159measureBRTryo0 = measurable != null ? measurable.mo4159measureBRTryo0(Constraints.m5119copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null)) : null;
                    Iterator<T> it2 = list2.iterator();
                    do {
                        if (!it2.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it2.next();
                    } while (!AbstractC4492zt.d(LayoutIdKt.getLayoutId((Measurable) next2), "text"));
                    Measurable measurable2 = (Measurable) next2;
                    Placeable placeableMo4159measureBRTryo1 = measurable2 != null ? measurable2.mo4159measureBRTryo0(Constraints.m5119copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null)) : null;
                    int height = 0;
                    int iMax = Math.max(placeableMo4159measureBRTryo0 != null ? placeableMo4159measureBRTryo0.getWidth() : 0, placeableMo4159measureBRTryo1 != null ? placeableMo4159measureBRTryo1.getWidth() : 0);
                    if (placeableMo4159measureBRTryo0 == null) {
                        iIntValue = 0;
                    } else {
                        int iIntValue4 = Integer.valueOf(placeableMo4159measureBRTryo0.get(AlignmentLineKt.getFirstBaseline())).intValue();
                        Integer numValueOf = iIntValue4 == Integer.MIN_VALUE ? null : Integer.valueOf(iIntValue4);
                        if (numValueOf != null) {
                            iIntValue = numValueOf.intValue();
                        } else {
                            iIntValue = 0;
                        }
                    }
                    if (placeableMo4159measureBRTryo0 == null) {
                        iIntValue2 = 0;
                    } else {
                        int i4 = placeableMo4159measureBRTryo0.get(AlignmentLineKt.getLastBaseline());
                        Integer numValueOf2 = i4 == Integer.MIN_VALUE ? null : Integer.valueOf(i4);
                        if (numValueOf2 != null) {
                            iIntValue2 = numValueOf2.intValue();
                        } else {
                            iIntValue2 = 0;
                        }
                    }
                    int iMo326roundToPxR2X_6o = measureScope.mo326roundToPxR2X_6o(AlertDialogKt.TitleBaselineDistanceFromTop) - iIntValue;
                    if (placeableMo4159measureBRTryo1 == null) {
                        iIntValue3 = 0;
                    } else {
                        int i5 = placeableMo4159measureBRTryo1.get(AlignmentLineKt.getFirstBaseline());
                        Integer numValueOf3 = i5 != Integer.MIN_VALUE ? Integer.valueOf(i5) : null;
                        if (numValueOf3 != null) {
                            iIntValue3 = numValueOf3.intValue();
                        } else {
                            iIntValue3 = 0;
                        }
                    }
                    int iMo326roundToPxR2X_6o2 = placeableMo4159measureBRTryo0 == null ? measureScope.mo326roundToPxR2X_6o(AlertDialogKt.TextBaselineDistanceFromTop) : measureScope.mo326roundToPxR2X_6o(AlertDialogKt.TextBaselineDistanceFromTitle);
                    int height2 = placeableMo4159measureBRTryo0 != null ? placeableMo4159measureBRTryo0.getHeight() + iMo326roundToPxR2X_6o : 0;
                    if (placeableMo4159measureBRTryo0 == null) {
                        i3 = iMo326roundToPxR2X_6o2 - iIntValue3;
                    } else {
                        i3 = (iIntValue2 == 0 ? height2 - iIntValue3 : (iMo326roundToPxR2X_6o + iIntValue2) - iIntValue3) + iMo326roundToPxR2X_6o2;
                    }
                    if (placeableMo4159measureBRTryo1 != null) {
                        if (iIntValue2 == 0) {
                            height = (placeableMo4159measureBRTryo1.getHeight() + iMo326roundToPxR2X_6o2) - iIntValue3;
                        } else {
                            height = ((placeableMo4159measureBRTryo1.getHeight() + iMo326roundToPxR2X_6o2) - iIntValue3) - ((placeableMo4159measureBRTryo0 != null ? placeableMo4159measureBRTryo0.getHeight() : 0) - iIntValue2);
                        }
                    }
                    return MeasureScope.CC.q(measureScope, iMax, height + height2, null, new AlertDialogKt$AlertDialogBaselineLayout$2$measure$1(placeableMo4159measureBRTryo0, iMo326roundToPxR2X_6o, placeableMo4159measureBRTryo1, i3), 4, null);
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
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierWeight);
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
            Updater.m2668setimpl(composerM2661constructorimpl, anonymousClass2, companion.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            InterfaceC0526Fp setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-1160646206);
            if (interfaceC0526Fp != null) {
                Modifier modifierLayoutId = LayoutIdKt.layoutId(TitlePadding, "title");
                Alignment.Companion companion2 = Alignment.Companion;
                Modifier modifierAlign = columnScope.align(modifierLayoutId, companion2.getStart());
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                InterfaceC3588op constructor2 = companion.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifierAlign);
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
                Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl2, currentCompositionLocalMap2, companion.getSetResolvedCompositionLocals());
                InterfaceC0526Fp setCompositeKeyHash2 = companion.getSetCompositeKeyHash();
                if (composerM2661constructorimpl2.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                interfaceC0552GpModifierMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(-1735756597);
            if (interfaceC0526Fp2 != null) {
                Modifier modifierLayoutId2 = LayoutIdKt.layoutId(TextPadding, "text");
                Alignment.Companion companion3 = Alignment.Companion;
                Modifier modifierAlign2 = columnScope.align(modifierLayoutId2, companion3.getStart());
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                InterfaceC3588op constructor3 = companion.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifierAlign2);
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
                Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyRememberBoxMeasurePolicy2, companion.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl3, currentCompositionLocalMap3, companion.getSetResolvedCompositionLocals());
                InterfaceC0526Fp setCompositeKeyHash3 = companion.getSetCompositeKeyHash();
                if (composerM2661constructorimpl3.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    composerM2661constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM2661constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                interfaceC0552GpModifierMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
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
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(columnScope, interfaceC0526Fp, interfaceC0526Fp2, i));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x011d A[PHI: r0 r3 r4 r6 r7 r8
      0x011d: PHI (r0v8 androidx.compose.ui.Modifier) = (r0v5 androidx.compose.ui.Modifier), (r0v13 androidx.compose.ui.Modifier) binds: [B:119:0x0156, B:99:0x0118] A[DONT_GENERATE, DONT_INLINE]
      0x011d: PHI (r3v28 int) = (r3v19 int), (r3v31 int) binds: [B:119:0x0156, B:99:0x0118] A[DONT_GENERATE, DONT_INLINE]
      0x011d: PHI (r4v5 Fp) = (r4v2 Fp), (r4v6 Fp) binds: [B:119:0x0156, B:99:0x0118] A[DONT_GENERATE, DONT_INLINE]
      0x011d: PHI (r6v12 androidx.compose.ui.graphics.Shape) = (r6v7 androidx.compose.ui.graphics.Shape), (r6v13 androidx.compose.ui.graphics.Shape) binds: [B:119:0x0156, B:99:0x0118] A[DONT_GENERATE, DONT_INLINE]
      0x011d: PHI (r7v6 Fp) = (r7v3 Fp), (r7v2 Fp) binds: [B:119:0x0156, B:99:0x0118] A[DONT_GENERATE, DONT_INLINE]
      0x011d: PHI (r8v11 long) = (r8v7 long), (r8v12 long) binds: [B:119:0x0156, B:99:0x0118] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:101:0x0120 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x0122  */
    /* JADX WARN: Code duplicated, block: B:103:0x0125  */
    /* JADX WARN: Code duplicated, block: B:106:0x012a  */
    /* JADX WARN: Code duplicated, block: B:109:0x012e  */
    /* JADX WARN: Code duplicated, block: B:112:0x0134  */
    /* JADX WARN: Code duplicated, block: B:113:0x0141  */
    /* JADX WARN: Code duplicated, block: B:116:0x0146  */
    /* JADX WARN: Code duplicated, block: B:117:0x0153  */
    /* JADX WARN: Code duplicated, block: B:120:0x0158  */
    /* JADX WARN: Code duplicated, block: B:123:0x016c  */
    /* JADX WARN: Code duplicated, block: B:126:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:131:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    /* JADX WARN: Code duplicated, block: B:28:0x004d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0051  */
    /* JADX WARN: Code duplicated, block: B:32:0x0059  */
    /* JADX WARN: Code duplicated, block: B:33:0x005c  */
    /* JADX WARN: Code duplicated, block: B:37:0x0063  */
    /* JADX WARN: Code duplicated, block: B:39:0x0068  */
    /* JADX WARN: Code duplicated, block: B:41:0x006c  */
    /* JADX WARN: Code duplicated, block: B:43:0x0074  */
    /* JADX WARN: Code duplicated, block: B:44:0x0077  */
    /* JADX WARN: Code duplicated, block: B:48:0x0080  */
    /* JADX WARN: Code duplicated, block: B:50:0x0084  */
    /* JADX WARN: Code duplicated, block: B:52:0x008c  */
    /* JADX WARN: Code duplicated, block: B:53:0x008f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0095  */
    /* JADX WARN: Code duplicated, block: B:59:0x009c  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:70:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:72:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:74:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:75:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:78:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:81:0x00da  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fd  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: AlertDialogContent-WMdw5o4, reason: not valid java name */
    public static final void m968AlertDialogContentWMdw5o4(InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, Shape shape, long j, long j2, Composer composer, int i, int i2) {
        int i3;
        int i4;
        InterfaceC0526Fp interfaceC0526Fp4;
        int i5;
        int i6;
        InterfaceC0526Fp interfaceC0526Fp5;
        int i7;
        Shape shape2;
        long j3;
        long j4;
        Modifier modifier2;
        InterfaceC0526Fp interfaceC0526Fp6;
        Shape medium;
        long jM1055getSurface0d7_KjU;
        long j5;
        Modifier modifier3;
        Shape shape3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0526Fp, "buttons");
        Composer composerStartRestartGroup = composer.startRestartGroup(-453679601);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    interfaceC0526Fp4 = interfaceC0526Fp2;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 7168) == 0) {
                        interfaceC0526Fp5 = interfaceC0526Fp3;
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((57344 & i) == 0) {
                        if ((i2 & 16) == 0) {
                            shape2 = shape;
                            int i9 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                            i3 |= i9;
                        } else {
                            shape2 = shape;
                        }
                        i3 |= i9;
                    } else {
                        shape2 = shape;
                    }
                    if ((458752 & i) == 0) {
                        if ((i2 & 32) == 0) {
                            j3 = j;
                            int i10 = composerStartRestartGroup.changed(j3) ? 131072 : 65536;
                            i3 |= i10;
                        } else {
                            j3 = j;
                        }
                        i3 |= i10;
                    } else {
                        j3 = j;
                    }
                    if ((3670016 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            j4 = j2;
                            int i11 = composerStartRestartGroup.changed(j4) ? 1048576 : 524288;
                            i3 |= i11;
                        } else {
                            j4 = j2;
                        }
                        i3 |= i11;
                    } else {
                        j4 = j2;
                    }
                    if ((i3 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i8 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            interfaceC0526Fp6 = i6 == 0 ? interfaceC0526Fp5 : null;
                            if ((i2 & 16) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -57345;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 32) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -458753;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i2 & 64) != 0) {
                                long jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                                i3 &= -3670017;
                                j5 = jM1069contentColorForek8zF_U;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-453679601, i3, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:43)");
                            }
                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp4, interfaceC0526Fp6, interfaceC0526Fp, i3));
                            int i12 = ((i3 >> 3) & 14) | 1572864;
                            int i13 = i3 >> 9;
                            SurfaceKt.m1227SurfaceFjzlyU(modifier2, medium, jM1055getSurface0d7_KjU, j5, null, 0.0f, composableLambda, composerStartRestartGroup, i12 | (i13 & 112) | (i13 & 896) | (i13 & 7168), 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            shape3 = medium;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
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
                            interfaceC0526Fp6 = interfaceC0526Fp5;
                            medium = shape2;
                            jM1055getSurface0d7_KjU = j3;
                        }
                        j5 = j4;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-453679601, i3, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:43)");
                        }
                        ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp4, interfaceC0526Fp6, interfaceC0526Fp, i3));
                        int i14 = ((i3 >> 3) & 14) | 1572864;
                        int i15 = i3 >> 9;
                        SurfaceKt.m1227SurfaceFjzlyU(modifier2, medium, jM1055getSurface0d7_KjU, j5, null, 0.0f, composableLambda2, composerStartRestartGroup, i14 | (i15 & 112) | (i15 & 896) | (i15 & 7168), 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        shape3 = medium;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        shape3 = shape2;
                        jM1055getSurface0d7_KjU = j3;
                        j5 = j4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AlertDialogKt$AlertDialogContent$2(interfaceC0526Fp, modifier3, interfaceC0526Fp4, interfaceC0526Fp6, shape3, jM1055getSurface0d7_KjU, j5, i, i2));
                }
                i3 |= 3072;
                interfaceC0526Fp5 = interfaceC0526Fp3;
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i9;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i9;
                } else {
                    shape2 = shape;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        j3 = j;
                        if (composerStartRestartGroup.changed(j3)) {
                        }
                        i3 |= i10;
                    } else {
                        j3 = j;
                    }
                    i3 |= i10;
                } else {
                    j3 = j;
                }
                if ((3670016 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        j4 = j2;
                        if (composerStartRestartGroup.changed(j4)) {
                        }
                        i3 |= i11;
                    } else {
                        j4 = j2;
                    }
                    i3 |= i11;
                } else {
                    j4 = j2;
                }
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -57345;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -458753;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 64) != 0) {
                            long jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -3670017;
                            j5 = jM1069contentColorForek8zF_U2;
                        } else {
                            j5 = j4;
                        }
                    } else {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -57345;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -458753;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 64) != 0) {
                            long jM1069contentColorForek8zF_U3 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -3670017;
                            j5 = jM1069contentColorForek8zF_U3;
                        } else {
                            j5 = j4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-453679601, i3, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:43)");
                    }
                    ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp4, interfaceC0526Fp6, interfaceC0526Fp, i3));
                    int i16 = ((i3 >> 3) & 14) | 1572864;
                    int i17 = i3 >> 9;
                    SurfaceKt.m1227SurfaceFjzlyU(modifier2, medium, jM1055getSurface0d7_KjU, j5, null, 0.0f, composableLambda3, composerStartRestartGroup, i16 | (i17 & 112) | (i17 & 896) | (i17 & 7168), 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    shape3 = medium;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -57345;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -458753;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 64) != 0) {
                            long jM1069contentColorForek8zF_U4 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -3670017;
                            j5 = jM1069contentColorForek8zF_U4;
                        } else {
                            j5 = j4;
                        }
                    } else {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -57345;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -458753;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 64) != 0) {
                            long jM1069contentColorForek8zF_U5 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -3670017;
                            j5 = jM1069contentColorForek8zF_U5;
                        } else {
                            j5 = j4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-453679601, i3, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:43)");
                    }
                    ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp4, interfaceC0526Fp6, interfaceC0526Fp, i3));
                    int i18 = ((i3 >> 3) & 14) | 1572864;
                    int i19 = i3 >> 9;
                    SurfaceKt.m1227SurfaceFjzlyU(modifier2, medium, jM1055getSurface0d7_KjU, j5, null, 0.0f, composableLambda4, composerStartRestartGroup, i18 | (i19 & 112) | (i19 & 896) | (i19 & 7168), 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    shape3 = medium;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AlertDialogKt$AlertDialogContent$2(interfaceC0526Fp, modifier3, interfaceC0526Fp4, interfaceC0526Fp6, shape3, jM1055getSurface0d7_KjU, j5, i, i2));
            }
            i3 |= 384;
            interfaceC0526Fp4 = interfaceC0526Fp2;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i9;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i9;
                } else {
                    shape2 = shape;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        j3 = j;
                        if (composerStartRestartGroup.changed(j3)) {
                        }
                        i3 |= i10;
                    } else {
                        j3 = j;
                    }
                    i3 |= i10;
                } else {
                    j3 = j;
                }
                if ((3670016 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        j4 = j2;
                        if (composerStartRestartGroup.changed(j4)) {
                        }
                        i3 |= i11;
                    } else {
                        j4 = j2;
                    }
                    i3 |= i11;
                } else {
                    j4 = j2;
                }
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -57345;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -458753;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 64) != 0) {
                            long jM1069contentColorForek8zF_U6 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -3670017;
                            j5 = jM1069contentColorForek8zF_U6;
                        } else {
                            j5 = j4;
                        }
                    } else {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -57345;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -458753;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 64) != 0) {
                            long jM1069contentColorForek8zF_U7 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -3670017;
                            j5 = jM1069contentColorForek8zF_U7;
                        } else {
                            j5 = j4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-453679601, i3, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:43)");
                    }
                    ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp4, interfaceC0526Fp6, interfaceC0526Fp, i3));
                    int i110 = ((i3 >> 3) & 14) | 1572864;
                    int i111 = i3 >> 9;
                    SurfaceKt.m1227SurfaceFjzlyU(modifier2, medium, jM1055getSurface0d7_KjU, j5, null, 0.0f, composableLambda5, composerStartRestartGroup, i110 | (i111 & 112) | (i111 & 896) | (i111 & 7168), 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    shape3 = medium;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -57345;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -458753;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 64) != 0) {
                            long jM1069contentColorForek8zF_U8 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -3670017;
                            j5 = jM1069contentColorForek8zF_U8;
                        } else {
                            j5 = j4;
                        }
                    } else {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -57345;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -458753;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 64) != 0) {
                            long jM1069contentColorForek8zF_U9 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -3670017;
                            j5 = jM1069contentColorForek8zF_U9;
                        } else {
                            j5 = j4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-453679601, i3, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:43)");
                    }
                    ComposableLambda composableLambda6 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp4, interfaceC0526Fp6, interfaceC0526Fp, i3));
                    int i112 = ((i3 >> 3) & 14) | 1572864;
                    int i113 = i3 >> 9;
                    SurfaceKt.m1227SurfaceFjzlyU(modifier2, medium, jM1055getSurface0d7_KjU, j5, null, 0.0f, composableLambda6, composerStartRestartGroup, i112 | (i113 & 112) | (i113 & 896) | (i113 & 7168), 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    shape3 = medium;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AlertDialogKt$AlertDialogContent$2(interfaceC0526Fp, modifier3, interfaceC0526Fp4, interfaceC0526Fp6, shape3, jM1055getSurface0d7_KjU, j5, i, i2));
            }
            i3 |= 3072;
            interfaceC0526Fp5 = interfaceC0526Fp3;
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i9;
                } else {
                    shape2 = shape;
                }
                i3 |= i9;
            } else {
                shape2 = shape;
            }
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    j3 = j;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i3 |= i10;
                } else {
                    j3 = j;
                }
                i3 |= i10;
            } else {
                j3 = j;
            }
            if ((3670016 & i) == 0) {
                if ((i2 & 64) == 0) {
                    j4 = j2;
                    if (composerStartRestartGroup.changed(j4)) {
                    }
                    i3 |= i11;
                } else {
                    j4 = j2;
                }
                i3 |= i11;
            } else {
                j4 = j2;
            }
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -57345;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 64) != 0) {
                        long jM1069contentColorForek8zF_U10 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -3670017;
                        j5 = jM1069contentColorForek8zF_U10;
                    } else {
                        j5 = j4;
                    }
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -57345;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 64) != 0) {
                        long jM1069contentColorForek8zF_U11 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -3670017;
                        j5 = jM1069contentColorForek8zF_U11;
                    } else {
                        j5 = j4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-453679601, i3, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:43)");
                }
                ComposableLambda composableLambda7 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp4, interfaceC0526Fp6, interfaceC0526Fp, i3));
                int i114 = ((i3 >> 3) & 14) | 1572864;
                int i115 = i3 >> 9;
                SurfaceKt.m1227SurfaceFjzlyU(modifier2, medium, jM1055getSurface0d7_KjU, j5, null, 0.0f, composableLambda7, composerStartRestartGroup, i114 | (i115 & 112) | (i115 & 896) | (i115 & 7168), 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                shape3 = medium;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -57345;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 64) != 0) {
                        long jM1069contentColorForek8zF_U12 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -3670017;
                        j5 = jM1069contentColorForek8zF_U12;
                    } else {
                        j5 = j4;
                    }
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -57345;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 64) != 0) {
                        long jM1069contentColorForek8zF_U13 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -3670017;
                        j5 = jM1069contentColorForek8zF_U13;
                    } else {
                        j5 = j4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-453679601, i3, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:43)");
                }
                ComposableLambda composableLambda8 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp4, interfaceC0526Fp6, interfaceC0526Fp, i3));
                int i116 = ((i3 >> 3) & 14) | 1572864;
                int i117 = i3 >> 9;
                SurfaceKt.m1227SurfaceFjzlyU(modifier2, medium, jM1055getSurface0d7_KjU, j5, null, 0.0f, composableLambda8, composerStartRestartGroup, i116 | (i117 & 112) | (i117 & 896) | (i117 & 7168), 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                shape3 = medium;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AlertDialogKt$AlertDialogContent$2(interfaceC0526Fp, modifier3, interfaceC0526Fp4, interfaceC0526Fp6, shape3, jM1055getSurface0d7_KjU, j5, i, i2));
        }
        i3 |= 48;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                interfaceC0526Fp4 = interfaceC0526Fp2;
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i9;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i9;
                } else {
                    shape2 = shape;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        j3 = j;
                        if (composerStartRestartGroup.changed(j3)) {
                        }
                        i3 |= i10;
                    } else {
                        j3 = j;
                    }
                    i3 |= i10;
                } else {
                    j3 = j;
                }
                if ((3670016 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        j4 = j2;
                        if (composerStartRestartGroup.changed(j4)) {
                        }
                        i3 |= i11;
                    } else {
                        j4 = j2;
                    }
                    i3 |= i11;
                } else {
                    j4 = j2;
                }
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -57345;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -458753;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 64) != 0) {
                            long jM1069contentColorForek8zF_U14 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -3670017;
                            j5 = jM1069contentColorForek8zF_U14;
                        } else {
                            j5 = j4;
                        }
                    } else {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -57345;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -458753;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 64) != 0) {
                            long jM1069contentColorForek8zF_U15 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -3670017;
                            j5 = jM1069contentColorForek8zF_U15;
                        } else {
                            j5 = j4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-453679601, i3, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:43)");
                    }
                    ComposableLambda composableLambda9 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp4, interfaceC0526Fp6, interfaceC0526Fp, i3));
                    int i118 = ((i3 >> 3) & 14) | 1572864;
                    int i119 = i3 >> 9;
                    SurfaceKt.m1227SurfaceFjzlyU(modifier2, medium, jM1055getSurface0d7_KjU, j5, null, 0.0f, composableLambda9, composerStartRestartGroup, i118 | (i119 & 112) | (i119 & 896) | (i119 & 7168), 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    shape3 = medium;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -57345;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -458753;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 64) != 0) {
                            long jM1069contentColorForek8zF_U16 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -3670017;
                            j5 = jM1069contentColorForek8zF_U16;
                        } else {
                            j5 = j4;
                        }
                    } else {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -57345;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -458753;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 64) != 0) {
                            long jM1069contentColorForek8zF_U17 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -3670017;
                            j5 = jM1069contentColorForek8zF_U17;
                        } else {
                            j5 = j4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-453679601, i3, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:43)");
                    }
                    ComposableLambda composableLambda10 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp4, interfaceC0526Fp6, interfaceC0526Fp, i3));
                    int i1110 = ((i3 >> 3) & 14) | 1572864;
                    int i1111 = i3 >> 9;
                    SurfaceKt.m1227SurfaceFjzlyU(modifier2, medium, jM1055getSurface0d7_KjU, j5, null, 0.0f, composableLambda10, composerStartRestartGroup, i1110 | (i1111 & 112) | (i1111 & 896) | (i1111 & 7168), 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    shape3 = medium;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AlertDialogKt$AlertDialogContent$2(interfaceC0526Fp, modifier3, interfaceC0526Fp4, interfaceC0526Fp6, shape3, jM1055getSurface0d7_KjU, j5, i, i2));
            }
            i3 |= 3072;
            interfaceC0526Fp5 = interfaceC0526Fp3;
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i9;
                } else {
                    shape2 = shape;
                }
                i3 |= i9;
            } else {
                shape2 = shape;
            }
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    j3 = j;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i3 |= i10;
                } else {
                    j3 = j;
                }
                i3 |= i10;
            } else {
                j3 = j;
            }
            if ((3670016 & i) == 0) {
                if ((i2 & 64) == 0) {
                    j4 = j2;
                    if (composerStartRestartGroup.changed(j4)) {
                    }
                    i3 |= i11;
                } else {
                    j4 = j2;
                }
                i3 |= i11;
            } else {
                j4 = j2;
            }
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -57345;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 64) != 0) {
                        long jM1069contentColorForek8zF_U18 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -3670017;
                        j5 = jM1069contentColorForek8zF_U18;
                    } else {
                        j5 = j4;
                    }
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -57345;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 64) != 0) {
                        long jM1069contentColorForek8zF_U19 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -3670017;
                        j5 = jM1069contentColorForek8zF_U19;
                    } else {
                        j5 = j4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-453679601, i3, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:43)");
                }
                ComposableLambda composableLambda11 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp4, interfaceC0526Fp6, interfaceC0526Fp, i3));
                int i1112 = ((i3 >> 3) & 14) | 1572864;
                int i1113 = i3 >> 9;
                SurfaceKt.m1227SurfaceFjzlyU(modifier2, medium, jM1055getSurface0d7_KjU, j5, null, 0.0f, composableLambda11, composerStartRestartGroup, i1112 | (i1113 & 112) | (i1113 & 896) | (i1113 & 7168), 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                shape3 = medium;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -57345;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 64) != 0) {
                        long jM1069contentColorForek8zF_U110 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -3670017;
                        j5 = jM1069contentColorForek8zF_U110;
                    } else {
                        j5 = j4;
                    }
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -57345;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 64) != 0) {
                        long jM1069contentColorForek8zF_U111 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -3670017;
                        j5 = jM1069contentColorForek8zF_U111;
                    } else {
                        j5 = j4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-453679601, i3, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:43)");
                }
                ComposableLambda composableLambda12 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp4, interfaceC0526Fp6, interfaceC0526Fp, i3));
                int i1114 = ((i3 >> 3) & 14) | 1572864;
                int i1115 = i3 >> 9;
                SurfaceKt.m1227SurfaceFjzlyU(modifier2, medium, jM1055getSurface0d7_KjU, j5, null, 0.0f, composableLambda12, composerStartRestartGroup, i1114 | (i1115 & 112) | (i1115 & 896) | (i1115 & 7168), 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                shape3 = medium;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AlertDialogKt$AlertDialogContent$2(interfaceC0526Fp, modifier3, interfaceC0526Fp4, interfaceC0526Fp6, shape3, jM1055getSurface0d7_KjU, j5, i, i2));
        }
        i3 |= 384;
        interfaceC0526Fp4 = interfaceC0526Fp2;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 7168) == 0) {
                interfaceC0526Fp5 = interfaceC0526Fp3;
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i9;
                } else {
                    shape2 = shape;
                }
                i3 |= i9;
            } else {
                shape2 = shape;
            }
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    j3 = j;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i3 |= i10;
                } else {
                    j3 = j;
                }
                i3 |= i10;
            } else {
                j3 = j;
            }
            if ((3670016 & i) == 0) {
                if ((i2 & 64) == 0) {
                    j4 = j2;
                    if (composerStartRestartGroup.changed(j4)) {
                    }
                    i3 |= i11;
                } else {
                    j4 = j2;
                }
                i3 |= i11;
            } else {
                j4 = j2;
            }
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -57345;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 64) != 0) {
                        long jM1069contentColorForek8zF_U112 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -3670017;
                        j5 = jM1069contentColorForek8zF_U112;
                    } else {
                        j5 = j4;
                    }
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -57345;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 64) != 0) {
                        long jM1069contentColorForek8zF_U113 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -3670017;
                        j5 = jM1069contentColorForek8zF_U113;
                    } else {
                        j5 = j4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-453679601, i3, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:43)");
                }
                ComposableLambda composableLambda13 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp4, interfaceC0526Fp6, interfaceC0526Fp, i3));
                int i1116 = ((i3 >> 3) & 14) | 1572864;
                int i1117 = i3 >> 9;
                SurfaceKt.m1227SurfaceFjzlyU(modifier2, medium, jM1055getSurface0d7_KjU, j5, null, 0.0f, composableLambda13, composerStartRestartGroup, i1116 | (i1117 & 112) | (i1117 & 896) | (i1117 & 7168), 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                shape3 = medium;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -57345;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 64) != 0) {
                        long jM1069contentColorForek8zF_U114 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -3670017;
                        j5 = jM1069contentColorForek8zF_U114;
                    } else {
                        j5 = j4;
                    }
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -57345;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 64) != 0) {
                        long jM1069contentColorForek8zF_U115 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -3670017;
                        j5 = jM1069contentColorForek8zF_U115;
                    } else {
                        j5 = j4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-453679601, i3, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:43)");
                }
                ComposableLambda composableLambda14 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp4, interfaceC0526Fp6, interfaceC0526Fp, i3));
                int i1118 = ((i3 >> 3) & 14) | 1572864;
                int i1119 = i3 >> 9;
                SurfaceKt.m1227SurfaceFjzlyU(modifier2, medium, jM1055getSurface0d7_KjU, j5, null, 0.0f, composableLambda14, composerStartRestartGroup, i1118 | (i1119 & 112) | (i1119 & 896) | (i1119 & 7168), 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                shape3 = medium;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AlertDialogKt$AlertDialogContent$2(interfaceC0526Fp, modifier3, interfaceC0526Fp4, interfaceC0526Fp6, shape3, jM1055getSurface0d7_KjU, j5, i, i2));
        }
        i3 |= 3072;
        interfaceC0526Fp5 = interfaceC0526Fp3;
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i9;
            } else {
                shape2 = shape;
            }
            i3 |= i9;
        } else {
            shape2 = shape;
        }
        if ((458752 & i) == 0) {
            if ((i2 & 32) == 0) {
                j3 = j;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i3 |= i10;
            } else {
                j3 = j;
            }
            i3 |= i10;
        } else {
            j3 = j;
        }
        if ((3670016 & i) == 0) {
            if ((i2 & 64) == 0) {
                j4 = j2;
                if (composerStartRestartGroup.changed(j4)) {
                }
                i3 |= i11;
            } else {
                j4 = j2;
            }
            i3 |= i11;
        } else {
            j4 = j2;
        }
        if ((i3 & 2995931) == 599186) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                }
                if (i6 == 0) {
                }
                if ((i2 & 16) != 0) {
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    i3 &= -57345;
                } else {
                    medium = shape2;
                }
                if ((i2 & 32) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 &= -458753;
                } else {
                    jM1055getSurface0d7_KjU = j3;
                }
                if ((i2 & 64) != 0) {
                    long jM1069contentColorForek8zF_U116 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                    i3 &= -3670017;
                    j5 = jM1069contentColorForek8zF_U116;
                } else {
                    j5 = j4;
                }
            } else {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                }
                if (i6 == 0) {
                }
                if ((i2 & 16) != 0) {
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    i3 &= -57345;
                } else {
                    medium = shape2;
                }
                if ((i2 & 32) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 &= -458753;
                } else {
                    jM1055getSurface0d7_KjU = j3;
                }
                if ((i2 & 64) != 0) {
                    long jM1069contentColorForek8zF_U117 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                    i3 &= -3670017;
                    j5 = jM1069contentColorForek8zF_U117;
                } else {
                    j5 = j4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-453679601, i3, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:43)");
            }
            ComposableLambda composableLambda15 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp4, interfaceC0526Fp6, interfaceC0526Fp, i3));
            int i11110 = ((i3 >> 3) & 14) | 1572864;
            int i11111 = i3 >> 9;
            SurfaceKt.m1227SurfaceFjzlyU(modifier2, medium, jM1055getSurface0d7_KjU, j5, null, 0.0f, composableLambda15, composerStartRestartGroup, i11110 | (i11111 & 112) | (i11111 & 896) | (i11111 & 7168), 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            shape3 = medium;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                }
                if (i6 == 0) {
                }
                if ((i2 & 16) != 0) {
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    i3 &= -57345;
                } else {
                    medium = shape2;
                }
                if ((i2 & 32) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 &= -458753;
                } else {
                    jM1055getSurface0d7_KjU = j3;
                }
                if ((i2 & 64) != 0) {
                    long jM1069contentColorForek8zF_U118 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                    i3 &= -3670017;
                    j5 = jM1069contentColorForek8zF_U118;
                } else {
                    j5 = j4;
                }
            } else {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                }
                if (i6 == 0) {
                }
                if ((i2 & 16) != 0) {
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    i3 &= -57345;
                } else {
                    medium = shape2;
                }
                if ((i2 & 32) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 &= -458753;
                } else {
                    jM1055getSurface0d7_KjU = j3;
                }
                if ((i2 & 64) != 0) {
                    long jM1069contentColorForek8zF_U119 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                    i3 &= -3670017;
                    j5 = jM1069contentColorForek8zF_U119;
                } else {
                    j5 = j4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-453679601, i3, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:43)");
            }
            ComposableLambda composableLambda16 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp4, interfaceC0526Fp6, interfaceC0526Fp, i3));
            int i11112 = ((i3 >> 3) & 14) | 1572864;
            int i11113 = i3 >> 9;
            SurfaceKt.m1227SurfaceFjzlyU(modifier2, medium, jM1055getSurface0d7_KjU, j5, null, 0.0f, composableLambda16, composerStartRestartGroup, i11112 | (i11113 & 112) | (i11113 & 896) | (i11113 & 7168), 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            shape3 = medium;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AlertDialogKt$AlertDialogContent$2(interfaceC0526Fp, modifier3, interfaceC0526Fp4, interfaceC0526Fp6, shape3, jM1055getSurface0d7_KjU, j5, i, i2));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: AlertDialogFlowRow-ixp7dh8, reason: not valid java name */
    public static final void m969AlertDialogFlowRowixp7dh8(final float f, final float f2, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        int i2;
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(73434452);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(f2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 256 : 128;
        }
        if ((i2 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(73434452, i2, -1, "androidx.compose.material.AlertDialogFlowRow (AlertDialog.kt:187)");
            }
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogFlowRow$1
                private static final boolean measure_3p2s80s$canAddToCurrentSequence(List<Placeable> list, MJ mj, MeasureScope measureScope, float f3, long j, Placeable placeable) {
                    return list.isEmpty() || (mj.a + measureScope.mo327roundToPx0680j_4(f3)) + placeable.getWidth() <= Constraints.m5128getMaxWidthimpl(j);
                }

                private static final void measure_3p2s80s$startNewSequence(List<List<Placeable>> list, MJ mj, MeasureScope measureScope, float f3, List<Placeable> list2, List<Integer> list3, MJ mj2, List<Integer> list4, MJ mj3, MJ mj4) {
                    if (!list.isEmpty()) {
                        mj.a += measureScope.mo327roundToPx0680j_4(f3);
                    }
                    list.add(0, AbstractC3240kc.C0(list2));
                    list3.add(Integer.valueOf(mj2.a));
                    list4.add(Integer.valueOf(mj.a));
                    mj.a += mj2.a;
                    mj3.a = Math.max(mj3.a, mj4.a);
                    list2.clear();
                    mj4.a = 0;
                    mj2.a = 0;
                }

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
                    MJ mj;
                    AbstractC4492zt.h(measureScope, "$this$Layout");
                    AbstractC4492zt.h(list, "measurables");
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    MJ mj2 = new MJ();
                    MJ mj3 = new MJ();
                    ArrayList arrayList4 = new ArrayList();
                    MJ mj4 = new MJ();
                    MJ mj5 = new MJ();
                    long jConstraints$default = ConstraintsKt.Constraints$default(0, Constraints.m5128getMaxWidthimpl(j), 0, 0, 13, null);
                    Iterator<? extends Measurable> it = list.iterator();
                    while (it.hasNext()) {
                        Placeable placeableMo4159measureBRTryo0 = it.next().mo4159measureBRTryo0(jConstraints$default);
                        long j2 = jConstraints$default;
                        MJ mj6 = mj5;
                        if (measure_3p2s80s$canAddToCurrentSequence(arrayList4, mj4, measureScope, f, j, placeableMo4159measureBRTryo0)) {
                            mj = mj4;
                        } else {
                            mj = mj4;
                            measure_3p2s80s$startNewSequence(arrayList, mj3, measureScope, f2, arrayList4, arrayList2, mj6, arrayList3, mj2, mj);
                        }
                        MJ mj7 = mj;
                        if (!arrayList4.isEmpty()) {
                            mj7.a += measureScope.mo327roundToPx0680j_4(f);
                        }
                        ArrayList arrayList5 = arrayList4;
                        arrayList5.add(placeableMo4159measureBRTryo0);
                        mj7.a += placeableMo4159measureBRTryo0.getWidth();
                        mj5 = mj6;
                        mj5.a = Math.max(mj5.a, placeableMo4159measureBRTryo0.getHeight());
                        arrayList4 = arrayList5;
                        mj4 = mj7;
                        jConstraints$default = j2;
                        mj3 = mj3;
                    }
                    ArrayList arrayList6 = arrayList4;
                    MJ mj8 = mj3;
                    MJ mj9 = mj4;
                    if (!arrayList6.isEmpty()) {
                        measure_3p2s80s$startNewSequence(arrayList, mj8, measureScope, f2, arrayList6, arrayList2, mj5, arrayList3, mj2, mj9);
                    }
                    int iM5128getMaxWidthimpl = Constraints.m5128getMaxWidthimpl(j) != Integer.MAX_VALUE ? Constraints.m5128getMaxWidthimpl(j) : Math.max(mj2.a, Constraints.m5130getMinWidthimpl(j));
                    return MeasureScope.CC.q(measureScope, iM5128getMaxWidthimpl, Math.max(mj8.a, Constraints.m5129getMinHeightimpl(j)), null, new AlertDialogKt$AlertDialogFlowRow$1$measure$1(arrayList, measureScope, f, iM5128getMaxWidthimpl, arrayList3), 4, null);
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
            int i3 = ((((i2 >> 6) & 14) << 9) & 7168) | 6;
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
            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
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
        scopeUpdateScopeEndRestartGroup.updateScope(new AlertDialogKt$AlertDialogFlowRow$2(f, f2, interfaceC0526Fp, i));
    }
}
