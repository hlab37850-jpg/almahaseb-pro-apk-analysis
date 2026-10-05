package info.aalmoghalis.inventory.fcm;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.iid.FirebaseInstanceId;
import com.itextpdf.text.pdf.PdfBoolean;
import defpackage.AbstractC2038dY;
import defpackage.C1798bX;
import defpackage.C2119eY;
import defpackage.C2441iS;
import defpackage.C3865sD;
import defpackage.C4278xL;
import defpackage.DL;
import defpackage.MC;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.Google_drive_list;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class LoginActivity extends BaseActivity {
    public String c = LoginActivity.class.getSimpleName();
    public EditText d;
    public EditText e;
    public TextInputLayout f;
    public TextInputLayout g;
    public Button h;
    public SQLiteDatabase i;
    public Z00 j;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LoginActivity.this.B();
        }
    }

    public class b implements DL.b {
        public b() {
        }

        @Override // DL.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("error").equals(PdfBoolean.FALSE)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("user");
                    new MC(LoginActivity.this).f(new C1798bX(jSONObject2.getString("user_id"), jSONObject2.getString("name"), jSONObject2.getString("email"), jSONObject2.getString("imei"), jSONObject2.getString("support_id")));
                    LoginActivity.this.startActivity(new Intent(LoginActivity.this.getApplicationContext(), (Class<?>) MainActivity.class));
                    LoginActivity.this.finish();
                } else {
                    Toast.makeText(LoginActivity.this.getApplicationContext(), "" + jSONObject.getJSONObject("error").getString("message"), 1).show();
                }
            } catch (JSONException e) {
                Log.e(LoginActivity.this.c, "json parsing error: " + e.getMessage());
            }
        }
    }

    public class c implements DL.a {
        public c() {
        }

        @Override // DL.a
        public void a(C2119eY c2119eY) {
            C3865sD c3865sD = c2119eY.a;
            Log.e(LoginActivity.this.c, "Volley error: " + c2119eY.getMessage() + ", code: " + c3865sD);
            Toast.makeText(LoginActivity.this.getApplicationContext(), "Check Your Internet or LOGIN...", 0).show();
        }
    }

    public class d extends C2441iS {
        public final /* synthetic */ String t;
        public final /* synthetic */ String u;
        public final /* synthetic */ String v;
        public final /* synthetic */ String w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i, String str, DL.b bVar, DL.a aVar, String str2, String str3, String str4, String str5) {
            super(i, str, bVar, aVar);
            this.t = str2;
            this.u = str3;
            this.v = str4;
            this.w = str5;
        }

        @Override // defpackage.AbstractC3712qL
        public Map n() {
            HashMap map = new HashMap();
            map.put("name", this.t);
            map.put("email", this.u);
            map.put("imei", this.v);
            map.put("token", this.w);
            return map;
        }
    }

    public class e implements TextWatcher {
        public View a;

        public /* synthetic */ e(LoginActivity loginActivity, View view, a aVar) {
            this(view);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int id = this.a.getId();
            if (id == R.id.input_email) {
                LoginActivity.this.D();
            } else {
                if (id != R.id.input_name) {
                    return;
                }
                LoginActivity.this.E();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public e(View view) {
            this.a = view;
        }
    }

    public static boolean A(String str) {
        return !TextUtils.isEmpty(str) && Patterns.EMAIL_ADDRESS.matcher(str).matches();
    }

    public final void B() {
        if (this.j.ia("PREF_ACCOUNT_NAME", "0").equals("0")) {
            Intent intent = new Intent(this, (Class<?>) Google_drive_list.class);
            intent.putExtra("change_email_flag", "1");
            startActivity(intent);
        }
        String strIa = this.j.ia("PREF_ACCOUNT_NAME", "0");
        Z00.T = strIa;
        if (!strIa.equals("0")) {
            this.e.setText(Z00.T);
        }
        if (E() && D()) {
            String string = this.d.getText().toString();
            String string2 = this.e.getText().toString();
            String str = Z00.R;
            String token = FirebaseInstanceId.getInstance().getToken();
            C4278xL c4278xLA = AbstractC2038dY.a(this);
            d dVar = new d(1, "https://easycard.work/inv/v1/user/login", new b(), new c(), string, string2, str, token);
            dVar.H(false);
            c4278xLA.a(dVar);
        }
    }

    public final void C(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(5);
        }
    }

    public final boolean D() {
        String strTrim = this.e.getText().toString().trim();
        if (!strTrim.isEmpty() && A(strTrim)) {
            this.g.setErrorEnabled(false);
            return true;
        }
        this.g.setError(getString(R.string.err_msg_email));
        C(this.e);
        return false;
    }

    public final boolean E() {
        if (!this.d.getText().toString().trim().isEmpty()) {
            this.f.setErrorEnabled(false);
            return true;
        }
        this.f.setError(getString(R.string.err_msg_name));
        C(this.d);
        return false;
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (new MC(this).d() != null) {
                startActivity(new Intent(this, (Class<?>) MainActivity.class));
                finish();
            }
            setContentView(R.layout.fcm_activity_login);
            this.j = new Z00(this.i, this);
            this.f = (TextInputLayout) findViewById(R.id.input_layout_name);
            this.g = (TextInputLayout) findViewById(R.id.input_layout_email);
            this.d = (EditText) findViewById(R.id.input_name);
            this.e = (EditText) findViewById(R.id.input_email);
            this.h = (Button) findViewById(R.id.btn_enter);
            EditText editText = this.d;
            a aVar = null;
            editText.addTextChangedListener(new e(this, editText, aVar));
            EditText editText2 = this.e;
            editText2.addTextChangedListener(new e(this, editText2, aVar));
            this.h.setOnClickListener(new a());
            if (this.j.ia("PREF_ACCOUNT_NAME", "0").equals("0")) {
                Intent intent = new Intent(this, (Class<?>) Google_drive_list.class);
                intent.putExtra("change_email_flag", "1");
                startActivity(intent);
            }
            String strIa = this.j.ia("PREF_ACCOUNT_NAME", "0");
            Z00.T = strIa;
            if (!strIa.equals("0")) {
                this.e.setText(Z00.T);
            }
            if (this.d.getText().toString().length() == 0) {
                this.d.requestFocus();
            }
        } catch (Exception e2) {
            Log.d("login_err=", e2.getMessage() + "");
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            return false;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            String strIa = this.j.ia("PREF_ACCOUNT_NAME", "0");
            Z00.T = strIa;
            if (strIa.length() != 0) {
                this.e.setText(Z00.T);
            }
            if (this.d.getText().toString().length() == 0) {
                this.d.requestFocus();
            }
        } catch (Exception unused) {
        }
    }
}
