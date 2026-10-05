package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import androidx.core.internal.view.SupportMenu;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: renamed from: wG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4192wG {
    public static final Handler o = new a(Looper.getMainLooper());
    public static volatile C4192wG p = null;
    public final g a;
    public final c b;
    public final List c;
    public final Context d;
    public final C4482zj e;
    public final InterfaceC2421i9 f;
    public final C1874cS g;
    public final Map h;
    public final Map i;
    public final ReferenceQueue j;
    public final Bitmap.Config k;
    public boolean l;
    public volatile boolean m;
    public boolean n;

    /* JADX INFO: renamed from: wG$a */
    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 3) {
                X1 x1 = (X1) message.obj;
                if (x1.g().m) {
                    AbstractC4047uX.v("Main", "canceled", x1.b.d(), "target got garbage collected");
                }
                x1.a.b(x1.k());
                return;
            }
            int i2 = 0;
            if (i == 8) {
                List list = (List) message.obj;
                int size = list.size();
                while (i2 < size) {
                    RunnableC2091e8 runnableC2091e8 = (RunnableC2091e8) list.get(i2);
                    runnableC2091e8.b.d(runnableC2091e8);
                    i2++;
                }
                return;
            }
            if (i != 13) {
                throw new AssertionError("Unknown handler message received: " + message.what);
            }
            List list2 = (List) message.obj;
            int size2 = list2.size();
            while (i2 < size2) {
                X1 x2 = (X1) list2.get(i2);
                x2.a.k(x2);
                i2++;
            }
        }
    }

    /* JADX INFO: renamed from: wG$b */
    public static class b {
        public final Context a;
        public InterfaceC1254ak b;
        public ExecutorService c;
        public InterfaceC2421i9 d;
        public g e;
        public List f;
        public Bitmap.Config g;
        public boolean h;
        public boolean i;

        public b(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.a = context.getApplicationContext();
        }

        public C4192wG a() {
            Context context = this.a;
            if (this.b == null) {
                this.b = AbstractC4047uX.g(context);
            }
            if (this.d == null) {
                this.d = new C2071dx(context);
            }
            if (this.c == null) {
                this.c = new C4354yG();
            }
            if (this.e == null) {
                this.e = g.a;
            }
            C1874cS c1874cS = new C1874cS(this.d);
            return new C4192wG(context, new C4482zj(context, this.c, C4192wG.o, this.b, this.d, c1874cS), this.d, null, this.e, this.f, c1874cS, this.g, this.h, this.i);
        }
    }

    /* JADX INFO: renamed from: wG$c */
    public static class c extends Thread {
        public final ReferenceQueue a;
        public final Handler b;

        /* JADX INFO: renamed from: wG$c$a */
        public class a implements Runnable {
            public final /* synthetic */ Exception a;

            public a(Exception exc) {
                this.a = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                throw new RuntimeException(this.a);
            }
        }

        public c(ReferenceQueue referenceQueue, Handler handler) {
            this.a = referenceQueue;
            this.b = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    X1.a aVar = (X1.a) this.a.remove(1000L);
                    Message messageObtainMessage = this.b.obtainMessage();
                    if (aVar != null) {
                        messageObtainMessage.what = 3;
                        messageObtainMessage.obj = aVar.a;
                        this.b.sendMessage(messageObtainMessage);
                    } else {
                        messageObtainMessage.recycle();
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e) {
                    this.b.post(new a(e));
                    return;
                }
            }
        }
    }

    /* JADX INFO: renamed from: wG$d */
    public interface d {
    }

    /* JADX INFO: renamed from: wG$e */
    public enum e {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(SupportMenu.CATEGORY_MASK);

        public final int a;

        e(int i) {
            this.a = i;
        }
    }

    /* JADX INFO: renamed from: wG$f */
    public enum f {
        LOW,
        NORMAL,
        HIGH
    }

    public C4192wG(Context context, C4482zj c4482zj, InterfaceC2421i9 interfaceC2421i9, d dVar, g gVar, List list, C1874cS c1874cS, Bitmap.Config config, boolean z, boolean z2) {
        this.d = context;
        this.e = c4482zj;
        this.f = interfaceC2421i9;
        this.a = gVar;
        this.k = config;
        ArrayList arrayList = new ArrayList((list != null ? list.size() : 0) + 7);
        arrayList.add(new C4450zL(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new C3164jf(context));
        arrayList.add(new FB(context));
        arrayList.add(new C0690Kf(context));
        arrayList.add(new T5(context));
        arrayList.add(new C3503nm(context));
        arrayList.add(new C3784rD(c4482zj.d, c1874cS));
        this.c = Collections.unmodifiableList(arrayList);
        this.g = c1874cS;
        this.h = new WeakHashMap();
        this.i = new WeakHashMap();
        this.l = z;
        this.m = z2;
        ReferenceQueue referenceQueue = new ReferenceQueue();
        this.j = referenceQueue;
        c cVar = new c(referenceQueue, o);
        this.b = cVar;
        cVar.start();
    }

    public static C4192wG n(Context context) {
        if (p == null) {
            synchronized (C4192wG.class) {
                try {
                    if (p == null) {
                        p = new b(context).a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return p;
    }

    public final void b(Object obj) {
        AbstractC4047uX.c();
        X1 x1 = (X1) this.h.remove(obj);
        if (x1 != null) {
            x1.a();
            this.e.c(x1);
        }
        if (obj instanceof ImageView) {
            ViewTreeObserverOnPreDrawListenerC0909Si viewTreeObserverOnPreDrawListenerC0909Si = (ViewTreeObserverOnPreDrawListenerC0909Si) this.i.remove((ImageView) obj);
            if (viewTreeObserverOnPreDrawListenerC0909Si != null) {
                viewTreeObserverOnPreDrawListenerC0909Si.a();
            }
        }
    }

    public void c(ImageView imageView) {
        b(imageView);
    }

    public void d(RunnableC2091e8 runnableC2091e8) {
        X1 x1H = runnableC2091e8.h();
        List listI = runnableC2091e8.i();
        boolean z = (listI == null || listI.isEmpty()) ? false : true;
        if (x1H != null || z) {
            Uri uri = runnableC2091e8.j().d;
            runnableC2091e8.k();
            Bitmap bitmapQ = runnableC2091e8.q();
            e eVarM = runnableC2091e8.m();
            if (x1H != null) {
                f(bitmapQ, eVarM, x1H);
            }
            if (z) {
                int size = listI.size();
                for (int i = 0; i < size; i++) {
                    f(bitmapQ, eVarM, (X1) listI.get(i));
                }
            }
        }
    }

    public void e(ImageView imageView, ViewTreeObserverOnPreDrawListenerC0909Si viewTreeObserverOnPreDrawListenerC0909Si) {
        this.i.put(imageView, viewTreeObserverOnPreDrawListenerC0909Si);
    }

    public final void f(Bitmap bitmap, e eVar, X1 x1) {
        if (x1.l()) {
            return;
        }
        if (!x1.m()) {
            this.h.remove(x1.k());
        }
        if (bitmap == null) {
            x1.c();
            if (this.m) {
                AbstractC4047uX.u("Main", "errored", x1.b.d());
                return;
            }
            return;
        }
        if (eVar == null) {
            throw new AssertionError("LoadedFrom cannot be null.");
        }
        x1.b(bitmap, eVar);
        if (this.m) {
            AbstractC4047uX.v("Main", "completed", x1.b.d(), "from " + eVar);
        }
    }

    public void g(X1 x1) {
        Object objK = x1.k();
        if (objK != null && this.h.get(objK) != x1) {
            b(objK);
            this.h.put(objK, x1);
        }
        l(x1);
    }

    public List h() {
        return this.c;
    }

    public C4035uL i(int i) {
        if (i != 0) {
            return new C4035uL(this, null, i);
        }
        throw new IllegalArgumentException("Resource ID must not be zero.");
    }

    public Bitmap j(String str) {
        Bitmap bitmap = this.f.get(str);
        if (bitmap != null) {
            this.g.d();
        } else {
            this.g.e();
        }
        return bitmap;
    }

    public void k(X1 x1) {
        Bitmap bitmapJ = KB.a(x1.e) ? j(x1.d()) : null;
        if (bitmapJ == null) {
            g(x1);
            if (this.m) {
                AbstractC4047uX.u("Main", "resumed", x1.b.d());
                return;
            }
            return;
        }
        e eVar = e.MEMORY;
        f(bitmapJ, eVar, x1);
        if (this.m) {
            AbstractC4047uX.v("Main", "completed", x1.b.d(), "from " + eVar);
        }
    }

    public void l(X1 x1) {
        this.e.h(x1);
    }

    public C3792rL m(C3792rL c3792rL) {
        C3792rL c3792rLA = this.a.a(c3792rL);
        if (c3792rLA != null) {
            return c3792rLA;
        }
        throw new IllegalStateException("Request transformer " + this.a.getClass().getCanonicalName() + " returned null for " + c3792rL);
    }

    /* JADX INFO: renamed from: wG$g */
    public interface g {
        public static final g a = new a();

        C3792rL a(C3792rL c3792rL);

        /* JADX INFO: renamed from: wG$g$a */
        public static class a implements g {
            @Override // defpackage.C4192wG.g
            public C3792rL a(C3792rL c3792rL) {
                return c3792rL;
            }
        }
    }
}
