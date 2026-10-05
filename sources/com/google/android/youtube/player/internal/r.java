package com.google.android.youtube.player.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.youtube.player.YouTubeApiServiceUtil;
import com.google.android.youtube.player.YouTubeInitializationResult;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r<T extends IInterface> implements t {
    final Handler a;
    private final Context b;
    private T c;
    private ArrayList<t.a> d;
    private ArrayList<t.b> g;
    private ServiceConnection j;
    private final ArrayList<t.a> e = new ArrayList<>();
    private boolean f = false;
    private boolean h = false;
    private final ArrayList<b<?>> i = new ArrayList<>();
    private boolean k = false;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[YouTubeInitializationResult.values().length];
            a = iArr;
            try {
                iArr[YouTubeInitializationResult.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public abstract class b<TListener> {
        private TListener b;

        public b(TListener tlistener) {
            this.b = tlistener;
            synchronized (r.this.i) {
                r.this.i.add(this);
            }
        }

        public final void a() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.b;
            }
            a(tlistener);
        }

        public abstract void a(TListener tlistener);

        public final void b() {
            synchronized (this) {
                this.b = null;
            }
        }
    }

    public final class c extends b<Boolean> {
        public final YouTubeInitializationResult b;
        public final IBinder c;

        public c(String str, IBinder iBinder) {
            super(Boolean.TRUE);
            this.b = r.b(str);
            this.c = iBinder;
        }

        @Override // com.google.android.youtube.player.internal.r.b
        public final /* synthetic */ void a(Boolean bool) {
            if (bool != null) {
                if (a.a[this.b.ordinal()] != 1) {
                    r.this.a(this.b);
                    return;
                }
                try {
                    if (r.this.b().equals(this.c.getInterfaceDescriptor())) {
                        r rVar = r.this;
                        rVar.c = rVar.a(this.c);
                        if (r.this.c != null) {
                            r.this.g();
                            return;
                        }
                    }
                } catch (RemoteException unused) {
                }
                r.this.a();
                r.this.a(YouTubeInitializationResult.INTERNAL_ERROR);
            }
        }
    }

    public final class d extends com.google.android.youtube.player.internal.c.a {
        public d() {
        }

        @Override // com.google.android.youtube.player.internal.c
        public final void a(String str, IBinder iBinder) {
            r rVar = r.this;
            Handler handler = rVar.a;
            handler.sendMessage(handler.obtainMessage(1, new c(str, iBinder)));
        }
    }

    public final class e extends Handler {
        public e() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 3) {
                r.this.a((YouTubeInitializationResult) message.obj);
                return;
            }
            if (i == 4) {
                synchronized (r.this.d) {
                    try {
                        if (r.this.k && r.this.f() && r.this.d.contains(message.obj)) {
                            ((t.a) message.obj).a();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            }
            if (i != 2 || r.this.f()) {
                int i2 = message.what;
                if (i2 == 2 || i2 == 1) {
                    ((b) message.obj).a();
                }
            }
        }
    }

    public final class f implements ServiceConnection {
        public f() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            r.this.b(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            r.this.c = null;
            r.this.h();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r(Context context, t.a aVar, t.b bVar) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Clients must be created on the UI thread.");
        }
        this.b = (Context) ab.a(context);
        ArrayList<t.a> arrayList = new ArrayList<>();
        this.d = arrayList;
        arrayList.add(ab.a(aVar));
        ArrayList<t.b> arrayList2 = new ArrayList<>();
        this.g = arrayList2;
        arrayList2.add(ab.a(bVar));
        this.a = new e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static YouTubeInitializationResult b(String str) {
        try {
            return YouTubeInitializationResult.valueOf(str);
        } catch (IllegalArgumentException unused) {
            return YouTubeInitializationResult.UNKNOWN_ERROR;
        } catch (NullPointerException unused2) {
            return YouTubeInitializationResult.UNKNOWN_ERROR;
        }
    }

    public abstract T a(IBinder iBinder);

    public abstract void a(i iVar, d dVar);

    public abstract String b();

    public abstract String c();

    @Override // com.google.android.youtube.player.internal.t
    public final void e() {
        this.k = true;
        YouTubeInitializationResult youTubeInitializationResultIsYouTubeApiServiceAvailable = YouTubeApiServiceUtil.isYouTubeApiServiceAvailable(this.b);
        if (youTubeInitializationResultIsYouTubeApiServiceAvailable != YouTubeInitializationResult.SUCCESS) {
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage(3, youTubeInitializationResultIsYouTubeApiServiceAvailable));
            return;
        }
        Intent intent = new Intent(c()).setPackage(z.a(this.b));
        if (this.j != null) {
            Log.e("YouTubeClient", "Calling connect() while still connected, missing disconnect().");
            a();
        }
        f fVar = new f();
        this.j = fVar;
        if (this.b.bindService(intent, fVar, 129)) {
            return;
        }
        Handler handler2 = this.a;
        handler2.sendMessage(handler2.obtainMessage(3, YouTubeInitializationResult.ERROR_CONNECTING_TO_SERVICE));
    }

    public final boolean f() {
        return this.c != null;
    }

    public final void g() {
        synchronized (this.d) {
            try {
                boolean z = true;
                ab.a(!this.f);
                this.a.removeMessages(4);
                this.f = true;
                if (this.e.size() != 0) {
                    z = false;
                }
                ab.a(z);
                ArrayList<t.a> arrayList = this.d;
                int size = arrayList.size();
                for (int i = 0; i < size && this.k && f(); i++) {
                    if (!this.e.contains(arrayList.get(i))) {
                        arrayList.get(i).a();
                    }
                }
                this.e.clear();
                this.f = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h() {
        this.a.removeMessages(4);
        synchronized (this.d) {
            try {
                this.f = true;
                ArrayList<t.a> arrayList = this.d;
                int size = arrayList.size();
                for (int i = 0; i < size && this.k; i++) {
                    if (this.d.contains(arrayList.get(i))) {
                        arrayList.get(i).b();
                    }
                }
                this.f = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void i() {
        if (!f()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T j() {
        i();
        return this.c;
    }

    public final void b(IBinder iBinder) {
        try {
            a(i.a.a(iBinder), new d());
        } catch (RemoteException unused) {
            Log.w("YouTubeClient", "service died");
        }
    }

    @Override // com.google.android.youtube.player.internal.t
    public void d() {
        h();
        this.k = false;
        synchronized (this.i) {
            try {
                int size = this.i.size();
                for (int i = 0; i < size; i++) {
                    this.i.get(i).b();
                }
                this.i.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        ServiceConnection serviceConnection = this.j;
        if (serviceConnection != null) {
            try {
                this.b.unbindService(serviceConnection);
            } catch (IllegalArgumentException e2) {
                Log.w("YouTubeClient", "Unexpected error from unbindService()", e2);
            }
        }
        this.c = null;
        this.j = null;
    }

    public final void a(YouTubeInitializationResult youTubeInitializationResult) {
        this.a.removeMessages(4);
        synchronized (this.g) {
            try {
                this.h = true;
                ArrayList<t.b> arrayList = this.g;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    if (!this.k) {
                        return;
                    }
                    if (this.g.contains(arrayList.get(i))) {
                        arrayList.get(i).a(youTubeInitializationResult);
                    }
                }
                this.h = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
