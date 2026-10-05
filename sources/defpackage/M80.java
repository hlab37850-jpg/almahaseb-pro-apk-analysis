package defpackage;

import android.util.Log;
import com.google.android.gms.internal.auth.zzcz;
import com.google.android.gms.internal.auth.zzdc;

/* JADX INFO: loaded from: classes2.dex */
public final class M80 extends zzdc {
    public M80(zzcz zzczVar, String str, Long l, boolean z) {
        super(zzczVar, str, l, true, null);
    }

    @Override // com.google.android.gms.internal.auth.zzdc
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        try {
            return Long.valueOf(Long.parseLong((String) obj));
        } catch (NumberFormatException unused) {
            Log.e("PhenotypeFlag", "Invalid long value for " + super.zzc() + ": " + ((String) obj));
            return null;
        }
    }
}
