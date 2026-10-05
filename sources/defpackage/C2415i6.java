package defpackage;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.itextpdf.tool.xml.css.CSS;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: renamed from: i6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2415i6 {
    public static final String i = "i6";
    public static final Collection j;
    public boolean a;
    public boolean b;
    public final boolean c;
    public final Camera d;
    public Handler e;
    public int f = 1;
    public final Handler.Callback g;
    public final Camera.AutoFocusCallback h;

    /* JADX INFO: renamed from: i6$a */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != C2415i6.this.f) {
                return false;
            }
            C2415i6.this.h();
            return true;
        }
    }

    /* JADX INFO: renamed from: i6$b */
    public class b implements Camera.AutoFocusCallback {

        /* JADX INFO: renamed from: i6$b$a */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C2415i6.this.b = false;
                C2415i6.this.f();
            }
        }

        public b() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            C2415i6.this.e.post(new a());
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        j = arrayList;
        arrayList.add(CSS.Value.AUTO);
        arrayList.add("macro");
    }

    public C2415i6(Camera camera, C3727qa c3727qa) {
        a aVar = new a();
        this.g = aVar;
        this.h = new b();
        this.e = new Handler(aVar);
        this.d = camera;
        String focusMode = camera.getParameters().getFocusMode();
        boolean z = c3727qa.c() && j.contains(focusMode);
        this.c = z;
        Log.i(i, "Current focus mode '" + focusMode + "'; use auto focus? " + z);
        i();
    }

    public final synchronized void f() {
        if (!this.a && !this.e.hasMessages(this.f)) {
            Handler handler = this.e;
            handler.sendMessageDelayed(handler.obtainMessage(this.f), 2000L);
        }
    }

    public final void g() {
        this.e.removeMessages(this.f);
    }

    public final void h() {
        if (!this.c || this.a || this.b) {
            return;
        }
        try {
            this.d.autoFocus(this.h);
            this.b = true;
        } catch (RuntimeException e) {
            Log.w(i, "Unexpected exception while focusing", e);
            f();
        }
    }

    public void i() {
        this.a = false;
        h();
    }

    public void j() {
        this.a = true;
        this.b = false;
        g();
        if (this.c) {
            try {
                this.d.cancelAutoFocus();
            } catch (RuntimeException e) {
                Log.w(i, "Unexpected exception while cancelling focusing", e);
            }
        }
    }
}
