package defpackage;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;

/* JADX INFO: renamed from: g50, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2250g50 implements ListenerHolder.Notifier {
    public final /* synthetic */ LocationResult a;

    public C2250g50(BinderC3283l50 binderC3283l50, LocationResult locationResult) {
        this.a = locationResult;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((LocationCallback) obj).onLocationResult(this.a);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
