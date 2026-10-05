package androidx.compose.material;

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
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
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
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
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
    private static final float SmallTabHeight = Dp.m5160constructorimpl(48);
    private static final float LargeTabHeight = Dp.m5160constructorimpl(72);
    private static final float HorizontalTextPadding = Dp.m5160constructorimpl(16);
    private static final float SingleLineTextBaselineWithIcon = Dp.m5160constructorimpl(14);
    private static final float DoubleLineTextBaselineWithIcon = Dp.m5160constructorimpl(6);
    private static final long IconDistanceFromBaseline = TextUnitKt.getSp(20);
    private static final float TextDistanceFromLeadingIcon = Dp.m5160constructorimpl(8);

    /* JADX INFO: renamed from: androidx.compose.material.TabKt$TabBaselineLayout$3, reason: invalid class name */
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

    /* JADX WARN: Code duplicated, block: B:102:0x0132  */
    /* JADX WARN: Code duplicated, block: B:104:0x013d  */
    /* JADX WARN: Code duplicated, block: B:114:0x0164 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:115:0x0166  */
    /* JADX WARN: Code duplicated, block: B:117:0x016b  */
    /* JADX WARN: Code duplicated, block: B:119:0x016e  */
    /* JADX WARN: Code duplicated, block: B:121:0x0180  */
    /* JADX WARN: Code duplicated, block: B:125:0x0191  */
    /* JADX WARN: Code duplicated, block: B:126:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:129:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:131:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:134:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:137:0x024c  */
    /* JADX WARN: Code duplicated, block: B:142:0x0260  */
    /* JADX WARN: Code duplicated, block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:78:0x00de  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:88:0x0100  */
    /* JADX WARN: Code duplicated, block: B:90:0x0106  */
    /* JADX WARN: Code duplicated, block: B:93:0x010f  */
    /* JADX WARN: Code duplicated, block: B:95:0x0114  */
    /* JADX WARN: Code duplicated, block: B:98:0x0120  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: LeadingIconTab-0nD-MI0, reason: not valid java name */
    public static final void m1244LeadingIconTab0nDMI0(boolean z, InterfaceC3588op interfaceC3588op, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, long j, long j2, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        int i8;
        long jM3042unboximpl;
        long jM3031copywmQWz5c$default;
        int i9;
        MutableInteractionSource mutableInteractionSource3;
        Object objRememberedValue;
        Modifier modifier3;
        boolean z4;
        long j3;
        long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i10;
        int i11;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0526Fp, "text");
        AbstractC4492zt.h(interfaceC0526Fp2, "icon");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1499861761);
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
        int i12 = i2 & 16;
        if (i12 == 0) {
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
                i6 = i2 & 64;
                if (i6 != 0) {
                    if ((3670016 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i7 = 1048576;
                        } else {
                            i7 = 524288;
                        }
                        i3 |= i7;
                    }
                    if ((29360128 & i) == 0) {
                        int i13 = i3;
                        if ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j)) {
                            i11 = 4194304;
                        } else {
                            i11 = 8388608;
                        }
                        i8 = i13 | i11;
                    } else {
                        i8 = i3;
                    }
                    if ((i & 234881024) != 0) {
                        if ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j2)) {
                            i10 = 33554432;
                        } else {
                            i10 = 67108864;
                        }
                        i8 |= i10;
                    }
                    if ((i8 & 191739611) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i12 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if ((i2 & 128) != 0) {
                                jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                                i8 &= -29360129;
                            } else {
                                jM3042unboximpl = j;
                            }
                            if ((i2 & 256) != 0) {
                                i9 = i8 & (-234881025);
                                jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            } else {
                                jM3031copywmQWz5c$default = j2;
                                i9 = i8;
                            }
                            mutableInteractionSource3 = mutableInteractionSource2;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 128) != 0) {
                                i8 &= -29360129;
                            }
                            if ((i2 & 256) != 0) {
                                i8 &= -234881025;
                            }
                            jM3042unboximpl = j;
                            jM3031copywmQWz5c$default = j2;
                            z3 = z3;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            i9 = i8;
                            modifier2 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1499861761, i9, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:151)");
                        }
                        int i14 = i9;
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 866677691, true, new TabKt$LeadingIconTab$2(modifier2, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i9 >> 15) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0526Fp2, i9, interfaceC0526Fp));
                        int i15 = i14 >> 21;
                        m1247TabTransitionKlgxPg(jM3042unboximpl, jM3031copywmQWz5c$default, z, composableLambda, composerStartRestartGroup, (i15 & 112) | (i15 & 14) | 3072 | ((i14 << 6) & 896));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        z4 = z3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        j3 = jM3042unboximpl;
                        j4 = jM3031copywmQWz5c$default;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        j3 = j;
                        j4 = j2;
                        z4 = z3;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$LeadingIconTab$3(z, interfaceC3588op, interfaceC0526Fp, interfaceC0526Fp2, modifier3, z4, mutableInteractionSource2, j3, j4, i, i2));
                }
                i3 |= 1572864;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((29360128 & i) == 0) {
                    int i16 = i3;
                    if ((i2 & 128) == 0) {
                        i11 = 4194304;
                    } else {
                        i11 = 4194304;
                    }
                    i8 = i16 | i11;
                } else {
                    i8 = i3;
                }
                if ((i & 234881024) != 0) {
                    if ((i2 & 256) == 0) {
                        i10 = 33554432;
                    } else {
                        i10 = 33554432;
                    }
                    i8 |= i10;
                }
                if ((i8 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 128) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -29360129;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            i9 = i8 & (-234881025);
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jM3031copywmQWz5c$default = j2;
                            i9 = i8;
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 128) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -29360129;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            i9 = i8 & (-234881025);
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jM3031copywmQWz5c$default = j2;
                            i9 = i8;
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1499861761, i9, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:151)");
                    }
                    int i17 = i9;
                    ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 866677691, true, new TabKt$LeadingIconTab$2(modifier2, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i9 >> 15) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0526Fp2, i9, interfaceC0526Fp));
                    int i18 = i17 >> 21;
                    m1247TabTransitionKlgxPg(jM3042unboximpl, jM3031copywmQWz5c$default, z, composableLambda2, composerStartRestartGroup, (i18 & 112) | (i18 & 14) | 3072 | ((i17 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    z4 = z3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    j3 = jM3042unboximpl;
                    j4 = jM3031copywmQWz5c$default;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 128) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -29360129;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            i9 = i8 & (-234881025);
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jM3031copywmQWz5c$default = j2;
                            i9 = i8;
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 128) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -29360129;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            i9 = i8 & (-234881025);
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jM3031copywmQWz5c$default = j2;
                            i9 = i8;
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1499861761, i9, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:151)");
                    }
                    int i19 = i9;
                    ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 866677691, true, new TabKt$LeadingIconTab$2(modifier2, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i9 >> 15) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0526Fp2, i9, interfaceC0526Fp));
                    int i110 = i19 >> 21;
                    m1247TabTransitionKlgxPg(jM3042unboximpl, jM3031copywmQWz5c$default, z, composableLambda3, composerStartRestartGroup, (i110 & 112) | (i110 & 14) | 3072 | ((i19 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    z4 = z3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    j3 = jM3042unboximpl;
                    j4 = jM3031copywmQWz5c$default;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$LeadingIconTab$3(z, interfaceC3588op, interfaceC0526Fp, interfaceC0526Fp2, modifier3, z4, mutableInteractionSource2, j3, j4, i, i2));
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z3 = z2;
            i6 = i2 & 64;
            if (i6 != 0) {
                if ((3670016 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
                if ((29360128 & i) == 0) {
                    int i111 = i3;
                    if ((i2 & 128) == 0) {
                        i11 = 4194304;
                    } else {
                        i11 = 4194304;
                    }
                    i8 = i111 | i11;
                } else {
                    i8 = i3;
                }
                if ((i & 234881024) != 0) {
                    if ((i2 & 256) == 0) {
                        i10 = 33554432;
                    } else {
                        i10 = 33554432;
                    }
                    i8 |= i10;
                }
                if ((i8 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 128) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -29360129;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            i9 = i8 & (-234881025);
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jM3031copywmQWz5c$default = j2;
                            i9 = i8;
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 128) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -29360129;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            i9 = i8 & (-234881025);
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jM3031copywmQWz5c$default = j2;
                            i9 = i8;
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1499861761, i9, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:151)");
                    }
                    int i112 = i9;
                    ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 866677691, true, new TabKt$LeadingIconTab$2(modifier2, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i9 >> 15) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0526Fp2, i9, interfaceC0526Fp));
                    int i113 = i112 >> 21;
                    m1247TabTransitionKlgxPg(jM3042unboximpl, jM3031copywmQWz5c$default, z, composableLambda4, composerStartRestartGroup, (i113 & 112) | (i113 & 14) | 3072 | ((i112 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    z4 = z3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    j3 = jM3042unboximpl;
                    j4 = jM3031copywmQWz5c$default;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 128) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -29360129;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            i9 = i8 & (-234881025);
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jM3031copywmQWz5c$default = j2;
                            i9 = i8;
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 128) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -29360129;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            i9 = i8 & (-234881025);
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jM3031copywmQWz5c$default = j2;
                            i9 = i8;
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1499861761, i9, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:151)");
                    }
                    int i114 = i9;
                    ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 866677691, true, new TabKt$LeadingIconTab$2(modifier2, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i9 >> 15) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0526Fp2, i9, interfaceC0526Fp));
                    int i115 = i114 >> 21;
                    m1247TabTransitionKlgxPg(jM3042unboximpl, jM3031copywmQWz5c$default, z, composableLambda5, composerStartRestartGroup, (i115 & 112) | (i115 & 14) | 3072 | ((i114 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    z4 = z3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    j3 = jM3042unboximpl;
                    j4 = jM3031copywmQWz5c$default;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$LeadingIconTab$3(z, interfaceC3588op, interfaceC0526Fp, interfaceC0526Fp2, modifier3, z4, mutableInteractionSource2, j3, j4, i, i2));
            }
            i3 |= 1572864;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((29360128 & i) == 0) {
                int i116 = i3;
                if ((i2 & 128) == 0) {
                    i11 = 4194304;
                } else {
                    i11 = 4194304;
                }
                i8 = i116 | i11;
            } else {
                i8 = i3;
            }
            if ((i & 234881024) != 0) {
                if ((i2 & 256) == 0) {
                    i10 = 33554432;
                } else {
                    i10 = 33554432;
                }
                i8 |= i10;
            }
            if ((i8 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 128) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -29360129;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        i9 = i8 & (-234881025);
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j2;
                        i9 = i8;
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 128) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -29360129;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        i9 = i8 & (-234881025);
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j2;
                        i9 = i8;
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1499861761, i9, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:151)");
                }
                int i117 = i9;
                ComposableLambda composableLambda6 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 866677691, true, new TabKt$LeadingIconTab$2(modifier2, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i9 >> 15) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0526Fp2, i9, interfaceC0526Fp));
                int i118 = i117 >> 21;
                m1247TabTransitionKlgxPg(jM3042unboximpl, jM3031copywmQWz5c$default, z, composableLambda6, composerStartRestartGroup, (i118 & 112) | (i118 & 14) | 3072 | ((i117 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                z4 = z3;
                mutableInteractionSource2 = mutableInteractionSource3;
                j3 = jM3042unboximpl;
                j4 = jM3031copywmQWz5c$default;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 128) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -29360129;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        i9 = i8 & (-234881025);
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j2;
                        i9 = i8;
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 128) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -29360129;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        i9 = i8 & (-234881025);
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j2;
                        i9 = i8;
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1499861761, i9, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:151)");
                }
                int i119 = i9;
                ComposableLambda composableLambda7 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 866677691, true, new TabKt$LeadingIconTab$2(modifier2, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i9 >> 15) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0526Fp2, i9, interfaceC0526Fp));
                int i1110 = i119 >> 21;
                m1247TabTransitionKlgxPg(jM3042unboximpl, jM3031copywmQWz5c$default, z, composableLambda7, composerStartRestartGroup, (i1110 & 112) | (i1110 & 14) | 3072 | ((i119 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                z4 = z3;
                mutableInteractionSource2 = mutableInteractionSource3;
                j3 = jM3042unboximpl;
                j4 = jM3031copywmQWz5c$default;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$LeadingIconTab$3(z, interfaceC3588op, interfaceC0526Fp, interfaceC0526Fp2, modifier3, z4, mutableInteractionSource2, j3, j4, i, i2));
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
            i6 = i2 & 64;
            if (i6 != 0) {
                if ((3670016 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
                if ((29360128 & i) == 0) {
                    int i1111 = i3;
                    if ((i2 & 128) == 0) {
                        i11 = 4194304;
                    } else {
                        i11 = 4194304;
                    }
                    i8 = i1111 | i11;
                } else {
                    i8 = i3;
                }
                if ((i & 234881024) != 0) {
                    if ((i2 & 256) == 0) {
                        i10 = 33554432;
                    } else {
                        i10 = 33554432;
                    }
                    i8 |= i10;
                }
                if ((i8 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 128) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -29360129;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            i9 = i8 & (-234881025);
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jM3031copywmQWz5c$default = j2;
                            i9 = i8;
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 128) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -29360129;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            i9 = i8 & (-234881025);
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jM3031copywmQWz5c$default = j2;
                            i9 = i8;
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1499861761, i9, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:151)");
                    }
                    int i1112 = i9;
                    ComposableLambda composableLambda8 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 866677691, true, new TabKt$LeadingIconTab$2(modifier2, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i9 >> 15) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0526Fp2, i9, interfaceC0526Fp));
                    int i1113 = i1112 >> 21;
                    m1247TabTransitionKlgxPg(jM3042unboximpl, jM3031copywmQWz5c$default, z, composableLambda8, composerStartRestartGroup, (i1113 & 112) | (i1113 & 14) | 3072 | ((i1112 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    z4 = z3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    j3 = jM3042unboximpl;
                    j4 = jM3031copywmQWz5c$default;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 128) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -29360129;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            i9 = i8 & (-234881025);
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jM3031copywmQWz5c$default = j2;
                            i9 = i8;
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 128) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -29360129;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            i9 = i8 & (-234881025);
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jM3031copywmQWz5c$default = j2;
                            i9 = i8;
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1499861761, i9, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:151)");
                    }
                    int i1114 = i9;
                    ComposableLambda composableLambda9 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 866677691, true, new TabKt$LeadingIconTab$2(modifier2, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i9 >> 15) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0526Fp2, i9, interfaceC0526Fp));
                    int i1115 = i1114 >> 21;
                    m1247TabTransitionKlgxPg(jM3042unboximpl, jM3031copywmQWz5c$default, z, composableLambda9, composerStartRestartGroup, (i1115 & 112) | (i1115 & 14) | 3072 | ((i1114 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    z4 = z3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    j3 = jM3042unboximpl;
                    j4 = jM3031copywmQWz5c$default;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$LeadingIconTab$3(z, interfaceC3588op, interfaceC0526Fp, interfaceC0526Fp2, modifier3, z4, mutableInteractionSource2, j3, j4, i, i2));
            }
            i3 |= 1572864;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((29360128 & i) == 0) {
                int i1116 = i3;
                if ((i2 & 128) == 0) {
                    i11 = 4194304;
                } else {
                    i11 = 4194304;
                }
                i8 = i1116 | i11;
            } else {
                i8 = i3;
            }
            if ((i & 234881024) != 0) {
                if ((i2 & 256) == 0) {
                    i10 = 33554432;
                } else {
                    i10 = 33554432;
                }
                i8 |= i10;
            }
            if ((i8 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 128) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -29360129;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        i9 = i8 & (-234881025);
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j2;
                        i9 = i8;
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 128) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -29360129;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        i9 = i8 & (-234881025);
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j2;
                        i9 = i8;
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1499861761, i9, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:151)");
                }
                int i1117 = i9;
                ComposableLambda composableLambda10 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 866677691, true, new TabKt$LeadingIconTab$2(modifier2, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i9 >> 15) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0526Fp2, i9, interfaceC0526Fp));
                int i1118 = i1117 >> 21;
                m1247TabTransitionKlgxPg(jM3042unboximpl, jM3031copywmQWz5c$default, z, composableLambda10, composerStartRestartGroup, (i1118 & 112) | (i1118 & 14) | 3072 | ((i1117 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                z4 = z3;
                mutableInteractionSource2 = mutableInteractionSource3;
                j3 = jM3042unboximpl;
                j4 = jM3031copywmQWz5c$default;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 128) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -29360129;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        i9 = i8 & (-234881025);
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j2;
                        i9 = i8;
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 128) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -29360129;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        i9 = i8 & (-234881025);
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j2;
                        i9 = i8;
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1499861761, i9, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:151)");
                }
                int i1119 = i9;
                ComposableLambda composableLambda11 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 866677691, true, new TabKt$LeadingIconTab$2(modifier2, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i9 >> 15) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0526Fp2, i9, interfaceC0526Fp));
                int i11110 = i1119 >> 21;
                m1247TabTransitionKlgxPg(jM3042unboximpl, jM3031copywmQWz5c$default, z, composableLambda11, composerStartRestartGroup, (i11110 & 112) | (i11110 & 14) | 3072 | ((i1119 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                z4 = z3;
                mutableInteractionSource2 = mutableInteractionSource3;
                j3 = jM3042unboximpl;
                j4 = jM3031copywmQWz5c$default;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$LeadingIconTab$3(z, interfaceC3588op, interfaceC0526Fp, interfaceC0526Fp2, modifier3, z4, mutableInteractionSource2, j3, j4, i, i2));
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z3 = z2;
        i6 = i2 & 64;
        if (i6 != 0) {
            if ((3670016 & i) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
            if ((29360128 & i) == 0) {
                int i11111 = i3;
                if ((i2 & 128) == 0) {
                    i11 = 4194304;
                } else {
                    i11 = 4194304;
                }
                i8 = i11111 | i11;
            } else {
                i8 = i3;
            }
            if ((i & 234881024) != 0) {
                if ((i2 & 256) == 0) {
                    i10 = 33554432;
                } else {
                    i10 = 33554432;
                }
                i8 |= i10;
            }
            if ((i8 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 128) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -29360129;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        i9 = i8 & (-234881025);
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j2;
                        i9 = i8;
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 128) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -29360129;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        i9 = i8 & (-234881025);
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j2;
                        i9 = i8;
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1499861761, i9, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:151)");
                }
                int i11112 = i9;
                ComposableLambda composableLambda12 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 866677691, true, new TabKt$LeadingIconTab$2(modifier2, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i9 >> 15) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0526Fp2, i9, interfaceC0526Fp));
                int i11113 = i11112 >> 21;
                m1247TabTransitionKlgxPg(jM3042unboximpl, jM3031copywmQWz5c$default, z, composableLambda12, composerStartRestartGroup, (i11113 & 112) | (i11113 & 14) | 3072 | ((i11112 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                z4 = z3;
                mutableInteractionSource2 = mutableInteractionSource3;
                j3 = jM3042unboximpl;
                j4 = jM3031copywmQWz5c$default;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 128) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -29360129;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        i9 = i8 & (-234881025);
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j2;
                        i9 = i8;
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 128) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -29360129;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        i9 = i8 & (-234881025);
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j2;
                        i9 = i8;
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1499861761, i9, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:151)");
                }
                int i11114 = i9;
                ComposableLambda composableLambda13 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 866677691, true, new TabKt$LeadingIconTab$2(modifier2, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i9 >> 15) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0526Fp2, i9, interfaceC0526Fp));
                int i11115 = i11114 >> 21;
                m1247TabTransitionKlgxPg(jM3042unboximpl, jM3031copywmQWz5c$default, z, composableLambda13, composerStartRestartGroup, (i11115 & 112) | (i11115 & 14) | 3072 | ((i11114 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                z4 = z3;
                mutableInteractionSource2 = mutableInteractionSource3;
                j3 = jM3042unboximpl;
                j4 = jM3031copywmQWz5c$default;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$LeadingIconTab$3(z, interfaceC3588op, interfaceC0526Fp, interfaceC0526Fp2, modifier3, z4, mutableInteractionSource2, j3, j4, i, i2));
        }
        i3 |= 1572864;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((29360128 & i) == 0) {
            int i11116 = i3;
            if ((i2 & 128) == 0) {
                i11 = 4194304;
            } else {
                i11 = 4194304;
            }
            i8 = i11116 | i11;
        } else {
            i8 = i3;
        }
        if ((i & 234881024) != 0) {
            if ((i2 & 256) == 0) {
                i10 = 33554432;
            } else {
                i10 = 33554432;
            }
            i8 |= i10;
        }
        if ((i8 & 191739611) == 38347922) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if ((i2 & 128) != 0) {
                    jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                    i8 &= -29360129;
                } else {
                    jM3042unboximpl = j;
                }
                if ((i2 & 256) != 0) {
                    i9 = i8 & (-234881025);
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jM3031copywmQWz5c$default = j2;
                    i9 = i8;
                }
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if ((i2 & 128) != 0) {
                    jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                    i8 &= -29360129;
                } else {
                    jM3042unboximpl = j;
                }
                if ((i2 & 256) != 0) {
                    i9 = i8 & (-234881025);
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jM3031copywmQWz5c$default = j2;
                    i9 = i8;
                }
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1499861761, i9, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:151)");
            }
            int i11117 = i9;
            ComposableLambda composableLambda14 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 866677691, true, new TabKt$LeadingIconTab$2(modifier2, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i9 >> 15) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0526Fp2, i9, interfaceC0526Fp));
            int i11118 = i11117 >> 21;
            m1247TabTransitionKlgxPg(jM3042unboximpl, jM3031copywmQWz5c$default, z, composableLambda14, composerStartRestartGroup, (i11118 & 112) | (i11118 & 14) | 3072 | ((i11117 << 6) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            z4 = z3;
            mutableInteractionSource2 = mutableInteractionSource3;
            j3 = jM3042unboximpl;
            j4 = jM3031copywmQWz5c$default;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if ((i2 & 128) != 0) {
                    jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                    i8 &= -29360129;
                } else {
                    jM3042unboximpl = j;
                }
                if ((i2 & 256) != 0) {
                    i9 = i8 & (-234881025);
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jM3031copywmQWz5c$default = j2;
                    i9 = i8;
                }
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if ((i2 & 128) != 0) {
                    jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                    i8 &= -29360129;
                } else {
                    jM3042unboximpl = j;
                }
                if ((i2 & 256) != 0) {
                    i9 = i8 & (-234881025);
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jM3031copywmQWz5c$default = j2;
                    i9 = i8;
                }
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1499861761, i9, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:151)");
            }
            int i11119 = i9;
            ComposableLambda composableLambda15 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 866677691, true, new TabKt$LeadingIconTab$2(modifier2, z, mutableInteractionSource3, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i9 >> 15) & 896) | 6, 2), z3, interfaceC3588op, interfaceC0526Fp2, i9, interfaceC0526Fp));
            int i111110 = i11119 >> 21;
            m1247TabTransitionKlgxPg(jM3042unboximpl, jM3031copywmQWz5c$default, z, composableLambda15, composerStartRestartGroup, (i111110 & 112) | (i111110 & 14) | 3072 | ((i11119 << 6) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            z4 = z3;
            mutableInteractionSource2 = mutableInteractionSource3;
            j3 = jM3042unboximpl;
            j4 = jM3031copywmQWz5c$default;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$LeadingIconTab$3(z, interfaceC3588op, interfaceC0526Fp, interfaceC0526Fp2, modifier3, z4, mutableInteractionSource2, j3, j4, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0131  */
    /* JADX WARN: Code duplicated, block: B:104:0x013e  */
    /* JADX WARN: Code duplicated, block: B:114:0x0165 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:115:0x0167  */
    /* JADX WARN: Code duplicated, block: B:116:0x016a  */
    /* JADX WARN: Code duplicated, block: B:118:0x016e  */
    /* JADX WARN: Code duplicated, block: B:120:0x0171  */
    /* JADX WARN: Code duplicated, block: B:121:0x0174  */
    /* JADX WARN: Code duplicated, block: B:123:0x0178  */
    /* JADX WARN: Code duplicated, block: B:125:0x017c  */
    /* JADX WARN: Code duplicated, block: B:127:0x018e  */
    /* JADX WARN: Code duplicated, block: B:129:0x019b  */
    /* JADX WARN: Code duplicated, block: B:132:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:133:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:136:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:138:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:141:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:143:0x0205  */
    /* JADX WARN: Code duplicated, block: B:146:0x0262  */
    /* JADX WARN: Code duplicated, block: B:151:0x027a  */
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
    /* JADX WARN: Code duplicated, block: B:69:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:90:0x0100  */
    /* JADX WARN: Code duplicated, block: B:93:0x0109  */
    /* JADX WARN: Code duplicated, block: B:95:0x010d  */
    /* JADX WARN: Code duplicated, block: B:98:0x0118  */
    /* JADX WARN: Instruction removed from duplicated block: B:102:0x0131, please report this as an issue */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Tab-0nD-MI0, reason: not valid java name */
    public static final void m1245Tab0nDMI0(boolean z, InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z2, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, MutableInteractionSource mutableInteractionSource, long j, long j2, Composer composer, int i, int i2) {
        int i3;
        int i4;
        boolean z3;
        int i5;
        int i6;
        int i7;
        int i8;
        InterfaceC0526Fp interfaceC0526Fp3;
        int i9;
        int i10;
        int i11;
        long j3;
        Modifier modifier2;
        InterfaceC0526Fp interfaceC0526Fp4;
        MutableInteractionSource mutableInteractionSource2;
        long jM3042unboximpl;
        long jM3031copywmQWz5c$default;
        InterfaceC0526Fp interfaceC0526Fp5;
        InterfaceC0526Fp interfaceC0526Fp6;
        Object objRememberedValue;
        Modifier modifier3;
        InterfaceC0526Fp interfaceC0526Fp7;
        boolean z4;
        InterfaceC0526Fp interfaceC0526Fp8;
        MutableInteractionSource mutableInteractionSource3;
        long j4;
        long j5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i12;
        int i13;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1486097588);
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
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
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
                    i10 = i2 & 64;
                    if (i10 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                    if ((i & 29360128) != 0) {
                        if ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j)) {
                            i13 = 4194304;
                        } else {
                            i13 = 8388608;
                        }
                        i3 |= i13;
                    }
                    if ((234881024 & i) == 0) {
                        j3 = j2;
                        if ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j3)) {
                            i12 = 33554432;
                        } else {
                            i12 = 67108864;
                        }
                        i3 |= i12;
                    } else {
                        j3 = j2;
                    }
                    if ((191739611 & i3) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp3 = null;
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
                            if ((i2 & 128) != 0) {
                                jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                                i3 &= -29360129;
                            } else {
                                jM3042unboximpl = j;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                                jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            } else {
                                jM3031copywmQWz5c$default = j3;
                            }
                            interfaceC0526Fp5 = interfaceC0526Fp3;
                            interfaceC0526Fp6 = interfaceC0526Fp4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 128) != 0) {
                                i3 &= -29360129;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                            }
                            modifier2 = modifier;
                            mutableInteractionSource2 = mutableInteractionSource;
                            jM3042unboximpl = j;
                            z3 = z3;
                            jM3031copywmQWz5c$default = j3;
                            interfaceC0526Fp5 = interfaceC0526Fp3;
                            interfaceC0526Fp6 = interfaceC0526Fp;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1486097588, i3, -1, "androidx.compose.material.Tab (Tab.kt:89)");
                        }
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -178151495, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1729014781, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
                        int i15 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                        int i16 = i3 >> 6;
                        InterfaceC0526Fp interfaceC0526Fp9 = interfaceC0526Fp5;
                        InterfaceC0526Fp interfaceC0526Fp10 = interfaceC0526Fp6;
                        m1246TabEVJuX4I(z, interfaceC3588op, modifier2, z3, mutableInteractionSource2, jM3042unboximpl, jM3031copywmQWz5c$default, composableLambda, composerStartRestartGroup, i15 | (57344 & i16) | (458752 & i16) | (i16 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        interfaceC0526Fp7 = interfaceC0526Fp10;
                        z4 = z3;
                        interfaceC0526Fp8 = interfaceC0526Fp9;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        j4 = jM3042unboximpl;
                        j5 = jM3031copywmQWz5c$default;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier;
                        z4 = z3;
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                        interfaceC0526Fp7 = interfaceC0526Fp;
                        j5 = j3;
                        mutableInteractionSource3 = mutableInteractionSource;
                        j4 = j;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$3(z, interfaceC3588op, modifier3, z4, interfaceC0526Fp7, interfaceC0526Fp8, mutableInteractionSource3, j4, j5, i, i2));
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
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i & 29360128) != 0) {
                    if ((i2 & 128) == 0) {
                        i13 = 4194304;
                    } else {
                        i13 = 4194304;
                    }
                    i3 |= i13;
                }
                if ((234881024 & i) == 0) {
                    j3 = j2;
                    if ((i2 & 256) == 0) {
                        i12 = 33554432;
                    } else {
                        i12 = 33554432;
                    }
                    i3 |= i12;
                } else {
                    j3 = j2;
                }
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp3 = null;
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
                        if ((i2 & 128) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i3 &= -29360129;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jM3031copywmQWz5c$default = j3;
                        }
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
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp3 = null;
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
                        if ((i2 & 128) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i3 &= -29360129;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jM3031copywmQWz5c$default = j3;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp3;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1486097588, i3, -1, "androidx.compose.material.Tab (Tab.kt:89)");
                    }
                    ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -178151495, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1729014781, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
                    int i17 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                    int i18 = i3 >> 6;
                    InterfaceC0526Fp interfaceC0526Fp11 = interfaceC0526Fp5;
                    InterfaceC0526Fp interfaceC0526Fp12 = interfaceC0526Fp6;
                    m1246TabEVJuX4I(z, interfaceC3588op, modifier2, z3, mutableInteractionSource2, jM3042unboximpl, jM3031copywmQWz5c$default, composableLambda2, composerStartRestartGroup, i17 | (57344 & i18) | (458752 & i18) | (i18 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    interfaceC0526Fp7 = interfaceC0526Fp12;
                    z4 = z3;
                    interfaceC0526Fp8 = interfaceC0526Fp11;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    j4 = jM3042unboximpl;
                    j5 = jM3031copywmQWz5c$default;
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
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp3 = null;
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
                        if ((i2 & 128) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i3 &= -29360129;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jM3031copywmQWz5c$default = j3;
                        }
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
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp3 = null;
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
                        if ((i2 & 128) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i3 &= -29360129;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jM3031copywmQWz5c$default = j3;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp3;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1486097588, i3, -1, "androidx.compose.material.Tab (Tab.kt:89)");
                    }
                    ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -178151495, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1729014781, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
                    int i19 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                    int i110 = i3 >> 6;
                    InterfaceC0526Fp interfaceC0526Fp13 = interfaceC0526Fp5;
                    InterfaceC0526Fp interfaceC0526Fp14 = interfaceC0526Fp6;
                    m1246TabEVJuX4I(z, interfaceC3588op, modifier2, z3, mutableInteractionSource2, jM3042unboximpl, jM3031copywmQWz5c$default, composableLambda3, composerStartRestartGroup, i19 | (57344 & i110) | (458752 & i110) | (i110 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    interfaceC0526Fp7 = interfaceC0526Fp14;
                    z4 = z3;
                    interfaceC0526Fp8 = interfaceC0526Fp13;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    j4 = jM3042unboximpl;
                    j5 = jM3031copywmQWz5c$default;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$3(z, interfaceC3588op, modifier3, z4, interfaceC0526Fp7, interfaceC0526Fp8, mutableInteractionSource3, j4, j5, i, i2));
            }
            i3 |= 3072;
            z3 = z2;
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
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i & 29360128) != 0) {
                    if ((i2 & 128) == 0) {
                        i13 = 4194304;
                    } else {
                        i13 = 4194304;
                    }
                    i3 |= i13;
                }
                if ((234881024 & i) == 0) {
                    j3 = j2;
                    if ((i2 & 256) == 0) {
                        i12 = 33554432;
                    } else {
                        i12 = 33554432;
                    }
                    i3 |= i12;
                } else {
                    j3 = j2;
                }
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp3 = null;
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
                        if ((i2 & 128) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i3 &= -29360129;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jM3031copywmQWz5c$default = j3;
                        }
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
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp3 = null;
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
                        if ((i2 & 128) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i3 &= -29360129;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jM3031copywmQWz5c$default = j3;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp3;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1486097588, i3, -1, "androidx.compose.material.Tab (Tab.kt:89)");
                    }
                    ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -178151495, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1729014781, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
                    int i111 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                    int i112 = i3 >> 6;
                    InterfaceC0526Fp interfaceC0526Fp15 = interfaceC0526Fp5;
                    InterfaceC0526Fp interfaceC0526Fp16 = interfaceC0526Fp6;
                    m1246TabEVJuX4I(z, interfaceC3588op, modifier2, z3, mutableInteractionSource2, jM3042unboximpl, jM3031copywmQWz5c$default, composableLambda4, composerStartRestartGroup, i111 | (57344 & i112) | (458752 & i112) | (i112 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    interfaceC0526Fp7 = interfaceC0526Fp16;
                    z4 = z3;
                    interfaceC0526Fp8 = interfaceC0526Fp15;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    j4 = jM3042unboximpl;
                    j5 = jM3031copywmQWz5c$default;
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
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp3 = null;
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
                        if ((i2 & 128) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i3 &= -29360129;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jM3031copywmQWz5c$default = j3;
                        }
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
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp3 = null;
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
                        if ((i2 & 128) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i3 &= -29360129;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jM3031copywmQWz5c$default = j3;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp3;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1486097588, i3, -1, "androidx.compose.material.Tab (Tab.kt:89)");
                    }
                    ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -178151495, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1729014781, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
                    int i113 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                    int i114 = i3 >> 6;
                    InterfaceC0526Fp interfaceC0526Fp17 = interfaceC0526Fp5;
                    InterfaceC0526Fp interfaceC0526Fp18 = interfaceC0526Fp6;
                    m1246TabEVJuX4I(z, interfaceC3588op, modifier2, z3, mutableInteractionSource2, jM3042unboximpl, jM3031copywmQWz5c$default, composableLambda5, composerStartRestartGroup, i113 | (57344 & i114) | (458752 & i114) | (i114 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    interfaceC0526Fp7 = interfaceC0526Fp18;
                    z4 = z3;
                    interfaceC0526Fp8 = interfaceC0526Fp17;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    j4 = jM3042unboximpl;
                    j5 = jM3031copywmQWz5c$default;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$3(z, interfaceC3588op, modifier3, z4, interfaceC0526Fp7, interfaceC0526Fp8, mutableInteractionSource3, j4, j5, i, i2));
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
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            if ((i & 29360128) != 0) {
                if ((i2 & 128) == 0) {
                    i13 = 4194304;
                } else {
                    i13 = 4194304;
                }
                i3 |= i13;
            }
            if ((234881024 & i) == 0) {
                j3 = j2;
                if ((i2 & 256) == 0) {
                    i12 = 33554432;
                } else {
                    i12 = 33554432;
                }
                i3 |= i12;
            } else {
                j3 = j2;
            }
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp3 = null;
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
                    if ((i2 & 128) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i3 &= -29360129;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j3;
                    }
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
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp3 = null;
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
                    if ((i2 & 128) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i3 &= -29360129;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j3;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1486097588, i3, -1, "androidx.compose.material.Tab (Tab.kt:89)");
                }
                ComposableLambda composableLambda6 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -178151495, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1729014781, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
                int i115 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                int i116 = i3 >> 6;
                InterfaceC0526Fp interfaceC0526Fp19 = interfaceC0526Fp5;
                InterfaceC0526Fp interfaceC0526Fp110 = interfaceC0526Fp6;
                m1246TabEVJuX4I(z, interfaceC3588op, modifier2, z3, mutableInteractionSource2, jM3042unboximpl, jM3031copywmQWz5c$default, composableLambda6, composerStartRestartGroup, i115 | (57344 & i116) | (458752 & i116) | (i116 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                interfaceC0526Fp7 = interfaceC0526Fp110;
                z4 = z3;
                interfaceC0526Fp8 = interfaceC0526Fp19;
                mutableInteractionSource3 = mutableInteractionSource2;
                j4 = jM3042unboximpl;
                j5 = jM3031copywmQWz5c$default;
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
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp3 = null;
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
                    if ((i2 & 128) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i3 &= -29360129;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j3;
                    }
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
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp3 = null;
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
                    if ((i2 & 128) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i3 &= -29360129;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j3;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1486097588, i3, -1, "androidx.compose.material.Tab (Tab.kt:89)");
                }
                ComposableLambda composableLambda7 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -178151495, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1729014781, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
                int i117 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                int i118 = i3 >> 6;
                InterfaceC0526Fp interfaceC0526Fp111 = interfaceC0526Fp5;
                InterfaceC0526Fp interfaceC0526Fp112 = interfaceC0526Fp6;
                m1246TabEVJuX4I(z, interfaceC3588op, modifier2, z3, mutableInteractionSource2, jM3042unboximpl, jM3031copywmQWz5c$default, composableLambda7, composerStartRestartGroup, i117 | (57344 & i118) | (458752 & i118) | (i118 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                interfaceC0526Fp7 = interfaceC0526Fp112;
                z4 = z3;
                interfaceC0526Fp8 = interfaceC0526Fp111;
                mutableInteractionSource3 = mutableInteractionSource2;
                j4 = jM3042unboximpl;
                j5 = jM3031copywmQWz5c$default;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$3(z, interfaceC3588op, modifier3, z4, interfaceC0526Fp7, interfaceC0526Fp8, mutableInteractionSource3, j4, j5, i, i2));
        }
        i3 |= 384;
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
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i & 29360128) != 0) {
                    if ((i2 & 128) == 0) {
                        i13 = 4194304;
                    } else {
                        i13 = 4194304;
                    }
                    i3 |= i13;
                }
                if ((234881024 & i) == 0) {
                    j3 = j2;
                    if ((i2 & 256) == 0) {
                        i12 = 33554432;
                    } else {
                        i12 = 33554432;
                    }
                    i3 |= i12;
                } else {
                    j3 = j2;
                }
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp3 = null;
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
                        if ((i2 & 128) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i3 &= -29360129;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jM3031copywmQWz5c$default = j3;
                        }
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
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp3 = null;
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
                        if ((i2 & 128) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i3 &= -29360129;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jM3031copywmQWz5c$default = j3;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp3;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1486097588, i3, -1, "androidx.compose.material.Tab (Tab.kt:89)");
                    }
                    ComposableLambda composableLambda8 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -178151495, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1729014781, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
                    int i119 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                    int i1110 = i3 >> 6;
                    InterfaceC0526Fp interfaceC0526Fp113 = interfaceC0526Fp5;
                    InterfaceC0526Fp interfaceC0526Fp114 = interfaceC0526Fp6;
                    m1246TabEVJuX4I(z, interfaceC3588op, modifier2, z3, mutableInteractionSource2, jM3042unboximpl, jM3031copywmQWz5c$default, composableLambda8, composerStartRestartGroup, i119 | (57344 & i1110) | (458752 & i1110) | (i1110 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    interfaceC0526Fp7 = interfaceC0526Fp114;
                    z4 = z3;
                    interfaceC0526Fp8 = interfaceC0526Fp113;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    j4 = jM3042unboximpl;
                    j5 = jM3031copywmQWz5c$default;
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
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp3 = null;
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
                        if ((i2 & 128) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i3 &= -29360129;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jM3031copywmQWz5c$default = j3;
                        }
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
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp3 = null;
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
                        if ((i2 & 128) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i3 &= -29360129;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jM3031copywmQWz5c$default = j3;
                        }
                        interfaceC0526Fp5 = interfaceC0526Fp3;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1486097588, i3, -1, "androidx.compose.material.Tab (Tab.kt:89)");
                    }
                    ComposableLambda composableLambda9 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -178151495, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1729014781, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
                    int i1111 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                    int i1112 = i3 >> 6;
                    InterfaceC0526Fp interfaceC0526Fp115 = interfaceC0526Fp5;
                    InterfaceC0526Fp interfaceC0526Fp116 = interfaceC0526Fp6;
                    m1246TabEVJuX4I(z, interfaceC3588op, modifier2, z3, mutableInteractionSource2, jM3042unboximpl, jM3031copywmQWz5c$default, composableLambda9, composerStartRestartGroup, i1111 | (57344 & i1112) | (458752 & i1112) | (i1112 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    interfaceC0526Fp7 = interfaceC0526Fp116;
                    z4 = z3;
                    interfaceC0526Fp8 = interfaceC0526Fp115;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    j4 = jM3042unboximpl;
                    j5 = jM3031copywmQWz5c$default;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$3(z, interfaceC3588op, modifier3, z4, interfaceC0526Fp7, interfaceC0526Fp8, mutableInteractionSource3, j4, j5, i, i2));
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
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            if ((i & 29360128) != 0) {
                if ((i2 & 128) == 0) {
                    i13 = 4194304;
                } else {
                    i13 = 4194304;
                }
                i3 |= i13;
            }
            if ((234881024 & i) == 0) {
                j3 = j2;
                if ((i2 & 256) == 0) {
                    i12 = 33554432;
                } else {
                    i12 = 33554432;
                }
                i3 |= i12;
            } else {
                j3 = j2;
            }
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp3 = null;
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
                    if ((i2 & 128) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i3 &= -29360129;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j3;
                    }
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
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp3 = null;
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
                    if ((i2 & 128) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i3 &= -29360129;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j3;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1486097588, i3, -1, "androidx.compose.material.Tab (Tab.kt:89)");
                }
                ComposableLambda composableLambda10 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -178151495, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1729014781, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
                int i1113 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                int i1114 = i3 >> 6;
                InterfaceC0526Fp interfaceC0526Fp117 = interfaceC0526Fp5;
                InterfaceC0526Fp interfaceC0526Fp118 = interfaceC0526Fp6;
                m1246TabEVJuX4I(z, interfaceC3588op, modifier2, z3, mutableInteractionSource2, jM3042unboximpl, jM3031copywmQWz5c$default, composableLambda10, composerStartRestartGroup, i1113 | (57344 & i1114) | (458752 & i1114) | (i1114 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                interfaceC0526Fp7 = interfaceC0526Fp118;
                z4 = z3;
                interfaceC0526Fp8 = interfaceC0526Fp117;
                mutableInteractionSource3 = mutableInteractionSource2;
                j4 = jM3042unboximpl;
                j5 = jM3031copywmQWz5c$default;
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
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp3 = null;
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
                    if ((i2 & 128) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i3 &= -29360129;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j3;
                    }
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
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp3 = null;
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
                    if ((i2 & 128) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i3 &= -29360129;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j3;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1486097588, i3, -1, "androidx.compose.material.Tab (Tab.kt:89)");
                }
                ComposableLambda composableLambda11 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -178151495, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1729014781, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
                int i1115 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                int i1116 = i3 >> 6;
                InterfaceC0526Fp interfaceC0526Fp119 = interfaceC0526Fp5;
                InterfaceC0526Fp interfaceC0526Fp1110 = interfaceC0526Fp6;
                m1246TabEVJuX4I(z, interfaceC3588op, modifier2, z3, mutableInteractionSource2, jM3042unboximpl, jM3031copywmQWz5c$default, composableLambda11, composerStartRestartGroup, i1115 | (57344 & i1116) | (458752 & i1116) | (i1116 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                interfaceC0526Fp7 = interfaceC0526Fp1110;
                z4 = z3;
                interfaceC0526Fp8 = interfaceC0526Fp119;
                mutableInteractionSource3 = mutableInteractionSource2;
                j4 = jM3042unboximpl;
                j5 = jM3031copywmQWz5c$default;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$3(z, interfaceC3588op, modifier3, z4, interfaceC0526Fp7, interfaceC0526Fp8, mutableInteractionSource3, j4, j5, i, i2));
        }
        i3 |= 3072;
        z3 = z2;
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
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            if ((i & 29360128) != 0) {
                if ((i2 & 128) == 0) {
                    i13 = 4194304;
                } else {
                    i13 = 4194304;
                }
                i3 |= i13;
            }
            if ((234881024 & i) == 0) {
                j3 = j2;
                if ((i2 & 256) == 0) {
                    i12 = 33554432;
                } else {
                    i12 = 33554432;
                }
                i3 |= i12;
            } else {
                j3 = j2;
            }
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp3 = null;
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
                    if ((i2 & 128) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i3 &= -29360129;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j3;
                    }
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
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp3 = null;
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
                    if ((i2 & 128) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i3 &= -29360129;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j3;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1486097588, i3, -1, "androidx.compose.material.Tab (Tab.kt:89)");
                }
                ComposableLambda composableLambda12 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -178151495, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1729014781, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
                int i1117 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                int i1118 = i3 >> 6;
                InterfaceC0526Fp interfaceC0526Fp1111 = interfaceC0526Fp5;
                InterfaceC0526Fp interfaceC0526Fp1112 = interfaceC0526Fp6;
                m1246TabEVJuX4I(z, interfaceC3588op, modifier2, z3, mutableInteractionSource2, jM3042unboximpl, jM3031copywmQWz5c$default, composableLambda12, composerStartRestartGroup, i1117 | (57344 & i1118) | (458752 & i1118) | (i1118 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                interfaceC0526Fp7 = interfaceC0526Fp1112;
                z4 = z3;
                interfaceC0526Fp8 = interfaceC0526Fp1111;
                mutableInteractionSource3 = mutableInteractionSource2;
                j4 = jM3042unboximpl;
                j5 = jM3031copywmQWz5c$default;
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
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp3 = null;
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
                    if ((i2 & 128) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i3 &= -29360129;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j3;
                    }
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
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp3 = null;
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
                    if ((i2 & 128) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i3 &= -29360129;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j3;
                    }
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1486097588, i3, -1, "androidx.compose.material.Tab (Tab.kt:89)");
                }
                ComposableLambda composableLambda13 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -178151495, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1729014781, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
                int i1119 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                int i11110 = i3 >> 6;
                InterfaceC0526Fp interfaceC0526Fp1113 = interfaceC0526Fp5;
                InterfaceC0526Fp interfaceC0526Fp1114 = interfaceC0526Fp6;
                m1246TabEVJuX4I(z, interfaceC3588op, modifier2, z3, mutableInteractionSource2, jM3042unboximpl, jM3031copywmQWz5c$default, composableLambda13, composerStartRestartGroup, i1119 | (57344 & i11110) | (458752 & i11110) | (i11110 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                interfaceC0526Fp7 = interfaceC0526Fp1114;
                z4 = z3;
                interfaceC0526Fp8 = interfaceC0526Fp1113;
                mutableInteractionSource3 = mutableInteractionSource2;
                j4 = jM3042unboximpl;
                j5 = jM3031copywmQWz5c$default;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$3(z, interfaceC3588op, modifier3, z4, interfaceC0526Fp7, interfaceC0526Fp8, mutableInteractionSource3, j4, j5, i, i2));
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
        i10 = i2 & 64;
        if (i10 != 0) {
            i3 |= 1572864;
        } else if ((i & 3670016) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i11 = 1048576;
            } else {
                i11 = 524288;
            }
            i3 |= i11;
        }
        if ((i & 29360128) != 0) {
            if ((i2 & 128) == 0) {
                i13 = 4194304;
            } else {
                i13 = 4194304;
            }
            i3 |= i13;
        }
        if ((234881024 & i) == 0) {
            j3 = j2;
            if ((i2 & 256) == 0) {
                i12 = 33554432;
            } else {
                i12 = 33554432;
            }
            i3 |= i12;
        } else {
            j3 = j2;
        }
        if ((191739611 & i3) == 38347922) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if (i6 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp;
                }
                if (i8 != 0) {
                    interfaceC0526Fp3 = null;
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
                if ((i2 & 128) != 0) {
                    jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                    i3 &= -29360129;
                } else {
                    jM3042unboximpl = j;
                }
                if ((i2 & 256) != 0) {
                    i3 &= -234881025;
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jM3031copywmQWz5c$default = j3;
                }
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
                }
                if (i6 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp;
                }
                if (i8 != 0) {
                    interfaceC0526Fp3 = null;
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
                if ((i2 & 128) != 0) {
                    jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                    i3 &= -29360129;
                } else {
                    jM3042unboximpl = j;
                }
                if ((i2 & 256) != 0) {
                    i3 &= -234881025;
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jM3031copywmQWz5c$default = j3;
                }
                interfaceC0526Fp5 = interfaceC0526Fp3;
                interfaceC0526Fp6 = interfaceC0526Fp4;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1486097588, i3, -1, "androidx.compose.material.Tab (Tab.kt:89)");
            }
            ComposableLambda composableLambda14 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -178151495, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1729014781, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
            int i11111 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
            int i11112 = i3 >> 6;
            InterfaceC0526Fp interfaceC0526Fp1115 = interfaceC0526Fp5;
            InterfaceC0526Fp interfaceC0526Fp1116 = interfaceC0526Fp6;
            m1246TabEVJuX4I(z, interfaceC3588op, modifier2, z3, mutableInteractionSource2, jM3042unboximpl, jM3031copywmQWz5c$default, composableLambda14, composerStartRestartGroup, i11111 | (57344 & i11112) | (458752 & i11112) | (i11112 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            interfaceC0526Fp7 = interfaceC0526Fp1116;
            z4 = z3;
            interfaceC0526Fp8 = interfaceC0526Fp1115;
            mutableInteractionSource3 = mutableInteractionSource2;
            j4 = jM3042unboximpl;
            j5 = jM3031copywmQWz5c$default;
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
                }
                if (i6 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp;
                }
                if (i8 != 0) {
                    interfaceC0526Fp3 = null;
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
                if ((i2 & 128) != 0) {
                    jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                    i3 &= -29360129;
                } else {
                    jM3042unboximpl = j;
                }
                if ((i2 & 256) != 0) {
                    i3 &= -234881025;
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jM3031copywmQWz5c$default = j3;
                }
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
                }
                if (i6 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp;
                }
                if (i8 != 0) {
                    interfaceC0526Fp3 = null;
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
                if ((i2 & 128) != 0) {
                    jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                    i3 &= -29360129;
                } else {
                    jM3042unboximpl = j;
                }
                if ((i2 & 256) != 0) {
                    i3 &= -234881025;
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jM3031copywmQWz5c$default = j3;
                }
                interfaceC0526Fp5 = interfaceC0526Fp3;
                interfaceC0526Fp6 = interfaceC0526Fp4;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1486097588, i3, -1, "androidx.compose.material.Tab (Tab.kt:89)");
            }
            ComposableLambda composableLambda15 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -178151495, true, new TabKt$Tab$2(interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1729014781, true, new TabKt$Tab$styledText$1$1(interfaceC0526Fp6, i3)) : null, interfaceC0526Fp5, i3));
            int i11113 = 12582912 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
            int i11114 = i3 >> 6;
            InterfaceC0526Fp interfaceC0526Fp1117 = interfaceC0526Fp5;
            InterfaceC0526Fp interfaceC0526Fp1118 = interfaceC0526Fp6;
            m1246TabEVJuX4I(z, interfaceC3588op, modifier2, z3, mutableInteractionSource2, jM3042unboximpl, jM3031copywmQWz5c$default, composableLambda15, composerStartRestartGroup, i11113 | (57344 & i11114) | (458752 & i11114) | (i11114 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            interfaceC0526Fp7 = interfaceC0526Fp1118;
            z4 = z3;
            interfaceC0526Fp8 = interfaceC0526Fp1117;
            mutableInteractionSource3 = mutableInteractionSource2;
            j4 = jM3042unboximpl;
            j5 = jM3031copywmQWz5c$default;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$3(z, interfaceC3588op, modifier3, z4, interfaceC0526Fp7, interfaceC0526Fp8, mutableInteractionSource3, j4, j5, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:105:0x013c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:106:0x013e  */
    /* JADX WARN: Code duplicated, block: B:108:0x0143  */
    /* JADX WARN: Code duplicated, block: B:110:0x0146  */
    /* JADX WARN: Code duplicated, block: B:112:0x0158  */
    /* JADX WARN: Code duplicated, block: B:116:0x0169  */
    /* JADX WARN: Code duplicated, block: B:117:0x017a  */
    /* JADX WARN: Code duplicated, block: B:120:0x0180  */
    /* JADX WARN: Code duplicated, block: B:123:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:126:0x0206  */
    /* JADX WARN: Code duplicated, block: B:131:0x0219  */
    /* JADX WARN: Code duplicated, block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x006c  */
    /* JADX WARN: Code duplicated, block: B:38:0x0071  */
    /* JADX WARN: Code duplicated, block: B:40:0x0075  */
    /* JADX WARN: Code duplicated, block: B:42:0x007d  */
    /* JADX WARN: Code duplicated, block: B:43:0x0080  */
    /* JADX WARN: Code duplicated, block: B:47:0x0087  */
    /* JADX WARN: Code duplicated, block: B:49:0x008c  */
    /* JADX WARN: Code duplicated, block: B:51:0x0092  */
    /* JADX WARN: Code duplicated, block: B:53:0x009a  */
    /* JADX WARN: Code duplicated, block: B:54:0x009d  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:70:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:75:0x00db  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:88:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:92:0x010f  */
    /* JADX WARN: Code duplicated, block: B:94:0x011a  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Tab-EVJuX4I, reason: not valid java name */
    public static final void m1246TabEVJuX4I(boolean z, InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, long j, long j2, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        int i8;
        long jM3031copywmQWz5c$default;
        int i9;
        long jM3042unboximpl;
        Object objRememberedValue;
        int i10;
        boolean z4;
        MutableInteractionSource mutableInteractionSource3;
        long j3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        int i12;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(713679175);
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
        int i13 = i2 & 4;
        if (i13 == 0) {
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
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((57344 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    if ((458752 & i) == 0) {
                        int i14 = i3;
                        if ((i2 & 32) == 0 || !composerStartRestartGroup.changed(j)) {
                            i12 = 65536;
                        } else {
                            i12 = 131072;
                        }
                        i8 = i14 | i12;
                    } else {
                        i8 = i3;
                    }
                    if ((i & 3670016) == 0) {
                        jM3031copywmQWz5c$default = j2;
                        if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(jM3031copywmQWz5c$default)) {
                            i11 = 524288;
                        } else {
                            i11 = 1048576;
                        }
                        i8 |= i11;
                    } else {
                        jM3031copywmQWz5c$default = j2;
                    }
                    if ((i2 & 128) != 0) {
                        if ((29360128 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i9 = 8388608;
                            } else {
                                i9 = 4194304;
                            }
                        }
                        if ((23967451 & i8) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i13 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    z3 = true;
                                }
                                if (i6 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                }
                                if ((i2 & 32) != 0) {
                                    jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                                    i8 &= -458753;
                                } else {
                                    jM3042unboximpl = j;
                                }
                                if ((i2 & 64) != 0) {
                                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                    i8 &= -3670017;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 32) != 0) {
                                    i8 &= -458753;
                                }
                                if ((i2 & 64) != 0) {
                                    i8 &= -3670017;
                                }
                                jM3042unboximpl = j;
                            }
                            MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                            long j4 = jM3031copywmQWz5c$default;
                            i10 = i8;
                            Modifier modifier3 = modifier2;
                            boolean z5 = z3;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                            }
                            int i15 = i10 >> 15;
                            m1247TabTransitionKlgxPg(jM3042unboximpl, j4, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier3, z, mutableInteractionSource4, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z5, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i15 & 112) | (i15 & 14) | 3072 | ((i10 << 6) & 896));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier3;
                            z4 = z5;
                            mutableInteractionSource3 = mutableInteractionSource4;
                            j3 = jM3042unboximpl;
                            jM3031copywmQWz5c$default = j4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            z4 = z3;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            j3 = j;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$6(z, interfaceC3588op, modifier2, z4, mutableInteractionSource3, j3, jM3031copywmQWz5c$default, interfaceC0552Gp, i, i2));
                    }
                    i9 = 12582912;
                    i8 |= i9;
                    if ((23967451 & i8) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if ((i2 & 32) != 0) {
                                jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                                i8 &= -458753;
                            } else {
                                jM3042unboximpl = j;
                            }
                            if ((i2 & 64) != 0) {
                                jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i8 &= -3670017;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if ((i2 & 32) != 0) {
                                jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                                i8 &= -458753;
                            } else {
                                jM3042unboximpl = j;
                            }
                            if ((i2 & 64) != 0) {
                                jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i8 &= -3670017;
                            }
                        }
                        MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource2;
                        long j5 = jM3031copywmQWz5c$default;
                        i10 = i8;
                        Modifier modifier4 = modifier2;
                        boolean z6 = z3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                        }
                        int i16 = i10 >> 15;
                        m1247TabTransitionKlgxPg(jM3042unboximpl, j5, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier4, z, mutableInteractionSource5, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z6, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i16 & 112) | (i16 & 14) | 3072 | ((i10 << 6) & 896));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier4;
                        z4 = z6;
                        mutableInteractionSource3 = mutableInteractionSource5;
                        j3 = jM3042unboximpl;
                        jM3031copywmQWz5c$default = j5;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if ((i2 & 32) != 0) {
                                jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                                i8 &= -458753;
                            } else {
                                jM3042unboximpl = j;
                            }
                            if ((i2 & 64) != 0) {
                                jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i8 &= -3670017;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if ((i2 & 32) != 0) {
                                jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                                i8 &= -458753;
                            } else {
                                jM3042unboximpl = j;
                            }
                            if ((i2 & 64) != 0) {
                                jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i8 &= -3670017;
                            }
                        }
                        MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource2;
                        long j6 = jM3031copywmQWz5c$default;
                        i10 = i8;
                        Modifier modifier5 = modifier2;
                        boolean z7 = z3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                        }
                        int i17 = i10 >> 15;
                        m1247TabTransitionKlgxPg(jM3042unboximpl, j6, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier5, z, mutableInteractionSource6, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z7, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i17 & 112) | (i17 & 14) | 3072 | ((i10 << 6) & 896));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier5;
                        z4 = z7;
                        mutableInteractionSource3 = mutableInteractionSource6;
                        j3 = jM3042unboximpl;
                        jM3031copywmQWz5c$default = j6;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$6(z, interfaceC3588op, modifier2, z4, mutableInteractionSource3, j3, jM3031copywmQWz5c$default, interfaceC0552Gp, i, i2));
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((458752 & i) == 0) {
                    int i18 = i3;
                    if ((i2 & 32) == 0) {
                        i12 = 65536;
                    } else {
                        i12 = 65536;
                    }
                    i8 = i18 | i12;
                } else {
                    i8 = i3;
                }
                if ((i & 3670016) == 0) {
                    jM3031copywmQWz5c$default = j2;
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i8 |= i11;
                } else {
                    jM3031copywmQWz5c$default = j2;
                }
                if ((i2 & 128) != 0) {
                    if ((29360128 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i9 = 8388608;
                        } else {
                            i9 = 4194304;
                        }
                    }
                    if ((23967451 & i8) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if ((i2 & 32) != 0) {
                                jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                                i8 &= -458753;
                            } else {
                                jM3042unboximpl = j;
                            }
                            if ((i2 & 64) != 0) {
                                jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i8 &= -3670017;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if ((i2 & 32) != 0) {
                                jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                                i8 &= -458753;
                            } else {
                                jM3042unboximpl = j;
                            }
                            if ((i2 & 64) != 0) {
                                jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i8 &= -3670017;
                            }
                        }
                        MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource2;
                        long j7 = jM3031copywmQWz5c$default;
                        i10 = i8;
                        Modifier modifier6 = modifier2;
                        boolean z8 = z3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                        }
                        int i19 = i10 >> 15;
                        m1247TabTransitionKlgxPg(jM3042unboximpl, j7, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier6, z, mutableInteractionSource7, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z8, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i19 & 112) | (i19 & 14) | 3072 | ((i10 << 6) & 896));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier6;
                        z4 = z8;
                        mutableInteractionSource3 = mutableInteractionSource7;
                        j3 = jM3042unboximpl;
                        jM3031copywmQWz5c$default = j7;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if ((i2 & 32) != 0) {
                                jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                                i8 &= -458753;
                            } else {
                                jM3042unboximpl = j;
                            }
                            if ((i2 & 64) != 0) {
                                jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i8 &= -3670017;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if ((i2 & 32) != 0) {
                                jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                                i8 &= -458753;
                            } else {
                                jM3042unboximpl = j;
                            }
                            if ((i2 & 64) != 0) {
                                jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i8 &= -3670017;
                            }
                        }
                        MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource2;
                        long j8 = jM3031copywmQWz5c$default;
                        i10 = i8;
                        Modifier modifier7 = modifier2;
                        boolean z9 = z3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                        }
                        int i110 = i10 >> 15;
                        m1247TabTransitionKlgxPg(jM3042unboximpl, j8, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier7, z, mutableInteractionSource8, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z9, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i110 & 112) | (i110 & 14) | 3072 | ((i10 << 6) & 896));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier7;
                        z4 = z9;
                        mutableInteractionSource3 = mutableInteractionSource8;
                        j3 = jM3042unboximpl;
                        jM3031copywmQWz5c$default = j8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$6(z, interfaceC3588op, modifier2, z4, mutableInteractionSource3, j3, jM3031copywmQWz5c$default, interfaceC0552Gp, i, i2));
                }
                i9 = 12582912;
                i8 |= i9;
                if ((23967451 & i8) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 32) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -458753;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 64) != 0) {
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -3670017;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 32) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -458753;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 64) != 0) {
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -3670017;
                        }
                    }
                    MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource2;
                    long j9 = jM3031copywmQWz5c$default;
                    i10 = i8;
                    Modifier modifier8 = modifier2;
                    boolean z10 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                    }
                    int i111 = i10 >> 15;
                    m1247TabTransitionKlgxPg(jM3042unboximpl, j9, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier8, z, mutableInteractionSource9, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z10, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i111 & 112) | (i111 & 14) | 3072 | ((i10 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier8;
                    z4 = z10;
                    mutableInteractionSource3 = mutableInteractionSource9;
                    j3 = jM3042unboximpl;
                    jM3031copywmQWz5c$default = j9;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 32) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -458753;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 64) != 0) {
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -3670017;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 32) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -458753;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 64) != 0) {
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -3670017;
                        }
                    }
                    MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource2;
                    long j10 = jM3031copywmQWz5c$default;
                    i10 = i8;
                    Modifier modifier9 = modifier2;
                    boolean z11 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                    }
                    int i112 = i10 >> 15;
                    m1247TabTransitionKlgxPg(jM3042unboximpl, j10, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier9, z, mutableInteractionSource10, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z11, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i112 & 112) | (i112 & 14) | 3072 | ((i10 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier9;
                    z4 = z11;
                    mutableInteractionSource3 = mutableInteractionSource10;
                    j3 = jM3042unboximpl;
                    jM3031copywmQWz5c$default = j10;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$6(z, interfaceC3588op, modifier2, z4, mutableInteractionSource3, j3, jM3031copywmQWz5c$default, interfaceC0552Gp, i, i2));
            }
            i3 |= 3072;
            z3 = z2;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((57344 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((458752 & i) == 0) {
                    int i113 = i3;
                    if ((i2 & 32) == 0) {
                        i12 = 65536;
                    } else {
                        i12 = 65536;
                    }
                    i8 = i113 | i12;
                } else {
                    i8 = i3;
                }
                if ((i & 3670016) == 0) {
                    jM3031copywmQWz5c$default = j2;
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i8 |= i11;
                } else {
                    jM3031copywmQWz5c$default = j2;
                }
                if ((i2 & 128) != 0) {
                    if ((29360128 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i9 = 8388608;
                        } else {
                            i9 = 4194304;
                        }
                    }
                    if ((23967451 & i8) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if ((i2 & 32) != 0) {
                                jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                                i8 &= -458753;
                            } else {
                                jM3042unboximpl = j;
                            }
                            if ((i2 & 64) != 0) {
                                jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i8 &= -3670017;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if ((i2 & 32) != 0) {
                                jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                                i8 &= -458753;
                            } else {
                                jM3042unboximpl = j;
                            }
                            if ((i2 & 64) != 0) {
                                jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i8 &= -3670017;
                            }
                        }
                        MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource2;
                        long j11 = jM3031copywmQWz5c$default;
                        i10 = i8;
                        Modifier modifier10 = modifier2;
                        boolean z12 = z3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                        }
                        int i114 = i10 >> 15;
                        m1247TabTransitionKlgxPg(jM3042unboximpl, j11, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier10, z, mutableInteractionSource11, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z12, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i114 & 112) | (i114 & 14) | 3072 | ((i10 << 6) & 896));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier10;
                        z4 = z12;
                        mutableInteractionSource3 = mutableInteractionSource11;
                        j3 = jM3042unboximpl;
                        jM3031copywmQWz5c$default = j11;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if ((i2 & 32) != 0) {
                                jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                                i8 &= -458753;
                            } else {
                                jM3042unboximpl = j;
                            }
                            if ((i2 & 64) != 0) {
                                jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i8 &= -3670017;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if ((i2 & 32) != 0) {
                                jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                                i8 &= -458753;
                            } else {
                                jM3042unboximpl = j;
                            }
                            if ((i2 & 64) != 0) {
                                jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i8 &= -3670017;
                            }
                        }
                        MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource2;
                        long j12 = jM3031copywmQWz5c$default;
                        i10 = i8;
                        Modifier modifier11 = modifier2;
                        boolean z13 = z3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                        }
                        int i115 = i10 >> 15;
                        m1247TabTransitionKlgxPg(jM3042unboximpl, j12, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier11, z, mutableInteractionSource12, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z13, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i115 & 112) | (i115 & 14) | 3072 | ((i10 << 6) & 896));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier11;
                        z4 = z13;
                        mutableInteractionSource3 = mutableInteractionSource12;
                        j3 = jM3042unboximpl;
                        jM3031copywmQWz5c$default = j12;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$6(z, interfaceC3588op, modifier2, z4, mutableInteractionSource3, j3, jM3031copywmQWz5c$default, interfaceC0552Gp, i, i2));
                }
                i9 = 12582912;
                i8 |= i9;
                if ((23967451 & i8) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 32) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -458753;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 64) != 0) {
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -3670017;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 32) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -458753;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 64) != 0) {
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -3670017;
                        }
                    }
                    MutableInteractionSource mutableInteractionSource13 = mutableInteractionSource2;
                    long j13 = jM3031copywmQWz5c$default;
                    i10 = i8;
                    Modifier modifier12 = modifier2;
                    boolean z14 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                    }
                    int i116 = i10 >> 15;
                    m1247TabTransitionKlgxPg(jM3042unboximpl, j13, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier12, z, mutableInteractionSource13, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z14, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i116 & 112) | (i116 & 14) | 3072 | ((i10 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier12;
                    z4 = z14;
                    mutableInteractionSource3 = mutableInteractionSource13;
                    j3 = jM3042unboximpl;
                    jM3031copywmQWz5c$default = j13;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 32) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -458753;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 64) != 0) {
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -3670017;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 32) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -458753;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 64) != 0) {
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -3670017;
                        }
                    }
                    MutableInteractionSource mutableInteractionSource14 = mutableInteractionSource2;
                    long j14 = jM3031copywmQWz5c$default;
                    i10 = i8;
                    Modifier modifier13 = modifier2;
                    boolean z15 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                    }
                    int i117 = i10 >> 15;
                    m1247TabTransitionKlgxPg(jM3042unboximpl, j14, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier13, z, mutableInteractionSource14, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z15, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i117 & 112) | (i117 & 14) | 3072 | ((i10 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier13;
                    z4 = z15;
                    mutableInteractionSource3 = mutableInteractionSource14;
                    j3 = jM3042unboximpl;
                    jM3031copywmQWz5c$default = j14;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$6(z, interfaceC3588op, modifier2, z4, mutableInteractionSource3, j3, jM3031copywmQWz5c$default, interfaceC0552Gp, i, i2));
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((458752 & i) == 0) {
                int i118 = i3;
                if ((i2 & 32) == 0) {
                    i12 = 65536;
                } else {
                    i12 = 65536;
                }
                i8 = i118 | i12;
            } else {
                i8 = i3;
            }
            if ((i & 3670016) == 0) {
                jM3031copywmQWz5c$default = j2;
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i8 |= i11;
            } else {
                jM3031copywmQWz5c$default = j2;
            }
            if ((i2 & 128) != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                }
                if ((23967451 & i8) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 32) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -458753;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 64) != 0) {
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -3670017;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 32) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -458753;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 64) != 0) {
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -3670017;
                        }
                    }
                    MutableInteractionSource mutableInteractionSource15 = mutableInteractionSource2;
                    long j15 = jM3031copywmQWz5c$default;
                    i10 = i8;
                    Modifier modifier14 = modifier2;
                    boolean z16 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                    }
                    int i119 = i10 >> 15;
                    m1247TabTransitionKlgxPg(jM3042unboximpl, j15, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier14, z, mutableInteractionSource15, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z16, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i119 & 112) | (i119 & 14) | 3072 | ((i10 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier14;
                    z4 = z16;
                    mutableInteractionSource3 = mutableInteractionSource15;
                    j3 = jM3042unboximpl;
                    jM3031copywmQWz5c$default = j15;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 32) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -458753;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 64) != 0) {
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -3670017;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 32) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -458753;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 64) != 0) {
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -3670017;
                        }
                    }
                    MutableInteractionSource mutableInteractionSource16 = mutableInteractionSource2;
                    long j16 = jM3031copywmQWz5c$default;
                    i10 = i8;
                    Modifier modifier15 = modifier2;
                    boolean z17 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                    }
                    int i1110 = i10 >> 15;
                    m1247TabTransitionKlgxPg(jM3042unboximpl, j16, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier15, z, mutableInteractionSource16, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z17, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i1110 & 112) | (i1110 & 14) | 3072 | ((i10 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier15;
                    z4 = z17;
                    mutableInteractionSource3 = mutableInteractionSource16;
                    j3 = jM3042unboximpl;
                    jM3031copywmQWz5c$default = j16;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$6(z, interfaceC3588op, modifier2, z4, mutableInteractionSource3, j3, jM3031copywmQWz5c$default, interfaceC0552Gp, i, i2));
            }
            i9 = 12582912;
            i8 |= i9;
            if ((23967451 & i8) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 32) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -458753;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 64) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i8 &= -3670017;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 32) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -458753;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 64) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i8 &= -3670017;
                    }
                }
                MutableInteractionSource mutableInteractionSource17 = mutableInteractionSource2;
                long j17 = jM3031copywmQWz5c$default;
                i10 = i8;
                Modifier modifier16 = modifier2;
                boolean z18 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                }
                int i1111 = i10 >> 15;
                m1247TabTransitionKlgxPg(jM3042unboximpl, j17, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier16, z, mutableInteractionSource17, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z18, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i1111 & 112) | (i1111 & 14) | 3072 | ((i10 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier16;
                z4 = z18;
                mutableInteractionSource3 = mutableInteractionSource17;
                j3 = jM3042unboximpl;
                jM3031copywmQWz5c$default = j17;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 32) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -458753;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 64) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i8 &= -3670017;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 32) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -458753;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 64) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i8 &= -3670017;
                    }
                }
                MutableInteractionSource mutableInteractionSource18 = mutableInteractionSource2;
                long j18 = jM3031copywmQWz5c$default;
                i10 = i8;
                Modifier modifier17 = modifier2;
                boolean z19 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                }
                int i1112 = i10 >> 15;
                m1247TabTransitionKlgxPg(jM3042unboximpl, j18, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier17, z, mutableInteractionSource18, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z19, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i1112 & 112) | (i1112 & 14) | 3072 | ((i10 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier17;
                z4 = z19;
                mutableInteractionSource3 = mutableInteractionSource18;
                j3 = jM3042unboximpl;
                jM3031copywmQWz5c$default = j18;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$6(z, interfaceC3588op, modifier2, z4, mutableInteractionSource3, j3, jM3031copywmQWz5c$default, interfaceC0552Gp, i, i2));
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
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((57344 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((458752 & i) == 0) {
                    int i1113 = i3;
                    if ((i2 & 32) == 0) {
                        i12 = 65536;
                    } else {
                        i12 = 65536;
                    }
                    i8 = i1113 | i12;
                } else {
                    i8 = i3;
                }
                if ((i & 3670016) == 0) {
                    jM3031copywmQWz5c$default = j2;
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i8 |= i11;
                } else {
                    jM3031copywmQWz5c$default = j2;
                }
                if ((i2 & 128) != 0) {
                    if ((29360128 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i9 = 8388608;
                        } else {
                            i9 = 4194304;
                        }
                    }
                    if ((23967451 & i8) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if ((i2 & 32) != 0) {
                                jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                                i8 &= -458753;
                            } else {
                                jM3042unboximpl = j;
                            }
                            if ((i2 & 64) != 0) {
                                jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i8 &= -3670017;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if ((i2 & 32) != 0) {
                                jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                                i8 &= -458753;
                            } else {
                                jM3042unboximpl = j;
                            }
                            if ((i2 & 64) != 0) {
                                jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i8 &= -3670017;
                            }
                        }
                        MutableInteractionSource mutableInteractionSource19 = mutableInteractionSource2;
                        long j19 = jM3031copywmQWz5c$default;
                        i10 = i8;
                        Modifier modifier18 = modifier2;
                        boolean z110 = z3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                        }
                        int i1114 = i10 >> 15;
                        m1247TabTransitionKlgxPg(jM3042unboximpl, j19, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier18, z, mutableInteractionSource19, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z110, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i1114 & 112) | (i1114 & 14) | 3072 | ((i10 << 6) & 896));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier18;
                        z4 = z110;
                        mutableInteractionSource3 = mutableInteractionSource19;
                        j3 = jM3042unboximpl;
                        jM3031copywmQWz5c$default = j19;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if ((i2 & 32) != 0) {
                                jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                                i8 &= -458753;
                            } else {
                                jM3042unboximpl = j;
                            }
                            if ((i2 & 64) != 0) {
                                jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i8 &= -3670017;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if ((i2 & 32) != 0) {
                                jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                                i8 &= -458753;
                            } else {
                                jM3042unboximpl = j;
                            }
                            if ((i2 & 64) != 0) {
                                jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i8 &= -3670017;
                            }
                        }
                        MutableInteractionSource mutableInteractionSource110 = mutableInteractionSource2;
                        long j110 = jM3031copywmQWz5c$default;
                        i10 = i8;
                        Modifier modifier19 = modifier2;
                        boolean z111 = z3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                        }
                        int i1115 = i10 >> 15;
                        m1247TabTransitionKlgxPg(jM3042unboximpl, j110, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier19, z, mutableInteractionSource110, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z111, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i1115 & 112) | (i1115 & 14) | 3072 | ((i10 << 6) & 896));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier19;
                        z4 = z111;
                        mutableInteractionSource3 = mutableInteractionSource110;
                        j3 = jM3042unboximpl;
                        jM3031copywmQWz5c$default = j110;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$6(z, interfaceC3588op, modifier2, z4, mutableInteractionSource3, j3, jM3031copywmQWz5c$default, interfaceC0552Gp, i, i2));
                }
                i9 = 12582912;
                i8 |= i9;
                if ((23967451 & i8) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 32) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -458753;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 64) != 0) {
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -3670017;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 32) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -458753;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 64) != 0) {
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -3670017;
                        }
                    }
                    MutableInteractionSource mutableInteractionSource111 = mutableInteractionSource2;
                    long j111 = jM3031copywmQWz5c$default;
                    i10 = i8;
                    Modifier modifier110 = modifier2;
                    boolean z112 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                    }
                    int i1116 = i10 >> 15;
                    m1247TabTransitionKlgxPg(jM3042unboximpl, j111, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier110, z, mutableInteractionSource111, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z112, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i1116 & 112) | (i1116 & 14) | 3072 | ((i10 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier110;
                    z4 = z112;
                    mutableInteractionSource3 = mutableInteractionSource111;
                    j3 = jM3042unboximpl;
                    jM3031copywmQWz5c$default = j111;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 32) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -458753;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 64) != 0) {
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -3670017;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 32) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -458753;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 64) != 0) {
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -3670017;
                        }
                    }
                    MutableInteractionSource mutableInteractionSource112 = mutableInteractionSource2;
                    long j112 = jM3031copywmQWz5c$default;
                    i10 = i8;
                    Modifier modifier111 = modifier2;
                    boolean z113 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                    }
                    int i1117 = i10 >> 15;
                    m1247TabTransitionKlgxPg(jM3042unboximpl, j112, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier111, z, mutableInteractionSource112, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z113, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i1117 & 112) | (i1117 & 14) | 3072 | ((i10 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier111;
                    z4 = z113;
                    mutableInteractionSource3 = mutableInteractionSource112;
                    j3 = jM3042unboximpl;
                    jM3031copywmQWz5c$default = j112;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$6(z, interfaceC3588op, modifier2, z4, mutableInteractionSource3, j3, jM3031copywmQWz5c$default, interfaceC0552Gp, i, i2));
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((458752 & i) == 0) {
                int i1118 = i3;
                if ((i2 & 32) == 0) {
                    i12 = 65536;
                } else {
                    i12 = 65536;
                }
                i8 = i1118 | i12;
            } else {
                i8 = i3;
            }
            if ((i & 3670016) == 0) {
                jM3031copywmQWz5c$default = j2;
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i8 |= i11;
            } else {
                jM3031copywmQWz5c$default = j2;
            }
            if ((i2 & 128) != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                }
                if ((23967451 & i8) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 32) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -458753;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 64) != 0) {
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -3670017;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 32) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -458753;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 64) != 0) {
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -3670017;
                        }
                    }
                    MutableInteractionSource mutableInteractionSource113 = mutableInteractionSource2;
                    long j113 = jM3031copywmQWz5c$default;
                    i10 = i8;
                    Modifier modifier112 = modifier2;
                    boolean z114 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                    }
                    int i1119 = i10 >> 15;
                    m1247TabTransitionKlgxPg(jM3042unboximpl, j113, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier112, z, mutableInteractionSource113, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z114, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i1119 & 112) | (i1119 & 14) | 3072 | ((i10 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier112;
                    z4 = z114;
                    mutableInteractionSource3 = mutableInteractionSource113;
                    j3 = jM3042unboximpl;
                    jM3031copywmQWz5c$default = j113;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 32) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -458753;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 64) != 0) {
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -3670017;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 32) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -458753;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 64) != 0) {
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -3670017;
                        }
                    }
                    MutableInteractionSource mutableInteractionSource114 = mutableInteractionSource2;
                    long j114 = jM3031copywmQWz5c$default;
                    i10 = i8;
                    Modifier modifier113 = modifier2;
                    boolean z115 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                    }
                    int i11110 = i10 >> 15;
                    m1247TabTransitionKlgxPg(jM3042unboximpl, j114, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier113, z, mutableInteractionSource114, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z115, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i11110 & 112) | (i11110 & 14) | 3072 | ((i10 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier113;
                    z4 = z115;
                    mutableInteractionSource3 = mutableInteractionSource114;
                    j3 = jM3042unboximpl;
                    jM3031copywmQWz5c$default = j114;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$6(z, interfaceC3588op, modifier2, z4, mutableInteractionSource3, j3, jM3031copywmQWz5c$default, interfaceC0552Gp, i, i2));
            }
            i9 = 12582912;
            i8 |= i9;
            if ((23967451 & i8) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 32) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -458753;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 64) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i8 &= -3670017;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 32) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -458753;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 64) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i8 &= -3670017;
                    }
                }
                MutableInteractionSource mutableInteractionSource115 = mutableInteractionSource2;
                long j115 = jM3031copywmQWz5c$default;
                i10 = i8;
                Modifier modifier114 = modifier2;
                boolean z116 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                }
                int i11111 = i10 >> 15;
                m1247TabTransitionKlgxPg(jM3042unboximpl, j115, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier114, z, mutableInteractionSource115, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z116, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i11111 & 112) | (i11111 & 14) | 3072 | ((i10 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier114;
                z4 = z116;
                mutableInteractionSource3 = mutableInteractionSource115;
                j3 = jM3042unboximpl;
                jM3031copywmQWz5c$default = j115;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 32) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -458753;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 64) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i8 &= -3670017;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 32) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -458753;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 64) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i8 &= -3670017;
                    }
                }
                MutableInteractionSource mutableInteractionSource116 = mutableInteractionSource2;
                long j116 = jM3031copywmQWz5c$default;
                i10 = i8;
                Modifier modifier115 = modifier2;
                boolean z117 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                }
                int i11112 = i10 >> 15;
                m1247TabTransitionKlgxPg(jM3042unboximpl, j116, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier115, z, mutableInteractionSource116, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z117, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i11112 & 112) | (i11112 & 14) | 3072 | ((i10 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier115;
                z4 = z117;
                mutableInteractionSource3 = mutableInteractionSource116;
                j3 = jM3042unboximpl;
                jM3031copywmQWz5c$default = j116;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$6(z, interfaceC3588op, modifier2, z4, mutableInteractionSource3, j3, jM3031copywmQWz5c$default, interfaceC0552Gp, i, i2));
        }
        i3 |= 3072;
        z3 = z2;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((57344 & i) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((458752 & i) == 0) {
                int i11113 = i3;
                if ((i2 & 32) == 0) {
                    i12 = 65536;
                } else {
                    i12 = 65536;
                }
                i8 = i11113 | i12;
            } else {
                i8 = i3;
            }
            if ((i & 3670016) == 0) {
                jM3031copywmQWz5c$default = j2;
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i8 |= i11;
            } else {
                jM3031copywmQWz5c$default = j2;
            }
            if ((i2 & 128) != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                }
                if ((23967451 & i8) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 32) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -458753;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 64) != 0) {
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -3670017;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 32) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -458753;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 64) != 0) {
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -3670017;
                        }
                    }
                    MutableInteractionSource mutableInteractionSource117 = mutableInteractionSource2;
                    long j117 = jM3031copywmQWz5c$default;
                    i10 = i8;
                    Modifier modifier116 = modifier2;
                    boolean z118 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                    }
                    int i11114 = i10 >> 15;
                    m1247TabTransitionKlgxPg(jM3042unboximpl, j117, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier116, z, mutableInteractionSource117, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z118, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i11114 & 112) | (i11114 & 14) | 3072 | ((i10 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier116;
                    z4 = z118;
                    mutableInteractionSource3 = mutableInteractionSource117;
                    j3 = jM3042unboximpl;
                    jM3031copywmQWz5c$default = j117;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 32) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -458753;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 64) != 0) {
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -3670017;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if ((i2 & 32) != 0) {
                            jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                            i8 &= -458753;
                        } else {
                            jM3042unboximpl = j;
                        }
                        if ((i2 & 64) != 0) {
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -3670017;
                        }
                    }
                    MutableInteractionSource mutableInteractionSource118 = mutableInteractionSource2;
                    long j118 = jM3031copywmQWz5c$default;
                    i10 = i8;
                    Modifier modifier117 = modifier2;
                    boolean z119 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                    }
                    int i11115 = i10 >> 15;
                    m1247TabTransitionKlgxPg(jM3042unboximpl, j118, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier117, z, mutableInteractionSource118, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z119, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i11115 & 112) | (i11115 & 14) | 3072 | ((i10 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier117;
                    z4 = z119;
                    mutableInteractionSource3 = mutableInteractionSource118;
                    j3 = jM3042unboximpl;
                    jM3031copywmQWz5c$default = j118;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$6(z, interfaceC3588op, modifier2, z4, mutableInteractionSource3, j3, jM3031copywmQWz5c$default, interfaceC0552Gp, i, i2));
            }
            i9 = 12582912;
            i8 |= i9;
            if ((23967451 & i8) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 32) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -458753;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 64) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i8 &= -3670017;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 32) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -458753;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 64) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i8 &= -3670017;
                    }
                }
                MutableInteractionSource mutableInteractionSource119 = mutableInteractionSource2;
                long j119 = jM3031copywmQWz5c$default;
                i10 = i8;
                Modifier modifier118 = modifier2;
                boolean z1110 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                }
                int i11116 = i10 >> 15;
                m1247TabTransitionKlgxPg(jM3042unboximpl, j119, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier118, z, mutableInteractionSource119, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z1110, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i11116 & 112) | (i11116 & 14) | 3072 | ((i10 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier118;
                z4 = z1110;
                mutableInteractionSource3 = mutableInteractionSource119;
                j3 = jM3042unboximpl;
                jM3031copywmQWz5c$default = j119;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 32) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -458753;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 64) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i8 &= -3670017;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 32) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -458753;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 64) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i8 &= -3670017;
                    }
                }
                MutableInteractionSource mutableInteractionSource1110 = mutableInteractionSource2;
                long j1110 = jM3031copywmQWz5c$default;
                i10 = i8;
                Modifier modifier119 = modifier2;
                boolean z1111 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                }
                int i11117 = i10 >> 15;
                m1247TabTransitionKlgxPg(jM3042unboximpl, j1110, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier119, z, mutableInteractionSource1110, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z1111, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i11117 & 112) | (i11117 & 14) | 3072 | ((i10 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier119;
                z4 = z1111;
                mutableInteractionSource3 = mutableInteractionSource1110;
                j3 = jM3042unboximpl;
                jM3031copywmQWz5c$default = j1110;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$6(z, interfaceC3588op, modifier2, z4, mutableInteractionSource3, j3, jM3031copywmQWz5c$default, interfaceC0552Gp, i, i2));
        }
        i3 |= 24576;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((458752 & i) == 0) {
            int i11118 = i3;
            if ((i2 & 32) == 0) {
                i12 = 65536;
            } else {
                i12 = 65536;
            }
            i8 = i11118 | i12;
        } else {
            i8 = i3;
        }
        if ((i & 3670016) == 0) {
            jM3031copywmQWz5c$default = j2;
            if ((i2 & 64) == 0) {
                i11 = 524288;
            } else {
                i11 = 524288;
            }
            i8 |= i11;
        } else {
            jM3031copywmQWz5c$default = j2;
        }
        if ((i2 & 128) != 0) {
            if ((29360128 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
            }
            if ((23967451 & i8) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 32) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -458753;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 64) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i8 &= -3670017;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 32) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -458753;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 64) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i8 &= -3670017;
                    }
                }
                MutableInteractionSource mutableInteractionSource1111 = mutableInteractionSource2;
                long j1111 = jM3031copywmQWz5c$default;
                i10 = i8;
                Modifier modifier1110 = modifier2;
                boolean z1112 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                }
                int i11119 = i10 >> 15;
                m1247TabTransitionKlgxPg(jM3042unboximpl, j1111, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier1110, z, mutableInteractionSource1111, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z1112, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i11119 & 112) | (i11119 & 14) | 3072 | ((i10 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier1110;
                z4 = z1112;
                mutableInteractionSource3 = mutableInteractionSource1111;
                j3 = jM3042unboximpl;
                jM3031copywmQWz5c$default = j1111;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 32) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -458753;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 64) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i8 &= -3670017;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if ((i2 & 32) != 0) {
                        jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                        i8 &= -458753;
                    } else {
                        jM3042unboximpl = j;
                    }
                    if ((i2 & 64) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i8 &= -3670017;
                    }
                }
                MutableInteractionSource mutableInteractionSource1112 = mutableInteractionSource2;
                long j1112 = jM3031copywmQWz5c$default;
                i10 = i8;
                Modifier modifier1111 = modifier2;
                boolean z1113 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
                }
                int i111110 = i10 >> 15;
                m1247TabTransitionKlgxPg(jM3042unboximpl, j1112, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier1111, z, mutableInteractionSource1112, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z1113, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i111110 & 112) | (i111110 & 14) | 3072 | ((i10 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier1111;
                z4 = z1113;
                mutableInteractionSource3 = mutableInteractionSource1112;
                j3 = jM3042unboximpl;
                jM3031copywmQWz5c$default = j1112;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$6(z, interfaceC3588op, modifier2, z4, mutableInteractionSource3, j3, jM3031copywmQWz5c$default, interfaceC0552Gp, i, i2));
        }
        i9 = 12582912;
        i8 |= i9;
        if ((23967451 & i8) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if ((i2 & 32) != 0) {
                    jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                    i8 &= -458753;
                } else {
                    jM3042unboximpl = j;
                }
                if ((i2 & 64) != 0) {
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    i8 &= -3670017;
                }
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if ((i2 & 32) != 0) {
                    jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                    i8 &= -458753;
                } else {
                    jM3042unboximpl = j;
                }
                if ((i2 & 64) != 0) {
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    i8 &= -3670017;
                }
            }
            MutableInteractionSource mutableInteractionSource1113 = mutableInteractionSource2;
            long j1113 = jM3031copywmQWz5c$default;
            i10 = i8;
            Modifier modifier1112 = modifier2;
            boolean z1114 = z3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
            }
            int i111111 = i10 >> 15;
            m1247TabTransitionKlgxPg(jM3042unboximpl, j1113, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier1112, z, mutableInteractionSource1113, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z1114, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i111111 & 112) | (i111111 & 14) | 3072 | ((i10 << 6) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier1112;
            z4 = z1114;
            mutableInteractionSource3 = mutableInteractionSource1113;
            j3 = jM3042unboximpl;
            jM3031copywmQWz5c$default = j1113;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if ((i2 & 32) != 0) {
                    jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                    i8 &= -458753;
                } else {
                    jM3042unboximpl = j;
                }
                if ((i2 & 64) != 0) {
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    i8 &= -3670017;
                }
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if ((i2 & 32) != 0) {
                    jM3042unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl();
                    i8 &= -458753;
                } else {
                    jM3042unboximpl = j;
                }
                if ((i2 & 64) != 0) {
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3042unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    i8 &= -3670017;
                }
            }
            MutableInteractionSource mutableInteractionSource1114 = mutableInteractionSource2;
            long j1114 = jM3031copywmQWz5c$default;
            i10 = i8;
            Modifier modifier1113 = modifier2;
            boolean z1115 = z3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(713679175, i10, -1, "androidx.compose.material.Tab (Tab.kt:222)");
            }
            int i111112 = i10 >> 15;
            m1247TabTransitionKlgxPg(jM3042unboximpl, j1114, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1237246709, true, new TabKt$Tab$5(modifier1113, z, mutableInteractionSource1114, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, jM3042unboximpl, composerStartRestartGroup, ((i10 >> 9) & 896) | 6, 2), z1115, interfaceC3588op, interfaceC0552Gp, i10)), composerStartRestartGroup, (i111112 & 112) | (i111112 & 14) | 3072 | ((i10 << 6) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier1113;
            z4 = z1115;
            mutableInteractionSource3 = mutableInteractionSource1114;
            j3 = jM3042unboximpl;
            jM3031copywmQWz5c$default = j1114;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new TabKt$Tab$6(z, interfaceC3588op, modifier2, z4, mutableInteractionSource3, j3, jM3031copywmQWz5c$default, interfaceC0552Gp, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void TabBaselineLayout(final InterfaceC0526Fp interfaceC0526Fp, final InterfaceC0526Fp interfaceC0526Fp2, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1249848471);
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
                ComposerKt.traceEventStart(1249848471, i2, -1, "androidx.compose.material.TabBaselineLayout (Tab.kt:300)");
            }
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material.TabKt.TabBaselineLayout.2
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
                    int iMo327roundToPx0680j_4 = measureScope.mo327roundToPx0680j_4((placeableMo4159measureBRTryo0 == null || placeableMo4159measureBRTryo1 == null) ? TabKt.SmallTabHeight : TabKt.LargeTabHeight);
                    return MeasureScope.CC.q(measureScope, iMax, iMo327roundToPx0680j_4, null, new TabKt$TabBaselineLayout$2$measure$1(placeableMo4159measureBRTryo0, placeableMo4159measureBRTryo1, measureScope, iMax, iMo327roundToPx0680j_4, placeableMo4159measureBRTryo0 != null ? Integer.valueOf(placeableMo4159measureBRTryo0.get(AlignmentLineKt.getFirstBaseline())) : null, placeableMo4159measureBRTryo0 != null ? Integer.valueOf(placeableMo4159measureBRTryo0.get(AlignmentLineKt.getLastBaseline())) : null), 4, null);
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
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            InterfaceC0526Fp setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2141028452);
            if (interfaceC0526Fp != null) {
                Modifier modifierM487paddingVpY3zN4$default = PaddingKt.m487paddingVpY3zN4$default(LayoutIdKt.layoutId(companion, "text"), HorizontalTextPadding, 0.0f, 2, null);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                InterfaceC3588op constructor2 = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifierM487paddingVpY3zN4$default);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                InterfaceC0526Fp setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                if (composerM2661constructorimpl2.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                interfaceC0552GpModifierMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf(i2 & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(448373045);
            if (interfaceC0526Fp2 != null) {
                Modifier modifierLayoutId = LayoutIdKt.layoutId(companion, "icon");
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                InterfaceC3588op constructor3 = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifierLayoutId);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM2661constructorimpl3 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyRememberBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl3, currentCompositionLocalMap3, companion2.getSetResolvedCompositionLocals());
                InterfaceC0526Fp setCompositeKeyHash3 = companion2.getSetCompositeKeyHash();
                if (composerM2661constructorimpl3.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    composerM2661constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM2661constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                interfaceC0552GpModifierMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
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
    public static final void m1247TabTransitionKlgxPg(long j, long j2, boolean z, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-405571117);
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
                ComposerKt.traceEventStart(-405571117, i2, -1, "androidx.compose.material.TabTransition (Tab.kt:262)");
            }
            int i3 = i2 >> 6;
            Transition transitionUpdateTransition = TransitionKt.updateTransition(Boolean.valueOf(z), (String) null, composerStartRestartGroup, i3 & 14, 2);
            TabKt$TabTransition$color$2 tabKt$TabTransition$color$2 = TabKt$TabTransition$color$2.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-1939694975);
            boolean zBooleanValue = ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(1445938070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1445938070, 0, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:284)");
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
            composerStartRestartGroup.startReplaceableGroup(1445938070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1445938070, 0, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:284)");
            }
            long j4 = zBooleanValue2 ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            Color colorM3022boximpl = Color.m3022boximpl(j4);
            boolean zBooleanValue3 = ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(1445938070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1445938070, 0, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:284)");
            }
            long j5 = zBooleanValue3 ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM3022boximpl, Color.m3022boximpl(j5), (FiniteAnimationSpec) tabKt$TabTransition$color$2.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), twoWayConverter, "ColorAnimation", composerStartRestartGroup, 32768);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(Color.m3031copywmQWz5c$default(TabTransition_Klgx_Pg$lambda$5(stateCreateTransitionAnimation), 1.0f, 0.0f, 0.0f, 0.0f, 14, null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m3034getAlphaimpl(TabTransition_Klgx_Pg$lambda$5(stateCreateTransitionAnimation))))}, interfaceC0526Fp, composerStartRestartGroup, (i3 & 112) | 8);
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
        int iMo327roundToPx0680j_4 = density.mo327roundToPx0680j_4(i3 == i4 ? SingleLineTextBaselineWithIcon : DoubleLineTextBaselineWithIcon) + density.mo327roundToPx0680j_4(TabRowDefaults.INSTANCE.m1255getIndicatorHeightD9Ej5fM());
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
