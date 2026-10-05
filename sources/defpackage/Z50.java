package defpackage;

import android.database.ContentObserver;
import android.os.Handler;
import com.google.android.gms.phenotype.zza;

/* JADX INFO: loaded from: classes2.dex */
public final class Z50 extends ContentObserver {
    public final /* synthetic */ zza a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z50(zza zzaVar, Handler handler) {
        super(null);
        this.a = zzaVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.a.zzb();
    }
}
