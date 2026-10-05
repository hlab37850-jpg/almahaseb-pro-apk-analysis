package defpackage;

import android.database.ContentObserver;
import android.os.Handler;
import com.google.android.gms.internal.vision.zzau;

/* JADX INFO: loaded from: classes2.dex */
public final class H50 extends ContentObserver {
    public final /* synthetic */ zzau a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H50(zzau zzauVar, Handler handler) {
        super(null);
        this.a = zzauVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.a.zza();
    }
}
