package androidx.compose.material3;

import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.SnackbarTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
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
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.itextpdf.text.Annotation;
import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AbstractC2260gB;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class SnackbarKt {
    private static final float HorizontalSpacingButtonSide;
    private static final float TextEndExtraSpacing;
    private static final float ContainerMaxWidth = Dp.m5160constructorimpl(600);
    private static final float HeightToFirstLine = Dp.m5160constructorimpl(30);
    private static final float HorizontalSpacing = Dp.m5160constructorimpl(16);
    private static final float SeparateButtonExtraY = Dp.m5160constructorimpl(2);
    private static final float SnackbarVerticalPadding = Dp.m5160constructorimpl(6);
    private static final float LongButtonVerticalOffset = Dp.m5160constructorimpl(12);

    static {
        float f = 8;
        HorizontalSpacingButtonSide = Dp.m5160constructorimpl(f);
        TextEndExtraSpacing = Dp.m5160constructorimpl(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: NewLineButtonSnackbar-kKq0p4A, reason: not valid java name */
    public static final void m1761NewLineButtonSnackbarkKq0p4A(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, TextStyle textStyle, long j, long j2, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1332496681);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp3) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(textStyle) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 131072 : 65536;
        }
        if ((374491 & i2) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1332496681, i2, -1, "androidx.compose.material3.NewLineButtonSnackbar (Snackbar.kt:251)");
            }
            Modifier.Companion companion = Modifier.Companion;
            Modifier modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m539widthInVpY3zN4$default(companion, 0.0f, ContainerMaxWidth, 1, null), 0.0f, 1, null), HorizontalSpacing, 0.0f, 0.0f, SeparateButtonExtraY, 6, null);
            composerStartRestartGroup.startReplaceableGroup(-483455358);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.Companion;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierM489paddingqDBjuR0$default);
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
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion3.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion3.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion3.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier modifierM373paddingFromBaselineVpY3zN4 = AlignmentLineKt.m373paddingFromBaselineVpY3zN4(companion, HeightToFirstLine, LongButtonVerticalOffset);
            float f = HorizontalSpacingButtonSide;
            Modifier modifierM489paddingqDBjuR0$default2 = PaddingKt.m489paddingqDBjuR0$default(modifierM373paddingFromBaselineVpY3zN4, 0.0f, 0.0f, f, 0.0f, 11, null);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            InterfaceC3588op constructor2 = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(modifierM489paddingqDBjuR0$default2);
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
            Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl2, density2, companion3.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion3.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion3.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf(i2 & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierM489paddingqDBjuR0$default3 = PaddingKt.m489paddingqDBjuR0$default(columnScopeInstance.align(companion, companion2.getEnd()), 0.0f, 0.0f, interfaceC0526Fp3 == null ? f : Dp.m5160constructorimpl(0), 0.0f, 11, null);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            InterfaceC3588op constructor3 = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf3 = LayoutKt.materializerOf(modifierM489paddingqDBjuR0$default3);
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
            Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyRememberBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl3, density3, companion3.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl3, layoutDirection3, companion3.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl3, viewConfiguration3, companion3.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density4 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection4 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration4 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            InterfaceC3588op constructor4 = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf4 = LayoutKt.materializerOf(companion);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl4 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl4, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl4, density4, companion3.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl4, layoutDirection4, companion3.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl4, viewConfiguration4, companion3.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf4.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j)), TextKt.getLocalTextStyle().provides(textStyle)}, interfaceC0526Fp2, composerStartRestartGroup, (i2 & 112) | 8);
            composerStartRestartGroup.startReplaceableGroup(302366994);
            if (interfaceC0526Fp3 != null) {
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j2))}, interfaceC0526Fp3, composerStartRestartGroup, ((i2 >> 3) & 112) | 8);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
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
        scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$NewLineButtonSnackbar$2(interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, textStyle, j, j2, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: OneRowSnackbar-kKq0p4A, reason: not valid java name */
    public static final void m1762OneRowSnackbarkKq0p4A(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, TextStyle textStyle, long j, long j2, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-903235475);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp3) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(textStyle) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 131072 : 65536;
        }
        if ((374491 & i2) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-903235475, i2, -1, "androidx.compose.material3.OneRowSnackbar (Snackbar.kt:296)");
            }
            Modifier.Companion companion = Modifier.Companion;
            Modifier modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(companion, HorizontalSpacing, 0.0f, interfaceC0526Fp3 == null ? HorizontalSpacingButtonSide : Dp.m5160constructorimpl(0), 0.0f, 10, null);
            final String str = "action";
            final String str2 = "dismissAction";
            final String str3 = "text";
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$2
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
                public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j3) {
                    Object next;
                    Object next2;
                    int iMax;
                    int i3;
                    int height;
                    int i4;
                    AbstractC4492zt.h(measureScope, "$this$Layout");
                    AbstractC4492zt.h(list, "measurables");
                    int iMin = Math.min(Constraints.m5128getMaxWidthimpl(j3), measureScope.mo327roundToPx0680j_4(SnackbarKt.ContainerMaxWidth));
                    List<? extends Measurable> list2 = list;
                    String str4 = str;
                    Iterator<T> it = list2.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!AbstractC4492zt.d(LayoutIdKt.getLayoutId((Measurable) next), str4));
                    Measurable measurable = (Measurable) next;
                    Placeable placeableMo4159measureBRTryo0 = measurable != null ? measurable.mo4159measureBRTryo0(j3) : null;
                    String str5 = str2;
                    Iterator<T> it2 = list2.iterator();
                    do {
                        if (!it2.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it2.next();
                    } while (!AbstractC4492zt.d(LayoutIdKt.getLayoutId((Measurable) next2), str5));
                    Measurable measurable2 = (Measurable) next2;
                    Placeable placeableMo4159measureBRTryo1 = measurable2 != null ? measurable2.mo4159measureBRTryo0(j3) : null;
                    int width = placeableMo4159measureBRTryo0 != null ? placeableMo4159measureBRTryo0.getWidth() : 0;
                    int height2 = placeableMo4159measureBRTryo0 != null ? placeableMo4159measureBRTryo0.getHeight() : 0;
                    int width2 = placeableMo4159measureBRTryo1 != null ? placeableMo4159measureBRTryo1.getWidth() : 0;
                    int height3 = placeableMo4159measureBRTryo1 != null ? placeableMo4159measureBRTryo1.getHeight() : 0;
                    int iD = AbstractC3871sJ.d(((iMin - width) - width2) - (width2 == 0 ? measureScope.mo327roundToPx0680j_4(SnackbarKt.TextEndExtraSpacing) : 0), Constraints.m5130getMinWidthimpl(j3));
                    String str6 = str3;
                    for (Measurable measurable3 : list2) {
                        if (AbstractC4492zt.d(LayoutIdKt.getLayoutId(measurable3), str6)) {
                            int i5 = height3;
                            Placeable placeableMo4159measureBRTryo2 = measurable3.mo4159measureBRTryo0(Constraints.m5119copyZbe2FdA$default(j3, 0, iD, 0, 0, 9, null));
                            int i6 = placeableMo4159measureBRTryo2.get(androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline());
                            if (i6 == Integer.MIN_VALUE) {
                                throw new IllegalArgumentException("No baselines for text");
                            }
                            int i7 = placeableMo4159measureBRTryo2.get(androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline());
                            if (i7 == Integer.MIN_VALUE) {
                                throw new IllegalArgumentException("No baselines for text");
                            }
                            boolean z = i6 == i7;
                            int i8 = iMin - width2;
                            int i9 = i8 - width;
                            if (z) {
                                int iMax2 = Math.max(measureScope.mo327roundToPx0680j_4(SnackbarTokens.INSTANCE.m2514getSingleLineContainerHeightD9Ej5fM()), Math.max(height2, i5));
                                int height4 = (iMax2 - placeableMo4159measureBRTryo2.getHeight()) / 2;
                                height = (placeableMo4159measureBRTryo0 == null || (i4 = placeableMo4159measureBRTryo0.get(androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline())) == Integer.MIN_VALUE) ? 0 : (i6 + height4) - i4;
                                i3 = height4;
                                iMax = iMax2;
                            } else {
                                int iMo327roundToPx0680j_4 = measureScope.mo327roundToPx0680j_4(SnackbarKt.HeightToFirstLine) - i6;
                                iMax = Math.max(measureScope.mo327roundToPx0680j_4(SnackbarTokens.INSTANCE.m2515getTwoLinesContainerHeightD9Ej5fM()), placeableMo4159measureBRTryo2.getHeight() + iMo327roundToPx0680j_4);
                                i3 = iMo327roundToPx0680j_4;
                                height = placeableMo4159measureBRTryo0 != null ? (iMax - placeableMo4159measureBRTryo0.getHeight()) / 2 : 0;
                            }
                            return MeasureScope.CC.q(measureScope, iMin, iMax, null, new SnackbarKt$OneRowSnackbar$2$measure$4(placeableMo4159measureBRTryo2, i3, placeableMo4159measureBRTryo1, i8, placeableMo4159measureBRTryo1 != null ? (iMax - placeableMo4159measureBRTryo1.getHeight()) / 2 : 0, placeableMo4159measureBRTryo0, i9, height), 4, null);
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
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierM489paddingqDBjuR0$default);
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
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion2.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            Modifier modifierM487paddingVpY3zN4$default = PaddingKt.m487paddingVpY3zN4$default(LayoutIdKt.layoutId(companion, "text"), 0.0f, SnackbarVerticalPadding, 1, null);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            Alignment.Companion companion3 = Alignment.Companion;
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            InterfaceC3588op constructor2 = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(modifierM487paddingVpY3zN4$default);
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
            Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl2, density2, companion2.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion2.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion2.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf(i2 & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(-167734350);
            if (interfaceC0526Fp2 != null) {
                Modifier modifierLayoutId = LayoutIdKt.layoutId(companion, "action");
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                InterfaceC3588op constructor3 = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf3 = LayoutKt.materializerOf(modifierLayoutId);
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
                Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyRememberBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl3, density3, companion2.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl3, layoutDirection3, companion2.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl3, viewConfiguration3, companion2.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j)), TextKt.getLocalTextStyle().provides(textStyle)}, interfaceC0526Fp2, composerStartRestartGroup, (i2 & 112) | 8);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(44738809);
            if (interfaceC0526Fp3 != null) {
                Modifier modifierLayoutId2 = LayoutIdKt.layoutId(companion, "dismissAction");
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density4 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection4 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration4 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                InterfaceC3588op constructor4 = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf4 = LayoutKt.materializerOf(modifierLayoutId2);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor4);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl4 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl4, measurePolicyRememberBoxMeasurePolicy3, companion2.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl4, density4, companion2.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl4, layoutDirection4, companion2.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl4, viewConfiguration4, companion2.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf4.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j2))}, interfaceC0526Fp3, composerStartRestartGroup, ((i2 >> 3) & 112) | 8);
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
        scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$OneRowSnackbar$3(interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, textStyle, j, j2, i));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0110  */
    /* JADX WARN: Code duplicated, block: B:103:0x0115  */
    /* JADX WARN: Code duplicated, block: B:105:0x011b  */
    /* JADX WARN: Code duplicated, block: B:106:0x011e  */
    /* JADX WARN: Code duplicated, block: B:109:0x012a  */
    /* JADX WARN: Code duplicated, block: B:113:0x0142  */
    /* JADX WARN: Code duplicated, block: B:115:0x0158  */
    /* JADX WARN: Code duplicated, block: B:134:0x018d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:135:0x018f  */
    /* JADX WARN: Code duplicated, block: B:136:0x0192  */
    /* JADX WARN: Code duplicated, block: B:139:0x0196  */
    /* JADX WARN: Code duplicated, block: B:142:0x019a  */
    /* JADX WARN: Code duplicated, block: B:144:0x019d  */
    /* JADX WARN: Code duplicated, block: B:145:0x019f  */
    /* JADX WARN: Code duplicated, block: B:148:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:149:0x01af  */
    /* JADX WARN: Code duplicated, block: B:152:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:153:0x01be  */
    /* JADX WARN: Code duplicated, block: B:156:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:157:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:160:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:161:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:164:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:167:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:170:0x0257  */
    /* JADX WARN: Code duplicated, block: B:175:0x026a  */
    /* JADX WARN: Code duplicated, block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:33:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    /* JADX WARN: Code duplicated, block: B:43:0x007d  */
    /* JADX WARN: Code duplicated, block: B:44:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:53:0x0098 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:56:0x009e  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:81:0x00df  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:86:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:91:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:94:0x0102  */
    /* JADX WARN: Code duplicated, block: B:96:0x0106  */
    /* JADX WARN: Code duplicated, block: B:99:0x010c  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Snackbar-eQBnUkQ, reason: not valid java name */
    public static final void m1763SnackbareQBnUkQ(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, boolean z, Shape shape, long j, long j2, long j3, long j4, InterfaceC0526Fp interfaceC0526Fp3, Composer composer, int i, int i2) {
        Modifier modifier2;
        int i3;
        InterfaceC0526Fp interfaceC0526Fp4;
        int i4;
        InterfaceC0526Fp interfaceC0526Fp5;
        int i5;
        int i6;
        int i7;
        long dismissActionContentColor;
        int i8;
        Modifier modifier3;
        InterfaceC0526Fp interfaceC0526Fp6;
        boolean z2;
        Shape shape2;
        long color;
        long contentColor;
        long actionContentColor;
        boolean z3;
        InterfaceC0526Fp interfaceC0526Fp7;
        long j5;
        long j6;
        long j7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        int i10;
        int i11;
        int i12;
        AbstractC4492zt.h(interfaceC0526Fp3, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-1235788955);
        int i13 = i2 & 1;
        if (i13 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i14 = i2 & 2;
        if (i14 == 0) {
            if ((i & 112) == 0) {
                interfaceC0526Fp4 = interfaceC0526Fp;
                i3 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp4) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    interfaceC0526Fp5 = interfaceC0526Fp2;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 7168) == 0) {
                        if (composerStartRestartGroup.changed(z)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((57344 & i) != 0) {
                        i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changed(shape)) ? 8192 : 16384;
                    }
                    if ((458752 & i) != 0) {
                        if ((i2 & 32) == 0 || !composerStartRestartGroup.changed(j)) {
                            i12 = 65536;
                        } else {
                            i12 = 131072;
                        }
                        i3 |= i12;
                    }
                    if ((3670016 & i) != 0) {
                        if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(j2)) {
                            i11 = 524288;
                        } else {
                            i11 = 1048576;
                        }
                        i3 |= i11;
                    }
                    if ((29360128 & i) != 0) {
                        if ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j3)) {
                            i10 = 4194304;
                        } else {
                            i10 = 8388608;
                        }
                        i3 |= i10;
                    }
                    if ((234881024 & i) == 0) {
                        dismissActionContentColor = j4;
                        if ((i2 & 256) == 0 || !composerStartRestartGroup.changed(dismissActionContentColor)) {
                            i9 = 33554432;
                        } else {
                            i9 = 67108864;
                        }
                        i3 |= i9;
                    } else {
                        dismissActionContentColor = j4;
                    }
                    if ((i2 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                                i8 = PropertyOptions.DELETE_EXISTING;
                            } else {
                                i8 = 268435456;
                            }
                        }
                        if ((1533916891 & i3) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i13 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i14 != 0) {
                                    interfaceC0526Fp4 = null;
                                }
                                interfaceC0526Fp6 = i4 == 0 ? interfaceC0526Fp5 : null;
                                if (i6 != 0) {
                                    z2 = false;
                                } else {
                                    z2 = z;
                                }
                                if ((i2 & 16) != 0) {
                                    shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                    i3 &= -57345;
                                } else {
                                    shape2 = shape;
                                }
                                if ((i2 & 32) != 0) {
                                    color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                                    i3 &= -458753;
                                } else {
                                    color = j;
                                }
                                if ((i2 & 64) != 0) {
                                    contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                    i3 &= -3670017;
                                } else {
                                    contentColor = j2;
                                }
                                if ((i2 & 128) != 0) {
                                    actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    actionContentColor = j3;
                                }
                                if ((i2 & 256) != 0) {
                                    dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                                    i3 &= -234881025;
                                }
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
                                if ((i2 & 128) != 0) {
                                    i3 &= -29360129;
                                }
                                if ((i2 & 256) != 0) {
                                    i3 &= -234881025;
                                }
                                shape2 = shape;
                                contentColor = j2;
                                actionContentColor = j3;
                                modifier3 = modifier2;
                                interfaceC0526Fp6 = interfaceC0526Fp5;
                                z2 = z;
                                color = j;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                            }
                            float fM2512getContainerElevationD9Ej5fM = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                            InterfaceC0526Fp interfaceC0526Fp8 = interfaceC0526Fp6;
                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                            int i15 = 12779520 | (i3 & 14);
                            int i16 = i3 >> 9;
                            SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM, null, composableLambda, composerStartRestartGroup, (i16 & 7168) | i15 | (i16 & 112) | (i16 & 896), 80);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z3 = z2;
                            interfaceC0526Fp7 = interfaceC0526Fp4;
                            j5 = color;
                            j6 = dismissActionContentColor;
                            j7 = actionContentColor;
                            interfaceC0526Fp5 = interfaceC0526Fp8;
                            modifier2 = modifier3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            z3 = z;
                            shape2 = shape;
                            contentColor = j2;
                            interfaceC0526Fp7 = interfaceC0526Fp4;
                            j6 = dismissActionContentColor;
                            j5 = j;
                            j7 = j3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$2(modifier2, interfaceC0526Fp7, interfaceC0526Fp5, z3, shape2, j5, contentColor, j7, j6, interfaceC0526Fp3, i, i2));
                    }
                    i8 = 805306368;
                    i3 |= i8;
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i4 == 0) {
                            }
                            if (i6 != 0) {
                                z2 = false;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 16) != 0) {
                                shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i3 &= -57345;
                            } else {
                                shape2 = shape;
                            }
                            if ((i2 & 32) != 0) {
                                color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                                i3 &= -458753;
                            } else {
                                color = j;
                            }
                            if ((i2 & 64) != 0) {
                                contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                contentColor = j2;
                            }
                            if ((i2 & 128) != 0) {
                                actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                actionContentColor = j3;
                            }
                            if ((i2 & 256) != 0) {
                                dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -234881025;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i4 == 0) {
                            }
                            if (i6 != 0) {
                                z2 = false;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 16) != 0) {
                                shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i3 &= -57345;
                            } else {
                                shape2 = shape;
                            }
                            if ((i2 & 32) != 0) {
                                color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                                i3 &= -458753;
                            } else {
                                color = j;
                            }
                            if ((i2 & 64) != 0) {
                                contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                contentColor = j2;
                            }
                            if ((i2 & 128) != 0) {
                                actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                actionContentColor = j3;
                            }
                            if ((i2 & 256) != 0) {
                                dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -234881025;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                        }
                        float fM2512getContainerElevationD9Ej5fM2 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                        InterfaceC0526Fp interfaceC0526Fp9 = interfaceC0526Fp6;
                        ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                        int i17 = 12779520 | (i3 & 14);
                        int i18 = i3 >> 9;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM2, null, composableLambda2, composerStartRestartGroup, (i18 & 7168) | i17 | (i18 & 112) | (i18 & 896), 80);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z3 = z2;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j5 = color;
                        j6 = dismissActionContentColor;
                        j7 = actionContentColor;
                        interfaceC0526Fp5 = interfaceC0526Fp9;
                        modifier2 = modifier3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i4 == 0) {
                            }
                            if (i6 != 0) {
                                z2 = false;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 16) != 0) {
                                shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i3 &= -57345;
                            } else {
                                shape2 = shape;
                            }
                            if ((i2 & 32) != 0) {
                                color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                                i3 &= -458753;
                            } else {
                                color = j;
                            }
                            if ((i2 & 64) != 0) {
                                contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                contentColor = j2;
                            }
                            if ((i2 & 128) != 0) {
                                actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                actionContentColor = j3;
                            }
                            if ((i2 & 256) != 0) {
                                dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -234881025;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i4 == 0) {
                            }
                            if (i6 != 0) {
                                z2 = false;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 16) != 0) {
                                shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i3 &= -57345;
                            } else {
                                shape2 = shape;
                            }
                            if ((i2 & 32) != 0) {
                                color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                                i3 &= -458753;
                            } else {
                                color = j;
                            }
                            if ((i2 & 64) != 0) {
                                contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                contentColor = j2;
                            }
                            if ((i2 & 128) != 0) {
                                actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                actionContentColor = j3;
                            }
                            if ((i2 & 256) != 0) {
                                dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -234881025;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                        }
                        float fM2512getContainerElevationD9Ej5fM3 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                        InterfaceC0526Fp interfaceC0526Fp10 = interfaceC0526Fp6;
                        ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                        int i19 = 12779520 | (i3 & 14);
                        int i110 = i3 >> 9;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM3, null, composableLambda3, composerStartRestartGroup, (i110 & 7168) | i19 | (i110 & 112) | (i110 & 896), 80);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z3 = z2;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j5 = color;
                        j6 = dismissActionContentColor;
                        j7 = actionContentColor;
                        interfaceC0526Fp5 = interfaceC0526Fp10;
                        modifier2 = modifier3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$2(modifier2, interfaceC0526Fp7, interfaceC0526Fp5, z3, shape2, j5, contentColor, j7, j6, interfaceC0526Fp3, i, i2));
                }
                i3 |= 3072;
                if ((57344 & i) != 0) {
                    i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changed(shape)) ? 8192 : 16384;
                }
                if ((458752 & i) != 0) {
                    if ((i2 & 32) == 0) {
                        i12 = 65536;
                    } else {
                        i12 = 65536;
                    }
                    i3 |= i12;
                }
                if ((3670016 & i) != 0) {
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((29360128 & i) != 0) {
                    if ((i2 & 128) == 0) {
                        i10 = 4194304;
                    } else {
                        i10 = 4194304;
                    }
                    i3 |= i10;
                }
                if ((234881024 & i) == 0) {
                    dismissActionContentColor = j4;
                    if ((i2 & 256) == 0) {
                        i9 = 33554432;
                    } else {
                        i9 = 33554432;
                    }
                    i3 |= i9;
                } else {
                    dismissActionContentColor = j4;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                            i8 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i8 = 268435456;
                        }
                    }
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i4 == 0) {
                            }
                            if (i6 != 0) {
                                z2 = false;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 16) != 0) {
                                shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i3 &= -57345;
                            } else {
                                shape2 = shape;
                            }
                            if ((i2 & 32) != 0) {
                                color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                                i3 &= -458753;
                            } else {
                                color = j;
                            }
                            if ((i2 & 64) != 0) {
                                contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                contentColor = j2;
                            }
                            if ((i2 & 128) != 0) {
                                actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                actionContentColor = j3;
                            }
                            if ((i2 & 256) != 0) {
                                dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -234881025;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i4 == 0) {
                            }
                            if (i6 != 0) {
                                z2 = false;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 16) != 0) {
                                shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i3 &= -57345;
                            } else {
                                shape2 = shape;
                            }
                            if ((i2 & 32) != 0) {
                                color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                                i3 &= -458753;
                            } else {
                                color = j;
                            }
                            if ((i2 & 64) != 0) {
                                contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                contentColor = j2;
                            }
                            if ((i2 & 128) != 0) {
                                actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                actionContentColor = j3;
                            }
                            if ((i2 & 256) != 0) {
                                dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -234881025;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                        }
                        float fM2512getContainerElevationD9Ej5fM4 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                        InterfaceC0526Fp interfaceC0526Fp11 = interfaceC0526Fp6;
                        ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                        int i111 = 12779520 | (i3 & 14);
                        int i112 = i3 >> 9;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM4, null, composableLambda4, composerStartRestartGroup, (i112 & 7168) | i111 | (i112 & 112) | (i112 & 896), 80);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z3 = z2;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j5 = color;
                        j6 = dismissActionContentColor;
                        j7 = actionContentColor;
                        interfaceC0526Fp5 = interfaceC0526Fp11;
                        modifier2 = modifier3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i4 == 0) {
                            }
                            if (i6 != 0) {
                                z2 = false;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 16) != 0) {
                                shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i3 &= -57345;
                            } else {
                                shape2 = shape;
                            }
                            if ((i2 & 32) != 0) {
                                color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                                i3 &= -458753;
                            } else {
                                color = j;
                            }
                            if ((i2 & 64) != 0) {
                                contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                contentColor = j2;
                            }
                            if ((i2 & 128) != 0) {
                                actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                actionContentColor = j3;
                            }
                            if ((i2 & 256) != 0) {
                                dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -234881025;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i4 == 0) {
                            }
                            if (i6 != 0) {
                                z2 = false;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 16) != 0) {
                                shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i3 &= -57345;
                            } else {
                                shape2 = shape;
                            }
                            if ((i2 & 32) != 0) {
                                color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                                i3 &= -458753;
                            } else {
                                color = j;
                            }
                            if ((i2 & 64) != 0) {
                                contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                contentColor = j2;
                            }
                            if ((i2 & 128) != 0) {
                                actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                actionContentColor = j3;
                            }
                            if ((i2 & 256) != 0) {
                                dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -234881025;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                        }
                        float fM2512getContainerElevationD9Ej5fM5 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                        InterfaceC0526Fp interfaceC0526Fp12 = interfaceC0526Fp6;
                        ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                        int i113 = 12779520 | (i3 & 14);
                        int i114 = i3 >> 9;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM5, null, composableLambda5, composerStartRestartGroup, (i114 & 7168) | i113 | (i114 & 112) | (i114 & 896), 80);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z3 = z2;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j5 = color;
                        j6 = dismissActionContentColor;
                        j7 = actionContentColor;
                        interfaceC0526Fp5 = interfaceC0526Fp12;
                        modifier2 = modifier3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$2(modifier2, interfaceC0526Fp7, interfaceC0526Fp5, z3, shape2, j5, contentColor, j7, j6, interfaceC0526Fp3, i, i2));
                }
                i8 = 805306368;
                i3 |= i8;
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape2 = shape;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape2 = shape;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                    }
                    float fM2512getContainerElevationD9Ej5fM6 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                    InterfaceC0526Fp interfaceC0526Fp13 = interfaceC0526Fp6;
                    ComposableLambda composableLambda6 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                    int i115 = 12779520 | (i3 & 14);
                    int i116 = i3 >> 9;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM6, null, composableLambda6, composerStartRestartGroup, (i116 & 7168) | i115 | (i116 & 112) | (i116 & 896), 80);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z3 = z2;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j5 = color;
                    j6 = dismissActionContentColor;
                    j7 = actionContentColor;
                    interfaceC0526Fp5 = interfaceC0526Fp13;
                    modifier2 = modifier3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape2 = shape;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape2 = shape;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                    }
                    float fM2512getContainerElevationD9Ej5fM7 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                    InterfaceC0526Fp interfaceC0526Fp14 = interfaceC0526Fp6;
                    ComposableLambda composableLambda7 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                    int i117 = 12779520 | (i3 & 14);
                    int i118 = i3 >> 9;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM7, null, composableLambda7, composerStartRestartGroup, (i118 & 7168) | i117 | (i118 & 112) | (i118 & 896), 80);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z3 = z2;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j5 = color;
                    j6 = dismissActionContentColor;
                    j7 = actionContentColor;
                    interfaceC0526Fp5 = interfaceC0526Fp14;
                    modifier2 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$2(modifier2, interfaceC0526Fp7, interfaceC0526Fp5, z3, shape2, j5, contentColor, j7, j6, interfaceC0526Fp3, i, i2));
            }
            i3 |= 384;
            interfaceC0526Fp5 = interfaceC0526Fp2;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((57344 & i) != 0) {
                    i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changed(shape)) ? 8192 : 16384;
                }
                if ((458752 & i) != 0) {
                    if ((i2 & 32) == 0) {
                        i12 = 65536;
                    } else {
                        i12 = 65536;
                    }
                    i3 |= i12;
                }
                if ((3670016 & i) != 0) {
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((29360128 & i) != 0) {
                    if ((i2 & 128) == 0) {
                        i10 = 4194304;
                    } else {
                        i10 = 4194304;
                    }
                    i3 |= i10;
                }
                if ((234881024 & i) == 0) {
                    dismissActionContentColor = j4;
                    if ((i2 & 256) == 0) {
                        i9 = 33554432;
                    } else {
                        i9 = 33554432;
                    }
                    i3 |= i9;
                } else {
                    dismissActionContentColor = j4;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                            i8 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i8 = 268435456;
                        }
                    }
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i4 == 0) {
                            }
                            if (i6 != 0) {
                                z2 = false;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 16) != 0) {
                                shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i3 &= -57345;
                            } else {
                                shape2 = shape;
                            }
                            if ((i2 & 32) != 0) {
                                color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                                i3 &= -458753;
                            } else {
                                color = j;
                            }
                            if ((i2 & 64) != 0) {
                                contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                contentColor = j2;
                            }
                            if ((i2 & 128) != 0) {
                                actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                actionContentColor = j3;
                            }
                            if ((i2 & 256) != 0) {
                                dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -234881025;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i4 == 0) {
                            }
                            if (i6 != 0) {
                                z2 = false;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 16) != 0) {
                                shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i3 &= -57345;
                            } else {
                                shape2 = shape;
                            }
                            if ((i2 & 32) != 0) {
                                color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                                i3 &= -458753;
                            } else {
                                color = j;
                            }
                            if ((i2 & 64) != 0) {
                                contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                contentColor = j2;
                            }
                            if ((i2 & 128) != 0) {
                                actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                actionContentColor = j3;
                            }
                            if ((i2 & 256) != 0) {
                                dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -234881025;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                        }
                        float fM2512getContainerElevationD9Ej5fM8 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                        InterfaceC0526Fp interfaceC0526Fp15 = interfaceC0526Fp6;
                        ComposableLambda composableLambda8 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                        int i119 = 12779520 | (i3 & 14);
                        int i1110 = i3 >> 9;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM8, null, composableLambda8, composerStartRestartGroup, (i1110 & 7168) | i119 | (i1110 & 112) | (i1110 & 896), 80);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z3 = z2;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j5 = color;
                        j6 = dismissActionContentColor;
                        j7 = actionContentColor;
                        interfaceC0526Fp5 = interfaceC0526Fp15;
                        modifier2 = modifier3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i4 == 0) {
                            }
                            if (i6 != 0) {
                                z2 = false;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 16) != 0) {
                                shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i3 &= -57345;
                            } else {
                                shape2 = shape;
                            }
                            if ((i2 & 32) != 0) {
                                color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                                i3 &= -458753;
                            } else {
                                color = j;
                            }
                            if ((i2 & 64) != 0) {
                                contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                contentColor = j2;
                            }
                            if ((i2 & 128) != 0) {
                                actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                actionContentColor = j3;
                            }
                            if ((i2 & 256) != 0) {
                                dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -234881025;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i4 == 0) {
                            }
                            if (i6 != 0) {
                                z2 = false;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 16) != 0) {
                                shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i3 &= -57345;
                            } else {
                                shape2 = shape;
                            }
                            if ((i2 & 32) != 0) {
                                color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                                i3 &= -458753;
                            } else {
                                color = j;
                            }
                            if ((i2 & 64) != 0) {
                                contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                contentColor = j2;
                            }
                            if ((i2 & 128) != 0) {
                                actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                actionContentColor = j3;
                            }
                            if ((i2 & 256) != 0) {
                                dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -234881025;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                        }
                        float fM2512getContainerElevationD9Ej5fM9 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                        InterfaceC0526Fp interfaceC0526Fp16 = interfaceC0526Fp6;
                        ComposableLambda composableLambda9 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                        int i1111 = 12779520 | (i3 & 14);
                        int i1112 = i3 >> 9;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM9, null, composableLambda9, composerStartRestartGroup, (i1112 & 7168) | i1111 | (i1112 & 112) | (i1112 & 896), 80);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z3 = z2;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j5 = color;
                        j6 = dismissActionContentColor;
                        j7 = actionContentColor;
                        interfaceC0526Fp5 = interfaceC0526Fp16;
                        modifier2 = modifier3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$2(modifier2, interfaceC0526Fp7, interfaceC0526Fp5, z3, shape2, j5, contentColor, j7, j6, interfaceC0526Fp3, i, i2));
                }
                i8 = 805306368;
                i3 |= i8;
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape2 = shape;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape2 = shape;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                    }
                    float fM2512getContainerElevationD9Ej5fM10 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                    InterfaceC0526Fp interfaceC0526Fp17 = interfaceC0526Fp6;
                    ComposableLambda composableLambda10 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                    int i1113 = 12779520 | (i3 & 14);
                    int i1114 = i3 >> 9;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM10, null, composableLambda10, composerStartRestartGroup, (i1114 & 7168) | i1113 | (i1114 & 112) | (i1114 & 896), 80);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z3 = z2;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j5 = color;
                    j6 = dismissActionContentColor;
                    j7 = actionContentColor;
                    interfaceC0526Fp5 = interfaceC0526Fp17;
                    modifier2 = modifier3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape2 = shape;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape2 = shape;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                    }
                    float fM2512getContainerElevationD9Ej5fM11 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                    InterfaceC0526Fp interfaceC0526Fp18 = interfaceC0526Fp6;
                    ComposableLambda composableLambda11 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                    int i1115 = 12779520 | (i3 & 14);
                    int i1116 = i3 >> 9;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM11, null, composableLambda11, composerStartRestartGroup, (i1116 & 7168) | i1115 | (i1116 & 112) | (i1116 & 896), 80);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z3 = z2;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j5 = color;
                    j6 = dismissActionContentColor;
                    j7 = actionContentColor;
                    interfaceC0526Fp5 = interfaceC0526Fp18;
                    modifier2 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$2(modifier2, interfaceC0526Fp7, interfaceC0526Fp5, z3, shape2, j5, contentColor, j7, j6, interfaceC0526Fp3, i, i2));
            }
            i3 |= 3072;
            if ((57344 & i) != 0) {
                i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changed(shape)) ? 8192 : 16384;
            }
            if ((458752 & i) != 0) {
                if ((i2 & 32) == 0) {
                    i12 = 65536;
                } else {
                    i12 = 65536;
                }
                i3 |= i12;
            }
            if ((3670016 & i) != 0) {
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            if ((29360128 & i) != 0) {
                if ((i2 & 128) == 0) {
                    i10 = 4194304;
                } else {
                    i10 = 4194304;
                }
                i3 |= i10;
            }
            if ((234881024 & i) == 0) {
                dismissActionContentColor = j4;
                if ((i2 & 256) == 0) {
                    i9 = 33554432;
                } else {
                    i9 = 33554432;
                }
                i3 |= i9;
            } else {
                dismissActionContentColor = j4;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i8 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i8 = 268435456;
                    }
                }
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape2 = shape;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape2 = shape;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                    }
                    float fM2512getContainerElevationD9Ej5fM12 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                    InterfaceC0526Fp interfaceC0526Fp19 = interfaceC0526Fp6;
                    ComposableLambda composableLambda12 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                    int i1117 = 12779520 | (i3 & 14);
                    int i1118 = i3 >> 9;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM12, null, composableLambda12, composerStartRestartGroup, (i1118 & 7168) | i1117 | (i1118 & 112) | (i1118 & 896), 80);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z3 = z2;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j5 = color;
                    j6 = dismissActionContentColor;
                    j7 = actionContentColor;
                    interfaceC0526Fp5 = interfaceC0526Fp19;
                    modifier2 = modifier3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape2 = shape;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape2 = shape;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                    }
                    float fM2512getContainerElevationD9Ej5fM13 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                    InterfaceC0526Fp interfaceC0526Fp110 = interfaceC0526Fp6;
                    ComposableLambda composableLambda13 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                    int i1119 = 12779520 | (i3 & 14);
                    int i11110 = i3 >> 9;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM13, null, composableLambda13, composerStartRestartGroup, (i11110 & 7168) | i1119 | (i11110 & 112) | (i11110 & 896), 80);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z3 = z2;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j5 = color;
                    j6 = dismissActionContentColor;
                    j7 = actionContentColor;
                    interfaceC0526Fp5 = interfaceC0526Fp110;
                    modifier2 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$2(modifier2, interfaceC0526Fp7, interfaceC0526Fp5, z3, shape2, j5, contentColor, j7, j6, interfaceC0526Fp3, i, i2));
            }
            i8 = 805306368;
            i3 |= i8;
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i4 == 0) {
                    }
                    if (i6 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 16) != 0) {
                        shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        shape2 = shape;
                    }
                    if ((i2 & 32) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        color = j;
                    }
                    if ((i2 & 64) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        contentColor = j2;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        actionContentColor = j3;
                    }
                    if ((i2 & 256) != 0) {
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -234881025;
                    }
                } else {
                    if (i13 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i4 == 0) {
                    }
                    if (i6 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 16) != 0) {
                        shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        shape2 = shape;
                    }
                    if ((i2 & 32) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        color = j;
                    }
                    if ((i2 & 64) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        contentColor = j2;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        actionContentColor = j3;
                    }
                    if ((i2 & 256) != 0) {
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -234881025;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                }
                float fM2512getContainerElevationD9Ej5fM14 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                InterfaceC0526Fp interfaceC0526Fp111 = interfaceC0526Fp6;
                ComposableLambda composableLambda14 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                int i11111 = 12779520 | (i3 & 14);
                int i11112 = i3 >> 9;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM14, null, composableLambda14, composerStartRestartGroup, (i11112 & 7168) | i11111 | (i11112 & 112) | (i11112 & 896), 80);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z3 = z2;
                interfaceC0526Fp7 = interfaceC0526Fp4;
                j5 = color;
                j6 = dismissActionContentColor;
                j7 = actionContentColor;
                interfaceC0526Fp5 = interfaceC0526Fp111;
                modifier2 = modifier3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i4 == 0) {
                    }
                    if (i6 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 16) != 0) {
                        shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        shape2 = shape;
                    }
                    if ((i2 & 32) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        color = j;
                    }
                    if ((i2 & 64) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        contentColor = j2;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        actionContentColor = j3;
                    }
                    if ((i2 & 256) != 0) {
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -234881025;
                    }
                } else {
                    if (i13 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i4 == 0) {
                    }
                    if (i6 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 16) != 0) {
                        shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        shape2 = shape;
                    }
                    if ((i2 & 32) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        color = j;
                    }
                    if ((i2 & 64) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        contentColor = j2;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        actionContentColor = j3;
                    }
                    if ((i2 & 256) != 0) {
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -234881025;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                }
                float fM2512getContainerElevationD9Ej5fM15 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                InterfaceC0526Fp interfaceC0526Fp112 = interfaceC0526Fp6;
                ComposableLambda composableLambda15 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                int i11113 = 12779520 | (i3 & 14);
                int i11114 = i3 >> 9;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM15, null, composableLambda15, composerStartRestartGroup, (i11114 & 7168) | i11113 | (i11114 & 112) | (i11114 & 896), 80);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z3 = z2;
                interfaceC0526Fp7 = interfaceC0526Fp4;
                j5 = color;
                j6 = dismissActionContentColor;
                j7 = actionContentColor;
                interfaceC0526Fp5 = interfaceC0526Fp112;
                modifier2 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$2(modifier2, interfaceC0526Fp7, interfaceC0526Fp5, z3, shape2, j5, contentColor, j7, j6, interfaceC0526Fp3, i, i2));
        }
        i3 |= 48;
        interfaceC0526Fp4 = interfaceC0526Fp;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                interfaceC0526Fp5 = interfaceC0526Fp2;
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((57344 & i) != 0) {
                    i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changed(shape)) ? 8192 : 16384;
                }
                if ((458752 & i) != 0) {
                    if ((i2 & 32) == 0) {
                        i12 = 65536;
                    } else {
                        i12 = 65536;
                    }
                    i3 |= i12;
                }
                if ((3670016 & i) != 0) {
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((29360128 & i) != 0) {
                    if ((i2 & 128) == 0) {
                        i10 = 4194304;
                    } else {
                        i10 = 4194304;
                    }
                    i3 |= i10;
                }
                if ((234881024 & i) == 0) {
                    dismissActionContentColor = j4;
                    if ((i2 & 256) == 0) {
                        i9 = 33554432;
                    } else {
                        i9 = 33554432;
                    }
                    i3 |= i9;
                } else {
                    dismissActionContentColor = j4;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                            i8 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i8 = 268435456;
                        }
                    }
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i4 == 0) {
                            }
                            if (i6 != 0) {
                                z2 = false;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 16) != 0) {
                                shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i3 &= -57345;
                            } else {
                                shape2 = shape;
                            }
                            if ((i2 & 32) != 0) {
                                color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                                i3 &= -458753;
                            } else {
                                color = j;
                            }
                            if ((i2 & 64) != 0) {
                                contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                contentColor = j2;
                            }
                            if ((i2 & 128) != 0) {
                                actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                actionContentColor = j3;
                            }
                            if ((i2 & 256) != 0) {
                                dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -234881025;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i4 == 0) {
                            }
                            if (i6 != 0) {
                                z2 = false;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 16) != 0) {
                                shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i3 &= -57345;
                            } else {
                                shape2 = shape;
                            }
                            if ((i2 & 32) != 0) {
                                color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                                i3 &= -458753;
                            } else {
                                color = j;
                            }
                            if ((i2 & 64) != 0) {
                                contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                contentColor = j2;
                            }
                            if ((i2 & 128) != 0) {
                                actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                actionContentColor = j3;
                            }
                            if ((i2 & 256) != 0) {
                                dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -234881025;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                        }
                        float fM2512getContainerElevationD9Ej5fM16 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                        InterfaceC0526Fp interfaceC0526Fp113 = interfaceC0526Fp6;
                        ComposableLambda composableLambda16 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                        int i11115 = 12779520 | (i3 & 14);
                        int i11116 = i3 >> 9;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM16, null, composableLambda16, composerStartRestartGroup, (i11116 & 7168) | i11115 | (i11116 & 112) | (i11116 & 896), 80);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z3 = z2;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j5 = color;
                        j6 = dismissActionContentColor;
                        j7 = actionContentColor;
                        interfaceC0526Fp5 = interfaceC0526Fp113;
                        modifier2 = modifier3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i4 == 0) {
                            }
                            if (i6 != 0) {
                                z2 = false;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 16) != 0) {
                                shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i3 &= -57345;
                            } else {
                                shape2 = shape;
                            }
                            if ((i2 & 32) != 0) {
                                color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                                i3 &= -458753;
                            } else {
                                color = j;
                            }
                            if ((i2 & 64) != 0) {
                                contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                contentColor = j2;
                            }
                            if ((i2 & 128) != 0) {
                                actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                actionContentColor = j3;
                            }
                            if ((i2 & 256) != 0) {
                                dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -234881025;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i4 == 0) {
                            }
                            if (i6 != 0) {
                                z2 = false;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 16) != 0) {
                                shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i3 &= -57345;
                            } else {
                                shape2 = shape;
                            }
                            if ((i2 & 32) != 0) {
                                color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                                i3 &= -458753;
                            } else {
                                color = j;
                            }
                            if ((i2 & 64) != 0) {
                                contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                contentColor = j2;
                            }
                            if ((i2 & 128) != 0) {
                                actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                actionContentColor = j3;
                            }
                            if ((i2 & 256) != 0) {
                                dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -234881025;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                        }
                        float fM2512getContainerElevationD9Ej5fM17 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                        InterfaceC0526Fp interfaceC0526Fp114 = interfaceC0526Fp6;
                        ComposableLambda composableLambda17 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                        int i11117 = 12779520 | (i3 & 14);
                        int i11118 = i3 >> 9;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM17, null, composableLambda17, composerStartRestartGroup, (i11118 & 7168) | i11117 | (i11118 & 112) | (i11118 & 896), 80);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z3 = z2;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j5 = color;
                        j6 = dismissActionContentColor;
                        j7 = actionContentColor;
                        interfaceC0526Fp5 = interfaceC0526Fp114;
                        modifier2 = modifier3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$2(modifier2, interfaceC0526Fp7, interfaceC0526Fp5, z3, shape2, j5, contentColor, j7, j6, interfaceC0526Fp3, i, i2));
                }
                i8 = 805306368;
                i3 |= i8;
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape2 = shape;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape2 = shape;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                    }
                    float fM2512getContainerElevationD9Ej5fM18 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                    InterfaceC0526Fp interfaceC0526Fp115 = interfaceC0526Fp6;
                    ComposableLambda composableLambda18 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                    int i11119 = 12779520 | (i3 & 14);
                    int i111110 = i3 >> 9;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM18, null, composableLambda18, composerStartRestartGroup, (i111110 & 7168) | i11119 | (i111110 & 112) | (i111110 & 896), 80);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z3 = z2;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j5 = color;
                    j6 = dismissActionContentColor;
                    j7 = actionContentColor;
                    interfaceC0526Fp5 = interfaceC0526Fp115;
                    modifier2 = modifier3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape2 = shape;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape2 = shape;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                    }
                    float fM2512getContainerElevationD9Ej5fM19 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                    InterfaceC0526Fp interfaceC0526Fp116 = interfaceC0526Fp6;
                    ComposableLambda composableLambda19 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                    int i111111 = 12779520 | (i3 & 14);
                    int i111112 = i3 >> 9;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM19, null, composableLambda19, composerStartRestartGroup, (i111112 & 7168) | i111111 | (i111112 & 112) | (i111112 & 896), 80);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z3 = z2;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j5 = color;
                    j6 = dismissActionContentColor;
                    j7 = actionContentColor;
                    interfaceC0526Fp5 = interfaceC0526Fp116;
                    modifier2 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$2(modifier2, interfaceC0526Fp7, interfaceC0526Fp5, z3, shape2, j5, contentColor, j7, j6, interfaceC0526Fp3, i, i2));
            }
            i3 |= 3072;
            if ((57344 & i) != 0) {
                i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changed(shape)) ? 8192 : 16384;
            }
            if ((458752 & i) != 0) {
                if ((i2 & 32) == 0) {
                    i12 = 65536;
                } else {
                    i12 = 65536;
                }
                i3 |= i12;
            }
            if ((3670016 & i) != 0) {
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            if ((29360128 & i) != 0) {
                if ((i2 & 128) == 0) {
                    i10 = 4194304;
                } else {
                    i10 = 4194304;
                }
                i3 |= i10;
            }
            if ((234881024 & i) == 0) {
                dismissActionContentColor = j4;
                if ((i2 & 256) == 0) {
                    i9 = 33554432;
                } else {
                    i9 = 33554432;
                }
                i3 |= i9;
            } else {
                dismissActionContentColor = j4;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i8 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i8 = 268435456;
                    }
                }
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape2 = shape;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape2 = shape;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                    }
                    float fM2512getContainerElevationD9Ej5fM110 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                    InterfaceC0526Fp interfaceC0526Fp117 = interfaceC0526Fp6;
                    ComposableLambda composableLambda110 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                    int i111113 = 12779520 | (i3 & 14);
                    int i111114 = i3 >> 9;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM110, null, composableLambda110, composerStartRestartGroup, (i111114 & 7168) | i111113 | (i111114 & 112) | (i111114 & 896), 80);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z3 = z2;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j5 = color;
                    j6 = dismissActionContentColor;
                    j7 = actionContentColor;
                    interfaceC0526Fp5 = interfaceC0526Fp117;
                    modifier2 = modifier3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape2 = shape;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape2 = shape;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                    }
                    float fM2512getContainerElevationD9Ej5fM111 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                    InterfaceC0526Fp interfaceC0526Fp118 = interfaceC0526Fp6;
                    ComposableLambda composableLambda111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                    int i111115 = 12779520 | (i3 & 14);
                    int i111116 = i3 >> 9;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM111, null, composableLambda111, composerStartRestartGroup, (i111116 & 7168) | i111115 | (i111116 & 112) | (i111116 & 896), 80);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z3 = z2;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j5 = color;
                    j6 = dismissActionContentColor;
                    j7 = actionContentColor;
                    interfaceC0526Fp5 = interfaceC0526Fp118;
                    modifier2 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$2(modifier2, interfaceC0526Fp7, interfaceC0526Fp5, z3, shape2, j5, contentColor, j7, j6, interfaceC0526Fp3, i, i2));
            }
            i8 = 805306368;
            i3 |= i8;
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i4 == 0) {
                    }
                    if (i6 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 16) != 0) {
                        shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        shape2 = shape;
                    }
                    if ((i2 & 32) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        color = j;
                    }
                    if ((i2 & 64) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        contentColor = j2;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        actionContentColor = j3;
                    }
                    if ((i2 & 256) != 0) {
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -234881025;
                    }
                } else {
                    if (i13 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i4 == 0) {
                    }
                    if (i6 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 16) != 0) {
                        shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        shape2 = shape;
                    }
                    if ((i2 & 32) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        color = j;
                    }
                    if ((i2 & 64) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        contentColor = j2;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        actionContentColor = j3;
                    }
                    if ((i2 & 256) != 0) {
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -234881025;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                }
                float fM2512getContainerElevationD9Ej5fM112 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                InterfaceC0526Fp interfaceC0526Fp119 = interfaceC0526Fp6;
                ComposableLambda composableLambda112 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                int i111117 = 12779520 | (i3 & 14);
                int i111118 = i3 >> 9;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM112, null, composableLambda112, composerStartRestartGroup, (i111118 & 7168) | i111117 | (i111118 & 112) | (i111118 & 896), 80);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z3 = z2;
                interfaceC0526Fp7 = interfaceC0526Fp4;
                j5 = color;
                j6 = dismissActionContentColor;
                j7 = actionContentColor;
                interfaceC0526Fp5 = interfaceC0526Fp119;
                modifier2 = modifier3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i4 == 0) {
                    }
                    if (i6 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 16) != 0) {
                        shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        shape2 = shape;
                    }
                    if ((i2 & 32) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        color = j;
                    }
                    if ((i2 & 64) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        contentColor = j2;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        actionContentColor = j3;
                    }
                    if ((i2 & 256) != 0) {
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -234881025;
                    }
                } else {
                    if (i13 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i4 == 0) {
                    }
                    if (i6 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 16) != 0) {
                        shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        shape2 = shape;
                    }
                    if ((i2 & 32) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        color = j;
                    }
                    if ((i2 & 64) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        contentColor = j2;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        actionContentColor = j3;
                    }
                    if ((i2 & 256) != 0) {
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -234881025;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                }
                float fM2512getContainerElevationD9Ej5fM113 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                InterfaceC0526Fp interfaceC0526Fp1110 = interfaceC0526Fp6;
                ComposableLambda composableLambda113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                int i111119 = 12779520 | (i3 & 14);
                int i1111110 = i3 >> 9;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM113, null, composableLambda113, composerStartRestartGroup, (i1111110 & 7168) | i111119 | (i1111110 & 112) | (i1111110 & 896), 80);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z3 = z2;
                interfaceC0526Fp7 = interfaceC0526Fp4;
                j5 = color;
                j6 = dismissActionContentColor;
                j7 = actionContentColor;
                interfaceC0526Fp5 = interfaceC0526Fp1110;
                modifier2 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$2(modifier2, interfaceC0526Fp7, interfaceC0526Fp5, z3, shape2, j5, contentColor, j7, j6, interfaceC0526Fp3, i, i2));
        }
        i3 |= 384;
        interfaceC0526Fp5 = interfaceC0526Fp2;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((57344 & i) != 0) {
                i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changed(shape)) ? 8192 : 16384;
            }
            if ((458752 & i) != 0) {
                if ((i2 & 32) == 0) {
                    i12 = 65536;
                } else {
                    i12 = 65536;
                }
                i3 |= i12;
            }
            if ((3670016 & i) != 0) {
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            if ((29360128 & i) != 0) {
                if ((i2 & 128) == 0) {
                    i10 = 4194304;
                } else {
                    i10 = 4194304;
                }
                i3 |= i10;
            }
            if ((234881024 & i) == 0) {
                dismissActionContentColor = j4;
                if ((i2 & 256) == 0) {
                    i9 = 33554432;
                } else {
                    i9 = 33554432;
                }
                i3 |= i9;
            } else {
                dismissActionContentColor = j4;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i8 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i8 = 268435456;
                    }
                }
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape2 = shape;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape2 = shape;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                    }
                    float fM2512getContainerElevationD9Ej5fM114 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                    InterfaceC0526Fp interfaceC0526Fp1111 = interfaceC0526Fp6;
                    ComposableLambda composableLambda114 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                    int i1111111 = 12779520 | (i3 & 14);
                    int i1111112 = i3 >> 9;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM114, null, composableLambda114, composerStartRestartGroup, (i1111112 & 7168) | i1111111 | (i1111112 & 112) | (i1111112 & 896), 80);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z3 = z2;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j5 = color;
                    j6 = dismissActionContentColor;
                    j7 = actionContentColor;
                    interfaceC0526Fp5 = interfaceC0526Fp1111;
                    modifier2 = modifier3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape2 = shape;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape2 = shape;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                    }
                    float fM2512getContainerElevationD9Ej5fM115 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                    InterfaceC0526Fp interfaceC0526Fp1112 = interfaceC0526Fp6;
                    ComposableLambda composableLambda115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                    int i1111113 = 12779520 | (i3 & 14);
                    int i1111114 = i3 >> 9;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM115, null, composableLambda115, composerStartRestartGroup, (i1111114 & 7168) | i1111113 | (i1111114 & 112) | (i1111114 & 896), 80);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z3 = z2;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j5 = color;
                    j6 = dismissActionContentColor;
                    j7 = actionContentColor;
                    interfaceC0526Fp5 = interfaceC0526Fp1112;
                    modifier2 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$2(modifier2, interfaceC0526Fp7, interfaceC0526Fp5, z3, shape2, j5, contentColor, j7, j6, interfaceC0526Fp3, i, i2));
            }
            i8 = 805306368;
            i3 |= i8;
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i4 == 0) {
                    }
                    if (i6 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 16) != 0) {
                        shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        shape2 = shape;
                    }
                    if ((i2 & 32) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        color = j;
                    }
                    if ((i2 & 64) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        contentColor = j2;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        actionContentColor = j3;
                    }
                    if ((i2 & 256) != 0) {
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -234881025;
                    }
                } else {
                    if (i13 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i4 == 0) {
                    }
                    if (i6 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 16) != 0) {
                        shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        shape2 = shape;
                    }
                    if ((i2 & 32) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        color = j;
                    }
                    if ((i2 & 64) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        contentColor = j2;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        actionContentColor = j3;
                    }
                    if ((i2 & 256) != 0) {
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -234881025;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                }
                float fM2512getContainerElevationD9Ej5fM116 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                InterfaceC0526Fp interfaceC0526Fp1113 = interfaceC0526Fp6;
                ComposableLambda composableLambda116 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                int i1111115 = 12779520 | (i3 & 14);
                int i1111116 = i3 >> 9;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM116, null, composableLambda116, composerStartRestartGroup, (i1111116 & 7168) | i1111115 | (i1111116 & 112) | (i1111116 & 896), 80);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z3 = z2;
                interfaceC0526Fp7 = interfaceC0526Fp4;
                j5 = color;
                j6 = dismissActionContentColor;
                j7 = actionContentColor;
                interfaceC0526Fp5 = interfaceC0526Fp1113;
                modifier2 = modifier3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i4 == 0) {
                    }
                    if (i6 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 16) != 0) {
                        shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        shape2 = shape;
                    }
                    if ((i2 & 32) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        color = j;
                    }
                    if ((i2 & 64) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        contentColor = j2;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        actionContentColor = j3;
                    }
                    if ((i2 & 256) != 0) {
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -234881025;
                    }
                } else {
                    if (i13 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i4 == 0) {
                    }
                    if (i6 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 16) != 0) {
                        shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        shape2 = shape;
                    }
                    if ((i2 & 32) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        color = j;
                    }
                    if ((i2 & 64) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        contentColor = j2;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        actionContentColor = j3;
                    }
                    if ((i2 & 256) != 0) {
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -234881025;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                }
                float fM2512getContainerElevationD9Ej5fM117 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                InterfaceC0526Fp interfaceC0526Fp1114 = interfaceC0526Fp6;
                ComposableLambda composableLambda117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                int i1111117 = 12779520 | (i3 & 14);
                int i1111118 = i3 >> 9;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM117, null, composableLambda117, composerStartRestartGroup, (i1111118 & 7168) | i1111117 | (i1111118 & 112) | (i1111118 & 896), 80);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z3 = z2;
                interfaceC0526Fp7 = interfaceC0526Fp4;
                j5 = color;
                j6 = dismissActionContentColor;
                j7 = actionContentColor;
                interfaceC0526Fp5 = interfaceC0526Fp1114;
                modifier2 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$2(modifier2, interfaceC0526Fp7, interfaceC0526Fp5, z3, shape2, j5, contentColor, j7, j6, interfaceC0526Fp3, i, i2));
        }
        i3 |= 3072;
        if ((57344 & i) != 0) {
            i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changed(shape)) ? 8192 : 16384;
        }
        if ((458752 & i) != 0) {
            if ((i2 & 32) == 0) {
                i12 = 65536;
            } else {
                i12 = 65536;
            }
            i3 |= i12;
        }
        if ((3670016 & i) != 0) {
            if ((i2 & 64) == 0) {
                i11 = 524288;
            } else {
                i11 = 524288;
            }
            i3 |= i11;
        }
        if ((29360128 & i) != 0) {
            if ((i2 & 128) == 0) {
                i10 = 4194304;
            } else {
                i10 = 4194304;
            }
            i3 |= i10;
        }
        if ((234881024 & i) == 0) {
            dismissActionContentColor = j4;
            if ((i2 & 256) == 0) {
                i9 = 33554432;
            } else {
                i9 = 33554432;
            }
            i3 |= i9;
        } else {
            dismissActionContentColor = j4;
        }
        if ((i2 & 512) != 0) {
            if ((1879048192 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                    i8 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i8 = 268435456;
                }
            }
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i4 == 0) {
                    }
                    if (i6 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 16) != 0) {
                        shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        shape2 = shape;
                    }
                    if ((i2 & 32) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        color = j;
                    }
                    if ((i2 & 64) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        contentColor = j2;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        actionContentColor = j3;
                    }
                    if ((i2 & 256) != 0) {
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -234881025;
                    }
                } else {
                    if (i13 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i4 == 0) {
                    }
                    if (i6 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 16) != 0) {
                        shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        shape2 = shape;
                    }
                    if ((i2 & 32) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        color = j;
                    }
                    if ((i2 & 64) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        contentColor = j2;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        actionContentColor = j3;
                    }
                    if ((i2 & 256) != 0) {
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -234881025;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                }
                float fM2512getContainerElevationD9Ej5fM118 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                InterfaceC0526Fp interfaceC0526Fp1115 = interfaceC0526Fp6;
                ComposableLambda composableLambda118 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                int i1111119 = 12779520 | (i3 & 14);
                int i11111110 = i3 >> 9;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM118, null, composableLambda118, composerStartRestartGroup, (i11111110 & 7168) | i1111119 | (i11111110 & 112) | (i11111110 & 896), 80);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z3 = z2;
                interfaceC0526Fp7 = interfaceC0526Fp4;
                j5 = color;
                j6 = dismissActionContentColor;
                j7 = actionContentColor;
                interfaceC0526Fp5 = interfaceC0526Fp1115;
                modifier2 = modifier3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i4 == 0) {
                    }
                    if (i6 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 16) != 0) {
                        shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        shape2 = shape;
                    }
                    if ((i2 & 32) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        color = j;
                    }
                    if ((i2 & 64) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        contentColor = j2;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        actionContentColor = j3;
                    }
                    if ((i2 & 256) != 0) {
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -234881025;
                    }
                } else {
                    if (i13 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i4 == 0) {
                    }
                    if (i6 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 16) != 0) {
                        shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        shape2 = shape;
                    }
                    if ((i2 & 32) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        color = j;
                    }
                    if ((i2 & 64) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        contentColor = j2;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        actionContentColor = j3;
                    }
                    if ((i2 & 256) != 0) {
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -234881025;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
                }
                float fM2512getContainerElevationD9Ej5fM119 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
                InterfaceC0526Fp interfaceC0526Fp1116 = interfaceC0526Fp6;
                ComposableLambda composableLambda119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
                int i11111111 = 12779520 | (i3 & 14);
                int i11111112 = i3 >> 9;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM119, null, composableLambda119, composerStartRestartGroup, (i11111112 & 7168) | i11111111 | (i11111112 & 112) | (i11111112 & 896), 80);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z3 = z2;
                interfaceC0526Fp7 = interfaceC0526Fp4;
                j5 = color;
                j6 = dismissActionContentColor;
                j7 = actionContentColor;
                interfaceC0526Fp5 = interfaceC0526Fp1116;
                modifier2 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$2(modifier2, interfaceC0526Fp7, interfaceC0526Fp5, z3, shape2, j5, contentColor, j7, j6, interfaceC0526Fp3, i, i2));
        }
        i8 = 805306368;
        i3 |= i8;
        if ((1533916891 & i3) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i13 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i14 != 0) {
                    interfaceC0526Fp4 = null;
                }
                if (i4 == 0) {
                }
                if (i6 != 0) {
                    z2 = false;
                } else {
                    z2 = z;
                }
                if ((i2 & 16) != 0) {
                    shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i3 &= -57345;
                } else {
                    shape2 = shape;
                }
                if ((i2 & 32) != 0) {
                    color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                    i3 &= -458753;
                } else {
                    color = j;
                }
                if ((i2 & 64) != 0) {
                    contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    contentColor = j2;
                }
                if ((i2 & 128) != 0) {
                    actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    actionContentColor = j3;
                }
                if ((i2 & 256) != 0) {
                    dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                    i3 &= -234881025;
                }
            } else {
                if (i13 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i14 != 0) {
                    interfaceC0526Fp4 = null;
                }
                if (i4 == 0) {
                }
                if (i6 != 0) {
                    z2 = false;
                } else {
                    z2 = z;
                }
                if ((i2 & 16) != 0) {
                    shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i3 &= -57345;
                } else {
                    shape2 = shape;
                }
                if ((i2 & 32) != 0) {
                    color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                    i3 &= -458753;
                } else {
                    color = j;
                }
                if ((i2 & 64) != 0) {
                    contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    contentColor = j2;
                }
                if ((i2 & 128) != 0) {
                    actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    actionContentColor = j3;
                }
                if ((i2 & 256) != 0) {
                    dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                    i3 &= -234881025;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
            }
            float fM2512getContainerElevationD9Ej5fM1110 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
            InterfaceC0526Fp interfaceC0526Fp1117 = interfaceC0526Fp6;
            ComposableLambda composableLambda1110 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
            int i11111113 = 12779520 | (i3 & 14);
            int i11111114 = i3 >> 9;
            SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM1110, null, composableLambda1110, composerStartRestartGroup, (i11111114 & 7168) | i11111113 | (i11111114 & 112) | (i11111114 & 896), 80);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z3 = z2;
            interfaceC0526Fp7 = interfaceC0526Fp4;
            j5 = color;
            j6 = dismissActionContentColor;
            j7 = actionContentColor;
            interfaceC0526Fp5 = interfaceC0526Fp1117;
            modifier2 = modifier3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i13 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i14 != 0) {
                    interfaceC0526Fp4 = null;
                }
                if (i4 == 0) {
                }
                if (i6 != 0) {
                    z2 = false;
                } else {
                    z2 = z;
                }
                if ((i2 & 16) != 0) {
                    shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i3 &= -57345;
                } else {
                    shape2 = shape;
                }
                if ((i2 & 32) != 0) {
                    color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                    i3 &= -458753;
                } else {
                    color = j;
                }
                if ((i2 & 64) != 0) {
                    contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    contentColor = j2;
                }
                if ((i2 & 128) != 0) {
                    actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    actionContentColor = j3;
                }
                if ((i2 & 256) != 0) {
                    dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                    i3 &= -234881025;
                }
            } else {
                if (i13 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i14 != 0) {
                    interfaceC0526Fp4 = null;
                }
                if (i4 == 0) {
                }
                if (i6 != 0) {
                    z2 = false;
                } else {
                    z2 = z;
                }
                if ((i2 & 16) != 0) {
                    shape2 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i3 &= -57345;
                } else {
                    shape2 = shape;
                }
                if ((i2 & 32) != 0) {
                    color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                    i3 &= -458753;
                } else {
                    color = j;
                }
                if ((i2 & 64) != 0) {
                    contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    contentColor = j2;
                }
                if ((i2 & 128) != 0) {
                    actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    actionContentColor = j3;
                }
                if ((i2 & 256) != 0) {
                    dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                    i3 &= -234881025;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:94)");
            }
            float fM2512getContainerElevationD9Ej5fM1111 = SnackbarTokens.INSTANCE.m2512getContainerElevationD9Ej5fM();
            InterfaceC0526Fp interfaceC0526Fp1118 = interfaceC0526Fp6;
            ComposableLambda composableLambda1111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new SnackbarKt$Snackbar$1(interfaceC0526Fp4, interfaceC0526Fp3, interfaceC0526Fp6, actionContentColor, dismissActionContentColor, i3, z2));
            int i11111115 = 12779520 | (i3 & 14);
            int i11111116 = i3 >> 9;
            SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape2, color, contentColor, 0.0f, fM2512getContainerElevationD9Ej5fM1111, null, composableLambda1111, composerStartRestartGroup, (i11111116 & 7168) | i11111115 | (i11111116 & 112) | (i11111116 & 896), 80);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z3 = z2;
            interfaceC0526Fp7 = interfaceC0526Fp4;
            j5 = color;
            j6 = dismissActionContentColor;
            j7 = actionContentColor;
            interfaceC0526Fp5 = interfaceC0526Fp1118;
            modifier2 = modifier3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$2(modifier2, interfaceC0526Fp7, interfaceC0526Fp5, z3, shape2, j5, contentColor, j7, j6, interfaceC0526Fp3, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0127  */
    /* JADX WARN: Code duplicated, block: B:105:0x013a  */
    /* JADX WARN: Code duplicated, block: B:127:0x0173 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:128:0x0175  */
    /* JADX WARN: Code duplicated, block: B:129:0x0178  */
    /* JADX WARN: Code duplicated, block: B:131:0x017b  */
    /* JADX WARN: Code duplicated, block: B:132:0x017d  */
    /* JADX WARN: Code duplicated, block: B:135:0x0183  */
    /* JADX WARN: Code duplicated, block: B:136:0x018c  */
    /* JADX WARN: Code duplicated, block: B:139:0x0191  */
    /* JADX WARN: Code duplicated, block: B:140:0x019a  */
    /* JADX WARN: Code duplicated, block: B:143:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:146:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:149:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:150:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:153:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:154:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:157:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:160:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:161:0x020d  */
    /* JADX WARN: Code duplicated, block: B:164:0x0218  */
    /* JADX WARN: Code duplicated, block: B:165:0x022a  */
    /* JADX WARN: Code duplicated, block: B:168:0x0281  */
    /* JADX WARN: Code duplicated, block: B:173:0x0291  */
    /* JADX WARN: Code duplicated, block: B:175:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARN: Code duplicated, block: B:61:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:64:0x00af  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:76:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:81:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:86:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:91:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:94:0x0102  */
    /* JADX WARN: Code duplicated, block: B:96:0x0106  */
    /* JADX WARN: Code duplicated, block: B:99:0x0111  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Snackbar-sDKtq54, reason: not valid java name */
    public static final void m1764SnackbarsDKtq54(SnackbarData snackbarData, Modifier modifier, boolean z, Shape shape, long j, long j2, long j3, long j4, long j5, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        Shape shape2;
        long contentColor;
        long actionColor;
        Modifier modifier3;
        boolean z3;
        Shape shape3;
        long color;
        long actionContentColor;
        long dismissActionContentColor;
        long j6;
        String actionLabel;
        ComposableLambda composableLambda;
        SnackbarData snackbarData2;
        ComposableLambda composableLambda2;
        boolean z4;
        Shape shape4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i6;
        int i7;
        int i8;
        int i9;
        AbstractC4492zt.h(snackbarData, "snackbarData");
        Composer composerStartRestartGroup = composer.startRestartGroup(274621471);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(snackbarData) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
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
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        int i11 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                        i3 |= i11;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i11;
                } else {
                    shape2 = shape;
                }
                if ((i & 57344) != 0) {
                    i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changed(j)) ? 8192 : 16384;
                }
                if ((i & 458752) == 0) {
                    contentColor = j2;
                    if ((i2 & 32) == 0 || !composerStartRestartGroup.changed(contentColor)) {
                        i9 = 65536;
                    } else {
                        i9 = 131072;
                    }
                    i3 |= i9;
                } else {
                    contentColor = j2;
                }
                if ((i & 3670016) == 0) {
                    actionColor = j3;
                    if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(actionColor)) {
                        i8 = 524288;
                    } else {
                        i8 = 1048576;
                    }
                    i3 |= i8;
                } else {
                    actionColor = j3;
                }
                if ((i & 29360128) != 0) {
                    if ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j4)) {
                        i7 = 4194304;
                    } else {
                        i7 = 8388608;
                    }
                    i3 |= i7;
                }
                if ((i & 234881024) != 0) {
                    if ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j5)) {
                        i6 = 33554432;
                    } else {
                        i6 = 67108864;
                    }
                    i3 |= i6;
                }
                if ((191739611 & i3) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = false;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 8) != 0) {
                            shape3 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            color = j;
                        }
                        if ((i2 & 32) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            actionColor = SnackbarDefaults.INSTANCE.getActionColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 = (-29360129) & i3;
                        } else {
                            actionContentColor = j4;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            j6 = actionContentColor;
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                        } else {
                            dismissActionContentColor = j5;
                            j6 = actionContentColor;
                        }
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
                        if ((i2 & 128) != 0) {
                            i3 &= -29360129;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                        }
                        j6 = j4;
                        dismissActionContentColor = j5;
                        modifier3 = modifier2;
                        z3 = z2;
                        shape3 = shape2;
                        color = j;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(274621471, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:197)");
                    }
                    actionLabel = snackbarData.getVisuals().getActionLabel();
                    if (actionLabel != null) {
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1378313599, true, new SnackbarKt$Snackbar$actionComposable$1(actionColor, i3, snackbarData, actionLabel));
                    } else {
                        composableLambda = null;
                    }
                    if (snackbarData.getVisuals().getWithDismissAction()) {
                        snackbarData2 = snackbarData;
                        composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1812633777, true, new SnackbarKt$Snackbar$dismissActionComposable$1(snackbarData2, i3));
                    } else {
                        snackbarData2 = snackbarData;
                        composableLambda2 = null;
                    }
                    Modifier modifier4 = modifier3;
                    int i12 = i3 << 3;
                    m1763SnackbareQBnUkQ(PaddingKt.m485padding3ABfNKs(modifier3, Dp.m5160constructorimpl(12)), composableLambda, composableLambda2, z3, shape3, color, contentColor, j6, dismissActionContentColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1266389126, true, new SnackbarKt$Snackbar$3(snackbarData2)), composerStartRestartGroup, (i12 & 3670016) | (i12 & 7168) | 805306368 | (57344 & i12) | (458752 & i12) | (i3 & 29360128) | (i3 & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    actionColor = actionColor;
                    z4 = z3;
                    shape4 = shape3;
                    modifier2 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    j6 = j4;
                    dismissActionContentColor = j5;
                    z4 = z2;
                    shape4 = shape2;
                    color = j;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$4(snackbarData, modifier2, z4, shape4, color, contentColor, actionColor, j6, dismissActionContentColor, i, i2));
            }
            i3 |= 384;
            z2 = z;
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i11;
                } else {
                    shape2 = shape;
                }
                i3 |= i11;
            } else {
                shape2 = shape;
            }
            if ((i & 57344) != 0) {
                i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changed(j)) ? 8192 : 16384;
            }
            if ((i & 458752) == 0) {
                contentColor = j2;
                if ((i2 & 32) == 0) {
                    i9 = 65536;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            } else {
                contentColor = j2;
            }
            if ((i & 3670016) == 0) {
                actionColor = j3;
                if ((i2 & 64) == 0) {
                    i8 = 524288;
                } else {
                    i8 = 524288;
                }
                i3 |= i8;
            } else {
                actionColor = j3;
            }
            if ((i & 29360128) != 0) {
                if ((i2 & 128) == 0) {
                    i7 = 4194304;
                } else {
                    i7 = 4194304;
                }
                i3 |= i7;
            }
            if ((i & 234881024) != 0) {
                if ((i2 & 256) == 0) {
                    i6 = 33554432;
                } else {
                    i6 = 33554432;
                }
                i3 |= i6;
            }
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        shape3 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        color = j;
                    }
                    if ((i2 & 32) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        actionColor = SnackbarDefaults.INSTANCE.getActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 = (-29360129) & i3;
                    } else {
                        actionContentColor = j4;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        j6 = actionContentColor;
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                    } else {
                        dismissActionContentColor = j5;
                        j6 = actionContentColor;
                    }
                } else {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        shape3 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        color = j;
                    }
                    if ((i2 & 32) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        actionColor = SnackbarDefaults.INSTANCE.getActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 = (-29360129) & i3;
                    } else {
                        actionContentColor = j4;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        j6 = actionContentColor;
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                    } else {
                        dismissActionContentColor = j5;
                        j6 = actionContentColor;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(274621471, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:197)");
                }
                actionLabel = snackbarData.getVisuals().getActionLabel();
                if (actionLabel != null) {
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1378313599, true, new SnackbarKt$Snackbar$actionComposable$1(actionColor, i3, snackbarData, actionLabel));
                } else {
                    composableLambda = null;
                }
                if (snackbarData.getVisuals().getWithDismissAction()) {
                    snackbarData2 = snackbarData;
                    composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1812633777, true, new SnackbarKt$Snackbar$dismissActionComposable$1(snackbarData2, i3));
                } else {
                    snackbarData2 = snackbarData;
                    composableLambda2 = null;
                }
                Modifier modifier5 = modifier3;
                int i13 = i3 << 3;
                m1763SnackbareQBnUkQ(PaddingKt.m485padding3ABfNKs(modifier3, Dp.m5160constructorimpl(12)), composableLambda, composableLambda2, z3, shape3, color, contentColor, j6, dismissActionContentColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1266389126, true, new SnackbarKt$Snackbar$3(snackbarData2)), composerStartRestartGroup, (i13 & 3670016) | (i13 & 7168) | 805306368 | (57344 & i13) | (458752 & i13) | (i3 & 29360128) | (i3 & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                actionColor = actionColor;
                z4 = z3;
                shape4 = shape3;
                modifier2 = modifier5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        shape3 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        color = j;
                    }
                    if ((i2 & 32) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        actionColor = SnackbarDefaults.INSTANCE.getActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 = (-29360129) & i3;
                    } else {
                        actionContentColor = j4;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        j6 = actionContentColor;
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                    } else {
                        dismissActionContentColor = j5;
                        j6 = actionContentColor;
                    }
                } else {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        shape3 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        color = j;
                    }
                    if ((i2 & 32) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        actionColor = SnackbarDefaults.INSTANCE.getActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 = (-29360129) & i3;
                    } else {
                        actionContentColor = j4;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        j6 = actionContentColor;
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                    } else {
                        dismissActionContentColor = j5;
                        j6 = actionContentColor;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(274621471, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:197)");
                }
                actionLabel = snackbarData.getVisuals().getActionLabel();
                if (actionLabel != null) {
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1378313599, true, new SnackbarKt$Snackbar$actionComposable$1(actionColor, i3, snackbarData, actionLabel));
                } else {
                    composableLambda = null;
                }
                if (snackbarData.getVisuals().getWithDismissAction()) {
                    snackbarData2 = snackbarData;
                    composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1812633777, true, new SnackbarKt$Snackbar$dismissActionComposable$1(snackbarData2, i3));
                } else {
                    snackbarData2 = snackbarData;
                    composableLambda2 = null;
                }
                Modifier modifier6 = modifier3;
                int i14 = i3 << 3;
                m1763SnackbareQBnUkQ(PaddingKt.m485padding3ABfNKs(modifier3, Dp.m5160constructorimpl(12)), composableLambda, composableLambda2, z3, shape3, color, contentColor, j6, dismissActionContentColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1266389126, true, new SnackbarKt$Snackbar$3(snackbarData2)), composerStartRestartGroup, (i14 & 3670016) | (i14 & 7168) | 805306368 | (57344 & i14) | (458752 & i14) | (i3 & 29360128) | (i3 & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                actionColor = actionColor;
                z4 = z3;
                shape4 = shape3;
                modifier2 = modifier6;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$4(snackbarData, modifier2, z4, shape4, color, contentColor, actionColor, j6, dismissActionContentColor, i, i2));
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
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i11;
                } else {
                    shape2 = shape;
                }
                i3 |= i11;
            } else {
                shape2 = shape;
            }
            if ((i & 57344) != 0) {
                i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changed(j)) ? 8192 : 16384;
            }
            if ((i & 458752) == 0) {
                contentColor = j2;
                if ((i2 & 32) == 0) {
                    i9 = 65536;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            } else {
                contentColor = j2;
            }
            if ((i & 3670016) == 0) {
                actionColor = j3;
                if ((i2 & 64) == 0) {
                    i8 = 524288;
                } else {
                    i8 = 524288;
                }
                i3 |= i8;
            } else {
                actionColor = j3;
            }
            if ((i & 29360128) != 0) {
                if ((i2 & 128) == 0) {
                    i7 = 4194304;
                } else {
                    i7 = 4194304;
                }
                i3 |= i7;
            }
            if ((i & 234881024) != 0) {
                if ((i2 & 256) == 0) {
                    i6 = 33554432;
                } else {
                    i6 = 33554432;
                }
                i3 |= i6;
            }
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        shape3 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        color = j;
                    }
                    if ((i2 & 32) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        actionColor = SnackbarDefaults.INSTANCE.getActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 = (-29360129) & i3;
                    } else {
                        actionContentColor = j4;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        j6 = actionContentColor;
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                    } else {
                        dismissActionContentColor = j5;
                        j6 = actionContentColor;
                    }
                } else {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        shape3 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        color = j;
                    }
                    if ((i2 & 32) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        actionColor = SnackbarDefaults.INSTANCE.getActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 = (-29360129) & i3;
                    } else {
                        actionContentColor = j4;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        j6 = actionContentColor;
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                    } else {
                        dismissActionContentColor = j5;
                        j6 = actionContentColor;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(274621471, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:197)");
                }
                actionLabel = snackbarData.getVisuals().getActionLabel();
                if (actionLabel != null) {
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1378313599, true, new SnackbarKt$Snackbar$actionComposable$1(actionColor, i3, snackbarData, actionLabel));
                } else {
                    composableLambda = null;
                }
                if (snackbarData.getVisuals().getWithDismissAction()) {
                    snackbarData2 = snackbarData;
                    composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1812633777, true, new SnackbarKt$Snackbar$dismissActionComposable$1(snackbarData2, i3));
                } else {
                    snackbarData2 = snackbarData;
                    composableLambda2 = null;
                }
                Modifier modifier7 = modifier3;
                int i15 = i3 << 3;
                m1763SnackbareQBnUkQ(PaddingKt.m485padding3ABfNKs(modifier3, Dp.m5160constructorimpl(12)), composableLambda, composableLambda2, z3, shape3, color, contentColor, j6, dismissActionContentColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1266389126, true, new SnackbarKt$Snackbar$3(snackbarData2)), composerStartRestartGroup, (i15 & 3670016) | (i15 & 7168) | 805306368 | (57344 & i15) | (458752 & i15) | (i3 & 29360128) | (i3 & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                actionColor = actionColor;
                z4 = z3;
                shape4 = shape3;
                modifier2 = modifier7;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        shape3 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        color = j;
                    }
                    if ((i2 & 32) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        actionColor = SnackbarDefaults.INSTANCE.getActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 = (-29360129) & i3;
                    } else {
                        actionContentColor = j4;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        j6 = actionContentColor;
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                    } else {
                        dismissActionContentColor = j5;
                        j6 = actionContentColor;
                    }
                } else {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        shape3 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        color = j;
                    }
                    if ((i2 & 32) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        actionColor = SnackbarDefaults.INSTANCE.getActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 = (-29360129) & i3;
                    } else {
                        actionContentColor = j4;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        j6 = actionContentColor;
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                    } else {
                        dismissActionContentColor = j5;
                        j6 = actionContentColor;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(274621471, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:197)");
                }
                actionLabel = snackbarData.getVisuals().getActionLabel();
                if (actionLabel != null) {
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1378313599, true, new SnackbarKt$Snackbar$actionComposable$1(actionColor, i3, snackbarData, actionLabel));
                } else {
                    composableLambda = null;
                }
                if (snackbarData.getVisuals().getWithDismissAction()) {
                    snackbarData2 = snackbarData;
                    composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1812633777, true, new SnackbarKt$Snackbar$dismissActionComposable$1(snackbarData2, i3));
                } else {
                    snackbarData2 = snackbarData;
                    composableLambda2 = null;
                }
                Modifier modifier8 = modifier3;
                int i16 = i3 << 3;
                m1763SnackbareQBnUkQ(PaddingKt.m485padding3ABfNKs(modifier3, Dp.m5160constructorimpl(12)), composableLambda, composableLambda2, z3, shape3, color, contentColor, j6, dismissActionContentColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1266389126, true, new SnackbarKt$Snackbar$3(snackbarData2)), composerStartRestartGroup, (i16 & 3670016) | (i16 & 7168) | 805306368 | (57344 & i16) | (458752 & i16) | (i3 & 29360128) | (i3 & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                actionColor = actionColor;
                z4 = z3;
                shape4 = shape3;
                modifier2 = modifier8;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$4(snackbarData, modifier2, z4, shape4, color, contentColor, actionColor, j6, dismissActionContentColor, i, i2));
        }
        i3 |= 384;
        z2 = z;
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i11;
            } else {
                shape2 = shape;
            }
            i3 |= i11;
        } else {
            shape2 = shape;
        }
        if ((i & 57344) != 0) {
            i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changed(j)) ? 8192 : 16384;
        }
        if ((i & 458752) == 0) {
            contentColor = j2;
            if ((i2 & 32) == 0) {
                i9 = 65536;
            } else {
                i9 = 65536;
            }
            i3 |= i9;
        } else {
            contentColor = j2;
        }
        if ((i & 3670016) == 0) {
            actionColor = j3;
            if ((i2 & 64) == 0) {
                i8 = 524288;
            } else {
                i8 = 524288;
            }
            i3 |= i8;
        } else {
            actionColor = j3;
        }
        if ((i & 29360128) != 0) {
            if ((i2 & 128) == 0) {
                i7 = 4194304;
            } else {
                i7 = 4194304;
            }
            i3 |= i7;
        }
        if ((i & 234881024) != 0) {
            if ((i2 & 256) == 0) {
                i6 = 33554432;
            } else {
                i6 = 33554432;
            }
            i3 |= i6;
        }
        if ((191739611 & i3) == 38347922) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = false;
                } else {
                    z3 = z2;
                }
                if ((i2 & 8) != 0) {
                    shape3 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i3 &= -7169;
                } else {
                    shape3 = shape2;
                }
                if ((i2 & 16) != 0) {
                    color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                } else {
                    color = j;
                }
                if ((i2 & 32) != 0) {
                    contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    actionColor = SnackbarDefaults.INSTANCE.getActionColor(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                    i3 = (-29360129) & i3;
                } else {
                    actionContentColor = j4;
                }
                if ((i2 & 256) != 0) {
                    i3 &= -234881025;
                    j6 = actionContentColor;
                    dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                } else {
                    dismissActionContentColor = j5;
                    j6 = actionContentColor;
                }
            } else {
                if (i10 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = false;
                } else {
                    z3 = z2;
                }
                if ((i2 & 8) != 0) {
                    shape3 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i3 &= -7169;
                } else {
                    shape3 = shape2;
                }
                if ((i2 & 16) != 0) {
                    color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                } else {
                    color = j;
                }
                if ((i2 & 32) != 0) {
                    contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    actionColor = SnackbarDefaults.INSTANCE.getActionColor(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                    i3 = (-29360129) & i3;
                } else {
                    actionContentColor = j4;
                }
                if ((i2 & 256) != 0) {
                    i3 &= -234881025;
                    j6 = actionContentColor;
                    dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                } else {
                    dismissActionContentColor = j5;
                    j6 = actionContentColor;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(274621471, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:197)");
            }
            actionLabel = snackbarData.getVisuals().getActionLabel();
            if (actionLabel != null) {
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1378313599, true, new SnackbarKt$Snackbar$actionComposable$1(actionColor, i3, snackbarData, actionLabel));
            } else {
                composableLambda = null;
            }
            if (snackbarData.getVisuals().getWithDismissAction()) {
                snackbarData2 = snackbarData;
                composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1812633777, true, new SnackbarKt$Snackbar$dismissActionComposable$1(snackbarData2, i3));
            } else {
                snackbarData2 = snackbarData;
                composableLambda2 = null;
            }
            Modifier modifier9 = modifier3;
            int i17 = i3 << 3;
            m1763SnackbareQBnUkQ(PaddingKt.m485padding3ABfNKs(modifier3, Dp.m5160constructorimpl(12)), composableLambda, composableLambda2, z3, shape3, color, contentColor, j6, dismissActionContentColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1266389126, true, new SnackbarKt$Snackbar$3(snackbarData2)), composerStartRestartGroup, (i17 & 3670016) | (i17 & 7168) | 805306368 | (57344 & i17) | (458752 & i17) | (i3 & 29360128) | (i3 & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            actionColor = actionColor;
            z4 = z3;
            shape4 = shape3;
            modifier2 = modifier9;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = false;
                } else {
                    z3 = z2;
                }
                if ((i2 & 8) != 0) {
                    shape3 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i3 &= -7169;
                } else {
                    shape3 = shape2;
                }
                if ((i2 & 16) != 0) {
                    color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                } else {
                    color = j;
                }
                if ((i2 & 32) != 0) {
                    contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    actionColor = SnackbarDefaults.INSTANCE.getActionColor(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                    i3 = (-29360129) & i3;
                } else {
                    actionContentColor = j4;
                }
                if ((i2 & 256) != 0) {
                    i3 &= -234881025;
                    j6 = actionContentColor;
                    dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                } else {
                    dismissActionContentColor = j5;
                    j6 = actionContentColor;
                }
            } else {
                if (i10 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = false;
                } else {
                    z3 = z2;
                }
                if ((i2 & 8) != 0) {
                    shape3 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i3 &= -7169;
                } else {
                    shape3 = shape2;
                }
                if ((i2 & 16) != 0) {
                    color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                } else {
                    color = j;
                }
                if ((i2 & 32) != 0) {
                    contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    actionColor = SnackbarDefaults.INSTANCE.getActionColor(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                    i3 = (-29360129) & i3;
                } else {
                    actionContentColor = j4;
                }
                if ((i2 & 256) != 0) {
                    i3 &= -234881025;
                    j6 = actionContentColor;
                    dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                } else {
                    dismissActionContentColor = j5;
                    j6 = actionContentColor;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(274621471, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:197)");
            }
            actionLabel = snackbarData.getVisuals().getActionLabel();
            if (actionLabel != null) {
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1378313599, true, new SnackbarKt$Snackbar$actionComposable$1(actionColor, i3, snackbarData, actionLabel));
            } else {
                composableLambda = null;
            }
            if (snackbarData.getVisuals().getWithDismissAction()) {
                snackbarData2 = snackbarData;
                composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1812633777, true, new SnackbarKt$Snackbar$dismissActionComposable$1(snackbarData2, i3));
            } else {
                snackbarData2 = snackbarData;
                composableLambda2 = null;
            }
            Modifier modifier10 = modifier3;
            int i18 = i3 << 3;
            m1763SnackbareQBnUkQ(PaddingKt.m485padding3ABfNKs(modifier3, Dp.m5160constructorimpl(12)), composableLambda, composableLambda2, z3, shape3, color, contentColor, j6, dismissActionContentColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1266389126, true, new SnackbarKt$Snackbar$3(snackbarData2)), composerStartRestartGroup, (i18 & 3670016) | (i18 & 7168) | 805306368 | (57344 & i18) | (458752 & i18) | (i3 & 29360128) | (i3 & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            actionColor = actionColor;
            z4 = z3;
            shape4 = shape3;
            modifier2 = modifier10;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new SnackbarKt$Snackbar$4(snackbarData, modifier2, z4, shape4, color, contentColor, actionColor, j6, dismissActionContentColor, i, i2));
    }
}
