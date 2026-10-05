package defpackage;

import android.util.Log;
import com.google.android.gms.internal.auth.zzcb;
import com.google.android.gms.internal.auth.zzcz;
import com.google.android.gms.internal.auth.zzdc;

/* JADX INFO: loaded from: classes2.dex */
public final class Q80 extends zzdc {
    public Q80(zzcz zzczVar, String str, Boolean bool, boolean z) {
        super(zzczVar, str, bool, true, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.auth.zzdc
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        if (zzcb.zzc.matcher(obj).matches()) {
            return Boolean.TRUE;
        }
        if (zzcb.zzd.matcher(obj).matches()) {
            return Boolean.FALSE;
        }
        Log.e("PhenotypeFlag", "Invalid boolean value for " + super.zzc() + ": " + ((String) obj));
        return null;
    }
}
