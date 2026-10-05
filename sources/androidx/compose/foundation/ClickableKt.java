package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.Role;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2133eg;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3588op;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ClickableKt {
    /* JADX INFO: renamed from: clickable-O2vRcR0, reason: not valid java name */
    public static final Modifier m197clickableO2vRcR0(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(modifier, "$this$clickable");
        AbstractC4492zt.h(mutableInteractionSource, "interactionSource");
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        return InspectableValueKt.inspectableWrapper(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$clickableO2vRcR0$$inlined$debugInspectorInfo$1(mutableInteractionSource, indication, z, str, role, interfaceC3588op) : InspectableValueKt.getNoInspectorInfo(), FocusableKt.focusableInNonTouchMode(HoverableKt.hoverable(IndicationKt.indication(Modifier.Companion, mutableInteractionSource, indication), mutableInteractionSource, z), z, mutableInteractionSource).then(new ClickableElement(mutableInteractionSource, z, str, role, interfaceC3588op, null)));
    }

    /* JADX INFO: renamed from: clickable-XHw0xAI, reason: not valid java name */
    public static final Modifier m199clickableXHw0xAI(Modifier modifier, boolean z, String str, Role role, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(modifier, "$this$clickable");
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$clickableXHw0xAI$$inlined$debugInspectorInfo$1(z, str, role, interfaceC3588op) : InspectableValueKt.getNoInspectorInfo(), new ClickableKt$clickable$2(z, str, role, interfaceC3588op));
    }

    /* JADX INFO: renamed from: clickable-XHw0xAI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m200clickableXHw0xAI$default(Modifier modifier, boolean z, String str, Role role, InterfaceC3588op interfaceC3588op, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m199clickableXHw0xAI(modifier, z, str, role, interfaceC3588op);
    }

    @ExperimentalFoundationApi
    /* JADX INFO: renamed from: combinedClickable-XVZzFYc, reason: not valid java name */
    public static final Modifier m201combinedClickableXVZzFYc(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, String str2, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, InterfaceC3588op interfaceC3588op3) {
        AbstractC4492zt.h(modifier, "$this$combinedClickable");
        AbstractC4492zt.h(mutableInteractionSource, "interactionSource");
        AbstractC4492zt.h(interfaceC3588op3, "onClick");
        return InspectableValueKt.inspectableWrapper(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$combinedClickableXVZzFYc$$inlined$debugInspectorInfo$1(indication, mutableInteractionSource, z, str, role, interfaceC3588op3, interfaceC3588op2, interfaceC3588op, str2) : InspectableValueKt.getNoInspectorInfo(), FocusableKt.focusableInNonTouchMode(HoverableKt.hoverable(IndicationKt.indication(Modifier.Companion, mutableInteractionSource, indication), mutableInteractionSource, z), z, mutableInteractionSource).then(new CombinedClickableElement(mutableInteractionSource, z, str, role, interfaceC3588op3, str2, interfaceC3588op, interfaceC3588op2, null)));
    }

    @ExperimentalFoundationApi
    /* JADX INFO: renamed from: combinedClickable-cJG_KMw, reason: not valid java name */
    public static final Modifier m203combinedClickablecJG_KMw(Modifier modifier, boolean z, String str, Role role, String str2, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, InterfaceC3588op interfaceC3588op3) {
        AbstractC4492zt.h(modifier, "$this$combinedClickable");
        AbstractC4492zt.h(interfaceC3588op3, "onClick");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$combinedClickablecJG_KMw$$inlined$debugInspectorInfo$1(z, str, role, interfaceC3588op3, interfaceC3588op2, interfaceC3588op, str2) : InspectableValueKt.getNoInspectorInfo(), new ClickableKt$combinedClickable$2(z, str, role, str2, interfaceC3588op, interfaceC3588op2, interfaceC3588op3));
    }

    /* JADX INFO: renamed from: genericClickableWithoutGesture-Kqv-Bsg, reason: not valid java name */
    public static final Modifier m205genericClickableWithoutGestureKqvBsg(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, InterfaceC2052dg interfaceC2052dg, Map<Key, PressInteraction.Press> map, State<Offset> state, boolean z, String str, Role role, String str2, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2) {
        AbstractC4492zt.h(modifier, "$this$genericClickableWithoutGesture");
        AbstractC4492zt.h(mutableInteractionSource, "interactionSource");
        AbstractC4492zt.h(interfaceC2052dg, "indicationScope");
        AbstractC4492zt.h(map, "currentKeyPressInteractions");
        AbstractC4492zt.h(state, "keyClickOffset");
        AbstractC4492zt.h(interfaceC3588op2, "onClick");
        return modifier.then(FocusableKt.focusableInNonTouchMode(HoverableKt.hoverable(IndicationKt.indication(genericClickableWithoutGesture_Kqv_Bsg$detectPressAndClickFromKey(new ClickableSemanticsElement(z, role, str2, interfaceC3588op, str, interfaceC3588op2, null), z, map, state, interfaceC2052dg, interfaceC3588op2, mutableInteractionSource), mutableInteractionSource, indication), mutableInteractionSource, z), z, mutableInteractionSource));
    }

    private static final Modifier genericClickableWithoutGesture_Kqv_Bsg$detectPressAndClickFromKey(Modifier modifier, boolean z, Map<Key, PressInteraction.Press> map, State<Offset> state, InterfaceC2052dg interfaceC2052dg, InterfaceC3588op interfaceC3588op, MutableInteractionSource mutableInteractionSource) {
        return KeyInputModifierKt.onKeyEvent(modifier, new ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1(z, map, state, interfaceC2052dg, interfaceC3588op, mutableInteractionSource));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handlePressInteraction-EPk0efs, reason: not valid java name */
    public static final Object m207handlePressInteractionEPk0efs(PressGestureScope pressGestureScope, long j, MutableInteractionSource mutableInteractionSource, AbstractClickableNode.InteractionData interactionData, InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
        Object objD = AbstractC2133eg.d(new ClickableKt$handlePressInteraction$2(pressGestureScope, j, mutableInteractionSource, interactionData, interfaceC3588op, null), interfaceC0793Of);
        return objD == AbstractC0378Bt.d() ? objD : FW.a;
    }
}
