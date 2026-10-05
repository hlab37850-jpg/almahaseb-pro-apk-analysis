package defpackage;

import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth.zzbd;
import com.google.android.gms.internal.auth.zzbv;

/* JADX INFO: renamed from: n70, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class BinderC3451n70 extends zzbd {
    public final /* synthetic */ C3857s70 a;

    public BinderC3451n70(C3857s70 c3857s70) {
        this.a = c3857s70;
    }

    @Override // com.google.android.gms.internal.auth.zzbd, com.google.android.gms.internal.auth.zzbg
    public final void zzc(String str) {
        if (str != null) {
            this.a.setResult(new zzbv(str));
        } else {
            this.a.setResult(new zzbv(new Status(AuthApiStatusCodes.AUTH_APP_CERT_ERROR)));
        }
    }
}
