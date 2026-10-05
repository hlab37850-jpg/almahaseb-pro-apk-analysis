package defpackage;

import android.location.Location;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationListener;

/* JADX INFO: renamed from: s50, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3853s50 implements ListenerHolder.Notifier {
    public final /* synthetic */ Location a;

    public C3853s50(BinderC4339y50 binderC4339y50, Location location) {
        this.a = location;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((LocationListener) obj).onLocationChanged(this.a);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
