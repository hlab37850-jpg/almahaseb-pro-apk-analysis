package androidx.paging.internal;

import androidx.annotation.RestrictTo;
import androidx.paging.LoadStates;
import defpackage.AbstractC3310lS;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class LogUtilKt {
    public static final String appendMediatorStatesIfNotNull(LoadStates loadStates, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, "log");
        String str = (String) interfaceC3588op.invoke();
        if (loadStates != null) {
            str = str + "|   mediatorLoadStates: " + loadStates + '\n';
        }
        return AbstractC3310lS.h(str + "|)", null, 1, null);
    }
}
