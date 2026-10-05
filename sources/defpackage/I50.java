package defpackage;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.firebase_messaging.zze;
import com.google.firebase.iid.a;

/* JADX INFO: loaded from: classes3.dex */
public final class I50 extends zze {
    public final /* synthetic */ a a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I50(a aVar, Looper looper) {
        super(looper);
        this.a = aVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.a.d(message);
    }
}
