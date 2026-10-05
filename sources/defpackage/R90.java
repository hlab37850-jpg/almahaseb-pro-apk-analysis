package defpackage;

import com.google.android.gms.internal.auth.zzdj;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class R90 implements Serializable, zzdj {
    public final Object a;

    public R90(Object obj) {
        this.a = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof R90)) {
            return false;
        }
        Object obj2 = this.a;
        Object obj3 = ((R90) obj).a;
        return obj2 == obj3 || obj2.equals(obj3);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a});
    }

    public final String toString() {
        return "Suppliers.ofInstance(" + this.a + ")";
    }

    @Override // com.google.android.gms.internal.auth.zzdj
    public final Object zza() {
        return this.a;
    }
}
