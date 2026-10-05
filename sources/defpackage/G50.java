package defpackage;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.internal.location.zzaj;
import com.google.android.gms.location.LocationStatusCodes;

/* JADX INFO: loaded from: classes2.dex */
public final class G50 extends zzaj {
    public BaseImplementation.ResultHolder a;

    public G50(BaseImplementation.ResultHolder resultHolder) {
        this.a = resultHolder;
    }

    @Override // com.google.android.gms.internal.location.zzak
    public final void zzb(int i, String[] strArr) {
        if (this.a == null) {
            Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times", new Exception());
            return;
        }
        this.a.setResult(LocationStatusCodes.zzb(LocationStatusCodes.zza(i)));
        this.a = null;
    }

    @Override // com.google.android.gms.internal.location.zzak
    public final void zzc(int i, String[] strArr) {
        Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult", new Exception());
    }

    @Override // com.google.android.gms.internal.location.zzak
    public final void zzd(int i, PendingIntent pendingIntent) {
        Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult", new Exception());
    }
}
