package defpackage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: nG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3462nG {
    public static final Map a;
    public static final Map b;
    public static final WF c;

    /* JADX INFO: renamed from: nG$a */
    public static class a extends HashMap {
        public a() {
            put("open", 0);
            put("close", 1);
            put("ping", 2);
            put("pong", 3);
            put("message", 4);
            put("upgrade", 5);
            put("noop", 6);
        }
    }

    /* JADX INFO: renamed from: nG$b */
    public static class b implements d {
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ boolean b;

        public b(StringBuilder sb, boolean z) {
            this.a = sb;
            this.b = z;
        }

        @Override // defpackage.AbstractC3462nG.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            this.a.append(str);
            if (this.b) {
                return;
            }
            this.a.append((char) 30);
        }
    }

    /* JADX INFO: renamed from: nG$c */
    public interface c {
        boolean a(WF wf, int i, int i2);
    }

    /* JADX INFO: renamed from: nG$d */
    public interface d {
        void a(Object obj);
    }

    static {
        a aVar = new a();
        a = aVar;
        b = new HashMap();
        Iterator it = aVar.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            b.put(entry.getValue(), entry.getKey());
        }
        c = new WF("error", "parser error");
    }

    public static WF a(String str) {
        if (str == null) {
            return c;
        }
        return str.charAt(0) == 'b' ? new WF("message", AbstractC1850c7.a(str.substring(1), 0)) : b(str);
    }

    public static WF b(String str) {
        int numericValue;
        if (str == null) {
            return c;
        }
        try {
            numericValue = Character.getNumericValue(str.charAt(0));
        } catch (IndexOutOfBoundsException unused) {
            numericValue = -1;
        }
        if (numericValue >= 0) {
            Map map = b;
            if (numericValue < map.size()) {
                return str.length() > 1 ? new WF((String) map.get(Integer.valueOf(numericValue)), str.substring(1)) : new WF((String) map.get(Integer.valueOf(numericValue)));
            }
        }
        return c;
    }

    public static WF c(byte[] bArr) {
        return new WF("message", bArr);
    }

    public static void d(String str, c cVar) {
        if (str == null || str.length() == 0) {
            cVar.a(c, 0, 1);
            return;
        }
        String[] strArrSplit = str.split(String.valueOf((char) 30));
        int length = strArrSplit.length;
        for (int i = 0; i < length; i++) {
            WF wfA = a(strArrSplit[i]);
            WF wf = c;
            if (wf.a.equals(wfA.a) && ((String) wf.b).equals(wfA.b)) {
                cVar.a(wf, 0, 1);
                return;
            } else {
                if (!cVar.a(wfA, i, length)) {
                    return;
                }
            }
        }
    }

    public static void e(WF wf, d dVar) {
        Object obj = wf.b;
        if (obj instanceof byte[]) {
            dVar.a(obj);
            return;
        }
        String strValueOf = String.valueOf(a.get(wf.a));
        Object obj2 = wf.b;
        dVar.a(strValueOf + (obj2 != null ? String.valueOf(obj2) : ""));
    }

    public static void f(WF wf, d dVar) {
        Object obj = wf.b;
        if (!(obj instanceof byte[])) {
            e(wf, dVar);
            return;
        }
        dVar.a("b" + AbstractC1850c7.f((byte[]) obj, 0));
    }

    public static void g(WF[] wfArr, d dVar) {
        if (wfArr.length == 0) {
            dVar.a("0:");
            return;
        }
        StringBuilder sb = new StringBuilder();
        int length = wfArr.length;
        int i = 0;
        while (i < length) {
            f(wfArr[i], new b(sb, i == length + (-1)));
            i++;
        }
        dVar.a(sb.toString());
    }
}
