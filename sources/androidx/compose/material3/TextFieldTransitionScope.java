package androidx.compose.material3;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import defpackage.AD;
import defpackage.AbstractC4492zt;
import defpackage.C0774Nm;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0700Kp;

/* JADX INFO: loaded from: classes.dex */
final class TextFieldTransitionScope {
    public static final TextFieldTransitionScope INSTANCE = new TextFieldTransitionScope();

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InputPhase.values().length];
            try {
                iArr[InputPhase.Focused.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TextFieldTransitionScope() {
    }

    private static final float Transition_DTcfvLk$lambda$1(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float Transition_DTcfvLk$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float Transition_DTcfvLk$lambda$5(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final long Transition_DTcfvLk$lambda$7(State<Color> state) {
        return state.getValue().m3042unboximpl();
    }

    private static final long Transition_DTcfvLk$lambda$8(State<Color> state) {
        return state.getValue().m3042unboximpl();
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:105:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:108:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:111:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:113:0x01f1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:115:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:117:0x01fb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:119:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:122:0x0206  */
    /* JADX WARN: Code duplicated, block: B:125:0x0256  */
    /* JADX WARN: Code duplicated, block: B:128:0x0264  */
    /* JADX WARN: Code duplicated, block: B:130:0x0267 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:131:0x0269  */
    /* JADX WARN: Code duplicated, block: B:132:0x026c  */
    /* JADX WARN: Code duplicated, block: B:134:0x0272 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:135:0x0274  */
    /* JADX WARN: Code duplicated, block: B:138:0x027b  */
    /* JADX WARN: Code duplicated, block: B:141:0x0294  */
    /* JADX WARN: Code duplicated, block: B:144:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:146:0x02a5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:147:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:148:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:150:0x02b0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:153:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:156:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:159:0x0309  */
    /* JADX WARN: Code duplicated, block: B:160:0x030c  */
    /* JADX WARN: Code duplicated, block: B:163:0x0314  */
    /* JADX WARN: Code duplicated, block: B:166:0x032e  */
    /* JADX WARN: Code duplicated, block: B:168:0x0336  */
    /* JADX WARN: Code duplicated, block: B:171:0x0360  */
    /* JADX WARN: Code duplicated, block: B:174:0x036c  */
    /* JADX WARN: Code duplicated, block: B:175:0x036f  */
    /* JADX WARN: Code duplicated, block: B:178:0x0377  */
    /* JADX WARN: Code duplicated, block: B:181:0x0390  */
    /* JADX WARN: Code duplicated, block: B:184:0x039c  */
    /* JADX WARN: Code duplicated, block: B:185:0x039f  */
    /* JADX WARN: Code duplicated, block: B:188:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:191:0x0409  */
    /* JADX WARN: Code duplicated, block: B:193:0x0411  */
    /* JADX WARN: Code duplicated, block: B:196:0x04a8  */
    /* JADX WARN: Code duplicated, block: B:85:0x014b  */
    /* JADX WARN: Code duplicated, block: B:88:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:91:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:93:0x01af  */
    /* JADX WARN: Code duplicated, block: B:96:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:98:0x01ba  */
    /* JADX WARN: Instruction removed from duplicated block: B:131:0x0269, please report this as an issue */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    /* JADX INFO: renamed from: Transition-DTcfvLk, reason: not valid java name */
    public final void m1928TransitionDTcfvLk(InputPhase inputPhase, long j, long j2, InterfaceC0552Gp interfaceC0552Gp, boolean z, InterfaceC0700Kp interfaceC0700Kp, Composer composer, int i) {
        int i2;
        float f;
        float f2;
        int i3;
        int i4;
        float f3;
        int i5;
        float f4;
        int i6;
        float f5;
        int i7;
        InputPhase inputPhase2;
        long j3;
        ColorSpace colorSpaceM3036getColorSpaceimpl;
        boolean zChanged;
        Object objRememberedValue;
        InputPhase inputPhase3;
        long j4;
        InputPhase inputPhase4;
        long j5;
        ColorSpace colorSpaceM3036getColorSpaceimpl2;
        boolean zChanged2;
        Object objRememberedValue2;
        AbstractC4492zt.h(inputPhase, "inputState");
        AbstractC4492zt.h(interfaceC0552Gp, "contentColor");
        AbstractC4492zt.h(interfaceC0700Kp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-995111872);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(inputPhase) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0552Gp) ? 2048 : 1024;
        }
        if ((i & 57344) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 16384 : 8192;
        }
        if ((i & 458752) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0700Kp) ? 131072 : 65536;
        }
        if ((374491 & i2) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-995111872, i2, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition (TextFieldImpl.kt:293)");
            }
            Transition transitionUpdateTransition = TransitionKt.updateTransition(inputPhase, "TextFieldInputState", composerStartRestartGroup, (i2 & 14) | 48, 0);
            TextFieldTransitionScope$Transition$labelProgress$2 textFieldTransitionScope$Transition$labelProgress$2 = TextFieldTransitionScope$Transition$labelProgress$2.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-1338768149);
            C0774Nm c0774Nm = C0774Nm.a;
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(c0774Nm);
            composerStartRestartGroup.startReplaceableGroup(-142660079);
            InputPhase inputPhase5 = (InputPhase) transitionUpdateTransition.getCurrentState();
            composerStartRestartGroup.startReplaceableGroup(240378898);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(240378898, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:315)");
            }
            int[] iArr = WhenMappings.$EnumSwitchMapping$0;
            int i8 = iArr[inputPhase5.ordinal()];
            float f6 = 0.0f;
            if (i8 == 1) {
                f = 1.0f;
            } else if (i8 != 2) {
                if (i8 != 3) {
                    throw new AD();
                }
                f = 1.0f;
            } else {
                f = 0.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            Float fValueOf = Float.valueOf(f);
            InputPhase inputPhase6 = (InputPhase) transitionUpdateTransition.getTargetState();
            composerStartRestartGroup.startReplaceableGroup(240378898);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(240378898, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:315)");
            }
            int i9 = iArr[inputPhase6.ordinal()];
            if (i9 != 1) {
                if (i9 == 2) {
                    f2 = 0.0f;
                } else if (i9 != 3) {
                    throw new AD();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, Float.valueOf(f2), (FiniteAnimationSpec) textFieldTransitionScope$Transition$labelProgress$2.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), vectorConverter, "LabelProgress", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                TextFieldTransitionScope$Transition$placeholderOpacity$2 textFieldTransitionScope$Transition$placeholderOpacity$2 = TextFieldTransitionScope$Transition$placeholderOpacity$2.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-1338768149);
                TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(c0774Nm);
                composerStartRestartGroup.startReplaceableGroup(-142660079);
                InputPhase inputPhase7 = (InputPhase) transitionUpdateTransition.getCurrentState();
                composerStartRestartGroup.startReplaceableGroup(2067512179);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2067512179, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:343)");
                }
                i3 = iArr[inputPhase7.ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        i4 = 3;
                        if (i3 != 3) {
                            throw new AD();
                        }
                    } else {
                        i4 = 3;
                        if (z) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Float fValueOf2 = Float.valueOf(f3);
                        InputPhase inputPhase8 = (InputPhase) transitionUpdateTransition.getTargetState();
                        composerStartRestartGroup.startReplaceableGroup(2067512179);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2067512179, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:343)");
                        }
                        i5 = iArr[inputPhase8.ordinal()];
                        if (i5 == 1) {
                            f4 = 1.0f;
                        } else {
                            if (i5 != 2) {
                                if (i5 != i4) {
                                    throw new AD();
                                }
                            } else if (z) {
                                f4 = 1.0f;
                            }
                            f4 = 0.0f;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        State stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf2, Float.valueOf(f4), (FiniteAnimationSpec) textFieldTransitionScope$Transition$placeholderOpacity$2.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), vectorConverter2, "PlaceholderOpacity", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        TextFieldTransitionScope$Transition$prefixSuffixOpacity$2 textFieldTransitionScope$Transition$prefixSuffixOpacity$2 = TextFieldTransitionScope$Transition$prefixSuffixOpacity$2.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-1338768149);
                        TwoWayConverter<Float, AnimationVector1D> vectorConverter3 = VectorConvertersKt.getVectorConverter(c0774Nm);
                        composerStartRestartGroup.startReplaceableGroup(-142660079);
                        InputPhase inputPhase9 = (InputPhase) transitionUpdateTransition.getCurrentState();
                        composerStartRestartGroup.startReplaceableGroup(5829913);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(5829913, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:354)");
                        }
                        i6 = iArr[inputPhase9.ordinal()];
                        if (i6 == 1) {
                            if (i6 == 2) {
                                f5 = z ? 0.0f : 1.0f;
                            } else if (i6 != 3) {
                                throw new AD();
                            }
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Float fValueOf3 = Float.valueOf(f5);
                        InputPhase inputPhase10 = (InputPhase) transitionUpdateTransition.getTargetState();
                        composerStartRestartGroup.startReplaceableGroup(5829913);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(5829913, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:354)");
                        }
                        i7 = iArr[inputPhase10.ordinal()];
                        if (i7 == 1) {
                            f6 = 1.0f;
                        } else {
                            if (i7 != 2) {
                                if (i7 != 3) {
                                    throw new AD();
                                }
                            } else if (!z) {
                            }
                            f6 = 1.0f;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        State stateCreateTransitionAnimation3 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf3, Float.valueOf(f6), (FiniteAnimationSpec) textFieldTransitionScope$Transition$prefixSuffixOpacity$2.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), vectorConverter3, "PrefixSuffixOpacity", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        TextFieldTransitionScope$Transition$labelTextStyleColor$2 textFieldTransitionScope$Transition$labelTextStyleColor$2 = TextFieldTransitionScope$Transition$labelTextStyleColor$2.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-1939694975);
                        inputPhase2 = (InputPhase) transitionUpdateTransition.getTargetState();
                        composerStartRestartGroup.startReplaceableGroup(-1468066062);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1468066062, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:365)");
                        }
                        if (iArr[inputPhase2.ordinal()] == 1) {
                            j3 = j;
                        } else {
                            j3 = j2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        colorSpaceM3036getColorSpaceimpl = Color.m3036getColorSpaceimpl(j3);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(colorSpaceM3036getColorSpaceimpl);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpaceM3036getColorSpaceimpl);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        TwoWayConverter twoWayConverter = (TwoWayConverter) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(-142660079);
                        inputPhase3 = (InputPhase) transitionUpdateTransition.getCurrentState();
                        composerStartRestartGroup.startReplaceableGroup(-1468066062);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1468066062, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:365)");
                        }
                        if (iArr[inputPhase3.ordinal()] == 1) {
                            j4 = j;
                        } else {
                            j4 = j2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Color colorM3022boximpl = Color.m3022boximpl(j4);
                        inputPhase4 = (InputPhase) transitionUpdateTransition.getTargetState();
                        composerStartRestartGroup.startReplaceableGroup(-1468066062);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1468066062, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:365)");
                        }
                        if (iArr[inputPhase4.ordinal()] == 1) {
                            j5 = j;
                        } else {
                            j5 = j2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        State stateCreateTransitionAnimation4 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM3022boximpl, Color.m3022boximpl(j5), (FiniteAnimationSpec) textFieldTransitionScope$Transition$labelTextStyleColor$2.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), twoWayConverter, "LabelTextStyleColor", composerStartRestartGroup, 229376);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        TextFieldTransitionScope$Transition$labelContentColor$2 textFieldTransitionScope$Transition$labelContentColor$2 = TextFieldTransitionScope$Transition$labelContentColor$2.INSTANCE;
                        int i10 = (i2 & 7168) | 384;
                        composerStartRestartGroup.startReplaceableGroup(-1939694975);
                        colorSpaceM3036getColorSpaceimpl2 = Color.m3036getColorSpaceimpl(((Color) interfaceC0552Gp.invoke(transitionUpdateTransition.getTargetState(), composerStartRestartGroup, Integer.valueOf((i10 >> 6) & 112))).m3042unboximpl());
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged2 = composerStartRestartGroup.changed(colorSpaceM3036getColorSpaceimpl2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpaceM3036getColorSpaceimpl2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.startReplaceableGroup(-142660079);
                        int i11 = ((((i10 << 3) & 57344) | 3136) >> 9) & 112;
                        State stateCreateTransitionAnimation5 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, interfaceC0552Gp.invoke(transitionUpdateTransition.getCurrentState(), composerStartRestartGroup, Integer.valueOf(i11)), interfaceC0552Gp.invoke(transitionUpdateTransition.getTargetState(), composerStartRestartGroup, Integer.valueOf(i11)), (FiniteAnimationSpec) textFieldTransitionScope$Transition$labelContentColor$2.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), (TwoWayConverter) objRememberedValue2, "LabelContentColor", composerStartRestartGroup, 229376);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        interfaceC0700Kp.invoke(Float.valueOf(Transition_DTcfvLk$lambda$1(stateCreateTransitionAnimation)), Color.m3022boximpl(Transition_DTcfvLk$lambda$7(stateCreateTransitionAnimation4)), Color.m3022boximpl(Transition_DTcfvLk$lambda$8(stateCreateTransitionAnimation5)), Float.valueOf(Transition_DTcfvLk$lambda$3(stateCreateTransitionAnimation2)), Float.valueOf(Transition_DTcfvLk$lambda$5(stateCreateTransitionAnimation3)), composerStartRestartGroup, Integer.valueOf(i2 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    f3 = 0.0f;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Float fValueOf4 = Float.valueOf(f3);
                    InputPhase inputPhase11 = (InputPhase) transitionUpdateTransition.getTargetState();
                    composerStartRestartGroup.startReplaceableGroup(2067512179);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2067512179, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:343)");
                    }
                    i5 = iArr[inputPhase11.ordinal()];
                    if (i5 == 1) {
                        f4 = 1.0f;
                    } else {
                        if (i5 != 2) {
                            if (i5 != i4) {
                                throw new AD();
                            }
                        } else if (z) {
                            f4 = 1.0f;
                        }
                        f4 = 0.0f;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    State stateCreateTransitionAnimation6 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf4, Float.valueOf(f4), (FiniteAnimationSpec) textFieldTransitionScope$Transition$placeholderOpacity$2.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), vectorConverter2, "PlaceholderOpacity", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    TextFieldTransitionScope$Transition$prefixSuffixOpacity$2 textFieldTransitionScope$Transition$prefixSuffixOpacity$3 = TextFieldTransitionScope$Transition$prefixSuffixOpacity$2.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-1338768149);
                    TwoWayConverter<Float, AnimationVector1D> vectorConverter4 = VectorConvertersKt.getVectorConverter(c0774Nm);
                    composerStartRestartGroup.startReplaceableGroup(-142660079);
                    InputPhase inputPhase12 = (InputPhase) transitionUpdateTransition.getCurrentState();
                    composerStartRestartGroup.startReplaceableGroup(5829913);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(5829913, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:354)");
                    }
                    i6 = iArr[inputPhase12.ordinal()];
                    if (i6 == 1) {
                        if (i6 == 2) {
                            if (i6 != 3) {
                                throw new AD();
                            }
                        } else if (z) {
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Float fValueOf5 = Float.valueOf(f5);
                    InputPhase inputPhase13 = (InputPhase) transitionUpdateTransition.getTargetState();
                    composerStartRestartGroup.startReplaceableGroup(5829913);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(5829913, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:354)");
                    }
                    i7 = iArr[inputPhase13.ordinal()];
                    if (i7 == 1) {
                        f6 = 1.0f;
                    } else {
                        if (i7 != 2) {
                            if (i7 != 3) {
                                throw new AD();
                            }
                        } else if (!z) {
                        }
                        f6 = 1.0f;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    State stateCreateTransitionAnimation7 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf5, Float.valueOf(f6), (FiniteAnimationSpec) textFieldTransitionScope$Transition$prefixSuffixOpacity$3.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), vectorConverter4, "PrefixSuffixOpacity", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    TextFieldTransitionScope$Transition$labelTextStyleColor$2 textFieldTransitionScope$Transition$labelTextStyleColor$3 = TextFieldTransitionScope$Transition$labelTextStyleColor$2.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-1939694975);
                    inputPhase2 = (InputPhase) transitionUpdateTransition.getTargetState();
                    composerStartRestartGroup.startReplaceableGroup(-1468066062);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1468066062, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:365)");
                    }
                    if (iArr[inputPhase2.ordinal()] == 1) {
                        j3 = j;
                    } else {
                        j3 = j2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    colorSpaceM3036getColorSpaceimpl = Color.m3036getColorSpaceimpl(j3);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(colorSpaceM3036getColorSpaceimpl);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpaceM3036getColorSpaceimpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpaceM3036getColorSpaceimpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TwoWayConverter twoWayConverter2 = (TwoWayConverter) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(-142660079);
                    inputPhase3 = (InputPhase) transitionUpdateTransition.getCurrentState();
                    composerStartRestartGroup.startReplaceableGroup(-1468066062);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1468066062, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:365)");
                    }
                    if (iArr[inputPhase3.ordinal()] == 1) {
                        j4 = j;
                    } else {
                        j4 = j2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Color colorM3022boximpl2 = Color.m3022boximpl(j4);
                    inputPhase4 = (InputPhase) transitionUpdateTransition.getTargetState();
                    composerStartRestartGroup.startReplaceableGroup(-1468066062);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1468066062, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:365)");
                    }
                    if (iArr[inputPhase4.ordinal()] == 1) {
                        j5 = j;
                    } else {
                        j5 = j2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    State stateCreateTransitionAnimation8 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM3022boximpl2, Color.m3022boximpl(j5), (FiniteAnimationSpec) textFieldTransitionScope$Transition$labelTextStyleColor$3.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), twoWayConverter2, "LabelTextStyleColor", composerStartRestartGroup, 229376);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    TextFieldTransitionScope$Transition$labelContentColor$2 textFieldTransitionScope$Transition$labelContentColor$3 = TextFieldTransitionScope$Transition$labelContentColor$2.INSTANCE;
                    int i12 = (i2 & 7168) | 384;
                    composerStartRestartGroup.startReplaceableGroup(-1939694975);
                    colorSpaceM3036getColorSpaceimpl2 = Color.m3036getColorSpaceimpl(((Color) interfaceC0552Gp.invoke(transitionUpdateTransition.getTargetState(), composerStartRestartGroup, Integer.valueOf((i12 >> 6) & 112))).m3042unboximpl());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged2 = composerStartRestartGroup.changed(colorSpaceM3036getColorSpaceimpl2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpaceM3036getColorSpaceimpl2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpaceM3036getColorSpaceimpl2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-142660079);
                    int i13 = ((((i12 << 3) & 57344) | 3136) >> 9) & 112;
                    State stateCreateTransitionAnimation9 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, interfaceC0552Gp.invoke(transitionUpdateTransition.getCurrentState(), composerStartRestartGroup, Integer.valueOf(i13)), interfaceC0552Gp.invoke(transitionUpdateTransition.getTargetState(), composerStartRestartGroup, Integer.valueOf(i13)), (FiniteAnimationSpec) textFieldTransitionScope$Transition$labelContentColor$3.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), (TwoWayConverter) objRememberedValue2, "LabelContentColor", composerStartRestartGroup, 229376);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    interfaceC0700Kp.invoke(Float.valueOf(Transition_DTcfvLk$lambda$1(stateCreateTransitionAnimation)), Color.m3022boximpl(Transition_DTcfvLk$lambda$7(stateCreateTransitionAnimation8)), Color.m3022boximpl(Transition_DTcfvLk$lambda$8(stateCreateTransitionAnimation9)), Float.valueOf(Transition_DTcfvLk$lambda$3(stateCreateTransitionAnimation6)), Float.valueOf(Transition_DTcfvLk$lambda$5(stateCreateTransitionAnimation7)), composerStartRestartGroup, Integer.valueOf(i2 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    i4 = 3;
                }
                f3 = 1.0f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                Float fValueOf6 = Float.valueOf(f3);
                InputPhase inputPhase14 = (InputPhase) transitionUpdateTransition.getTargetState();
                composerStartRestartGroup.startReplaceableGroup(2067512179);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2067512179, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:343)");
                }
                i5 = iArr[inputPhase14.ordinal()];
                if (i5 == 1) {
                    f4 = 1.0f;
                } else {
                    if (i5 != 2) {
                        if (i5 != i4) {
                            throw new AD();
                        }
                    } else if (z) {
                        f4 = 1.0f;
                    }
                    f4 = 0.0f;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                State stateCreateTransitionAnimation10 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf6, Float.valueOf(f4), (FiniteAnimationSpec) textFieldTransitionScope$Transition$placeholderOpacity$2.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), vectorConverter2, "PlaceholderOpacity", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                TextFieldTransitionScope$Transition$prefixSuffixOpacity$2 textFieldTransitionScope$Transition$prefixSuffixOpacity$4 = TextFieldTransitionScope$Transition$prefixSuffixOpacity$2.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-1338768149);
                TwoWayConverter<Float, AnimationVector1D> vectorConverter5 = VectorConvertersKt.getVectorConverter(c0774Nm);
                composerStartRestartGroup.startReplaceableGroup(-142660079);
                InputPhase inputPhase15 = (InputPhase) transitionUpdateTransition.getCurrentState();
                composerStartRestartGroup.startReplaceableGroup(5829913);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(5829913, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:354)");
                }
                i6 = iArr[inputPhase15.ordinal()];
                if (i6 == 1) {
                    if (i6 == 2) {
                        if (i6 != 3) {
                            throw new AD();
                        }
                    } else if (z) {
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                Float fValueOf7 = Float.valueOf(f5);
                InputPhase inputPhase16 = (InputPhase) transitionUpdateTransition.getTargetState();
                composerStartRestartGroup.startReplaceableGroup(5829913);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(5829913, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:354)");
                }
                i7 = iArr[inputPhase16.ordinal()];
                if (i7 == 1) {
                    f6 = 1.0f;
                } else {
                    if (i7 != 2) {
                        if (i7 != 3) {
                            throw new AD();
                        }
                    } else if (!z) {
                    }
                    f6 = 1.0f;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                State stateCreateTransitionAnimation11 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf7, Float.valueOf(f6), (FiniteAnimationSpec) textFieldTransitionScope$Transition$prefixSuffixOpacity$4.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), vectorConverter5, "PrefixSuffixOpacity", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                TextFieldTransitionScope$Transition$labelTextStyleColor$2 textFieldTransitionScope$Transition$labelTextStyleColor$4 = TextFieldTransitionScope$Transition$labelTextStyleColor$2.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-1939694975);
                inputPhase2 = (InputPhase) transitionUpdateTransition.getTargetState();
                composerStartRestartGroup.startReplaceableGroup(-1468066062);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1468066062, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:365)");
                }
                if (iArr[inputPhase2.ordinal()] == 1) {
                    j3 = j;
                } else {
                    j3 = j2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                colorSpaceM3036getColorSpaceimpl = Color.m3036getColorSpaceimpl(j3);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(colorSpaceM3036getColorSpaceimpl);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpaceM3036getColorSpaceimpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpaceM3036getColorSpaceimpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                TwoWayConverter twoWayConverter3 = (TwoWayConverter) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-142660079);
                inputPhase3 = (InputPhase) transitionUpdateTransition.getCurrentState();
                composerStartRestartGroup.startReplaceableGroup(-1468066062);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1468066062, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:365)");
                }
                if (iArr[inputPhase3.ordinal()] == 1) {
                    j4 = j;
                } else {
                    j4 = j2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                Color colorM3022boximpl3 = Color.m3022boximpl(j4);
                inputPhase4 = (InputPhase) transitionUpdateTransition.getTargetState();
                composerStartRestartGroup.startReplaceableGroup(-1468066062);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1468066062, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:365)");
                }
                if (iArr[inputPhase4.ordinal()] == 1) {
                    j5 = j;
                } else {
                    j5 = j2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                State stateCreateTransitionAnimation12 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM3022boximpl3, Color.m3022boximpl(j5), (FiniteAnimationSpec) textFieldTransitionScope$Transition$labelTextStyleColor$4.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), twoWayConverter3, "LabelTextStyleColor", composerStartRestartGroup, 229376);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                TextFieldTransitionScope$Transition$labelContentColor$2 textFieldTransitionScope$Transition$labelContentColor$4 = TextFieldTransitionScope$Transition$labelContentColor$2.INSTANCE;
                int i14 = (i2 & 7168) | 384;
                composerStartRestartGroup.startReplaceableGroup(-1939694975);
                colorSpaceM3036getColorSpaceimpl2 = Color.m3036getColorSpaceimpl(((Color) interfaceC0552Gp.invoke(transitionUpdateTransition.getTargetState(), composerStartRestartGroup, Integer.valueOf((i14 >> 6) & 112))).m3042unboximpl());
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged2 = composerStartRestartGroup.changed(colorSpaceM3036getColorSpaceimpl2);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    objRememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpaceM3036getColorSpaceimpl2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpaceM3036getColorSpaceimpl2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(-142660079);
                int i15 = ((((i14 << 3) & 57344) | 3136) >> 9) & 112;
                State stateCreateTransitionAnimation13 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, interfaceC0552Gp.invoke(transitionUpdateTransition.getCurrentState(), composerStartRestartGroup, Integer.valueOf(i15)), interfaceC0552Gp.invoke(transitionUpdateTransition.getTargetState(), composerStartRestartGroup, Integer.valueOf(i15)), (FiniteAnimationSpec) textFieldTransitionScope$Transition$labelContentColor$4.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), (TwoWayConverter) objRememberedValue2, "LabelContentColor", composerStartRestartGroup, 229376);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                interfaceC0700Kp.invoke(Float.valueOf(Transition_DTcfvLk$lambda$1(stateCreateTransitionAnimation)), Color.m3022boximpl(Transition_DTcfvLk$lambda$7(stateCreateTransitionAnimation12)), Color.m3022boximpl(Transition_DTcfvLk$lambda$8(stateCreateTransitionAnimation13)), Float.valueOf(Transition_DTcfvLk$lambda$3(stateCreateTransitionAnimation10)), Float.valueOf(Transition_DTcfvLk$lambda$5(stateCreateTransitionAnimation11)), composerStartRestartGroup, Integer.valueOf(i2 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            f2 = 1.0f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            State stateCreateTransitionAnimation14 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, Float.valueOf(f2), (FiniteAnimationSpec) textFieldTransitionScope$Transition$labelProgress$2.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), vectorConverter, "LabelProgress", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            TextFieldTransitionScope$Transition$placeholderOpacity$2 textFieldTransitionScope$Transition$placeholderOpacity$3 = TextFieldTransitionScope$Transition$placeholderOpacity$2.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-1338768149);
            TwoWayConverter<Float, AnimationVector1D> vectorConverter6 = VectorConvertersKt.getVectorConverter(c0774Nm);
            composerStartRestartGroup.startReplaceableGroup(-142660079);
            InputPhase inputPhase17 = (InputPhase) transitionUpdateTransition.getCurrentState();
            composerStartRestartGroup.startReplaceableGroup(2067512179);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2067512179, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:343)");
            }
            i3 = iArr[inputPhase17.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    i4 = 3;
                    if (i3 != 3) {
                        throw new AD();
                    }
                } else {
                    i4 = 3;
                    if (z) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Float fValueOf8 = Float.valueOf(f3);
                    InputPhase inputPhase18 = (InputPhase) transitionUpdateTransition.getTargetState();
                    composerStartRestartGroup.startReplaceableGroup(2067512179);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2067512179, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:343)");
                    }
                    i5 = iArr[inputPhase18.ordinal()];
                    if (i5 == 1) {
                        f4 = 1.0f;
                    } else {
                        if (i5 != 2) {
                            if (i5 != i4) {
                                throw new AD();
                            }
                        } else if (z) {
                            f4 = 1.0f;
                        }
                        f4 = 0.0f;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    State stateCreateTransitionAnimation15 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf8, Float.valueOf(f4), (FiniteAnimationSpec) textFieldTransitionScope$Transition$placeholderOpacity$3.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), vectorConverter6, "PlaceholderOpacity", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    TextFieldTransitionScope$Transition$prefixSuffixOpacity$2 textFieldTransitionScope$Transition$prefixSuffixOpacity$5 = TextFieldTransitionScope$Transition$prefixSuffixOpacity$2.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-1338768149);
                    TwoWayConverter<Float, AnimationVector1D> vectorConverter7 = VectorConvertersKt.getVectorConverter(c0774Nm);
                    composerStartRestartGroup.startReplaceableGroup(-142660079);
                    InputPhase inputPhase19 = (InputPhase) transitionUpdateTransition.getCurrentState();
                    composerStartRestartGroup.startReplaceableGroup(5829913);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(5829913, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:354)");
                    }
                    i6 = iArr[inputPhase19.ordinal()];
                    if (i6 == 1) {
                        if (i6 == 2) {
                            if (i6 != 3) {
                                throw new AD();
                            }
                        } else if (z) {
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Float fValueOf9 = Float.valueOf(f5);
                    InputPhase inputPhase110 = (InputPhase) transitionUpdateTransition.getTargetState();
                    composerStartRestartGroup.startReplaceableGroup(5829913);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(5829913, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:354)");
                    }
                    i7 = iArr[inputPhase110.ordinal()];
                    if (i7 == 1) {
                        f6 = 1.0f;
                    } else {
                        if (i7 != 2) {
                            if (i7 != 3) {
                                throw new AD();
                            }
                        } else if (!z) {
                        }
                        f6 = 1.0f;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    State stateCreateTransitionAnimation16 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf9, Float.valueOf(f6), (FiniteAnimationSpec) textFieldTransitionScope$Transition$prefixSuffixOpacity$5.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), vectorConverter7, "PrefixSuffixOpacity", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    TextFieldTransitionScope$Transition$labelTextStyleColor$2 textFieldTransitionScope$Transition$labelTextStyleColor$5 = TextFieldTransitionScope$Transition$labelTextStyleColor$2.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-1939694975);
                    inputPhase2 = (InputPhase) transitionUpdateTransition.getTargetState();
                    composerStartRestartGroup.startReplaceableGroup(-1468066062);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1468066062, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:365)");
                    }
                    if (iArr[inputPhase2.ordinal()] == 1) {
                        j3 = j;
                    } else {
                        j3 = j2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    colorSpaceM3036getColorSpaceimpl = Color.m3036getColorSpaceimpl(j3);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(colorSpaceM3036getColorSpaceimpl);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpaceM3036getColorSpaceimpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpaceM3036getColorSpaceimpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TwoWayConverter twoWayConverter4 = (TwoWayConverter) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(-142660079);
                    inputPhase3 = (InputPhase) transitionUpdateTransition.getCurrentState();
                    composerStartRestartGroup.startReplaceableGroup(-1468066062);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1468066062, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:365)");
                    }
                    if (iArr[inputPhase3.ordinal()] == 1) {
                        j4 = j;
                    } else {
                        j4 = j2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Color colorM3022boximpl4 = Color.m3022boximpl(j4);
                    inputPhase4 = (InputPhase) transitionUpdateTransition.getTargetState();
                    composerStartRestartGroup.startReplaceableGroup(-1468066062);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1468066062, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:365)");
                    }
                    if (iArr[inputPhase4.ordinal()] == 1) {
                        j5 = j;
                    } else {
                        j5 = j2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    State stateCreateTransitionAnimation17 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM3022boximpl4, Color.m3022boximpl(j5), (FiniteAnimationSpec) textFieldTransitionScope$Transition$labelTextStyleColor$5.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), twoWayConverter4, "LabelTextStyleColor", composerStartRestartGroup, 229376);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    TextFieldTransitionScope$Transition$labelContentColor$2 textFieldTransitionScope$Transition$labelContentColor$5 = TextFieldTransitionScope$Transition$labelContentColor$2.INSTANCE;
                    int i16 = (i2 & 7168) | 384;
                    composerStartRestartGroup.startReplaceableGroup(-1939694975);
                    colorSpaceM3036getColorSpaceimpl2 = Color.m3036getColorSpaceimpl(((Color) interfaceC0552Gp.invoke(transitionUpdateTransition.getTargetState(), composerStartRestartGroup, Integer.valueOf((i16 >> 6) & 112))).m3042unboximpl());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged2 = composerStartRestartGroup.changed(colorSpaceM3036getColorSpaceimpl2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpaceM3036getColorSpaceimpl2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpaceM3036getColorSpaceimpl2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-142660079);
                    int i17 = ((((i16 << 3) & 57344) | 3136) >> 9) & 112;
                    State stateCreateTransitionAnimation18 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, interfaceC0552Gp.invoke(transitionUpdateTransition.getCurrentState(), composerStartRestartGroup, Integer.valueOf(i17)), interfaceC0552Gp.invoke(transitionUpdateTransition.getTargetState(), composerStartRestartGroup, Integer.valueOf(i17)), (FiniteAnimationSpec) textFieldTransitionScope$Transition$labelContentColor$5.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), (TwoWayConverter) objRememberedValue2, "LabelContentColor", composerStartRestartGroup, 229376);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    interfaceC0700Kp.invoke(Float.valueOf(Transition_DTcfvLk$lambda$1(stateCreateTransitionAnimation14)), Color.m3022boximpl(Transition_DTcfvLk$lambda$7(stateCreateTransitionAnimation17)), Color.m3022boximpl(Transition_DTcfvLk$lambda$8(stateCreateTransitionAnimation18)), Float.valueOf(Transition_DTcfvLk$lambda$3(stateCreateTransitionAnimation15)), Float.valueOf(Transition_DTcfvLk$lambda$5(stateCreateTransitionAnimation16)), composerStartRestartGroup, Integer.valueOf(i2 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                f3 = 0.0f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                Float fValueOf10 = Float.valueOf(f3);
                InputPhase inputPhase111 = (InputPhase) transitionUpdateTransition.getTargetState();
                composerStartRestartGroup.startReplaceableGroup(2067512179);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2067512179, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:343)");
                }
                i5 = iArr[inputPhase111.ordinal()];
                if (i5 == 1) {
                    f4 = 1.0f;
                } else {
                    if (i5 != 2) {
                        if (i5 != i4) {
                            throw new AD();
                        }
                    } else if (z) {
                        f4 = 1.0f;
                    }
                    f4 = 0.0f;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                State stateCreateTransitionAnimation19 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf10, Float.valueOf(f4), (FiniteAnimationSpec) textFieldTransitionScope$Transition$placeholderOpacity$3.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), vectorConverter6, "PlaceholderOpacity", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                TextFieldTransitionScope$Transition$prefixSuffixOpacity$2 textFieldTransitionScope$Transition$prefixSuffixOpacity$6 = TextFieldTransitionScope$Transition$prefixSuffixOpacity$2.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-1338768149);
                TwoWayConverter<Float, AnimationVector1D> vectorConverter8 = VectorConvertersKt.getVectorConverter(c0774Nm);
                composerStartRestartGroup.startReplaceableGroup(-142660079);
                InputPhase inputPhase112 = (InputPhase) transitionUpdateTransition.getCurrentState();
                composerStartRestartGroup.startReplaceableGroup(5829913);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(5829913, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:354)");
                }
                i6 = iArr[inputPhase112.ordinal()];
                if (i6 == 1) {
                    if (i6 == 2) {
                        if (i6 != 3) {
                            throw new AD();
                        }
                    } else if (z) {
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                Float fValueOf11 = Float.valueOf(f5);
                InputPhase inputPhase113 = (InputPhase) transitionUpdateTransition.getTargetState();
                composerStartRestartGroup.startReplaceableGroup(5829913);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(5829913, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:354)");
                }
                i7 = iArr[inputPhase113.ordinal()];
                if (i7 == 1) {
                    f6 = 1.0f;
                } else {
                    if (i7 != 2) {
                        if (i7 != 3) {
                            throw new AD();
                        }
                    } else if (!z) {
                    }
                    f6 = 1.0f;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                State stateCreateTransitionAnimation110 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf11, Float.valueOf(f6), (FiniteAnimationSpec) textFieldTransitionScope$Transition$prefixSuffixOpacity$6.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), vectorConverter8, "PrefixSuffixOpacity", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                TextFieldTransitionScope$Transition$labelTextStyleColor$2 textFieldTransitionScope$Transition$labelTextStyleColor$6 = TextFieldTransitionScope$Transition$labelTextStyleColor$2.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-1939694975);
                inputPhase2 = (InputPhase) transitionUpdateTransition.getTargetState();
                composerStartRestartGroup.startReplaceableGroup(-1468066062);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1468066062, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:365)");
                }
                if (iArr[inputPhase2.ordinal()] == 1) {
                    j3 = j;
                } else {
                    j3 = j2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                colorSpaceM3036getColorSpaceimpl = Color.m3036getColorSpaceimpl(j3);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(colorSpaceM3036getColorSpaceimpl);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpaceM3036getColorSpaceimpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpaceM3036getColorSpaceimpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                TwoWayConverter twoWayConverter5 = (TwoWayConverter) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-142660079);
                inputPhase3 = (InputPhase) transitionUpdateTransition.getCurrentState();
                composerStartRestartGroup.startReplaceableGroup(-1468066062);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1468066062, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:365)");
                }
                if (iArr[inputPhase3.ordinal()] == 1) {
                    j4 = j;
                } else {
                    j4 = j2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                Color colorM3022boximpl5 = Color.m3022boximpl(j4);
                inputPhase4 = (InputPhase) transitionUpdateTransition.getTargetState();
                composerStartRestartGroup.startReplaceableGroup(-1468066062);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1468066062, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:365)");
                }
                if (iArr[inputPhase4.ordinal()] == 1) {
                    j5 = j;
                } else {
                    j5 = j2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                State stateCreateTransitionAnimation111 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM3022boximpl5, Color.m3022boximpl(j5), (FiniteAnimationSpec) textFieldTransitionScope$Transition$labelTextStyleColor$6.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), twoWayConverter5, "LabelTextStyleColor", composerStartRestartGroup, 229376);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                TextFieldTransitionScope$Transition$labelContentColor$2 textFieldTransitionScope$Transition$labelContentColor$6 = TextFieldTransitionScope$Transition$labelContentColor$2.INSTANCE;
                int i18 = (i2 & 7168) | 384;
                composerStartRestartGroup.startReplaceableGroup(-1939694975);
                colorSpaceM3036getColorSpaceimpl2 = Color.m3036getColorSpaceimpl(((Color) interfaceC0552Gp.invoke(transitionUpdateTransition.getTargetState(), composerStartRestartGroup, Integer.valueOf((i18 >> 6) & 112))).m3042unboximpl());
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged2 = composerStartRestartGroup.changed(colorSpaceM3036getColorSpaceimpl2);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    objRememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpaceM3036getColorSpaceimpl2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpaceM3036getColorSpaceimpl2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(-142660079);
                int i19 = ((((i18 << 3) & 57344) | 3136) >> 9) & 112;
                State stateCreateTransitionAnimation112 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, interfaceC0552Gp.invoke(transitionUpdateTransition.getCurrentState(), composerStartRestartGroup, Integer.valueOf(i19)), interfaceC0552Gp.invoke(transitionUpdateTransition.getTargetState(), composerStartRestartGroup, Integer.valueOf(i19)), (FiniteAnimationSpec) textFieldTransitionScope$Transition$labelContentColor$6.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), (TwoWayConverter) objRememberedValue2, "LabelContentColor", composerStartRestartGroup, 229376);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                interfaceC0700Kp.invoke(Float.valueOf(Transition_DTcfvLk$lambda$1(stateCreateTransitionAnimation14)), Color.m3022boximpl(Transition_DTcfvLk$lambda$7(stateCreateTransitionAnimation111)), Color.m3022boximpl(Transition_DTcfvLk$lambda$8(stateCreateTransitionAnimation112)), Float.valueOf(Transition_DTcfvLk$lambda$3(stateCreateTransitionAnimation19)), Float.valueOf(Transition_DTcfvLk$lambda$5(stateCreateTransitionAnimation110)), composerStartRestartGroup, Integer.valueOf(i2 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                i4 = 3;
            }
            f3 = 1.0f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            Float fValueOf12 = Float.valueOf(f3);
            InputPhase inputPhase114 = (InputPhase) transitionUpdateTransition.getTargetState();
            composerStartRestartGroup.startReplaceableGroup(2067512179);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2067512179, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:343)");
            }
            i5 = iArr[inputPhase114.ordinal()];
            if (i5 == 1) {
                f4 = 1.0f;
            } else {
                if (i5 != 2) {
                    if (i5 != i4) {
                        throw new AD();
                    }
                } else if (z) {
                    f4 = 1.0f;
                }
                f4 = 0.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            State stateCreateTransitionAnimation113 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf12, Float.valueOf(f4), (FiniteAnimationSpec) textFieldTransitionScope$Transition$placeholderOpacity$3.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), vectorConverter6, "PlaceholderOpacity", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            TextFieldTransitionScope$Transition$prefixSuffixOpacity$2 textFieldTransitionScope$Transition$prefixSuffixOpacity$7 = TextFieldTransitionScope$Transition$prefixSuffixOpacity$2.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-1338768149);
            TwoWayConverter<Float, AnimationVector1D> vectorConverter9 = VectorConvertersKt.getVectorConverter(c0774Nm);
            composerStartRestartGroup.startReplaceableGroup(-142660079);
            InputPhase inputPhase115 = (InputPhase) transitionUpdateTransition.getCurrentState();
            composerStartRestartGroup.startReplaceableGroup(5829913);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(5829913, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:354)");
            }
            i6 = iArr[inputPhase115.ordinal()];
            if (i6 == 1) {
                if (i6 == 2) {
                    if (i6 != 3) {
                        throw new AD();
                    }
                } else if (z) {
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            Float fValueOf13 = Float.valueOf(f5);
            InputPhase inputPhase116 = (InputPhase) transitionUpdateTransition.getTargetState();
            composerStartRestartGroup.startReplaceableGroup(5829913);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(5829913, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:354)");
            }
            i7 = iArr[inputPhase116.ordinal()];
            if (i7 == 1) {
                f6 = 1.0f;
            } else {
                if (i7 != 2) {
                    if (i7 != 3) {
                        throw new AD();
                    }
                } else if (!z) {
                }
                f6 = 1.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            State stateCreateTransitionAnimation114 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf13, Float.valueOf(f6), (FiniteAnimationSpec) textFieldTransitionScope$Transition$prefixSuffixOpacity$7.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), vectorConverter9, "PrefixSuffixOpacity", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            TextFieldTransitionScope$Transition$labelTextStyleColor$2 textFieldTransitionScope$Transition$labelTextStyleColor$7 = TextFieldTransitionScope$Transition$labelTextStyleColor$2.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-1939694975);
            inputPhase2 = (InputPhase) transitionUpdateTransition.getTargetState();
            composerStartRestartGroup.startReplaceableGroup(-1468066062);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1468066062, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:365)");
            }
            if (iArr[inputPhase2.ordinal()] == 1) {
                j3 = j;
            } else {
                j3 = j2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            colorSpaceM3036getColorSpaceimpl = Color.m3036getColorSpaceimpl(j3);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(colorSpaceM3036getColorSpaceimpl);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpaceM3036getColorSpaceimpl);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpaceM3036getColorSpaceimpl);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            TwoWayConverter twoWayConverter6 = (TwoWayConverter) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(-142660079);
            inputPhase3 = (InputPhase) transitionUpdateTransition.getCurrentState();
            composerStartRestartGroup.startReplaceableGroup(-1468066062);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1468066062, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:365)");
            }
            if (iArr[inputPhase3.ordinal()] == 1) {
                j4 = j;
            } else {
                j4 = j2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            Color colorM3022boximpl6 = Color.m3022boximpl(j4);
            inputPhase4 = (InputPhase) transitionUpdateTransition.getTargetState();
            composerStartRestartGroup.startReplaceableGroup(-1468066062);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1468066062, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:365)");
            }
            if (iArr[inputPhase4.ordinal()] == 1) {
                j5 = j;
            } else {
                j5 = j2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            State stateCreateTransitionAnimation115 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM3022boximpl6, Color.m3022boximpl(j5), (FiniteAnimationSpec) textFieldTransitionScope$Transition$labelTextStyleColor$7.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), twoWayConverter6, "LabelTextStyleColor", composerStartRestartGroup, 229376);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            TextFieldTransitionScope$Transition$labelContentColor$2 textFieldTransitionScope$Transition$labelContentColor$7 = TextFieldTransitionScope$Transition$labelContentColor$2.INSTANCE;
            int i110 = (i2 & 7168) | 384;
            composerStartRestartGroup.startReplaceableGroup(-1939694975);
            colorSpaceM3036getColorSpaceimpl2 = Color.m3036getColorSpaceimpl(((Color) interfaceC0552Gp.invoke(transitionUpdateTransition.getTargetState(), composerStartRestartGroup, Integer.valueOf((i110 >> 6) & 112))).m3042unboximpl());
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged2 = composerStartRestartGroup.changed(colorSpaceM3036getColorSpaceimpl2);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2) {
                objRememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpaceM3036getColorSpaceimpl2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpaceM3036getColorSpaceimpl2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(-142660079);
            int i111 = ((((i110 << 3) & 57344) | 3136) >> 9) & 112;
            State stateCreateTransitionAnimation116 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, interfaceC0552Gp.invoke(transitionUpdateTransition.getCurrentState(), composerStartRestartGroup, Integer.valueOf(i111)), interfaceC0552Gp.invoke(transitionUpdateTransition.getTargetState(), composerStartRestartGroup, Integer.valueOf(i111)), (FiniteAnimationSpec) textFieldTransitionScope$Transition$labelContentColor$7.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), (TwoWayConverter) objRememberedValue2, "LabelContentColor", composerStartRestartGroup, 229376);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            interfaceC0700Kp.invoke(Float.valueOf(Transition_DTcfvLk$lambda$1(stateCreateTransitionAnimation14)), Color.m3022boximpl(Transition_DTcfvLk$lambda$7(stateCreateTransitionAnimation115)), Color.m3022boximpl(Transition_DTcfvLk$lambda$8(stateCreateTransitionAnimation116)), Float.valueOf(Transition_DTcfvLk$lambda$3(stateCreateTransitionAnimation113)), Float.valueOf(Transition_DTcfvLk$lambda$5(stateCreateTransitionAnimation114)), composerStartRestartGroup, Integer.valueOf(i2 & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new TextFieldTransitionScope$Transition$1(this, inputPhase, j, j2, interfaceC0552Gp, z, interfaceC0700Kp, i));
    }
}
