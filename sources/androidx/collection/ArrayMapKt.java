package androidx.collection;

import androidx.databinding.ObservableArrayMap;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;

/* JADX INFO: loaded from: classes.dex */
public final class ArrayMapKt {
    public static final <K, V> ArrayMap<K, V> arrayMapOf() {
        return new ArrayMap<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> ArrayMap<K, V> arrayMapOf(C2020dG... c2020dGArr) {
        AbstractC4492zt.i(c2020dGArr, "pairs");
        ObservableArrayMap observableArrayMap = (ArrayMap<K, V>) new ArrayMap(c2020dGArr.length);
        for (C2020dG c2020dG : c2020dGArr) {
            observableArrayMap.put(c2020dG.c(), c2020dG.e());
        }
        return observableArrayMap;
    }
}
