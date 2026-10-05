package defpackage;

import android.util.Log;
import com.google.android.gms.internal.auth.zzcz;
import com.google.android.gms.internal.auth.zzdc;

/* JADX INFO: loaded from: classes2.dex */
public final class V80 extends zzdc {
    public V80(zzcz zzczVar, String str, Double d, boolean z) {
        super(zzczVar, str, d, true, null);
    }

    @Override // com.google.android.gms.internal.auth.zzdc
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            Log.e("PhenotypeFlag", "Invalid double value for " + super.zzc() + ": " + ((String) obj));
            return null;
        }
    }
}
