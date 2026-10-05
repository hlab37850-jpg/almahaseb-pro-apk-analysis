package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class KO implements IO, Serializable {
    public final String a;
    public byte[] b;

    public KO(String str) {
        if (str == null) {
            throw new IllegalStateException("Null String illegal for SerializedString");
        }
        this.a = str;
    }

    @Override // defpackage.IO
    public final byte[] a() {
        byte[] bArr = this.b;
        if (bArr != null) {
            return bArr;
        }
        byte[] bArrC = C0405Cu.d().c(this.a);
        this.b = bArrC;
        return bArrC;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return this.a.equals(((KO) obj).a);
    }

    @Override // defpackage.IO
    public final String getValue() {
        return this.a;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a;
    }
}
