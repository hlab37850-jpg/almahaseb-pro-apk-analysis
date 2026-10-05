package defpackage;

import android.database.ContentObserver;
import android.os.Handler;
import com.google.android.gms.internal.vision.zzbi;

/* JADX INFO: loaded from: classes2.dex */
public final class B60 extends ContentObserver {
    public B60(C4017u60 c4017u60, Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        zzbi.zza();
    }
}
