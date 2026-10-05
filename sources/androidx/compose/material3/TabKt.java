package androidx.compose.material3;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.layout.AlignmentLineKt;
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
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2260gB;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class TabKt {
    private static final int TabFadeInAnimationDelay = 100;
    private static final int TabFadeInAnimationDuration = 150;
    private static final int TabFadeOutAnimationDuration = 100;
    private static final float SmallTabHeight = PrimaryNavigationTabTokens.INSTANCE.m2483getContainerHeightD9Ej5fM();
    private static final float LargeTabHeight = Dp.m5160constructorimpl(72);
    private static final float HorizontalTextPadding = Dp.m5160constructorimpl(16);
    private static final float SingleLineTextBaselineWithIcon = Dp.m5160constructorimpl(14);
    private static final float DoubleLineTextBaselineWithIcon = Dp.m5160constructorimpl(6);
    private static final long IconDistanceFromBaseline = TextUnitKt.getSp(20);
    private static final float TextDistanceFromLeadingIcon = Dp.m5160constructorimpl(8);

    /* JADX INFO: renamed from: androidx.compose.material3.TabKt$TabBaselineLayout$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ InterfaceC0526Fp $icon;
        final /* synthetic */ InterfaceC0526Fp $text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, int i) {
            super(2);
            this.$text = interfaceC0526Fp;
            this.$icon = interfaceC0526Fp2;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            TabKt.TabBaselineLayout(this.$text, this.$icon, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0136  */
    /* JADX WARN: Code duplicated, block: B:104:0x0141  */
    /* JADX WARN: Code duplicated, block: B:114:0x0167 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:115:0x0169  */
    /* JADX WARN: Code duplicated, block: B:117:0x016e  */
    /* JADX WARN: Code duplicated, block: B:120:0x0173  */
    /* JADX WARN: Code duplicated, block: B:123:0x0187  */
    /* JADX WARN: Code duplicated, block: B:124:0x018f  */
    /* JADX WARN: Code duplicated, block: B:126:0x0195  */
    /* JADX WARN: Code duplicated, block: B:128:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:131:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:134:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:137:0x0231  */
    /* JADX WARN: Code duplicated, block: B:142:0x0245  */
    /* JADX WARN: Code duplicated, block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:78:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:89:0x0104  */
    /* JADX WARN: Code duplicated, block: B:91:0x010c  */
    /* JADX WARN: Code duplicated, block: B:93:0x0112  */
    /* JADX WARN: Code duplicated, block: B:94:0x0115  */
    /* JADX WARN: Code duplicated, block: B:98:0x0123  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: LeadingIconTab-wqdebIU, reason: not valid java name */
    public static final void m1877LeadingIconTabwqdebIU(boolean z, InterfaceC3588op interfaceC3588op, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, Modifier modifier, boolean z2, long j, long j2, MutableInteractionSource mutableInteractionSource, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        long jM3042unboximpl;
        int i6;
        int i7;
        int i8;
        int i9;
        long j3;
        MutableInteractionSource mutableInteractionSource2;
        long j4;
        long j5;
        Modifier modifier3;
        boolean z4;
        Object objRememberedValue;
        Modifier modifier4;
        boolean z5;
        long j6;
        long j7;
        MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i10;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0526Fp, "text");
        AbstractC4492zt.h(interfaceC0526Fp2, "icon");
        Composer composerStartRestartGroup = composer.startRestartGroup(-777316544);
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
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp2) ? 2048 : 1024;
        }
        int i11 = i2 & 16;
        if (i11 == 0) {
            if ((57344 & i) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((458752 & i) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i5 = 131072;
                    } else {
                        i5 = 65536;
                    }
                    i3 |= i5;
                }
                if ((3670016 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        jM3042unboximpl = j;
                        int i12 = composerStartRestartGroup.changed(jM3042unboximpl) ? 1048576 : 524288;
                        i3 |= i12;
                    } else {
                        jM3042unboximpl = j;
                    }
                    i3 |= i12;
                } else {
                    jM3042unboximpl = j;
                }
                if ((29360128 & i) == 0) {
                    int i13 = i3;
                    if ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j2)) {
                        i10 = 4194304;
                    } else {
                        i10 = 8388608;
                    }
                    i6 = i13 | i10;
                } else {
                    i6 = i3;
                }
                i7 = i2 & 256;
                if (i7 != 0) {
                    i6 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i8 = 67108864;
                    } else {
                        i8 = 33554432;
                    }
                    i6 |= i8;
                }
                if ((i6 & 191739611) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 64) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i6 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            i9 = i6 & (-29360129);
                            j3 = jM3042unboximpl;
                        } else {
                            i9 = i6;
                            j3 = j2;
                        }
                        if (i7 != 0) {
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
                        j4 = jM3042unboximpl;
                        j5 = j3;
                        modifier3 = modifier2;
                        z4 = z3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 64) != 0) {
                            i6 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            i6 &= -29360129;
                        }
                        j5 = j2;
                        mutableInteractionSource2 = mutableInteractionSource;
                        z4 = z3;
                        j4 = jM3042unboximpl;
                        i9 = i6;
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-777316544, i9, -1, "androidx.compose.material3.LeadingIconTab (Tab.kt:154)");
                    }
                    int i14 = i9;
                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -429037564, true, new TabKt$LeadingIconTab$2(modifier3, z, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, j4, composerStartRestartGroup, ((i9 >> 12) & 896) | 6, 2), z4, interfaceC3588op, interfaceC0526Fp2, i9, interfaceC0526Fp));
                    int i15 = i14 >> 18;
                    m1880TabTransitionKlgxPg(j4, j5, z, composableLambda, composerStartRestartGroup, (i15 & 112) | (i15 & 14) | 3072 | ((i14 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z5 = z4;
                    j6 = j4;
                    j7 = j5;
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    j7 = j2;
                    mutableInteractionSource3 = mutableInteractionSource;
                    j6 = jM3042unboximpl;
                    z5 = z3;
                    modifier4 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$LeadingIconTab$3(z, interfaceC3588op, interfaceC0526Fp, interfaceC0526Fp2, modifier4, z5, j6, j7, mutableInteractionSource3, i, i2));
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z3 = z2;
            if ((3670016 & i) == 0) {
                if ((i2 & 64) == 0) {
                    jM3042unboximpl = j;
                    if (composerStartRestartGroup.changed(jM3042unboximpl)) {
                    }
                    i3 |= i12;
                } else {
                    jM3042unboximpl = j;
                }
                i3 |= i12;
            } else {
                jM3042unboximpl = j;
            }
            if ((29360128 & i) == 0) {
                int i16 = i3;
                if ((i2 & 128) == 0) {
                    i10 = 4194304;
                } else {
                    i10 = 4194304;
                }
                i6 = i16 | i10;
            } else {
                i6 = i3;
            }
            i7 = i2 & 256;
            if (i7 != 0) {
                i6 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i8 = 67108864;
                } else {
                    i8 = 33554432;
                }
                i6 |= i8;
            }
            if ((i6 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 64) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i6 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        i9 = i6 & (-29360129);
                        j3 = jM3042unboximpl;
                    } else {
                        i9 = i6;
                        j3 = j2;
                    }
                    if (i7 != 0) {
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
                    j4 = jM3042unboximpl;
                    j5 = j3;
                    modifier3 = modifier2;
                    z4 = z3;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 64) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i6 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        i9 = i6 & (-29360129);
                        j3 = jM3042unboximpl;
                    } else {
                        i9 = i6;
                        j3 = j2;
                    }
                    if (i7 != 0) {
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
                    j4 = jM3042unboximpl;
                    j5 = j3;
                    modifier3 = modifier2;
                    z4 = z3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-777316544, i9, -1, "androidx.compose.material3.LeadingIconTab (Tab.kt:154)");
                }
                int i17 = i9;
                ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -429037564, true, new TabKt$LeadingIconTab$2(modifier3, z, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, j4, composerStartRestartGroup, ((i9 >> 12) & 896) | 6, 2), z4, interfaceC3588op, interfaceC0526Fp2, i9, interfaceC0526Fp));
                int i18 = i17 >> 18;
                m1880TabTransitionKlgxPg(j4, j5, z, composableLambda2, composerStartRestartGroup, (i18 & 112) | (i18 & 14) | 3072 | ((i17 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z5 = z4;
                j6 = j4;
                j7 = j5;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 64) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i6 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        i9 = i6 & (-29360129);
                        j3 = jM3042unboximpl;
                    } else {
                        i9 = i6;
                        j3 = j2;
                    }
                    if (i7 != 0) {
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
                    j4 = jM3042unboximpl;
                    j5 = j3;
                    modifier3 = modifier2;
                    z4 = z3;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 64) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i6 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        i9 = i6 & (-29360129);
                        j3 = jM3042unboximpl;
                    } else {
                        i9 = i6;
                        j3 = j2;
                    }
                    if (i7 != 0) {
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
                    j4 = jM3042unboximpl;
                    j5 = j3;
                    modifier3 = modifier2;
                    z4 = z3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-777316544, i9, -1, "androidx.compose.material3.LeadingIconTab (Tab.kt:154)");
                }
                int i19 = i9;
                ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -429037564, true, new TabKt$LeadingIconTab$2(modifier3, z, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, j4, composerStartRestartGroup, ((i9 >> 12) & 896) | 6, 2), z4, interfaceC3588op, interfaceC0526Fp2, i9, interfaceC0526Fp));
                int i110 = i19 >> 18;
                m1880TabTransitionKlgxPg(j4, j5, z, composableLambda3, composerStartRestartGroup, (i110 & 112) | (i110 & 14) | 3072 | ((i19 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z5 = z4;
                j6 = j4;
                j7 = j5;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$LeadingIconTab$3(z, interfaceC3588op, interfaceC0526Fp, interfaceC0526Fp2, modifier4, z5, j6, j7, mutableInteractionSource3, i, i2));
        }
        i3 |= 24576;
        modifier2 = modifier;
        i4 = i2 & 32;
        if (i4 != 0) {
            if ((458752 & i) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i3 |= i5;
            }
            if ((3670016 & i) == 0) {
                if ((i2 & 64) == 0) {
                    jM3042unboximpl = j;
                    if (composerStartRestartGroup.changed(jM3042unboximpl)) {
                    }
                    i3 |= i12;
                } else {
                    jM3042unboximpl = j;
                }
                i3 |= i12;
            } else {
                jM3042unboximpl = j;
            }
            if ((29360128 & i) == 0) {
                int i111 = i3;
                if ((i2 & 128) == 0) {
                    i10 = 4194304;
                } else {
                    i10 = 4194304;
                }
                i6 = i111 | i10;
            } else {
                i6 = i3;
            }
            i7 = i2 & 256;
            if (i7 != 0) {
                i6 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i8 = 67108864;
                } else {
                    i8 = 33554432;
                }
                i6 |= i8;
            }
            if ((i6 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 64) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i6 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        i9 = i6 & (-29360129);
                        j3 = jM3042unboximpl;
                    } else {
                        i9 = i6;
                        j3 = j2;
                    }
                    if (i7 != 0) {
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
                    j4 = jM3042unboximpl;
                    j5 = j3;
                    modifier3 = modifier2;
                    z4 = z3;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 64) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i6 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        i9 = i6 & (-29360129);
                        j3 = jM3042unboximpl;
                    } else {
                        i9 = i6;
                        j3 = j2;
                    }
                    if (i7 != 0) {
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
                    j4 = jM3042unboximpl;
                    j5 = j3;
                    modifier3 = modifier2;
                    z4 = z3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-777316544, i9, -1, "androidx.compose.material3.LeadingIconTab (Tab.kt:154)");
                }
                int i112 = i9;
                ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -429037564, true, new TabKt$LeadingIconTab$2(modifier3, z, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, j4, composerStartRestartGroup, ((i9 >> 12) & 896) | 6, 2), z4, interfaceC3588op, interfaceC0526Fp2, i9, interfaceC0526Fp));
                int i113 = i112 >> 18;
                m1880TabTransitionKlgxPg(j4, j5, z, composableLambda4, composerStartRestartGroup, (i113 & 112) | (i113 & 14) | 3072 | ((i112 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z5 = z4;
                j6 = j4;
                j7 = j5;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 64) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i6 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        i9 = i6 & (-29360129);
                        j3 = jM3042unboximpl;
                    } else {
                        i9 = i6;
                        j3 = j2;
                    }
                    if (i7 != 0) {
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
                    j4 = jM3042unboximpl;
                    j5 = j3;
                    modifier3 = modifier2;
                    z4 = z3;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 64) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i6 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        i9 = i6 & (-29360129);
                        j3 = jM3042unboximpl;
                    } else {
                        i9 = i6;
                        j3 = j2;
                    }
                    if (i7 != 0) {
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
                    j4 = jM3042unboximpl;
                    j5 = j3;
                    modifier3 = modifier2;
                    z4 = z3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-777316544, i9, -1, "androidx.compose.material3.LeadingIconTab (Tab.kt:154)");
                }
                int i114 = i9;
                ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -429037564, true, new TabKt$LeadingIconTab$2(modifier3, z, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, j4, composerStartRestartGroup, ((i9 >> 12) & 896) | 6, 2), z4, interfaceC3588op, interfaceC0526Fp2, i9, interfaceC0526Fp));
                int i115 = i114 >> 18;
                m1880TabTransitionKlgxPg(j4, j5, z, composableLambda5, composerStartRestartGroup, (i115 & 112) | (i115 & 14) | 3072 | ((i114 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z5 = z4;
                j6 = j4;
                j7 = j5;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$LeadingIconTab$3(z, interfaceC3588op, interfaceC0526Fp, interfaceC0526Fp2, modifier4, z5, j6, j7, mutableInteractionSource3, i, i2));
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z3 = z2;
        if ((3670016 & i) == 0) {
            if ((i2 & 64) == 0) {
                jM3042unboximpl = j;
                if (composerStartRestartGroup.changed(jM3042unboximpl)) {
                }
                i3 |= i12;
            } else {
                jM3042unboximpl = j;
            }
            i3 |= i12;
        } else {
            jM3042unboximpl = j;
        }
        if ((29360128 & i) == 0) {
            int i116 = i3;
            if ((i2 & 128) == 0) {
                i10 = 4194304;
            } else {
                i10 = 4194304;
            }
            i6 = i116 | i10;
        } else {
            i6 = i3;
        }
        i7 = i2 & 256;
        if (i7 != 0) {
            i6 |= 100663296;
        } else if ((i & 234881024) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i8 = 67108864;
            } else {
                i8 = 33554432;
            }
            i6 |= i8;
        }
        if ((i6 & 191739611) == 38347922) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if ((i2 & 64) != 0) {
                    jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                    i6 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    i9 = i6 & (-29360129);
                    j3 = jM3042unboximpl;
                } else {
                    i9 = i6;
                    j3 = j2;
                }
                if (i7 != 0) {
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
                j4 = jM3042unboximpl;
                j5 = j3;
                modifier3 = modifier2;
                z4 = z3;
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if ((i2 & 64) != 0) {
                    jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                    i6 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    i9 = i6 & (-29360129);
                    j3 = jM3042unboximpl;
                } else {
                    i9 = i6;
                    j3 = j2;
                }
                if (i7 != 0) {
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
                j4 = jM3042unboximpl;
                j5 = j3;
                modifier3 = modifier2;
                z4 = z3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-777316544, i9, -1, "androidx.compose.material3.LeadingIconTab (Tab.kt:154)");
            }
            int i117 = i9;
            ComposableLambda composableLambda6 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -429037564, true, new TabKt$LeadingIconTab$2(modifier3, z, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, j4, composerStartRestartGroup, ((i9 >> 12) & 896) | 6, 2), z4, interfaceC3588op, interfaceC0526Fp2, i9, interfaceC0526Fp));
            int i118 = i117 >> 18;
            m1880TabTransitionKlgxPg(j4, j5, z, composableLambda6, composerStartRestartGroup, (i118 & 112) | (i118 & 14) | 3072 | ((i117 << 6) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            z5 = z4;
            j6 = j4;
            j7 = j5;
            mutableInteractionSource3 = mutableInteractionSource2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if ((i2 & 64) != 0) {
                    jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                    i6 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    i9 = i6 & (-29360129);
                    j3 = jM3042unboximpl;
                } else {
                    i9 = i6;
                    j3 = j2;
                }
                if (i7 != 0) {
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
                j4 = jM3042unboximpl;
                j5 = j3;
                modifier3 = modifier2;
                z4 = z3;
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if ((i2 & 64) != 0) {
                    jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                    i6 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    i9 = i6 & (-29360129);
                    j3 = jM3042unboximpl;
                } else {
                    i9 = i6;
                    j3 = j2;
                }
                if (i7 != 0) {
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
                j4 = jM3042unboximpl;
                j5 = j3;
                modifier3 = modifier2;
                z4 = z3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-777316544, i9, -1, "androidx.compose.material3.LeadingIconTab (Tab.kt:154)");
            }
            int i119 = i9;
            ComposableLambda composableLambda7 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -429037564, true, new TabKt$LeadingIconTab$2(modifier3, z, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, j4, composerStartRestartGroup, ((i9 >> 12) & 896) | 6, 2), z4, interfaceC3588op, interfaceC0526Fp2, i9, interfaceC0526Fp));
            int i1110 = i119 >> 18;
            m1880TabTransitionKlgxPg(j4, j5, z, composableLambda7, composerStartRestartGroup, (i1110 & 112) | (i1110 & 14) | 3072 | ((i119 << 6) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            z5 = z4;
            j6 = j4;
            j7 = j5;
            mutableInteractionSource3 = mutableInteractionSource2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$LeadingIconTab$3(z, interfaceC3588op, interfaceC0526Fp, interfaceC0526Fp2, modifier4, z5, j6, j7, mutableInteractionSource3, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0142 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:105:0x0144  */
    /* JADX WARN: Code duplicated, block: B:107:0x0149  */
    /* JADX WARN: Code duplicated, block: B:110:0x014e  */
    /* JADX WARN: Code duplicated, block: B:113:0x0162  */
    /* JADX WARN: Code duplicated, block: B:114:0x016a  */
    /* JADX WARN: Code duplicated, block: B:116:0x016e  */
    /* JADX WARN: Code duplicated, block: B:118:0x0180  */
    /* JADX WARN: Code duplicated, block: B:121:0x0197  */
    /* JADX WARN: Code duplicated, block: B:124:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:127:0x0203  */
    /* JADX WARN: Code duplicated, block: B:132:0x0216  */
    /* JADX WARN: Code duplicated, block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x006c  */
    /* JADX WARN: Code duplicated, block: B:38:0x0071  */
    /* JADX WARN: Code duplicated, block: B:40:0x0075  */
    /* JADX WARN: Code duplicated, block: B:42:0x007d  */
    /* JADX WARN: Code duplicated, block: B:43:0x0080  */
    /* JADX WARN: Code duplicated, block: B:47:0x0089  */
    /* JADX WARN: Code duplicated, block: B:49:0x008d  */
    /* JADX WARN: Code duplicated, block: B:51:0x0095  */
    /* JADX WARN: Code duplicated, block: B:52:0x0098  */
    /* JADX WARN: Code duplicated, block: B:55:0x009e  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:69:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:73:0x00da  */
    /* JADX WARN: Code duplicated, block: B:74:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:88:0x0103  */
    /* JADX WARN: Code duplicated, block: B:92:0x0114  */
    /* JADX WARN: Code duplicated, block: B:94:0x011f  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Tab-bogVsAg, reason: not valid java name */
    public static final void m1878TabbogVsAg(boolean z, InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z2, long j, long j2, MutableInteractionSource mutableInteractionSource, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        long jM3042unboximpl;
        int i6;
        int i7;
        MutableInteractionSource mutableInteractionSource2;
        int i8;
        int i9;
        long j3;
        MutableInteractionSource mutableInteractionSource3;
        int i10;
        long j4;
        Modifier modifier3;
        long j5;
        Object objRememberedValue;
        boolean z4;
        long j6;
        long j7;
        MutableInteractionSource mutableInteractionSource4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-202735880);
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
        int i12 = i2 & 4;
        if (i12 == 0) {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        jM3042unboximpl = j;
                        int i13 = composerStartRestartGroup.changed(jM3042unboximpl) ? 16384 : 8192;
                        i3 |= i13;
                    } else {
                        jM3042unboximpl = j;
                    }
                    i3 |= i13;
                } else {
                    jM3042unboximpl = j;
                }
                if ((458752 & i) == 0) {
                    int i14 = i3;
                    if ((i2 & 32) == 0 || !composerStartRestartGroup.changed(j2)) {
                        i11 = 65536;
                    } else {
                        i11 = 131072;
                    }
                    i6 = i14 | i11;
                } else {
                    i6 = i3;
                }
                i7 = i2 & 64;
                if (i7 != 0) {
                    i6 |= 1572864;
                    mutableInteractionSource2 = mutableInteractionSource;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i8 = 1048576;
                        } else {
                            i8 = 524288;
                        }
                        i6 |= i8;
                    }
                }
                if ((i2 & 128) != 0) {
                    if ((29360128 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i9 = 8388608;
                        } else {
                            i9 = 4194304;
                        }
                    }
                    if ((23967451 & i6) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i12 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if ((i2 & 16) != 0) {
                                jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                                i6 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i6 = (-458753) & i6;
                                j3 = jM3042unboximpl;
                            } else {
                                j3 = j2;
                            }
                            if (i7 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            i10 = i6;
                            j4 = j3;
                            modifier3 = modifier2;
                            j5 = jM3042unboximpl;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i6 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i6 &= -458753;
                            }
                            j4 = j2;
                            z3 = z3;
                            j5 = jM3042unboximpl;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            i10 = i6;
                            modifier3 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-202735880, i10, -1, "androidx.compose.material3.Tab (Tab.kt:226)");
                        }
                        int i15 = i10;
                        int i16 = i15 >> 12;
                        m1880TabTransitionKlgxPg(j5, j4, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -551896140, true, new TabKt$Tab$5(modifier3, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, j5, composerStartRestartGroup, ((i10 >> 6) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i16 & 112) | (i16 & 14) | 3072 | ((i15 << 6) & 896));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        z4 = z3;
                        j6 = j5;
                        j7 = j4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        z4 = z3;
                        j6 = jM3042unboximpl;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        j7 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$6(z, interfaceC3588op, modifier2, z4, j6, j7, mutableInteractionSource4, interfaceC0552Gp, i, i2));
                }
                i9 = 12582912;
                i6 |= i9;
                if ((23967451 & i6) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i6 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i6 = (-458753) & i6;
                            j3 = jM3042unboximpl;
                        } else {
                            j3 = j2;
                        }
                        if (i7 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        i10 = i6;
                        j4 = j3;
                        modifier3 = modifier2;
                        j5 = jM3042unboximpl;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i6 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i6 = (-458753) & i6;
                            j3 = jM3042unboximpl;
                        } else {
                            j3 = j2;
                        }
                        if (i7 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        i10 = i6;
                        j4 = j3;
                        modifier3 = modifier2;
                        j5 = jM3042unboximpl;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-202735880, i10, -1, "androidx.compose.material3.Tab (Tab.kt:226)");
                    }
                    int i17 = i10;
                    int i18 = i17 >> 12;
                    m1880TabTransitionKlgxPg(j5, j4, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -551896140, true, new TabKt$Tab$5(modifier3, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, j5, composerStartRestartGroup, ((i10 >> 6) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i18 & 112) | (i18 & 14) | 3072 | ((i17 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    z4 = z3;
                    j6 = j5;
                    j7 = j4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i6 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i6 = (-458753) & i6;
                            j3 = jM3042unboximpl;
                        } else {
                            j3 = j2;
                        }
                        if (i7 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        i10 = i6;
                        j4 = j3;
                        modifier3 = modifier2;
                        j5 = jM3042unboximpl;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i6 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i6 = (-458753) & i6;
                            j3 = jM3042unboximpl;
                        } else {
                            j3 = j2;
                        }
                        if (i7 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        i10 = i6;
                        j4 = j3;
                        modifier3 = modifier2;
                        j5 = jM3042unboximpl;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-202735880, i10, -1, "androidx.compose.material3.Tab (Tab.kt:226)");
                    }
                    int i19 = i10;
                    int i110 = i19 >> 12;
                    m1880TabTransitionKlgxPg(j5, j4, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -551896140, true, new TabKt$Tab$5(modifier3, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, j5, composerStartRestartGroup, ((i10 >> 6) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i110 & 112) | (i110 & 14) | 3072 | ((i19 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    z4 = z3;
                    j6 = j5;
                    j7 = j4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$6(z, interfaceC3588op, modifier2, z4, j6, j7, mutableInteractionSource4, interfaceC0552Gp, i, i2));
            }
            i3 |= 3072;
            z3 = z2;
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    jM3042unboximpl = j;
                    if (composerStartRestartGroup.changed(jM3042unboximpl)) {
                    }
                    i3 |= i13;
                } else {
                    jM3042unboximpl = j;
                }
                i3 |= i13;
            } else {
                jM3042unboximpl = j;
            }
            if ((458752 & i) == 0) {
                int i111 = i3;
                if ((i2 & 32) == 0) {
                    i11 = 65536;
                } else {
                    i11 = 65536;
                }
                i6 = i111 | i11;
            } else {
                i6 = i3;
            }
            i7 = i2 & 64;
            if (i7 != 0) {
                i6 |= 1572864;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i6 |= i8;
                }
            }
            if ((i2 & 128) != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                }
                if ((23967451 & i6) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i6 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i6 = (-458753) & i6;
                            j3 = jM3042unboximpl;
                        } else {
                            j3 = j2;
                        }
                        if (i7 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        i10 = i6;
                        j4 = j3;
                        modifier3 = modifier2;
                        j5 = jM3042unboximpl;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i6 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i6 = (-458753) & i6;
                            j3 = jM3042unboximpl;
                        } else {
                            j3 = j2;
                        }
                        if (i7 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        i10 = i6;
                        j4 = j3;
                        modifier3 = modifier2;
                        j5 = jM3042unboximpl;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-202735880, i10, -1, "androidx.compose.material3.Tab (Tab.kt:226)");
                    }
                    int i112 = i10;
                    int i113 = i112 >> 12;
                    m1880TabTransitionKlgxPg(j5, j4, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -551896140, true, new TabKt$Tab$5(modifier3, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, j5, composerStartRestartGroup, ((i10 >> 6) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i113 & 112) | (i113 & 14) | 3072 | ((i112 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    z4 = z3;
                    j6 = j5;
                    j7 = j4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i6 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i6 = (-458753) & i6;
                            j3 = jM3042unboximpl;
                        } else {
                            j3 = j2;
                        }
                        if (i7 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        i10 = i6;
                        j4 = j3;
                        modifier3 = modifier2;
                        j5 = jM3042unboximpl;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i6 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i6 = (-458753) & i6;
                            j3 = jM3042unboximpl;
                        } else {
                            j3 = j2;
                        }
                        if (i7 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        i10 = i6;
                        j4 = j3;
                        modifier3 = modifier2;
                        j5 = jM3042unboximpl;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-202735880, i10, -1, "androidx.compose.material3.Tab (Tab.kt:226)");
                    }
                    int i114 = i10;
                    int i115 = i114 >> 12;
                    m1880TabTransitionKlgxPg(j5, j4, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -551896140, true, new TabKt$Tab$5(modifier3, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, j5, composerStartRestartGroup, ((i10 >> 6) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i115 & 112) | (i115 & 14) | 3072 | ((i114 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    z4 = z3;
                    j6 = j5;
                    j7 = j4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$6(z, interfaceC3588op, modifier2, z4, j6, j7, mutableInteractionSource4, interfaceC0552Gp, i, i2));
            }
            i9 = 12582912;
            i6 |= i9;
            if ((23967451 & i6) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i6 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i6 = (-458753) & i6;
                        j3 = jM3042unboximpl;
                    } else {
                        j3 = j2;
                    }
                    if (i7 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    i10 = i6;
                    j4 = j3;
                    modifier3 = modifier2;
                    j5 = jM3042unboximpl;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i6 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i6 = (-458753) & i6;
                        j3 = jM3042unboximpl;
                    } else {
                        j3 = j2;
                    }
                    if (i7 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    i10 = i6;
                    j4 = j3;
                    modifier3 = modifier2;
                    j5 = jM3042unboximpl;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-202735880, i10, -1, "androidx.compose.material3.Tab (Tab.kt:226)");
                }
                int i116 = i10;
                int i117 = i116 >> 12;
                m1880TabTransitionKlgxPg(j5, j4, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -551896140, true, new TabKt$Tab$5(modifier3, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, j5, composerStartRestartGroup, ((i10 >> 6) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i117 & 112) | (i117 & 14) | 3072 | ((i116 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                z4 = z3;
                j6 = j5;
                j7 = j4;
                mutableInteractionSource4 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i6 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i6 = (-458753) & i6;
                        j3 = jM3042unboximpl;
                    } else {
                        j3 = j2;
                    }
                    if (i7 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    i10 = i6;
                    j4 = j3;
                    modifier3 = modifier2;
                    j5 = jM3042unboximpl;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i6 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i6 = (-458753) & i6;
                        j3 = jM3042unboximpl;
                    } else {
                        j3 = j2;
                    }
                    if (i7 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    i10 = i6;
                    j4 = j3;
                    modifier3 = modifier2;
                    j5 = jM3042unboximpl;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-202735880, i10, -1, "androidx.compose.material3.Tab (Tab.kt:226)");
                }
                int i118 = i10;
                int i119 = i118 >> 12;
                m1880TabTransitionKlgxPg(j5, j4, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -551896140, true, new TabKt$Tab$5(modifier3, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, j5, composerStartRestartGroup, ((i10 >> 6) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i119 & 112) | (i119 & 14) | 3072 | ((i118 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                z4 = z3;
                j6 = j5;
                j7 = j4;
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$6(z, interfaceC3588op, modifier2, z4, j6, j7, mutableInteractionSource4, interfaceC0552Gp, i, i2));
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    jM3042unboximpl = j;
                    if (composerStartRestartGroup.changed(jM3042unboximpl)) {
                    }
                    i3 |= i13;
                } else {
                    jM3042unboximpl = j;
                }
                i3 |= i13;
            } else {
                jM3042unboximpl = j;
            }
            if ((458752 & i) == 0) {
                int i1110 = i3;
                if ((i2 & 32) == 0) {
                    i11 = 65536;
                } else {
                    i11 = 65536;
                }
                i6 = i1110 | i11;
            } else {
                i6 = i3;
            }
            i7 = i2 & 64;
            if (i7 != 0) {
                i6 |= 1572864;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i6 |= i8;
                }
            }
            if ((i2 & 128) != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                }
                if ((23967451 & i6) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i6 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i6 = (-458753) & i6;
                            j3 = jM3042unboximpl;
                        } else {
                            j3 = j2;
                        }
                        if (i7 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        i10 = i6;
                        j4 = j3;
                        modifier3 = modifier2;
                        j5 = jM3042unboximpl;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i6 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i6 = (-458753) & i6;
                            j3 = jM3042unboximpl;
                        } else {
                            j3 = j2;
                        }
                        if (i7 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        i10 = i6;
                        j4 = j3;
                        modifier3 = modifier2;
                        j5 = jM3042unboximpl;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-202735880, i10, -1, "androidx.compose.material3.Tab (Tab.kt:226)");
                    }
                    int i1111 = i10;
                    int i1112 = i1111 >> 12;
                    m1880TabTransitionKlgxPg(j5, j4, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -551896140, true, new TabKt$Tab$5(modifier3, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, j5, composerStartRestartGroup, ((i10 >> 6) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i1112 & 112) | (i1112 & 14) | 3072 | ((i1111 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    z4 = z3;
                    j6 = j5;
                    j7 = j4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i6 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i6 = (-458753) & i6;
                            j3 = jM3042unboximpl;
                        } else {
                            j3 = j2;
                        }
                        if (i7 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        i10 = i6;
                        j4 = j3;
                        modifier3 = modifier2;
                        j5 = jM3042unboximpl;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i6 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i6 = (-458753) & i6;
                            j3 = jM3042unboximpl;
                        } else {
                            j3 = j2;
                        }
                        if (i7 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        i10 = i6;
                        j4 = j3;
                        modifier3 = modifier2;
                        j5 = jM3042unboximpl;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-202735880, i10, -1, "androidx.compose.material3.Tab (Tab.kt:226)");
                    }
                    int i1113 = i10;
                    int i1114 = i1113 >> 12;
                    m1880TabTransitionKlgxPg(j5, j4, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -551896140, true, new TabKt$Tab$5(modifier3, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, j5, composerStartRestartGroup, ((i10 >> 6) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i1114 & 112) | (i1114 & 14) | 3072 | ((i1113 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    z4 = z3;
                    j6 = j5;
                    j7 = j4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$6(z, interfaceC3588op, modifier2, z4, j6, j7, mutableInteractionSource4, interfaceC0552Gp, i, i2));
            }
            i9 = 12582912;
            i6 |= i9;
            if ((23967451 & i6) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i6 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i6 = (-458753) & i6;
                        j3 = jM3042unboximpl;
                    } else {
                        j3 = j2;
                    }
                    if (i7 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    i10 = i6;
                    j4 = j3;
                    modifier3 = modifier2;
                    j5 = jM3042unboximpl;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i6 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i6 = (-458753) & i6;
                        j3 = jM3042unboximpl;
                    } else {
                        j3 = j2;
                    }
                    if (i7 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    i10 = i6;
                    j4 = j3;
                    modifier3 = modifier2;
                    j5 = jM3042unboximpl;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-202735880, i10, -1, "androidx.compose.material3.Tab (Tab.kt:226)");
                }
                int i1115 = i10;
                int i1116 = i1115 >> 12;
                m1880TabTransitionKlgxPg(j5, j4, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -551896140, true, new TabKt$Tab$5(modifier3, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, j5, composerStartRestartGroup, ((i10 >> 6) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i1116 & 112) | (i1116 & 14) | 3072 | ((i1115 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                z4 = z3;
                j6 = j5;
                j7 = j4;
                mutableInteractionSource4 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i6 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i6 = (-458753) & i6;
                        j3 = jM3042unboximpl;
                    } else {
                        j3 = j2;
                    }
                    if (i7 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    i10 = i6;
                    j4 = j3;
                    modifier3 = modifier2;
                    j5 = jM3042unboximpl;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i6 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i6 = (-458753) & i6;
                        j3 = jM3042unboximpl;
                    } else {
                        j3 = j2;
                    }
                    if (i7 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    i10 = i6;
                    j4 = j3;
                    modifier3 = modifier2;
                    j5 = jM3042unboximpl;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-202735880, i10, -1, "androidx.compose.material3.Tab (Tab.kt:226)");
                }
                int i1117 = i10;
                int i1118 = i1117 >> 12;
                m1880TabTransitionKlgxPg(j5, j4, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -551896140, true, new TabKt$Tab$5(modifier3, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, j5, composerStartRestartGroup, ((i10 >> 6) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i1118 & 112) | (i1118 & 14) | 3072 | ((i1117 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                z4 = z3;
                j6 = j5;
                j7 = j4;
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$6(z, interfaceC3588op, modifier2, z4, j6, j7, mutableInteractionSource4, interfaceC0552Gp, i, i2));
        }
        i3 |= 3072;
        z3 = z2;
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                jM3042unboximpl = j;
                if (composerStartRestartGroup.changed(jM3042unboximpl)) {
                }
                i3 |= i13;
            } else {
                jM3042unboximpl = j;
            }
            i3 |= i13;
        } else {
            jM3042unboximpl = j;
        }
        if ((458752 & i) == 0) {
            int i1119 = i3;
            if ((i2 & 32) == 0) {
                i11 = 65536;
            } else {
                i11 = 65536;
            }
            i6 = i1119 | i11;
        } else {
            i6 = i3;
        }
        i7 = i2 & 64;
        if (i7 != 0) {
            i6 |= 1572864;
            mutableInteractionSource2 = mutableInteractionSource;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i6 |= i8;
            }
        }
        if ((i2 & 128) != 0) {
            if ((29360128 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
            }
            if ((23967451 & i6) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i6 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i6 = (-458753) & i6;
                        j3 = jM3042unboximpl;
                    } else {
                        j3 = j2;
                    }
                    if (i7 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    i10 = i6;
                    j4 = j3;
                    modifier3 = modifier2;
                    j5 = jM3042unboximpl;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i6 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i6 = (-458753) & i6;
                        j3 = jM3042unboximpl;
                    } else {
                        j3 = j2;
                    }
                    if (i7 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    i10 = i6;
                    j4 = j3;
                    modifier3 = modifier2;
                    j5 = jM3042unboximpl;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-202735880, i10, -1, "androidx.compose.material3.Tab (Tab.kt:226)");
                }
                int i11110 = i10;
                int i11111 = i11110 >> 12;
                m1880TabTransitionKlgxPg(j5, j4, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -551896140, true, new TabKt$Tab$5(modifier3, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, j5, composerStartRestartGroup, ((i10 >> 6) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i11111 & 112) | (i11111 & 14) | 3072 | ((i11110 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                z4 = z3;
                j6 = j5;
                j7 = j4;
                mutableInteractionSource4 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i6 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i6 = (-458753) & i6;
                        j3 = jM3042unboximpl;
                    } else {
                        j3 = j2;
                    }
                    if (i7 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    i10 = i6;
                    j4 = j3;
                    modifier3 = modifier2;
                    j5 = jM3042unboximpl;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i6 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i6 = (-458753) & i6;
                        j3 = jM3042unboximpl;
                    } else {
                        j3 = j2;
                    }
                    if (i7 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    i10 = i6;
                    j4 = j3;
                    modifier3 = modifier2;
                    j5 = jM3042unboximpl;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-202735880, i10, -1, "androidx.compose.material3.Tab (Tab.kt:226)");
                }
                int i11112 = i10;
                int i11113 = i11112 >> 12;
                m1880TabTransitionKlgxPg(j5, j4, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -551896140, true, new TabKt$Tab$5(modifier3, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, j5, composerStartRestartGroup, ((i10 >> 6) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i11113 & 112) | (i11113 & 14) | 3072 | ((i11112 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                z4 = z3;
                j6 = j5;
                j7 = j4;
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$6(z, interfaceC3588op, modifier2, z4, j6, j7, mutableInteractionSource4, interfaceC0552Gp, i, i2));
        }
        i9 = 12582912;
        i6 |= i9;
        if ((23967451 & i6) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if ((i2 & 16) != 0) {
                    jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                    i6 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    i6 = (-458753) & i6;
                    j3 = jM3042unboximpl;
                } else {
                    j3 = j2;
                }
                if (i7 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                i10 = i6;
                j4 = j3;
                modifier3 = modifier2;
                j5 = jM3042unboximpl;
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if ((i2 & 16) != 0) {
                    jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                    i6 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    i6 = (-458753) & i6;
                    j3 = jM3042unboximpl;
                } else {
                    j3 = j2;
                }
                if (i7 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                i10 = i6;
                j4 = j3;
                modifier3 = modifier2;
                j5 = jM3042unboximpl;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-202735880, i10, -1, "androidx.compose.material3.Tab (Tab.kt:226)");
            }
            int i11114 = i10;
            int i11115 = i11114 >> 12;
            m1880TabTransitionKlgxPg(j5, j4, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -551896140, true, new TabKt$Tab$5(modifier3, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, j5, composerStartRestartGroup, ((i10 >> 6) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i11115 & 112) | (i11115 & 14) | 3072 | ((i11114 << 6) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            z4 = z3;
            j6 = j5;
            j7 = j4;
            mutableInteractionSource4 = mutableInteractionSource3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if ((i2 & 16) != 0) {
                    jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                    i6 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    i6 = (-458753) & i6;
                    j3 = jM3042unboximpl;
                } else {
                    j3 = j2;
                }
                if (i7 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                i10 = i6;
                j4 = j3;
                modifier3 = modifier2;
                j5 = jM3042unboximpl;
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if ((i2 & 16) != 0) {
                    jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                    i6 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    i6 = (-458753) & i6;
                    j3 = jM3042unboximpl;
                } else {
                    j3 = j2;
                }
                if (i7 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                i10 = i6;
                j4 = j3;
                modifier3 = modifier2;
                j5 = jM3042unboximpl;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-202735880, i10, -1, "androidx.compose.material3.Tab (Tab.kt:226)");
            }
            int i11116 = i10;
            int i11117 = i11116 >> 12;
            m1880TabTransitionKlgxPg(j5, j4, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -551896140, true, new TabKt$Tab$5(modifier3, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, j5, composerStartRestartGroup, ((i10 >> 6) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i11117 & 112) | (i11117 & 14) | 3072 | ((i11116 << 6) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            z4 = z3;
            j6 = j5;
            j7 = j4;
            mutableInteractionSource4 = mutableInteractionSource3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$6(z, interfaceC3588op, modifier2, z4, j6, j7, mutableInteractionSource4, interfaceC0552Gp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0135  */
    /* JADX WARN: Code duplicated, block: B:104:0x0142  */
    /* JADX WARN: Code duplicated, block: B:114:0x0169 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:115:0x016b  */
    /* JADX WARN: Code duplicated, block: B:116:0x016e  */
    /* JADX WARN: Code duplicated, block: B:118:0x0172  */
    /* JADX WARN: Code duplicated, block: B:119:0x0174  */
    /* JADX WARN: Code duplicated, block: B:121:0x0178  */
    /* JADX WARN: Code duplicated, block: B:122:0x017b  */
    /* JADX WARN: Code duplicated, block: B:124:0x017f  */
    /* JADX WARN: Code duplicated, block: B:127:0x0185  */
    /* JADX WARN: Code duplicated, block: B:128:0x0196  */
    /* JADX WARN: Code duplicated, block: B:131:0x019c  */
    /* JADX WARN: Code duplicated, block: B:133:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:135:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:138:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:141:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:143:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:146:0x0241  */
    /* JADX WARN: Code duplicated, block: B:151:0x0259  */
    /* JADX WARN: Code duplicated, block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0065  */
    /* JADX WARN: Code duplicated, block: B:38:0x006a  */
    /* JADX WARN: Code duplicated, block: B:40:0x006e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0076  */
    /* JADX WARN: Code duplicated, block: B:43:0x0079  */
    /* JADX WARN: Code duplicated, block: B:47:0x0083  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088  */
    /* JADX WARN: Code duplicated, block: B:51:0x008c  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:54:0x0097  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:78:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:83:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:91:0x0104  */
    /* JADX WARN: Code duplicated, block: B:93:0x010a  */
    /* JADX WARN: Code duplicated, block: B:94:0x010d  */
    /* JADX WARN: Code duplicated, block: B:98:0x011b  */
    /* JADX WARN: Instruction removed from duplicated block: B:102:0x0135, please report this as an issue */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Tab-wqdebIU, reason: not valid java name */
    public static final void m1879TabwqdebIU(boolean z, InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z2, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, long j, long j2, MutableInteractionSource mutableInteractionSource, Composer composer, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        InterfaceC0526Fp interfaceC0526Fp3;
        int i9;
        long j3;
        int i10;
        int i11;
        Modifier modifier2;
        boolean z3;
        InterfaceC0526Fp interfaceC0526Fp4;
        long jM3042unboximpl;
        MutableInteractionSource mutableInteractionSource2;
        Modifier modifier3;
        boolean z4;
        long j4;
        InterfaceC0526Fp interfaceC0526Fp5;
        InterfaceC0526Fp interfaceC0526Fp6;
        Object objRememberedValue;
        InterfaceC0526Fp interfaceC0526Fp7;
        Modifier modifier4;
        InterfaceC0526Fp interfaceC0526Fp8;
        boolean z5;
        long j5;
        long j6;
        MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i12;
        int i13;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-350627181);
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
        int i14 = i2 & 4;
        if (i14 == 0) {
            if ((i & 896) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 57344) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 32;
                    if (i8 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                        if ((i & 458752) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                                i9 = 131072;
                            } else {
                                i9 = 65536;
                            }
                            i3 |= i9;
                        }
                    }
                    if ((i & 3670016) != 0) {
                        if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(j)) {
                            i13 = 524288;
                        } else {
                            i13 = 1048576;
                        }
                        i3 |= i13;
                    }
                    if ((i & 29360128) == 0) {
                        j3 = j2;
                        if ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j3)) {
                            i12 = 4194304;
                        } else {
                            i12 = 8388608;
                        }
                        i3 |= i12;
                    } else {
                        j3 = j2;
                    }
                    i10 = i2 & 256;
                    if (i10 != 0) {
                        i3 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
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
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp3 = null;
                            }
                            if ((i2 & 64) != 0) {
                                jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                                i3 &= -3670017;
                            } else {
                                jM3042unboximpl = j;
                            }
                            if ((i2 & 128) != 0) {
                                i3 &= -29360129;
                                j3 = jM3042unboximpl;
                            }
                            if (i10 != 0) {
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
                            modifier3 = modifier2;
                            z4 = z3;
                            j4 = j3;
                            interfaceC0526Fp5 = interfaceC0526Fp3;
                            interfaceC0526Fp6 = interfaceC0526Fp4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i3 &= -29360129;
                            }
                            modifier3 = modifier;
                            z4 = z2;
                            jM3042unboximpl = j;
                            mutableInteractionSource2 = mutableInteractionSource;
                            j4 = j3;
                            interfaceC0526Fp5 = interfaceC0526Fp3;
                            interfaceC0526Fp6 = interfaceC0526Fp;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-350627181, i3, -1, "androidx.compose.material3.Tab (Tab.kt:92)");
                        }
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1540996038, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, 708874428, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
                        int i15 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                        int i16 = i3 >> 6;
                        InterfaceC0526Fp interfaceC0526Fp9 = interfaceC0526Fp5;
                        InterfaceC0526Fp interfaceC0526Fp10 = interfaceC0526Fp6;
                        m1878TabbogVsAg(z, interfaceC3588op, modifier3, z4, jM3042unboximpl, j4, mutableInteractionSource2, composableLambda, composerStartRestartGroup, i15 | (57344 & i16) | (458752 & i16) | (i16 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp7 = interfaceC0526Fp10;
                        modifier4 = modifier3;
                        interfaceC0526Fp8 = interfaceC0526Fp9;
                        z5 = z4;
                        j5 = jM3042unboximpl;
                        j6 = j4;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier4 = modifier;
                        z5 = z2;
                        interfaceC0526Fp7 = interfaceC0526Fp;
                        mutableInteractionSource3 = mutableInteractionSource;
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                        j6 = j3;
                        j5 = j;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$3(z, interfaceC3588op, modifier4, z5, interfaceC0526Fp7, interfaceC0526Fp8, j5, j6, mutableInteractionSource3, i, i2));
                }
                i3 |= 24576;
                i8 = i2 & 32;
                if (i8 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                } else {
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                }
                if ((i & 3670016) != 0) {
                    if ((i2 & 64) == 0) {
                        i13 = 524288;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                if ((i & 29360128) == 0) {
                    j3 = j2;
                    if ((i2 & 128) == 0) {
                        i12 = 4194304;
                    } else {
                        i12 = 4194304;
                    }
                    i3 |= i12;
                } else {
                    j3 = j2;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
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
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp3 = null;
                        }
                        if ((i2 & 64) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i3 &= -3670017;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i3 &= -29360129;
                            j3 = jM3042unboximpl;
                        }
                        if (i10 != 0) {
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
                        modifier3 = modifier2;
                        z4 = z3;
                        j4 = j3;
                        interfaceC0526Fp5 = interfaceC0526Fp3;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp3 = null;
                        }
                        if ((i2 & 64) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i3 &= -3670017;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i3 &= -29360129;
                            j3 = jM3042unboximpl;
                        }
                        if (i10 != 0) {
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
                        modifier3 = modifier2;
                        z4 = z3;
                        j4 = j3;
                        interfaceC0526Fp5 = interfaceC0526Fp3;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350627181, i3, -1, "androidx.compose.material3.Tab (Tab.kt:92)");
                    }
                    ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1540996038, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, 708874428, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
                    int i17 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                    int i18 = i3 >> 6;
                    InterfaceC0526Fp interfaceC0526Fp11 = interfaceC0526Fp5;
                    InterfaceC0526Fp interfaceC0526Fp12 = interfaceC0526Fp6;
                    m1878TabbogVsAg(z, interfaceC3588op, modifier3, z4, jM3042unboximpl, j4, mutableInteractionSource2, composableLambda2, composerStartRestartGroup, i17 | (57344 & i18) | (458752 & i18) | (i18 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp7 = interfaceC0526Fp12;
                    modifier4 = modifier3;
                    interfaceC0526Fp8 = interfaceC0526Fp11;
                    z5 = z4;
                    j5 = jM3042unboximpl;
                    j6 = j4;
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
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp3 = null;
                        }
                        if ((i2 & 64) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i3 &= -3670017;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i3 &= -29360129;
                            j3 = jM3042unboximpl;
                        }
                        if (i10 != 0) {
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
                        modifier3 = modifier2;
                        z4 = z3;
                        j4 = j3;
                        interfaceC0526Fp5 = interfaceC0526Fp3;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp3 = null;
                        }
                        if ((i2 & 64) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i3 &= -3670017;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i3 &= -29360129;
                            j3 = jM3042unboximpl;
                        }
                        if (i10 != 0) {
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
                        modifier3 = modifier2;
                        z4 = z3;
                        j4 = j3;
                        interfaceC0526Fp5 = interfaceC0526Fp3;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350627181, i3, -1, "androidx.compose.material3.Tab (Tab.kt:92)");
                    }
                    ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1540996038, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, 708874428, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
                    int i19 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                    int i110 = i3 >> 6;
                    InterfaceC0526Fp interfaceC0526Fp13 = interfaceC0526Fp5;
                    InterfaceC0526Fp interfaceC0526Fp14 = interfaceC0526Fp6;
                    m1878TabbogVsAg(z, interfaceC3588op, modifier3, z4, jM3042unboximpl, j4, mutableInteractionSource2, composableLambda3, composerStartRestartGroup, i19 | (57344 & i110) | (458752 & i110) | (i110 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp7 = interfaceC0526Fp14;
                    modifier4 = modifier3;
                    interfaceC0526Fp8 = interfaceC0526Fp13;
                    z5 = z4;
                    j5 = jM3042unboximpl;
                    j6 = j4;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$3(z, interfaceC3588op, modifier4, z5, interfaceC0526Fp7, interfaceC0526Fp8, j5, j6, mutableInteractionSource3, i, i2));
            }
            i3 |= 3072;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                } else {
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                }
                if ((i & 3670016) != 0) {
                    if ((i2 & 64) == 0) {
                        i13 = 524288;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                if ((i & 29360128) == 0) {
                    j3 = j2;
                    if ((i2 & 128) == 0) {
                        i12 = 4194304;
                    } else {
                        i12 = 4194304;
                    }
                    i3 |= i12;
                } else {
                    j3 = j2;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
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
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp3 = null;
                        }
                        if ((i2 & 64) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i3 &= -3670017;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i3 &= -29360129;
                            j3 = jM3042unboximpl;
                        }
                        if (i10 != 0) {
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
                        modifier3 = modifier2;
                        z4 = z3;
                        j4 = j3;
                        interfaceC0526Fp5 = interfaceC0526Fp3;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp3 = null;
                        }
                        if ((i2 & 64) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i3 &= -3670017;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i3 &= -29360129;
                            j3 = jM3042unboximpl;
                        }
                        if (i10 != 0) {
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
                        modifier3 = modifier2;
                        z4 = z3;
                        j4 = j3;
                        interfaceC0526Fp5 = interfaceC0526Fp3;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350627181, i3, -1, "androidx.compose.material3.Tab (Tab.kt:92)");
                    }
                    ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1540996038, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, 708874428, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
                    int i111 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                    int i112 = i3 >> 6;
                    InterfaceC0526Fp interfaceC0526Fp15 = interfaceC0526Fp5;
                    InterfaceC0526Fp interfaceC0526Fp16 = interfaceC0526Fp6;
                    m1878TabbogVsAg(z, interfaceC3588op, modifier3, z4, jM3042unboximpl, j4, mutableInteractionSource2, composableLambda4, composerStartRestartGroup, i111 | (57344 & i112) | (458752 & i112) | (i112 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp7 = interfaceC0526Fp16;
                    modifier4 = modifier3;
                    interfaceC0526Fp8 = interfaceC0526Fp15;
                    z5 = z4;
                    j5 = jM3042unboximpl;
                    j6 = j4;
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
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp3 = null;
                        }
                        if ((i2 & 64) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i3 &= -3670017;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i3 &= -29360129;
                            j3 = jM3042unboximpl;
                        }
                        if (i10 != 0) {
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
                        modifier3 = modifier2;
                        z4 = z3;
                        j4 = j3;
                        interfaceC0526Fp5 = interfaceC0526Fp3;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp3 = null;
                        }
                        if ((i2 & 64) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i3 &= -3670017;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i3 &= -29360129;
                            j3 = jM3042unboximpl;
                        }
                        if (i10 != 0) {
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
                        modifier3 = modifier2;
                        z4 = z3;
                        j4 = j3;
                        interfaceC0526Fp5 = interfaceC0526Fp3;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350627181, i3, -1, "androidx.compose.material3.Tab (Tab.kt:92)");
                    }
                    ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1540996038, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, 708874428, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
                    int i113 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                    int i114 = i3 >> 6;
                    InterfaceC0526Fp interfaceC0526Fp17 = interfaceC0526Fp5;
                    InterfaceC0526Fp interfaceC0526Fp18 = interfaceC0526Fp6;
                    m1878TabbogVsAg(z, interfaceC3588op, modifier3, z4, jM3042unboximpl, j4, mutableInteractionSource2, composableLambda5, composerStartRestartGroup, i113 | (57344 & i114) | (458752 & i114) | (i114 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp7 = interfaceC0526Fp18;
                    modifier4 = modifier3;
                    interfaceC0526Fp8 = interfaceC0526Fp17;
                    z5 = z4;
                    j5 = jM3042unboximpl;
                    j6 = j4;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$3(z, interfaceC3588op, modifier4, z5, interfaceC0526Fp7, interfaceC0526Fp8, j5, j6, mutableInteractionSource3, i, i2));
            }
            i3 |= 24576;
            i8 = i2 & 32;
            if (i8 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                interfaceC0526Fp3 = interfaceC0526Fp2;
            } else {
                interfaceC0526Fp3 = interfaceC0526Fp2;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
            }
            if ((i & 3670016) != 0) {
                if ((i2 & 64) == 0) {
                    i13 = 524288;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            if ((i & 29360128) == 0) {
                j3 = j2;
                if ((i2 & 128) == 0) {
                    i12 = 4194304;
                } else {
                    i12 = 4194304;
                }
                i3 |= i12;
            } else {
                j3 = j2;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
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
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp3 = null;
                    }
                    if ((i2 & 64) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i3 &= -3670017;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                        j3 = jM3042unboximpl;
                    }
                    if (i10 != 0) {
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
                    modifier3 = modifier2;
                    z4 = z3;
                    j4 = j3;
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp3 = null;
                    }
                    if ((i2 & 64) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i3 &= -3670017;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                        j3 = jM3042unboximpl;
                    }
                    if (i10 != 0) {
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
                    modifier3 = modifier2;
                    z4 = z3;
                    j4 = j3;
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-350627181, i3, -1, "androidx.compose.material3.Tab (Tab.kt:92)");
                }
                ComposableLambda composableLambda6 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1540996038, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, 708874428, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
                int i115 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                int i116 = i3 >> 6;
                InterfaceC0526Fp interfaceC0526Fp19 = interfaceC0526Fp5;
                InterfaceC0526Fp interfaceC0526Fp110 = interfaceC0526Fp6;
                m1878TabbogVsAg(z, interfaceC3588op, modifier3, z4, jM3042unboximpl, j4, mutableInteractionSource2, composableLambda6, composerStartRestartGroup, i115 | (57344 & i116) | (458752 & i116) | (i116 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp7 = interfaceC0526Fp110;
                modifier4 = modifier3;
                interfaceC0526Fp8 = interfaceC0526Fp19;
                z5 = z4;
                j5 = jM3042unboximpl;
                j6 = j4;
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
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp3 = null;
                    }
                    if ((i2 & 64) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i3 &= -3670017;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                        j3 = jM3042unboximpl;
                    }
                    if (i10 != 0) {
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
                    modifier3 = modifier2;
                    z4 = z3;
                    j4 = j3;
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp3 = null;
                    }
                    if ((i2 & 64) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i3 &= -3670017;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                        j3 = jM3042unboximpl;
                    }
                    if (i10 != 0) {
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
                    modifier3 = modifier2;
                    z4 = z3;
                    j4 = j3;
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-350627181, i3, -1, "androidx.compose.material3.Tab (Tab.kt:92)");
                }
                ComposableLambda composableLambda7 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1540996038, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, 708874428, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
                int i117 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                int i118 = i3 >> 6;
                InterfaceC0526Fp interfaceC0526Fp111 = interfaceC0526Fp5;
                InterfaceC0526Fp interfaceC0526Fp112 = interfaceC0526Fp6;
                m1878TabbogVsAg(z, interfaceC3588op, modifier3, z4, jM3042unboximpl, j4, mutableInteractionSource2, composableLambda7, composerStartRestartGroup, i117 | (57344 & i118) | (458752 & i118) | (i118 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp7 = interfaceC0526Fp112;
                modifier4 = modifier3;
                interfaceC0526Fp8 = interfaceC0526Fp111;
                z5 = z4;
                j5 = jM3042unboximpl;
                j6 = j4;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$3(z, interfaceC3588op, modifier4, z5, interfaceC0526Fp7, interfaceC0526Fp8, j5, j6, mutableInteractionSource3, i, i2));
        }
        i3 |= 384;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                } else {
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                }
                if ((i & 3670016) != 0) {
                    if ((i2 & 64) == 0) {
                        i13 = 524288;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                if ((i & 29360128) == 0) {
                    j3 = j2;
                    if ((i2 & 128) == 0) {
                        i12 = 4194304;
                    } else {
                        i12 = 4194304;
                    }
                    i3 |= i12;
                } else {
                    j3 = j2;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
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
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp3 = null;
                        }
                        if ((i2 & 64) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i3 &= -3670017;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i3 &= -29360129;
                            j3 = jM3042unboximpl;
                        }
                        if (i10 != 0) {
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
                        modifier3 = modifier2;
                        z4 = z3;
                        j4 = j3;
                        interfaceC0526Fp5 = interfaceC0526Fp3;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp3 = null;
                        }
                        if ((i2 & 64) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i3 &= -3670017;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i3 &= -29360129;
                            j3 = jM3042unboximpl;
                        }
                        if (i10 != 0) {
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
                        modifier3 = modifier2;
                        z4 = z3;
                        j4 = j3;
                        interfaceC0526Fp5 = interfaceC0526Fp3;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350627181, i3, -1, "androidx.compose.material3.Tab (Tab.kt:92)");
                    }
                    ComposableLambda composableLambda8 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1540996038, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, 708874428, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
                    int i119 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                    int i1110 = i3 >> 6;
                    InterfaceC0526Fp interfaceC0526Fp113 = interfaceC0526Fp5;
                    InterfaceC0526Fp interfaceC0526Fp114 = interfaceC0526Fp6;
                    m1878TabbogVsAg(z, interfaceC3588op, modifier3, z4, jM3042unboximpl, j4, mutableInteractionSource2, composableLambda8, composerStartRestartGroup, i119 | (57344 & i1110) | (458752 & i1110) | (i1110 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp7 = interfaceC0526Fp114;
                    modifier4 = modifier3;
                    interfaceC0526Fp8 = interfaceC0526Fp113;
                    z5 = z4;
                    j5 = jM3042unboximpl;
                    j6 = j4;
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
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp3 = null;
                        }
                        if ((i2 & 64) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i3 &= -3670017;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i3 &= -29360129;
                            j3 = jM3042unboximpl;
                        }
                        if (i10 != 0) {
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
                        modifier3 = modifier2;
                        z4 = z3;
                        j4 = j3;
                        interfaceC0526Fp5 = interfaceC0526Fp3;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp3 = null;
                        }
                        if ((i2 & 64) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i3 &= -3670017;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i3 &= -29360129;
                            j3 = jM3042unboximpl;
                        }
                        if (i10 != 0) {
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
                        modifier3 = modifier2;
                        z4 = z3;
                        j4 = j3;
                        interfaceC0526Fp5 = interfaceC0526Fp3;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350627181, i3, -1, "androidx.compose.material3.Tab (Tab.kt:92)");
                    }
                    ComposableLambda composableLambda9 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1540996038, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, 708874428, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
                    int i1111 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                    int i1112 = i3 >> 6;
                    InterfaceC0526Fp interfaceC0526Fp115 = interfaceC0526Fp5;
                    InterfaceC0526Fp interfaceC0526Fp116 = interfaceC0526Fp6;
                    m1878TabbogVsAg(z, interfaceC3588op, modifier3, z4, jM3042unboximpl, j4, mutableInteractionSource2, composableLambda9, composerStartRestartGroup, i1111 | (57344 & i1112) | (458752 & i1112) | (i1112 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp7 = interfaceC0526Fp116;
                    modifier4 = modifier3;
                    interfaceC0526Fp8 = interfaceC0526Fp115;
                    z5 = z4;
                    j5 = jM3042unboximpl;
                    j6 = j4;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$3(z, interfaceC3588op, modifier4, z5, interfaceC0526Fp7, interfaceC0526Fp8, j5, j6, mutableInteractionSource3, i, i2));
            }
            i3 |= 24576;
            i8 = i2 & 32;
            if (i8 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                interfaceC0526Fp3 = interfaceC0526Fp2;
            } else {
                interfaceC0526Fp3 = interfaceC0526Fp2;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
            }
            if ((i & 3670016) != 0) {
                if ((i2 & 64) == 0) {
                    i13 = 524288;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            if ((i & 29360128) == 0) {
                j3 = j2;
                if ((i2 & 128) == 0) {
                    i12 = 4194304;
                } else {
                    i12 = 4194304;
                }
                i3 |= i12;
            } else {
                j3 = j2;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
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
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp3 = null;
                    }
                    if ((i2 & 64) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i3 &= -3670017;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                        j3 = jM3042unboximpl;
                    }
                    if (i10 != 0) {
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
                    modifier3 = modifier2;
                    z4 = z3;
                    j4 = j3;
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp3 = null;
                    }
                    if ((i2 & 64) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i3 &= -3670017;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                        j3 = jM3042unboximpl;
                    }
                    if (i10 != 0) {
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
                    modifier3 = modifier2;
                    z4 = z3;
                    j4 = j3;
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-350627181, i3, -1, "androidx.compose.material3.Tab (Tab.kt:92)");
                }
                ComposableLambda composableLambda10 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1540996038, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, 708874428, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
                int i1113 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                int i1114 = i3 >> 6;
                InterfaceC0526Fp interfaceC0526Fp117 = interfaceC0526Fp5;
                InterfaceC0526Fp interfaceC0526Fp118 = interfaceC0526Fp6;
                m1878TabbogVsAg(z, interfaceC3588op, modifier3, z4, jM3042unboximpl, j4, mutableInteractionSource2, composableLambda10, composerStartRestartGroup, i1113 | (57344 & i1114) | (458752 & i1114) | (i1114 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp7 = interfaceC0526Fp118;
                modifier4 = modifier3;
                interfaceC0526Fp8 = interfaceC0526Fp117;
                z5 = z4;
                j5 = jM3042unboximpl;
                j6 = j4;
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
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp3 = null;
                    }
                    if ((i2 & 64) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i3 &= -3670017;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                        j3 = jM3042unboximpl;
                    }
                    if (i10 != 0) {
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
                    modifier3 = modifier2;
                    z4 = z3;
                    j4 = j3;
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp3 = null;
                    }
                    if ((i2 & 64) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i3 &= -3670017;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                        j3 = jM3042unboximpl;
                    }
                    if (i10 != 0) {
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
                    modifier3 = modifier2;
                    z4 = z3;
                    j4 = j3;
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-350627181, i3, -1, "androidx.compose.material3.Tab (Tab.kt:92)");
                }
                ComposableLambda composableLambda11 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1540996038, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, 708874428, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
                int i1115 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                int i1116 = i3 >> 6;
                InterfaceC0526Fp interfaceC0526Fp119 = interfaceC0526Fp5;
                InterfaceC0526Fp interfaceC0526Fp1110 = interfaceC0526Fp6;
                m1878TabbogVsAg(z, interfaceC3588op, modifier3, z4, jM3042unboximpl, j4, mutableInteractionSource2, composableLambda11, composerStartRestartGroup, i1115 | (57344 & i1116) | (458752 & i1116) | (i1116 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp7 = interfaceC0526Fp1110;
                modifier4 = modifier3;
                interfaceC0526Fp8 = interfaceC0526Fp119;
                z5 = z4;
                j5 = jM3042unboximpl;
                j6 = j4;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$3(z, interfaceC3588op, modifier4, z5, interfaceC0526Fp7, interfaceC0526Fp8, j5, j6, mutableInteractionSource3, i, i2));
        }
        i3 |= 3072;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                interfaceC0526Fp3 = interfaceC0526Fp2;
            } else {
                interfaceC0526Fp3 = interfaceC0526Fp2;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
            }
            if ((i & 3670016) != 0) {
                if ((i2 & 64) == 0) {
                    i13 = 524288;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            if ((i & 29360128) == 0) {
                j3 = j2;
                if ((i2 & 128) == 0) {
                    i12 = 4194304;
                } else {
                    i12 = 4194304;
                }
                i3 |= i12;
            } else {
                j3 = j2;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
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
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp3 = null;
                    }
                    if ((i2 & 64) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i3 &= -3670017;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                        j3 = jM3042unboximpl;
                    }
                    if (i10 != 0) {
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
                    modifier3 = modifier2;
                    z4 = z3;
                    j4 = j3;
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp3 = null;
                    }
                    if ((i2 & 64) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i3 &= -3670017;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                        j3 = jM3042unboximpl;
                    }
                    if (i10 != 0) {
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
                    modifier3 = modifier2;
                    z4 = z3;
                    j4 = j3;
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-350627181, i3, -1, "androidx.compose.material3.Tab (Tab.kt:92)");
                }
                ComposableLambda composableLambda12 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1540996038, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, 708874428, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
                int i1117 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                int i1118 = i3 >> 6;
                InterfaceC0526Fp interfaceC0526Fp1111 = interfaceC0526Fp5;
                InterfaceC0526Fp interfaceC0526Fp1112 = interfaceC0526Fp6;
                m1878TabbogVsAg(z, interfaceC3588op, modifier3, z4, jM3042unboximpl, j4, mutableInteractionSource2, composableLambda12, composerStartRestartGroup, i1117 | (57344 & i1118) | (458752 & i1118) | (i1118 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp7 = interfaceC0526Fp1112;
                modifier4 = modifier3;
                interfaceC0526Fp8 = interfaceC0526Fp1111;
                z5 = z4;
                j5 = jM3042unboximpl;
                j6 = j4;
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
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp3 = null;
                    }
                    if ((i2 & 64) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i3 &= -3670017;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                        j3 = jM3042unboximpl;
                    }
                    if (i10 != 0) {
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
                    modifier3 = modifier2;
                    z4 = z3;
                    j4 = j3;
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp3 = null;
                    }
                    if ((i2 & 64) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i3 &= -3670017;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                        j3 = jM3042unboximpl;
                    }
                    if (i10 != 0) {
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
                    modifier3 = modifier2;
                    z4 = z3;
                    j4 = j3;
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-350627181, i3, -1, "androidx.compose.material3.Tab (Tab.kt:92)");
                }
                ComposableLambda composableLambda13 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1540996038, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, 708874428, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
                int i1119 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                int i11110 = i3 >> 6;
                InterfaceC0526Fp interfaceC0526Fp1113 = interfaceC0526Fp5;
                InterfaceC0526Fp interfaceC0526Fp1114 = interfaceC0526Fp6;
                m1878TabbogVsAg(z, interfaceC3588op, modifier3, z4, jM3042unboximpl, j4, mutableInteractionSource2, composableLambda13, composerStartRestartGroup, i1119 | (57344 & i11110) | (458752 & i11110) | (i11110 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp7 = interfaceC0526Fp1114;
                modifier4 = modifier3;
                interfaceC0526Fp8 = interfaceC0526Fp1113;
                z5 = z4;
                j5 = jM3042unboximpl;
                j6 = j4;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$3(z, interfaceC3588op, modifier4, z5, interfaceC0526Fp7, interfaceC0526Fp8, j5, j6, mutableInteractionSource3, i, i2));
        }
        i3 |= 24576;
        i8 = i2 & 32;
        if (i8 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            interfaceC0526Fp3 = interfaceC0526Fp2;
        } else {
            interfaceC0526Fp3 = interfaceC0526Fp2;
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
        }
        if ((i & 3670016) != 0) {
            if ((i2 & 64) == 0) {
                i13 = 524288;
            } else {
                i13 = 524288;
            }
            i3 |= i13;
        }
        if ((i & 29360128) == 0) {
            j3 = j2;
            if ((i2 & 128) == 0) {
                i12 = 4194304;
            } else {
                i12 = 4194304;
            }
            i3 |= i12;
        } else {
            j3 = j2;
        }
        i10 = i2 & 256;
        if (i10 != 0) {
            i3 |= 100663296;
        } else if ((i & 234881024) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i11 = 67108864;
            } else {
                i11 = 33554432;
            }
            i3 |= i11;
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
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp;
                }
                if (i8 != 0) {
                    interfaceC0526Fp3 = null;
                }
                if ((i2 & 64) != 0) {
                    jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                    i3 &= -3670017;
                } else {
                    jM3042unboximpl = j;
                }
                if ((i2 & 128) != 0) {
                    i3 &= -29360129;
                    j3 = jM3042unboximpl;
                }
                if (i10 != 0) {
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
                modifier3 = modifier2;
                z4 = z3;
                j4 = j3;
                interfaceC0526Fp5 = interfaceC0526Fp3;
                interfaceC0526Fp6 = interfaceC0526Fp4;
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp;
                }
                if (i8 != 0) {
                    interfaceC0526Fp3 = null;
                }
                if ((i2 & 64) != 0) {
                    jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                    i3 &= -3670017;
                } else {
                    jM3042unboximpl = j;
                }
                if ((i2 & 128) != 0) {
                    i3 &= -29360129;
                    j3 = jM3042unboximpl;
                }
                if (i10 != 0) {
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
                modifier3 = modifier2;
                z4 = z3;
                j4 = j3;
                interfaceC0526Fp5 = interfaceC0526Fp3;
                interfaceC0526Fp6 = interfaceC0526Fp4;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-350627181, i3, -1, "androidx.compose.material3.Tab (Tab.kt:92)");
            }
            ComposableLambda composableLambda14 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1540996038, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, 708874428, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
            int i11111 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
            int i11112 = i3 >> 6;
            InterfaceC0526Fp interfaceC0526Fp1115 = interfaceC0526Fp5;
            InterfaceC0526Fp interfaceC0526Fp1116 = interfaceC0526Fp6;
            m1878TabbogVsAg(z, interfaceC3588op, modifier3, z4, jM3042unboximpl, j4, mutableInteractionSource2, composableLambda14, composerStartRestartGroup, i11111 | (57344 & i11112) | (458752 & i11112) | (i11112 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC0526Fp7 = interfaceC0526Fp1116;
            modifier4 = modifier3;
            interfaceC0526Fp8 = interfaceC0526Fp1115;
            z5 = z4;
            j5 = jM3042unboximpl;
            j6 = j4;
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
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp;
                }
                if (i8 != 0) {
                    interfaceC0526Fp3 = null;
                }
                if ((i2 & 64) != 0) {
                    jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                    i3 &= -3670017;
                } else {
                    jM3042unboximpl = j;
                }
                if ((i2 & 128) != 0) {
                    i3 &= -29360129;
                    j3 = jM3042unboximpl;
                }
                if (i10 != 0) {
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
                modifier3 = modifier2;
                z4 = z3;
                j4 = j3;
                interfaceC0526Fp5 = interfaceC0526Fp3;
                interfaceC0526Fp6 = interfaceC0526Fp4;
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp;
                }
                if (i8 != 0) {
                    interfaceC0526Fp3 = null;
                }
                if ((i2 & 64) != 0) {
                    jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                    i3 &= -3670017;
                } else {
                    jM3042unboximpl = j;
                }
                if ((i2 & 128) != 0) {
                    i3 &= -29360129;
                    j3 = jM3042unboximpl;
                }
                if (i10 != 0) {
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
                modifier3 = modifier2;
                z4 = z3;
                j4 = j3;
                interfaceC0526Fp5 = interfaceC0526Fp3;
                interfaceC0526Fp6 = interfaceC0526Fp4;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-350627181, i3, -1, "androidx.compose.material3.Tab (Tab.kt:92)");
            }
            ComposableLambda composableLambda15 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1540996038, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, 708874428, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
            int i11113 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
            int i11114 = i3 >> 6;
            InterfaceC0526Fp interfaceC0526Fp1117 = interfaceC0526Fp5;
            InterfaceC0526Fp interfaceC0526Fp1118 = interfaceC0526Fp6;
            m1878TabbogVsAg(z, interfaceC3588op, modifier3, z4, jM3042unboximpl, j4, mutableInteractionSource2, composableLambda15, composerStartRestartGroup, i11113 | (57344 & i11114) | (458752 & i11114) | (i11114 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC0526Fp7 = interfaceC0526Fp1118;
            modifier4 = modifier3;
            interfaceC0526Fp8 = interfaceC0526Fp1117;
            z5 = z4;
            j5 = jM3042unboximpl;
            j6 = j4;
            mutableInteractionSource3 = mutableInteractionSource2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$3(z, interfaceC3588op, modifier4, z5, interfaceC0526Fp7, interfaceC0526Fp8, j5, j6, mutableInteractionSource3, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void TabBaselineLayout(final InterfaceC0526Fp interfaceC0526Fp, final InterfaceC0526Fp interfaceC0526Fp2, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(514131524);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp2) ? 32 : 16;
        }
        if ((i2 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(514131524, i2, -1, "androidx.compose.material3.TabBaselineLayout (Tab.kt:303)");
            }
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material3.TabKt.TabBaselineLayout.2
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
                public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                    Placeable placeableMo4159measureBRTryo0;
                    Placeable placeableMo4159measureBRTryo1;
                    Measurable measurable;
                    Measurable measurable2;
                    AbstractC4492zt.h(measureScope, "$this$Layout");
                    AbstractC4492zt.h(list, "measurables");
                    if (interfaceC0526Fp != null) {
                        Iterator<T> it = list.iterator();
                        do {
                            if (!it.hasNext()) {
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                            measurable2 = (Measurable) it.next();
                        } while (!AbstractC4492zt.d(LayoutIdKt.getLayoutId(measurable2), "text"));
                        placeableMo4159measureBRTryo0 = measurable2.mo4159measureBRTryo0(Constraints.m5119copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                    } else {
                        placeableMo4159measureBRTryo0 = null;
                    }
                    if (interfaceC0526Fp2 != null) {
                        Iterator<T> it2 = list.iterator();
                        do {
                            if (!it2.hasNext()) {
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                            measurable = (Measurable) it2.next();
                        } while (!AbstractC4492zt.d(LayoutIdKt.getLayoutId(measurable), "icon"));
                        placeableMo4159measureBRTryo1 = measurable.mo4159measureBRTryo0(j);
                    } else {
                        placeableMo4159measureBRTryo1 = null;
                    }
                    int iMax = Math.max(placeableMo4159measureBRTryo0 != null ? placeableMo4159measureBRTryo0.getWidth() : 0, placeableMo4159measureBRTryo1 != null ? placeableMo4159measureBRTryo1.getWidth() : 0);
                    int iMax2 = Math.max(measureScope.mo327roundToPx0680j_4((placeableMo4159measureBRTryo0 == null || placeableMo4159measureBRTryo1 == null) ? TabKt.SmallTabHeight : TabKt.LargeTabHeight), (placeableMo4159measureBRTryo1 != null ? placeableMo4159measureBRTryo1.getHeight() : 0) + (placeableMo4159measureBRTryo0 != null ? placeableMo4159measureBRTryo0.getHeight() : 0) + measureScope.mo326roundToPxR2X_6o(TabKt.IconDistanceFromBaseline));
                    return MeasureScope.CC.q(measureScope, iMax, iMax2, null, new TabKt$TabBaselineLayout$2$measure$1(placeableMo4159measureBRTryo0, placeableMo4159measureBRTryo1, measureScope, iMax, iMax2, placeableMo4159measureBRTryo0 != null ? Integer.valueOf(placeableMo4159measureBRTryo0.get(AlignmentLineKt.getFirstBaseline())) : null, placeableMo4159measureBRTryo0 != null ? Integer.valueOf(placeableMo4159measureBRTryo0.get(AlignmentLineKt.getLastBaseline())) : null), 4, null);
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
            Modifier.Companion companion = Modifier.Companion;
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(companion);
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
            composerStartRestartGroup.startReplaceableGroup(720851189);
            if (interfaceC0526Fp != null) {
                Modifier modifierM487paddingVpY3zN4$default = PaddingKt.m487paddingVpY3zN4$default(LayoutIdKt.layoutId(companion, "text"), HorizontalTextPadding, 0.0f, 2, null);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composerStartRestartGroup, 0);
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
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(150513216);
            if (interfaceC0526Fp2 != null) {
                Modifier modifierLayoutId = LayoutIdKt.layoutId(companion, "icon");
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composerStartRestartGroup, 0);
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
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
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
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC0526Fp, interfaceC0526Fp2, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    /* JADX INFO: renamed from: TabTransition-Klgx-Pg, reason: not valid java name */
    public static final void m1880TabTransitionKlgxPg(long j, long j2, boolean z, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(735731848);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 2048 : 1024;
        }
        if ((i2 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(735731848, i2, -1, "androidx.compose.material3.TabTransition (Tab.kt:266)");
            }
            int i3 = i2 >> 6;
            Transition transitionUpdateTransition = TransitionKt.updateTransition(Boolean.valueOf(z), (String) null, composerStartRestartGroup, i3 & 14, 2);
            TabKt$TabTransition$color$2 tabKt$TabTransition$color$2 = TabKt$TabTransition$color$2.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-1939694975);
            boolean zBooleanValue = ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(-1997025499);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1997025499, 0, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:288)");
            }
            long j3 = zBooleanValue ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            ColorSpace colorSpaceM3036getColorSpaceimpl = Color.m3036getColorSpaceimpl(j3);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed(colorSpaceM3036getColorSpaceimpl);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpaceM3036getColorSpaceimpl);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            TwoWayConverter twoWayConverter = (TwoWayConverter) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(-142660079);
            boolean zBooleanValue2 = ((Boolean) transitionUpdateTransition.getCurrentState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(-1997025499);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1997025499, 0, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:288)");
            }
            long j4 = zBooleanValue2 ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            Color colorM3022boximpl = Color.m3022boximpl(j4);
            boolean zBooleanValue3 = ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(-1997025499);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1997025499, 0, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:288)");
            }
            long j5 = zBooleanValue3 ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM3022boximpl, Color.m3022boximpl(j5), (FiniteAnimationSpec) tabKt$TabTransition$color$2.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), twoWayConverter, "ColorAnimation", composerStartRestartGroup, 32768);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(TabTransition_Klgx_Pg$lambda$5(stateCreateTransitionAnimation)))}, interfaceC0526Fp, composerStartRestartGroup, (i3 & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$TabTransition$1(j, j2, z, interfaceC0526Fp, i));
    }

    private static final long TabTransition_Klgx_Pg$lambda$5(State<Color> state) {
        return state.getValue().m3042unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeTextAndIcon(Placeable.PlacementScope placementScope, Density density, Placeable placeable, Placeable placeable2, int i, int i2, int i3, int i4) {
        int iMo327roundToPx0680j_4 = density.mo327roundToPx0680j_4(i3 == i4 ? SingleLineTextBaselineWithIcon : DoubleLineTextBaselineWithIcon) + density.mo327roundToPx0680j_4(PrimaryNavigationTabTokens.INSTANCE.m2481getActiveIndicatorHeightD9Ej5fM());
        int height = (placeable2.getHeight() + density.mo326roundToPxR2X_6o(IconDistanceFromBaseline)) - i3;
        int i5 = (i2 - i4) - iMo327roundToPx0680j_4;
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, (i - placeable.getWidth()) / 2, i5, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, (i - placeable2.getWidth()) / 2, i5 - height, 0.0f, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeTextOrIcon(Placeable.PlacementScope placementScope, Placeable placeable, int i) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, (i - placeable.getHeight()) / 2, 0.0f, 4, null);
    }
}
