package defpackage;

import java.io.Serializable;

/* JADX INFO: renamed from: xu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C4321xu implements Serializable {
    public static final C4321xu f = new C4321xu("N/A", -1, -1, -1, -1);
    public final long a;
    public final long b;
    public final int c;
    public final int d;
    public final Object e;

    public C4321xu(Object obj, long j, int i, int i2) {
        this(obj, -1L, j, i, i2);
    }

    public long a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof C4321xu)) {
            return false;
        }
        C4321xu c4321xu = (C4321xu) obj;
        Object obj2 = this.e;
        if (obj2 == null) {
            if (c4321xu.e != null) {
                return false;
            }
        } else if (!obj2.equals(c4321xu.e)) {
            return false;
        }
        return this.c == c4321xu.c && this.d == c4321xu.d && this.b == c4321xu.b && a() == c4321xu.a();
    }

    public int hashCode() {
        Object obj = this.e;
        return ((((obj == null ? 1 : obj.hashCode()) ^ this.c) + this.d) ^ ((int) this.b)) + ((int) this.a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(80);
        sb.append("[Source: ");
        Object obj = this.e;
        if (obj == null) {
            sb.append("UNKNOWN");
        } else {
            sb.append(obj.toString());
        }
        sb.append("; line: ");
        sb.append(this.c);
        sb.append(", column: ");
        sb.append(this.d);
        sb.append(']');
        return sb.toString();
    }

    public C4321xu(Object obj, long j, long j2, int i, int i2) {
        this.e = obj;
        this.a = j;
        this.b = j2;
        this.c = i;
        this.d = i2;
    }
}
