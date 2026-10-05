package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import org.apache.poi.ss.util.IEEEDouble;

/* JADX INFO: loaded from: classes.dex */
@Stable
public final class SliderDefaults {
    public static final int $stable = 0;
    public static final SliderDefaults INSTANCE = new SliderDefaults();

    /* JADX INFO: renamed from: androidx.compose.material3.SliderDefaults$Track$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ SliderColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ SliderPositions $sliderPositions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(SliderPositions sliderPositions, Modifier modifier, SliderColors sliderColors, boolean z, int i, int i2) {
            super(2);
            this.$sliderPositions = sliderPositions;
            this.$modifier = modifier;
            this.$colors = sliderColors;
            this.$enabled = z;
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
            SliderDefaults.this.Track(this.$sliderPositions, this.$modifier, this.$colors, this.$enabled, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    private SliderDefaults() {
    }

    /* JADX WARN: Code duplicated, block: B:100:0x016c  */
    /* JADX WARN: Code duplicated, block: B:102:0x0172  */
    /* JADX WARN: Code duplicated, block: B:105:0x018a  */
    /* JADX WARN: Code duplicated, block: B:106:0x018f  */
    /* JADX WARN: Code duplicated, block: B:110:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:113:0x020f  */
    /* JADX WARN: Code duplicated, block: B:118:0x021d  */
    /* JADX WARN: Code duplicated, block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0049  */
    /* JADX WARN: Code duplicated, block: B:28:0x004d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0055  */
    /* JADX WARN: Code duplicated, block: B:31:0x0058  */
    /* JADX WARN: Code duplicated, block: B:34:0x005e  */
    /* JADX WARN: Code duplicated, block: B:37:0x0064  */
    /* JADX WARN: Code duplicated, block: B:39:0x0069  */
    /* JADX WARN: Code duplicated, block: B:41:0x006d  */
    /* JADX WARN: Code duplicated, block: B:43:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x0078  */
    /* JADX WARN: Code duplicated, block: B:48:0x007f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0084  */
    /* JADX WARN: Code duplicated, block: B:51:0x008c  */
    /* JADX WARN: Code duplicated, block: B:53:0x0092  */
    /* JADX WARN: Code duplicated, block: B:54:0x0095  */
    /* JADX WARN: Code duplicated, block: B:58:0x009c  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:63:0x00af  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:68:0x00be  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:87:0x0119  */
    /* JADX WARN: Code duplicated, block: B:88:0x011b  */
    /* JADX WARN: Code duplicated, block: B:90:0x011f  */
    /* JADX WARN: Code duplicated, block: B:91:0x0125  */
    /* JADX WARN: Code duplicated, block: B:94:0x0130  */
    /* JADX WARN: Code duplicated, block: B:97:0x0148  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Thumb-9LiSoMs, reason: not valid java name */
    public final void m1752Thumb9LiSoMs(MutableInteractionSource mutableInteractionSource, Modifier modifier, SliderColors sliderColors, boolean z, long j, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        SliderColors sliderColors2;
        int i4;
        boolean z2;
        int i5;
        int i6;
        long j2;
        int i7;
        int i8;
        boolean z3;
        Object objRememberedValue;
        Composer.Companion companion;
        SnapshotStateList snapshotStateList;
        boolean zChanged;
        Object objRememberedValue2;
        float fM5160constructorimpl;
        Modifier modifier3;
        SliderColors sliderColors3;
        long j3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(mutableInteractionSource, "interactionSource");
        Composer composerStartRestartGroup = composer.startRestartGroup(-290277409);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(mutableInteractionSource) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                if ((i2 & 4) == 0) {
                    sliderColors2 = sliderColors;
                    int i10 = composerStartRestartGroup.changed(sliderColors2) ? 256 : 128;
                    i3 |= i10;
                } else {
                    sliderColors2 = sliderColors;
                }
                i3 |= i10;
            } else {
                sliderColors2 = sliderColors;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    i3 |= 24576;
                    j2 = j;
                } else {
                    j2 = j;
                    if ((57344 & i) == 0) {
                        if (composerStartRestartGroup.changed(j2)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                }
                if ((i2 & 32) != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i3 |= i8;
                }
                if ((374491 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i9 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            SliderColors sliderColorsM1753colorsq0g_0yA = m1753colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, (i3 >> 15) & 14, IEEEDouble.EXPONENT_BIAS);
                            i3 &= -897;
                            sliderColors2 = sliderColorsM1753colorsq0g_0yA;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z;
                        }
                        if (i6 != 0) {
                            j2 = SliderKt.ThumbSize;
                        } else {
                            j2 = j;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        z3 = z2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-290277409, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:950)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateListOf();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    snapshotStateList = (SnapshotStateList) objRememberedValue;
                    int i11 = i3 & 14;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(mutableInteractionSource) | composerStartRestartGroup.changed(snapshotStateList);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new SliderDefaults$Thumb$1$1(mutableInteractionSource, snapshotStateList, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(mutableInteractionSource, (InterfaceC0526Fp) objRememberedValue2, composerStartRestartGroup, i11 | 64);
                    if (snapshotStateList.isEmpty()) {
                        fM5160constructorimpl = SliderKt.ThumbDefaultElevation;
                    } else {
                        fM5160constructorimpl = SliderKt.ThumbPressedElevation;
                    }
                    SliderTokens sliderTokens = SliderTokens.INSTANCE;
                    Shape shape = ShapesKt.toShape(sliderTokens.getHandleShape(), composerStartRestartGroup, 6);
                    long j4 = j2;
                    Modifier modifierHoverable$default = HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m533size6HolHcs(modifier2, j2), mutableInteractionSource, RippleKt.m1318rememberRipple9IZ8Weo(false, Dp.m5160constructorimpl(sliderTokens.m2509getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4)), mutableInteractionSource, false, 2, null);
                    if (!z3) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    SpacerKt.Spacer(BackgroundKt.m166backgroundbw27NRU(ShadowKt.m2707shadows4CzXII$default(modifierHoverable$default, fM5160constructorimpl, shape, false, 0L, 0L, 24, null), sliderColors2.thumbColor$material3_release(z3, composerStartRestartGroup, ((i3 >> 3) & 112) | ((i3 >> 9) & 14)).getValue().m3042unboximpl(), shape), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    sliderColors3 = sliderColors2;
                    j3 = j4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    sliderColors3 = sliderColors2;
                    z3 = z2;
                    j3 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new SliderDefaults$Thumb$2(this, mutableInteractionSource, modifier3, sliderColors3, z3, j3, i, i2));
            }
            i3 |= 3072;
            z2 = z;
            i6 = i2 & 16;
            if (i6 != 0) {
                i3 |= 24576;
                j2 = j;
            } else {
                j2 = j;
                if ((57344 & i) == 0) {
                    if (composerStartRestartGroup.changed(j2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
            }
            if ((i2 & 32) != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((458752 & i) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i3 |= i8;
            }
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        SliderColors sliderColorsM1753colorsq0g_0yA2 = m1753colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, (i3 >> 15) & 14, IEEEDouble.EXPONENT_BIAS);
                        i3 &= -897;
                        sliderColors2 = sliderColorsM1753colorsq0g_0yA2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z;
                    }
                    if (i6 != 0) {
                        j2 = SliderKt.ThumbSize;
                    } else {
                        j2 = j;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        SliderColors sliderColorsM1753colorsq0g_0yA3 = m1753colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, (i3 >> 15) & 14, IEEEDouble.EXPONENT_BIAS);
                        i3 &= -897;
                        sliderColors2 = sliderColorsM1753colorsq0g_0yA3;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z;
                    }
                    if (i6 != 0) {
                        j2 = SliderKt.ThumbSize;
                    } else {
                        j2 = j;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-290277409, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:950)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.mutableStateListOf();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                snapshotStateList = (SnapshotStateList) objRememberedValue;
                int i12 = i3 & 14;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(mutableInteractionSource) | composerStartRestartGroup.changed(snapshotStateList);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new SliderDefaults$Thumb$1$1(mutableInteractionSource, snapshotStateList, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new SliderDefaults$Thumb$1$1(mutableInteractionSource, snapshotStateList, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect(mutableInteractionSource, (InterfaceC0526Fp) objRememberedValue2, composerStartRestartGroup, i12 | 64);
                if (snapshotStateList.isEmpty()) {
                    fM5160constructorimpl = SliderKt.ThumbPressedElevation;
                } else {
                    fM5160constructorimpl = SliderKt.ThumbDefaultElevation;
                }
                SliderTokens sliderTokens2 = SliderTokens.INSTANCE;
                Shape shape2 = ShapesKt.toShape(sliderTokens2.getHandleShape(), composerStartRestartGroup, 6);
                long j5 = j2;
                Modifier modifierHoverable$default2 = HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m533size6HolHcs(modifier2, j2), mutableInteractionSource, RippleKt.m1318rememberRipple9IZ8Weo(false, Dp.m5160constructorimpl(sliderTokens2.m2509getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4)), mutableInteractionSource, false, 2, null);
                if (!z3) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                SpacerKt.Spacer(BackgroundKt.m166backgroundbw27NRU(ShadowKt.m2707shadows4CzXII$default(modifierHoverable$default2, fM5160constructorimpl, shape2, false, 0L, 0L, 24, null), sliderColors2.thumbColor$material3_release(z3, composerStartRestartGroup, ((i3 >> 3) & 112) | ((i3 >> 9) & 14)).getValue().m3042unboximpl(), shape2), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                sliderColors3 = sliderColors2;
                j3 = j5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        SliderColors sliderColorsM1753colorsq0g_0yA4 = m1753colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, (i3 >> 15) & 14, IEEEDouble.EXPONENT_BIAS);
                        i3 &= -897;
                        sliderColors2 = sliderColorsM1753colorsq0g_0yA4;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z;
                    }
                    if (i6 != 0) {
                        j2 = SliderKt.ThumbSize;
                    } else {
                        j2 = j;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        SliderColors sliderColorsM1753colorsq0g_0yA5 = m1753colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, (i3 >> 15) & 14, IEEEDouble.EXPONENT_BIAS);
                        i3 &= -897;
                        sliderColors2 = sliderColorsM1753colorsq0g_0yA5;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z;
                    }
                    if (i6 != 0) {
                        j2 = SliderKt.ThumbSize;
                    } else {
                        j2 = j;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-290277409, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:950)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.mutableStateListOf();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                snapshotStateList = (SnapshotStateList) objRememberedValue;
                int i13 = i3 & 14;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(mutableInteractionSource) | composerStartRestartGroup.changed(snapshotStateList);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new SliderDefaults$Thumb$1$1(mutableInteractionSource, snapshotStateList, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new SliderDefaults$Thumb$1$1(mutableInteractionSource, snapshotStateList, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect(mutableInteractionSource, (InterfaceC0526Fp) objRememberedValue2, composerStartRestartGroup, i13 | 64);
                if (snapshotStateList.isEmpty()) {
                    fM5160constructorimpl = SliderKt.ThumbPressedElevation;
                } else {
                    fM5160constructorimpl = SliderKt.ThumbDefaultElevation;
                }
                SliderTokens sliderTokens3 = SliderTokens.INSTANCE;
                Shape shape3 = ShapesKt.toShape(sliderTokens3.getHandleShape(), composerStartRestartGroup, 6);
                long j6 = j2;
                Modifier modifierHoverable$default3 = HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m533size6HolHcs(modifier2, j2), mutableInteractionSource, RippleKt.m1318rememberRipple9IZ8Weo(false, Dp.m5160constructorimpl(sliderTokens3.m2509getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4)), mutableInteractionSource, false, 2, null);
                if (!z3) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                SpacerKt.Spacer(BackgroundKt.m166backgroundbw27NRU(ShadowKt.m2707shadows4CzXII$default(modifierHoverable$default3, fM5160constructorimpl, shape3, false, 0L, 0L, 24, null), sliderColors2.thumbColor$material3_release(z3, composerStartRestartGroup, ((i3 >> 3) & 112) | ((i3 >> 9) & 14)).getValue().m3042unboximpl(), shape3), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                sliderColors3 = sliderColors2;
                j3 = j6;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SliderDefaults$Thumb$2(this, mutableInteractionSource, modifier3, sliderColors3, z3, j3, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                sliderColors2 = sliderColors;
                if (composerStartRestartGroup.changed(sliderColors2)) {
                }
                i3 |= i10;
            } else {
                sliderColors2 = sliderColors;
            }
            i3 |= i10;
        } else {
            sliderColors2 = sliderColors;
        }
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                i3 |= 24576;
                j2 = j;
            } else {
                j2 = j;
                if ((57344 & i) == 0) {
                    if (composerStartRestartGroup.changed(j2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
            }
            if ((i2 & 32) != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((458752 & i) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i3 |= i8;
            }
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        SliderColors sliderColorsM1753colorsq0g_0yA6 = m1753colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, (i3 >> 15) & 14, IEEEDouble.EXPONENT_BIAS);
                        i3 &= -897;
                        sliderColors2 = sliderColorsM1753colorsq0g_0yA6;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z;
                    }
                    if (i6 != 0) {
                        j2 = SliderKt.ThumbSize;
                    } else {
                        j2 = j;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        SliderColors sliderColorsM1753colorsq0g_0yA7 = m1753colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, (i3 >> 15) & 14, IEEEDouble.EXPONENT_BIAS);
                        i3 &= -897;
                        sliderColors2 = sliderColorsM1753colorsq0g_0yA7;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z;
                    }
                    if (i6 != 0) {
                        j2 = SliderKt.ThumbSize;
                    } else {
                        j2 = j;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-290277409, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:950)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.mutableStateListOf();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                snapshotStateList = (SnapshotStateList) objRememberedValue;
                int i14 = i3 & 14;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(mutableInteractionSource) | composerStartRestartGroup.changed(snapshotStateList);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new SliderDefaults$Thumb$1$1(mutableInteractionSource, snapshotStateList, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new SliderDefaults$Thumb$1$1(mutableInteractionSource, snapshotStateList, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect(mutableInteractionSource, (InterfaceC0526Fp) objRememberedValue2, composerStartRestartGroup, i14 | 64);
                if (snapshotStateList.isEmpty()) {
                    fM5160constructorimpl = SliderKt.ThumbPressedElevation;
                } else {
                    fM5160constructorimpl = SliderKt.ThumbDefaultElevation;
                }
                SliderTokens sliderTokens4 = SliderTokens.INSTANCE;
                Shape shape4 = ShapesKt.toShape(sliderTokens4.getHandleShape(), composerStartRestartGroup, 6);
                long j7 = j2;
                Modifier modifierHoverable$default4 = HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m533size6HolHcs(modifier2, j2), mutableInteractionSource, RippleKt.m1318rememberRipple9IZ8Weo(false, Dp.m5160constructorimpl(sliderTokens4.m2509getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4)), mutableInteractionSource, false, 2, null);
                if (!z3) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                SpacerKt.Spacer(BackgroundKt.m166backgroundbw27NRU(ShadowKt.m2707shadows4CzXII$default(modifierHoverable$default4, fM5160constructorimpl, shape4, false, 0L, 0L, 24, null), sliderColors2.thumbColor$material3_release(z3, composerStartRestartGroup, ((i3 >> 3) & 112) | ((i3 >> 9) & 14)).getValue().m3042unboximpl(), shape4), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                sliderColors3 = sliderColors2;
                j3 = j7;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        SliderColors sliderColorsM1753colorsq0g_0yA8 = m1753colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, (i3 >> 15) & 14, IEEEDouble.EXPONENT_BIAS);
                        i3 &= -897;
                        sliderColors2 = sliderColorsM1753colorsq0g_0yA8;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z;
                    }
                    if (i6 != 0) {
                        j2 = SliderKt.ThumbSize;
                    } else {
                        j2 = j;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        SliderColors sliderColorsM1753colorsq0g_0yA9 = m1753colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, (i3 >> 15) & 14, IEEEDouble.EXPONENT_BIAS);
                        i3 &= -897;
                        sliderColors2 = sliderColorsM1753colorsq0g_0yA9;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z;
                    }
                    if (i6 != 0) {
                        j2 = SliderKt.ThumbSize;
                    } else {
                        j2 = j;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-290277409, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:950)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.mutableStateListOf();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                snapshotStateList = (SnapshotStateList) objRememberedValue;
                int i15 = i3 & 14;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(mutableInteractionSource) | composerStartRestartGroup.changed(snapshotStateList);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new SliderDefaults$Thumb$1$1(mutableInteractionSource, snapshotStateList, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new SliderDefaults$Thumb$1$1(mutableInteractionSource, snapshotStateList, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect(mutableInteractionSource, (InterfaceC0526Fp) objRememberedValue2, composerStartRestartGroup, i15 | 64);
                if (snapshotStateList.isEmpty()) {
                    fM5160constructorimpl = SliderKt.ThumbPressedElevation;
                } else {
                    fM5160constructorimpl = SliderKt.ThumbDefaultElevation;
                }
                SliderTokens sliderTokens5 = SliderTokens.INSTANCE;
                Shape shape5 = ShapesKt.toShape(sliderTokens5.getHandleShape(), composerStartRestartGroup, 6);
                long j8 = j2;
                Modifier modifierHoverable$default5 = HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m533size6HolHcs(modifier2, j2), mutableInteractionSource, RippleKt.m1318rememberRipple9IZ8Weo(false, Dp.m5160constructorimpl(sliderTokens5.m2509getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4)), mutableInteractionSource, false, 2, null);
                if (!z3) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                SpacerKt.Spacer(BackgroundKt.m166backgroundbw27NRU(ShadowKt.m2707shadows4CzXII$default(modifierHoverable$default5, fM5160constructorimpl, shape5, false, 0L, 0L, 24, null), sliderColors2.thumbColor$material3_release(z3, composerStartRestartGroup, ((i3 >> 3) & 112) | ((i3 >> 9) & 14)).getValue().m3042unboximpl(), shape5), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                sliderColors3 = sliderColors2;
                j3 = j8;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new SliderDefaults$Thumb$2(this, mutableInteractionSource, modifier3, sliderColors3, z3, j3, i, i2));
        }
        i3 |= 3072;
        z2 = z;
        i6 = i2 & 16;
        if (i6 != 0) {
            i3 |= 24576;
            j2 = j;
        } else {
            j2 = j;
            if ((57344 & i) == 0) {
                if (composerStartRestartGroup.changed(j2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
        }
        if ((i2 & 32) != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((458752 & i) == 0) {
            if (composerStartRestartGroup.changed(this)) {
                i8 = 131072;
            } else {
                i8 = 65536;
            }
            i3 |= i8;
        }
        if ((374491 & i3) == 74898) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    SliderColors sliderColorsM1753colorsq0g_0yA10 = m1753colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, (i3 >> 15) & 14, IEEEDouble.EXPONENT_BIAS);
                    i3 &= -897;
                    sliderColors2 = sliderColorsM1753colorsq0g_0yA10;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z;
                }
                if (i6 != 0) {
                    j2 = SliderKt.ThumbSize;
                } else {
                    j2 = j;
                }
            } else {
                if (i9 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    SliderColors sliderColorsM1753colorsq0g_0yA11 = m1753colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, (i3 >> 15) & 14, IEEEDouble.EXPONENT_BIAS);
                    i3 &= -897;
                    sliderColors2 = sliderColorsM1753colorsq0g_0yA11;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z;
                }
                if (i6 != 0) {
                    j2 = SliderKt.ThumbSize;
                } else {
                    j2 = j;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-290277409, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:950)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateListOf();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            snapshotStateList = (SnapshotStateList) objRememberedValue;
            int i16 = i3 & 14;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged = composerStartRestartGroup.changed(mutableInteractionSource) | composerStartRestartGroup.changed(snapshotStateList);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = new SliderDefaults$Thumb$1$1(mutableInteractionSource, snapshotStateList, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new SliderDefaults$Thumb$1$1(mutableInteractionSource, snapshotStateList, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(mutableInteractionSource, (InterfaceC0526Fp) objRememberedValue2, composerStartRestartGroup, i16 | 64);
            if (snapshotStateList.isEmpty()) {
                fM5160constructorimpl = SliderKt.ThumbPressedElevation;
            } else {
                fM5160constructorimpl = SliderKt.ThumbDefaultElevation;
            }
            SliderTokens sliderTokens6 = SliderTokens.INSTANCE;
            Shape shape6 = ShapesKt.toShape(sliderTokens6.getHandleShape(), composerStartRestartGroup, 6);
            long j9 = j2;
            Modifier modifierHoverable$default6 = HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m533size6HolHcs(modifier2, j2), mutableInteractionSource, RippleKt.m1318rememberRipple9IZ8Weo(false, Dp.m5160constructorimpl(sliderTokens6.m2509getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4)), mutableInteractionSource, false, 2, null);
            if (!z3) {
                fM5160constructorimpl = Dp.m5160constructorimpl(0);
            }
            SpacerKt.Spacer(BackgroundKt.m166backgroundbw27NRU(ShadowKt.m2707shadows4CzXII$default(modifierHoverable$default6, fM5160constructorimpl, shape6, false, 0L, 0L, 24, null), sliderColors2.thumbColor$material3_release(z3, composerStartRestartGroup, ((i3 >> 3) & 112) | ((i3 >> 9) & 14)).getValue().m3042unboximpl(), shape6), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            sliderColors3 = sliderColors2;
            j3 = j9;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    SliderColors sliderColorsM1753colorsq0g_0yA12 = m1753colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, (i3 >> 15) & 14, IEEEDouble.EXPONENT_BIAS);
                    i3 &= -897;
                    sliderColors2 = sliderColorsM1753colorsq0g_0yA12;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z;
                }
                if (i6 != 0) {
                    j2 = SliderKt.ThumbSize;
                } else {
                    j2 = j;
                }
            } else {
                if (i9 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    SliderColors sliderColorsM1753colorsq0g_0yA13 = m1753colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, (i3 >> 15) & 14, IEEEDouble.EXPONENT_BIAS);
                    i3 &= -897;
                    sliderColors2 = sliderColorsM1753colorsq0g_0yA13;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z;
                }
                if (i6 != 0) {
                    j2 = SliderKt.ThumbSize;
                } else {
                    j2 = j;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-290277409, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:950)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateListOf();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            snapshotStateList = (SnapshotStateList) objRememberedValue;
            int i17 = i3 & 14;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged = composerStartRestartGroup.changed(mutableInteractionSource) | composerStartRestartGroup.changed(snapshotStateList);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = new SliderDefaults$Thumb$1$1(mutableInteractionSource, snapshotStateList, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new SliderDefaults$Thumb$1$1(mutableInteractionSource, snapshotStateList, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(mutableInteractionSource, (InterfaceC0526Fp) objRememberedValue2, composerStartRestartGroup, i17 | 64);
            if (snapshotStateList.isEmpty()) {
                fM5160constructorimpl = SliderKt.ThumbPressedElevation;
            } else {
                fM5160constructorimpl = SliderKt.ThumbDefaultElevation;
            }
            SliderTokens sliderTokens7 = SliderTokens.INSTANCE;
            Shape shape7 = ShapesKt.toShape(sliderTokens7.getHandleShape(), composerStartRestartGroup, 6);
            long j10 = j2;
            Modifier modifierHoverable$default7 = HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m533size6HolHcs(modifier2, j2), mutableInteractionSource, RippleKt.m1318rememberRipple9IZ8Weo(false, Dp.m5160constructorimpl(sliderTokens7.m2509getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4)), mutableInteractionSource, false, 2, null);
            if (!z3) {
                fM5160constructorimpl = Dp.m5160constructorimpl(0);
            }
            SpacerKt.Spacer(BackgroundKt.m166backgroundbw27NRU(ShadowKt.m2707shadows4CzXII$default(modifierHoverable$default7, fM5160constructorimpl, shape7, false, 0L, 0L, 24, null), sliderColors2.thumbColor$material3_release(z3, composerStartRestartGroup, ((i3 >> 3) & 112) | ((i3 >> 9) & 14)).getValue().m3042unboximpl(), shape7), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            sliderColors3 = sliderColors2;
            j3 = j10;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new SliderDefaults$Thumb$2(this, mutableInteractionSource, modifier3, sliderColors3, z3, j3, i, i2));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v4 ??, still in use, count: 1, list:
          (r8v4 ?? I:java.lang.Object) from 0x018c: INVOKE (r10v22 ?? I:androidx.compose.runtime.Composer), (r8v4 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:397)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    public final void Track(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v4 ??, still in use, count: 1, list:
          (r8v4 ?? I:java.lang.Object) from 0x018c: INVOKE (r10v22 ?? I:androidx.compose.runtime.Composer), (r8v4 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:397)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r36v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */

    @Composable
    /* JADX INFO: renamed from: colors-q0g_0yA, reason: not valid java name */
    public final SliderColors m1753colorsq0g_0yA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, Composer composer, int i, int i2, int i3) {
        composer.startReplaceableGroup(885588574);
        long color = (i3 & 1) != 0 ? ColorSchemeKt.toColor(SliderTokens.INSTANCE.getHandleColor(), composer, 6) : j;
        long color2 = (i3 & 2) != 0 ? ColorSchemeKt.toColor(SliderTokens.INSTANCE.getActiveTrackColor(), composer, 6) : j2;
        long jM3031copywmQWz5c$default = (i3 & 4) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getTickMarksActiveContainerColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long color3 = (i3 & 8) != 0 ? ColorSchemeKt.toColor(SliderTokens.INSTANCE.getInactiveTrackColor(), composer, 6) : j4;
        long jM3031copywmQWz5c$default2 = (i3 & 16) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getTickMarksInactiveContainerColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        long jM3077compositeOverOWjLjI = (i3 & 32) != 0 ? ColorKt.m3077compositeOverOWjLjI(Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getDisabledHandleColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1413getSurface0d7_KjU()) : j6;
        long jM3031copywmQWz5c$default3 = (i3 & 64) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getDisabledActiveTrackColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        long jM3031copywmQWz5c$default4 = (i3 & 128) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getTickMarksDisabledContainerColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j8;
        long jM3031copywmQWz5c$default5 = (i3 & 256) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getDisabledInactiveTrackColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j9;
        long jM3031copywmQWz5c$default6 = (i3 & 512) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getTickMarksDisabledContainerColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j10;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(885588574, i, i2, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:896)");
        }
        SliderColors sliderColors = new SliderColors(color, color2, jM3031copywmQWz5c$default, color3, jM3031copywmQWz5c$default2, jM3077compositeOverOWjLjI, jM3031copywmQWz5c$default3, jM3031copywmQWz5c$default4, jM3031copywmQWz5c$default5, jM3031copywmQWz5c$default6, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return sliderColors;
    }
}
