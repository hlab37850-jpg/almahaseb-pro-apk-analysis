package info.aalmoghalis.inventory.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC4371yX;
import defpackage.C0372Bn;
import defpackage.C0566Hd;
import defpackage.C0978Uv;
import defpackage.C2160f10;
import defpackage.C4145vh;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.helper.Excel_add;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Account_Tree_Det extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, info.aalmoghalis.inventory.activity.a.b {
    public C0978Uv B;
    public SparseBooleanArray D;
    public int R;
    public int S;
    public int T;
    public ArrayAdapter b0;
    public ArrayAdapter c0;
    public SQLiteDatabase h;
    public Z00 i;
    public String j;
    public String k;
    public int l;
    public int n = 0;
    public double p = 0.0d;
    public double q = 0.0d;
    public TextView t = null;
    public AutoCompleteTextView u = null;
    public TextView v = null;
    public SwitchCompat w = null;
    public int x = 0;
    public ImageView y = null;
    public ListView z = null;
    public Toolbar A = null;
    public List C = new ArrayList();
    public ImageButton E = null;
    public AppCompatCheckBox F = null;
    public int G = 0;
    public String[] H = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] I = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public TextView J = null;
    public ImageView K = null;
    public String L = "";
    public Dialog M = null;
    public Handler N = new c();
    public String O = "";
    public Cursor P = null;
    public boolean Q = false;
    public int U = 0;
    public String V = CSS.Value.PERCENTAGE;
    public String W = CSS.Value.PERCENTAGE;
    public TextView X = null;
    public TextView Y = null;
    public DatePickerDialog.OnDateSetListener Z = new p();
    public DatePickerDialog.OnDateSetListener a0 = new q();
    public SwitchCompat d0 = null;

    public class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public a(TextView textView, ImageView imageView) {
            this.a = textView;
            this.b = imageView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ImageView imageView;
            try {
                if (this.a == null || (imageView = this.b) == null) {
                    return;
                }
                String str = Integer.parseInt(imageView.getTag().toString()) == 17301515 ? "1" : "0";
                Account_Tree_Det.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Account_Tree_Det.this.l = 0;
                Account_Tree_Det.this.Q();
            } catch (Exception unused) {
                Toast.makeText(Account_Tree_Det.this.getApplicationContext(), Account_Tree_Det.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class c extends Handler {
        public c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                Account_Tree_Det.this.M();
            } else if (message.obj.toString().equals("1")) {
                Z00 z00 = Account_Tree_Det.this.i;
                StringBuilder sb = new StringBuilder();
                Account_Tree_Det account_Tree_Det = Account_Tree_Det.this;
                sb.append(account_Tree_Det.i.ic(account_Tree_Det.O));
                sb.append(".pdf");
                z00.ra(sb.toString());
            }
            Account_Tree_Det.this.Y(false);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Account_Tree_Det.this.P();
            Message message = new Message();
            message.obj = "0";
            Account_Tree_Det.this.N.sendMessage(message);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Message message = new Message();
            message.obj = "1";
            Account_Tree_Det.this.N.sendMessage(message);
        }
    }

    public class f extends WebViewClient {
        public f() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            webView.loadUrl("javascript:DisplayItem_details('2','8','7')");
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class h implements AdapterView.OnItemClickListener {
        public h() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            C4145vh c4145vh = (C4145vh) adapterView.getItemAtPosition(i);
            if (!c4145vh.r().equals("1")) {
                Toast.makeText(view.getContext(), Account_Tree_Det.this.getString(R.string.no_det_accounts), 0).show();
                return;
            }
            Intent intent = new Intent(view.getContext(), (Class<?>) Account_Tree_Det.class);
            intent.putExtra("parent_id", c4145vh.v() + "");
            intent.putExtra("p_name", c4145vh.a() + "");
            Account_Tree_Det.this.startActivity(intent);
            Log.d("lv_click=", c4145vh.v() + ":" + c4145vh.a());
        }
    }

    public class i implements AbsListView.MultiChoiceModeListener {

        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Account_Tree_Det.this.K();
                } catch (Exception unused) {
                    Toast.makeText(Account_Tree_Det.this.getApplicationContext(), "SQL Error.", 1).show();
                }
            }
        }

        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public i() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.menu_delete /* 2131297039 */:
                    SparseBooleanArray sparseBooleanArrayB = Account_Tree_Det.this.B.b();
                    Account_Tree_Det account_Tree_Det = Account_Tree_Det.this;
                    account_Tree_Det.D = sparseBooleanArrayB;
                    AlertDialog.Builder builder = new AlertDialog.Builder(account_Tree_Det);
                    builder.setMessage(Account_Tree_Det.this.getString(R.string.delete_msg));
                    builder.setPositiveButton(Account_Tree_Det.this.getString(R.string.confirm_yes), new a());
                    builder.setNegativeButton(Account_Tree_Det.this.getString(R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayB2 = Account_Tree_Det.this.B.b();
                    Account_Tree_Det account_Tree_Det2 = Account_Tree_Det.this;
                    account_Tree_Det2.D = sparseBooleanArrayB2;
                    account_Tree_Det2.L();
                    actionMode.finish();
                    break;
            }
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.contextual_action_bar3, menu);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            Log.d("Back_=", "BACK#2");
            Account_Tree_Det.this.z.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Account_Tree_Det.this.B.l.clear();
            Account_Tree_Det.this.B.e();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = Account_Tree_Det.this.z.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            Account_Tree_Det.this.B.g(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (Account_Tree_Det.this.z.getCheckedItemCount() != 1) {
                menu.findItem(R.id.menu_edit).setVisible(false);
            } else {
                menu.findItem(R.id.menu_delete).setVisible(true);
                menu.findItem(R.id.menu_edit).setVisible(true);
            }
            return false;
        }
    }

    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Account_Tree_Det.this.showDialog(0);
        }
    }

    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Account_Tree_Det.this.showDialog(4);
        }
    }

    public class l implements DialogInterface.OnClickListener {
        public l() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class m implements DialogInterface.OnClickListener {
        public m() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Account_Tree_Det.this.U = 0;
                dialogInterface.dismiss();
                Account_Tree_Det.this.Q();
            } catch (Exception unused) {
            }
        }
    }

    public class n implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public n(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Account_Tree_Det account_Tree_Det = Account_Tree_Det.this;
                account_Tree_Det.U = 1;
                if (account_Tree_Det.X.getText() == null) {
                    Account_Tree_Det.this.V = "";
                } else {
                    Account_Tree_Det account_Tree_Det2 = Account_Tree_Det.this;
                    account_Tree_Det2.V = account_Tree_Det2.X.getText().toString();
                }
                if (Account_Tree_Det.this.Y.getText() == null) {
                    Account_Tree_Det.this.W = "";
                } else {
                    Account_Tree_Det account_Tree_Det3 = Account_Tree_Det.this;
                    account_Tree_Det3.W = account_Tree_Det3.Y.getText().toString();
                }
                this.a.dismiss();
                Account_Tree_Det.this.Q();
            } catch (Exception unused) {
            }
        }
    }

    public class o implements SearchView.OnQueryTextListener {
        public o() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            if (TextUtils.isEmpty(str)) {
                Account_Tree_Det.this.N(1);
            }
            Account_Tree_Det.this.U(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            Account_Tree_Det.this.N(0);
            return false;
        }
    }

    public class p implements DatePickerDialog.OnDateSetListener {
        public p() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Account_Tree_Det.this.R = i;
            Account_Tree_Det.this.S = i2;
            Account_Tree_Det.this.T = i3;
            try {
                String str = Account_Tree_Det.this.R + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Account_Tree_Det.this.S + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Account_Tree_Det.this.T));
                Locale locale = Locale.ENGLISH;
                Account_Tree_Det.this.X.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class q implements DatePickerDialog.OnDateSetListener {
        public q() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Account_Tree_Det.this.R = i;
            Account_Tree_Det.this.S = i2;
            Account_Tree_Det.this.T = i3;
            try {
                String str = Account_Tree_Det.this.R + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Account_Tree_Det.this.S + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Account_Tree_Det.this.T));
                Locale locale = Locale.ENGLISH;
                Account_Tree_Det.this.Y.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class r implements CompoundButton.OnCheckedChangeListener {
        public r() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                Account_Tree_Det account_Tree_Det = Account_Tree_Det.this;
                account_Tree_Det.d0.setText(account_Tree_Det.i.y1("0"));
            } else {
                Account_Tree_Det account_Tree_Det2 = Account_Tree_Det.this;
                account_Tree_Det2.d0.setText(account_Tree_Det2.i.y1("1"));
            }
        }
    }

    public class s implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public s(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Account_Tree_Det account_Tree_Det = Account_Tree_Det.this;
            account_Tree_Det.i.Md(account_Tree_Det);
            Account_Tree_Det account_Tree_Det2 = Account_Tree_Det.this;
            account_Tree_Det2.i.T(account_Tree_Det2, account_Tree_Det2.b0, this.a);
        }
    }

    public class t implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public t(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.a.dismissDropDown();
        }
    }

    public class u implements DialogInterface.OnClickListener {
        public u() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class v implements DialogInterface.OnClickListener {
        public v() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class w implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ String c;
        public final /* synthetic */ AlertDialog d;

        public w(EditText editText, AutoCompleteTextView autoCompleteTextView, String str, AlertDialog alertDialog) {
            this.a = editText;
            this.b = autoCompleteTextView;
            this.c = str;
            this.d = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (Account_Tree_Det.this.i.p1(this.b.getText().toString()).getCount() == 0) {
                this.b.setError(Account_Tree_Det.this.getString(R.string.not_exists));
                zA = false;
            }
            if (zA) {
                Account_Tree_Det account_Tree_Det = Account_Tree_Det.this;
                int iW1 = account_Tree_Det.i.w1(account_Tree_Det.d0.getText().toString());
                if (this.c.equals("0")) {
                    if (iW1 == 0 && Account_Tree_Det.this.i.Q4(this.a.getText().toString().trim()).getCount() > 0) {
                        Account_Tree_Det account_Tree_Det2 = Account_Tree_Det.this;
                        account_Tree_Det2.i.Pd(account_Tree_Det2, account_Tree_Det2.z, this.a.getText().toString().trim() + " : " + Account_Tree_Det.this.getString(R.string.exist), 5000, 2);
                        FragmentStatePagerSupport_Main.Z(Account_Tree_Det.this);
                        this.d.dismiss();
                        return;
                    }
                    if (iW1 == 1 && Account_Tree_Det.this.i.p1(this.a.getText().toString().trim()).getCount() > 0) {
                        Account_Tree_Det account_Tree_Det3 = Account_Tree_Det.this;
                        account_Tree_Det3.i.Pd(account_Tree_Det3, account_Tree_Det3.z, this.a.getText().toString().trim() + " : " + Account_Tree_Det.this.getString(R.string.exist), 5000, 2);
                        FragmentStatePagerSupport_Main.Z(Account_Tree_Det.this);
                        this.d.dismiss();
                        return;
                    }
                    if (iW1 == 0) {
                        Account_Tree_Det.this.i.v0("insert into customers (name,gsm,address,g_id,cus_type_id,acc_p_id) values('" + this.a.getText().toString().trim() + "','','','0','6',(select b.id from account_tree b where b.name='" + this.b.getText().toString() + "') ) ");
                        Account_Tree_Det.this.Q();
                        Account_Tree_Det.this.O();
                    } else {
                        Z00 z00 = Account_Tree_Det.this.i;
                        StringBuilder sb = new StringBuilder();
                        sb.append("insert into account_tree (id,name,parent_id,p) values('");
                        sb.append(Account_Tree_Det.this.j);
                        Account_Tree_Det account_Tree_Det4 = Account_Tree_Det.this;
                        sb.append(account_Tree_Det4.i.n1(account_Tree_Det4.j) + 1);
                        sb.append("','");
                        sb.append(this.a.getText().toString().trim());
                        sb.append("','");
                        sb.append(Account_Tree_Det.this.j);
                        sb.append("',1)");
                        z00.v0(sb.toString());
                        Account_Tree_Det.this.Q();
                        Account_Tree_Det.this.O();
                    }
                } else if (this.c != null) {
                    if (iW1 == 0) {
                        if (Account_Tree_Det.this.i.ia("PREF_ACCOUNT_NAME", "###").equals("mmoghlis@gmail.com")) {
                            Account_Tree_Det.this.i.v0("update customers set name='" + this.a.getText().toString().trim() + "',online=0,acc_p_id=(select id from account_tree where name='" + this.b.getText().toString() + "') where id='" + this.c + "' ");
                        } else {
                            Account_Tree_Det.this.i.v0("update customers set name='" + this.a.getText().toString().trim() + "',online=0,acc_p_id=(select id from account_tree where name='" + this.b.getText().toString() + "') where id='" + this.c + "' and id>0 ");
                        }
                        Account_Tree_Det.this.Q();
                        Account_Tree_Det.this.O();
                    } else {
                        if (Account_Tree_Det.this.i.ia("PREF_ACCOUNT_NAME", "###").equals("mmoghlis@gmail.com")) {
                            Account_Tree_Det.this.i.v0("update account_tree set name='" + this.a.getText().toString().trim() + "' where id='" + this.c + "' ");
                        } else {
                            Account_Tree_Det.this.i.v0("update account_tree set name='" + this.a.getText().toString().trim() + "' where id='" + this.c + "' and admin<>1 ");
                        }
                        Account_Tree_Det.this.Q();
                        Account_Tree_Det.this.O();
                    }
                }
                this.d.dismiss();
                Account_Tree_Det account_Tree_Det5 = Account_Tree_Det.this;
                account_Tree_Det5.i.Md(account_Tree_Det5);
            }
        }
    }

    public void I() {
        try {
            this.U = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.X = (TextView) viewInflate.findViewById(R.id.f_date);
            this.Y = (TextView) viewInflate.findViewById(R.id.t_date);
            this.X.setOnClickListener(new j());
            this.Y.setOnClickListener(new k());
            builder.setPositiveButton(getString(R.string.btn_search), new l());
            builder.setNegativeButton(getString(R.string.btn_cancel), new m());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new n(alertDialogCreate));
        } catch (Exception e2) {
            Log.d("adv_search_error=", e2.getMessage());
        }
    }

    public void J() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void K() {
        if (C2160f10.h > 0 && !new C2160f10(this.i).l("13", HTML.Tag.DEL)) {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
            return;
        }
        for (int size = this.D.size() - 1; size >= 0; size--) {
            if (this.D.valueAt(size)) {
                C4145vh item = this.B.getItem(this.D.keyAt(size));
                if (item.r().equals("1") && item.p().equals("0")) {
                    if (this.i.ia("PREF_ACCOUNT_NAME", "###").equals("mmoghlis@gmail.com")) {
                        this.i.v0("delete from account_tree where id='" + item.v() + "' ");
                    } else {
                        this.i.v0("delete from account_tree where id='" + item.v() + "' and admin<>1");
                    }
                    this.B.remove(item);
                    Bill_edit.P2 = true;
                } else if (item.r().equals("0") && item.p().equals("0") && this.i.L3(item.s()).getCount() == 0) {
                    if (this.i.ia("PREF_ACCOUNT_NAME", "###").equals("mmoghlis@gmail.com")) {
                        this.i.v0("delete from customers where id='" + item.s() + "' and id not in (select cus_id from bills)  and id not in (select cus_id from transactions)  and id not in (select t_cus_id from transactions where t_cus_id is not null) ");
                    } else {
                        String strY0 = this.i.y0("delete from customers where id='" + item.s() + "' and id>0 and id not in (select cus_id from bills) and id not in (select cus_id from transactions)  and id not in (select t_cus_id from transactions where t_cus_id is not null)  ");
                        if (strY0 == null || !strY0.equals("1")) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Error:");
                            if (strY0 != null && strY0.length() > 20) {
                                strY0 = strY0.substring(0, 20);
                            }
                            sb.append(strY0);
                            Toast.makeText(this, sb.toString(), 0).show();
                            return;
                        }
                    }
                    this.B.remove(item);
                    Bill_edit.P2 = true;
                } else {
                    Toast.makeText(this, getString(R.string.no_delete), 0).show();
                }
            }
        }
        Q();
        O();
    }

    public void L() {
        if (C2160f10.h > 0 && !new C2160f10(this.i).l("13", "edit")) {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
            return;
        }
        int size = this.D.size() - 1;
        if (this.D.valueAt(size)) {
            C4145vh item = this.B.getItem(this.D.keyAt(size));
            if (!item.r().equals("0")) {
                Z(item.v(), item.a(), item.n(), item.o());
                return;
            }
            Log.d("cus_type_name=", this.i.O4(item.s()) + ":" + item.s());
            Z(item.s(), item.a(), item.n(), item.o());
        }
    }

    public void M() {
        T();
        C0978Uv c0978Uv = new C0978Uv(this, R.layout.data_det_row_rep4_, this.C, 4, S(), 1);
        this.B = c0978Uv;
        c0978Uv.l.clear();
        this.B.notifyDataSetChanged();
        this.z.setAdapter((ListAdapter) this.B);
    }

    public void N(int i2) {
    }

    public void O() {
        Log.d("trace_S_List_Acct_d=", FragmentStatePagerSupport_Main.X());
        Cursor cursorQ1 = this.i.q1();
        Z00.i0.clear();
        new C0566Hd();
        cursorQ1.moveToFirst();
        while (!cursorQ1.isAfterLast()) {
            Z00.i0.add(new C4145vh(cursorQ1.getString(cursorQ1.getColumnIndex("_id")), cursorQ1.getString(cursorQ1.getColumnIndex("name")), cursorQ1.getString(cursorQ1.getColumnIndex("p_name")), cursorQ1.getString(cursorQ1.getColumnIndex("t_name")), cursorQ1.getString(cursorQ1.getColumnIndex("cnt")), cursorQ1.getString(cursorQ1.getColumnIndex("parent_id")), cursorQ1.getString(cursorQ1.getColumnIndex("p")), cursorQ1.getString(cursorQ1.getColumnIndex("cus_id")), ""));
            cursorQ1.moveToNext();
        }
        cursorQ1.close();
        Log.d("trace_E_List_Acct_d=", FragmentStatePagerSupport_Main.X() + ":" + Z00.i0.size());
    }

    public void P() {
        Cursor cursorO1 = this.i.o1(this.j);
        Log.d("Cursor_cnt=", String.valueOf(cursorO1.getCount()));
        this.p = 0.0d;
        this.q = 0.0d;
        this.C.clear();
        cursorO1.moveToFirst();
        while (!cursorO1.isAfterLast()) {
            this.C.add(new C4145vh(cursorO1.getString(cursorO1.getColumnIndex("_id")), cursorO1.getString(cursorO1.getColumnIndex("name")), cursorO1.getString(cursorO1.getColumnIndex("p_name")), cursorO1.getString(cursorO1.getColumnIndex("t_name")), cursorO1.getString(cursorO1.getColumnIndex("cnt")), cursorO1.getString(cursorO1.getColumnIndex("parent_id")), cursorO1.getString(cursorO1.getColumnIndex("p")), cursorO1.getString(cursorO1.getColumnIndex("cus_id")), ""));
            cursorO1.moveToNext();
        }
        cursorO1.close();
    }

    public void Q() {
        Y(true);
        new Thread(new d()).start();
    }

    public void R(String str, String str2) {
        Log.d("edit_inputs=", str + ":" + str2);
        Intent intent = new Intent(this, (Class<?>) Bill_edit.class);
        intent.putExtra("TR_ID", str);
        intent.putExtra("TR_TYPE", String.valueOf(this.x));
        intent.putExtra("tran_status", String.valueOf(str2));
        intent.putExtra("g_id", this.j);
        intent.putExtra("g_name", this.k);
        startActivity(intent);
        finish();
    }

    public boolean S() {
        return false;
    }

    public void T() {
        TextView textView = (TextView) findViewById(R.id.f1);
        TextView textView2 = (TextView) findViewById(R.id.f2);
        TextView textView3 = (TextView) findViewById(R.id.f3);
        TextView textView4 = (TextView) findViewById(R.id.f4);
        textView.setText(getString(R.string.account_name));
        textView2.setText(getString(R.string.parent_account));
        textView3.setText(getString(R.string.account_type));
        textView4.setText(getString(R.string.cnt));
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, textView);
        c0372Bn.a(this, textView2);
        c0372Bn.a(this, textView3);
        c0372Bn.a(this, textView4);
    }

    public void U(String str) {
        this.B.getFilter().filter(str);
    }

    public void V() {
        Y(true);
        new Thread(new e()).start();
    }

    public void W(boolean z) {
    }

    public void X() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new f());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new g());
        builder.show();
    }

    public void Y(boolean z) {
        Log.d("mProgress=", "....start..." + z);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setView(getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null));
        if (z) {
            android.app.AlertDialog alertDialogCreate = builder.create();
            this.M = alertDialogCreate;
            alertDialogCreate.show();
        } else {
            Dialog dialog = this.M;
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    public void Z(String str, String str2, String str3, String str4) {
        try {
            Bill_edit.P2 = true;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_customer5, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(R.id.account_name);
            this.d0 = (SwitchCompat) viewInflate.findViewById(R.id.account_type);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.account_parent);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_cus_type);
            this.i.ad(this, editText);
            this.i.cd(this, autoCompleteTextView);
            editText.setText(str2);
            this.d0.setText(str4);
            autoCompleteTextView.setText(str3);
            if (this.i.w1(str4) == 1) {
                this.d0.setChecked(false);
            } else {
                this.d0.setChecked(true);
            }
            this.d0.setOnCheckedChangeListener(new r());
            this.c0 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.x1());
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.s1());
            this.b0 = arrayAdapter;
            autoCompleteTextView.setAdapter(arrayAdapter);
            imageView.setOnClickListener(new s(autoCompleteTextView));
            autoCompleteTextView.setOnItemClickListener(new t(autoCompleteTextView));
            if (!str.equals("0")) {
                this.d0.setEnabled(false);
                if (this.i.w1(str4) == 1) {
                    autoCompleteTextView.setVisibility(4);
                }
            }
            editText.requestFocus();
            builder.setPositiveButton(getString(R.string.resourceID_OK), new u());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new v());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new w(editText, autoCompleteTextView, str, alertDialogCreate));
        } catch (Exception e2) {
            Log.d("edit_cus_error=", e2.getMessage());
            e2.printStackTrace();
        }
    }

    public void amount_add_btn(View view) {
        btn_add(view);
    }

    public void btn_add(View view) {
        if (C2160f10.h <= 0 || new C2160f10(this.i).l("13", "new")) {
            Z("0", "", this.k, this.i.y1("0"));
        } else {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
        }
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        info.aalmoghalis.inventory.activity.a aVarA = info.aalmoghalis.inventory.activity.a.a(textView.getText().toString());
        this.L = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_more(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        R(((TextView) linearLayout.findViewById(R.id.id)).getText().toString(), ((TextView) linearLayout.findViewById(R.id.f8)).getText().toString());
    }

    public void btn_update_status(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.page_enable);
        TextView textView = (TextView) linearLayout.findViewById(R.id.page_name);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        if (Integer.parseInt(imageView.getTag().toString()) == 17301515) {
            builder.setMessage(getString(R.string.enable) + "#" + ((Object) textView.getText()) + "?");
        } else {
            builder.setMessage(getString(R.string.disable) + "#" + ((Object) textView.getText()) + "?");
        }
        builder.setPositiveButton(getString(R.string.confirm_yes), new a(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new b());
        builder.create().show();
    }

    public void help_btn(View view) {
        X();
    }

    public void import_excel(View view) {
        if (C2160f10.h > 0 && !new C2160f10(this.i).l("13", "new")) {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
            return;
        }
        Intent intent = new Intent(this, (Class<?>) Excel_add.class);
        intent.putExtra("loader_id", "2");
        intent.putExtra("acc_id", this.j);
        startActivity(intent);
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.L.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.L + "'");
            }
            this.L = "";
            Q();
        } catch (Exception e2) {
            Log.d("cat_update_error=", e2.getMessage());
        }
    }

    public void no_result_btn(View view) {
        this.U = 0;
        Q();
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.data_listview_bill5_2);
        this.z = (ListView) findViewById(R.id.list_items);
        TextView textView = (TextView) findViewById(R.id.emptyResults);
        textView.setText(getString(R.string.empty_results2));
        this.z.setEmptyView(textView);
        this.i = new Z00(this.h, this);
        this.z.setOnItemClickListener(new h());
        this.K = (ImageView) findViewById(R.id.img_add_amount);
        try {
            T();
            if (getIntent().getStringExtra("p_name") != null) {
                this.j = getIntent().getStringExtra("parent_id");
                this.k = getIntent().getStringExtra("p_name");
                setTitle(getIntent().getStringExtra("p_name"));
            }
        } catch (Exception unused) {
        }
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.R = calendar.get(1);
        this.S = calendar.get(2);
        this.T = calendar.get(5);
        W(true);
        this.z.setChoiceMode(3);
        this.z.setMultiChoiceModeListener(new i());
        Q();
        O();
        getWindow().setSoftInputMode(2);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.Z, this.R, this.S, this.T);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.a0, this.R, this.S, this.T);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new o());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        W(true);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        onBackPressed();
        return true;
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        if (menuItem.getItemId() == R.id.adv_search) {
            I();
            return true;
        }
        if (menuItem.getItemId() != R.id.print) {
            return super.onOptionsItemSelected(menuItem);
        }
        J();
        this.O = getTitle().toString();
        V();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (Bill_edit.P2) {
            Bill_edit.P2 = false;
            recreate();
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
