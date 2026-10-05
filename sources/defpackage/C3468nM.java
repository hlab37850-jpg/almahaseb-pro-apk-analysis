package defpackage;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;

/* JADX INFO: renamed from: nM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3468nM {
    public int a;
    public WindowManager b;
    public OrientationEventListener c;
    public InterfaceC3386mM d;

    /* JADX INFO: renamed from: nM$a */
    public class a extends OrientationEventListener {
        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            int rotation;
            WindowManager windowManager = C3468nM.this.b;
            InterfaceC3386mM interfaceC3386mM = C3468nM.this.d;
            if (C3468nM.this.b == null || interfaceC3386mM == null || (rotation = windowManager.getDefaultDisplay().getRotation()) == C3468nM.this.a) {
                return;
            }
            C3468nM.this.a = rotation;
            interfaceC3386mM.a(rotation);
        }
    }

    public void e(Context context, InterfaceC3386mM interfaceC3386mM) {
        f();
        Context applicationContext = context.getApplicationContext();
        this.d = interfaceC3386mM;
        this.b = (WindowManager) applicationContext.getSystemService("window");
        a aVar = new a(applicationContext, 3);
        this.c = aVar;
        aVar.enable();
        this.a = this.b.getDefaultDisplay().getRotation();
    }

    public void f() {
        OrientationEventListener orientationEventListener = this.c;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        this.c = null;
        this.b = null;
        this.d = null;
    }
}
