package androidx.compose.material;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
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
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidMenu_androidKt {

    /* JADX INFO: renamed from: androidx.compose.material.AndroidMenu_androidKt$DropdownMenuItem$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3588op $onClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, InterfaceC0552Gp interfaceC0552Gp, int i, int i2) {
            super(2);
            this.$onClick = interfaceC3588op;
            this.$modifier = modifier;
            this.$enabled = z;
            this.$contentPadding = paddingValues;
            this.$interactionSource = mutableInteractionSource;
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
            AndroidMenu_androidKt.DropdownMenuItem(this.$onClick, this.$modifier, this.$enabled, this.$contentPadding, this.$interactionSource, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x012c  */
    /* JADX WARN: Code duplicated, block: B:103:0x0137  */
    /* JADX WARN: Code duplicated, block: B:104:0x0154  */
    /* JADX WARN: Code duplicated, block: B:107:0x0162  */
    /* JADX WARN: Code duplicated, block: B:110:0x017d  */
    /* JADX WARN: Code duplicated, block: B:113:0x019f  */
    /* JADX WARN: Code duplicated, block: B:115:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:117:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:120:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:122:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:126:0x0240  */
    /* JADX WARN: Code duplicated, block: B:131:0x024f  */
    /* JADX WARN: Code duplicated, block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x006a  */
    /* JADX WARN: Code duplicated, block: B:37:0x006f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0075  */
    /* JADX WARN: Code duplicated, block: B:41:0x007b  */
    /* JADX WARN: Code duplicated, block: B:42:0x007e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0087  */
    /* JADX WARN: Code duplicated, block: B:48:0x008b  */
    /* JADX WARN: Code duplicated, block: B:50:0x0093  */
    /* JADX WARN: Code duplicated, block: B:51:0x0096  */
    /* JADX WARN: Code duplicated, block: B:54:0x009c  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:93:0x0111 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:94:0x0113  */
    /* JADX WARN: Code duplicated, block: B:95:0x0116  */
    /* JADX WARN: Code duplicated, block: B:98:0x011a  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: DropdownMenu-4kj-_NE, reason: not valid java name */
    public static final void m973DropdownMenu4kj_NE(boolean z, InterfaceC3588op interfaceC3588op, Modifier modifier, long j, ScrollState scrollState, PopupProperties popupProperties, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        long jM5181DpOffsetYgX7TsA;
        int i5;
        ScrollState scrollStateRememberScrollState;
        int i6;
        PopupProperties popupProperties2;
        int i7;
        int i8;
        Modifier modifier3;
        long j2;
        Modifier modifier4;
        ScrollState scrollState2;
        int i9;
        Object objRememberedValue;
        Composer.Companion companion;
        MutableTransitionState mutableTransitionState;
        Object objRememberedValue2;
        MutableState mutableState;
        boolean zChanged;
        Object objRememberedValue3;
        Modifier modifier5;
        long j3;
        PopupProperties popupProperties3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC3588op, "onDismissRequest");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-2135362555);
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
        int i10 = i2 & 4;
        if (i10 == 0) {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                i3 |= 3072;
                jM5181DpOffsetYgX7TsA = j;
            } else {
                jM5181DpOffsetYgX7TsA = j;
                if ((i & 7168) == 0) {
                    if (composerStartRestartGroup.changed(jM5181DpOffsetYgX7TsA)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    scrollStateRememberScrollState = scrollState;
                    int i11 = composerStartRestartGroup.changed(scrollStateRememberScrollState) ? 16384 : 8192;
                    i3 |= i11;
                } else {
                    scrollStateRememberScrollState = scrollState;
                }
                i3 |= i11;
            } else {
                scrollStateRememberScrollState = scrollState;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((458752 & i) == 0) {
                    popupProperties2 = popupProperties;
                    if (composerStartRestartGroup.changed(popupProperties2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((i2 & 64) != 0) {
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i8 = 1048576;
                        } else {
                            i8 = 524288;
                        }
                    }
                    if ((i3 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i10 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                float f = 0;
                                jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f), Dp.m5160constructorimpl(f));
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            }
                            if (i6 != 0) {
                                popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                                scrollState2 = scrollStateRememberScrollState;
                                j2 = jM5181DpOffsetYgX7TsA;
                                modifier4 = modifier3;
                            } else {
                                j2 = jM5181DpOffsetYgX7TsA;
                                modifier4 = modifier3;
                            }
                            i9 = i3;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2135362555, i9, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:146)");
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
                                composerStartRestartGroup.startReplaceableGroup(1157296644);
                                zChanged = composerStartRestartGroup.changed(mutableState);
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                                    objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier5 = modifier4;
                            j3 = j2;
                            scrollStateRememberScrollState = scrollState2;
                            popupProperties3 = popupProperties2;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            j2 = jM5181DpOffsetYgX7TsA;
                            modifier4 = modifier2;
                        }
                        scrollState2 = scrollStateRememberScrollState;
                        i9 = i3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2135362555, i9, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:146)");
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
                            composerStartRestartGroup.startReplaceableGroup(1157296644);
                            zChanged = composerStartRestartGroup.changed(mutableState);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density2, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
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
                            composerStartRestartGroup.startReplaceableGroup(1157296644);
                            zChanged = composerStartRestartGroup.changed(mutableState);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density3, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        j3 = j2;
                        scrollStateRememberScrollState = scrollState2;
                        popupProperties3 = popupProperties2;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier5 = modifier2;
                        j3 = jM5181DpOffsetYgX7TsA;
                        popupProperties3 = popupProperties2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$3(z, interfaceC3588op, modifier5, j3, scrollStateRememberScrollState, popupProperties3, interfaceC0552Gp, i, i2));
                }
                i8 = 1572864;
                i3 |= i8;
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            float f2 = 0;
                            jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f2), Dp.m5160constructorimpl(f2));
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        }
                        if (i6 != 0) {
                            popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                            scrollState2 = scrollStateRememberScrollState;
                            j2 = jM5181DpOffsetYgX7TsA;
                            modifier4 = modifier3;
                        } else {
                            j2 = jM5181DpOffsetYgX7TsA;
                            modifier4 = modifier3;
                            scrollState2 = scrollStateRememberScrollState;
                        }
                    } else {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            float f3 = 0;
                            jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f3), Dp.m5160constructorimpl(f3));
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        }
                        if (i6 != 0) {
                            popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                            scrollState2 = scrollStateRememberScrollState;
                            j2 = jM5181DpOffsetYgX7TsA;
                            modifier4 = modifier3;
                        } else {
                            j2 = jM5181DpOffsetYgX7TsA;
                            modifier4 = modifier3;
                            scrollState2 = scrollStateRememberScrollState;
                        }
                    }
                    i9 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2135362555, i9, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:146)");
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
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(mutableState);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density4, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
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
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(mutableState);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density5, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    j3 = j2;
                    scrollStateRememberScrollState = scrollState2;
                    popupProperties3 = popupProperties2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            float f4 = 0;
                            jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f4), Dp.m5160constructorimpl(f4));
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        }
                        if (i6 != 0) {
                            popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                            scrollState2 = scrollStateRememberScrollState;
                            j2 = jM5181DpOffsetYgX7TsA;
                            modifier4 = modifier3;
                        } else {
                            j2 = jM5181DpOffsetYgX7TsA;
                            modifier4 = modifier3;
                            scrollState2 = scrollStateRememberScrollState;
                        }
                    } else {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            float f5 = 0;
                            jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f5), Dp.m5160constructorimpl(f5));
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        }
                        if (i6 != 0) {
                            popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                            scrollState2 = scrollStateRememberScrollState;
                            j2 = jM5181DpOffsetYgX7TsA;
                            modifier4 = modifier3;
                        } else {
                            j2 = jM5181DpOffsetYgX7TsA;
                            modifier4 = modifier3;
                            scrollState2 = scrollStateRememberScrollState;
                        }
                    }
                    i9 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2135362555, i9, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:146)");
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
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(mutableState);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density6, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
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
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(mutableState);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density7, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    j3 = j2;
                    scrollStateRememberScrollState = scrollState2;
                    popupProperties3 = popupProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$3(z, interfaceC3588op, modifier5, j3, scrollStateRememberScrollState, popupProperties3, interfaceC0552Gp, i, i2));
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            popupProperties2 = popupProperties;
            if ((i2 & 64) != 0) {
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                }
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            float f6 = 0;
                            jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f6), Dp.m5160constructorimpl(f6));
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        }
                        if (i6 != 0) {
                            popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                            scrollState2 = scrollStateRememberScrollState;
                            j2 = jM5181DpOffsetYgX7TsA;
                            modifier4 = modifier3;
                        } else {
                            j2 = jM5181DpOffsetYgX7TsA;
                            modifier4 = modifier3;
                            scrollState2 = scrollStateRememberScrollState;
                        }
                    } else {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            float f7 = 0;
                            jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f7), Dp.m5160constructorimpl(f7));
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        }
                        if (i6 != 0) {
                            popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                            scrollState2 = scrollStateRememberScrollState;
                            j2 = jM5181DpOffsetYgX7TsA;
                            modifier4 = modifier3;
                        } else {
                            j2 = jM5181DpOffsetYgX7TsA;
                            modifier4 = modifier3;
                            scrollState2 = scrollStateRememberScrollState;
                        }
                    }
                    i9 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2135362555, i9, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:146)");
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
                        Density density8 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(mutableState);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density8, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m3381boximpl(TransformOrigin.Companion.m3394getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue2;
                        Density density9 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(mutableState);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density9, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    j3 = j2;
                    scrollStateRememberScrollState = scrollState2;
                    popupProperties3 = popupProperties2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            float f8 = 0;
                            jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f8), Dp.m5160constructorimpl(f8));
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        }
                        if (i6 != 0) {
                            popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                            scrollState2 = scrollStateRememberScrollState;
                            j2 = jM5181DpOffsetYgX7TsA;
                            modifier4 = modifier3;
                        } else {
                            j2 = jM5181DpOffsetYgX7TsA;
                            modifier4 = modifier3;
                            scrollState2 = scrollStateRememberScrollState;
                        }
                    } else {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            float f9 = 0;
                            jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f9), Dp.m5160constructorimpl(f9));
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        }
                        if (i6 != 0) {
                            popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                            scrollState2 = scrollStateRememberScrollState;
                            j2 = jM5181DpOffsetYgX7TsA;
                            modifier4 = modifier3;
                        } else {
                            j2 = jM5181DpOffsetYgX7TsA;
                            modifier4 = modifier3;
                            scrollState2 = scrollStateRememberScrollState;
                        }
                    }
                    i9 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2135362555, i9, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:146)");
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
                        Density density10 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(mutableState);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density10, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m3381boximpl(TransformOrigin.Companion.m3394getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue2;
                        Density density11 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(mutableState);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density11, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    j3 = j2;
                    scrollStateRememberScrollState = scrollState2;
                    popupProperties3 = popupProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$3(z, interfaceC3588op, modifier5, j3, scrollStateRememberScrollState, popupProperties3, interfaceC0552Gp, i, i2));
            }
            i8 = 1572864;
            i3 |= i8;
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f10 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f10), Dp.m5160constructorimpl(f10));
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    }
                    if (i6 != 0) {
                        popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                        scrollState2 = scrollStateRememberScrollState;
                        j2 = jM5181DpOffsetYgX7TsA;
                        modifier4 = modifier3;
                    } else {
                        j2 = jM5181DpOffsetYgX7TsA;
                        modifier4 = modifier3;
                        scrollState2 = scrollStateRememberScrollState;
                    }
                } else {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f11 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f11), Dp.m5160constructorimpl(f11));
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    }
                    if (i6 != 0) {
                        popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                        scrollState2 = scrollStateRememberScrollState;
                        j2 = jM5181DpOffsetYgX7TsA;
                        modifier4 = modifier3;
                    } else {
                        j2 = jM5181DpOffsetYgX7TsA;
                        modifier4 = modifier3;
                        scrollState2 = scrollStateRememberScrollState;
                    }
                }
                i9 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2135362555, i9, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:146)");
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
                    Density density12 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(mutableState);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density12, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m3381boximpl(TransformOrigin.Companion.m3394getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue2;
                    Density density13 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(mutableState);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density13, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                j3 = j2;
                scrollStateRememberScrollState = scrollState2;
                popupProperties3 = popupProperties2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f12 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f12), Dp.m5160constructorimpl(f12));
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    }
                    if (i6 != 0) {
                        popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                        scrollState2 = scrollStateRememberScrollState;
                        j2 = jM5181DpOffsetYgX7TsA;
                        modifier4 = modifier3;
                    } else {
                        j2 = jM5181DpOffsetYgX7TsA;
                        modifier4 = modifier3;
                        scrollState2 = scrollStateRememberScrollState;
                    }
                } else {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f13 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f13), Dp.m5160constructorimpl(f13));
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    }
                    if (i6 != 0) {
                        popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                        scrollState2 = scrollStateRememberScrollState;
                        j2 = jM5181DpOffsetYgX7TsA;
                        modifier4 = modifier3;
                    } else {
                        j2 = jM5181DpOffsetYgX7TsA;
                        modifier4 = modifier3;
                        scrollState2 = scrollStateRememberScrollState;
                    }
                }
                i9 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2135362555, i9, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:146)");
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
                    Density density14 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(mutableState);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density14, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m3381boximpl(TransformOrigin.Companion.m3394getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue2;
                    Density density15 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(mutableState);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density15, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                j3 = j2;
                scrollStateRememberScrollState = scrollState2;
                popupProperties3 = popupProperties2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$3(z, interfaceC3588op, modifier5, j3, scrollStateRememberScrollState, popupProperties3, interfaceC0552Gp, i, i2));
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            i3 |= 3072;
            jM5181DpOffsetYgX7TsA = j;
        } else {
            jM5181DpOffsetYgX7TsA = j;
            if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changed(jM5181DpOffsetYgX7TsA)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
        }
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                scrollStateRememberScrollState = scrollState;
                if (composerStartRestartGroup.changed(scrollStateRememberScrollState)) {
                }
                i3 |= i11;
            } else {
                scrollStateRememberScrollState = scrollState;
            }
            i3 |= i11;
        } else {
            scrollStateRememberScrollState = scrollState;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((458752 & i) == 0) {
                popupProperties2 = popupProperties;
                if (composerStartRestartGroup.changed(popupProperties2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((i2 & 64) != 0) {
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                }
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            float f14 = 0;
                            jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f14), Dp.m5160constructorimpl(f14));
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        }
                        if (i6 != 0) {
                            popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                            scrollState2 = scrollStateRememberScrollState;
                            j2 = jM5181DpOffsetYgX7TsA;
                            modifier4 = modifier3;
                        } else {
                            j2 = jM5181DpOffsetYgX7TsA;
                            modifier4 = modifier3;
                            scrollState2 = scrollStateRememberScrollState;
                        }
                    } else {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            float f15 = 0;
                            jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f15), Dp.m5160constructorimpl(f15));
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        }
                        if (i6 != 0) {
                            popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                            scrollState2 = scrollStateRememberScrollState;
                            j2 = jM5181DpOffsetYgX7TsA;
                            modifier4 = modifier3;
                        } else {
                            j2 = jM5181DpOffsetYgX7TsA;
                            modifier4 = modifier3;
                            scrollState2 = scrollStateRememberScrollState;
                        }
                    }
                    i9 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2135362555, i9, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:146)");
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
                        Density density16 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(mutableState);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density16, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m3381boximpl(TransformOrigin.Companion.m3394getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue2;
                        Density density17 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(mutableState);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density17, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    j3 = j2;
                    scrollStateRememberScrollState = scrollState2;
                    popupProperties3 = popupProperties2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            float f16 = 0;
                            jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f16), Dp.m5160constructorimpl(f16));
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        }
                        if (i6 != 0) {
                            popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                            scrollState2 = scrollStateRememberScrollState;
                            j2 = jM5181DpOffsetYgX7TsA;
                            modifier4 = modifier3;
                        } else {
                            j2 = jM5181DpOffsetYgX7TsA;
                            modifier4 = modifier3;
                            scrollState2 = scrollStateRememberScrollState;
                        }
                    } else {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            float f17 = 0;
                            jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f17), Dp.m5160constructorimpl(f17));
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        }
                        if (i6 != 0) {
                            popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                            scrollState2 = scrollStateRememberScrollState;
                            j2 = jM5181DpOffsetYgX7TsA;
                            modifier4 = modifier3;
                        } else {
                            j2 = jM5181DpOffsetYgX7TsA;
                            modifier4 = modifier3;
                            scrollState2 = scrollStateRememberScrollState;
                        }
                    }
                    i9 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2135362555, i9, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:146)");
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
                        Density density18 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(mutableState);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density18, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m3381boximpl(TransformOrigin.Companion.m3394getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue2;
                        Density density19 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(mutableState);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density19, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    j3 = j2;
                    scrollStateRememberScrollState = scrollState2;
                    popupProperties3 = popupProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$3(z, interfaceC3588op, modifier5, j3, scrollStateRememberScrollState, popupProperties3, interfaceC0552Gp, i, i2));
            }
            i8 = 1572864;
            i3 |= i8;
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f18 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f18), Dp.m5160constructorimpl(f18));
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    }
                    if (i6 != 0) {
                        popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                        scrollState2 = scrollStateRememberScrollState;
                        j2 = jM5181DpOffsetYgX7TsA;
                        modifier4 = modifier3;
                    } else {
                        j2 = jM5181DpOffsetYgX7TsA;
                        modifier4 = modifier3;
                        scrollState2 = scrollStateRememberScrollState;
                    }
                } else {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f19 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f19), Dp.m5160constructorimpl(f19));
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    }
                    if (i6 != 0) {
                        popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                        scrollState2 = scrollStateRememberScrollState;
                        j2 = jM5181DpOffsetYgX7TsA;
                        modifier4 = modifier3;
                    } else {
                        j2 = jM5181DpOffsetYgX7TsA;
                        modifier4 = modifier3;
                        scrollState2 = scrollStateRememberScrollState;
                    }
                }
                i9 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2135362555, i9, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:146)");
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
                    Density density110 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(mutableState);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density110, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m3381boximpl(TransformOrigin.Companion.m3394getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue2;
                    Density density111 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(mutableState);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density111, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                j3 = j2;
                scrollStateRememberScrollState = scrollState2;
                popupProperties3 = popupProperties2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f110 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f110), Dp.m5160constructorimpl(f110));
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    }
                    if (i6 != 0) {
                        popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                        scrollState2 = scrollStateRememberScrollState;
                        j2 = jM5181DpOffsetYgX7TsA;
                        modifier4 = modifier3;
                    } else {
                        j2 = jM5181DpOffsetYgX7TsA;
                        modifier4 = modifier3;
                        scrollState2 = scrollStateRememberScrollState;
                    }
                } else {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f111 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f111), Dp.m5160constructorimpl(f111));
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    }
                    if (i6 != 0) {
                        popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                        scrollState2 = scrollStateRememberScrollState;
                        j2 = jM5181DpOffsetYgX7TsA;
                        modifier4 = modifier3;
                    } else {
                        j2 = jM5181DpOffsetYgX7TsA;
                        modifier4 = modifier3;
                        scrollState2 = scrollStateRememberScrollState;
                    }
                }
                i9 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2135362555, i9, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:146)");
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
                    Density density112 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(mutableState);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density112, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m3381boximpl(TransformOrigin.Companion.m3394getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue2;
                    Density density113 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(mutableState);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density113, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                j3 = j2;
                scrollStateRememberScrollState = scrollState2;
                popupProperties3 = popupProperties2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$3(z, interfaceC3588op, modifier5, j3, scrollStateRememberScrollState, popupProperties3, interfaceC0552Gp, i, i2));
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        popupProperties2 = popupProperties;
        if ((i2 & 64) != 0) {
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
            }
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f112 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f112), Dp.m5160constructorimpl(f112));
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    }
                    if (i6 != 0) {
                        popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                        scrollState2 = scrollStateRememberScrollState;
                        j2 = jM5181DpOffsetYgX7TsA;
                        modifier4 = modifier3;
                    } else {
                        j2 = jM5181DpOffsetYgX7TsA;
                        modifier4 = modifier3;
                        scrollState2 = scrollStateRememberScrollState;
                    }
                } else {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f113 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f113), Dp.m5160constructorimpl(f113));
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    }
                    if (i6 != 0) {
                        popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                        scrollState2 = scrollStateRememberScrollState;
                        j2 = jM5181DpOffsetYgX7TsA;
                        modifier4 = modifier3;
                    } else {
                        j2 = jM5181DpOffsetYgX7TsA;
                        modifier4 = modifier3;
                        scrollState2 = scrollStateRememberScrollState;
                    }
                }
                i9 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2135362555, i9, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:146)");
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
                    Density density114 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(mutableState);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density114, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m3381boximpl(TransformOrigin.Companion.m3394getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue2;
                    Density density115 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(mutableState);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density115, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                j3 = j2;
                scrollStateRememberScrollState = scrollState2;
                popupProperties3 = popupProperties2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f114 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f114), Dp.m5160constructorimpl(f114));
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    }
                    if (i6 != 0) {
                        popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                        scrollState2 = scrollStateRememberScrollState;
                        j2 = jM5181DpOffsetYgX7TsA;
                        modifier4 = modifier3;
                    } else {
                        j2 = jM5181DpOffsetYgX7TsA;
                        modifier4 = modifier3;
                        scrollState2 = scrollStateRememberScrollState;
                    }
                } else {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f115 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f115), Dp.m5160constructorimpl(f115));
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    }
                    if (i6 != 0) {
                        popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                        scrollState2 = scrollStateRememberScrollState;
                        j2 = jM5181DpOffsetYgX7TsA;
                        modifier4 = modifier3;
                    } else {
                        j2 = jM5181DpOffsetYgX7TsA;
                        modifier4 = modifier3;
                        scrollState2 = scrollStateRememberScrollState;
                    }
                }
                i9 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2135362555, i9, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:146)");
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
                    Density density116 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(mutableState);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density116, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m3381boximpl(TransformOrigin.Companion.m3394getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue2;
                    Density density117 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(mutableState);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density117, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                j3 = j2;
                scrollStateRememberScrollState = scrollState2;
                popupProperties3 = popupProperties2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$3(z, interfaceC3588op, modifier5, j3, scrollStateRememberScrollState, popupProperties3, interfaceC0552Gp, i, i2));
        }
        i8 = 1572864;
        i3 |= i8;
        if ((i3 & 2995931) == 599186) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    float f116 = 0;
                    jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f116), Dp.m5160constructorimpl(f116));
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                }
                if (i6 != 0) {
                    popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                    scrollState2 = scrollStateRememberScrollState;
                    j2 = jM5181DpOffsetYgX7TsA;
                    modifier4 = modifier3;
                } else {
                    j2 = jM5181DpOffsetYgX7TsA;
                    modifier4 = modifier3;
                    scrollState2 = scrollStateRememberScrollState;
                }
            } else {
                if (i10 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    float f117 = 0;
                    jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f117), Dp.m5160constructorimpl(f117));
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                }
                if (i6 != 0) {
                    popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                    scrollState2 = scrollStateRememberScrollState;
                    j2 = jM5181DpOffsetYgX7TsA;
                    modifier4 = modifier3;
                } else {
                    j2 = jM5181DpOffsetYgX7TsA;
                    modifier4 = modifier3;
                    scrollState2 = scrollStateRememberScrollState;
                }
            }
            i9 = i3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2135362555, i9, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:146)");
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
                Density density118 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(mutableState);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density118, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
            } else {
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m3381boximpl(TransformOrigin.Companion.m3394getCenterSzJe1aQ()), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue2;
                Density density119 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(mutableState);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density119, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            j3 = j2;
            scrollStateRememberScrollState = scrollState2;
            popupProperties3 = popupProperties2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    float f118 = 0;
                    jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f118), Dp.m5160constructorimpl(f118));
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                }
                if (i6 != 0) {
                    popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                    scrollState2 = scrollStateRememberScrollState;
                    j2 = jM5181DpOffsetYgX7TsA;
                    modifier4 = modifier3;
                } else {
                    j2 = jM5181DpOffsetYgX7TsA;
                    modifier4 = modifier3;
                    scrollState2 = scrollStateRememberScrollState;
                }
            } else {
                if (i10 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    float f119 = 0;
                    jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f119), Dp.m5160constructorimpl(f119));
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                }
                if (i6 != 0) {
                    popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                    scrollState2 = scrollStateRememberScrollState;
                    j2 = jM5181DpOffsetYgX7TsA;
                    modifier4 = modifier3;
                } else {
                    j2 = jM5181DpOffsetYgX7TsA;
                    modifier4 = modifier3;
                    scrollState2 = scrollStateRememberScrollState;
                }
            }
            i9 = i3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2135362555, i9, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:146)");
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
                Density density1110 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(mutableState);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density1110, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
            } else {
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m3381boximpl(TransformOrigin.Companion.m3394getCenterSzJe1aQ()), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue2;
                Density density1111 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(mutableState);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(mutableState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j2, density1111, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -47803778, true, new AndroidMenu_androidKt$DropdownMenu$2(mutableTransitionState, mutableState, scrollState2, modifier4, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            j3 = j2;
            scrollStateRememberScrollState = scrollState2;
            popupProperties3 = popupProperties2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$3(z, interfaceC3588op, modifier5, j3, scrollStateRememberScrollState, popupProperties3, interfaceC0552Gp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:36:0x006a  */
    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:43:0x007e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0085  */
    /* JADX WARN: Code duplicated, block: B:49:0x008a  */
    /* JADX WARN: Code duplicated, block: B:51:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0098  */
    /* JADX WARN: Code duplicated, block: B:54:0x009b  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:77:0x00db  */
    /* JADX WARN: Code duplicated, block: B:78:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:81:0x0107  */
    /* JADX WARN: Code duplicated, block: B:84:0x010f  */
    /* JADX WARN: Code duplicated, block: B:87:0x013e  */
    /* JADX WARN: Code duplicated, block: B:92:0x014e  */
    /* JADX WARN: Code duplicated, block: B:94:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: DropdownMenu-ILWXrKs, reason: not valid java name */
    public static final /* synthetic */ void m974DropdownMenuILWXrKs(boolean z, InterfaceC3588op interfaceC3588op, Modifier modifier, long j, PopupProperties popupProperties, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        long j2;
        int i5;
        int i6;
        PopupProperties popupProperties2;
        int i7;
        int i8;
        Modifier modifier3;
        long jM5181DpOffsetYgX7TsA;
        PopupProperties popupProperties3;
        long j3;
        PopupProperties popupProperties4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC3588op, "onDismissRequest");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-840283139);
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
        int i9 = i2 & 4;
        if (i9 == 0) {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    j2 = j;
                    if (composerStartRestartGroup.changed(j2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((57344 & i) == 0) {
                        popupProperties2 = popupProperties;
                        if (composerStartRestartGroup.changed(popupProperties2)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    if ((i2 & 32) != 0) {
                        if ((i & 458752) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i8 = 131072;
                            } else {
                                i8 = 65536;
                            }
                        }
                        if ((374491 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                            if (i9 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                float f = 0;
                                jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f), Dp.m5160constructorimpl(f));
                            } else {
                                jM5181DpOffsetYgX7TsA = j2;
                            }
                            if (i6 != 0) {
                                popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                            } else {
                                popupProperties3 = popupProperties2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                            }
                            int i10 = i3 & 8190;
                            int i11 = i3 << 3;
                            m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i10 | (458752 & i11) | (i11 & 3670016), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier3;
                            j3 = jM5181DpOffsetYgX7TsA;
                            popupProperties4 = popupProperties3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            j3 = j2;
                            popupProperties4 = popupProperties2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$1(z, interfaceC3588op, modifier2, j3, popupProperties4, interfaceC0552Gp, i, i2));
                    }
                    i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i3 |= i8;
                    if ((374491 & i3) == 74898) {
                        if (i9 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            float f2 = 0;
                            jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f2), Dp.m5160constructorimpl(f2));
                        } else {
                            jM5181DpOffsetYgX7TsA = j2;
                        }
                        if (i6 != 0) {
                            popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                        } else {
                            popupProperties3 = popupProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                        }
                        int i12 = i3 & 8190;
                        int i13 = i3 << 3;
                        m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i12 | (458752 & i13) | (i13 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        j3 = jM5181DpOffsetYgX7TsA;
                        popupProperties4 = popupProperties3;
                    } else {
                        if (i9 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            float f3 = 0;
                            jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f3), Dp.m5160constructorimpl(f3));
                        } else {
                            jM5181DpOffsetYgX7TsA = j2;
                        }
                        if (i6 != 0) {
                            popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                        } else {
                            popupProperties3 = popupProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                        }
                        int i14 = i3 & 8190;
                        int i15 = i3 << 3;
                        m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i14 | (458752 & i15) | (i15 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        j3 = jM5181DpOffsetYgX7TsA;
                        popupProperties4 = popupProperties3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$1(z, interfaceC3588op, modifier2, j3, popupProperties4, interfaceC0552Gp, i, i2));
                }
                i3 |= 24576;
                popupProperties2 = popupProperties;
                if ((i2 & 32) != 0) {
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i8 = 131072;
                        } else {
                            i8 = 65536;
                        }
                    }
                    if ((374491 & i3) == 74898) {
                        if (i9 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            float f4 = 0;
                            jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f4), Dp.m5160constructorimpl(f4));
                        } else {
                            jM5181DpOffsetYgX7TsA = j2;
                        }
                        if (i6 != 0) {
                            popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                        } else {
                            popupProperties3 = popupProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                        }
                        int i16 = i3 & 8190;
                        int i17 = i3 << 3;
                        m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i16 | (458752 & i17) | (i17 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        j3 = jM5181DpOffsetYgX7TsA;
                        popupProperties4 = popupProperties3;
                    } else {
                        if (i9 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            float f5 = 0;
                            jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f5), Dp.m5160constructorimpl(f5));
                        } else {
                            jM5181DpOffsetYgX7TsA = j2;
                        }
                        if (i6 != 0) {
                            popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                        } else {
                            popupProperties3 = popupProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                        }
                        int i18 = i3 & 8190;
                        int i19 = i3 << 3;
                        m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i18 | (458752 & i19) | (i19 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        j3 = jM5181DpOffsetYgX7TsA;
                        popupProperties4 = popupProperties3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$1(z, interfaceC3588op, modifier2, j3, popupProperties4, interfaceC0552Gp, i, i2));
                }
                i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i8;
                if ((374491 & i3) == 74898) {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f6 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f6), Dp.m5160constructorimpl(f6));
                    } else {
                        jM5181DpOffsetYgX7TsA = j2;
                    }
                    if (i6 != 0) {
                        popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                    } else {
                        popupProperties3 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                    }
                    int i110 = i3 & 8190;
                    int i111 = i3 << 3;
                    m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i110 | (458752 & i111) | (i111 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    j3 = jM5181DpOffsetYgX7TsA;
                    popupProperties4 = popupProperties3;
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f7 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f7), Dp.m5160constructorimpl(f7));
                    } else {
                        jM5181DpOffsetYgX7TsA = j2;
                    }
                    if (i6 != 0) {
                        popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                    } else {
                        popupProperties3 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                    }
                    int i112 = i3 & 8190;
                    int i113 = i3 << 3;
                    m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i112 | (458752 & i113) | (i113 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    j3 = jM5181DpOffsetYgX7TsA;
                    popupProperties4 = popupProperties3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$1(z, interfaceC3588op, modifier2, j3, popupProperties4, interfaceC0552Gp, i, i2));
            }
            i3 |= 3072;
            j2 = j;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((57344 & i) == 0) {
                    popupProperties2 = popupProperties;
                    if (composerStartRestartGroup.changed(popupProperties2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((i2 & 32) != 0) {
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i8 = 131072;
                        } else {
                            i8 = 65536;
                        }
                    }
                    if ((374491 & i3) == 74898) {
                        if (i9 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            float f8 = 0;
                            jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f8), Dp.m5160constructorimpl(f8));
                        } else {
                            jM5181DpOffsetYgX7TsA = j2;
                        }
                        if (i6 != 0) {
                            popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                        } else {
                            popupProperties3 = popupProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                        }
                        int i114 = i3 & 8190;
                        int i115 = i3 << 3;
                        m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i114 | (458752 & i115) | (i115 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        j3 = jM5181DpOffsetYgX7TsA;
                        popupProperties4 = popupProperties3;
                    } else {
                        if (i9 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            float f9 = 0;
                            jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f9), Dp.m5160constructorimpl(f9));
                        } else {
                            jM5181DpOffsetYgX7TsA = j2;
                        }
                        if (i6 != 0) {
                            popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                        } else {
                            popupProperties3 = popupProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                        }
                        int i116 = i3 & 8190;
                        int i117 = i3 << 3;
                        m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i116 | (458752 & i117) | (i117 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        j3 = jM5181DpOffsetYgX7TsA;
                        popupProperties4 = popupProperties3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$1(z, interfaceC3588op, modifier2, j3, popupProperties4, interfaceC0552Gp, i, i2));
                }
                i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i8;
                if ((374491 & i3) == 74898) {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f10 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f10), Dp.m5160constructorimpl(f10));
                    } else {
                        jM5181DpOffsetYgX7TsA = j2;
                    }
                    if (i6 != 0) {
                        popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                    } else {
                        popupProperties3 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                    }
                    int i118 = i3 & 8190;
                    int i119 = i3 << 3;
                    m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i118 | (458752 & i119) | (i119 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    j3 = jM5181DpOffsetYgX7TsA;
                    popupProperties4 = popupProperties3;
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f11 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f11), Dp.m5160constructorimpl(f11));
                    } else {
                        jM5181DpOffsetYgX7TsA = j2;
                    }
                    if (i6 != 0) {
                        popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                    } else {
                        popupProperties3 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                    }
                    int i1110 = i3 & 8190;
                    int i1111 = i3 << 3;
                    m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i1110 | (458752 & i1111) | (i1111 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    j3 = jM5181DpOffsetYgX7TsA;
                    popupProperties4 = popupProperties3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$1(z, interfaceC3588op, modifier2, j3, popupProperties4, interfaceC0552Gp, i, i2));
            }
            i3 |= 24576;
            popupProperties2 = popupProperties;
            if ((i2 & 32) != 0) {
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                }
                if ((374491 & i3) == 74898) {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f12 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f12), Dp.m5160constructorimpl(f12));
                    } else {
                        jM5181DpOffsetYgX7TsA = j2;
                    }
                    if (i6 != 0) {
                        popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                    } else {
                        popupProperties3 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                    }
                    int i1112 = i3 & 8190;
                    int i1113 = i3 << 3;
                    m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i1112 | (458752 & i1113) | (i1113 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    j3 = jM5181DpOffsetYgX7TsA;
                    popupProperties4 = popupProperties3;
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f13 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f13), Dp.m5160constructorimpl(f13));
                    } else {
                        jM5181DpOffsetYgX7TsA = j2;
                    }
                    if (i6 != 0) {
                        popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                    } else {
                        popupProperties3 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                    }
                    int i1114 = i3 & 8190;
                    int i1115 = i3 << 3;
                    m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i1114 | (458752 & i1115) | (i1115 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    j3 = jM5181DpOffsetYgX7TsA;
                    popupProperties4 = popupProperties3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$1(z, interfaceC3588op, modifier2, j3, popupProperties4, interfaceC0552Gp, i, i2));
            }
            i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i8;
            if ((374491 & i3) == 74898) {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    float f14 = 0;
                    jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f14), Dp.m5160constructorimpl(f14));
                } else {
                    jM5181DpOffsetYgX7TsA = j2;
                }
                if (i6 != 0) {
                    popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                } else {
                    popupProperties3 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                }
                int i1116 = i3 & 8190;
                int i1117 = i3 << 3;
                m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i1116 | (458752 & i1117) | (i1117 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                j3 = jM5181DpOffsetYgX7TsA;
                popupProperties4 = popupProperties3;
            } else {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    float f15 = 0;
                    jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f15), Dp.m5160constructorimpl(f15));
                } else {
                    jM5181DpOffsetYgX7TsA = j2;
                }
                if (i6 != 0) {
                    popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                } else {
                    popupProperties3 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                }
                int i1118 = i3 & 8190;
                int i1119 = i3 << 3;
                m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i1118 | (458752 & i1119) | (i1119 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                j3 = jM5181DpOffsetYgX7TsA;
                popupProperties4 = popupProperties3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$1(z, interfaceC3588op, modifier2, j3, popupProperties4, interfaceC0552Gp, i, i2));
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                j2 = j;
                if (composerStartRestartGroup.changed(j2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((57344 & i) == 0) {
                    popupProperties2 = popupProperties;
                    if (composerStartRestartGroup.changed(popupProperties2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((i2 & 32) != 0) {
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i8 = 131072;
                        } else {
                            i8 = 65536;
                        }
                    }
                    if ((374491 & i3) == 74898) {
                        if (i9 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            float f16 = 0;
                            jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f16), Dp.m5160constructorimpl(f16));
                        } else {
                            jM5181DpOffsetYgX7TsA = j2;
                        }
                        if (i6 != 0) {
                            popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                        } else {
                            popupProperties3 = popupProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                        }
                        int i11110 = i3 & 8190;
                        int i11111 = i3 << 3;
                        m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i11110 | (458752 & i11111) | (i11111 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        j3 = jM5181DpOffsetYgX7TsA;
                        popupProperties4 = popupProperties3;
                    } else {
                        if (i9 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            float f17 = 0;
                            jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f17), Dp.m5160constructorimpl(f17));
                        } else {
                            jM5181DpOffsetYgX7TsA = j2;
                        }
                        if (i6 != 0) {
                            popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                        } else {
                            popupProperties3 = popupProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                        }
                        int i11112 = i3 & 8190;
                        int i11113 = i3 << 3;
                        m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i11112 | (458752 & i11113) | (i11113 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        j3 = jM5181DpOffsetYgX7TsA;
                        popupProperties4 = popupProperties3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$1(z, interfaceC3588op, modifier2, j3, popupProperties4, interfaceC0552Gp, i, i2));
                }
                i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i8;
                if ((374491 & i3) == 74898) {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f18 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f18), Dp.m5160constructorimpl(f18));
                    } else {
                        jM5181DpOffsetYgX7TsA = j2;
                    }
                    if (i6 != 0) {
                        popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                    } else {
                        popupProperties3 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                    }
                    int i11114 = i3 & 8190;
                    int i11115 = i3 << 3;
                    m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i11114 | (458752 & i11115) | (i11115 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    j3 = jM5181DpOffsetYgX7TsA;
                    popupProperties4 = popupProperties3;
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f19 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f19), Dp.m5160constructorimpl(f19));
                    } else {
                        jM5181DpOffsetYgX7TsA = j2;
                    }
                    if (i6 != 0) {
                        popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                    } else {
                        popupProperties3 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                    }
                    int i11116 = i3 & 8190;
                    int i11117 = i3 << 3;
                    m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i11116 | (458752 & i11117) | (i11117 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    j3 = jM5181DpOffsetYgX7TsA;
                    popupProperties4 = popupProperties3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$1(z, interfaceC3588op, modifier2, j3, popupProperties4, interfaceC0552Gp, i, i2));
            }
            i3 |= 24576;
            popupProperties2 = popupProperties;
            if ((i2 & 32) != 0) {
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                }
                if ((374491 & i3) == 74898) {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f110 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f110), Dp.m5160constructorimpl(f110));
                    } else {
                        jM5181DpOffsetYgX7TsA = j2;
                    }
                    if (i6 != 0) {
                        popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                    } else {
                        popupProperties3 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                    }
                    int i11118 = i3 & 8190;
                    int i11119 = i3 << 3;
                    m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i11118 | (458752 & i11119) | (i11119 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    j3 = jM5181DpOffsetYgX7TsA;
                    popupProperties4 = popupProperties3;
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f111 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f111), Dp.m5160constructorimpl(f111));
                    } else {
                        jM5181DpOffsetYgX7TsA = j2;
                    }
                    if (i6 != 0) {
                        popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                    } else {
                        popupProperties3 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                    }
                    int i111110 = i3 & 8190;
                    int i111111 = i3 << 3;
                    m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i111110 | (458752 & i111111) | (i111111 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    j3 = jM5181DpOffsetYgX7TsA;
                    popupProperties4 = popupProperties3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$1(z, interfaceC3588op, modifier2, j3, popupProperties4, interfaceC0552Gp, i, i2));
            }
            i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i8;
            if ((374491 & i3) == 74898) {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    float f112 = 0;
                    jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f112), Dp.m5160constructorimpl(f112));
                } else {
                    jM5181DpOffsetYgX7TsA = j2;
                }
                if (i6 != 0) {
                    popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                } else {
                    popupProperties3 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                }
                int i111112 = i3 & 8190;
                int i111113 = i3 << 3;
                m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i111112 | (458752 & i111113) | (i111113 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                j3 = jM5181DpOffsetYgX7TsA;
                popupProperties4 = popupProperties3;
            } else {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    float f113 = 0;
                    jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f113), Dp.m5160constructorimpl(f113));
                } else {
                    jM5181DpOffsetYgX7TsA = j2;
                }
                if (i6 != 0) {
                    popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                } else {
                    popupProperties3 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                }
                int i111114 = i3 & 8190;
                int i111115 = i3 << 3;
                m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i111114 | (458752 & i111115) | (i111115 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                j3 = jM5181DpOffsetYgX7TsA;
                popupProperties4 = popupProperties3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$1(z, interfaceC3588op, modifier2, j3, popupProperties4, interfaceC0552Gp, i, i2));
        }
        i3 |= 3072;
        j2 = j;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((57344 & i) == 0) {
                popupProperties2 = popupProperties;
                if (composerStartRestartGroup.changed(popupProperties2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((i2 & 32) != 0) {
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                }
                if ((374491 & i3) == 74898) {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f114 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f114), Dp.m5160constructorimpl(f114));
                    } else {
                        jM5181DpOffsetYgX7TsA = j2;
                    }
                    if (i6 != 0) {
                        popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                    } else {
                        popupProperties3 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                    }
                    int i111116 = i3 & 8190;
                    int i111117 = i3 << 3;
                    m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i111116 | (458752 & i111117) | (i111117 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    j3 = jM5181DpOffsetYgX7TsA;
                    popupProperties4 = popupProperties3;
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f115 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f115), Dp.m5160constructorimpl(f115));
                    } else {
                        jM5181DpOffsetYgX7TsA = j2;
                    }
                    if (i6 != 0) {
                        popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                    } else {
                        popupProperties3 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                    }
                    int i111118 = i3 & 8190;
                    int i111119 = i3 << 3;
                    m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i111118 | (458752 & i111119) | (i111119 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    j3 = jM5181DpOffsetYgX7TsA;
                    popupProperties4 = popupProperties3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$1(z, interfaceC3588op, modifier2, j3, popupProperties4, interfaceC0552Gp, i, i2));
            }
            i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i8;
            if ((374491 & i3) == 74898) {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    float f116 = 0;
                    jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f116), Dp.m5160constructorimpl(f116));
                } else {
                    jM5181DpOffsetYgX7TsA = j2;
                }
                if (i6 != 0) {
                    popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                } else {
                    popupProperties3 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                }
                int i1111110 = i3 & 8190;
                int i1111111 = i3 << 3;
                m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i1111110 | (458752 & i1111111) | (i1111111 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                j3 = jM5181DpOffsetYgX7TsA;
                popupProperties4 = popupProperties3;
            } else {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    float f117 = 0;
                    jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f117), Dp.m5160constructorimpl(f117));
                } else {
                    jM5181DpOffsetYgX7TsA = j2;
                }
                if (i6 != 0) {
                    popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                } else {
                    popupProperties3 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                }
                int i1111112 = i3 & 8190;
                int i1111113 = i3 << 3;
                m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i1111112 | (458752 & i1111113) | (i1111113 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                j3 = jM5181DpOffsetYgX7TsA;
                popupProperties4 = popupProperties3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$1(z, interfaceC3588op, modifier2, j3, popupProperties4, interfaceC0552Gp, i, i2));
        }
        i3 |= 24576;
        popupProperties2 = popupProperties;
        if ((i2 & 32) != 0) {
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
            }
            if ((374491 & i3) == 74898) {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    float f118 = 0;
                    jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f118), Dp.m5160constructorimpl(f118));
                } else {
                    jM5181DpOffsetYgX7TsA = j2;
                }
                if (i6 != 0) {
                    popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                } else {
                    popupProperties3 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                }
                int i1111114 = i3 & 8190;
                int i1111115 = i3 << 3;
                m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i1111114 | (458752 & i1111115) | (i1111115 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                j3 = jM5181DpOffsetYgX7TsA;
                popupProperties4 = popupProperties3;
            } else {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    float f119 = 0;
                    jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f119), Dp.m5160constructorimpl(f119));
                } else {
                    jM5181DpOffsetYgX7TsA = j2;
                }
                if (i6 != 0) {
                    popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                } else {
                    popupProperties3 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
                }
                int i1111116 = i3 & 8190;
                int i1111117 = i3 << 3;
                m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i1111116 | (458752 & i1111117) | (i1111117 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                j3 = jM5181DpOffsetYgX7TsA;
                popupProperties4 = popupProperties3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$1(z, interfaceC3588op, modifier2, j3, popupProperties4, interfaceC0552Gp, i, i2));
        }
        i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i3 |= i8;
        if ((374491 & i3) == 74898) {
            if (i9 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                float f1110 = 0;
                jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f1110), Dp.m5160constructorimpl(f1110));
            } else {
                jM5181DpOffsetYgX7TsA = j2;
            }
            if (i6 != 0) {
                popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
            } else {
                popupProperties3 = popupProperties2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
            }
            int i1111118 = i3 & 8190;
            int i1111119 = i3 << 3;
            m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i1111118 | (458752 & i1111119) | (i1111119 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            j3 = jM5181DpOffsetYgX7TsA;
            popupProperties4 = popupProperties3;
        } else {
            if (i9 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                float f1111 = 0;
                jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f1111), Dp.m5160constructorimpl(f1111));
            } else {
                jM5181DpOffsetYgX7TsA = j2;
            }
            if (i6 != 0) {
                popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
            } else {
                popupProperties3 = popupProperties2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)");
            }
            int i11111110 = i3 & 8190;
            int i11111111 = i3 << 3;
            m973DropdownMenu4kj_NE(z, interfaceC3588op, modifier3, jM5181DpOffsetYgX7TsA, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, interfaceC0552Gp, composerStartRestartGroup, i11111110 | (458752 & i11111111) | (i11111111 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            j3 = jM5181DpOffsetYgX7TsA;
            popupProperties4 = popupProperties3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$1(z, interfaceC3588op, modifier2, j3, popupProperties4, interfaceC0552Gp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0054  */
    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:33:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0073  */
    /* JADX WARN: Code duplicated, block: B:43:0x007b  */
    /* JADX WARN: Code duplicated, block: B:44:0x007e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:54:0x0098  */
    /* JADX WARN: Code duplicated, block: B:55:0x009b  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:78:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:80:0x00df  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:89:0x0111  */
    /* JADX WARN: Code duplicated, block: B:92:0x0130  */
    /* JADX WARN: Code duplicated, block: B:97:0x013f  */
    /* JADX WARN: Code duplicated, block: B:99:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void DropdownMenuItem(InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        int i6;
        PaddingValues paddingValues2;
        int i7;
        int i8;
        MutableInteractionSource mutableInteractionSource2;
        int i9;
        int i10;
        Modifier modifier3;
        boolean z3;
        PaddingValues dropdownMenuItemContentPadding;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier4;
        boolean z4;
        PaddingValues paddingValues3;
        Object objRememberedValue;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-1988562892);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC3588op) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 == 0) {
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
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 7168) == 0) {
                        paddingValues2 = paddingValues;
                        if (composerStartRestartGroup.changed(paddingValues2)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((57344 & i) == 0) {
                            mutableInteractionSource2 = mutableInteractionSource;
                            if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                                i9 = 16384;
                            } else {
                                i9 = 8192;
                            }
                            i3 |= i9;
                        }
                        if ((i2 & 32) != 0) {
                            if ((458752 & i) == 0) {
                                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                    i10 = 131072;
                                } else {
                                    i10 = 65536;
                                }
                            }
                            if ((374491 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                                if (i11 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i4 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (i6 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues2;
                                }
                                if (i8 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                                }
                                MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                mutableInteractionSource3 = mutableInteractionSource2;
                                modifier4 = modifier3;
                                z4 = z3;
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                modifier4 = modifier2;
                                z4 = z2;
                                paddingValues3 = paddingValues2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                        }
                        i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        i3 |= i10;
                        if ((374491 & i3) == 74898) {
                            if (i11 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                            }
                            MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier4 = modifier3;
                            z4 = z3;
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i11 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                            }
                            MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier4 = modifier3;
                            z4 = z3;
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                    }
                    i3 |= 24576;
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i2 & 32) != 0) {
                        if ((458752 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i10 = 131072;
                            } else {
                                i10 = 65536;
                            }
                        }
                        if ((374491 & i3) == 74898) {
                            if (i11 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                            }
                            MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier4 = modifier3;
                            z4 = z3;
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i11 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                            }
                            MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier4 = modifier3;
                            z4 = z3;
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                    }
                    i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i3 |= i10;
                    if ((374491 & i3) == 74898) {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                }
                i3 |= 3072;
                paddingValues2 = paddingValues;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((57344 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i2 & 32) != 0) {
                        if ((458752 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i10 = 131072;
                            } else {
                                i10 = 65536;
                            }
                        }
                        if ((374491 & i3) == 74898) {
                            if (i11 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                            }
                            MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier4 = modifier3;
                            z4 = z3;
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i11 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                            }
                            MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier4 = modifier3;
                            z4 = z3;
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                    }
                    i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i3 |= i10;
                    if ((374491 & i3) == 74898) {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 32) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                    }
                    if ((374491 & i3) == 74898) {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                }
                i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i10;
                if ((374491 & i3) == 74898) {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                    paddingValues3 = dropdownMenuItemContentPadding;
                } else {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                    paddingValues3 = dropdownMenuItemContentPadding;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
            }
            i3 |= 384;
            z2 = z;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((57344 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i2 & 32) != 0) {
                        if ((458752 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i10 = 131072;
                            } else {
                                i10 = 65536;
                            }
                        }
                        if ((374491 & i3) == 74898) {
                            if (i11 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                            }
                            MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier4 = modifier3;
                            z4 = z3;
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i11 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                            }
                            MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier4 = modifier3;
                            z4 = z3;
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                    }
                    i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i3 |= i10;
                    if ((374491 & i3) == 74898) {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 32) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                    }
                    if ((374491 & i3) == 74898) {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                }
                i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i10;
                if ((374491 & i3) == 74898) {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                    paddingValues3 = dropdownMenuItemContentPadding;
                } else {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                    paddingValues3 = dropdownMenuItemContentPadding;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
            }
            i3 |= 3072;
            paddingValues2 = paddingValues;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((57344 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i2 & 32) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                    }
                    if ((374491 & i3) == 74898) {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                }
                i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i10;
                if ((374491 & i3) == 74898) {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                    paddingValues3 = dropdownMenuItemContentPadding;
                } else {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                    paddingValues3 = dropdownMenuItemContentPadding;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 32) != 0) {
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                }
                if ((374491 & i3) == 74898) {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                    paddingValues3 = dropdownMenuItemContentPadding;
                } else {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                    paddingValues3 = dropdownMenuItemContentPadding;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
            }
            i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i10;
            if ((374491 & i3) == 74898) {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                }
                MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier4 = modifier3;
                z4 = z3;
                paddingValues3 = dropdownMenuItemContentPadding;
            } else {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                }
                MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier4 = modifier3;
                z4 = z3;
                paddingValues3 = dropdownMenuItemContentPadding;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
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
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((57344 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i2 & 32) != 0) {
                        if ((458752 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i10 = 131072;
                            } else {
                                i10 = 65536;
                            }
                        }
                        if ((374491 & i3) == 74898) {
                            if (i11 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                            }
                            MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier4 = modifier3;
                            z4 = z3;
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i11 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                            }
                            MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier4 = modifier3;
                            z4 = z3;
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                    }
                    i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i3 |= i10;
                    if ((374491 & i3) == 74898) {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 32) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                    }
                    if ((374491 & i3) == 74898) {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                }
                i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i10;
                if ((374491 & i3) == 74898) {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                    paddingValues3 = dropdownMenuItemContentPadding;
                } else {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                    paddingValues3 = dropdownMenuItemContentPadding;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
            }
            i3 |= 3072;
            paddingValues2 = paddingValues;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((57344 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i2 & 32) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                    }
                    if ((374491 & i3) == 74898) {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                }
                i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i10;
                if ((374491 & i3) == 74898) {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                    paddingValues3 = dropdownMenuItemContentPadding;
                } else {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                    paddingValues3 = dropdownMenuItemContentPadding;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 32) != 0) {
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                }
                if ((374491 & i3) == 74898) {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                    paddingValues3 = dropdownMenuItemContentPadding;
                } else {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                    paddingValues3 = dropdownMenuItemContentPadding;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
            }
            i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i10;
            if ((374491 & i3) == 74898) {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                }
                MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier4 = modifier3;
                z4 = z3;
                paddingValues3 = dropdownMenuItemContentPadding;
            } else {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                }
                MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier4 = modifier3;
                z4 = z3;
                paddingValues3 = dropdownMenuItemContentPadding;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
        }
        i3 |= 384;
        z2 = z;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 7168) == 0) {
                paddingValues2 = paddingValues;
                if (composerStartRestartGroup.changed(paddingValues2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((57344 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i2 & 32) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                    }
                    if ((374491 & i3) == 74898) {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                }
                i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i10;
                if ((374491 & i3) == 74898) {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                    paddingValues3 = dropdownMenuItemContentPadding;
                } else {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                    paddingValues3 = dropdownMenuItemContentPadding;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 32) != 0) {
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                }
                if ((374491 & i3) == 74898) {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                    paddingValues3 = dropdownMenuItemContentPadding;
                } else {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                    paddingValues3 = dropdownMenuItemContentPadding;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
            }
            i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i10;
            if ((374491 & i3) == 74898) {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                }
                MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier4 = modifier3;
                z4 = z3;
                paddingValues3 = dropdownMenuItemContentPadding;
            } else {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                }
                MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier4 = modifier3;
                z4 = z3;
                paddingValues3 = dropdownMenuItemContentPadding;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
        }
        i3 |= 3072;
        paddingValues2 = paddingValues;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((57344 & i) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((i2 & 32) != 0) {
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                }
                if ((374491 & i3) == 74898) {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                    paddingValues3 = dropdownMenuItemContentPadding;
                } else {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                    paddingValues3 = dropdownMenuItemContentPadding;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
            }
            i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i10;
            if ((374491 & i3) == 74898) {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                }
                MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier4 = modifier3;
                z4 = z3;
                paddingValues3 = dropdownMenuItemContentPadding;
            } else {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                }
                MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier4 = modifier3;
                z4 = z3;
                paddingValues3 = dropdownMenuItemContentPadding;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
        }
        i3 |= 24576;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 32) != 0) {
            if ((458752 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i10 = 131072;
                } else {
                    i10 = 65536;
                }
            }
            if ((374491 & i3) == 74898) {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                }
                MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier4 = modifier3;
                z4 = z3;
                paddingValues3 = dropdownMenuItemContentPadding;
            } else {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
                }
                MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier4 = modifier3;
                z4 = z3;
                paddingValues3 = dropdownMenuItemContentPadding;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
        }
        i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i3 |= i10;
        if ((374491 & i3) == 74898) {
            if (i11 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                z3 = true;
            } else {
                z3 = z2;
            }
            if (i6 != 0) {
                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
            } else {
                dropdownMenuItemContentPadding = paddingValues2;
            }
            if (i8 != 0) {
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
            }
            MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            mutableInteractionSource3 = mutableInteractionSource2;
            modifier4 = modifier3;
            z4 = z3;
            paddingValues3 = dropdownMenuItemContentPadding;
        } else {
            if (i11 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                z3 = true;
            } else {
                z3 = z2;
            }
            if (i6 != 0) {
                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
            } else {
                dropdownMenuItemContentPadding = paddingValues2;
            }
            if (i8 != 0) {
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)");
            }
            MenuKt.DropdownMenuItemContent(interfaceC3588op, modifier3, z3, dropdownMenuItemContentPadding, mutableInteractionSource2, interfaceC0552Gp, composerStartRestartGroup, i3 & 524286, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            mutableInteractionSource3 = mutableInteractionSource2;
            modifier4 = modifier3;
            z4 = z3;
            paddingValues3 = dropdownMenuItemContentPadding;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, modifier4, z4, paddingValues3, mutableInteractionSource3, interfaceC0552Gp, i, i2));
    }
}
