package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidAlertDialog_androidKt$AlertDialog$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ InterfaceC0526Fp $confirmButton;
    final /* synthetic */ InterfaceC0526Fp $dismissButton;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidAlertDialog_androidKt$AlertDialog$1(InterfaceC0526Fp interfaceC0526Fp, int i, InterfaceC0526Fp interfaceC0526Fp2) {
        super(2);
        this.$dismissButton = interfaceC0526Fp;
        this.$$dirty = i;
        this.$confirmButton = interfaceC0526Fp2;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return FW.a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(Composer composer, int i) {
        if ((i & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1849673151, i, -1, "androidx.compose.material.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:77)");
        }
        float f = 8;
        Modifier modifierM486paddingVpY3zN4 = PaddingKt.m486paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Dp.m5160constructorimpl(f), Dp.m5160constructorimpl(2));
        InterfaceC0526Fp interfaceC0526Fp = this.$dismissButton;
        int i2 = this.$$dirty;
        InterfaceC0526Fp interfaceC0526Fp2 = this.$confirmButton;
        composer.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer, 0);
        composer.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        InterfaceC3588op constructor = companion.getConstructor();
        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierM486paddingVpY3zN4);
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composer);
        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
        InterfaceC0526Fp setCompositeKeyHash = companion.getSetCompositeKeyHash();
        if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        AlertDialogKt.m969AlertDialogFlowRowixp7dh8(Dp.m5160constructorimpl(f), Dp.m5160constructorimpl(12), ComposableLambdaKt.composableLambda(composer, 1789213604, true, new AndroidAlertDialog_androidKt$AlertDialog$1$1$1(interfaceC0526Fp, i2, interfaceC0526Fp2)), composer, 438);
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
