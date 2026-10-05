package defpackage;

import com.google.android.gms.internal.vision.zzde;
import com.google.android.gms.internal.vision.zzdf;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class E90 implements zzdf, Serializable {
    public final zzdf a;
    public volatile transient boolean b;
    public transient Object c;

    public E90(zzdf zzdfVar) {
        this.a = (zzdf) zzde.zza(zzdfVar);
    }

    public final String toString() {
        Object string;
        if (this.b) {
            String strValueOf = String.valueOf(this.c);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 25);
            sb.append("<supplier that returned ");
            sb.append(strValueOf);
            sb.append(">");
            string = sb.toString();
        } else {
            string = this.a;
        }
        String strValueOf2 = String.valueOf(string);
        StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(strValueOf2);
        sb2.append(")");
        return sb2.toString();
    }

    @Override // com.google.android.gms.internal.vision.zzdf
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
