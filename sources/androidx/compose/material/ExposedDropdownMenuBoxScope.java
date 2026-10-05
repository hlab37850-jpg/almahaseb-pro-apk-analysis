package androidx.compose.material;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.material.internal.ExposedDropdownMenuPopupKt;
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
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalMaterialApi
public interface ExposedDropdownMenuBoxScope {

    /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuBoxScope$-CC, reason: invalid class name */
    public abstract /* synthetic */ class CC {
        /* JADX WARN: Code duplicated, block: B:100:0x015a  */
        /* JADX WARN: Code duplicated, block: B:102:0x0167  */
        /* JADX WARN: Code duplicated, block: B:105:0x01a0  */
        /* JADX WARN: Code duplicated, block: B:107:0x01a6  */
        /* JADX WARN: Code duplicated, block: B:111:0x01f0  */
        /* JADX WARN: Code duplicated, block: B:116:0x01fe  */
        /* JADX WARN: Code duplicated, block: B:118:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:36:0x006b  */
        /* JADX WARN: Code duplicated, block: B:38:0x006f  */
        /* JADX WARN: Code duplicated, block: B:40:0x0077  */
        /* JADX WARN: Code duplicated, block: B:41:0x007a  */
        /* JADX WARN: Code duplicated, block: B:44:0x0080  */
        /* JADX WARN: Code duplicated, block: B:47:0x0086  */
        /* JADX WARN: Code duplicated, block: B:48:0x0089  */
        /* JADX WARN: Code duplicated, block: B:50:0x008f  */
        /* JADX WARN: Code duplicated, block: B:52:0x0095  */
        /* JADX WARN: Code duplicated, block: B:53:0x0098  */
        /* JADX WARN: Code duplicated, block: B:57:0x009f  */
        /* JADX WARN: Code duplicated, block: B:58:0x00a5  */
        /* JADX WARN: Code duplicated, block: B:60:0x00ac  */
        /* JADX WARN: Code duplicated, block: B:62:0x00b2  */
        /* JADX WARN: Code duplicated, block: B:63:0x00b5  */
        /* JADX WARN: Code duplicated, block: B:71:0x00d0  */
        /* JADX WARN: Code duplicated, block: B:73:0x00d8  */
        /* JADX WARN: Code duplicated, block: B:81:0x00ed A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:82:0x00ef  */
        /* JADX WARN: Code duplicated, block: B:83:0x00f2  */
        /* JADX WARN: Code duplicated, block: B:86:0x00f7  */
        /* JADX WARN: Code duplicated, block: B:87:0x0103  */
        /* JADX WARN: Code duplicated, block: B:90:0x010f  */
        /* JADX WARN: Code duplicated, block: B:93:0x0127  */
        /* JADX WARN: Code duplicated, block: B:96:0x014a  */
        public static void a(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, boolean z, InterfaceC3588op interfaceC3588op, Modifier modifier, ScrollState scrollState, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
            int i3;
            Modifier modifier2;
            ScrollState scrollState2;
            int i4;
            int i5;
            Modifier modifier3;
            Modifier modifier4;
            ScrollState scrollStateRememberScrollState;
            Object objRememberedValue;
            Composer.Companion companion;
            MutableTransitionState mutableTransitionState;
            Object objRememberedValue2;
            MutableState mutableState;
            boolean zChanged;
            Object objRememberedValue3;
            Modifier modifier5;
            ScrollState scrollState3;
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
            AbstractC4492zt.h(interfaceC3588op, "onDismissRequest");
            AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
            Composer composerStartRestartGroup = composer.startRestartGroup(1081438217);
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
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        scrollState2 = scrollState;
                        int i7 = composerStartRestartGroup.changed(scrollState2) ? 2048 : 1024;
                        i3 |= i7;
                    } else {
                        scrollState2 = scrollState;
                    }
                    i3 |= i7;
                } else {
                    scrollState2 = scrollState;
                }
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((57344 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i4 = 16384;
                    } else {
                        i4 = 8192;
                    }
                    i3 |= i4;
                }
                if ((i2 & 32) != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changed(exposedDropdownMenuBoxScope)) {
                        i5 = 131072;
                    } else {
                        i5 = 65536;
                    }
                    i3 |= i5;
                }
                if ((374491 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i6 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            modifier4 = modifier3;
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        } else {
                            modifier4 = modifier3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1081438217, i3, -1, "androidx.compose.material.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:232)");
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
                            ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(interfaceC3588op, new DropdownMenuPositionProvider(jM5231getZeroRKDOV3M, density, (InterfaceC0526Fp) objRememberedValue3, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1167205969, true, new AnonymousClass1(mutableTransitionState, mutableState, scrollStateRememberScrollState, exposedDropdownMenuBoxScope, modifier4, interfaceC0552Gp, i3)), composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        scrollState3 = scrollStateRememberScrollState;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        modifier4 = modifier2;
                    }
                    scrollStateRememberScrollState = scrollState2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1081438217, i3, -1, "androidx.compose.material.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:232)");
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
                        ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(interfaceC3588op, new DropdownMenuPositionProvider(jM5231getZeroRKDOV3M2, density2, (InterfaceC0526Fp) objRememberedValue3, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1167205969, true, new AnonymousClass1(mutableTransitionState, mutableState, scrollStateRememberScrollState, exposedDropdownMenuBoxScope, modifier4, interfaceC0552Gp, i3)), composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 0);
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
                        ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(interfaceC3588op, new DropdownMenuPositionProvider(jM5231getZeroRKDOV3M3, density3, (InterfaceC0526Fp) objRememberedValue3, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1167205969, true, new AnonymousClass1(mutableTransitionState, mutableState, scrollStateRememberScrollState, exposedDropdownMenuBoxScope, modifier4, interfaceC0552Gp, i3)), composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    scrollState3 = scrollStateRememberScrollState;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    scrollState3 = scrollState2;
                    composerStartRestartGroup = composerStartRestartGroup;
                    modifier5 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(exposedDropdownMenuBoxScope.new AnonymousClass2(z, interfaceC3588op, modifier5, scrollState3, interfaceC0552Gp, i, i2));
            }
            i3 |= 384;
            modifier2 = modifier;
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    scrollState2 = scrollState;
                    if (composerStartRestartGroup.changed(scrollState2)) {
                    }
                    i3 |= i7;
                } else {
                    scrollState2 = scrollState;
                }
                i3 |= i7;
            } else {
                scrollState2 = scrollState;
            }
            if ((i2 & 16) != 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i4 = 16384;
                } else {
                    i4 = 8192;
                }
                i3 |= i4;
            }
            if ((i2 & 32) != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((458752 & i) == 0) {
                if (composerStartRestartGroup.changed(exposedDropdownMenuBoxScope)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i3 |= i5;
            }
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        modifier4 = modifier3;
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        modifier4 = modifier3;
                        scrollStateRememberScrollState = scrollState2;
                    }
                } else {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        modifier4 = modifier3;
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        modifier4 = modifier3;
                        scrollStateRememberScrollState = scrollState2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1081438217, i3, -1, "androidx.compose.material.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:232)");
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
                    ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(interfaceC3588op, new DropdownMenuPositionProvider(jM5231getZeroRKDOV3M4, density4, (InterfaceC0526Fp) objRememberedValue3, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1167205969, true, new AnonymousClass1(mutableTransitionState, mutableState, scrollStateRememberScrollState, exposedDropdownMenuBoxScope, modifier4, interfaceC0552Gp, i3)), composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 0);
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
                    ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(interfaceC3588op, new DropdownMenuPositionProvider(jM5231getZeroRKDOV3M5, density5, (InterfaceC0526Fp) objRememberedValue3, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1167205969, true, new AnonymousClass1(mutableTransitionState, mutableState, scrollStateRememberScrollState, exposedDropdownMenuBoxScope, modifier4, interfaceC0552Gp, i3)), composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                scrollState3 = scrollStateRememberScrollState;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        modifier4 = modifier3;
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        modifier4 = modifier3;
                        scrollStateRememberScrollState = scrollState2;
                    }
                } else {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        modifier4 = modifier3;
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        modifier4 = modifier3;
                        scrollStateRememberScrollState = scrollState2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1081438217, i3, -1, "androidx.compose.material.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:232)");
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
                    Density density6 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    long jM5231getZeroRKDOV3M6 = DpOffset.Companion.m5231getZeroRKDOV3M();
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
                    ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(interfaceC3588op, new DropdownMenuPositionProvider(jM5231getZeroRKDOV3M6, density6, (InterfaceC0526Fp) objRememberedValue3, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1167205969, true, new AnonymousClass1(mutableTransitionState, mutableState, scrollStateRememberScrollState, exposedDropdownMenuBoxScope, modifier4, interfaceC0552Gp, i3)), composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 0);
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m3381boximpl(TransformOrigin.Companion.m3394getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue2;
                    Density density7 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    long jM5231getZeroRKDOV3M7 = DpOffset.Companion.m5231getZeroRKDOV3M();
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
                    ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(interfaceC3588op, new DropdownMenuPositionProvider(jM5231getZeroRKDOV3M7, density7, (InterfaceC0526Fp) objRememberedValue3, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1167205969, true, new AnonymousClass1(mutableTransitionState, mutableState, scrollStateRememberScrollState, exposedDropdownMenuBoxScope, modifier4, interfaceC0552Gp, i3)), composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                scrollState3 = scrollStateRememberScrollState;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(exposedDropdownMenuBoxScope.new AnonymousClass2(z, interfaceC3588op, modifier5, scrollState3, interfaceC0552Gp, i, i2));
        }

        public static /* synthetic */ Modifier c(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            return exposedDropdownMenuBoxScope.exposedDropdownSize(modifier, z);
        }
    }

    public static final class DefaultImpls {
        @Composable
        @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
        @Deprecated
        public static void ExposedDropdownMenu(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, boolean z, InterfaceC3588op interfaceC3588op, Modifier modifier, ScrollState scrollState, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
            AbstractC4492zt.h(interfaceC3588op, "onDismissRequest");
            AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
            CC.a(exposedDropdownMenuBoxScope, z, interfaceC3588op, modifier, scrollState, interfaceC0552Gp, composer, i, i2);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ MutableTransitionState<Boolean> $expandedStates;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ ScrollState $scrollState;
        final /* synthetic */ MutableState<TransformOrigin> $transformOriginState;
        final /* synthetic */ ExposedDropdownMenuBoxScope this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MutableTransitionState<Boolean> mutableTransitionState, MutableState<TransformOrigin> mutableState, ScrollState scrollState, ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, InterfaceC0552Gp interfaceC0552Gp, int i) {
            super(2);
            this.$expandedStates = mutableTransitionState;
            this.$transformOriginState = mutableState;
            this.$scrollState = scrollState;
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
                ComposerKt.traceEventStart(-1167205969, i, -1, "androidx.compose.material.ExposedDropdownMenuBoxScope.ExposedDropdownMenu.<anonymous> (ExposedDropdownMenu.kt:264)");
            }
            MutableTransitionState<Boolean> mutableTransitionState = this.$expandedStates;
            MutableState<TransformOrigin> mutableState = this.$transformOriginState;
            ScrollState scrollState = this.$scrollState;
            Modifier modifierC = CC.c(this.this$0, this.$modifier, false, 1, null);
            InterfaceC0552Gp interfaceC0552Gp = this.$content;
            int i2 = MutableTransitionState.$stable | 48;
            int i3 = this.$$dirty;
            MenuKt.DropdownMenuContent(mutableTransitionState, mutableState, scrollState, modifierC, interfaceC0552Gp, composer, i2 | ((i3 >> 3) & 896) | (i3 & 57344), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ boolean $expanded;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3588op $onDismissRequest;
        final /* synthetic */ ScrollState $scrollState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(boolean z, InterfaceC3588op interfaceC3588op, Modifier modifier, ScrollState scrollState, InterfaceC0552Gp interfaceC0552Gp, int i, int i2) {
            super(2);
            this.$expanded = z;
            this.$onDismissRequest = interfaceC3588op;
            this.$modifier = modifier;
            this.$scrollState = scrollState;
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
            ExposedDropdownMenuBoxScope.this.ExposedDropdownMenu(this.$expanded, this.$onDismissRequest, this.$modifier, this.$scrollState, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    void ExposedDropdownMenu(boolean z, InterfaceC3588op interfaceC3588op, Modifier modifier, ScrollState scrollState, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2);

    Modifier exposedDropdownSize(Modifier modifier, boolean z);
}
