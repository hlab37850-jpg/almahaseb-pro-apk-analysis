package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: cm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1903cm {
    public final List a;
    public final int b;
    public final boolean c;

    public C1903cm(List list, int i, boolean z) {
        this.a = new ArrayList(list);
        this.b = i;
        this.c = z;
    }

    public List a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public boolean c(List list) {
        return this.a.equals(list);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1903cm)) {
            return false;
        }
        C1903cm c1903cm = (C1903cm) obj;
        return this.a.equals(c1903cm.a()) && this.c == c1903cm.c;
    }

    public int hashCode() {
        return this.a.hashCode() ^ Boolean.valueOf(this.c).hashCode();
    }

    public String toString() {
        return "{ " + this.a + " }";
    }
}
