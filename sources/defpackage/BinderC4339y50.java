package defpackage;

import android.location.Location;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.zzbc;

/* JADX INFO: renamed from: y50, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class BinderC4339y50 extends zzbc {
    public final ListenerHolder a;

    public BinderC4339y50(ListenerHolder listenerHolder) {
        this.a = listenerHolder;
    }

    public final synchronized void zzc() {
        this.a.clear();
    }

    @Override // com.google.android.gms.location.zzbd
    public final synchronized void zzd(Location location) {
        this.a.notifyListener(new C3853s50(this, location));
    }
}
