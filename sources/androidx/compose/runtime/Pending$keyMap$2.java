package androidx.compose.runtime;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;
import java.util.HashMap;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public final class Pending$keyMap$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ Pending this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Pending$keyMap$2(Pending pending) {
        super(0);
        this.this$0 = pending;
    }

    @Override // defpackage.InterfaceC3588op
    public final HashMap<Object, LinkedHashSet<KeyInfo>> invoke() {
        HashMap<Object, LinkedHashSet<KeyInfo>> mapMultiMap = ComposerKt.multiMap();
        Pending pending = this.this$0;
        int size = pending.getKeyInfos().size();
        for (int i = 0; i < size; i++) {
            KeyInfo keyInfo = pending.getKeyInfos().get(i);
            ComposerKt.put(mapMultiMap, ComposerKt.getJoinedKey(keyInfo), keyInfo);
        }
        return mapMultiMap;
    }
}
