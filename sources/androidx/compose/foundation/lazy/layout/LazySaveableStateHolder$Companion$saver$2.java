package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.saveable.SaveableStateRegistry;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class LazySaveableStateHolder$Companion$saver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ SaveableStateRegistry $parentRegistry;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazySaveableStateHolder$Companion$saver$2(SaveableStateRegistry saveableStateRegistry) {
        super(1);
        this.$parentRegistry = saveableStateRegistry;
    }

    @Override // defpackage.InterfaceC3750qp
    public final LazySaveableStateHolder invoke(Map<String, ? extends List<? extends Object>> map) {
        AbstractC4492zt.h(map, "restored");
        return new LazySaveableStateHolder(this.$parentRegistry, map);
    }
}
