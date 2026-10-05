package defpackage;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.internal.zabe;
import com.google.android.gms.internal.base.zau;

/* JADX INFO: loaded from: classes2.dex */
public final class N10 extends zau {
    public final /* synthetic */ zabe a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N10(zabe zabeVar, Looper looper) {
        super(looper);
        this.a = zabeVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            zabe.zaj(this.a);
            return;
        }
        if (i == 2) {
            zabe.zai(this.a);
            return;
        }
        Log.w("GoogleApiClientImpl", "Unknown message id: " + i);
    }
}
