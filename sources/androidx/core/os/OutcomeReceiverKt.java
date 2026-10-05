package androidx.core.os;

import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import defpackage.InterfaceC0793Of;
import defpackage.ZE;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(31)
public final class OutcomeReceiverKt {
    @RequiresApi(31)
    public static final <R, E extends Throwable> OutcomeReceiver<R, E> asOutcomeReceiver(InterfaceC0793Of interfaceC0793Of) {
        return ZE.a(new ContinuationOutcomeReceiver(interfaceC0793Of));
    }
}
