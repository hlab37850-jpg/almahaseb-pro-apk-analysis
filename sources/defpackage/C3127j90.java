package defpackage;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zzg;

/* JADX INFO: renamed from: j90, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3127j90 extends Ib0 {
    public final /* synthetic */ long a;
    public final /* synthetic */ PendingIntent b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3127j90(zzg zzgVar, GoogleApiClient googleApiClient, long j, PendingIntent pendingIntent) {
        super(googleApiClient);
        this.a = j;
        this.b = pendingIntent;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zzaz) anyClient).zzq(this.a, this.b);
        setResult(Status.RESULT_SUCCESS);
    }
}
