package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import defpackage.YB;
import defpackage.ZB;

/* JADX INFO: loaded from: classes.dex */
final class PointerIconModifierLocal implements PointerIcon, ModifierLocalProvider<PointerIconModifierLocal>, ModifierLocalConsumer {
    private PointerIcon icon;
    private boolean isHovered;
    private boolean isPaused;
    private final ProvidableModifierLocal<PointerIconModifierLocal> key;
    private InterfaceC3750qp onSetIcon;
    private boolean overrideDescendants;
    private final MutableState parentInfo$delegate;
    private final PointerIconModifierLocal value;

    public PointerIconModifierLocal(PointerIcon pointerIcon, boolean z, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(pointerIcon, "icon");
        AbstractC4492zt.h(interfaceC3750qp, "onSetIcon");
        this.icon = pointerIcon;
        this.overrideDescendants = z;
        this.onSetIcon = interfaceC3750qp;
        this.parentInfo$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.key = PointerIconKt.ModifierLocalPointerIcon;
        this.value = this;
    }

    private final PointerIconModifierLocal getParentInfo() {
        return (PointerIconModifierLocal) this.parentInfo$delegate.getValue();
    }

    private final boolean hasOverride() {
        if (this.overrideDescendants) {
            return true;
        }
        PointerIconModifierLocal parentInfo = getParentInfo();
        return parentInfo != null && parentInfo.hasOverride();
    }

    private final void pause() {
        this.isPaused = true;
        PointerIconModifierLocal parentInfo = getParentInfo();
        if (parentInfo != null) {
            parentInfo.pause();
        }
    }

    private final void reassignIcon() {
        this.isPaused = false;
        if (this.isHovered) {
            this.onSetIcon.invoke(this.icon);
            return;
        }
        if (getParentInfo() == null) {
            this.onSetIcon.invoke(null);
            return;
        }
        PointerIconModifierLocal parentInfo = getParentInfo();
        if (parentInfo != null) {
            parentInfo.reassignIcon();
        }
    }

    private final void setParentInfo(PointerIconModifierLocal pointerIconModifierLocal) {
        this.parentInfo$delegate.setValue(pointerIconModifierLocal);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(InterfaceC3750qp interfaceC3750qp) {
        return ZB.a(this, interfaceC3750qp);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(InterfaceC3750qp interfaceC3750qp) {
        return ZB.b(this, interfaceC3750qp);
    }

    public final void enter() {
        this.isHovered = true;
        if (this.isPaused) {
            return;
        }
        PointerIconModifierLocal parentInfo = getParentInfo();
        if (parentInfo != null) {
            parentInfo.pause();
        }
        this.onSetIcon.invoke(this.icon);
    }

    public final void exit() {
        exit(getParentInfo());
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, InterfaceC0526Fp interfaceC0526Fp) {
        return ZB.c(this, obj, interfaceC0526Fp);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, InterfaceC0526Fp interfaceC0526Fp) {
        return ZB.d(this, obj, interfaceC0526Fp);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public ProvidableModifierLocal<PointerIconModifierLocal> getKey() {
        return this.key;
    }

    public final boolean isHovered() {
        return this.isHovered;
    }

    public final boolean isPaused() {
        return this.isPaused;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(ModifierLocalReadScope modifierLocalReadScope) {
        AbstractC4492zt.h(modifierLocalReadScope, "scope");
        PointerIconModifierLocal parentInfo = getParentInfo();
        setParentInfo((PointerIconModifierLocal) modifierLocalReadScope.getCurrent(PointerIconKt.ModifierLocalPointerIcon));
        if (parentInfo == null || getParentInfo() != null) {
            return;
        }
        exit(parentInfo);
        this.onSetIcon = PointerIconModifierLocal$onModifierLocalsUpdated$1$1.INSTANCE;
    }

    public final void setHovered(boolean z) {
        this.isHovered = z;
    }

    public final void setPaused(boolean z) {
        this.isPaused = z;
    }

    public final boolean shouldUpdatePointerIcon() {
        PointerIconModifierLocal parentInfo = getParentInfo();
        return parentInfo == null || !parentInfo.hasOverride();
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return YB.a(this, modifier);
    }

    public final void updateValues(PointerIcon pointerIcon, boolean z, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(pointerIcon, "icon");
        AbstractC4492zt.h(interfaceC3750qp, "onSetIcon");
        if (!AbstractC4492zt.d(this.icon, pointerIcon) && this.isHovered && !this.isPaused) {
            interfaceC3750qp.invoke(pointerIcon);
        }
        this.icon = pointerIcon;
        this.overrideDescendants = z;
        this.onSetIcon = interfaceC3750qp;
    }

    private final void exit(PointerIconModifierLocal pointerIconModifierLocal) {
        if (this.isHovered) {
            if (pointerIconModifierLocal == null) {
                this.onSetIcon.invoke(null);
            } else {
                pointerIconModifierLocal.reassignIcon();
            }
        }
        this.isHovered = false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public PointerIconModifierLocal getValue() {
        return this.value;
    }
}
