package info.aalmoghalis.inventory.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC4371yX;
import defpackage.C0566Hd;
import defpackage.C0908Sh;
import defpackage.C0917Sq;
import defpackage.C0978Uv;
import defpackage.C2160f10;
import defpackage.C4143vg;
import defpackage.C4145vh;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.App;
import info.aalmoghalis.inventory.old.CusLimit_edit;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ValidFragment"})
public class k extends Fragment implements View.OnClickListener, LoaderManager.LoaderCallbacks<List<C4145vh>> {
    public ImageView A;
    public ImageView B;
    public C0978Uv L;
    public SparseBooleanArray O;
    public Bundle X;
    public int Y;
    public int Z;
    public int a0;
    public SQLiteDatabase g;
    public Z00 h;
    public C h0;
    public String i;
    public String j;
    public ProgressDialog j0;
    public String k;
    public String l;
    public String n;
    public B o0;
    public EditText p0;
    public boolean q0;
    public Activity s0;
    public double p = 0.0d;
    public int q = 0;
    public int t = 0;
    public AutoCompleteTextView u = null;
    public EditText v = null;
    public EditText w = null;
    public TextView x = null;
    public ImageView y = null;
    public ImageView z = null;
    public ImageView C = null;
    public TextView D = null;
    public TextView E = null;
    public TextView F = null;
    public TextView G = null;
    public TextView H = null;
    public Button I = null;
    public ListView J = null;
    public TextView K = null;
    public List M = new ArrayList();
    public List N = new ArrayList();
    public ImageButton P = null;
    public String[] Q = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public int[] R = {R.drawable.up, 1, R.drawable.down};
    public Toolbar S = null;
    public int T = 0;
    public String U = "";
    public String V = "";
    public String W = "";
    public int b0 = 0;
    public String c0 = CSS.Value.PERCENTAGE;
    public String d0 = CSS.Value.PERCENTAGE;
    public TextView e0 = null;
    public TextView f0 = null;
    public ProgressDialog g0 = null;
    public View.OnClickListener i0 = new d();
    public Handler k0 = new h();
    public String l0 = "";
    public boolean m0 = false;
    public ArrayList n0 = new ArrayList();
    public String r0 = "";

