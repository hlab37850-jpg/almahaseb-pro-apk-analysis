package info.aalmoghalis.inventory.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.internal.view.SupportMenu;
import defpackage.AbstractC4158vt;
import defpackage.AbstractC4371yX;
import defpackage.C1839c10;
import defpackage.C2160f10;
import defpackage.C2325h2;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.util.Calendar;

/* JADX INFO: loaded from: classes3.dex */
public class LoginPwdActivity extends BaseActivity implements C2160f10.g {
    public SQLiteDatabase c;
    public Z00 d;
    public C2325h2 e;
    public Handler f = new c();
    public Dialog g = null;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LoginPwdActivity.this.x();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LoginPwdActivity.this.A();
        }
    }

    public class c extends Handler {
        public c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("mProgress=f=", message.obj + "");
            message.obj.toString().equals("20");
            LoginPwdActivity.this.B(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.e.h.setError(null);
        boolean zA = AbstractC4371yX.a(this.e.e);
        if (!AbstractC4371yX.a(this.e.h)) {
            zA = false;
        }
        if (zA) {
            this.e.h.getText().toString();
            this.e.e.getText().toString();
            if (!new C2160f10(this.d).k(Integer.parseInt(this.e.e.getText().toString()), this.e.h.getText().toString(), this)) {
                this.e.h.setError(getString(R.string.error_invalid_user_password));
                this.e.h.requestFocus();
                this.d.Lc("user_id", "-1");
            } else {
                Z00.V = "1";
                this.d.Lc("user_id", this.e.e.getText().toString());
                new C2160f10(this.d).a0();
                z();
            }
        }
    }

    private void z() {
        startActivity(new Intent(this, (Class<?>) FragmentStatePagerSupport_Main.class));
        finish();
    }

    public void A() {
        if (AbstractC4371yX.a(this.e.e)) {
            C2160f10 c2160f10 = new C2160f10(this.d, this, this);
            if (!c2160f10.j(Integer.parseInt(this.e.e.getText().toString()))) {
                this.e.c.setText(getString(R.string.user_not_found));
                return;
            }
            if (!AbstractC4158vt.a(this)) {
                Toast.makeText(this, getString(R.string.no_internet), 0).show();
                return;
            }
            this.d.Sb();
            Z00.T = this.d.ia("PREF_ACCOUNT_NAME", "0");
            if (!this.d.ia("PREF_ACCOUNT_NAME", "0").equals("0")) {
                B(true);
                c2160f10.o(this.e.e.getText().toString(), "0", this.f);
            } else {
                Intent intent = new Intent(this, (Class<?>) Google_drive_list.class);
                intent.putExtra("change_email_flag", "1");
                startActivity(intent);
            }
        }
    }

    public void B(boolean z) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.progress, (ViewGroup) null));
            if (z) {
                AlertDialog alertDialogCreate = builder.create();
                this.g = alertDialogCreate;
                alertDialogCreate.setCancelable(false);
                this.g.show();
            } else {
                Dialog dialog = this.g;
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // defpackage.C2160f10.g
    public void d(int i, int i2, String str) {
        if (i2 != 3 || this.d.ia("reset_user_id", "").equals("")) {
            this.e.c.setText(str);
            return;
        }
        new C2160f10(this.d).a0();
        new C2160f10(this.d, this).o(String.valueOf(i), "2", null);
        new C2160f10(this.d, this).g(i, this.e.h);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Process.killProcess(Process.myPid());
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C2325h2 c2325h2C = C2325h2.c(getLayoutInflater());
        this.e = c2325h2C;
        setContentView(c2325h2C.getRoot());
        try {
            this.e.i.setOnClickListener(new a());
            TextView textView = this.e.d;
            textView.setPaintFlags(textView.getPaintFlags() | 8);
            this.e.c.setTextColor(SupportMenu.CATEGORY_MASK);
            this.e.d.setOnClickListener(new b());
        } catch (Exception unused) {
        }
        this.d = new Z00(this.c, this);
        new C1839c10(this.d);
        if (C1839c10.o(this.d)) {
            Log.d("login=", ":reset_user_id=" + this.d.ia("reset_user_id", "") + ":user_id=" + this.d.ia("user_id", ""));
        }
        if (!this.d.ia("reset_user_id", "").equals("")) {
            this.e.e.setText(this.d.ia("reset_user_id", ""));
            y();
        } else if (!this.d.ia("user_id", "").equals("")) {
            this.e.e.setText(this.d.ia("user_id", ""));
            this.e.h.requestFocus();
        } else if (new C2160f10(this.d).u() == new C2160f10(this.d).v()) {
            this.e.e.setText("0");
            this.e.h.requestFocus();
        } else {
            this.e.e.requestFocus();
        }
        if (this.e.e.getText() == null || this.e.e.getText().toString().length() != 0) {
            return;
        }
        this.e.e.setText(this.d.X4("select max(id) as _id from users where is_active=1"));
        this.e.h.requestFocus();
    }

    public void y() {
        C2160f10 c2160f10 = new C2160f10(this.d, this, this);
        Log.d("check_confirm=", "c1");
        if (AbstractC4158vt.a(this)) {
            this.d.Sb();
            long timeInMillis = Calendar.getInstance().getTimeInMillis();
            long j = Long.parseLong(this.d.ia("reset_expire", "0"));
            Log.d("check_confirm=", "c2:" + timeInMillis + ":" + j);
            if (timeInMillis >= j) {
                c2160f10.a0();
                return;
            }
            int i = Integer.parseInt(this.d.ia("reset_check", "0"));
            long j2 = ((long) (60000 * i)) + timeInMillis;
            long j3 = Long.parseLong(this.d.ia("reset_next", "0"));
            Log.d("check_confirm=", "c3:" + j3 + ":" + j2 + ":" + i);
            if (j3 <= 0 || timeInMillis >= j3) {
                this.d.Lc("reset_next", j2 + "");
                B(true);
                c2160f10.o(this.e.e.getText().toString(), "0", this.f);
            }
        }
    }
}
