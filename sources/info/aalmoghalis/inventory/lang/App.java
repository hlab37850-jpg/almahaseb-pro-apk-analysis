package info.aalmoghalis.inventory.lang;

import android.content.Context;
import android.content.res.Configuration;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;
import defpackage.C2160f10;
import defpackage.MO;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class App extends MultiDexApplication {
    public List a = new ArrayList();
    public List b = new ArrayList();

    public List a() {
        return this.a;
    }

    @Override // androidx.multidex.MultiDexApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    public List b() {
        return this.b;
    }

    public void c(List list) {
        this.a = list;
    }

    public void d(List list) {
        this.b = list;
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        C2160f10.h = MO.b(this);
    }
}
