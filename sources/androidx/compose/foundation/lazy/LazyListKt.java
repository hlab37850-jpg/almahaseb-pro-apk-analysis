package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ClipScrollableContainerKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.layout.Arrangement;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
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
public final class LazyListKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListKt$LazyList$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$changed1;
        final /* synthetic */ int $$default;
        final /* synthetic */ int $beyondBoundsItemCount;
        final /* synthetic */ InterfaceC3750qp $content;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ FlingBehavior $flingBehavior;
        final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
        final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
        final /* synthetic */ boolean $isVertical;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ boolean $reverseLayout;
        final /* synthetic */ LazyListState $state;
        final /* synthetic */ boolean $userScrollEnabled;
        final /* synthetic */ Alignment.Vertical $verticalAlignment;
        final /* synthetic */ Arrangement.Vertical $verticalArrangement;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, boolean z2, FlingBehavior flingBehavior, boolean z3, int i, Alignment.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, Arrangement.Horizontal horizontal2, InterfaceC3750qp interfaceC3750qp, int i2, int i3, int i4) {
            super(2);
            this.$modifier = modifier;
            this.$state = lazyListState;
            this.$contentPadding = paddingValues;
            this.$reverseLayout = z;
            this.$isVertical = z2;
            this.$flingBehavior = flingBehavior;
            this.$userScrollEnabled = z3;
            this.$beyondBoundsItemCount = i;
            this.$horizontalAlignment = horizontal;
            this.$verticalArrangement = vertical;
            this.$verticalAlignment = vertical2;
            this.$horizontalArrangement = horizontal2;
            this.$content = interfaceC3750qp;
            this.$$changed = i2;
            this.$$changed1 = i3;
            this.$$default = i4;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            LazyListKt.LazyList(this.$modifier, this.$state, this.$contentPadding, this.$reverseLayout, this.$isVertical, this.$flingBehavior, this.$userScrollEnabled, this.$beyondBoundsItemCount, this.$horizontalAlignment, this.$verticalArrangement, this.$verticalAlignment, this.$horizontalArrangement, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListKt$ScrollPositionUpdater$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13661 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ InterfaceC3588op $itemProviderLambda;
        final /* synthetic */ LazyListState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13661(InterfaceC3588op interfaceC3588op, LazyListState lazyListState, int i) {
            super(2);
            this.$itemProviderLambda = interfaceC3588op;
            this.$state = lazyListState;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            LazyListKt.ScrollPositionUpdater(this.$itemProviderLambda, this.$state, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0146  */
    /* JADX WARN: Code duplicated, block: B:102:0x0149  */
    /* JADX WARN: Code duplicated, block: B:106:0x0151  */
    /* JADX WARN: Code duplicated, block: B:107:0x0156  */
    /* JADX WARN: Code duplicated, block: B:109:0x015c  */
    /* JADX WARN: Code duplicated, block: B:111:0x0162  */
    /* JADX WARN: Code duplicated, block: B:112:0x0165  */
    /* JADX WARN: Code duplicated, block: B:114:0x016a  */
    /* JADX WARN: Code duplicated, block: B:117:0x0170  */
    /* JADX WARN: Code duplicated, block: B:119:0x0175  */
    /* JADX WARN: Code duplicated, block: B:121:0x017b  */
    /* JADX WARN: Code duplicated, block: B:123:0x0181  */
    /* JADX WARN: Code duplicated, block: B:127:0x018a  */
    /* JADX WARN: Code duplicated, block: B:128:0x018d  */
    /* JADX WARN: Code duplicated, block: B:130:0x0191  */
    /* JADX WARN: Code duplicated, block: B:132:0x0197  */
    /* JADX WARN: Code duplicated, block: B:136:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:142:0x01c2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:143:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:144:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:147:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:148:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:150:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:151:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:153:0x01da  */
    /* JADX WARN: Code duplicated, block: B:154:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:156:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:157:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:160:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:163:0x0265  */
    /* JADX WARN: Code duplicated, block: B:165:0x0269  */
    /* JADX WARN: Code duplicated, block: B:168:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:173:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:175:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00da  */
    /* JADX WARN: Code duplicated, block: B:69:0x00de  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:76:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:77:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:79:0x0100  */
    /* JADX WARN: Code duplicated, block: B:81:0x0106  */
    /* JADX WARN: Code duplicated, block: B:82:0x0109  */
    /* JADX WARN: Code duplicated, block: B:86:0x0113  */
    /* JADX WARN: Code duplicated, block: B:87:0x011a  */
    /* JADX WARN: Code duplicated, block: B:89:0x0120  */
    /* JADX WARN: Code duplicated, block: B:91:0x0126  */
    /* JADX WARN: Code duplicated, block: B:92:0x0129  */
    /* JADX WARN: Code duplicated, block: B:96:0x0131  */
    /* JADX WARN: Code duplicated, block: B:97:0x0138  */
    /* JADX WARN: Code duplicated, block: B:99:0x0140  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void LazyList(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, boolean z2, FlingBehavior flingBehavior, boolean z3, int i, Alignment.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, Arrangement.Horizontal horizontal2, InterfaceC3750qp interfaceC3750qp, Composer composer, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        Alignment.Horizontal horizontal3;
        Arrangement.Vertical vertical3;
        Alignment.Vertical vertical4;
        Arrangement.Horizontal horizontal4;
        Composer composer2;
        Orientation orientation;
        Arrangement.Vertical vertical5;
        int i20;
        Alignment.Horizontal horizontal5;
        Arrangement.Horizontal horizontal6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(modifier, "modifier");
        AbstractC4492zt.h(lazyListState, "state");
        AbstractC4492zt.h(paddingValues, "contentPadding");
        AbstractC4492zt.h(flingBehavior, "flingBehavior");
        AbstractC4492zt.h(interfaceC3750qp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(620764179);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(lazyListState) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else if ((i2 & 896) == 0) {
            i5 |= composerStartRestartGroup.changed(paddingValues) ? 256 : 128;
        }
        if ((i4 & 8) != 0) {
            i5 |= 3072;
        } else if ((i2 & 7168) == 0) {
            i5 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i4 & 16) != 0) {
            i5 |= 24576;
        } else if ((i2 & 57344) == 0) {
            i5 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
        }
        if ((i4 & 32) == 0) {
            if ((i2 & 458752) == 0) {
                i6 = composerStartRestartGroup.changed(flingBehavior) ? 131072 : 65536;
            }
            if ((i4 & 64) != 0) {
                if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i5 |= i7;
                }
                i8 = i4 & 128;
                if (i8 != 0) {
                    i5 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i5 |= i9;
                }
                i10 = i4 & 256;
                if (i10 != 0) {
                    i5 |= 100663296;
                } else if ((i2 & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(horizontal)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i5 |= i11;
                }
                i12 = i4 & 512;
                if (i12 != 0) {
                    i5 |= 805306368;
                } else if ((i2 & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(vertical)) {
                        i13 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i13 = 268435456;
                    }
                    i5 |= i13;
                }
                i14 = i4 & 1024;
                if (i14 != 0) {
                    i15 = i3 | 6;
                } else if ((i3 & 14) == 0) {
                    if (composerStartRestartGroup.changed(vertical2)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i15 = i3 | i16;
                } else {
                    i15 = i3;
                }
                i17 = i4 & 2048;
                if (i17 != 0) {
                    i15 |= 48;
                } else if ((i3 & 112) == 0) {
                    i15 |= composerStartRestartGroup.changed(horizontal2) ? 32 : 16;
                }
                i18 = i15;
                if ((i4 & 4096) != 0) {
                    i18 |= 384;
                } else if ((i3 & 896) == 0) {
                    i18 |= composerStartRestartGroup.changedInstance(interfaceC3750qp) ? 256 : 128;
                }
                if ((1533916891 & i5) != 306783378 && (i18 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    i20 = i;
                    horizontal5 = horizontal;
                    vertical5 = vertical;
                    vertical4 = vertical2;
                    horizontal6 = horizontal2;
                    composer2 = composerStartRestartGroup;
                } else {
                    if (i8 != 0) {
                        i19 = 0;
                    } else {
                        i19 = i;
                    }
                    if (i10 != 0) {
                        horizontal3 = null;
                    } else {
                        horizontal3 = horizontal;
                    }
                    if (i12 != 0) {
                        vertical3 = null;
                    } else {
                        vertical3 = vertical;
                    }
                    if (i14 != 0) {
                        vertical4 = null;
                    } else {
                        vertical4 = vertical2;
                    }
                    if (i17 != 0) {
                        horizontal4 = null;
                    } else {
                        horizontal4 = horizontal2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(620764179, i5, i18, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:50)");
                    }
                    int i21 = (i5 >> 3) & 14;
                    InterfaceC3588op interfaceC3588opRememberLazyListItemProviderLambda = LazyListItemProviderKt.rememberLazyListItemProviderLambda(lazyListState, interfaceC3750qp, composerStartRestartGroup, ((i18 >> 3) & 112) | i21);
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyListSemanticState = LazyListSemanticsKt.rememberLazyListSemanticState(lazyListState, z2, composerStartRestartGroup, i21 | ((i5 >> 9) & 112));
                    int i22 = i5 & 112;
                    int i23 = i5 & 7168;
                    int i24 = i5 >> 6;
                    int i25 = i18 << 21;
                    int i26 = i5;
                    Arrangement.Vertical vertical6 = vertical3;
                    InterfaceC0526Fp interfaceC0526FpRememberLazyListMeasurePolicy = rememberLazyListMeasurePolicy(interfaceC3588opRememberLazyListItemProviderLambda, lazyListState, paddingValues, z, z2, i19, horizontal3, vertical4, horizontal4, vertical3, composerStartRestartGroup, (65520 & i5) | (i24 & 458752) | (i24 & 3670016) | (i25 & 29360128) | (i25 & 234881024) | (1879048192 & i5), 0);
                    composer2 = composerStartRestartGroup;
                    ScrollPositionUpdater(interfaceC3588opRememberLazyListItemProviderLambda, lazyListState, composer2, i22);
                    ScrollableDefaults scrollableDefaults = ScrollableDefaults.INSTANCE;
                    OverscrollEffect overscrollEffect = scrollableDefaults.overscrollEffect(composer2, 6);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation2 = orientation;
                    LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyListItemProviderLambda, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyListBeyondBoundsModifierKt.lazyListBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(lazyListState.getRemeasurementModifier$foundation_release()).then(lazyListState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyListItemProviderLambda, lazyLayoutSemanticStateRememberLazyListSemanticState, orientation2, z3, z, composer2, (i24 & 57344) | ((i26 << 6) & 458752)), orientation2), lazyListState, i19, z, orientation2, composer2, ((i26 >> 15) & 896) | i22 | i23), overscrollEffect), lazyListState, orientation2, overscrollEffect, z3, scrollableDefaults.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation2, z), flingBehavior, lazyListState.getInternalInteractionSource$foundation_release()), lazyListState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyListMeasurePolicy, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    vertical5 = vertical6;
                    i20 = i19;
                    horizontal5 = horizontal3;
                    horizontal6 = horizontal4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier, lazyListState, paddingValues, z, z2, flingBehavior, z3, i20, horizontal5, vertical5, vertical4, horizontal6, interfaceC3750qp, i2, i3, i4));
            }
            i5 |= 1572864;
            i8 = i4 & 128;
            if (i8 != 0) {
                i5 |= 12582912;
            } else if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i5 |= i9;
            }
            i10 = i4 & 256;
            if (i10 != 0) {
                i5 |= 100663296;
            } else if ((i2 & 234881024) == 0) {
                if (composerStartRestartGroup.changed(horizontal)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i5 |= i11;
            }
            i12 = i4 & 512;
            if (i12 != 0) {
                i5 |= 805306368;
            } else if ((i2 & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(vertical)) {
                    i13 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i13 = 268435456;
                }
                i5 |= i13;
            }
            i14 = i4 & 1024;
            if (i14 != 0) {
                i15 = i3 | 6;
            } else if ((i3 & 14) == 0) {
                if (composerStartRestartGroup.changed(vertical2)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i15 = i3 | i16;
            } else {
                i15 = i3;
            }
            i17 = i4 & 2048;
            if (i17 != 0) {
                i15 |= 48;
            } else if ((i3 & 112) == 0) {
                i15 |= composerStartRestartGroup.changed(horizontal2) ? 32 : 16;
            }
            i18 = i15;
            if ((i4 & 4096) != 0) {
                i18 |= 384;
            } else if ((i3 & 896) == 0) {
                i18 |= composerStartRestartGroup.changedInstance(interfaceC3750qp) ? 256 : 128;
            }
            if ((1533916891 & i5) != 306783378) {
                if (i8 != 0) {
                    i19 = 0;
                } else {
                    i19 = i;
                }
                if (i10 != 0) {
                    horizontal3 = null;
                } else {
                    horizontal3 = horizontal;
                }
                if (i12 != 0) {
                    vertical3 = null;
                } else {
                    vertical3 = vertical;
                }
                if (i14 != 0) {
                    vertical4 = null;
                } else {
                    vertical4 = vertical2;
                }
                if (i17 != 0) {
                    horizontal4 = null;
                } else {
                    horizontal4 = horizontal2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(620764179, i5, i18, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:50)");
                }
                int i27 = (i5 >> 3) & 14;
                InterfaceC3588op interfaceC3588opRememberLazyListItemProviderLambda2 = LazyListItemProviderKt.rememberLazyListItemProviderLambda(lazyListState, interfaceC3750qp, composerStartRestartGroup, ((i18 >> 3) & 112) | i27);
                LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyListSemanticState2 = LazyListSemanticsKt.rememberLazyListSemanticState(lazyListState, z2, composerStartRestartGroup, i27 | ((i5 >> 9) & 112));
                int i28 = i5 & 112;
                int i29 = i5 & 7168;
                int i210 = i5 >> 6;
                int i211 = i18 << 21;
                int i212 = i5;
                Arrangement.Vertical vertical7 = vertical3;
                InterfaceC0526Fp interfaceC0526FpRememberLazyListMeasurePolicy2 = rememberLazyListMeasurePolicy(interfaceC3588opRememberLazyListItemProviderLambda2, lazyListState, paddingValues, z, z2, i19, horizontal3, vertical4, horizontal4, vertical3, composerStartRestartGroup, (65520 & i5) | (i210 & 458752) | (i210 & 3670016) | (i211 & 29360128) | (i211 & 234881024) | (1879048192 & i5), 0);
                composer2 = composerStartRestartGroup;
                ScrollPositionUpdater(interfaceC3588opRememberLazyListItemProviderLambda2, lazyListState, composer2, i28);
                ScrollableDefaults scrollableDefaults2 = ScrollableDefaults.INSTANCE;
                OverscrollEffect overscrollEffect2 = scrollableDefaults2.overscrollEffect(composer2, 6);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation3 = orientation;
                LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyListItemProviderLambda2, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyListBeyondBoundsModifierKt.lazyListBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(lazyListState.getRemeasurementModifier$foundation_release()).then(lazyListState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyListItemProviderLambda2, lazyLayoutSemanticStateRememberLazyListSemanticState2, orientation3, z3, z, composer2, (i210 & 57344) | ((i212 << 6) & 458752)), orientation3), lazyListState, i19, z, orientation3, composer2, ((i212 >> 15) & 896) | i28 | i29), overscrollEffect2), lazyListState, orientation3, overscrollEffect2, z3, scrollableDefaults2.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation3, z), flingBehavior, lazyListState.getInternalInteractionSource$foundation_release()), lazyListState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyListMeasurePolicy2, composer2, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                vertical5 = vertical7;
                i20 = i19;
                horizontal5 = horizontal3;
                horizontal6 = horizontal4;
            } else {
                if (i8 != 0) {
                    i19 = 0;
                } else {
                    i19 = i;
                }
                if (i10 != 0) {
                    horizontal3 = null;
                } else {
                    horizontal3 = horizontal;
                }
                if (i12 != 0) {
                    vertical3 = null;
                } else {
                    vertical3 = vertical;
                }
                if (i14 != 0) {
                    vertical4 = null;
                } else {
                    vertical4 = vertical2;
                }
                if (i17 != 0) {
                    horizontal4 = null;
                } else {
                    horizontal4 = horizontal2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(620764179, i5, i18, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:50)");
                }
                int i213 = (i5 >> 3) & 14;
                InterfaceC3588op interfaceC3588opRememberLazyListItemProviderLambda3 = LazyListItemProviderKt.rememberLazyListItemProviderLambda(lazyListState, interfaceC3750qp, composerStartRestartGroup, ((i18 >> 3) & 112) | i213);
                LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyListSemanticState3 = LazyListSemanticsKt.rememberLazyListSemanticState(lazyListState, z2, composerStartRestartGroup, i213 | ((i5 >> 9) & 112));
                int i214 = i5 & 112;
                int i215 = i5 & 7168;
                int i216 = i5 >> 6;
                int i217 = i18 << 21;
                int i218 = i5;
                Arrangement.Vertical vertical8 = vertical3;
                InterfaceC0526Fp interfaceC0526FpRememberLazyListMeasurePolicy3 = rememberLazyListMeasurePolicy(interfaceC3588opRememberLazyListItemProviderLambda3, lazyListState, paddingValues, z, z2, i19, horizontal3, vertical4, horizontal4, vertical3, composerStartRestartGroup, (65520 & i5) | (i216 & 458752) | (i216 & 3670016) | (i217 & 29360128) | (i217 & 234881024) | (1879048192 & i5), 0);
                composer2 = composerStartRestartGroup;
                ScrollPositionUpdater(interfaceC3588opRememberLazyListItemProviderLambda3, lazyListState, composer2, i214);
                ScrollableDefaults scrollableDefaults3 = ScrollableDefaults.INSTANCE;
                OverscrollEffect overscrollEffect3 = scrollableDefaults3.overscrollEffect(composer2, 6);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation4 = orientation;
                LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyListItemProviderLambda3, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyListBeyondBoundsModifierKt.lazyListBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(lazyListState.getRemeasurementModifier$foundation_release()).then(lazyListState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyListItemProviderLambda3, lazyLayoutSemanticStateRememberLazyListSemanticState3, orientation4, z3, z, composer2, (i216 & 57344) | ((i218 << 6) & 458752)), orientation4), lazyListState, i19, z, orientation4, composer2, ((i218 >> 15) & 896) | i214 | i215), overscrollEffect3), lazyListState, orientation4, overscrollEffect3, z3, scrollableDefaults3.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation4, z), flingBehavior, lazyListState.getInternalInteractionSource$foundation_release()), lazyListState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyListMeasurePolicy3, composer2, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                vertical5 = vertical8;
                i20 = i19;
                horizontal5 = horizontal3;
                horizontal6 = horizontal4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier, lazyListState, paddingValues, z, z2, flingBehavior, z3, i20, horizontal5, vertical5, vertical4, horizontal6, interfaceC3750qp, i2, i3, i4));
        }
        i6 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i5 |= i6;
        if ((i4 & 64) != 0) {
            if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i5 |= i7;
            }
            i8 = i4 & 128;
            if (i8 != 0) {
                i5 |= 12582912;
            } else if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i5 |= i9;
            }
            i10 = i4 & 256;
            if (i10 != 0) {
                i5 |= 100663296;
            } else if ((i2 & 234881024) == 0) {
                if (composerStartRestartGroup.changed(horizontal)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i5 |= i11;
            }
            i12 = i4 & 512;
            if (i12 != 0) {
                i5 |= 805306368;
            } else if ((i2 & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(vertical)) {
                    i13 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i13 = 268435456;
                }
                i5 |= i13;
            }
            i14 = i4 & 1024;
            if (i14 != 0) {
                i15 = i3 | 6;
            } else if ((i3 & 14) == 0) {
                if (composerStartRestartGroup.changed(vertical2)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i15 = i3 | i16;
            } else {
                i15 = i3;
            }
            i17 = i4 & 2048;
            if (i17 != 0) {
                i15 |= 48;
            } else if ((i3 & 112) == 0) {
                i15 |= composerStartRestartGroup.changed(horizontal2) ? 32 : 16;
            }
            i18 = i15;
            if ((i4 & 4096) != 0) {
                i18 |= 384;
            } else if ((i3 & 896) == 0) {
                i18 |= composerStartRestartGroup.changedInstance(interfaceC3750qp) ? 256 : 128;
            }
            if ((1533916891 & i5) != 306783378) {
                if (i8 != 0) {
                    i19 = 0;
                } else {
                    i19 = i;
                }
                if (i10 != 0) {
                    horizontal3 = null;
                } else {
                    horizontal3 = horizontal;
                }
                if (i12 != 0) {
                    vertical3 = null;
                } else {
                    vertical3 = vertical;
                }
                if (i14 != 0) {
                    vertical4 = null;
                } else {
                    vertical4 = vertical2;
                }
                if (i17 != 0) {
                    horizontal4 = null;
                } else {
                    horizontal4 = horizontal2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(620764179, i5, i18, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:50)");
                }
                int i219 = (i5 >> 3) & 14;
                InterfaceC3588op interfaceC3588opRememberLazyListItemProviderLambda4 = LazyListItemProviderKt.rememberLazyListItemProviderLambda(lazyListState, interfaceC3750qp, composerStartRestartGroup, ((i18 >> 3) & 112) | i219);
                LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyListSemanticState4 = LazyListSemanticsKt.rememberLazyListSemanticState(lazyListState, z2, composerStartRestartGroup, i219 | ((i5 >> 9) & 112));
                int i2110 = i5 & 112;
                int i2111 = i5 & 7168;
                int i2112 = i5 >> 6;
                int i2113 = i18 << 21;
                int i2114 = i5;
                Arrangement.Vertical vertical9 = vertical3;
                InterfaceC0526Fp interfaceC0526FpRememberLazyListMeasurePolicy4 = rememberLazyListMeasurePolicy(interfaceC3588opRememberLazyListItemProviderLambda4, lazyListState, paddingValues, z, z2, i19, horizontal3, vertical4, horizontal4, vertical3, composerStartRestartGroup, (65520 & i5) | (i2112 & 458752) | (i2112 & 3670016) | (i2113 & 29360128) | (i2113 & 234881024) | (1879048192 & i5), 0);
                composer2 = composerStartRestartGroup;
                ScrollPositionUpdater(interfaceC3588opRememberLazyListItemProviderLambda4, lazyListState, composer2, i2110);
                ScrollableDefaults scrollableDefaults4 = ScrollableDefaults.INSTANCE;
                OverscrollEffect overscrollEffect4 = scrollableDefaults4.overscrollEffect(composer2, 6);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation5 = orientation;
                LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyListItemProviderLambda4, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyListBeyondBoundsModifierKt.lazyListBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(lazyListState.getRemeasurementModifier$foundation_release()).then(lazyListState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyListItemProviderLambda4, lazyLayoutSemanticStateRememberLazyListSemanticState4, orientation5, z3, z, composer2, (i2112 & 57344) | ((i2114 << 6) & 458752)), orientation5), lazyListState, i19, z, orientation5, composer2, ((i2114 >> 15) & 896) | i2110 | i2111), overscrollEffect4), lazyListState, orientation5, overscrollEffect4, z3, scrollableDefaults4.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation5, z), flingBehavior, lazyListState.getInternalInteractionSource$foundation_release()), lazyListState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyListMeasurePolicy4, composer2, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                vertical5 = vertical9;
                i20 = i19;
                horizontal5 = horizontal3;
                horizontal6 = horizontal4;
            } else {
                if (i8 != 0) {
                    i19 = 0;
                } else {
                    i19 = i;
                }
                if (i10 != 0) {
                    horizontal3 = null;
                } else {
                    horizontal3 = horizontal;
                }
                if (i12 != 0) {
                    vertical3 = null;
                } else {
                    vertical3 = vertical;
                }
                if (i14 != 0) {
                    vertical4 = null;
                } else {
                    vertical4 = vertical2;
                }
                if (i17 != 0) {
                    horizontal4 = null;
                } else {
                    horizontal4 = horizontal2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(620764179, i5, i18, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:50)");
                }
                int i2115 = (i5 >> 3) & 14;
                InterfaceC3588op interfaceC3588opRememberLazyListItemProviderLambda5 = LazyListItemProviderKt.rememberLazyListItemProviderLambda(lazyListState, interfaceC3750qp, composerStartRestartGroup, ((i18 >> 3) & 112) | i2115);
                LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyListSemanticState5 = LazyListSemanticsKt.rememberLazyListSemanticState(lazyListState, z2, composerStartRestartGroup, i2115 | ((i5 >> 9) & 112));
                int i2116 = i5 & 112;
                int i2117 = i5 & 7168;
                int i2118 = i5 >> 6;
                int i2119 = i18 << 21;
                int i21110 = i5;
                Arrangement.Vertical vertical10 = vertical3;
                InterfaceC0526Fp interfaceC0526FpRememberLazyListMeasurePolicy5 = rememberLazyListMeasurePolicy(interfaceC3588opRememberLazyListItemProviderLambda5, lazyListState, paddingValues, z, z2, i19, horizontal3, vertical4, horizontal4, vertical3, composerStartRestartGroup, (65520 & i5) | (i2118 & 458752) | (i2118 & 3670016) | (i2119 & 29360128) | (i2119 & 234881024) | (1879048192 & i5), 0);
                composer2 = composerStartRestartGroup;
                ScrollPositionUpdater(interfaceC3588opRememberLazyListItemProviderLambda5, lazyListState, composer2, i2116);
                ScrollableDefaults scrollableDefaults5 = ScrollableDefaults.INSTANCE;
                OverscrollEffect overscrollEffect5 = scrollableDefaults5.overscrollEffect(composer2, 6);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation6 = orientation;
                LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyListItemProviderLambda5, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyListBeyondBoundsModifierKt.lazyListBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(lazyListState.getRemeasurementModifier$foundation_release()).then(lazyListState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyListItemProviderLambda5, lazyLayoutSemanticStateRememberLazyListSemanticState5, orientation6, z3, z, composer2, (i2118 & 57344) | ((i21110 << 6) & 458752)), orientation6), lazyListState, i19, z, orientation6, composer2, ((i21110 >> 15) & 896) | i2116 | i2117), overscrollEffect5), lazyListState, orientation6, overscrollEffect5, z3, scrollableDefaults5.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation6, z), flingBehavior, lazyListState.getInternalInteractionSource$foundation_release()), lazyListState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyListMeasurePolicy5, composer2, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                vertical5 = vertical10;
                i20 = i19;
                horizontal5 = horizontal3;
                horizontal6 = horizontal4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier, lazyListState, paddingValues, z, z2, flingBehavior, z3, i20, horizontal5, vertical5, vertical4, horizontal6, interfaceC3750qp, i2, i3, i4));
        }
        i5 |= 1572864;
        i8 = i4 & 128;
        if (i8 != 0) {
            i5 |= 12582912;
        } else if ((i2 & 29360128) == 0) {
            if (composerStartRestartGroup.changed(i)) {
                i9 = 8388608;
            } else {
                i9 = 4194304;
            }
            i5 |= i9;
        }
        i10 = i4 & 256;
        if (i10 != 0) {
            i5 |= 100663296;
        } else if ((i2 & 234881024) == 0) {
            if (composerStartRestartGroup.changed(horizontal)) {
                i11 = 67108864;
            } else {
                i11 = 33554432;
            }
            i5 |= i11;
        }
        i12 = i4 & 512;
        if (i12 != 0) {
            i5 |= 805306368;
        } else if ((i2 & 1879048192) == 0) {
            if (composerStartRestartGroup.changed(vertical)) {
                i13 = PropertyOptions.DELETE_EXISTING;
            } else {
                i13 = 268435456;
            }
            i5 |= i13;
        }
        i14 = i4 & 1024;
        if (i14 != 0) {
            i15 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            if (composerStartRestartGroup.changed(vertical2)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i15 = i3 | i16;
        } else {
            i15 = i3;
        }
        i17 = i4 & 2048;
        if (i17 != 0) {
            i15 |= 48;
        } else if ((i3 & 112) == 0) {
            i15 |= composerStartRestartGroup.changed(horizontal2) ? 32 : 16;
        }
        i18 = i15;
        if ((i4 & 4096) != 0) {
            i18 |= 384;
        } else if ((i3 & 896) == 0) {
            i18 |= composerStartRestartGroup.changedInstance(interfaceC3750qp) ? 256 : 128;
        }
        if ((1533916891 & i5) != 306783378) {
            if (i8 != 0) {
                i19 = 0;
            } else {
                i19 = i;
            }
            if (i10 != 0) {
                horizontal3 = null;
            } else {
                horizontal3 = horizontal;
            }
            if (i12 != 0) {
                vertical3 = null;
            } else {
                vertical3 = vertical;
            }
            if (i14 != 0) {
                vertical4 = null;
            } else {
                vertical4 = vertical2;
            }
            if (i17 != 0) {
                horizontal4 = null;
            } else {
                horizontal4 = horizontal2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(620764179, i5, i18, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:50)");
            }
            int i21111 = (i5 >> 3) & 14;
            InterfaceC3588op interfaceC3588opRememberLazyListItemProviderLambda6 = LazyListItemProviderKt.rememberLazyListItemProviderLambda(lazyListState, interfaceC3750qp, composerStartRestartGroup, ((i18 >> 3) & 112) | i21111);
            LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyListSemanticState6 = LazyListSemanticsKt.rememberLazyListSemanticState(lazyListState, z2, composerStartRestartGroup, i21111 | ((i5 >> 9) & 112));
            int i21112 = i5 & 112;
            int i21113 = i5 & 7168;
            int i21114 = i5 >> 6;
            int i21115 = i18 << 21;
            int i21116 = i5;
            Arrangement.Vertical vertical11 = vertical3;
            InterfaceC0526Fp interfaceC0526FpRememberLazyListMeasurePolicy6 = rememberLazyListMeasurePolicy(interfaceC3588opRememberLazyListItemProviderLambda6, lazyListState, paddingValues, z, z2, i19, horizontal3, vertical4, horizontal4, vertical3, composerStartRestartGroup, (65520 & i5) | (i21114 & 458752) | (i21114 & 3670016) | (i21115 & 29360128) | (i21115 & 234881024) | (1879048192 & i5), 0);
            composer2 = composerStartRestartGroup;
            ScrollPositionUpdater(interfaceC3588opRememberLazyListItemProviderLambda6, lazyListState, composer2, i21112);
            ScrollableDefaults scrollableDefaults6 = ScrollableDefaults.INSTANCE;
            OverscrollEffect overscrollEffect6 = scrollableDefaults6.overscrollEffect(composer2, 6);
            if (z2) {
                orientation = Orientation.Vertical;
            } else {
                orientation = Orientation.Horizontal;
            }
            Orientation orientation7 = orientation;
            LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyListItemProviderLambda6, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyListBeyondBoundsModifierKt.lazyListBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(lazyListState.getRemeasurementModifier$foundation_release()).then(lazyListState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyListItemProviderLambda6, lazyLayoutSemanticStateRememberLazyListSemanticState6, orientation7, z3, z, composer2, (i21114 & 57344) | ((i21116 << 6) & 458752)), orientation7), lazyListState, i19, z, orientation7, composer2, ((i21116 >> 15) & 896) | i21112 | i21113), overscrollEffect6), lazyListState, orientation7, overscrollEffect6, z3, scrollableDefaults6.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation7, z), flingBehavior, lazyListState.getInternalInteractionSource$foundation_release()), lazyListState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyListMeasurePolicy6, composer2, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            vertical5 = vertical11;
            i20 = i19;
            horizontal5 = horizontal3;
            horizontal6 = horizontal4;
        } else {
            if (i8 != 0) {
                i19 = 0;
            } else {
                i19 = i;
            }
            if (i10 != 0) {
                horizontal3 = null;
            } else {
                horizontal3 = horizontal;
            }
            if (i12 != 0) {
                vertical3 = null;
            } else {
                vertical3 = vertical;
            }
            if (i14 != 0) {
                vertical4 = null;
            } else {
                vertical4 = vertical2;
            }
            if (i17 != 0) {
                horizontal4 = null;
            } else {
                horizontal4 = horizontal2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(620764179, i5, i18, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:50)");
            }
            int i21117 = (i5 >> 3) & 14;
            InterfaceC3588op interfaceC3588opRememberLazyListItemProviderLambda7 = LazyListItemProviderKt.rememberLazyListItemProviderLambda(lazyListState, interfaceC3750qp, composerStartRestartGroup, ((i18 >> 3) & 112) | i21117);
            LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyListSemanticState7 = LazyListSemanticsKt.rememberLazyListSemanticState(lazyListState, z2, composerStartRestartGroup, i21117 | ((i5 >> 9) & 112));
            int i21118 = i5 & 112;
            int i21119 = i5 & 7168;
            int i211110 = i5 >> 6;
            int i211111 = i18 << 21;
            int i211112 = i5;
            Arrangement.Vertical vertical12 = vertical3;
            InterfaceC0526Fp interfaceC0526FpRememberLazyListMeasurePolicy7 = rememberLazyListMeasurePolicy(interfaceC3588opRememberLazyListItemProviderLambda7, lazyListState, paddingValues, z, z2, i19, horizontal3, vertical4, horizontal4, vertical3, composerStartRestartGroup, (65520 & i5) | (i211110 & 458752) | (i211110 & 3670016) | (i211111 & 29360128) | (i211111 & 234881024) | (1879048192 & i5), 0);
            composer2 = composerStartRestartGroup;
            ScrollPositionUpdater(interfaceC3588opRememberLazyListItemProviderLambda7, lazyListState, composer2, i21118);
            ScrollableDefaults scrollableDefaults7 = ScrollableDefaults.INSTANCE;
            OverscrollEffect overscrollEffect7 = scrollableDefaults7.overscrollEffect(composer2, 6);
            if (z2) {
                orientation = Orientation.Vertical;
            } else {
                orientation = Orientation.Horizontal;
            }
            Orientation orientation8 = orientation;
            LazyLayoutKt.LazyLayout(interfaceC3588opRememberLazyListItemProviderLambda7, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyListBeyondBoundsModifierKt.lazyListBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(lazyListState.getRemeasurementModifier$foundation_release()).then(lazyListState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberLazyListItemProviderLambda7, lazyLayoutSemanticStateRememberLazyListSemanticState7, orientation8, z3, z, composer2, (i211110 & 57344) | ((i211112 << 6) & 458752)), orientation8), lazyListState, i19, z, orientation8, composer2, ((i211112 >> 15) & 896) | i21118 | i21119), overscrollEffect7), lazyListState, orientation8, overscrollEffect7, z3, scrollableDefaults7.reverseDirection((LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation8, z), flingBehavior, lazyListState.getInternalInteractionSource$foundation_release()), lazyListState.getPrefetchState$foundation_release(), interfaceC0526FpRememberLazyListMeasurePolicy7, composer2, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            vertical5 = vertical12;
            i20 = i19;
            horizontal5 = horizontal3;
            horizontal6 = horizontal4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier, lazyListState, paddingValues, z, z2, flingBehavior, z3, i20, horizontal5, vertical5, vertical4, horizontal6, interfaceC3750qp, i2, i3, i4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ExperimentalFoundationApi
    public static final void ScrollPositionUpdater(InterfaceC3588op interfaceC3588op, LazyListState lazyListState, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-331135862);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(interfaceC3588op) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(lazyListState) ? 32 : 16;
        }
        if ((i2 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-331135862, i, -1, "androidx.compose.foundation.lazy.ScrollPositionUpdater (LazyList.kt:140)");
            }
            LazyListItemProvider lazyListItemProvider = (LazyListItemProvider) interfaceC3588op.invoke();
            if (lazyListItemProvider.getItemCount() > 0) {
                LazyListState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release$default(lazyListState, lazyListItemProvider, 0, 2, null);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C13661(interfaceC3588op, lazyListState, i));
    }

    @Composable
    @ExperimentalFoundationApi
    private static final InterfaceC0526Fp rememberLazyListMeasurePolicy(InterfaceC3588op interfaceC3588op, LazyListState lazyListState, PaddingValues paddingValues, boolean z, boolean z2, int i, Alignment.Horizontal horizontal, Alignment.Vertical vertical, Arrangement.Horizontal horizontal2, Arrangement.Vertical vertical2, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(183156450);
        Alignment.Horizontal horizontal3 = (i3 & 64) != 0 ? null : horizontal;
        Alignment.Vertical vertical3 = (i3 & 128) != 0 ? null : vertical;
        Arrangement.Horizontal horizontal4 = (i3 & 256) != 0 ? null : horizontal2;
        Arrangement.Vertical vertical4 = (i3 & 512) != 0 ? null : vertical2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(183156450, i2, -1, "androidx.compose.foundation.lazy.rememberLazyListMeasurePolicy (LazyList.kt:152)");
        }
        Object[] objArr = {lazyListState, paddingValues, Boolean.valueOf(z), Boolean.valueOf(z2), horizontal3, vertical3, horizontal4, vertical4};
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (int i4 = 0; i4 < 8; i4++) {
            zChanged |= composer.changed(objArr[i4]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new LazyListKt$rememberLazyListMeasurePolicy$1$1(z2, paddingValues, z, lazyListState, interfaceC3588op, vertical4, horizontal4, i, horizontal3, vertical3);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        InterfaceC0526Fp interfaceC0526Fp = (InterfaceC0526Fp) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return interfaceC0526Fp;
    }
}
