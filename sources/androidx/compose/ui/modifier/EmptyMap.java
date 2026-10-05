package androidx.compose.ui.modifier;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class EmptyMap extends ModifierLocalMap {
    public static final EmptyMap INSTANCE = new EmptyMap();

    private EmptyMap() {
        super(null);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public boolean contains$ui_release(ModifierLocal<?> modifierLocal) {
        AbstractC4492zt.h(modifierLocal, "key");
        return false;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public <T> T get$ui_release(ModifierLocal<T> modifierLocal) {
        AbstractC4492zt.h(modifierLocal, "key");
        throw new IllegalStateException("");
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    /* JADX INFO: renamed from: set$ui_release, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ void mo4243set$ui_release(ModifierLocal modifierLocal, Object obj) {
        set$ui_release((ModifierLocal<Object>) modifierLocal, obj);
    }

    public <T> Void set$ui_release(ModifierLocal<T> modifierLocal, T t) {
        AbstractC4492zt.h(modifierLocal, "key");
        throw new IllegalStateException("");
    }
}
