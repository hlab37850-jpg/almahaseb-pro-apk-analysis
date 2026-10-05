package defpackage;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;

/* JADX INFO: renamed from: k50, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3201k50 implements ListenerHolder.Notifier {
    public final /* synthetic */ LocationAvailability a;

    public C3201k50(BinderC3283l50 binderC3283l50, LocationAvailability locationAvailability) {
        this.a = locationAvailability;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((LocationCallback) obj).onLocationAvailability(this.a);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
