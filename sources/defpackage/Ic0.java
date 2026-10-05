package defpackage;

import android.database.ContentObserver;
import android.os.Handler;
import com.google.android.gms.internal.phenotype.zzf;

/* JADX INFO: loaded from: classes2.dex */
public final class Ic0 extends ContentObserver {
    public Ic0(Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        zzf.zzbh.set(true);
    }
}
