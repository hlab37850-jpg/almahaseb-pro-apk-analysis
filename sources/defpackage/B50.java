package defpackage;

import android.content.Context;
import com.google.android.gms.internal.vision.zzdf;

/* JADX INFO: loaded from: classes2.dex */
public final class B50 extends AbstractC3696q70 {
    public final Context a;
    public final zzdf b;

    public B50(Context context, zzdf zzdfVar) {
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        this.a = context;
        this.b = zzdfVar;
    }

    @Override // defpackage.AbstractC3696q70
    public final Context a() {
        return this.a;
    }

    @Override // defpackage.AbstractC3696q70
    public final zzdf b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        zzdf zzdfVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC3696q70) {
            AbstractC3696q70 abstractC3696q70 = (AbstractC3696q70) obj;
            if (this.a.equals(abstractC3696q70.a()) && ((zzdfVar = this.b) != null ? zzdfVar.equals(abstractC3696q70.b()) : abstractC3696q70.b() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        zzdf zzdfVar = this.b;
        return iHashCode ^ (zzdfVar == null ? 0 : zzdfVar.hashCode());
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.a);
        String strValueOf2 = String.valueOf(this.b);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 46 + strValueOf2.length());
        sb.append("FlagsContext{context=");
        sb.append(strValueOf);
        sb.append(", hermeticFileOverrides=");
        sb.append(strValueOf2);
        sb.append("}");
        return sb.toString();
    }
}
