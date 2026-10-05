package androidx.compose.foundation.selection;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class SelectableKt {
    /* JADX INFO: renamed from: selectable-O2vRcR0, reason: not valid java name */
    public static final Modifier m707selectableO2vRcR0(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z2, Role role, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(modifier, "$this$selectable");
        AbstractC4492zt.h(mutableInteractionSource, "interactionSource");
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        return InspectableValueKt.inspectableWrapper(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SelectableKt$selectableO2vRcR0$$inlined$debugInspectorInfo$1(z, mutableInteractionSource, indication, z2, role, interfaceC3588op) : InspectableValueKt.getNoInspectorInfo(), SemanticsModifierKt.semantics$default(ClickableKt.m197clickableO2vRcR0(Modifier.Companion, mutableInteractionSource, indication, (24 & 4) != 0 ? true : z2, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : role, interfaceC3588op), false, new SelectableKt$selectable$4$1(z), 1, null));
    }

    /* JADX INFO: renamed from: selectable-O2vRcR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m708selectableO2vRcR0$default(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z2, Role role, InterfaceC3588op interfaceC3588op, int i, Object obj) {
        boolean z3 = (i & 8) != 0 ? true : z2;
        if ((i & 16) != 0) {
            role = null;
        }
        return m707selectableO2vRcR0(modifier, z, mutableInteractionSource, indication, z3, role, interfaceC3588op);
    }

    /* JADX INFO: renamed from: selectable-XHw0xAI, reason: not valid java name */
    public static final Modifier m709selectableXHw0xAI(Modifier modifier, boolean z, boolean z2, Role role, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(modifier, "$this$selectable");
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SelectableKt$selectableXHw0xAI$$inlined$debugInspectorInfo$1(z, z2, role, interfaceC3588op) : InspectableValueKt.getNoInspectorInfo(), new SelectableKt$selectable$2(z, z2, role, interfaceC3588op));
    }

    /* JADX INFO: renamed from: selectable-XHw0xAI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m710selectableXHw0xAI$default(Modifier modifier, boolean z, boolean z2, Role role, InterfaceC3588op interfaceC3588op, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m709selectableXHw0xAI(modifier, z, z2, role, interfaceC3588op);
    }
}
