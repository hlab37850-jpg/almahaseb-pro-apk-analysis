package info.aalmoghalis.inventory.helper;

import android.app.AlertDialog;
import android.app.Dialog;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import defpackage.C0372Bn;
import defpackage.C3439n10;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.BaseActivity;

/* JADX INFO: loaded from: classes3.dex */
public class Auto_sms_add extends BaseActivity {
    public Button c;
    public Button d;
    public EditText e;
    public LinearLayout f;
    public SQLiteDatabase g;
    public Z00 h;
    public Dialog i = null;
    public Handler j = new c();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Auto_sms_add auto_sms_add = Auto_sms_add.this;
            auto_sms_add.h.Lc("auto_sms_text", auto_sms_add.getString(R.string.auto_sms_text).replace("{0}", Auto_sms_add.this.getString(R.string.total_prt)));
            C3439n10 c3439n10 = new C3439n10();
            Auto_sms_add auto_sms_add2 = Auto_sms_add.this;
            c3439n10.e(auto_sms_add2, auto_sms_add2.h, auto_sms_add2.e);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String[] stringArray = Auto_sms_add.this.getResources().getStringArray(R.array.auto_sms_plugin);
            C3439n10 c3439n10 = new C3439n10();
            Auto_sms_add auto_sms_add = Auto_sms_add.this;
            if (c3439n10.a(auto_sms_add, auto_sms_add.e, auto_sms_add.getResources().getStringArray(R.array.auto_sms_plugin), new String[]{stringArray[3], stringArray[4]}, stringArray, new String[0])) {
                Auto_sms_add auto_sms_add2 = Auto_sms_add.this;
                auto_sms_add2.h.Lc("auto_sms_text", auto_sms_add2.e.getText().toString());
                C3439n10 c3439n11 = new C3439n10();
                Auto_sms_add auto_sms_add3 = Auto_sms_add.this;
                c3439n11.e(auto_sms_add3, auto_sms_add3.h, auto_sms_add3.e);
                Auto_sms_add.this.finish();
            }
        }
    }

    public class c extends Handler {
        public c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            Auto_sms_add.this.w(false);
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_approval);
        this.h = new Z00(this.g, this);
        this.e = (EditText) findViewById(R.id.template_view);
        this.f = (LinearLayout) findViewById(R.id.button_ll);
        new C3439n10().e(this, this.h, this.e);
        new C3439n10().d(this, this.h, this.f, this.e, getResources().getStringArray(R.array.auto_sms_plugin));
        this.c = (Button) findViewById(R.id.clear);
        this.d = (Button) findViewById(R.id.save);
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, this.c);
        c0372Bn.a(this, this.d);
        this.c.setOnClickListener(new a());
        this.d.setOnClickListener(new b());
        setTitle(R.string.change_auto_sms);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public void w(boolean z) {
        Log.d("mProgress=", "....start..." + z);
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null));
            if (z) {
                AlertDialog alertDialogCreate = builder.create();
                this.i = alertDialogCreate;
                alertDialogCreate.show();
            } else {
                Dialog dialog = this.i;
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        } catch (Exception unused) {
        }
    }
}
