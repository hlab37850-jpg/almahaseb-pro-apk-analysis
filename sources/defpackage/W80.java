package defpackage;

import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.auth.zzcz;
import com.google.android.gms.internal.auth.zzdc;
import com.google.android.gms.internal.auth.zzhr;
import com.google.android.gms.internal.auth.zzhu;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class W80 extends zzdc {
    public final /* synthetic */ zzhu a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W80(zzcz zzczVar, String str, Object obj, boolean z, zzhu zzhuVar, byte[] bArr) {
        super(zzczVar, "getTokenRefactor__blocked_packages", obj, true, null);
        this.a = zzhuVar;
    }

    @Override // com.google.android.gms.internal.auth.zzdc
    public final Object zza(Object obj) {
        try {
            return zzhr.zzk(Base64.decode((String) obj, 3));
        } catch (IOException | IllegalArgumentException unused) {
            Log.e("PhenotypeFlag", "Invalid byte[] value for " + super.zzc() + ": " + ((String) obj));
            return null;
        }
    }
}
