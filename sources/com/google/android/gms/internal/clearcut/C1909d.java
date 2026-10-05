package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: renamed from: com.google.android.gms.internal.clearcut.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1909d extends zzae {
    public final Object a;
    public String b;
    public Object c;
    public final /* synthetic */ zzan d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1909d(zzao zzaoVar, String str, Object obj, zzan zzanVar) {
        super(zzaoVar, str, obj, null);
        this.d = zzanVar;
        this.a = new Object();
    }

    @Override // com.google.android.gms.internal.clearcut.zzae
    public final Object zza(SharedPreferences sharedPreferences) {
        try {
            return zzb(sharedPreferences.getString(this.zzds, ""));
        } catch (ClassCastException e) {
            String strValueOf = String.valueOf(this.zzds);
            Log.e("PhenotypeFlag", strValueOf.length() != 0 ? "Invalid byte[] value in SharedPreferences for ".concat(strValueOf) : new String("Invalid byte[] value in SharedPreferences for "), e);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.zzae
    public final Object zzb(String str) {
        Object obj;
        try {
            synchronized (this.a) {
                try {
                    if (!str.equals(this.b)) {
                        Object objZzb = this.d.zzb(Base64.decode(str, 3));
                        this.b = str;
                        this.c = objZzb;
                    }
                    obj = this.c;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return obj;
        } catch (IOException | IllegalArgumentException unused) {
            String str2 = this.zzds;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 27 + String.valueOf(str).length());
            sb.append("Invalid byte[] value for ");
            sb.append(str2);
            sb.append(": ");
            sb.append(str);
            Log.e("PhenotypeFlag", sb.toString());
            return null;
        }
    }
}
