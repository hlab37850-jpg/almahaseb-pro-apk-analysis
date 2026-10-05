package defpackage;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes2.dex */
public final class R40 extends AbstractC2332h50 {
    public final /* synthetic */ ListenerHolder b;
    public final /* synthetic */ FusedLocationProviderClient c;

    public R40(FusedLocationProviderClient fusedLocationProviderClient, ListenerHolder listenerHolder) {
        this.c = fusedLocationProviderClient;
        this.b = listenerHolder;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* bridge */ /* synthetic */ void accept(Object obj, Object obj2) {
        zzaz zzazVar = (zzaz) obj;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
        if (a()) {
            U40 u40 = new U40(this.c, taskCompletionSource);
            try {
                ListenerHolder.ListenerKey<LocationCallback> listenerKey = this.b.getListenerKey();
                if (listenerKey != null) {
                    zzazVar.zzH(listenerKey, u40);
                }
            } catch (RuntimeException e) {
                taskCompletionSource.trySetException(e);
            }
        }
    }
}
