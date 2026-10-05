package androidx.compose.foundation.text;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.profileinstaller.ProfileVerifier;
import defpackage.AbstractC4492zt;
import defpackage.C1172Zk;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ClickableTextKt {
    /* JADX WARN: Code duplicated, block: B:102:0x013e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:103:0x0140  */
    /* JADX WARN: Code duplicated, block: B:104:0x0144  */
    /* JADX WARN: Code duplicated, block: B:106:0x0148  */
    /* JADX WARN: Code duplicated, block: B:107:0x0151  */
    /* JADX WARN: Code duplicated, block: B:109:0x0155  */
    /* JADX WARN: Code duplicated, block: B:110:0x0159  */
    /* JADX WARN: Code duplicated, block: B:112:0x015d  */
    /* JADX WARN: Code duplicated, block: B:113:0x0166  */
    /* JADX WARN: Code duplicated, block: B:115:0x016a  */
    /* JADX WARN: Code duplicated, block: B:116:0x0171  */
    /* JADX WARN: Code duplicated, block: B:118:0x0175  */
    /* JADX WARN: Code duplicated, block: B:119:0x0179  */
    /* JADX WARN: Code duplicated, block: B:122:0x0181  */
    /* JADX WARN: Code duplicated, block: B:125:0x019c  */
    /* JADX WARN: Code duplicated, block: B:128:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:131:0x0209  */
    /* JADX WARN: Code duplicated, block: B:133:0x020f  */
    /* JADX WARN: Code duplicated, block: B:136:0x0258  */
    /* JADX WARN: Code duplicated, block: B:141:0x026e  */
    /* JADX WARN: Code duplicated, block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x006f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0074  */
    /* JADX WARN: Code duplicated, block: B:40:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x0080  */
    /* JADX WARN: Code duplicated, block: B:43:0x0083  */
    /* JADX WARN: Code duplicated, block: B:47:0x008d  */
    /* JADX WARN: Code duplicated, block: B:49:0x0092  */
    /* JADX WARN: Code duplicated, block: B:51:0x0096  */
    /* JADX WARN: Code duplicated, block: B:53:0x009e  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00be  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:68:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:73:0x00de  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:83:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:84:0x0101  */
    /* JADX WARN: Code duplicated, block: B:88:0x0109  */
    /* JADX WARN: Code duplicated, block: B:90:0x010d  */
    /* JADX WARN: Code duplicated, block: B:92:0x0112  */
    /* JADX WARN: Code duplicated, block: B:94:0x0118  */
    /* JADX WARN: Code duplicated, block: B:95:0x011b  */
    /* JADX WARN: Code duplicated, block: B:98:0x0127  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @ExperimentalFoundationApi
    /* JADX INFO: renamed from: ClickableText-03UYbkw, reason: not valid java name */
    public static final void m749ClickableText03UYbkw(AnnotatedString annotatedString, InterfaceC3750qp interfaceC3750qp, Modifier modifier, TextStyle textStyle, boolean z, int i, int i2, InterfaceC3750qp interfaceC3750qp2, InterfaceC3750qp interfaceC3750qp3, Composer composer, int i3, int i4) {
        int i5;
        int i6;
        TextStyle textStyle2;
        int i7;
        int i8;
        boolean z2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        Modifier modifier2;
        TextStyle textStyle3;
        boolean z3;
        int iM5113getClipgIe3tQ8;
        int i18;
        InterfaceC3750qp interfaceC3750qp4;
        Object objRememberedValue;
        Composer.Companion companion;
        MutableState mutableState;
        Object objRememberedValue2;
        boolean zChanged;
        Object objRememberedValue3;
        int i19;
        int i20;
        Modifier modifier3;
        TextStyle textStyle4;
        boolean z4;
        InterfaceC3750qp interfaceC3750qp5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(annotatedString, "text");
        AbstractC4492zt.h(interfaceC3750qp, "onHover");
        AbstractC4492zt.h(interfaceC3750qp3, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1020774372);
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(annotatedString) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i3 & 112) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(interfaceC3750qp) ? 32 : 16;
        }
        int i21 = i4 & 4;
        if (i21 == 0) {
            if ((i3 & 896) == 0) {
                i5 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
            }
            i6 = i4 & 8;
            if (i6 != 0) {
                if ((i3 & 7168) == 0) {
                    textStyle2 = textStyle;
                    if (composerStartRestartGroup.changed(textStyle2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i5 |= i7;
                }
                i8 = i4 & 16;
                if (i8 != 0) {
                    if ((i3 & 57344) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i5 |= i9;
                    }
                    i10 = i4 & 32;
                    if (i10 != 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        i11 = i;
                    } else {
                        i11 = i;
                        if ((i3 & 458752) == 0) {
                            if (composerStartRestartGroup.changed(i11)) {
                                i12 = 131072;
                            } else {
                                i12 = 65536;
                            }
                            i5 |= i12;
                        }
                    }
                    i13 = i4 & 64;
                    if (i13 != 0) {
                        i5 |= 1572864;
                    } else if ((i3 & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(i2)) {
                            i14 = 1048576;
                        } else {
                            i14 = 524288;
                        }
                        i5 |= i14;
                    }
                    i15 = i4 & 128;
                    if (i15 != 0) {
                        i5 |= 12582912;
                    } else if ((i3 & 29360128) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                            i16 = 8388608;
                        } else {
                            i16 = 4194304;
                        }
                        i5 |= i16;
                    }
                    if ((i4 & 256) != 0) {
                        if ((234881024 & i3) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC3750qp3)) {
                                i17 = 67108864;
                            } else {
                                i17 = 33554432;
                            }
                        }
                        if ((191739611 & i5) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                            if (i21 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i6 != 0) {
                                textStyle3 = TextStyle.Companion.getDefault();
                            } else {
                                textStyle3 = textStyle2;
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i10 != 0) {
                                iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                            } else {
                                iM5113getClipgIe3tQ8 = i11;
                            }
                            if (i13 != 0) {
                                i18 = Integer.MAX_VALUE;
                            } else {
                                i18 = i2;
                            }
                            if (i15 != 0) {
                                interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                            } else {
                                interfaceC3750qp4 = interfaceC3750qp2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.Companion;
                            if (objRememberedValue == companion.getEmpty()) {
                                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableState = (MutableState) objRememberedValue;
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == companion.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                objRememberedValue2 = compositionScopedCoroutineScopeCanceller;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            InterfaceC2052dg coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            Modifier modifierThen = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                                objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            int i22 = i5 >> 3;
                            Modifier modifier4 = modifier2;
                            InterfaceC3750qp interfaceC3750qp6 = interfaceC3750qp4;
                            BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i22 & 896) | (i22 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            i19 = iM5113getClipgIe3tQ8;
                            i20 = i18;
                            modifier3 = modifier4;
                            textStyle4 = textStyle3;
                            z4 = z3;
                            interfaceC3750qp5 = interfaceC3750qp6;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier;
                            i20 = i2;
                            textStyle4 = textStyle2;
                            i19 = i11;
                            z4 = z2;
                            interfaceC3750qp5 = interfaceC3750qp2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$6(annotatedString, interfaceC3750qp, modifier3, textStyle4, z4, i19, i20, interfaceC3750qp5, interfaceC3750qp3, i3, i4));
                    }
                    i17 = 100663296;
                    i5 |= i17;
                    if ((191739611 & i5) == 38347922) {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                        } else {
                            interfaceC3750qp4 = interfaceC3750qp2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller2 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller2);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller2;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen2 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope2, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i23 = i5 >> 3;
                        Modifier modifier5 = modifier2;
                        InterfaceC3750qp interfaceC3750qp7 = interfaceC3750qp4;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen2, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i23 & 896) | (i23 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = iM5113getClipgIe3tQ8;
                        i20 = i18;
                        modifier3 = modifier5;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        interfaceC3750qp5 = interfaceC3750qp7;
                    } else {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                        } else {
                            interfaceC3750qp4 = interfaceC3750qp2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller3 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller3);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller3;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope3 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen3 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope3, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i24 = i5 >> 3;
                        Modifier modifier6 = modifier2;
                        InterfaceC3750qp interfaceC3750qp8 = interfaceC3750qp4;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen3, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i24 & 896) | (i24 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = iM5113getClipgIe3tQ8;
                        i20 = i18;
                        modifier3 = modifier6;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        interfaceC3750qp5 = interfaceC3750qp8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$6(annotatedString, interfaceC3750qp, modifier3, textStyle4, z4, i19, i20, interfaceC3750qp5, interfaceC3750qp3, i3, i4));
                }
                i5 |= 24576;
                z2 = z;
                i10 = i4 & 32;
                if (i10 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i11 = i;
                } else {
                    i11 = i;
                    if ((i3 & 458752) == 0) {
                        if (composerStartRestartGroup.changed(i11)) {
                            i12 = 131072;
                        } else {
                            i12 = 65536;
                        }
                        i5 |= i12;
                    }
                }
                i13 = i4 & 64;
                if (i13 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i14 = 1048576;
                    } else {
                        i14 = 524288;
                    }
                    i5 |= i14;
                }
                i15 = i4 & 128;
                if (i15 != 0) {
                    i5 |= 12582912;
                } else if ((i3 & 29360128) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                        i16 = 8388608;
                    } else {
                        i16 = 4194304;
                    }
                    i5 |= i16;
                }
                if ((i4 & 256) != 0) {
                    if ((234881024 & i3) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp3)) {
                            i17 = 67108864;
                        } else {
                            i17 = 33554432;
                        }
                    }
                    if ((191739611 & i5) == 38347922) {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                        } else {
                            interfaceC3750qp4 = interfaceC3750qp2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller4 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller4);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller4;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope4 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen4 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope4, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i25 = i5 >> 3;
                        Modifier modifier7 = modifier2;
                        InterfaceC3750qp interfaceC3750qp9 = interfaceC3750qp4;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen4, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i25 & 896) | (i25 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = iM5113getClipgIe3tQ8;
                        i20 = i18;
                        modifier3 = modifier7;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        interfaceC3750qp5 = interfaceC3750qp9;
                    } else {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                        } else {
                            interfaceC3750qp4 = interfaceC3750qp2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller5 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller5);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller5;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope5 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen5 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope5, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i26 = i5 >> 3;
                        Modifier modifier8 = modifier2;
                        InterfaceC3750qp interfaceC3750qp10 = interfaceC3750qp4;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen5, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i26 & 896) | (i26 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = iM5113getClipgIe3tQ8;
                        i20 = i18;
                        modifier3 = modifier8;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        interfaceC3750qp5 = interfaceC3750qp10;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$6(annotatedString, interfaceC3750qp, modifier3, textStyle4, z4, i19, i20, interfaceC3750qp5, interfaceC3750qp3, i3, i4));
                }
                i17 = 100663296;
                i5 |= i17;
                if ((191739611 & i5) == 38347922) {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                    } else {
                        interfaceC3750qp4 = interfaceC3750qp2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller6 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller6);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller6;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope6 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen6 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope6, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i27 = i5 >> 3;
                    Modifier modifier9 = modifier2;
                    InterfaceC3750qp interfaceC3750qp11 = interfaceC3750qp4;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen6, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i27 & 896) | (i27 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = iM5113getClipgIe3tQ8;
                    i20 = i18;
                    modifier3 = modifier9;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    interfaceC3750qp5 = interfaceC3750qp11;
                } else {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                    } else {
                        interfaceC3750qp4 = interfaceC3750qp2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller7 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller7);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller7;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope7 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen7 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope7, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i28 = i5 >> 3;
                    Modifier modifier10 = modifier2;
                    InterfaceC3750qp interfaceC3750qp12 = interfaceC3750qp4;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen7, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i28 & 896) | (i28 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = iM5113getClipgIe3tQ8;
                    i20 = i18;
                    modifier3 = modifier10;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    interfaceC3750qp5 = interfaceC3750qp12;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$6(annotatedString, interfaceC3750qp, modifier3, textStyle4, z4, i19, i20, interfaceC3750qp5, interfaceC3750qp3, i3, i4));
            }
            i5 |= 3072;
            textStyle2 = textStyle;
            i8 = i4 & 16;
            if (i8 != 0) {
                if ((i3 & 57344) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i5 |= i9;
                }
                i10 = i4 & 32;
                if (i10 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i11 = i;
                } else {
                    i11 = i;
                    if ((i3 & 458752) == 0) {
                        if (composerStartRestartGroup.changed(i11)) {
                            i12 = 131072;
                        } else {
                            i12 = 65536;
                        }
                        i5 |= i12;
                    }
                }
                i13 = i4 & 64;
                if (i13 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i14 = 1048576;
                    } else {
                        i14 = 524288;
                    }
                    i5 |= i14;
                }
                i15 = i4 & 128;
                if (i15 != 0) {
                    i5 |= 12582912;
                } else if ((i3 & 29360128) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                        i16 = 8388608;
                    } else {
                        i16 = 4194304;
                    }
                    i5 |= i16;
                }
                if ((i4 & 256) != 0) {
                    if ((234881024 & i3) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp3)) {
                            i17 = 67108864;
                        } else {
                            i17 = 33554432;
                        }
                    }
                    if ((191739611 & i5) == 38347922) {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                        } else {
                            interfaceC3750qp4 = interfaceC3750qp2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller8 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller8);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller8;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope8 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen8 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope8, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i29 = i5 >> 3;
                        Modifier modifier11 = modifier2;
                        InterfaceC3750qp interfaceC3750qp13 = interfaceC3750qp4;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen8, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i29 & 896) | (i29 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = iM5113getClipgIe3tQ8;
                        i20 = i18;
                        modifier3 = modifier11;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        interfaceC3750qp5 = interfaceC3750qp13;
                    } else {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                        } else {
                            interfaceC3750qp4 = interfaceC3750qp2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller9 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller9);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller9;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope9 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen9 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope9, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i210 = i5 >> 3;
                        Modifier modifier12 = modifier2;
                        InterfaceC3750qp interfaceC3750qp14 = interfaceC3750qp4;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen9, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i210 & 896) | (i210 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = iM5113getClipgIe3tQ8;
                        i20 = i18;
                        modifier3 = modifier12;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        interfaceC3750qp5 = interfaceC3750qp14;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$6(annotatedString, interfaceC3750qp, modifier3, textStyle4, z4, i19, i20, interfaceC3750qp5, interfaceC3750qp3, i3, i4));
                }
                i17 = 100663296;
                i5 |= i17;
                if ((191739611 & i5) == 38347922) {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                    } else {
                        interfaceC3750qp4 = interfaceC3750qp2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller10 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller10);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller10;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope10 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen10 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope10, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i211 = i5 >> 3;
                    Modifier modifier13 = modifier2;
                    InterfaceC3750qp interfaceC3750qp15 = interfaceC3750qp4;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen10, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i211 & 896) | (i211 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = iM5113getClipgIe3tQ8;
                    i20 = i18;
                    modifier3 = modifier13;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    interfaceC3750qp5 = interfaceC3750qp15;
                } else {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                    } else {
                        interfaceC3750qp4 = interfaceC3750qp2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller11;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope11 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen11 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope11, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i212 = i5 >> 3;
                    Modifier modifier14 = modifier2;
                    InterfaceC3750qp interfaceC3750qp16 = interfaceC3750qp4;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen11, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i212 & 896) | (i212 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = iM5113getClipgIe3tQ8;
                    i20 = i18;
                    modifier3 = modifier14;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    interfaceC3750qp5 = interfaceC3750qp16;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$6(annotatedString, interfaceC3750qp, modifier3, textStyle4, z4, i19, i20, interfaceC3750qp5, interfaceC3750qp3, i3, i4));
            }
            i5 |= 24576;
            z2 = z;
            i10 = i4 & 32;
            if (i10 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i11 = i;
            } else {
                i11 = i;
                if ((i3 & 458752) == 0) {
                    if (composerStartRestartGroup.changed(i11)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i5 |= i12;
                }
            }
            i13 = i4 & 64;
            if (i13 != 0) {
                i5 |= 1572864;
            } else if ((i3 & 3670016) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i14 = 1048576;
                } else {
                    i14 = 524288;
                }
                i5 |= i14;
            }
            i15 = i4 & 128;
            if (i15 != 0) {
                i5 |= 12582912;
            } else if ((i3 & 29360128) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                    i16 = 8388608;
                } else {
                    i16 = 4194304;
                }
                i5 |= i16;
            }
            if ((i4 & 256) != 0) {
                if ((234881024 & i3) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp3)) {
                        i17 = 67108864;
                    } else {
                        i17 = 33554432;
                    }
                }
                if ((191739611 & i5) == 38347922) {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                    } else {
                        interfaceC3750qp4 = interfaceC3750qp2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller12 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller12);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller12;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope12 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen12 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope12, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i213 = i5 >> 3;
                    Modifier modifier15 = modifier2;
                    InterfaceC3750qp interfaceC3750qp17 = interfaceC3750qp4;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen12, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i213 & 896) | (i213 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = iM5113getClipgIe3tQ8;
                    i20 = i18;
                    modifier3 = modifier15;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    interfaceC3750qp5 = interfaceC3750qp17;
                } else {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                    } else {
                        interfaceC3750qp4 = interfaceC3750qp2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller13 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller13);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller13;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope13 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen13 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope13, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i214 = i5 >> 3;
                    Modifier modifier16 = modifier2;
                    InterfaceC3750qp interfaceC3750qp18 = interfaceC3750qp4;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen13, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i214 & 896) | (i214 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = iM5113getClipgIe3tQ8;
                    i20 = i18;
                    modifier3 = modifier16;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    interfaceC3750qp5 = interfaceC3750qp18;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$6(annotatedString, interfaceC3750qp, modifier3, textStyle4, z4, i19, i20, interfaceC3750qp5, interfaceC3750qp3, i3, i4));
            }
            i17 = 100663296;
            i5 |= i17;
            if ((191739611 & i5) == 38347922) {
                if (i21 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i6 != 0) {
                    textStyle3 = TextStyle.Companion.getDefault();
                } else {
                    textStyle3 = textStyle2;
                }
                if (i8 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i10 != 0) {
                    iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                } else {
                    iM5113getClipgIe3tQ8 = i11;
                }
                if (i13 != 0) {
                    i18 = Integer.MAX_VALUE;
                } else {
                    i18 = i2;
                }
                if (i15 != 0) {
                    interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                } else {
                    interfaceC3750qp4 = interfaceC3750qp2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller14 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller14);
                    objRememberedValue2 = compositionScopedCoroutineScopeCanceller14;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope14 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen14 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope14, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i215 = i5 >> 3;
                Modifier modifier17 = modifier2;
                InterfaceC3750qp interfaceC3750qp19 = interfaceC3750qp4;
                BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen14, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i215 & 896) | (i215 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i19 = iM5113getClipgIe3tQ8;
                i20 = i18;
                modifier3 = modifier17;
                textStyle4 = textStyle3;
                z4 = z3;
                interfaceC3750qp5 = interfaceC3750qp19;
            } else {
                if (i21 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i6 != 0) {
                    textStyle3 = TextStyle.Companion.getDefault();
                } else {
                    textStyle3 = textStyle2;
                }
                if (i8 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i10 != 0) {
                    iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                } else {
                    iM5113getClipgIe3tQ8 = i11;
                }
                if (i13 != 0) {
                    i18 = Integer.MAX_VALUE;
                } else {
                    i18 = i2;
                }
                if (i15 != 0) {
                    interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                } else {
                    interfaceC3750qp4 = interfaceC3750qp2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller15 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller15);
                    objRememberedValue2 = compositionScopedCoroutineScopeCanceller15;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope15 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen15 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope15, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i216 = i5 >> 3;
                Modifier modifier18 = modifier2;
                InterfaceC3750qp interfaceC3750qp110 = interfaceC3750qp4;
                BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen15, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i216 & 896) | (i216 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i19 = iM5113getClipgIe3tQ8;
                i20 = i18;
                modifier3 = modifier18;
                textStyle4 = textStyle3;
                z4 = z3;
                interfaceC3750qp5 = interfaceC3750qp110;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$6(annotatedString, interfaceC3750qp, modifier3, textStyle4, z4, i19, i20, interfaceC3750qp5, interfaceC3750qp3, i3, i4));
        }
        i5 |= 384;
        i6 = i4 & 8;
        if (i6 != 0) {
            if ((i3 & 7168) == 0) {
                textStyle2 = textStyle;
                if (composerStartRestartGroup.changed(textStyle2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i5 |= i7;
            }
            i8 = i4 & 16;
            if (i8 != 0) {
                if ((i3 & 57344) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i5 |= i9;
                }
                i10 = i4 & 32;
                if (i10 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i11 = i;
                } else {
                    i11 = i;
                    if ((i3 & 458752) == 0) {
                        if (composerStartRestartGroup.changed(i11)) {
                            i12 = 131072;
                        } else {
                            i12 = 65536;
                        }
                        i5 |= i12;
                    }
                }
                i13 = i4 & 64;
                if (i13 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i14 = 1048576;
                    } else {
                        i14 = 524288;
                    }
                    i5 |= i14;
                }
                i15 = i4 & 128;
                if (i15 != 0) {
                    i5 |= 12582912;
                } else if ((i3 & 29360128) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                        i16 = 8388608;
                    } else {
                        i16 = 4194304;
                    }
                    i5 |= i16;
                }
                if ((i4 & 256) != 0) {
                    if ((234881024 & i3) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp3)) {
                            i17 = 67108864;
                        } else {
                            i17 = 33554432;
                        }
                    }
                    if ((191739611 & i5) == 38347922) {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                        } else {
                            interfaceC3750qp4 = interfaceC3750qp2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller16 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller16);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller16;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope16 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen16 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope16, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i217 = i5 >> 3;
                        Modifier modifier19 = modifier2;
                        InterfaceC3750qp interfaceC3750qp111 = interfaceC3750qp4;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen16, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i217 & 896) | (i217 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = iM5113getClipgIe3tQ8;
                        i20 = i18;
                        modifier3 = modifier19;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        interfaceC3750qp5 = interfaceC3750qp111;
                    } else {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                        } else {
                            interfaceC3750qp4 = interfaceC3750qp2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller17 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller17);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller17;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope17 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen17 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope17, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i218 = i5 >> 3;
                        Modifier modifier110 = modifier2;
                        InterfaceC3750qp interfaceC3750qp112 = interfaceC3750qp4;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen17, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i218 & 896) | (i218 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = iM5113getClipgIe3tQ8;
                        i20 = i18;
                        modifier3 = modifier110;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        interfaceC3750qp5 = interfaceC3750qp112;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$6(annotatedString, interfaceC3750qp, modifier3, textStyle4, z4, i19, i20, interfaceC3750qp5, interfaceC3750qp3, i3, i4));
                }
                i17 = 100663296;
                i5 |= i17;
                if ((191739611 & i5) == 38347922) {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                    } else {
                        interfaceC3750qp4 = interfaceC3750qp2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller18 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller18);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller18;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope18 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen18 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope18, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i219 = i5 >> 3;
                    Modifier modifier111 = modifier2;
                    InterfaceC3750qp interfaceC3750qp113 = interfaceC3750qp4;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen18, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i219 & 896) | (i219 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = iM5113getClipgIe3tQ8;
                    i20 = i18;
                    modifier3 = modifier111;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    interfaceC3750qp5 = interfaceC3750qp113;
                } else {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                    } else {
                        interfaceC3750qp4 = interfaceC3750qp2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller19 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller19);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller19;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope19 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen19 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope19, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i2110 = i5 >> 3;
                    Modifier modifier112 = modifier2;
                    InterfaceC3750qp interfaceC3750qp114 = interfaceC3750qp4;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen19, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i2110 & 896) | (i2110 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = iM5113getClipgIe3tQ8;
                    i20 = i18;
                    modifier3 = modifier112;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    interfaceC3750qp5 = interfaceC3750qp114;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$6(annotatedString, interfaceC3750qp, modifier3, textStyle4, z4, i19, i20, interfaceC3750qp5, interfaceC3750qp3, i3, i4));
            }
            i5 |= 24576;
            z2 = z;
            i10 = i4 & 32;
            if (i10 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i11 = i;
            } else {
                i11 = i;
                if ((i3 & 458752) == 0) {
                    if (composerStartRestartGroup.changed(i11)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i5 |= i12;
                }
            }
            i13 = i4 & 64;
            if (i13 != 0) {
                i5 |= 1572864;
            } else if ((i3 & 3670016) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i14 = 1048576;
                } else {
                    i14 = 524288;
                }
                i5 |= i14;
            }
            i15 = i4 & 128;
            if (i15 != 0) {
                i5 |= 12582912;
            } else if ((i3 & 29360128) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                    i16 = 8388608;
                } else {
                    i16 = 4194304;
                }
                i5 |= i16;
            }
            if ((i4 & 256) != 0) {
                if ((234881024 & i3) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp3)) {
                        i17 = 67108864;
                    } else {
                        i17 = 33554432;
                    }
                }
                if ((191739611 & i5) == 38347922) {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                    } else {
                        interfaceC3750qp4 = interfaceC3750qp2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller110 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller110);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller110;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope110 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen110 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope110, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i2111 = i5 >> 3;
                    Modifier modifier113 = modifier2;
                    InterfaceC3750qp interfaceC3750qp115 = interfaceC3750qp4;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen110, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i2111 & 896) | (i2111 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = iM5113getClipgIe3tQ8;
                    i20 = i18;
                    modifier3 = modifier113;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    interfaceC3750qp5 = interfaceC3750qp115;
                } else {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                    } else {
                        interfaceC3750qp4 = interfaceC3750qp2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller111 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller111);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller111;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope111 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen111 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope111, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i2112 = i5 >> 3;
                    Modifier modifier114 = modifier2;
                    InterfaceC3750qp interfaceC3750qp116 = interfaceC3750qp4;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen111, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i2112 & 896) | (i2112 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = iM5113getClipgIe3tQ8;
                    i20 = i18;
                    modifier3 = modifier114;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    interfaceC3750qp5 = interfaceC3750qp116;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$6(annotatedString, interfaceC3750qp, modifier3, textStyle4, z4, i19, i20, interfaceC3750qp5, interfaceC3750qp3, i3, i4));
            }
            i17 = 100663296;
            i5 |= i17;
            if ((191739611 & i5) == 38347922) {
                if (i21 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i6 != 0) {
                    textStyle3 = TextStyle.Companion.getDefault();
                } else {
                    textStyle3 = textStyle2;
                }
                if (i8 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i10 != 0) {
                    iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                } else {
                    iM5113getClipgIe3tQ8 = i11;
                }
                if (i13 != 0) {
                    i18 = Integer.MAX_VALUE;
                } else {
                    i18 = i2;
                }
                if (i15 != 0) {
                    interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                } else {
                    interfaceC3750qp4 = interfaceC3750qp2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller112 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller112);
                    objRememberedValue2 = compositionScopedCoroutineScopeCanceller112;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope112 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen112 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope112, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i2113 = i5 >> 3;
                Modifier modifier115 = modifier2;
                InterfaceC3750qp interfaceC3750qp117 = interfaceC3750qp4;
                BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen112, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i2113 & 896) | (i2113 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i19 = iM5113getClipgIe3tQ8;
                i20 = i18;
                modifier3 = modifier115;
                textStyle4 = textStyle3;
                z4 = z3;
                interfaceC3750qp5 = interfaceC3750qp117;
            } else {
                if (i21 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i6 != 0) {
                    textStyle3 = TextStyle.Companion.getDefault();
                } else {
                    textStyle3 = textStyle2;
                }
                if (i8 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i10 != 0) {
                    iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                } else {
                    iM5113getClipgIe3tQ8 = i11;
                }
                if (i13 != 0) {
                    i18 = Integer.MAX_VALUE;
                } else {
                    i18 = i2;
                }
                if (i15 != 0) {
                    interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                } else {
                    interfaceC3750qp4 = interfaceC3750qp2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller113 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller113);
                    objRememberedValue2 = compositionScopedCoroutineScopeCanceller113;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope113 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen113 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope113, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i2114 = i5 >> 3;
                Modifier modifier116 = modifier2;
                InterfaceC3750qp interfaceC3750qp118 = interfaceC3750qp4;
                BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen113, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i2114 & 896) | (i2114 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i19 = iM5113getClipgIe3tQ8;
                i20 = i18;
                modifier3 = modifier116;
                textStyle4 = textStyle3;
                z4 = z3;
                interfaceC3750qp5 = interfaceC3750qp118;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$6(annotatedString, interfaceC3750qp, modifier3, textStyle4, z4, i19, i20, interfaceC3750qp5, interfaceC3750qp3, i3, i4));
        }
        i5 |= 3072;
        textStyle2 = textStyle;
        i8 = i4 & 16;
        if (i8 != 0) {
            if ((i3 & 57344) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i5 |= i9;
            }
            i10 = i4 & 32;
            if (i10 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i11 = i;
            } else {
                i11 = i;
                if ((i3 & 458752) == 0) {
                    if (composerStartRestartGroup.changed(i11)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i5 |= i12;
                }
            }
            i13 = i4 & 64;
            if (i13 != 0) {
                i5 |= 1572864;
            } else if ((i3 & 3670016) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i14 = 1048576;
                } else {
                    i14 = 524288;
                }
                i5 |= i14;
            }
            i15 = i4 & 128;
            if (i15 != 0) {
                i5 |= 12582912;
            } else if ((i3 & 29360128) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                    i16 = 8388608;
                } else {
                    i16 = 4194304;
                }
                i5 |= i16;
            }
            if ((i4 & 256) != 0) {
                if ((234881024 & i3) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp3)) {
                        i17 = 67108864;
                    } else {
                        i17 = 33554432;
                    }
                }
                if ((191739611 & i5) == 38347922) {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                    } else {
                        interfaceC3750qp4 = interfaceC3750qp2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller114 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller114);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller114;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope114 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen114 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope114, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i2115 = i5 >> 3;
                    Modifier modifier117 = modifier2;
                    InterfaceC3750qp interfaceC3750qp119 = interfaceC3750qp4;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen114, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i2115 & 896) | (i2115 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = iM5113getClipgIe3tQ8;
                    i20 = i18;
                    modifier3 = modifier117;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    interfaceC3750qp5 = interfaceC3750qp119;
                } else {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                    } else {
                        interfaceC3750qp4 = interfaceC3750qp2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller115 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller115);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller115;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope115 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen115 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope115, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i2116 = i5 >> 3;
                    Modifier modifier118 = modifier2;
                    InterfaceC3750qp interfaceC3750qp1110 = interfaceC3750qp4;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen115, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i2116 & 896) | (i2116 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = iM5113getClipgIe3tQ8;
                    i20 = i18;
                    modifier3 = modifier118;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    interfaceC3750qp5 = interfaceC3750qp1110;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$6(annotatedString, interfaceC3750qp, modifier3, textStyle4, z4, i19, i20, interfaceC3750qp5, interfaceC3750qp3, i3, i4));
            }
            i17 = 100663296;
            i5 |= i17;
            if ((191739611 & i5) == 38347922) {
                if (i21 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i6 != 0) {
                    textStyle3 = TextStyle.Companion.getDefault();
                } else {
                    textStyle3 = textStyle2;
                }
                if (i8 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i10 != 0) {
                    iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                } else {
                    iM5113getClipgIe3tQ8 = i11;
                }
                if (i13 != 0) {
                    i18 = Integer.MAX_VALUE;
                } else {
                    i18 = i2;
                }
                if (i15 != 0) {
                    interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                } else {
                    interfaceC3750qp4 = interfaceC3750qp2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller116 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller116);
                    objRememberedValue2 = compositionScopedCoroutineScopeCanceller116;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope116 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen116 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope116, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i2117 = i5 >> 3;
                Modifier modifier119 = modifier2;
                InterfaceC3750qp interfaceC3750qp1111 = interfaceC3750qp4;
                BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen116, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i2117 & 896) | (i2117 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i19 = iM5113getClipgIe3tQ8;
                i20 = i18;
                modifier3 = modifier119;
                textStyle4 = textStyle3;
                z4 = z3;
                interfaceC3750qp5 = interfaceC3750qp1111;
            } else {
                if (i21 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i6 != 0) {
                    textStyle3 = TextStyle.Companion.getDefault();
                } else {
                    textStyle3 = textStyle2;
                }
                if (i8 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i10 != 0) {
                    iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                } else {
                    iM5113getClipgIe3tQ8 = i11;
                }
                if (i13 != 0) {
                    i18 = Integer.MAX_VALUE;
                } else {
                    i18 = i2;
                }
                if (i15 != 0) {
                    interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                } else {
                    interfaceC3750qp4 = interfaceC3750qp2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller117 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller117);
                    objRememberedValue2 = compositionScopedCoroutineScopeCanceller117;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope117 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen117 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope117, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i2118 = i5 >> 3;
                Modifier modifier1110 = modifier2;
                InterfaceC3750qp interfaceC3750qp1112 = interfaceC3750qp4;
                BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen117, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i2118 & 896) | (i2118 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i19 = iM5113getClipgIe3tQ8;
                i20 = i18;
                modifier3 = modifier1110;
                textStyle4 = textStyle3;
                z4 = z3;
                interfaceC3750qp5 = interfaceC3750qp1112;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$6(annotatedString, interfaceC3750qp, modifier3, textStyle4, z4, i19, i20, interfaceC3750qp5, interfaceC3750qp3, i3, i4));
        }
        i5 |= 24576;
        z2 = z;
        i10 = i4 & 32;
        if (i10 != 0) {
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i11 = i;
        } else {
            i11 = i;
            if ((i3 & 458752) == 0) {
                if (composerStartRestartGroup.changed(i11)) {
                    i12 = 131072;
                } else {
                    i12 = 65536;
                }
                i5 |= i12;
            }
        }
        i13 = i4 & 64;
        if (i13 != 0) {
            i5 |= 1572864;
        } else if ((i3 & 3670016) == 0) {
            if (composerStartRestartGroup.changed(i2)) {
                i14 = 1048576;
            } else {
                i14 = 524288;
            }
            i5 |= i14;
        }
        i15 = i4 & 128;
        if (i15 != 0) {
            i5 |= 12582912;
        } else if ((i3 & 29360128) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                i16 = 8388608;
            } else {
                i16 = 4194304;
            }
            i5 |= i16;
        }
        if ((i4 & 256) != 0) {
            if ((234881024 & i3) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp3)) {
                    i17 = 67108864;
                } else {
                    i17 = 33554432;
                }
            }
            if ((191739611 & i5) == 38347922) {
                if (i21 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i6 != 0) {
                    textStyle3 = TextStyle.Companion.getDefault();
                } else {
                    textStyle3 = textStyle2;
                }
                if (i8 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i10 != 0) {
                    iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                } else {
                    iM5113getClipgIe3tQ8 = i11;
                }
                if (i13 != 0) {
                    i18 = Integer.MAX_VALUE;
                } else {
                    i18 = i2;
                }
                if (i15 != 0) {
                    interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                } else {
                    interfaceC3750qp4 = interfaceC3750qp2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller118 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller118);
                    objRememberedValue2 = compositionScopedCoroutineScopeCanceller118;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope118 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen118 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope118, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i2119 = i5 >> 3;
                Modifier modifier1111 = modifier2;
                InterfaceC3750qp interfaceC3750qp1113 = interfaceC3750qp4;
                BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen118, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i2119 & 896) | (i2119 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i19 = iM5113getClipgIe3tQ8;
                i20 = i18;
                modifier3 = modifier1111;
                textStyle4 = textStyle3;
                z4 = z3;
                interfaceC3750qp5 = interfaceC3750qp1113;
            } else {
                if (i21 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i6 != 0) {
                    textStyle3 = TextStyle.Companion.getDefault();
                } else {
                    textStyle3 = textStyle2;
                }
                if (i8 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i10 != 0) {
                    iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                } else {
                    iM5113getClipgIe3tQ8 = i11;
                }
                if (i13 != 0) {
                    i18 = Integer.MAX_VALUE;
                } else {
                    i18 = i2;
                }
                if (i15 != 0) {
                    interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
                } else {
                    interfaceC3750qp4 = interfaceC3750qp2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller119 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller119);
                    objRememberedValue2 = compositionScopedCoroutineScopeCanceller119;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope119 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen119 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope119, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i21110 = i5 >> 3;
                Modifier modifier1112 = modifier2;
                InterfaceC3750qp interfaceC3750qp1114 = interfaceC3750qp4;
                BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen119, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i21110 & 896) | (i21110 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i19 = iM5113getClipgIe3tQ8;
                i20 = i18;
                modifier3 = modifier1112;
                textStyle4 = textStyle3;
                z4 = z3;
                interfaceC3750qp5 = interfaceC3750qp1114;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$6(annotatedString, interfaceC3750qp, modifier3, textStyle4, z4, i19, i20, interfaceC3750qp5, interfaceC3750qp3, i3, i4));
        }
        i17 = 100663296;
        i5 |= i17;
        if ((191739611 & i5) == 38347922) {
            if (i21 != 0) {
                modifier2 = Modifier.Companion;
            } else {
                modifier2 = modifier;
            }
            if (i6 != 0) {
                textStyle3 = TextStyle.Companion.getDefault();
            } else {
                textStyle3 = textStyle2;
            }
            if (i8 != 0) {
                z3 = true;
            } else {
                z3 = z2;
            }
            if (i10 != 0) {
                iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
            } else {
                iM5113getClipgIe3tQ8 = i11;
            }
            if (i13 != 0) {
                i18 = Integer.MAX_VALUE;
            } else {
                i18 = i2;
            }
            if (i15 != 0) {
                interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
            } else {
                interfaceC3750qp4 = interfaceC3750qp2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableState = (MutableState) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(773894976);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1110 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1110);
                objRememberedValue2 = compositionScopedCoroutineScopeCanceller1110;
            }
            composerStartRestartGroup.endReplaceableGroup();
            InterfaceC2052dg coroutineScope1110 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierThen1110 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope1110, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            int i21111 = i5 >> 3;
            Modifier modifier1113 = modifier2;
            InterfaceC3750qp interfaceC3750qp1115 = interfaceC3750qp4;
            BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen1110, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i21111 & 896) | (i21111 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            i19 = iM5113getClipgIe3tQ8;
            i20 = i18;
            modifier3 = modifier1113;
            textStyle4 = textStyle3;
            z4 = z3;
            interfaceC3750qp5 = interfaceC3750qp1115;
        } else {
            if (i21 != 0) {
                modifier2 = Modifier.Companion;
            } else {
                modifier2 = modifier;
            }
            if (i6 != 0) {
                textStyle3 = TextStyle.Companion.getDefault();
            } else {
                textStyle3 = textStyle2;
            }
            if (i8 != 0) {
                z3 = true;
            } else {
                z3 = z2;
            }
            if (i10 != 0) {
                iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
            } else {
                iM5113getClipgIe3tQ8 = i11;
            }
            if (i13 != 0) {
                i18 = Integer.MAX_VALUE;
            } else {
                i18 = i2;
            }
            if (i15 != 0) {
                interfaceC3750qp4 = ClickableTextKt$ClickableText$4.INSTANCE;
            } else {
                interfaceC3750qp4 = interfaceC3750qp2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:142)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableState = (MutableState) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(773894976);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1111 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1111);
                objRememberedValue2 = compositionScopedCoroutineScopeCanceller1111;
            }
            composerStartRestartGroup.endReplaceableGroup();
            InterfaceC2052dg coroutineScope1111 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierThen1111 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC3750qp3, interfaceC3750qp, new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope1111, interfaceC3750qp, mutableState, interfaceC3750qp3, null)));
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp4);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new ClickableTextKt$ClickableText$5$1(mutableState, interfaceC3750qp4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            int i21112 = i5 >> 3;
            Modifier modifier1114 = modifier2;
            InterfaceC3750qp interfaceC3750qp1116 = interfaceC3750qp4;
            BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen1111, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (i5 & 14) | (i21112 & 896) | (i21112 & 57344) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            i19 = iM5113getClipgIe3tQ8;
            i20 = i18;
            modifier3 = modifier1114;
            textStyle4 = textStyle3;
            z4 = z3;
            interfaceC3750qp5 = interfaceC3750qp1116;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$6(annotatedString, interfaceC3750qp, modifier3, textStyle4, z4, i19, i20, interfaceC3750qp5, interfaceC3750qp3, i3, i4));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0131  */
    /* JADX WARN: Code duplicated, block: B:102:0x0135  */
    /* JADX WARN: Code duplicated, block: B:103:0x013e  */
    /* JADX WARN: Code duplicated, block: B:105:0x0142  */
    /* JADX WARN: Code duplicated, block: B:106:0x0149  */
    /* JADX WARN: Code duplicated, block: B:108:0x014d  */
    /* JADX WARN: Code duplicated, block: B:109:0x0151  */
    /* JADX WARN: Code duplicated, block: B:112:0x0159  */
    /* JADX WARN: Code duplicated, block: B:115:0x0175  */
    /* JADX WARN: Code duplicated, block: B:118:0x0199  */
    /* JADX WARN: Code duplicated, block: B:120:0x019f  */
    /* JADX WARN: Code duplicated, block: B:123:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:125:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:128:0x020e  */
    /* JADX WARN: Code duplicated, block: B:133:0x0224  */
    /* JADX WARN: Code duplicated, block: B:135:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARN: Code duplicated, block: B:48:0x0087  */
    /* JADX WARN: Code duplicated, block: B:50:0x008c  */
    /* JADX WARN: Code duplicated, block: B:52:0x0092  */
    /* JADX WARN: Code duplicated, block: B:54:0x009a  */
    /* JADX WARN: Code duplicated, block: B:55:0x009d  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:74:0x00da  */
    /* JADX WARN: Code duplicated, block: B:75:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:89:0x0103  */
    /* JADX WARN: Code duplicated, block: B:93:0x0119 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:94:0x011b  */
    /* JADX WARN: Code duplicated, block: B:96:0x0120  */
    /* JADX WARN: Code duplicated, block: B:97:0x0129  */
    /* JADX WARN: Code duplicated, block: B:99:0x012d  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ClickableText-4YKlhWE, reason: not valid java name */
    public static final void m750ClickableText4YKlhWE(AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, boolean z, int i, int i2, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, Composer composer, int i3, int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        TextStyle textStyle2;
        int i7;
        int i8;
        boolean z2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        TextStyle textStyle3;
        boolean z3;
        int iM5113getClipgIe3tQ8;
        int i18;
        InterfaceC3750qp interfaceC3750qp3;
        Object objRememberedValue;
        Composer.Companion companion;
        MutableState mutableState;
        boolean zChanged;
        Object objRememberedValue2;
        boolean zChanged2;
        Object objRememberedValue3;
        int i19;
        Modifier modifier3;
        InterfaceC3750qp interfaceC3750qp4;
        TextStyle textStyle4;
        boolean z4;
        int i20;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(annotatedString, "text");
        AbstractC4492zt.h(interfaceC3750qp2, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-246609449);
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(annotatedString) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i21 = i4 & 2;
        if (i21 == 0) {
            if ((i3 & 112) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i6 = i4 & 4;
            if (i6 != 0) {
                if ((i3 & 896) == 0) {
                    textStyle2 = textStyle;
                    if (composerStartRestartGroup.changed(textStyle2)) {
                        i7 = 256;
                    } else {
                        i7 = 128;
                    }
                    i5 |= i7;
                }
                i8 = i4 & 8;
                if (i8 != 0) {
                    if ((i3 & 7168) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 2048;
                        } else {
                            i9 = 1024;
                        }
                        i5 |= i9;
                    }
                    i10 = i4 & 16;
                    if (i10 != 0) {
                        if ((57344 & i3) == 0) {
                            i11 = i;
                            if (composerStartRestartGroup.changed(i11)) {
                                i12 = 16384;
                            } else {
                                i12 = 8192;
                            }
                            i5 |= i12;
                        }
                        i13 = i4 & 32;
                        if (i13 != 0) {
                            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i3 & 458752) == 0) {
                            if (composerStartRestartGroup.changed(i2)) {
                                i14 = 131072;
                            } else {
                                i14 = 65536;
                            }
                            i5 |= i14;
                        }
                        i15 = i4 & 64;
                        if (i15 != 0) {
                            i5 |= 1572864;
                        } else if ((i3 & 3670016) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                                i16 = 1048576;
                            } else {
                                i16 = 524288;
                            }
                            i5 |= i16;
                        }
                        if ((i4 & 128) != 0) {
                            if ((29360128 & i3) == 0) {
                                if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                                    i17 = 8388608;
                                } else {
                                    i17 = 4194304;
                                }
                            }
                            if ((23967451 & i5) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                                if (i21 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    textStyle3 = TextStyle.Companion.getDefault();
                                } else {
                                    textStyle3 = textStyle2;
                                }
                                if (i8 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (i10 != 0) {
                                    iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                                } else {
                                    iM5113getClipgIe3tQ8 = i11;
                                }
                                if (i13 != 0) {
                                    i18 = Integer.MAX_VALUE;
                                } else {
                                    i18 = i2;
                                }
                                if (i15 != 0) {
                                    interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                                } else {
                                    interfaceC3750qp3 = interfaceC3750qp;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                                }
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                companion = Composer.Companion;
                                if (objRememberedValue == companion.getEmpty()) {
                                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableState = (MutableState) objRememberedValue;
                                Modifier.Companion companion2 = Modifier.Companion;
                                composerStartRestartGroup.startReplaceableGroup(511388516);
                                zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                                    objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                Modifier modifierThen = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion2, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                                composerStartRestartGroup.startReplaceableGroup(511388516);
                                zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                                    objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                Modifier modifier4 = modifier2;
                                InterfaceC3750qp interfaceC3750qp5 = interfaceC3750qp3;
                                BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                i19 = i18;
                                modifier3 = modifier4;
                                interfaceC3750qp4 = interfaceC3750qp5;
                                textStyle4 = textStyle3;
                                z4 = z3;
                                i20 = iM5113getClipgIe3tQ8;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                interfaceC3750qp4 = interfaceC3750qp;
                                modifier3 = modifier2;
                                textStyle4 = textStyle2;
                                z4 = z2;
                                i20 = i11;
                                i19 = i2;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
                        }
                        i17 = 12582912;
                        i5 |= i17;
                        if ((23967451 & i5) == 4793490) {
                            if (i21 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i6 != 0) {
                                textStyle3 = TextStyle.Companion.getDefault();
                            } else {
                                textStyle3 = textStyle2;
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i10 != 0) {
                                iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                            } else {
                                iM5113getClipgIe3tQ8 = i11;
                            }
                            if (i13 != 0) {
                                i18 = Integer.MAX_VALUE;
                            } else {
                                i18 = i2;
                            }
                            if (i15 != 0) {
                                interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.Companion;
                            if (objRememberedValue == companion.getEmpty()) {
                                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableState = (MutableState) objRememberedValue;
                            Modifier.Companion companion3 = Modifier.Companion;
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Modifier modifierThen2 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion3, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged2) {
                                objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Modifier modifier5 = modifier2;
                            InterfaceC3750qp interfaceC3750qp6 = interfaceC3750qp3;
                            BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen2, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            i19 = i18;
                            modifier3 = modifier5;
                            interfaceC3750qp4 = interfaceC3750qp6;
                            textStyle4 = textStyle3;
                            z4 = z3;
                            i20 = iM5113getClipgIe3tQ8;
                        } else {
                            if (i21 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i6 != 0) {
                                textStyle3 = TextStyle.Companion.getDefault();
                            } else {
                                textStyle3 = textStyle2;
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i10 != 0) {
                                iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                            } else {
                                iM5113getClipgIe3tQ8 = i11;
                            }
                            if (i13 != 0) {
                                i18 = Integer.MAX_VALUE;
                            } else {
                                i18 = i2;
                            }
                            if (i15 != 0) {
                                interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.Companion;
                            if (objRememberedValue == companion.getEmpty()) {
                                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableState = (MutableState) objRememberedValue;
                            Modifier.Companion companion4 = Modifier.Companion;
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Modifier modifierThen3 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion4, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged2) {
                                objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Modifier modifier6 = modifier2;
                            InterfaceC3750qp interfaceC3750qp7 = interfaceC3750qp3;
                            BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen3, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            i19 = i18;
                            modifier3 = modifier6;
                            interfaceC3750qp4 = interfaceC3750qp7;
                            textStyle4 = textStyle3;
                            z4 = z3;
                            i20 = iM5113getClipgIe3tQ8;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
                    }
                    i5 |= 24576;
                    i11 = i;
                    i13 = i4 & 32;
                    if (i13 != 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i3 & 458752) == 0) {
                        if (composerStartRestartGroup.changed(i2)) {
                            i14 = 131072;
                        } else {
                            i14 = 65536;
                        }
                        i5 |= i14;
                    }
                    i15 = i4 & 64;
                    if (i15 != 0) {
                        i5 |= 1572864;
                    } else if ((i3 & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i16 = 1048576;
                        } else {
                            i16 = 524288;
                        }
                        i5 |= i16;
                    }
                    if ((i4 & 128) != 0) {
                        if ((29360128 & i3) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                                i17 = 8388608;
                            } else {
                                i17 = 4194304;
                            }
                        }
                        if ((23967451 & i5) == 4793490) {
                            if (i21 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i6 != 0) {
                                textStyle3 = TextStyle.Companion.getDefault();
                            } else {
                                textStyle3 = textStyle2;
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i10 != 0) {
                                iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                            } else {
                                iM5113getClipgIe3tQ8 = i11;
                            }
                            if (i13 != 0) {
                                i18 = Integer.MAX_VALUE;
                            } else {
                                i18 = i2;
                            }
                            if (i15 != 0) {
                                interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.Companion;
                            if (objRememberedValue == companion.getEmpty()) {
                                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableState = (MutableState) objRememberedValue;
                            Modifier.Companion companion5 = Modifier.Companion;
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Modifier modifierThen4 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion5, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged2) {
                                objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Modifier modifier7 = modifier2;
                            InterfaceC3750qp interfaceC3750qp8 = interfaceC3750qp3;
                            BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen4, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            i19 = i18;
                            modifier3 = modifier7;
                            interfaceC3750qp4 = interfaceC3750qp8;
                            textStyle4 = textStyle3;
                            z4 = z3;
                            i20 = iM5113getClipgIe3tQ8;
                        } else {
                            if (i21 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i6 != 0) {
                                textStyle3 = TextStyle.Companion.getDefault();
                            } else {
                                textStyle3 = textStyle2;
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i10 != 0) {
                                iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                            } else {
                                iM5113getClipgIe3tQ8 = i11;
                            }
                            if (i13 != 0) {
                                i18 = Integer.MAX_VALUE;
                            } else {
                                i18 = i2;
                            }
                            if (i15 != 0) {
                                interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.Companion;
                            if (objRememberedValue == companion.getEmpty()) {
                                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableState = (MutableState) objRememberedValue;
                            Modifier.Companion companion6 = Modifier.Companion;
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Modifier modifierThen5 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion6, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged2) {
                                objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Modifier modifier8 = modifier2;
                            InterfaceC3750qp interfaceC3750qp9 = interfaceC3750qp3;
                            BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen5, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            i19 = i18;
                            modifier3 = modifier8;
                            interfaceC3750qp4 = interfaceC3750qp9;
                            textStyle4 = textStyle3;
                            z4 = z3;
                            i20 = iM5113getClipgIe3tQ8;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
                    }
                    i17 = 12582912;
                    i5 |= i17;
                    if ((23967451 & i5) == 4793490) {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        Modifier.Companion companion7 = Modifier.Companion;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen6 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion7, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier9 = modifier2;
                        InterfaceC3750qp interfaceC3750qp10 = interfaceC3750qp3;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen6, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = i18;
                        modifier3 = modifier9;
                        interfaceC3750qp4 = interfaceC3750qp10;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        i20 = iM5113getClipgIe3tQ8;
                    } else {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        Modifier.Companion companion8 = Modifier.Companion;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen7 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion8, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier10 = modifier2;
                        InterfaceC3750qp interfaceC3750qp11 = interfaceC3750qp3;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen7, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = i18;
                        modifier3 = modifier10;
                        interfaceC3750qp4 = interfaceC3750qp11;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        i20 = iM5113getClipgIe3tQ8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
                }
                i5 |= 3072;
                z2 = z;
                i10 = i4 & 16;
                if (i10 != 0) {
                    if ((57344 & i3) == 0) {
                        i11 = i;
                        if (composerStartRestartGroup.changed(i11)) {
                            i12 = 16384;
                        } else {
                            i12 = 8192;
                        }
                        i5 |= i12;
                    }
                    i13 = i4 & 32;
                    if (i13 != 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i3 & 458752) == 0) {
                        if (composerStartRestartGroup.changed(i2)) {
                            i14 = 131072;
                        } else {
                            i14 = 65536;
                        }
                        i5 |= i14;
                    }
                    i15 = i4 & 64;
                    if (i15 != 0) {
                        i5 |= 1572864;
                    } else if ((i3 & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i16 = 1048576;
                        } else {
                            i16 = 524288;
                        }
                        i5 |= i16;
                    }
                    if ((i4 & 128) != 0) {
                        if ((29360128 & i3) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                                i17 = 8388608;
                            } else {
                                i17 = 4194304;
                            }
                        }
                        if ((23967451 & i5) == 4793490) {
                            if (i21 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i6 != 0) {
                                textStyle3 = TextStyle.Companion.getDefault();
                            } else {
                                textStyle3 = textStyle2;
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i10 != 0) {
                                iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                            } else {
                                iM5113getClipgIe3tQ8 = i11;
                            }
                            if (i13 != 0) {
                                i18 = Integer.MAX_VALUE;
                            } else {
                                i18 = i2;
                            }
                            if (i15 != 0) {
                                interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.Companion;
                            if (objRememberedValue == companion.getEmpty()) {
                                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableState = (MutableState) objRememberedValue;
                            Modifier.Companion companion9 = Modifier.Companion;
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Modifier modifierThen8 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion9, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged2) {
                                objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Modifier modifier11 = modifier2;
                            InterfaceC3750qp interfaceC3750qp12 = interfaceC3750qp3;
                            BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen8, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            i19 = i18;
                            modifier3 = modifier11;
                            interfaceC3750qp4 = interfaceC3750qp12;
                            textStyle4 = textStyle3;
                            z4 = z3;
                            i20 = iM5113getClipgIe3tQ8;
                        } else {
                            if (i21 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i6 != 0) {
                                textStyle3 = TextStyle.Companion.getDefault();
                            } else {
                                textStyle3 = textStyle2;
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i10 != 0) {
                                iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                            } else {
                                iM5113getClipgIe3tQ8 = i11;
                            }
                            if (i13 != 0) {
                                i18 = Integer.MAX_VALUE;
                            } else {
                                i18 = i2;
                            }
                            if (i15 != 0) {
                                interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.Companion;
                            if (objRememberedValue == companion.getEmpty()) {
                                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableState = (MutableState) objRememberedValue;
                            Modifier.Companion companion10 = Modifier.Companion;
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Modifier modifierThen9 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion10, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged2) {
                                objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Modifier modifier12 = modifier2;
                            InterfaceC3750qp interfaceC3750qp13 = interfaceC3750qp3;
                            BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen9, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            i19 = i18;
                            modifier3 = modifier12;
                            interfaceC3750qp4 = interfaceC3750qp13;
                            textStyle4 = textStyle3;
                            z4 = z3;
                            i20 = iM5113getClipgIe3tQ8;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
                    }
                    i17 = 12582912;
                    i5 |= i17;
                    if ((23967451 & i5) == 4793490) {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        Modifier.Companion companion11 = Modifier.Companion;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen10 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion11, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier13 = modifier2;
                        InterfaceC3750qp interfaceC3750qp14 = interfaceC3750qp3;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen10, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = i18;
                        modifier3 = modifier13;
                        interfaceC3750qp4 = interfaceC3750qp14;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        i20 = iM5113getClipgIe3tQ8;
                    } else {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        Modifier.Companion companion12 = Modifier.Companion;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen11 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion12, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier14 = modifier2;
                        InterfaceC3750qp interfaceC3750qp15 = interfaceC3750qp3;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen11, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = i18;
                        modifier3 = modifier14;
                        interfaceC3750qp4 = interfaceC3750qp15;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        i20 = iM5113getClipgIe3tQ8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
                }
                i5 |= 24576;
                i11 = i;
                i13 = i4 & 32;
                if (i13 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & 458752) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i14 = 131072;
                    } else {
                        i14 = 65536;
                    }
                    i5 |= i14;
                }
                i15 = i4 & 64;
                if (i15 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i5 |= i16;
                }
                if ((i4 & 128) != 0) {
                    if ((29360128 & i3) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                            i17 = 8388608;
                        } else {
                            i17 = 4194304;
                        }
                    }
                    if ((23967451 & i5) == 4793490) {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        Modifier.Companion companion13 = Modifier.Companion;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen12 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion13, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier15 = modifier2;
                        InterfaceC3750qp interfaceC3750qp16 = interfaceC3750qp3;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen12, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = i18;
                        modifier3 = modifier15;
                        interfaceC3750qp4 = interfaceC3750qp16;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        i20 = iM5113getClipgIe3tQ8;
                    } else {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        Modifier.Companion companion14 = Modifier.Companion;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen13 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion14, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier16 = modifier2;
                        InterfaceC3750qp interfaceC3750qp17 = interfaceC3750qp3;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen13, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = i18;
                        modifier3 = modifier16;
                        interfaceC3750qp4 = interfaceC3750qp17;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        i20 = iM5113getClipgIe3tQ8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
                }
                i17 = 12582912;
                i5 |= i17;
                if ((23967451 & i5) == 4793490) {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    Modifier.Companion companion15 = Modifier.Companion;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen14 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion15, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier17 = modifier2;
                    InterfaceC3750qp interfaceC3750qp18 = interfaceC3750qp3;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen14, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = i18;
                    modifier3 = modifier17;
                    interfaceC3750qp4 = interfaceC3750qp18;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    i20 = iM5113getClipgIe3tQ8;
                } else {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    Modifier.Companion companion16 = Modifier.Companion;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen15 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion16, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier18 = modifier2;
                    InterfaceC3750qp interfaceC3750qp19 = interfaceC3750qp3;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen15, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = i18;
                    modifier3 = modifier18;
                    interfaceC3750qp4 = interfaceC3750qp19;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    i20 = iM5113getClipgIe3tQ8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
            }
            i5 |= 384;
            textStyle2 = textStyle;
            i8 = i4 & 8;
            if (i8 != 0) {
                if ((i3 & 7168) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 2048;
                    } else {
                        i9 = 1024;
                    }
                    i5 |= i9;
                }
                i10 = i4 & 16;
                if (i10 != 0) {
                    if ((57344 & i3) == 0) {
                        i11 = i;
                        if (composerStartRestartGroup.changed(i11)) {
                            i12 = 16384;
                        } else {
                            i12 = 8192;
                        }
                        i5 |= i12;
                    }
                    i13 = i4 & 32;
                    if (i13 != 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i3 & 458752) == 0) {
                        if (composerStartRestartGroup.changed(i2)) {
                            i14 = 131072;
                        } else {
                            i14 = 65536;
                        }
                        i5 |= i14;
                    }
                    i15 = i4 & 64;
                    if (i15 != 0) {
                        i5 |= 1572864;
                    } else if ((i3 & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i16 = 1048576;
                        } else {
                            i16 = 524288;
                        }
                        i5 |= i16;
                    }
                    if ((i4 & 128) != 0) {
                        if ((29360128 & i3) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                                i17 = 8388608;
                            } else {
                                i17 = 4194304;
                            }
                        }
                        if ((23967451 & i5) == 4793490) {
                            if (i21 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i6 != 0) {
                                textStyle3 = TextStyle.Companion.getDefault();
                            } else {
                                textStyle3 = textStyle2;
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i10 != 0) {
                                iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                            } else {
                                iM5113getClipgIe3tQ8 = i11;
                            }
                            if (i13 != 0) {
                                i18 = Integer.MAX_VALUE;
                            } else {
                                i18 = i2;
                            }
                            if (i15 != 0) {
                                interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.Companion;
                            if (objRememberedValue == companion.getEmpty()) {
                                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableState = (MutableState) objRememberedValue;
                            Modifier.Companion companion17 = Modifier.Companion;
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Modifier modifierThen16 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion17, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged2) {
                                objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Modifier modifier19 = modifier2;
                            InterfaceC3750qp interfaceC3750qp110 = interfaceC3750qp3;
                            BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen16, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            i19 = i18;
                            modifier3 = modifier19;
                            interfaceC3750qp4 = interfaceC3750qp110;
                            textStyle4 = textStyle3;
                            z4 = z3;
                            i20 = iM5113getClipgIe3tQ8;
                        } else {
                            if (i21 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i6 != 0) {
                                textStyle3 = TextStyle.Companion.getDefault();
                            } else {
                                textStyle3 = textStyle2;
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i10 != 0) {
                                iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                            } else {
                                iM5113getClipgIe3tQ8 = i11;
                            }
                            if (i13 != 0) {
                                i18 = Integer.MAX_VALUE;
                            } else {
                                i18 = i2;
                            }
                            if (i15 != 0) {
                                interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.Companion;
                            if (objRememberedValue == companion.getEmpty()) {
                                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableState = (MutableState) objRememberedValue;
                            Modifier.Companion companion18 = Modifier.Companion;
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Modifier modifierThen17 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion18, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged2) {
                                objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Modifier modifier110 = modifier2;
                            InterfaceC3750qp interfaceC3750qp111 = interfaceC3750qp3;
                            BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen17, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            i19 = i18;
                            modifier3 = modifier110;
                            interfaceC3750qp4 = interfaceC3750qp111;
                            textStyle4 = textStyle3;
                            z4 = z3;
                            i20 = iM5113getClipgIe3tQ8;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
                    }
                    i17 = 12582912;
                    i5 |= i17;
                    if ((23967451 & i5) == 4793490) {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        Modifier.Companion companion19 = Modifier.Companion;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen18 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion19, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier111 = modifier2;
                        InterfaceC3750qp interfaceC3750qp112 = interfaceC3750qp3;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen18, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = i18;
                        modifier3 = modifier111;
                        interfaceC3750qp4 = interfaceC3750qp112;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        i20 = iM5113getClipgIe3tQ8;
                    } else {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        Modifier.Companion companion110 = Modifier.Companion;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen19 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion110, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier112 = modifier2;
                        InterfaceC3750qp interfaceC3750qp113 = interfaceC3750qp3;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen19, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = i18;
                        modifier3 = modifier112;
                        interfaceC3750qp4 = interfaceC3750qp113;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        i20 = iM5113getClipgIe3tQ8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
                }
                i5 |= 24576;
                i11 = i;
                i13 = i4 & 32;
                if (i13 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & 458752) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i14 = 131072;
                    } else {
                        i14 = 65536;
                    }
                    i5 |= i14;
                }
                i15 = i4 & 64;
                if (i15 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i5 |= i16;
                }
                if ((i4 & 128) != 0) {
                    if ((29360128 & i3) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                            i17 = 8388608;
                        } else {
                            i17 = 4194304;
                        }
                    }
                    if ((23967451 & i5) == 4793490) {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        Modifier.Companion companion111 = Modifier.Companion;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen110 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion111, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier113 = modifier2;
                        InterfaceC3750qp interfaceC3750qp114 = interfaceC3750qp3;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen110, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = i18;
                        modifier3 = modifier113;
                        interfaceC3750qp4 = interfaceC3750qp114;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        i20 = iM5113getClipgIe3tQ8;
                    } else {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        Modifier.Companion companion112 = Modifier.Companion;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen111 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion112, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier114 = modifier2;
                        InterfaceC3750qp interfaceC3750qp115 = interfaceC3750qp3;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen111, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = i18;
                        modifier3 = modifier114;
                        interfaceC3750qp4 = interfaceC3750qp115;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        i20 = iM5113getClipgIe3tQ8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
                }
                i17 = 12582912;
                i5 |= i17;
                if ((23967451 & i5) == 4793490) {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    Modifier.Companion companion113 = Modifier.Companion;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen112 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion113, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier115 = modifier2;
                    InterfaceC3750qp interfaceC3750qp116 = interfaceC3750qp3;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen112, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = i18;
                    modifier3 = modifier115;
                    interfaceC3750qp4 = interfaceC3750qp116;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    i20 = iM5113getClipgIe3tQ8;
                } else {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    Modifier.Companion companion114 = Modifier.Companion;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen113 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion114, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier116 = modifier2;
                    InterfaceC3750qp interfaceC3750qp117 = interfaceC3750qp3;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen113, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = i18;
                    modifier3 = modifier116;
                    interfaceC3750qp4 = interfaceC3750qp117;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    i20 = iM5113getClipgIe3tQ8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
            }
            i5 |= 3072;
            z2 = z;
            i10 = i4 & 16;
            if (i10 != 0) {
                if ((57344 & i3) == 0) {
                    i11 = i;
                    if (composerStartRestartGroup.changed(i11)) {
                        i12 = 16384;
                    } else {
                        i12 = 8192;
                    }
                    i5 |= i12;
                }
                i13 = i4 & 32;
                if (i13 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & 458752) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i14 = 131072;
                    } else {
                        i14 = 65536;
                    }
                    i5 |= i14;
                }
                i15 = i4 & 64;
                if (i15 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i5 |= i16;
                }
                if ((i4 & 128) != 0) {
                    if ((29360128 & i3) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                            i17 = 8388608;
                        } else {
                            i17 = 4194304;
                        }
                    }
                    if ((23967451 & i5) == 4793490) {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        Modifier.Companion companion115 = Modifier.Companion;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen114 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion115, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier117 = modifier2;
                        InterfaceC3750qp interfaceC3750qp118 = interfaceC3750qp3;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen114, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = i18;
                        modifier3 = modifier117;
                        interfaceC3750qp4 = interfaceC3750qp118;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        i20 = iM5113getClipgIe3tQ8;
                    } else {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        Modifier.Companion companion116 = Modifier.Companion;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen115 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion116, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier118 = modifier2;
                        InterfaceC3750qp interfaceC3750qp119 = interfaceC3750qp3;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen115, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = i18;
                        modifier3 = modifier118;
                        interfaceC3750qp4 = interfaceC3750qp119;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        i20 = iM5113getClipgIe3tQ8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
                }
                i17 = 12582912;
                i5 |= i17;
                if ((23967451 & i5) == 4793490) {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    Modifier.Companion companion117 = Modifier.Companion;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen116 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion117, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier119 = modifier2;
                    InterfaceC3750qp interfaceC3750qp1110 = interfaceC3750qp3;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen116, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = i18;
                    modifier3 = modifier119;
                    interfaceC3750qp4 = interfaceC3750qp1110;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    i20 = iM5113getClipgIe3tQ8;
                } else {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    Modifier.Companion companion118 = Modifier.Companion;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen117 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion118, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier1110 = modifier2;
                    InterfaceC3750qp interfaceC3750qp1111 = interfaceC3750qp3;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen117, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = i18;
                    modifier3 = modifier1110;
                    interfaceC3750qp4 = interfaceC3750qp1111;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    i20 = iM5113getClipgIe3tQ8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
            }
            i5 |= 24576;
            i11 = i;
            i13 = i4 & 32;
            if (i13 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i3 & 458752) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i14 = 131072;
                } else {
                    i14 = 65536;
                }
                i5 |= i14;
            }
            i15 = i4 & 64;
            if (i15 != 0) {
                i5 |= 1572864;
            } else if ((i3 & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i5 |= i16;
            }
            if ((i4 & 128) != 0) {
                if ((29360128 & i3) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                        i17 = 8388608;
                    } else {
                        i17 = 4194304;
                    }
                }
                if ((23967451 & i5) == 4793490) {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    Modifier.Companion companion119 = Modifier.Companion;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen118 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion119, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier1111 = modifier2;
                    InterfaceC3750qp interfaceC3750qp1112 = interfaceC3750qp3;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen118, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = i18;
                    modifier3 = modifier1111;
                    interfaceC3750qp4 = interfaceC3750qp1112;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    i20 = iM5113getClipgIe3tQ8;
                } else {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    Modifier.Companion companion1110 = Modifier.Companion;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen119 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion1110, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier1112 = modifier2;
                    InterfaceC3750qp interfaceC3750qp1113 = interfaceC3750qp3;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen119, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = i18;
                    modifier3 = modifier1112;
                    interfaceC3750qp4 = interfaceC3750qp1113;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    i20 = iM5113getClipgIe3tQ8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
            }
            i17 = 12582912;
            i5 |= i17;
            if ((23967451 & i5) == 4793490) {
                if (i21 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i6 != 0) {
                    textStyle3 = TextStyle.Companion.getDefault();
                } else {
                    textStyle3 = textStyle2;
                }
                if (i8 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i10 != 0) {
                    iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                } else {
                    iM5113getClipgIe3tQ8 = i11;
                }
                if (i13 != 0) {
                    i18 = Integer.MAX_VALUE;
                } else {
                    i18 = i2;
                }
                if (i15 != 0) {
                    interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                } else {
                    interfaceC3750qp3 = interfaceC3750qp;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue;
                Modifier.Companion companion1111 = Modifier.Companion;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen1110 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion1111, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifier1113 = modifier2;
                InterfaceC3750qp interfaceC3750qp1114 = interfaceC3750qp3;
                BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen1110, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i19 = i18;
                modifier3 = modifier1113;
                interfaceC3750qp4 = interfaceC3750qp1114;
                textStyle4 = textStyle3;
                z4 = z3;
                i20 = iM5113getClipgIe3tQ8;
            } else {
                if (i21 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i6 != 0) {
                    textStyle3 = TextStyle.Companion.getDefault();
                } else {
                    textStyle3 = textStyle2;
                }
                if (i8 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i10 != 0) {
                    iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                } else {
                    iM5113getClipgIe3tQ8 = i11;
                }
                if (i13 != 0) {
                    i18 = Integer.MAX_VALUE;
                } else {
                    i18 = i2;
                }
                if (i15 != 0) {
                    interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                } else {
                    interfaceC3750qp3 = interfaceC3750qp;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue;
                Modifier.Companion companion1112 = Modifier.Companion;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen1111 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion1112, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifier1114 = modifier2;
                InterfaceC3750qp interfaceC3750qp1115 = interfaceC3750qp3;
                BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen1111, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i19 = i18;
                modifier3 = modifier1114;
                interfaceC3750qp4 = interfaceC3750qp1115;
                textStyle4 = textStyle3;
                z4 = z3;
                i20 = iM5113getClipgIe3tQ8;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
        }
        i5 |= 48;
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 != 0) {
            if ((i3 & 896) == 0) {
                textStyle2 = textStyle;
                if (composerStartRestartGroup.changed(textStyle2)) {
                    i7 = 256;
                } else {
                    i7 = 128;
                }
                i5 |= i7;
            }
            i8 = i4 & 8;
            if (i8 != 0) {
                if ((i3 & 7168) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 2048;
                    } else {
                        i9 = 1024;
                    }
                    i5 |= i9;
                }
                i10 = i4 & 16;
                if (i10 != 0) {
                    if ((57344 & i3) == 0) {
                        i11 = i;
                        if (composerStartRestartGroup.changed(i11)) {
                            i12 = 16384;
                        } else {
                            i12 = 8192;
                        }
                        i5 |= i12;
                    }
                    i13 = i4 & 32;
                    if (i13 != 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i3 & 458752) == 0) {
                        if (composerStartRestartGroup.changed(i2)) {
                            i14 = 131072;
                        } else {
                            i14 = 65536;
                        }
                        i5 |= i14;
                    }
                    i15 = i4 & 64;
                    if (i15 != 0) {
                        i5 |= 1572864;
                    } else if ((i3 & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i16 = 1048576;
                        } else {
                            i16 = 524288;
                        }
                        i5 |= i16;
                    }
                    if ((i4 & 128) != 0) {
                        if ((29360128 & i3) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                                i17 = 8388608;
                            } else {
                                i17 = 4194304;
                            }
                        }
                        if ((23967451 & i5) == 4793490) {
                            if (i21 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i6 != 0) {
                                textStyle3 = TextStyle.Companion.getDefault();
                            } else {
                                textStyle3 = textStyle2;
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i10 != 0) {
                                iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                            } else {
                                iM5113getClipgIe3tQ8 = i11;
                            }
                            if (i13 != 0) {
                                i18 = Integer.MAX_VALUE;
                            } else {
                                i18 = i2;
                            }
                            if (i15 != 0) {
                                interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.Companion;
                            if (objRememberedValue == companion.getEmpty()) {
                                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableState = (MutableState) objRememberedValue;
                            Modifier.Companion companion1113 = Modifier.Companion;
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Modifier modifierThen1112 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion1113, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged2) {
                                objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Modifier modifier1115 = modifier2;
                            InterfaceC3750qp interfaceC3750qp1116 = interfaceC3750qp3;
                            BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen1112, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            i19 = i18;
                            modifier3 = modifier1115;
                            interfaceC3750qp4 = interfaceC3750qp1116;
                            textStyle4 = textStyle3;
                            z4 = z3;
                            i20 = iM5113getClipgIe3tQ8;
                        } else {
                            if (i21 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i6 != 0) {
                                textStyle3 = TextStyle.Companion.getDefault();
                            } else {
                                textStyle3 = textStyle2;
                            }
                            if (i8 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i10 != 0) {
                                iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                            } else {
                                iM5113getClipgIe3tQ8 = i11;
                            }
                            if (i13 != 0) {
                                i18 = Integer.MAX_VALUE;
                            } else {
                                i18 = i2;
                            }
                            if (i15 != 0) {
                                interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.Companion;
                            if (objRememberedValue == companion.getEmpty()) {
                                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableState = (MutableState) objRememberedValue;
                            Modifier.Companion companion1114 = Modifier.Companion;
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Modifier modifierThen1113 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion1114, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged2) {
                                objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Modifier modifier1116 = modifier2;
                            InterfaceC3750qp interfaceC3750qp1117 = interfaceC3750qp3;
                            BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen1113, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            i19 = i18;
                            modifier3 = modifier1116;
                            interfaceC3750qp4 = interfaceC3750qp1117;
                            textStyle4 = textStyle3;
                            z4 = z3;
                            i20 = iM5113getClipgIe3tQ8;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
                    }
                    i17 = 12582912;
                    i5 |= i17;
                    if ((23967451 & i5) == 4793490) {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        Modifier.Companion companion1115 = Modifier.Companion;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen1114 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion1115, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier1117 = modifier2;
                        InterfaceC3750qp interfaceC3750qp1118 = interfaceC3750qp3;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen1114, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = i18;
                        modifier3 = modifier1117;
                        interfaceC3750qp4 = interfaceC3750qp1118;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        i20 = iM5113getClipgIe3tQ8;
                    } else {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        Modifier.Companion companion1116 = Modifier.Companion;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen1115 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion1116, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier1118 = modifier2;
                        InterfaceC3750qp interfaceC3750qp1119 = interfaceC3750qp3;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen1115, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = i18;
                        modifier3 = modifier1118;
                        interfaceC3750qp4 = interfaceC3750qp1119;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        i20 = iM5113getClipgIe3tQ8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
                }
                i5 |= 24576;
                i11 = i;
                i13 = i4 & 32;
                if (i13 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & 458752) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i14 = 131072;
                    } else {
                        i14 = 65536;
                    }
                    i5 |= i14;
                }
                i15 = i4 & 64;
                if (i15 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i5 |= i16;
                }
                if ((i4 & 128) != 0) {
                    if ((29360128 & i3) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                            i17 = 8388608;
                        } else {
                            i17 = 4194304;
                        }
                    }
                    if ((23967451 & i5) == 4793490) {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        Modifier.Companion companion1117 = Modifier.Companion;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen1116 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion1117, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier1119 = modifier2;
                        InterfaceC3750qp interfaceC3750qp11110 = interfaceC3750qp3;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen1116, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = i18;
                        modifier3 = modifier1119;
                        interfaceC3750qp4 = interfaceC3750qp11110;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        i20 = iM5113getClipgIe3tQ8;
                    } else {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        Modifier.Companion companion1118 = Modifier.Companion;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen1117 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion1118, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier11110 = modifier2;
                        InterfaceC3750qp interfaceC3750qp11111 = interfaceC3750qp3;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen1117, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = i18;
                        modifier3 = modifier11110;
                        interfaceC3750qp4 = interfaceC3750qp11111;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        i20 = iM5113getClipgIe3tQ8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
                }
                i17 = 12582912;
                i5 |= i17;
                if ((23967451 & i5) == 4793490) {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    Modifier.Companion companion1119 = Modifier.Companion;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen1118 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion1119, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier11111 = modifier2;
                    InterfaceC3750qp interfaceC3750qp11112 = interfaceC3750qp3;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen1118, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = i18;
                    modifier3 = modifier11111;
                    interfaceC3750qp4 = interfaceC3750qp11112;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    i20 = iM5113getClipgIe3tQ8;
                } else {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    Modifier.Companion companion11110 = Modifier.Companion;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen1119 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion11110, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier11112 = modifier2;
                    InterfaceC3750qp interfaceC3750qp11113 = interfaceC3750qp3;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen1119, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = i18;
                    modifier3 = modifier11112;
                    interfaceC3750qp4 = interfaceC3750qp11113;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    i20 = iM5113getClipgIe3tQ8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
            }
            i5 |= 3072;
            z2 = z;
            i10 = i4 & 16;
            if (i10 != 0) {
                if ((57344 & i3) == 0) {
                    i11 = i;
                    if (composerStartRestartGroup.changed(i11)) {
                        i12 = 16384;
                    } else {
                        i12 = 8192;
                    }
                    i5 |= i12;
                }
                i13 = i4 & 32;
                if (i13 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & 458752) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i14 = 131072;
                    } else {
                        i14 = 65536;
                    }
                    i5 |= i14;
                }
                i15 = i4 & 64;
                if (i15 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i5 |= i16;
                }
                if ((i4 & 128) != 0) {
                    if ((29360128 & i3) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                            i17 = 8388608;
                        } else {
                            i17 = 4194304;
                        }
                    }
                    if ((23967451 & i5) == 4793490) {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        Modifier.Companion companion11111 = Modifier.Companion;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen11110 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion11111, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier11113 = modifier2;
                        InterfaceC3750qp interfaceC3750qp11114 = interfaceC3750qp3;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen11110, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = i18;
                        modifier3 = modifier11113;
                        interfaceC3750qp4 = interfaceC3750qp11114;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        i20 = iM5113getClipgIe3tQ8;
                    } else {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        Modifier.Companion companion11112 = Modifier.Companion;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen11111 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion11112, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier11114 = modifier2;
                        InterfaceC3750qp interfaceC3750qp11115 = interfaceC3750qp3;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen11111, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = i18;
                        modifier3 = modifier11114;
                        interfaceC3750qp4 = interfaceC3750qp11115;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        i20 = iM5113getClipgIe3tQ8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
                }
                i17 = 12582912;
                i5 |= i17;
                if ((23967451 & i5) == 4793490) {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    Modifier.Companion companion11113 = Modifier.Companion;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen11112 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion11113, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier11115 = modifier2;
                    InterfaceC3750qp interfaceC3750qp11116 = interfaceC3750qp3;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen11112, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = i18;
                    modifier3 = modifier11115;
                    interfaceC3750qp4 = interfaceC3750qp11116;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    i20 = iM5113getClipgIe3tQ8;
                } else {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    Modifier.Companion companion11114 = Modifier.Companion;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen11113 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion11114, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier11116 = modifier2;
                    InterfaceC3750qp interfaceC3750qp11117 = interfaceC3750qp3;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen11113, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = i18;
                    modifier3 = modifier11116;
                    interfaceC3750qp4 = interfaceC3750qp11117;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    i20 = iM5113getClipgIe3tQ8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
            }
            i5 |= 24576;
            i11 = i;
            i13 = i4 & 32;
            if (i13 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i3 & 458752) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i14 = 131072;
                } else {
                    i14 = 65536;
                }
                i5 |= i14;
            }
            i15 = i4 & 64;
            if (i15 != 0) {
                i5 |= 1572864;
            } else if ((i3 & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i5 |= i16;
            }
            if ((i4 & 128) != 0) {
                if ((29360128 & i3) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                        i17 = 8388608;
                    } else {
                        i17 = 4194304;
                    }
                }
                if ((23967451 & i5) == 4793490) {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    Modifier.Companion companion11115 = Modifier.Companion;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen11114 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion11115, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier11117 = modifier2;
                    InterfaceC3750qp interfaceC3750qp11118 = interfaceC3750qp3;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen11114, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = i18;
                    modifier3 = modifier11117;
                    interfaceC3750qp4 = interfaceC3750qp11118;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    i20 = iM5113getClipgIe3tQ8;
                } else {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    Modifier.Companion companion11116 = Modifier.Companion;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen11115 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion11116, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier11118 = modifier2;
                    InterfaceC3750qp interfaceC3750qp11119 = interfaceC3750qp3;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen11115, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = i18;
                    modifier3 = modifier11118;
                    interfaceC3750qp4 = interfaceC3750qp11119;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    i20 = iM5113getClipgIe3tQ8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
            }
            i17 = 12582912;
            i5 |= i17;
            if ((23967451 & i5) == 4793490) {
                if (i21 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i6 != 0) {
                    textStyle3 = TextStyle.Companion.getDefault();
                } else {
                    textStyle3 = textStyle2;
                }
                if (i8 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i10 != 0) {
                    iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                } else {
                    iM5113getClipgIe3tQ8 = i11;
                }
                if (i13 != 0) {
                    i18 = Integer.MAX_VALUE;
                } else {
                    i18 = i2;
                }
                if (i15 != 0) {
                    interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                } else {
                    interfaceC3750qp3 = interfaceC3750qp;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue;
                Modifier.Companion companion11117 = Modifier.Companion;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen11116 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion11117, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifier11119 = modifier2;
                InterfaceC3750qp interfaceC3750qp111110 = interfaceC3750qp3;
                BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen11116, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i19 = i18;
                modifier3 = modifier11119;
                interfaceC3750qp4 = interfaceC3750qp111110;
                textStyle4 = textStyle3;
                z4 = z3;
                i20 = iM5113getClipgIe3tQ8;
            } else {
                if (i21 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i6 != 0) {
                    textStyle3 = TextStyle.Companion.getDefault();
                } else {
                    textStyle3 = textStyle2;
                }
                if (i8 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i10 != 0) {
                    iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                } else {
                    iM5113getClipgIe3tQ8 = i11;
                }
                if (i13 != 0) {
                    i18 = Integer.MAX_VALUE;
                } else {
                    i18 = i2;
                }
                if (i15 != 0) {
                    interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                } else {
                    interfaceC3750qp3 = interfaceC3750qp;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue;
                Modifier.Companion companion11118 = Modifier.Companion;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen11117 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion11118, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifier111110 = modifier2;
                InterfaceC3750qp interfaceC3750qp111111 = interfaceC3750qp3;
                BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen11117, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i19 = i18;
                modifier3 = modifier111110;
                interfaceC3750qp4 = interfaceC3750qp111111;
                textStyle4 = textStyle3;
                z4 = z3;
                i20 = iM5113getClipgIe3tQ8;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
        }
        i5 |= 384;
        textStyle2 = textStyle;
        i8 = i4 & 8;
        if (i8 != 0) {
            if ((i3 & 7168) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 2048;
                } else {
                    i9 = 1024;
                }
                i5 |= i9;
            }
            i10 = i4 & 16;
            if (i10 != 0) {
                if ((57344 & i3) == 0) {
                    i11 = i;
                    if (composerStartRestartGroup.changed(i11)) {
                        i12 = 16384;
                    } else {
                        i12 = 8192;
                    }
                    i5 |= i12;
                }
                i13 = i4 & 32;
                if (i13 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & 458752) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i14 = 131072;
                    } else {
                        i14 = 65536;
                    }
                    i5 |= i14;
                }
                i15 = i4 & 64;
                if (i15 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i5 |= i16;
                }
                if ((i4 & 128) != 0) {
                    if ((29360128 & i3) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                            i17 = 8388608;
                        } else {
                            i17 = 4194304;
                        }
                    }
                    if ((23967451 & i5) == 4793490) {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        Modifier.Companion companion11119 = Modifier.Companion;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen11118 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion11119, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier111111 = modifier2;
                        InterfaceC3750qp interfaceC3750qp111112 = interfaceC3750qp3;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen11118, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = i18;
                        modifier3 = modifier111111;
                        interfaceC3750qp4 = interfaceC3750qp111112;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        i20 = iM5113getClipgIe3tQ8;
                    } else {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i6 != 0) {
                            textStyle3 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle3 = textStyle2;
                        }
                        if (i8 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i10 != 0) {
                            iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                        } else {
                            iM5113getClipgIe3tQ8 = i11;
                        }
                        if (i13 != 0) {
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i2;
                        }
                        if (i15 != 0) {
                            interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        Modifier.Companion companion111110 = Modifier.Companion;
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen11119 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion111110, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier111112 = modifier2;
                        InterfaceC3750qp interfaceC3750qp111113 = interfaceC3750qp3;
                        BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen11119, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = i18;
                        modifier3 = modifier111112;
                        interfaceC3750qp4 = interfaceC3750qp111113;
                        textStyle4 = textStyle3;
                        z4 = z3;
                        i20 = iM5113getClipgIe3tQ8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
                }
                i17 = 12582912;
                i5 |= i17;
                if ((23967451 & i5) == 4793490) {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    Modifier.Companion companion111111 = Modifier.Companion;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen111110 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion111111, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier111113 = modifier2;
                    InterfaceC3750qp interfaceC3750qp111114 = interfaceC3750qp3;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen111110, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = i18;
                    modifier3 = modifier111113;
                    interfaceC3750qp4 = interfaceC3750qp111114;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    i20 = iM5113getClipgIe3tQ8;
                } else {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    Modifier.Companion companion111112 = Modifier.Companion;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen111111 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion111112, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier111114 = modifier2;
                    InterfaceC3750qp interfaceC3750qp111115 = interfaceC3750qp3;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen111111, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = i18;
                    modifier3 = modifier111114;
                    interfaceC3750qp4 = interfaceC3750qp111115;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    i20 = iM5113getClipgIe3tQ8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
            }
            i5 |= 24576;
            i11 = i;
            i13 = i4 & 32;
            if (i13 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i3 & 458752) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i14 = 131072;
                } else {
                    i14 = 65536;
                }
                i5 |= i14;
            }
            i15 = i4 & 64;
            if (i15 != 0) {
                i5 |= 1572864;
            } else if ((i3 & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i5 |= i16;
            }
            if ((i4 & 128) != 0) {
                if ((29360128 & i3) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                        i17 = 8388608;
                    } else {
                        i17 = 4194304;
                    }
                }
                if ((23967451 & i5) == 4793490) {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    Modifier.Companion companion111113 = Modifier.Companion;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen111112 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion111113, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier111115 = modifier2;
                    InterfaceC3750qp interfaceC3750qp111116 = interfaceC3750qp3;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen111112, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = i18;
                    modifier3 = modifier111115;
                    interfaceC3750qp4 = interfaceC3750qp111116;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    i20 = iM5113getClipgIe3tQ8;
                } else {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    Modifier.Companion companion111114 = Modifier.Companion;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen111113 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion111114, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier111116 = modifier2;
                    InterfaceC3750qp interfaceC3750qp111117 = interfaceC3750qp3;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen111113, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = i18;
                    modifier3 = modifier111116;
                    interfaceC3750qp4 = interfaceC3750qp111117;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    i20 = iM5113getClipgIe3tQ8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
            }
            i17 = 12582912;
            i5 |= i17;
            if ((23967451 & i5) == 4793490) {
                if (i21 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i6 != 0) {
                    textStyle3 = TextStyle.Companion.getDefault();
                } else {
                    textStyle3 = textStyle2;
                }
                if (i8 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i10 != 0) {
                    iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                } else {
                    iM5113getClipgIe3tQ8 = i11;
                }
                if (i13 != 0) {
                    i18 = Integer.MAX_VALUE;
                } else {
                    i18 = i2;
                }
                if (i15 != 0) {
                    interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                } else {
                    interfaceC3750qp3 = interfaceC3750qp;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue;
                Modifier.Companion companion111115 = Modifier.Companion;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen111114 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion111115, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifier111117 = modifier2;
                InterfaceC3750qp interfaceC3750qp111118 = interfaceC3750qp3;
                BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen111114, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i19 = i18;
                modifier3 = modifier111117;
                interfaceC3750qp4 = interfaceC3750qp111118;
                textStyle4 = textStyle3;
                z4 = z3;
                i20 = iM5113getClipgIe3tQ8;
            } else {
                if (i21 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i6 != 0) {
                    textStyle3 = TextStyle.Companion.getDefault();
                } else {
                    textStyle3 = textStyle2;
                }
                if (i8 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i10 != 0) {
                    iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                } else {
                    iM5113getClipgIe3tQ8 = i11;
                }
                if (i13 != 0) {
                    i18 = Integer.MAX_VALUE;
                } else {
                    i18 = i2;
                }
                if (i15 != 0) {
                    interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                } else {
                    interfaceC3750qp3 = interfaceC3750qp;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue;
                Modifier.Companion companion111116 = Modifier.Companion;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen111115 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion111116, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifier111118 = modifier2;
                InterfaceC3750qp interfaceC3750qp111119 = interfaceC3750qp3;
                BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen111115, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i19 = i18;
                modifier3 = modifier111118;
                interfaceC3750qp4 = interfaceC3750qp111119;
                textStyle4 = textStyle3;
                z4 = z3;
                i20 = iM5113getClipgIe3tQ8;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
        }
        i5 |= 3072;
        z2 = z;
        i10 = i4 & 16;
        if (i10 != 0) {
            if ((57344 & i3) == 0) {
                i11 = i;
                if (composerStartRestartGroup.changed(i11)) {
                    i12 = 16384;
                } else {
                    i12 = 8192;
                }
                i5 |= i12;
            }
            i13 = i4 & 32;
            if (i13 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i3 & 458752) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i14 = 131072;
                } else {
                    i14 = 65536;
                }
                i5 |= i14;
            }
            i15 = i4 & 64;
            if (i15 != 0) {
                i5 |= 1572864;
            } else if ((i3 & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i5 |= i16;
            }
            if ((i4 & 128) != 0) {
                if ((29360128 & i3) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                        i17 = 8388608;
                    } else {
                        i17 = 4194304;
                    }
                }
                if ((23967451 & i5) == 4793490) {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    Modifier.Companion companion111117 = Modifier.Companion;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen111116 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion111117, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier111119 = modifier2;
                    InterfaceC3750qp interfaceC3750qp1111110 = interfaceC3750qp3;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen111116, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = i18;
                    modifier3 = modifier111119;
                    interfaceC3750qp4 = interfaceC3750qp1111110;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    i20 = iM5113getClipgIe3tQ8;
                } else {
                    if (i21 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i6 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i8 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i10 != 0) {
                        iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                    } else {
                        iM5113getClipgIe3tQ8 = i11;
                    }
                    if (i13 != 0) {
                        i18 = Integer.MAX_VALUE;
                    } else {
                        i18 = i2;
                    }
                    if (i15 != 0) {
                        interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue;
                    Modifier.Companion companion111118 = Modifier.Companion;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen111117 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion111118, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier1111110 = modifier2;
                    InterfaceC3750qp interfaceC3750qp1111111 = interfaceC3750qp3;
                    BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen111117, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = i18;
                    modifier3 = modifier1111110;
                    interfaceC3750qp4 = interfaceC3750qp1111111;
                    textStyle4 = textStyle3;
                    z4 = z3;
                    i20 = iM5113getClipgIe3tQ8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
            }
            i17 = 12582912;
            i5 |= i17;
            if ((23967451 & i5) == 4793490) {
                if (i21 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i6 != 0) {
                    textStyle3 = TextStyle.Companion.getDefault();
                } else {
                    textStyle3 = textStyle2;
                }
                if (i8 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i10 != 0) {
                    iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                } else {
                    iM5113getClipgIe3tQ8 = i11;
                }
                if (i13 != 0) {
                    i18 = Integer.MAX_VALUE;
                } else {
                    i18 = i2;
                }
                if (i15 != 0) {
                    interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                } else {
                    interfaceC3750qp3 = interfaceC3750qp;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue;
                Modifier.Companion companion111119 = Modifier.Companion;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen111118 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion111119, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifier1111111 = modifier2;
                InterfaceC3750qp interfaceC3750qp1111112 = interfaceC3750qp3;
                BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen111118, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i19 = i18;
                modifier3 = modifier1111111;
                interfaceC3750qp4 = interfaceC3750qp1111112;
                textStyle4 = textStyle3;
                z4 = z3;
                i20 = iM5113getClipgIe3tQ8;
            } else {
                if (i21 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i6 != 0) {
                    textStyle3 = TextStyle.Companion.getDefault();
                } else {
                    textStyle3 = textStyle2;
                }
                if (i8 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i10 != 0) {
                    iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                } else {
                    iM5113getClipgIe3tQ8 = i11;
                }
                if (i13 != 0) {
                    i18 = Integer.MAX_VALUE;
                } else {
                    i18 = i2;
                }
                if (i15 != 0) {
                    interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                } else {
                    interfaceC3750qp3 = interfaceC3750qp;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue;
                Modifier.Companion companion1111110 = Modifier.Companion;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen111119 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion1111110, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifier1111112 = modifier2;
                InterfaceC3750qp interfaceC3750qp1111113 = interfaceC3750qp3;
                BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen111119, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i19 = i18;
                modifier3 = modifier1111112;
                interfaceC3750qp4 = interfaceC3750qp1111113;
                textStyle4 = textStyle3;
                z4 = z3;
                i20 = iM5113getClipgIe3tQ8;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
        }
        i5 |= 24576;
        i11 = i;
        i13 = i4 & 32;
        if (i13 != 0) {
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i3 & 458752) == 0) {
            if (composerStartRestartGroup.changed(i2)) {
                i14 = 131072;
            } else {
                i14 = 65536;
            }
            i5 |= i14;
        }
        i15 = i4 & 64;
        if (i15 != 0) {
            i5 |= 1572864;
        } else if ((i3 & 3670016) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                i16 = 1048576;
            } else {
                i16 = 524288;
            }
            i5 |= i16;
        }
        if ((i4 & 128) != 0) {
            if ((29360128 & i3) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                    i17 = 8388608;
                } else {
                    i17 = 4194304;
                }
            }
            if ((23967451 & i5) == 4793490) {
                if (i21 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i6 != 0) {
                    textStyle3 = TextStyle.Companion.getDefault();
                } else {
                    textStyle3 = textStyle2;
                }
                if (i8 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i10 != 0) {
                    iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                } else {
                    iM5113getClipgIe3tQ8 = i11;
                }
                if (i13 != 0) {
                    i18 = Integer.MAX_VALUE;
                } else {
                    i18 = i2;
                }
                if (i15 != 0) {
                    interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                } else {
                    interfaceC3750qp3 = interfaceC3750qp;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue;
                Modifier.Companion companion1111111 = Modifier.Companion;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen1111110 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion1111111, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifier1111113 = modifier2;
                InterfaceC3750qp interfaceC3750qp1111114 = interfaceC3750qp3;
                BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen1111110, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i19 = i18;
                modifier3 = modifier1111113;
                interfaceC3750qp4 = interfaceC3750qp1111114;
                textStyle4 = textStyle3;
                z4 = z3;
                i20 = iM5113getClipgIe3tQ8;
            } else {
                if (i21 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i6 != 0) {
                    textStyle3 = TextStyle.Companion.getDefault();
                } else {
                    textStyle3 = textStyle2;
                }
                if (i8 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i10 != 0) {
                    iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
                } else {
                    iM5113getClipgIe3tQ8 = i11;
                }
                if (i13 != 0) {
                    i18 = Integer.MAX_VALUE;
                } else {
                    i18 = i2;
                }
                if (i15 != 0) {
                    interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
                } else {
                    interfaceC3750qp3 = interfaceC3750qp;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue;
                Modifier.Companion companion1111112 = Modifier.Companion;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen1111111 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion1111112, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifier1111114 = modifier2;
                InterfaceC3750qp interfaceC3750qp1111115 = interfaceC3750qp3;
                BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen1111111, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i19 = i18;
                modifier3 = modifier1111114;
                interfaceC3750qp4 = interfaceC3750qp1111115;
                textStyle4 = textStyle3;
                z4 = z3;
                i20 = iM5113getClipgIe3tQ8;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
        }
        i17 = 12582912;
        i5 |= i17;
        if ((23967451 & i5) == 4793490) {
            if (i21 != 0) {
                modifier2 = Modifier.Companion;
            }
            if (i6 != 0) {
                textStyle3 = TextStyle.Companion.getDefault();
            } else {
                textStyle3 = textStyle2;
            }
            if (i8 != 0) {
                z3 = true;
            } else {
                z3 = z2;
            }
            if (i10 != 0) {
                iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
            } else {
                iM5113getClipgIe3tQ8 = i11;
            }
            if (i13 != 0) {
                i18 = Integer.MAX_VALUE;
            } else {
                i18 = i2;
            }
            if (i15 != 0) {
                interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
            } else {
                interfaceC3750qp3 = interfaceC3750qp;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableState = (MutableState) objRememberedValue;
            Modifier.Companion companion1111113 = Modifier.Companion;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierThen1111112 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion1111113, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2) {
                objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifier1111115 = modifier2;
            InterfaceC3750qp interfaceC3750qp1111116 = interfaceC3750qp3;
            BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen1111112, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            i19 = i18;
            modifier3 = modifier1111115;
            interfaceC3750qp4 = interfaceC3750qp1111116;
            textStyle4 = textStyle3;
            z4 = z3;
            i20 = iM5113getClipgIe3tQ8;
        } else {
            if (i21 != 0) {
                modifier2 = Modifier.Companion;
            }
            if (i6 != 0) {
                textStyle3 = TextStyle.Companion.getDefault();
            } else {
                textStyle3 = textStyle2;
            }
            if (i8 != 0) {
                z3 = true;
            } else {
                z3 = z2;
            }
            if (i10 != 0) {
                iM5113getClipgIe3tQ8 = TextOverflow.Companion.m5113getClipgIe3tQ8();
            } else {
                iM5113getClipgIe3tQ8 = i11;
            }
            if (i13 != 0) {
                i18 = Integer.MAX_VALUE;
            } else {
                i18 = i2;
            }
            if (i15 != 0) {
                interfaceC3750qp3 = ClickableTextKt$ClickableText$1.INSTANCE;
            } else {
                interfaceC3750qp3 = interfaceC3750qp;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:69)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableState = (MutableState) objRememberedValue;
            Modifier.Companion companion1111114 = Modifier.Companion;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp2);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, interfaceC3750qp2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierThen1111113 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion1111114, interfaceC3750qp2, (InterfaceC0526Fp) objRememberedValue2));
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(interfaceC3750qp3);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2) {
                objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new ClickableTextKt$ClickableText$2$1(mutableState, interfaceC3750qp3);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifier1111116 = modifier2;
            InterfaceC3750qp interfaceC3750qp1111117 = interfaceC3750qp3;
            BasicTextKt.m745BasicTextRWo7tUw(annotatedString, modifierThen1111113, textStyle3, (InterfaceC3750qp) objRememberedValue3, iM5113getClipgIe3tQ8, z3, i18, 0, null, null, composerStartRestartGroup, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            i19 = i18;
            modifier3 = modifier1111116;
            interfaceC3750qp4 = interfaceC3750qp1111117;
            textStyle4 = textStyle3;
            z4 = z3;
            i20 = iM5113getClipgIe3tQ8;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new ClickableTextKt$ClickableText$3(annotatedString, modifier3, textStyle4, z4, i20, i19, interfaceC3750qp4, interfaceC3750qp2, i3, i4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer ClickableText_03UYbkw$getOffset(MutableState<TextLayoutResult> mutableState, long j) {
        MultiParagraph multiParagraph;
        TextLayoutResult value = mutableState.getValue();
        if (value == null || (multiParagraph = value.getMultiParagraph()) == null) {
            return null;
        }
        if (!m751containsWithinBoundsUv8p0NA(multiParagraph, j)) {
            multiParagraph = null;
        }
        if (multiParagraph != null) {
            return Integer.valueOf(multiParagraph.m4596getOffsetForPositionk4lQ0M(j));
        }
        return null;
    }

    /* JADX INFO: renamed from: containsWithinBounds-Uv8p0NA, reason: not valid java name */
    private static final boolean m751containsWithinBoundsUv8p0NA(MultiParagraph multiParagraph, long j) {
        float fM2788component1impl = Offset.m2788component1impl(j);
        float fM2789component2impl = Offset.m2789component2impl(j);
        return fM2788component1impl > 0.0f && fM2789component2impl >= 0.0f && fM2788component1impl <= multiParagraph.getWidth() && fM2789component2impl <= multiParagraph.getHeight();
    }
}
