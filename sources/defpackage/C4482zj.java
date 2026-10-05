package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: renamed from: zj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4482zj {
    public final b a;
    public final Context b;
    public final ExecutorService c;
    public final InterfaceC1254ak d;
    public final Map e;
    public final Map f;
    public final Map g;
    public final Set h;
    public final Handler i;
    public final Handler j;
    public final InterfaceC2421i9 k;
    public final C1874cS l;
    public final List m;
    public final c n;
    public final boolean o;
    public boolean p;

    /* JADX INFO: renamed from: zj$a */
    public static class a extends Handler {
        public final C4482zj a;

        /* JADX INFO: renamed from: zj$a$a, reason: collision with other inner class name */
        public class RunnableC0332a implements Runnable {
            public final /* synthetic */ Message a;

            public RunnableC0332a(Message message) {
                this.a = message;
            }

            @Override // java.lang.Runnable
            public void run() {
                throw new AssertionError("Unknown handler message received: " + this.a.what);
            }
        }

        public a(Looper looper, C4482zj c4482zj) {
            super(looper);
            this.a = c4482zj;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.a.v((X1) message.obj);
                    break;
                case 2:
                    this.a.o((X1) message.obj);
                    break;
                case 3:
                case 8:
                default:
                    C4192wG.o.post(new RunnableC0332a(message));
                    break;
                case 4:
                    this.a.p((RunnableC2091e8) message.obj);
                    break;
                case 5:
                    this.a.u((RunnableC2091e8) message.obj);
                    break;
                case 6:
                    this.a.q((RunnableC2091e8) message.obj, false);
                    break;
                case 7:
                    this.a.n();
                    break;
                case 9:
                    this.a.r((NetworkInfo) message.obj);
                    break;
                case 10:
                    this.a.m(message.arg1 == 1);
                    break;
                case 11:
                    this.a.s(message.obj);
                    break;
                case 12:
                    this.a.t(message.obj);
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: zj$b */
    public static class b extends HandlerThread {
        public b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    /* JADX INFO: renamed from: zj$c */
    public static class c extends BroadcastReceiver {
        public final C4482zj a;

        public c(C4482zj c4482zj) {
            this.a = c4482zj;
        }

        public void a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.a.o) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.a.b.registerReceiver(this, intentFilter);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                if (intent.hasExtra("state")) {
                    this.a.b(intent.getBooleanExtra("state", false));
                }
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                this.a.f(((ConnectivityManager) AbstractC4047uX.p(context, "connectivity")).getActiveNetworkInfo());
            }
        }
    }

    public C4482zj(Context context, ExecutorService executorService, Handler handler, InterfaceC1254ak interfaceC1254ak, InterfaceC2421i9 interfaceC2421i9, C1874cS c1874cS) {
        b bVar = new b();
        this.a = bVar;
        bVar.start();
        AbstractC4047uX.j(bVar.getLooper());
        this.b = context;
        this.c = executorService;
        this.e = new LinkedHashMap();
        this.f = new WeakHashMap();
        this.g = new WeakHashMap();
        this.h = new HashSet();
        this.i = new a(bVar.getLooper(), this);
        this.d = interfaceC1254ak;
        this.j = handler;
        this.k = interfaceC2421i9;
        this.l = c1874cS;
        this.m = new ArrayList(4);
        this.p = AbstractC4047uX.r(context);
        this.o = AbstractC4047uX.q(context, "android.permission.ACCESS_NETWORK_STATE");
        c cVar = new c(this);
        this.n = cVar;
        cVar.a();
    }

    public final void a(RunnableC2091e8 runnableC2091e8) {
        if (runnableC2091e8.s()) {
            return;
        }
        this.m.add(runnableC2091e8);
        if (this.i.hasMessages(7)) {
            return;
        }
        this.i.sendEmptyMessageDelayed(7, 200L);
    }

    public void b(boolean z) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(10, z ? 1 : 0, 0));
    }

    public void c(X1 x1) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(2, x1));
    }

    public void d(RunnableC2091e8 runnableC2091e8) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(4, runnableC2091e8));
    }

    public void e(RunnableC2091e8 runnableC2091e8) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(6, runnableC2091e8));
    }

    public void f(NetworkInfo networkInfo) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(9, networkInfo));
    }

    public void g(RunnableC2091e8 runnableC2091e8) {
        Handler handler = this.i;
        handler.sendMessageDelayed(handler.obtainMessage(5, runnableC2091e8), 500L);
    }

    public void h(X1 x1) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(1, x1));
    }

    public final void i() {
        if (this.f.isEmpty()) {
            return;
        }
        Iterator it = this.f.values().iterator();
        while (it.hasNext()) {
            X1 x1 = (X1) it.next();
            it.remove();
            if (x1.g().m) {
                AbstractC4047uX.u("Dispatcher", "replaying", x1.i().d());
            }
            w(x1, false);
        }
    }

    public final void j(List list) {
        if (list == null || list.isEmpty() || !((RunnableC2091e8) list.get(0)).o().m) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            RunnableC2091e8 runnableC2091e8 = (RunnableC2091e8) it.next();
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(AbstractC4047uX.l(runnableC2091e8));
        }
        AbstractC4047uX.u("Dispatcher", "delivered", sb.toString());
    }

    public final void k(X1 x1) {
        Object objK = x1.k();
        if (objK != null) {
            x1.k = true;
            this.f.put(objK, x1);
        }
    }

    public final void l(RunnableC2091e8 runnableC2091e8) {
        X1 x1H = runnableC2091e8.h();
        if (x1H != null) {
            k(x1H);
        }
        List listI = runnableC2091e8.i();
        if (listI != null) {
            int size = listI.size();
            for (int i = 0; i < size; i++) {
                k((X1) listI.get(i));
            }
        }
    }

    public void m(boolean z) {
        this.p = z;
    }

    public void n() {
        ArrayList arrayList = new ArrayList(this.m);
        this.m.clear();
        Handler handler = this.j;
        handler.sendMessage(handler.obtainMessage(8, arrayList));
        j(arrayList);
    }

    public void o(X1 x1) {
        String strD = x1.d();
        RunnableC2091e8 runnableC2091e8 = (RunnableC2091e8) this.e.get(strD);
        if (runnableC2091e8 != null) {
            runnableC2091e8.f(x1);
            if (runnableC2091e8.c()) {
                this.e.remove(strD);
                if (x1.g().m) {
                    AbstractC4047uX.u("Dispatcher", "canceled", x1.i().d());
                }
            }
        }
        if (this.h.contains(x1.j())) {
            this.g.remove(x1.k());
            if (x1.g().m) {
                AbstractC4047uX.v("Dispatcher", "canceled", x1.i().d(), "because paused request got canceled");
            }
        }
        X1 x2 = (X1) this.f.remove(x1.k());
        if (x2 == null || !x2.g().m) {
            return;
        }
        AbstractC4047uX.v("Dispatcher", "canceled", x2.i().d(), "from replaying");
    }

    public void p(RunnableC2091e8 runnableC2091e8) {
        if (KB.b(runnableC2091e8.n())) {
            this.k.b(runnableC2091e8.l(), runnableC2091e8.q());
        }
        this.e.remove(runnableC2091e8.l());
        a(runnableC2091e8);
        if (runnableC2091e8.o().m) {
            AbstractC4047uX.v("Dispatcher", "batched", AbstractC4047uX.l(runnableC2091e8), "for completion");
        }
    }

    public void q(RunnableC2091e8 runnableC2091e8, boolean z) {
        if (runnableC2091e8.o().m) {
            String strL = AbstractC4047uX.l(runnableC2091e8);
            StringBuilder sb = new StringBuilder();
            sb.append("for error");
            sb.append(z ? " (will replay)" : "");
            AbstractC4047uX.v("Dispatcher", "batched", strL, sb.toString());
        }
        this.e.remove(runnableC2091e8.l());
        a(runnableC2091e8);
    }

    public void r(NetworkInfo networkInfo) {
        ExecutorService executorService = this.c;
        if (executorService instanceof C4354yG) {
            ((C4354yG) executorService).a(networkInfo);
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return;
        }
        i();
    }

    public void s(Object obj) {
        if (this.h.add(obj)) {
            Iterator it = this.e.values().iterator();
            while (it.hasNext()) {
                RunnableC2091e8 runnableC2091e8 = (RunnableC2091e8) it.next();
                boolean z = runnableC2091e8.o().m;
                X1 x1H = runnableC2091e8.h();
                List listI = runnableC2091e8.i();
                boolean z2 = (listI == null || listI.isEmpty()) ? false : true;
                if (x1H != null || z2) {
                    if (x1H != null && x1H.j().equals(obj)) {
                        runnableC2091e8.f(x1H);
                        this.g.put(x1H.k(), x1H);
                        if (z) {
                            AbstractC4047uX.v("Dispatcher", "paused", x1H.b.d(), "because tag '" + obj + "' was paused");
                        }
                    }
                    if (z2) {
                        for (int size = listI.size() - 1; size >= 0; size--) {
                            X1 x1 = (X1) listI.get(size);
                            if (x1.j().equals(obj)) {
                                runnableC2091e8.f(x1);
                                this.g.put(x1.k(), x1);
                                if (z) {
                                    AbstractC4047uX.v("Dispatcher", "paused", x1.b.d(), "because tag '" + obj + "' was paused");
                                }
                            }
                        }
                    }
                    if (runnableC2091e8.c()) {
                        it.remove();
                        if (z) {
                            AbstractC4047uX.v("Dispatcher", "canceled", AbstractC4047uX.l(runnableC2091e8), "all actions paused");
                        }
                    }
                }
            }
        }
    }

    public void t(Object obj) {
        if (this.h.remove(obj)) {
            Iterator it = this.g.values().iterator();
            ArrayList arrayList = null;
            while (it.hasNext()) {
                X1 x1 = (X1) it.next();
                if (x1.j().equals(obj)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(x1);
                    it.remove();
                }
            }
            if (arrayList != null) {
                Handler handler = this.j;
                handler.sendMessage(handler.obtainMessage(13, arrayList));
            }
        }
    }

    public void u(RunnableC2091e8 runnableC2091e8) {
        if (runnableC2091e8.s()) {
            return;
        }
        boolean z = false;
        if (this.c.isShutdown()) {
            q(runnableC2091e8, false);
            return;
        }
        NetworkInfo activeNetworkInfo = this.o ? ((ConnectivityManager) AbstractC4047uX.p(this.b, "connectivity")).getActiveNetworkInfo() : null;
        boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        boolean zU = runnableC2091e8.u(this.p, activeNetworkInfo);
        boolean zV = runnableC2091e8.v();
        if (!zU) {
            if (this.o && zV) {
                z = true;
            }
            q(runnableC2091e8, z);
            if (z) {
                l(runnableC2091e8);
                return;
            }
            return;
        }
        if (this.o && !z2) {
            q(runnableC2091e8, zV);
            if (zV) {
                l(runnableC2091e8);
                return;
            }
            return;
        }
        if (runnableC2091e8.o().m) {
            AbstractC4047uX.u("Dispatcher", "retrying", AbstractC4047uX.l(runnableC2091e8));
        }
        if (runnableC2091e8.k() instanceof C3784rD.a) {
            runnableC2091e8.i |= EnumC3704qD.NO_CACHE.a;
        }
        runnableC2091e8.p = this.c.submit(runnableC2091e8);
    }

    public void v(X1 x1) {
        w(x1, true);
    }

    public void w(X1 x1, boolean z) {
        if (this.h.contains(x1.j())) {
            this.g.put(x1.k(), x1);
            if (x1.g().m) {
                AbstractC4047uX.v("Dispatcher", "paused", x1.b.d(), "because tag '" + x1.j() + "' is paused");
                return;
            }
            return;
        }
        RunnableC2091e8 runnableC2091e8 = (RunnableC2091e8) this.e.get(x1.d());
        if (runnableC2091e8 != null) {
            runnableC2091e8.b(x1);
            return;
        }
        if (this.c.isShutdown()) {
            if (x1.g().m) {
                AbstractC4047uX.v("Dispatcher", "ignored", x1.b.d(), "because shut down");
                return;
            }
            return;
        }
        RunnableC2091e8 runnableC2091e8G = RunnableC2091e8.g(x1.g(), this, this.k, this.l, x1);
        runnableC2091e8G.p = this.c.submit(runnableC2091e8G);
        this.e.put(x1.d(), runnableC2091e8G);
        if (z) {
            this.f.remove(x1.k());
        }
        if (x1.g().m) {
            AbstractC4047uX.u("Dispatcher", "enqueued", x1.b.d());
        }
    }
}
