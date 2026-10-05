package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.material3.internal.ExposedDropdownMenuPopupKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalMaterial3Api
public interface ExposedDropdownMenuBoxScope {

    /* JADX INFO: renamed from: androidx.compose.material3.ExposedDropdownMenuBoxScope$-CC, reason: invalid class name */
    public abstract /* synthetic */ class CC {
        /* JADX WARN: Code duplicated, block: B:36:0x006b  */
        /* JADX WARN: Code duplicated, block: B:37:0x006e  */
        /* JADX WARN: Code duplicated, block: B:39:0x0072  */
        /* JADX WARN: Code duplicated, block: B:41:0x0078  */
        /* JADX WARN: Code duplicated, block: B:42:0x007b  */
        /* JADX WARN: Code duplicated, block: B:46:0x0082  */
        /* JADX WARN: Code duplicated, block: B:47:0x0087  */
        /* JADX WARN: Code duplicated, block: B:49:0x008f  */
        /* JADX WARN: Code duplicated, block: B:51:0x0095  */
        /* JADX WARN: Code duplicated, block: B:52:0x0098  */
        /* JADX WARN: Code duplicated, block: B:60:0x00b1 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:61:0x00b3  */
        /* JADX WARN: Code duplicated, block: B:62:0x00b8  */
        /* JADX WARN: Code duplicated, block: B:65:0x00c0  */
        /* JADX WARN: Code duplicated, block: B:68:0x00d8  */
        /* JADX WARN: Code duplicated, block: B:71:0x00fb  */
        /* JADX WARN: Code duplicated, block: B:75:0x010b  */
        /* JADX WARN: Code duplicated, block: B:77:0x0118  */
        /* JADX WARN: Code duplicated, block: B:80:0x0152  */
        /* JADX WARN: Code duplicated, block: B:82:0x0158  */
        /* JADX WARN: Code duplicated, block: B:86:0x019d  */
        /* JADX WARN: Code duplicated, block: B:91:0x01a9  */
        /* JADX WARN: Code duplicated, block: B:93:? A[RETURN, SYNTHETIC] */
        public static void a(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, boolean z, InterfaceC3588op interfaceC3588op, Modifier modifier, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
            int i3;
            Modifier modifier2;
            int i4;
            int i5;
            Modifier modifier3;
            Object objRememberedValue;
            Composer.Companion companion;
            MutableTransitionState mutableTransitionState;
            Object objRememberedValue2;
            MutableState mutableState;
            boolean zChanged;
            Object objRememberedValue3;
            Modifier modifier4;
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
            AbstractC4492zt.h(interfaceC3588op, "onDismissRequest");
            AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
            Composer composerStartRestartGroup = composer.startRestartGroup(-1658683708);
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
                i3 |= composerStartRestartGroup.changedInstance(interfaceC3588op) ? 32 : 16;
            }
            int i6 = i2 & 4;
            if (i6 == 0) {
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
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((57344 & i) == 0) {
                    if (composerStartRestartGroup.changed(exposedDropdownMenuBoxScope)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                if ((46811 & i3) == 9362 || !composerStartRestartGroup.getSkipping()) {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1658683708, i3, -1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:244)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = new MutableTransitionState(Boolean.FALSE);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableTransitionState = (MutableTransitionState) objRememberedValue;
                    mutableTransitionState.setTargetState(Boolean.valueOf(z));
                    if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue() || ((Boolean) mutableTransitionState.getTargetState()).booleanValue()) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m3381boximpl(TransformOrigin.Companion.m3394getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue2;
                        Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        long jM5231getZeroRKDOV3M = DpOffset.Companion.m5231getZeroRKDOV3M();
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(mutableState);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                            objRememberedValue3 = new ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1(mutableState);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(interfaceC3588op, new DropdownMenuPositionProvider(jM5231getZeroRKDOV3M, density, (InterfaceC0526Fp) objRememberedValue3, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 395026654, true, new AnonymousClass1(mutableTransitionState, mutableState, exposedDropdownMenuBoxScope, modifier3, interfaceC0552Gp, i3)), composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier4 = modifier2;
                    composerStartRestartGroup = composerStartRestartGroup;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(exposedDropdownMenuBoxScope.new AnonymousClass2(z, interfaceC3588op, modifier4, interfaceC0552Gp, i, i2));
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
            if ((i2 & 16) != 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                if (composerStartRestartGroup.changed(exposedDropdownMenuBoxScope)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((46811 & i3) == 9362) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1658683708, i3, -1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:244)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new MutableTransitionState(Boolean.FALSE);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableTransitionState = (MutableTransitionState) objRememberedValue;
                mutableTransitionState.setTargetState(Boolean.valueOf(z));
                if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m3381boximpl(TransformOrigin.Companion.m3394getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue2;
                    Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    long jM5231getZeroRKDOV3M2 = DpOffset.Companion.m5231getZeroRKDOV3M();
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(mutableState);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(interfaceC3588op, new DropdownMenuPositionProvider(jM5231getZeroRKDOV3M2, density2, (InterfaceC0526Fp) objRememberedValue3, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 395026654, true, new AnonymousClass1(mutableTransitionState, mutableState, exposedDropdownMenuBoxScope, modifier3, interfaceC0552Gp, i3)), composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 0);
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m3381boximpl(TransformOrigin.Companion.m3394getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue2;
                    Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    long jM5231getZeroRKDOV3M3 = DpOffset.Companion.m5231getZeroRKDOV3M();
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(mutableState);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(interfaceC3588op, new DropdownMenuPositionProvider(jM5231getZeroRKDOV3M3, density3, (InterfaceC0526Fp) objRememberedValue3, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 395026654, true, new AnonymousClass1(mutableTransitionState, mutableState, exposedDropdownMenuBoxScope, modifier3, interfaceC0552Gp, i3)), composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            } else {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1658683708, i3, -1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:244)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new MutableTransitionState(Boolean.FALSE);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableTransitionState = (MutableTransitionState) objRememberedValue;
                mutableTransitionState.setTargetState(Boolean.valueOf(z));
                if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m3381boximpl(TransformOrigin.Companion.m3394getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue2;
                    Density density4 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    long jM5231getZeroRKDOV3M4 = DpOffset.Companion.m5231getZeroRKDOV3M();
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(mutableState);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(interfaceC3588op, new DropdownMenuPositionProvider(jM5231getZeroRKDOV3M4, density4, (InterfaceC0526Fp) objRememberedValue3, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 395026654, true, new AnonymousClass1(mutableTransitionState, mutableState, exposedDropdownMenuBoxScope, modifier3, interfaceC0552Gp, i3)), composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 0);
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m3381boximpl(TransformOrigin.Companion.m3394getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue2;
                    Density density5 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    long jM5231getZeroRKDOV3M5 = DpOffset.Companion.m5231getZeroRKDOV3M();
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(mutableState);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(interfaceC3588op, new DropdownMenuPositionProvider(jM5231getZeroRKDOV3M5, density5, (InterfaceC0526Fp) objRememberedValue3, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 395026654, true, new AnonymousClass1(mutableTransitionState, mutableState, exposedDropdownMenuBoxScope, modifier3, interfaceC0552Gp, i3)), composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(exposedDropdownMenuBoxScope.new AnonymousClass2(z, interfaceC3588op, modifier4, interfaceC0552Gp, i, i2));
        }

        public static /* synthetic */ Modifier b(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            return exposedDropdownMenuBoxScope.exposedDropdownSize(modifier, z);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ MutableTransitionState<Boolean> $expandedStates;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ MutableState<TransformOrigin> $transformOriginState;
        final /* synthetic */ ExposedDropdownMenuBoxScope this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MutableTransitionState<Boolean> mutableTransitionState, MutableState<TransformOrigin> mutableState, ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, InterfaceC0552Gp interfaceC0552Gp, int i) {
            super(2);
            this.$expandedStates = mutableTransitionState;
            this.$transformOriginState = mutableState;
            this.this$0 = exposedDropdownMenuBoxScope;
            this.$modifier = modifier;
            this.$content = interfaceC0552Gp;
            this.$$dirty = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(395026654, i, -1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu.<anonymous> (ExposedDropdownMenu.kt:275)");
            }
            MenuKt.DropdownMenuContent(this.$expandedStates, this.$transformOriginState, CC.b(this.this$0, this.$modifier, false, 1, null), this.$content, composer, MutableTransitionState.$stable | 48 | (this.$$dirty & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ boolean $expanded;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3588op $onDismissRequest;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(boolean z, InterfaceC3588op interfaceC3588op, Modifier modifier, InterfaceC0552Gp interfaceC0552Gp, int i, int i2) {
            super(2);
            this.$expanded = z;
            this.$onDismissRequest = interfaceC3588op;
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
            ExposedDropdownMenuBoxScope.this.ExposedDropdownMenu(this.$expanded, this.$onDismissRequest, this.$modifier, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    void ExposedDropdownMenu(boolean z, InterfaceC3588op interfaceC3588op, Modifier modifier, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2);

    Modifier exposedDropdownSize(Modifier modifier, boolean z);

    Modifier menuAnchor(Modifier modifier);
}
