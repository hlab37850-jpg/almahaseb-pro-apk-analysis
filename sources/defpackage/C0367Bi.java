package defpackage;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.google.zxing.LuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.client.android.R;

/* JADX INFO: renamed from: Bi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0367Bi {
    public static final String k = "Bi";
    public C3564oa a;
    public HandlerThread b;
    public Handler c;
    public C4390yi d;
    public Handler e;
    public Rect f;
    public boolean g = false;
    public final Object h = new Object();
    public final Handler.Callback i = new a();
    public final LH j = new b();

    /* JADX INFO: renamed from: Bi$a */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == R.id.zxing_decode) {
                C0367Bi.this.g((C3391mR) message.obj);
                return true;
            }
            if (i != R.id.zxing_preview_failed) {
                return true;
            }
            C0367Bi.this.h();
            return true;
        }
    }

    /* JADX INFO: renamed from: Bi$b */
    public class b implements LH {
        public b() {
        }

        @Override // defpackage.LH
        public void a(Exception exc) {
            synchronized (C0367Bi.this.h) {
                try {
                    if (C0367Bi.this.g) {
                        C0367Bi.this.c.obtainMessage(R.id.zxing_preview_failed).sendToTarget();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // defpackage.LH
        public void b(C3391mR c3391mR) {
            synchronized (C0367Bi.this.h) {
                try {
                    if (C0367Bi.this.g) {
                        C0367Bi.this.c.obtainMessage(R.id.zxing_decode, c3391mR).sendToTarget();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public C0367Bi(C3564oa c3564oa, C4390yi c4390yi, Handler handler) {
        AbstractC3804rX.a();
        this.a = c3564oa;
        this.d = c4390yi;
        this.e = handler;
    }

    public LuminanceSource f(C3391mR c3391mR) {
        if (this.f == null) {
            return null;
        }
        return c3391mR.a();
    }

    public final void g(C3391mR c3391mR) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        c3391mR.i(this.f);
        LuminanceSource luminanceSourceF = f(c3391mR);
        Result resultB = luminanceSourceF != null ? this.d.b(luminanceSourceF) : null;
        if (resultB != null) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            Log.d(k, "Found barcode in " + (jCurrentTimeMillis2 - jCurrentTimeMillis) + " ms");
            if (this.e != null) {
                Message messageObtain = Message.obtain(this.e, R.id.zxing_decode_succeeded, new Y6(resultB, c3391mR));
                messageObtain.setData(new Bundle());
                messageObtain.sendToTarget();
            }
        } else {
            Handler handler = this.e;
            if (handler != null) {
                Message.obtain(handler, R.id.zxing_decode_failed).sendToTarget();
            }
        }
        if (this.e != null) {
            Message.obtain(this.e, R.id.zxing_possible_result_points, this.d.c()).sendToTarget();
        }
        h();
    }

    public final void h() {
        this.a.q(this.j);
    }

    public void i(Rect rect) {
        this.f = rect;
    }

    public void j(C4390yi c4390yi) {
        this.d = c4390yi;
    }

    public void k() {
        AbstractC3804rX.a();
        HandlerThread handlerThread = new HandlerThread(k);
        this.b = handlerThread;
        handlerThread.start();
        this.c = new Handler(this.b.getLooper(), this.i);
        this.g = true;
        h();
    }

    public void l() {
        AbstractC3804rX.a();
        synchronized (this.h) {
            this.g = false;
            this.c.removeCallbacksAndMessages(null);
            this.b.quit();
        }
    }
}
