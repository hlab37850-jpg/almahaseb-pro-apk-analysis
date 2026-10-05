package androidx.compose.ui.modifier;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class BackwardsCompatLocalMap extends ModifierLocalMap {
    private ModifierLocalProvider<?> element;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackwardsCompatLocalMap(ModifierLocalProvider<?> modifierLocalProvider) {
        super(null);
        AbstractC4492zt.h(modifierLocalProvider, "element");
        this.element = modifierLocalProvider;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public boolean contains$ui_release(ModifierLocal<?> modifierLocal) {
        AbstractC4492zt.h(modifierLocal, "key");
        return modifierLocal == this.element.getKey();
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public <T> T get$ui_release(ModifierLocal<T> modifierLocal) {
        AbstractC4492zt.h(modifierLocal, "key");
        if (modifierLocal == this.element.getKey()) {
            return (T) this.element.getValue();
        }
        throw new IllegalStateException("Check failed.");
    }

    public final ModifierLocalProvider<?> getElement() {
        return this.element;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    /* JADX INFO: renamed from: set$ui_release */
    public <T> void mo4243set$ui_release(ModifierLocal<T> modifierLocal, T t) {
        AbstractC4492zt.h(modifierLocal, "key");
        throw new IllegalStateException("Set is not allowed on a backwards compat provider");
    }

    public final void setElement(ModifierLocalProvider<?> modifierLocalProvider) {
        AbstractC4492zt.h(modifierLocalProvider, "<set-?>");
        this.element = modifierLocalProvider;
    }
}
