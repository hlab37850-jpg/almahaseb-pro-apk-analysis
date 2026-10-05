package defpackage;

import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.vision.zzbi;
import com.google.android.gms.internal.vision.zzbo;
import com.google.android.gms.internal.vision.zzbp;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class Y60 extends zzbi {
    public final /* synthetic */ zzbp a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y60(zzbo zzboVar, String str, Object obj, boolean z, zzbp zzbpVar) {
        super(zzboVar, str, obj, true, null);
        this.a = zzbpVar;
    }

    @Override // com.google.android.gms.internal.vision.zzbi
    public final Object zza(Object obj) {
        if (obj instanceof String) {
            try {
                return this.a.zza(Base64.decode((String) obj, 3));
            } catch (IOException | IllegalArgumentException unused) {
            }
        }
        String strZzb = super.zzb();
        String strValueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(strZzb).length() + 27 + strValueOf.length());
        sb.append("Invalid byte[] value for ");
        sb.append(strZzb);
        sb.append(": ");
        sb.append(strValueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
