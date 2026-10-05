package defpackage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: j9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3126j9 {
    public Map a = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: j9$a */
    public class a extends b {
        public Map d;

        public a() {
            super();
            this.d = Collections.synchronizedMap(new HashMap());
        }
    }

    /* JADX INFO: renamed from: j9$b */
    public class b {
        public Object a;
        public AbstractRunnableC3450n7 b;

        public b() {
        }
    }

    public void a(Integer num, CF cf, FF ff) {
        b(num, cf, ff);
    }

    public a b(Integer num, CF cf, FF ff) {
        a aVar = new a();
        aVar.a = cf;
        aVar.b = ff;
        this.a.put(num, new ZQ(aVar));
        return aVar;
    }

    public CF c(Integer num) {
        a aVarE = e(num);
        if (aVarE != null) {
            return (CF) aVarE.a;
        }
        return null;
    }

    public FF d(Integer num) {
        a aVarE = e(num);
        if (aVarE != null) {
            return (FF) aVarE.b;
        }
        return null;
    }

    public a e(Integer num) {
        ZQ zq = (ZQ) this.a.get(num);
        if (zq == null) {
            return null;
        }
        zq.a();
        return (a) zq.a();
    }
}
