package defpackage;

import android.database.ContentObserver;
import android.os.Handler;
import com.google.android.gms.internal.clearcut.zzy;

/* JADX INFO: loaded from: classes2.dex */
public final class Ki0 extends ContentObserver {
    public Ki0(Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        zzy.zzct.set(true);
    }
}
