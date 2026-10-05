package defpackage;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.internal.location.zzaa;
import com.google.android.gms.internal.location.zzah;

/* JADX INFO: loaded from: classes2.dex */
public final class Ei0 extends zzah {
    public final BaseImplementation.ResultHolder a;

    public Ei0(BaseImplementation.ResultHolder resultHolder) {
        this.a = resultHolder;
    }

    @Override // com.google.android.gms.internal.location.zzai
    public final void zzb(zzaa zzaaVar) {
        this.a.setResult(zzaaVar.getStatus());
    }

    @Override // com.google.android.gms.internal.location.zzai
    public final void zzc() {
    }
}
