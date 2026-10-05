package defpackage;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.location.zzan;
import com.google.android.gms.location.LocationSettingsResult;

/* JADX INFO: loaded from: classes2.dex */
public final class O50 extends zzan {
    public BaseImplementation.ResultHolder a;

    public O50(BaseImplementation.ResultHolder resultHolder) {
        Preconditions.checkArgument(resultHolder != null, "listener can't be null.");
        this.a = resultHolder;
    }

    @Override // com.google.android.gms.internal.location.zzao
    public final void zzb(LocationSettingsResult locationSettingsResult) {
        this.a.setResult(locationSettingsResult);
        this.a = null;
    }
}
