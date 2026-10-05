package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutKt {
    private static final int MaxItemsToRetainForReuse = 7;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ LazyLayoutItemProvider $itemProvider;
        final /* synthetic */ InterfaceC0526Fp $measurePolicy;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ LazyLayoutPrefetchState $prefetchState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(LazyLayoutItemProvider lazyLayoutItemProvider, Modifier modifier, LazyLayoutPrefetchState lazyLayoutPrefetchState, InterfaceC0526Fp interfaceC0526Fp, int i, int i2) {
            super(2);
            this.$itemProvider = lazyLayoutItemProvider;
            this.$modifier = modifier;
            this.$prefetchState = lazyLayoutPrefetchState;
            this.$measurePolicy = interfaceC0526Fp;
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
            LazyLayoutKt.LazyLayout(this.$itemProvider, this.$modifier, this.$prefetchState, this.$measurePolicy, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ State<InterfaceC3588op> $currentItemProvider;
        final /* synthetic */ InterfaceC0526Fp $measurePolicy;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ LazyLayoutPrefetchState $prefetchState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(LazyLayoutPrefetchState lazyLayoutPrefetchState, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, int i, State<? extends InterfaceC3588op> state) {
            super(3);
            this.$prefetchState = lazyLayoutPrefetchState;
            this.$modifier = modifier;
            this.$measurePolicy = interfaceC0526Fp;
            this.$$dirty = i;
            this.$currentItemProvider = state;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((SaveableStateHolder) obj, (Composer) obj2, ((Number) obj3).intValue());
            return FW.a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(SaveableStateHolder saveableStateHolder, Composer composer, int i) {
            AbstractC4492zt.h(saveableStateHolder, "saveableStateHolder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1488997347, i, -1, "androidx.compose.foundation.lazy.layout.LazyLayout.<anonymous> (LazyLayout.kt:60)");
            }
            State<InterfaceC3588op> state = this.$currentItemProvider;
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new LazyLayoutItemContentFactory(saveableStateHolder, new LazyLayoutKt$LazyLayout$3$itemContentFactory$1$1(state));
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            LazyLayoutItemContentFactory lazyLayoutItemContentFactory = (LazyLayoutItemContentFactory) objRememberedValue;
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new SubcomposeLayoutState(new LazyLayoutItemReusePolicy(lazyLayoutItemContentFactory));
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            SubcomposeLayoutState subcomposeLayoutState = (SubcomposeLayoutState) objRememberedValue2;
            LazyLayoutPrefetchState lazyLayoutPrefetchState = this.$prefetchState;
            composer.startReplaceableGroup(-1523808190);
            if (lazyLayoutPrefetchState != null) {
                LazyLayoutPrefetcher_androidKt.LazyLayoutPrefetcher(this.$prefetchState, lazyLayoutItemContentFactory, subcomposeLayoutState, composer, ((this.$$dirty >> 6) & 14) | 64 | (SubcomposeLayoutState.$stable << 6));
                FW fw = FW.a;
            }
            composer.endReplaceableGroup();
            Modifier modifier = this.$modifier;
            InterfaceC0526Fp interfaceC0526Fp = this.$measurePolicy;
            composer.startReplaceableGroup(511388516);
            boolean zChanged = composer.changed(lazyLayoutItemContentFactory) | composer.changed(interfaceC0526Fp);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new LazyLayoutKt$LazyLayout$3$2$1(lazyLayoutItemContentFactory, interfaceC0526Fp);
                composer.updateRememberedValue(objRememberedValue3);
            }
            composer.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(subcomposeLayoutState, modifier, (InterfaceC0526Fp) objRememberedValue3, composer, SubcomposeLayoutState.$stable | (this.$$dirty & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC3588op $itemProvider;
        final /* synthetic */ InterfaceC0526Fp $measurePolicy;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ LazyLayoutPrefetchState $prefetchState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(InterfaceC3588op interfaceC3588op, Modifier modifier, LazyLayoutPrefetchState lazyLayoutPrefetchState, InterfaceC0526Fp interfaceC0526Fp, int i, int i2) {
            super(2);
            this.$itemProvider = interfaceC3588op;
            this.$modifier = modifier;
            this.$prefetchState = lazyLayoutPrefetchState;
            this.$measurePolicy = interfaceC0526Fp;
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
            LazyLayoutKt.LazyLayout(this.$itemProvider, this.$modifier, this.$prefetchState, this.$measurePolicy, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    @Composable
    @ExperimentalFoundationApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_]]")
    public static final void LazyLayout(LazyLayoutItemProvider lazyLayoutItemProvider, Modifier modifier, LazyLayoutPrefetchState lazyLayoutPrefetchState, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        int i3;
        AbstractC4492zt.h(lazyLayoutItemProvider, "itemProvider");
        AbstractC4492zt.h(interfaceC0526Fp, "measurePolicy");
        Composer composerStartRestartGroup = composer.startRestartGroup(852831187);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(lazyLayoutItemProvider) ? 4 : 2) | i;
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
            i3 |= composerStartRestartGroup.changed(lazyLayoutPrefetchState) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 2048 : 1024;
        }
        if ((i3 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (i5 != 0) {
                lazyLayoutPrefetchState = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(852831187, i3, -1, "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:41)");
            }
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed(lazyLayoutItemProvider);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new LazyLayoutKt$LazyLayout$1$1(lazyLayoutItemProvider);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            LazyLayout((InterfaceC3588op) objRememberedValue, modifier, lazyLayoutPrefetchState, interfaceC0526Fp, composerStartRestartGroup, i3 & 8176, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        Modifier modifier2 = modifier;
        LazyLayoutPrefetchState lazyLayoutPrefetchState2 = lazyLayoutPrefetchState;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(lazyLayoutItemProvider, modifier2, lazyLayoutPrefetchState2, interfaceC0526Fp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:26:0x004c  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:30:0x0055  */
    /* JADX WARN: Code duplicated, block: B:32:0x005d  */
    /* JADX WARN: Code duplicated, block: B:33:0x0060  */
    /* JADX WARN: Code duplicated, block: B:37:0x0067  */
    /* JADX WARN: Code duplicated, block: B:39:0x006b  */
    /* JADX WARN: Code duplicated, block: B:41:0x006f  */
    /* JADX WARN: Code duplicated, block: B:43:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x0078  */
    /* JADX WARN: Code duplicated, block: B:48:0x0082  */
    /* JADX WARN: Code duplicated, block: B:52:0x008f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x0091  */
    /* JADX WARN: Code duplicated, block: B:54:0x0095  */
    /* JADX WARN: Code duplicated, block: B:56:0x0098  */
    /* JADX WARN: Code duplicated, block: B:57:0x009b  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:63:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:68:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:70:? A[RETURN, SYNTHETIC] */
    @Composable
    @ExperimentalFoundationApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable:[androidx.compose.ui.UiComposable]]]")
    public static final void LazyLayout(InterfaceC3588op interfaceC3588op, Modifier modifier, LazyLayoutPrefetchState lazyLayoutPrefetchState, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        int i3;
        int i4;
        LazyLayoutPrefetchState lazyLayoutPrefetchState2;
        int i5;
        int i6;
        int i7;
        Modifier modifier2;
        LazyLayoutPrefetchState lazyLayoutPrefetchState3;
        Modifier modifier3;
        LazyLayoutPrefetchState lazyLayoutPrefetchState4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC3588op, "itemProvider");
        AbstractC4492zt.h(interfaceC0526Fp, "measurePolicy");
        Composer composerStartRestartGroup = composer.startRestartGroup(2002163445);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC3588op) ? 4 : 2) | i;
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
                    lazyLayoutPrefetchState2 = lazyLayoutPrefetchState;
                    if (composerStartRestartGroup.changed(lazyLayoutPrefetchState2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                } else if ((i & 7168) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i3 |= i6;
                }
                i7 = i3;
                if ((i7 & 5851) != 1170 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier;
                    lazyLayoutPrefetchState4 = lazyLayoutPrefetchState2;
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        lazyLayoutPrefetchState3 = null;
                    } else {
                        lazyLayoutPrefetchState3 = lazyLayoutPrefetchState2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2002163445, i7, -1, "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:52)");
                    }
                    LazySaveableStateHolderKt.LazySaveableStateHolderProvider(ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1488997347, true, new AnonymousClass3(lazyLayoutPrefetchState3, modifier2, interfaceC0526Fp, i7, SnapshotStateKt.rememberUpdatedState(interfaceC3588op, composerStartRestartGroup, i7 & 14))), composerStartRestartGroup, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    lazyLayoutPrefetchState4 = lazyLayoutPrefetchState3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier3, lazyLayoutPrefetchState4, interfaceC0526Fp, i, i2));
            }
            i3 |= 384;
            lazyLayoutPrefetchState2 = lazyLayoutPrefetchState;
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            i7 = i3;
            if ((i7 & 5851) != 1170) {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    lazyLayoutPrefetchState3 = null;
                } else {
                    lazyLayoutPrefetchState3 = lazyLayoutPrefetchState2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2002163445, i7, -1, "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:52)");
                }
                LazySaveableStateHolderKt.LazySaveableStateHolderProvider(ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1488997347, true, new AnonymousClass3(lazyLayoutPrefetchState3, modifier2, interfaceC0526Fp, i7, SnapshotStateKt.rememberUpdatedState(interfaceC3588op, composerStartRestartGroup, i7 & 14))), composerStartRestartGroup, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                lazyLayoutPrefetchState4 = lazyLayoutPrefetchState3;
            } else {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    lazyLayoutPrefetchState3 = null;
                } else {
                    lazyLayoutPrefetchState3 = lazyLayoutPrefetchState2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2002163445, i7, -1, "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:52)");
                }
                LazySaveableStateHolderKt.LazySaveableStateHolderProvider(ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1488997347, true, new AnonymousClass3(lazyLayoutPrefetchState3, modifier2, interfaceC0526Fp, i7, SnapshotStateKt.rememberUpdatedState(interfaceC3588op, composerStartRestartGroup, i7 & 14))), composerStartRestartGroup, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                lazyLayoutPrefetchState4 = lazyLayoutPrefetchState3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier3, lazyLayoutPrefetchState4, interfaceC0526Fp, i, i2));
        }
        i3 |= 48;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                lazyLayoutPrefetchState2 = lazyLayoutPrefetchState;
                if (composerStartRestartGroup.changed(lazyLayoutPrefetchState2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            i7 = i3;
            if ((i7 & 5851) != 1170) {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    lazyLayoutPrefetchState3 = null;
                } else {
                    lazyLayoutPrefetchState3 = lazyLayoutPrefetchState2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2002163445, i7, -1, "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:52)");
                }
                LazySaveableStateHolderKt.LazySaveableStateHolderProvider(ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1488997347, true, new AnonymousClass3(lazyLayoutPrefetchState3, modifier2, interfaceC0526Fp, i7, SnapshotStateKt.rememberUpdatedState(interfaceC3588op, composerStartRestartGroup, i7 & 14))), composerStartRestartGroup, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                lazyLayoutPrefetchState4 = lazyLayoutPrefetchState3;
            } else {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    lazyLayoutPrefetchState3 = null;
                } else {
                    lazyLayoutPrefetchState3 = lazyLayoutPrefetchState2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2002163445, i7, -1, "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:52)");
                }
                LazySaveableStateHolderKt.LazySaveableStateHolderProvider(ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1488997347, true, new AnonymousClass3(lazyLayoutPrefetchState3, modifier2, interfaceC0526Fp, i7, SnapshotStateKt.rememberUpdatedState(interfaceC3588op, composerStartRestartGroup, i7 & 14))), composerStartRestartGroup, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                lazyLayoutPrefetchState4 = lazyLayoutPrefetchState3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier3, lazyLayoutPrefetchState4, interfaceC0526Fp, i, i2));
        }
        i3 |= 384;
        lazyLayoutPrefetchState2 = lazyLayoutPrefetchState;
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i3 |= i6;
        }
        i7 = i3;
        if ((i7 & 5851) != 1170) {
            if (i8 != 0) {
                modifier2 = Modifier.Companion;
            } else {
                modifier2 = modifier;
            }
            if (i4 != 0) {
                lazyLayoutPrefetchState3 = null;
            } else {
                lazyLayoutPrefetchState3 = lazyLayoutPrefetchState2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2002163445, i7, -1, "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:52)");
            }
            LazySaveableStateHolderKt.LazySaveableStateHolderProvider(ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1488997347, true, new AnonymousClass3(lazyLayoutPrefetchState3, modifier2, interfaceC0526Fp, i7, SnapshotStateKt.rememberUpdatedState(interfaceC3588op, composerStartRestartGroup, i7 & 14))), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            lazyLayoutPrefetchState4 = lazyLayoutPrefetchState3;
        } else {
            if (i8 != 0) {
                modifier2 = Modifier.Companion;
            } else {
                modifier2 = modifier;
            }
            if (i4 != 0) {
                lazyLayoutPrefetchState3 = null;
            } else {
                lazyLayoutPrefetchState3 = lazyLayoutPrefetchState2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2002163445, i7, -1, "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:52)");
            }
            LazySaveableStateHolderKt.LazySaveableStateHolderProvider(ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1488997347, true, new AnonymousClass3(lazyLayoutPrefetchState3, modifier2, interfaceC0526Fp, i7, SnapshotStateKt.rememberUpdatedState(interfaceC3588op, composerStartRestartGroup, i7 & 14))), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            lazyLayoutPrefetchState4 = lazyLayoutPrefetchState3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier3, lazyLayoutPrefetchState4, interfaceC0526Fp, i, i2));
    }
}
