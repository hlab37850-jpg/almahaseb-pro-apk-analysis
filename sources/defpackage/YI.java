package defpackage;

import com.google.android.gms.internal.play_billing.zzbt;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class YI {
    public final zzbt a;

    public static class a {
        public zzbt a;

        public /* synthetic */ a(Z80 z80) {
        }

        public YI a() {
            if (this.a != null) {
                return new YI(this, null);
            }
            throw new IllegalArgumentException("Product list must be set to a non empty list.");
        }

        public a b(List list) {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("Product list cannot be empty.");
            }
            HashSet hashSet = new HashSet();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (!"play_pass_subs".equals(bVar.c())) {
                    hashSet.add(bVar.c());
                }
            }
            if (hashSet.size() > 1) {
                throw new IllegalArgumentException("All products should be of the same product type.");
            }
            this.a = zzbt.zzj(list);
            return this;
        }
    }

    public static class b {
        public final String a;
        public final String b;

        public static class a {
            public String a;
            public String b;

            public /* synthetic */ a(Z80 z80) {
            }

            public b a() {
                if ("first_party".equals(this.b)) {
                    throw new IllegalArgumentException("Serialized doc id must be provided for first party products.");
                }
                if (this.a == null) {
                    throw new IllegalArgumentException("Product id must be provided.");
                }
                if (this.b != null) {
                    return new b(this, null);
                }
                throw new IllegalArgumentException("Product type must be provided.");
            }

            public a b(String str) {
                this.a = str;
                return this;
            }

            public a c(String str) {
                this.b = str;
                return this;
            }
        }

        public /* synthetic */ b(a aVar, Z80 z80) {
            this.a = aVar.a;
            this.b = aVar.b;
        }

        public static a a() {
            return new a(null);
        }

        public final String b() {
            return this.a;
        }

        public final String c() {
            return this.b;
        }
    }

    public /* synthetic */ YI(a aVar, Z80 z80) {
        this.a = aVar.a;
    }

    public static a a() {
        return new a(null);
    }

    public final zzbt b() {
        return this.a;
    }

    public final String c() {
        return ((b) this.a.get(0)).c();
    }
}
