package info.aalmoghalis.inventory.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
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
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.C0372Bn;
import defpackage.C0922Sv;
import defpackage.C2160f10;
import defpackage.C4145vh;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Moves2 extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, info.aalmoghalis.inventory.activity.a.b {
    public static int V;
    public ArrayAdapter A;
    public int G;
    public int H;
    public int I;
    public ProgressDialog P;
    public SQLiteDatabase h;
    public Z00 i;
    public String j;
    public String k;
    public int l;
    public C0922Sv x;
    public SparseBooleanArray z;
    public double n = 0.0d;
    public TextView p = null;
    public AutoCompleteTextView q = null;
    public int t = 0;
    public ImageView u = null;
    public ListView v = null;
    public Toolbar w = null;
    public List y = new ArrayList();
    public ImageButton B = null;
    public int C = 0;
    public String[] D = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] E = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public TextView F = null;
    public int J = 0;
    public String K = CSS.Value.PERCENTAGE;
    public String L = CSS.Value.PERCENTAGE;
    public TextView M = null;
    public TextView N = null;
    public String O = "";
    public Handler Q = new g();
    public String R = "";
    public Cursor S = null;
    public DatePickerDialog.OnDateSetListener T = new k();
    public DatePickerDialog.OnDateSetListener U = new l();

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
                Moves2.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Moves2.this.l = 0;
                Moves2.this.P();
            } catch (Exception unused) {
                Toast.makeText(Moves2.this.getApplicationContext(), Moves2.this.getString(R.string.sql_error), 1);
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

    public class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;

        public c(TextView textView) {
            this.a = textView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (this.a != null) {
                    Moves2.this.l = 0;
                    Moves2.this.P();
                }
            } catch (Exception unused) {
                Toast.makeText(Moves2.this.getApplicationContext(), Moves2.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class e implements AdapterView.OnItemClickListener {
        public e() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            TextView textView = (TextView) view.findViewById(R.id.id);
            C4145vh c4145vh = (C4145vh) adapterView.getItemAtPosition(i);
            Moves2.V = Moves2.this.v.getFirstVisiblePosition();
            Moves2.this.R(textView.getText().toString(), c4145vh.n(), c4145vh.u());
        }
    }

    public class f implements AbsListView.MultiChoiceModeListener {

        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Moves2.this.K();
                } catch (Exception unused) {
                    Toast.makeText(Moves2.this.getApplicationContext(), "SQL Error.", 1);
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

        public f() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.menu_delete /* 2131297039 */:
                    Moves2.this.z = Moves2.this.x.c();
                    AlertDialog.Builder builder = new AlertDialog.Builder(Moves2.this);
                    builder.setMessage(Moves2.this.getString(R.string.delete_msg));
                    builder.setPositiveButton(Moves2.this.getString(R.string.confirm_yes), new a());
                    builder.setNegativeButton(Moves2.this.getString(R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayC = Moves2.this.x.c();
                    Moves2 moves2 = Moves2.this;
                    moves2.z = sparseBooleanArrayC;
                    moves2.L();
                    actionMode.finish();
                    break;
            }
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.contextual_action_bar, menu);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            Log.d("Back_=", "BACK#2");
            Moves2.this.v.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Moves2.this.x.l.clear();
            Moves2.this.x.h();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = Moves2.this.v.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            Moves2.this.x.l(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (Moves2.this.v.getCheckedItemCount() != 1) {
                menu.findItem(R.id.menu_edit).setVisible(false);
            } else {
                menu.findItem(R.id.menu_delete).setVisible(true);
                menu.findItem(R.id.menu_edit).setVisible(true);
            }
            return false;
        }
    }

    public class g extends Handler {
        public g() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                Moves2 moves2 = Moves2.this;
                moves2.M(moves2.S);
            } else if (message.obj.toString().equals("1")) {
                Z00 z00 = Moves2.this.i;
                StringBuilder sb = new StringBuilder();
                Moves2 moves3 = Moves2.this;
                sb.append(moves3.i.ic(moves3.R));
                sb.append(".pdf");
                z00.ra(sb.toString());
            }
            Moves2.this.W(false);
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Moves2.this.O();
            Message message = new Message();
            message.obj = "0";
            Moves2.this.Q.sendMessage(message);
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Moves2 moves2 = Moves2.this;
            Z00 z00 = moves2.i;
            ListView listView = moves2.v;
            String strIc = z00.ic(moves2.R);
            Moves2 moves3 = Moves2.this;
            z00.Eb(listView, strIc, moves3.K, moves3.L, moves3.t);
            Message message = new Message();
            message.obj = "1";
            Moves2.this.Q.sendMessage(message);
        }
    }

    public class j implements SearchView.OnQueryTextListener {
        public j() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            if (TextUtils.isEmpty(str)) {
                Moves2.this.N(1);
            }
            Moves2.this.T(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            Moves2.this.N(0);
            return false;
        }
    }

    public class k implements DatePickerDialog.OnDateSetListener {
        public k() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Moves2.this.G = i;
            Moves2.this.H = i2;
            Moves2.this.I = i3;
            try {
                String str = Moves2.this.G + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Moves2.this.H + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Moves2.this.I));
                Locale locale = Locale.ENGLISH;
                Moves2.this.M.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class l implements DatePickerDialog.OnDateSetListener {
        public l() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Moves2.this.G = i;
            Moves2.this.H = i2;
            Moves2.this.I = i3;
            try {
                String str = Moves2.this.G + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Moves2.this.H + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Moves2.this.I));
                Locale locale = Locale.ENGLISH;
                Moves2.this.N.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Moves2.this.showDialog(0);
        }
    }

    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Moves2.this.showDialog(4);
        }
    }

    public class o implements DialogInterface.OnClickListener {
        public o() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class p implements DialogInterface.OnClickListener {
        public p() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Moves2 moves2 = Moves2.this;
                moves2.J = 0;
                moves2.P();
            } catch (Exception unused) {
            }
        }
    }

    public class q implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public q(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Moves2 moves2 = Moves2.this;
                moves2.J = 1;
                if (moves2.M.getText() == null) {
                    Moves2.this.K = "";
                } else {
                    Moves2 moves3 = Moves2.this;
                    moves3.K = moves3.M.getText().toString();
                }
                if (Moves2.this.N.getText() == null) {
                    Moves2.this.L = "";
                } else {
                    Moves2 moves4 = Moves2.this;
                    moves4.L = moves4.N.getText().toString();
                }
                Moves2.this.P();
            } catch (Exception unused) {
            }
            this.a.dismiss();
        }
    }

    private void X() {
        P();
    }

    public void H() {
        try {
            this.J = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.M = (TextView) viewInflate.findViewById(R.id.f_date);
            this.N = (TextView) viewInflate.findViewById(R.id.t_date);
            this.M.setOnClickListener(new m());
            this.N.setOnClickListener(new n());
            builder.setPositiveButton(getString(R.string.btn_search), new o());
            builder.setNegativeButton(getString(R.string.btn_cancel), new p());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new q(alertDialogCreate));
        } catch (Exception e2) {
            Log.d("adv_search_error=", e2.getMessage());
        }
    }

    public void I() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void J() {
        try {
            Log.d("lv_pos=", V + "");
            if (V <= 0) {
                V = 0;
                return;
            }
            if (this.v.getFirstVisiblePosition() > V || this.v.getLastVisiblePosition() < V) {
                this.v.setSelection(V);
            }
            V = 0;
        } catch (Exception e2) {
            V = 0;
            e2.printStackTrace();
        }
    }

    public void K() {
        if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.t == 3 ? "6" : "7", HTML.Tag.DEL)) {
                Toast.makeText(this, getString(R.string.no_priv), 0).show();
                return;
            }
        }
        for (int size = this.z.size() - 1; size >= 0; size--) {
            if (this.z.valueAt(size)) {
                C4145vh item = this.x.getItem(this.z.keyAt(size));
                this.x.remove(item);
                this.i.H("delete from bill_transactions where bill_id='" + item.v() + "' and exists(select * from bills a where a.id=bill_transactions.bill_id and a.date_='" + item.n() + "' and tr_type=" + this.t + ")", "delete from bills where id ='" + item.v() + "' and date_='" + item.n() + "'");
            }
        }
        P();
        V(true);
    }

    public void L() {
        if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.t == 3 ? "6" : "7", "edit")) {
                Toast.makeText(this, getString(R.string.no_priv), 0).show();
                return;
            }
        }
        int size = this.z.size() - 1;
        if (this.z.valueAt(size)) {
            C4145vh item = this.x.getItem(this.z.keyAt(size));
            R(item.v(), item.n(), item.t());
        }
    }

    public void M(Cursor cursor) {
        Log.d("Cursor_cnt=", String.valueOf(cursor.getCount()));
        this.n = 0.0d;
        this.y.clear();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            this.n += cursor.getDouble(cursor.getColumnIndex("f3"));
            this.y.add(new C4145vh(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("f9")), cursor.getString(cursor.getColumnIndex("f1")), cursor.getString(cursor.getColumnIndex("f6")), cursor.getString(cursor.getColumnIndex("f7")), this.i.P7("" + cursor.getDouble(cursor.getColumnIndex("f2"))), cursor.getString(cursor.getColumnIndex("f4")), cursor.getString(cursor.getColumnIndex("f6")), cursor.getString(cursor.getColumnIndex("f7")), cursor.getString(cursor.getColumnIndex("f8")), ""));
            if (cursor.getColumnIndex("user_name") > 0) {
                List list = this.y;
                ((C4145vh) list.get(list.size() - 1)).i = cursor.getString(cursor.getColumnIndex("user_name"));
            }
            cursor.moveToNext();
        }
        cursor.close();
        C0922Sv c0922Sv = this.x;
        if (c0922Sv == null) {
            C0922Sv c0922Sv2 = new C0922Sv(this, R.layout.data_det_row_rep5_, this.y, 4);
            this.x = c0922Sv2;
            c0922Sv2.l.clear();
            this.x.notifyDataSetChanged();
            this.v.setAdapter((ListAdapter) this.x);
        } else {
            c0922Sv.notifyDataSetChanged();
        }
        this.F.setText(this.i.P7(String.valueOf(this.n)));
        J();
    }

    public void N(int i2) {
        try {
            if (i2 == 1) {
                this.F.setText(this.i.P7(String.valueOf(this.n)));
            } else {
                this.F.setText(this.i.P7(String.valueOf(Q(this.x.e))));
            }
        } catch (Exception unused) {
        }
    }

    public void O() {
        if (this.J == 0) {
            this.S = this.i.G7(this.t, 1, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE);
            return;
        }
        this.K = this.K.isEmpty() ? CSS.Value.PERCENTAGE : this.K;
        String str = this.L.isEmpty() ? CSS.Value.PERCENTAGE : this.L;
        this.L = str;
        this.S = this.i.G7(this.t, 0, this.K, str, CSS.Value.PERCENTAGE);
    }

    public void P() {
        new Thread(new h()).start();
    }

    public double Q(List list) {
        Log.d("net_bal:", list.size() + "");
        double d2 = 0.0d;
        for (int i2 = 0; i2 < list.size(); i2++) {
            d2 += Double.parseDouble(((C4145vh) list.get(i2)).q().replaceAll(",", ""));
        }
        return d2;
    }

    public void R(String str, String str2, String str3) {
        Log.d("edit_inputs=", str + ":" + str2 + ":" + this.j + ":" + this.k + ":" + this.t);
        Intent intent = new Intent(this, (Class<?>) (this.t == 3 ? Bill_move.class : Bill_adj.class));
        intent.putExtra("TR_ID", str);
        intent.putExtra("TR_TYPE", String.valueOf(this.t));
        intent.putExtra("TR_DATE", str2);
        intent.putExtra("tran_status", String.valueOf(str3));
        intent.putExtra("g_id", this.j);
        intent.putExtra("g_name", this.k);
        startActivity(intent);
    }

    public void S() {
        TextView textView = (TextView) findViewById(R.id.f1);
        TextView textView2 = (TextView) findViewById(R.id.f2);
        TextView textView3 = (TextView) findViewById(R.id.f3);
        TextView textView4 = (TextView) findViewById(R.id.f4);
        TextView textView5 = (TextView) findViewById(R.id.f5);
        textView.setText(getString(R.string.no_));
        textView2.setText(getString(R.string.date));
        int i2 = this.t;
        if (i2 == 3) {
            textView3.setText(getString(R.string.from_branch));
            textView4.setText(getString(R.string.to_branch));
            textView5.setText(getString(R.string.qty));
        } else if (i2 == 4) {
            textView3.setText(getString(R.string.branch));
            textView4.setText(getString(R.string.adj_type));
            textView5.setText(getString(R.string.o_cost));
        }
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, textView);
        c0372Bn.a(this, textView2);
        c0372Bn.a(this, textView3);
        c0372Bn.a(this, textView4);
        c0372Bn.a(this, textView5);
    }

    public void T(String str) {
        try {
            C0922Sv c0922Sv = this.x;
            if (c0922Sv != null) {
                c0922Sv.getFilter().filter(str);
            }
        } catch (Exception unused) {
        }
    }

    public void U() {
        W(true);
        new Thread(new i()).start();
    }

    public void V(boolean z) {
    }

    public void W(boolean z) {
        if (z) {
            ProgressDialog progressDialog = new ProgressDialog(this);
            this.P = progressDialog;
            progressDialog.setMessage(getString(R.string.google_drive_list));
            this.P.show();
            return;
        }
        ProgressDialog progressDialog2 = this.P;
        if (progressDialog2 != null) {
            progressDialog2.hide();
        }
    }

    public void add_btn(View view) {
        if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.t == 3 ? "6" : "7", "new")) {
                Toast.makeText(this, getString(R.string.no_priv), 0).show();
                return;
            }
        }
        Intent intent = new Intent(this, (Class<?>) (this.t == 3 ? Bill_move.class : Bill_adj.class));
        intent.putExtra("TR_TYPE", String.valueOf(this.t));
        intent.putExtra("g_id", this.j);
        intent.putExtra("g_name", this.k);
        startActivity(intent);
    }

    public void amount_add_btn(View view) {
        add_btn(view);
    }

    public void btn_add(View view) {
        if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.t == 3 ? "6" : "7", "new")) {
                Toast.makeText(this, getString(R.string.no_priv), 0).show();
                return;
            }
        }
        Intent intent = new Intent(this, (Class<?>) (this.t == 3 ? Bill_move.class : Bill_adj.class));
        intent.putExtra("TR_ID", this.l);
        intent.putExtra("TR_TYPE", String.valueOf(this.t));
        intent.putExtra("g_id", this.j);
        intent.putExtra("g_name", this.k);
        startActivity(intent);
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        info.aalmoghalis.inventory.activity.a aVarA = info.aalmoghalis.inventory.activity.a.a(textView.getText().toString());
        this.O = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_item_remove(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        TextView textView = (TextView) linearLayout.findViewById(R.id.id);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.delete_msg) + "#" + ((Object) textView.getText()) + "?");
        builder.setPositiveButton(getString(R.string.confirm_yes), new c(textView));
        builder.setNegativeButton(getString(R.string.confirm_no), new d());
        builder.create().show();
    }

    public void btn_more(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        TextView textView = (TextView) linearLayout.findViewById(R.id.id);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.f8);
        R(textView.getText().toString(), ((TextView) linearLayout.findViewById(R.id.f2)).getText().toString(), textView2.getText().toString());
    }

    public void btn_update_status(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.page_enable);
        TextView textView = (TextView) linearLayout.findViewById(R.id.page_name);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (Integer.parseInt(imageView.getTag().toString()) == 17301515) {
            builder.setMessage(getString(R.string.enable) + "#" + ((Object) textView.getText()) + "?");
        } else {
            builder.setMessage(getString(R.string.disable) + "#" + ((Object) textView.getText()) + "?");
        }
        builder.setPositiveButton(getString(R.string.confirm_yes), new a(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new b());
        builder.create().show();
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.O.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.O + "'");
            }
            this.O = "";
            P();
        } catch (Exception e2) {
            Log.d("cat_update_error=", e2.getMessage());
        }
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (isTaskRoot()) {
            y();
        } else {
            finish();
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.data_listview_move3);
        this.v = (ListView) findViewById(R.id.list_items);
        this.v.setEmptyView((TextView) findViewById(R.id.emptyResults));
        this.i = new Z00(this.h, this);
        this.F = (TextView) findViewById(R.id.footer_sum);
        this.v.setOnItemClickListener(new e());
        try {
            if (getIntent().getStringExtra("TR_TYPE") != null) {
                this.t = Integer.parseInt(getIntent().getStringExtra("TR_TYPE"));
                this.j = getIntent().getStringExtra("g_id");
                this.k = getIntent().getStringExtra("g_name");
                setTitle(getResources().getStringArray(R.array.titles_main)[this.t - 1]);
            }
        } catch (Exception unused) {
        }
        S();
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.G = calendar.get(1);
        this.H = calendar.get(2);
        this.I = calendar.get(5);
        this.A = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.D);
        V(true);
        this.v.setChoiceMode(3);
        this.v.setMultiChoiceModeListener(new f());
        X();
        getWindow().setSoftInputMode(2);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.T, this.G, this.H, this.I);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.U, this.G, this.H, this.I);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main3_group_move, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new j());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        M(this.i.L2());
        V(true);
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
            H();
            return true;
        }
        if (menuItem.getItemId() != R.id.print) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (Build.VERSION.SDK_INT < 31) {
            I();
        }
        this.R = getTitle().toString();
        U();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
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
