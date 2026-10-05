package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.BaseGmsClient;
import defpackage.T10;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements BaseGmsClient.SignOutCallbacks {
    public final /* synthetic */ zabq a;

    public g(zabq zabqVar) {
        this.a = zabqVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks
    public final void onSignOutComplete() {
        this.a.zaa.zar.post(new T10(this));
    }
}
