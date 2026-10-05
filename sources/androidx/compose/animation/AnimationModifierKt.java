package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.IntSize;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C1172Zk;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC2052dg;

/* JADX INFO: loaded from: classes.dex */
public final class AnimationModifierKt {

    /* JADX INFO: renamed from: androidx.compose.animation.AnimationModifierKt$animateContentSize$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ FiniteAnimationSpec<IntSize> $animationSpec;
        final /* synthetic */ InterfaceC0526Fp $finishedListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC0526Fp interfaceC0526Fp, FiniteAnimationSpec<IntSize> finiteAnimationSpec) {
            super(3);
            this.$finishedListener = interfaceC0526Fp;
            this.$animationSpec = finiteAnimationSpec;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
        }

        @Composable
        public final Modifier invoke(Modifier modifier, Composer composer, int i) {
            AbstractC4492zt.h(modifier, "$this$composed");
            composer.startReplaceableGroup(-843180607);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-843180607, i, -1, "androidx.compose.animation.animateContentSize.<anonymous> (AnimationModifier.kt:76)");
            }
            composer.startReplaceableGroup(773894976);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composer));
                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            composer.endReplaceableGroup();
            InterfaceC2052dg coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composer.endReplaceableGroup();
            FiniteAnimationSpec<IntSize> finiteAnimationSpec = this.$animationSpec;
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(coroutineScope);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new SizeAnimationModifier(finiteAnimationSpec, coroutineScope);
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            SizeAnimationModifier sizeAnimationModifier = (SizeAnimationModifier) objRememberedValue2;
            sizeAnimationModifier.setListener(this.$finishedListener);
            Modifier modifierThen = ClipKt.clipToBounds(modifier).then(sizeAnimationModifier);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return modifierThen;
        }
    }

    public static final Modifier animateContentSize(Modifier modifier, FiniteAnimationSpec<IntSize> finiteAnimationSpec, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(finiteAnimationSpec, "animationSpec");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new AnimationModifierKt$animateContentSize$$inlined$debugInspectorInfo$1(finiteAnimationSpec, interfaceC0526Fp) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(interfaceC0526Fp, finiteAnimationSpec));
    }

    public static /* synthetic */ Modifier animateContentSize$default(Modifier modifier, FiniteAnimationSpec finiteAnimationSpec, InterfaceC0526Fp interfaceC0526Fp, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        if ((i & 2) != 0) {
            interfaceC0526Fp = null;
        }
        return animateContentSize(modifier, finiteAnimationSpec, interfaceC0526Fp);
    }
}
