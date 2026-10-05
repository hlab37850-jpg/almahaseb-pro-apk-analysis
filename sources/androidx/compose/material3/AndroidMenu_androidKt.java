package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
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

    /* JADX INFO: renamed from: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenuItem$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ MenuItemColors $colors;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ InterfaceC0526Fp $leadingIcon;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3588op $onClick;
        final /* synthetic */ InterfaceC0526Fp $text;
        final /* synthetic */ InterfaceC0526Fp $trailingIcon;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC0526Fp interfaceC0526Fp, InterfaceC3588op interfaceC3588op, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, boolean z, MenuItemColors menuItemColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, int i, int i2) {
            super(2);
            this.$text = interfaceC0526Fp;
            this.$onClick = interfaceC3588op;
            this.$modifier = modifier;
            this.$leadingIcon = interfaceC0526Fp2;
            this.$trailingIcon = interfaceC0526Fp3;
            this.$enabled = z;
            this.$colors = menuItemColors;
            this.$contentPadding = paddingValues;
            this.$interactionSource = mutableInteractionSource;
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
            AndroidMenu_androidKt.DropdownMenuItem(this.$text, this.$onClick, this.$modifier, this.$leadingIcon, this.$trailingIcon, this.$enabled, this.$colors, this.$contentPadding, this.$interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:105:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x006a  */
    /* JADX WARN: Code duplicated, block: B:37:0x006f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0075  */
    /* JADX WARN: Code duplicated, block: B:41:0x007b  */
    /* JADX WARN: Code duplicated, block: B:42:0x007e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0085  */
    /* JADX WARN: Code duplicated, block: B:48:0x008a  */
    /* JADX WARN: Code duplicated, block: B:50:0x0090  */
    /* JADX WARN: Code duplicated, block: B:52:0x0098  */
    /* JADX WARN: Code duplicated, block: B:53:0x009b  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:76:0x00db  */
    /* JADX WARN: Code duplicated, block: B:78:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:81:0x010a  */
    /* JADX WARN: Code duplicated, block: B:84:0x0122  */
    /* JADX WARN: Code duplicated, block: B:87:0x0144  */
    /* JADX WARN: Code duplicated, block: B:89:0x0150  */
    /* JADX WARN: Code duplicated, block: B:91:0x015d  */
    /* JADX WARN: Code duplicated, block: B:94:0x0192  */
    /* JADX WARN: Code duplicated, block: B:96:0x0198  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: DropdownMenu-ILWXrKs, reason: not valid java name */
    public static final void m1328DropdownMenuILWXrKs(boolean z, InterfaceC3588op interfaceC3588op, Modifier modifier, long j, PopupProperties popupProperties, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        long jM5181DpOffsetYgX7TsA;
        int i5;
        int i6;
        PopupProperties popupProperties2;
        int i7;
        int i8;
        int i9;
        Modifier modifier3;
        Object objRememberedValue;
        Composer.Companion companion;
        MutableTransitionState mutableTransitionState;
        Object objRememberedValue2;
        MutableState mutableState;
        boolean zChanged;
        Object objRememberedValue3;
        long j2;
        PopupProperties popupProperties3;
        Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC3588op, "onDismissRequest");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(354826666);
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
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i8 = 131072;
                        } else {
                            i8 = 65536;
                        }
                    }
                    i9 = i3;
                    if ((374491 & i9) == 74898 || !composerStartRestartGroup.getSkipping()) {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            float f = 0;
                            jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f), Dp.m5160constructorimpl(f));
                        }
                        if (i6 != 0) {
                            popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(354826666, i9, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:73)");
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
                            AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j2 = jM5181DpOffsetYgX7TsA;
                        popupProperties3 = popupProperties2;
                        modifier4 = modifier3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier4 = modifier2;
                        j2 = jM5181DpOffsetYgX7TsA;
                        popupProperties3 = popupProperties2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$2(z, interfaceC3588op, modifier4, j2, popupProperties3, interfaceC0552Gp, i, i2));
                }
                i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i8;
                i9 = i3;
                if ((374491 & i9) == 74898) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f2 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f2), Dp.m5160constructorimpl(f2));
                    }
                    if (i6 != 0) {
                        popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(354826666, i9, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:73)");
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
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density2, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
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
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density3, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j2 = jM5181DpOffsetYgX7TsA;
                    popupProperties3 = popupProperties2;
                    modifier4 = modifier3;
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
                    if (i6 != 0) {
                        popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(354826666, i9, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:73)");
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
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density4, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
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
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density5, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j2 = jM5181DpOffsetYgX7TsA;
                    popupProperties3 = popupProperties2;
                    modifier4 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$2(z, interfaceC3588op, modifier4, j2, popupProperties3, interfaceC0552Gp, i, i2));
            }
            i3 |= 24576;
            popupProperties2 = popupProperties;
            if ((i2 & 32) != 0) {
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                }
                i9 = i3;
                if ((374491 & i9) == 74898) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f4 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f4), Dp.m5160constructorimpl(f4));
                    }
                    if (i6 != 0) {
                        popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(354826666, i9, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:73)");
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
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density6, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
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
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density7, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j2 = jM5181DpOffsetYgX7TsA;
                    popupProperties3 = popupProperties2;
                    modifier4 = modifier3;
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
                    if (i6 != 0) {
                        popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(354826666, i9, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:73)");
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
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density8, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
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
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density9, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j2 = jM5181DpOffsetYgX7TsA;
                    popupProperties3 = popupProperties2;
                    modifier4 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$2(z, interfaceC3588op, modifier4, j2, popupProperties3, interfaceC0552Gp, i, i2));
            }
            i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i8;
            i9 = i3;
            if ((374491 & i9) == 74898) {
                if (i10 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    float f6 = 0;
                    jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f6), Dp.m5160constructorimpl(f6));
                }
                if (i6 != 0) {
                    popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(354826666, i9, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:73)");
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
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density10, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
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
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density11, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j2 = jM5181DpOffsetYgX7TsA;
                popupProperties3 = popupProperties2;
                modifier4 = modifier3;
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
                if (i6 != 0) {
                    popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(354826666, i9, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:73)");
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
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density12, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
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
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density13, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j2 = jM5181DpOffsetYgX7TsA;
                popupProperties3 = popupProperties2;
                modifier4 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$2(z, interfaceC3588op, modifier4, j2, popupProperties3, interfaceC0552Gp, i, i2));
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
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                }
                i9 = i3;
                if ((374491 & i9) == 74898) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        float f8 = 0;
                        jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f8), Dp.m5160constructorimpl(f8));
                    }
                    if (i6 != 0) {
                        popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(354826666, i9, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:73)");
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
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density14, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
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
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density15, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j2 = jM5181DpOffsetYgX7TsA;
                    popupProperties3 = popupProperties2;
                    modifier4 = modifier3;
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
                    if (i6 != 0) {
                        popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(354826666, i9, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:73)");
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
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density16, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
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
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density17, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j2 = jM5181DpOffsetYgX7TsA;
                    popupProperties3 = popupProperties2;
                    modifier4 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$2(z, interfaceC3588op, modifier4, j2, popupProperties3, interfaceC0552Gp, i, i2));
            }
            i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i8;
            i9 = i3;
            if ((374491 & i9) == 74898) {
                if (i10 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    float f10 = 0;
                    jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f10), Dp.m5160constructorimpl(f10));
                }
                if (i6 != 0) {
                    popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(354826666, i9, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:73)");
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
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density18, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
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
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density19, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j2 = jM5181DpOffsetYgX7TsA;
                popupProperties3 = popupProperties2;
                modifier4 = modifier3;
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
                if (i6 != 0) {
                    popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(354826666, i9, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:73)");
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
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density110, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
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
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density111, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j2 = jM5181DpOffsetYgX7TsA;
                popupProperties3 = popupProperties2;
                modifier4 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$2(z, interfaceC3588op, modifier4, j2, popupProperties3, interfaceC0552Gp, i, i2));
        }
        i3 |= 24576;
        popupProperties2 = popupProperties;
        if ((i2 & 32) != 0) {
            if ((458752 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
            }
            i9 = i3;
            if ((374491 & i9) == 74898) {
                if (i10 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    float f12 = 0;
                    jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f12), Dp.m5160constructorimpl(f12));
                }
                if (i6 != 0) {
                    popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(354826666, i9, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:73)");
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
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density112, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
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
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density113, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j2 = jM5181DpOffsetYgX7TsA;
                popupProperties3 = popupProperties2;
                modifier4 = modifier3;
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
                if (i6 != 0) {
                    popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(354826666, i9, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:73)");
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
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density114, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
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
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density115, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j2 = jM5181DpOffsetYgX7TsA;
                popupProperties3 = popupProperties2;
                modifier4 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$2(z, interfaceC3588op, modifier4, j2, popupProperties3, interfaceC0552Gp, i, i2));
        }
        i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i3 |= i8;
        i9 = i3;
        if ((374491 & i9) == 74898) {
            if (i10 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                float f14 = 0;
                jM5181DpOffsetYgX7TsA = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f14), Dp.m5160constructorimpl(f14));
            }
            if (i6 != 0) {
                popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(354826666, i9, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:73)");
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
                AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density116, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
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
                AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density117, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j2 = jM5181DpOffsetYgX7TsA;
            popupProperties3 = popupProperties2;
            modifier4 = modifier3;
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
            if (i6 != 0) {
                popupProperties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(354826666, i9, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:73)");
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
                AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density118, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
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
                AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM5181DpOffsetYgX7TsA, density119, (InterfaceC0526Fp) objRememberedValue3, null), interfaceC3588op, popupProperties2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new AndroidMenu_androidKt$DropdownMenu$1(mutableTransitionState, mutableState, modifier3, interfaceC0552Gp, i9)), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 6) & 896), 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j2 = jM5181DpOffsetYgX7TsA;
            popupProperties3 = popupProperties2;
            modifier4 = modifier3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenu$2(z, interfaceC3588op, modifier4, j2, popupProperties3, interfaceC0552Gp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0120  */
    /* JADX WARN: Code duplicated, block: B:104:0x013a  */
    /* JADX WARN: Code duplicated, block: B:106:0x0144  */
    /* JADX WARN: Code duplicated, block: B:113:0x0163 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:114:0x0165  */
    /* JADX WARN: Code duplicated, block: B:115:0x0168  */
    /* JADX WARN: Code duplicated, block: B:118:0x016d  */
    /* JADX WARN: Code duplicated, block: B:119:0x016f  */
    /* JADX WARN: Code duplicated, block: B:122:0x0174  */
    /* JADX WARN: Code duplicated, block: B:124:0x0178  */
    /* JADX WARN: Code duplicated, block: B:125:0x017a  */
    /* JADX WARN: Code duplicated, block: B:128:0x017f  */
    /* JADX WARN: Code duplicated, block: B:129:0x0199  */
    /* JADX WARN: Code duplicated, block: B:131:0x019c  */
    /* JADX WARN: Code duplicated, block: B:132:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:134:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:136:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:139:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:142:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:145:0x020f  */
    /* JADX WARN: Code duplicated, block: B:150:0x0226  */
    /* JADX WARN: Code duplicated, block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:38:0x006d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:43:0x007c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0083  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088  */
    /* JADX WARN: Code duplicated, block: B:51:0x008e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0096  */
    /* JADX WARN: Code duplicated, block: B:54:0x0099  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00be  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:80:0x00da  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:91:0x0101  */
    /* JADX WARN: Code duplicated, block: B:93:0x0109  */
    /* JADX WARN: Code duplicated, block: B:95:0x010f  */
    /* JADX WARN: Code duplicated, block: B:96:0x0112  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void DropdownMenuItem(InterfaceC0526Fp interfaceC0526Fp, InterfaceC3588op interfaceC3588op, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, boolean z, MenuItemColors menuItemColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Composer composer, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z2;
        int i9;
        MenuItemColors menuItemColors2;
        int i10;
        int i11;
        int i12;
        int i13;
        Modifier modifier2;
        InterfaceC0526Fp interfaceC0526Fp4;
        boolean z3;
        MenuItemColors menuItemColorsM1644itemColors5tl4gsc;
        PaddingValues dropdownMenuItemContentPadding;
        MutableInteractionSource mutableInteractionSource2;
        InterfaceC0526Fp interfaceC0526Fp5;
        InterfaceC0526Fp interfaceC0526Fp6;
        boolean z4;
        MenuItemColors menuItemColors3;
        Object objRememberedValue;
        Modifier modifier3;
        InterfaceC0526Fp interfaceC0526Fp7;
        InterfaceC0526Fp interfaceC0526Fp8;
        boolean z5;
        MenuItemColors menuItemColors4;
        PaddingValues paddingValues2;
        MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0526Fp, "text");
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1826340448);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC3588op) ? 32 : 16;
        }
        int i14 = i2 & 4;
        if (i14 == 0) {
            if ((i & 896) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((57344 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 32;
                    if (i8 != 0) {
                        if ((458752 & i) == 0) {
                            z2 = z;
                            if (composerStartRestartGroup.changed(z2)) {
                                i9 = 131072;
                            } else {
                                i9 = 65536;
                            }
                            i3 |= i9;
                        }
                        if ((3670016 & i) == 0) {
                            if ((i2 & 64) == 0) {
                                menuItemColors2 = menuItemColors;
                                int i15 = composerStartRestartGroup.changed(menuItemColors2) ? 1048576 : 524288;
                                i3 |= i15;
                            } else {
                                menuItemColors2 = menuItemColors;
                            }
                            i3 |= i15;
                        } else {
                            menuItemColors2 = menuItemColors;
                        }
                        i10 = i2 & 128;
                        if (i10 != 0) {
                            i3 |= 12582912;
                        } else if ((i & 29360128) == 0) {
                            if (composerStartRestartGroup.changed(paddingValues)) {
                                i11 = 8388608;
                            } else {
                                i11 = 4194304;
                            }
                            i3 |= i11;
                        }
                        i12 = i2 & 256;
                        if (i12 != 0) {
                            i3 |= 100663296;
                        } else if ((i & 234881024) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = 67108864;
                            } else {
                                i13 = 33554432;
                            }
                            i3 |= i13;
                        }
                        if ((i3 & 191739611) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    interfaceC0526Fp4 = null;
                                } else {
                                    interfaceC0526Fp4 = interfaceC0526Fp2;
                                }
                                InterfaceC0526Fp interfaceC0526Fp9 = i6 == 0 ? interfaceC0526Fp3 : null;
                                if (i8 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if ((i2 & 64) != 0) {
                                    menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                    i3 &= -3670017;
                                } else {
                                    menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource2 = mutableInteractionSource;
                                }
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                interfaceC0526Fp6 = interfaceC0526Fp9;
                                z4 = z3;
                                menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                interfaceC0526Fp5 = interfaceC0526Fp2;
                                interfaceC0526Fp6 = interfaceC0526Fp3;
                                dropdownMenuItemContentPadding = paddingValues;
                                mutableInteractionSource2 = mutableInteractionSource;
                                z4 = z2;
                                menuItemColors3 = menuItemColors2;
                                modifier2 = modifier;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                            }
                            MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            interfaceC0526Fp7 = interfaceC0526Fp5;
                            interfaceC0526Fp8 = interfaceC0526Fp6;
                            z5 = z4;
                            menuItemColors4 = menuItemColors3;
                            paddingValues2 = dropdownMenuItemContentPadding;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier;
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                            paddingValues2 = paddingValues;
                            z5 = z2;
                            menuItemColors4 = menuItemColors2;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC0526Fp, interfaceC3588op, modifier3, interfaceC0526Fp7, interfaceC0526Fp8, z5, menuItemColors4, paddingValues2, mutableInteractionSource3, i, i2));
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    z2 = z;
                    if ((3670016 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            menuItemColors2 = menuItemColors;
                            if (composerStartRestartGroup.changed(menuItemColors2)) {
                            }
                            i3 |= i15;
                        } else {
                            menuItemColors2 = menuItemColors;
                        }
                        i3 |= i15;
                    } else {
                        menuItemColors2 = menuItemColors;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 256;
                    if (i12 != 0) {
                        i3 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i3 |= i13;
                    }
                    if ((i3 & 191739611) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp2;
                            }
                            if (i6 == 0) {
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if ((i2 & 64) != 0) {
                                menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            interfaceC0526Fp6 = interfaceC0526Fp9;
                            z4 = z3;
                            menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp2;
                            }
                            if (i6 == 0) {
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if ((i2 & 64) != 0) {
                                menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            interfaceC0526Fp6 = interfaceC0526Fp9;
                            z4 = z3;
                            menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        z5 = z4;
                        menuItemColors4 = menuItemColors3;
                        paddingValues2 = dropdownMenuItemContentPadding;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp2;
                            }
                            if (i6 == 0) {
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if ((i2 & 64) != 0) {
                                menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            interfaceC0526Fp6 = interfaceC0526Fp9;
                            z4 = z3;
                            menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp2;
                            }
                            if (i6 == 0) {
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if ((i2 & 64) != 0) {
                                menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            interfaceC0526Fp6 = interfaceC0526Fp9;
                            z4 = z3;
                            menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        z5 = z4;
                        menuItemColors4 = menuItemColors3;
                        paddingValues2 = dropdownMenuItemContentPadding;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC0526Fp, interfaceC3588op, modifier3, interfaceC0526Fp7, interfaceC0526Fp8, z5, menuItemColors4, paddingValues2, mutableInteractionSource3, i, i2));
                }
                i3 |= 24576;
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((458752 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((3670016 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            menuItemColors2 = menuItemColors;
                            if (composerStartRestartGroup.changed(menuItemColors2)) {
                            }
                            i3 |= i15;
                        } else {
                            menuItemColors2 = menuItemColors;
                        }
                        i3 |= i15;
                    } else {
                        menuItemColors2 = menuItemColors;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 256;
                    if (i12 != 0) {
                        i3 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i3 |= i13;
                    }
                    if ((i3 & 191739611) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp2;
                            }
                            if (i6 == 0) {
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if ((i2 & 64) != 0) {
                                menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            interfaceC0526Fp6 = interfaceC0526Fp9;
                            z4 = z3;
                            menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp2;
                            }
                            if (i6 == 0) {
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if ((i2 & 64) != 0) {
                                menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            interfaceC0526Fp6 = interfaceC0526Fp9;
                            z4 = z3;
                            menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        z5 = z4;
                        menuItemColors4 = menuItemColors3;
                        paddingValues2 = dropdownMenuItemContentPadding;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp2;
                            }
                            if (i6 == 0) {
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if ((i2 & 64) != 0) {
                                menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            interfaceC0526Fp6 = interfaceC0526Fp9;
                            z4 = z3;
                            menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp2;
                            }
                            if (i6 == 0) {
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if ((i2 & 64) != 0) {
                                menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            interfaceC0526Fp6 = interfaceC0526Fp9;
                            z4 = z3;
                            menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        z5 = z4;
                        menuItemColors4 = menuItemColors3;
                        paddingValues2 = dropdownMenuItemContentPadding;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC0526Fp, interfaceC3588op, modifier3, interfaceC0526Fp7, interfaceC0526Fp8, z5, menuItemColors4, paddingValues2, mutableInteractionSource3, i, i2));
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z2 = z;
                if ((3670016 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        menuItemColors2 = menuItemColors;
                        if (composerStartRestartGroup.changed(menuItemColors2)) {
                        }
                        i3 |= i15;
                    } else {
                        menuItemColors2 = menuItemColors;
                    }
                    i3 |= i15;
                } else {
                    menuItemColors2 = menuItemColors;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 256;
                if (i12 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i3 |= i13;
                }
                if ((i3 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                        }
                        if (i6 == 0) {
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        interfaceC0526Fp6 = interfaceC0526Fp9;
                        z4 = z3;
                        menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                        }
                        if (i6 == 0) {
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        interfaceC0526Fp6 = interfaceC0526Fp9;
                        z4 = z3;
                        menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    z5 = z4;
                    menuItemColors4 = menuItemColors3;
                    paddingValues2 = dropdownMenuItemContentPadding;
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                        }
                        if (i6 == 0) {
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        interfaceC0526Fp6 = interfaceC0526Fp9;
                        z4 = z3;
                        menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                        }
                        if (i6 == 0) {
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        interfaceC0526Fp6 = interfaceC0526Fp9;
                        z4 = z3;
                        menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    z5 = z4;
                    menuItemColors4 = menuItemColors3;
                    paddingValues2 = dropdownMenuItemContentPadding;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC0526Fp, interfaceC3588op, modifier3, interfaceC0526Fp7, interfaceC0526Fp8, z5, menuItemColors4, paddingValues2, mutableInteractionSource3, i, i2));
            }
            i3 |= 3072;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((57344 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((458752 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((3670016 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            menuItemColors2 = menuItemColors;
                            if (composerStartRestartGroup.changed(menuItemColors2)) {
                            }
                            i3 |= i15;
                        } else {
                            menuItemColors2 = menuItemColors;
                        }
                        i3 |= i15;
                    } else {
                        menuItemColors2 = menuItemColors;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 256;
                    if (i12 != 0) {
                        i3 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i3 |= i13;
                    }
                    if ((i3 & 191739611) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp2;
                            }
                            if (i6 == 0) {
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if ((i2 & 64) != 0) {
                                menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            interfaceC0526Fp6 = interfaceC0526Fp9;
                            z4 = z3;
                            menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp2;
                            }
                            if (i6 == 0) {
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if ((i2 & 64) != 0) {
                                menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            interfaceC0526Fp6 = interfaceC0526Fp9;
                            z4 = z3;
                            menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        z5 = z4;
                        menuItemColors4 = menuItemColors3;
                        paddingValues2 = dropdownMenuItemContentPadding;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp2;
                            }
                            if (i6 == 0) {
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if ((i2 & 64) != 0) {
                                menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            interfaceC0526Fp6 = interfaceC0526Fp9;
                            z4 = z3;
                            menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp2;
                            }
                            if (i6 == 0) {
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if ((i2 & 64) != 0) {
                                menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            interfaceC0526Fp6 = interfaceC0526Fp9;
                            z4 = z3;
                            menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        z5 = z4;
                        menuItemColors4 = menuItemColors3;
                        paddingValues2 = dropdownMenuItemContentPadding;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC0526Fp, interfaceC3588op, modifier3, interfaceC0526Fp7, interfaceC0526Fp8, z5, menuItemColors4, paddingValues2, mutableInteractionSource3, i, i2));
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z2 = z;
                if ((3670016 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        menuItemColors2 = menuItemColors;
                        if (composerStartRestartGroup.changed(menuItemColors2)) {
                        }
                        i3 |= i15;
                    } else {
                        menuItemColors2 = menuItemColors;
                    }
                    i3 |= i15;
                } else {
                    menuItemColors2 = menuItemColors;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 256;
                if (i12 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i3 |= i13;
                }
                if ((i3 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                        }
                        if (i6 == 0) {
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        interfaceC0526Fp6 = interfaceC0526Fp9;
                        z4 = z3;
                        menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                        }
                        if (i6 == 0) {
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        interfaceC0526Fp6 = interfaceC0526Fp9;
                        z4 = z3;
                        menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    z5 = z4;
                    menuItemColors4 = menuItemColors3;
                    paddingValues2 = dropdownMenuItemContentPadding;
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                        }
                        if (i6 == 0) {
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        interfaceC0526Fp6 = interfaceC0526Fp9;
                        z4 = z3;
                        menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                        }
                        if (i6 == 0) {
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        interfaceC0526Fp6 = interfaceC0526Fp9;
                        z4 = z3;
                        menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    z5 = z4;
                    menuItemColors4 = menuItemColors3;
                    paddingValues2 = dropdownMenuItemContentPadding;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC0526Fp, interfaceC3588op, modifier3, interfaceC0526Fp7, interfaceC0526Fp8, z5, menuItemColors4, paddingValues2, mutableInteractionSource3, i, i2));
            }
            i3 |= 24576;
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((458752 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((3670016 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        menuItemColors2 = menuItemColors;
                        if (composerStartRestartGroup.changed(menuItemColors2)) {
                        }
                        i3 |= i15;
                    } else {
                        menuItemColors2 = menuItemColors;
                    }
                    i3 |= i15;
                } else {
                    menuItemColors2 = menuItemColors;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 256;
                if (i12 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i3 |= i13;
                }
                if ((i3 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                        }
                        if (i6 == 0) {
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        interfaceC0526Fp6 = interfaceC0526Fp9;
                        z4 = z3;
                        menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                        }
                        if (i6 == 0) {
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        interfaceC0526Fp6 = interfaceC0526Fp9;
                        z4 = z3;
                        menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    z5 = z4;
                    menuItemColors4 = menuItemColors3;
                    paddingValues2 = dropdownMenuItemContentPadding;
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                        }
                        if (i6 == 0) {
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        interfaceC0526Fp6 = interfaceC0526Fp9;
                        z4 = z3;
                        menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                        }
                        if (i6 == 0) {
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        interfaceC0526Fp6 = interfaceC0526Fp9;
                        z4 = z3;
                        menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    z5 = z4;
                    menuItemColors4 = menuItemColors3;
                    paddingValues2 = dropdownMenuItemContentPadding;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC0526Fp, interfaceC3588op, modifier3, interfaceC0526Fp7, interfaceC0526Fp8, z5, menuItemColors4, paddingValues2, mutableInteractionSource3, i, i2));
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z2 = z;
            if ((3670016 & i) == 0) {
                if ((i2 & 64) == 0) {
                    menuItemColors2 = menuItemColors;
                    if (composerStartRestartGroup.changed(menuItemColors2)) {
                    }
                    i3 |= i15;
                } else {
                    menuItemColors2 = menuItemColors;
                }
                i3 |= i15;
            } else {
                menuItemColors2 = menuItemColors;
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            i12 = i2 & 256;
            if (i12 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i3 |= i13;
            }
            if ((i3 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp2;
                    }
                    if (i6 == 0) {
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 64) != 0) {
                        menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    interfaceC0526Fp6 = interfaceC0526Fp9;
                    z4 = z3;
                    menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp2;
                    }
                    if (i6 == 0) {
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 64) != 0) {
                        menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    interfaceC0526Fp6 = interfaceC0526Fp9;
                    z4 = z3;
                    menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                }
                MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                interfaceC0526Fp7 = interfaceC0526Fp5;
                interfaceC0526Fp8 = interfaceC0526Fp6;
                z5 = z4;
                menuItemColors4 = menuItemColors3;
                paddingValues2 = dropdownMenuItemContentPadding;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp2;
                    }
                    if (i6 == 0) {
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 64) != 0) {
                        menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    interfaceC0526Fp6 = interfaceC0526Fp9;
                    z4 = z3;
                    menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp2;
                    }
                    if (i6 == 0) {
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 64) != 0) {
                        menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    interfaceC0526Fp6 = interfaceC0526Fp9;
                    z4 = z3;
                    menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                }
                MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                interfaceC0526Fp7 = interfaceC0526Fp5;
                interfaceC0526Fp8 = interfaceC0526Fp6;
                z5 = z4;
                menuItemColors4 = menuItemColors3;
                paddingValues2 = dropdownMenuItemContentPadding;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC0526Fp, interfaceC3588op, modifier3, interfaceC0526Fp7, interfaceC0526Fp8, z5, menuItemColors4, paddingValues2, mutableInteractionSource3, i, i2));
        }
        i3 |= 384;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((57344 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((458752 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((3670016 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            menuItemColors2 = menuItemColors;
                            if (composerStartRestartGroup.changed(menuItemColors2)) {
                            }
                            i3 |= i15;
                        } else {
                            menuItemColors2 = menuItemColors;
                        }
                        i3 |= i15;
                    } else {
                        menuItemColors2 = menuItemColors;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 256;
                    if (i12 != 0) {
                        i3 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i3 |= i13;
                    }
                    if ((i3 & 191739611) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp2;
                            }
                            if (i6 == 0) {
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if ((i2 & 64) != 0) {
                                menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            interfaceC0526Fp6 = interfaceC0526Fp9;
                            z4 = z3;
                            menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp2;
                            }
                            if (i6 == 0) {
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if ((i2 & 64) != 0) {
                                menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            interfaceC0526Fp6 = interfaceC0526Fp9;
                            z4 = z3;
                            menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        z5 = z4;
                        menuItemColors4 = menuItemColors3;
                        paddingValues2 = dropdownMenuItemContentPadding;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp2;
                            }
                            if (i6 == 0) {
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if ((i2 & 64) != 0) {
                                menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            interfaceC0526Fp6 = interfaceC0526Fp9;
                            z4 = z3;
                            menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp2;
                            }
                            if (i6 == 0) {
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if ((i2 & 64) != 0) {
                                menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                i3 &= -3670017;
                            } else {
                                menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            interfaceC0526Fp6 = interfaceC0526Fp9;
                            z4 = z3;
                            menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                        }
                        MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        z5 = z4;
                        menuItemColors4 = menuItemColors3;
                        paddingValues2 = dropdownMenuItemContentPadding;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC0526Fp, interfaceC3588op, modifier3, interfaceC0526Fp7, interfaceC0526Fp8, z5, menuItemColors4, paddingValues2, mutableInteractionSource3, i, i2));
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z2 = z;
                if ((3670016 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        menuItemColors2 = menuItemColors;
                        if (composerStartRestartGroup.changed(menuItemColors2)) {
                        }
                        i3 |= i15;
                    } else {
                        menuItemColors2 = menuItemColors;
                    }
                    i3 |= i15;
                } else {
                    menuItemColors2 = menuItemColors;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 256;
                if (i12 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i3 |= i13;
                }
                if ((i3 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                        }
                        if (i6 == 0) {
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        interfaceC0526Fp6 = interfaceC0526Fp9;
                        z4 = z3;
                        menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                        }
                        if (i6 == 0) {
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        interfaceC0526Fp6 = interfaceC0526Fp9;
                        z4 = z3;
                        menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    z5 = z4;
                    menuItemColors4 = menuItemColors3;
                    paddingValues2 = dropdownMenuItemContentPadding;
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                        }
                        if (i6 == 0) {
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        interfaceC0526Fp6 = interfaceC0526Fp9;
                        z4 = z3;
                        menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                        }
                        if (i6 == 0) {
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        interfaceC0526Fp6 = interfaceC0526Fp9;
                        z4 = z3;
                        menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    z5 = z4;
                    menuItemColors4 = menuItemColors3;
                    paddingValues2 = dropdownMenuItemContentPadding;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC0526Fp, interfaceC3588op, modifier3, interfaceC0526Fp7, interfaceC0526Fp8, z5, menuItemColors4, paddingValues2, mutableInteractionSource3, i, i2));
            }
            i3 |= 24576;
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((458752 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((3670016 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        menuItemColors2 = menuItemColors;
                        if (composerStartRestartGroup.changed(menuItemColors2)) {
                        }
                        i3 |= i15;
                    } else {
                        menuItemColors2 = menuItemColors;
                    }
                    i3 |= i15;
                } else {
                    menuItemColors2 = menuItemColors;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 256;
                if (i12 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i3 |= i13;
                }
                if ((i3 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                        }
                        if (i6 == 0) {
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        interfaceC0526Fp6 = interfaceC0526Fp9;
                        z4 = z3;
                        menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                        }
                        if (i6 == 0) {
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        interfaceC0526Fp6 = interfaceC0526Fp9;
                        z4 = z3;
                        menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    z5 = z4;
                    menuItemColors4 = menuItemColors3;
                    paddingValues2 = dropdownMenuItemContentPadding;
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                        }
                        if (i6 == 0) {
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        interfaceC0526Fp6 = interfaceC0526Fp9;
                        z4 = z3;
                        menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                        }
                        if (i6 == 0) {
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        interfaceC0526Fp6 = interfaceC0526Fp9;
                        z4 = z3;
                        menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    z5 = z4;
                    menuItemColors4 = menuItemColors3;
                    paddingValues2 = dropdownMenuItemContentPadding;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC0526Fp, interfaceC3588op, modifier3, interfaceC0526Fp7, interfaceC0526Fp8, z5, menuItemColors4, paddingValues2, mutableInteractionSource3, i, i2));
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z2 = z;
            if ((3670016 & i) == 0) {
                if ((i2 & 64) == 0) {
                    menuItemColors2 = menuItemColors;
                    if (composerStartRestartGroup.changed(menuItemColors2)) {
                    }
                    i3 |= i15;
                } else {
                    menuItemColors2 = menuItemColors;
                }
                i3 |= i15;
            } else {
                menuItemColors2 = menuItemColors;
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            i12 = i2 & 256;
            if (i12 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i3 |= i13;
            }
            if ((i3 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp2;
                    }
                    if (i6 == 0) {
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 64) != 0) {
                        menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    interfaceC0526Fp6 = interfaceC0526Fp9;
                    z4 = z3;
                    menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp2;
                    }
                    if (i6 == 0) {
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 64) != 0) {
                        menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    interfaceC0526Fp6 = interfaceC0526Fp9;
                    z4 = z3;
                    menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                }
                MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                interfaceC0526Fp7 = interfaceC0526Fp5;
                interfaceC0526Fp8 = interfaceC0526Fp6;
                z5 = z4;
                menuItemColors4 = menuItemColors3;
                paddingValues2 = dropdownMenuItemContentPadding;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp2;
                    }
                    if (i6 == 0) {
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 64) != 0) {
                        menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    interfaceC0526Fp6 = interfaceC0526Fp9;
                    z4 = z3;
                    menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp2;
                    }
                    if (i6 == 0) {
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 64) != 0) {
                        menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    interfaceC0526Fp6 = interfaceC0526Fp9;
                    z4 = z3;
                    menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                }
                MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                interfaceC0526Fp7 = interfaceC0526Fp5;
                interfaceC0526Fp8 = interfaceC0526Fp6;
                z5 = z4;
                menuItemColors4 = menuItemColors3;
                paddingValues2 = dropdownMenuItemContentPadding;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC0526Fp, interfaceC3588op, modifier3, interfaceC0526Fp7, interfaceC0526Fp8, z5, menuItemColors4, paddingValues2, mutableInteractionSource3, i, i2));
        }
        i3 |= 3072;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((57344 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((458752 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((3670016 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        menuItemColors2 = menuItemColors;
                        if (composerStartRestartGroup.changed(menuItemColors2)) {
                        }
                        i3 |= i15;
                    } else {
                        menuItemColors2 = menuItemColors;
                    }
                    i3 |= i15;
                } else {
                    menuItemColors2 = menuItemColors;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 256;
                if (i12 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i3 |= i13;
                }
                if ((i3 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                        }
                        if (i6 == 0) {
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        interfaceC0526Fp6 = interfaceC0526Fp9;
                        z4 = z3;
                        menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                        }
                        if (i6 == 0) {
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        interfaceC0526Fp6 = interfaceC0526Fp9;
                        z4 = z3;
                        menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    z5 = z4;
                    menuItemColors4 = menuItemColors3;
                    paddingValues2 = dropdownMenuItemContentPadding;
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                        }
                        if (i6 == 0) {
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        interfaceC0526Fp6 = interfaceC0526Fp9;
                        z4 = z3;
                        menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                        }
                        if (i6 == 0) {
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if ((i2 & 64) != 0) {
                            menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            i3 &= -3670017;
                        } else {
                            menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        interfaceC0526Fp6 = interfaceC0526Fp9;
                        z4 = z3;
                        menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                    }
                    MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    z5 = z4;
                    menuItemColors4 = menuItemColors3;
                    paddingValues2 = dropdownMenuItemContentPadding;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC0526Fp, interfaceC3588op, modifier3, interfaceC0526Fp7, interfaceC0526Fp8, z5, menuItemColors4, paddingValues2, mutableInteractionSource3, i, i2));
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z2 = z;
            if ((3670016 & i) == 0) {
                if ((i2 & 64) == 0) {
                    menuItemColors2 = menuItemColors;
                    if (composerStartRestartGroup.changed(menuItemColors2)) {
                    }
                    i3 |= i15;
                } else {
                    menuItemColors2 = menuItemColors;
                }
                i3 |= i15;
            } else {
                menuItemColors2 = menuItemColors;
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            i12 = i2 & 256;
            if (i12 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i3 |= i13;
            }
            if ((i3 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp2;
                    }
                    if (i6 == 0) {
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 64) != 0) {
                        menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    interfaceC0526Fp6 = interfaceC0526Fp9;
                    z4 = z3;
                    menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp2;
                    }
                    if (i6 == 0) {
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 64) != 0) {
                        menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    interfaceC0526Fp6 = interfaceC0526Fp9;
                    z4 = z3;
                    menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                }
                MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                interfaceC0526Fp7 = interfaceC0526Fp5;
                interfaceC0526Fp8 = interfaceC0526Fp6;
                z5 = z4;
                menuItemColors4 = menuItemColors3;
                paddingValues2 = dropdownMenuItemContentPadding;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp2;
                    }
                    if (i6 == 0) {
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 64) != 0) {
                        menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    interfaceC0526Fp6 = interfaceC0526Fp9;
                    z4 = z3;
                    menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp2;
                    }
                    if (i6 == 0) {
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 64) != 0) {
                        menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    interfaceC0526Fp6 = interfaceC0526Fp9;
                    z4 = z3;
                    menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                }
                MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                interfaceC0526Fp7 = interfaceC0526Fp5;
                interfaceC0526Fp8 = interfaceC0526Fp6;
                z5 = z4;
                menuItemColors4 = menuItemColors3;
                paddingValues2 = dropdownMenuItemContentPadding;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC0526Fp, interfaceC3588op, modifier3, interfaceC0526Fp7, interfaceC0526Fp8, z5, menuItemColors4, paddingValues2, mutableInteractionSource3, i, i2));
        }
        i3 |= 24576;
        i8 = i2 & 32;
        if (i8 != 0) {
            if ((458752 & i) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
            if ((3670016 & i) == 0) {
                if ((i2 & 64) == 0) {
                    menuItemColors2 = menuItemColors;
                    if (composerStartRestartGroup.changed(menuItemColors2)) {
                    }
                    i3 |= i15;
                } else {
                    menuItemColors2 = menuItemColors;
                }
                i3 |= i15;
            } else {
                menuItemColors2 = menuItemColors;
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            i12 = i2 & 256;
            if (i12 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i3 |= i13;
            }
            if ((i3 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp2;
                    }
                    if (i6 == 0) {
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 64) != 0) {
                        menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    interfaceC0526Fp6 = interfaceC0526Fp9;
                    z4 = z3;
                    menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp2;
                    }
                    if (i6 == 0) {
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 64) != 0) {
                        menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    interfaceC0526Fp6 = interfaceC0526Fp9;
                    z4 = z3;
                    menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                }
                MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                interfaceC0526Fp7 = interfaceC0526Fp5;
                interfaceC0526Fp8 = interfaceC0526Fp6;
                z5 = z4;
                menuItemColors4 = menuItemColors3;
                paddingValues2 = dropdownMenuItemContentPadding;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp2;
                    }
                    if (i6 == 0) {
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 64) != 0) {
                        menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    interfaceC0526Fp6 = interfaceC0526Fp9;
                    z4 = z3;
                    menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp2;
                    }
                    if (i6 == 0) {
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if ((i2 & 64) != 0) {
                        menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        i3 &= -3670017;
                    } else {
                        menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    interfaceC0526Fp6 = interfaceC0526Fp9;
                    z4 = z3;
                    menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                }
                MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                interfaceC0526Fp7 = interfaceC0526Fp5;
                interfaceC0526Fp8 = interfaceC0526Fp6;
                z5 = z4;
                menuItemColors4 = menuItemColors3;
                paddingValues2 = dropdownMenuItemContentPadding;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC0526Fp, interfaceC3588op, modifier3, interfaceC0526Fp7, interfaceC0526Fp8, z5, menuItemColors4, paddingValues2, mutableInteractionSource3, i, i2));
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z2 = z;
        if ((3670016 & i) == 0) {
            if ((i2 & 64) == 0) {
                menuItemColors2 = menuItemColors;
                if (composerStartRestartGroup.changed(menuItemColors2)) {
                }
                i3 |= i15;
            } else {
                menuItemColors2 = menuItemColors;
            }
            i3 |= i15;
        } else {
            menuItemColors2 = menuItemColors;
        }
        i10 = i2 & 128;
        if (i10 != 0) {
            i3 |= 12582912;
        } else if ((i & 29360128) == 0) {
            if (composerStartRestartGroup.changed(paddingValues)) {
                i11 = 8388608;
            } else {
                i11 = 4194304;
            }
            i3 |= i11;
        }
        i12 = i2 & 256;
        if (i12 != 0) {
            i3 |= 100663296;
        } else if ((i & 234881024) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i13 = 67108864;
            } else {
                i13 = 33554432;
            }
            i3 |= i13;
        }
        if ((i3 & 191739611) == 38347922) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp2;
                }
                if (i6 == 0) {
                }
                if (i8 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if ((i2 & 64) != 0) {
                    menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    i3 &= -3670017;
                } else {
                    menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                }
                if (i10 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues;
                }
                if (i12 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                interfaceC0526Fp5 = interfaceC0526Fp4;
                interfaceC0526Fp6 = interfaceC0526Fp9;
                z4 = z3;
                menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp2;
                }
                if (i6 == 0) {
                }
                if (i8 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if ((i2 & 64) != 0) {
                    menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    i3 &= -3670017;
                } else {
                    menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                }
                if (i10 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues;
                }
                if (i12 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                interfaceC0526Fp5 = interfaceC0526Fp4;
                interfaceC0526Fp6 = interfaceC0526Fp9;
                z4 = z3;
                menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
            }
            MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            interfaceC0526Fp7 = interfaceC0526Fp5;
            interfaceC0526Fp8 = interfaceC0526Fp6;
            z5 = z4;
            menuItemColors4 = menuItemColors3;
            paddingValues2 = dropdownMenuItemContentPadding;
            mutableInteractionSource3 = mutableInteractionSource2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp2;
                }
                if (i6 == 0) {
                }
                if (i8 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if ((i2 & 64) != 0) {
                    menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    i3 &= -3670017;
                } else {
                    menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                }
                if (i10 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues;
                }
                if (i12 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                interfaceC0526Fp5 = interfaceC0526Fp4;
                interfaceC0526Fp6 = interfaceC0526Fp9;
                z4 = z3;
                menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp2;
                }
                if (i6 == 0) {
                }
                if (i8 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if ((i2 & 64) != 0) {
                    menuItemColorsM1644itemColors5tl4gsc = MenuDefaults.INSTANCE.m1644itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    i3 &= -3670017;
                } else {
                    menuItemColorsM1644itemColors5tl4gsc = menuItemColors2;
                }
                if (i10 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues;
                }
                if (i12 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                interfaceC0526Fp5 = interfaceC0526Fp4;
                interfaceC0526Fp6 = interfaceC0526Fp9;
                z4 = z3;
                menuItemColors3 = menuItemColorsM1644itemColors5tl4gsc;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
            }
            MenuKt.DropdownMenuItemContent(interfaceC0526Fp, interfaceC3588op, modifier2, interfaceC0526Fp5, interfaceC0526Fp6, z4, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, composerStartRestartGroup, i3 & 268435454);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            interfaceC0526Fp7 = interfaceC0526Fp5;
            interfaceC0526Fp8 = interfaceC0526Fp6;
            z5 = z4;
            menuItemColors4 = menuItemColors3;
            paddingValues2 = dropdownMenuItemContentPadding;
            mutableInteractionSource3 = mutableInteractionSource2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC0526Fp, interfaceC3588op, modifier3, interfaceC0526Fp7, interfaceC0526Fp8, z5, menuItemColors4, paddingValues2, mutableInteractionSource3, i, i2));
    }
}
