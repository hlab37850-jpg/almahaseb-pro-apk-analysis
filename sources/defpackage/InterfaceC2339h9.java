package defpackage;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: renamed from: h9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC2339h9 {

    /* JADX INFO: renamed from: h9$a */
    public static class a {
        public byte[] a;
        public String b;
        public long c;
        public long d;
        public long e;
        public Map f = Collections.emptyMap();

        public boolean a() {
            return this.d < System.currentTimeMillis();
        }

        public boolean b() {
            return this.e < System.currentTimeMillis();
        }
    }

    void a(String str, a aVar);

    a get(String str);

    void initialize();
}
