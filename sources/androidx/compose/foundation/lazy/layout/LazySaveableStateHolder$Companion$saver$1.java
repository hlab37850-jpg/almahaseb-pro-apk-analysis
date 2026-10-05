package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.saveable.SaverScope;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class LazySaveableStateHolder$Companion$saver$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final LazySaveableStateHolder$Companion$saver$1 INSTANCE = new LazySaveableStateHolder$Companion$saver$1();

    public LazySaveableStateHolder$Companion$saver$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Map<String, List<Object>> mo13invoke(SaverScope saverScope, LazySaveableStateHolder lazySaveableStateHolder) {
        AbstractC4492zt.h(saverScope, "$this$Saver");
        AbstractC4492zt.h(lazySaveableStateHolder, "it");
        Map<String, List<Object>> mapPerformSave = lazySaveableStateHolder.performSave();
        if (mapPerformSave.isEmpty()) {
            return null;
        }
        return mapPerformSave;
    }
}