    public class A implements View.OnClickListener {
        public A() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                k.this.F(view);
            } catch (Exception unused) {
            }
        }
    }

    public interface B {
        void onButtonClicked2(MenuItem menuItem);
    }

    public interface C {
        void onButtonClicked(View view);
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.k$a, reason: case insensitive filesystem */
    public class RunnableC3078a implements Runnable {
        public RunnableC3078a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.g0.dismiss();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.k$b, reason: case insensitive filesystem */
    public class C3079b extends WebViewClient {
        public C3079b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            webView.loadUrl("javascript:DisplayItem_details('5','6','8')");
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.k$c, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC3080c implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3080c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.img_add_amount) {
                k.this.amount_add_btn(view);
                return;
            }
            if (view.getId() == R.id.img_help) {
                k.this.help_btn(view);
                return;
            }
            if (view.getId() == 16908292) {
                k.this.w(view);
            } else if (view.getId() == R.id.move_left || view.getId() == R.id.move_right) {
                k.this.h0.onButtonClicked(view);
            }
        }
    }

    public class e extends Handler {
        public e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class f implements Comparator {
        public f() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return String.valueOf(c4145vh2.a()).compareTo(String.valueOf(c4145vh.a()));
        }
    }

    public class g implements Comparator {
        public g() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return String.valueOf(c4145vh.a()).compareTo(String.valueOf(c4145vh2.a()));
        }
    }

    public class h extends Handler {
        public h() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (!message.obj.toString().equals("0") && message.obj.toString().equals("1")) {
                Z00 z00 = k.this.h;
                StringBuilder sb = new StringBuilder();
                k kVar = k.this;
                sb.append(kVar.h.ic(kVar.l0));
                sb.append(".pdf");
                z00.ra(sb.toString());
            }
            k.this.C(false);
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k kVar = k.this;
            Z00 z00 = kVar.h;
            z00.ib(kVar.J, z00.ic(kVar.l0));
            Message message = new Message();
            message.obj = "1";
            k.this.k0.sendMessage(message);
        }
    }

    public class j implements AdapterView.OnItemClickListener {
        public j() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            try {
                String string = ((TextView) view.findViewById(R.id.f1)).getText().toString();
                String string2 = ((TextView) view.findViewById(R.id.id)).getText().toString();
                String string3 = ((TextView) view.findViewById(R.id.f2)).getText().toString();
                k kVar = k.this;
                kVar.l = kVar.h.l3("0");
                Intent intent = new Intent(view.getContext(), (Class<?>) FragmentStatePagerSupport.class);
                intent.putExtra("CUS_ID", string2);
                intent.putExtra("CUS_BAL", "0");
                intent.putExtra("CUS_GSM", string3);
                intent.putExtra("CUS_NAME", string);
                intent.putExtra("g_id", k.this.j);
                intent.putExtra("CURR_NAME", k.this.l);
                k.this.X = new Bundle();
                k.this.N.clear();
                for (int i2 = 0; i2 < k.this.M.size(); i2++) {
                    C4145vh c4145vh = (C4145vh) k.this.M.get(i2);
                    k.this.N.add(new C4143vg(c4145vh.v(), c4145vh.a(), c4145vh.n(), 0.0d, 0, 0, k.this.k, k.this.l));
                }
                ((App) k.this.getActivity().getApplication()).d(k.this.N);
                if (C2160f10.h <= 0 || new C2160f10(k.this.h).l("-9", "view")) {
                    k.this.startActivity(intent);
                } else {
                    Toast.makeText(k.this.getActivity(), k.this.getActivity().getString(R.string.no_priv), 0).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.k$k, reason: collision with other inner class name */
    public class C0309k implements AbsListView.MultiChoiceModeListener {

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.k$k$a */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    k.this.p();
                } catch (Exception unused) {
                    Toast.makeText(k.this.getActivity(), "SQL Error.", 1);
                }
            }
        }

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.k$k$b */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public C0309k() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.menu_delete /* 2131297039 */:
                    SparseBooleanArray sparseBooleanArrayB = k.this.L.b();
                    k kVar = k.this;
                    kVar.O = sparseBooleanArrayB;
                    AlertDialog.Builder builder = new AlertDialog.Builder(kVar.getActivity());
                    builder.setMessage(k.this.getActivity().getString(R.string.delete_msg_cus));
                    builder.setPositiveButton(k.this.getActivity().getString(R.string.confirm_yes), new a());
                    builder.setNegativeButton(k.this.getActivity().getString(R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayB2 = k.this.L.b();
                    k kVar2 = k.this;
                    kVar2.O = sparseBooleanArrayB2;
                    kVar2.q();
                    actionMode.finish();
                    break;
                case R.id.menu_move /* 2131297042 */:
                    SparseBooleanArray sparseBooleanArrayB3 = k.this.L.b();
                    k kVar3 = k.this;
                    kVar3.O = sparseBooleanArrayB3;
                    kVar3.v();
                    actionMode.finish();
                    break;
            }
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.contextual_action_bar_main, menu);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            k.this.J.setBackgroundColor(Color.parseColor("#FFFFFF"));
            k.this.L.l.clear();
            k.this.L.e();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = k.this.J.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            k.this.L.g(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (k.this.J.getCheckedItemCount() != 1) {
                menu.findItem(R.id.menu_edit).setVisible(false);
                menu.findItem(R.id.menu_move).setVisible(false);
            } else {
                menu.findItem(R.id.menu_delete).setVisible(true);
                menu.findItem(R.id.menu_edit).setVisible(true);
                menu.findItem(R.id.menu_move).setVisible(false);
            }
            return false;
        }
    }

    public class l implements SearchView.OnQueryTextListener {
        public l() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            TextUtils.isEmpty(str);
            k.this.y(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class m implements DialogInterface.OnClickListener {
        public m() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class n extends Handler {
        public n() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class o extends Handler {
        public o() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class p implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public p(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            k.this.h.v0("insert into groups  (name )  values( '" + k.this.r0 + "'  )");
            k.this.q0 = true;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class q implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public q(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            k.this.q0 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class r implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ Dialog b;
        public final /* synthetic */ EditText c;

        public r(AutoCompleteTextView autoCompleteTextView, Dialog dialog, EditText editText) {
            this.a = autoCompleteTextView;
            this.b = dialog;
            this.c = editText;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.a.dismissDropDown();
            this.b.dismiss();
            if (this.c != null) {
                if (this.a.getId() == R.id.account_type || this.a.getId() == R.id.cus_group) {
                    this.c.requestFocus();
                    k kVar = k.this;
                    kVar.h.Md(kVar.getActivity());
                }
            }
        }
    }

    public class s implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public s(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    public class t implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public t(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
        }
    }

    public class u implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public u(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k.this.n(this.a, this.b, null);
        }
    }

    public class v implements DialogInterface.OnClickListener {
        public v() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class w implements DialogInterface.OnClickListener {
        public w() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class x implements Comparator {
        public x() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return String.valueOf(c4145vh2.a()).compareTo(String.valueOf(c4145vh.a()));
        }
    }

    public class y implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ AlertDialog b;

        public y(AutoCompleteTextView autoCompleteTextView, AlertDialog alertDialog) {
            this.a = autoCompleteTextView;
            this.b = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (k.this.h.Q5(this.a.getText().toString()).getCount() == 0) {
                k.this.r0 = this.a.getText().toString();
                k kVar = k.this;
                kVar.r(kVar.getActivity().getString(R.string.validation_add_group), k.this.getActivity().getString(R.string.validation_add_group) + "#" + k.this.r0, k.this.getActivity());
                if (!k.this.q0) {
                    return;
                }
            }
            if (zA) {
                for (int size = k.this.O.size() - 1; size >= 0; size--) {
                    if (k.this.O.valueAt(size)) {
                        k kVar2 = k.this;
                        C4143vg c4143vgM = kVar2.m(kVar2.L.getItem(kVar2.O.keyAt(size)));
                        k kVar3 = k.this;
                        C0978Uv c0978Uv = kVar3.L;
                        c0978Uv.remove(c0978Uv.getItem(kVar3.O.keyAt(size)));
                        k.this.h.v0("update customers  set g_id=(select b.id from groups b where b.name='" + this.a.getText().toString() + "') ,online=0 where id='" + c4143vgM.i() + "' and cus_type_id in (0,1) ");
                    }
                }
                k.this.t();
                this.b.dismiss();
            }
        }
    }

    public class z implements Comparator {
        public z() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return String.valueOf(c4145vh.a()).compareTo(String.valueOf(c4145vh2.a()));
        }
    }

    public k() {
    }

    private void A(List list) {
        Collections.sort(list, Collections.reverseOrder(new z()));
    }

    private void B(List list) {
        Collections.sort(list, Collections.reverseOrder(new g()));
    }

    private void D(List list) {
        Collections.sort(list, Collections.reverseOrder(new x()));
    }

    private void E(List list) {
        Collections.sort(list, Collections.reverseOrder(new f()));
    }

    private void k(String str) {
        new android.app.AlertDialog.Builder(getActivity()).setTitle("Permission Request").setMessage(str).setCancelable(false).setPositiveButton(android.R.string.yes, new m()).show();
    }

    private void o() {
        int i2 = Calendar.getInstance().get(14);
        getActivity().getSupportLoaderManager().initLoader(Integer.parseInt(this.j + 1) * i2, null, this).forceLoad();
        s();
    }

    public void C(boolean z2) {
        try {
            if (z2) {
                ProgressDialog progressDialog = new ProgressDialog(getActivity());
                this.j0 = progressDialog;
                progressDialog.setMessage(getString(R.string.google_drive_list));
                this.j0.show();
            } else {
                this.j0.hide();
            }
        } catch (Exception unused) {
        }
    }

    public void F(View view) {
        if (this.t == 0) {
            D(this.M);
            this.L.notifyDataSetChanged();
            this.t = 1;
        } else {
            A(this.M);
            this.L.notifyDataSetChanged();
            this.t = 0;
        }
    }

    public void G(View view) {
        if (this.t == 0) {
            E(this.M);
            this.L.notifyDataSetChanged();
            this.t = 1;
        } else {
            B(this.M);
            this.L.notifyDataSetChanged();
            this.t = 0;
        }
    }

    public void amount_add_btn(View view) {
        if (C2160f10.h > 0 && !new C2160f10(this.h).l("11", "new")) {
            Toast.makeText(getActivity(), getActivity().getString(R.string.no_priv), 0).show();
            return;
        }
        this.h.fe(getActivity(), "0", "", "", this.k, "", "", this.n, new e(), this.J);
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        t();
    }

    public void help_btn(View view) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        WebView webView = new WebView(getActivity());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new C3079b());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new DialogInterfaceOnClickListenerC3080c());
        builder.show();
    }

    public void l() {
        if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(getActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public C4143vg m(C4145vh c4145vh) {
        return new C4143vg(c4145vh.v(), c4145vh.a(), c4145vh.n(), 0.0d, 0, 0, this.k, this.l, c4145vh.o());
    }

    public void n(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
        Dialog dialog = new Dialog(getActivity());
        LinearLayout linearLayout = new LinearLayout(getActivity());
        autoCompleteTextView.setText("");
        ListView listView = new ListView(getActivity());
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new r(autoCompleteTextView, dialog, editText));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.setTitle(autoCompleteTextView.getHint().toString());
        dialog.show();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 1) {
            try {
                getActivity();
                if (i3 == -1) {
                    Cursor cursorQuery = getActivity().getContentResolver().query(intent.getData(), new String[]{"data1", "display_name"}, null, null, null);
                    cursorQuery.moveToFirst();
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
                    this.p0.setText(string);
                    cursorQuery.close();
                    Log.d("Phone=", "ZZZ number : " + string + " , name : " + string2);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.s0 = activity;
        try {
            this.h0 = (C) activity;
        } catch (ClassCastException unused) {
        }
        try {
            this.o0 = (B) activity;
        } catch (ClassCastException unused2) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressDialog progressDialog = new ProgressDialog(view.getContext());
        this.g0 = progressDialog;
        progressDialog.setCancelable(true);
        this.g0.setMessage("Processing...");
        this.g0.setProgressStyle(0);
        this.g0.setMax(10);
        this.g0.show();
        this.M = this.L.e;
        if (view.getId() == R.id.f1) {
            G(view);
        }
        new Handler().postDelayed(new RunnableC3078a(), 400L);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.h = new Z00(this.g, getActivity());
            this.j = getArguments() != null ? getArguments().getString("cus_id") : "";
            this.k = getArguments() != null ? getArguments().getString("cus_name") : "";
            this.l = getArguments() != null ? getArguments().getString("curr_name") : "";
            this.n = getArguments() != null ? getArguments().getString("cus_type") : "";
            this.T = getArguments() != null ? getArguments().getInt("size") : 0;
        } catch (Exception unused) {
        }
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<List<C4145vh>> onCreateLoader(int i2, Bundle bundle) {
        Log.d("Loader=", "onCreateLoader:" + this.j + ":" + this.n);
        return new C0908Sh(getActivity(), this.j, this.l, this.n, this.h, 13);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (menu != null) {
            menu.clear();
        }
        menuInflater.inflate(R.menu.menu_main3_, menu);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.search));
        searchView.setSearchableInfo(((SearchManager) getActivity().getSystemService("search")).getSearchableInfo(getActivity().getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new l());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.data_listview_rep7_, viewGroup, false);
        this.h = new Z00(this.g, getActivity());
        try {
            setHasOptionsMenu(true);
            u(viewInflate);
            Log.d("OnCreate:=", "onCreateView_all:" + this.j);
            if (this.J == null) {
                this.J = (ListView) viewInflate.findViewById(R.id.list_items);
                TextView textView = (TextView) viewInflate.findViewById(android.R.id.empty);
                this.K = textView;
                this.J.setEmptyView(textView);
            }
            this.J.setOnItemClickListener(new j());
            this.J.setChoiceMode(3);
            this.J.setMultiChoiceModeListener(new C0309k());
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.footer_sum);
            this.x = textView2;
            textView2.setText(this.k + "#" + this.n);
            this.A = (ImageView) viewInflate.findViewById(R.id.move_right);
            this.B = (ImageView) viewInflate.findViewById(R.id.move_left);
            this.A.setOnClickListener(this.i0);
            this.B.setOnClickListener(this.i0);
            if (this.T <= 1) {
                this.A.setVisibility(8);
                this.B.setVisibility(8);
            }
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_add_amount);
            this.z = imageView;
            imageView.setOnClickListener(this.i0);
            this.U = getActivity().getString(R.string.footer_cus_null);
            this.V = getActivity().getString(R.string.tot_radio1);
            this.W = getActivity().getString(R.string.tot_radio2);
            Calendar calendar = Calendar.getInstance();
            new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            this.Y = calendar.get(1);
            this.Z = calendar.get(2);
            this.a0 = calendar.get(5);
            try {
                ViewConfiguration viewConfiguration = ViewConfiguration.get(getActivity());
                Field declaredField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    declaredField.setBoolean(viewConfiguration, false);
                }
            } catch (Exception unused) {
            }
            o();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.s0 = null;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<List<C4145vh>> loader) {
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.print) {
            l();
            if (this.h.ja("prefPrintSort", true)) {
                this.L.notifyDataSetChanged();
                this.t = 1;
            }
            try {
                this.l0 = getActivity().getTitle().toString() + "#" + this.k;
                z();
            } catch (Exception unused) {
            }
            return true;
        }
        if (itemId == R.id.list) {
            this.o0.onButtonClicked2(menuItem);
            return true;
        }
        if (itemId != R.id.cus_limit) {
            if (itemId != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            getActivity().finish();
            return true;
        }
        if (C2160f10.h <= 0 || new C2160f10(this.h).l("31", "view")) {
            startActivity(new Intent(getActivity(), (Class<?>) CusLimit_edit.class));
            return true;
        }
        Toast.makeText(getActivity(), getActivity().getString(R.string.no_priv), 0).show();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 112) {
            if (iArr.length == 1 && iArr[0] == 0) {
                return;
            }
            k(getString(R.string.permissions_not_granted_write_storage));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (Bill_edit.P2) {
            Bill_edit.P2 = false;
            getActivity().recreate();
        }
    }

    public void p() {
        if (C2160f10.h > 0 && !new C2160f10(this.h).l("11", "edit")) {
            Toast.makeText(getActivity(), getActivity().getString(R.string.no_priv), 0).show();
            return;
        }
        for (int size = this.O.size() - 1; size >= 0; size--) {
            if (this.O.valueAt(size)) {
                C4143vg c4143vgM = m(this.L.getItem(this.O.keyAt(size)));
                if (this.h.L3(c4143vgM.i()).getCount() == 0) {
                    String strY0 = this.h.y0("delete from customers where id='" + c4143vgM.i() + "' and id>0 and id not in (select cus_id from bills)  and id not in (select cus_id from transactions)  and id not in (select t_cus_id from transactions where t_cus_id is not null) ");
                    if (strY0 == null || !strY0.equals("1")) {
                        FragmentActivity activity = getActivity();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Error:");
                        if (strY0 != null && strY0.length() > 20) {
                            strY0 = strY0.substring(0, 20);
                        }
                        sb.append(strY0);
                        Toast.makeText(activity, sb.toString(), 0).show();
                        return;
                    }
                    C0978Uv c0978Uv = this.L;
                    c0978Uv.remove(c0978Uv.getItem(this.O.keyAt(size)));
                } else {
                    Toast.makeText(getActivity(), getActivity().getString(R.string.no_delete), 0).show();
                }
            }
        }
        t();
    }

    public void q() {
        if (C2160f10.h > 0 && !new C2160f10(this.h).l("11", "edit")) {
            Toast.makeText(getActivity(), getActivity().getString(R.string.no_priv), 0).show();
            return;
        }
        try {
            int size = this.O.size() - 1;
            if (this.O.valueAt(size)) {
                C4143vg c4143vgM = m(this.L.getItem(this.O.keyAt(size)));
                this.i = c4143vgM.i();
                this.h.fe(getActivity(), c4143vgM.i(), c4143vgM.j(), c4143vgM.h(), c4143vgM.f(), c4143vgM.l(), this.h.P4(c4143vgM.i()), this.h.v3(c4143vgM.i()), new n(), this.J);
                try {
                    Looper.loop();
                } catch (RuntimeException unused) {
                }
                t();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean r(String str, String str2, Context context) {
        o oVar = new o();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getActivity().getString(R.string.confirm_yes), new p(oVar));
        builder.setNegativeButton(getActivity().getString(R.string.confirm_no), new q(oVar));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.q0;
    }

    public void s() {
        Log.d("trace_S_List_Acct_d=", FragmentStatePagerSupport_Main.X());
        Cursor cursorS4 = this.h.s4();
        Z00.i0.clear();
        C0566Hd c0566Hd = new C0566Hd();
        cursorS4.moveToFirst();
        while (!cursorS4.isAfterLast()) {
            Z00.i0.add(new C4145vh(cursorS4.getString(c0566Hd.b(cursorS4, "_id")), cursorS4.getString(c0566Hd.b(cursorS4, "f1")), cursorS4.getString(c0566Hd.b(cursorS4, "f2")), cursorS4.getString(c0566Hd.b(cursorS4, "f3")), cursorS4.getString(c0566Hd.b(cursorS4, "f6")) + "-" + cursorS4.getString(c0566Hd.b(cursorS4, "f4")), cursorS4.getString(c0566Hd.b(cursorS4, "f5")), cursorS4.getString(c0566Hd.b(cursorS4, "f4")), "", ""));
            cursorS4.moveToNext();
        }
        cursorS4.close();
        Log.d("trace_E_List_Acct_d=", FragmentStatePagerSupport_Main.X() + ":" + Z00.i0.size());
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
    }

    public void t() {
        getActivity().recreate();
    }

    public void u(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        if (view != null) {
            textView = (TextView) view.findViewById(R.id.f1);
            textView2 = (TextView) view.findViewById(R.id.f2);
            textView3 = (TextView) view.findViewById(R.id.f3);
            textView4 = (TextView) view.findViewById(R.id.f4);
        } else {
            textView = (TextView) view.findViewById(R.id.f1);
            textView2 = (TextView) view.findViewById(R.id.f2);
            textView3 = (TextView) view.findViewById(R.id.f3);
            textView4 = (TextView) view.findViewById(R.id.f4);
        }
        textView.setText(getString(R.string.name));
        textView2.setText(getString(R.string.cus_phone));
        textView3.setText(getString(R.string.pref_address));
        textView4.setText(getString(R.string.pref_tax_no));
        textView.setOnClickListener(new A());
    }

    public void v() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            View viewInflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_customer2, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(R.id.cus_name);
            EditText editText2 = (EditText) viewInflate.findViewById(R.id.cus_phone);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_call);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.img_class);
            editText.setVisibility(8);
            editText2.setVisibility(8);
            imageView.setVisibility(8);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.cus_group);
            ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, this.h.U5());
            autoCompleteTextView.setText(this.h.T5(this.j));
            autoCompleteTextView.setOnItemClickListener(new s(autoCompleteTextView));
            autoCompleteTextView.setOnTouchListener(new t(autoCompleteTextView));
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.selectAll();
            imageView2.setOnClickListener(new u(arrayAdapter, autoCompleteTextView));
            builder.setPositiveButton(getActivity().getString(R.string.resourceID_OK), new v());
            builder.setNegativeButton(getActivity().getString(R.string.resourceID_Cancel), new w());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(getActivity().getString(R.string.change_class));
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new y(autoCompleteTextView, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    public void w(View view) {
        this.b0 = 0;
        t();
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader loader, List list) {
        TextView textView;
        ListView listView = this.J;
        if (listView != null && (textView = this.K) != null) {
            listView.setEmptyView(textView);
        }
        this.M = list;
        C0978Uv c0978Uv = new C0978Uv(getActivity(), R.layout.data_det_row_rep7_, this.M, 4);
        this.L = c0978Uv;
        this.J.setAdapter((ListAdapter) c0978Uv);
    }

    public void y(String str) {
        try {
            this.L.getFilter().filter(str);
        } catch (Exception unused) {
        }
    }

    public void z() {
        C(true);
        new Thread(new i()).start();
    }

    public k(C0917Sq c0917Sq, int i2, int i3, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("cus_id", c0917Sq.c());
        bundle.putString("cus_name", c0917Sq.e());
        bundle.putString("curr_name", c0917Sq.a());
        bundle.putString("cus_type", c0917Sq.b());
        bundle.putInt(CSS.Property.POSITION, i2);
        bundle.putInt("size", i3);
        bundle.putString("searchString", str);
        setArguments(bundle);
    }
}
