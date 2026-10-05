package defpackage;

import android.os.IBinder;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;
import com.google.android.gms.auth.zzl;
import com.google.android.gms.internal.auth.zze;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class Me0 implements Lf0 {
    public final /* synthetic */ AccountChangeEventsRequest a;

    public Me0(AccountChangeEventsRequest accountChangeEventsRequest) {
        this.a = accountChangeEventsRequest;
    }

    @Override // defpackage.Lf0
    public final /* bridge */ /* synthetic */ Object zza(IBinder iBinder) throws IOException {
        AccountChangeEventsResponse accountChangeEventsResponseZzh = zze.zzb(iBinder).zzh(this.a);
        zzl.zzd(accountChangeEventsResponseZzh);
        return accountChangeEventsResponseZzh.getEvents();
    }
}
