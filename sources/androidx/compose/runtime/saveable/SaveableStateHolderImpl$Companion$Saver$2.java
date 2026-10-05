package androidx.compose.runtime.saveable;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class SaveableStateHolderImpl$Companion$Saver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final SaveableStateHolderImpl$Companion$Saver$2 INSTANCE = new SaveableStateHolderImpl$Companion$Saver$2();

    public SaveableStateHolderImpl$Companion$Saver$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final SaveableStateHolderImpl invoke(Map<Object, Map<String, List<Object>>> map) {
        AbstractC4492zt.h(map, "it");
        return new SaveableStateHolderImpl(map);
    }
}
