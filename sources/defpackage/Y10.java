package defpackage;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.service.zae;
import com.google.android.gms.common.internal.service.zah;
import com.google.android.gms.common.internal.service.zal;

/* JADX INFO: loaded from: classes2.dex */
public final class Y10 extends AbstractC3766r20 {
    public Y10(zae zaeVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zal) ((zah) anyClient).getService()).zae(new BinderC3195k20(this));
    }
}
