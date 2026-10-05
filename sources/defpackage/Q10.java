package defpackage;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.internal.zabi;
import com.google.android.gms.internal.base.zau;

/* JADX INFO: loaded from: classes2.dex */
public final class Q10 extends zau {
    public final /* synthetic */ zabi a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q10(zabi zabiVar, Looper looper) {
        super(looper);
        this.a = zabiVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            ((P10) message.obj).b(this.a);
        } else {
            if (i == 2) {
                throw ((RuntimeException) message.obj);
            }
            Log.w("GACStateManager", "Unknown message id: " + i);
        }
    }
}
