package defpackage;

import com.google.android.gms.internal.auth.zzdj;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class L90 implements Serializable, zzdj {
    public final zzdj a;
    public volatile transient boolean b;
    public transient Object c;

    public L90(zzdj zzdjVar) {
        zzdjVar.getClass();
        this.a = zzdjVar;
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("Suppliers.memoize(");
        if (this.b) {
            obj = "<supplier that returned " + this.c + ">";
        } else {
            obj = this.a;
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
                        Object objZza = this.a.zza();
                        this.c = objZza;
                        this.b = true;
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
