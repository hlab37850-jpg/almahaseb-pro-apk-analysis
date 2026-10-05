package androidx.compose.ui.modifier;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class SingleLocalMap extends ModifierLocalMap {
    private final ModifierLocal<?> key;
    private final MutableState value$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleLocalMap(ModifierLocal<?> modifierLocal) {
        super(null);
        AbstractC4492zt.h(modifierLocal, "key");
        this.key = modifierLocal;
        this.value$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    private final Object getValue() {
        return this.value$delegate.getValue();
    }

    private final void setValue(Object obj) {
        this.value$delegate.setValue(obj);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public boolean contains$ui_release(ModifierLocal<?> modifierLocal) {
        AbstractC4492zt.h(modifierLocal, "key");
        return modifierLocal == this.key;
    }

    public final void forceValue$ui_release(Object obj) {
        setValue(obj);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public <T> T get$ui_release(ModifierLocal<T> modifierLocal) {
        AbstractC4492zt.h(modifierLocal, "key");
        if (modifierLocal != this.key) {
            throw new IllegalStateException("Check failed.");
        }
        T t = (T) getValue();
        if (t == null) {
            return null;
        }
        return t;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    /* JADX INFO: renamed from: set$ui_release */
    public <T> void mo4243set$ui_release(ModifierLocal<T> modifierLocal, T t) {
        AbstractC4492zt.h(modifierLocal, "key");
        if (modifierLocal != this.key) {
            throw new IllegalStateException("Check failed.");
        }
        setValue(t);
    }
}
