package defpackage;

import com.google.android.gms.internal.auth.zzdj;

/* JADX INFO: loaded from: classes2.dex */
public final class O90 implements zzdj {
    public volatile zzdj a;
    public volatile boolean b;
    public Object c;

    public O90(zzdj zzdjVar) {
        zzdjVar.getClass();
        this.a = zzdjVar;
    }

    public final String toString() {
        Object obj = this.a;
        StringBuilder sb = new StringBuilder();
        sb.append("Suppliers.memoize(");
        if (obj == null) {
            obj = "<supplier that returned " + this.c + ">";
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.auth.zzdj
    public final Object zza() {
        if (!this.b) {
            synchronized (this) {
                try {
                    if (!this.b) {
                        zzdj zzdjVar = this.a;
                        zzdjVar.getClass();
                        Object objZza = zzdjVar.zza();
                        this.c = objZza;
                        this.b = true;
                        this.a = null;
                        return objZza;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.c;
    }
}
