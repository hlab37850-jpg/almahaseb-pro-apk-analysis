package defpackage;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import com.google.android.gms.internal.auth.zzcb;
import com.google.android.gms.internal.auth.zzcc;
import com.google.android.gms.internal.auth.zzcj;
import com.google.android.gms.internal.auth.zzck;

/* JADX INFO: loaded from: classes2.dex */
public final class B80 implements InterfaceC4102v80 {
    public static B80 c;
    public final Context a;
    public final ContentObserver b;

    public B80() {
        this.a = null;
        this.b = null;
    }

    public static B80 a(Context context) {
        B80 b80;
        synchronized (B80.class) {
            try {
                if (c == null) {
                    c = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new B80(context) : new B80();
                }
                b80 = c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return b80;
    }

    public static synchronized void d() {
        Context context;
        try {
            B80 b80 = c;
            if (b80 != null && (context = b80.a) != null && b80.b != null) {
                context.getContentResolver().unregisterContentObserver(c.b);
            }
            c = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // defpackage.InterfaceC4102v80
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final String zzb(final String str) {
        Context context = this.a;
        if (context != null && !zzcc.zza(context)) {
            try {
                return (String) zzcj.zza(new zzck() { // from class: com.google.android.gms.internal.auth.zzcm
                    @Override // com.google.android.gms.internal.auth.zzck
                    public final Object zza() {
                        return this.zza.c(str);
                    }
                });
            } catch (IllegalStateException | NullPointerException | SecurityException e) {
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(String.valueOf(str)), e);
            }
        }
        return null;
    }

    public final /* synthetic */ String c(String str) {
        return zzcb.zza(this.a.getContentResolver(), str, null);
    }

    public B80(Context context) {
        this.a = context;
        C4436z80 c4436z80 = new C4436z80(this, null);
        this.b = c4436z80;
        context.getContentResolver().registerContentObserver(zzcb.zza, true, c4436z80);
    }
}
