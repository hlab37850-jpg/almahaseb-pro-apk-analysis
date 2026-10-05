package info.aalmoghalis.inventory.online;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.util.Log;
import defpackage.AbstractC3946tD;
import defpackage.C0631Jq;
import defpackage.C0719Li;
import defpackage.C2119eY;
import defpackage.C2441iS;
import defpackage.DL;
import defpackage.Z00;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;
import info.aalmoghalis.inventory.app.MyApplication;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class PhoneStatListener extends BroadcastReceiver {
    public SQLiteDatabase a;
    public Z00 b;
    public Context c;
    public String d = "";
    public int e = 0;

    public class a implements DL.b {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // DL.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            Log.e("black_list_res2:", str + ":" + PhoneStatListener.this.d + ":" + PhoneStatListener.this.b.ia("black_date", ""));
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getBoolean("error")) {
                    return;
                }
                JSONArray jSONArray = jSONObject.getJSONArray("black_list");
                PhoneStatListener.this.e = -1;
                for (int i = 0; i < jSONArray.length(); i++) {
                    PhoneStatListener.this.e = Integer.parseInt(((JSONObject) jSONArray.get(i)).getString("cnt"));
                    PhoneStatListener phoneStatListener = PhoneStatListener.this;
                    int i2 = phoneStatListener.e;
                    if (i2 >= 1) {
                        phoneStatListener.b.Mc("black_list", true);
                        PhoneStatListener.this.b.Lc("black_date", this.a);
                    } else if (i2 == 0) {
                        phoneStatListener.b.Mc("black_list", false);
                        PhoneStatListener.this.b.Lc("black_date", this.a);
                    }
                    Log.d("black_list=2", PhoneStatListener.this.e + ":" + this.a + ":" + PhoneStatListener.this.b.ia("black_date", ""));
                }
            } catch (JSONException unused) {
            }
        }
    }

    public class c implements DL.b {
        public final /* synthetic */ String a;

        public c(String str) {
            this.a = str;
        }

        @Override // DL.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getBoolean("error")) {
                    return;
                }
                JSONArray jSONArray = jSONObject.getJSONArray("black_list");
                PhoneStatListener.this.e = -1;
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                    PhoneStatListener.this.e = Integer.parseInt(jSONObject2.getString("cnt"));
                    PhoneStatListener phoneStatListener = PhoneStatListener.this;
                    if (phoneStatListener.e >= 1) {
                        phoneStatListener.b.Mc("prefLogin", false);
                        PhoneStatListener.this.b.Lc("prefPassword", "");
                        PhoneStatListener.this.b.Lc("pwd_date", this.a);
                    } else {
                        phoneStatListener.b.Lc("pwd_date", this.a);
                    }
                }
            } catch (JSONException unused) {
            }
        }
    }

    public final void a() {
        String str = "";
        try {
            String str2 = new SimpleDateFormat("dd-MM-yyyy H", Locale.ENGLISH).format(Calendar.getInstance().getTime());
            if (this.b.ia("black_date", "").equals(str2) || this.b.p3().equals("")) {
                return;
            }
            String str3 = this.d;
            if (str3 != null) {
                str = str3;
            }
            C2441iS c2441iS = new C2441iS(0, "https://easycard.work/inv/v1/black_list/_ID_/_AID_/check".replace("_ID_", str), new a(str2), new b());
            c2441iS.H(false);
            c2441iS.F(new C0719Li(150000, 1, 1.0f));
            MyApplication.b().a(c2441iS);
        } catch (Exception e) {
            Log.d("black_lst_error=", e.getMessage());
        }
    }

    public final void b() {
        String str = "";
        try {
            String str2 = new SimpleDateFormat("dd-MM-yyyy H", Locale.ENGLISH).format(Calendar.getInstance().getTime());
            if (this.b.ia("pwd_date", "").equals(str2) || this.b.p3().equals("")) {
                return;
            }
            String str3 = this.d;
            if (str3 != null) {
                str = str3;
            }
            C2441iS c2441iS = new C2441iS(0, "https://easycard.work/inv/v1/pwd_list/_ID_/check".replace("_ID_", str), new c(str2), new d());
            c2441iS.F(new C0719Li(150000, 1, 1.0f));
            MyApplication.b().a(c2441iS);
        } catch (Exception unused) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            int iB = AbstractC3946tD.b(context);
            this.b = new Z00(this.a, context);
            this.c = context;
            Log.d("status=", "status(" + iB + "):" + intent.getAction());
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
            if (iB == 1 || iB == 2) {
                this.d = this.b.Sb();
                a();
                b();
                String strIa = this.b.ia("bk_drive_flag", "0");
                FragmentStatePagerSupport_Main.b0 = strIa;
                if (strIa.equals("0") && this.b.ja("prefAutoBackup", true)) {
                    new C0631Jq(this.c, this.b).c();
                    this.b.Lc("bk_drive_flag", FragmentStatePagerSupport_Main.b0);
                }
            }
        } catch (Exception unused) {
        }
    }

    public class b implements DL.a {
        public b() {
        }

        @Override // DL.a
        public void a(C2119eY c2119eY) {
        }
    }

    public class d implements DL.a {
        public d() {
        }

        @Override // DL.a
        public void a(C2119eY c2119eY) {
        }
    }
}
