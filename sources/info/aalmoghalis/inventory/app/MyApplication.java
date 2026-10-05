package info.aalmoghalis.inventory.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import androidx.multidex.MultiDex;
import defpackage.AbstractC2038dY;
import defpackage.AbstractC3712qL;
import defpackage.C4278xL;

/* JADX INFO: loaded from: classes3.dex */
public class MyApplication extends Application {
    public static final String b = "MyApplication";
    public static MyApplication c;
    public C4278xL a;

    public static synchronized MyApplication b() {
        return c;
    }

    public void a(AbstractC3712qL abstractC3712qL) {
        abstractC3712qL.I(b);
        c().a(abstractC3712qL);
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    public C4278xL c() {
        if (this.a == null) {
            this.a = AbstractC2038dY.a(getApplicationContext());
        }
        return this.a;
    }

    public void d() {
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d();
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        c = this;
        d();
    }
}
