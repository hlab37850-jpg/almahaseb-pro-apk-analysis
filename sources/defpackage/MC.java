package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class MC {
    public SharedPreferences b;
    public SharedPreferences.Editor c;
    public Context d;
    public String a = MC.class.getSimpleName();
    public int e = 0;

    public MC(Context context) {
        this.d = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidhive_gcm", 0);
        this.b = sharedPreferences;
        this.c = sharedPreferences.edit();
    }

    public void a(String str) {
        String strC = c();
        if (strC != null) {
            str = strC + "|" + str;
        }
        this.c.putString("notifications", str);
        this.c.commit();
    }

    public int b() {
        if (this.b.getInt("msg_cnt", 0) != 0) {
            return this.b.getInt("msg_cnt", 0);
        }
        return 0;
    }

    public String c() {
        return this.b.getString("notifications", null);
    }

    public C1798bX d() {
        if (this.b.getString("user_id", null) != null) {
            return new C1798bX(this.b.getString("user_id", null), this.b.getString("user_name", null), this.b.getString("user_email", null), this.b.getString("user_imei", null), this.b.getString("user_support", "0"));
        }
        return null;
    }

    public void e(int i) {
        this.c.putInt("msg_cnt", i);
        this.c.commit();
    }

    public void f(C1798bX c1798bX) {
        this.c.putString("user_id", c1798bX.b());
        this.c.putString("user_name", c1798bX.e());
        this.c.putString("user_email", c1798bX.a());
        this.c.putString("user_imei", c1798bX.c());
        this.c.putString("user_support", c1798bX.f());
        this.c.commit();
        Log.e(this.a, "User is stored in shared preferences. " + c1798bX.e() + ", " + c1798bX.a());
    }
}
