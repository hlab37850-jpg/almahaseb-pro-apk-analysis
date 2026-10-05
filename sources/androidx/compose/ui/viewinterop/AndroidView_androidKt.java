package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.view.View;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.UiComposable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.UiApplier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidView_androidKt {
    private static final InterfaceC3750qp NoOpUpdate = AndroidView_androidKt$NoOpUpdate$1.INSTANCE;

    /* JADX INFO: renamed from: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC3750qp $factory;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3750qp $update;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC3750qp interfaceC3750qp, Modifier modifier, InterfaceC3750qp interfaceC3750qp2, int i, int i2) {
            super(2);
            this.$factory = interfaceC3750qp;
            this.$modifier = modifier;
            this.$update = interfaceC3750qp2;
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
            AndroidView_androidKt.AndroidView(this.$factory, this.$modifier, this.$update, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC3750qp $factory;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3750qp $onRelease;
        final /* synthetic */ InterfaceC3750qp $onReset;
        final /* synthetic */ InterfaceC3750qp $update;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(InterfaceC3750qp interfaceC3750qp, Modifier modifier, InterfaceC3750qp interfaceC3750qp2, InterfaceC3750qp interfaceC3750qp3, InterfaceC3750qp interfaceC3750qp4, int i, int i2) {
            super(2);
            this.$factory = interfaceC3750qp;
            this.$modifier = modifier;
            this.$onReset = interfaceC3750qp2;
            this.$onRelease = interfaceC3750qp3;
            this.$update = interfaceC3750qp4;
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
            AndroidView_androidKt.AndroidView(this.$factory, this.$modifier, this.$onReset, this.$onRelease, this.$update, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.viewinterop.AndroidView_androidKt$createAndroidViewNodeFactory$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16691 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ int $compositeKeyHash;
        final /* synthetic */ Context $context;
        final /* synthetic */ InterfaceC3750qp $factory;
        final /* synthetic */ CompositionContext $parentReference;
        final /* synthetic */ SaveableStateRegistry $stateRegistry;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16691(Context context, InterfaceC3750qp interfaceC3750qp, CompositionContext compositionContext, SaveableStateRegistry saveableStateRegistry, int i) {
            super(0);
            this.$context = context;
            this.$factory = interfaceC3750qp;
            this.$parentReference = compositionContext;
            this.$stateRegistry = saveableStateRegistry;
            this.$compositeKeyHash = i;
        }

        @Override // defpackage.InterfaceC3588op
        public final LayoutNode invoke() {
            return new ViewFactoryHolder(this.$context, this.$factory, this.$parentReference, this.$stateRegistry, this.$compositeKeyHash).getLayoutNode();
        }
    }

    @Composable
    @UiComposable
    public static final <T extends View> void AndroidView(InterfaceC3750qp interfaceC3750qp, Modifier modifier, InterfaceC3750qp interfaceC3750qp2, Composer composer, int i, int i2) {
        int i3;
        AbstractC4492zt.h(interfaceC3750qp, "factory");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1783766393);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC3750qp) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC3750qp2) ? 256 : 128;
        }
        if ((i3 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (i5 != 0) {
                interfaceC3750qp2 = NoOpUpdate;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1783766393, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:100)");
            }
            AndroidView(interfaceC3750qp, modifier, null, NoOpUpdate, interfaceC3750qp2, composerStartRestartGroup, (i3 & 14) | 3072 | (i3 & 112) | ((i3 << 6) & 57344), 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        Modifier modifier2 = modifier;
        InterfaceC3750qp interfaceC3750qp3 = interfaceC3750qp2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(interfaceC3750qp, modifier2, interfaceC3750qp3, i, i2));
    }

    @Composable
    private static final <T extends View> InterfaceC3588op createAndroidViewNodeFactory(InterfaceC3750qp interfaceC3750qp, Composer composer, int i) {
        composer.startReplaceableGroup(2030558801);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2030558801, i, -1, "androidx.compose.ui.viewinterop.createAndroidViewNodeFactory (AndroidView.android.kt:261)");
        }
        C16691 c16691 = new C16691((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext()), interfaceC3750qp, ComposablesKt.rememberCompositionContext(composer, 0), (SaveableStateRegistry) composer.consume(SaveableStateRegistryKt.getLocalSaveableStateRegistry()), ComposablesKt.getCurrentCompositeKeyHash(composer, 0));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return c16691;
    }

    public static final InterfaceC3750qp getNoOpUpdate() {
        return NoOpUpdate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends View> ViewFactoryHolder<T> requireViewFactoryHolder(LayoutNode layoutNode) {
        AndroidViewHolder interopViewFactoryHolder$ui_release = layoutNode.getInteropViewFactoryHolder$ui_release();
        if (interopViewFactoryHolder$ui_release == null) {
            throw new IllegalStateException("Required value was null.");
        }
        AbstractC4492zt.f(interopViewFactoryHolder$ui_release, "null cannot be cast to non-null type androidx.compose.ui.viewinterop.ViewFactoryHolder<T of androidx.compose.ui.viewinterop.AndroidView_androidKt.requireViewFactoryHolder>");
        return (ViewFactoryHolder) interopViewFactoryHolder$ui_release;
    }

    /* JADX INFO: renamed from: updateViewHolderParams-6NefGtU, reason: not valid java name */
    private static final <T extends View> void m5401updateViewHolderParams6NefGtU(Composer composer, Modifier modifier, int i, Density density, LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner, LayoutDirection layoutDirection, CompositionLocalMap compositionLocalMap) {
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        Updater.m2668setimpl(composer, compositionLocalMap, companion.getSetResolvedCompositionLocals());
        Updater.m2668setimpl(composer, modifier, AndroidView_androidKt$updateViewHolderParams$1.INSTANCE);
        Updater.m2668setimpl(composer, density, AndroidView_androidKt$updateViewHolderParams$2.INSTANCE);
        Updater.m2668setimpl(composer, lifecycleOwner, AndroidView_androidKt$updateViewHolderParams$3.INSTANCE);
        Updater.m2668setimpl(composer, savedStateRegistryOwner, AndroidView_androidKt$updateViewHolderParams$4.INSTANCE);
        Updater.m2668setimpl(composer, layoutDirection, AndroidView_androidKt$updateViewHolderParams$5.INSTANCE);
        InterfaceC0526Fp setCompositeKeyHash = companion.getSetCompositeKeyHash();
        if (composer.getInserting() || !AbstractC4492zt.d(composer.rememberedValue(), Integer.valueOf(i))) {
            composer.updateRememberedValue(Integer.valueOf(i));
            composer.apply(Integer.valueOf(i), setCompositeKeyHash);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:102:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARN: Code duplicated, block: B:48:0x007e  */
    /* JADX WARN: Code duplicated, block: B:50:0x0083  */
    /* JADX WARN: Code duplicated, block: B:52:0x0089  */
    /* JADX WARN: Code duplicated, block: B:54:0x0091  */
    /* JADX WARN: Code duplicated, block: B:55:0x0094  */
    /* JADX WARN: Code duplicated, block: B:59:0x009f  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ae A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:72:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:75:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:78:0x010d  */
    /* JADX WARN: Code duplicated, block: B:80:0x0127  */
    /* JADX WARN: Code duplicated, block: B:83:0x0133  */
    /* JADX WARN: Code duplicated, block: B:84:0x013c  */
    /* JADX WARN: Code duplicated, block: B:86:0x0160  */
    /* JADX WARN: Code duplicated, block: B:88:0x017a  */
    /* JADX WARN: Code duplicated, block: B:91:0x0186  */
    /* JADX WARN: Code duplicated, block: B:92:0x018f  */
    /* JADX WARN: Code duplicated, block: B:96:0x01b3  */
    @Composable
    @UiComposable
    public static final <T extends View> void AndroidView(InterfaceC3750qp interfaceC3750qp, Modifier modifier, InterfaceC3750qp interfaceC3750qp2, InterfaceC3750qp interfaceC3750qp3, InterfaceC3750qp interfaceC3750qp4, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        InterfaceC3750qp interfaceC3750qp5;
        int i5;
        int i6;
        InterfaceC3750qp interfaceC3750qp6;
        int i7;
        int i8;
        InterfaceC3750qp interfaceC3750qp7;
        int i9;
        Modifier modifier3;
        int currentCompositeKeyHash;
        Modifier modifierMaterializeModifier;
        Density density;
        LayoutDirection layoutDirection;
        CompositionLocalMap currentCompositionLocalMap;
        LifecycleOwner lifecycleOwner;
        SavedStateRegistryOwner savedStateRegistryOwner;
        InterfaceC3588op interfaceC3588opCreateAndroidViewNodeFactory;
        InterfaceC3588op interfaceC3588opCreateAndroidViewNodeFactory2;
        InterfaceC3750qp interfaceC3750qp8;
        InterfaceC3750qp interfaceC3750qp9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC3750qp, "factory");
        Composer composerStartRestartGroup = composer.startRestartGroup(-180024211);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC3750qp) ? 4 : 2) | i;
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
                    interfaceC3750qp5 = interfaceC3750qp2;
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp5)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 7168) == 0) {
                        interfaceC3750qp6 = interfaceC3750qp3;
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp6)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((57344 & i) == 0) {
                            interfaceC3750qp7 = interfaceC3750qp4;
                            if (composerStartRestartGroup.changedInstance(interfaceC3750qp7)) {
                                i9 = 16384;
                            } else {
                                i9 = 8192;
                            }
                            i3 |= i9;
                        }
                        if ((46811 & i3) != 9362 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                        } else {
                            if (i10 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                interfaceC3750qp5 = null;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp6 = NoOpUpdate;
                            }
                            if (i8 != 0) {
                                interfaceC3750qp7 = NoOpUpdate;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                            }
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                            density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                            layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                            savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                            if (interfaceC3750qp5 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-88753439);
                                interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                                composerStartRestartGroup.startReplaceableGroup(1405779621);
                                if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composerStartRestartGroup.startReusableNode();
                                if (composerStartRestartGroup.getInserting()) {
                                    composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                                } else {
                                    composerStartRestartGroup.useNode();
                                }
                                Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                                m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                                Updater.m2668setimpl(composerM2661constructorimpl, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                                Updater.m2668setimpl(composerM2661constructorimpl, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                                Updater.m2668setimpl(composerM2661constructorimpl, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                                composerStartRestartGroup.endNode();
                                composerStartRestartGroup.endReplaceableGroup();
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-88752574);
                                interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                                composerStartRestartGroup.startReplaceableGroup(1886828752);
                                if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composerStartRestartGroup.startNode();
                                if (composerStartRestartGroup.getInserting()) {
                                    composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                                } else {
                                    composerStartRestartGroup.useNode();
                                }
                                Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
                                m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl2, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                                Updater.m2668setimpl(composerM2661constructorimpl2, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                                Updater.m2668setimpl(composerM2661constructorimpl2, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                                composerStartRestartGroup.endNode();
                                composerStartRestartGroup.endReplaceableGroup();
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        interfaceC3750qp8 = interfaceC3750qp5;
                        interfaceC3750qp9 = interfaceC3750qp7;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3750qp, modifier3, interfaceC3750qp8, interfaceC3750qp6, interfaceC3750qp9, i, i2));
                    }
                    i3 |= 24576;
                    interfaceC3750qp7 = interfaceC3750qp4;
                    if ((46811 & i3) != 9362) {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = null;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp6 = NoOpUpdate;
                        }
                        if (i8 != 0) {
                            interfaceC3750qp7 = NoOpUpdate;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                        }
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                        density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                        savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                        if (interfaceC3750qp5 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-88753439);
                            interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1405779621);
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM2661constructorimpl3 = Updater.m2661constructorimpl(composerStartRestartGroup);
                            m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl3, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m2668setimpl(composerM2661constructorimpl3, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl3, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl3, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-88752574);
                            interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1886828752);
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM2661constructorimpl4 = Updater.m2661constructorimpl(composerStartRestartGroup);
                            m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl4, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m2668setimpl(composerM2661constructorimpl4, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl4, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = null;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp6 = NoOpUpdate;
                        }
                        if (i8 != 0) {
                            interfaceC3750qp7 = NoOpUpdate;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                        }
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                        density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                        savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                        if (interfaceC3750qp5 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-88753439);
                            interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1405779621);
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM2661constructorimpl5 = Updater.m2661constructorimpl(composerStartRestartGroup);
                            m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl5, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m2668setimpl(composerM2661constructorimpl5, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl5, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl5, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-88752574);
                            interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1886828752);
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM2661constructorimpl6 = Updater.m2661constructorimpl(composerStartRestartGroup);
                            m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl6, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m2668setimpl(composerM2661constructorimpl6, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl6, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    interfaceC3750qp8 = interfaceC3750qp5;
                    interfaceC3750qp9 = interfaceC3750qp7;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3750qp, modifier3, interfaceC3750qp8, interfaceC3750qp6, interfaceC3750qp9, i, i2));
                }
                i3 |= 3072;
                interfaceC3750qp6 = interfaceC3750qp3;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((57344 & i) == 0) {
                        interfaceC3750qp7 = interfaceC3750qp4;
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp7)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((46811 & i3) != 9362) {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = null;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp6 = NoOpUpdate;
                        }
                        if (i8 != 0) {
                            interfaceC3750qp7 = NoOpUpdate;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                        }
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                        density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                        savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                        if (interfaceC3750qp5 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-88753439);
                            interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1405779621);
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM2661constructorimpl7 = Updater.m2661constructorimpl(composerStartRestartGroup);
                            m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl7, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m2668setimpl(composerM2661constructorimpl7, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl7, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl7, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-88752574);
                            interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1886828752);
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM2661constructorimpl8 = Updater.m2661constructorimpl(composerStartRestartGroup);
                            m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl8, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m2668setimpl(composerM2661constructorimpl8, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl8, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = null;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp6 = NoOpUpdate;
                        }
                        if (i8 != 0) {
                            interfaceC3750qp7 = NoOpUpdate;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                        }
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                        density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                        savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                        if (interfaceC3750qp5 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-88753439);
                            interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1405779621);
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM2661constructorimpl9 = Updater.m2661constructorimpl(composerStartRestartGroup);
                            m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl9, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m2668setimpl(composerM2661constructorimpl9, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl9, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl9, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-88752574);
                            interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1886828752);
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM2661constructorimpl10 = Updater.m2661constructorimpl(composerStartRestartGroup);
                            m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl10, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m2668setimpl(composerM2661constructorimpl10, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl10, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    interfaceC3750qp8 = interfaceC3750qp5;
                    interfaceC3750qp9 = interfaceC3750qp7;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3750qp, modifier3, interfaceC3750qp8, interfaceC3750qp6, interfaceC3750qp9, i, i2));
                }
                i3 |= 24576;
                interfaceC3750qp7 = interfaceC3750qp4;
                if ((46811 & i3) != 9362) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = null;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp6 = NoOpUpdate;
                    }
                    if (i8 != 0) {
                        interfaceC3750qp7 = NoOpUpdate;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                    }
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                    density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                    savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                    if (interfaceC3750qp5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-88753439);
                        interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1405779621);
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl11 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl11, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m2668setimpl(composerM2661constructorimpl11, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl11, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl11, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-88752574);
                        interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1886828752);
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl12 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl12, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m2668setimpl(composerM2661constructorimpl12, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl12, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = null;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp6 = NoOpUpdate;
                    }
                    if (i8 != 0) {
                        interfaceC3750qp7 = NoOpUpdate;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                    }
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                    density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                    savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                    if (interfaceC3750qp5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-88753439);
                        interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1405779621);
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl13 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl13, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m2668setimpl(composerM2661constructorimpl13, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl13, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl13, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-88752574);
                        interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1886828752);
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl14 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl14, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m2668setimpl(composerM2661constructorimpl14, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl14, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                interfaceC3750qp8 = interfaceC3750qp5;
                interfaceC3750qp9 = interfaceC3750qp7;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3750qp, modifier3, interfaceC3750qp8, interfaceC3750qp6, interfaceC3750qp9, i, i2));
            }
            i3 |= 384;
            interfaceC3750qp5 = interfaceC3750qp2;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    interfaceC3750qp6 = interfaceC3750qp3;
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp6)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((57344 & i) == 0) {
                        interfaceC3750qp7 = interfaceC3750qp4;
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp7)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((46811 & i3) != 9362) {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = null;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp6 = NoOpUpdate;
                        }
                        if (i8 != 0) {
                            interfaceC3750qp7 = NoOpUpdate;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                        }
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                        density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                        savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                        if (interfaceC3750qp5 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-88753439);
                            interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1405779621);
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM2661constructorimpl15 = Updater.m2661constructorimpl(composerStartRestartGroup);
                            m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl15, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m2668setimpl(composerM2661constructorimpl15, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl15, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl15, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-88752574);
                            interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1886828752);
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM2661constructorimpl16 = Updater.m2661constructorimpl(composerStartRestartGroup);
                            m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl16, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m2668setimpl(composerM2661constructorimpl16, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl16, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = null;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp6 = NoOpUpdate;
                        }
                        if (i8 != 0) {
                            interfaceC3750qp7 = NoOpUpdate;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                        }
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                        density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                        savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                        if (interfaceC3750qp5 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-88753439);
                            interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1405779621);
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM2661constructorimpl17 = Updater.m2661constructorimpl(composerStartRestartGroup);
                            m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl17, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m2668setimpl(composerM2661constructorimpl17, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl17, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl17, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-88752574);
                            interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1886828752);
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM2661constructorimpl18 = Updater.m2661constructorimpl(composerStartRestartGroup);
                            m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl18, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m2668setimpl(composerM2661constructorimpl18, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl18, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    interfaceC3750qp8 = interfaceC3750qp5;
                    interfaceC3750qp9 = interfaceC3750qp7;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3750qp, modifier3, interfaceC3750qp8, interfaceC3750qp6, interfaceC3750qp9, i, i2));
                }
                i3 |= 24576;
                interfaceC3750qp7 = interfaceC3750qp4;
                if ((46811 & i3) != 9362) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = null;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp6 = NoOpUpdate;
                    }
                    if (i8 != 0) {
                        interfaceC3750qp7 = NoOpUpdate;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                    }
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                    density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                    savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                    if (interfaceC3750qp5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-88753439);
                        interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1405779621);
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl19 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl19, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m2668setimpl(composerM2661constructorimpl19, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl19, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl19, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-88752574);
                        interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1886828752);
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl110 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl110, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m2668setimpl(composerM2661constructorimpl110, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl110, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = null;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp6 = NoOpUpdate;
                    }
                    if (i8 != 0) {
                        interfaceC3750qp7 = NoOpUpdate;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                    }
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                    density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                    savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                    if (interfaceC3750qp5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-88753439);
                        interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1405779621);
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl111 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl111, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m2668setimpl(composerM2661constructorimpl111, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl111, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl111, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-88752574);
                        interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1886828752);
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl112 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl112, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m2668setimpl(composerM2661constructorimpl112, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl112, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                interfaceC3750qp8 = interfaceC3750qp5;
                interfaceC3750qp9 = interfaceC3750qp7;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3750qp, modifier3, interfaceC3750qp8, interfaceC3750qp6, interfaceC3750qp9, i, i2));
            }
            i3 |= 3072;
            interfaceC3750qp6 = interfaceC3750qp3;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((57344 & i) == 0) {
                    interfaceC3750qp7 = interfaceC3750qp4;
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp7)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((46811 & i3) != 9362) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = null;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp6 = NoOpUpdate;
                    }
                    if (i8 != 0) {
                        interfaceC3750qp7 = NoOpUpdate;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                    }
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                    density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                    savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                    if (interfaceC3750qp5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-88753439);
                        interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1405779621);
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl113 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl113, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m2668setimpl(composerM2661constructorimpl113, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl113, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl113, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-88752574);
                        interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1886828752);
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl114 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl114, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m2668setimpl(composerM2661constructorimpl114, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl114, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = null;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp6 = NoOpUpdate;
                    }
                    if (i8 != 0) {
                        interfaceC3750qp7 = NoOpUpdate;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                    }
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                    density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                    savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                    if (interfaceC3750qp5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-88753439);
                        interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1405779621);
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl115 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl115, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m2668setimpl(composerM2661constructorimpl115, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl115, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl115, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-88752574);
                        interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1886828752);
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl116 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl116, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m2668setimpl(composerM2661constructorimpl116, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl116, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                interfaceC3750qp8 = interfaceC3750qp5;
                interfaceC3750qp9 = interfaceC3750qp7;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3750qp, modifier3, interfaceC3750qp8, interfaceC3750qp6, interfaceC3750qp9, i, i2));
            }
            i3 |= 24576;
            interfaceC3750qp7 = interfaceC3750qp4;
            if ((46811 & i3) != 9362) {
                if (i10 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    interfaceC3750qp5 = null;
                }
                if (i6 != 0) {
                    interfaceC3750qp6 = NoOpUpdate;
                }
                if (i8 != 0) {
                    interfaceC3750qp7 = NoOpUpdate;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                }
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                if (interfaceC3750qp5 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-88753439);
                    interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1405779621);
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl117 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl117, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m2668setimpl(composerM2661constructorimpl117, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl117, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl117, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-88752574);
                    interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1886828752);
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl118 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl118, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m2668setimpl(composerM2661constructorimpl118, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl118, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (i10 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    interfaceC3750qp5 = null;
                }
                if (i6 != 0) {
                    interfaceC3750qp6 = NoOpUpdate;
                }
                if (i8 != 0) {
                    interfaceC3750qp7 = NoOpUpdate;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                }
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                if (interfaceC3750qp5 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-88753439);
                    interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1405779621);
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl119 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl119, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m2668setimpl(composerM2661constructorimpl119, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl119, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl119, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-88752574);
                    interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1886828752);
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl1110 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl1110, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m2668setimpl(composerM2661constructorimpl1110, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl1110, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            interfaceC3750qp8 = interfaceC3750qp5;
            interfaceC3750qp9 = interfaceC3750qp7;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3750qp, modifier3, interfaceC3750qp8, interfaceC3750qp6, interfaceC3750qp9, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                interfaceC3750qp5 = interfaceC3750qp2;
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp5)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    interfaceC3750qp6 = interfaceC3750qp3;
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp6)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((57344 & i) == 0) {
                        interfaceC3750qp7 = interfaceC3750qp4;
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp7)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((46811 & i3) != 9362) {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = null;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp6 = NoOpUpdate;
                        }
                        if (i8 != 0) {
                            interfaceC3750qp7 = NoOpUpdate;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                        }
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                        density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                        savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                        if (interfaceC3750qp5 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-88753439);
                            interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1405779621);
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM2661constructorimpl1111 = Updater.m2661constructorimpl(composerStartRestartGroup);
                            m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl1111, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m2668setimpl(composerM2661constructorimpl1111, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl1111, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl1111, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-88752574);
                            interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1886828752);
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM2661constructorimpl1112 = Updater.m2661constructorimpl(composerStartRestartGroup);
                            m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl1112, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m2668setimpl(composerM2661constructorimpl1112, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl1112, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = null;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp6 = NoOpUpdate;
                        }
                        if (i8 != 0) {
                            interfaceC3750qp7 = NoOpUpdate;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                        }
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                        density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                        savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                        if (interfaceC3750qp5 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-88753439);
                            interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1405779621);
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM2661constructorimpl1113 = Updater.m2661constructorimpl(composerStartRestartGroup);
                            m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl1113, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m2668setimpl(composerM2661constructorimpl1113, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl1113, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl1113, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-88752574);
                            interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1886828752);
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM2661constructorimpl1114 = Updater.m2661constructorimpl(composerStartRestartGroup);
                            m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl1114, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m2668setimpl(composerM2661constructorimpl1114, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl1114, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    interfaceC3750qp8 = interfaceC3750qp5;
                    interfaceC3750qp9 = interfaceC3750qp7;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3750qp, modifier3, interfaceC3750qp8, interfaceC3750qp6, interfaceC3750qp9, i, i2));
                }
                i3 |= 24576;
                interfaceC3750qp7 = interfaceC3750qp4;
                if ((46811 & i3) != 9362) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = null;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp6 = NoOpUpdate;
                    }
                    if (i8 != 0) {
                        interfaceC3750qp7 = NoOpUpdate;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                    }
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                    density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                    savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                    if (interfaceC3750qp5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-88753439);
                        interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1405779621);
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl1115 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl1115, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m2668setimpl(composerM2661constructorimpl1115, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl1115, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl1115, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-88752574);
                        interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1886828752);
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl1116 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl1116, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m2668setimpl(composerM2661constructorimpl1116, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl1116, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = null;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp6 = NoOpUpdate;
                    }
                    if (i8 != 0) {
                        interfaceC3750qp7 = NoOpUpdate;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                    }
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                    density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                    savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                    if (interfaceC3750qp5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-88753439);
                        interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1405779621);
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl1117 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl1117, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m2668setimpl(composerM2661constructorimpl1117, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl1117, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl1117, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-88752574);
                        interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1886828752);
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl1118 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl1118, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m2668setimpl(composerM2661constructorimpl1118, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl1118, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                interfaceC3750qp8 = interfaceC3750qp5;
                interfaceC3750qp9 = interfaceC3750qp7;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3750qp, modifier3, interfaceC3750qp8, interfaceC3750qp6, interfaceC3750qp9, i, i2));
            }
            i3 |= 3072;
            interfaceC3750qp6 = interfaceC3750qp3;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((57344 & i) == 0) {
                    interfaceC3750qp7 = interfaceC3750qp4;
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp7)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((46811 & i3) != 9362) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = null;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp6 = NoOpUpdate;
                    }
                    if (i8 != 0) {
                        interfaceC3750qp7 = NoOpUpdate;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                    }
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                    density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                    savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                    if (interfaceC3750qp5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-88753439);
                        interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1405779621);
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl1119 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl1119, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m2668setimpl(composerM2661constructorimpl1119, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl1119, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl1119, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-88752574);
                        interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1886828752);
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl11110 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl11110, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m2668setimpl(composerM2661constructorimpl11110, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl11110, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = null;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp6 = NoOpUpdate;
                    }
                    if (i8 != 0) {
                        interfaceC3750qp7 = NoOpUpdate;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                    }
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                    density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                    savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                    if (interfaceC3750qp5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-88753439);
                        interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1405779621);
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl11111 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl11111, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m2668setimpl(composerM2661constructorimpl11111, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl11111, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl11111, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-88752574);
                        interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1886828752);
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl11112 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl11112, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m2668setimpl(composerM2661constructorimpl11112, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl11112, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                interfaceC3750qp8 = interfaceC3750qp5;
                interfaceC3750qp9 = interfaceC3750qp7;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3750qp, modifier3, interfaceC3750qp8, interfaceC3750qp6, interfaceC3750qp9, i, i2));
            }
            i3 |= 24576;
            interfaceC3750qp7 = interfaceC3750qp4;
            if ((46811 & i3) != 9362) {
                if (i10 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    interfaceC3750qp5 = null;
                }
                if (i6 != 0) {
                    interfaceC3750qp6 = NoOpUpdate;
                }
                if (i8 != 0) {
                    interfaceC3750qp7 = NoOpUpdate;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                }
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                if (interfaceC3750qp5 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-88753439);
                    interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1405779621);
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl11113 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl11113, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m2668setimpl(composerM2661constructorimpl11113, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl11113, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl11113, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-88752574);
                    interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1886828752);
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl11114 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl11114, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m2668setimpl(composerM2661constructorimpl11114, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl11114, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (i10 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    interfaceC3750qp5 = null;
                }
                if (i6 != 0) {
                    interfaceC3750qp6 = NoOpUpdate;
                }
                if (i8 != 0) {
                    interfaceC3750qp7 = NoOpUpdate;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                }
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                if (interfaceC3750qp5 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-88753439);
                    interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1405779621);
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl11115 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl11115, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m2668setimpl(composerM2661constructorimpl11115, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl11115, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl11115, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-88752574);
                    interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1886828752);
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl11116 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl11116, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m2668setimpl(composerM2661constructorimpl11116, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl11116, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            interfaceC3750qp8 = interfaceC3750qp5;
            interfaceC3750qp9 = interfaceC3750qp7;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3750qp, modifier3, interfaceC3750qp8, interfaceC3750qp6, interfaceC3750qp9, i, i2));
        }
        i3 |= 384;
        interfaceC3750qp5 = interfaceC3750qp2;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 7168) == 0) {
                interfaceC3750qp6 = interfaceC3750qp3;
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp6)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((57344 & i) == 0) {
                    interfaceC3750qp7 = interfaceC3750qp4;
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp7)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((46811 & i3) != 9362) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = null;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp6 = NoOpUpdate;
                    }
                    if (i8 != 0) {
                        interfaceC3750qp7 = NoOpUpdate;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                    }
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                    density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                    savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                    if (interfaceC3750qp5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-88753439);
                        interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1405779621);
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl11117 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl11117, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m2668setimpl(composerM2661constructorimpl11117, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl11117, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl11117, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-88752574);
                        interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1886828752);
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl11118 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl11118, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m2668setimpl(composerM2661constructorimpl11118, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl11118, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = null;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp6 = NoOpUpdate;
                    }
                    if (i8 != 0) {
                        interfaceC3750qp7 = NoOpUpdate;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                    }
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                    density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                    savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                    if (interfaceC3750qp5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-88753439);
                        interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1405779621);
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl11119 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl11119, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m2668setimpl(composerM2661constructorimpl11119, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl11119, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl11119, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-88752574);
                        interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1886828752);
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl111110 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl111110, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m2668setimpl(composerM2661constructorimpl111110, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl111110, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                interfaceC3750qp8 = interfaceC3750qp5;
                interfaceC3750qp9 = interfaceC3750qp7;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3750qp, modifier3, interfaceC3750qp8, interfaceC3750qp6, interfaceC3750qp9, i, i2));
            }
            i3 |= 24576;
            interfaceC3750qp7 = interfaceC3750qp4;
            if ((46811 & i3) != 9362) {
                if (i10 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    interfaceC3750qp5 = null;
                }
                if (i6 != 0) {
                    interfaceC3750qp6 = NoOpUpdate;
                }
                if (i8 != 0) {
                    interfaceC3750qp7 = NoOpUpdate;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                }
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                if (interfaceC3750qp5 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-88753439);
                    interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1405779621);
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl111111 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl111111, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m2668setimpl(composerM2661constructorimpl111111, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl111111, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl111111, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-88752574);
                    interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1886828752);
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl111112 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl111112, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m2668setimpl(composerM2661constructorimpl111112, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl111112, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (i10 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    interfaceC3750qp5 = null;
                }
                if (i6 != 0) {
                    interfaceC3750qp6 = NoOpUpdate;
                }
                if (i8 != 0) {
                    interfaceC3750qp7 = NoOpUpdate;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                }
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                if (interfaceC3750qp5 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-88753439);
                    interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1405779621);
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl111113 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl111113, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m2668setimpl(composerM2661constructorimpl111113, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl111113, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl111113, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-88752574);
                    interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1886828752);
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl111114 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl111114, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m2668setimpl(composerM2661constructorimpl111114, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl111114, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            interfaceC3750qp8 = interfaceC3750qp5;
            interfaceC3750qp9 = interfaceC3750qp7;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3750qp, modifier3, interfaceC3750qp8, interfaceC3750qp6, interfaceC3750qp9, i, i2));
        }
        i3 |= 3072;
        interfaceC3750qp6 = interfaceC3750qp3;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((57344 & i) == 0) {
                interfaceC3750qp7 = interfaceC3750qp4;
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp7)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((46811 & i3) != 9362) {
                if (i10 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    interfaceC3750qp5 = null;
                }
                if (i6 != 0) {
                    interfaceC3750qp6 = NoOpUpdate;
                }
                if (i8 != 0) {
                    interfaceC3750qp7 = NoOpUpdate;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                }
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                if (interfaceC3750qp5 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-88753439);
                    interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1405779621);
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl111115 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl111115, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m2668setimpl(composerM2661constructorimpl111115, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl111115, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl111115, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-88752574);
                    interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1886828752);
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl111116 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl111116, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m2668setimpl(composerM2661constructorimpl111116, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl111116, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (i10 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    interfaceC3750qp5 = null;
                }
                if (i6 != 0) {
                    interfaceC3750qp6 = NoOpUpdate;
                }
                if (i8 != 0) {
                    interfaceC3750qp7 = NoOpUpdate;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
                }
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                if (interfaceC3750qp5 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-88753439);
                    interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1405779621);
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl111117 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl111117, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m2668setimpl(composerM2661constructorimpl111117, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl111117, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl111117, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-88752574);
                    interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1886828752);
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl111118 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl111118, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m2668setimpl(composerM2661constructorimpl111118, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl111118, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            interfaceC3750qp8 = interfaceC3750qp5;
            interfaceC3750qp9 = interfaceC3750qp7;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3750qp, modifier3, interfaceC3750qp8, interfaceC3750qp6, interfaceC3750qp9, i, i2));
        }
        i3 |= 24576;
        interfaceC3750qp7 = interfaceC3750qp4;
        if ((46811 & i3) != 9362) {
            if (i10 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                interfaceC3750qp5 = null;
            }
            if (i6 != 0) {
                interfaceC3750qp6 = NoOpUpdate;
            }
            if (i8 != 0) {
                interfaceC3750qp7 = NoOpUpdate;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
            }
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
            density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
            savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
            if (interfaceC3750qp5 != null) {
                composerStartRestartGroup.startReplaceableGroup(-88753439);
                interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                composerStartRestartGroup.startReplaceableGroup(1405779621);
                if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM2661constructorimpl111119 = Updater.m2661constructorimpl(composerStartRestartGroup);
                m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl111119, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                Updater.m2668setimpl(composerM2661constructorimpl111119, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl111119, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl111119, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(-88752574);
                interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                composerStartRestartGroup.startReplaceableGroup(1886828752);
                if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM2661constructorimpl1111110 = Updater.m2661constructorimpl(composerStartRestartGroup);
                m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl1111110, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                Updater.m2668setimpl(composerM2661constructorimpl1111110, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl1111110, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            if (i10 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                interfaceC3750qp5 = null;
            }
            if (i6 != 0) {
                interfaceC3750qp6 = NoOpUpdate;
            }
            if (i8 != 0) {
                interfaceC3750qp7 = NoOpUpdate;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)");
            }
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
            density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
            savedStateRegistryOwner = (SavedStateRegistryOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
            if (interfaceC3750qp5 != null) {
                composerStartRestartGroup.startReplaceableGroup(-88753439);
                interfaceC3588opCreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                composerStartRestartGroup.startReplaceableGroup(1405779621);
                if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory2));
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM2661constructorimpl1111111 = Updater.m2661constructorimpl(composerStartRestartGroup);
                m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl1111111, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                Updater.m2668setimpl(composerM2661constructorimpl1111111, interfaceC3750qp5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl1111111, interfaceC3750qp7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl1111111, interfaceC3750qp6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(-88752574);
                interfaceC3588opCreateAndroidViewNodeFactory = createAndroidViewNodeFactory(interfaceC3750qp, composerStartRestartGroup, i3 & 14);
                composerStartRestartGroup.startReplaceableGroup(1886828752);
                if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(interfaceC3588opCreateAndroidViewNodeFactory));
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM2661constructorimpl1111112 = Updater.m2661constructorimpl(composerStartRestartGroup);
                m5401updateViewHolderParams6NefGtU(composerM2661constructorimpl1111112, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                Updater.m2668setimpl(composerM2661constructorimpl1111112, interfaceC3750qp7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl1111112, interfaceC3750qp6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        interfaceC3750qp8 = interfaceC3750qp5;
        interfaceC3750qp9 = interfaceC3750qp7;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3750qp, modifier3, interfaceC3750qp8, interfaceC3750qp6, interfaceC3750qp9, i, i2));
    }
}
