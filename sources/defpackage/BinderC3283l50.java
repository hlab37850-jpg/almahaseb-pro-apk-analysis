package defpackage;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzaz;

/* JADX INFO: renamed from: l50, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class BinderC3283l50 extends zzaz {
    public final ListenerHolder a;

    public BinderC3283l50(ListenerHolder listenerHolder) {
        this.a = listenerHolder;
    }

    public final synchronized void zzc() {
        this.a.clear();
    }

    @Override // com.google.android.gms.location.zzba
    public final void zzd(LocationResult locationResult) {
        this.a.notifyListener(new C2250g50(this, locationResult));
    }

    @Override // com.google.android.gms.location.zzba
    public final void zze(LocationAvailability locationAvailability) {
        this.a.notifyListener(new C3201k50(this, locationAvailability));
    }
}
