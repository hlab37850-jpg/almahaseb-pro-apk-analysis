package androidx.compose.material;

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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.profileinstaller.ProfileVerifier;
import defpackage.AbstractC2044dc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2260gB;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ListItemKt {

    /* JADX INFO: renamed from: androidx.compose.material.ListItemKt$BaselinesOffsetColumn$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC0526Fp $content;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ List<Dp> $offsets;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List<Dp> list, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, int i, int i2) {
            super(2);
            this.$offsets = list;
            this.$modifier = modifier;
            this.$content = interfaceC0526Fp;
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
            ListItemKt.BaselinesOffsetColumn(this.$offsets, this.$modifier, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ListItemKt$ListItem$1, reason: invalid class name and case insensitive filesystem */
    public static final class C14251 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC0526Fp $icon;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC0526Fp $overlineText;
        final /* synthetic */ InterfaceC0526Fp $secondaryText;
        final /* synthetic */ boolean $singleLineSecondaryText;
        final /* synthetic */ InterfaceC0526Fp $text;
        final /* synthetic */ InterfaceC0526Fp $trailing;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14251(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, boolean z, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, InterfaceC0526Fp interfaceC0526Fp5, int i, int i2) {
            super(2);
            this.$modifier = modifier;
            this.$icon = interfaceC0526Fp;
            this.$secondaryText = interfaceC0526Fp2;
            this.$singleLineSecondaryText = z;
            this.$overlineText = interfaceC0526Fp3;
            this.$trailing = interfaceC0526Fp4;
            this.$text = interfaceC0526Fp5;
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
            ListItemKt.ListItem(this.$modifier, this.$icon, this.$secondaryText, this.$singleLineSecondaryText, this.$overlineText, this.$trailing, this.$text, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ListItemKt$applyTextStyle$1, reason: invalid class name and case insensitive filesystem */
    public static final class C14261 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ float $contentAlpha;
        final /* synthetic */ InterfaceC0526Fp $icon;
        final /* synthetic */ TextStyle $textStyle;

        /* JADX INFO: renamed from: androidx.compose.material.ListItemKt$applyTextStyle$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00781 extends AbstractC2233fv implements InterfaceC0526Fp {
            final /* synthetic */ InterfaceC0526Fp $icon;
            final /* synthetic */ TextStyle $textStyle;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00781(TextStyle textStyle, InterfaceC0526Fp interfaceC0526Fp) {
                super(2);
                this.$textStyle = textStyle;
                this.$icon = interfaceC0526Fp;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return FW.a;
            }

            @Composable
            public final void invoke(Composer composer, int i) {
                if ((i & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1665877604, i, -1, "androidx.compose.material.applyTextStyle.<anonymous>.<anonymous> (ListItem.kt:423)");
                }
                TextKt.ProvideTextStyle(this.$textStyle, this.$icon, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14261(float f, TextStyle textStyle, InterfaceC0526Fp interfaceC0526Fp) {
            super(2);
            this.$contentAlpha = f;
            this.$textStyle = textStyle;
            this.$icon = interfaceC0526Fp;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        @Composable
        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-830176860, i, -1, "androidx.compose.material.applyTextStyle.<anonymous> (ListItem.kt:422)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(this.$contentAlpha))}, ComposableLambdaKt.composableLambda(composer, 1665877604, true, new C00781(this.$textStyle, this.$icon)), composer, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void BaselinesOffsetColumn(final List<Dp> list, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1631148337);
        if ((i2 & 2) != 0) {
            modifier = Modifier.Companion;
        }
        Modifier modifier2 = modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1631148337, i, -1, "androidx.compose.material.BaselinesOffsetColumn (ListItem.kt:347)");
        }
        MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material.ListItemKt.BaselinesOffsetColumn.1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list2, int i3) {
                return AbstractC2260gB.a(this, intrinsicMeasureScope, list2, i3);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list2, int i3) {
                return AbstractC2260gB.b(this, intrinsicMeasureScope, list2, i3);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list2, long j) {
                int height;
                AbstractC4492zt.h(measureScope, "$this$Layout");
                AbstractC4492zt.h(list2, "measurables");
                long jM5119copyZbe2FdA$default = Constraints.m5119copyZbe2FdA$default(j, 0, 0, 0, Integer.MAX_VALUE, 3, null);
                List<? extends Measurable> list3 = list2;
                ArrayList arrayList = new ArrayList(AbstractC2044dc.x(list3, 10));
                Iterator<T> it = list3.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Measurable) it.next()).mo4159measureBRTryo0(jM5119copyZbe2FdA$default));
                }
                Iterator it2 = arrayList.iterator();
                int iMax = 0;
                while (it2.hasNext()) {
                    iMax = Math.max(iMax, ((Placeable) it2.next()).getWidth());
                }
                int size = arrayList.size();
                Integer[] numArr = new Integer[size];
                for (int i3 = 0; i3 < size; i3++) {
                    numArr[i3] = 0;
                }
                List<Dp> list4 = list;
                int size2 = arrayList.size();
                int height2 = 0;
                for (int i4 = 0; i4 < size2; i4++) {
                    Placeable placeable = (Placeable) arrayList.get(i4);
                    if (i4 > 0) {
                        int i5 = i4 - 1;
                        height = ((Placeable) arrayList.get(i5)).getHeight() - ((Placeable) arrayList.get(i5)).get(AlignmentLineKt.getLastBaseline());
                    } else {
                        height = 0;
                    }
                    int iMax2 = Math.max(0, (measureScope.mo327roundToPx0680j_4(list4.get(i4).m5174unboximpl()) - placeable.get(AlignmentLineKt.getFirstBaseline())) - height);
                    numArr[i4] = Integer.valueOf(iMax2 + height2);
                    height2 += iMax2 + placeable.getHeight();
                }
                return MeasureScope.CC.q(measureScope, iMax, height2, null, new ListItemKt$BaselinesOffsetColumn$1$measure$2(arrayList, numArr), 4, null);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list2, int i3) {
                return AbstractC2260gB.c(this, intrinsicMeasureScope, list2, i3);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list2, int i3) {
                return AbstractC2260gB.d(this, intrinsicMeasureScope, list2, i3);
            }
        };
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        InterfaceC3588op constructor = companion.getConstructor();
        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier2);
        int i3 = (((((i >> 6) & 14) | (i & 112)) << 9) & 7168) | 6;
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
        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicy, companion.getSetMeasurePolicy());
        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
        InterfaceC0526Fp setCompositeKeyHash = companion.getSetCompositeKeyHash();
        if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(list, modifier2, interfaceC0526Fp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:102:0x011c  */
    /* JADX WARN: Code duplicated, block: B:105:0x016a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:107:0x0189  */
    /* JADX WARN: Code duplicated, block: B:109:0x018d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:110:0x018f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:115:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:120:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:122:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARN: Code duplicated, block: B:60:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:88:0x0101  */
    /* JADX WARN: Code duplicated, block: B:90:0x0104  */
    /* JADX WARN: Code duplicated, block: B:91:0x0106  */
    /* JADX WARN: Code duplicated, block: B:93:0x0109  */
    /* JADX WARN: Code duplicated, block: B:94:0x010c  */
    /* JADX WARN: Code duplicated, block: B:96:0x0110  */
    /* JADX WARN: Code duplicated, block: B:99:0x0114  */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][_][_][_][_]]")
    public static final void ListItem(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, boolean z, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, InterfaceC0526Fp interfaceC0526Fp5, Composer composer, int i, int i2) {
        int i3;
        InterfaceC0526Fp interfaceC0526Fp6;
        int i4;
        InterfaceC0526Fp interfaceC0526Fp7;
        int i5;
        int i6;
        boolean z2;
        int i7;
        int i8;
        InterfaceC0526Fp interfaceC0526Fp8;
        int i9;
        int i10;
        int i11;
        int i12;
        Modifier modifier2;
        InterfaceC0526Fp interfaceC0526Fp9;
        boolean z3;
        InterfaceC0526Fp interfaceC0526FpApplyTextStyle;
        InterfaceC0526Fp interfaceC0526FpApplyTextStyle2;
        InterfaceC0526Fp interfaceC0526FpApplyTextStyle3;
        InterfaceC0526Fp interfaceC0526FpApplyTextStyle4;
        Modifier modifierSemantics;
        InterfaceC0526Fp interfaceC0526Fp10;
        InterfaceC0526Fp interfaceC0526Fp11;
        boolean z4;
        InterfaceC0526Fp interfaceC0526Fp12;
        Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0526Fp5, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(-450923337);
        int i13 = i2 & 1;
        if (i13 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i14 = i2 & 2;
        if (i14 == 0) {
            if ((i & 112) == 0) {
                interfaceC0526Fp6 = interfaceC0526Fp;
                i3 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp6) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    interfaceC0526Fp7 = interfaceC0526Fp2;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp7)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 7168) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((57344 & i) == 0) {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp8)) {
                                i9 = 16384;
                            } else {
                                i9 = 8192;
                            }
                            i3 |= i9;
                        }
                        i10 = i2 & 32;
                        if (i10 != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i & 458752) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                        if ((i2 & 64) != 0) {
                            i3 |= 1572864;
                        } else if ((i & 3670016) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                                i12 = 1048576;
                            } else {
                                i12 = 524288;
                            }
                            i3 |= i12;
                        }
                        if ((i3 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp6 = null;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp7;
                            }
                            if (i6 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i8 != 0) {
                                interfaceC0526Fp8 = null;
                            }
                            InterfaceC0526Fp interfaceC0526Fp13 = i10 == 0 ? interfaceC0526Fp4 : null;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                            }
                            Typography typography = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            TextStyle subtitle1 = typography.getSubtitle1();
                            ContentAlpha contentAlpha = ContentAlpha.INSTANCE;
                            interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle1, contentAlpha.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                            AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                            interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography.getBody2(), contentAlpha.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                            interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography.getOverline(), contentAlpha.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                            interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography.getCaption(), contentAlpha.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                            modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                            if (interfaceC0526FpApplyTextStyle2 == null || interfaceC0526FpApplyTextStyle3 != null) {
                                interfaceC0526Fp10 = interfaceC0526Fp8;
                                if ((interfaceC0526FpApplyTextStyle3 == null || !z3) && interfaceC0526FpApplyTextStyle2 != null) {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceableGroup(-210280382);
                                    TwoLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                }
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280579);
                                interfaceC0526Fp10 = interfaceC0526Fp8;
                                OneLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 24576, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp13;
                            z4 = z3;
                            interfaceC0526Fp12 = interfaceC0526Fp10;
                            modifier3 = modifier2;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier;
                            interfaceC0526Fp11 = interfaceC0526Fp4;
                            interfaceC0526Fp9 = interfaceC0526Fp7;
                            z4 = z2;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new C14251(modifier3, interfaceC0526Fp6, interfaceC0526Fp9, z4, interfaceC0526Fp12, interfaceC0526Fp11, interfaceC0526Fp5, i, i2));
                    }
                    i3 |= 24576;
                    interfaceC0526Fp8 = interfaceC0526Fp3;
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 64) != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 2995931) == 599186) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp7;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i10 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                        }
                        Typography typography2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        TextStyle subtitle2 = typography2.getSubtitle1();
                        ContentAlpha contentAlpha2 = ContentAlpha.INSTANCE;
                        interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle2, contentAlpha2.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                        AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                        interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography2.getBody2(), contentAlpha2.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                        interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography2.getOverline(), contentAlpha2.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                        interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography2.getCaption(), contentAlpha2.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                        modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                        if (interfaceC0526FpApplyTextStyle2 == null) {
                            interfaceC0526Fp10 = interfaceC0526Fp8;
                            if (interfaceC0526FpApplyTextStyle3 == null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp8;
                            if (interfaceC0526FpApplyTextStyle3 == null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp13;
                        z4 = z3;
                        interfaceC0526Fp12 = interfaceC0526Fp10;
                        modifier3 = modifier2;
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp7;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i10 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                        }
                        Typography typography3 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        TextStyle subtitle3 = typography3.getSubtitle1();
                        ContentAlpha contentAlpha3 = ContentAlpha.INSTANCE;
                        interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle3, contentAlpha3.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                        AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                        interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography3.getBody2(), contentAlpha3.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                        interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography3.getOverline(), contentAlpha3.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                        interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography3.getCaption(), contentAlpha3.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                        modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                        if (interfaceC0526FpApplyTextStyle2 == null) {
                            interfaceC0526Fp10 = interfaceC0526Fp8;
                            if (interfaceC0526FpApplyTextStyle3 == null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp8;
                            if (interfaceC0526FpApplyTextStyle3 == null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp13;
                        z4 = z3;
                        interfaceC0526Fp12 = interfaceC0526Fp10;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new C14251(modifier3, interfaceC0526Fp6, interfaceC0526Fp9, z4, interfaceC0526Fp12, interfaceC0526Fp11, interfaceC0526Fp5, i, i2));
                }
                i3 |= 3072;
                z2 = z;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((57344 & i) == 0) {
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp8)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 64) != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 2995931) == 599186) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp7;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i10 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                        }
                        Typography typography4 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        TextStyle subtitle4 = typography4.getSubtitle1();
                        ContentAlpha contentAlpha4 = ContentAlpha.INSTANCE;
                        interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle4, contentAlpha4.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                        AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                        interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography4.getBody2(), contentAlpha4.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                        interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography4.getOverline(), contentAlpha4.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                        interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography4.getCaption(), contentAlpha4.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                        modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                        if (interfaceC0526FpApplyTextStyle2 == null) {
                            interfaceC0526Fp10 = interfaceC0526Fp8;
                            if (interfaceC0526FpApplyTextStyle3 == null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp8;
                            if (interfaceC0526FpApplyTextStyle3 == null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp13;
                        z4 = z3;
                        interfaceC0526Fp12 = interfaceC0526Fp10;
                        modifier3 = modifier2;
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp7;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i10 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                        }
                        Typography typography5 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        TextStyle subtitle5 = typography5.getSubtitle1();
                        ContentAlpha contentAlpha5 = ContentAlpha.INSTANCE;
                        interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle5, contentAlpha5.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                        AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                        interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography5.getBody2(), contentAlpha5.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                        interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography5.getOverline(), contentAlpha5.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                        interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography5.getCaption(), contentAlpha5.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                        modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                        if (interfaceC0526FpApplyTextStyle2 == null) {
                            interfaceC0526Fp10 = interfaceC0526Fp8;
                            if (interfaceC0526FpApplyTextStyle3 == null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp8;
                            if (interfaceC0526FpApplyTextStyle3 == null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp13;
                        z4 = z3;
                        interfaceC0526Fp12 = interfaceC0526Fp10;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new C14251(modifier3, interfaceC0526Fp6, interfaceC0526Fp9, z4, interfaceC0526Fp12, interfaceC0526Fp11, interfaceC0526Fp5, i, i2));
                }
                i3 |= 24576;
                interfaceC0526Fp8 = interfaceC0526Fp3;
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i3 & 2995931) == 599186) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp7;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i10 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                    }
                    Typography typography6 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    TextStyle subtitle6 = typography6.getSubtitle1();
                    ContentAlpha contentAlpha6 = ContentAlpha.INSTANCE;
                    interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle6, contentAlpha6.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                    AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                    interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography6.getBody2(), contentAlpha6.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                    interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography6.getOverline(), contentAlpha6.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                    interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography6.getCaption(), contentAlpha6.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                    modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                    if (interfaceC0526FpApplyTextStyle2 == null) {
                        interfaceC0526Fp10 = interfaceC0526Fp8;
                        if (interfaceC0526FpApplyTextStyle3 == null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp8;
                        if (interfaceC0526FpApplyTextStyle3 == null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp13;
                    z4 = z3;
                    interfaceC0526Fp12 = interfaceC0526Fp10;
                    modifier3 = modifier2;
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp7;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i10 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                    }
                    Typography typography7 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    TextStyle subtitle7 = typography7.getSubtitle1();
                    ContentAlpha contentAlpha7 = ContentAlpha.INSTANCE;
                    interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle7, contentAlpha7.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                    AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                    interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography7.getBody2(), contentAlpha7.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                    interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography7.getOverline(), contentAlpha7.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                    interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography7.getCaption(), contentAlpha7.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                    modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                    if (interfaceC0526FpApplyTextStyle2 == null) {
                        interfaceC0526Fp10 = interfaceC0526Fp8;
                        if (interfaceC0526FpApplyTextStyle3 == null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp8;
                        if (interfaceC0526FpApplyTextStyle3 == null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp13;
                    z4 = z3;
                    interfaceC0526Fp12 = interfaceC0526Fp10;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14251(modifier3, interfaceC0526Fp6, interfaceC0526Fp9, z4, interfaceC0526Fp12, interfaceC0526Fp11, interfaceC0526Fp5, i, i2));
            }
            i3 |= 384;
            interfaceC0526Fp7 = interfaceC0526Fp2;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((57344 & i) == 0) {
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp8)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 64) != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 2995931) == 599186) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp7;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i10 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                        }
                        Typography typography8 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        TextStyle subtitle8 = typography8.getSubtitle1();
                        ContentAlpha contentAlpha8 = ContentAlpha.INSTANCE;
                        interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle8, contentAlpha8.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                        AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                        interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography8.getBody2(), contentAlpha8.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                        interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography8.getOverline(), contentAlpha8.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                        interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography8.getCaption(), contentAlpha8.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                        modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                        if (interfaceC0526FpApplyTextStyle2 == null) {
                            interfaceC0526Fp10 = interfaceC0526Fp8;
                            if (interfaceC0526FpApplyTextStyle3 == null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp8;
                            if (interfaceC0526FpApplyTextStyle3 == null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp13;
                        z4 = z3;
                        interfaceC0526Fp12 = interfaceC0526Fp10;
                        modifier3 = modifier2;
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp7;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i10 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                        }
                        Typography typography9 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        TextStyle subtitle9 = typography9.getSubtitle1();
                        ContentAlpha contentAlpha9 = ContentAlpha.INSTANCE;
                        interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle9, contentAlpha9.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                        AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                        interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography9.getBody2(), contentAlpha9.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                        interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography9.getOverline(), contentAlpha9.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                        interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography9.getCaption(), contentAlpha9.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                        modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                        if (interfaceC0526FpApplyTextStyle2 == null) {
                            interfaceC0526Fp10 = interfaceC0526Fp8;
                            if (interfaceC0526FpApplyTextStyle3 == null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp8;
                            if (interfaceC0526FpApplyTextStyle3 == null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp13;
                        z4 = z3;
                        interfaceC0526Fp12 = interfaceC0526Fp10;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new C14251(modifier3, interfaceC0526Fp6, interfaceC0526Fp9, z4, interfaceC0526Fp12, interfaceC0526Fp11, interfaceC0526Fp5, i, i2));
                }
                i3 |= 24576;
                interfaceC0526Fp8 = interfaceC0526Fp3;
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i3 & 2995931) == 599186) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp7;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i10 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                    }
                    Typography typography10 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    TextStyle subtitle10 = typography10.getSubtitle1();
                    ContentAlpha contentAlpha10 = ContentAlpha.INSTANCE;
                    interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle10, contentAlpha10.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                    AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                    interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography10.getBody2(), contentAlpha10.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                    interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography10.getOverline(), contentAlpha10.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                    interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography10.getCaption(), contentAlpha10.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                    modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                    if (interfaceC0526FpApplyTextStyle2 == null) {
                        interfaceC0526Fp10 = interfaceC0526Fp8;
                        if (interfaceC0526FpApplyTextStyle3 == null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp8;
                        if (interfaceC0526FpApplyTextStyle3 == null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp13;
                    z4 = z3;
                    interfaceC0526Fp12 = interfaceC0526Fp10;
                    modifier3 = modifier2;
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp7;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i10 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                    }
                    Typography typography11 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    TextStyle subtitle11 = typography11.getSubtitle1();
                    ContentAlpha contentAlpha11 = ContentAlpha.INSTANCE;
                    interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle11, contentAlpha11.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                    AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                    interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography11.getBody2(), contentAlpha11.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                    interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography11.getOverline(), contentAlpha11.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                    interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography11.getCaption(), contentAlpha11.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                    modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                    if (interfaceC0526FpApplyTextStyle2 == null) {
                        interfaceC0526Fp10 = interfaceC0526Fp8;
                        if (interfaceC0526FpApplyTextStyle3 == null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp8;
                        if (interfaceC0526FpApplyTextStyle3 == null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp13;
                    z4 = z3;
                    interfaceC0526Fp12 = interfaceC0526Fp10;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14251(modifier3, interfaceC0526Fp6, interfaceC0526Fp9, z4, interfaceC0526Fp12, interfaceC0526Fp11, interfaceC0526Fp5, i, i2));
            }
            i3 |= 3072;
            z2 = z;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((57344 & i) == 0) {
                    interfaceC0526Fp8 = interfaceC0526Fp3;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp8)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i3 & 2995931) == 599186) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp7;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i10 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                    }
                    Typography typography12 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    TextStyle subtitle12 = typography12.getSubtitle1();
                    ContentAlpha contentAlpha12 = ContentAlpha.INSTANCE;
                    interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle12, contentAlpha12.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                    AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                    interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography12.getBody2(), contentAlpha12.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                    interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography12.getOverline(), contentAlpha12.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                    interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography12.getCaption(), contentAlpha12.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                    modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                    if (interfaceC0526FpApplyTextStyle2 == null) {
                        interfaceC0526Fp10 = interfaceC0526Fp8;
                        if (interfaceC0526FpApplyTextStyle3 == null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp8;
                        if (interfaceC0526FpApplyTextStyle3 == null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp13;
                    z4 = z3;
                    interfaceC0526Fp12 = interfaceC0526Fp10;
                    modifier3 = modifier2;
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp7;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i10 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                    }
                    Typography typography13 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    TextStyle subtitle13 = typography13.getSubtitle1();
                    ContentAlpha contentAlpha13 = ContentAlpha.INSTANCE;
                    interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle13, contentAlpha13.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                    AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                    interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography13.getBody2(), contentAlpha13.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                    interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography13.getOverline(), contentAlpha13.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                    interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography13.getCaption(), contentAlpha13.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                    modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                    if (interfaceC0526FpApplyTextStyle2 == null) {
                        interfaceC0526Fp10 = interfaceC0526Fp8;
                        if (interfaceC0526FpApplyTextStyle3 == null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp8;
                        if (interfaceC0526FpApplyTextStyle3 == null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp13;
                    z4 = z3;
                    interfaceC0526Fp12 = interfaceC0526Fp10;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14251(modifier3, interfaceC0526Fp6, interfaceC0526Fp9, z4, interfaceC0526Fp12, interfaceC0526Fp11, interfaceC0526Fp5, i, i2));
            }
            i3 |= 24576;
            interfaceC0526Fp8 = interfaceC0526Fp3;
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            if ((i2 & 64) != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
                i3 |= i12;
            }
            if ((i3 & 2995931) == 599186) {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i14 != 0) {
                    interfaceC0526Fp6 = null;
                }
                if (i4 != 0) {
                    interfaceC0526Fp9 = null;
                } else {
                    interfaceC0526Fp9 = interfaceC0526Fp7;
                }
                if (i6 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i8 != 0) {
                    interfaceC0526Fp8 = null;
                }
                if (i10 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                }
                Typography typography14 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                TextStyle subtitle14 = typography14.getSubtitle1();
                ContentAlpha contentAlpha14 = ContentAlpha.INSTANCE;
                interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle14, contentAlpha14.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography14.getBody2(), contentAlpha14.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography14.getOverline(), contentAlpha14.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography14.getCaption(), contentAlpha14.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                if (interfaceC0526FpApplyTextStyle2 == null) {
                    interfaceC0526Fp10 = interfaceC0526Fp8;
                    if (interfaceC0526FpApplyTextStyle3 == null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                } else {
                    interfaceC0526Fp10 = interfaceC0526Fp8;
                    if (interfaceC0526FpApplyTextStyle3 == null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp11 = interfaceC0526Fp13;
                z4 = z3;
                interfaceC0526Fp12 = interfaceC0526Fp10;
                modifier3 = modifier2;
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i14 != 0) {
                    interfaceC0526Fp6 = null;
                }
                if (i4 != 0) {
                    interfaceC0526Fp9 = null;
                } else {
                    interfaceC0526Fp9 = interfaceC0526Fp7;
                }
                if (i6 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i8 != 0) {
                    interfaceC0526Fp8 = null;
                }
                if (i10 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                }
                Typography typography15 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                TextStyle subtitle15 = typography15.getSubtitle1();
                ContentAlpha contentAlpha15 = ContentAlpha.INSTANCE;
                interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle15, contentAlpha15.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography15.getBody2(), contentAlpha15.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography15.getOverline(), contentAlpha15.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography15.getCaption(), contentAlpha15.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                if (interfaceC0526FpApplyTextStyle2 == null) {
                    interfaceC0526Fp10 = interfaceC0526Fp8;
                    if (interfaceC0526FpApplyTextStyle3 == null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                } else {
                    interfaceC0526Fp10 = interfaceC0526Fp8;
                    if (interfaceC0526FpApplyTextStyle3 == null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp11 = interfaceC0526Fp13;
                z4 = z3;
                interfaceC0526Fp12 = interfaceC0526Fp10;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C14251(modifier3, interfaceC0526Fp6, interfaceC0526Fp9, z4, interfaceC0526Fp12, interfaceC0526Fp11, interfaceC0526Fp5, i, i2));
        }
        i3 |= 48;
        interfaceC0526Fp6 = interfaceC0526Fp;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                interfaceC0526Fp7 = interfaceC0526Fp2;
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp7)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((57344 & i) == 0) {
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp8)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 64) != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 2995931) == 599186) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp7;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i10 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                        }
                        Typography typography16 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        TextStyle subtitle16 = typography16.getSubtitle1();
                        ContentAlpha contentAlpha16 = ContentAlpha.INSTANCE;
                        interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle16, contentAlpha16.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                        AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                        interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography16.getBody2(), contentAlpha16.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                        interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography16.getOverline(), contentAlpha16.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                        interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography16.getCaption(), contentAlpha16.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                        modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                        if (interfaceC0526FpApplyTextStyle2 == null) {
                            interfaceC0526Fp10 = interfaceC0526Fp8;
                            if (interfaceC0526FpApplyTextStyle3 == null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp8;
                            if (interfaceC0526FpApplyTextStyle3 == null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp13;
                        z4 = z3;
                        interfaceC0526Fp12 = interfaceC0526Fp10;
                        modifier3 = modifier2;
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp7;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i10 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                        }
                        Typography typography17 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        TextStyle subtitle17 = typography17.getSubtitle1();
                        ContentAlpha contentAlpha17 = ContentAlpha.INSTANCE;
                        interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle17, contentAlpha17.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                        AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                        interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography17.getBody2(), contentAlpha17.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                        interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography17.getOverline(), contentAlpha17.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                        interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography17.getCaption(), contentAlpha17.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                        modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                        if (interfaceC0526FpApplyTextStyle2 == null) {
                            interfaceC0526Fp10 = interfaceC0526Fp8;
                            if (interfaceC0526FpApplyTextStyle3 == null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp8;
                            if (interfaceC0526FpApplyTextStyle3 == null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp13;
                        z4 = z3;
                        interfaceC0526Fp12 = interfaceC0526Fp10;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new C14251(modifier3, interfaceC0526Fp6, interfaceC0526Fp9, z4, interfaceC0526Fp12, interfaceC0526Fp11, interfaceC0526Fp5, i, i2));
                }
                i3 |= 24576;
                interfaceC0526Fp8 = interfaceC0526Fp3;
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i3 & 2995931) == 599186) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp7;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i10 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                    }
                    Typography typography18 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    TextStyle subtitle18 = typography18.getSubtitle1();
                    ContentAlpha contentAlpha18 = ContentAlpha.INSTANCE;
                    interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle18, contentAlpha18.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                    AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                    interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography18.getBody2(), contentAlpha18.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                    interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography18.getOverline(), contentAlpha18.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                    interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography18.getCaption(), contentAlpha18.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                    modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                    if (interfaceC0526FpApplyTextStyle2 == null) {
                        interfaceC0526Fp10 = interfaceC0526Fp8;
                        if (interfaceC0526FpApplyTextStyle3 == null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp8;
                        if (interfaceC0526FpApplyTextStyle3 == null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp13;
                    z4 = z3;
                    interfaceC0526Fp12 = interfaceC0526Fp10;
                    modifier3 = modifier2;
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp7;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i10 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                    }
                    Typography typography19 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    TextStyle subtitle19 = typography19.getSubtitle1();
                    ContentAlpha contentAlpha19 = ContentAlpha.INSTANCE;
                    interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle19, contentAlpha19.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                    AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                    interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography19.getBody2(), contentAlpha19.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                    interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography19.getOverline(), contentAlpha19.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                    interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography19.getCaption(), contentAlpha19.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                    modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                    if (interfaceC0526FpApplyTextStyle2 == null) {
                        interfaceC0526Fp10 = interfaceC0526Fp8;
                        if (interfaceC0526FpApplyTextStyle3 == null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp8;
                        if (interfaceC0526FpApplyTextStyle3 == null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp13;
                    z4 = z3;
                    interfaceC0526Fp12 = interfaceC0526Fp10;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14251(modifier3, interfaceC0526Fp6, interfaceC0526Fp9, z4, interfaceC0526Fp12, interfaceC0526Fp11, interfaceC0526Fp5, i, i2));
            }
            i3 |= 3072;
            z2 = z;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((57344 & i) == 0) {
                    interfaceC0526Fp8 = interfaceC0526Fp3;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp8)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i3 & 2995931) == 599186) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp7;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i10 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                    }
                    Typography typography110 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    TextStyle subtitle110 = typography110.getSubtitle1();
                    ContentAlpha contentAlpha110 = ContentAlpha.INSTANCE;
                    interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle110, contentAlpha110.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                    AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                    interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography110.getBody2(), contentAlpha110.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                    interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography110.getOverline(), contentAlpha110.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                    interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography110.getCaption(), contentAlpha110.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                    modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                    if (interfaceC0526FpApplyTextStyle2 == null) {
                        interfaceC0526Fp10 = interfaceC0526Fp8;
                        if (interfaceC0526FpApplyTextStyle3 == null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp8;
                        if (interfaceC0526FpApplyTextStyle3 == null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp13;
                    z4 = z3;
                    interfaceC0526Fp12 = interfaceC0526Fp10;
                    modifier3 = modifier2;
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp7;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i10 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                    }
                    Typography typography111 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    TextStyle subtitle111 = typography111.getSubtitle1();
                    ContentAlpha contentAlpha111 = ContentAlpha.INSTANCE;
                    interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle111, contentAlpha111.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                    AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                    interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography111.getBody2(), contentAlpha111.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                    interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography111.getOverline(), contentAlpha111.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                    interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography111.getCaption(), contentAlpha111.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                    modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                    if (interfaceC0526FpApplyTextStyle2 == null) {
                        interfaceC0526Fp10 = interfaceC0526Fp8;
                        if (interfaceC0526FpApplyTextStyle3 == null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp8;
                        if (interfaceC0526FpApplyTextStyle3 == null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp13;
                    z4 = z3;
                    interfaceC0526Fp12 = interfaceC0526Fp10;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14251(modifier3, interfaceC0526Fp6, interfaceC0526Fp9, z4, interfaceC0526Fp12, interfaceC0526Fp11, interfaceC0526Fp5, i, i2));
            }
            i3 |= 24576;
            interfaceC0526Fp8 = interfaceC0526Fp3;
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            if ((i2 & 64) != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
                i3 |= i12;
            }
            if ((i3 & 2995931) == 599186) {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i14 != 0) {
                    interfaceC0526Fp6 = null;
                }
                if (i4 != 0) {
                    interfaceC0526Fp9 = null;
                } else {
                    interfaceC0526Fp9 = interfaceC0526Fp7;
                }
                if (i6 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i8 != 0) {
                    interfaceC0526Fp8 = null;
                }
                if (i10 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                }
                Typography typography112 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                TextStyle subtitle112 = typography112.getSubtitle1();
                ContentAlpha contentAlpha112 = ContentAlpha.INSTANCE;
                interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle112, contentAlpha112.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography112.getBody2(), contentAlpha112.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography112.getOverline(), contentAlpha112.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography112.getCaption(), contentAlpha112.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                if (interfaceC0526FpApplyTextStyle2 == null) {
                    interfaceC0526Fp10 = interfaceC0526Fp8;
                    if (interfaceC0526FpApplyTextStyle3 == null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                } else {
                    interfaceC0526Fp10 = interfaceC0526Fp8;
                    if (interfaceC0526FpApplyTextStyle3 == null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp11 = interfaceC0526Fp13;
                z4 = z3;
                interfaceC0526Fp12 = interfaceC0526Fp10;
                modifier3 = modifier2;
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i14 != 0) {
                    interfaceC0526Fp6 = null;
                }
                if (i4 != 0) {
                    interfaceC0526Fp9 = null;
                } else {
                    interfaceC0526Fp9 = interfaceC0526Fp7;
                }
                if (i6 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i8 != 0) {
                    interfaceC0526Fp8 = null;
                }
                if (i10 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                }
                Typography typography113 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                TextStyle subtitle113 = typography113.getSubtitle1();
                ContentAlpha contentAlpha113 = ContentAlpha.INSTANCE;
                interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle113, contentAlpha113.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography113.getBody2(), contentAlpha113.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography113.getOverline(), contentAlpha113.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography113.getCaption(), contentAlpha113.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                if (interfaceC0526FpApplyTextStyle2 == null) {
                    interfaceC0526Fp10 = interfaceC0526Fp8;
                    if (interfaceC0526FpApplyTextStyle3 == null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                } else {
                    interfaceC0526Fp10 = interfaceC0526Fp8;
                    if (interfaceC0526FpApplyTextStyle3 == null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp11 = interfaceC0526Fp13;
                z4 = z3;
                interfaceC0526Fp12 = interfaceC0526Fp10;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C14251(modifier3, interfaceC0526Fp6, interfaceC0526Fp9, z4, interfaceC0526Fp12, interfaceC0526Fp11, interfaceC0526Fp5, i, i2));
        }
        i3 |= 384;
        interfaceC0526Fp7 = interfaceC0526Fp2;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 7168) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((57344 & i) == 0) {
                    interfaceC0526Fp8 = interfaceC0526Fp3;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp8)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i3 & 2995931) == 599186) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp7;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i10 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                    }
                    Typography typography114 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    TextStyle subtitle114 = typography114.getSubtitle1();
                    ContentAlpha contentAlpha114 = ContentAlpha.INSTANCE;
                    interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle114, contentAlpha114.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                    AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                    interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography114.getBody2(), contentAlpha114.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                    interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography114.getOverline(), contentAlpha114.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                    interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography114.getCaption(), contentAlpha114.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                    modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                    if (interfaceC0526FpApplyTextStyle2 == null) {
                        interfaceC0526Fp10 = interfaceC0526Fp8;
                        if (interfaceC0526FpApplyTextStyle3 == null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp8;
                        if (interfaceC0526FpApplyTextStyle3 == null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp13;
                    z4 = z3;
                    interfaceC0526Fp12 = interfaceC0526Fp10;
                    modifier3 = modifier2;
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp7;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i10 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                    }
                    Typography typography115 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    TextStyle subtitle115 = typography115.getSubtitle1();
                    ContentAlpha contentAlpha115 = ContentAlpha.INSTANCE;
                    interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle115, contentAlpha115.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                    AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                    interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography115.getBody2(), contentAlpha115.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                    interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography115.getOverline(), contentAlpha115.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                    interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography115.getCaption(), contentAlpha115.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                    modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                    if (interfaceC0526FpApplyTextStyle2 == null) {
                        interfaceC0526Fp10 = interfaceC0526Fp8;
                        if (interfaceC0526FpApplyTextStyle3 == null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp8;
                        if (interfaceC0526FpApplyTextStyle3 == null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp13;
                    z4 = z3;
                    interfaceC0526Fp12 = interfaceC0526Fp10;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14251(modifier3, interfaceC0526Fp6, interfaceC0526Fp9, z4, interfaceC0526Fp12, interfaceC0526Fp11, interfaceC0526Fp5, i, i2));
            }
            i3 |= 24576;
            interfaceC0526Fp8 = interfaceC0526Fp3;
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            if ((i2 & 64) != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
                i3 |= i12;
            }
            if ((i3 & 2995931) == 599186) {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i14 != 0) {
                    interfaceC0526Fp6 = null;
                }
                if (i4 != 0) {
                    interfaceC0526Fp9 = null;
                } else {
                    interfaceC0526Fp9 = interfaceC0526Fp7;
                }
                if (i6 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i8 != 0) {
                    interfaceC0526Fp8 = null;
                }
                if (i10 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                }
                Typography typography116 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                TextStyle subtitle116 = typography116.getSubtitle1();
                ContentAlpha contentAlpha116 = ContentAlpha.INSTANCE;
                interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle116, contentAlpha116.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography116.getBody2(), contentAlpha116.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography116.getOverline(), contentAlpha116.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography116.getCaption(), contentAlpha116.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                if (interfaceC0526FpApplyTextStyle2 == null) {
                    interfaceC0526Fp10 = interfaceC0526Fp8;
                    if (interfaceC0526FpApplyTextStyle3 == null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                } else {
                    interfaceC0526Fp10 = interfaceC0526Fp8;
                    if (interfaceC0526FpApplyTextStyle3 == null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp11 = interfaceC0526Fp13;
                z4 = z3;
                interfaceC0526Fp12 = interfaceC0526Fp10;
                modifier3 = modifier2;
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i14 != 0) {
                    interfaceC0526Fp6 = null;
                }
                if (i4 != 0) {
                    interfaceC0526Fp9 = null;
                } else {
                    interfaceC0526Fp9 = interfaceC0526Fp7;
                }
                if (i6 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i8 != 0) {
                    interfaceC0526Fp8 = null;
                }
                if (i10 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                }
                Typography typography117 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                TextStyle subtitle117 = typography117.getSubtitle1();
                ContentAlpha contentAlpha117 = ContentAlpha.INSTANCE;
                interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle117, contentAlpha117.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography117.getBody2(), contentAlpha117.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography117.getOverline(), contentAlpha117.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography117.getCaption(), contentAlpha117.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                if (interfaceC0526FpApplyTextStyle2 == null) {
                    interfaceC0526Fp10 = interfaceC0526Fp8;
                    if (interfaceC0526FpApplyTextStyle3 == null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                } else {
                    interfaceC0526Fp10 = interfaceC0526Fp8;
                    if (interfaceC0526FpApplyTextStyle3 == null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp11 = interfaceC0526Fp13;
                z4 = z3;
                interfaceC0526Fp12 = interfaceC0526Fp10;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C14251(modifier3, interfaceC0526Fp6, interfaceC0526Fp9, z4, interfaceC0526Fp12, interfaceC0526Fp11, interfaceC0526Fp5, i, i2));
        }
        i3 |= 3072;
        z2 = z;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((57344 & i) == 0) {
                interfaceC0526Fp8 = interfaceC0526Fp3;
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp8)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            if ((i2 & 64) != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
                i3 |= i12;
            }
            if ((i3 & 2995931) == 599186) {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i14 != 0) {
                    interfaceC0526Fp6 = null;
                }
                if (i4 != 0) {
                    interfaceC0526Fp9 = null;
                } else {
                    interfaceC0526Fp9 = interfaceC0526Fp7;
                }
                if (i6 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i8 != 0) {
                    interfaceC0526Fp8 = null;
                }
                if (i10 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                }
                Typography typography118 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                TextStyle subtitle118 = typography118.getSubtitle1();
                ContentAlpha contentAlpha118 = ContentAlpha.INSTANCE;
                interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle118, contentAlpha118.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography118.getBody2(), contentAlpha118.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography118.getOverline(), contentAlpha118.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography118.getCaption(), contentAlpha118.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                if (interfaceC0526FpApplyTextStyle2 == null) {
                    interfaceC0526Fp10 = interfaceC0526Fp8;
                    if (interfaceC0526FpApplyTextStyle3 == null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                } else {
                    interfaceC0526Fp10 = interfaceC0526Fp8;
                    if (interfaceC0526FpApplyTextStyle3 == null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp11 = interfaceC0526Fp13;
                z4 = z3;
                interfaceC0526Fp12 = interfaceC0526Fp10;
                modifier3 = modifier2;
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i14 != 0) {
                    interfaceC0526Fp6 = null;
                }
                if (i4 != 0) {
                    interfaceC0526Fp9 = null;
                } else {
                    interfaceC0526Fp9 = interfaceC0526Fp7;
                }
                if (i6 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i8 != 0) {
                    interfaceC0526Fp8 = null;
                }
                if (i10 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                }
                Typography typography119 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                TextStyle subtitle119 = typography119.getSubtitle1();
                ContentAlpha contentAlpha119 = ContentAlpha.INSTANCE;
                interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle119, contentAlpha119.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
                AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
                interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography119.getBody2(), contentAlpha119.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
                interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography119.getOverline(), contentAlpha119.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
                interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography119.getCaption(), contentAlpha119.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
                modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
                if (interfaceC0526FpApplyTextStyle2 == null) {
                    interfaceC0526Fp10 = interfaceC0526Fp8;
                    if (interfaceC0526FpApplyTextStyle3 == null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                } else {
                    interfaceC0526Fp10 = interfaceC0526Fp8;
                    if (interfaceC0526FpApplyTextStyle3 == null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp11 = interfaceC0526Fp13;
                z4 = z3;
                interfaceC0526Fp12 = interfaceC0526Fp10;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C14251(modifier3, interfaceC0526Fp6, interfaceC0526Fp9, z4, interfaceC0526Fp12, interfaceC0526Fp11, interfaceC0526Fp5, i, i2));
        }
        i3 |= 24576;
        interfaceC0526Fp8 = interfaceC0526Fp3;
        i10 = i2 & 32;
        if (i10 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & 458752) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                i11 = 131072;
            } else {
                i11 = 65536;
            }
            i3 |= i11;
        }
        if ((i2 & 64) != 0) {
            i3 |= 1572864;
        } else if ((i & 3670016) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                i12 = 1048576;
            } else {
                i12 = 524288;
            }
            i3 |= i12;
        }
        if ((i3 & 2995931) == 599186) {
            if (i13 != 0) {
                modifier2 = Modifier.Companion;
            } else {
                modifier2 = modifier;
            }
            if (i14 != 0) {
                interfaceC0526Fp6 = null;
            }
            if (i4 != 0) {
                interfaceC0526Fp9 = null;
            } else {
                interfaceC0526Fp9 = interfaceC0526Fp7;
            }
            if (i6 != 0) {
                z3 = true;
            } else {
                z3 = z2;
            }
            if (i8 != 0) {
                interfaceC0526Fp8 = null;
            }
            if (i10 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
            }
            Typography typography1110 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
            TextStyle subtitle1110 = typography1110.getSubtitle1();
            ContentAlpha contentAlpha1110 = ContentAlpha.INSTANCE;
            interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle1110, contentAlpha1110.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
            AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
            interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography1110.getBody2(), contentAlpha1110.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
            interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography1110.getOverline(), contentAlpha1110.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
            interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography1110.getCaption(), contentAlpha1110.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
            modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
            if (interfaceC0526FpApplyTextStyle2 == null) {
                interfaceC0526Fp10 = interfaceC0526Fp8;
                if (interfaceC0526FpApplyTextStyle3 == null) {
                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                    ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                    ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                }
            } else {
                interfaceC0526Fp10 = interfaceC0526Fp8;
                if (interfaceC0526FpApplyTextStyle3 == null) {
                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                    ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                    ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC0526Fp11 = interfaceC0526Fp13;
            z4 = z3;
            interfaceC0526Fp12 = interfaceC0526Fp10;
            modifier3 = modifier2;
        } else {
            if (i13 != 0) {
                modifier2 = Modifier.Companion;
            } else {
                modifier2 = modifier;
            }
            if (i14 != 0) {
                interfaceC0526Fp6 = null;
            }
            if (i4 != 0) {
                interfaceC0526Fp9 = null;
            } else {
                interfaceC0526Fp9 = interfaceC0526Fp7;
            }
            if (i6 != 0) {
                z3 = true;
            } else {
                z3 = z2;
            }
            if (i8 != 0) {
                interfaceC0526Fp8 = null;
            }
            if (i10 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
            }
            Typography typography1111 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
            TextStyle subtitle1111 = typography1111.getSubtitle1();
            ContentAlpha contentAlpha1111 = ContentAlpha.INSTANCE;
            interfaceC0526FpApplyTextStyle = applyTextStyle(subtitle1111, contentAlpha1111.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp5);
            AbstractC4492zt.e(interfaceC0526FpApplyTextStyle);
            interfaceC0526FpApplyTextStyle2 = applyTextStyle(typography1111.getBody2(), contentAlpha1111.getMedium(composerStartRestartGroup, 6), interfaceC0526Fp9);
            interfaceC0526FpApplyTextStyle3 = applyTextStyle(typography1111.getOverline(), contentAlpha1111.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp8);
            interfaceC0526FpApplyTextStyle4 = applyTextStyle(typography1111.getCaption(), contentAlpha1111.getHigh(composerStartRestartGroup, 6), interfaceC0526Fp13);
            modifierSemantics = SemanticsModifierKt.semantics(modifier2, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
            if (interfaceC0526FpApplyTextStyle2 == null) {
                interfaceC0526Fp10 = interfaceC0526Fp8;
                if (interfaceC0526FpApplyTextStyle3 == null) {
                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                    ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                    ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                }
            } else {
                interfaceC0526Fp10 = interfaceC0526Fp8;
                if (interfaceC0526FpApplyTextStyle3 == null) {
                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                    ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                    ThreeLine.INSTANCE.ListItem(modifierSemantics, interfaceC0526Fp6, interfaceC0526FpApplyTextStyle, interfaceC0526FpApplyTextStyle2, interfaceC0526FpApplyTextStyle3, interfaceC0526FpApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC0526Fp11 = interfaceC0526Fp13;
            z4 = z3;
            interfaceC0526Fp12 = interfaceC0526Fp10;
            modifier3 = modifier2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C14251(modifier3, interfaceC0526Fp6, interfaceC0526Fp9, z4, interfaceC0526Fp12, interfaceC0526Fp11, interfaceC0526Fp5, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: OffsetToBaselineOrCenter-Kz89ssw, reason: not valid java name */
    public static final void m1142OffsetToBaselineOrCenterKz89ssw(final float f, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1062692685);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 256 : 128;
        }
        if ((i3 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1062692685, i3, -1, "androidx.compose.material.OffsetToBaselineOrCenter (ListItem.kt:389)");
            }
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material.ListItemKt$OffsetToBaselineOrCenter$1
                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i5) {
                    return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i5);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i5) {
                    return AbstractC2260gB.b(this, intrinsicMeasureScope, list, i5);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                    int iMax;
                    int iM5279getYimpl;
                    AbstractC4492zt.h(measureScope, "$this$Layout");
                    AbstractC4492zt.h(list, "measurables");
                    Placeable placeableMo4159measureBRTryo0 = list.get(0).mo4159measureBRTryo0(Constraints.m5119copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                    int i5 = placeableMo4159measureBRTryo0.get(AlignmentLineKt.getFirstBaseline());
                    if (i5 != Integer.MIN_VALUE) {
                        iM5279getYimpl = measureScope.mo327roundToPx0680j_4(f) - i5;
                        iMax = Math.max(Constraints.m5129getMinHeightimpl(j), placeableMo4159measureBRTryo0.getHeight() + iM5279getYimpl);
                    } else {
                        iMax = Math.max(Constraints.m5129getMinHeightimpl(j), placeableMo4159measureBRTryo0.getHeight());
                        iM5279getYimpl = IntOffset.m5279getYimpl(Alignment.Companion.getCenter().mo2684alignKFBX0sM(IntSize.Companion.m5325getZeroYbymL2g(), IntSizeKt.IntSize(0, iMax - placeableMo4159measureBRTryo0.getHeight()), measureScope.getLayoutDirection()));
                    }
                    return MeasureScope.CC.q(measureScope, placeableMo4159measureBRTryo0.getWidth(), iMax, null, new ListItemKt$OffsetToBaselineOrCenter$1$measure$1(placeableMo4159measureBRTryo0, iM5279getYimpl), 4, null);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i5) {
                    return AbstractC2260gB.c(this, intrinsicMeasureScope, list, i5);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i5) {
                    return AbstractC2260gB.d(this, intrinsicMeasureScope, list, i5);
                }
            };
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
            int i5 = ((((i3 & 112) | ((i3 >> 6) & 14)) << 9) & 7168) | 6;
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
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicy, companion.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            InterfaceC0526Fp setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i5 >> 9) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new ListItemKt$OffsetToBaselineOrCenter$2(f, modifier2, interfaceC0526Fp, i, i2));
    }

    private static final InterfaceC0526Fp applyTextStyle(TextStyle textStyle, float f, InterfaceC0526Fp interfaceC0526Fp) {
        if (interfaceC0526Fp == null) {
            return null;
        }
        return ComposableLambdaKt.composableLambdaInstance(-830176860, true, new C14261(f, textStyle, interfaceC0526Fp));
    }
}
