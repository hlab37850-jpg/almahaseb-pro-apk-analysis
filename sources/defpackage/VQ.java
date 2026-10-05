package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class VQ extends AbstractC0963Uk {
    public static final Logger n = Logger.getLogger(VQ.class.getName());
    public static Map o = new a();
    public String b;
    public volatile boolean c;
    public int d;
    public String e;
    public C3432mx f;
    public Map g;
    public Queue i;
    public Map h = new HashMap();
    public final Queue j = new LinkedList();
    public final Queue k = new LinkedList();
    public ConcurrentLinkedQueue l = new ConcurrentLinkedQueue();
    public ConcurrentLinkedQueue m = new ConcurrentLinkedQueue();

    public static class a extends HashMap {
        public a() {
            put("connect", 1);
            put("connect_error", 1);
            put("disconnect", 1);
            put("disconnecting", 1);
            put("newListener", 1);
            put("removeListener", 1);
        }
    }

    public class b extends LinkedList {
        public final /* synthetic */ C3432mx a;

        public class a implements AbstractC0963Uk.a {
            public a() {
            }

            @Override // defpackage.AbstractC0963Uk.a
            public void call(Object... objArr) {
                VQ.this.L();
            }
        }

        /* JADX INFO: renamed from: VQ$b$b, reason: collision with other inner class name */
        public class C0021b implements AbstractC0963Uk.a {
            public C0021b() {
            }

            @Override // defpackage.AbstractC0963Uk.a
            public void call(Object... objArr) {
                VQ.this.M((VF) objArr[0]);
            }
        }

        public class c implements AbstractC0963Uk.a {
            public c() {
            }

            @Override // defpackage.AbstractC0963Uk.a
            public void call(Object... objArr) {
                if (VQ.this.c) {
                    return;
                }
                VQ.super.a("connect_error", objArr[0]);
            }
        }

        public class d implements AbstractC0963Uk.a {
            public d() {
            }

            @Override // defpackage.AbstractC0963Uk.a
            public void call(Object... objArr) {
                VQ.this.H(objArr.length > 0 ? (String) objArr[0] : null);
            }
        }

        public b(C3432mx c3432mx) {
            this.a = c3432mx;
            add(CE.a(c3432mx, "open", new a()));
            add(CE.a(c3432mx, "packet", new C0021b()));
            add(CE.a(c3432mx, "error", new c()));
            add(CE.a(c3432mx, "close", new d()));
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VQ.this.c || VQ.this.f.E()) {
                return;
            }
            VQ.this.P();
            VQ.this.f.L();
            if (C3432mx.l.OPEN == VQ.this.f.b) {
                VQ.this.L();
            }
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ Object[] a;
        public final /* synthetic */ String b;

        public d(Object[] objArr, String str) {
            this.a = objArr;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            U1 u1;
            Object[] objArr = this.a;
            int length = objArr.length - 1;
            if (objArr.length <= 0 || !(objArr[length] instanceof U1)) {
                u1 = null;
            } else {
                objArr = new Object[length];
                for (int i = 0; i < length; i++) {
                    objArr[i] = this.a[i];
                }
                u1 = (U1) this.a[length];
            }
            VQ.this.C(this.b, objArr, u1);
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Object[] b;
        public final /* synthetic */ U1 c;

        public e(String str, Object[] objArr, U1 u1) {
            this.a = str;
            this.b = objArr;
            this.c = u1;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.a);
            Object[] objArr = this.b;
            if (objArr != null) {
                for (Object obj : objArr) {
                    jSONArray.put(obj);
                }
            }
            VF vf = new VF(2, jSONArray);
            if (this.c != null) {
                int i = VQ.this.d;
                VQ.n.fine(String.format("emitting packet with ack id %d", Integer.valueOf(i)));
                VQ.this.h.put(Integer.valueOf(i), this.c);
                vf.b = VQ.t(VQ.this);
            }
            if (VQ.this.c) {
                VQ.this.O(vf);
            } else {
                VQ.this.k.add(vf);
            }
        }
    }

    public class f implements U1 {
        public final /* synthetic */ boolean[] a;
        public final /* synthetic */ int b;
        public final /* synthetic */ VQ c;

        public class a implements Runnable {
            public final /* synthetic */ Object[] a;

            public a(Object[] objArr) {
                this.a = objArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean[] zArr = f.this.a;
                if (zArr[0]) {
                    return;
                }
                zArr[0] = true;
                if (VQ.n.isLoggable(Level.FINE)) {
                    Logger logger = VQ.n;
                    Object[] objArr = this.a;
                    if (objArr.length == 0) {
                        objArr = null;
                    }
                    logger.fine(String.format("sending ack %s", objArr));
                }
                JSONArray jSONArray = new JSONArray();
                for (Object obj : this.a) {
                    jSONArray.put(obj);
                }
                VF vf = new VF(3, jSONArray);
                f fVar = f.this;
                vf.b = fVar.b;
                fVar.c.O(vf);
            }
        }

        public f(boolean[] zArr, int i, VQ vq) {
            this.a = zArr;
            this.b = i;
            this.c = vq;
        }

        @Override // defpackage.U1
        public void call(Object... objArr) {
            C0626Jl.h(new a(objArr));
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VQ.this.c) {
                if (VQ.n.isLoggable(Level.FINE)) {
                    VQ.n.fine(String.format("performing disconnect (%s)", VQ.this.e));
                }
                VQ.this.O(new VF(1));
            }
            VQ.this.A();
            if (VQ.this.c) {
                VQ.this.H("io client disconnect");
            }
        }
    }

    public VQ(C3432mx c3432mx, String str, C3432mx.k kVar) {
        this.f = c3432mx;
        this.e = str;
        if (kVar != null) {
            this.g = kVar.z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        Queue queue = this.i;
        if (queue != null) {
            Iterator it = queue.iterator();
            while (it.hasNext()) {
                ((CE.b) it.next()).destroy();
            }
            this.i = null;
        }
        for (U1 u1 : this.h.values()) {
        }
        this.f.D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String str) {
        Logger logger = n;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("close (%s)", str));
        }
        this.c = false;
        this.b = null;
        super.a("disconnect", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        n.fine("transport is open - connecting");
        if (this.g != null) {
            O(new VF(0, new JSONObject(this.g)));
        } else {
            O(new VF(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(VF vf) {
        if (vf.a == 2 && !this.m.isEmpty()) {
            Object[] objArrQ = Q((JSONArray) vf.d);
            Iterator it = this.m.iterator();
            while (it.hasNext()) {
                ((AbstractC0963Uk.a) it.next()).call(objArrQ);
            }
        }
        vf.c = this.e;
        this.f.N(vf);
    }

    public static Object[] Q(JSONArray jSONArray) {
        Object obj;
        int length = jSONArray.length();
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            Object obj2 = null;
            try {
                obj = jSONArray.get(i);
            } catch (JSONException e2) {
                n.log(Level.WARNING, "An error occured while retrieving data from JSONArray", (Throwable) e2);
                obj = null;
            }
            if (!JSONObject.NULL.equals(obj)) {
                obj2 = obj;
            }
            objArr[i] = obj2;
        }
        return objArr;
    }

    public static /* synthetic */ int t(VQ vq) {
        int i = vq.d;
        vq.d = i + 1;
        return i;
    }

    public VQ B() {
        return x();
    }

    public AbstractC0963Uk C(String str, Object[] objArr, U1 u1) {
        C0626Jl.h(new e(str, objArr, u1));
        return this;
    }

    public final void D() {
        while (true) {
            List list = (List) this.j.poll();
            if (list == null) {
                break;
            } else {
                super.a((String) list.get(0), list.toArray());
            }
        }
        this.j.clear();
        while (true) {
            VF vf = (VF) this.k.poll();
            if (vf == null) {
                this.k.clear();
                return;
            }
            O(vf);
        }
    }

    public String E() {
        return this.b;
    }

    public boolean F() {
        return this.i != null;
    }

    public final void G(VF vf) {
        U1 u1 = (U1) this.h.remove(Integer.valueOf(vf.b));
        if (u1 != null) {
            Logger logger = n;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("calling ack %s with %s", Integer.valueOf(vf.b), vf.d));
            }
            u1.call(Q((JSONArray) vf.d));
            return;
        }
        Logger logger2 = n;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(String.format("bad ack %s", Integer.valueOf(vf.b)));
        }
    }

    public final void I(String str) {
        this.c = true;
        this.b = str;
        D();
        super.a("connect", new Object[0]);
    }

    public final void J() {
        Logger logger = n;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("server disconnect (%s)", this.e));
        }
        A();
        H("io server disconnect");
    }

    public final void K(VF vf) {
        ArrayList arrayList = new ArrayList(Arrays.asList(Q((JSONArray) vf.d)));
        Logger logger = n;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("emitting event %s", arrayList));
        }
        if (vf.b >= 0) {
            logger.fine("attaching ack callback to event");
            arrayList.add(w(vf.b));
        }
        if (!this.c) {
            this.j.add(arrayList);
            return;
        }
        if (arrayList.isEmpty()) {
            return;
        }
        if (!this.l.isEmpty()) {
            Object[] array = arrayList.toArray();
            Iterator it = this.l.iterator();
            while (it.hasNext()) {
                ((AbstractC0963Uk.a) it.next()).call(array);
            }
        }
        super.a(arrayList.remove(0).toString(), arrayList.toArray());
    }

    public final void M(VF vf) {
        if (this.e.equals(vf.c)) {
            switch (vf.a) {
                case 0:
                    Object obj = vf.d;
                    if ((obj instanceof JSONObject) && ((JSONObject) obj).has("sid")) {
                        try {
                            I(((JSONObject) vf.d).getString("sid"));
                        } catch (JSONException unused) {
                            return;
                        }
                    } else {
                        super.a("connect_error", new YQ("It seems you are trying to reach a Socket.IO server in v2.x with a v3.x client, which is not possible"));
                    }
                    break;
                case 1:
                    J();
                    break;
                case 2:
                    K(vf);
                    break;
                case 3:
                    G(vf);
                    break;
                case 4:
                    A();
                    super.a("connect_error", vf.d);
                    break;
                case 5:
                    K(vf);
                    break;
                case 6:
                    G(vf);
                    break;
            }
        }
    }

    public VQ N() {
        C0626Jl.h(new c());
        return this;
    }

    public final void P() {
        if (this.i != null) {
            return;
        }
        this.i = new b(this.f);
    }

    @Override // defpackage.AbstractC0963Uk
    public AbstractC0963Uk a(String str, Object... objArr) {
        if (!o.containsKey(str)) {
            C0626Jl.h(new d(objArr, str));
            return this;
        }
        throw new RuntimeException("'" + str + "' is a reserved event name");
    }

    public final U1 w(int i) {
        return new f(new boolean[]{false}, i, this);
    }

    public VQ x() {
        C0626Jl.h(new g());
        return this;
    }

    public VQ y() {
        return N();
    }

    public boolean z() {
        return this.c;
    }
}
