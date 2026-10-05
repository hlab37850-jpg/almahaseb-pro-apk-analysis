package defpackage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: em, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2142em {
    public final String a;
    public final Map b;
    public final Map c;
    public final Set d;

    public C2142em(String str) {
        if (str == null || str.trim().length() == 0) {
            throw new IllegalArgumentException("Expression can not be empty");
        }
        this.a = str;
        this.c = new HashMap(4);
        this.b = new HashMap(4);
        this.d = new HashSet(4);
    }

    public C2061dm a() {
        if (this.a.length() != 0) {
            return new C2061dm(AbstractC3717qQ.a(this.a, this.b, this.c, this.d), this.b.keySet());
        }
        throw new IllegalArgumentException("The expression can not be empty");
    }
}
