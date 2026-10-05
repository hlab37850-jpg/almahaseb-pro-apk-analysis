package androidx.compose.ui.modifier;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;

/* JADX INFO: loaded from: classes.dex */
public final class MultiLocalMap extends ModifierLocalMap {
    private final SnapshotStateMap<ModifierLocal<?>, Object> map;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiLocalMap(C2020dG... c2020dGArr) {
        super(null);
        AbstractC4492zt.h(c2020dGArr, "entries");
        SnapshotStateMap<ModifierLocal<?>, Object> snapshotStateMapMutableStateMapOf = SnapshotStateKt.mutableStateMapOf();
        this.map = snapshotStateMapMutableStateMapOf;
        snapshotStateMapMutableStateMapOf.putAll(AbstractC4243wx.t(c2020dGArr));
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public boolean contains$ui_release(ModifierLocal<?> modifierLocal) {
        AbstractC4492zt.h(modifierLocal, "key");
        return this.map.containsKey(modifierLocal);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public <T> T get$ui_release(ModifierLocal<T> modifierLocal) {
        AbstractC4492zt.h(modifierLocal, "key");
        T t = (T) this.map.get(modifierLocal);
        if (t == null) {
            return null;
        }
        return t;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    /* JADX INFO: renamed from: set$ui_release */
    public <T> void mo4243set$ui_release(ModifierLocal<T> modifierLocal, T t) {
        AbstractC4492zt.h(modifierLocal, "key");
        this.map.put(modifierLocal, t);
    }
}
