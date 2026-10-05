package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.UiComposable;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class BackdropScaffoldKt {
    private static final float AnimationSlideOffset = Dp.m5160constructorimpl(20);

    /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$BackLayerTransition$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ InterfaceC0526Fp $appBar;
        final /* synthetic */ InterfaceC0526Fp $content;
        final /* synthetic */ BackdropValue $target;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(BackdropValue backdropValue, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, int i) {
            super(2);
            this.$target = backdropValue;
            this.$appBar = interfaceC0526Fp;
            this.$content = interfaceC0526Fp2;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            BackdropScaffoldKt.BackLayerTransition(this.$target, this.$appBar, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropStack$2, reason: invalid class name and case insensitive filesystem */
    public static final class C14102 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ InterfaceC0526Fp $backLayer;
        final /* synthetic */ InterfaceC3750qp $calculateBackLayerConstraints;
        final /* synthetic */ InterfaceC0578Hp $frontLayer;
        final /* synthetic */ Modifier $modifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14102(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, InterfaceC3750qp interfaceC3750qp, InterfaceC0578Hp interfaceC0578Hp, int i) {
            super(2);
            this.$modifier = modifier;
            this.$backLayer = interfaceC0526Fp;
            this.$calculateBackLayerConstraints = interfaceC3750qp;
            this.$frontLayer = interfaceC0578Hp;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            BackdropScaffoldKt.BackdropStack(this.$modifier, this.$backLayer, this.$calculateBackLayerConstraints, this.$frontLayer, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$rememberBackdropScaffoldState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(BackdropValue backdropValue) {
            AbstractC4492zt.h(backdropValue, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$rememberBackdropScaffoldState$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ InterfaceC3750qp $confirmStateChange;
        final /* synthetic */ BackdropValue $initialValue;
        final /* synthetic */ SnackbarHostState $snackbarHostState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(BackdropValue backdropValue, AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp, SnackbarHostState snackbarHostState) {
            super(0);
            this.$initialValue = backdropValue;
            this.$animationSpec = animationSpec;
            this.$confirmStateChange = interfaceC3750qp;
            this.$snackbarHostState = snackbarHostState;
        }

        @Override // defpackage.InterfaceC3588op
        public final BackdropScaffoldState invoke() {
            return new BackdropScaffoldState(this.$initialValue, this.$animationSpec, this.$confirmStateChange, this.$snackbarHostState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void BackLayerTransition(BackdropValue backdropValue, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-950970976);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(backdropValue) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp2) ? 256 : 128;
        }
        int i3 = i2;
        if ((i3 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-950970976, i3, -1, "androidx.compose.material.BackLayerTransition (BackdropScaffold.kt:414)");
            }
            State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(backdropValue == BackdropValue.Revealed ? 0.0f : 2.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, composerStartRestartGroup, 48, 28);
            float fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(AnimationSlideOffset);
            float f = 1;
            float fK = AbstractC3871sJ.k(BackLayerTransition$lambda$7(stateAnimateFloatAsState) - f, 0.0f, 1.0f);
            float fK2 = AbstractC3871sJ.k(f - BackLayerTransition$lambda$7(stateAnimateFloatAsState), 0.0f, 1.0f);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            Modifier.Companion companion = Modifier.Companion;
            Alignment.Companion companion2 = Alignment.Companion;
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion3.getConstructor();
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
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            InterfaceC0526Fp setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierM3188graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m3188graphicsLayerAp8cVGQ$default(ZIndexModifierKt.zIndex(companion, fK), 0.0f, 0.0f, fK, 0.0f, (f - fK) * fMo333toPx0680j_4, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131051, null);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            InterfaceC3588op constructor2 = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifierM3188graphicsLayerAp8cVGQ$default);
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
            Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            InterfaceC0526Fp setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (composerM2661constructorimpl2.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            interfaceC0552GpModifierMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierM3188graphicsLayerAp8cVGQ$default2 = GraphicsLayerModifierKt.m3188graphicsLayerAp8cVGQ$default(ZIndexModifierKt.zIndex(companion, fK2), 0.0f, 0.0f, fK2, 0.0f, (f - fK2) * (-fMo333toPx0680j_4), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131051, null);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            InterfaceC3588op constructor3 = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifierM3188graphicsLayerAp8cVGQ$default2);
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
            Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyRememberBoxMeasurePolicy3, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            InterfaceC0526Fp setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
            if (composerM2661constructorimpl3.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM2661constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM2661constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            interfaceC0552GpModifierMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(backdropValue, interfaceC0526Fp, interfaceC0526Fp2, i));
    }

    private static final float BackLayerTransition$lambda$7(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX WARN: Code duplicated, block: B:101:0x014d  */
    /* JADX WARN: Code duplicated, block: B:103:0x0157  */
    /* JADX WARN: Code duplicated, block: B:104:0x015a  */
    /* JADX WARN: Code duplicated, block: B:107:0x0161  */
    /* JADX WARN: Code duplicated, block: B:110:0x016a  */
    /* JADX WARN: Code duplicated, block: B:112:0x0170  */
    /* JADX WARN: Code duplicated, block: B:115:0x0179  */
    /* JADX WARN: Code duplicated, block: B:117:0x017e  */
    /* JADX WARN: Code duplicated, block: B:120:0x0185  */
    /* JADX WARN: Code duplicated, block: B:122:0x018b  */
    /* JADX WARN: Code duplicated, block: B:125:0x0194  */
    /* JADX WARN: Code duplicated, block: B:127:0x0198  */
    /* JADX WARN: Code duplicated, block: B:130:0x019e  */
    /* JADX WARN: Code duplicated, block: B:132:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:135:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:137:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:140:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:142:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:144:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:146:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:150:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:152:0x01da  */
    /* JADX WARN: Code duplicated, block: B:156:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:159:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:161:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:164:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:166:0x0202  */
    /* JADX WARN: Code duplicated, block: B:169:0x0209  */
    /* JADX WARN: Code duplicated, block: B:171:0x020f  */
    /* JADX WARN: Code duplicated, block: B:174:0x0218  */
    /* JADX WARN: Code duplicated, block: B:176:0x021c  */
    /* JADX WARN: Code duplicated, block: B:179:0x0222  */
    /* JADX WARN: Code duplicated, block: B:181:0x022a  */
    /* JADX WARN: Code duplicated, block: B:183:0x0232  */
    /* JADX WARN: Code duplicated, block: B:185:0x0238  */
    /* JADX WARN: Code duplicated, block: B:186:0x023b  */
    /* JADX WARN: Code duplicated, block: B:190:0x0249  */
    /* JADX WARN: Code duplicated, block: B:196:0x0279  */
    /* JADX WARN: Code duplicated, block: B:198:0x0285  */
    /* JADX WARN: Code duplicated, block: B:223:0x02de A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:224:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:225:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:228:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:229:0x030f  */
    /* JADX WARN: Code duplicated, block: B:231:0x031c  */
    /* JADX WARN: Code duplicated, block: B:232:0x031e  */
    /* JADX WARN: Code duplicated, block: B:234:0x0322  */
    /* JADX WARN: Code duplicated, block: B:236:0x032a  */
    /* JADX WARN: Code duplicated, block: B:237:0x0331  */
    /* JADX WARN: Code duplicated, block: B:239:0x0335  */
    /* JADX WARN: Code duplicated, block: B:240:0x0337  */
    /* JADX WARN: Code duplicated, block: B:242:0x033b  */
    /* JADX WARN: Code duplicated, block: B:243:0x033d  */
    /* JADX WARN: Code duplicated, block: B:246:0x0343  */
    /* JADX WARN: Code duplicated, block: B:247:0x0353  */
    /* JADX WARN: Code duplicated, block: B:250:0x035a  */
    /* JADX WARN: Code duplicated, block: B:251:0x0363  */
    /* JADX WARN: Code duplicated, block: B:254:0x0369  */
    /* JADX WARN: Code duplicated, block: B:255:0x0372  */
    /* JADX WARN: Code duplicated, block: B:257:0x0376  */
    /* JADX WARN: Code duplicated, block: B:258:0x037d  */
    /* JADX WARN: Code duplicated, block: B:261:0x0383  */
    /* JADX WARN: Code duplicated, block: B:262:0x0393  */
    /* JADX WARN: Code duplicated, block: B:265:0x039b  */
    /* JADX WARN: Code duplicated, block: B:266:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:269:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:270:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:272:0x03c4  */
    /* JADX WARN: Code duplicated, block: B:274:0x03e9  */
    /* JADX WARN: Code duplicated, block: B:277:0x040a  */
    /* JADX WARN: Code duplicated, block: B:280:0x045b  */
    /* JADX WARN: Code duplicated, block: B:282:0x0463  */
    /* JADX WARN: Code duplicated, block: B:285:0x04da  */
    /* JADX WARN: Code duplicated, block: B:290:0x0501  */
    /* JADX WARN: Code duplicated, block: B:292:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0096  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:53:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:57:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:62:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00db  */
    /* JADX WARN: Code duplicated, block: B:69:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:76:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:78:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:80:0x0103  */
    /* JADX WARN: Code duplicated, block: B:82:0x010d  */
    /* JADX WARN: Code duplicated, block: B:83:0x0110  */
    /* JADX WARN: Code duplicated, block: B:87:0x0118  */
    /* JADX WARN: Code duplicated, block: B:89:0x0121  */
    /* JADX WARN: Code duplicated, block: B:91:0x0127  */
    /* JADX WARN: Code duplicated, block: B:93:0x0131  */
    /* JADX WARN: Code duplicated, block: B:94:0x0134  */
    /* JADX WARN: Code duplicated, block: B:98:0x013c  */
    /* JADX WARN: Code duplicated, block: B:99:0x0147  */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: BackdropScaffold-BZszfkY, reason: not valid java name */
    public static final void m985BackdropScaffoldBZszfkY(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, Modifier modifier, BackdropScaffoldState backdropScaffoldState, boolean z, float f, float f2, boolean z2, boolean z3, long j, long j2, Shape shape, float f3, long j3, long j4, long j5, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2, int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        BackdropScaffoldState backdropScaffoldStateRememberBackdropScaffoldState;
        int i6;
        int i7;
        int i8;
        float fM984getPeekHeightD9Ej5fM;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        Shape shape2;
        int i18;
        int i19;
        InterfaceC0552Gp interfaceC0552Gp2;
        int i20;
        int i21;
        Modifier modifier3;
        boolean z4;
        float fM983getHeaderHeightD9Ej5fM;
        boolean z5;
        boolean z6;
        int i22;
        long jM1051getPrimary0d7_KjU;
        long jM1069contentColorForek8zF_U;
        Shape frontLayerShape;
        float fM982getFrontLayerElevationD9Ej5fM;
        long jM1055getSurface0d7_KjU;
        long jM1069contentColorForek8zF_U2;
        long frontLayerScrimColor;
        InterfaceC0552Gp interfaceC0552GpM1075getLambda1$material_release;
        float f4;
        boolean z7;
        boolean z8;
        long j6;
        float fMo333toPx0680j_4;
        boolean zChanged;
        Object objRememberedValue;
        Composer composer2;
        Modifier modifier4;
        BackdropScaffoldState backdropScaffoldState2;
        boolean z9;
        boolean z10;
        boolean z11;
        long j7;
        long j8;
        Shape shape3;
        float f5;
        long j9;
        long j10;
        long j11;
        InterfaceC0552Gp interfaceC0552Gp3;
        float f6;
        float f7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        AbstractC4492zt.h(interfaceC0526Fp, "appBar");
        AbstractC4492zt.h(interfaceC0526Fp2, "backLayerContent");
        AbstractC4492zt.h(interfaceC0526Fp3, "frontLayerContent");
        Composer composerStartRestartGroup = composer.startRestartGroup(1397420093);
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp2) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp3) ? 256 : 128;
        }
        int i29 = i3 & 8;
        if (i29 == 0) {
            if ((i & 7168) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i5 = 8192;
            if ((i & 57344) == 0) {
                backdropScaffoldStateRememberBackdropScaffoldState = backdropScaffoldState;
                if ((i3 & 16) == 0 || !composerStartRestartGroup.changed(backdropScaffoldStateRememberBackdropScaffoldState)) {
                    i28 = 8192;
                } else {
                    i28 = 16384;
                }
                i4 |= i28;
            } else {
                backdropScaffoldStateRememberBackdropScaffoldState = backdropScaffoldState;
            }
            i6 = i3 & 32;
            if (i6 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i4 |= i7;
            }
            i8 = i3 & 64;
            if (i8 != 0) {
                i4 |= 1572864;
                fM984getPeekHeightD9Ej5fM = f;
            } else {
                fM984getPeekHeightD9Ej5fM = f;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(fM984getPeekHeightD9Ej5fM)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i4 |= i9;
                }
            }
            i10 = i3 & 128;
            if (i10 != 0) {
                if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i4 |= i11;
                }
                i12 = i3 & 256;
                if (i12 != 0) {
                    if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i4 |= i13;
                    }
                    i14 = i3 & 512;
                    if (i14 != 0) {
                        i15 = i4 | 805306368;
                        i14 = i14;
                    } else {
                        if ((i & 1879048192) != 0) {
                            if (composerStartRestartGroup.changed(z3)) {
                                i16 = PropertyOptions.DELETE_EXISTING;
                            } else {
                                i16 = 268435456;
                            }
                            i4 |= i16;
                        }
                        i15 = i4;
                    }
                    if ((i2 & 14) == 0) {
                        if ((i3 & 1024) == 0 || !composerStartRestartGroup.changed(j)) {
                            i27 = 2;
                        } else {
                            i27 = 4;
                        }
                        i17 = i2 | i27;
                    } else {
                        i17 = i2;
                    }
                    if ((i2 & 112) != 0) {
                        if ((i3 & 2048) == 0 || !composerStartRestartGroup.changed(j2)) {
                            i26 = 16;
                        } else {
                            i26 = 32;
                        }
                        i17 |= i26;
                    }
                    if ((i2 & 896) == 0) {
                        shape2 = shape;
                        if ((i3 & 4096) == 0 || !composerStartRestartGroup.changed(shape2)) {
                            i25 = 128;
                        } else {
                            i25 = 256;
                        }
                        i17 |= i25;
                    } else {
                        shape2 = shape;
                    }
                    i18 = i3 & 8192;
                    if (i18 != 0) {
                        if ((i2 & 7168) == 0) {
                            i17 |= composerStartRestartGroup.changed(f3) ? 2048 : 1024;
                        }
                        if ((i2 & 57344) != 0) {
                            if ((i3 & 16384) == 0 && composerStartRestartGroup.changed(j3)) {
                                i5 = 16384;
                            }
                            i17 |= i5;
                        }
                        if ((458752 & i2) != 0) {
                            if ((i3 & 32768) == 0 || !composerStartRestartGroup.changed(j4)) {
                                i24 = 65536;
                            } else {
                                i24 = 131072;
                            }
                            i17 |= i24;
                        }
                        if ((3670016 & i2) != 0) {
                            if ((i3 & 65536) == 0 || !composerStartRestartGroup.changed(j5)) {
                                i23 = 524288;
                            } else {
                                i23 = 1048576;
                            }
                            i17 |= i23;
                        }
                        i19 = i3 & 131072;
                        if (i19 != 0) {
                            i17 |= 12582912;
                            interfaceC0552Gp2 = interfaceC0552Gp;
                        } else {
                            interfaceC0552Gp2 = interfaceC0552Gp;
                            if ((i2 & 29360128) == 0) {
                                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                                    i20 = 8388608;
                                } else {
                                    i20 = 4194304;
                                }
                                i17 |= i20;
                            }
                        }
                        i21 = i17;
                        if ((i15 & 1533916891) != 306783378 && (23967451 & i21) == 4793490 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            f6 = f2;
                            j8 = j2;
                            f5 = f3;
                            j9 = j3;
                            j10 = j4;
                            j11 = j5;
                            f7 = fM984getPeekHeightD9Ej5fM;
                            modifier4 = modifier2;
                            backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                            shape3 = shape2;
                            interfaceC0552Gp3 = interfaceC0552Gp2;
                            composer2 = composerStartRestartGroup;
                            z9 = z;
                            z10 = z2;
                            z11 = z3;
                            j7 = j;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i29 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if ((i3 & 16) != 0) {
                                    i15 &= -57345;
                                    backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                                }
                                if (i6 != 0) {
                                    z4 = true;
                                } else {
                                    z4 = z;
                                }
                                if (i8 != 0) {
                                    fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                                }
                                if (i10 != 0) {
                                    fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                                } else {
                                    fM983getHeaderHeightD9Ej5fM = f2;
                                }
                                if (i12 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                }
                                if (i14 != 0) {
                                    z6 = true;
                                } else {
                                    z6 = z3;
                                }
                                if ((i3 & 1024) != 0) {
                                    i22 = 6;
                                    i21 &= -15;
                                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                                } else {
                                    i22 = 6;
                                    jM1051getPrimary0d7_KjU = j;
                                }
                                if ((i3 & 2048) != 0) {
                                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                                    i21 &= -113;
                                } else {
                                    jM1069contentColorForek8zF_U = j2;
                                }
                                if ((i3 & 4096) != 0) {
                                    frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                                    i21 &= -897;
                                } else {
                                    frontLayerShape = shape;
                                }
                                if (i18 != 0) {
                                    fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                                } else {
                                    fM982getFrontLayerElevationD9Ej5fM = f3;
                                }
                                if ((i3 & 16384) != 0) {
                                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                    i21 &= -57345;
                                } else {
                                    jM1055getSurface0d7_KjU = j3;
                                }
                                if ((i3 & 32768) != 0) {
                                    jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                                    i21 &= -458753;
                                } else {
                                    jM1069contentColorForek8zF_U2 = j4;
                                }
                                if ((i3 & 65536) != 0) {
                                    frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                                    i21 = (-3670017) & i21;
                                } else {
                                    frontLayerScrimColor = j5;
                                }
                                if (i19 != 0) {
                                    interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                                } else {
                                    interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                                }
                                f4 = fM984getPeekHeightD9Ej5fM;
                                z7 = z4;
                                z8 = z5;
                                j6 = jM1051getPrimary0d7_KjU;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 16) != 0) {
                                    i15 &= -57345;
                                }
                                if ((i3 & 1024) != 0) {
                                    i21 &= -15;
                                }
                                if ((i3 & 2048) != 0) {
                                    i21 &= -113;
                                }
                                if ((i3 & 4096) != 0) {
                                    i21 &= -897;
                                }
                                if ((i3 & 16384) != 0) {
                                    i21 &= -57345;
                                }
                                if ((i3 & 32768) != 0) {
                                    i21 &= -458753;
                                }
                                if ((i3 & 65536) != 0) {
                                    i21 &= -3670017;
                                }
                                z7 = z;
                                fM983getHeaderHeightD9Ej5fM = f2;
                                z8 = z2;
                                z6 = z3;
                                jM1069contentColorForek8zF_U = j2;
                                fM982getFrontLayerElevationD9Ej5fM = f3;
                                jM1055getSurface0d7_KjU = j3;
                                jM1069contentColorForek8zF_U2 = j4;
                                frontLayerScrimColor = j5;
                                interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                                modifier3 = modifier2;
                                backdropScaffoldStateRememberBackdropScaffoldState = backdropScaffoldStateRememberBackdropScaffoldState;
                                frontLayerShape = shape2;
                                i21 = i21;
                                i15 = i15;
                                j6 = j;
                                f4 = fM984getPeekHeightD9Ej5fM;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                            }
                            float fMo333toPx0680j_5 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                            fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                            Float fValueOf = Float.valueOf(fMo333toPx0680j_4);
                            composerStartRestartGroup.startReplaceableGroup(1157296644);
                            zChanged = composerStartRestartGroup.changed(fValueOf);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            int i30 = i21;
                            float f8 = fM983getHeaderHeightD9Ej5fM;
                            float f9 = f4;
                            Modifier modifier5 = modifier3;
                            composer2 = composerStartRestartGroup;
                            int i31 = i30 << 6;
                            SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_5, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i30, f8, f9, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i31 & 7168) | (i31 & 896) | 1572864, 51);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier5;
                            backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                            z9 = z7;
                            z10 = z8;
                            z11 = z6;
                            j7 = j6;
                            j8 = jM1069contentColorForek8zF_U;
                            shape3 = frontLayerShape;
                            f5 = fM982getFrontLayerElevationD9Ej5fM;
                            j9 = jM1055getSurface0d7_KjU;
                            j10 = jM1069contentColorForek8zF_U2;
                            j11 = frontLayerScrimColor;
                            interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                            f6 = f8;
                            f7 = f9;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new BackdropScaffoldKt$BackdropScaffold$2(interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, modifier4, backdropScaffoldState2, z9, f7, f6, z10, z11, j7, j8, shape3, f5, j9, j10, j11, interfaceC0552Gp3, i, i2, i3));
                    }
                    i17 |= 3072;
                    if ((i2 & 57344) != 0) {
                        if ((i3 & 16384) == 0) {
                            i5 = 16384;
                        }
                        i17 |= i5;
                    }
                    if ((458752 & i2) != 0) {
                        if ((i3 & 32768) == 0) {
                            i24 = 65536;
                        } else {
                            i24 = 65536;
                        }
                        i17 |= i24;
                    }
                    if ((3670016 & i2) != 0) {
                        if ((i3 & 65536) == 0) {
                            i23 = 524288;
                        } else {
                            i23 = 524288;
                        }
                        i17 |= i23;
                    }
                    i19 = i3 & 131072;
                    if (i19 != 0) {
                        i17 |= 12582912;
                        interfaceC0552Gp2 = interfaceC0552Gp;
                    } else {
                        interfaceC0552Gp2 = interfaceC0552Gp;
                        if ((i2 & 29360128) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                                i20 = 8388608;
                            } else {
                                i20 = 4194304;
                            }
                            i17 |= i20;
                        }
                    }
                    i21 = i17;
                    if ((i15 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i29 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i3 & 16) != 0) {
                                i15 &= -57345;
                                backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i8 != 0) {
                                fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                            }
                            if (i10 != 0) {
                                fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                            } else {
                                fM983getHeaderHeightD9Ej5fM = f2;
                            }
                            if (i12 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i14 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if ((i3 & 1024) != 0) {
                                i22 = 6;
                                i21 &= -15;
                                jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                            } else {
                                i22 = 6;
                                jM1051getPrimary0d7_KjU = j;
                            }
                            if ((i3 & 2048) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                                i21 &= -113;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if ((i3 & 4096) != 0) {
                                frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                                i21 &= -897;
                            } else {
                                frontLayerShape = shape;
                            }
                            if (i18 != 0) {
                                fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                            } else {
                                fM982getFrontLayerElevationD9Ej5fM = f3;
                            }
                            if ((i3 & 16384) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i21 &= -57345;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i3 & 32768) != 0) {
                                jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                                i21 &= -458753;
                            } else {
                                jM1069contentColorForek8zF_U2 = j4;
                            }
                            if ((i3 & 65536) != 0) {
                                frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                                i21 = (-3670017) & i21;
                            } else {
                                frontLayerScrimColor = j5;
                            }
                            if (i19 != 0) {
                                interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                            } else {
                                interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                            }
                            f4 = fM984getPeekHeightD9Ej5fM;
                            z7 = z4;
                            z8 = z5;
                            j6 = jM1051getPrimary0d7_KjU;
                        } else {
                            if (i29 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i3 & 16) != 0) {
                                i15 &= -57345;
                                backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i8 != 0) {
                                fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                            }
                            if (i10 != 0) {
                                fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                            } else {
                                fM983getHeaderHeightD9Ej5fM = f2;
                            }
                            if (i12 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i14 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if ((i3 & 1024) != 0) {
                                i22 = 6;
                                i21 &= -15;
                                jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                            } else {
                                i22 = 6;
                                jM1051getPrimary0d7_KjU = j;
                            }
                            if ((i3 & 2048) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                                i21 &= -113;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if ((i3 & 4096) != 0) {
                                frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                                i21 &= -897;
                            } else {
                                frontLayerShape = shape;
                            }
                            if (i18 != 0) {
                                fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                            } else {
                                fM982getFrontLayerElevationD9Ej5fM = f3;
                            }
                            if ((i3 & 16384) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i21 &= -57345;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i3 & 32768) != 0) {
                                jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                                i21 &= -458753;
                            } else {
                                jM1069contentColorForek8zF_U2 = j4;
                            }
                            if ((i3 & 65536) != 0) {
                                frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                                i21 = (-3670017) & i21;
                            } else {
                                frontLayerScrimColor = j5;
                            }
                            if (i19 != 0) {
                                interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                            } else {
                                interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                            }
                            f4 = fM984getPeekHeightD9Ej5fM;
                            z7 = z4;
                            z8 = z5;
                            j6 = jM1051getPrimary0d7_KjU;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                        }
                        float fMo333toPx0680j_6 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                        fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                        ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                        Float fValueOf2 = Float.valueOf(fMo333toPx0680j_4);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(fValueOf2);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i32 = i21;
                        float f10 = fM983getHeaderHeightD9Ej5fM;
                        float f11 = f4;
                        Modifier modifier6 = modifier3;
                        composer2 = composerStartRestartGroup;
                        int i33 = i32 << 6;
                        SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda2, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_6, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i32, f10, f11, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i33 & 7168) | (i33 & 896) | 1572864, 51);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier6;
                        backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                        z9 = z7;
                        z10 = z8;
                        z11 = z6;
                        j7 = j6;
                        j8 = jM1069contentColorForek8zF_U;
                        shape3 = frontLayerShape;
                        f5 = fM982getFrontLayerElevationD9Ej5fM;
                        j9 = jM1055getSurface0d7_KjU;
                        j10 = jM1069contentColorForek8zF_U2;
                        j11 = frontLayerScrimColor;
                        interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                        f6 = f10;
                        f7 = f11;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i29 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i3 & 16) != 0) {
                                i15 &= -57345;
                                backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i8 != 0) {
                                fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                            }
                            if (i10 != 0) {
                                fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                            } else {
                                fM983getHeaderHeightD9Ej5fM = f2;
                            }
                            if (i12 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i14 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if ((i3 & 1024) != 0) {
                                i22 = 6;
                                i21 &= -15;
                                jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                            } else {
                                i22 = 6;
                                jM1051getPrimary0d7_KjU = j;
                            }
                            if ((i3 & 2048) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                                i21 &= -113;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if ((i3 & 4096) != 0) {
                                frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                                i21 &= -897;
                            } else {
                                frontLayerShape = shape;
                            }
                            if (i18 != 0) {
                                fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                            } else {
                                fM982getFrontLayerElevationD9Ej5fM = f3;
                            }
                            if ((i3 & 16384) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i21 &= -57345;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i3 & 32768) != 0) {
                                jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                                i21 &= -458753;
                            } else {
                                jM1069contentColorForek8zF_U2 = j4;
                            }
                            if ((i3 & 65536) != 0) {
                                frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                                i21 = (-3670017) & i21;
                            } else {
                                frontLayerScrimColor = j5;
                            }
                            if (i19 != 0) {
                                interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                            } else {
                                interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                            }
                            f4 = fM984getPeekHeightD9Ej5fM;
                            z7 = z4;
                            z8 = z5;
                            j6 = jM1051getPrimary0d7_KjU;
                        } else {
                            if (i29 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i3 & 16) != 0) {
                                i15 &= -57345;
                                backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i8 != 0) {
                                fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                            }
                            if (i10 != 0) {
                                fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                            } else {
                                fM983getHeaderHeightD9Ej5fM = f2;
                            }
                            if (i12 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i14 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if ((i3 & 1024) != 0) {
                                i22 = 6;
                                i21 &= -15;
                                jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                            } else {
                                i22 = 6;
                                jM1051getPrimary0d7_KjU = j;
                            }
                            if ((i3 & 2048) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                                i21 &= -113;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if ((i3 & 4096) != 0) {
                                frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                                i21 &= -897;
                            } else {
                                frontLayerShape = shape;
                            }
                            if (i18 != 0) {
                                fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                            } else {
                                fM982getFrontLayerElevationD9Ej5fM = f3;
                            }
                            if ((i3 & 16384) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i21 &= -57345;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i3 & 32768) != 0) {
                                jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                                i21 &= -458753;
                            } else {
                                jM1069contentColorForek8zF_U2 = j4;
                            }
                            if ((i3 & 65536) != 0) {
                                frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                                i21 = (-3670017) & i21;
                            } else {
                                frontLayerScrimColor = j5;
                            }
                            if (i19 != 0) {
                                interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                            } else {
                                interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                            }
                            f4 = fM984getPeekHeightD9Ej5fM;
                            z7 = z4;
                            z8 = z5;
                            j6 = jM1051getPrimary0d7_KjU;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                        }
                        float fMo333toPx0680j_7 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                        fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                        ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                        Float fValueOf3 = Float.valueOf(fMo333toPx0680j_4);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(fValueOf3);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i34 = i21;
                        float f12 = fM983getHeaderHeightD9Ej5fM;
                        float f13 = f4;
                        Modifier modifier7 = modifier3;
                        composer2 = composerStartRestartGroup;
                        int i35 = i34 << 6;
                        SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda3, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_7, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i34, f12, f13, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i35 & 7168) | (i35 & 896) | 1572864, 51);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier7;
                        backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                        z9 = z7;
                        z10 = z8;
                        z11 = z6;
                        j7 = j6;
                        j8 = jM1069contentColorForek8zF_U;
                        shape3 = frontLayerShape;
                        f5 = fM982getFrontLayerElevationD9Ej5fM;
                        j9 = jM1055getSurface0d7_KjU;
                        j10 = jM1069contentColorForek8zF_U2;
                        j11 = frontLayerScrimColor;
                        interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                        f6 = f12;
                        f7 = f13;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new BackdropScaffoldKt$BackdropScaffold$2(interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, modifier4, backdropScaffoldState2, z9, f7, f6, z10, z11, j7, j8, shape3, f5, j9, j10, j11, interfaceC0552Gp3, i, i2, i3));
                }
                i4 |= 100663296;
                i14 = i3 & 512;
                if (i14 != 0) {
                    i15 = i4 | 805306368;
                    i14 = i14;
                } else {
                    if ((i & 1879048192) != 0) {
                        if (composerStartRestartGroup.changed(z3)) {
                            i16 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i16 = 268435456;
                        }
                        i4 |= i16;
                    }
                    i15 = i4;
                }
                if ((i2 & 14) == 0) {
                    if ((i3 & 1024) == 0) {
                        i27 = 2;
                    } else {
                        i27 = 2;
                    }
                    i17 = i2 | i27;
                } else {
                    i17 = i2;
                }
                if ((i2 & 112) != 0) {
                    if ((i3 & 2048) == 0) {
                        i26 = 16;
                    } else {
                        i26 = 16;
                    }
                    i17 |= i26;
                }
                if ((i2 & 896) == 0) {
                    shape2 = shape;
                    if ((i3 & 4096) == 0) {
                        i25 = 128;
                    } else {
                        i25 = 128;
                    }
                    i17 |= i25;
                } else {
                    shape2 = shape;
                }
                i18 = i3 & 8192;
                if (i18 != 0) {
                    if ((i2 & 7168) == 0) {
                        i17 |= composerStartRestartGroup.changed(f3) ? 2048 : 1024;
                    }
                    if ((i2 & 57344) != 0) {
                        if ((i3 & 16384) == 0) {
                            i5 = 16384;
                        }
                        i17 |= i5;
                    }
                    if ((458752 & i2) != 0) {
                        if ((i3 & 32768) == 0) {
                            i24 = 65536;
                        } else {
                            i24 = 65536;
                        }
                        i17 |= i24;
                    }
                    if ((3670016 & i2) != 0) {
                        if ((i3 & 65536) == 0) {
                            i23 = 524288;
                        } else {
                            i23 = 524288;
                        }
                        i17 |= i23;
                    }
                    i19 = i3 & 131072;
                    if (i19 != 0) {
                        i17 |= 12582912;
                        interfaceC0552Gp2 = interfaceC0552Gp;
                    } else {
                        interfaceC0552Gp2 = interfaceC0552Gp;
                        if ((i2 & 29360128) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                                i20 = 8388608;
                            } else {
                                i20 = 4194304;
                            }
                            i17 |= i20;
                        }
                    }
                    i21 = i17;
                    if ((i15 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i29 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i3 & 16) != 0) {
                                i15 &= -57345;
                                backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i8 != 0) {
                                fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                            }
                            if (i10 != 0) {
                                fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                            } else {
                                fM983getHeaderHeightD9Ej5fM = f2;
                            }
                            if (i12 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i14 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if ((i3 & 1024) != 0) {
                                i22 = 6;
                                i21 &= -15;
                                jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                            } else {
                                i22 = 6;
                                jM1051getPrimary0d7_KjU = j;
                            }
                            if ((i3 & 2048) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                                i21 &= -113;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if ((i3 & 4096) != 0) {
                                frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                                i21 &= -897;
                            } else {
                                frontLayerShape = shape;
                            }
                            if (i18 != 0) {
                                fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                            } else {
                                fM982getFrontLayerElevationD9Ej5fM = f3;
                            }
                            if ((i3 & 16384) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i21 &= -57345;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i3 & 32768) != 0) {
                                jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                                i21 &= -458753;
                            } else {
                                jM1069contentColorForek8zF_U2 = j4;
                            }
                            if ((i3 & 65536) != 0) {
                                frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                                i21 = (-3670017) & i21;
                            } else {
                                frontLayerScrimColor = j5;
                            }
                            if (i19 != 0) {
                                interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                            } else {
                                interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                            }
                            f4 = fM984getPeekHeightD9Ej5fM;
                            z7 = z4;
                            z8 = z5;
                            j6 = jM1051getPrimary0d7_KjU;
                        } else {
                            if (i29 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i3 & 16) != 0) {
                                i15 &= -57345;
                                backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i8 != 0) {
                                fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                            }
                            if (i10 != 0) {
                                fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                            } else {
                                fM983getHeaderHeightD9Ej5fM = f2;
                            }
                            if (i12 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i14 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if ((i3 & 1024) != 0) {
                                i22 = 6;
                                i21 &= -15;
                                jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                            } else {
                                i22 = 6;
                                jM1051getPrimary0d7_KjU = j;
                            }
                            if ((i3 & 2048) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                                i21 &= -113;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if ((i3 & 4096) != 0) {
                                frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                                i21 &= -897;
                            } else {
                                frontLayerShape = shape;
                            }
                            if (i18 != 0) {
                                fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                            } else {
                                fM982getFrontLayerElevationD9Ej5fM = f3;
                            }
                            if ((i3 & 16384) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i21 &= -57345;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i3 & 32768) != 0) {
                                jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                                i21 &= -458753;
                            } else {
                                jM1069contentColorForek8zF_U2 = j4;
                            }
                            if ((i3 & 65536) != 0) {
                                frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                                i21 = (-3670017) & i21;
                            } else {
                                frontLayerScrimColor = j5;
                            }
                            if (i19 != 0) {
                                interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                            } else {
                                interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                            }
                            f4 = fM984getPeekHeightD9Ej5fM;
                            z7 = z4;
                            z8 = z5;
                            j6 = jM1051getPrimary0d7_KjU;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                        }
                        float fMo333toPx0680j_8 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                        fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                        ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                        Float fValueOf4 = Float.valueOf(fMo333toPx0680j_4);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(fValueOf4);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i36 = i21;
                        float f14 = fM983getHeaderHeightD9Ej5fM;
                        float f15 = f4;
                        Modifier modifier8 = modifier3;
                        composer2 = composerStartRestartGroup;
                        int i37 = i36 << 6;
                        SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda4, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_8, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i36, f14, f15, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i37 & 7168) | (i37 & 896) | 1572864, 51);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier8;
                        backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                        z9 = z7;
                        z10 = z8;
                        z11 = z6;
                        j7 = j6;
                        j8 = jM1069contentColorForek8zF_U;
                        shape3 = frontLayerShape;
                        f5 = fM982getFrontLayerElevationD9Ej5fM;
                        j9 = jM1055getSurface0d7_KjU;
                        j10 = jM1069contentColorForek8zF_U2;
                        j11 = frontLayerScrimColor;
                        interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                        f6 = f14;
                        f7 = f15;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i29 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i3 & 16) != 0) {
                                i15 &= -57345;
                                backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i8 != 0) {
                                fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                            }
                            if (i10 != 0) {
                                fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                            } else {
                                fM983getHeaderHeightD9Ej5fM = f2;
                            }
                            if (i12 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i14 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if ((i3 & 1024) != 0) {
                                i22 = 6;
                                i21 &= -15;
                                jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                            } else {
                                i22 = 6;
                                jM1051getPrimary0d7_KjU = j;
                            }
                            if ((i3 & 2048) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                                i21 &= -113;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if ((i3 & 4096) != 0) {
                                frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                                i21 &= -897;
                            } else {
                                frontLayerShape = shape;
                            }
                            if (i18 != 0) {
                                fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                            } else {
                                fM982getFrontLayerElevationD9Ej5fM = f3;
                            }
                            if ((i3 & 16384) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i21 &= -57345;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i3 & 32768) != 0) {
                                jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                                i21 &= -458753;
                            } else {
                                jM1069contentColorForek8zF_U2 = j4;
                            }
                            if ((i3 & 65536) != 0) {
                                frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                                i21 = (-3670017) & i21;
                            } else {
                                frontLayerScrimColor = j5;
                            }
                            if (i19 != 0) {
                                interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                            } else {
                                interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                            }
                            f4 = fM984getPeekHeightD9Ej5fM;
                            z7 = z4;
                            z8 = z5;
                            j6 = jM1051getPrimary0d7_KjU;
                        } else {
                            if (i29 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i3 & 16) != 0) {
                                i15 &= -57345;
                                backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i8 != 0) {
                                fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                            }
                            if (i10 != 0) {
                                fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                            } else {
                                fM983getHeaderHeightD9Ej5fM = f2;
                            }
                            if (i12 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i14 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if ((i3 & 1024) != 0) {
                                i22 = 6;
                                i21 &= -15;
                                jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                            } else {
                                i22 = 6;
                                jM1051getPrimary0d7_KjU = j;
                            }
                            if ((i3 & 2048) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                                i21 &= -113;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if ((i3 & 4096) != 0) {
                                frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                                i21 &= -897;
                            } else {
                                frontLayerShape = shape;
                            }
                            if (i18 != 0) {
                                fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                            } else {
                                fM982getFrontLayerElevationD9Ej5fM = f3;
                            }
                            if ((i3 & 16384) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i21 &= -57345;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i3 & 32768) != 0) {
                                jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                                i21 &= -458753;
                            } else {
                                jM1069contentColorForek8zF_U2 = j4;
                            }
                            if ((i3 & 65536) != 0) {
                                frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                                i21 = (-3670017) & i21;
                            } else {
                                frontLayerScrimColor = j5;
                            }
                            if (i19 != 0) {
                                interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                            } else {
                                interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                            }
                            f4 = fM984getPeekHeightD9Ej5fM;
                            z7 = z4;
                            z8 = z5;
                            j6 = jM1051getPrimary0d7_KjU;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                        }
                        float fMo333toPx0680j_9 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                        fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                        ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                        Float fValueOf5 = Float.valueOf(fMo333toPx0680j_4);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(fValueOf5);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i38 = i21;
                        float f16 = fM983getHeaderHeightD9Ej5fM;
                        float f17 = f4;
                        Modifier modifier9 = modifier3;
                        composer2 = composerStartRestartGroup;
                        int i39 = i38 << 6;
                        SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda5, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_9, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i38, f16, f17, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i39 & 7168) | (i39 & 896) | 1572864, 51);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier9;
                        backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                        z9 = z7;
                        z10 = z8;
                        z11 = z6;
                        j7 = j6;
                        j8 = jM1069contentColorForek8zF_U;
                        shape3 = frontLayerShape;
                        f5 = fM982getFrontLayerElevationD9Ej5fM;
                        j9 = jM1055getSurface0d7_KjU;
                        j10 = jM1069contentColorForek8zF_U2;
                        j11 = frontLayerScrimColor;
                        interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                        f6 = f16;
                        f7 = f17;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new BackdropScaffoldKt$BackdropScaffold$2(interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, modifier4, backdropScaffoldState2, z9, f7, f6, z10, z11, j7, j8, shape3, f5, j9, j10, j11, interfaceC0552Gp3, i, i2, i3));
                }
                i17 |= 3072;
                if ((i2 & 57344) != 0) {
                    if ((i3 & 16384) == 0) {
                        i5 = 16384;
                    }
                    i17 |= i5;
                }
                if ((458752 & i2) != 0) {
                    if ((i3 & 32768) == 0) {
                        i24 = 65536;
                    } else {
                        i24 = 65536;
                    }
                    i17 |= i24;
                }
                if ((3670016 & i2) != 0) {
                    if ((i3 & 65536) == 0) {
                        i23 = 524288;
                    } else {
                        i23 = 524288;
                    }
                    i17 |= i23;
                }
                i19 = i3 & 131072;
                if (i19 != 0) {
                    i17 |= 12582912;
                    interfaceC0552Gp2 = interfaceC0552Gp;
                } else {
                    interfaceC0552Gp2 = interfaceC0552Gp;
                    if ((i2 & 29360128) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                            i20 = 8388608;
                        } else {
                            i20 = 4194304;
                        }
                        i17 |= i20;
                    }
                }
                i21 = i17;
                if ((i15 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i29 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i3 & 16) != 0) {
                            i15 &= -57345;
                            backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                        } else {
                            fM983getHeaderHeightD9Ej5fM = f2;
                        }
                        if (i12 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i14 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 1024) != 0) {
                            i22 = 6;
                            i21 &= -15;
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        } else {
                            i22 = 6;
                            jM1051getPrimary0d7_KjU = j;
                        }
                        if ((i3 & 2048) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                            i21 &= -113;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 4096) != 0) {
                            frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                            i21 &= -897;
                        } else {
                            frontLayerShape = shape;
                        }
                        if (i18 != 0) {
                            fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                        } else {
                            fM982getFrontLayerElevationD9Ej5fM = f3;
                        }
                        if ((i3 & 16384) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i21 &= -57345;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                            i21 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U2 = j4;
                        }
                        if ((i3 & 65536) != 0) {
                            frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                            i21 = (-3670017) & i21;
                        } else {
                            frontLayerScrimColor = j5;
                        }
                        if (i19 != 0) {
                            interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                        }
                        f4 = fM984getPeekHeightD9Ej5fM;
                        z7 = z4;
                        z8 = z5;
                        j6 = jM1051getPrimary0d7_KjU;
                    } else {
                        if (i29 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i3 & 16) != 0) {
                            i15 &= -57345;
                            backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                        } else {
                            fM983getHeaderHeightD9Ej5fM = f2;
                        }
                        if (i12 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i14 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 1024) != 0) {
                            i22 = 6;
                            i21 &= -15;
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        } else {
                            i22 = 6;
                            jM1051getPrimary0d7_KjU = j;
                        }
                        if ((i3 & 2048) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                            i21 &= -113;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 4096) != 0) {
                            frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                            i21 &= -897;
                        } else {
                            frontLayerShape = shape;
                        }
                        if (i18 != 0) {
                            fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                        } else {
                            fM982getFrontLayerElevationD9Ej5fM = f3;
                        }
                        if ((i3 & 16384) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i21 &= -57345;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                            i21 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U2 = j4;
                        }
                        if ((i3 & 65536) != 0) {
                            frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                            i21 = (-3670017) & i21;
                        } else {
                            frontLayerScrimColor = j5;
                        }
                        if (i19 != 0) {
                            interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                        }
                        f4 = fM984getPeekHeightD9Ej5fM;
                        z7 = z4;
                        z8 = z5;
                        j6 = jM1051getPrimary0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                    }
                    float fMo333toPx0680j_10 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                    fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                    ComposableLambda composableLambda6 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                    Float fValueOf6 = Float.valueOf(fMo333toPx0680j_4);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(fValueOf6);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i310 = i21;
                    float f18 = fM983getHeaderHeightD9Ej5fM;
                    float f19 = f4;
                    Modifier modifier10 = modifier3;
                    composer2 = composerStartRestartGroup;
                    int i311 = i310 << 6;
                    SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda6, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_10, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i310, f18, f19, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i311 & 7168) | (i311 & 896) | 1572864, 51);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier10;
                    backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                    z9 = z7;
                    z10 = z8;
                    z11 = z6;
                    j7 = j6;
                    j8 = jM1069contentColorForek8zF_U;
                    shape3 = frontLayerShape;
                    f5 = fM982getFrontLayerElevationD9Ej5fM;
                    j9 = jM1055getSurface0d7_KjU;
                    j10 = jM1069contentColorForek8zF_U2;
                    j11 = frontLayerScrimColor;
                    interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                    f6 = f18;
                    f7 = f19;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i29 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i3 & 16) != 0) {
                            i15 &= -57345;
                            backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                        } else {
                            fM983getHeaderHeightD9Ej5fM = f2;
                        }
                        if (i12 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i14 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 1024) != 0) {
                            i22 = 6;
                            i21 &= -15;
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        } else {
                            i22 = 6;
                            jM1051getPrimary0d7_KjU = j;
                        }
                        if ((i3 & 2048) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                            i21 &= -113;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 4096) != 0) {
                            frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                            i21 &= -897;
                        } else {
                            frontLayerShape = shape;
                        }
                        if (i18 != 0) {
                            fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                        } else {
                            fM982getFrontLayerElevationD9Ej5fM = f3;
                        }
                        if ((i3 & 16384) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i21 &= -57345;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                            i21 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U2 = j4;
                        }
                        if ((i3 & 65536) != 0) {
                            frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                            i21 = (-3670017) & i21;
                        } else {
                            frontLayerScrimColor = j5;
                        }
                        if (i19 != 0) {
                            interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                        }
                        f4 = fM984getPeekHeightD9Ej5fM;
                        z7 = z4;
                        z8 = z5;
                        j6 = jM1051getPrimary0d7_KjU;
                    } else {
                        if (i29 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i3 & 16) != 0) {
                            i15 &= -57345;
                            backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                        } else {
                            fM983getHeaderHeightD9Ej5fM = f2;
                        }
                        if (i12 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i14 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 1024) != 0) {
                            i22 = 6;
                            i21 &= -15;
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        } else {
                            i22 = 6;
                            jM1051getPrimary0d7_KjU = j;
                        }
                        if ((i3 & 2048) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                            i21 &= -113;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 4096) != 0) {
                            frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                            i21 &= -897;
                        } else {
                            frontLayerShape = shape;
                        }
                        if (i18 != 0) {
                            fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                        } else {
                            fM982getFrontLayerElevationD9Ej5fM = f3;
                        }
                        if ((i3 & 16384) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i21 &= -57345;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                            i21 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U2 = j4;
                        }
                        if ((i3 & 65536) != 0) {
                            frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                            i21 = (-3670017) & i21;
                        } else {
                            frontLayerScrimColor = j5;
                        }
                        if (i19 != 0) {
                            interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                        }
                        f4 = fM984getPeekHeightD9Ej5fM;
                        z7 = z4;
                        z8 = z5;
                        j6 = jM1051getPrimary0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                    }
                    float fMo333toPx0680j_11 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                    fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                    ComposableLambda composableLambda7 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                    Float fValueOf7 = Float.valueOf(fMo333toPx0680j_4);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(fValueOf7);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i312 = i21;
                    float f110 = fM983getHeaderHeightD9Ej5fM;
                    float f111 = f4;
                    Modifier modifier11 = modifier3;
                    composer2 = composerStartRestartGroup;
                    int i313 = i312 << 6;
                    SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda7, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_11, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i312, f110, f111, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i313 & 7168) | (i313 & 896) | 1572864, 51);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier11;
                    backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                    z9 = z7;
                    z10 = z8;
                    z11 = z6;
                    j7 = j6;
                    j8 = jM1069contentColorForek8zF_U;
                    shape3 = frontLayerShape;
                    f5 = fM982getFrontLayerElevationD9Ej5fM;
                    j9 = jM1055getSurface0d7_KjU;
                    j10 = jM1069contentColorForek8zF_U2;
                    j11 = frontLayerScrimColor;
                    interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                    f6 = f110;
                    f7 = f111;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new BackdropScaffoldKt$BackdropScaffold$2(interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, modifier4, backdropScaffoldState2, z9, f7, f6, z10, z11, j7, j8, shape3, f5, j9, j10, j11, interfaceC0552Gp3, i, i2, i3));
            }
            i4 |= 12582912;
            i12 = i3 & 256;
            if (i12 != 0) {
                if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i4 |= i13;
                }
                i14 = i3 & 512;
                if (i14 != 0) {
                    i15 = i4 | 805306368;
                    i14 = i14;
                } else {
                    if ((i & 1879048192) != 0) {
                        if (composerStartRestartGroup.changed(z3)) {
                            i16 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i16 = 268435456;
                        }
                        i4 |= i16;
                    }
                    i15 = i4;
                }
                if ((i2 & 14) == 0) {
                    if ((i3 & 1024) == 0) {
                        i27 = 2;
                    } else {
                        i27 = 2;
                    }
                    i17 = i2 | i27;
                } else {
                    i17 = i2;
                }
                if ((i2 & 112) != 0) {
                    if ((i3 & 2048) == 0) {
                        i26 = 16;
                    } else {
                        i26 = 16;
                    }
                    i17 |= i26;
                }
                if ((i2 & 896) == 0) {
                    shape2 = shape;
                    if ((i3 & 4096) == 0) {
                        i25 = 128;
                    } else {
                        i25 = 128;
                    }
                    i17 |= i25;
                } else {
                    shape2 = shape;
                }
                i18 = i3 & 8192;
                if (i18 != 0) {
                    if ((i2 & 7168) == 0) {
                        i17 |= composerStartRestartGroup.changed(f3) ? 2048 : 1024;
                    }
                    if ((i2 & 57344) != 0) {
                        if ((i3 & 16384) == 0) {
                            i5 = 16384;
                        }
                        i17 |= i5;
                    }
                    if ((458752 & i2) != 0) {
                        if ((i3 & 32768) == 0) {
                            i24 = 65536;
                        } else {
                            i24 = 65536;
                        }
                        i17 |= i24;
                    }
                    if ((3670016 & i2) != 0) {
                        if ((i3 & 65536) == 0) {
                            i23 = 524288;
                        } else {
                            i23 = 524288;
                        }
                        i17 |= i23;
                    }
                    i19 = i3 & 131072;
                    if (i19 != 0) {
                        i17 |= 12582912;
                        interfaceC0552Gp2 = interfaceC0552Gp;
                    } else {
                        interfaceC0552Gp2 = interfaceC0552Gp;
                        if ((i2 & 29360128) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                                i20 = 8388608;
                            } else {
                                i20 = 4194304;
                            }
                            i17 |= i20;
                        }
                    }
                    i21 = i17;
                    if ((i15 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i29 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i3 & 16) != 0) {
                                i15 &= -57345;
                                backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i8 != 0) {
                                fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                            }
                            if (i10 != 0) {
                                fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                            } else {
                                fM983getHeaderHeightD9Ej5fM = f2;
                            }
                            if (i12 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i14 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if ((i3 & 1024) != 0) {
                                i22 = 6;
                                i21 &= -15;
                                jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                            } else {
                                i22 = 6;
                                jM1051getPrimary0d7_KjU = j;
                            }
                            if ((i3 & 2048) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                                i21 &= -113;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if ((i3 & 4096) != 0) {
                                frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                                i21 &= -897;
                            } else {
                                frontLayerShape = shape;
                            }
                            if (i18 != 0) {
                                fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                            } else {
                                fM982getFrontLayerElevationD9Ej5fM = f3;
                            }
                            if ((i3 & 16384) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i21 &= -57345;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i3 & 32768) != 0) {
                                jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                                i21 &= -458753;
                            } else {
                                jM1069contentColorForek8zF_U2 = j4;
                            }
                            if ((i3 & 65536) != 0) {
                                frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                                i21 = (-3670017) & i21;
                            } else {
                                frontLayerScrimColor = j5;
                            }
                            if (i19 != 0) {
                                interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                            } else {
                                interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                            }
                            f4 = fM984getPeekHeightD9Ej5fM;
                            z7 = z4;
                            z8 = z5;
                            j6 = jM1051getPrimary0d7_KjU;
                        } else {
                            if (i29 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i3 & 16) != 0) {
                                i15 &= -57345;
                                backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i8 != 0) {
                                fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                            }
                            if (i10 != 0) {
                                fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                            } else {
                                fM983getHeaderHeightD9Ej5fM = f2;
                            }
                            if (i12 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i14 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if ((i3 & 1024) != 0) {
                                i22 = 6;
                                i21 &= -15;
                                jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                            } else {
                                i22 = 6;
                                jM1051getPrimary0d7_KjU = j;
                            }
                            if ((i3 & 2048) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                                i21 &= -113;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if ((i3 & 4096) != 0) {
                                frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                                i21 &= -897;
                            } else {
                                frontLayerShape = shape;
                            }
                            if (i18 != 0) {
                                fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                            } else {
                                fM982getFrontLayerElevationD9Ej5fM = f3;
                            }
                            if ((i3 & 16384) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i21 &= -57345;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i3 & 32768) != 0) {
                                jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                                i21 &= -458753;
                            } else {
                                jM1069contentColorForek8zF_U2 = j4;
                            }
                            if ((i3 & 65536) != 0) {
                                frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                                i21 = (-3670017) & i21;
                            } else {
                                frontLayerScrimColor = j5;
                            }
                            if (i19 != 0) {
                                interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                            } else {
                                interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                            }
                            f4 = fM984getPeekHeightD9Ej5fM;
                            z7 = z4;
                            z8 = z5;
                            j6 = jM1051getPrimary0d7_KjU;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                        }
                        float fMo333toPx0680j_12 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                        fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                        ComposableLambda composableLambda8 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                        Float fValueOf8 = Float.valueOf(fMo333toPx0680j_4);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(fValueOf8);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i314 = i21;
                        float f112 = fM983getHeaderHeightD9Ej5fM;
                        float f113 = f4;
                        Modifier modifier12 = modifier3;
                        composer2 = composerStartRestartGroup;
                        int i315 = i314 << 6;
                        SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda8, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_12, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i314, f112, f113, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i315 & 7168) | (i315 & 896) | 1572864, 51);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier12;
                        backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                        z9 = z7;
                        z10 = z8;
                        z11 = z6;
                        j7 = j6;
                        j8 = jM1069contentColorForek8zF_U;
                        shape3 = frontLayerShape;
                        f5 = fM982getFrontLayerElevationD9Ej5fM;
                        j9 = jM1055getSurface0d7_KjU;
                        j10 = jM1069contentColorForek8zF_U2;
                        j11 = frontLayerScrimColor;
                        interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                        f6 = f112;
                        f7 = f113;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i29 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i3 & 16) != 0) {
                                i15 &= -57345;
                                backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i8 != 0) {
                                fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                            }
                            if (i10 != 0) {
                                fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                            } else {
                                fM983getHeaderHeightD9Ej5fM = f2;
                            }
                            if (i12 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i14 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if ((i3 & 1024) != 0) {
                                i22 = 6;
                                i21 &= -15;
                                jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                            } else {
                                i22 = 6;
                                jM1051getPrimary0d7_KjU = j;
                            }
                            if ((i3 & 2048) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                                i21 &= -113;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if ((i3 & 4096) != 0) {
                                frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                                i21 &= -897;
                            } else {
                                frontLayerShape = shape;
                            }
                            if (i18 != 0) {
                                fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                            } else {
                                fM982getFrontLayerElevationD9Ej5fM = f3;
                            }
                            if ((i3 & 16384) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i21 &= -57345;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i3 & 32768) != 0) {
                                jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                                i21 &= -458753;
                            } else {
                                jM1069contentColorForek8zF_U2 = j4;
                            }
                            if ((i3 & 65536) != 0) {
                                frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                                i21 = (-3670017) & i21;
                            } else {
                                frontLayerScrimColor = j5;
                            }
                            if (i19 != 0) {
                                interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                            } else {
                                interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                            }
                            f4 = fM984getPeekHeightD9Ej5fM;
                            z7 = z4;
                            z8 = z5;
                            j6 = jM1051getPrimary0d7_KjU;
                        } else {
                            if (i29 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i3 & 16) != 0) {
                                i15 &= -57345;
                                backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i8 != 0) {
                                fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                            }
                            if (i10 != 0) {
                                fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                            } else {
                                fM983getHeaderHeightD9Ej5fM = f2;
                            }
                            if (i12 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i14 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if ((i3 & 1024) != 0) {
                                i22 = 6;
                                i21 &= -15;
                                jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                            } else {
                                i22 = 6;
                                jM1051getPrimary0d7_KjU = j;
                            }
                            if ((i3 & 2048) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                                i21 &= -113;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if ((i3 & 4096) != 0) {
                                frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                                i21 &= -897;
                            } else {
                                frontLayerShape = shape;
                            }
                            if (i18 != 0) {
                                fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                            } else {
                                fM982getFrontLayerElevationD9Ej5fM = f3;
                            }
                            if ((i3 & 16384) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i21 &= -57345;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i3 & 32768) != 0) {
                                jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                                i21 &= -458753;
                            } else {
                                jM1069contentColorForek8zF_U2 = j4;
                            }
                            if ((i3 & 65536) != 0) {
                                frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                                i21 = (-3670017) & i21;
                            } else {
                                frontLayerScrimColor = j5;
                            }
                            if (i19 != 0) {
                                interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                            } else {
                                interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                            }
                            f4 = fM984getPeekHeightD9Ej5fM;
                            z7 = z4;
                            z8 = z5;
                            j6 = jM1051getPrimary0d7_KjU;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                        }
                        float fMo333toPx0680j_13 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                        fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                        ComposableLambda composableLambda9 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                        Float fValueOf9 = Float.valueOf(fMo333toPx0680j_4);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(fValueOf9);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i316 = i21;
                        float f114 = fM983getHeaderHeightD9Ej5fM;
                        float f115 = f4;
                        Modifier modifier13 = modifier3;
                        composer2 = composerStartRestartGroup;
                        int i317 = i316 << 6;
                        SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda9, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_13, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i316, f114, f115, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i317 & 7168) | (i317 & 896) | 1572864, 51);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier13;
                        backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                        z9 = z7;
                        z10 = z8;
                        z11 = z6;
                        j7 = j6;
                        j8 = jM1069contentColorForek8zF_U;
                        shape3 = frontLayerShape;
                        f5 = fM982getFrontLayerElevationD9Ej5fM;
                        j9 = jM1055getSurface0d7_KjU;
                        j10 = jM1069contentColorForek8zF_U2;
                        j11 = frontLayerScrimColor;
                        interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                        f6 = f114;
                        f7 = f115;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new BackdropScaffoldKt$BackdropScaffold$2(interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, modifier4, backdropScaffoldState2, z9, f7, f6, z10, z11, j7, j8, shape3, f5, j9, j10, j11, interfaceC0552Gp3, i, i2, i3));
                }
                i17 |= 3072;
                if ((i2 & 57344) != 0) {
                    if ((i3 & 16384) == 0) {
                        i5 = 16384;
                    }
                    i17 |= i5;
                }
                if ((458752 & i2) != 0) {
                    if ((i3 & 32768) == 0) {
                        i24 = 65536;
                    } else {
                        i24 = 65536;
                    }
                    i17 |= i24;
                }
                if ((3670016 & i2) != 0) {
                    if ((i3 & 65536) == 0) {
                        i23 = 524288;
                    } else {
                        i23 = 524288;
                    }
                    i17 |= i23;
                }
                i19 = i3 & 131072;
                if (i19 != 0) {
                    i17 |= 12582912;
                    interfaceC0552Gp2 = interfaceC0552Gp;
                } else {
                    interfaceC0552Gp2 = interfaceC0552Gp;
                    if ((i2 & 29360128) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                            i20 = 8388608;
                        } else {
                            i20 = 4194304;
                        }
                        i17 |= i20;
                    }
                }
                i21 = i17;
                if ((i15 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i29 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i3 & 16) != 0) {
                            i15 &= -57345;
                            backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                        } else {
                            fM983getHeaderHeightD9Ej5fM = f2;
                        }
                        if (i12 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i14 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 1024) != 0) {
                            i22 = 6;
                            i21 &= -15;
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        } else {
                            i22 = 6;
                            jM1051getPrimary0d7_KjU = j;
                        }
                        if ((i3 & 2048) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                            i21 &= -113;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 4096) != 0) {
                            frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                            i21 &= -897;
                        } else {
                            frontLayerShape = shape;
                        }
                        if (i18 != 0) {
                            fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                        } else {
                            fM982getFrontLayerElevationD9Ej5fM = f3;
                        }
                        if ((i3 & 16384) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i21 &= -57345;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                            i21 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U2 = j4;
                        }
                        if ((i3 & 65536) != 0) {
                            frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                            i21 = (-3670017) & i21;
                        } else {
                            frontLayerScrimColor = j5;
                        }
                        if (i19 != 0) {
                            interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                        }
                        f4 = fM984getPeekHeightD9Ej5fM;
                        z7 = z4;
                        z8 = z5;
                        j6 = jM1051getPrimary0d7_KjU;
                    } else {
                        if (i29 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i3 & 16) != 0) {
                            i15 &= -57345;
                            backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                        } else {
                            fM983getHeaderHeightD9Ej5fM = f2;
                        }
                        if (i12 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i14 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 1024) != 0) {
                            i22 = 6;
                            i21 &= -15;
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        } else {
                            i22 = 6;
                            jM1051getPrimary0d7_KjU = j;
                        }
                        if ((i3 & 2048) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                            i21 &= -113;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 4096) != 0) {
                            frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                            i21 &= -897;
                        } else {
                            frontLayerShape = shape;
                        }
                        if (i18 != 0) {
                            fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                        } else {
                            fM982getFrontLayerElevationD9Ej5fM = f3;
                        }
                        if ((i3 & 16384) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i21 &= -57345;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                            i21 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U2 = j4;
                        }
                        if ((i3 & 65536) != 0) {
                            frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                            i21 = (-3670017) & i21;
                        } else {
                            frontLayerScrimColor = j5;
                        }
                        if (i19 != 0) {
                            interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                        }
                        f4 = fM984getPeekHeightD9Ej5fM;
                        z7 = z4;
                        z8 = z5;
                        j6 = jM1051getPrimary0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                    }
                    float fMo333toPx0680j_14 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                    fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                    ComposableLambda composableLambda10 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                    Float fValueOf10 = Float.valueOf(fMo333toPx0680j_4);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(fValueOf10);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i318 = i21;
                    float f116 = fM983getHeaderHeightD9Ej5fM;
                    float f117 = f4;
                    Modifier modifier14 = modifier3;
                    composer2 = composerStartRestartGroup;
                    int i319 = i318 << 6;
                    SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda10, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_14, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i318, f116, f117, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i319 & 7168) | (i319 & 896) | 1572864, 51);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier14;
                    backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                    z9 = z7;
                    z10 = z8;
                    z11 = z6;
                    j7 = j6;
                    j8 = jM1069contentColorForek8zF_U;
                    shape3 = frontLayerShape;
                    f5 = fM982getFrontLayerElevationD9Ej5fM;
                    j9 = jM1055getSurface0d7_KjU;
                    j10 = jM1069contentColorForek8zF_U2;
                    j11 = frontLayerScrimColor;
                    interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                    f6 = f116;
                    f7 = f117;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i29 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i3 & 16) != 0) {
                            i15 &= -57345;
                            backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                        } else {
                            fM983getHeaderHeightD9Ej5fM = f2;
                        }
                        if (i12 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i14 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 1024) != 0) {
                            i22 = 6;
                            i21 &= -15;
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        } else {
                            i22 = 6;
                            jM1051getPrimary0d7_KjU = j;
                        }
                        if ((i3 & 2048) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                            i21 &= -113;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 4096) != 0) {
                            frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                            i21 &= -897;
                        } else {
                            frontLayerShape = shape;
                        }
                        if (i18 != 0) {
                            fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                        } else {
                            fM982getFrontLayerElevationD9Ej5fM = f3;
                        }
                        if ((i3 & 16384) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i21 &= -57345;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                            i21 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U2 = j4;
                        }
                        if ((i3 & 65536) != 0) {
                            frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                            i21 = (-3670017) & i21;
                        } else {
                            frontLayerScrimColor = j5;
                        }
                        if (i19 != 0) {
                            interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                        }
                        f4 = fM984getPeekHeightD9Ej5fM;
                        z7 = z4;
                        z8 = z5;
                        j6 = jM1051getPrimary0d7_KjU;
                    } else {
                        if (i29 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i3 & 16) != 0) {
                            i15 &= -57345;
                            backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                        } else {
                            fM983getHeaderHeightD9Ej5fM = f2;
                        }
                        if (i12 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i14 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 1024) != 0) {
                            i22 = 6;
                            i21 &= -15;
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        } else {
                            i22 = 6;
                            jM1051getPrimary0d7_KjU = j;
                        }
                        if ((i3 & 2048) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                            i21 &= -113;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 4096) != 0) {
                            frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                            i21 &= -897;
                        } else {
                            frontLayerShape = shape;
                        }
                        if (i18 != 0) {
                            fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                        } else {
                            fM982getFrontLayerElevationD9Ej5fM = f3;
                        }
                        if ((i3 & 16384) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i21 &= -57345;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                            i21 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U2 = j4;
                        }
                        if ((i3 & 65536) != 0) {
                            frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                            i21 = (-3670017) & i21;
                        } else {
                            frontLayerScrimColor = j5;
                        }
                        if (i19 != 0) {
                            interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                        }
                        f4 = fM984getPeekHeightD9Ej5fM;
                        z7 = z4;
                        z8 = z5;
                        j6 = jM1051getPrimary0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                    }
                    float fMo333toPx0680j_15 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                    fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                    ComposableLambda composableLambda11 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                    Float fValueOf11 = Float.valueOf(fMo333toPx0680j_4);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(fValueOf11);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i3110 = i21;
                    float f118 = fM983getHeaderHeightD9Ej5fM;
                    float f119 = f4;
                    Modifier modifier15 = modifier3;
                    composer2 = composerStartRestartGroup;
                    int i3111 = i3110 << 6;
                    SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda11, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_15, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i3110, f118, f119, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i3111 & 7168) | (i3111 & 896) | 1572864, 51);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier15;
                    backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                    z9 = z7;
                    z10 = z8;
                    z11 = z6;
                    j7 = j6;
                    j8 = jM1069contentColorForek8zF_U;
                    shape3 = frontLayerShape;
                    f5 = fM982getFrontLayerElevationD9Ej5fM;
                    j9 = jM1055getSurface0d7_KjU;
                    j10 = jM1069contentColorForek8zF_U2;
                    j11 = frontLayerScrimColor;
                    interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                    f6 = f118;
                    f7 = f119;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new BackdropScaffoldKt$BackdropScaffold$2(interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, modifier4, backdropScaffoldState2, z9, f7, f6, z10, z11, j7, j8, shape3, f5, j9, j10, j11, interfaceC0552Gp3, i, i2, i3));
            }
            i4 |= 100663296;
            i14 = i3 & 512;
            if (i14 != 0) {
                i15 = i4 | 805306368;
                i14 = i14;
            } else {
                if ((i & 1879048192) != 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i16 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i16 = 268435456;
                    }
                    i4 |= i16;
                }
                i15 = i4;
            }
            if ((i2 & 14) == 0) {
                if ((i3 & 1024) == 0) {
                    i27 = 2;
                } else {
                    i27 = 2;
                }
                i17 = i2 | i27;
            } else {
                i17 = i2;
            }
            if ((i2 & 112) != 0) {
                if ((i3 & 2048) == 0) {
                    i26 = 16;
                } else {
                    i26 = 16;
                }
                i17 |= i26;
            }
            if ((i2 & 896) == 0) {
                shape2 = shape;
                if ((i3 & 4096) == 0) {
                    i25 = 128;
                } else {
                    i25 = 128;
                }
                i17 |= i25;
            } else {
                shape2 = shape;
            }
            i18 = i3 & 8192;
            if (i18 != 0) {
                if ((i2 & 7168) == 0) {
                    i17 |= composerStartRestartGroup.changed(f3) ? 2048 : 1024;
                }
                if ((i2 & 57344) != 0) {
                    if ((i3 & 16384) == 0) {
                        i5 = 16384;
                    }
                    i17 |= i5;
                }
                if ((458752 & i2) != 0) {
                    if ((i3 & 32768) == 0) {
                        i24 = 65536;
                    } else {
                        i24 = 65536;
                    }
                    i17 |= i24;
                }
                if ((3670016 & i2) != 0) {
                    if ((i3 & 65536) == 0) {
                        i23 = 524288;
                    } else {
                        i23 = 524288;
                    }
                    i17 |= i23;
                }
                i19 = i3 & 131072;
                if (i19 != 0) {
                    i17 |= 12582912;
                    interfaceC0552Gp2 = interfaceC0552Gp;
                } else {
                    interfaceC0552Gp2 = interfaceC0552Gp;
                    if ((i2 & 29360128) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                            i20 = 8388608;
                        } else {
                            i20 = 4194304;
                        }
                        i17 |= i20;
                    }
                }
                i21 = i17;
                if ((i15 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i29 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i3 & 16) != 0) {
                            i15 &= -57345;
                            backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                        } else {
                            fM983getHeaderHeightD9Ej5fM = f2;
                        }
                        if (i12 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i14 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 1024) != 0) {
                            i22 = 6;
                            i21 &= -15;
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        } else {
                            i22 = 6;
                            jM1051getPrimary0d7_KjU = j;
                        }
                        if ((i3 & 2048) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                            i21 &= -113;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 4096) != 0) {
                            frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                            i21 &= -897;
                        } else {
                            frontLayerShape = shape;
                        }
                        if (i18 != 0) {
                            fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                        } else {
                            fM982getFrontLayerElevationD9Ej5fM = f3;
                        }
                        if ((i3 & 16384) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i21 &= -57345;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                            i21 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U2 = j4;
                        }
                        if ((i3 & 65536) != 0) {
                            frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                            i21 = (-3670017) & i21;
                        } else {
                            frontLayerScrimColor = j5;
                        }
                        if (i19 != 0) {
                            interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                        }
                        f4 = fM984getPeekHeightD9Ej5fM;
                        z7 = z4;
                        z8 = z5;
                        j6 = jM1051getPrimary0d7_KjU;
                    } else {
                        if (i29 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i3 & 16) != 0) {
                            i15 &= -57345;
                            backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                        } else {
                            fM983getHeaderHeightD9Ej5fM = f2;
                        }
                        if (i12 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i14 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 1024) != 0) {
                            i22 = 6;
                            i21 &= -15;
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        } else {
                            i22 = 6;
                            jM1051getPrimary0d7_KjU = j;
                        }
                        if ((i3 & 2048) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                            i21 &= -113;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 4096) != 0) {
                            frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                            i21 &= -897;
                        } else {
                            frontLayerShape = shape;
                        }
                        if (i18 != 0) {
                            fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                        } else {
                            fM982getFrontLayerElevationD9Ej5fM = f3;
                        }
                        if ((i3 & 16384) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i21 &= -57345;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                            i21 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U2 = j4;
                        }
                        if ((i3 & 65536) != 0) {
                            frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                            i21 = (-3670017) & i21;
                        } else {
                            frontLayerScrimColor = j5;
                        }
                        if (i19 != 0) {
                            interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                        }
                        f4 = fM984getPeekHeightD9Ej5fM;
                        z7 = z4;
                        z8 = z5;
                        j6 = jM1051getPrimary0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                    }
                    float fMo333toPx0680j_16 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                    fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                    ComposableLambda composableLambda12 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                    Float fValueOf12 = Float.valueOf(fMo333toPx0680j_4);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(fValueOf12);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i3112 = i21;
                    float f1110 = fM983getHeaderHeightD9Ej5fM;
                    float f1111 = f4;
                    Modifier modifier16 = modifier3;
                    composer2 = composerStartRestartGroup;
                    int i3113 = i3112 << 6;
                    SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda12, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_16, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i3112, f1110, f1111, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i3113 & 7168) | (i3113 & 896) | 1572864, 51);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier16;
                    backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                    z9 = z7;
                    z10 = z8;
                    z11 = z6;
                    j7 = j6;
                    j8 = jM1069contentColorForek8zF_U;
                    shape3 = frontLayerShape;
                    f5 = fM982getFrontLayerElevationD9Ej5fM;
                    j9 = jM1055getSurface0d7_KjU;
                    j10 = jM1069contentColorForek8zF_U2;
                    j11 = frontLayerScrimColor;
                    interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                    f6 = f1110;
                    f7 = f1111;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i29 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i3 & 16) != 0) {
                            i15 &= -57345;
                            backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                        } else {
                            fM983getHeaderHeightD9Ej5fM = f2;
                        }
                        if (i12 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i14 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 1024) != 0) {
                            i22 = 6;
                            i21 &= -15;
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        } else {
                            i22 = 6;
                            jM1051getPrimary0d7_KjU = j;
                        }
                        if ((i3 & 2048) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                            i21 &= -113;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 4096) != 0) {
                            frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                            i21 &= -897;
                        } else {
                            frontLayerShape = shape;
                        }
                        if (i18 != 0) {
                            fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                        } else {
                            fM982getFrontLayerElevationD9Ej5fM = f3;
                        }
                        if ((i3 & 16384) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i21 &= -57345;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                            i21 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U2 = j4;
                        }
                        if ((i3 & 65536) != 0) {
                            frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                            i21 = (-3670017) & i21;
                        } else {
                            frontLayerScrimColor = j5;
                        }
                        if (i19 != 0) {
                            interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                        }
                        f4 = fM984getPeekHeightD9Ej5fM;
                        z7 = z4;
                        z8 = z5;
                        j6 = jM1051getPrimary0d7_KjU;
                    } else {
                        if (i29 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i3 & 16) != 0) {
                            i15 &= -57345;
                            backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                        } else {
                            fM983getHeaderHeightD9Ej5fM = f2;
                        }
                        if (i12 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i14 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 1024) != 0) {
                            i22 = 6;
                            i21 &= -15;
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        } else {
                            i22 = 6;
                            jM1051getPrimary0d7_KjU = j;
                        }
                        if ((i3 & 2048) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                            i21 &= -113;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 4096) != 0) {
                            frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                            i21 &= -897;
                        } else {
                            frontLayerShape = shape;
                        }
                        if (i18 != 0) {
                            fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                        } else {
                            fM982getFrontLayerElevationD9Ej5fM = f3;
                        }
                        if ((i3 & 16384) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i21 &= -57345;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                            i21 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U2 = j4;
                        }
                        if ((i3 & 65536) != 0) {
                            frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                            i21 = (-3670017) & i21;
                        } else {
                            frontLayerScrimColor = j5;
                        }
                        if (i19 != 0) {
                            interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                        }
                        f4 = fM984getPeekHeightD9Ej5fM;
                        z7 = z4;
                        z8 = z5;
                        j6 = jM1051getPrimary0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                    }
                    float fMo333toPx0680j_17 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                    fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                    ComposableLambda composableLambda13 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                    Float fValueOf13 = Float.valueOf(fMo333toPx0680j_4);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(fValueOf13);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i3114 = i21;
                    float f1112 = fM983getHeaderHeightD9Ej5fM;
                    float f1113 = f4;
                    Modifier modifier17 = modifier3;
                    composer2 = composerStartRestartGroup;
                    int i3115 = i3114 << 6;
                    SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda13, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_17, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i3114, f1112, f1113, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i3115 & 7168) | (i3115 & 896) | 1572864, 51);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier17;
                    backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                    z9 = z7;
                    z10 = z8;
                    z11 = z6;
                    j7 = j6;
                    j8 = jM1069contentColorForek8zF_U;
                    shape3 = frontLayerShape;
                    f5 = fM982getFrontLayerElevationD9Ej5fM;
                    j9 = jM1055getSurface0d7_KjU;
                    j10 = jM1069contentColorForek8zF_U2;
                    j11 = frontLayerScrimColor;
                    interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                    f6 = f1112;
                    f7 = f1113;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new BackdropScaffoldKt$BackdropScaffold$2(interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, modifier4, backdropScaffoldState2, z9, f7, f6, z10, z11, j7, j8, shape3, f5, j9, j10, j11, interfaceC0552Gp3, i, i2, i3));
            }
            i17 |= 3072;
            if ((i2 & 57344) != 0) {
                if ((i3 & 16384) == 0) {
                    i5 = 16384;
                }
                i17 |= i5;
            }
            if ((458752 & i2) != 0) {
                if ((i3 & 32768) == 0) {
                    i24 = 65536;
                } else {
                    i24 = 65536;
                }
                i17 |= i24;
            }
            if ((3670016 & i2) != 0) {
                if ((i3 & 65536) == 0) {
                    i23 = 524288;
                } else {
                    i23 = 524288;
                }
                i17 |= i23;
            }
            i19 = i3 & 131072;
            if (i19 != 0) {
                i17 |= 12582912;
                interfaceC0552Gp2 = interfaceC0552Gp;
            } else {
                interfaceC0552Gp2 = interfaceC0552Gp;
                if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                        i20 = 8388608;
                    } else {
                        i20 = 4194304;
                    }
                    i17 |= i20;
                }
            }
            i21 = i17;
            if ((i15 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i29 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i3 & 16) != 0) {
                        i15 &= -57345;
                        backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                    }
                    if (i10 != 0) {
                        fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                    } else {
                        fM983getHeaderHeightD9Ej5fM = f2;
                    }
                    if (i12 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i14 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if ((i3 & 1024) != 0) {
                        i22 = 6;
                        i21 &= -15;
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    } else {
                        i22 = 6;
                        jM1051getPrimary0d7_KjU = j;
                    }
                    if ((i3 & 2048) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                        i21 &= -113;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i3 & 4096) != 0) {
                        frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                        i21 &= -897;
                    } else {
                        frontLayerShape = shape;
                    }
                    if (i18 != 0) {
                        fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                    } else {
                        fM982getFrontLayerElevationD9Ej5fM = f3;
                    }
                    if ((i3 & 16384) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i21 &= -57345;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i3 & 32768) != 0) {
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                        i21 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U2 = j4;
                    }
                    if ((i3 & 65536) != 0) {
                        frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                        i21 = (-3670017) & i21;
                    } else {
                        frontLayerScrimColor = j5;
                    }
                    if (i19 != 0) {
                        interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                    }
                    f4 = fM984getPeekHeightD9Ej5fM;
                    z7 = z4;
                    z8 = z5;
                    j6 = jM1051getPrimary0d7_KjU;
                } else {
                    if (i29 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i3 & 16) != 0) {
                        i15 &= -57345;
                        backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                    }
                    if (i10 != 0) {
                        fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                    } else {
                        fM983getHeaderHeightD9Ej5fM = f2;
                    }
                    if (i12 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i14 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if ((i3 & 1024) != 0) {
                        i22 = 6;
                        i21 &= -15;
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    } else {
                        i22 = 6;
                        jM1051getPrimary0d7_KjU = j;
                    }
                    if ((i3 & 2048) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                        i21 &= -113;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i3 & 4096) != 0) {
                        frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                        i21 &= -897;
                    } else {
                        frontLayerShape = shape;
                    }
                    if (i18 != 0) {
                        fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                    } else {
                        fM982getFrontLayerElevationD9Ej5fM = f3;
                    }
                    if ((i3 & 16384) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i21 &= -57345;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i3 & 32768) != 0) {
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                        i21 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U2 = j4;
                    }
                    if ((i3 & 65536) != 0) {
                        frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                        i21 = (-3670017) & i21;
                    } else {
                        frontLayerScrimColor = j5;
                    }
                    if (i19 != 0) {
                        interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                    }
                    f4 = fM984getPeekHeightD9Ej5fM;
                    z7 = z4;
                    z8 = z5;
                    j6 = jM1051getPrimary0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                }
                float fMo333toPx0680j_18 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                ComposableLambda composableLambda14 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                Float fValueOf14 = Float.valueOf(fMo333toPx0680j_4);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(fValueOf14);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i3116 = i21;
                float f1114 = fM983getHeaderHeightD9Ej5fM;
                float f1115 = f4;
                Modifier modifier18 = modifier3;
                composer2 = composerStartRestartGroup;
                int i3117 = i3116 << 6;
                SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda14, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_18, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i3116, f1114, f1115, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i3117 & 7168) | (i3117 & 896) | 1572864, 51);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier18;
                backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                z9 = z7;
                z10 = z8;
                z11 = z6;
                j7 = j6;
                j8 = jM1069contentColorForek8zF_U;
                shape3 = frontLayerShape;
                f5 = fM982getFrontLayerElevationD9Ej5fM;
                j9 = jM1055getSurface0d7_KjU;
                j10 = jM1069contentColorForek8zF_U2;
                j11 = frontLayerScrimColor;
                interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                f6 = f1114;
                f7 = f1115;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i29 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i3 & 16) != 0) {
                        i15 &= -57345;
                        backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                    }
                    if (i10 != 0) {
                        fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                    } else {
                        fM983getHeaderHeightD9Ej5fM = f2;
                    }
                    if (i12 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i14 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if ((i3 & 1024) != 0) {
                        i22 = 6;
                        i21 &= -15;
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    } else {
                        i22 = 6;
                        jM1051getPrimary0d7_KjU = j;
                    }
                    if ((i3 & 2048) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                        i21 &= -113;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i3 & 4096) != 0) {
                        frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                        i21 &= -897;
                    } else {
                        frontLayerShape = shape;
                    }
                    if (i18 != 0) {
                        fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                    } else {
                        fM982getFrontLayerElevationD9Ej5fM = f3;
                    }
                    if ((i3 & 16384) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i21 &= -57345;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i3 & 32768) != 0) {
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                        i21 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U2 = j4;
                    }
                    if ((i3 & 65536) != 0) {
                        frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                        i21 = (-3670017) & i21;
                    } else {
                        frontLayerScrimColor = j5;
                    }
                    if (i19 != 0) {
                        interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                    }
                    f4 = fM984getPeekHeightD9Ej5fM;
                    z7 = z4;
                    z8 = z5;
                    j6 = jM1051getPrimary0d7_KjU;
                } else {
                    if (i29 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i3 & 16) != 0) {
                        i15 &= -57345;
                        backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                    }
                    if (i10 != 0) {
                        fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                    } else {
                        fM983getHeaderHeightD9Ej5fM = f2;
                    }
                    if (i12 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i14 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if ((i3 & 1024) != 0) {
                        i22 = 6;
                        i21 &= -15;
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    } else {
                        i22 = 6;
                        jM1051getPrimary0d7_KjU = j;
                    }
                    if ((i3 & 2048) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                        i21 &= -113;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i3 & 4096) != 0) {
                        frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                        i21 &= -897;
                    } else {
                        frontLayerShape = shape;
                    }
                    if (i18 != 0) {
                        fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                    } else {
                        fM982getFrontLayerElevationD9Ej5fM = f3;
                    }
                    if ((i3 & 16384) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i21 &= -57345;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i3 & 32768) != 0) {
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                        i21 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U2 = j4;
                    }
                    if ((i3 & 65536) != 0) {
                        frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                        i21 = (-3670017) & i21;
                    } else {
                        frontLayerScrimColor = j5;
                    }
                    if (i19 != 0) {
                        interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                    }
                    f4 = fM984getPeekHeightD9Ej5fM;
                    z7 = z4;
                    z8 = z5;
                    j6 = jM1051getPrimary0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                }
                float fMo333toPx0680j_19 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                ComposableLambda composableLambda15 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                Float fValueOf15 = Float.valueOf(fMo333toPx0680j_4);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(fValueOf15);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i3118 = i21;
                float f1116 = fM983getHeaderHeightD9Ej5fM;
                float f1117 = f4;
                Modifier modifier19 = modifier3;
                composer2 = composerStartRestartGroup;
                int i3119 = i3118 << 6;
                SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda15, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_19, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i3118, f1116, f1117, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i3119 & 7168) | (i3119 & 896) | 1572864, 51);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier19;
                backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                z9 = z7;
                z10 = z8;
                z11 = z6;
                j7 = j6;
                j8 = jM1069contentColorForek8zF_U;
                shape3 = frontLayerShape;
                f5 = fM982getFrontLayerElevationD9Ej5fM;
                j9 = jM1055getSurface0d7_KjU;
                j10 = jM1069contentColorForek8zF_U2;
                j11 = frontLayerScrimColor;
                interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                f6 = f1116;
                f7 = f1117;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new BackdropScaffoldKt$BackdropScaffold$2(interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, modifier4, backdropScaffoldState2, z9, f7, f6, z10, z11, j7, j8, shape3, f5, j9, j10, j11, interfaceC0552Gp3, i, i2, i3));
        }
        i4 |= 3072;
        modifier2 = modifier;
        i5 = 8192;
        if ((i & 57344) == 0) {
            backdropScaffoldStateRememberBackdropScaffoldState = backdropScaffoldState;
            if ((i3 & 16) == 0) {
                i28 = 8192;
            } else {
                i28 = 8192;
            }
            i4 |= i28;
        } else {
            backdropScaffoldStateRememberBackdropScaffoldState = backdropScaffoldState;
        }
        i6 = i3 & 32;
        if (i6 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & 458752) == 0) {
            if (composerStartRestartGroup.changed(z)) {
                i7 = 131072;
            } else {
                i7 = 65536;
            }
            i4 |= i7;
        }
        i8 = i3 & 64;
        if (i8 != 0) {
            i4 |= 1572864;
            fM984getPeekHeightD9Ej5fM = f;
        } else {
            fM984getPeekHeightD9Ej5fM = f;
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(fM984getPeekHeightD9Ej5fM)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i4 |= i9;
            }
        }
        i10 = i3 & 128;
        if (i10 != 0) {
            if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i4 |= i11;
            }
            i12 = i3 & 256;
            if (i12 != 0) {
                if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i4 |= i13;
                }
                i14 = i3 & 512;
                if (i14 != 0) {
                    i15 = i4 | 805306368;
                    i14 = i14;
                } else {
                    if ((i & 1879048192) != 0) {
                        if (composerStartRestartGroup.changed(z3)) {
                            i16 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i16 = 268435456;
                        }
                        i4 |= i16;
                    }
                    i15 = i4;
                }
                if ((i2 & 14) == 0) {
                    if ((i3 & 1024) == 0) {
                        i27 = 2;
                    } else {
                        i27 = 2;
                    }
                    i17 = i2 | i27;
                } else {
                    i17 = i2;
                }
                if ((i2 & 112) != 0) {
                    if ((i3 & 2048) == 0) {
                        i26 = 16;
                    } else {
                        i26 = 16;
                    }
                    i17 |= i26;
                }
                if ((i2 & 896) == 0) {
                    shape2 = shape;
                    if ((i3 & 4096) == 0) {
                        i25 = 128;
                    } else {
                        i25 = 128;
                    }
                    i17 |= i25;
                } else {
                    shape2 = shape;
                }
                i18 = i3 & 8192;
                if (i18 != 0) {
                    if ((i2 & 7168) == 0) {
                        i17 |= composerStartRestartGroup.changed(f3) ? 2048 : 1024;
                    }
                    if ((i2 & 57344) != 0) {
                        if ((i3 & 16384) == 0) {
                            i5 = 16384;
                        }
                        i17 |= i5;
                    }
                    if ((458752 & i2) != 0) {
                        if ((i3 & 32768) == 0) {
                            i24 = 65536;
                        } else {
                            i24 = 65536;
                        }
                        i17 |= i24;
                    }
                    if ((3670016 & i2) != 0) {
                        if ((i3 & 65536) == 0) {
                            i23 = 524288;
                        } else {
                            i23 = 524288;
                        }
                        i17 |= i23;
                    }
                    i19 = i3 & 131072;
                    if (i19 != 0) {
                        i17 |= 12582912;
                        interfaceC0552Gp2 = interfaceC0552Gp;
                    } else {
                        interfaceC0552Gp2 = interfaceC0552Gp;
                        if ((i2 & 29360128) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                                i20 = 8388608;
                            } else {
                                i20 = 4194304;
                            }
                            i17 |= i20;
                        }
                    }
                    i21 = i17;
                    if ((i15 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i29 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i3 & 16) != 0) {
                                i15 &= -57345;
                                backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i8 != 0) {
                                fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                            }
                            if (i10 != 0) {
                                fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                            } else {
                                fM983getHeaderHeightD9Ej5fM = f2;
                            }
                            if (i12 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i14 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if ((i3 & 1024) != 0) {
                                i22 = 6;
                                i21 &= -15;
                                jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                            } else {
                                i22 = 6;
                                jM1051getPrimary0d7_KjU = j;
                            }
                            if ((i3 & 2048) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                                i21 &= -113;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if ((i3 & 4096) != 0) {
                                frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                                i21 &= -897;
                            } else {
                                frontLayerShape = shape;
                            }
                            if (i18 != 0) {
                                fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                            } else {
                                fM982getFrontLayerElevationD9Ej5fM = f3;
                            }
                            if ((i3 & 16384) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i21 &= -57345;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i3 & 32768) != 0) {
                                jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                                i21 &= -458753;
                            } else {
                                jM1069contentColorForek8zF_U2 = j4;
                            }
                            if ((i3 & 65536) != 0) {
                                frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                                i21 = (-3670017) & i21;
                            } else {
                                frontLayerScrimColor = j5;
                            }
                            if (i19 != 0) {
                                interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                            } else {
                                interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                            }
                            f4 = fM984getPeekHeightD9Ej5fM;
                            z7 = z4;
                            z8 = z5;
                            j6 = jM1051getPrimary0d7_KjU;
                        } else {
                            if (i29 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i3 & 16) != 0) {
                                i15 &= -57345;
                                backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i8 != 0) {
                                fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                            }
                            if (i10 != 0) {
                                fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                            } else {
                                fM983getHeaderHeightD9Ej5fM = f2;
                            }
                            if (i12 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i14 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if ((i3 & 1024) != 0) {
                                i22 = 6;
                                i21 &= -15;
                                jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                            } else {
                                i22 = 6;
                                jM1051getPrimary0d7_KjU = j;
                            }
                            if ((i3 & 2048) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                                i21 &= -113;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if ((i3 & 4096) != 0) {
                                frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                                i21 &= -897;
                            } else {
                                frontLayerShape = shape;
                            }
                            if (i18 != 0) {
                                fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                            } else {
                                fM982getFrontLayerElevationD9Ej5fM = f3;
                            }
                            if ((i3 & 16384) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i21 &= -57345;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i3 & 32768) != 0) {
                                jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                                i21 &= -458753;
                            } else {
                                jM1069contentColorForek8zF_U2 = j4;
                            }
                            if ((i3 & 65536) != 0) {
                                frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                                i21 = (-3670017) & i21;
                            } else {
                                frontLayerScrimColor = j5;
                            }
                            if (i19 != 0) {
                                interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                            } else {
                                interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                            }
                            f4 = fM984getPeekHeightD9Ej5fM;
                            z7 = z4;
                            z8 = z5;
                            j6 = jM1051getPrimary0d7_KjU;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                        }
                        float fMo333toPx0680j_110 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                        fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                        ComposableLambda composableLambda16 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                        Float fValueOf16 = Float.valueOf(fMo333toPx0680j_4);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(fValueOf16);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i31110 = i21;
                        float f1118 = fM983getHeaderHeightD9Ej5fM;
                        float f1119 = f4;
                        Modifier modifier110 = modifier3;
                        composer2 = composerStartRestartGroup;
                        int i31111 = i31110 << 6;
                        SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda16, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_110, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i31110, f1118, f1119, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i31111 & 7168) | (i31111 & 896) | 1572864, 51);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier110;
                        backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                        z9 = z7;
                        z10 = z8;
                        z11 = z6;
                        j7 = j6;
                        j8 = jM1069contentColorForek8zF_U;
                        shape3 = frontLayerShape;
                        f5 = fM982getFrontLayerElevationD9Ej5fM;
                        j9 = jM1055getSurface0d7_KjU;
                        j10 = jM1069contentColorForek8zF_U2;
                        j11 = frontLayerScrimColor;
                        interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                        f6 = f1118;
                        f7 = f1119;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i29 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i3 & 16) != 0) {
                                i15 &= -57345;
                                backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i8 != 0) {
                                fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                            }
                            if (i10 != 0) {
                                fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                            } else {
                                fM983getHeaderHeightD9Ej5fM = f2;
                            }
                            if (i12 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i14 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if ((i3 & 1024) != 0) {
                                i22 = 6;
                                i21 &= -15;
                                jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                            } else {
                                i22 = 6;
                                jM1051getPrimary0d7_KjU = j;
                            }
                            if ((i3 & 2048) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                                i21 &= -113;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if ((i3 & 4096) != 0) {
                                frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                                i21 &= -897;
                            } else {
                                frontLayerShape = shape;
                            }
                            if (i18 != 0) {
                                fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                            } else {
                                fM982getFrontLayerElevationD9Ej5fM = f3;
                            }
                            if ((i3 & 16384) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i21 &= -57345;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i3 & 32768) != 0) {
                                jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                                i21 &= -458753;
                            } else {
                                jM1069contentColorForek8zF_U2 = j4;
                            }
                            if ((i3 & 65536) != 0) {
                                frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                                i21 = (-3670017) & i21;
                            } else {
                                frontLayerScrimColor = j5;
                            }
                            if (i19 != 0) {
                                interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                            } else {
                                interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                            }
                            f4 = fM984getPeekHeightD9Ej5fM;
                            z7 = z4;
                            z8 = z5;
                            j6 = jM1051getPrimary0d7_KjU;
                        } else {
                            if (i29 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i3 & 16) != 0) {
                                i15 &= -57345;
                                backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i8 != 0) {
                                fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                            }
                            if (i10 != 0) {
                                fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                            } else {
                                fM983getHeaderHeightD9Ej5fM = f2;
                            }
                            if (i12 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i14 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if ((i3 & 1024) != 0) {
                                i22 = 6;
                                i21 &= -15;
                                jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                            } else {
                                i22 = 6;
                                jM1051getPrimary0d7_KjU = j;
                            }
                            if ((i3 & 2048) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                                i21 &= -113;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if ((i3 & 4096) != 0) {
                                frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                                i21 &= -897;
                            } else {
                                frontLayerShape = shape;
                            }
                            if (i18 != 0) {
                                fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                            } else {
                                fM982getFrontLayerElevationD9Ej5fM = f3;
                            }
                            if ((i3 & 16384) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i21 &= -57345;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i3 & 32768) != 0) {
                                jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                                i21 &= -458753;
                            } else {
                                jM1069contentColorForek8zF_U2 = j4;
                            }
                            if ((i3 & 65536) != 0) {
                                frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                                i21 = (-3670017) & i21;
                            } else {
                                frontLayerScrimColor = j5;
                            }
                            if (i19 != 0) {
                                interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                            } else {
                                interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                            }
                            f4 = fM984getPeekHeightD9Ej5fM;
                            z7 = z4;
                            z8 = z5;
                            j6 = jM1051getPrimary0d7_KjU;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                        }
                        float fMo333toPx0680j_111 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                        fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                        ComposableLambda composableLambda17 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                        Float fValueOf17 = Float.valueOf(fMo333toPx0680j_4);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(fValueOf17);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i31112 = i21;
                        float f11110 = fM983getHeaderHeightD9Ej5fM;
                        float f11111 = f4;
                        Modifier modifier111 = modifier3;
                        composer2 = composerStartRestartGroup;
                        int i31113 = i31112 << 6;
                        SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda17, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_111, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i31112, f11110, f11111, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i31113 & 7168) | (i31113 & 896) | 1572864, 51);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier111;
                        backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                        z9 = z7;
                        z10 = z8;
                        z11 = z6;
                        j7 = j6;
                        j8 = jM1069contentColorForek8zF_U;
                        shape3 = frontLayerShape;
                        f5 = fM982getFrontLayerElevationD9Ej5fM;
                        j9 = jM1055getSurface0d7_KjU;
                        j10 = jM1069contentColorForek8zF_U2;
                        j11 = frontLayerScrimColor;
                        interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                        f6 = f11110;
                        f7 = f11111;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new BackdropScaffoldKt$BackdropScaffold$2(interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, modifier4, backdropScaffoldState2, z9, f7, f6, z10, z11, j7, j8, shape3, f5, j9, j10, j11, interfaceC0552Gp3, i, i2, i3));
                }
                i17 |= 3072;
                if ((i2 & 57344) != 0) {
                    if ((i3 & 16384) == 0) {
                        i5 = 16384;
                    }
                    i17 |= i5;
                }
                if ((458752 & i2) != 0) {
                    if ((i3 & 32768) == 0) {
                        i24 = 65536;
                    } else {
                        i24 = 65536;
                    }
                    i17 |= i24;
                }
                if ((3670016 & i2) != 0) {
                    if ((i3 & 65536) == 0) {
                        i23 = 524288;
                    } else {
                        i23 = 524288;
                    }
                    i17 |= i23;
                }
                i19 = i3 & 131072;
                if (i19 != 0) {
                    i17 |= 12582912;
                    interfaceC0552Gp2 = interfaceC0552Gp;
                } else {
                    interfaceC0552Gp2 = interfaceC0552Gp;
                    if ((i2 & 29360128) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                            i20 = 8388608;
                        } else {
                            i20 = 4194304;
                        }
                        i17 |= i20;
                    }
                }
                i21 = i17;
                if ((i15 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i29 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i3 & 16) != 0) {
                            i15 &= -57345;
                            backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                        } else {
                            fM983getHeaderHeightD9Ej5fM = f2;
                        }
                        if (i12 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i14 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 1024) != 0) {
                            i22 = 6;
                            i21 &= -15;
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        } else {
                            i22 = 6;
                            jM1051getPrimary0d7_KjU = j;
                        }
                        if ((i3 & 2048) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                            i21 &= -113;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 4096) != 0) {
                            frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                            i21 &= -897;
                        } else {
                            frontLayerShape = shape;
                        }
                        if (i18 != 0) {
                            fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                        } else {
                            fM982getFrontLayerElevationD9Ej5fM = f3;
                        }
                        if ((i3 & 16384) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i21 &= -57345;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                            i21 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U2 = j4;
                        }
                        if ((i3 & 65536) != 0) {
                            frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                            i21 = (-3670017) & i21;
                        } else {
                            frontLayerScrimColor = j5;
                        }
                        if (i19 != 0) {
                            interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                        }
                        f4 = fM984getPeekHeightD9Ej5fM;
                        z7 = z4;
                        z8 = z5;
                        j6 = jM1051getPrimary0d7_KjU;
                    } else {
                        if (i29 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i3 & 16) != 0) {
                            i15 &= -57345;
                            backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                        } else {
                            fM983getHeaderHeightD9Ej5fM = f2;
                        }
                        if (i12 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i14 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 1024) != 0) {
                            i22 = 6;
                            i21 &= -15;
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        } else {
                            i22 = 6;
                            jM1051getPrimary0d7_KjU = j;
                        }
                        if ((i3 & 2048) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                            i21 &= -113;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 4096) != 0) {
                            frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                            i21 &= -897;
                        } else {
                            frontLayerShape = shape;
                        }
                        if (i18 != 0) {
                            fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                        } else {
                            fM982getFrontLayerElevationD9Ej5fM = f3;
                        }
                        if ((i3 & 16384) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i21 &= -57345;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                            i21 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U2 = j4;
                        }
                        if ((i3 & 65536) != 0) {
                            frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                            i21 = (-3670017) & i21;
                        } else {
                            frontLayerScrimColor = j5;
                        }
                        if (i19 != 0) {
                            interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                        }
                        f4 = fM984getPeekHeightD9Ej5fM;
                        z7 = z4;
                        z8 = z5;
                        j6 = jM1051getPrimary0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                    }
                    float fMo333toPx0680j_112 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                    fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                    ComposableLambda composableLambda18 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                    Float fValueOf18 = Float.valueOf(fMo333toPx0680j_4);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(fValueOf18);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i31114 = i21;
                    float f11112 = fM983getHeaderHeightD9Ej5fM;
                    float f11113 = f4;
                    Modifier modifier112 = modifier3;
                    composer2 = composerStartRestartGroup;
                    int i31115 = i31114 << 6;
                    SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda18, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_112, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i31114, f11112, f11113, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i31115 & 7168) | (i31115 & 896) | 1572864, 51);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier112;
                    backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                    z9 = z7;
                    z10 = z8;
                    z11 = z6;
                    j7 = j6;
                    j8 = jM1069contentColorForek8zF_U;
                    shape3 = frontLayerShape;
                    f5 = fM982getFrontLayerElevationD9Ej5fM;
                    j9 = jM1055getSurface0d7_KjU;
                    j10 = jM1069contentColorForek8zF_U2;
                    j11 = frontLayerScrimColor;
                    interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                    f6 = f11112;
                    f7 = f11113;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i29 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i3 & 16) != 0) {
                            i15 &= -57345;
                            backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                        } else {
                            fM983getHeaderHeightD9Ej5fM = f2;
                        }
                        if (i12 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i14 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 1024) != 0) {
                            i22 = 6;
                            i21 &= -15;
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        } else {
                            i22 = 6;
                            jM1051getPrimary0d7_KjU = j;
                        }
                        if ((i3 & 2048) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                            i21 &= -113;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 4096) != 0) {
                            frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                            i21 &= -897;
                        } else {
                            frontLayerShape = shape;
                        }
                        if (i18 != 0) {
                            fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                        } else {
                            fM982getFrontLayerElevationD9Ej5fM = f3;
                        }
                        if ((i3 & 16384) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i21 &= -57345;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                            i21 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U2 = j4;
                        }
                        if ((i3 & 65536) != 0) {
                            frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                            i21 = (-3670017) & i21;
                        } else {
                            frontLayerScrimColor = j5;
                        }
                        if (i19 != 0) {
                            interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                        }
                        f4 = fM984getPeekHeightD9Ej5fM;
                        z7 = z4;
                        z8 = z5;
                        j6 = jM1051getPrimary0d7_KjU;
                    } else {
                        if (i29 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i3 & 16) != 0) {
                            i15 &= -57345;
                            backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                        } else {
                            fM983getHeaderHeightD9Ej5fM = f2;
                        }
                        if (i12 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i14 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 1024) != 0) {
                            i22 = 6;
                            i21 &= -15;
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        } else {
                            i22 = 6;
                            jM1051getPrimary0d7_KjU = j;
                        }
                        if ((i3 & 2048) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                            i21 &= -113;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 4096) != 0) {
                            frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                            i21 &= -897;
                        } else {
                            frontLayerShape = shape;
                        }
                        if (i18 != 0) {
                            fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                        } else {
                            fM982getFrontLayerElevationD9Ej5fM = f3;
                        }
                        if ((i3 & 16384) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i21 &= -57345;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                            i21 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U2 = j4;
                        }
                        if ((i3 & 65536) != 0) {
                            frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                            i21 = (-3670017) & i21;
                        } else {
                            frontLayerScrimColor = j5;
                        }
                        if (i19 != 0) {
                            interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                        }
                        f4 = fM984getPeekHeightD9Ej5fM;
                        z7 = z4;
                        z8 = z5;
                        j6 = jM1051getPrimary0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                    }
                    float fMo333toPx0680j_113 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                    fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                    ComposableLambda composableLambda19 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                    Float fValueOf19 = Float.valueOf(fMo333toPx0680j_4);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(fValueOf19);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i31116 = i21;
                    float f11114 = fM983getHeaderHeightD9Ej5fM;
                    float f11115 = f4;
                    Modifier modifier113 = modifier3;
                    composer2 = composerStartRestartGroup;
                    int i31117 = i31116 << 6;
                    SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda19, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_113, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i31116, f11114, f11115, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i31117 & 7168) | (i31117 & 896) | 1572864, 51);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier113;
                    backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                    z9 = z7;
                    z10 = z8;
                    z11 = z6;
                    j7 = j6;
                    j8 = jM1069contentColorForek8zF_U;
                    shape3 = frontLayerShape;
                    f5 = fM982getFrontLayerElevationD9Ej5fM;
                    j9 = jM1055getSurface0d7_KjU;
                    j10 = jM1069contentColorForek8zF_U2;
                    j11 = frontLayerScrimColor;
                    interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                    f6 = f11114;
                    f7 = f11115;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new BackdropScaffoldKt$BackdropScaffold$2(interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, modifier4, backdropScaffoldState2, z9, f7, f6, z10, z11, j7, j8, shape3, f5, j9, j10, j11, interfaceC0552Gp3, i, i2, i3));
            }
            i4 |= 100663296;
            i14 = i3 & 512;
            if (i14 != 0) {
                i15 = i4 | 805306368;
                i14 = i14;
            } else {
                if ((i & 1879048192) != 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i16 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i16 = 268435456;
                    }
                    i4 |= i16;
                }
                i15 = i4;
            }
            if ((i2 & 14) == 0) {
                if ((i3 & 1024) == 0) {
                    i27 = 2;
                } else {
                    i27 = 2;
                }
                i17 = i2 | i27;
            } else {
                i17 = i2;
            }
            if ((i2 & 112) != 0) {
                if ((i3 & 2048) == 0) {
                    i26 = 16;
                } else {
                    i26 = 16;
                }
                i17 |= i26;
            }
            if ((i2 & 896) == 0) {
                shape2 = shape;
                if ((i3 & 4096) == 0) {
                    i25 = 128;
                } else {
                    i25 = 128;
                }
                i17 |= i25;
            } else {
                shape2 = shape;
            }
            i18 = i3 & 8192;
            if (i18 != 0) {
                if ((i2 & 7168) == 0) {
                    i17 |= composerStartRestartGroup.changed(f3) ? 2048 : 1024;
                }
                if ((i2 & 57344) != 0) {
                    if ((i3 & 16384) == 0) {
                        i5 = 16384;
                    }
                    i17 |= i5;
                }
                if ((458752 & i2) != 0) {
                    if ((i3 & 32768) == 0) {
                        i24 = 65536;
                    } else {
                        i24 = 65536;
                    }
                    i17 |= i24;
                }
                if ((3670016 & i2) != 0) {
                    if ((i3 & 65536) == 0) {
                        i23 = 524288;
                    } else {
                        i23 = 524288;
                    }
                    i17 |= i23;
                }
                i19 = i3 & 131072;
                if (i19 != 0) {
                    i17 |= 12582912;
                    interfaceC0552Gp2 = interfaceC0552Gp;
                } else {
                    interfaceC0552Gp2 = interfaceC0552Gp;
                    if ((i2 & 29360128) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                            i20 = 8388608;
                        } else {
                            i20 = 4194304;
                        }
                        i17 |= i20;
                    }
                }
                i21 = i17;
                if ((i15 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i29 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i3 & 16) != 0) {
                            i15 &= -57345;
                            backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                        } else {
                            fM983getHeaderHeightD9Ej5fM = f2;
                        }
                        if (i12 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i14 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 1024) != 0) {
                            i22 = 6;
                            i21 &= -15;
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        } else {
                            i22 = 6;
                            jM1051getPrimary0d7_KjU = j;
                        }
                        if ((i3 & 2048) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                            i21 &= -113;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 4096) != 0) {
                            frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                            i21 &= -897;
                        } else {
                            frontLayerShape = shape;
                        }
                        if (i18 != 0) {
                            fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                        } else {
                            fM982getFrontLayerElevationD9Ej5fM = f3;
                        }
                        if ((i3 & 16384) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i21 &= -57345;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                            i21 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U2 = j4;
                        }
                        if ((i3 & 65536) != 0) {
                            frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                            i21 = (-3670017) & i21;
                        } else {
                            frontLayerScrimColor = j5;
                        }
                        if (i19 != 0) {
                            interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                        }
                        f4 = fM984getPeekHeightD9Ej5fM;
                        z7 = z4;
                        z8 = z5;
                        j6 = jM1051getPrimary0d7_KjU;
                    } else {
                        if (i29 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i3 & 16) != 0) {
                            i15 &= -57345;
                            backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                        } else {
                            fM983getHeaderHeightD9Ej5fM = f2;
                        }
                        if (i12 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i14 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 1024) != 0) {
                            i22 = 6;
                            i21 &= -15;
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        } else {
                            i22 = 6;
                            jM1051getPrimary0d7_KjU = j;
                        }
                        if ((i3 & 2048) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                            i21 &= -113;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 4096) != 0) {
                            frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                            i21 &= -897;
                        } else {
                            frontLayerShape = shape;
                        }
                        if (i18 != 0) {
                            fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                        } else {
                            fM982getFrontLayerElevationD9Ej5fM = f3;
                        }
                        if ((i3 & 16384) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i21 &= -57345;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                            i21 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U2 = j4;
                        }
                        if ((i3 & 65536) != 0) {
                            frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                            i21 = (-3670017) & i21;
                        } else {
                            frontLayerScrimColor = j5;
                        }
                        if (i19 != 0) {
                            interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                        }
                        f4 = fM984getPeekHeightD9Ej5fM;
                        z7 = z4;
                        z8 = z5;
                        j6 = jM1051getPrimary0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                    }
                    float fMo333toPx0680j_114 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                    fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                    ComposableLambda composableLambda110 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                    Float fValueOf110 = Float.valueOf(fMo333toPx0680j_4);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(fValueOf110);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i31118 = i21;
                    float f11116 = fM983getHeaderHeightD9Ej5fM;
                    float f11117 = f4;
                    Modifier modifier114 = modifier3;
                    composer2 = composerStartRestartGroup;
                    int i31119 = i31118 << 6;
                    SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda110, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_114, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i31118, f11116, f11117, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i31119 & 7168) | (i31119 & 896) | 1572864, 51);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier114;
                    backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                    z9 = z7;
                    z10 = z8;
                    z11 = z6;
                    j7 = j6;
                    j8 = jM1069contentColorForek8zF_U;
                    shape3 = frontLayerShape;
                    f5 = fM982getFrontLayerElevationD9Ej5fM;
                    j9 = jM1055getSurface0d7_KjU;
                    j10 = jM1069contentColorForek8zF_U2;
                    j11 = frontLayerScrimColor;
                    interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                    f6 = f11116;
                    f7 = f11117;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i29 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i3 & 16) != 0) {
                            i15 &= -57345;
                            backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                        } else {
                            fM983getHeaderHeightD9Ej5fM = f2;
                        }
                        if (i12 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i14 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 1024) != 0) {
                            i22 = 6;
                            i21 &= -15;
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        } else {
                            i22 = 6;
                            jM1051getPrimary0d7_KjU = j;
                        }
                        if ((i3 & 2048) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                            i21 &= -113;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 4096) != 0) {
                            frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                            i21 &= -897;
                        } else {
                            frontLayerShape = shape;
                        }
                        if (i18 != 0) {
                            fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                        } else {
                            fM982getFrontLayerElevationD9Ej5fM = f3;
                        }
                        if ((i3 & 16384) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i21 &= -57345;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                            i21 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U2 = j4;
                        }
                        if ((i3 & 65536) != 0) {
                            frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                            i21 = (-3670017) & i21;
                        } else {
                            frontLayerScrimColor = j5;
                        }
                        if (i19 != 0) {
                            interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                        }
                        f4 = fM984getPeekHeightD9Ej5fM;
                        z7 = z4;
                        z8 = z5;
                        j6 = jM1051getPrimary0d7_KjU;
                    } else {
                        if (i29 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i3 & 16) != 0) {
                            i15 &= -57345;
                            backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                        } else {
                            fM983getHeaderHeightD9Ej5fM = f2;
                        }
                        if (i12 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i14 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 1024) != 0) {
                            i22 = 6;
                            i21 &= -15;
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        } else {
                            i22 = 6;
                            jM1051getPrimary0d7_KjU = j;
                        }
                        if ((i3 & 2048) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                            i21 &= -113;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 4096) != 0) {
                            frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                            i21 &= -897;
                        } else {
                            frontLayerShape = shape;
                        }
                        if (i18 != 0) {
                            fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                        } else {
                            fM982getFrontLayerElevationD9Ej5fM = f3;
                        }
                        if ((i3 & 16384) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i21 &= -57345;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                            i21 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U2 = j4;
                        }
                        if ((i3 & 65536) != 0) {
                            frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                            i21 = (-3670017) & i21;
                        } else {
                            frontLayerScrimColor = j5;
                        }
                        if (i19 != 0) {
                            interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                        }
                        f4 = fM984getPeekHeightD9Ej5fM;
                        z7 = z4;
                        z8 = z5;
                        j6 = jM1051getPrimary0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                    }
                    float fMo333toPx0680j_115 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                    fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                    ComposableLambda composableLambda111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                    Float fValueOf111 = Float.valueOf(fMo333toPx0680j_4);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(fValueOf111);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i311110 = i21;
                    float f11118 = fM983getHeaderHeightD9Ej5fM;
                    float f11119 = f4;
                    Modifier modifier115 = modifier3;
                    composer2 = composerStartRestartGroup;
                    int i311111 = i311110 << 6;
                    SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda111, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_115, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i311110, f11118, f11119, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i311111 & 7168) | (i311111 & 896) | 1572864, 51);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier115;
                    backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                    z9 = z7;
                    z10 = z8;
                    z11 = z6;
                    j7 = j6;
                    j8 = jM1069contentColorForek8zF_U;
                    shape3 = frontLayerShape;
                    f5 = fM982getFrontLayerElevationD9Ej5fM;
                    j9 = jM1055getSurface0d7_KjU;
                    j10 = jM1069contentColorForek8zF_U2;
                    j11 = frontLayerScrimColor;
                    interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                    f6 = f11118;
                    f7 = f11119;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new BackdropScaffoldKt$BackdropScaffold$2(interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, modifier4, backdropScaffoldState2, z9, f7, f6, z10, z11, j7, j8, shape3, f5, j9, j10, j11, interfaceC0552Gp3, i, i2, i3));
            }
            i17 |= 3072;
            if ((i2 & 57344) != 0) {
                if ((i3 & 16384) == 0) {
                    i5 = 16384;
                }
                i17 |= i5;
            }
            if ((458752 & i2) != 0) {
                if ((i3 & 32768) == 0) {
                    i24 = 65536;
                } else {
                    i24 = 65536;
                }
                i17 |= i24;
            }
            if ((3670016 & i2) != 0) {
                if ((i3 & 65536) == 0) {
                    i23 = 524288;
                } else {
                    i23 = 524288;
                }
                i17 |= i23;
            }
            i19 = i3 & 131072;
            if (i19 != 0) {
                i17 |= 12582912;
                interfaceC0552Gp2 = interfaceC0552Gp;
            } else {
                interfaceC0552Gp2 = interfaceC0552Gp;
                if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                        i20 = 8388608;
                    } else {
                        i20 = 4194304;
                    }
                    i17 |= i20;
                }
            }
            i21 = i17;
            if ((i15 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i29 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i3 & 16) != 0) {
                        i15 &= -57345;
                        backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                    }
                    if (i10 != 0) {
                        fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                    } else {
                        fM983getHeaderHeightD9Ej5fM = f2;
                    }
                    if (i12 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i14 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if ((i3 & 1024) != 0) {
                        i22 = 6;
                        i21 &= -15;
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    } else {
                        i22 = 6;
                        jM1051getPrimary0d7_KjU = j;
                    }
                    if ((i3 & 2048) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                        i21 &= -113;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i3 & 4096) != 0) {
                        frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                        i21 &= -897;
                    } else {
                        frontLayerShape = shape;
                    }
                    if (i18 != 0) {
                        fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                    } else {
                        fM982getFrontLayerElevationD9Ej5fM = f3;
                    }
                    if ((i3 & 16384) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i21 &= -57345;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i3 & 32768) != 0) {
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                        i21 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U2 = j4;
                    }
                    if ((i3 & 65536) != 0) {
                        frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                        i21 = (-3670017) & i21;
                    } else {
                        frontLayerScrimColor = j5;
                    }
                    if (i19 != 0) {
                        interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                    }
                    f4 = fM984getPeekHeightD9Ej5fM;
                    z7 = z4;
                    z8 = z5;
                    j6 = jM1051getPrimary0d7_KjU;
                } else {
                    if (i29 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i3 & 16) != 0) {
                        i15 &= -57345;
                        backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                    }
                    if (i10 != 0) {
                        fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                    } else {
                        fM983getHeaderHeightD9Ej5fM = f2;
                    }
                    if (i12 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i14 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if ((i3 & 1024) != 0) {
                        i22 = 6;
                        i21 &= -15;
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    } else {
                        i22 = 6;
                        jM1051getPrimary0d7_KjU = j;
                    }
                    if ((i3 & 2048) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                        i21 &= -113;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i3 & 4096) != 0) {
                        frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                        i21 &= -897;
                    } else {
                        frontLayerShape = shape;
                    }
                    if (i18 != 0) {
                        fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                    } else {
                        fM982getFrontLayerElevationD9Ej5fM = f3;
                    }
                    if ((i3 & 16384) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i21 &= -57345;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i3 & 32768) != 0) {
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                        i21 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U2 = j4;
                    }
                    if ((i3 & 65536) != 0) {
                        frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                        i21 = (-3670017) & i21;
                    } else {
                        frontLayerScrimColor = j5;
                    }
                    if (i19 != 0) {
                        interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                    }
                    f4 = fM984getPeekHeightD9Ej5fM;
                    z7 = z4;
                    z8 = z5;
                    j6 = jM1051getPrimary0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                }
                float fMo333toPx0680j_116 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                ComposableLambda composableLambda112 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                Float fValueOf112 = Float.valueOf(fMo333toPx0680j_4);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(fValueOf112);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i311112 = i21;
                float f111110 = fM983getHeaderHeightD9Ej5fM;
                float f111111 = f4;
                Modifier modifier116 = modifier3;
                composer2 = composerStartRestartGroup;
                int i311113 = i311112 << 6;
                SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda112, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_116, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i311112, f111110, f111111, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i311113 & 7168) | (i311113 & 896) | 1572864, 51);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier116;
                backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                z9 = z7;
                z10 = z8;
                z11 = z6;
                j7 = j6;
                j8 = jM1069contentColorForek8zF_U;
                shape3 = frontLayerShape;
                f5 = fM982getFrontLayerElevationD9Ej5fM;
                j9 = jM1055getSurface0d7_KjU;
                j10 = jM1069contentColorForek8zF_U2;
                j11 = frontLayerScrimColor;
                interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                f6 = f111110;
                f7 = f111111;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i29 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i3 & 16) != 0) {
                        i15 &= -57345;
                        backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                    }
                    if (i10 != 0) {
                        fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                    } else {
                        fM983getHeaderHeightD9Ej5fM = f2;
                    }
                    if (i12 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i14 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if ((i3 & 1024) != 0) {
                        i22 = 6;
                        i21 &= -15;
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    } else {
                        i22 = 6;
                        jM1051getPrimary0d7_KjU = j;
                    }
                    if ((i3 & 2048) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                        i21 &= -113;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i3 & 4096) != 0) {
                        frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                        i21 &= -897;
                    } else {
                        frontLayerShape = shape;
                    }
                    if (i18 != 0) {
                        fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                    } else {
                        fM982getFrontLayerElevationD9Ej5fM = f3;
                    }
                    if ((i3 & 16384) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i21 &= -57345;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i3 & 32768) != 0) {
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                        i21 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U2 = j4;
                    }
                    if ((i3 & 65536) != 0) {
                        frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                        i21 = (-3670017) & i21;
                    } else {
                        frontLayerScrimColor = j5;
                    }
                    if (i19 != 0) {
                        interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                    }
                    f4 = fM984getPeekHeightD9Ej5fM;
                    z7 = z4;
                    z8 = z5;
                    j6 = jM1051getPrimary0d7_KjU;
                } else {
                    if (i29 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i3 & 16) != 0) {
                        i15 &= -57345;
                        backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                    }
                    if (i10 != 0) {
                        fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                    } else {
                        fM983getHeaderHeightD9Ej5fM = f2;
                    }
                    if (i12 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i14 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if ((i3 & 1024) != 0) {
                        i22 = 6;
                        i21 &= -15;
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    } else {
                        i22 = 6;
                        jM1051getPrimary0d7_KjU = j;
                    }
                    if ((i3 & 2048) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                        i21 &= -113;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i3 & 4096) != 0) {
                        frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                        i21 &= -897;
                    } else {
                        frontLayerShape = shape;
                    }
                    if (i18 != 0) {
                        fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                    } else {
                        fM982getFrontLayerElevationD9Ej5fM = f3;
                    }
                    if ((i3 & 16384) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i21 &= -57345;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i3 & 32768) != 0) {
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                        i21 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U2 = j4;
                    }
                    if ((i3 & 65536) != 0) {
                        frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                        i21 = (-3670017) & i21;
                    } else {
                        frontLayerScrimColor = j5;
                    }
                    if (i19 != 0) {
                        interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                    }
                    f4 = fM984getPeekHeightD9Ej5fM;
                    z7 = z4;
                    z8 = z5;
                    j6 = jM1051getPrimary0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                }
                float fMo333toPx0680j_117 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                ComposableLambda composableLambda113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                Float fValueOf113 = Float.valueOf(fMo333toPx0680j_4);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(fValueOf113);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i311114 = i21;
                float f111112 = fM983getHeaderHeightD9Ej5fM;
                float f111113 = f4;
                Modifier modifier117 = modifier3;
                composer2 = composerStartRestartGroup;
                int i311115 = i311114 << 6;
                SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda113, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_117, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i311114, f111112, f111113, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i311115 & 7168) | (i311115 & 896) | 1572864, 51);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier117;
                backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                z9 = z7;
                z10 = z8;
                z11 = z6;
                j7 = j6;
                j8 = jM1069contentColorForek8zF_U;
                shape3 = frontLayerShape;
                f5 = fM982getFrontLayerElevationD9Ej5fM;
                j9 = jM1055getSurface0d7_KjU;
                j10 = jM1069contentColorForek8zF_U2;
                j11 = frontLayerScrimColor;
                interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                f6 = f111112;
                f7 = f111113;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new BackdropScaffoldKt$BackdropScaffold$2(interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, modifier4, backdropScaffoldState2, z9, f7, f6, z10, z11, j7, j8, shape3, f5, j9, j10, j11, interfaceC0552Gp3, i, i2, i3));
        }
        i4 |= 12582912;
        i12 = i3 & 256;
        if (i12 != 0) {
            if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i4 |= i13;
            }
            i14 = i3 & 512;
            if (i14 != 0) {
                i15 = i4 | 805306368;
                i14 = i14;
            } else {
                if ((i & 1879048192) != 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i16 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i16 = 268435456;
                    }
                    i4 |= i16;
                }
                i15 = i4;
            }
            if ((i2 & 14) == 0) {
                if ((i3 & 1024) == 0) {
                    i27 = 2;
                } else {
                    i27 = 2;
                }
                i17 = i2 | i27;
            } else {
                i17 = i2;
            }
            if ((i2 & 112) != 0) {
                if ((i3 & 2048) == 0) {
                    i26 = 16;
                } else {
                    i26 = 16;
                }
                i17 |= i26;
            }
            if ((i2 & 896) == 0) {
                shape2 = shape;
                if ((i3 & 4096) == 0) {
                    i25 = 128;
                } else {
                    i25 = 128;
                }
                i17 |= i25;
            } else {
                shape2 = shape;
            }
            i18 = i3 & 8192;
            if (i18 != 0) {
                if ((i2 & 7168) == 0) {
                    i17 |= composerStartRestartGroup.changed(f3) ? 2048 : 1024;
                }
                if ((i2 & 57344) != 0) {
                    if ((i3 & 16384) == 0) {
                        i5 = 16384;
                    }
                    i17 |= i5;
                }
                if ((458752 & i2) != 0) {
                    if ((i3 & 32768) == 0) {
                        i24 = 65536;
                    } else {
                        i24 = 65536;
                    }
                    i17 |= i24;
                }
                if ((3670016 & i2) != 0) {
                    if ((i3 & 65536) == 0) {
                        i23 = 524288;
                    } else {
                        i23 = 524288;
                    }
                    i17 |= i23;
                }
                i19 = i3 & 131072;
                if (i19 != 0) {
                    i17 |= 12582912;
                    interfaceC0552Gp2 = interfaceC0552Gp;
                } else {
                    interfaceC0552Gp2 = interfaceC0552Gp;
                    if ((i2 & 29360128) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                            i20 = 8388608;
                        } else {
                            i20 = 4194304;
                        }
                        i17 |= i20;
                    }
                }
                i21 = i17;
                if ((i15 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i29 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i3 & 16) != 0) {
                            i15 &= -57345;
                            backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                        } else {
                            fM983getHeaderHeightD9Ej5fM = f2;
                        }
                        if (i12 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i14 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 1024) != 0) {
                            i22 = 6;
                            i21 &= -15;
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        } else {
                            i22 = 6;
                            jM1051getPrimary0d7_KjU = j;
                        }
                        if ((i3 & 2048) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                            i21 &= -113;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 4096) != 0) {
                            frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                            i21 &= -897;
                        } else {
                            frontLayerShape = shape;
                        }
                        if (i18 != 0) {
                            fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                        } else {
                            fM982getFrontLayerElevationD9Ej5fM = f3;
                        }
                        if ((i3 & 16384) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i21 &= -57345;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                            i21 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U2 = j4;
                        }
                        if ((i3 & 65536) != 0) {
                            frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                            i21 = (-3670017) & i21;
                        } else {
                            frontLayerScrimColor = j5;
                        }
                        if (i19 != 0) {
                            interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                        }
                        f4 = fM984getPeekHeightD9Ej5fM;
                        z7 = z4;
                        z8 = z5;
                        j6 = jM1051getPrimary0d7_KjU;
                    } else {
                        if (i29 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i3 & 16) != 0) {
                            i15 &= -57345;
                            backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                        } else {
                            fM983getHeaderHeightD9Ej5fM = f2;
                        }
                        if (i12 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i14 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 1024) != 0) {
                            i22 = 6;
                            i21 &= -15;
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        } else {
                            i22 = 6;
                            jM1051getPrimary0d7_KjU = j;
                        }
                        if ((i3 & 2048) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                            i21 &= -113;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 4096) != 0) {
                            frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                            i21 &= -897;
                        } else {
                            frontLayerShape = shape;
                        }
                        if (i18 != 0) {
                            fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                        } else {
                            fM982getFrontLayerElevationD9Ej5fM = f3;
                        }
                        if ((i3 & 16384) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i21 &= -57345;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                            i21 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U2 = j4;
                        }
                        if ((i3 & 65536) != 0) {
                            frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                            i21 = (-3670017) & i21;
                        } else {
                            frontLayerScrimColor = j5;
                        }
                        if (i19 != 0) {
                            interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                        }
                        f4 = fM984getPeekHeightD9Ej5fM;
                        z7 = z4;
                        z8 = z5;
                        j6 = jM1051getPrimary0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                    }
                    float fMo333toPx0680j_118 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                    fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                    ComposableLambda composableLambda114 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                    Float fValueOf114 = Float.valueOf(fMo333toPx0680j_4);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(fValueOf114);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i311116 = i21;
                    float f111114 = fM983getHeaderHeightD9Ej5fM;
                    float f111115 = f4;
                    Modifier modifier118 = modifier3;
                    composer2 = composerStartRestartGroup;
                    int i311117 = i311116 << 6;
                    SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda114, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_118, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i311116, f111114, f111115, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i311117 & 7168) | (i311117 & 896) | 1572864, 51);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier118;
                    backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                    z9 = z7;
                    z10 = z8;
                    z11 = z6;
                    j7 = j6;
                    j8 = jM1069contentColorForek8zF_U;
                    shape3 = frontLayerShape;
                    f5 = fM982getFrontLayerElevationD9Ej5fM;
                    j9 = jM1055getSurface0d7_KjU;
                    j10 = jM1069contentColorForek8zF_U2;
                    j11 = frontLayerScrimColor;
                    interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                    f6 = f111114;
                    f7 = f111115;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i29 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i3 & 16) != 0) {
                            i15 &= -57345;
                            backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                        } else {
                            fM983getHeaderHeightD9Ej5fM = f2;
                        }
                        if (i12 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i14 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 1024) != 0) {
                            i22 = 6;
                            i21 &= -15;
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        } else {
                            i22 = 6;
                            jM1051getPrimary0d7_KjU = j;
                        }
                        if ((i3 & 2048) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                            i21 &= -113;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 4096) != 0) {
                            frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                            i21 &= -897;
                        } else {
                            frontLayerShape = shape;
                        }
                        if (i18 != 0) {
                            fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                        } else {
                            fM982getFrontLayerElevationD9Ej5fM = f3;
                        }
                        if ((i3 & 16384) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i21 &= -57345;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                            i21 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U2 = j4;
                        }
                        if ((i3 & 65536) != 0) {
                            frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                            i21 = (-3670017) & i21;
                        } else {
                            frontLayerScrimColor = j5;
                        }
                        if (i19 != 0) {
                            interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                        }
                        f4 = fM984getPeekHeightD9Ej5fM;
                        z7 = z4;
                        z8 = z5;
                        j6 = jM1051getPrimary0d7_KjU;
                    } else {
                        if (i29 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i3 & 16) != 0) {
                            i15 &= -57345;
                            backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                        } else {
                            fM983getHeaderHeightD9Ej5fM = f2;
                        }
                        if (i12 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i14 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 1024) != 0) {
                            i22 = 6;
                            i21 &= -15;
                            jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                        } else {
                            i22 = 6;
                            jM1051getPrimary0d7_KjU = j;
                        }
                        if ((i3 & 2048) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                            i21 &= -113;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 4096) != 0) {
                            frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                            i21 &= -897;
                        } else {
                            frontLayerShape = shape;
                        }
                        if (i18 != 0) {
                            fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                        } else {
                            fM982getFrontLayerElevationD9Ej5fM = f3;
                        }
                        if ((i3 & 16384) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i21 &= -57345;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                            i21 &= -458753;
                        } else {
                            jM1069contentColorForek8zF_U2 = j4;
                        }
                        if ((i3 & 65536) != 0) {
                            frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                            i21 = (-3670017) & i21;
                        } else {
                            frontLayerScrimColor = j5;
                        }
                        if (i19 != 0) {
                            interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                        } else {
                            interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                        }
                        f4 = fM984getPeekHeightD9Ej5fM;
                        z7 = z4;
                        z8 = z5;
                        j6 = jM1051getPrimary0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                    }
                    float fMo333toPx0680j_119 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                    fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                    ComposableLambda composableLambda115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                    Float fValueOf115 = Float.valueOf(fMo333toPx0680j_4);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(fValueOf115);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i311118 = i21;
                    float f111116 = fM983getHeaderHeightD9Ej5fM;
                    float f111117 = f4;
                    Modifier modifier119 = modifier3;
                    composer2 = composerStartRestartGroup;
                    int i311119 = i311118 << 6;
                    SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda115, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_119, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i311118, f111116, f111117, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i311119 & 7168) | (i311119 & 896) | 1572864, 51);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier119;
                    backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                    z9 = z7;
                    z10 = z8;
                    z11 = z6;
                    j7 = j6;
                    j8 = jM1069contentColorForek8zF_U;
                    shape3 = frontLayerShape;
                    f5 = fM982getFrontLayerElevationD9Ej5fM;
                    j9 = jM1055getSurface0d7_KjU;
                    j10 = jM1069contentColorForek8zF_U2;
                    j11 = frontLayerScrimColor;
                    interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                    f6 = f111116;
                    f7 = f111117;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new BackdropScaffoldKt$BackdropScaffold$2(interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, modifier4, backdropScaffoldState2, z9, f7, f6, z10, z11, j7, j8, shape3, f5, j9, j10, j11, interfaceC0552Gp3, i, i2, i3));
            }
            i17 |= 3072;
            if ((i2 & 57344) != 0) {
                if ((i3 & 16384) == 0) {
                    i5 = 16384;
                }
                i17 |= i5;
            }
            if ((458752 & i2) != 0) {
                if ((i3 & 32768) == 0) {
                    i24 = 65536;
                } else {
                    i24 = 65536;
                }
                i17 |= i24;
            }
            if ((3670016 & i2) != 0) {
                if ((i3 & 65536) == 0) {
                    i23 = 524288;
                } else {
                    i23 = 524288;
                }
                i17 |= i23;
            }
            i19 = i3 & 131072;
            if (i19 != 0) {
                i17 |= 12582912;
                interfaceC0552Gp2 = interfaceC0552Gp;
            } else {
                interfaceC0552Gp2 = interfaceC0552Gp;
                if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                        i20 = 8388608;
                    } else {
                        i20 = 4194304;
                    }
                    i17 |= i20;
                }
            }
            i21 = i17;
            if ((i15 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i29 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i3 & 16) != 0) {
                        i15 &= -57345;
                        backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                    }
                    if (i10 != 0) {
                        fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                    } else {
                        fM983getHeaderHeightD9Ej5fM = f2;
                    }
                    if (i12 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i14 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if ((i3 & 1024) != 0) {
                        i22 = 6;
                        i21 &= -15;
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    } else {
                        i22 = 6;
                        jM1051getPrimary0d7_KjU = j;
                    }
                    if ((i3 & 2048) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                        i21 &= -113;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i3 & 4096) != 0) {
                        frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                        i21 &= -897;
                    } else {
                        frontLayerShape = shape;
                    }
                    if (i18 != 0) {
                        fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                    } else {
                        fM982getFrontLayerElevationD9Ej5fM = f3;
                    }
                    if ((i3 & 16384) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i21 &= -57345;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i3 & 32768) != 0) {
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                        i21 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U2 = j4;
                    }
                    if ((i3 & 65536) != 0) {
                        frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                        i21 = (-3670017) & i21;
                    } else {
                        frontLayerScrimColor = j5;
                    }
                    if (i19 != 0) {
                        interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                    }
                    f4 = fM984getPeekHeightD9Ej5fM;
                    z7 = z4;
                    z8 = z5;
                    j6 = jM1051getPrimary0d7_KjU;
                } else {
                    if (i29 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i3 & 16) != 0) {
                        i15 &= -57345;
                        backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                    }
                    if (i10 != 0) {
                        fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                    } else {
                        fM983getHeaderHeightD9Ej5fM = f2;
                    }
                    if (i12 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i14 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if ((i3 & 1024) != 0) {
                        i22 = 6;
                        i21 &= -15;
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    } else {
                        i22 = 6;
                        jM1051getPrimary0d7_KjU = j;
                    }
                    if ((i3 & 2048) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                        i21 &= -113;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i3 & 4096) != 0) {
                        frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                        i21 &= -897;
                    } else {
                        frontLayerShape = shape;
                    }
                    if (i18 != 0) {
                        fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                    } else {
                        fM982getFrontLayerElevationD9Ej5fM = f3;
                    }
                    if ((i3 & 16384) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i21 &= -57345;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i3 & 32768) != 0) {
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                        i21 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U2 = j4;
                    }
                    if ((i3 & 65536) != 0) {
                        frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                        i21 = (-3670017) & i21;
                    } else {
                        frontLayerScrimColor = j5;
                    }
                    if (i19 != 0) {
                        interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                    }
                    f4 = fM984getPeekHeightD9Ej5fM;
                    z7 = z4;
                    z8 = z5;
                    j6 = jM1051getPrimary0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                }
                float fMo333toPx0680j_1110 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                ComposableLambda composableLambda116 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                Float fValueOf116 = Float.valueOf(fMo333toPx0680j_4);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(fValueOf116);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i3111110 = i21;
                float f111118 = fM983getHeaderHeightD9Ej5fM;
                float f111119 = f4;
                Modifier modifier1110 = modifier3;
                composer2 = composerStartRestartGroup;
                int i3111111 = i3111110 << 6;
                SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda116, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_1110, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i3111110, f111118, f111119, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i3111111 & 7168) | (i3111111 & 896) | 1572864, 51);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier1110;
                backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                z9 = z7;
                z10 = z8;
                z11 = z6;
                j7 = j6;
                j8 = jM1069contentColorForek8zF_U;
                shape3 = frontLayerShape;
                f5 = fM982getFrontLayerElevationD9Ej5fM;
                j9 = jM1055getSurface0d7_KjU;
                j10 = jM1069contentColorForek8zF_U2;
                j11 = frontLayerScrimColor;
                interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                f6 = f111118;
                f7 = f111119;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i29 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i3 & 16) != 0) {
                        i15 &= -57345;
                        backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                    }
                    if (i10 != 0) {
                        fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                    } else {
                        fM983getHeaderHeightD9Ej5fM = f2;
                    }
                    if (i12 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i14 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if ((i3 & 1024) != 0) {
                        i22 = 6;
                        i21 &= -15;
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    } else {
                        i22 = 6;
                        jM1051getPrimary0d7_KjU = j;
                    }
                    if ((i3 & 2048) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                        i21 &= -113;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i3 & 4096) != 0) {
                        frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                        i21 &= -897;
                    } else {
                        frontLayerShape = shape;
                    }
                    if (i18 != 0) {
                        fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                    } else {
                        fM982getFrontLayerElevationD9Ej5fM = f3;
                    }
                    if ((i3 & 16384) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i21 &= -57345;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i3 & 32768) != 0) {
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                        i21 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U2 = j4;
                    }
                    if ((i3 & 65536) != 0) {
                        frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                        i21 = (-3670017) & i21;
                    } else {
                        frontLayerScrimColor = j5;
                    }
                    if (i19 != 0) {
                        interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                    }
                    f4 = fM984getPeekHeightD9Ej5fM;
                    z7 = z4;
                    z8 = z5;
                    j6 = jM1051getPrimary0d7_KjU;
                } else {
                    if (i29 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i3 & 16) != 0) {
                        i15 &= -57345;
                        backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                    }
                    if (i10 != 0) {
                        fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                    } else {
                        fM983getHeaderHeightD9Ej5fM = f2;
                    }
                    if (i12 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i14 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if ((i3 & 1024) != 0) {
                        i22 = 6;
                        i21 &= -15;
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    } else {
                        i22 = 6;
                        jM1051getPrimary0d7_KjU = j;
                    }
                    if ((i3 & 2048) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                        i21 &= -113;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i3 & 4096) != 0) {
                        frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                        i21 &= -897;
                    } else {
                        frontLayerShape = shape;
                    }
                    if (i18 != 0) {
                        fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                    } else {
                        fM982getFrontLayerElevationD9Ej5fM = f3;
                    }
                    if ((i3 & 16384) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i21 &= -57345;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i3 & 32768) != 0) {
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                        i21 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U2 = j4;
                    }
                    if ((i3 & 65536) != 0) {
                        frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                        i21 = (-3670017) & i21;
                    } else {
                        frontLayerScrimColor = j5;
                    }
                    if (i19 != 0) {
                        interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                    }
                    f4 = fM984getPeekHeightD9Ej5fM;
                    z7 = z4;
                    z8 = z5;
                    j6 = jM1051getPrimary0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                }
                float fMo333toPx0680j_1111 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                ComposableLambda composableLambda117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                Float fValueOf117 = Float.valueOf(fMo333toPx0680j_4);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(fValueOf117);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i3111112 = i21;
                float f1111110 = fM983getHeaderHeightD9Ej5fM;
                float f1111111 = f4;
                Modifier modifier1111 = modifier3;
                composer2 = composerStartRestartGroup;
                int i3111113 = i3111112 << 6;
                SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda117, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_1111, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i3111112, f1111110, f1111111, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i3111113 & 7168) | (i3111113 & 896) | 1572864, 51);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier1111;
                backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                z9 = z7;
                z10 = z8;
                z11 = z6;
                j7 = j6;
                j8 = jM1069contentColorForek8zF_U;
                shape3 = frontLayerShape;
                f5 = fM982getFrontLayerElevationD9Ej5fM;
                j9 = jM1055getSurface0d7_KjU;
                j10 = jM1069contentColorForek8zF_U2;
                j11 = frontLayerScrimColor;
                interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                f6 = f1111110;
                f7 = f1111111;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new BackdropScaffoldKt$BackdropScaffold$2(interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, modifier4, backdropScaffoldState2, z9, f7, f6, z10, z11, j7, j8, shape3, f5, j9, j10, j11, interfaceC0552Gp3, i, i2, i3));
        }
        i4 |= 100663296;
        i14 = i3 & 512;
        if (i14 != 0) {
            i15 = i4 | 805306368;
            i14 = i14;
        } else {
            if ((i & 1879048192) != 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i16 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i16 = 268435456;
                }
                i4 |= i16;
            }
            i15 = i4;
        }
        if ((i2 & 14) == 0) {
            if ((i3 & 1024) == 0) {
                i27 = 2;
            } else {
                i27 = 2;
            }
            i17 = i2 | i27;
        } else {
            i17 = i2;
        }
        if ((i2 & 112) != 0) {
            if ((i3 & 2048) == 0) {
                i26 = 16;
            } else {
                i26 = 16;
            }
            i17 |= i26;
        }
        if ((i2 & 896) == 0) {
            shape2 = shape;
            if ((i3 & 4096) == 0) {
                i25 = 128;
            } else {
                i25 = 128;
            }
            i17 |= i25;
        } else {
            shape2 = shape;
        }
        i18 = i3 & 8192;
        if (i18 != 0) {
            if ((i2 & 7168) == 0) {
                i17 |= composerStartRestartGroup.changed(f3) ? 2048 : 1024;
            }
            if ((i2 & 57344) != 0) {
                if ((i3 & 16384) == 0) {
                    i5 = 16384;
                }
                i17 |= i5;
            }
            if ((458752 & i2) != 0) {
                if ((i3 & 32768) == 0) {
                    i24 = 65536;
                } else {
                    i24 = 65536;
                }
                i17 |= i24;
            }
            if ((3670016 & i2) != 0) {
                if ((i3 & 65536) == 0) {
                    i23 = 524288;
                } else {
                    i23 = 524288;
                }
                i17 |= i23;
            }
            i19 = i3 & 131072;
            if (i19 != 0) {
                i17 |= 12582912;
                interfaceC0552Gp2 = interfaceC0552Gp;
            } else {
                interfaceC0552Gp2 = interfaceC0552Gp;
                if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                        i20 = 8388608;
                    } else {
                        i20 = 4194304;
                    }
                    i17 |= i20;
                }
            }
            i21 = i17;
            if ((i15 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i29 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i3 & 16) != 0) {
                        i15 &= -57345;
                        backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                    }
                    if (i10 != 0) {
                        fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                    } else {
                        fM983getHeaderHeightD9Ej5fM = f2;
                    }
                    if (i12 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i14 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if ((i3 & 1024) != 0) {
                        i22 = 6;
                        i21 &= -15;
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    } else {
                        i22 = 6;
                        jM1051getPrimary0d7_KjU = j;
                    }
                    if ((i3 & 2048) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                        i21 &= -113;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i3 & 4096) != 0) {
                        frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                        i21 &= -897;
                    } else {
                        frontLayerShape = shape;
                    }
                    if (i18 != 0) {
                        fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                    } else {
                        fM982getFrontLayerElevationD9Ej5fM = f3;
                    }
                    if ((i3 & 16384) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i21 &= -57345;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i3 & 32768) != 0) {
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                        i21 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U2 = j4;
                    }
                    if ((i3 & 65536) != 0) {
                        frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                        i21 = (-3670017) & i21;
                    } else {
                        frontLayerScrimColor = j5;
                    }
                    if (i19 != 0) {
                        interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                    }
                    f4 = fM984getPeekHeightD9Ej5fM;
                    z7 = z4;
                    z8 = z5;
                    j6 = jM1051getPrimary0d7_KjU;
                } else {
                    if (i29 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i3 & 16) != 0) {
                        i15 &= -57345;
                        backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                    }
                    if (i10 != 0) {
                        fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                    } else {
                        fM983getHeaderHeightD9Ej5fM = f2;
                    }
                    if (i12 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i14 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if ((i3 & 1024) != 0) {
                        i22 = 6;
                        i21 &= -15;
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    } else {
                        i22 = 6;
                        jM1051getPrimary0d7_KjU = j;
                    }
                    if ((i3 & 2048) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                        i21 &= -113;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i3 & 4096) != 0) {
                        frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                        i21 &= -897;
                    } else {
                        frontLayerShape = shape;
                    }
                    if (i18 != 0) {
                        fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                    } else {
                        fM982getFrontLayerElevationD9Ej5fM = f3;
                    }
                    if ((i3 & 16384) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i21 &= -57345;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i3 & 32768) != 0) {
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                        i21 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U2 = j4;
                    }
                    if ((i3 & 65536) != 0) {
                        frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                        i21 = (-3670017) & i21;
                    } else {
                        frontLayerScrimColor = j5;
                    }
                    if (i19 != 0) {
                        interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                    }
                    f4 = fM984getPeekHeightD9Ej5fM;
                    z7 = z4;
                    z8 = z5;
                    j6 = jM1051getPrimary0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                }
                float fMo333toPx0680j_1112 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                ComposableLambda composableLambda118 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                Float fValueOf118 = Float.valueOf(fMo333toPx0680j_4);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(fValueOf118);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i3111114 = i21;
                float f1111112 = fM983getHeaderHeightD9Ej5fM;
                float f1111113 = f4;
                Modifier modifier1112 = modifier3;
                composer2 = composerStartRestartGroup;
                int i3111115 = i3111114 << 6;
                SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda118, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_1112, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i3111114, f1111112, f1111113, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i3111115 & 7168) | (i3111115 & 896) | 1572864, 51);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier1112;
                backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                z9 = z7;
                z10 = z8;
                z11 = z6;
                j7 = j6;
                j8 = jM1069contentColorForek8zF_U;
                shape3 = frontLayerShape;
                f5 = fM982getFrontLayerElevationD9Ej5fM;
                j9 = jM1055getSurface0d7_KjU;
                j10 = jM1069contentColorForek8zF_U2;
                j11 = frontLayerScrimColor;
                interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                f6 = f1111112;
                f7 = f1111113;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i29 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i3 & 16) != 0) {
                        i15 &= -57345;
                        backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                    }
                    if (i10 != 0) {
                        fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                    } else {
                        fM983getHeaderHeightD9Ej5fM = f2;
                    }
                    if (i12 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i14 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if ((i3 & 1024) != 0) {
                        i22 = 6;
                        i21 &= -15;
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    } else {
                        i22 = 6;
                        jM1051getPrimary0d7_KjU = j;
                    }
                    if ((i3 & 2048) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                        i21 &= -113;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i3 & 4096) != 0) {
                        frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                        i21 &= -897;
                    } else {
                        frontLayerShape = shape;
                    }
                    if (i18 != 0) {
                        fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                    } else {
                        fM982getFrontLayerElevationD9Ej5fM = f3;
                    }
                    if ((i3 & 16384) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i21 &= -57345;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i3 & 32768) != 0) {
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                        i21 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U2 = j4;
                    }
                    if ((i3 & 65536) != 0) {
                        frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                        i21 = (-3670017) & i21;
                    } else {
                        frontLayerScrimColor = j5;
                    }
                    if (i19 != 0) {
                        interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                    }
                    f4 = fM984getPeekHeightD9Ej5fM;
                    z7 = z4;
                    z8 = z5;
                    j6 = jM1051getPrimary0d7_KjU;
                } else {
                    if (i29 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i3 & 16) != 0) {
                        i15 &= -57345;
                        backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                    }
                    if (i10 != 0) {
                        fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                    } else {
                        fM983getHeaderHeightD9Ej5fM = f2;
                    }
                    if (i12 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i14 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if ((i3 & 1024) != 0) {
                        i22 = 6;
                        i21 &= -15;
                        jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                    } else {
                        i22 = 6;
                        jM1051getPrimary0d7_KjU = j;
                    }
                    if ((i3 & 2048) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                        i21 &= -113;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i3 & 4096) != 0) {
                        frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                        i21 &= -897;
                    } else {
                        frontLayerShape = shape;
                    }
                    if (i18 != 0) {
                        fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                    } else {
                        fM982getFrontLayerElevationD9Ej5fM = f3;
                    }
                    if ((i3 & 16384) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i21 &= -57345;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i3 & 32768) != 0) {
                        jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                        i21 &= -458753;
                    } else {
                        jM1069contentColorForek8zF_U2 = j4;
                    }
                    if ((i3 & 65536) != 0) {
                        frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                        i21 = (-3670017) & i21;
                    } else {
                        frontLayerScrimColor = j5;
                    }
                    if (i19 != 0) {
                        interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                    } else {
                        interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                    }
                    f4 = fM984getPeekHeightD9Ej5fM;
                    z7 = z4;
                    z8 = z5;
                    j6 = jM1051getPrimary0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                }
                float fMo333toPx0680j_1113 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
                fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
                ComposableLambda composableLambda119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
                Float fValueOf119 = Float.valueOf(fMo333toPx0680j_4);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(fValueOf119);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i3111116 = i21;
                float f1111114 = fM983getHeaderHeightD9Ej5fM;
                float f1111115 = f4;
                Modifier modifier1113 = modifier3;
                composer2 = composerStartRestartGroup;
                int i3111117 = i3111116 << 6;
                SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda119, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_1113, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i3111116, f1111114, f1111115, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i3111117 & 7168) | (i3111117 & 896) | 1572864, 51);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier1113;
                backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                z9 = z7;
                z10 = z8;
                z11 = z6;
                j7 = j6;
                j8 = jM1069contentColorForek8zF_U;
                shape3 = frontLayerShape;
                f5 = fM982getFrontLayerElevationD9Ej5fM;
                j9 = jM1055getSurface0d7_KjU;
                j10 = jM1069contentColorForek8zF_U2;
                j11 = frontLayerScrimColor;
                interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
                f6 = f1111114;
                f7 = f1111115;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new BackdropScaffoldKt$BackdropScaffold$2(interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, modifier4, backdropScaffoldState2, z9, f7, f6, z10, z11, j7, j8, shape3, f5, j9, j10, j11, interfaceC0552Gp3, i, i2, i3));
        }
        i17 |= 3072;
        if ((i2 & 57344) != 0) {
            if ((i3 & 16384) == 0) {
                i5 = 16384;
            }
            i17 |= i5;
        }
        if ((458752 & i2) != 0) {
            if ((i3 & 32768) == 0) {
                i24 = 65536;
            } else {
                i24 = 65536;
            }
            i17 |= i24;
        }
        if ((3670016 & i2) != 0) {
            if ((i3 & 65536) == 0) {
                i23 = 524288;
            } else {
                i23 = 524288;
            }
            i17 |= i23;
        }
        i19 = i3 & 131072;
        if (i19 != 0) {
            i17 |= 12582912;
            interfaceC0552Gp2 = interfaceC0552Gp;
        } else {
            interfaceC0552Gp2 = interfaceC0552Gp;
            if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                    i20 = 8388608;
                } else {
                    i20 = 4194304;
                }
                i17 |= i20;
            }
        }
        i21 = i17;
        if ((i15 & 1533916891) != 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i29 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i3 & 16) != 0) {
                    i15 &= -57345;
                    backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                }
                if (i6 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i8 != 0) {
                    fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                }
                if (i10 != 0) {
                    fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                } else {
                    fM983getHeaderHeightD9Ej5fM = f2;
                }
                if (i12 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i14 != 0) {
                    z6 = true;
                } else {
                    z6 = z3;
                }
                if ((i3 & 1024) != 0) {
                    i22 = 6;
                    i21 &= -15;
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                } else {
                    i22 = 6;
                    jM1051getPrimary0d7_KjU = j;
                }
                if ((i3 & 2048) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                    i21 &= -113;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if ((i3 & 4096) != 0) {
                    frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                    i21 &= -897;
                } else {
                    frontLayerShape = shape;
                }
                if (i18 != 0) {
                    fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                } else {
                    fM982getFrontLayerElevationD9Ej5fM = f3;
                }
                if ((i3 & 16384) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i21 &= -57345;
                } else {
                    jM1055getSurface0d7_KjU = j3;
                }
                if ((i3 & 32768) != 0) {
                    jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                    i21 &= -458753;
                } else {
                    jM1069contentColorForek8zF_U2 = j4;
                }
                if ((i3 & 65536) != 0) {
                    frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                    i21 = (-3670017) & i21;
                } else {
                    frontLayerScrimColor = j5;
                }
                if (i19 != 0) {
                    interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                } else {
                    interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                }
                f4 = fM984getPeekHeightD9Ej5fM;
                z7 = z4;
                z8 = z5;
                j6 = jM1051getPrimary0d7_KjU;
            } else {
                if (i29 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i3 & 16) != 0) {
                    i15 &= -57345;
                    backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                }
                if (i6 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i8 != 0) {
                    fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                }
                if (i10 != 0) {
                    fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                } else {
                    fM983getHeaderHeightD9Ej5fM = f2;
                }
                if (i12 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i14 != 0) {
                    z6 = true;
                } else {
                    z6 = z3;
                }
                if ((i3 & 1024) != 0) {
                    i22 = 6;
                    i21 &= -15;
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                } else {
                    i22 = 6;
                    jM1051getPrimary0d7_KjU = j;
                }
                if ((i3 & 2048) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                    i21 &= -113;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if ((i3 & 4096) != 0) {
                    frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                    i21 &= -897;
                } else {
                    frontLayerShape = shape;
                }
                if (i18 != 0) {
                    fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                } else {
                    fM982getFrontLayerElevationD9Ej5fM = f3;
                }
                if ((i3 & 16384) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i21 &= -57345;
                } else {
                    jM1055getSurface0d7_KjU = j3;
                }
                if ((i3 & 32768) != 0) {
                    jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                    i21 &= -458753;
                } else {
                    jM1069contentColorForek8zF_U2 = j4;
                }
                if ((i3 & 65536) != 0) {
                    frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                    i21 = (-3670017) & i21;
                } else {
                    frontLayerScrimColor = j5;
                }
                if (i19 != 0) {
                    interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                } else {
                    interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                }
                f4 = fM984getPeekHeightD9Ej5fM;
                z7 = z4;
                z8 = z5;
                j6 = jM1051getPrimary0d7_KjU;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
            }
            float fMo333toPx0680j_1114 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
            fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
            ComposableLambda composableLambda1110 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
            Float fValueOf1110 = Float.valueOf(fMo333toPx0680j_4);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(fValueOf1110);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            int i3111118 = i21;
            float f1111116 = fM983getHeaderHeightD9Ej5fM;
            float f1111117 = f4;
            Modifier modifier1114 = modifier3;
            composer2 = composerStartRestartGroup;
            int i3111119 = i3111118 << 6;
            SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda1110, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_1114, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i3111118, f1111116, f1111117, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i3111119 & 7168) | (i3111119 & 896) | 1572864, 51);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier1114;
            backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
            z9 = z7;
            z10 = z8;
            z11 = z6;
            j7 = j6;
            j8 = jM1069contentColorForek8zF_U;
            shape3 = frontLayerShape;
            f5 = fM982getFrontLayerElevationD9Ej5fM;
            j9 = jM1055getSurface0d7_KjU;
            j10 = jM1069contentColorForek8zF_U2;
            j11 = frontLayerScrimColor;
            interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
            f6 = f1111116;
            f7 = f1111117;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i29 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i3 & 16) != 0) {
                    i15 &= -57345;
                    backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                }
                if (i6 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i8 != 0) {
                    fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                }
                if (i10 != 0) {
                    fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                } else {
                    fM983getHeaderHeightD9Ej5fM = f2;
                }
                if (i12 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i14 != 0) {
                    z6 = true;
                } else {
                    z6 = z3;
                }
                if ((i3 & 1024) != 0) {
                    i22 = 6;
                    i21 &= -15;
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                } else {
                    i22 = 6;
                    jM1051getPrimary0d7_KjU = j;
                }
                if ((i3 & 2048) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                    i21 &= -113;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if ((i3 & 4096) != 0) {
                    frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                    i21 &= -897;
                } else {
                    frontLayerShape = shape;
                }
                if (i18 != 0) {
                    fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                } else {
                    fM982getFrontLayerElevationD9Ej5fM = f3;
                }
                if ((i3 & 16384) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i21 &= -57345;
                } else {
                    jM1055getSurface0d7_KjU = j3;
                }
                if ((i3 & 32768) != 0) {
                    jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                    i21 &= -458753;
                } else {
                    jM1069contentColorForek8zF_U2 = j4;
                }
                if ((i3 & 65536) != 0) {
                    frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                    i21 = (-3670017) & i21;
                } else {
                    frontLayerScrimColor = j5;
                }
                if (i19 != 0) {
                    interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                } else {
                    interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                }
                f4 = fM984getPeekHeightD9Ej5fM;
                z7 = z4;
                z8 = z5;
                j6 = jM1051getPrimary0d7_KjU;
            } else {
                if (i29 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i3 & 16) != 0) {
                    i15 &= -57345;
                    backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                }
                if (i6 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i8 != 0) {
                    fM984getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m984getPeekHeightD9Ej5fM();
                }
                if (i10 != 0) {
                    fM983getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m983getHeaderHeightD9Ej5fM();
                } else {
                    fM983getHeaderHeightD9Ej5fM = f2;
                }
                if (i12 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i14 != 0) {
                    z6 = true;
                } else {
                    z6 = z3;
                }
                if ((i3 & 1024) != 0) {
                    i22 = 6;
                    i21 &= -15;
                    jM1051getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1051getPrimary0d7_KjU();
                } else {
                    i22 = 6;
                    jM1051getPrimary0d7_KjU = j;
                }
                if ((i3 & 2048) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1051getPrimary0d7_KjU, composerStartRestartGroup, i21 & 14);
                    i21 &= -113;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if ((i3 & 4096) != 0) {
                    frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, i22);
                    i21 &= -897;
                } else {
                    frontLayerShape = shape;
                }
                if (i18 != 0) {
                    fM982getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m982getFrontLayerElevationD9Ej5fM();
                } else {
                    fM982getFrontLayerElevationD9Ej5fM = f3;
                }
                if ((i3 & 16384) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i21 &= -57345;
                } else {
                    jM1055getSurface0d7_KjU = j3;
                }
                if ((i3 & 32768) != 0) {
                    jM1069contentColorForek8zF_U2 = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i21 >> 12) & 14);
                    i21 &= -458753;
                } else {
                    jM1069contentColorForek8zF_U2 = j4;
                }
                if ((i3 & 65536) != 0) {
                    frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 6);
                    i21 = (-3670017) & i21;
                } else {
                    frontLayerScrimColor = j5;
                }
                if (i19 != 0) {
                    interfaceC0552GpM1075getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1075getLambda1$material_release();
                } else {
                    interfaceC0552GpM1075getLambda1$material_release = interfaceC0552Gp;
                }
                f4 = fM984getPeekHeightD9Ej5fM;
                z7 = z4;
                z8 = z5;
                j6 = jM1051getPrimary0d7_KjU;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1397420093, i15, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
            }
            float fMo333toPx0680j_1115 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f4);
            fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(fM983getHeaderHeightD9Ej5fM);
            ComposableLambda composableLambda1111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1744778315, true, new BackdropScaffoldKt$BackdropScaffold$backLayer$1(z8, backdropScaffoldStateRememberBackdropScaffoldState, interfaceC0526Fp, interfaceC0526Fp2, i15));
            Float fValueOf1111 = Float.valueOf(fMo333toPx0680j_4);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(fValueOf1111);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(fMo333toPx0680j_4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            int i31111110 = i21;
            float f1111118 = fM983getHeaderHeightD9Ej5fM;
            float f1111119 = f4;
            Modifier modifier1115 = modifier3;
            composer2 = composerStartRestartGroup;
            int i31111111 = i31111110 << 6;
            SurfaceKt.m1227SurfaceFjzlyU(null, null, j6, jM1069contentColorForek8zF_U, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1049909631, true, new BackdropScaffoldKt$BackdropScaffold$1(modifier3, composableLambda1111, (InterfaceC3750qp) objRememberedValue, fMo333toPx0680j_4, z6, z7, backdropScaffoldStateRememberBackdropScaffoldState, fMo333toPx0680j_1115, i15, frontLayerShape, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U2, fM982getFrontLayerElevationD9Ej5fM, i31111110, f1111118, f1111119, interfaceC0526Fp3, frontLayerScrimColor, interfaceC0552GpM1075getLambda1$material_release)), composer2, (i31111111 & 7168) | (i31111111 & 896) | 1572864, 51);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier1115;
            backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
            z9 = z7;
            z10 = z8;
            z11 = z6;
            j7 = j6;
            j8 = jM1069contentColorForek8zF_U;
            shape3 = frontLayerShape;
            f5 = fM982getFrontLayerElevationD9Ej5fM;
            j9 = jM1055getSurface0d7_KjU;
            j10 = jM1069contentColorForek8zF_U2;
            j11 = frontLayerScrimColor;
            interfaceC0552Gp3 = interfaceC0552GpM1075getLambda1$material_release;
            f6 = f1111118;
            f7 = f1111119;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new BackdropScaffoldKt$BackdropScaffold$2(interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, modifier4, backdropScaffoldState2, z9, f7, f6, z10, z11, j7, j8, shape3, f5, j9, j10, j11, interfaceC0552Gp3, i, i2, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @UiComposable
    public static final void BackdropStack(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, InterfaceC3750qp interfaceC3750qp, InterfaceC0578Hp interfaceC0578Hp, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1248995194);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC3750qp) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0578Hp) ? 2048 : 1024;
        }
        if ((i2 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1248995194, i2, -1, "androidx.compose.material.BackdropStack (BackdropScaffold.kt:451)");
            }
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            boolean zChanged = composerStartRestartGroup.changed(interfaceC0526Fp) | composerStartRestartGroup.changed(interfaceC3750qp) | composerStartRestartGroup.changed(interfaceC0578Hp);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new BackdropScaffoldKt$BackdropStack$1$1(interfaceC0526Fp, interfaceC3750qp, interfaceC0578Hp, i2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(modifier, (InterfaceC0526Fp) objRememberedValue, composerStartRestartGroup, i2 & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C14102(modifier, interfaceC0526Fp, interfaceC3750qp, interfaceC0578Hp, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m986Scrim3JVO9M(long j, InterfaceC3588op interfaceC3588op, boolean z, Composer composer, int i) {
        int i2;
        Modifier modifierPointerInput;
        Composer composerStartRestartGroup = composer.startRestartGroup(-92141505);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC3588op) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-92141505, i2, -1, "androidx.compose.material.Scrim (BackdropScaffold.kt:382)");
            }
            if (j != Color.Companion.m3068getUnspecified0d7_KjU()) {
                State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, composerStartRestartGroup, 48, 28);
                composerStartRestartGroup.startReplaceableGroup(1010547004);
                if (z) {
                    Modifier.Companion companion = Modifier.Companion;
                    FW fw = FW.a;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    boolean zChanged = composerStartRestartGroup.changed(interfaceC3588op);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new BackdropScaffoldKt$Scrim$dismissModifier$1$1(interfaceC3588op, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, fw, (InterfaceC0526Fp) objRememberedValue);
                } else {
                    modifierPointerInput = Modifier.Companion;
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null).then(modifierPointerInput);
                Color colorM3022boximpl = Color.m3022boximpl(j);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                boolean zChanged2 = composerStartRestartGroup.changed(colorM3022boximpl) | composerStartRestartGroup.changed(stateAnimateFloatAsState);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new BackdropScaffoldKt$Scrim$1$1(j, stateAnimateFloatAsState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierThen, (InterfaceC3750qp) objRememberedValue2, composerStartRestartGroup, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new BackdropScaffoldKt$Scrim$2(j, interfaceC3588op, z, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Scrim_3J_VO9M$lambda$4(State<Float> state) {
        return state.getValue().floatValue();
    }

    @Composable
    @ExperimentalMaterialApi
    public static final BackdropScaffoldState rememberBackdropScaffoldState(BackdropValue backdropValue, AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        AbstractC4492zt.h(backdropValue, "initialValue");
        composer.startReplaceableGroup(-862178912);
        if ((i2 & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i2 & 4) != 0) {
            interfaceC3750qp = AnonymousClass1.INSTANCE;
        }
        if ((i2 & 8) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) objRememberedValue;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-862178912, i, -1, "androidx.compose.material.rememberBackdropScaffoldState (BackdropScaffold.kt:167)");
        }
        BackdropScaffoldState backdropScaffoldState = (BackdropScaffoldState) RememberSaveableKt.m2674rememberSaveable(new Object[]{animationSpec, interfaceC3750qp, snackbarHostState}, (Saver) BackdropScaffoldState.Companion.Saver(animationSpec, interfaceC3750qp, snackbarHostState), (String) null, (InterfaceC3588op) new AnonymousClass3(backdropValue, animationSpec, interfaceC3750qp, snackbarHostState), composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return backdropScaffoldState;
    }
}
