package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.Preconditions;
import defpackage.D20;
import defpackage.G20;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements Runnable {
    public final D20 a;
    public final /* synthetic */ zap b;

    public l(zap zapVar, D20 d20) {
        this.b = zapVar;
        this.a = d20;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.b.zaa) {
            ConnectionResult connectionResultB = this.a.b();
            if (connectionResultB.hasResolution()) {
                zap zapVar = this.b;
                zapVar.mLifecycleFragment.startActivityForResult(GoogleApiActivity.zaa(zapVar.getActivity(), (PendingIntent) Preconditions.checkNotNull(connectionResultB.getResolution()), this.a.a(), false), 1);
                return;
            }
            zap zapVar2 = this.b;
            if (zapVar2.zac.getErrorResolutionIntent(zapVar2.getActivity(), connectionResultB.getErrorCode(), null) != null) {
                zap zapVar3 = this.b;
                zapVar3.zac.zag(zapVar3.getActivity(), zapVar3.mLifecycleFragment, connectionResultB.getErrorCode(), 2, this.b);
                return;
            }
            if (connectionResultB.getErrorCode() != 18) {
                this.b.zaa(connectionResultB, this.a.a());
                return;
            }
            zap zapVar4 = this.b;
            Dialog dialogZab = zapVar4.zac.zab(zapVar4.getActivity(), zapVar4);
            zap zapVar5 = this.b;
            zapVar5.zac.zac(zapVar5.getActivity().getApplicationContext(), new G20(this, dialogZab));
        }
    }
}
