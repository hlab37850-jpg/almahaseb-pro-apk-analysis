package defpackage;

import android.util.Log;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.internal.clearcut.zzfz;
import com.google.android.gms.internal.clearcut.zzha;
import com.google.android.gms.internal.clearcut.zzj;
import com.google.android.gms.internal.clearcut.zzn;

/* JADX INFO: loaded from: classes2.dex */
public final class Fd0 extends BaseImplementation.ApiMethodImpl {
    public final zze a;

    public Fd0(zze zzeVar, GoogleApiClient googleApiClient) {
        super(ClearcutLogger.API, googleApiClient);
        this.a = zzeVar;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        zzj zzjVar = (zzj) anyClient;
        Ie0 ie0 = new Ie0(this);
        try {
            zze zzeVar = this.a;
            ClearcutLogger.zzb zzbVar = zzeVar.zzt;
            if (zzbVar != null) {
                zzha zzhaVar = zzeVar.zzaa;
                if (zzhaVar.zzbjp.length == 0) {
                    zzhaVar.zzbjp = zzbVar.zza();
                }
            }
            ClearcutLogger.zzb zzbVar2 = zzeVar.zzan;
            if (zzbVar2 != null) {
                zzha zzhaVar2 = zzeVar.zzaa;
                if (zzhaVar2.zzbjw.length == 0) {
                    zzhaVar2.zzbjw = zzbVar2.zza();
                }
            }
            zzha zzhaVar3 = zzeVar.zzaa;
            int iZzas = zzhaVar3.zzas();
            byte[] bArr = new byte[iZzas];
            zzfz.zza(zzhaVar3, bArr, 0, iZzas);
            zzeVar.zzah = bArr;
            ((zzn) zzjVar.getService()).zza(ie0, this.a);
        } catch (RuntimeException e) {
            Log.e("ClearcutLoggerApiImpl", "derived ClearcutLogger.MessageProducer ", e);
            setFailedResult(new Status(10, "MessageProducer"));
        }
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }
}
