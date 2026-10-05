package androidx.compose.runtime.saveable;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class SaveableStateHolderImpl$Companion$Saver$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final SaveableStateHolderImpl$Companion$Saver$1 INSTANCE = new SaveableStateHolderImpl$Companion$Saver$1();

    public SaveableStateHolderImpl$Companion$Saver$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Map<Object, Map<String, List<Object>>> mo13invoke(SaverScope saverScope, SaveableStateHolderImpl saveableStateHolderImpl) {
        AbstractC4492zt.h(saverScope, "$this$Saver");
        AbstractC4492zt.h(saveableStateHolderImpl, "it");
        return saveableStateHolderImpl.saveAll();
    }
}
