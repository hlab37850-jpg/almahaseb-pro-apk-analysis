package defpackage;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.moduleinstall.InstallStatusListener;
import com.google.android.gms.common.moduleinstall.ModuleInstallStatusUpdate;

/* JADX INFO: renamed from: t10, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3926t10 implements ListenerHolder.Notifier {
    public final /* synthetic */ ModuleInstallStatusUpdate a;

    public C3926t10(BinderC4007u10 binderC4007u10, ModuleInstallStatusUpdate moduleInstallStatusUpdate) {
        this.a = moduleInstallStatusUpdate;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((InstallStatusListener) obj).onInstallStatusUpdated(this.a);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
