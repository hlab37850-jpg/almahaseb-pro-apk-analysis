package info.aalmoghalis.inventory.threads;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import defpackage.M00;
import defpackage.Q00;
import defpackage.Z00;

/* JADX INFO: loaded from: classes3.dex */
public class SocketService2 extends Service {
    public Looper a;
    public a b;
    public Context c;
    public SQLiteDatabase d;
    public Z00 e;
    public String f = "";
    public Q00 g;
    public M00 h;

    public final class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                Z00.Z = true;
            } catch (Exception e) {
                Log.d("service_err", e.getMessage() + "");
                Thread.currentThread().interrupt();
            }
            SocketService2.this.stopSelf(message.arg1);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.c = getApplicationContext();
        Z00 z00 = new Z00(this.d, this.c);
        this.e = z00;
        if (z00.ia("online_share_type", "0").equals("2")) {
            this.h = new M00(this.e, this, true, null);
        } else {
            this.g = new Q00(this.e, this, null);
        }
        HandlerThread handlerThread = new HandlerThread("ServiceStartArguments", 10);
        handlerThread.start();
        this.a = handlerThread.getLooper();
        this.b = new a(this.a);
    }

    @Override // android.app.Service
    public void onDestroy() {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.c == null || this.e == null) {
            this.c = getApplicationContext();
            this.e = new Z00(this.d, this.c);
        }
        Message messageObtainMessage = this.b.obtainMessage();
        messageObtainMessage.arg1 = i2;
        this.b.sendMessage(messageObtainMessage);
        return 1;
    }
}
