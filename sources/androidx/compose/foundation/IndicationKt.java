package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
public final class IndicationKt {
    private static final ProvidableCompositionLocal<Indication> LocalIndication = CompositionLocalKt.staticCompositionLocalOf(IndicationKt$LocalIndication$1.INSTANCE);

    /* JADX INFO: renamed from: androidx.compose.foundation.IndicationKt$indication$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ Indication $indication;
        final /* synthetic */ InteractionSource $interactionSource;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Indication indication, InteractionSource interactionSource) {
            super(3);
            this.$indication = indication;
            this.$interactionSource = interactionSource;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
        }

        @Composable
        public final Modifier invoke(Modifier modifier, Composer composer, int i) {
            AbstractC4492zt.h(modifier, "$this$composed");
            composer.startReplaceableGroup(-353972293);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-353972293, i, -1, "androidx.compose.foundation.indication.<anonymous> (Indication.kt:107)");
            }
            Indication indication = this.$indication;
            if (indication == null) {
                indication = NoIndication.INSTANCE;
            }
            IndicationInstance indicationInstanceRememberUpdatedInstance = indication.rememberUpdatedInstance(this.$interactionSource, composer, 0);
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(indicationInstanceRememberUpdatedInstance);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new IndicationModifier(indicationInstanceRememberUpdatedInstance);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            IndicationModifier indicationModifier = (IndicationModifier) objRememberedValue;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return indicationModifier;
        }
    }

    public static final ProvidableCompositionLocal<Indication> getLocalIndication() {
        return LocalIndication;
    }

    public static final Modifier indication(Modifier modifier, InteractionSource interactionSource, Indication indication) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interactionSource, "interactionSource");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new IndicationKt$indication$$inlined$debugInspectorInfo$1(indication, interactionSource) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(indication, interactionSource));
    }
}
