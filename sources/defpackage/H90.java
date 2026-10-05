package defpackage;

import com.google.android.gms.internal.vision.zzcz;
import com.google.android.gms.internal.vision.zzdf;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class H90 implements zzdf, Serializable {
    public final Object a;

    public H90(Object obj) {
        this.a = obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof H90) {
            return zzcz.zza(this.a, ((H90) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a});
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.a);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 22);
        sb.append("Suppliers.ofInstance(");
        sb.append(strValueOf);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.vision.zzdf
    public final Object zza() {
        return this.a;
    }
}
