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
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.C0372Bn;
import defpackage.C0566Hd;
import defpackage.C0908Sh;
import defpackage.C0922Sv;
import defpackage.C2160f10;
import defpackage.C4145vh;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Offers extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, a.b, LoaderManager.LoaderCallbacks<List<C4145vh>> {
    public static int i0 = 0;
    public static String j0 = "%";
    public static String k0 = "%";
    public C0922Sv B;
    public SparseBooleanArray D;
    public ArrayAdapter E;
    public ProgressDialog S;
    public int V;
    public int W;
    public int X;
    public SearchView d0;
    public SQLiteDatabase h;
    public Z00 i;
    public String j;
    public String k;
    public int l;
    public TextView z;
    public int n = 0;
    public double p = 0.0d;
    public TextView q = null;
    public AutoCompleteTextView t = null;
    public TextView u = null;
    public SwitchCompat v = null;
    public int w = 0;
    public ImageView x = null;
    public ListView y = null;
    public Toolbar A = null;
    public List C = new ArrayList();
    public ImageButton F = null;
    public AppCompatCheckBox G = null;
    public int H = 0;
    public String[] I = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] J = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public TextView K = null;
    public int L = 0;
    public int M = 0;
    public TextView N = null;
    public TextView O = null;
    public int P = 0;
    public int Q = 0;
    public String R = "";
    public Handler T = new l();
    public Cursor U = null;
    public int Y = 0;
    public String Z = CSS.Value.PERCENTAGE;
    public String a0 = CSS.Value.PERCENTAGE;
    public TextView b0 = null;
    public TextView c0 = null;
    public String e0 = "";
    public DatePickerDialog.OnDateSetListener f0 = new y();
    public DatePickerDialog.OnDateSetListener g0 = new z();
    public String h0 = "";

    public class A implements Comparator {
        public A() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return Double.valueOf(c4145vh.a().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.a().replaceAll(",", "")));
        }

        public /* synthetic */ A(Offers offers, j jVar) {
            this();
        }
    }

    public class B implements Comparator {
        public B() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return Double.valueOf(c4145vh2.a().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.a().replaceAll(",", "")));
        }

        public /* synthetic */ B(Offers offers, j jVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Offers$a, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2970a implements View.OnClickListener {
        public ViewOnClickListenerC2970a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Offers.this.j0(view);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Offers$b, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2971b implements View.OnClickListener {
        public ViewOnClickListenerC2971b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Offers.this.j0(view);
            } catch (Exception unused) {
            }
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ View a;

        public c(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Offers offers = Offers.this;
            offers.C = offers.B.e;
            int id = this.a.getId();
            if (id == R.id.f1) {
                Offers.this.sort_amount_click(this.a);
                Offers.this.P = 1;
            } else if (id == R.id.f2) {
                Offers.this.i0(this.a);
                Offers.this.P = 2;
            }
            Message message = new Message();
            message.obj = "2";
            Offers.this.T.sendMessage(message);
        }
    }

    public class d implements Comparator {
        public d() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int iCompareTo = c4145vh2.n().compareTo(String.valueOf(c4145vh.n()));
            return iCompareTo == 0 ? Integer.parseInt(c4145vh2.v()) - Integer.parseInt(c4145vh.v()) : iCompareTo;
        }
    }

    public class e implements Comparator {
        public e() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int iCompareTo = c4145vh.n().compareTo(String.valueOf(c4145vh2.n()));
            return iCompareTo == 0 ? Integer.parseInt(c4145vh.v()) - Integer.parseInt(c4145vh2.v()) : iCompareTo;
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public f(TextView textView, ImageView imageView) {
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
                Offers.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Offers.this.l = 0;
                Offers.this.R();
            } catch (Exception unused) {
                Toast.makeText(Offers.this.getApplicationContext(), Offers.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;

        public h(TextView textView) {
            this.a = textView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (this.a != null) {
                    Offers.this.l = 0;
                    Offers.this.R();
                }
            } catch (Exception e) {
                Log.d("delete_err=", e.getMessage());
            }
        }
    }

    public class i implements DialogInterface.OnClickListener {
        public i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class j implements AdapterView.OnItemClickListener {
        public j() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            TextView textView = (TextView) view.findViewById(R.id.id);
            Log.d("lv_click=", textView.getText().toString() + ":" + ((TextView) view.findViewById(R.id.f8)).getText().toString());
            Offers.i0 = Offers.this.y.getFirstVisiblePosition();
            Offers offers = Offers.this;
            Offers.j0 = offers.Z;
            Offers.k0 = offers.a0;
            Z00.F0 = offers.d0.getQuery() != null ? Offers.this.d0.getQuery().toString() : "";
            Offers.this.i.j9(textView.getText().toString(), Offers.this, 1);
        }
    }

    public class k implements AbsListView.MultiChoiceModeListener {

        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Offers.this.M();
                } catch (Exception unused) {
                    Toast.makeText(Offers.this.getApplicationContext(), "SQL Error.", 1);
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

        public k() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.menu_delete /* 2131297039 */:
                    Offers.this.D = Offers.this.B.c();
                    AlertDialog.Builder builder = new AlertDialog.Builder(Offers.this);
                    builder.setMessage(Offers.this.getString(R.string.delete_msg));
                    builder.setPositiveButton(Offers.this.getString(R.string.confirm_yes), new a());
                    builder.setNegativeButton(Offers.this.getString(R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayC = Offers.this.B.c();
                    Offers offers = Offers.this;
                    offers.D = sparseBooleanArrayC;
                    offers.N();
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
            Offers.this.y.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Offers.this.B.l.clear();
            Offers.this.B.h();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = Offers.this.y.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            Offers.this.B.l(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (Offers.this.y.getCheckedItemCount() != 1) {
                menu.findItem(R.id.menu_edit).setVisible(false);
            } else {
                menu.findItem(R.id.menu_delete).setVisible(true);
                menu.findItem(R.id.menu_edit).setVisible(true);
            }
            return false;
        }
    }

    public class l extends Handler {
        public l() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                Offers offers = Offers.this;
                offers.O(offers.U);
            } else if (message.obj.toString().equals("1")) {
                Z00 z00 = Offers.this.i;
                StringBuilder sb = new StringBuilder();
                Offers offers2 = Offers.this;
                sb.append(offers2.i.ic(offers2.e0));
                sb.append(".pdf");
                z00.ra(sb.toString());
            } else if (message.obj.toString().equals("2")) {
                Offers.this.B.notifyDataSetChanged();
                Offers offers3 = Offers.this;
                int i = offers3.P;
                if (i == 1) {
                    offers3.i.ld(offers3, offers3.N, offers3.Q);
                } else if (i == 2) {
                    offers3.i.ld(offers3, offers3.O, offers3.Q);
                }
            }
            Offers.this.f0(false);
        }
    }

    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Offers.this.Q();
            Message message = new Message();
            message.obj = "0";
            Offers.this.T.sendMessage(message);
        }
    }

    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            Offers offers = Offers.this;
            Z00 z00 = offers.i;
            ListView listView = offers.y;
            String strIc = z00.ic(offers.e0);
            Offers offers2 = Offers.this;
            z00.rb(listView, strIc, offers2.Z, offers2.a0);
            Message message = new Message();
            message.obj = "1";
            Offers.this.T.sendMessage(message);
        }
    }

    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Offers offers = Offers.this;
            offers.e0 = offers.i.ic(offers.e0);
            Offers offers2 = Offers.this;
            offers2.i.tb(offers2.y, offers2.e0, offers2.Z, offers2.a0, offers2.w);
            Message message = new Message();
            message.obj = "1";
            Offers.this.T.sendMessage(message);
        }
    }

    public class p extends WebViewClient {
        public p() {
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

    public class q implements DialogInterface.OnClickListener {
        public q() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Offers.this.showDialog(0);
        }
    }

    public class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Offers.this.showDialog(4);
        }
    }

    public class t implements DialogInterface.OnClickListener {
        public t() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class u implements DialogInterface.OnClickListener {
        public u() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Offers offers = Offers.this;
                offers.Y = 0;
                offers.R();
            } catch (Exception unused) {
            }
        }
    }

    public class v implements View.OnClickListener {
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public v(androidx.appcompat.app.AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Offers offers = Offers.this;
                offers.Y = 1;
                if (offers.b0.getText() == null) {
                    Offers.this.Z = "";
                } else {
                    Offers offers2 = Offers.this;
                    offers2.Z = offers2.b0.getText().toString();
                }
                if (Offers.this.c0.getText() == null) {
                    Offers.this.a0 = "";
                } else {
                    Offers offers3 = Offers.this;
                    offers3.a0 = offers3.c0.getText().toString();
                }
                Offers.this.R();
            } catch (Exception unused) {
            }
            this.a.dismiss();
        }
    }

    public class w implements SearchView.OnQueryTextListener {
        public w() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            if (TextUtils.isEmpty(str) || str.length() == 0) {
                Offers.this.P(1);
            }
            Offers.this.Y(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            Offers.this.P(0);
            return false;
        }
    }

    public class x implements MenuItemCompat.OnActionExpandListener {
        public x() {
        }

        @Override // androidx.core.view.MenuItemCompat.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return true;
        }

        @Override // androidx.core.view.MenuItemCompat.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return true;
        }
    }

    public class y implements DatePickerDialog.OnDateSetListener {
        public y() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Offers.this.V = i;
            Offers.this.W = i2;
            Offers.this.X = i3;
            try {
                String str = Offers.this.V + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Offers.this.W + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Offers.this.X));
                Locale locale = Locale.ENGLISH;
                Offers.this.b0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class z implements DatePickerDialog.OnDateSetListener {
        public z() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Offers.this.V = i;
            Offers.this.W = i2;
            Offers.this.X = i3;
            try {
                String str = Offers.this.V + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Offers.this.W + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Offers.this.X));
                Locale locale = Locale.ENGLISH;
                Offers.this.c0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    private void L() {
        int i2 = Calendar.getInstance().get(14);
        getSupportLoaderManager().initLoader(Integer.parseInt(this.j + 1) * i2, null, this).forceLoad();
    }

    private void b0(List list) {
        Collections.sort(list, Collections.reverseOrder(new e()));
    }

    private void g0(List list) {
        Collections.sort(this.C, new A(this, null));
    }

    private void h0(List list) {
        Collections.sort(list, Collections.reverseOrder(new d()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(View view) {
        if (this.Q == 0) {
            h0(this.C);
            this.Q = 1;
        } else {
            b0(this.C);
            this.Q = 0;
        }
    }

    public void I() {
        try {
            this.Y = 0;
            androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.b0 = (TextView) viewInflate.findViewById(R.id.f_date);
            this.c0 = (TextView) viewInflate.findViewById(R.id.t_date);
            this.b0.setOnClickListener(new r());
            this.c0.setOnClickListener(new s());
            builder.setPositiveButton(getString(R.string.btn_search), new t());
            builder.setNegativeButton(getString(R.string.btn_cancel), new u());
            androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new v(alertDialogCreate));
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
        try {
            Log.d("lv_pos=", i0 + ":" + Z00.F0 + ":" + j0 + ":" + k0);
            if (i0 <= 0) {
                i0 = 0;
                return;
            }
            if (this.y.getFirstVisiblePosition() > i0 || this.y.getLastVisiblePosition() < i0) {
                this.y.setSelection(i0);
            }
            i0 = 0;
        } catch (Exception e2) {
            i0 = 0;
            e2.printStackTrace();
        }
    }

    public void M() {
        if (C2160f10.h > 0 && !new C2160f10(this.i).l("29", HTML.Tag.DEL)) {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
            return;
        }
        for (int size = this.D.size() - 1; size >= 0; size--) {
            if (this.D.valueAt(size)) {
                C4145vh item = this.B.getItem(this.D.keyAt(size));
                this.B.remove(item);
                this.i.H("delete from bill_transactions2 where bill_id='" + item.v() + "'", "delete from bills2 where id ='" + item.v() + "'");
            }
        }
        R();
        d0(true);
    }

    public void N() {
        if (C2160f10.h > 0 && !new C2160f10(this.i).l("29", "edit")) {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
            return;
        }
        int size = this.D.size() - 1;
        if (this.D.valueAt(size)) {
            this.i.j9(this.B.getItem(this.D.keyAt(size)).v(), this, 0);
        }
    }

    public void O(Cursor cursor) {
        Offers offers = this;
        W();
        cursor.getCount();
        offers.p = 0.0d;
        offers.C.clear();
        cursor.moveToFirst();
        C0566Hd c0566Hd = new C0566Hd();
        while (!cursor.isAfterLast()) {
            offers.p += cursor.getDouble(c0566Hd.b(cursor, "f13"));
            offers.C.add(new C4145vh(cursor.getString(c0566Hd.b(cursor, "_id")), cursor.getString(c0566Hd.b(cursor, "f10")), cursor.getString(c0566Hd.b(cursor, "f1")), cursor.getString(c0566Hd.b(cursor, "f5")), cursor.getString(c0566Hd.b(cursor, "f7")), "" + cursor.getDouble(c0566Hd.b(cursor, "f3")), cursor.getString(c0566Hd.b(cursor, "f9")), cursor.getString(c0566Hd.b(cursor, "f2")), cursor.getString(c0566Hd.b(cursor, "f8")), cursor.getString(c0566Hd.b(cursor, "f4")), cursor.getString(c0566Hd.b(cursor, "f6")), cursor.getString(c0566Hd.b(cursor, "f11")), cursor.getString(c0566Hd.b(cursor, "f12")), cursor.getString(c0566Hd.b(cursor, "f13")), "", "" + cursor.getDouble(c0566Hd.b(cursor, "f15")), "", cursor.getString(c0566Hd.b(cursor, "f17")), cursor.getString(c0566Hd.b(cursor, "f18")), cursor.getString(c0566Hd.b(cursor, "f19"))));
            offers = this;
            if (cursor.getColumnIndex("user_name") > 0) {
                List list = offers.C;
                ((C4145vh) list.get(list.size() - 1)).i = cursor.getString(cursor.getColumnIndex("user_name"));
            }
            cursor.moveToNext();
        }
        cursor.close();
        if (offers.B == null) {
            Log.d("listviewadapter=", "null");
            C0922Sv c0922Sv = new C0922Sv(this, R.layout.data_det_row_rep6_2, offers.C, 19, U(), V(), 4);
            offers.B = c0922Sv;
            c0922Sv.l.clear();
            offers.B.notifyDataSetChanged();
            offers.y.setAdapter((ListAdapter) offers.B);
        } else {
            Log.d("listviewadapter=", "not_null");
            offers.B.notifyDataSetChanged();
        }
        offers.K.setText(offers.i.P7(String.valueOf(offers.p)));
        K();
    }

    public void P(int i2) {
        try {
            if (i2 == 1) {
                this.K.setText(this.i.P7(String.valueOf(this.p)));
            } else {
                Log.d("search=", "calc_sum" + this.B.e.size());
                this.K.setText(this.i.P7(String.valueOf(S(this.B.e))));
            }
        } catch (Exception unused) {
        }
    }

    public void Q() {
        int i2 = this.Y;
        String str = CSS.Value.PERCENTAGE;
        if (i2 == 0) {
            Z00 z00 = this.i;
            if (!this.j.equals("0")) {
                str = this.j;
            }
            this.U = z00.U1(str, this.w, 2, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, -1, -1, 0, "");
            return;
        }
        this.Z = this.Z.isEmpty() ? CSS.Value.PERCENTAGE : this.Z;
        this.a0 = this.a0.isEmpty() ? CSS.Value.PERCENTAGE : this.a0;
        Z00 z01 = this.i;
        if (!this.j.equals("0")) {
            str = this.j;
        }
        this.U = z01.U1(str, this.w, 2, this.Z, this.a0, CSS.Value.PERCENTAGE, -1, -1, 0, "");
    }

    public void R() {
        f0(true);
        new Thread(new m()).start();
    }

    public double S(List list) {
        Log.d("net_bal:", list.size() + "");
        double d2 = 0.0d;
        for (int i2 = 0; i2 < list.size(); i2++) {
            d2 += Double.parseDouble(((C4145vh) list.get(i2)).f().replaceAll(",", ""));
        }
        return d2;
    }

    public void T(String str, String str2) {
        Log.d("edit_inputs=", str + ":" + str2);
        Intent intent = new Intent(this, (Class<?>) Offer_edit.class);
        intent.putExtra("TR_ID", str);
        intent.putExtra("TR_TYPE", String.valueOf(this.w));
        intent.putExtra("tran_status", String.valueOf(str2));
        intent.putExtra("is_back", this.i.e2(str));
        intent.putExtra("g_id", this.j);
        intent.putExtra("g_name", this.k);
        startActivity(intent);
    }

    public boolean U() {
        return this.L <= 1;
    }

    public boolean V() {
        return this.M <= 1;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void W() {
        this.N = (TextView) findViewById(R.id.f1);
        this.O = (TextView) findViewById(R.id.f2);
        TextView textView = (TextView) findViewById(R.id.f3);
        TextView textView2 = (TextView) findViewById(R.id.f4);
        TextView textView3 = (TextView) findViewById(R.id.f5);
        TextView textView4 = (TextView) findViewById(R.id.f6);
        this.N.setText(getString(R.string.doc_no_2));
        this.O.setText(getString(R.string.date));
        textView.setText(getString(R.string.name));
        this.i.ld(this, this.N, this.Q);
        this.i.ld(this, this.O, this.Q);
        textView2.setText(getString(R.string.branch));
        textView3.setText(getString(R.string.tr_amount));
        textView4.setText(getString(R.string.currency));
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, this.N);
        c0372Bn.a(this, this.O);
        c0372Bn.a(this, textView);
        c0372Bn.a(this, textView2);
        c0372Bn.a(this, textView3);
        c0372Bn.a(this, textView4);
        this.N.setOnClickListener(new ViewOnClickListenerC2970a());
        this.O.setOnClickListener(new ViewOnClickListenerC2971b());
        if (U()) {
            textView2.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.O.getLayoutParams();
            layoutParams.weight = 40.0f;
            this.O.setLayoutParams(layoutParams);
        }
        if (V()) {
            textView4.setVisibility(8);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView.getLayoutParams();
            layoutParams2.weight = 40.0f;
            textView.setLayoutParams(layoutParams2);
        }
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader loader, List list) {
        TextView textView;
        Log.d("Trace_E_Bill2_loader=", FragmentStatePagerSupport_Main.X() + "#" + this.j + ":" + this.Z + ":" + this.a0);
        W();
        this.C = list;
        this.p = C0908Sh.n;
        if (this.B == null) {
            Log.d("listviewadapter=", "null");
            C0922Sv c0922Sv = new C0922Sv(this, R.layout.data_det_row_rep6_2, this.C, 19, U(), V(), 4);
            this.B = c0922Sv;
            c0922Sv.l.clear();
            this.B.notifyDataSetChanged();
            this.y.setAdapter((ListAdapter) this.B);
            this.K.setText(this.i.P7(String.valueOf(C0908Sh.n)));
        } else {
            Log.d("listviewadapter=", "not_null:" + this.d0.getQuery().toString().length() + ":" + Z00.F0.length());
            this.B.f(this.C);
            this.i.le(this, this.d0, this.B, this.K, C0908Sh.n, 1);
        }
        ListView listView = this.y;
        if (listView == null || (textView = this.z) == null) {
            return;
        }
        listView.setEmptyView(textView);
        this.z.setText(getString(R.string.empty_results));
    }

    public void Y(String str) {
        try {
            C0922Sv c0922Sv = this.B;
            if (c0922Sv != null) {
                c0922Sv.getFilter().filter(str);
            }
        } catch (Exception unused) {
        }
    }

    public void Z() {
        f0(true);
        new Thread(new o()).start();
    }

    public void a0() {
        f0(true);
        new Thread(new n()).start();
    }

    public void add_btn(View view) {
        if (C2160f10.h > 0 && !new C2160f10(this.i).l("29", "new")) {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
            return;
        }
        Intent intent = new Intent(this, (Class<?>) Offer_edit.class);
        intent.putExtra("TR_TYPE", String.valueOf(this.w));
        intent.putExtra("g_id", this.j);
        intent.putExtra("g_name", this.k);
        intent.putExtra("back_edit", 1);
        Z00.E0 = true;
        startActivity(intent);
    }

    public void btn_add(View view) {
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        a aVarA = a.a(textView.getText().toString());
        this.R = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_item_remove(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        TextView textView = (TextView) linearLayout.findViewById(R.id.id);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.delete_msg) + "#" + ((Object) textView.getText()) + "?");
        builder.setPositiveButton(getString(R.string.confirm_yes), new h(textView));
        builder.setNegativeButton(getString(R.string.confirm_no), new i());
        builder.create().show();
    }

    public void btn_more(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        T(((TextView) linearLayout.findViewById(R.id.id)).getText().toString(), ((TextView) linearLayout.findViewById(R.id.f8)).getText().toString());
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
        builder.setPositiveButton(getString(R.string.confirm_yes), new f(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new g());
        builder.create().show();
    }

    public final void c0(List list) {
        Collections.sort(this.C, new B(this, null));
    }

    public void d0(boolean z2) {
    }

    public void e0() {
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new p());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new q());
        builder.show();
    }

    public void f0(boolean z2) {
        try {
            if (z2) {
                ProgressDialog progressDialog = new ProgressDialog(this);
                this.S = progressDialog;
                progressDialog.setMessage(getString(R.string.google_drive_list));
                this.S.show();
            } else {
                this.S.hide();
            }
        } catch (Exception unused) {
        }
    }

    public void help_btn(View view) {
        e0();
    }

    public void j0(View view) {
        f0(true);
        new Thread(new c(view)).start();
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.R.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.R + "'");
            }
            this.R = "";
            R();
        } catch (Exception e2) {
            Log.d("cat_update_error=", e2.getMessage());
        }
    }

    public void no_result_btn(View view) {
        this.Y = 0;
        R();
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Log.d("onback=", isTaskRoot() + "");
        if (isTaskRoot()) {
            y();
        } else {
            finish();
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.data_listview_bill3_);
        Z00.E0 = false;
        Z00.F0 = "";
        this.y = (ListView) findViewById(R.id.list_items);
        TextView textView = (TextView) findViewById(R.id.emptyResults);
        this.z = textView;
        textView.setText(getString(R.string.wait));
        this.y.setEmptyView(this.z);
        Z00 z00 = new Z00(this.h, this);
        this.i = z00;
        this.L = z00.F2();
        this.y.setOnItemClickListener(new j());
        this.K = (TextView) findViewById(R.id.footer_sum);
        try {
            if (getIntent().getStringExtra("TR_TYPE") != null) {
                this.w = Integer.parseInt(getIntent().getStringExtra("TR_TYPE"));
                this.j = getIntent().getStringExtra("g_id");
                this.k = getIntent().getStringExtra("g_name");
                setTitle(getResources().getStringArray(R.array.titles_main)[this.w - 3]);
            }
        } catch (Exception unused) {
        }
        this.M = this.i.f3(this.w);
        W();
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.V = calendar.get(1);
        this.W = calendar.get(2);
        this.X = calendar.get(5);
        this.E = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.I);
        d0(true);
        this.y.setChoiceMode(3);
        this.y.setMultiChoiceModeListener(new k());
        L();
        getWindow().setSoftInputMode(2);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.f0, this.V, this.W, this.X);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.g0, this.V, this.W, this.X);
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<List<C4145vh>> onCreateLoader(int i2, Bundle bundle) {
        Log.d("Trace_S_Bill2_loader=", FragmentStatePagerSupport_Main.X() + "#" + this.j + ":" + this.Z + ":" + this.a0);
        return new C0908Sh(this, this.j, this.w, this.i, this.Z, this.a0, 10);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d("oncreate:", "onCreateOptionsMenu");
        getMenuInflater().inflate(R.menu.menu_main3_group_general, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.search);
        this.d0 = (SearchView) menuItemFindItem.getActionView();
        this.d0.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        this.d0.setQueryHint(getString(R.string.search_hint));
        this.d0.setOnQueryTextListener(new w());
        MenuItemCompat.setOnActionExpandListener(menuItemFindItem, new x());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Log.d("oncreate=", "onDestroy...");
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        O(this.i.L2());
        d0(true);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        onBackPressed();
        return true;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<List<C4145vh>> loader) {
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
        if (menuItem.getItemId() == R.id.print) {
            if (Build.VERSION.SDK_INT < 31) {
                J();
            }
            this.e0 = getTitle().toString();
            a0();
            return true;
        }
        if (menuItem.getItemId() != R.id.action_print_bills) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (Build.VERSION.SDK_INT < 31) {
            J();
        }
        this.e0 = getTitle().toString();
        Z();
        return true;
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, android.app.Activity
    public void onRestart() {
        Log.d("oncreate=", "onRestart...");
        super.onRestart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Log.d("Oncreate:", "onResume:" + Offer_edit.s2);
        if (Offer_edit.s2) {
            Offer_edit.s2 = false;
            Offer_edit.t2 = false;
            L();
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Log.d("oncreate=", "onStart...");
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Log.d("oncreate=", "onStop...");
        super.onStop();
    }

    public void sort_amount_click(View view) {
        if (this.Q == 0) {
            g0(this.C);
            this.Q = 1;
        } else {
            c0(this.C);
            this.Q = 0;
        }
    }
}
