package androidx.compose.foundation.selection;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.state.ToggleableStateKt;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ToggleableKt {
    /* JADX INFO: renamed from: toggleable-O2vRcR0, reason: not valid java name */
    public static final Modifier m711toggleableO2vRcR0(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z2, Role role, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(modifier, "$this$toggleable");
        AbstractC4492zt.h(mutableInteractionSource, "interactionSource");
        AbstractC4492zt.h(interfaceC3750qp, "onValueChange");
        return InspectableValueKt.inspectableWrapper(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ToggleableKt$toggleableO2vRcR0$$inlined$debugInspectorInfo$1(z, mutableInteractionSource, indication, z2, role, interfaceC3750qp) : InspectableValueKt.getNoInspectorInfo(), m715triStateToggleableO2vRcR0(Modifier.Companion, ToggleableStateKt.ToggleableState(z), mutableInteractionSource, indication, z2, role, new ToggleableKt$toggleable$4$1(interfaceC3750qp, z)));
    }

    /* JADX INFO: renamed from: toggleable-O2vRcR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m712toggleableO2vRcR0$default(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z2, Role role, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        boolean z3 = (i & 8) != 0 ? true : z2;
        if ((i & 16) != 0) {
            role = null;
        }
        return m711toggleableO2vRcR0(modifier, z, mutableInteractionSource, indication, z3, role, interfaceC3750qp);
    }

    /* JADX INFO: renamed from: toggleable-XHw0xAI, reason: not valid java name */
    public static final Modifier m713toggleableXHw0xAI(Modifier modifier, boolean z, boolean z2, Role role, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(modifier, "$this$toggleable");
        AbstractC4492zt.h(interfaceC3750qp, "onValueChange");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ToggleableKt$toggleableXHw0xAI$$inlined$debugInspectorInfo$1(z, z2, role, interfaceC3750qp) : InspectableValueKt.getNoInspectorInfo(), new ToggleableKt$toggleable$2(z, z2, role, interfaceC3750qp));
    }

    /* JADX INFO: renamed from: toggleable-XHw0xAI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m714toggleableXHw0xAI$default(Modifier modifier, boolean z, boolean z2, Role role, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m713toggleableXHw0xAI(modifier, z, z2, role, interfaceC3750qp);
    }

    /* JADX INFO: renamed from: triStateToggleable-O2vRcR0, reason: not valid java name */
    public static final Modifier m715triStateToggleableO2vRcR0(Modifier modifier, ToggleableState toggleableState, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, Role role, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(modifier, "$this$triStateToggleable");
        AbstractC4492zt.h(toggleableState, "state");
        AbstractC4492zt.h(mutableInteractionSource, "interactionSource");
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        return InspectableValueKt.inspectableWrapper(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ToggleableKt$triStateToggleableO2vRcR0$$inlined$debugInspectorInfo$1(toggleableState, z, role, mutableInteractionSource, indication, interfaceC3588op) : InspectableValueKt.getNoInspectorInfo(), SemanticsModifierKt.semantics$default(ClickableKt.m197clickableO2vRcR0(Modifier.Companion, mutableInteractionSource, indication, (24 & 4) != 0 ? true : z, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : role, interfaceC3588op), false, new ToggleableKt$triStateToggleable$4$1(toggleableState), 1, null));
    }

    /* JADX INFO: renamed from: triStateToggleable-O2vRcR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m716triStateToggleableO2vRcR0$default(Modifier modifier, ToggleableState toggleableState, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, Role role, InterfaceC3588op interfaceC3588op, int i, Object obj) {
        boolean z2 = (i & 8) != 0 ? true : z;
        if ((i & 16) != 0) {
            role = null;
        }
        return m715triStateToggleableO2vRcR0(modifier, toggleableState, mutableInteractionSource, indication, z2, role, interfaceC3588op);
    }

    /* JADX INFO: renamed from: triStateToggleable-XHw0xAI, reason: not valid java name */
    public static final Modifier m717triStateToggleableXHw0xAI(Modifier modifier, ToggleableState toggleableState, boolean z, Role role, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(modifier, "$this$triStateToggleable");
        AbstractC4492zt.h(toggleableState, "state");
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ToggleableKt$triStateToggleableXHw0xAI$$inlined$debugInspectorInfo$1(toggleableState, z, role, interfaceC3588op) : InspectableValueKt.getNoInspectorInfo(), new ToggleableKt$triStateToggleable$2(toggleableState, z, role, interfaceC3588op));
    }

    /* JADX INFO: renamed from: triStateToggleable-XHw0xAI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m718triStateToggleableXHw0xAI$default(Modifier modifier, ToggleableState toggleableState, boolean z, Role role, InterfaceC3588op interfaceC3588op, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m717triStateToggleableXHw0xAI(modifier, toggleableState, z, role, interfaceC3588op);
    }
}
