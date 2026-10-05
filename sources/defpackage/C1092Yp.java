package defpackage;

import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;

/* JADX INFO: renamed from: Yp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1092Yp extends Equivalence implements Serializable {
    public final Function a;
    public final Equivalence b;

    public C1092Yp(Function function, Equivalence equivalence) {
        this.a = (Function) Preconditions.checkNotNull(function);
        this.b = (Equivalence) Preconditions.checkNotNull(equivalence);
    }

    @Override // com.google.common.base.Equivalence
    public boolean doEquivalent(Object obj, Object obj2) {
        return this.b.equivalent(this.a.apply(obj), this.a.apply(obj2));
    }

    @Override // com.google.common.base.Equivalence
    public int doHash(Object obj) {
        return this.b.hash(this.a.apply(obj));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1092Yp)) {
            return false;
        }
        C1092Yp c1092Yp = (C1092Yp) obj;
        return this.a.equals(c1092Yp.a) && this.b.equals(c1092Yp.b);
    }

    public int hashCode() {
        return Objects.hashCode(this.a, this.b);
    }

    public String toString() {
        String strValueOf = String.valueOf(this.b);
        String strValueOf2 = String.valueOf(this.a);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 13 + strValueOf2.length());
        sb.append(strValueOf);
        sb.append(".onResultOf(");
        sb.append(strValueOf2);
        sb.append(")");
        return sb.toString();
    }
}
