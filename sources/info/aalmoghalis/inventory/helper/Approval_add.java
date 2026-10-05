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
import android.widget.Toast;
import com.itextpdf.text.pdf.PdfObject;
import com.zebra.sdk.util.internal.StringUtilities;
import defpackage.C0372Bn;
import defpackage.C3439n10;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.BaseActivity;

/* JADX INFO: loaded from: classes3.dex */
public class Approval_add extends BaseActivity {
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
            Approval_add approval_add = Approval_add.this;
            approval_add.h.Lc("approval_text", approval_add.getString(R.string.approval_text));
            C3439n10 c3439n10 = new C3439n10();
            Approval_add approval_add2 = Approval_add.this;
            c3439n10.e(approval_add2, approval_add2.h, approval_add2.e);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String[] stringArray = Approval_add.this.getResources().getStringArray(R.array.approval_plugin);
            String str = stringArray[2];
            String str2 = stringArray[4];
            String[] strArr = {str, str2};
            String str3 = stringArray[1];
            String str4 = stringArray[6];
            String[] strArr2 = {str3, str2, str4};
            String[] strArr3 = {str4, stringArray[8]};
            C3439n10 c3439n10 = new C3439n10();
            Approval_add approval_add = Approval_add.this;
            if (c3439n10.a(approval_add, approval_add.e, approval_add.getResources().getStringArray(R.array.approval_plugin), strArr, strArr2, strArr3)) {
                EditText editText = Approval_add.this.e;
                editText.setText(editText.getText().toString().replace(StringUtilities.LF, ""));
                Approval_add approval_add2 = Approval_add.this;
                approval_add2.h.Lc("approval_text", approval_add2.e.getText().toString());
                C3439n10 c3439n11 = new C3439n10();
                Approval_add approval_add3 = Approval_add.this;
                c3439n11.e(approval_add3, approval_add3.h, approval_add3.e);
                Approval_add.this.finish();
            }
        }
    }

    public class c extends Handler {
        public c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            Approval_add.this.w(false);
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
        new C3439n10().d(this, this.h, this.f, this.e, getResources().getStringArray(R.array.approval_plugin));
        this.c = (Button) findViewById(R.id.clear);
        this.d = (Button) findViewById(R.id.save);
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, this.c);
        c0372Bn.a(this, this.d);
        this.c.setOnClickListener(new a());
        this.d.setOnClickListener(new b());
        setTitle(R.string.change_approval);
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

    public void x(View view) {
        Z00 z00 = this.h;
        z00.Mc("approval_wa", !z00.ja("approval_wa", true));
        ((Button) view).setText(this.h.ja("approval_wa", true) ? "واتساب" : PdfObject.TEXT_PDFDOCENCODING);
        Toast.makeText(this, this.h.ja("approval_wa", true) ? getString(R.string.approval_wa) : getString(R.string.approval_file), 0).show();
    }
}
