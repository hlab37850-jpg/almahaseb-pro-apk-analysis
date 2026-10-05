package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.firebase_messaging.zze;
import com.google.firebase.iid.zzad;
import com.google.firebase.iid.zzap;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: y40, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class ServiceConnectionC4337y40 implements ServiceConnection {
    public int a;
    public final Messenger b;
    public S40 c;
    public final Queue d;
    public final SparseArray e;
    public final /* synthetic */ zzad f;

    public ServiceConnectionC4337y40(zzad zzadVar) {
        this.f = zzadVar;
        this.a = 0;
        this.b = new Messenger(new zze(Looper.getMainLooper(), new Handler.Callback(this) { // from class: s40
            public final ServiceConnectionC4337y40 a;

            {
                this.a = this;
            }

            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.a.d(message);
            }
        }));
        this.d = new ArrayDeque();
        this.e = new SparseArray();
    }

    public final void a() {
        this.f.zzc.execute(new Runnable(this) { // from class: P40
            public final ServiceConnectionC4337y40 a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                final Y40 y40;
                final ServiceConnectionC4337y40 serviceConnectionC4337y40 = this.a;
                while (true) {
                    synchronized (serviceConnectionC4337y40) {
                        try {
                            if (serviceConnectionC4337y40.a != 2) {
                                return;
                            }
                            if (serviceConnectionC4337y40.d.isEmpty()) {
                                serviceConnectionC4337y40.f();
                                return;
                            } else {
                                y40 = (Y40) serviceConnectionC4337y40.d.poll();
                                serviceConnectionC4337y40.e.put(y40.a, y40);
                                serviceConnectionC4337y40.f.zzc.schedule(new Runnable(serviceConnectionC4337y40, y40) { // from class: V40
                                    public final ServiceConnectionC4337y40 a;
                                    public final Y40 b;

                                    {
                                        this.a = serviceConnectionC4337y40;
                                        this.b = y40;
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.a.b(this.b.a);
                                    }
                                }, 30L, TimeUnit.SECONDS);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        String strValueOf = String.valueOf(y40);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 8);
                        sb.append("Sending ");
                        sb.append(strValueOf);
                        Log.d("MessengerIpcClient", sb.toString());
                    }
                    Context context = serviceConnectionC4337y40.f.zzb;
                    Messenger messenger = serviceConnectionC4337y40.b;
                    Message messageObtain = Message.obtain();
                    messageObtain.what = y40.c;
                    messageObtain.arg1 = y40.a;
                    messageObtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", y40.d());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle("data", y40.d);
                    messageObtain.setData(bundle);
                    try {
                        serviceConnectionC4337y40.c.a(messageObtain);
                    } catch (RemoteException e) {
                        serviceConnectionC4337y40.c(2, e.getMessage());
                    }
                }
            }
        });
    }

    public final synchronized void b(int i) {
        Y40 y40 = (Y40) this.e.get(i);
        if (y40 != null) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Timing out request: ");
            sb.append(i);
            Log.w("MessengerIpcClient", sb.toString());
            this.e.remove(i);
            y40.b(new zzap(3, "Timed out waiting for response"));
            f();
        }
    }

    public final synchronized void c(int i, String str) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                String strValueOf = String.valueOf(str);
                Log.d("MessengerIpcClient", strValueOf.length() != 0 ? "Disconnected: ".concat(strValueOf) : new String("Disconnected: "));
            }
            int i2 = this.a;
            if (i2 == 0) {
                throw new IllegalStateException();
            }
            if (i2 != 1 && i2 != 2) {
                if (i2 == 3) {
                    this.a = 4;
                    return;
                } else {
                    if (i2 == 4) {
                        return;
                    }
                    int i3 = this.a;
                    StringBuilder sb = new StringBuilder(26);
                    sb.append("Unknown state: ");
                    sb.append(i3);
                    throw new IllegalStateException(sb.toString());
                }
            }
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Unbinding service");
            }
            this.a = 4;
            ConnectionTracker.getInstance().unbindService(this.f.zzb, this);
            zzap zzapVar = new zzap(i, str);
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((Y40) it.next()).b(zzapVar);
            }
            this.d.clear();
            for (int i4 = 0; i4 < this.e.size(); i4++) {
                ((Y40) this.e.valueAt(i4)).b(zzapVar);
            }
            this.e.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final boolean d(Message message) {
        int i = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Received response to request: ");
            sb.append(i);
            Log.d("MessengerIpcClient", sb.toString());
        }
        synchronized (this) {
            try {
                Y40 y40 = (Y40) this.e.get(i);
                if (y40 == null) {
                    StringBuilder sb2 = new StringBuilder(50);
                    sb2.append("Received response for unknown request: ");
                    sb2.append(i);
                    Log.w("MessengerIpcClient", sb2.toString());
                    return true;
                }
                this.e.remove(i);
                f();
                Bundle data = message.getData();
                if (data.getBoolean("unsupported", false)) {
                    y40.b(new zzap(4, "Not supported by GmsCore"));
                } else {
                    y40.a(data);
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized boolean e(Y40 y40) {
        int i = this.a;
        if (i == 0) {
            this.d.add(y40);
            Preconditions.checkState(this.a == 0);
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Starting bind to GmsCore");
            }
            this.a = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            if (ConnectionTracker.getInstance().bindService(this.f.zzb, intent, this, 1)) {
                this.f.zzc.schedule(new Runnable(this) { // from class: H40
                    public final ServiceConnectionC4337y40 a;

                    {
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.g();
                    }
                }, 30L, TimeUnit.SECONDS);
            } else {
                c(0, "Unable to bind to service");
            }
            return true;
        }
        if (i == 1) {
            this.d.add(y40);
            return true;
        }
        if (i == 2) {
            this.d.add(y40);
            a();
            return true;
        }
        if (i != 3 && i != 4) {
            int i2 = this.a;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Unknown state: ");
            sb.append(i2);
            throw new IllegalStateException(sb.toString());
        }
        return false;
    }

    public final synchronized void f() {
        try {
            if (this.a == 2 && this.d.isEmpty() && this.e.size() == 0) {
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
                }
                this.a = 3;
                ConnectionTracker.getInstance().unbindService(this.f.zzb, this);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void g() {
        if (this.a == 1) {
            c(1, "Timed out while binding");
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        this.f.zzc.execute(new Runnable(this, iBinder) { // from class: C40
            public final ServiceConnectionC4337y40 a;
            public final IBinder b;

            {
                this.a = this;
                this.b = iBinder;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ServiceConnectionC4337y40 serviceConnectionC4337y40 = this.a;
                IBinder iBinder2 = this.b;
                synchronized (serviceConnectionC4337y40) {
                    if (iBinder2 == null) {
                        serviceConnectionC4337y40.c(0, "Null service connection");
                        return;
                    }
                    try {
                        serviceConnectionC4337y40.c = new S40(iBinder2);
                        serviceConnectionC4337y40.a = 2;
                        serviceConnectionC4337y40.a();
                    } catch (RemoteException e) {
                        serviceConnectionC4337y40.c(0, e.getMessage());
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        this.f.zzc.execute(new Runnable(this) { // from class: L40
            public final ServiceConnectionC4337y40 a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.c(2, "Service disconnected");
            }
        });
    }
}
