package defpackage;

import com.google.android.gms.internal.auth.zzdh;

/* JADX INFO: loaded from: classes2.dex */
public final class G90 extends zzdh {
    public final Object a;

    public G90(Object obj) {
        this.a = obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof G90) {
            return this.a.equals(((G90) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode() + 1502476572;
    }

    public final String toString() {
        return "Optional.of(" + this.a + ")";
    }

    @Override // com.google.android.gms.internal.auth.zzdh
    public final Object zza() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.auth.zzdh
    public final boolean zzb() {
        return true;
    }
}
