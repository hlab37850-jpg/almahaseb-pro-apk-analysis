package defpackage;

import android.database.ContentObserver;
import android.os.Handler;
import com.google.android.gms.internal.auth.zzcb;

/* JADX INFO: loaded from: classes2.dex */
public final class Z70 extends ContentObserver {
    public Z70(Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        zzcb.zzk.set(true);
    }
}
