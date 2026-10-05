package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
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
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2260gB;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.HV;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class BadgeKt {
    private static final float BadgeHorizontalOffset;
    private static final float BadgeRadius;
    private static final float BadgeWithContentHorizontalPadding;
    private static final float BadgeWithContentRadius = Dp.m5160constructorimpl(8);
    private static final long BadgeContentFontSize = TextUnitKt.getSp(10);
    private static final float BadgeWithContentHorizontalOffset = Dp.m5160constructorimpl(-Dp.m5160constructorimpl(6));

    /* JADX INFO: renamed from: androidx.compose.material.BadgeKt$BadgedBox$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC0552Gp $badge;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ Modifier $modifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(InterfaceC0552Gp interfaceC0552Gp, Modifier modifier, InterfaceC0552Gp interfaceC0552Gp2, int i, int i2) {
            super(2);
            this.$badge = interfaceC0552Gp;
            this.$modifier = modifier;
            this.$content = interfaceC0552Gp2;
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
            BadgeKt.BadgedBox(this.$badge, this.$modifier, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    static {
        float f = 4;
        BadgeRadius = Dp.m5160constructorimpl(f);
        BadgeWithContentHorizontalPadding = Dp.m5160constructorimpl(f);
        BadgeHorizontalOffset = Dp.m5160constructorimpl(-Dp.m5160constructorimpl(f));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0200  */
    /* JADX WARN: Code duplicated, block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:55:0x009c  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:73:0x00db  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:82:0x0150  */
    /* JADX WARN: Code duplicated, block: B:85:0x015c  */
    /* JADX WARN: Code duplicated, block: B:86:0x0160  */
    /* JADX WARN: Code duplicated, block: B:89:0x017f  */
    /* JADX WARN: Code duplicated, block: B:91:0x018d  */
    /* JADX WARN: Code duplicated, block: B:94:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:97:0x01f4  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Badge-eopBjH0, reason: not valid java name */
    public static final void m994BadgeeopBjH0(Modifier modifier, long j, long j2, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        Modifier modifier2;
        int i3;
        long jM1045getError0d7_KjU;
        long jM1069contentColorForek8zF_U;
        InterfaceC0552Gp interfaceC0552Gp2;
        float f;
        int currentCompositeKeyHash;
        InterfaceC3588op constructor;
        Composer composerM2661constructorimpl;
        InterfaceC0526Fp setCompositeKeyHash;
        RowScopeInstance rowScopeInstance;
        InterfaceC0552Gp interfaceC0552Gp3;
        Modifier modifier3;
        long j3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1133484502);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                jM1045getError0d7_KjU = j;
                int i5 = composerStartRestartGroup.changed(jM1045getError0d7_KjU) ? 32 : 16;
                i3 |= i5;
            } else {
                jM1045getError0d7_KjU = j;
            }
            i3 |= i5;
        } else {
            jM1045getError0d7_KjU = j;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                jM1069contentColorForek8zF_U = j2;
                int i6 = composerStartRestartGroup.changed(jM1069contentColorForek8zF_U) ? 256 : 128;
                i3 |= i6;
            } else {
                jM1069contentColorForek8zF_U = j2;
            }
            i3 |= i6;
        } else {
            jM1069contentColorForek8zF_U = j2;
        }
        int i7 = i2 & 8;
        if (i7 == 0) {
            if ((i & 7168) == 0) {
                interfaceC0552Gp2 = interfaceC0552Gp;
                i3 |= composerStartRestartGroup.changedInstance(interfaceC0552Gp2) ? 2048 : 1024;
            }
            if ((i3 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i4 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 2) != 0) {
                        jM1045getError0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1045getError0d7_KjU();
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1045getError0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i7 != 0) {
                        interfaceC0552Gp2 = null;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1133484502, i3, -1, "androidx.compose.material.Badge (Badge.kt:129)");
                }
                if (interfaceC0552Gp2 != null) {
                    f = BadgeWithContentRadius;
                } else {
                    f = BadgeRadius;
                }
                RoundedCornerShape roundedCornerShapeM737RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m737RoundedCornerShape0680j_4(f);
                float f2 = f * 2;
                Modifier modifierM487paddingVpY3zN4$default = PaddingKt.m487paddingVpY3zN4$default(ClipKt.clip(BackgroundKt.m166backgroundbw27NRU(SizeKt.m516defaultMinSizeVpY3zN4(modifier2, Dp.m5160constructorimpl(f2), Dp.m5160constructorimpl(f2)), jM1045getError0d7_KjU, roundedCornerShapeM737RoundedCornerShape0680j_4), roundedCornerShapeM737RoundedCornerShape0680j_4), BadgeWithContentHorizontalPadding, 0.0f, 2, null);
                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composerStartRestartGroup, 54);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                constructor = companion.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierM487paddingVpY3zN4$default);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                rowScopeInstance = RowScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(521574215);
                if (interfaceC0552Gp2 != null) {
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(jM1069contentColorForek8zF_U))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1784526485, true, new BadgeKt$Badge$1$1(interfaceC0552Gp2, rowScopeInstance, 6, i3)), composerStartRestartGroup, 56);
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
            }
            interfaceC0552Gp3 = interfaceC0552Gp2;
            modifier3 = modifier2;
            j3 = jM1045getError0d7_KjU;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new BadgeKt$Badge$2(modifier3, j3, jM1069contentColorForek8zF_U, interfaceC0552Gp3, i, i2));
        }
        i3 |= 3072;
        interfaceC0552Gp2 = interfaceC0552Gp;
        if ((i3 & 5851) == 1170) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i4 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i2 & 2) != 0) {
                    jM1045getError0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1045getError0d7_KjU();
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1045getError0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i7 != 0) {
                    interfaceC0552Gp2 = null;
                }
            } else {
                if (i4 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i2 & 2) != 0) {
                    jM1045getError0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1045getError0d7_KjU();
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1045getError0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i7 != 0) {
                    interfaceC0552Gp2 = null;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1133484502, i3, -1, "androidx.compose.material.Badge (Badge.kt:129)");
            }
            if (interfaceC0552Gp2 != null) {
                f = BadgeWithContentRadius;
            } else {
                f = BadgeRadius;
            }
            RoundedCornerShape roundedCornerShapeM737RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m737RoundedCornerShape0680j_4(f);
            float f3 = f * 2;
            Modifier modifierM487paddingVpY3zN4$default2 = PaddingKt.m487paddingVpY3zN4$default(ClipKt.clip(BackgroundKt.m166backgroundbw27NRU(SizeKt.m516defaultMinSizeVpY3zN4(modifier2, Dp.m5160constructorimpl(f3), Dp.m5160constructorimpl(f3)), jM1045getError0d7_KjU, roundedCornerShapeM737RoundedCornerShape0680j_5), roundedCornerShapeM737RoundedCornerShape0680j_5), BadgeWithContentHorizontalPadding, 0.0f, 2, null);
            Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
            Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
            composerStartRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(center2, centerVertically2, composerStartRestartGroup, 54);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            constructor = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifierM487paddingVpY3zN4$default2);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting()) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            rowScopeInstance = RowScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(521574215);
            if (interfaceC0552Gp2 != null) {
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(jM1069contentColorForek8zF_U))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1784526485, true, new BadgeKt$Badge$1$1(interfaceC0552Gp2, rowScopeInstance, 6, i3)), composerStartRestartGroup, 56);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i4 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i2 & 2) != 0) {
                    jM1045getError0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1045getError0d7_KjU();
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1045getError0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i7 != 0) {
                    interfaceC0552Gp2 = null;
                }
            } else {
                if (i4 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i2 & 2) != 0) {
                    jM1045getError0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1045getError0d7_KjU();
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1045getError0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i7 != 0) {
                    interfaceC0552Gp2 = null;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1133484502, i3, -1, "androidx.compose.material.Badge (Badge.kt:129)");
            }
            if (interfaceC0552Gp2 != null) {
                f = BadgeWithContentRadius;
            } else {
                f = BadgeRadius;
            }
            RoundedCornerShape roundedCornerShapeM737RoundedCornerShape0680j_6 = RoundedCornerShapeKt.m737RoundedCornerShape0680j_4(f);
            float f4 = f * 2;
            Modifier modifierM487paddingVpY3zN4$default3 = PaddingKt.m487paddingVpY3zN4$default(ClipKt.clip(BackgroundKt.m166backgroundbw27NRU(SizeKt.m516defaultMinSizeVpY3zN4(modifier2, Dp.m5160constructorimpl(f4), Dp.m5160constructorimpl(f4)), jM1045getError0d7_KjU, roundedCornerShapeM737RoundedCornerShape0680j_6), roundedCornerShapeM737RoundedCornerShape0680j_6), BadgeWithContentHorizontalPadding, 0.0f, 2, null);
            Alignment.Vertical centerVertically3 = Alignment.Companion.getCenterVertically();
            Arrangement.HorizontalOrVertical center3 = Arrangement.INSTANCE.getCenter();
            composerStartRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(center3, centerVertically3, composerStartRestartGroup, 54);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            constructor = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifierM487paddingVpY3zN4$default3);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy3, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting()) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            rowScopeInstance = RowScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(521574215);
            if (interfaceC0552Gp2 != null) {
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(jM1069contentColorForek8zF_U))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1784526485, true, new BadgeKt$Badge$1$1(interfaceC0552Gp2, rowScopeInstance, 6, i3)), composerStartRestartGroup, 56);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        interfaceC0552Gp3 = interfaceC0552Gp2;
        modifier3 = modifier2;
        j3 = jM1045getError0d7_KjU;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new BadgeKt$Badge$2(modifier3, j3, jM1069contentColorForek8zF_U, interfaceC0552Gp3, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0052  */
    /* JADX WARN: Code duplicated, block: B:29:0x0056  */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:32:0x005f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0075 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x0077  */
    /* JADX WARN: Code duplicated, block: B:42:0x007a  */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:55:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:60:0x0144  */
    /* JADX WARN: Code duplicated, block: B:63:0x0150  */
    /* JADX WARN: Code duplicated, block: B:64:0x0154  */
    /* JADX WARN: Code duplicated, block: B:67:0x0173  */
    /* JADX WARN: Code duplicated, block: B:69:0x0181  */
    /* JADX WARN: Code duplicated, block: B:72:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:75:0x0202  */
    /* JADX WARN: Code duplicated, block: B:76:0x0206  */
    /* JADX WARN: Code duplicated, block: B:79:0x0225  */
    /* JADX WARN: Code duplicated, block: B:81:0x0233  */
    /* JADX WARN: Code duplicated, block: B:84:0x027e  */
    /* JADX WARN: Code duplicated, block: B:89:0x0289  */
    /* JADX WARN: Code duplicated, block: B:91:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void BadgedBox(InterfaceC0552Gp interfaceC0552Gp, Modifier modifier, InterfaceC0552Gp interfaceC0552Gp2, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Modifier modifier3;
        int currentCompositeKeyHash;
        InterfaceC3588op constructor;
        Composer composerM2661constructorimpl;
        InterfaceC0526Fp setCompositeKeyHash;
        int currentCompositeKeyHash2;
        InterfaceC3588op constructor2;
        Composer composerM2661constructorimpl2;
        InterfaceC0526Fp setCompositeKeyHash2;
        int currentCompositeKeyHash3;
        InterfaceC3588op constructor3;
        Composer composerM2661constructorimpl3;
        InterfaceC0526Fp setCompositeKeyHash3;
        Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0552Gp, "badge");
        AbstractC4492zt.h(interfaceC0552Gp2, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(859805272);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC0552Gp) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 4) != 0) {
                i3 |= 384;
            } else if ((i & 896) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                    i4 = 256;
                } else {
                    i4 = 128;
                }
                i3 |= i4;
            }
            if ((i3 & 731) == 146 || !composerStartRestartGroup.getSkipping()) {
                if (i5 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(859805272, i3, -1, "androidx.compose.material.BadgedBox (Badge.kt:58)");
                }
                AnonymousClass2 anonymousClass2 = new MeasurePolicy() { // from class: androidx.compose.material.BadgeKt.BadgedBox.2
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i6) {
                        return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i6);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i6) {
                        return AbstractC2260gB.b(this, intrinsicMeasureScope, list, i6);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        AbstractC4492zt.h(measureScope, "$this$Layout");
                        AbstractC4492zt.h(list, "measurables");
                        List<? extends Measurable> list2 = list;
                        for (Measurable measurable : list2) {
                            if (AbstractC4492zt.d(LayoutIdKt.getLayoutId(measurable), "badge")) {
                                Placeable placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(Constraints.m5119copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                                for (Measurable measurable2 : list2) {
                                    if (AbstractC4492zt.d(LayoutIdKt.getLayoutId(measurable2), "anchor")) {
                                        Placeable placeableMo4159measureBRTryo1 = measurable2.mo4159measureBRTryo0(j);
                                        return measureScope.layout(placeableMo4159measureBRTryo1.getWidth(), placeableMo4159measureBRTryo1.getHeight(), AbstractC4243wx.j(HV.a(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(placeableMo4159measureBRTryo1.get(AlignmentLineKt.getFirstBaseline()))), HV.a(AlignmentLineKt.getLastBaseline(), Integer.valueOf(placeableMo4159measureBRTryo1.get(AlignmentLineKt.getLastBaseline())))), new BadgeKt$BadgedBox$2$measure$1(placeableMo4159measureBRTryo0, measureScope, placeableMo4159measureBRTryo1));
                                    }
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i6) {
                        return AbstractC2260gB.c(this, intrinsicMeasureScope, list, i6);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i6) {
                        return AbstractC2260gB.d(this, intrinsicMeasureScope, list, i6);
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                constructor = companion.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier3);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl, anonymousClass2, companion.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                Modifier.Companion companion2 = Modifier.Companion;
                Modifier modifierLayoutId = LayoutIdKt.layoutId(companion2, "anchor");
                Alignment.Companion companion3 = Alignment.Companion;
                Alignment center = companion3.getCenter();
                int i6 = ((i3 << 3) & 7168) | 54;
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                constructor2 = companion.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifierLayoutId);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl2, currentCompositionLocalMap2, companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = companion.getSetCompositeKeyHash();
                if (composerM2661constructorimpl2.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                interfaceC0552GpModifierMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                interfaceC0552Gp2.invoke(boxScopeInstance, composerStartRestartGroup, Integer.valueOf(((i6 >> 6) & 112) | 6));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierLayoutId2 = LayoutIdKt.layoutId(companion2, "badge");
                int i7 = ((i3 << 9) & 7168) | 6;
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                constructor3 = companion.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifierLayoutId2);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM2661constructorimpl3 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyRememberBoxMeasurePolicy2, companion.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl3, currentCompositionLocalMap3, companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = companion.getSetCompositeKeyHash();
                if (composerM2661constructorimpl3.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    composerM2661constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM2661constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                interfaceC0552GpModifierMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                interfaceC0552Gp.invoke(boxScopeInstance, composerStartRestartGroup, Integer.valueOf(6 | ((i7 >> 6) & 112)));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier4 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC0552Gp, modifier4, interfaceC0552Gp2, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i3 |= i4;
        }
        if ((i3 & 731) == 146) {
            if (i5 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(859805272, i3, -1, "androidx.compose.material.BadgedBox (Badge.kt:58)");
            }
            AnonymousClass2 anonymousClass3 = new MeasurePolicy() { // from class: androidx.compose.material.BadgeKt.BadgedBox.2
                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i8) {
                    return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i8);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i8) {
                    return AbstractC2260gB.b(this, intrinsicMeasureScope, list, i8);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                    AbstractC4492zt.h(measureScope, "$this$Layout");
                    AbstractC4492zt.h(list, "measurables");
                    List<? extends Measurable> list2 = list;
                    for (Measurable measurable : list2) {
                        if (AbstractC4492zt.d(LayoutIdKt.getLayoutId(measurable), "badge")) {
                            Placeable placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(Constraints.m5119copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                            for (Measurable measurable2 : list2) {
                                if (AbstractC4492zt.d(LayoutIdKt.getLayoutId(measurable2), "anchor")) {
                                    Placeable placeableMo4159measureBRTryo1 = measurable2.mo4159measureBRTryo0(j);
                                    return measureScope.layout(placeableMo4159measureBRTryo1.getWidth(), placeableMo4159measureBRTryo1.getHeight(), AbstractC4243wx.j(HV.a(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(placeableMo4159measureBRTryo1.get(AlignmentLineKt.getFirstBaseline()))), HV.a(AlignmentLineKt.getLastBaseline(), Integer.valueOf(placeableMo4159measureBRTryo1.get(AlignmentLineKt.getLastBaseline())))), new BadgeKt$BadgedBox$2$measure$1(placeableMo4159measureBRTryo0, measureScope, placeableMo4159measureBRTryo1));
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i8) {
                    return AbstractC2260gB.c(this, intrinsicMeasureScope, list, i8);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i8) {
                    return AbstractC2260gB.d(this, intrinsicMeasureScope, list, i8);
                }
            };
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion4 = ComposeUiNode.Companion;
            constructor = companion4.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(modifier3);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl, anonymousClass3, companion4.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap4, companion4.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion4.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting()) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf4.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            Modifier.Companion companion5 = Modifier.Companion;
            Modifier modifierLayoutId3 = LayoutIdKt.layoutId(companion5, "anchor");
            Alignment.Companion companion6 = Alignment.Companion;
            Alignment center2 = companion6.getCenter();
            int i8 = ((i3 << 3) & 7168) | 54;
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(center2, false, composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            constructor2 = companion4.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(modifierLayoutId3);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy3, companion4.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl2, currentCompositionLocalMap5, companion4.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
            if (composerM2661constructorimpl2.getInserting()) {
                composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            interfaceC0552GpModifierMaterializerOf5.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            interfaceC0552Gp2.invoke(boxScopeInstance2, composerStartRestartGroup, Integer.valueOf(((i8 >> 6) & 112) | 6));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierLayoutId4 = LayoutIdKt.layoutId(companion5, "badge");
            int i9 = ((i3 << 9) & 7168) | 6;
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(companion6.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            constructor3 = companion4.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf6 = LayoutKt.modifierMaterializerOf(modifierLayoutId4);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM2661constructorimpl3 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyRememberBoxMeasurePolicy4, companion4.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl3, currentCompositionLocalMap6, companion4.getSetResolvedCompositionLocals());
            setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
            if (composerM2661constructorimpl3.getInserting()) {
                composerM2661constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM2661constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            } else {
                composerM2661constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM2661constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            interfaceC0552GpModifierMaterializerOf6.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            interfaceC0552Gp.invoke(boxScopeInstance2, composerStartRestartGroup, Integer.valueOf(6 | ((i9 >> 6) & 112)));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
        } else {
            if (i5 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(859805272, i3, -1, "androidx.compose.material.BadgedBox (Badge.kt:58)");
            }
            AnonymousClass2 anonymousClass4 = new MeasurePolicy() { // from class: androidx.compose.material.BadgeKt.BadgedBox.2
                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
                    return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i10);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
                    return AbstractC2260gB.b(this, intrinsicMeasureScope, list, i10);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                    AbstractC4492zt.h(measureScope, "$this$Layout");
                    AbstractC4492zt.h(list, "measurables");
                    List<? extends Measurable> list2 = list;
                    for (Measurable measurable : list2) {
                        if (AbstractC4492zt.d(LayoutIdKt.getLayoutId(measurable), "badge")) {
                            Placeable placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(Constraints.m5119copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                            for (Measurable measurable2 : list2) {
                                if (AbstractC4492zt.d(LayoutIdKt.getLayoutId(measurable2), "anchor")) {
                                    Placeable placeableMo4159measureBRTryo1 = measurable2.mo4159measureBRTryo0(j);
                                    return measureScope.layout(placeableMo4159measureBRTryo1.getWidth(), placeableMo4159measureBRTryo1.getHeight(), AbstractC4243wx.j(HV.a(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(placeableMo4159measureBRTryo1.get(AlignmentLineKt.getFirstBaseline()))), HV.a(AlignmentLineKt.getLastBaseline(), Integer.valueOf(placeableMo4159measureBRTryo1.get(AlignmentLineKt.getLastBaseline())))), new BadgeKt$BadgedBox$2$measure$1(placeableMo4159measureBRTryo0, measureScope, placeableMo4159measureBRTryo1));
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
                    return AbstractC2260gB.c(this, intrinsicMeasureScope, list, i10);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
                    return AbstractC2260gB.d(this, intrinsicMeasureScope, list, i10);
                }
            };
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion7 = ComposeUiNode.Companion;
            constructor = companion7.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf7 = LayoutKt.modifierMaterializerOf(modifier3);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl, anonymousClass4, companion7.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap7, companion7.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion7.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting()) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf7.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            Modifier.Companion companion8 = Modifier.Companion;
            Modifier modifierLayoutId5 = LayoutIdKt.layoutId(companion8, "anchor");
            Alignment.Companion companion9 = Alignment.Companion;
            Alignment center3 = companion9.getCenter();
            int i10 = ((i3 << 3) & 7168) | 54;
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy5 = BoxKt.rememberBoxMeasurePolicy(center3, false, composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            constructor2 = companion7.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf8 = LayoutKt.modifierMaterializerOf(modifierLayoutId5);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy5, companion7.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl2, currentCompositionLocalMap8, companion7.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = companion7.getSetCompositeKeyHash();
            if (composerM2661constructorimpl2.getInserting()) {
                composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            interfaceC0552GpModifierMaterializerOf8.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            interfaceC0552Gp2.invoke(boxScopeInstance3, composerStartRestartGroup, Integer.valueOf(((i10 >> 6) & 112) | 6));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierLayoutId6 = LayoutIdKt.layoutId(companion8, "badge");
            int i11 = ((i3 << 9) & 7168) | 6;
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy6 = BoxKt.rememberBoxMeasurePolicy(companion9.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            constructor3 = companion7.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf9 = LayoutKt.modifierMaterializerOf(modifierLayoutId6);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM2661constructorimpl3 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyRememberBoxMeasurePolicy6, companion7.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl3, currentCompositionLocalMap9, companion7.getSetResolvedCompositionLocals());
            setCompositeKeyHash3 = companion7.getSetCompositeKeyHash();
            if (composerM2661constructorimpl3.getInserting()) {
                composerM2661constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM2661constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            } else {
                composerM2661constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM2661constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            interfaceC0552GpModifierMaterializerOf9.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            interfaceC0552Gp.invoke(boxScopeInstance3, composerStartRestartGroup, Integer.valueOf(6 | ((i11 >> 6) & 112)));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC0552Gp, modifier4, interfaceC0552Gp2, i, i2));
    }

    public static final float getBadgeHorizontalOffset() {
        return BadgeHorizontalOffset;
    }

    public static final float getBadgeRadius() {
        return BadgeRadius;
    }

    public static final float getBadgeWithContentHorizontalOffset() {
        return BadgeWithContentHorizontalOffset;
    }

    public static final float getBadgeWithContentHorizontalPadding() {
        return BadgeWithContentHorizontalPadding;
    }

    public static final float getBadgeWithContentRadius() {
        return BadgeWithContentRadius;
    }
}
