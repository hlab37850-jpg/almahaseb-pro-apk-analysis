package androidx.compose.runtime.internal;

import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.State;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;

/* JADX INFO: loaded from: classes.dex */
public final class PersistentCompositionLocalMapKt {
    public static final PersistentCompositionLocalHashMap persistentCompositionLocalHashMapOf() {
        return PersistentCompositionLocalHashMap.Companion.getEmpty();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.compose.runtime.PersistentCompositionLocalMap] */
    public static final PersistentCompositionLocalMap persistentCompositionLocalHashMapOf(C2020dG... c2020dGArr) {
        AbstractC4492zt.h(c2020dGArr, "pairs");
        PersistentMap.Builder<CompositionLocal<Object>, State<? extends Object>> builderBuilder2 = PersistentCompositionLocalHashMap.Companion.getEmpty().builder2();
        AbstractC4243wx.p(builderBuilder2, c2020dGArr);
        return builderBuilder2.build2();
    }
}
