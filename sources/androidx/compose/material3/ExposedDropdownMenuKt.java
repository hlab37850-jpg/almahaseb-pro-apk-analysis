package androidx.compose.material3;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ExposedDropdownMenuKt {
    private static final float ExposedDropdownMenuItemHorizontalPadding = Dp.m5160constructorimpl(16);

    /* JADX INFO: renamed from: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ Ref<LayoutCoordinates> $coordinates;
        final /* synthetic */ MutableState<Integer> $menuHeight$delegate;
        final /* synthetic */ int $verticalMarginInPx;
        final /* synthetic */ View $view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(View view, Ref<LayoutCoordinates> ref, int i, MutableState<Integer> mutableState) {
            super(1);
            this.$view = view;
            this.$coordinates = ref;
            this.$verticalMarginInPx = i;
            this.$menuHeight$delegate = mutableState;
        }

        @Override // defpackage.InterfaceC3750qp
        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
            AbstractC4492zt.h(disposableEffectScope, "$this$DisposableEffect");
            View view = this.$view;
            final OnGlobalLayoutListener onGlobalLayoutListener = new OnGlobalLayoutListener(view, new ExposedDropdownMenuKt$ExposedDropdownMenuBox$3$listener$1(view, this.$coordinates, this.$verticalMarginInPx, this.$menuHeight$delegate));
            return new DisposableEffectResult() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$3$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    onGlobalLayoutListener.dispose();
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ boolean $expanded;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3750qp $onExpandedChange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(boolean z, InterfaceC3750qp interfaceC3750qp, Modifier modifier, InterfaceC0552Gp interfaceC0552Gp, int i, int i2) {
            super(2);
            this.$expanded = z;
            this.$onExpandedChange = interfaceC3750qp;
            this.$modifier = modifier;
            this.$content = interfaceC0552Gp;
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
            ExposedDropdownMenuKt.ExposedDropdownMenuBox(this.$expanded, this.$onExpandedChange, this.$modifier, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x006f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0073  */
    /* JADX WARN: Code duplicated, block: B:40:0x0077  */
    /* JADX WARN: Code duplicated, block: B:42:0x007d  */
    /* JADX WARN: Code duplicated, block: B:43:0x0080  */
    /* JADX WARN: Code duplicated, block: B:51:0x0098 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x009a  */
    /* JADX WARN: Code duplicated, block: B:53:0x009f  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:59:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:65:0x011b  */
    /* JADX WARN: Code duplicated, block: B:68:0x0136  */
    /* JADX WARN: Code duplicated, block: B:71:0x0174 A[LOOP:0: B:70:0x0172->B:71:0x0174, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:74:0x0185  */
    /* JADX WARN: Code duplicated, block: B:78:0x019b  */
    /* JADX WARN: Code duplicated, block: B:81:0x020e  */
    /* JADX WARN: Code duplicated, block: B:84:0x021a  */
    /* JADX WARN: Code duplicated, block: B:85:0x021e  */
    /* JADX WARN: Code duplicated, block: B:88:0x028d  */
    /* JADX WARN: Code duplicated, block: B:90:0x0295  */
    /* JADX WARN: Code duplicated, block: B:93:0x02be  */
    /* JADX WARN: Code duplicated, block: B:98:0x02ca  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void ExposedDropdownMenuBox(final boolean z, final InterfaceC3750qp interfaceC3750qp, Modifier modifier, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final int i5;
        Modifier modifier3;
        final Density density;
        final View view;
        Object objRememberedValue;
        Composer.Companion companion;
        final MutableState mutableState;
        Object objRememberedValue2;
        MutableState mutableState2;
        int iMo327roundToPx0680j_4;
        Object objRememberedValue3;
        final Ref ref;
        Object objRememberedValue4;
        final FocusRequester focusRequester;
        Object[] objArr;
        int i6;
        boolean zChanged;
        Object objRememberedValue5;
        final int i7;
        final MutableState mutableState3;
        View view2;
        Composer composer2;
        InterfaceC3588op constructor;
        boolean zChanged2;
        Object objRememberedValue6;
        Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC3750qp, "onExpandedChange");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-1990697039);
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
        int i8 = i2 & 4;
        if (i8 == 0) {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i4 = 2048;
                } else {
                    i4 = 1024;
                }
                i3 |= i4;
            }
            i5 = i3;
            if ((i5 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                if (i8 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1990697039, i5, -1, "androidx.compose.material3.ExposedDropdownMenuBox (ExposedDropdownMenu.kt:100)");
                }
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                view = (View) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState2 = (MutableState) objRememberedValue2;
                iMo327roundToPx0680j_4 = density.mo327roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new Ref();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                ref = (Ref) objRememberedValue3;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                focusRequester = (FocusRequester) objRememberedValue4;
                objArr = new Object[]{Boolean.valueOf(z), interfaceC3750qp, density, Integer.valueOf(ExposedDropdownMenuBox$lambda$4(mutableState2)), Integer.valueOf(ExposedDropdownMenuBox$lambda$1(mutableState))};
                composerStartRestartGroup.startReplaceableGroup(-568225417);
                i6 = 0;
                zChanged = false;
                for (int i9 = 5; i6 < i9; i9 = 5) {
                    zChanged |= composerStartRestartGroup.changed(objArr[i6]);
                    i6++;
                }
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue5 == Composer.Companion.getEmpty()) {
                    i7 = iMo327roundToPx0680j_4;
                    mutableState3 = mutableState2;
                    view2 = view;
                    composer2 = composerStartRestartGroup;
                    Object obj = new ExposedDropdownMenuBoxScope() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1
                        @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                        public /* synthetic */ void ExposedDropdownMenu(boolean z2, InterfaceC3588op interfaceC3588op, Modifier modifier5, InterfaceC0552Gp interfaceC0552Gp2, Composer composer3, int i10, int i11) {
                            ExposedDropdownMenuBoxScope.CC.a(this, z2, interfaceC3588op, modifier5, interfaceC0552Gp2, composer3, i10, i11);
                        }

                        @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                        public Modifier exposedDropdownSize(Modifier modifier5, boolean z2) {
                            AbstractC4492zt.h(modifier5, "<this>");
                            Density density2 = density;
                            MutableState<Integer> mutableState4 = mutableState3;
                            MutableState<Integer> mutableState5 = mutableState;
                            Modifier modifierM520heightInVpY3zN4$default = SizeKt.m520heightInVpY3zN4$default(modifier5, 0.0f, density2.mo330toDpu2uoSUM(ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$4(mutableState4)), 1, null);
                            return z2 ? SizeKt.m537width3ABfNKs(modifierM520heightInVpY3zN4$default, density2.mo330toDpu2uoSUM(ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$1(mutableState5))) : modifierM520heightInVpY3zN4$default;
                        }

                        @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                        public Modifier menuAnchor(Modifier modifier5) {
                            AbstractC4492zt.h(modifier5, "<this>");
                            return ComposedModifierKt.composed(modifier5, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2(z, interfaceC3750qp, i5, focusRequester, ref, view, i7, mutableState, mutableState3));
                        }
                    };
                    composer2.updateRememberedValue(obj);
                    objRememberedValue5 = obj;
                } else {
                    i7 = iMo327roundToPx0680j_4;
                    mutableState3 = mutableState2;
                    view2 = view;
                    composer2 = composerStartRestartGroup;
                }
                composer2.endReplaceableGroup();
                Object obj2 = (ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1) objRememberedValue5;
                int i10 = i5 >> 6;
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                constructor = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifier3);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composer2);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, density2, companion2.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
                composer2.enableReusing();
                interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                interfaceC0552Gp.invoke(obj2, composer2, Integer.valueOf(i10 & 112));
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                Boolean boolValueOf = Boolean.valueOf(z);
                composer2.startReplaceableGroup(511388516);
                zChanged2 = composer2.changed(boolValueOf) | composer2.changed(focusRequester);
                objRememberedValue6 = composer2.rememberedValue();
                if (zChanged2 || objRememberedValue6 == Composer.Companion.getEmpty()) {
                    objRememberedValue6 = new ExposedDropdownMenuKt$ExposedDropdownMenuBox$2$1(z, focusRequester);
                    composer2.updateRememberedValue(objRememberedValue6);
                }
                composer2.endReplaceableGroup();
                EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue6, composer2, 0);
                View view3 = view2;
                EffectsKt.DisposableEffect(view3, new AnonymousClass3(view3, ref, i7, mutableState3), composer2, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier4 = modifier2;
                composer2 = composerStartRestartGroup;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(z, interfaceC3750qp, modifier4, interfaceC0552Gp, i, i2));
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                i4 = 2048;
            } else {
                i4 = 1024;
            }
            i3 |= i4;
        }
        i5 = i3;
        if ((i5 & 5851) == 1170) {
            if (i8 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1990697039, i5, -1, "androidx.compose.material3.ExposedDropdownMenuBox (ExposedDropdownMenu.kt:100)");
            }
            density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            view = (View) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableState = (MutableState) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableState2 = (MutableState) objRememberedValue2;
            iMo327roundToPx0680j_4 = density.mo327roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new Ref();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            ref = (Ref) objRememberedValue3;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new FocusRequester();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            composerStartRestartGroup.endReplaceableGroup();
            focusRequester = (FocusRequester) objRememberedValue4;
            objArr = new Object[]{Boolean.valueOf(z), interfaceC3750qp, density, Integer.valueOf(ExposedDropdownMenuBox$lambda$4(mutableState2)), Integer.valueOf(ExposedDropdownMenuBox$lambda$1(mutableState))};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            i6 = 0;
            zChanged = false;
            while (i6 < i9) {
                zChanged |= composerStartRestartGroup.changed(objArr[i6]);
                i6++;
            }
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                i7 = iMo327roundToPx0680j_4;
                mutableState3 = mutableState2;
                view2 = view;
                composer2 = composerStartRestartGroup;
                Object obj3 = new ExposedDropdownMenuBoxScope() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1
                    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                    public /* synthetic */ void ExposedDropdownMenu(boolean z2, InterfaceC3588op interfaceC3588op, Modifier modifier5, InterfaceC0552Gp interfaceC0552Gp2, Composer composer3, int i11, int i12) {
                        ExposedDropdownMenuBoxScope.CC.a(this, z2, interfaceC3588op, modifier5, interfaceC0552Gp2, composer3, i11, i12);
                    }

                    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                    public Modifier exposedDropdownSize(Modifier modifier5, boolean z2) {
                        AbstractC4492zt.h(modifier5, "<this>");
                        Density density3 = density;
                        MutableState<Integer> mutableState4 = mutableState3;
                        MutableState<Integer> mutableState5 = mutableState;
                        Modifier modifierM520heightInVpY3zN4$default = SizeKt.m520heightInVpY3zN4$default(modifier5, 0.0f, density3.mo330toDpu2uoSUM(ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$4(mutableState4)), 1, null);
                        return z2 ? SizeKt.m537width3ABfNKs(modifierM520heightInVpY3zN4$default, density3.mo330toDpu2uoSUM(ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$1(mutableState5))) : modifierM520heightInVpY3zN4$default;
                    }

                    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                    public Modifier menuAnchor(Modifier modifier5) {
                        AbstractC4492zt.h(modifier5, "<this>");
                        return ComposedModifierKt.composed(modifier5, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2(z, interfaceC3750qp, i5, focusRequester, ref, view, i7, mutableState, mutableState3));
                    }
                };
                composer2.updateRememberedValue(obj3);
                objRememberedValue5 = obj3;
            } else {
                i7 = iMo327roundToPx0680j_4;
                mutableState3 = mutableState2;
                view2 = view;
                composer2 = composerStartRestartGroup;
                Object obj4 = new ExposedDropdownMenuBoxScope() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1
                    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                    public /* synthetic */ void ExposedDropdownMenu(boolean z2, InterfaceC3588op interfaceC3588op, Modifier modifier5, InterfaceC0552Gp interfaceC0552Gp2, Composer composer3, int i11, int i12) {
                        ExposedDropdownMenuBoxScope.CC.a(this, z2, interfaceC3588op, modifier5, interfaceC0552Gp2, composer3, i11, i12);
                    }

                    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                    public Modifier exposedDropdownSize(Modifier modifier5, boolean z2) {
                        AbstractC4492zt.h(modifier5, "<this>");
                        Density density3 = density;
                        MutableState<Integer> mutableState4 = mutableState3;
                        MutableState<Integer> mutableState5 = mutableState;
                        Modifier modifierM520heightInVpY3zN4$default = SizeKt.m520heightInVpY3zN4$default(modifier5, 0.0f, density3.mo330toDpu2uoSUM(ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$4(mutableState4)), 1, null);
                        return z2 ? SizeKt.m537width3ABfNKs(modifierM520heightInVpY3zN4$default, density3.mo330toDpu2uoSUM(ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$1(mutableState5))) : modifierM520heightInVpY3zN4$default;
                    }

                    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                    public Modifier menuAnchor(Modifier modifier5) {
                        AbstractC4492zt.h(modifier5, "<this>");
                        return ComposedModifierKt.composed(modifier5, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2(z, interfaceC3750qp, i5, focusRequester, ref, view, i7, mutableState, mutableState3));
                    }
                };
                composer2.updateRememberedValue(obj4);
                objRememberedValue5 = obj4;
            }
            composer2.endReplaceableGroup();
            Object obj5 = (ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1) objRememberedValue5;
            int i11 = i5 >> 6;
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            Density density3 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            constructor = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(modifier3);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composer2);
            Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl2, density3, companion3.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion3.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion3.getSetViewConfiguration());
            composer2.enableReusing();
            interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            interfaceC0552Gp.invoke(obj5, composer2, Integer.valueOf(i11 & 112));
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            Boolean boolValueOf2 = Boolean.valueOf(z);
            composer2.startReplaceableGroup(511388516);
            zChanged2 = composer2.changed(boolValueOf2) | composer2.changed(focusRequester);
            objRememberedValue6 = composer2.rememberedValue();
            if (zChanged2) {
                objRememberedValue6 = new ExposedDropdownMenuKt$ExposedDropdownMenuBox$2$1(z, focusRequester);
                composer2.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new ExposedDropdownMenuKt$ExposedDropdownMenuBox$2$1(z, focusRequester);
                composer2.updateRememberedValue(objRememberedValue6);
            }
            composer2.endReplaceableGroup();
            EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue6, composer2, 0);
            View view4 = view2;
            EffectsKt.DisposableEffect(view4, new AnonymousClass3(view4, ref, i7, mutableState3), composer2, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
        } else {
            if (i8 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1990697039, i5, -1, "androidx.compose.material3.ExposedDropdownMenuBox (ExposedDropdownMenu.kt:100)");
            }
            density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            view = (View) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableState = (MutableState) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableState2 = (MutableState) objRememberedValue2;
            iMo327roundToPx0680j_4 = density.mo327roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new Ref();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            ref = (Ref) objRememberedValue3;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new FocusRequester();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            composerStartRestartGroup.endReplaceableGroup();
            focusRequester = (FocusRequester) objRememberedValue4;
            objArr = new Object[]{Boolean.valueOf(z), interfaceC3750qp, density, Integer.valueOf(ExposedDropdownMenuBox$lambda$4(mutableState2)), Integer.valueOf(ExposedDropdownMenuBox$lambda$1(mutableState))};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            i6 = 0;
            zChanged = false;
            while (i6 < i9) {
                zChanged |= composerStartRestartGroup.changed(objArr[i6]);
                i6++;
            }
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                i7 = iMo327roundToPx0680j_4;
                mutableState3 = mutableState2;
                view2 = view;
                composer2 = composerStartRestartGroup;
                Object obj6 = new ExposedDropdownMenuBoxScope() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1
                    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                    public /* synthetic */ void ExposedDropdownMenu(boolean z2, InterfaceC3588op interfaceC3588op, Modifier modifier5, InterfaceC0552Gp interfaceC0552Gp2, Composer composer3, int i12, int i13) {
                        ExposedDropdownMenuBoxScope.CC.a(this, z2, interfaceC3588op, modifier5, interfaceC0552Gp2, composer3, i12, i13);
                    }

                    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                    public Modifier exposedDropdownSize(Modifier modifier5, boolean z2) {
                        AbstractC4492zt.h(modifier5, "<this>");
                        Density density4 = density;
                        MutableState<Integer> mutableState4 = mutableState3;
                        MutableState<Integer> mutableState5 = mutableState;
                        Modifier modifierM520heightInVpY3zN4$default = SizeKt.m520heightInVpY3zN4$default(modifier5, 0.0f, density4.mo330toDpu2uoSUM(ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$4(mutableState4)), 1, null);
                        return z2 ? SizeKt.m537width3ABfNKs(modifierM520heightInVpY3zN4$default, density4.mo330toDpu2uoSUM(ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$1(mutableState5))) : modifierM520heightInVpY3zN4$default;
                    }

                    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                    public Modifier menuAnchor(Modifier modifier5) {
                        AbstractC4492zt.h(modifier5, "<this>");
                        return ComposedModifierKt.composed(modifier5, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2(z, interfaceC3750qp, i5, focusRequester, ref, view, i7, mutableState, mutableState3));
                    }
                };
                composer2.updateRememberedValue(obj6);
                objRememberedValue5 = obj6;
            } else {
                i7 = iMo327roundToPx0680j_4;
                mutableState3 = mutableState2;
                view2 = view;
                composer2 = composerStartRestartGroup;
                Object obj7 = new ExposedDropdownMenuBoxScope() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1
                    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                    public /* synthetic */ void ExposedDropdownMenu(boolean z2, InterfaceC3588op interfaceC3588op, Modifier modifier5, InterfaceC0552Gp interfaceC0552Gp2, Composer composer3, int i12, int i13) {
                        ExposedDropdownMenuBoxScope.CC.a(this, z2, interfaceC3588op, modifier5, interfaceC0552Gp2, composer3, i12, i13);
                    }

                    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                    public Modifier exposedDropdownSize(Modifier modifier5, boolean z2) {
                        AbstractC4492zt.h(modifier5, "<this>");
                        Density density4 = density;
                        MutableState<Integer> mutableState4 = mutableState3;
                        MutableState<Integer> mutableState5 = mutableState;
                        Modifier modifierM520heightInVpY3zN4$default = SizeKt.m520heightInVpY3zN4$default(modifier5, 0.0f, density4.mo330toDpu2uoSUM(ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$4(mutableState4)), 1, null);
                        return z2 ? SizeKt.m537width3ABfNKs(modifierM520heightInVpY3zN4$default, density4.mo330toDpu2uoSUM(ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$1(mutableState5))) : modifierM520heightInVpY3zN4$default;
                    }

                    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                    public Modifier menuAnchor(Modifier modifier5) {
                        AbstractC4492zt.h(modifier5, "<this>");
                        return ComposedModifierKt.composed(modifier5, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2(z, interfaceC3750qp, i5, focusRequester, ref, view, i7, mutableState, mutableState3));
                    }
                };
                composer2.updateRememberedValue(obj7);
                objRememberedValue5 = obj7;
            }
            composer2.endReplaceableGroup();
            Object obj8 = (ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1) objRememberedValue5;
            int i12 = i5 >> 6;
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            Density density4 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion4 = ComposeUiNode.Companion;
            constructor = companion4.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf3 = LayoutKt.materializerOf(modifier3);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer composerM2661constructorimpl3 = Updater.m2661constructorimpl(composer2);
            Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyRememberBoxMeasurePolicy3, companion4.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl3, density4, companion4.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl3, layoutDirection3, companion4.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl3, viewConfiguration3, companion4.getSetViewConfiguration());
            composer2.enableReusing();
            interfaceC0552GpMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            interfaceC0552Gp.invoke(obj8, composer2, Integer.valueOf(i12 & 112));
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            Boolean boolValueOf3 = Boolean.valueOf(z);
            composer2.startReplaceableGroup(511388516);
            zChanged2 = composer2.changed(boolValueOf3) | composer2.changed(focusRequester);
            objRememberedValue6 = composer2.rememberedValue();
            if (zChanged2) {
                objRememberedValue6 = new ExposedDropdownMenuKt$ExposedDropdownMenuBox$2$1(z, focusRequester);
                composer2.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new ExposedDropdownMenuKt$ExposedDropdownMenuBox$2$1(z, focusRequester);
                composer2.updateRememberedValue(objRememberedValue6);
            }
            composer2.endReplaceableGroup();
            EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue6, composer2, 0);
            View view5 = view2;
            EffectsKt.DisposableEffect(view5, new AnonymousClass3(view5, ref, i7, mutableState3), composer2, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(z, interfaceC3750qp, modifier4, interfaceC0552Gp, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$1(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ExposedDropdownMenuBox$lambda$2(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$4(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ExposedDropdownMenuBox$lambda$5(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r11v5 ??, still in use, count: 1, list:
          (r11v5 ?? I:java.lang.Object) from 0x00bd: INVOKE (r20v0 ?? I:androidx.compose.runtime.Composer), (r11v5 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:190)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    @androidx.compose.runtime.Composable
    public static final androidx.compose.ui.Modifier expandable(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r11v5 ??, still in use, count: 1, list:
          (r11v5 ?? I:java.lang.Object) from 0x00bd: INVOKE (r20v0 ?? I:androidx.compose.runtime.Composer), (r11v5 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:190)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r14v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateHeight(View view, LayoutCoordinates layoutCoordinates, int i, InterfaceC3750qp interfaceC3750qp) {
        if (layoutCoordinates == null) {
            return;
        }
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        float top = LayoutCoordinatesKt.boundsInWindow(layoutCoordinates).getTop();
        int i2 = rect.top;
        interfaceC3750qp.invoke(Integer.valueOf(((int) Math.max(top - i2, (rect.bottom - i2) - LayoutCoordinatesKt.boundsInWindow(layoutCoordinates).getBottom())) - i));
    }
}
