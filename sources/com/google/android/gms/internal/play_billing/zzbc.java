package com.google.android.gms.internal.play_billing;

import defpackage.C3203k60;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbc {
    private final String zza;
    private final C3203k60 zzb;
    private C3203k60 zzc;

    public /* synthetic */ zzbc(String str, zzbd zzbdVar) {
        C3203k60 c3203k60 = new C3203k60();
        this.zzb = c3203k60;
        this.zzc = c3203k60;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        C3203k60 c3203k60 = this.zzb.b;
        String str = "";
        while (c3203k60 != null) {
            Object obj = c3203k60.a;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String strDeepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
            }
            c3203k60 = c3203k60.b;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzbc zza(Object obj) {
        C3203k60 c3203k60 = new C3203k60();
        this.zzc.b = c3203k60;
        this.zzc = c3203k60;
        c3203k60.a = obj;
        return this;
    }
}
