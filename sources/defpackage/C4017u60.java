package defpackage;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import com.google.android.gms.internal.vision.zzaq;
import com.google.android.gms.internal.vision.zzba;
import com.google.android.gms.internal.vision.zzbb;

/* JADX INFO: renamed from: u60, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4017u60 implements Q50 {
    public static C4017u60 c;
    public final Context a;
    public final ContentObserver b;

    public C4017u60(Context context) {
        this.a = context;
        B60 b60 = new B60(this, null);
        this.b = b60;
        context.getContentResolver().registerContentObserver(zzaq.zza, true, b60);
    }

    public static C4017u60 a(Context context) {
        C4017u60 c4017u60;
        synchronized (C4017u60.class) {
            try {
                if (c == null) {
                    c = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new C4017u60(context) : new C4017u60();
                }
                c4017u60 = c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c4017u60;
    }

    public static synchronized void b() {
        Context context;
        try {
            C4017u60 c4017u60 = c;
            if (c4017u60 != null && (context = c4017u60.a) != null && c4017u60.b != null) {
                context.getContentResolver().unregisterContentObserver(c.b);
            }
            c = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final /* synthetic */ String c(String str) {
        return zzaq.zza(this.a.getContentResolver(), str, (String) null);
    }

    @Override // defpackage.Q50
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final String zza(final String str) {
        if (this.a == null) {
            return null;
        }
        try {
            return (String) zzbb.zza(new zzba(this, str) { // from class: p60
                public final C4017u60 a;
                public final String b;

                {
                    this.a = this;
                    this.b = str;
                }

                @Override // com.google.android.gms.internal.vision.zzba
                public final Object zza() {
                    return this.a.c(this.b);
                }
            });
        } catch (IllegalStateException | SecurityException e) {
            String strValueOf = String.valueOf(str);
            Log.e("GservicesLoader", strValueOf.length() != 0 ? "Unable to read GServices for: ".concat(strValueOf) : new String("Unable to read GServices for: "), e);
            return null;
        }
    }

    public C4017u60() {
        this.a = null;
        this.b = null;
    }
}
