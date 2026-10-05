package com.google.android.gms.internal.fido;

import defpackage.C4094v40;
import defpackage.F40;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaj {
    private final String zza;
    private final F40 zzb;
    private F40 zzc;

    public /* synthetic */ zzaj(String str, zzai zzaiVar) {
        F40 f40 = new F40(null);
        this.zzb = f40;
        this.zzc = f40;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        F40 f40 = this.zzb.c;
        String str = "";
        while (f40 != null) {
            Object obj = f40.b;
            boolean z = f40 instanceof C4094v40;
            sb.append(str);
            String str2 = f40.a;
            if (str2 != null) {
                sb.append(str2);
                sb.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String strDeepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
            }
            f40 = f40.c;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzaj zza(String str, int i) {
        String strValueOf = String.valueOf(i);
        C4094v40 c4094v40 = new C4094v40(null);
        this.zzc.c = c4094v40;
        this.zzc = c4094v40;
        c4094v40.b = strValueOf;
        c4094v40.a = "errorCode";
        return this;
    }

    public final zzaj zzb(String str, Object obj) {
        F40 f40 = new F40(null);
        this.zzc.c = f40;
        this.zzc = f40;
        f40.b = obj;
        f40.a = str;
        return this;
    }
}
