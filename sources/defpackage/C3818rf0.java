package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.auth.zzl;
import com.google.android.gms.internal.auth.zzby;
import com.google.android.gms.internal.auth.zze;
import java.io.IOException;

/* JADX INFO: renamed from: rf0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3818rf0 implements Lf0 {
    public final /* synthetic */ String a;

    public C3818rf0(String str) {
        this.a = str;
    }

    @Override // defpackage.Lf0
    public final /* bridge */ /* synthetic */ Object zza(IBinder iBinder) throws IOException, GoogleAuthException {
        Bundle bundleZzg = zze.zzb(iBinder).zzg(this.a);
        zzl.zzd(bundleZzg);
        String string = bundleZzg.getString("Error");
        Intent intent = (Intent) bundleZzg.getParcelable("userRecoveryIntent");
        zzby zzbyVarZza = zzby.zza(string);
        if (zzby.SUCCESS.equals(zzbyVarZza)) {
            return Boolean.TRUE;
        }
        if (!zzby.zzb(zzbyVarZza)) {
            throw new GoogleAuthException(string);
        }
        zzl.zzd.w("isUserRecoverableError status: ".concat(String.valueOf(zzbyVarZza)), new Object[0]);
        throw new UserRecoverableAuthException(string, intent);
    }
}
