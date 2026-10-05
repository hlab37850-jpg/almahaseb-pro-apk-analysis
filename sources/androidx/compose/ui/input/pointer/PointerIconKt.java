package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class PointerIconKt {
    private static final ProvidableModifierLocal<PointerIconModifierLocal> ModifierLocalPointerIcon = ModifierLocalKt.modifierLocalOf(PointerIconKt$ModifierLocalPointerIcon$1.INSTANCE);

    /* JADX INFO: renamed from: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ PointerIcon $icon;
        final /* synthetic */ boolean $overrideDescendants;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(PointerIcon pointerIcon, boolean z) {
            super(3);
            this.$icon = pointerIcon;
            this.$overrideDescendants = z;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
        }

        @Composable
        public final Modifier invoke(Modifier modifier, Composer composer, int i) {
            Modifier modifierPointerInput;
            Modifier modifierThen;
            AbstractC4492zt.h(modifier, "$this$composed");
            composer.startReplaceableGroup(811087536);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(811087536, i, -1, "androidx.compose.ui.input.pointer.pointerHoverIcon.<anonymous> (PointerIcon.kt:89)");
            }
            PointerIconService pointerIconService = (PointerIconService) composer.consume(CompositionLocalsKt.getLocalPointerIconService());
            if (pointerIconService == null) {
                modifierThen = Modifier.Companion;
            } else {
                PointerIconKt$pointerHoverIcon$2$onSetIcon$1 pointerIconKt$pointerHoverIcon$2$onSetIcon$1 = new PointerIconKt$pointerHoverIcon$2$onSetIcon$1(pointerIconService);
                PointerIcon pointerIcon = this.$icon;
                boolean z = this.$overrideDescendants;
                composer.startReplaceableGroup(-492369756);
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new PointerIconModifierLocal(pointerIcon, z, pointerIconKt$pointerHoverIcon$2$onSetIcon$1);
                    composer.updateRememberedValue(objRememberedValue);
                }
                composer.endReplaceableGroup();
                PointerIconModifierLocal pointerIconModifierLocal = (PointerIconModifierLocal) objRememberedValue;
                Object[] objArr = {pointerIconModifierLocal, this.$icon, Boolean.valueOf(this.$overrideDescendants), pointerIconKt$pointerHoverIcon$2$onSetIcon$1};
                PointerIcon pointerIcon2 = this.$icon;
                boolean z2 = this.$overrideDescendants;
                composer.startReplaceableGroup(-568225417);
                boolean zChanged = false;
                for (int i2 = 0; i2 < 4; i2++) {
                    zChanged |= composer.changed(objArr[i2]);
                }
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new PointerIconKt$pointerHoverIcon$2$1$1(pointerIconModifierLocal, pointerIcon2, z2, pointerIconKt$pointerHoverIcon$2$onSetIcon$1);
                    composer.updateRememberedValue(objRememberedValue2);
                }
                composer.endReplaceableGroup();
                EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue2, composer, 0);
                if (pointerIconModifierLocal.shouldUpdatePointerIcon()) {
                    composer.startReplaceableGroup(1157296644);
                    boolean zChanged2 = composer.changed(pointerIconModifierLocal);
                    Object objRememberedValue3 = composer.rememberedValue();
                    if (zChanged2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                        objRememberedValue3 = new PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1(pointerIconModifierLocal, null);
                        composer.updateRememberedValue(objRememberedValue3);
                    }
                    composer.endReplaceableGroup();
                    modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier, pointerIconModifierLocal, (InterfaceC0526Fp) objRememberedValue3);
                } else {
                    modifierPointerInput = Modifier.Companion;
                }
                modifierThen = pointerIconModifierLocal.then(modifierPointerInput);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return modifierThen;
        }
    }

    @Stable
    public static final Modifier pointerHoverIcon(Modifier modifier, PointerIcon pointerIcon, boolean z) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(pointerIcon, "icon");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new PointerIconKt$pointerHoverIcon$$inlined$debugInspectorInfo$1(pointerIcon, z) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(pointerIcon, z));
    }

    public static /* synthetic */ Modifier pointerHoverIcon$default(Modifier modifier, PointerIcon pointerIcon, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return pointerHoverIcon(modifier, pointerIcon, z);
    }
}
