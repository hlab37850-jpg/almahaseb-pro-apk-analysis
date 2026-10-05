package defpackage;

import android.content.Context;
import com.google.android.gms.internal.auth.zzdj;

/* JADX INFO: renamed from: h80, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2338h80 extends AbstractC3537o90 {
    public final Context a;
    public final zzdj b;

    public C2338h80(Context context, zzdj zzdjVar) {
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        this.a = context;
        this.b = zzdjVar;
    }

    @Override // defpackage.AbstractC3537o90
    public final Context a() {
        return this.a;
    }

    @Override // defpackage.AbstractC3537o90
    public final zzdj b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        zzdj zzdjVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC3537o90) {
            AbstractC3537o90 abstractC3537o90 = (AbstractC3537o90) obj;
            if (this.a.equals(abstractC3537o90.a()) && ((zzdjVar = this.b) != null ? zzdjVar.equals(abstractC3537o90.b()) : abstractC3537o90.b() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        zzdj zzdjVar = this.b;
        return iHashCode ^ (zzdjVar == null ? 0 : zzdjVar.hashCode());
    }

    public final String toString() {
        return "FlagsContext{context=" + this.a.toString() + ", hermeticFileOverrides=" + String.valueOf(this.b) + "}";
    }
}
