package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import defpackage.AbstractC1777bC;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.HV;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class FocusedBoundsObserverNode extends Modifier.Node implements ModifierLocalModifierNode, InterfaceC3750qp {
    private InterfaceC3750qp onPositioned;
    private final ModifierLocalMap providedValues;

    public FocusedBoundsObserverNode(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "onPositioned");
        this.onPositioned = interfaceC3750qp;
        this.providedValues = ModifierLocalModifierNodeKt.modifierLocalMapOf(HV.a(FocusedBoundsKt.getModifierLocalFocusedBoundsObserver(), this));
    }

    private final InterfaceC3750qp getParent() {
        if (isAttached()) {
            return (InterfaceC3750qp) getCurrent(FocusedBoundsKt.getModifierLocalFocusedBoundsObserver());
        }
        return null;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode, androidx.compose.ui.modifier.ModifierLocalReadScope
    public /* synthetic */ Object getCurrent(ModifierLocal modifierLocal) {
        return AbstractC1777bC.a(this, modifierLocal);
    }

    public final InterfaceC3750qp getOnPositioned() {
        return this.onPositioned;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public ModifierLocalMap getProvidedValues() {
        return this.providedValues;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return FW.a;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public /* synthetic */ void provide(ModifierLocal modifierLocal, Object obj) {
        AbstractC1777bC.c(this, modifierLocal, obj);
    }

    public final void setOnPositioned(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "<set-?>");
        this.onPositioned = interfaceC3750qp;
    }

    public void invoke(LayoutCoordinates layoutCoordinates) {
        if (isAttached()) {
            this.onPositioned.invoke(layoutCoordinates);
            InterfaceC3750qp parent = getParent();
            if (parent != null) {
                parent.invoke(layoutCoordinates);
            }
        }
    }
}
