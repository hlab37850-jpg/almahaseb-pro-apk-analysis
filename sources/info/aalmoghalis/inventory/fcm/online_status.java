package info.aalmoghalis.inventory.fcm;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.core.internal.view.SupportMenu;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import com.zebra.sdk.util.internal.StringUtilities;
import defpackage.AbstractC1197a4;
import defpackage.AbstractC1794bT;
import defpackage.AbstractC3132jE;
import defpackage.AbstractC4158vt;
import defpackage.AbstractC4371yX;
import defpackage.C2407i2;
import defpackage.C3881sT;
import defpackage.IN;
import defpackage.InterfaceC2295gf;
import defpackage.Q00;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;
import info.aalmoghalis.inventory.fcm.online_status;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class online_status extends BaseActivity {
    public static List g = new ArrayList();
    public C2407i2 c;
    public Z00 d;
    public SQLiteDatabase e;
    public C3881sT f;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (online_status.this.c.d.getVisibility() == 0 || AbstractC1794bT.e() || FragmentStatePagerSupport_Main.S == null) {
                return;
            }
            online_status.this.N();
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            online_status.this.B(this.a);
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ String a;

        public c(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            online_status.this.B(this.a);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb = new StringBuilder();
            sb.append(":attach_status::f2=");
            sb.append(FragmentStatePagerSupport_Main.S == null ? "null" : "notNull");
            Log.d("fire_chk=", sb.toString());
            Q00 q00 = FragmentStatePagerSupport_Main.S;
            if (q00 != null) {
                q00.d.q = online_status.this;
            }
        }
    }

    public static JSONArray C(JSONArray jSONArray, String... strArr) throws JSONException {
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            JSONObject jSONObject2 = new JSONObject();
            for (String str : strArr) {
                if (jSONObject.has(str)) {
                    jSONObject2.put(str, jSONObject.get(str));
                }
            }
            jSONArray2.put(jSONObject2);
        }
        return jSONArray2;
    }

    public static /* synthetic */ void E(Integer num) {
    }

    public static /* synthetic */ void G(EditText editText, AlertDialog alertDialog, View view) {
        String strTrim = editText.getText().toString().trim();
        if (!AbstractC4371yX.d(strTrim)) {
            editText.setError("Invalid email format");
            return;
        }
        Q00 q00 = FragmentStatePagerSupport_Main.S;
        if (q00 != null) {
            q00.k(strTrim);
            alertDialog.dismiss();
        }
    }

    public static List H(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (jSONArray.length() > 0) {
            JSONObject jSONObject = jSONArray.getJSONObject(0);
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                arrayList3.add(itKeys.next());
                arrayList4.add("");
            }
            arrayList2.add(arrayList3);
            arrayList.add(arrayList4);
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            ArrayList arrayList5 = new ArrayList();
            for (int i2 = 0; i2 < ((List) arrayList2.get(0)).size(); i2++) {
                arrayList5.add(jSONObject2.optString((String) ((List) arrayList2.get(0)).get(i2)));
            }
            arrayList.add(arrayList5);
        }
        return arrayList;
    }

    private void M() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void B(String str) {
        Log.d("trace_status=", ":start:" + this.d.ia("online_share_type", "0"));
        if (this.c.d.getVisibility() == 0 || AbstractC1794bT.e()) {
            Log.d("trace_status=", "progressBar:VISIBLE or Sync is running");
            return;
        }
        Log.d("trace_status=", ":end:" + this.d.ia("online_share_type", "0"));
        StringBuilder sb = new StringBuilder();
        sb.append(":start::f2=");
        sb.append(FragmentStatePagerSupport_Main.S == null ? "null" : "notNull");
        sb.append(":n=");
        sb.append(AbstractC4158vt.a(this));
        Log.d("fire_chk=", sb.toString());
        this.d.m0();
        if (AbstractC4158vt.a(this)) {
            AbstractC3132jE.d(new Callable() { // from class: i10
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.D();
                }
            }).m(IN.c()).g().e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: j10
                @Override // defpackage.InterfaceC2295gf
                public final void accept(Object obj) {
                    online_status.E((Integer) obj);
                }
            });
        }
        new Handler().postDelayed(new d(), CoroutineLiveDataKt.DEFAULT_TIMEOUT);
    }

    public final /* synthetic */ Integer D() {
        AbstractC1794bT.c(this);
        AbstractC1794bT.a();
        return 1;
    }

    public void I(String str) {
        try {
            Log.d("socket:online_status=", str + "");
            this.c.b.append("\n***\n" + str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void J(String str) {
        try {
            Log.d("socket:online_status=", str + "");
            this.c.b.setText("\n...\n" + str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void K() {
        String strIa;
        SpannableString spannableString;
        try {
            if (this.d.ia("online_share_type", "0").equals("2")) {
                L();
                return;
            }
            if (this.d.ia("online_users_un", "").equals(this.d.ia("online_users_p_un", ""))) {
                strIa = this.d.ia("online_users_un", "");
            } else {
                strIa = this.d.ia("online_users_un", "") + "->" + this.d.ia("online_users_p_un", "");
            }
            String str = getString(R.string.sync_user) + " " + strIa;
            String str2 = getString(R.string.sync_dev_id) + " " + this.d.ia("online_dev_id", "");
            String string = (this.d.ja("online_server", false) || this.d.ia("online_users_un", "").equals(this.d.ia("online_users_p_un", ""))) ? getString(R.string.sync_server) : getString(R.string.sync_client);
            String str3 = String.format("\n%s \n%s \n [%s] \n %s \n %s", str, str2, string, getString(R.string.app_name), getString(R.string.sync_end_date) + " " + P(this.d.ia("online_users_ts", "")).replace("00:00:00", ""));
            String str4 = String.format("\n%s \n%s \n", this.d.ia("online_data_cnt", ""), getString(R.string.sync_date) + " " + P(this.d.ia("online_data_last_time", "")));
            StringBuilder sb = new StringBuilder();
            sb.append(P(this.d.ia("online_last_time", "")));
            sb.append(StringUtilities.LF);
            String string2 = sb.toString();
            this.d.ia("online_last_request_id", "");
            new SpannableString(str3 + str4 + string2);
            if (P(this.d.ia("online_data_last_time", "")).equals(string2.replace(StringUtilities.LF, ""))) {
                String str5 = getString(R.string.sync_to) + " " + P(this.d.ia("online_last_time", "")) + StringUtilities.LF;
                spannableString = new SpannableString(str3 + str4 + str5);
                spannableString.setSpan(new ForegroundColorSpan(-16776961), str3.length() + str4.length(), str3.length() + str4.length() + str5.length(), 33);
                spannableString.setSpan(new ForegroundColorSpan(-16776961), str3.length(), (str3.length() + str4.length()) - 1, 33);
                this.c.d.setVisibility(8);
            } else {
                spannableString = new SpannableString(str3 + str4 + (getString(R.string.sync_to) + " " + P(this.d.ia("online_last_time", "")) + StringUtilities.LF));
                spannableString.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), str3.length(), (str3.length() + str4.length()) - 1, 33);
            }
            this.c.b.setText(spannableString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void L() {
    }

    public final void N() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter Email");
        final EditText editText = new EditText(this);
        editText.setInputType(32);
        editText.setHint("example@Gmail.com");
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(50, 0, 50, 0);
        editText.setLayoutParams(layoutParams);
        linearLayout.addView(editText);
        builder.setView(linearLayout);
        builder.setCancelable(false);
        builder.setPositiveButton(getString(R.string.resourceID_OK), (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(getString(R.string.resourceID_Cancel), new DialogInterface.OnClickListener() { // from class: k10
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.show();
        alertDialogCreate.getButton(-1).setOnClickListener(new View.OnClickListener() { // from class: l10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                online_status.G(editText, alertDialogCreate, view);
            }
        });
    }

    public void O() {
        if (g.size() == 0) {
            return;
        }
        int size = ((List) g.get(0)).size();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, size);
        this.c.e.setLayoutManager(gridLayoutManager);
        this.c.e.addItemDecoration(new DividerItemDecoration(this.c.e.getContext(), gridLayoutManager.getOrientation()));
        C3881sT c3881sT = new C3881sT(this, g, size);
        this.f = c3881sT;
        this.c.e.setAdapter(c3881sT);
        this.c.e.setVisibility(0);
        this.c.c.setVisibility(0);
    }

    public String P(String str) {
        if (str.equals("")) {
            return "";
        }
        Locale locale = Locale.ENGLISH;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", locale);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale).format((Date) new Timestamp(simpleDateFormat.parse(str).getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C2407i2 c2407i2C = C2407i2.c(getLayoutInflater());
        this.c = c2407i2C;
        setContentView(c2407i2C.getRoot());
        M();
        try {
            this.d = new Z00(this.e, this);
            AbstractC4158vt.a(this);
            Q00 q00 = FragmentStatePagerSupport_Main.S;
            if (q00 != null) {
                q00.d.q = this;
            } else if (this.d.ia("online_last_request_id", "0").equals("0") && this.d.S()) {
                this.d.m0();
            }
            K();
            Button button = this.c.f;
            button.setPaintFlags(button.getPaintFlags() | 8);
            String string = getString(R.string.wait);
            this.c.c.setOnClickListener(new a());
            this.c.f.setOnClickListener(new b(string));
            this.c.getRoot().setOnClickListener(new c(string));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_online_setting, menu);
        if (!this.d.ia("online_users_un", "").equals(this.d.ia("online_users_p_un", "")) || this.d.ia("online_users_un", "").length() <= 0) {
            menu.findItem(R.id.online_users).setVisible(false);
        } else {
            menu.findItem(R.id.online_users).setVisible(true);
        }
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Q00 q00 = FragmentStatePagerSupport_Main.S;
        if (q00 != null) {
            q00.d.q = null;
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId != R.id.online_users) {
            return super.onOptionsItemSelected(menuItem);
        }
        Q00 q00 = FragmentStatePagerSupport_Main.S;
        if (q00 != null) {
            q00.A();
        }
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
