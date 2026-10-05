package defpackage;

import com.google.android.gms.internal.play_billing.zzfl;
import com.google.android.gms.internal.play_billing.zzil;

/* JADX INFO: loaded from: classes2.dex */
public final class Ue0 implements zzfl {
    public static final zzfl a = new Ue0();

    @Override // com.google.android.gms.internal.play_billing.zzfl
    public final boolean zza(int i) {
        zzil zzilVar;
        if (i == 0) {
            zzilVar = zzil.BROADCAST_ACTION_UNSPECIFIED;
        } else if (i == 1) {
            zzilVar = zzil.PURCHASES_UPDATED_ACTION;
        } else if (i != 2) {
            zzilVar = i != 3 ? null : zzil.ALTERNATIVE_BILLING_ACTION;
        } else {
            zzilVar = zzil.LOCAL_PURCHASES_UPDATED_ACTION;
        }
        return zzilVar != null;
    }
}
