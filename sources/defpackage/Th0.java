package defpackage;

import android.content.Context;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes2.dex */
public final class Th0 {
    public final Context a;
    public final FI b;
    public final InterfaceC3940t80 c;
    public final Mh0 d = new Mh0(this, true);
    public final Mh0 e = new Mh0(this, false);
    public boolean f;

    public Th0(Context context, FI fi, C80 c80, InterfaceC2170f60 interfaceC2170f60, InterfaceC1879cX interfaceC1879cX, InterfaceC3940t80 interfaceC3940t80) {
        this.a = context;
        this.b = fi;
        this.c = interfaceC3940t80;
    }

    public static /* bridge */ /* synthetic */ InterfaceC2170f60 a(Th0 th0) {
        th0.getClass();
        return null;
    }

    public static /* bridge */ /* synthetic */ InterfaceC1879cX e(Th0 th0) {
        th0.getClass();
        return null;
    }

    public final FI d() {
        return this.b;
    }

    public final void f(boolean z) {
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        IntentFilter intentFilter2 = new IntentFilter("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intentFilter2.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.f = z;
        Mh0 mh0 = this.e;
        Context context = this.a;
        mh0.a(context, intentFilter2);
        if (this.f) {
            this.d.b(context, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST");
        } else {
            this.d.a(context, intentFilter);
        }
    }
}
