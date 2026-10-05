package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.ClipScrollableContainerKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class LazyGridKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridKt$LazyGrid$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$changed1;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC3750qp $content;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ FlingBehavior $flingBehavior;
        final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
        final /* synthetic */ boolean $isVertical;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ boolean $reverseLayout;
        final /* synthetic */ InterfaceC0526Fp $slots;
        final /* synthetic */ LazyGridState $state;
        final /* synthetic */ boolean $userScrollEnabled;
        final /* synthetic */ Arrangement.Vertical $verticalArrangement;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Modifier modifier, LazyGridState lazyGridState, InterfaceC0526Fp interfaceC0526Fp, PaddingValues paddingValues, boolean z, boolean z2, FlingBehavior flingBehavior, boolean z3, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, InterfaceC3750qp interfaceC3750qp, int i, int i2, int i3) {
            super(2);
            this.$modifier = modifier;
            this.$state = lazyGridState;
            this.$slots = interfaceC0526Fp;
            this.$contentPadding = paddingValues;
            this.$reverseLayout = z;
            this.$isVertical = z2;
            this.$flingBehavior = flingBehavior;
            this.$userScrollEnabled = z3;
            this.$verticalArrangement = vertical;
            this.$horizontalArrangement = horizontal;
            this.$content = interfaceC3750qp;
            this.$$changed = i;
            this.$$changed1 = i2;
            this.$$default = i3;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            LazyGridKt.LazyGrid(this.$modifier, this.$state, this.$slots, this.$contentPadding, this.$reverseLayout, this.$isVertical, this.$flingBehavior, this.$userScrollEnabled, this.$verticalArrangement, this.$horizontalArrangement, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridKt$ScrollPositionUpdater$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13791 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ InterfaceC3588op $itemProviderLambda;
        final /* synthetic */ LazyGridState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13791(InterfaceC3588op interfaceC3588op, LazyGridState lazyGridState, int i) {
            super(2);
            this.$itemProviderLambda = interfaceC3588op;
            this.$state = lazyGridState;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            LazyGridKt.ScrollPositionUpdater(this.$itemProviderLambda, this.$state, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0135  */
    /* JADX WARN: Code duplicated, block: B:103:0x013b  */
    /* JADX WARN: Code duplicated, block: B:104:0x013e  */
    /* JADX WARN: Code duplicated, block: B:107:0x0145  */
    /* JADX WARN: Code duplicated, block: B:108:0x0148  */
    /* JADX WARN: Code duplicated, block: B:110:0x014c  */
    /* JADX WARN: Code duplicated, block: B:112:0x0152  */
    /* JADX WARN: Code duplicated, block: B:113:0x0154  */
    /* JADX WARN: Code duplicated, block: B:115:0x0158  */
    /* JADX WARN: Code duplicated, block: B:118:0x0164  */
    /* JADX WARN: Code duplicated, block: B:124:0x017d  */
    /* JADX WARN: Code duplicated, block: B:126:0x0185  */
    /* JADX WARN: Code duplicated, block: B:133:0x01a0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:134:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:135:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:138:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:139:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:142:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:145:0x01be  */
    /* JADX WARN: Code duplicated, block: B:147:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:150:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:153:0x024d  */
    /* JADX WARN: Code duplicated, block: B:155:0x0251  */
    /* JADX WARN: Code duplicated, block: B:158:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:163:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:56:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:63:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:66:0x00da  */
    /* JADX WARN: Code duplicated, block: B:68:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:76:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:78:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:80:0x0100  */
    /* JADX WARN: Code duplicated, block: B:82:0x0108  */
    /* JADX WARN: Code duplicated, block: B:83:0x010b  */
    /* JADX WARN: Code duplicated, block: B:87:0x0113  */
    /* JADX WARN: Code duplicated, block: B:89:0x0117  */
    /* JADX WARN: Code duplicated, block: B:91:0x011c  */
    /* JADX WARN: Code duplicated, block: B:93:0x0122  */
    /* JADX WARN: Code duplicated, block: B:94:0x0125  */
    /* JADX WARN: Code duplicated, block: B:97:0x012c  */
    /* JADX WARN: Code duplicated, block: B:99:0x0130  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void LazyGrid(Modifier modifier, LazyGridState lazyGridState, InterfaceC0526Fp interfaceC0526Fp, PaddingValues paddingValues, boolean z, boolean z2, FlingBehavior flingBehavior, boolean z3, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, InterfaceC3750qp interfaceC3750qp, Composer composer, int i, int i2, int i3) {
        Modifier modifier2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Modifier modifier3;
        PaddingValues paddingValuesM478PaddingValues0680j_4;
        FlingBehavior flingBehavior2;
        int i13;
        boolean z4;
        Composer composer2;
        Orientation orientation;
        boolean z5;
        PaddingValues paddingValues2;
        Modifier modifier4;
        FlingBehavior flingBehavior3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i14;
        AbstractC4492zt.h(lazyGridState, "state");
        AbstractC4492zt.h(interfaceC0526Fp, "slots");
        AbstractC4492zt.h(vertical, "verticalArrangement");
        AbstractC4492zt.h(horizontal, "horizontalArrangement");
        AbstractC4492zt.h(interfaceC3750qp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(152645664);
        int i15 = i3 & 1;
        if (i15 != 0) {
            i4 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(lazyGridState) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 256 : 128;
        }
        int i16 = i3 & 8;
        if (i16 == 0) {
            if ((i & 7168) == 0) {
                i4 |= composerStartRestartGroup.changed(paddingValues) ? 2048 : 1024;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                i4 |= 24576;
            } else if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i4 |= i6;
            }
            if ((i3 & 32) != 0) {
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                }
                if ((i & 3670016) != 0) {
                    if ((i3 & 64) == 0 || !composerStartRestartGroup.changed(flingBehavior)) {
                        i14 = 524288;
                    } else {
                        i14 = 1048576;
                    }
                    i4 |= i14;
                }
                if ((i3 & 128) != 0) {
                    if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(z3)) {
                            i8 = 8388608;
                        } else {
                            i8 = 4194304;
                        }
                        i4 |= i8;
                    }
                    if ((i3 & 256) != 0) {
                        if ((234881024 & i) == 0) {
                            if (composerStartRestartGroup.changed(vertical)) {
                                i9 = 67108864;
                            } else {
                                i9 = 33554432;
                            }
                        }
                        if ((i3 & 512) != 0) {
                            if ((1879048192 & i) == 0) {
                                if (composerStartRestartGroup.changed(horizontal)) {
                                    i10 = PropertyOptions.DELETE_EXISTING;
                                } else {
                                    i10 = 268435456;
                                }
                            }
                            if ((i3 & 1024) != 0) {
                                i11 = i2 | 6;
                            } else if ((i2 & 14) == 0) {
                                if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                                    i12 = 4;
                                } else {
                                    i12 = 2;
                                }
                                i11 = i2 | i12;
                            } else {
                                i11 = i2;
                            }
                            if ((i4 & 1533916891) != 306783378 && (i11 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                z5 = z;
                                modifier4 = modifier2;
                                composer2 = composerStartRestartGroup;
                                paddingValues2 = paddingValues;
                                flingBehavior3 = flingBehavior;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i15 != 0) {
                                        modifier3 = Modifier.Companion;
                                    } else {
                                        modifier3 = modifier2;
                                    }
                                    if (i16 != 0) {
                                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                                    } else {
                                        paddingValuesM478PaddingValues0680j_4 = paddingValues;
                                    }
                                    boolean z6 = i5 == 0 ? z : false;
                                    if ((i3 & 64) != 0) {
                                        i13 = i4 & (-3670017);
                                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    } else {
                                        flingBehavior2 = flingBehavior;
                                        i13 = i4;
                                    }
                                    z4 = z6;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i3 & 64) != 0) {
                                        i4 &= -3670017;
                                    }
                                    paddingValuesM478PaddingValues0680j_4 = paddingValues;
                                    flingBehavior2 = flingBehavior;
                                    modifier3 = modifier2;
                                    i13 = i4;
                                    z4 = z;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                                }
                                ScrollableDefaults scrollableDefaults = ScrollableDefaults.INSTANCE;
                                OverscrollEffect overscrollEffect = scrollableDefaults.overscrollEffect(composerStartRestartGroup, 6);
                                int i17 = i13 >> 3;
                                int i18 = i17 & 14;
                                InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i18 | ((i11 << 3) & 112));
                                int i19 = i13 >> 9;
                                LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i18 | (i19 & 112));
                                int i20 = i13 & 112;
                                int i21 = i13;
                                boolean z7 = z4;
                                Modifier modifier5 = modifier3;
                                InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i19 & 3670016) | (i17 & 29360128), 0);
                                lazyGridState.setVertical$foundation_release(z2);
                                composer2 = composerStartRestartGroup;
                                ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda, lazyGridState, composer2, i20);
                                if (z2) {
                                    orientation = Orientation.Vertical;
                                } else {
                                    orientation = Orientation.Horizontal;
                                }
                                Orientation orientation2 = orientation;
                                LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier5.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda, lazyLayoutSemanticStateRememberLazyGridSemanticState, orientation2, z3, z7, composer2, (i19 & 57344) | ((i21 << 3) & 458752)), orientation2), lazyGridState, z7, orientation2, composer2, i20 | ((i21 >> 6) & 896)), overscrollEffect), lazyGridState, orientation2, overscrollEffect, z3, scrollableDefaults.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation2, z7), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                z5 = z7;
                                paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                                modifier4 = modifier5;
                                flingBehavior3 = flingBehavior2;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
                        }
                        i10 = 805306368;
                        i4 |= i10;
                        if ((i3 & 1024) != 0) {
                            i11 = i2 | 6;
                        } else if ((i2 & 14) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                                i12 = 4;
                            } else {
                                i12 = 2;
                            }
                            i11 = i2 | i12;
                        } else {
                            i11 = i2;
                        }
                        if ((i4 & 1533916891) != 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i16 != 0) {
                                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                                } else {
                                    paddingValuesM478PaddingValues0680j_4 = paddingValues;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i13 = i4 & (-3670017);
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    i13 = i4;
                                }
                                z4 = z6;
                            } else {
                                if (i15 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i16 != 0) {
                                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                                } else {
                                    paddingValuesM478PaddingValues0680j_4 = paddingValues;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i13 = i4 & (-3670017);
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    i13 = i4;
                                }
                                z4 = z6;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                            }
                            ScrollableDefaults scrollableDefaults2 = ScrollableDefaults.INSTANCE;
                            OverscrollEffect overscrollEffect2 = scrollableDefaults2.overscrollEffect(composerStartRestartGroup, 6);
                            int i110 = i13 >> 3;
                            int i111 = i110 & 14;
                            InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda2 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i111 | ((i11 << 3) & 112));
                            int i112 = i13 >> 9;
                            LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState2 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i111 | (i112 & 112));
                            int i22 = i13 & 112;
                            int i23 = i13;
                            boolean z8 = z4;
                            Modifier modifier6 = modifier3;
                            InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy2 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda2, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i112 & 3670016) | (i110 & 29360128), 0);
                            lazyGridState.setVertical$foundation_release(z2);
                            composer2 = composerStartRestartGroup;
                            ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda2, lazyGridState, composer2, i22);
                            if (z2) {
                                orientation = Orientation.Vertical;
                            } else {
                                orientation = Orientation.Horizontal;
                            }
                            Orientation orientation3 = orientation;
                            LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda2, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier6.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda2, lazyLayoutSemanticStateRememberLazyGridSemanticState2, orientation3, z3, z8, composer2, (i112 & 57344) | ((i23 << 3) & 458752)), orientation3), lazyGridState, z8, orientation3, composer2, i22 | ((i23 >> 6) & 896)), overscrollEffect2), lazyGridState, orientation3, overscrollEffect2, z3, scrollableDefaults2.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation3, z8), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy2, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z5 = z8;
                            paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                            modifier4 = modifier6;
                            flingBehavior3 = flingBehavior2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i16 != 0) {
                                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                                } else {
                                    paddingValuesM478PaddingValues0680j_4 = paddingValues;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i13 = i4 & (-3670017);
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    i13 = i4;
                                }
                                z4 = z6;
                            } else {
                                if (i15 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i16 != 0) {
                                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                                } else {
                                    paddingValuesM478PaddingValues0680j_4 = paddingValues;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i13 = i4 & (-3670017);
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    i13 = i4;
                                }
                                z4 = z6;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                            }
                            ScrollableDefaults scrollableDefaults3 = ScrollableDefaults.INSTANCE;
                            OverscrollEffect overscrollEffect3 = scrollableDefaults3.overscrollEffect(composerStartRestartGroup, 6);
                            int i113 = i13 >> 3;
                            int i114 = i113 & 14;
                            InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda3 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i114 | ((i11 << 3) & 112));
                            int i115 = i13 >> 9;
                            LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState3 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i114 | (i115 & 112));
                            int i24 = i13 & 112;
                            int i25 = i13;
                            boolean z9 = z4;
                            Modifier modifier7 = modifier3;
                            InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy3 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda3, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i115 & 3670016) | (i113 & 29360128), 0);
                            lazyGridState.setVertical$foundation_release(z2);
                            composer2 = composerStartRestartGroup;
                            ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda3, lazyGridState, composer2, i24);
                            if (z2) {
                                orientation = Orientation.Vertical;
                            } else {
                                orientation = Orientation.Horizontal;
                            }
                            Orientation orientation4 = orientation;
                            LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda3, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier7.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda3, lazyLayoutSemanticStateRememberLazyGridSemanticState3, orientation4, z3, z9, composer2, (i115 & 57344) | ((i25 << 3) & 458752)), orientation4), lazyGridState, z9, orientation4, composer2, i24 | ((i25 >> 6) & 896)), overscrollEffect3), lazyGridState, orientation4, overscrollEffect3, z3, scrollableDefaults3.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation4, z9), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy3, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z5 = z9;
                            paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                            modifier4 = modifier7;
                            flingBehavior3 = flingBehavior2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
                    }
                    i9 = 100663296;
                    i4 |= i9;
                    if ((i3 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changed(horizontal)) {
                                i10 = PropertyOptions.DELETE_EXISTING;
                            } else {
                                i10 = 268435456;
                            }
                        }
                        if ((i3 & 1024) != 0) {
                            i11 = i2 | 6;
                        } else if ((i2 & 14) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                                i12 = 4;
                            } else {
                                i12 = 2;
                            }
                            i11 = i2 | i12;
                        } else {
                            i11 = i2;
                        }
                        if ((i4 & 1533916891) != 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i16 != 0) {
                                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                                } else {
                                    paddingValuesM478PaddingValues0680j_4 = paddingValues;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i13 = i4 & (-3670017);
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    i13 = i4;
                                }
                                z4 = z6;
                            } else {
                                if (i15 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i16 != 0) {
                                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                                } else {
                                    paddingValuesM478PaddingValues0680j_4 = paddingValues;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i13 = i4 & (-3670017);
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    i13 = i4;
                                }
                                z4 = z6;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                            }
                            ScrollableDefaults scrollableDefaults4 = ScrollableDefaults.INSTANCE;
                            OverscrollEffect overscrollEffect4 = scrollableDefaults4.overscrollEffect(composerStartRestartGroup, 6);
                            int i116 = i13 >> 3;
                            int i117 = i116 & 14;
                            InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda4 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i117 | ((i11 << 3) & 112));
                            int i118 = i13 >> 9;
                            LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState4 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i117 | (i118 & 112));
                            int i26 = i13 & 112;
                            int i27 = i13;
                            boolean z10 = z4;
                            Modifier modifier8 = modifier3;
                            InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy4 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda4, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i118 & 3670016) | (i116 & 29360128), 0);
                            lazyGridState.setVertical$foundation_release(z2);
                            composer2 = composerStartRestartGroup;
                            ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda4, lazyGridState, composer2, i26);
                            if (z2) {
                                orientation = Orientation.Vertical;
                            } else {
                                orientation = Orientation.Horizontal;
                            }
                            Orientation orientation5 = orientation;
                            LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda4, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier8.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda4, lazyLayoutSemanticStateRememberLazyGridSemanticState4, orientation5, z3, z10, composer2, (i118 & 57344) | ((i27 << 3) & 458752)), orientation5), lazyGridState, z10, orientation5, composer2, i26 | ((i27 >> 6) & 896)), overscrollEffect4), lazyGridState, orientation5, overscrollEffect4, z3, scrollableDefaults4.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation5, z10), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z5 = z10;
                            paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                            modifier4 = modifier8;
                            flingBehavior3 = flingBehavior2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i16 != 0) {
                                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                                } else {
                                    paddingValuesM478PaddingValues0680j_4 = paddingValues;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i13 = i4 & (-3670017);
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    i13 = i4;
                                }
                                z4 = z6;
                            } else {
                                if (i15 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i16 != 0) {
                                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                                } else {
                                    paddingValuesM478PaddingValues0680j_4 = paddingValues;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i13 = i4 & (-3670017);
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    i13 = i4;
                                }
                                z4 = z6;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                            }
                            ScrollableDefaults scrollableDefaults5 = ScrollableDefaults.INSTANCE;
                            OverscrollEffect overscrollEffect5 = scrollableDefaults5.overscrollEffect(composerStartRestartGroup, 6);
                            int i119 = i13 >> 3;
                            int i1110 = i119 & 14;
                            InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda5 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i1110 | ((i11 << 3) & 112));
                            int i1111 = i13 >> 9;
                            LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState5 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i1110 | (i1111 & 112));
                            int i28 = i13 & 112;
                            int i29 = i13;
                            boolean z11 = z4;
                            Modifier modifier9 = modifier3;
                            InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy5 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda5, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i1111 & 3670016) | (i119 & 29360128), 0);
                            lazyGridState.setVertical$foundation_release(z2);
                            composer2 = composerStartRestartGroup;
                            ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda5, lazyGridState, composer2, i28);
                            if (z2) {
                                orientation = Orientation.Vertical;
                            } else {
                                orientation = Orientation.Horizontal;
                            }
                            Orientation orientation6 = orientation;
                            LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda5, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier9.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda5, lazyLayoutSemanticStateRememberLazyGridSemanticState5, orientation6, z3, z11, composer2, (i1111 & 57344) | ((i29 << 3) & 458752)), orientation6), lazyGridState, z11, orientation6, composer2, i28 | ((i29 >> 6) & 896)), overscrollEffect5), lazyGridState, orientation6, overscrollEffect5, z3, scrollableDefaults5.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation6, z11), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy5, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z5 = z11;
                            paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                            modifier4 = modifier9;
                            flingBehavior3 = flingBehavior2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
                    }
                    i10 = 805306368;
                    i4 |= i10;
                    if ((i3 & 1024) != 0) {
                        i11 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i12 = 4;
                        } else {
                            i12 = 2;
                        }
                        i11 = i2 | i12;
                    } else {
                        i11 = i2;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        } else {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                        }
                        ScrollableDefaults scrollableDefaults6 = ScrollableDefaults.INSTANCE;
                        OverscrollEffect overscrollEffect6 = scrollableDefaults6.overscrollEffect(composerStartRestartGroup, 6);
                        int i1112 = i13 >> 3;
                        int i1113 = i1112 & 14;
                        InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda6 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i1113 | ((i11 << 3) & 112));
                        int i1114 = i13 >> 9;
                        LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState6 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i1113 | (i1114 & 112));
                        int i210 = i13 & 112;
                        int i211 = i13;
                        boolean z12 = z4;
                        Modifier modifier10 = modifier3;
                        InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy6 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda6, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i1114 & 3670016) | (i1112 & 29360128), 0);
                        lazyGridState.setVertical$foundation_release(z2);
                        composer2 = composerStartRestartGroup;
                        ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda6, lazyGridState, composer2, i210);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation7 = orientation;
                        LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda6, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier10.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda6, lazyLayoutSemanticStateRememberLazyGridSemanticState6, orientation7, z3, z12, composer2, (i1114 & 57344) | ((i211 << 3) & 458752)), orientation7), lazyGridState, z12, orientation7, composer2, i210 | ((i211 >> 6) & 896)), overscrollEffect6), lazyGridState, orientation7, overscrollEffect6, z3, scrollableDefaults6.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation7, z12), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy6, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z5 = z12;
                        paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                        modifier4 = modifier10;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        } else {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                        }
                        ScrollableDefaults scrollableDefaults7 = ScrollableDefaults.INSTANCE;
                        OverscrollEffect overscrollEffect7 = scrollableDefaults7.overscrollEffect(composerStartRestartGroup, 6);
                        int i1115 = i13 >> 3;
                        int i1116 = i1115 & 14;
                        InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda7 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i1116 | ((i11 << 3) & 112));
                        int i1117 = i13 >> 9;
                        LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState7 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i1116 | (i1117 & 112));
                        int i212 = i13 & 112;
                        int i213 = i13;
                        boolean z13 = z4;
                        Modifier modifier11 = modifier3;
                        InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy7 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda7, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i1117 & 3670016) | (i1115 & 29360128), 0);
                        lazyGridState.setVertical$foundation_release(z2);
                        composer2 = composerStartRestartGroup;
                        ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda7, lazyGridState, composer2, i212);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation8 = orientation;
                        LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda7, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier11.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda7, lazyLayoutSemanticStateRememberLazyGridSemanticState7, orientation8, z3, z13, composer2, (i1117 & 57344) | ((i213 << 3) & 458752)), orientation8), lazyGridState, z13, orientation8, composer2, i212 | ((i213 >> 6) & 896)), overscrollEffect7), lazyGridState, orientation8, overscrollEffect7, z3, scrollableDefaults7.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation8, z13), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy7, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z5 = z13;
                        paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                        modifier4 = modifier11;
                        flingBehavior3 = flingBehavior2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
                }
                i4 |= 12582912;
                if ((i3 & 256) != 0) {
                    if ((234881024 & i) == 0) {
                        if (composerStartRestartGroup.changed(vertical)) {
                            i9 = 67108864;
                        } else {
                            i9 = 33554432;
                        }
                    }
                    if ((i3 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changed(horizontal)) {
                                i10 = PropertyOptions.DELETE_EXISTING;
                            } else {
                                i10 = 268435456;
                            }
                        }
                        if ((i3 & 1024) != 0) {
                            i11 = i2 | 6;
                        } else if ((i2 & 14) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                                i12 = 4;
                            } else {
                                i12 = 2;
                            }
                            i11 = i2 | i12;
                        } else {
                            i11 = i2;
                        }
                        if ((i4 & 1533916891) != 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i16 != 0) {
                                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                                } else {
                                    paddingValuesM478PaddingValues0680j_4 = paddingValues;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i13 = i4 & (-3670017);
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    i13 = i4;
                                }
                                z4 = z6;
                            } else {
                                if (i15 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i16 != 0) {
                                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                                } else {
                                    paddingValuesM478PaddingValues0680j_4 = paddingValues;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i13 = i4 & (-3670017);
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    i13 = i4;
                                }
                                z4 = z6;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                            }
                            ScrollableDefaults scrollableDefaults8 = ScrollableDefaults.INSTANCE;
                            OverscrollEffect overscrollEffect8 = scrollableDefaults8.overscrollEffect(composerStartRestartGroup, 6);
                            int i1118 = i13 >> 3;
                            int i1119 = i1118 & 14;
                            InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda8 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i1119 | ((i11 << 3) & 112));
                            int i11110 = i13 >> 9;
                            LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState8 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i1119 | (i11110 & 112));
                            int i214 = i13 & 112;
                            int i215 = i13;
                            boolean z14 = z4;
                            Modifier modifier12 = modifier3;
                            InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy8 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda8, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i11110 & 3670016) | (i1118 & 29360128), 0);
                            lazyGridState.setVertical$foundation_release(z2);
                            composer2 = composerStartRestartGroup;
                            ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda8, lazyGridState, composer2, i214);
                            if (z2) {
                                orientation = Orientation.Vertical;
                            } else {
                                orientation = Orientation.Horizontal;
                            }
                            Orientation orientation9 = orientation;
                            LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda8, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier12.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda8, lazyLayoutSemanticStateRememberLazyGridSemanticState8, orientation9, z3, z14, composer2, (i11110 & 57344) | ((i215 << 3) & 458752)), orientation9), lazyGridState, z14, orientation9, composer2, i214 | ((i215 >> 6) & 896)), overscrollEffect8), lazyGridState, orientation9, overscrollEffect8, z3, scrollableDefaults8.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation9, z14), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy8, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z5 = z14;
                            paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                            modifier4 = modifier12;
                            flingBehavior3 = flingBehavior2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i16 != 0) {
                                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                                } else {
                                    paddingValuesM478PaddingValues0680j_4 = paddingValues;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i13 = i4 & (-3670017);
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    i13 = i4;
                                }
                                z4 = z6;
                            } else {
                                if (i15 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i16 != 0) {
                                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                                } else {
                                    paddingValuesM478PaddingValues0680j_4 = paddingValues;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i13 = i4 & (-3670017);
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    i13 = i4;
                                }
                                z4 = z6;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                            }
                            ScrollableDefaults scrollableDefaults9 = ScrollableDefaults.INSTANCE;
                            OverscrollEffect overscrollEffect9 = scrollableDefaults9.overscrollEffect(composerStartRestartGroup, 6);
                            int i11111 = i13 >> 3;
                            int i11112 = i11111 & 14;
                            InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda9 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i11112 | ((i11 << 3) & 112));
                            int i11113 = i13 >> 9;
                            LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState9 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i11112 | (i11113 & 112));
                            int i216 = i13 & 112;
                            int i217 = i13;
                            boolean z15 = z4;
                            Modifier modifier13 = modifier3;
                            InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy9 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda9, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i11113 & 3670016) | (i11111 & 29360128), 0);
                            lazyGridState.setVertical$foundation_release(z2);
                            composer2 = composerStartRestartGroup;
                            ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda9, lazyGridState, composer2, i216);
                            if (z2) {
                                orientation = Orientation.Vertical;
                            } else {
                                orientation = Orientation.Horizontal;
                            }
                            Orientation orientation10 = orientation;
                            LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda9, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier13.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda9, lazyLayoutSemanticStateRememberLazyGridSemanticState9, orientation10, z3, z15, composer2, (i11113 & 57344) | ((i217 << 3) & 458752)), orientation10), lazyGridState, z15, orientation10, composer2, i216 | ((i217 >> 6) & 896)), overscrollEffect9), lazyGridState, orientation10, overscrollEffect9, z3, scrollableDefaults9.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation10, z15), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy9, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z5 = z15;
                            paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                            modifier4 = modifier13;
                            flingBehavior3 = flingBehavior2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
                    }
                    i10 = 805306368;
                    i4 |= i10;
                    if ((i3 & 1024) != 0) {
                        i11 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i12 = 4;
                        } else {
                            i12 = 2;
                        }
                        i11 = i2 | i12;
                    } else {
                        i11 = i2;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        } else {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                        }
                        ScrollableDefaults scrollableDefaults10 = ScrollableDefaults.INSTANCE;
                        OverscrollEffect overscrollEffect10 = scrollableDefaults10.overscrollEffect(composerStartRestartGroup, 6);
                        int i11114 = i13 >> 3;
                        int i11115 = i11114 & 14;
                        InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda10 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i11115 | ((i11 << 3) & 112));
                        int i11116 = i13 >> 9;
                        LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState10 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i11115 | (i11116 & 112));
                        int i218 = i13 & 112;
                        int i219 = i13;
                        boolean z16 = z4;
                        Modifier modifier14 = modifier3;
                        InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy10 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda10, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i11116 & 3670016) | (i11114 & 29360128), 0);
                        lazyGridState.setVertical$foundation_release(z2);
                        composer2 = composerStartRestartGroup;
                        ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda10, lazyGridState, composer2, i218);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation11 = orientation;
                        LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda10, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier14.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda10, lazyLayoutSemanticStateRememberLazyGridSemanticState10, orientation11, z3, z16, composer2, (i11116 & 57344) | ((i219 << 3) & 458752)), orientation11), lazyGridState, z16, orientation11, composer2, i218 | ((i219 >> 6) & 896)), overscrollEffect10), lazyGridState, orientation11, overscrollEffect10, z3, scrollableDefaults10.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation11, z16), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy10, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z5 = z16;
                        paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                        modifier4 = modifier14;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        } else {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                        }
                        ScrollableDefaults scrollableDefaults11 = ScrollableDefaults.INSTANCE;
                        OverscrollEffect overscrollEffect11 = scrollableDefaults11.overscrollEffect(composerStartRestartGroup, 6);
                        int i11117 = i13 >> 3;
                        int i11118 = i11117 & 14;
                        InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda11 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i11118 | ((i11 << 3) & 112));
                        int i11119 = i13 >> 9;
                        LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState11 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i11118 | (i11119 & 112));
                        int i2110 = i13 & 112;
                        int i2111 = i13;
                        boolean z17 = z4;
                        Modifier modifier15 = modifier3;
                        InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy11 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda11, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i11119 & 3670016) | (i11117 & 29360128), 0);
                        lazyGridState.setVertical$foundation_release(z2);
                        composer2 = composerStartRestartGroup;
                        ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda11, lazyGridState, composer2, i2110);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation12 = orientation;
                        LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda11, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier15.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda11, lazyLayoutSemanticStateRememberLazyGridSemanticState11, orientation12, z3, z17, composer2, (i11119 & 57344) | ((i2111 << 3) & 458752)), orientation12), lazyGridState, z17, orientation12, composer2, i2110 | ((i2111 >> 6) & 896)), overscrollEffect11), lazyGridState, orientation12, overscrollEffect11, z3, scrollableDefaults11.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation12, z17), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy11, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z5 = z17;
                        paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                        modifier4 = modifier15;
                        flingBehavior3 = flingBehavior2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
                }
                i9 = 100663296;
                i4 |= i9;
                if ((i3 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changed(horizontal)) {
                            i10 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i10 = 268435456;
                        }
                    }
                    if ((i3 & 1024) != 0) {
                        i11 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i12 = 4;
                        } else {
                            i12 = 2;
                        }
                        i11 = i2 | i12;
                    } else {
                        i11 = i2;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        } else {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                        }
                        ScrollableDefaults scrollableDefaults12 = ScrollableDefaults.INSTANCE;
                        OverscrollEffect overscrollEffect12 = scrollableDefaults12.overscrollEffect(composerStartRestartGroup, 6);
                        int i111110 = i13 >> 3;
                        int i111111 = i111110 & 14;
                        InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda12 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i111111 | ((i11 << 3) & 112));
                        int i111112 = i13 >> 9;
                        LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState12 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i111111 | (i111112 & 112));
                        int i2112 = i13 & 112;
                        int i2113 = i13;
                        boolean z18 = z4;
                        Modifier modifier16 = modifier3;
                        InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy12 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda12, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i111112 & 3670016) | (i111110 & 29360128), 0);
                        lazyGridState.setVertical$foundation_release(z2);
                        composer2 = composerStartRestartGroup;
                        ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda12, lazyGridState, composer2, i2112);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation13 = orientation;
                        LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda12, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier16.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda12, lazyLayoutSemanticStateRememberLazyGridSemanticState12, orientation13, z3, z18, composer2, (i111112 & 57344) | ((i2113 << 3) & 458752)), orientation13), lazyGridState, z18, orientation13, composer2, i2112 | ((i2113 >> 6) & 896)), overscrollEffect12), lazyGridState, orientation13, overscrollEffect12, z3, scrollableDefaults12.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation13, z18), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy12, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z5 = z18;
                        paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                        modifier4 = modifier16;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        } else {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                        }
                        ScrollableDefaults scrollableDefaults13 = ScrollableDefaults.INSTANCE;
                        OverscrollEffect overscrollEffect13 = scrollableDefaults13.overscrollEffect(composerStartRestartGroup, 6);
                        int i111113 = i13 >> 3;
                        int i111114 = i111113 & 14;
                        InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda13 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i111114 | ((i11 << 3) & 112));
                        int i111115 = i13 >> 9;
                        LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState13 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i111114 | (i111115 & 112));
                        int i2114 = i13 & 112;
                        int i2115 = i13;
                        boolean z19 = z4;
                        Modifier modifier17 = modifier3;
                        InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy13 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda13, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i111115 & 3670016) | (i111113 & 29360128), 0);
                        lazyGridState.setVertical$foundation_release(z2);
                        composer2 = composerStartRestartGroup;
                        ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda13, lazyGridState, composer2, i2114);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation14 = orientation;
                        LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda13, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier17.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda13, lazyLayoutSemanticStateRememberLazyGridSemanticState13, orientation14, z3, z19, composer2, (i111115 & 57344) | ((i2115 << 3) & 458752)), orientation14), lazyGridState, z19, orientation14, composer2, i2114 | ((i2115 >> 6) & 896)), overscrollEffect13), lazyGridState, orientation14, overscrollEffect13, z3, scrollableDefaults13.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation14, z19), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy13, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z5 = z19;
                        paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                        modifier4 = modifier17;
                        flingBehavior3 = flingBehavior2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
                }
                i10 = 805306368;
                i4 |= i10;
                if ((i3 & 1024) != 0) {
                    i11 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i12 = 4;
                    } else {
                        i12 = 2;
                    }
                    i11 = i2 | i12;
                } else {
                    i11 = i2;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    } else {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                    }
                    ScrollableDefaults scrollableDefaults14 = ScrollableDefaults.INSTANCE;
                    OverscrollEffect overscrollEffect14 = scrollableDefaults14.overscrollEffect(composerStartRestartGroup, 6);
                    int i111116 = i13 >> 3;
                    int i111117 = i111116 & 14;
                    InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda14 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i111117 | ((i11 << 3) & 112));
                    int i111118 = i13 >> 9;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState14 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i111117 | (i111118 & 112));
                    int i2116 = i13 & 112;
                    int i2117 = i13;
                    boolean z110 = z4;
                    Modifier modifier18 = modifier3;
                    InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy14 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda14, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i111118 & 3670016) | (i111116 & 29360128), 0);
                    lazyGridState.setVertical$foundation_release(z2);
                    composer2 = composerStartRestartGroup;
                    ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda14, lazyGridState, composer2, i2116);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation15 = orientation;
                    LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda14, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier18.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda14, lazyLayoutSemanticStateRememberLazyGridSemanticState14, orientation15, z3, z110, composer2, (i111118 & 57344) | ((i2117 << 3) & 458752)), orientation15), lazyGridState, z110, orientation15, composer2, i2116 | ((i2117 >> 6) & 896)), overscrollEffect14), lazyGridState, orientation15, overscrollEffect14, z3, scrollableDefaults14.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation15, z110), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy14, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z110;
                    paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                    modifier4 = modifier18;
                    flingBehavior3 = flingBehavior2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    } else {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                    }
                    ScrollableDefaults scrollableDefaults15 = ScrollableDefaults.INSTANCE;
                    OverscrollEffect overscrollEffect15 = scrollableDefaults15.overscrollEffect(composerStartRestartGroup, 6);
                    int i111119 = i13 >> 3;
                    int i1111110 = i111119 & 14;
                    InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda15 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i1111110 | ((i11 << 3) & 112));
                    int i1111111 = i13 >> 9;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState15 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i1111110 | (i1111111 & 112));
                    int i2118 = i13 & 112;
                    int i2119 = i13;
                    boolean z111 = z4;
                    Modifier modifier19 = modifier3;
                    InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy15 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda15, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i1111111 & 3670016) | (i111119 & 29360128), 0);
                    lazyGridState.setVertical$foundation_release(z2);
                    composer2 = composerStartRestartGroup;
                    ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda15, lazyGridState, composer2, i2118);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation16 = orientation;
                    LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda15, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier19.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda15, lazyLayoutSemanticStateRememberLazyGridSemanticState15, orientation16, z3, z111, composer2, (i1111111 & 57344) | ((i2119 << 3) & 458752)), orientation16), lazyGridState, z111, orientation16, composer2, i2118 | ((i2119 >> 6) & 896)), overscrollEffect15), lazyGridState, orientation16, overscrollEffect15, z3, scrollableDefaults15.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation16, z111), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy15, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z111;
                    paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                    modifier4 = modifier19;
                    flingBehavior3 = flingBehavior2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
            }
            i7 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i4 |= i7;
            if ((i & 3670016) != 0) {
                if ((i3 & 64) == 0) {
                    i14 = 524288;
                } else {
                    i14 = 524288;
                }
                i4 |= i14;
            }
            if ((i3 & 128) != 0) {
                if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                    i4 |= i8;
                }
                if ((i3 & 256) != 0) {
                    if ((234881024 & i) == 0) {
                        if (composerStartRestartGroup.changed(vertical)) {
                            i9 = 67108864;
                        } else {
                            i9 = 33554432;
                        }
                    }
                    if ((i3 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changed(horizontal)) {
                                i10 = PropertyOptions.DELETE_EXISTING;
                            } else {
                                i10 = 268435456;
                            }
                        }
                        if ((i3 & 1024) != 0) {
                            i11 = i2 | 6;
                        } else if ((i2 & 14) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                                i12 = 4;
                            } else {
                                i12 = 2;
                            }
                            i11 = i2 | i12;
                        } else {
                            i11 = i2;
                        }
                        if ((i4 & 1533916891) != 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i16 != 0) {
                                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                                } else {
                                    paddingValuesM478PaddingValues0680j_4 = paddingValues;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i13 = i4 & (-3670017);
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    i13 = i4;
                                }
                                z4 = z6;
                            } else {
                                if (i15 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i16 != 0) {
                                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                                } else {
                                    paddingValuesM478PaddingValues0680j_4 = paddingValues;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i13 = i4 & (-3670017);
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    i13 = i4;
                                }
                                z4 = z6;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                            }
                            ScrollableDefaults scrollableDefaults16 = ScrollableDefaults.INSTANCE;
                            OverscrollEffect overscrollEffect16 = scrollableDefaults16.overscrollEffect(composerStartRestartGroup, 6);
                            int i1111112 = i13 >> 3;
                            int i1111113 = i1111112 & 14;
                            InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda16 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i1111113 | ((i11 << 3) & 112));
                            int i1111114 = i13 >> 9;
                            LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState16 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i1111113 | (i1111114 & 112));
                            int i21110 = i13 & 112;
                            int i21111 = i13;
                            boolean z112 = z4;
                            Modifier modifier110 = modifier3;
                            InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy16 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda16, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i1111114 & 3670016) | (i1111112 & 29360128), 0);
                            lazyGridState.setVertical$foundation_release(z2);
                            composer2 = composerStartRestartGroup;
                            ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda16, lazyGridState, composer2, i21110);
                            if (z2) {
                                orientation = Orientation.Vertical;
                            } else {
                                orientation = Orientation.Horizontal;
                            }
                            Orientation orientation17 = orientation;
                            LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda16, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier110.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda16, lazyLayoutSemanticStateRememberLazyGridSemanticState16, orientation17, z3, z112, composer2, (i1111114 & 57344) | ((i21111 << 3) & 458752)), orientation17), lazyGridState, z112, orientation17, composer2, i21110 | ((i21111 >> 6) & 896)), overscrollEffect16), lazyGridState, orientation17, overscrollEffect16, z3, scrollableDefaults16.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation17, z112), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy16, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z5 = z112;
                            paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                            modifier4 = modifier110;
                            flingBehavior3 = flingBehavior2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i16 != 0) {
                                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                                } else {
                                    paddingValuesM478PaddingValues0680j_4 = paddingValues;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i13 = i4 & (-3670017);
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    i13 = i4;
                                }
                                z4 = z6;
                            } else {
                                if (i15 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i16 != 0) {
                                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                                } else {
                                    paddingValuesM478PaddingValues0680j_4 = paddingValues;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i13 = i4 & (-3670017);
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    i13 = i4;
                                }
                                z4 = z6;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                            }
                            ScrollableDefaults scrollableDefaults17 = ScrollableDefaults.INSTANCE;
                            OverscrollEffect overscrollEffect17 = scrollableDefaults17.overscrollEffect(composerStartRestartGroup, 6);
                            int i1111115 = i13 >> 3;
                            int i1111116 = i1111115 & 14;
                            InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda17 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i1111116 | ((i11 << 3) & 112));
                            int i1111117 = i13 >> 9;
                            LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState17 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i1111116 | (i1111117 & 112));
                            int i21112 = i13 & 112;
                            int i21113 = i13;
                            boolean z113 = z4;
                            Modifier modifier111 = modifier3;
                            InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy17 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda17, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i1111117 & 3670016) | (i1111115 & 29360128), 0);
                            lazyGridState.setVertical$foundation_release(z2);
                            composer2 = composerStartRestartGroup;
                            ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda17, lazyGridState, composer2, i21112);
                            if (z2) {
                                orientation = Orientation.Vertical;
                            } else {
                                orientation = Orientation.Horizontal;
                            }
                            Orientation orientation18 = orientation;
                            LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda17, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier111.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda17, lazyLayoutSemanticStateRememberLazyGridSemanticState17, orientation18, z3, z113, composer2, (i1111117 & 57344) | ((i21113 << 3) & 458752)), orientation18), lazyGridState, z113, orientation18, composer2, i21112 | ((i21113 >> 6) & 896)), overscrollEffect17), lazyGridState, orientation18, overscrollEffect17, z3, scrollableDefaults17.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation18, z113), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy17, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z5 = z113;
                            paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                            modifier4 = modifier111;
                            flingBehavior3 = flingBehavior2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
                    }
                    i10 = 805306368;
                    i4 |= i10;
                    if ((i3 & 1024) != 0) {
                        i11 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i12 = 4;
                        } else {
                            i12 = 2;
                        }
                        i11 = i2 | i12;
                    } else {
                        i11 = i2;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        } else {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                        }
                        ScrollableDefaults scrollableDefaults18 = ScrollableDefaults.INSTANCE;
                        OverscrollEffect overscrollEffect18 = scrollableDefaults18.overscrollEffect(composerStartRestartGroup, 6);
                        int i1111118 = i13 >> 3;
                        int i1111119 = i1111118 & 14;
                        InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda18 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i1111119 | ((i11 << 3) & 112));
                        int i11111110 = i13 >> 9;
                        LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState18 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i1111119 | (i11111110 & 112));
                        int i21114 = i13 & 112;
                        int i21115 = i13;
                        boolean z114 = z4;
                        Modifier modifier112 = modifier3;
                        InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy18 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda18, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i11111110 & 3670016) | (i1111118 & 29360128), 0);
                        lazyGridState.setVertical$foundation_release(z2);
                        composer2 = composerStartRestartGroup;
                        ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda18, lazyGridState, composer2, i21114);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation19 = orientation;
                        LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda18, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier112.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda18, lazyLayoutSemanticStateRememberLazyGridSemanticState18, orientation19, z3, z114, composer2, (i11111110 & 57344) | ((i21115 << 3) & 458752)), orientation19), lazyGridState, z114, orientation19, composer2, i21114 | ((i21115 >> 6) & 896)), overscrollEffect18), lazyGridState, orientation19, overscrollEffect18, z3, scrollableDefaults18.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation19, z114), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy18, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z5 = z114;
                        paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                        modifier4 = modifier112;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        } else {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                        }
                        ScrollableDefaults scrollableDefaults19 = ScrollableDefaults.INSTANCE;
                        OverscrollEffect overscrollEffect19 = scrollableDefaults19.overscrollEffect(composerStartRestartGroup, 6);
                        int i11111111 = i13 >> 3;
                        int i11111112 = i11111111 & 14;
                        InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda19 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i11111112 | ((i11 << 3) & 112));
                        int i11111113 = i13 >> 9;
                        LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState19 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i11111112 | (i11111113 & 112));
                        int i21116 = i13 & 112;
                        int i21117 = i13;
                        boolean z115 = z4;
                        Modifier modifier113 = modifier3;
                        InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy19 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda19, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i11111113 & 3670016) | (i11111111 & 29360128), 0);
                        lazyGridState.setVertical$foundation_release(z2);
                        composer2 = composerStartRestartGroup;
                        ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda19, lazyGridState, composer2, i21116);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation110 = orientation;
                        LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda19, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier113.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda19, lazyLayoutSemanticStateRememberLazyGridSemanticState19, orientation110, z3, z115, composer2, (i11111113 & 57344) | ((i21117 << 3) & 458752)), orientation110), lazyGridState, z115, orientation110, composer2, i21116 | ((i21117 >> 6) & 896)), overscrollEffect19), lazyGridState, orientation110, overscrollEffect19, z3, scrollableDefaults19.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation110, z115), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy19, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z5 = z115;
                        paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                        modifier4 = modifier113;
                        flingBehavior3 = flingBehavior2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
                }
                i9 = 100663296;
                i4 |= i9;
                if ((i3 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changed(horizontal)) {
                            i10 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i10 = 268435456;
                        }
                    }
                    if ((i3 & 1024) != 0) {
                        i11 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i12 = 4;
                        } else {
                            i12 = 2;
                        }
                        i11 = i2 | i12;
                    } else {
                        i11 = i2;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        } else {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                        }
                        ScrollableDefaults scrollableDefaults110 = ScrollableDefaults.INSTANCE;
                        OverscrollEffect overscrollEffect110 = scrollableDefaults110.overscrollEffect(composerStartRestartGroup, 6);
                        int i11111114 = i13 >> 3;
                        int i11111115 = i11111114 & 14;
                        InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda110 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i11111115 | ((i11 << 3) & 112));
                        int i11111116 = i13 >> 9;
                        LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState110 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i11111115 | (i11111116 & 112));
                        int i21118 = i13 & 112;
                        int i21119 = i13;
                        boolean z116 = z4;
                        Modifier modifier114 = modifier3;
                        InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy110 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda110, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i11111116 & 3670016) | (i11111114 & 29360128), 0);
                        lazyGridState.setVertical$foundation_release(z2);
                        composer2 = composerStartRestartGroup;
                        ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda110, lazyGridState, composer2, i21118);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation111 = orientation;
                        LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda110, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier114.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda110, lazyLayoutSemanticStateRememberLazyGridSemanticState110, orientation111, z3, z116, composer2, (i11111116 & 57344) | ((i21119 << 3) & 458752)), orientation111), lazyGridState, z116, orientation111, composer2, i21118 | ((i21119 >> 6) & 896)), overscrollEffect110), lazyGridState, orientation111, overscrollEffect110, z3, scrollableDefaults110.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation111, z116), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy110, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z5 = z116;
                        paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                        modifier4 = modifier114;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        } else {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                        }
                        ScrollableDefaults scrollableDefaults111 = ScrollableDefaults.INSTANCE;
                        OverscrollEffect overscrollEffect111 = scrollableDefaults111.overscrollEffect(composerStartRestartGroup, 6);
                        int i11111117 = i13 >> 3;
                        int i11111118 = i11111117 & 14;
                        InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda111 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i11111118 | ((i11 << 3) & 112));
                        int i11111119 = i13 >> 9;
                        LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState111 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i11111118 | (i11111119 & 112));
                        int i211110 = i13 & 112;
                        int i211111 = i13;
                        boolean z117 = z4;
                        Modifier modifier115 = modifier3;
                        InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy111 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda111, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i11111119 & 3670016) | (i11111117 & 29360128), 0);
                        lazyGridState.setVertical$foundation_release(z2);
                        composer2 = composerStartRestartGroup;
                        ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda111, lazyGridState, composer2, i211110);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation112 = orientation;
                        LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda111, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier115.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda111, lazyLayoutSemanticStateRememberLazyGridSemanticState111, orientation112, z3, z117, composer2, (i11111119 & 57344) | ((i211111 << 3) & 458752)), orientation112), lazyGridState, z117, orientation112, composer2, i211110 | ((i211111 >> 6) & 896)), overscrollEffect111), lazyGridState, orientation112, overscrollEffect111, z3, scrollableDefaults111.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation112, z117), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy111, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z5 = z117;
                        paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                        modifier4 = modifier115;
                        flingBehavior3 = flingBehavior2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
                }
                i10 = 805306368;
                i4 |= i10;
                if ((i3 & 1024) != 0) {
                    i11 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i12 = 4;
                    } else {
                        i12 = 2;
                    }
                    i11 = i2 | i12;
                } else {
                    i11 = i2;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    } else {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                    }
                    ScrollableDefaults scrollableDefaults112 = ScrollableDefaults.INSTANCE;
                    OverscrollEffect overscrollEffect112 = scrollableDefaults112.overscrollEffect(composerStartRestartGroup, 6);
                    int i111111110 = i13 >> 3;
                    int i111111111 = i111111110 & 14;
                    InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda112 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i111111111 | ((i11 << 3) & 112));
                    int i111111112 = i13 >> 9;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState112 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i111111111 | (i111111112 & 112));
                    int i211112 = i13 & 112;
                    int i211113 = i13;
                    boolean z118 = z4;
                    Modifier modifier116 = modifier3;
                    InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy112 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda112, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i111111112 & 3670016) | (i111111110 & 29360128), 0);
                    lazyGridState.setVertical$foundation_release(z2);
                    composer2 = composerStartRestartGroup;
                    ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda112, lazyGridState, composer2, i211112);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation113 = orientation;
                    LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda112, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier116.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda112, lazyLayoutSemanticStateRememberLazyGridSemanticState112, orientation113, z3, z118, composer2, (i111111112 & 57344) | ((i211113 << 3) & 458752)), orientation113), lazyGridState, z118, orientation113, composer2, i211112 | ((i211113 >> 6) & 896)), overscrollEffect112), lazyGridState, orientation113, overscrollEffect112, z3, scrollableDefaults112.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation113, z118), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy112, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z118;
                    paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                    modifier4 = modifier116;
                    flingBehavior3 = flingBehavior2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    } else {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                    }
                    ScrollableDefaults scrollableDefaults113 = ScrollableDefaults.INSTANCE;
                    OverscrollEffect overscrollEffect113 = scrollableDefaults113.overscrollEffect(composerStartRestartGroup, 6);
                    int i111111113 = i13 >> 3;
                    int i111111114 = i111111113 & 14;
                    InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda113 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i111111114 | ((i11 << 3) & 112));
                    int i111111115 = i13 >> 9;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState113 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i111111114 | (i111111115 & 112));
                    int i211114 = i13 & 112;
                    int i211115 = i13;
                    boolean z119 = z4;
                    Modifier modifier117 = modifier3;
                    InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy113 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda113, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i111111115 & 3670016) | (i111111113 & 29360128), 0);
                    lazyGridState.setVertical$foundation_release(z2);
                    composer2 = composerStartRestartGroup;
                    ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda113, lazyGridState, composer2, i211114);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation114 = orientation;
                    LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda113, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier117.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda113, lazyLayoutSemanticStateRememberLazyGridSemanticState113, orientation114, z3, z119, composer2, (i111111115 & 57344) | ((i211115 << 3) & 458752)), orientation114), lazyGridState, z119, orientation114, composer2, i211114 | ((i211115 >> 6) & 896)), overscrollEffect113), lazyGridState, orientation114, overscrollEffect113, z3, scrollableDefaults113.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation114, z119), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy113, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z119;
                    paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                    modifier4 = modifier117;
                    flingBehavior3 = flingBehavior2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
            }
            i4 |= 12582912;
            if ((i3 & 256) != 0) {
                if ((234881024 & i) == 0) {
                    if (composerStartRestartGroup.changed(vertical)) {
                        i9 = 67108864;
                    } else {
                        i9 = 33554432;
                    }
                }
                if ((i3 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changed(horizontal)) {
                            i10 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i10 = 268435456;
                        }
                    }
                    if ((i3 & 1024) != 0) {
                        i11 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i12 = 4;
                        } else {
                            i12 = 2;
                        }
                        i11 = i2 | i12;
                    } else {
                        i11 = i2;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        } else {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                        }
                        ScrollableDefaults scrollableDefaults114 = ScrollableDefaults.INSTANCE;
                        OverscrollEffect overscrollEffect114 = scrollableDefaults114.overscrollEffect(composerStartRestartGroup, 6);
                        int i111111116 = i13 >> 3;
                        int i111111117 = i111111116 & 14;
                        InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda114 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i111111117 | ((i11 << 3) & 112));
                        int i111111118 = i13 >> 9;
                        LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState114 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i111111117 | (i111111118 & 112));
                        int i211116 = i13 & 112;
                        int i211117 = i13;
                        boolean z1110 = z4;
                        Modifier modifier118 = modifier3;
                        InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy114 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda114, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i111111118 & 3670016) | (i111111116 & 29360128), 0);
                        lazyGridState.setVertical$foundation_release(z2);
                        composer2 = composerStartRestartGroup;
                        ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda114, lazyGridState, composer2, i211116);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation115 = orientation;
                        LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda114, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier118.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda114, lazyLayoutSemanticStateRememberLazyGridSemanticState114, orientation115, z3, z1110, composer2, (i111111118 & 57344) | ((i211117 << 3) & 458752)), orientation115), lazyGridState, z1110, orientation115, composer2, i211116 | ((i211117 >> 6) & 896)), overscrollEffect114), lazyGridState, orientation115, overscrollEffect114, z3, scrollableDefaults114.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation115, z1110), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy114, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z5 = z1110;
                        paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                        modifier4 = modifier118;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        } else {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                        }
                        ScrollableDefaults scrollableDefaults115 = ScrollableDefaults.INSTANCE;
                        OverscrollEffect overscrollEffect115 = scrollableDefaults115.overscrollEffect(composerStartRestartGroup, 6);
                        int i111111119 = i13 >> 3;
                        int i1111111110 = i111111119 & 14;
                        InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda115 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i1111111110 | ((i11 << 3) & 112));
                        int i1111111111 = i13 >> 9;
                        LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState115 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i1111111110 | (i1111111111 & 112));
                        int i211118 = i13 & 112;
                        int i211119 = i13;
                        boolean z1111 = z4;
                        Modifier modifier119 = modifier3;
                        InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy115 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda115, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i1111111111 & 3670016) | (i111111119 & 29360128), 0);
                        lazyGridState.setVertical$foundation_release(z2);
                        composer2 = composerStartRestartGroup;
                        ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda115, lazyGridState, composer2, i211118);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation116 = orientation;
                        LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda115, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier119.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda115, lazyLayoutSemanticStateRememberLazyGridSemanticState115, orientation116, z3, z1111, composer2, (i1111111111 & 57344) | ((i211119 << 3) & 458752)), orientation116), lazyGridState, z1111, orientation116, composer2, i211118 | ((i211119 >> 6) & 896)), overscrollEffect115), lazyGridState, orientation116, overscrollEffect115, z3, scrollableDefaults115.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation116, z1111), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy115, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z5 = z1111;
                        paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                        modifier4 = modifier119;
                        flingBehavior3 = flingBehavior2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
                }
                i10 = 805306368;
                i4 |= i10;
                if ((i3 & 1024) != 0) {
                    i11 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i12 = 4;
                    } else {
                        i12 = 2;
                    }
                    i11 = i2 | i12;
                } else {
                    i11 = i2;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    } else {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                    }
                    ScrollableDefaults scrollableDefaults116 = ScrollableDefaults.INSTANCE;
                    OverscrollEffect overscrollEffect116 = scrollableDefaults116.overscrollEffect(composerStartRestartGroup, 6);
                    int i1111111112 = i13 >> 3;
                    int i1111111113 = i1111111112 & 14;
                    InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda116 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i1111111113 | ((i11 << 3) & 112));
                    int i1111111114 = i13 >> 9;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState116 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i1111111113 | (i1111111114 & 112));
                    int i2111110 = i13 & 112;
                    int i2111111 = i13;
                    boolean z1112 = z4;
                    Modifier modifier1110 = modifier3;
                    InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy116 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda116, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i1111111114 & 3670016) | (i1111111112 & 29360128), 0);
                    lazyGridState.setVertical$foundation_release(z2);
                    composer2 = composerStartRestartGroup;
                    ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda116, lazyGridState, composer2, i2111110);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation117 = orientation;
                    LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda116, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier1110.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda116, lazyLayoutSemanticStateRememberLazyGridSemanticState116, orientation117, z3, z1112, composer2, (i1111111114 & 57344) | ((i2111111 << 3) & 458752)), orientation117), lazyGridState, z1112, orientation117, composer2, i2111110 | ((i2111111 >> 6) & 896)), overscrollEffect116), lazyGridState, orientation117, overscrollEffect116, z3, scrollableDefaults116.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation117, z1112), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy116, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z1112;
                    paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                    modifier4 = modifier1110;
                    flingBehavior3 = flingBehavior2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    } else {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                    }
                    ScrollableDefaults scrollableDefaults117 = ScrollableDefaults.INSTANCE;
                    OverscrollEffect overscrollEffect117 = scrollableDefaults117.overscrollEffect(composerStartRestartGroup, 6);
                    int i1111111115 = i13 >> 3;
                    int i1111111116 = i1111111115 & 14;
                    InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda117 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i1111111116 | ((i11 << 3) & 112));
                    int i1111111117 = i13 >> 9;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState117 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i1111111116 | (i1111111117 & 112));
                    int i2111112 = i13 & 112;
                    int i2111113 = i13;
                    boolean z1113 = z4;
                    Modifier modifier1111 = modifier3;
                    InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy117 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda117, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i1111111117 & 3670016) | (i1111111115 & 29360128), 0);
                    lazyGridState.setVertical$foundation_release(z2);
                    composer2 = composerStartRestartGroup;
                    ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda117, lazyGridState, composer2, i2111112);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation118 = orientation;
                    LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda117, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier1111.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda117, lazyLayoutSemanticStateRememberLazyGridSemanticState117, orientation118, z3, z1113, composer2, (i1111111117 & 57344) | ((i2111113 << 3) & 458752)), orientation118), lazyGridState, z1113, orientation118, composer2, i2111112 | ((i2111113 >> 6) & 896)), overscrollEffect117), lazyGridState, orientation118, overscrollEffect117, z3, scrollableDefaults117.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation118, z1113), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy117, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z1113;
                    paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                    modifier4 = modifier1111;
                    flingBehavior3 = flingBehavior2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
            }
            i9 = 100663296;
            i4 |= i9;
            if ((i3 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changed(horizontal)) {
                        i10 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i10 = 268435456;
                    }
                }
                if ((i3 & 1024) != 0) {
                    i11 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i12 = 4;
                    } else {
                        i12 = 2;
                    }
                    i11 = i2 | i12;
                } else {
                    i11 = i2;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    } else {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                    }
                    ScrollableDefaults scrollableDefaults118 = ScrollableDefaults.INSTANCE;
                    OverscrollEffect overscrollEffect118 = scrollableDefaults118.overscrollEffect(composerStartRestartGroup, 6);
                    int i1111111118 = i13 >> 3;
                    int i1111111119 = i1111111118 & 14;
                    InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda118 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i1111111119 | ((i11 << 3) & 112));
                    int i11111111110 = i13 >> 9;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState118 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i1111111119 | (i11111111110 & 112));
                    int i2111114 = i13 & 112;
                    int i2111115 = i13;
                    boolean z1114 = z4;
                    Modifier modifier1112 = modifier3;
                    InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy118 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda118, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i11111111110 & 3670016) | (i1111111118 & 29360128), 0);
                    lazyGridState.setVertical$foundation_release(z2);
                    composer2 = composerStartRestartGroup;
                    ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda118, lazyGridState, composer2, i2111114);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation119 = orientation;
                    LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda118, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier1112.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda118, lazyLayoutSemanticStateRememberLazyGridSemanticState118, orientation119, z3, z1114, composer2, (i11111111110 & 57344) | ((i2111115 << 3) & 458752)), orientation119), lazyGridState, z1114, orientation119, composer2, i2111114 | ((i2111115 >> 6) & 896)), overscrollEffect118), lazyGridState, orientation119, overscrollEffect118, z3, scrollableDefaults118.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation119, z1114), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy118, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z1114;
                    paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                    modifier4 = modifier1112;
                    flingBehavior3 = flingBehavior2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    } else {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                    }
                    ScrollableDefaults scrollableDefaults119 = ScrollableDefaults.INSTANCE;
                    OverscrollEffect overscrollEffect119 = scrollableDefaults119.overscrollEffect(composerStartRestartGroup, 6);
                    int i11111111111 = i13 >> 3;
                    int i11111111112 = i11111111111 & 14;
                    InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda119 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i11111111112 | ((i11 << 3) & 112));
                    int i11111111113 = i13 >> 9;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState119 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i11111111112 | (i11111111113 & 112));
                    int i2111116 = i13 & 112;
                    int i2111117 = i13;
                    boolean z1115 = z4;
                    Modifier modifier1113 = modifier3;
                    InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy119 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda119, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i11111111113 & 3670016) | (i11111111111 & 29360128), 0);
                    lazyGridState.setVertical$foundation_release(z2);
                    composer2 = composerStartRestartGroup;
                    ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda119, lazyGridState, composer2, i2111116);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation1110 = orientation;
                    LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda119, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier1113.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda119, lazyLayoutSemanticStateRememberLazyGridSemanticState119, orientation1110, z3, z1115, composer2, (i11111111113 & 57344) | ((i2111117 << 3) & 458752)), orientation1110), lazyGridState, z1115, orientation1110, composer2, i2111116 | ((i2111117 >> 6) & 896)), overscrollEffect119), lazyGridState, orientation1110, overscrollEffect119, z3, scrollableDefaults119.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation1110, z1115), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy119, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z1115;
                    paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                    modifier4 = modifier1113;
                    flingBehavior3 = flingBehavior2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
            }
            i10 = 805306368;
            i4 |= i10;
            if ((i3 & 1024) != 0) {
                i11 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                    i12 = 4;
                } else {
                    i12 = 2;
                }
                i11 = i2 | i12;
            } else {
                i11 = i2;
            }
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i16 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i13 = i4 & (-3670017);
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                        i13 = i4;
                    }
                    z4 = z6;
                } else {
                    if (i15 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i16 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i13 = i4 & (-3670017);
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                        i13 = i4;
                    }
                    z4 = z6;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                }
                ScrollableDefaults scrollableDefaults1110 = ScrollableDefaults.INSTANCE;
                OverscrollEffect overscrollEffect1110 = scrollableDefaults1110.overscrollEffect(composerStartRestartGroup, 6);
                int i11111111114 = i13 >> 3;
                int i11111111115 = i11111111114 & 14;
                InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda1110 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i11111111115 | ((i11 << 3) & 112));
                int i11111111116 = i13 >> 9;
                LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState1110 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i11111111115 | (i11111111116 & 112));
                int i2111118 = i13 & 112;
                int i2111119 = i13;
                boolean z1116 = z4;
                Modifier modifier1114 = modifier3;
                InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy1110 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda1110, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i11111111116 & 3670016) | (i11111111114 & 29360128), 0);
                lazyGridState.setVertical$foundation_release(z2);
                composer2 = composerStartRestartGroup;
                ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda1110, lazyGridState, composer2, i2111118);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation1111 = orientation;
                LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda1110, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier1114.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda1110, lazyLayoutSemanticStateRememberLazyGridSemanticState1110, orientation1111, z3, z1116, composer2, (i11111111116 & 57344) | ((i2111119 << 3) & 458752)), orientation1111), lazyGridState, z1116, orientation1111, composer2, i2111118 | ((i2111119 >> 6) & 896)), overscrollEffect1110), lazyGridState, orientation1111, overscrollEffect1110, z3, scrollableDefaults1110.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation1111, z1116), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy1110, composer2, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z1116;
                paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                modifier4 = modifier1114;
                flingBehavior3 = flingBehavior2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i16 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i13 = i4 & (-3670017);
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                        i13 = i4;
                    }
                    z4 = z6;
                } else {
                    if (i15 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i16 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i13 = i4 & (-3670017);
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                        i13 = i4;
                    }
                    z4 = z6;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                }
                ScrollableDefaults scrollableDefaults1111 = ScrollableDefaults.INSTANCE;
                OverscrollEffect overscrollEffect1111 = scrollableDefaults1111.overscrollEffect(composerStartRestartGroup, 6);
                int i11111111117 = i13 >> 3;
                int i11111111118 = i11111111117 & 14;
                InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda1111 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i11111111118 | ((i11 << 3) & 112));
                int i11111111119 = i13 >> 9;
                LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState1111 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i11111111118 | (i11111111119 & 112));
                int i21111110 = i13 & 112;
                int i21111111 = i13;
                boolean z1117 = z4;
                Modifier modifier1115 = modifier3;
                InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy1111 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda1111, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i11111111119 & 3670016) | (i11111111117 & 29360128), 0);
                lazyGridState.setVertical$foundation_release(z2);
                composer2 = composerStartRestartGroup;
                ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda1111, lazyGridState, composer2, i21111110);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation1112 = orientation;
                LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda1111, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier1115.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda1111, lazyLayoutSemanticStateRememberLazyGridSemanticState1111, orientation1112, z3, z1117, composer2, (i11111111119 & 57344) | ((i21111111 << 3) & 458752)), orientation1112), lazyGridState, z1117, orientation1112, composer2, i21111110 | ((i21111111 >> 6) & 896)), overscrollEffect1111), lazyGridState, orientation1112, overscrollEffect1111, z3, scrollableDefaults1111.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation1112, z1117), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy1111, composer2, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z1117;
                paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                modifier4 = modifier1115;
                flingBehavior3 = flingBehavior2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
        }
        i4 |= 3072;
        i5 = i3 & 16;
        if (i5 != 0) {
            i4 |= 24576;
        } else if ((i & 57344) == 0) {
            if (composerStartRestartGroup.changed(z)) {
                i6 = 16384;
            } else {
                i6 = 8192;
            }
            i4 |= i6;
        }
        if ((i3 & 32) != 0) {
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
            }
            if ((i & 3670016) != 0) {
                if ((i3 & 64) == 0) {
                    i14 = 524288;
                } else {
                    i14 = 524288;
                }
                i4 |= i14;
            }
            if ((i3 & 128) != 0) {
                if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                    i4 |= i8;
                }
                if ((i3 & 256) != 0) {
                    if ((234881024 & i) == 0) {
                        if (composerStartRestartGroup.changed(vertical)) {
                            i9 = 67108864;
                        } else {
                            i9 = 33554432;
                        }
                    }
                    if ((i3 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changed(horizontal)) {
                                i10 = PropertyOptions.DELETE_EXISTING;
                            } else {
                                i10 = 268435456;
                            }
                        }
                        if ((i3 & 1024) != 0) {
                            i11 = i2 | 6;
                        } else if ((i2 & 14) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                                i12 = 4;
                            } else {
                                i12 = 2;
                            }
                            i11 = i2 | i12;
                        } else {
                            i11 = i2;
                        }
                        if ((i4 & 1533916891) != 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i16 != 0) {
                                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                                } else {
                                    paddingValuesM478PaddingValues0680j_4 = paddingValues;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i13 = i4 & (-3670017);
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    i13 = i4;
                                }
                                z4 = z6;
                            } else {
                                if (i15 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i16 != 0) {
                                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                                } else {
                                    paddingValuesM478PaddingValues0680j_4 = paddingValues;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i13 = i4 & (-3670017);
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    i13 = i4;
                                }
                                z4 = z6;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                            }
                            ScrollableDefaults scrollableDefaults1112 = ScrollableDefaults.INSTANCE;
                            OverscrollEffect overscrollEffect1112 = scrollableDefaults1112.overscrollEffect(composerStartRestartGroup, 6);
                            int i111111111110 = i13 >> 3;
                            int i111111111111 = i111111111110 & 14;
                            InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda1112 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i111111111111 | ((i11 << 3) & 112));
                            int i111111111112 = i13 >> 9;
                            LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState1112 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i111111111111 | (i111111111112 & 112));
                            int i21111112 = i13 & 112;
                            int i21111113 = i13;
                            boolean z1118 = z4;
                            Modifier modifier1116 = modifier3;
                            InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy1112 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda1112, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i111111111112 & 3670016) | (i111111111110 & 29360128), 0);
                            lazyGridState.setVertical$foundation_release(z2);
                            composer2 = composerStartRestartGroup;
                            ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda1112, lazyGridState, composer2, i21111112);
                            if (z2) {
                                orientation = Orientation.Vertical;
                            } else {
                                orientation = Orientation.Horizontal;
                            }
                            Orientation orientation1113 = orientation;
                            LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda1112, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier1116.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda1112, lazyLayoutSemanticStateRememberLazyGridSemanticState1112, orientation1113, z3, z1118, composer2, (i111111111112 & 57344) | ((i21111113 << 3) & 458752)), orientation1113), lazyGridState, z1118, orientation1113, composer2, i21111112 | ((i21111113 >> 6) & 896)), overscrollEffect1112), lazyGridState, orientation1113, overscrollEffect1112, z3, scrollableDefaults1112.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation1113, z1118), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy1112, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z5 = z1118;
                            paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                            modifier4 = modifier1116;
                            flingBehavior3 = flingBehavior2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i16 != 0) {
                                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                                } else {
                                    paddingValuesM478PaddingValues0680j_4 = paddingValues;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i13 = i4 & (-3670017);
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    i13 = i4;
                                }
                                z4 = z6;
                            } else {
                                if (i15 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i16 != 0) {
                                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                                } else {
                                    paddingValuesM478PaddingValues0680j_4 = paddingValues;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i13 = i4 & (-3670017);
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    i13 = i4;
                                }
                                z4 = z6;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                            }
                            ScrollableDefaults scrollableDefaults1113 = ScrollableDefaults.INSTANCE;
                            OverscrollEffect overscrollEffect1113 = scrollableDefaults1113.overscrollEffect(composerStartRestartGroup, 6);
                            int i111111111113 = i13 >> 3;
                            int i111111111114 = i111111111113 & 14;
                            InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda1113 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i111111111114 | ((i11 << 3) & 112));
                            int i111111111115 = i13 >> 9;
                            LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState1113 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i111111111114 | (i111111111115 & 112));
                            int i21111114 = i13 & 112;
                            int i21111115 = i13;
                            boolean z1119 = z4;
                            Modifier modifier1117 = modifier3;
                            InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy1113 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda1113, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i111111111115 & 3670016) | (i111111111113 & 29360128), 0);
                            lazyGridState.setVertical$foundation_release(z2);
                            composer2 = composerStartRestartGroup;
                            ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda1113, lazyGridState, composer2, i21111114);
                            if (z2) {
                                orientation = Orientation.Vertical;
                            } else {
                                orientation = Orientation.Horizontal;
                            }
                            Orientation orientation1114 = orientation;
                            LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda1113, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier1117.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda1113, lazyLayoutSemanticStateRememberLazyGridSemanticState1113, orientation1114, z3, z1119, composer2, (i111111111115 & 57344) | ((i21111115 << 3) & 458752)), orientation1114), lazyGridState, z1119, orientation1114, composer2, i21111114 | ((i21111115 >> 6) & 896)), overscrollEffect1113), lazyGridState, orientation1114, overscrollEffect1113, z3, scrollableDefaults1113.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation1114, z1119), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy1113, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z5 = z1119;
                            paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                            modifier4 = modifier1117;
                            flingBehavior3 = flingBehavior2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
                    }
                    i10 = 805306368;
                    i4 |= i10;
                    if ((i3 & 1024) != 0) {
                        i11 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i12 = 4;
                        } else {
                            i12 = 2;
                        }
                        i11 = i2 | i12;
                    } else {
                        i11 = i2;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        } else {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                        }
                        ScrollableDefaults scrollableDefaults1114 = ScrollableDefaults.INSTANCE;
                        OverscrollEffect overscrollEffect1114 = scrollableDefaults1114.overscrollEffect(composerStartRestartGroup, 6);
                        int i111111111116 = i13 >> 3;
                        int i111111111117 = i111111111116 & 14;
                        InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda1114 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i111111111117 | ((i11 << 3) & 112));
                        int i111111111118 = i13 >> 9;
                        LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState1114 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i111111111117 | (i111111111118 & 112));
                        int i21111116 = i13 & 112;
                        int i21111117 = i13;
                        boolean z11110 = z4;
                        Modifier modifier1118 = modifier3;
                        InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy1114 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda1114, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i111111111118 & 3670016) | (i111111111116 & 29360128), 0);
                        lazyGridState.setVertical$foundation_release(z2);
                        composer2 = composerStartRestartGroup;
                        ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda1114, lazyGridState, composer2, i21111116);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation1115 = orientation;
                        LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda1114, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier1118.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda1114, lazyLayoutSemanticStateRememberLazyGridSemanticState1114, orientation1115, z3, z11110, composer2, (i111111111118 & 57344) | ((i21111117 << 3) & 458752)), orientation1115), lazyGridState, z11110, orientation1115, composer2, i21111116 | ((i21111117 >> 6) & 896)), overscrollEffect1114), lazyGridState, orientation1115, overscrollEffect1114, z3, scrollableDefaults1114.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation1115, z11110), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy1114, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z5 = z11110;
                        paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                        modifier4 = modifier1118;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        } else {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                        }
                        ScrollableDefaults scrollableDefaults1115 = ScrollableDefaults.INSTANCE;
                        OverscrollEffect overscrollEffect1115 = scrollableDefaults1115.overscrollEffect(composerStartRestartGroup, 6);
                        int i111111111119 = i13 >> 3;
                        int i1111111111110 = i111111111119 & 14;
                        InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda1115 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i1111111111110 | ((i11 << 3) & 112));
                        int i1111111111111 = i13 >> 9;
                        LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState1115 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i1111111111110 | (i1111111111111 & 112));
                        int i21111118 = i13 & 112;
                        int i21111119 = i13;
                        boolean z11111 = z4;
                        Modifier modifier1119 = modifier3;
                        InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy1115 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda1115, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i1111111111111 & 3670016) | (i111111111119 & 29360128), 0);
                        lazyGridState.setVertical$foundation_release(z2);
                        composer2 = composerStartRestartGroup;
                        ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda1115, lazyGridState, composer2, i21111118);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation1116 = orientation;
                        LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda1115, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier1119.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda1115, lazyLayoutSemanticStateRememberLazyGridSemanticState1115, orientation1116, z3, z11111, composer2, (i1111111111111 & 57344) | ((i21111119 << 3) & 458752)), orientation1116), lazyGridState, z11111, orientation1116, composer2, i21111118 | ((i21111119 >> 6) & 896)), overscrollEffect1115), lazyGridState, orientation1116, overscrollEffect1115, z3, scrollableDefaults1115.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation1116, z11111), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy1115, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z5 = z11111;
                        paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                        modifier4 = modifier1119;
                        flingBehavior3 = flingBehavior2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
                }
                i9 = 100663296;
                i4 |= i9;
                if ((i3 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changed(horizontal)) {
                            i10 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i10 = 268435456;
                        }
                    }
                    if ((i3 & 1024) != 0) {
                        i11 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i12 = 4;
                        } else {
                            i12 = 2;
                        }
                        i11 = i2 | i12;
                    } else {
                        i11 = i2;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        } else {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                        }
                        ScrollableDefaults scrollableDefaults1116 = ScrollableDefaults.INSTANCE;
                        OverscrollEffect overscrollEffect1116 = scrollableDefaults1116.overscrollEffect(composerStartRestartGroup, 6);
                        int i1111111111112 = i13 >> 3;
                        int i1111111111113 = i1111111111112 & 14;
                        InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda1116 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i1111111111113 | ((i11 << 3) & 112));
                        int i1111111111114 = i13 >> 9;
                        LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState1116 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i1111111111113 | (i1111111111114 & 112));
                        int i211111110 = i13 & 112;
                        int i211111111 = i13;
                        boolean z11112 = z4;
                        Modifier modifier11110 = modifier3;
                        InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy1116 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda1116, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i1111111111114 & 3670016) | (i1111111111112 & 29360128), 0);
                        lazyGridState.setVertical$foundation_release(z2);
                        composer2 = composerStartRestartGroup;
                        ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda1116, lazyGridState, composer2, i211111110);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation1117 = orientation;
                        LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda1116, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier11110.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda1116, lazyLayoutSemanticStateRememberLazyGridSemanticState1116, orientation1117, z3, z11112, composer2, (i1111111111114 & 57344) | ((i211111111 << 3) & 458752)), orientation1117), lazyGridState, z11112, orientation1117, composer2, i211111110 | ((i211111111 >> 6) & 896)), overscrollEffect1116), lazyGridState, orientation1117, overscrollEffect1116, z3, scrollableDefaults1116.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation1117, z11112), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy1116, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z5 = z11112;
                        paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                        modifier4 = modifier11110;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        } else {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                        }
                        ScrollableDefaults scrollableDefaults1117 = ScrollableDefaults.INSTANCE;
                        OverscrollEffect overscrollEffect1117 = scrollableDefaults1117.overscrollEffect(composerStartRestartGroup, 6);
                        int i1111111111115 = i13 >> 3;
                        int i1111111111116 = i1111111111115 & 14;
                        InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda1117 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i1111111111116 | ((i11 << 3) & 112));
                        int i1111111111117 = i13 >> 9;
                        LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState1117 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i1111111111116 | (i1111111111117 & 112));
                        int i211111112 = i13 & 112;
                        int i211111113 = i13;
                        boolean z11113 = z4;
                        Modifier modifier11111 = modifier3;
                        InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy1117 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda1117, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i1111111111117 & 3670016) | (i1111111111115 & 29360128), 0);
                        lazyGridState.setVertical$foundation_release(z2);
                        composer2 = composerStartRestartGroup;
                        ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda1117, lazyGridState, composer2, i211111112);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation1118 = orientation;
                        LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda1117, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier11111.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda1117, lazyLayoutSemanticStateRememberLazyGridSemanticState1117, orientation1118, z3, z11113, composer2, (i1111111111117 & 57344) | ((i211111113 << 3) & 458752)), orientation1118), lazyGridState, z11113, orientation1118, composer2, i211111112 | ((i211111113 >> 6) & 896)), overscrollEffect1117), lazyGridState, orientation1118, overscrollEffect1117, z3, scrollableDefaults1117.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation1118, z11113), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy1117, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z5 = z11113;
                        paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                        modifier4 = modifier11111;
                        flingBehavior3 = flingBehavior2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
                }
                i10 = 805306368;
                i4 |= i10;
                if ((i3 & 1024) != 0) {
                    i11 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i12 = 4;
                    } else {
                        i12 = 2;
                    }
                    i11 = i2 | i12;
                } else {
                    i11 = i2;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    } else {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                    }
                    ScrollableDefaults scrollableDefaults1118 = ScrollableDefaults.INSTANCE;
                    OverscrollEffect overscrollEffect1118 = scrollableDefaults1118.overscrollEffect(composerStartRestartGroup, 6);
                    int i1111111111118 = i13 >> 3;
                    int i1111111111119 = i1111111111118 & 14;
                    InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda1118 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i1111111111119 | ((i11 << 3) & 112));
                    int i11111111111110 = i13 >> 9;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState1118 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i1111111111119 | (i11111111111110 & 112));
                    int i211111114 = i13 & 112;
                    int i211111115 = i13;
                    boolean z11114 = z4;
                    Modifier modifier11112 = modifier3;
                    InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy1118 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda1118, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i11111111111110 & 3670016) | (i1111111111118 & 29360128), 0);
                    lazyGridState.setVertical$foundation_release(z2);
                    composer2 = composerStartRestartGroup;
                    ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda1118, lazyGridState, composer2, i211111114);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation1119 = orientation;
                    LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda1118, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier11112.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda1118, lazyLayoutSemanticStateRememberLazyGridSemanticState1118, orientation1119, z3, z11114, composer2, (i11111111111110 & 57344) | ((i211111115 << 3) & 458752)), orientation1119), lazyGridState, z11114, orientation1119, composer2, i211111114 | ((i211111115 >> 6) & 896)), overscrollEffect1118), lazyGridState, orientation1119, overscrollEffect1118, z3, scrollableDefaults1118.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation1119, z11114), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy1118, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z11114;
                    paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                    modifier4 = modifier11112;
                    flingBehavior3 = flingBehavior2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    } else {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                    }
                    ScrollableDefaults scrollableDefaults1119 = ScrollableDefaults.INSTANCE;
                    OverscrollEffect overscrollEffect1119 = scrollableDefaults1119.overscrollEffect(composerStartRestartGroup, 6);
                    int i11111111111111 = i13 >> 3;
                    int i11111111111112 = i11111111111111 & 14;
                    InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda1119 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i11111111111112 | ((i11 << 3) & 112));
                    int i11111111111113 = i13 >> 9;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState1119 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i11111111111112 | (i11111111111113 & 112));
                    int i211111116 = i13 & 112;
                    int i211111117 = i13;
                    boolean z11115 = z4;
                    Modifier modifier11113 = modifier3;
                    InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy1119 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda1119, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i11111111111113 & 3670016) | (i11111111111111 & 29360128), 0);
                    lazyGridState.setVertical$foundation_release(z2);
                    composer2 = composerStartRestartGroup;
                    ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda1119, lazyGridState, composer2, i211111116);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation11110 = orientation;
                    LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda1119, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier11113.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda1119, lazyLayoutSemanticStateRememberLazyGridSemanticState1119, orientation11110, z3, z11115, composer2, (i11111111111113 & 57344) | ((i211111117 << 3) & 458752)), orientation11110), lazyGridState, z11115, orientation11110, composer2, i211111116 | ((i211111117 >> 6) & 896)), overscrollEffect1119), lazyGridState, orientation11110, overscrollEffect1119, z3, scrollableDefaults1119.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation11110, z11115), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy1119, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z11115;
                    paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                    modifier4 = modifier11113;
                    flingBehavior3 = flingBehavior2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
            }
            i4 |= 12582912;
            if ((i3 & 256) != 0) {
                if ((234881024 & i) == 0) {
                    if (composerStartRestartGroup.changed(vertical)) {
                        i9 = 67108864;
                    } else {
                        i9 = 33554432;
                    }
                }
                if ((i3 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changed(horizontal)) {
                            i10 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i10 = 268435456;
                        }
                    }
                    if ((i3 & 1024) != 0) {
                        i11 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i12 = 4;
                        } else {
                            i12 = 2;
                        }
                        i11 = i2 | i12;
                    } else {
                        i11 = i2;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        } else {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                        }
                        ScrollableDefaults scrollableDefaults11110 = ScrollableDefaults.INSTANCE;
                        OverscrollEffect overscrollEffect11110 = scrollableDefaults11110.overscrollEffect(composerStartRestartGroup, 6);
                        int i11111111111114 = i13 >> 3;
                        int i11111111111115 = i11111111111114 & 14;
                        InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda11110 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i11111111111115 | ((i11 << 3) & 112));
                        int i11111111111116 = i13 >> 9;
                        LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState11110 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i11111111111115 | (i11111111111116 & 112));
                        int i211111118 = i13 & 112;
                        int i211111119 = i13;
                        boolean z11116 = z4;
                        Modifier modifier11114 = modifier3;
                        InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy11110 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda11110, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i11111111111116 & 3670016) | (i11111111111114 & 29360128), 0);
                        lazyGridState.setVertical$foundation_release(z2);
                        composer2 = composerStartRestartGroup;
                        ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda11110, lazyGridState, composer2, i211111118);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation11111 = orientation;
                        LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda11110, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier11114.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda11110, lazyLayoutSemanticStateRememberLazyGridSemanticState11110, orientation11111, z3, z11116, composer2, (i11111111111116 & 57344) | ((i211111119 << 3) & 458752)), orientation11111), lazyGridState, z11116, orientation11111, composer2, i211111118 | ((i211111119 >> 6) & 896)), overscrollEffect11110), lazyGridState, orientation11111, overscrollEffect11110, z3, scrollableDefaults11110.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation11111, z11116), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy11110, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z5 = z11116;
                        paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                        modifier4 = modifier11114;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        } else {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                        }
                        ScrollableDefaults scrollableDefaults11111 = ScrollableDefaults.INSTANCE;
                        OverscrollEffect overscrollEffect11111 = scrollableDefaults11111.overscrollEffect(composerStartRestartGroup, 6);
                        int i11111111111117 = i13 >> 3;
                        int i11111111111118 = i11111111111117 & 14;
                        InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda11111 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i11111111111118 | ((i11 << 3) & 112));
                        int i11111111111119 = i13 >> 9;
                        LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState11111 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i11111111111118 | (i11111111111119 & 112));
                        int i2111111110 = i13 & 112;
                        int i2111111111 = i13;
                        boolean z11117 = z4;
                        Modifier modifier11115 = modifier3;
                        InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy11111 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda11111, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i11111111111119 & 3670016) | (i11111111111117 & 29360128), 0);
                        lazyGridState.setVertical$foundation_release(z2);
                        composer2 = composerStartRestartGroup;
                        ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda11111, lazyGridState, composer2, i2111111110);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation11112 = orientation;
                        LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda11111, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier11115.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda11111, lazyLayoutSemanticStateRememberLazyGridSemanticState11111, orientation11112, z3, z11117, composer2, (i11111111111119 & 57344) | ((i2111111111 << 3) & 458752)), orientation11112), lazyGridState, z11117, orientation11112, composer2, i2111111110 | ((i2111111111 >> 6) & 896)), overscrollEffect11111), lazyGridState, orientation11112, overscrollEffect11111, z3, scrollableDefaults11111.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation11112, z11117), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy11111, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z5 = z11117;
                        paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                        modifier4 = modifier11115;
                        flingBehavior3 = flingBehavior2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
                }
                i10 = 805306368;
                i4 |= i10;
                if ((i3 & 1024) != 0) {
                    i11 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i12 = 4;
                    } else {
                        i12 = 2;
                    }
                    i11 = i2 | i12;
                } else {
                    i11 = i2;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    } else {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                    }
                    ScrollableDefaults scrollableDefaults11112 = ScrollableDefaults.INSTANCE;
                    OverscrollEffect overscrollEffect11112 = scrollableDefaults11112.overscrollEffect(composerStartRestartGroup, 6);
                    int i111111111111110 = i13 >> 3;
                    int i111111111111111 = i111111111111110 & 14;
                    InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda11112 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i111111111111111 | ((i11 << 3) & 112));
                    int i111111111111112 = i13 >> 9;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState11112 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i111111111111111 | (i111111111111112 & 112));
                    int i2111111112 = i13 & 112;
                    int i2111111113 = i13;
                    boolean z11118 = z4;
                    Modifier modifier11116 = modifier3;
                    InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy11112 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda11112, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i111111111111112 & 3670016) | (i111111111111110 & 29360128), 0);
                    lazyGridState.setVertical$foundation_release(z2);
                    composer2 = composerStartRestartGroup;
                    ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda11112, lazyGridState, composer2, i2111111112);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation11113 = orientation;
                    LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda11112, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier11116.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda11112, lazyLayoutSemanticStateRememberLazyGridSemanticState11112, orientation11113, z3, z11118, composer2, (i111111111111112 & 57344) | ((i2111111113 << 3) & 458752)), orientation11113), lazyGridState, z11118, orientation11113, composer2, i2111111112 | ((i2111111113 >> 6) & 896)), overscrollEffect11112), lazyGridState, orientation11113, overscrollEffect11112, z3, scrollableDefaults11112.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation11113, z11118), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy11112, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z11118;
                    paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                    modifier4 = modifier11116;
                    flingBehavior3 = flingBehavior2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    } else {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                    }
                    ScrollableDefaults scrollableDefaults11113 = ScrollableDefaults.INSTANCE;
                    OverscrollEffect overscrollEffect11113 = scrollableDefaults11113.overscrollEffect(composerStartRestartGroup, 6);
                    int i111111111111113 = i13 >> 3;
                    int i111111111111114 = i111111111111113 & 14;
                    InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda11113 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i111111111111114 | ((i11 << 3) & 112));
                    int i111111111111115 = i13 >> 9;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState11113 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i111111111111114 | (i111111111111115 & 112));
                    int i2111111114 = i13 & 112;
                    int i2111111115 = i13;
                    boolean z11119 = z4;
                    Modifier modifier11117 = modifier3;
                    InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy11113 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda11113, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i111111111111115 & 3670016) | (i111111111111113 & 29360128), 0);
                    lazyGridState.setVertical$foundation_release(z2);
                    composer2 = composerStartRestartGroup;
                    ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda11113, lazyGridState, composer2, i2111111114);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation11114 = orientation;
                    LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda11113, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier11117.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda11113, lazyLayoutSemanticStateRememberLazyGridSemanticState11113, orientation11114, z3, z11119, composer2, (i111111111111115 & 57344) | ((i2111111115 << 3) & 458752)), orientation11114), lazyGridState, z11119, orientation11114, composer2, i2111111114 | ((i2111111115 >> 6) & 896)), overscrollEffect11113), lazyGridState, orientation11114, overscrollEffect11113, z3, scrollableDefaults11113.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation11114, z11119), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy11113, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z11119;
                    paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                    modifier4 = modifier11117;
                    flingBehavior3 = flingBehavior2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
            }
            i9 = 100663296;
            i4 |= i9;
            if ((i3 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changed(horizontal)) {
                        i10 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i10 = 268435456;
                    }
                }
                if ((i3 & 1024) != 0) {
                    i11 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i12 = 4;
                    } else {
                        i12 = 2;
                    }
                    i11 = i2 | i12;
                } else {
                    i11 = i2;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    } else {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                    }
                    ScrollableDefaults scrollableDefaults11114 = ScrollableDefaults.INSTANCE;
                    OverscrollEffect overscrollEffect11114 = scrollableDefaults11114.overscrollEffect(composerStartRestartGroup, 6);
                    int i111111111111116 = i13 >> 3;
                    int i111111111111117 = i111111111111116 & 14;
                    InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda11114 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i111111111111117 | ((i11 << 3) & 112));
                    int i111111111111118 = i13 >> 9;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState11114 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i111111111111117 | (i111111111111118 & 112));
                    int i2111111116 = i13 & 112;
                    int i2111111117 = i13;
                    boolean z111110 = z4;
                    Modifier modifier11118 = modifier3;
                    InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy11114 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda11114, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i111111111111118 & 3670016) | (i111111111111116 & 29360128), 0);
                    lazyGridState.setVertical$foundation_release(z2);
                    composer2 = composerStartRestartGroup;
                    ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda11114, lazyGridState, composer2, i2111111116);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation11115 = orientation;
                    LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda11114, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier11118.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda11114, lazyLayoutSemanticStateRememberLazyGridSemanticState11114, orientation11115, z3, z111110, composer2, (i111111111111118 & 57344) | ((i2111111117 << 3) & 458752)), orientation11115), lazyGridState, z111110, orientation11115, composer2, i2111111116 | ((i2111111117 >> 6) & 896)), overscrollEffect11114), lazyGridState, orientation11115, overscrollEffect11114, z3, scrollableDefaults11114.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation11115, z111110), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy11114, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z111110;
                    paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                    modifier4 = modifier11118;
                    flingBehavior3 = flingBehavior2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    } else {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                    }
                    ScrollableDefaults scrollableDefaults11115 = ScrollableDefaults.INSTANCE;
                    OverscrollEffect overscrollEffect11115 = scrollableDefaults11115.overscrollEffect(composerStartRestartGroup, 6);
                    int i111111111111119 = i13 >> 3;
                    int i1111111111111110 = i111111111111119 & 14;
                    InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda11115 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i1111111111111110 | ((i11 << 3) & 112));
                    int i1111111111111111 = i13 >> 9;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState11115 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i1111111111111110 | (i1111111111111111 & 112));
                    int i2111111118 = i13 & 112;
                    int i2111111119 = i13;
                    boolean z111111 = z4;
                    Modifier modifier11119 = modifier3;
                    InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy11115 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda11115, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i1111111111111111 & 3670016) | (i111111111111119 & 29360128), 0);
                    lazyGridState.setVertical$foundation_release(z2);
                    composer2 = composerStartRestartGroup;
                    ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda11115, lazyGridState, composer2, i2111111118);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation11116 = orientation;
                    LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda11115, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier11119.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda11115, lazyLayoutSemanticStateRememberLazyGridSemanticState11115, orientation11116, z3, z111111, composer2, (i1111111111111111 & 57344) | ((i2111111119 << 3) & 458752)), orientation11116), lazyGridState, z111111, orientation11116, composer2, i2111111118 | ((i2111111119 >> 6) & 896)), overscrollEffect11115), lazyGridState, orientation11116, overscrollEffect11115, z3, scrollableDefaults11115.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation11116, z111111), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy11115, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z111111;
                    paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                    modifier4 = modifier11119;
                    flingBehavior3 = flingBehavior2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
            }
            i10 = 805306368;
            i4 |= i10;
            if ((i3 & 1024) != 0) {
                i11 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                    i12 = 4;
                } else {
                    i12 = 2;
                }
                i11 = i2 | i12;
            } else {
                i11 = i2;
            }
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i16 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i13 = i4 & (-3670017);
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                        i13 = i4;
                    }
                    z4 = z6;
                } else {
                    if (i15 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i16 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i13 = i4 & (-3670017);
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                        i13 = i4;
                    }
                    z4 = z6;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                }
                ScrollableDefaults scrollableDefaults11116 = ScrollableDefaults.INSTANCE;
                OverscrollEffect overscrollEffect11116 = scrollableDefaults11116.overscrollEffect(composerStartRestartGroup, 6);
                int i1111111111111112 = i13 >> 3;
                int i1111111111111113 = i1111111111111112 & 14;
                InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda11116 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i1111111111111113 | ((i11 << 3) & 112));
                int i1111111111111114 = i13 >> 9;
                LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState11116 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i1111111111111113 | (i1111111111111114 & 112));
                int i21111111110 = i13 & 112;
                int i21111111111 = i13;
                boolean z111112 = z4;
                Modifier modifier111110 = modifier3;
                InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy11116 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda11116, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i1111111111111114 & 3670016) | (i1111111111111112 & 29360128), 0);
                lazyGridState.setVertical$foundation_release(z2);
                composer2 = composerStartRestartGroup;
                ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda11116, lazyGridState, composer2, i21111111110);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation11117 = orientation;
                LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda11116, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier111110.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda11116, lazyLayoutSemanticStateRememberLazyGridSemanticState11116, orientation11117, z3, z111112, composer2, (i1111111111111114 & 57344) | ((i21111111111 << 3) & 458752)), orientation11117), lazyGridState, z111112, orientation11117, composer2, i21111111110 | ((i21111111111 >> 6) & 896)), overscrollEffect11116), lazyGridState, orientation11117, overscrollEffect11116, z3, scrollableDefaults11116.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation11117, z111112), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy11116, composer2, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z111112;
                paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                modifier4 = modifier111110;
                flingBehavior3 = flingBehavior2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i16 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i13 = i4 & (-3670017);
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                        i13 = i4;
                    }
                    z4 = z6;
                } else {
                    if (i15 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i16 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i13 = i4 & (-3670017);
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                        i13 = i4;
                    }
                    z4 = z6;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                }
                ScrollableDefaults scrollableDefaults11117 = ScrollableDefaults.INSTANCE;
                OverscrollEffect overscrollEffect11117 = scrollableDefaults11117.overscrollEffect(composerStartRestartGroup, 6);
                int i1111111111111115 = i13 >> 3;
                int i1111111111111116 = i1111111111111115 & 14;
                InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda11117 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i1111111111111116 | ((i11 << 3) & 112));
                int i1111111111111117 = i13 >> 9;
                LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState11117 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i1111111111111116 | (i1111111111111117 & 112));
                int i21111111112 = i13 & 112;
                int i21111111113 = i13;
                boolean z111113 = z4;
                Modifier modifier111111 = modifier3;
                InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy11117 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda11117, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i1111111111111117 & 3670016) | (i1111111111111115 & 29360128), 0);
                lazyGridState.setVertical$foundation_release(z2);
                composer2 = composerStartRestartGroup;
                ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda11117, lazyGridState, composer2, i21111111112);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation11118 = orientation;
                LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda11117, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier111111.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda11117, lazyLayoutSemanticStateRememberLazyGridSemanticState11117, orientation11118, z3, z111113, composer2, (i1111111111111117 & 57344) | ((i21111111113 << 3) & 458752)), orientation11118), lazyGridState, z111113, orientation11118, composer2, i21111111112 | ((i21111111113 >> 6) & 896)), overscrollEffect11117), lazyGridState, orientation11118, overscrollEffect11117, z3, scrollableDefaults11117.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation11118, z111113), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy11117, composer2, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z111113;
                paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                modifier4 = modifier111111;
                flingBehavior3 = flingBehavior2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
        }
        i7 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i4 |= i7;
        if ((i & 3670016) != 0) {
            if ((i3 & 64) == 0) {
                i14 = 524288;
            } else {
                i14 = 524288;
            }
            i4 |= i14;
        }
        if ((i3 & 128) != 0) {
            if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i4 |= i8;
            }
            if ((i3 & 256) != 0) {
                if ((234881024 & i) == 0) {
                    if (composerStartRestartGroup.changed(vertical)) {
                        i9 = 67108864;
                    } else {
                        i9 = 33554432;
                    }
                }
                if ((i3 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changed(horizontal)) {
                            i10 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i10 = 268435456;
                        }
                    }
                    if ((i3 & 1024) != 0) {
                        i11 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i12 = 4;
                        } else {
                            i12 = 2;
                        }
                        i11 = i2 | i12;
                    } else {
                        i11 = i2;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        } else {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                        }
                        ScrollableDefaults scrollableDefaults11118 = ScrollableDefaults.INSTANCE;
                        OverscrollEffect overscrollEffect11118 = scrollableDefaults11118.overscrollEffect(composerStartRestartGroup, 6);
                        int i1111111111111118 = i13 >> 3;
                        int i1111111111111119 = i1111111111111118 & 14;
                        InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda11118 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i1111111111111119 | ((i11 << 3) & 112));
                        int i11111111111111110 = i13 >> 9;
                        LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState11118 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i1111111111111119 | (i11111111111111110 & 112));
                        int i21111111114 = i13 & 112;
                        int i21111111115 = i13;
                        boolean z111114 = z4;
                        Modifier modifier111112 = modifier3;
                        InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy11118 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda11118, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i11111111111111110 & 3670016) | (i1111111111111118 & 29360128), 0);
                        lazyGridState.setVertical$foundation_release(z2);
                        composer2 = composerStartRestartGroup;
                        ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda11118, lazyGridState, composer2, i21111111114);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation11119 = orientation;
                        LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda11118, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier111112.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda11118, lazyLayoutSemanticStateRememberLazyGridSemanticState11118, orientation11119, z3, z111114, composer2, (i11111111111111110 & 57344) | ((i21111111115 << 3) & 458752)), orientation11119), lazyGridState, z111114, orientation11119, composer2, i21111111114 | ((i21111111115 >> 6) & 896)), overscrollEffect11118), lazyGridState, orientation11119, overscrollEffect11118, z3, scrollableDefaults11118.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation11119, z111114), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy11118, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z5 = z111114;
                        paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                        modifier4 = modifier111112;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        } else {
                            if (i15 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i16 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i13 = i4 & (-3670017);
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            } else {
                                flingBehavior2 = flingBehavior;
                                i13 = i4;
                            }
                            z4 = z6;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                        }
                        ScrollableDefaults scrollableDefaults11119 = ScrollableDefaults.INSTANCE;
                        OverscrollEffect overscrollEffect11119 = scrollableDefaults11119.overscrollEffect(composerStartRestartGroup, 6);
                        int i11111111111111111 = i13 >> 3;
                        int i11111111111111112 = i11111111111111111 & 14;
                        InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda11119 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i11111111111111112 | ((i11 << 3) & 112));
                        int i11111111111111113 = i13 >> 9;
                        LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState11119 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i11111111111111112 | (i11111111111111113 & 112));
                        int i21111111116 = i13 & 112;
                        int i21111111117 = i13;
                        boolean z111115 = z4;
                        Modifier modifier111113 = modifier3;
                        InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy11119 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda11119, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i11111111111111113 & 3670016) | (i11111111111111111 & 29360128), 0);
                        lazyGridState.setVertical$foundation_release(z2);
                        composer2 = composerStartRestartGroup;
                        ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda11119, lazyGridState, composer2, i21111111116);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation111110 = orientation;
                        LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda11119, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier111113.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda11119, lazyLayoutSemanticStateRememberLazyGridSemanticState11119, orientation111110, z3, z111115, composer2, (i11111111111111113 & 57344) | ((i21111111117 << 3) & 458752)), orientation111110), lazyGridState, z111115, orientation111110, composer2, i21111111116 | ((i21111111117 >> 6) & 896)), overscrollEffect11119), lazyGridState, orientation111110, overscrollEffect11119, z3, scrollableDefaults11119.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation111110, z111115), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy11119, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z5 = z111115;
                        paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                        modifier4 = modifier111113;
                        flingBehavior3 = flingBehavior2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
                }
                i10 = 805306368;
                i4 |= i10;
                if ((i3 & 1024) != 0) {
                    i11 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i12 = 4;
                    } else {
                        i12 = 2;
                    }
                    i11 = i2 | i12;
                } else {
                    i11 = i2;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    } else {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                    }
                    ScrollableDefaults scrollableDefaults111110 = ScrollableDefaults.INSTANCE;
                    OverscrollEffect overscrollEffect111110 = scrollableDefaults111110.overscrollEffect(composerStartRestartGroup, 6);
                    int i11111111111111114 = i13 >> 3;
                    int i11111111111111115 = i11111111111111114 & 14;
                    InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda111110 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i11111111111111115 | ((i11 << 3) & 112));
                    int i11111111111111116 = i13 >> 9;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState111110 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i11111111111111115 | (i11111111111111116 & 112));
                    int i21111111118 = i13 & 112;
                    int i21111111119 = i13;
                    boolean z111116 = z4;
                    Modifier modifier111114 = modifier3;
                    InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy111110 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda111110, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i11111111111111116 & 3670016) | (i11111111111111114 & 29360128), 0);
                    lazyGridState.setVertical$foundation_release(z2);
                    composer2 = composerStartRestartGroup;
                    ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda111110, lazyGridState, composer2, i21111111118);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation111111 = orientation;
                    LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda111110, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier111114.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda111110, lazyLayoutSemanticStateRememberLazyGridSemanticState111110, orientation111111, z3, z111116, composer2, (i11111111111111116 & 57344) | ((i21111111119 << 3) & 458752)), orientation111111), lazyGridState, z111116, orientation111111, composer2, i21111111118 | ((i21111111119 >> 6) & 896)), overscrollEffect111110), lazyGridState, orientation111111, overscrollEffect111110, z3, scrollableDefaults111110.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation111111, z111116), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy111110, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z111116;
                    paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                    modifier4 = modifier111114;
                    flingBehavior3 = flingBehavior2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    } else {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                    }
                    ScrollableDefaults scrollableDefaults111111 = ScrollableDefaults.INSTANCE;
                    OverscrollEffect overscrollEffect111111 = scrollableDefaults111111.overscrollEffect(composerStartRestartGroup, 6);
                    int i11111111111111117 = i13 >> 3;
                    int i11111111111111118 = i11111111111111117 & 14;
                    InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda111111 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i11111111111111118 | ((i11 << 3) & 112));
                    int i11111111111111119 = i13 >> 9;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState111111 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i11111111111111118 | (i11111111111111119 & 112));
                    int i211111111110 = i13 & 112;
                    int i211111111111 = i13;
                    boolean z111117 = z4;
                    Modifier modifier111115 = modifier3;
                    InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy111111 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda111111, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i11111111111111119 & 3670016) | (i11111111111111117 & 29360128), 0);
                    lazyGridState.setVertical$foundation_release(z2);
                    composer2 = composerStartRestartGroup;
                    ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda111111, lazyGridState, composer2, i211111111110);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation111112 = orientation;
                    LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda111111, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier111115.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda111111, lazyLayoutSemanticStateRememberLazyGridSemanticState111111, orientation111112, z3, z111117, composer2, (i11111111111111119 & 57344) | ((i211111111111 << 3) & 458752)), orientation111112), lazyGridState, z111117, orientation111112, composer2, i211111111110 | ((i211111111111 >> 6) & 896)), overscrollEffect111111), lazyGridState, orientation111112, overscrollEffect111111, z3, scrollableDefaults111111.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation111112, z111117), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy111111, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z111117;
                    paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                    modifier4 = modifier111115;
                    flingBehavior3 = flingBehavior2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
            }
            i9 = 100663296;
            i4 |= i9;
            if ((i3 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changed(horizontal)) {
                        i10 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i10 = 268435456;
                    }
                }
                if ((i3 & 1024) != 0) {
                    i11 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i12 = 4;
                    } else {
                        i12 = 2;
                    }
                    i11 = i2 | i12;
                } else {
                    i11 = i2;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    } else {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                    }
                    ScrollableDefaults scrollableDefaults111112 = ScrollableDefaults.INSTANCE;
                    OverscrollEffect overscrollEffect111112 = scrollableDefaults111112.overscrollEffect(composerStartRestartGroup, 6);
                    int i111111111111111110 = i13 >> 3;
                    int i111111111111111111 = i111111111111111110 & 14;
                    InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda111112 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i111111111111111111 | ((i11 << 3) & 112));
                    int i111111111111111112 = i13 >> 9;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState111112 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i111111111111111111 | (i111111111111111112 & 112));
                    int i211111111112 = i13 & 112;
                    int i211111111113 = i13;
                    boolean z111118 = z4;
                    Modifier modifier111116 = modifier3;
                    InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy111112 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda111112, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i111111111111111112 & 3670016) | (i111111111111111110 & 29360128), 0);
                    lazyGridState.setVertical$foundation_release(z2);
                    composer2 = composerStartRestartGroup;
                    ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda111112, lazyGridState, composer2, i211111111112);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation111113 = orientation;
                    LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda111112, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier111116.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda111112, lazyLayoutSemanticStateRememberLazyGridSemanticState111112, orientation111113, z3, z111118, composer2, (i111111111111111112 & 57344) | ((i211111111113 << 3) & 458752)), orientation111113), lazyGridState, z111118, orientation111113, composer2, i211111111112 | ((i211111111113 >> 6) & 896)), overscrollEffect111112), lazyGridState, orientation111113, overscrollEffect111112, z3, scrollableDefaults111112.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation111113, z111118), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy111112, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z111118;
                    paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                    modifier4 = modifier111116;
                    flingBehavior3 = flingBehavior2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    } else {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                    }
                    ScrollableDefaults scrollableDefaults111113 = ScrollableDefaults.INSTANCE;
                    OverscrollEffect overscrollEffect111113 = scrollableDefaults111113.overscrollEffect(composerStartRestartGroup, 6);
                    int i111111111111111113 = i13 >> 3;
                    int i111111111111111114 = i111111111111111113 & 14;
                    InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda111113 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i111111111111111114 | ((i11 << 3) & 112));
                    int i111111111111111115 = i13 >> 9;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState111113 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i111111111111111114 | (i111111111111111115 & 112));
                    int i211111111114 = i13 & 112;
                    int i211111111115 = i13;
                    boolean z111119 = z4;
                    Modifier modifier111117 = modifier3;
                    InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy111113 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda111113, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i111111111111111115 & 3670016) | (i111111111111111113 & 29360128), 0);
                    lazyGridState.setVertical$foundation_release(z2);
                    composer2 = composerStartRestartGroup;
                    ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda111113, lazyGridState, composer2, i211111111114);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation111114 = orientation;
                    LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda111113, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier111117.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda111113, lazyLayoutSemanticStateRememberLazyGridSemanticState111113, orientation111114, z3, z111119, composer2, (i111111111111111115 & 57344) | ((i211111111115 << 3) & 458752)), orientation111114), lazyGridState, z111119, orientation111114, composer2, i211111111114 | ((i211111111115 >> 6) & 896)), overscrollEffect111113), lazyGridState, orientation111114, overscrollEffect111113, z3, scrollableDefaults111113.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation111114, z111119), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy111113, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z111119;
                    paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                    modifier4 = modifier111117;
                    flingBehavior3 = flingBehavior2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
            }
            i10 = 805306368;
            i4 |= i10;
            if ((i3 & 1024) != 0) {
                i11 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                    i12 = 4;
                } else {
                    i12 = 2;
                }
                i11 = i2 | i12;
            } else {
                i11 = i2;
            }
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i16 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i13 = i4 & (-3670017);
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                        i13 = i4;
                    }
                    z4 = z6;
                } else {
                    if (i15 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i16 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i13 = i4 & (-3670017);
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                        i13 = i4;
                    }
                    z4 = z6;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                }
                ScrollableDefaults scrollableDefaults111114 = ScrollableDefaults.INSTANCE;
                OverscrollEffect overscrollEffect111114 = scrollableDefaults111114.overscrollEffect(composerStartRestartGroup, 6);
                int i111111111111111116 = i13 >> 3;
                int i111111111111111117 = i111111111111111116 & 14;
                InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda111114 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i111111111111111117 | ((i11 << 3) & 112));
                int i111111111111111118 = i13 >> 9;
                LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState111114 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i111111111111111117 | (i111111111111111118 & 112));
                int i211111111116 = i13 & 112;
                int i211111111117 = i13;
                boolean z1111110 = z4;
                Modifier modifier111118 = modifier3;
                InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy111114 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda111114, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i111111111111111118 & 3670016) | (i111111111111111116 & 29360128), 0);
                lazyGridState.setVertical$foundation_release(z2);
                composer2 = composerStartRestartGroup;
                ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda111114, lazyGridState, composer2, i211111111116);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation111115 = orientation;
                LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda111114, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier111118.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda111114, lazyLayoutSemanticStateRememberLazyGridSemanticState111114, orientation111115, z3, z1111110, composer2, (i111111111111111118 & 57344) | ((i211111111117 << 3) & 458752)), orientation111115), lazyGridState, z1111110, orientation111115, composer2, i211111111116 | ((i211111111117 >> 6) & 896)), overscrollEffect111114), lazyGridState, orientation111115, overscrollEffect111114, z3, scrollableDefaults111114.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation111115, z1111110), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy111114, composer2, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z1111110;
                paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                modifier4 = modifier111118;
                flingBehavior3 = flingBehavior2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i16 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i13 = i4 & (-3670017);
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                        i13 = i4;
                    }
                    z4 = z6;
                } else {
                    if (i15 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i16 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i13 = i4 & (-3670017);
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                        i13 = i4;
                    }
                    z4 = z6;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                }
                ScrollableDefaults scrollableDefaults111115 = ScrollableDefaults.INSTANCE;
                OverscrollEffect overscrollEffect111115 = scrollableDefaults111115.overscrollEffect(composerStartRestartGroup, 6);
                int i111111111111111119 = i13 >> 3;
                int i1111111111111111110 = i111111111111111119 & 14;
                InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda111115 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i1111111111111111110 | ((i11 << 3) & 112));
                int i1111111111111111111 = i13 >> 9;
                LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState111115 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i1111111111111111110 | (i1111111111111111111 & 112));
                int i211111111118 = i13 & 112;
                int i211111111119 = i13;
                boolean z1111111 = z4;
                Modifier modifier111119 = modifier3;
                InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy111115 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda111115, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i1111111111111111111 & 3670016) | (i111111111111111119 & 29360128), 0);
                lazyGridState.setVertical$foundation_release(z2);
                composer2 = composerStartRestartGroup;
                ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda111115, lazyGridState, composer2, i211111111118);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation111116 = orientation;
                LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda111115, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier111119.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda111115, lazyLayoutSemanticStateRememberLazyGridSemanticState111115, orientation111116, z3, z1111111, composer2, (i1111111111111111111 & 57344) | ((i211111111119 << 3) & 458752)), orientation111116), lazyGridState, z1111111, orientation111116, composer2, i211111111118 | ((i211111111119 >> 6) & 896)), overscrollEffect111115), lazyGridState, orientation111116, overscrollEffect111115, z3, scrollableDefaults111115.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation111116, z1111111), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy111115, composer2, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z1111111;
                paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                modifier4 = modifier111119;
                flingBehavior3 = flingBehavior2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
        }
        i4 |= 12582912;
        if ((i3 & 256) != 0) {
            if ((234881024 & i) == 0) {
                if (composerStartRestartGroup.changed(vertical)) {
                    i9 = 67108864;
                } else {
                    i9 = 33554432;
                }
            }
            if ((i3 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changed(horizontal)) {
                        i10 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i10 = 268435456;
                    }
                }
                if ((i3 & 1024) != 0) {
                    i11 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i12 = 4;
                    } else {
                        i12 = 2;
                    }
                    i11 = i2 | i12;
                } else {
                    i11 = i2;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    } else {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                    }
                    ScrollableDefaults scrollableDefaults111116 = ScrollableDefaults.INSTANCE;
                    OverscrollEffect overscrollEffect111116 = scrollableDefaults111116.overscrollEffect(composerStartRestartGroup, 6);
                    int i1111111111111111112 = i13 >> 3;
                    int i1111111111111111113 = i1111111111111111112 & 14;
                    InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda111116 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i1111111111111111113 | ((i11 << 3) & 112));
                    int i1111111111111111114 = i13 >> 9;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState111116 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i1111111111111111113 | (i1111111111111111114 & 112));
                    int i2111111111110 = i13 & 112;
                    int i2111111111111 = i13;
                    boolean z1111112 = z4;
                    Modifier modifier1111110 = modifier3;
                    InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy111116 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda111116, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i1111111111111111114 & 3670016) | (i1111111111111111112 & 29360128), 0);
                    lazyGridState.setVertical$foundation_release(z2);
                    composer2 = composerStartRestartGroup;
                    ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda111116, lazyGridState, composer2, i2111111111110);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation111117 = orientation;
                    LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda111116, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier1111110.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda111116, lazyLayoutSemanticStateRememberLazyGridSemanticState111116, orientation111117, z3, z1111112, composer2, (i1111111111111111114 & 57344) | ((i2111111111111 << 3) & 458752)), orientation111117), lazyGridState, z1111112, orientation111117, composer2, i2111111111110 | ((i2111111111111 >> 6) & 896)), overscrollEffect111116), lazyGridState, orientation111117, overscrollEffect111116, z3, scrollableDefaults111116.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation111117, z1111112), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy111116, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z1111112;
                    paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                    modifier4 = modifier1111110;
                    flingBehavior3 = flingBehavior2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    } else {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i13 = i4 & (-3670017);
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                            i13 = i4;
                        }
                        z4 = z6;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                    }
                    ScrollableDefaults scrollableDefaults111117 = ScrollableDefaults.INSTANCE;
                    OverscrollEffect overscrollEffect111117 = scrollableDefaults111117.overscrollEffect(composerStartRestartGroup, 6);
                    int i1111111111111111115 = i13 >> 3;
                    int i1111111111111111116 = i1111111111111111115 & 14;
                    InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda111117 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i1111111111111111116 | ((i11 << 3) & 112));
                    int i1111111111111111117 = i13 >> 9;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState111117 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i1111111111111111116 | (i1111111111111111117 & 112));
                    int i2111111111112 = i13 & 112;
                    int i2111111111113 = i13;
                    boolean z1111113 = z4;
                    Modifier modifier1111111 = modifier3;
                    InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy111117 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda111117, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i1111111111111111117 & 3670016) | (i1111111111111111115 & 29360128), 0);
                    lazyGridState.setVertical$foundation_release(z2);
                    composer2 = composerStartRestartGroup;
                    ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda111117, lazyGridState, composer2, i2111111111112);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation111118 = orientation;
                    LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda111117, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier1111111.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda111117, lazyLayoutSemanticStateRememberLazyGridSemanticState111117, orientation111118, z3, z1111113, composer2, (i1111111111111111117 & 57344) | ((i2111111111113 << 3) & 458752)), orientation111118), lazyGridState, z1111113, orientation111118, composer2, i2111111111112 | ((i2111111111113 >> 6) & 896)), overscrollEffect111117), lazyGridState, orientation111118, overscrollEffect111117, z3, scrollableDefaults111117.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation111118, z1111113), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy111117, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z1111113;
                    paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                    modifier4 = modifier1111111;
                    flingBehavior3 = flingBehavior2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
            }
            i10 = 805306368;
            i4 |= i10;
            if ((i3 & 1024) != 0) {
                i11 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                    i12 = 4;
                } else {
                    i12 = 2;
                }
                i11 = i2 | i12;
            } else {
                i11 = i2;
            }
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i16 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i13 = i4 & (-3670017);
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                        i13 = i4;
                    }
                    z4 = z6;
                } else {
                    if (i15 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i16 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i13 = i4 & (-3670017);
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                        i13 = i4;
                    }
                    z4 = z6;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                }
                ScrollableDefaults scrollableDefaults111118 = ScrollableDefaults.INSTANCE;
                OverscrollEffect overscrollEffect111118 = scrollableDefaults111118.overscrollEffect(composerStartRestartGroup, 6);
                int i1111111111111111118 = i13 >> 3;
                int i1111111111111111119 = i1111111111111111118 & 14;
                InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda111118 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i1111111111111111119 | ((i11 << 3) & 112));
                int i11111111111111111110 = i13 >> 9;
                LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState111118 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i1111111111111111119 | (i11111111111111111110 & 112));
                int i2111111111114 = i13 & 112;
                int i2111111111115 = i13;
                boolean z1111114 = z4;
                Modifier modifier1111112 = modifier3;
                InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy111118 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda111118, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i11111111111111111110 & 3670016) | (i1111111111111111118 & 29360128), 0);
                lazyGridState.setVertical$foundation_release(z2);
                composer2 = composerStartRestartGroup;
                ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda111118, lazyGridState, composer2, i2111111111114);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation111119 = orientation;
                LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda111118, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier1111112.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda111118, lazyLayoutSemanticStateRememberLazyGridSemanticState111118, orientation111119, z3, z1111114, composer2, (i11111111111111111110 & 57344) | ((i2111111111115 << 3) & 458752)), orientation111119), lazyGridState, z1111114, orientation111119, composer2, i2111111111114 | ((i2111111111115 >> 6) & 896)), overscrollEffect111118), lazyGridState, orientation111119, overscrollEffect111118, z3, scrollableDefaults111118.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation111119, z1111114), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy111118, composer2, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z1111114;
                paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                modifier4 = modifier1111112;
                flingBehavior3 = flingBehavior2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i16 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i13 = i4 & (-3670017);
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                        i13 = i4;
                    }
                    z4 = z6;
                } else {
                    if (i15 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i16 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i13 = i4 & (-3670017);
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                        i13 = i4;
                    }
                    z4 = z6;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                }
                ScrollableDefaults scrollableDefaults111119 = ScrollableDefaults.INSTANCE;
                OverscrollEffect overscrollEffect111119 = scrollableDefaults111119.overscrollEffect(composerStartRestartGroup, 6);
                int i11111111111111111111 = i13 >> 3;
                int i11111111111111111112 = i11111111111111111111 & 14;
                InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda111119 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i11111111111111111112 | ((i11 << 3) & 112));
                int i11111111111111111113 = i13 >> 9;
                LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState111119 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i11111111111111111112 | (i11111111111111111113 & 112));
                int i2111111111116 = i13 & 112;
                int i2111111111117 = i13;
                boolean z1111115 = z4;
                Modifier modifier1111113 = modifier3;
                InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy111119 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda111119, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i11111111111111111113 & 3670016) | (i11111111111111111111 & 29360128), 0);
                lazyGridState.setVertical$foundation_release(z2);
                composer2 = composerStartRestartGroup;
                ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda111119, lazyGridState, composer2, i2111111111116);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation1111110 = orientation;
                LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda111119, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier1111113.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda111119, lazyLayoutSemanticStateRememberLazyGridSemanticState111119, orientation1111110, z3, z1111115, composer2, (i11111111111111111113 & 57344) | ((i2111111111117 << 3) & 458752)), orientation1111110), lazyGridState, z1111115, orientation1111110, composer2, i2111111111116 | ((i2111111111117 >> 6) & 896)), overscrollEffect111119), lazyGridState, orientation1111110, overscrollEffect111119, z3, scrollableDefaults111119.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation1111110, z1111115), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy111119, composer2, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z1111115;
                paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                modifier4 = modifier1111113;
                flingBehavior3 = flingBehavior2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
        }
        i9 = 100663296;
        i4 |= i9;
        if ((i3 & 512) != 0) {
            if ((1879048192 & i) == 0) {
                if (composerStartRestartGroup.changed(horizontal)) {
                    i10 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i10 = 268435456;
                }
            }
            if ((i3 & 1024) != 0) {
                i11 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                    i12 = 4;
                } else {
                    i12 = 2;
                }
                i11 = i2 | i12;
            } else {
                i11 = i2;
            }
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i16 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i13 = i4 & (-3670017);
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                        i13 = i4;
                    }
                    z4 = z6;
                } else {
                    if (i15 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i16 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i13 = i4 & (-3670017);
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                        i13 = i4;
                    }
                    z4 = z6;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                }
                ScrollableDefaults scrollableDefaults1111110 = ScrollableDefaults.INSTANCE;
                OverscrollEffect overscrollEffect1111110 = scrollableDefaults1111110.overscrollEffect(composerStartRestartGroup, 6);
                int i11111111111111111114 = i13 >> 3;
                int i11111111111111111115 = i11111111111111111114 & 14;
                InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda1111110 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i11111111111111111115 | ((i11 << 3) & 112));
                int i11111111111111111116 = i13 >> 9;
                LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState1111110 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i11111111111111111115 | (i11111111111111111116 & 112));
                int i2111111111118 = i13 & 112;
                int i2111111111119 = i13;
                boolean z1111116 = z4;
                Modifier modifier1111114 = modifier3;
                InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy1111110 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda1111110, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i11111111111111111116 & 3670016) | (i11111111111111111114 & 29360128), 0);
                lazyGridState.setVertical$foundation_release(z2);
                composer2 = composerStartRestartGroup;
                ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda1111110, lazyGridState, composer2, i2111111111118);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation1111111 = orientation;
                LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda1111110, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier1111114.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda1111110, lazyLayoutSemanticStateRememberLazyGridSemanticState1111110, orientation1111111, z3, z1111116, composer2, (i11111111111111111116 & 57344) | ((i2111111111119 << 3) & 458752)), orientation1111111), lazyGridState, z1111116, orientation1111111, composer2, i2111111111118 | ((i2111111111119 >> 6) & 896)), overscrollEffect1111110), lazyGridState, orientation1111111, overscrollEffect1111110, z3, scrollableDefaults1111110.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation1111111, z1111116), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy1111110, composer2, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z1111116;
                paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                modifier4 = modifier1111114;
                flingBehavior3 = flingBehavior2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i16 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i13 = i4 & (-3670017);
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                        i13 = i4;
                    }
                    z4 = z6;
                } else {
                    if (i15 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i16 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i13 = i4 & (-3670017);
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                        i13 = i4;
                    }
                    z4 = z6;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                }
                ScrollableDefaults scrollableDefaults1111111 = ScrollableDefaults.INSTANCE;
                OverscrollEffect overscrollEffect1111111 = scrollableDefaults1111111.overscrollEffect(composerStartRestartGroup, 6);
                int i11111111111111111117 = i13 >> 3;
                int i11111111111111111118 = i11111111111111111117 & 14;
                InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda1111111 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i11111111111111111118 | ((i11 << 3) & 112));
                int i11111111111111111119 = i13 >> 9;
                LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState1111111 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i11111111111111111118 | (i11111111111111111119 & 112));
                int i21111111111110 = i13 & 112;
                int i21111111111111 = i13;
                boolean z1111117 = z4;
                Modifier modifier1111115 = modifier3;
                InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy1111111 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda1111111, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i11111111111111111119 & 3670016) | (i11111111111111111117 & 29360128), 0);
                lazyGridState.setVertical$foundation_release(z2);
                composer2 = composerStartRestartGroup;
                ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda1111111, lazyGridState, composer2, i21111111111110);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation1111112 = orientation;
                LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda1111111, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier1111115.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda1111111, lazyLayoutSemanticStateRememberLazyGridSemanticState1111111, orientation1111112, z3, z1111117, composer2, (i11111111111111111119 & 57344) | ((i21111111111111 << 3) & 458752)), orientation1111112), lazyGridState, z1111117, orientation1111112, composer2, i21111111111110 | ((i21111111111111 >> 6) & 896)), overscrollEffect1111111), lazyGridState, orientation1111112, overscrollEffect1111111, z3, scrollableDefaults1111111.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation1111112, z1111117), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy1111111, composer2, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z1111117;
                paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                modifier4 = modifier1111115;
                flingBehavior3 = flingBehavior2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
        }
        i10 = 805306368;
        i4 |= i10;
        if ((i3 & 1024) != 0) {
            i11 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                i12 = 4;
            } else {
                i12 = 2;
            }
            i11 = i2 | i12;
        } else {
            i11 = i2;
        }
        if ((i4 & 1533916891) != 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i15 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i16 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues;
                }
                if (i5 == 0) {
                }
                if ((i3 & 64) != 0) {
                    i13 = i4 & (-3670017);
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                } else {
                    flingBehavior2 = flingBehavior;
                    i13 = i4;
                }
                z4 = z6;
            } else {
                if (i15 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i16 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues;
                }
                if (i5 == 0) {
                }
                if ((i3 & 64) != 0) {
                    i13 = i4 & (-3670017);
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                } else {
                    flingBehavior2 = flingBehavior;
                    i13 = i4;
                }
                z4 = z6;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
            }
            ScrollableDefaults scrollableDefaults1111112 = ScrollableDefaults.INSTANCE;
            OverscrollEffect overscrollEffect1111112 = scrollableDefaults1111112.overscrollEffect(composerStartRestartGroup, 6);
            int i111111111111111111110 = i13 >> 3;
            int i111111111111111111111 = i111111111111111111110 & 14;
            InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda1111112 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i111111111111111111111 | ((i11 << 3) & 112));
            int i111111111111111111112 = i13 >> 9;
            LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState1111112 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i111111111111111111111 | (i111111111111111111112 & 112));
            int i21111111111112 = i13 & 112;
            int i21111111111113 = i13;
            boolean z1111118 = z4;
            Modifier modifier1111116 = modifier3;
            InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy1111112 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda1111112, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i111111111111111111112 & 3670016) | (i111111111111111111110 & 29360128), 0);
            lazyGridState.setVertical$foundation_release(z2);
            composer2 = composerStartRestartGroup;
            ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda1111112, lazyGridState, composer2, i21111111111112);
            if (z2) {
                orientation = Orientation.Vertical;
            } else {
                orientation = Orientation.Horizontal;
            }
            Orientation orientation1111113 = orientation;
            LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda1111112, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier1111116.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda1111112, lazyLayoutSemanticStateRememberLazyGridSemanticState1111112, orientation1111113, z3, z1111118, composer2, (i111111111111111111112 & 57344) | ((i21111111111113 << 3) & 458752)), orientation1111113), lazyGridState, z1111118, orientation1111113, composer2, i21111111111112 | ((i21111111111113 >> 6) & 896)), overscrollEffect1111112), lazyGridState, orientation1111113, overscrollEffect1111112, z3, scrollableDefaults1111112.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation1111113, z1111118), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy1111112, composer2, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z5 = z1111118;
            paddingValues2 = paddingValuesM478PaddingValues0680j_4;
            modifier4 = modifier1111116;
            flingBehavior3 = flingBehavior2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i15 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i16 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues;
                }
                if (i5 == 0) {
                }
                if ((i3 & 64) != 0) {
                    i13 = i4 & (-3670017);
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                } else {
                    flingBehavior2 = flingBehavior;
                    i13 = i4;
                }
                z4 = z6;
            } else {
                if (i15 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i16 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues;
                }
                if (i5 == 0) {
                }
                if ((i3 & 64) != 0) {
                    i13 = i4 & (-3670017);
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                } else {
                    flingBehavior2 = flingBehavior;
                    i13 = i4;
                }
                z4 = z6;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(152645664, i13, i11, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
            }
            ScrollableDefaults scrollableDefaults1111113 = ScrollableDefaults.INSTANCE;
            OverscrollEffect overscrollEffect1111113 = scrollableDefaults1111113.overscrollEffect(composerStartRestartGroup, 6);
            int i111111111111111111113 = i13 >> 3;
            int i111111111111111111114 = i111111111111111111113 & 14;
            InterfaceC3588op interfaceC3588opRememberLazyGridItemProviderLambda1111113 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, interfaceC3750qp, composerStartRestartGroup, i111111111111111111114 | ((i11 << 3) & 112));
            int i111111111111111111115 = i13 >> 9;
            LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState1111113 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, i111111111111111111114 | (i111111111111111111115 & 112));
            int i21111111111114 = i13 & 112;
            int i21111111111115 = i13;
            boolean z1111119 = z4;
            Modifier modifier1111117 = modifier3;
            InterfaceC0526Fp interfaceC0526FpRememberLazyGridMeasurePolicy1111113 = rememberLazyGridMeasurePolicy(interfaceC3588opRememberLazyGridItemProviderLambda1111113, lazyGridState, interfaceC0526Fp, paddingValuesM478PaddingValues0680j_4, z4, z2, horizontal, vertical, composerStartRestartGroup, (i13 & 524272) | (i111111111111111111115 & 3670016) | (i111111111111111111113 & 29360128), 0);
            lazyGridState.setVertical$foundation_release(z2);
            composer2 = composerStartRestartGroup;
            ScrollPositionUpdater(interfaceC3588opRememberLazyGridItemProviderLambda1111113, lazyGridState, composer2, i21111111111114);
            if (z2) {
                orientation = Orientation.Vertical;
            } else {
                orientation = Orientation.Horizontal;
            }
            Orientation orientation1111114 = orientation;
            LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyGridItemProviderLambda1111113, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier1111117.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyGridItemProviderLambda1111113, lazyLayoutSemanticStateRememberLazyGridSemanticState1111113, orientation1111114, z3, z1111119, composer2, (i111111111111111111115 & 57344) | ((i21111111111115 << 3) & 458752)), orientation1111114), lazyGridState, z1111119, orientation1111114, composer2, i21111111111114 | ((i21111111111115 >> 6) & 896)), overscrollEffect1111113), lazyGridState, orientation1111114, overscrollEffect1111113, z3, scrollableDefaults1111113.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation1111114, z1111119), flingBehavior2, lazyGridState.getInternalInteractionSource$foundation_release()), lazyGridState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyGridMeasurePolicy1111113, composer2, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z5 = z1111119;
            paddingValues2 = paddingValuesM478PaddingValues0680j_4;
            modifier4 = modifier1111117;
            flingBehavior3 = flingBehavior2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyGridState, interfaceC0526Fp, paddingValues2, z5, z2, flingBehavior3, z3, vertical, horizontal, interfaceC3750qp, i, i2, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final void ScrollPositionUpdater(InterfaceC3588op interfaceC3588op, LazyGridState lazyGridState, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-649335720);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(interfaceC3588op) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(lazyGridState) ? 32 : 16;
        }
        if ((i2 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-649335720, i, -1, "androidx.compose.foundation.lazy.grid.ScrollPositionUpdater (LazyGrid.kt:138)");
            }
            LazyGridItemProvider lazyGridItemProvider = (LazyGridItemProvider) interfaceC3588op.invoke();
            if (lazyGridItemProvider.getItemCount() > 0) {
                LazyGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release$default(lazyGridState, lazyGridItemProvider, 0, 2, null);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C13791(interfaceC3588op, lazyGridState, i));
    }

    @Composable
    private static final InterfaceC0526Fp rememberLazyGridMeasurePolicy(InterfaceC3588op interfaceC3588op, LazyGridState lazyGridState, InterfaceC0526Fp interfaceC0526Fp, PaddingValues paddingValues, boolean z, boolean z2, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1292704639);
        Arrangement.Horizontal horizontal2 = (i2 & 64) != 0 ? null : horizontal;
        Arrangement.Vertical vertical2 = (i2 & 128) != 0 ? null : vertical;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1292704639, i, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridMeasurePolicy (LazyGrid.kt:156)");
        }
        Object[] objArr = {lazyGridState, interfaceC0526Fp, paddingValues, Boolean.valueOf(z), Boolean.valueOf(z2), horizontal2, vertical2};
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (int i3 = 0; i3 < 7; i3++) {
            zChanged |= composer.changed(objArr[i3]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new LazyGridKt$rememberLazyGridMeasurePolicy$1$1(z2, paddingValues, z, interfaceC3588op, interfaceC0526Fp, lazyGridState, vertical2, horizontal2);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        InterfaceC0526Fp interfaceC0526Fp2 = (InterfaceC0526Fp) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return interfaceC0526Fp2;
    }
}
