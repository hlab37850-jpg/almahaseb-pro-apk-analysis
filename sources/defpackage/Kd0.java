package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.zzl;
import com.google.android.gms.internal.auth.zze;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class Kd0 implements Lf0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ Bundle b;

    public Kd0(String str, Bundle bundle) {
        this.a = str;
        this.b = bundle;
    }

    @Override // defpackage.Lf0
    public final /* bridge */ /* synthetic */ Object zza(IBinder iBinder) throws IOException, GoogleAuthException {
        Bundle bundleZzd = zze.zzb(iBinder).zzd(this.a, this.b);
        zzl.zzd(bundleZzd);
        String string = bundleZzd.getString("Error");
        if (bundleZzd.getBoolean("booleanResult")) {
            return null;
        }
        throw new GoogleAuthException(string);
    }
}
